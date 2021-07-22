// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Objects;
import instrumented.java.util.Set;
import java.io.Serializable;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import instrumented.java.util.concurrent.atomic.AtomicBoolean;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.Collection;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.AbstractCollection;
import instrumented.java.util.HashSet;
import instrumented.java.util.LinkedHashSet;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

final class DistinctOps
{
    private DistinctOps() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> ReferencePipeline<T, T> makeRef(final AbstractPipeline<?, T, ?> abstractPipeline) {
        try {
            final StreamShape reference = StreamShape.REFERENCE;
            final int n = StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED;
            BytecodeManager.incBytecodes(8);
            final ReferencePipeline.StatefulOp<T, T> statefulOp = new ReferencePipeline.StatefulOp<T, T>(abstractPipeline, reference, n) {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                 <P_IN> Node<T> reduce(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        final Supplier<LinkedHashSet> supplier = LinkedHashSet::new;
                        final BiConsumer<R, ? super T> biConsumer = HashSet::add;
                        final BiConsumer<R, R> biConsumer2 = AbstractCollection::addAll;
                        BytecodeManager.incBytecodes(1);
                        final TerminalOp<Object, Collection<T>> ref = ReduceOps.makeRef((Supplier<Collection<T>>)supplier, (BiConsumer<Collection<T>, ? super Object>)biConsumer, (BiConsumer<Collection<T>, Collection<T>>)biConsumer2);
                        BytecodeManager.incBytecodes(1);
                        final TerminalOp<Object, Collection<T>> terminalOp = ref;
                        BytecodeManager.incBytecodes(4);
                        final Collection<T> collection = terminalOp.evaluateParallel((PipelineHelper<Object>)pipelineHelper, spliterator);
                        BytecodeManager.incBytecodes(2);
                        final Node<T> node = Nodes.node((Collection<T>)collection);
                        BytecodeManager.incBytecodes(1);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Node<T> opEvaluateParallel(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator, final IntFunction<T[]> intFunction) {
                    try {
                        final StreamOpFlag distinct = StreamOpFlag.DISTINCT;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = distinct.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (known) {
                            final boolean b = false;
                            BytecodeManager.incBytecodes(5);
                            final Node<T> evaluate = pipelineHelper.evaluate(spliterator, b, intFunction);
                            BytecodeManager.incBytecodes(1);
                            return evaluate;
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags2 = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known2 = ordered.isKnown(streamAndOpFlags2);
                        BytecodeManager.incBytecodes(1);
                        if (known2) {
                            BytecodeManager.incBytecodes(4);
                            final Node<T> reduce = this.reduce(pipelineHelper, spliterator);
                            BytecodeManager.incBytecodes(1);
                            return reduce;
                        }
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(4);
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(b2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
                        BytecodeManager.incBytecodes(1);
                        final AtomicBoolean atomicBoolean2;
                        final boolean b3;
                        Boolean true;
                        final ConcurrentHashMap<Object, Boolean> concurrentHashMap2;
                        final Consumer<? super Object> consumer = o -> {
                            try {
                                BytecodeManager.incBytecodes(2);
                                if (o == null) {
                                    BytecodeManager.incBytecodes(3);
                                    atomicBoolean2.set(b3);
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    true = Boolean.TRUE;
                                    BytecodeManager.incBytecodes(4);
                                    concurrentHashMap2.putIfAbsent(o, true);
                                    BytecodeManager.incBytecodes(1);
                                }
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        };
                        final boolean b4 = false;
                        BytecodeManager.incBytecodes(4);
                        final TerminalOp<Object, Void> ref = ForEachOps.makeRef(consumer, b4);
                        BytecodeManager.incBytecodes(1);
                        final TerminalOp<Object, Void> terminalOp = ref;
                        BytecodeManager.incBytecodes(4);
                        terminalOp.evaluateParallel((PipelineHelper<Object>)pipelineHelper, spliterator);
                        BytecodeManager.incBytecodes(1);
                        final ConcurrentHashMap<Object, Object> concurrentHashMap3 = concurrentHashMap;
                        BytecodeManager.incBytecodes(2);
                        Serializable keySet = concurrentHashMap3.keySet();
                        BytecodeManager.incBytecodes(1);
                        final AtomicBoolean atomicBoolean3 = atomicBoolean;
                        BytecodeManager.incBytecodes(2);
                        final boolean value = atomicBoolean3.get();
                        BytecodeManager.incBytecodes(1);
                        if (value) {
                            final Serializable s = keySet;
                            BytecodeManager.incBytecodes(4);
                            keySet = new HashSet<Object>((Collection<?>)s);
                            BytecodeManager.incBytecodes(1);
                            final Serializable s2 = keySet;
                            final Object o2 = null;
                            BytecodeManager.incBytecodes(3);
                            ((Set<Object>)s2).add(o2);
                            BytecodeManager.incBytecodes(1);
                        }
                        final Set<Object> set = (Set<Object>)keySet;
                        BytecodeManager.incBytecodes(2);
                        final Node<T> node = Nodes.node((Collection<T>)set);
                        BytecodeManager.incBytecodes(1);
                        return node;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                 <P_IN> Spliterator<T> opEvaluateParallelLazy(final PipelineHelper<T> pipelineHelper, final Spliterator<P_IN> spliterator) {
                    try {
                        final StreamOpFlag distinct = StreamOpFlag.DISTINCT;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known = distinct.isKnown(streamAndOpFlags);
                        BytecodeManager.incBytecodes(1);
                        if (known) {
                            BytecodeManager.incBytecodes(3);
                            final Spliterator<T> wrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                            BytecodeManager.incBytecodes(1);
                            return wrapSpliterator;
                        }
                        final StreamOpFlag ordered = StreamOpFlag.ORDERED;
                        BytecodeManager.incBytecodes(3);
                        final int streamAndOpFlags2 = pipelineHelper.getStreamAndOpFlags();
                        BytecodeManager.incBytecodes(1);
                        final boolean known2 = ordered.isKnown(streamAndOpFlags2);
                        BytecodeManager.incBytecodes(1);
                        if (known2) {
                            BytecodeManager.incBytecodes(4);
                            final Node<T> reduce = this.reduce(pipelineHelper, spliterator);
                            BytecodeManager.incBytecodes(1);
                            final Spliterator<T> spliterator2 = reduce.spliterator();
                            BytecodeManager.incBytecodes(1);
                            return spliterator2;
                        }
                        BytecodeManager.incBytecodes(5);
                        final Spliterator<T> wrapSpliterator2 = pipelineHelper.wrapSpliterator(spliterator);
                        BytecodeManager.incBytecodes(1);
                        final StreamSpliterators.DistinctSpliterator distinctSpliterator = new StreamSpliterators.DistinctSpliterator<T>(wrapSpliterator2);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<T>)distinctSpliterator;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                Sink<T> opWrapSink(final int n, final Sink<T> sink) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(sink);
                        BytecodeManager.incBytecodes(1);
                        final StreamOpFlag distinct = StreamOpFlag.DISTINCT;
                        BytecodeManager.incBytecodes(3);
                        final boolean known = distinct.isKnown(n);
                        BytecodeManager.incBytecodes(1);
                        if (known) {
                            BytecodeManager.incBytecodes(2);
                            return sink;
                        }
                        final StreamOpFlag sorted = StreamOpFlag.SORTED;
                        BytecodeManager.incBytecodes(3);
                        final boolean known2 = sorted.isKnown(n);
                        BytecodeManager.incBytecodes(1);
                        if (known2) {
                            BytecodeManager.incBytecodes(5);
                            final Sink.ChainedReference<T, T> chainedReference = new Sink.ChainedReference<T, T>(sink) {
                                boolean seenNull;
                                T lastSeen;
                                
                                {
                                    BytecodeManager.incBytecodes(1);
                                }
                                
                                @Override
                                public void begin(final long n) {
                                    try {
                                        this.seenNull = false;
                                        BytecodeManager.incBytecodes(3);
                                        this.lastSeen = null;
                                        BytecodeManager.incBytecodes(3);
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
                                public void end() {
                                    try {
                                        this.seenNull = false;
                                        BytecodeManager.incBytecodes(3);
                                        this.lastSeen = null;
                                        BytecodeManager.incBytecodes(3);
                                        final Sink<? super E_OUT> downstream = this.downstream;
                                        BytecodeManager.incBytecodes(3);
                                        downstream.end();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    finally {
                                        throw loadexception(java.lang.Throwable.class);
                                    }
                                }
                                
                                @Override
                                public void accept(final T lastSeen) {
                                    try {
                                        BytecodeManager.incBytecodes(2);
                                        Label_0112: {
                                            if (lastSeen == null) {
                                                final boolean seenNull = this.seenNull;
                                                BytecodeManager.incBytecodes(3);
                                                if (!seenNull) {
                                                    this.seenNull = true;
                                                    BytecodeManager.incBytecodes(3);
                                                    final Sink<? super E_OUT> downstream = this.downstream;
                                                    final Object lastSeen2 = null;
                                                    this.lastSeen = (T)lastSeen2;
                                                    BytecodeManager.incBytecodes(7);
                                                    downstream.accept((Object)lastSeen2);
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            else {
                                                final T lastSeen3 = this.lastSeen;
                                                BytecodeManager.incBytecodes(3);
                                                if (lastSeen3 != null) {
                                                    final T lastSeen4 = this.lastSeen;
                                                    BytecodeManager.incBytecodes(4);
                                                    final boolean equals = lastSeen.equals(lastSeen4);
                                                    BytecodeManager.incBytecodes(1);
                                                    if (equals) {
                                                        break Label_0112;
                                                    }
                                                }
                                                final Sink<? super E_OUT> downstream2 = this.downstream;
                                                this.lastSeen = lastSeen;
                                                BytecodeManager.incBytecodes(7);
                                                downstream2.accept(lastSeen);
                                            }
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
                        BytecodeManager.incBytecodes(5);
                        final Sink.ChainedReference<T, T> chainedReference2 = new Sink.ChainedReference<T, T>(sink) {
                            Set<T> seen;
                            
                            {
                                BytecodeManager.incBytecodes(1);
                            }
                            
                            @Override
                            public void begin(final long n) {
                                try {
                                    BytecodeManager.incBytecodes(4);
                                    this.seen = new HashSet<T>();
                                    BytecodeManager.incBytecodes(1);
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
                            public void end() {
                                try {
                                    this.seen = null;
                                    BytecodeManager.incBytecodes(3);
                                    final Sink<? super E_OUT> downstream = this.downstream;
                                    BytecodeManager.incBytecodes(3);
                                    downstream.end();
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                            
                            @Override
                            public void accept(final T t) {
                                try {
                                    final Set<T> seen = this.seen;
                                    BytecodeManager.incBytecodes(4);
                                    final boolean contains = seen.contains(t);
                                    BytecodeManager.incBytecodes(1);
                                    if (!contains) {
                                        final Set<T> seen2 = this.seen;
                                        BytecodeManager.incBytecodes(4);
                                        seen2.add(t);
                                        BytecodeManager.incBytecodes(1);
                                        final Sink<? super E_OUT> downstream = this.downstream;
                                        BytecodeManager.incBytecodes(4);
                                        downstream.accept(t);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            }
                        };
                        BytecodeManager.incBytecodes(1);
                        return chainedReference2;
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
}
