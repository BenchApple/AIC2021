// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

final class SliceOps
{
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private SliceOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long calcSize(final long n, final long n2, final long b) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            long max;
            if (n3 >= 0) {
                final long a = -1L;
                final long a2 = n - n2;
                BytecodeManager.incBytecodes(6);
                final long min = Math.min(a2, b);
                BytecodeManager.incBytecodes(1);
                max = Math.max(a, min);
                BytecodeManager.incBytecodes(1);
            }
            else {
                max = -1L;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return max;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static long calcSliceFence(final long n, final long n2) {
        try {
            final long n3 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            long n4;
            if (n3 >= 0) {
                n4 = n + n2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n4 = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(1);
            }
            final long n5 = n4;
            BytecodeManager.incBytecodes(1);
            final long n6 = lcmp(n5, 0L);
            BytecodeManager.incBytecodes(4);
            long n7;
            if (n6 >= 0) {
                n7 = n5;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n7 = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <P_IN> Spliterator<P_IN> sliceSpliterator(final StreamShape obj, final Spliterator<P_IN> spliterator, final long n, final long n2) {
        try {
            final boolean $assertionsDisabled = SliceOps.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int n3 = 16384;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = spliterator.hasCharacteristics(n3);
                BytecodeManager.incBytecodes(1);
                if (!hasCharacteristics) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            BytecodeManager.incBytecodes(3);
            final long calcSliceFence = calcSliceFence(n, n2);
            BytecodeManager.incBytecodes(1);
            final int[] $SwitchMap$java$util$stream$StreamShape = SliceOps$5.$SwitchMap$java$util$stream$StreamShape;
            BytecodeManager.incBytecodes(3);
            final int n4 = $SwitchMap$java$util$stream$StreamShape[obj.ordinal()];
            BytecodeManager.incBytecodes(2);
            switch (n4) {
                case 1: {
                    final long n5 = calcSliceFence;
                    BytecodeManager.incBytecodes(6);
                    final StreamSpliterators.SliceSpliterator.OfRef ofRef = new StreamSpliterators.SliceSpliterator.OfRef<P_IN>((Spliterator<Object>)spliterator, n, n5);
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<P_IN>)ofRef;
                }
                case 2: {
                    final Spliterator.OfInt ofInt = (Spliterator.OfInt)spliterator;
                    final long n6 = calcSliceFence;
                    BytecodeManager.incBytecodes(7);
                    final StreamSpliterators.SliceSpliterator.OfInt ofInt2 = new StreamSpliterators.SliceSpliterator.OfInt(ofInt, n, n6);
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<P_IN>)ofInt2;
                }
                case 3: {
                    final Spliterator.OfLong ofLong = (Spliterator.OfLong)spliterator;
                    final long n7 = calcSliceFence;
                    BytecodeManager.incBytecodes(7);
                    final StreamSpliterators.SliceSpliterator.OfLong ofLong2 = new StreamSpliterators.SliceSpliterator.OfLong(ofLong, n, n7);
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<P_IN>)ofLong2;
                }
                case 4: {
                    final Spliterator.OfDouble ofDouble = (Spliterator.OfDouble)spliterator;
                    final long n8 = calcSliceFence;
                    BytecodeManager.incBytecodes(7);
                    final StreamSpliterators.SliceSpliterator.OfDouble ofDouble2 = new StreamSpliterators.SliceSpliterator.OfDouble(ofDouble, n, n8);
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<P_IN>)ofDouble2;
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
    
    private static <T> IntFunction<T[]> castingArray() {
        try {
            Object[] array;
            final IntFunction<Object> intFunction = n -> {
                try {
                    array = new Object[n];
                    BytecodeManager.incBytecodes(3);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return (IntFunction<T[]>)intFunction;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Stream<T> makeRef(final AbstractPipeline<?, T, ?> abstractPipeline, final long lng, final long n) {
        try {
            final long n2 = lcmp(lng, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Skip must be non-negative: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(lng);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int flags = flags(n);
            BytecodeManager.incBytecodes(3);
            final ReferencePipeline.StatefulOp<T, T> statefulOp = new ReferencePipeline.StatefulOp<T, T>(abstractPipeline, reference, flags) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                Spliterator<T> unorderedSkipLimitSpliterator(final Spliterator<T> spliterator, long n, long n2, final long n3) {
                    try {
                        final long n4 = lcmp(n, n3);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            long min;
                            if (n5 >= 0) {
                                final long a = n2;
                                final long b = n3 - n;
                                BytecodeManager.incBytecodes(5);
                                min = Math.min(a, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                min = n3 - n;
                                BytecodeManager.incBytecodes(3);
                            }
                            n2 = min;
                            BytecodeManager.incBytecodes(1);
                            n = 0L;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long n6 = n;
                        final long n7 = n2;
                        BytecodeManager.incBytecodes(6);
                        final StreamSpliterators.UnorderedSliceSpliterator.OfRef ofRef = new StreamSpliterators.UnorderedSliceSpliterator.OfRef<T>((Spliterator<Object>)spliterator, n6, n7);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<T>)ofRef;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Spliterator<T> opEvaluateParallelLazy(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n > 0) {
                            final int n2 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<T> wrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                                final long val$skip = lng;
                                final long val$skip2 = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(6);
                                BytecodeManager.incBytecodes(1);
                                final long access$000 = SliceOps.access$000(val$skip2, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final StreamSpliterators.SliceSpliterator.OfRef ofRef = new StreamSpliterators.SliceSpliterator.OfRef<T>((Spliterator<Object>)wrapSpliterator, val$skip, access$000);
                                BytecodeManager.incBytecodes(1);
                                return (Spliterator<T>)ofRef;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> wrapSpliterator2 = pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip3 = lng;
                            final long val$limit2 = n;
                            final long n3 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(wrapSpliterator2, val$skip3, val$limit2, n3);
                            BytecodeManager.incBytecodes(1);
                            return unorderedSkipLimitSpliterator;
                        }
                        BytecodeManager.incBytecodes(6);
                        final IntFunction access$2 = SliceOps.access$100();
                        final long val$skip4 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(5);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, access$2, val$skip4, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<T> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        final Spliterator<T> spliterator2 = node.spliterator();
                        BytecodeManager.incBytecodes(1);
                        return spliterator2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Node<T> opEvaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<T[]> intFunction) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n > 0) {
                            final int n2 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(2);
                                final StreamShape sourceShape = pipelineHelper.getSourceShape();
                                final long val$skip = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(6);
                                final Spliterator access$200 = SliceOps.access$200(sourceShape, spliterator, val$skip, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator spliterator2 = access$200;
                                final boolean b = true;
                                BytecodeManager.incBytecodes(5);
                                final Node<T> collect = Nodes.collect(pipelineHelper, (Spliterator<Object>)spliterator2, b, intFunction);
                                BytecodeManager.incBytecodes(1);
                                return collect;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> wrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip2 = lng;
                            final long val$limit2 = n;
                            final long n3 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<P_IN> unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator((Spliterator<P_IN>)wrapSpliterator, val$skip2, val$limit2, n3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<P_IN> spliterator3 = unorderedSkipLimitSpliterator;
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(5);
                            final Node<T> collect2 = Nodes.collect((PipelineHelper<T>)this, (Spliterator<Object>)spliterator3, b2, intFunction);
                            BytecodeManager.incBytecodes(1);
                            return collect2;
                        }
                        final long val$skip3 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(11);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip3, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<T> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                Sink<T> opWrapSink(final int n, final Sink<T> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<T, T> chainedReference = new Sink.ChainedReference<T, T>(sink) {
                            long n = lng;
                            long m;
                            
                            {
                                BytecodeManager.incBytecodes(5);
                                final long n = lcmp(n, 0L);
                                BytecodeManager.incBytecodes(7);
                                long val$limit;
                                if (n >= 0) {
                                    val$limit = n;
                                    BytecodeManager.incBytecodes(4);
                                }
                                else {
                                    val$limit = Long.MAX_VALUE;
                                    BytecodeManager.incBytecodes(1);
                                }
                                this.m = val$limit;
                                BytecodeManager.incBytecodes(2);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long val$skip = lng;
                                    final long m = this.m;
                                    BytecodeManager.incBytecodes(9);
                                    final long access$300 = SliceOps.access$300(n, val$skip, m);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.begin(access$300);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final T t) {
                                try {
                                    final long n = lcmp(this.n, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    if (n == 0) {
                                        final long n2 = lcmp(this.m, 0L);
                                        BytecodeManager.incBytecodes(5);
                                        if (n2 > 0) {
                                            --this.m;
                                            BytecodeManager.incBytecodes(6);
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(4);
                                            downstream.accept(t);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    else {
                                        --this.n;
                                        BytecodeManager.incBytecodes(6);
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
                                    final long n = lcmp(this.m, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    boolean b = false;
                                    Label_0051: {
                                        if (n != 0) {
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean cancellationRequested = downstream.cancellationRequested();
                                            BytecodeManager.incBytecodes(1);
                                            if (!cancellationRequested) {
                                                b = false;
                                                BytecodeManager.incBytecodes(1);
                                                break Label_0051;
                                            }
                                        }
                                        b = true;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return b;
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
            return statefulOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static IntStream makeInt(final AbstractPipeline<?, Integer, ?> abstractPipeline, final long lng, final long n) {
        try {
            final long n2 = lcmp(lng, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Skip must be non-negative: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(lng);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final StreamShape int_VALUE = StreamShape.INT_VALUE;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int flags = flags(n);
            BytecodeManager.incBytecodes(3);
            final IntPipeline.StatefulOp<Integer> statefulOp = new IntPipeline.StatefulOp<Integer>(abstractPipeline, int_VALUE, flags) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                Spliterator.OfInt unorderedSkipLimitSpliterator(final Spliterator.OfInt ofInt, long n, long n2, final long n3) {
                    try {
                        final long n4 = lcmp(n, n3);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            long min;
                            if (n5 >= 0) {
                                final long a = n2;
                                final long b = n3 - n;
                                BytecodeManager.incBytecodes(5);
                                min = Math.min(a, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                min = n3 - n;
                                BytecodeManager.incBytecodes(3);
                            }
                            n2 = min;
                            BytecodeManager.incBytecodes(1);
                            n = 0L;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long n6 = n;
                        final long n7 = n2;
                        BytecodeManager.incBytecodes(6);
                        final StreamSpliterators.UnorderedSliceSpliterator.OfInt ofInt2 = new StreamSpliterators.UnorderedSliceSpliterator.OfInt(ofInt, n6, n7);
                        BytecodeManager.incBytecodes(1);
                        return ofInt2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Spliterator<Integer> opEvaluateParallelLazy(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n2 = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n2 > 0) {
                            final int n3 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n3);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator.OfInt ofInt = (Spliterator.OfInt)pipelineHelper.wrapSpliterator(spliterator);
                                final long val$skip = lng;
                                final long val$skip2 = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(7);
                                BytecodeManager.incBytecodes(1);
                                final long access$000 = SliceOps.access$000(val$skip2, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final StreamSpliterators.SliceSpliterator.OfInt ofInt2 = new StreamSpliterators.SliceSpliterator.OfInt(ofInt, val$skip, access$000);
                                BytecodeManager.incBytecodes(1);
                                return ofInt2;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfInt ofInt3 = (Spliterator.OfInt)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip3 = lng;
                            final long val$limit2 = n;
                            final long n4 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfInt unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofInt3, val$skip3, val$limit2, n4);
                            BytecodeManager.incBytecodes(1);
                            return unorderedSkipLimitSpliterator;
                        }
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
                        final long val$skip4 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(10);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip4, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Integer> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        final Spliterator<Integer> spliterator2 = node.spliterator();
                        BytecodeManager.incBytecodes(1);
                        return spliterator2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Node<Integer> opEvaluateParallel(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Integer[]> intFunction) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n > 0) {
                            final int n2 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(2);
                                final StreamShape sourceShape = pipelineHelper.getSourceShape();
                                final long val$skip = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(6);
                                final Spliterator access$200 = SliceOps.access$200(sourceShape, spliterator, val$skip, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<Object> spliterator2 = (Spliterator<Object>)access$200;
                                final boolean b = true;
                                BytecodeManager.incBytecodes(4);
                                final Node.OfInt collectInt = Nodes.collectInt(pipelineHelper, spliterator2, b);
                                BytecodeManager.incBytecodes(1);
                                return collectInt;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfInt ofInt = (Spliterator.OfInt)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip2 = lng;
                            final long val$limit2 = n;
                            final long n3 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfInt unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofInt, val$skip2, val$limit2, n3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfInt ofInt2 = unorderedSkipLimitSpliterator;
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(4);
                            final Node.OfInt collectInt2 = Nodes.collectInt((PipelineHelper<Integer>)this, (Spliterator<Object>)ofInt2, b2);
                            BytecodeManager.incBytecodes(1);
                            return collectInt2;
                        }
                        final long val$skip3 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(11);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip3, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Integer> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                Sink<Integer> opWrapSink(final int n, final Sink<Integer> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedInt<Integer> chainedInt = new Sink.ChainedInt<Integer>(sink) {
                            long n = lng;
                            long m;
                            
                            {
                                BytecodeManager.incBytecodes(5);
                                final long n = lcmp(n, 0L);
                                BytecodeManager.incBytecodes(7);
                                long val$limit;
                                if (n >= 0) {
                                    val$limit = n;
                                    BytecodeManager.incBytecodes(4);
                                }
                                else {
                                    val$limit = Long.MAX_VALUE;
                                    BytecodeManager.incBytecodes(1);
                                }
                                this.m = val$limit;
                                BytecodeManager.incBytecodes(2);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long val$skip = lng;
                                    final long m = this.m;
                                    BytecodeManager.incBytecodes(9);
                                    final long access$300 = SliceOps.access$300(n, val$skip, m);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.begin(access$300);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final int n) {
                                try {
                                    final long n2 = lcmp(this.n, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    if (n2 == 0) {
                                        final long n3 = lcmp(this.m, 0L);
                                        BytecodeManager.incBytecodes(5);
                                        if (n3 > 0) {
                                            --this.m;
                                            BytecodeManager.incBytecodes(6);
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(4);
                                            downstream.accept(n);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    else {
                                        --this.n;
                                        BytecodeManager.incBytecodes(6);
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
                                    final long n = lcmp(this.m, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    boolean b = false;
                                    Label_0051: {
                                        if (n != 0) {
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean cancellationRequested = downstream.cancellationRequested();
                                            BytecodeManager.incBytecodes(1);
                                            if (!cancellationRequested) {
                                                b = false;
                                                BytecodeManager.incBytecodes(1);
                                                break Label_0051;
                                            }
                                        }
                                        b = true;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return b;
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
            return statefulOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static LongStream makeLong(final AbstractPipeline<?, Long, ?> abstractPipeline, final long lng, final long n) {
        try {
            final long n2 = lcmp(lng, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Skip must be non-negative: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(lng);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final StreamShape long_VALUE = StreamShape.LONG_VALUE;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int flags = flags(n);
            BytecodeManager.incBytecodes(3);
            final LongPipeline.StatefulOp<Long> statefulOp = new LongPipeline.StatefulOp<Long>(abstractPipeline, long_VALUE, flags) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                Spliterator.OfLong unorderedSkipLimitSpliterator(final Spliterator.OfLong ofLong, long n, long n2, final long n3) {
                    try {
                        final long n4 = lcmp(n, n3);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            long min;
                            if (n5 >= 0) {
                                final long a = n2;
                                final long b = n3 - n;
                                BytecodeManager.incBytecodes(5);
                                min = Math.min(a, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                min = n3 - n;
                                BytecodeManager.incBytecodes(3);
                            }
                            n2 = min;
                            BytecodeManager.incBytecodes(1);
                            n = 0L;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long n6 = n;
                        final long n7 = n2;
                        BytecodeManager.incBytecodes(6);
                        final StreamSpliterators.UnorderedSliceSpliterator.OfLong ofLong2 = new StreamSpliterators.UnorderedSliceSpliterator.OfLong(ofLong, n6, n7);
                        BytecodeManager.incBytecodes(1);
                        return ofLong2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Spliterator<Long> opEvaluateParallelLazy(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n2 = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n2 > 0) {
                            final int n3 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n3);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator.OfLong ofLong = (Spliterator.OfLong)pipelineHelper.wrapSpliterator(spliterator);
                                final long val$skip = lng;
                                final long val$skip2 = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(7);
                                BytecodeManager.incBytecodes(1);
                                final long access$000 = SliceOps.access$000(val$skip2, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final StreamSpliterators.SliceSpliterator.OfLong ofLong2 = new StreamSpliterators.SliceSpliterator.OfLong(ofLong, val$skip, access$000);
                                BytecodeManager.incBytecodes(1);
                                return ofLong2;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfLong ofLong3 = (Spliterator.OfLong)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip3 = lng;
                            final long val$limit2 = n;
                            final long n4 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfLong unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofLong3, val$skip3, val$limit2, n4);
                            BytecodeManager.incBytecodes(1);
                            return unorderedSkipLimitSpliterator;
                        }
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
                        final long val$skip4 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(10);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip4, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Long> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        final Spliterator<Long> spliterator2 = node.spliterator();
                        BytecodeManager.incBytecodes(1);
                        return spliterator2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Node<Long> opEvaluateParallel(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Long[]> intFunction) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n > 0) {
                            final int n2 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(2);
                                final StreamShape sourceShape = pipelineHelper.getSourceShape();
                                final long val$skip = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(6);
                                final Spliterator access$200 = SliceOps.access$200(sourceShape, spliterator, val$skip, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<Object> spliterator2 = (Spliterator<Object>)access$200;
                                final boolean b = true;
                                BytecodeManager.incBytecodes(4);
                                final Node.OfLong collectLong = Nodes.collectLong(pipelineHelper, spliterator2, b);
                                BytecodeManager.incBytecodes(1);
                                return collectLong;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfLong ofLong = (Spliterator.OfLong)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip2 = lng;
                            final long val$limit2 = n;
                            final long n3 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfLong unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofLong, val$skip2, val$limit2, n3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfLong ofLong2 = unorderedSkipLimitSpliterator;
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(4);
                            final Node.OfLong collectLong2 = Nodes.collectLong((PipelineHelper<Long>)this, (Spliterator<Object>)ofLong2, b2);
                            BytecodeManager.incBytecodes(1);
                            return collectLong2;
                        }
                        final long val$skip3 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(11);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip3, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Long> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                Sink<Long> opWrapSink(final int n, final Sink<Long> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedLong<Long> chainedLong = new Sink.ChainedLong<Long>(sink) {
                            long n = lng;
                            long m;
                            
                            {
                                BytecodeManager.incBytecodes(5);
                                final long n = lcmp(n, 0L);
                                BytecodeManager.incBytecodes(7);
                                long val$limit;
                                if (n >= 0) {
                                    val$limit = n;
                                    BytecodeManager.incBytecodes(4);
                                }
                                else {
                                    val$limit = Long.MAX_VALUE;
                                    BytecodeManager.incBytecodes(1);
                                }
                                this.m = val$limit;
                                BytecodeManager.incBytecodes(2);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long val$skip = lng;
                                    final long m = this.m;
                                    BytecodeManager.incBytecodes(9);
                                    final long access$300 = SliceOps.access$300(n, val$skip, m);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.begin(access$300);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final long n) {
                                try {
                                    final long n2 = lcmp(this.n, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    if (n2 == 0) {
                                        final long n3 = lcmp(this.m, 0L);
                                        BytecodeManager.incBytecodes(5);
                                        if (n3 > 0) {
                                            --this.m;
                                            BytecodeManager.incBytecodes(6);
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(4);
                                            downstream.accept(n);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    else {
                                        --this.n;
                                        BytecodeManager.incBytecodes(6);
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
                                    final long n = lcmp(this.m, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    boolean b = false;
                                    Label_0051: {
                                        if (n != 0) {
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean cancellationRequested = downstream.cancellationRequested();
                                            BytecodeManager.incBytecodes(1);
                                            if (!cancellationRequested) {
                                                b = false;
                                                BytecodeManager.incBytecodes(1);
                                                break Label_0051;
                                            }
                                        }
                                        b = true;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return b;
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
            return statefulOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static DoubleStream makeDouble(final AbstractPipeline<?, Double, ?> abstractPipeline, final long lng, final long n) {
        try {
            final long n2 = lcmp(lng, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Skip must be non-negative: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(lng);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final int flags = flags(n);
            BytecodeManager.incBytecodes(3);
            final DoublePipeline.StatefulOp<Double> statefulOp = new DoublePipeline.StatefulOp<Double>(abstractPipeline, double_VALUE, flags) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                Spliterator.OfDouble unorderedSkipLimitSpliterator(final Spliterator.OfDouble ofDouble, long n, long n2, final long n3) {
                    try {
                        final long n4 = lcmp(n, n3);
                        BytecodeManager.incBytecodes(4);
                        if (n4 <= 0) {
                            final long n5 = lcmp(n2, 0L);
                            BytecodeManager.incBytecodes(4);
                            long min;
                            if (n5 >= 0) {
                                final long a = n2;
                                final long b = n3 - n;
                                BytecodeManager.incBytecodes(5);
                                min = Math.min(a, b);
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                min = n3 - n;
                                BytecodeManager.incBytecodes(3);
                            }
                            n2 = min;
                            BytecodeManager.incBytecodes(1);
                            n = 0L;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long n6 = n;
                        final long n7 = n2;
                        BytecodeManager.incBytecodes(6);
                        final StreamSpliterators.UnorderedSliceSpliterator.OfDouble ofDouble2 = new StreamSpliterators.UnorderedSliceSpliterator.OfDouble(ofDouble, n6, n7);
                        BytecodeManager.incBytecodes(1);
                        return ofDouble2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Spliterator<Double> opEvaluateParallelLazy(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n2 = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n2 > 0) {
                            final int n3 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n3);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator.OfDouble ofDouble = (Spliterator.OfDouble)pipelineHelper.wrapSpliterator(spliterator);
                                final long val$skip = lng;
                                final long val$skip2 = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(7);
                                BytecodeManager.incBytecodes(1);
                                final long access$000 = SliceOps.access$000(val$skip2, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final StreamSpliterators.SliceSpliterator.OfDouble ofDouble2 = new StreamSpliterators.SliceSpliterator.OfDouble(ofDouble, val$skip, access$000);
                                BytecodeManager.incBytecodes(1);
                                return ofDouble2;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfDouble ofDouble3 = (Spliterator.OfDouble)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip3 = lng;
                            final long val$limit2 = n;
                            final long n4 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfDouble unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofDouble3, val$skip3, val$limit2, n4);
                            BytecodeManager.incBytecodes(1);
                            return unorderedSkipLimitSpliterator;
                        }
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
                        final long val$skip4 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(10);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip4, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Double> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        final Spliterator<Double> spliterator2 = node.spliterator();
                        BytecodeManager.incBytecodes(1);
                        return spliterator2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Node<Double> opEvaluateParallel(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<Double[]> intFunction) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(exactOutputSizeIfKnown, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n > 0) {
                            final int n2 = 16384;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasCharacteristics = spliterator.hasCharacteristics(n2);
                            BytecodeManager.incBytecodes(1);
                            if (hasCharacteristics) {
                                BytecodeManager.incBytecodes(2);
                                final StreamShape sourceShape = pipelineHelper.getSourceShape();
                                final long val$skip = lng;
                                final long val$limit = n;
                                BytecodeManager.incBytecodes(6);
                                final Spliterator access$200 = SliceOps.access$200(sourceShape, spliterator, val$skip, val$limit);
                                BytecodeManager.incBytecodes(1);
                                final Spliterator<Object> spliterator2 = (Spliterator<Object>)access$200;
                                final boolean b = true;
                                BytecodeManager.incBytecodes(4);
                                final Node.OfDouble collectDouble = Nodes.collectDouble(pipelineHelper, spliterator2, b);
                                BytecodeManager.incBytecodes(1);
                                return collectDouble;
                            }
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = ordered.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (!known) {
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfDouble ofDouble = (Spliterator.OfDouble)pipelineHelper.wrapSpliterator(spliterator);
                            final long val$skip2 = lng;
                            final long val$limit2 = n;
                            final long n3 = exactOutputSizeIfKnown;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfDouble unorderedSkipLimitSpliterator = this.unorderedSkipLimitSpliterator(ofDouble, val$skip2, val$limit2, n3);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator.OfDouble ofDouble2 = unorderedSkipLimitSpliterator;
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(4);
                            final Node.OfDouble collectDouble2 = Nodes.collectDouble((PipelineHelper<Double>)this, (Spliterator<Object>)ofDouble2, b2);
                            BytecodeManager.incBytecodes(1);
                            return collectDouble2;
                        }
                        final long val$skip3 = lng;
                        final long val$limit3 = n;
                        BytecodeManager.incBytecodes(11);
                        final SliceTask sliceTask = new SliceTask((AbstractPipeline<Object, Object, ?>)this, (PipelineHelper<Object>)pipelineHelper, (Spliterator<Object>)spliterator, (IntFunction<Object[]>)intFunction, val$skip3, val$limit3);
                        BytecodeManager.incBytecodes(1);
                        final Node<Double> node = sliceTask.invoke();
                        BytecodeManager.incBytecodes(2);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                Sink<Double> opWrapSink(final int n, final Sink<Double> sink) {
                    try {
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedDouble<Double> chainedDouble = new Sink.ChainedDouble<Double>(sink) {
                            long n = lng;
                            long m;
                            
                            {
                                BytecodeManager.incBytecodes(5);
                                final long n = lcmp(n, 0L);
                                BytecodeManager.incBytecodes(7);
                                long val$limit;
                                if (n >= 0) {
                                    val$limit = n;
                                    BytecodeManager.incBytecodes(4);
                                }
                                else {
                                    val$limit = Long.MAX_VALUE;
                                    BytecodeManager.incBytecodes(1);
                                }
                                this.m = val$limit;
                                BytecodeManager.incBytecodes(2);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    final long val$skip = lng;
                                    final long m = this.m;
                                    BytecodeManager.incBytecodes(9);
                                    final long access$300 = SliceOps.access$300(n, val$skip, m);
                                    BytecodeManager.incBytecodes(1);
                                    downstream.begin(access$300);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final double n) {
                                try {
                                    final long n2 = lcmp(this.n, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    if (n2 == 0) {
                                        final long n3 = lcmp(this.m, 0L);
                                        BytecodeManager.incBytecodes(5);
                                        if (n3 > 0) {
                                            --this.m;
                                            BytecodeManager.incBytecodes(6);
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(4);
                                            downstream.accept(n);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    else {
                                        --this.n;
                                        BytecodeManager.incBytecodes(6);
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
                                    final long n = lcmp(this.m, 0L);
                                    BytecodeManager.incBytecodes(5);
                                    boolean b = false;
                                    Label_0051: {
                                        if (n != 0) {
                                            final Sink<? super E_OUT> downstream = this.downstream;
                                            BytecodeManager.incBytecodes(3);
                                            final boolean cancellationRequested = downstream.cancellationRequested();
                                            BytecodeManager.incBytecodes(1);
                                            if (!cancellationRequested) {
                                                b = false;
                                                BytecodeManager.incBytecodes(1);
                                                break Label_0051;
                                            }
                                        }
                                        b = true;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    return b;
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
            return statefulOp;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int flags(final long n) {
        try {
            final int not_SIZED = StreamOpFlag.NOT_SIZED;
            final long n2 = lcmp(n, -1L);
            BytecodeManager.incBytecodes(5);
            int is_SHORT_CIRCUIT;
            if (n2 != 0) {
                is_SHORT_CIRCUIT = StreamOpFlag.IS_SHORT_CIRCUIT;
                BytecodeManager.incBytecodes(2);
            }
            else {
                is_SHORT_CIRCUIT = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = not_SIZED | is_SHORT_CIRCUIT;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long access$000(final long n, final long n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final long calcSliceFence = calcSliceFence(n, n2);
            BytecodeManager.incBytecodes(1);
            return calcSliceFence;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ IntFunction access$100() {
        try {
            BytecodeManager.incBytecodes(1);
            final IntFunction<Object[]> castingArray = castingArray();
            BytecodeManager.incBytecodes(1);
            return castingArray;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Spliterator access$200(final StreamShape streamShape, final Spliterator spliterator, final long n, final long n2) {
        try {
            BytecodeManager.incBytecodes(5);
            final Spliterator<Object> sliceSpliterator = sliceSpliterator(streamShape, (Spliterator<Object>)spliterator, n, n2);
            BytecodeManager.incBytecodes(1);
            return sliceSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long access$300(final long n, final long n2, final long n3) {
        try {
            BytecodeManager.incBytecodes(4);
            final long calcSize = calcSize(n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return calcSize;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<SliceOps> clazz = SliceOps.class;
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
    
    private static final class SliceTask<P_IN, P_OUT> extends AbstractShortCircuitTask<P_IN, P_OUT, Node<P_OUT>, SliceTask<P_IN, P_OUT>>
    {
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private final IntFunction<P_OUT[]> generator;
        private final long targetOffset;
        private final long targetSize;
        private long thisNodeSize;
        private volatile boolean completed;
        
        SliceTask(final AbstractPipeline<P_OUT, P_OUT, ?> op, final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<P_OUT[]> generator, final long targetOffset, final long targetSize) {
            try {
                BytecodeManager.incBytecodes(4);
                super(pipelineHelper, spliterator);
                this.op = op;
                BytecodeManager.incBytecodes(3);
                this.generator = generator;
                BytecodeManager.incBytecodes(3);
                this.targetOffset = targetOffset;
                BytecodeManager.incBytecodes(3);
                this.targetSize = targetSize;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SliceTask(final SliceTask<P_IN, P_OUT> sliceTask, final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(4);
                super(sliceTask, spliterator);
                this.op = sliceTask.op;
                BytecodeManager.incBytecodes(4);
                this.generator = sliceTask.generator;
                BytecodeManager.incBytecodes(4);
                this.targetOffset = sliceTask.targetOffset;
                BytecodeManager.incBytecodes(4);
                this.targetSize = sliceTask.targetSize;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected SliceTask<P_IN, P_OUT> makeChild(final Spliterator<P_IN> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final SliceTask<P_IN, P_OUT> sliceTask = new SliceTask<P_IN, P_OUT>(this, spliterator);
                BytecodeManager.incBytecodes(1);
                return sliceTask;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected final Node<P_OUT> getEmptyResult() {
            try {
                final AbstractPipeline<P_OUT, P_OUT, ?> op = this.op;
                BytecodeManager.incBytecodes(3);
                final StreamShape outputShape = op.getOutputShape();
                BytecodeManager.incBytecodes(1);
                final Node<Object> emptyNode = Nodes.emptyNode(outputShape);
                BytecodeManager.incBytecodes(1);
                return (Node<P_OUT>)emptyNode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        protected final Node<P_OUT> doLeaf() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean root = this.isRoot();
                BytecodeManager.incBytecodes(1);
                if (root) {
                    final StreamOpFlag sized = StreamOpFlag.SIZED;
                    final int sourceOrOpFlags = this.op.sourceOrOpFlags;
                    BytecodeManager.incBytecodes(5);
                    final boolean preserved = sized.isPreserved(sourceOrOpFlags);
                    BytecodeManager.incBytecodes(1);
                    long exactOutputSizeIfKnown;
                    if (preserved) {
                        final AbstractPipeline<P_OUT, P_OUT, ?> op = this.op;
                        final Spliterator<P_IN> spliterator = this.spliterator;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        exactOutputSizeIfKnown = op.exactOutputSizeIfKnown(spliterator);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        exactOutputSizeIfKnown = -1L;
                        BytecodeManager.incBytecodes(1);
                    }
                    final long n = exactOutputSizeIfKnown;
                    BytecodeManager.incBytecodes(1);
                    final AbstractPipeline<P_OUT, P_OUT, ?> op2 = this.op;
                    final long n2 = n;
                    final IntFunction<P_OUT[]> generator = this.generator;
                    BytecodeManager.incBytecodes(6);
                    final Node.Builder<P_OUT> nodeBuilder = op2.makeNodeBuilder(n2, generator);
                    BytecodeManager.incBytecodes(1);
                    final AbstractPipeline<P_OUT, P_OUT, ?> op3 = this.op;
                    final PipelineHelper<P_OUT> helper = this.helper;
                    BytecodeManager.incBytecodes(5);
                    final int streamAndOpFlags = helper.getStreamAndOpFlags();
                    final Node.Builder<P_OUT> builder = nodeBuilder;
                    BytecodeManager.incBytecodes(2);
                    final Sink<P_OUT> opWrapSink = op3.opWrapSink(streamAndOpFlags, builder);
                    BytecodeManager.incBytecodes(1);
                    final PipelineHelper<P_OUT> helper2 = this.helper;
                    final PipelineHelper<P_OUT> helper3 = this.helper;
                    final Sink<P_OUT> sink = opWrapSink;
                    BytecodeManager.incBytecodes(6);
                    final Sink<Object> wrapSink = helper3.wrapSink((Sink<P_OUT>)sink);
                    final Spliterator<P_IN> spliterator2 = this.spliterator;
                    BytecodeManager.incBytecodes(3);
                    helper2.copyIntoWithCancel((Sink<P_IN>)wrapSink, spliterator2);
                    final Node.Builder<P_OUT> builder2 = nodeBuilder;
                    BytecodeManager.incBytecodes(2);
                    final Node<P_OUT> build = builder2.build();
                    BytecodeManager.incBytecodes(1);
                    return build;
                }
                final PipelineHelper<P_OUT> helper4 = this.helper;
                final PipelineHelper<P_OUT> helper5 = this.helper;
                final long n3 = -1L;
                final IntFunction<P_OUT[]> generator2 = this.generator;
                BytecodeManager.incBytecodes(8);
                final Node.Builder<P_OUT> nodeBuilder2 = helper5.makeNodeBuilder(n3, generator2);
                final Spliterator<P_IN> spliterator3 = this.spliterator;
                BytecodeManager.incBytecodes(3);
                final Node.Builder<P_OUT> builder3 = helper4.wrapAndCopyInto(nodeBuilder2, spliterator3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Node<P_OUT> build2 = builder3.build();
                BytecodeManager.incBytecodes(1);
                final Node<P_OUT> node = build2;
                BytecodeManager.incBytecodes(3);
                this.thisNodeSize = node.count();
                BytecodeManager.incBytecodes(1);
                this.completed = true;
                BytecodeManager.incBytecodes(3);
                this.spliterator = null;
                BytecodeManager.incBytecodes(3);
                final Node<P_OUT> node2 = build2;
                BytecodeManager.incBytecodes(2);
                return node2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void onCompletion(final CountedCompleter<?> countedCompleter) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean leaf = this.isLeaf();
                BytecodeManager.incBytecodes(1);
                if (!leaf) {
                    this.thisNodeSize = ((SliceTask)this.leftChild).thisNodeSize + ((SliceTask)this.rightChild).thisNodeSize;
                    BytecodeManager.incBytecodes(11);
                    final boolean canceled = this.canceled;
                    BytecodeManager.incBytecodes(3);
                    Node<P_OUT> node;
                    if (canceled) {
                        this.thisNodeSize = 0L;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        node = this.getEmptyResult();
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final long n = lcmp(this.thisNodeSize, 0L);
                        BytecodeManager.incBytecodes(5);
                        if (n == 0) {
                            BytecodeManager.incBytecodes(2);
                            node = this.getEmptyResult();
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final long n2 = lcmp(((SliceTask)this.leftChild).thisNodeSize, 0L);
                            BytecodeManager.incBytecodes(7);
                            if (n2 == 0) {
                                final SliceTask sliceTask = (SliceTask)this.rightChild;
                                BytecodeManager.incBytecodes(4);
                                node = sliceTask.getLocalResult();
                                BytecodeManager.incBytecodes(3);
                            }
                            else {
                                final AbstractPipeline<P_OUT, P_OUT, ?> op = this.op;
                                BytecodeManager.incBytecodes(3);
                                final StreamShape outputShape = op.getOutputShape();
                                final SliceTask sliceTask2 = (SliceTask)this.leftChild;
                                BytecodeManager.incBytecodes(3);
                                BytecodeManager.incBytecodes(1);
                                final Node<T> node2 = sliceTask2.getLocalResult();
                                final SliceTask sliceTask3 = (SliceTask)this.rightChild;
                                BytecodeManager.incBytecodes(5);
                                final Node<T> node3 = sliceTask3.getLocalResult();
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                                node = Nodes.conc(outputShape, (Node<P_OUT>)node2, (Node<P_OUT>)node3);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final boolean root = this.isRoot();
                    BytecodeManager.incBytecodes(1);
                    Node<P_OUT> doTruncate;
                    if (root) {
                        final Node<P_OUT> node4 = node;
                        BytecodeManager.incBytecodes(3);
                        doTruncate = this.doTruncate(node4);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        doTruncate = node;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    this.setLocalResult(doTruncate);
                    this.completed = true;
                    BytecodeManager.incBytecodes(3);
                }
                final long n3 = lcmp(this.targetSize, 0L);
                BytecodeManager.incBytecodes(5);
                if (n3 >= 0) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final boolean root2 = this.isRoot();
                    BytecodeManager.incBytecodes(1);
                    if (!root2) {
                        final long n4 = this.targetOffset + this.targetSize;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        final boolean leftCompleted = this.isLeftCompleted(n4);
                        BytecodeManager.incBytecodes(1);
                        if (leftCompleted) {
                            BytecodeManager.incBytecodes(2);
                            this.cancelLaterNodes();
                        }
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
        
        @Override
        protected void cancel() {
            try {
                BytecodeManager.incBytecodes(2);
                super.cancel();
                final boolean completed = this.completed;
                BytecodeManager.incBytecodes(3);
                if (completed) {
                    BytecodeManager.incBytecodes(3);
                    final Node<P_OUT> emptyResult = this.getEmptyResult();
                    BytecodeManager.incBytecodes(1);
                    this.setLocalResult(emptyResult);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Node<P_OUT> doTruncate(final Node<P_OUT> node) {
            try {
                final long n = lcmp(this.targetSize, 0L);
                BytecodeManager.incBytecodes(5);
                long n2;
                if (n >= 0) {
                    BytecodeManager.incBytecodes(2);
                    final long count = node.count();
                    final long b = this.targetOffset + this.targetSize;
                    BytecodeManager.incBytecodes(6);
                    n2 = Math.min(count, b);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    n2 = this.thisNodeSize;
                    BytecodeManager.incBytecodes(2);
                }
                final long n3 = n2;
                BytecodeManager.incBytecodes(1);
                final long targetOffset = this.targetOffset;
                final long n4 = n3;
                final IntFunction<P_OUT[]> generator = this.generator;
                BytecodeManager.incBytecodes(7);
                final Node<P_OUT> truncate = node.truncate(targetOffset, n4, generator);
                BytecodeManager.incBytecodes(1);
                return truncate;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private boolean isLeftCompleted(final long n) {
            try {
                final boolean completed = this.completed;
                BytecodeManager.incBytecodes(3);
                long n2;
                if (completed) {
                    n2 = this.thisNodeSize;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    n2 = this.completedSize(n);
                }
                long n3 = n2;
                BytecodeManager.incBytecodes(1);
                final long n4 = lcmp(n3, n);
                BytecodeManager.incBytecodes(4);
                if (n4 >= 0) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                BytecodeManager.incBytecodes(2);
                SliceTask sliceTask = this.getParent();
                SliceTask sliceTask2 = this;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final SliceTask sliceTask3 = sliceTask;
                    BytecodeManager.incBytecodes(2);
                    if (sliceTask3 == null) {
                        final long n5 = lcmp(n3, n);
                        BytecodeManager.incBytecodes(4);
                        boolean b2;
                        if (n5 >= 0) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            b2 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return b2;
                    }
                    final SliceTask sliceTask4 = sliceTask2;
                    final AbstractTask<P_IN, P_OUT, R, K> rightChild = sliceTask.rightChild;
                    BytecodeManager.incBytecodes(4);
                    if (sliceTask4 == rightChild) {
                        final SliceTask sliceTask5 = (SliceTask)sliceTask.leftChild;
                        BytecodeManager.incBytecodes(4);
                        final SliceTask sliceTask6 = sliceTask5;
                        BytecodeManager.incBytecodes(2);
                        if (sliceTask6 != null) {
                            final long n6 = n3;
                            final SliceTask sliceTask7 = sliceTask5;
                            BytecodeManager.incBytecodes(4);
                            n3 = n6 + sliceTask7.completedSize(n);
                            BytecodeManager.incBytecodes(2);
                            final long n7 = lcmp(n3, n);
                            BytecodeManager.incBytecodes(4);
                            if (n7 >= 0) {
                                final boolean b3 = true;
                                BytecodeManager.incBytecodes(2);
                                return b3;
                            }
                        }
                    }
                    sliceTask2 = sliceTask;
                    final AbstractTask<P_IN, P_OUT, R, SliceTask> abstractTask = (AbstractTask<P_IN, P_OUT, R, SliceTask>)sliceTask;
                    BytecodeManager.incBytecodes(4);
                    sliceTask = abstractTask.getParent();
                    BytecodeManager.incBytecodes(3);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private long completedSize(final long n) {
            try {
                final boolean completed = this.completed;
                BytecodeManager.incBytecodes(3);
                if (completed) {
                    final long thisNodeSize = this.thisNodeSize;
                    BytecodeManager.incBytecodes(3);
                    return thisNodeSize;
                }
                final SliceTask sliceTask = (SliceTask)this.leftChild;
                BytecodeManager.incBytecodes(4);
                final SliceTask sliceTask2 = (SliceTask)this.rightChild;
                BytecodeManager.incBytecodes(4);
                final SliceTask sliceTask3 = sliceTask;
                BytecodeManager.incBytecodes(2);
                if (sliceTask3 != null) {
                    final SliceTask sliceTask4 = sliceTask2;
                    BytecodeManager.incBytecodes(2);
                    if (sliceTask4 != null) {
                        final SliceTask sliceTask5 = sliceTask;
                        BytecodeManager.incBytecodes(3);
                        final long completedSize = sliceTask5.completedSize(n);
                        BytecodeManager.incBytecodes(1);
                        final long n2 = lcmp(completedSize, n);
                        BytecodeManager.incBytecodes(4);
                        long n3;
                        if (n2 >= 0) {
                            n3 = completedSize;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final long n4 = completedSize;
                            final SliceTask sliceTask6 = sliceTask2;
                            BytecodeManager.incBytecodes(4);
                            n3 = n4 + sliceTask6.completedSize(n);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return n3;
                    }
                }
                final long thisNodeSize2 = this.thisNodeSize;
                BytecodeManager.incBytecodes(3);
                return thisNodeSize2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
