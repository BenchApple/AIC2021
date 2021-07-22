// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.DoubleSupplier;
import instrumented.java.util.function.LongSupplier;
import instrumented.java.util.function.IntSupplier;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import instrumented.java.util.concurrent.atomic.AtomicLong;
import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.Objects;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Comparator;
import instrumented.java.util.function.BooleanSupplier;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

class StreamSpliterators
{
    StreamSpliterators() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private abstract static class AbstractWrappingSpliterator<P_IN, P_OUT, T_BUFFER extends AbstractSpinedBuffer> implements Spliterator<P_OUT>
    {
        final boolean isParallel;
        final PipelineHelper<P_OUT> ph;
        private Supplier<Spliterator<P_IN>> spliteratorSupplier;
        Spliterator<P_IN> spliterator;
        Sink<P_IN> bufferSink;
        BooleanSupplier pusher;
        long nextToConsume;
        T_BUFFER buffer;
        boolean finished;
        
        AbstractWrappingSpliterator(final PipelineHelper<P_OUT> ph, final Supplier<Spliterator<P_IN>> spliteratorSupplier, final boolean isParallel) {
            try {
                BytecodeManager.incBytecodes(2);
                this.ph = ph;
                BytecodeManager.incBytecodes(3);
                this.spliteratorSupplier = spliteratorSupplier;
                BytecodeManager.incBytecodes(3);
                this.spliterator = null;
                BytecodeManager.incBytecodes(3);
                this.isParallel = isParallel;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        AbstractWrappingSpliterator(final PipelineHelper<P_OUT> ph, final Spliterator<P_IN> spliterator, final boolean isParallel) {
            try {
                BytecodeManager.incBytecodes(2);
                this.ph = ph;
                BytecodeManager.incBytecodes(3);
                this.spliteratorSupplier = null;
                BytecodeManager.incBytecodes(3);
                this.spliterator = spliterator;
                BytecodeManager.incBytecodes(3);
                this.isParallel = isParallel;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final void init() {
            try {
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(3);
                if (spliterator == null) {
                    final Supplier<Spliterator<P_IN>> spliteratorSupplier = this.spliteratorSupplier;
                    BytecodeManager.incBytecodes(4);
                    this.spliterator = spliteratorSupplier.get();
                    BytecodeManager.incBytecodes(2);
                    this.spliteratorSupplier = null;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean doAdvance() {
            try {
                final AbstractSpinedBuffer buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                if (buffer != null) {
                    ++this.nextToConsume;
                    BytecodeManager.incBytecodes(6);
                    final long nextToConsume = this.nextToConsume;
                    final AbstractSpinedBuffer buffer2 = this.buffer;
                    BytecodeManager.incBytecodes(5);
                    final long n = lcmp(nextToConsume, buffer2.count());
                    BytecodeManager.incBytecodes(2);
                    int n2;
                    if (n < 0) {
                        n2 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    int fillBuffer = n2;
                    BytecodeManager.incBytecodes(1);
                    final boolean b = fillBuffer != 0;
                    BytecodeManager.incBytecodes(2);
                    if (!b) {
                        this.nextToConsume = 0L;
                        BytecodeManager.incBytecodes(3);
                        final AbstractSpinedBuffer buffer3 = this.buffer;
                        BytecodeManager.incBytecodes(3);
                        buffer3.clear();
                        BytecodeManager.incBytecodes(2);
                        fillBuffer = (this.fillBuffer() ? 1 : 0);
                        BytecodeManager.incBytecodes(1);
                    }
                    final boolean b2 = fillBuffer != 0;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final boolean finished = this.finished;
                BytecodeManager.incBytecodes(3);
                if (finished) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                BytecodeManager.incBytecodes(2);
                this.init();
                BytecodeManager.incBytecodes(2);
                this.initPartialTraversalState();
                this.nextToConsume = 0L;
                BytecodeManager.incBytecodes(3);
                final Sink<P_IN> bufferSink = this.bufferSink;
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(5);
                final long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
                BytecodeManager.incBytecodes(1);
                bufferSink.begin(exactSizeIfKnown);
                BytecodeManager.incBytecodes(2);
                final boolean fillBuffer2 = this.fillBuffer();
                BytecodeManager.incBytecodes(1);
                return fillBuffer2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract AbstractWrappingSpliterator<P_IN, P_OUT, ?> wrap(final Spliterator<P_IN> p0);
        
        abstract void initPartialTraversalState();
        
        @Override
        public Spliterator<P_OUT> trySplit() {
            try {
                final boolean isParallel = this.isParallel;
                BytecodeManager.incBytecodes(3);
                if (isParallel) {
                    final boolean finished = this.finished;
                    BytecodeManager.incBytecodes(3);
                    if (!finished) {
                        BytecodeManager.incBytecodes(2);
                        this.init();
                        final Spliterator<P_IN> spliterator = this.spliterator;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator<P_IN> trySplit = spliterator.trySplit();
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<P_IN> spliterator2 = trySplit;
                        BytecodeManager.incBytecodes(2);
                        Spliterator<P_OUT> wrap;
                        if (spliterator2 == null) {
                            wrap = null;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final Spliterator<P_IN> spliterator3 = trySplit;
                            BytecodeManager.incBytecodes(3);
                            wrap = this.wrap(spliterator3);
                        }
                        BytecodeManager.incBytecodes(1);
                        return wrap;
                    }
                }
                final Spliterator<P_OUT> spliterator4 = null;
                BytecodeManager.incBytecodes(2);
                return spliterator4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private boolean fillBuffer() {
            try {
                while (true) {
                    final AbstractSpinedBuffer buffer = this.buffer;
                    BytecodeManager.incBytecodes(3);
                    final long n = lcmp(buffer.count(), 0L);
                    BytecodeManager.incBytecodes(3);
                    if (n != 0) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Sink<P_IN> bufferSink = this.bufferSink;
                    BytecodeManager.incBytecodes(3);
                    final boolean cancellationRequested = bufferSink.cancellationRequested();
                    BytecodeManager.incBytecodes(1);
                    if (!cancellationRequested) {
                        final BooleanSupplier pusher = this.pusher;
                        BytecodeManager.incBytecodes(3);
                        final boolean asBoolean = pusher.getAsBoolean();
                        BytecodeManager.incBytecodes(1);
                        if (asBoolean) {
                            continue;
                        }
                    }
                    final boolean finished = this.finished;
                    BytecodeManager.incBytecodes(3);
                    if (finished) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Sink<P_IN> bufferSink2 = this.bufferSink;
                    BytecodeManager.incBytecodes(3);
                    bufferSink2.end();
                    this.finished = true;
                    BytecodeManager.incBytecodes(4);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                this.init();
                final Spliterator<P_IN> spliterator = this.spliterator;
                BytecodeManager.incBytecodes(3);
                final long estimateSize = spliterator.estimateSize();
                BytecodeManager.incBytecodes(1);
                return estimateSize;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final long getExactSizeIfKnown() {
            try {
                BytecodeManager.incBytecodes(2);
                this.init();
                final StreamOpFlag sized = StreamOpFlag.SIZED;
                final PipelineHelper<P_OUT> ph = this.ph;
                BytecodeManager.incBytecodes(4);
                final int streamAndOpFlags = ph.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final boolean known = sized.isKnown(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                long exactSizeIfKnown;
                if (known) {
                    final Spliterator<P_IN> spliterator = this.spliterator;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
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
        public final int characteristics() {
            try {
                BytecodeManager.incBytecodes(2);
                this.init();
                final PipelineHelper<P_OUT> ph = this.ph;
                BytecodeManager.incBytecodes(3);
                final int streamAndOpFlags = ph.getStreamAndOpFlags();
                BytecodeManager.incBytecodes(1);
                final int streamFlags = StreamOpFlag.toStreamFlags(streamAndOpFlags);
                BytecodeManager.incBytecodes(1);
                int characteristics = StreamOpFlag.toCharacteristics(streamFlags);
                BytecodeManager.incBytecodes(1);
                final int n = characteristics & 0x40;
                BytecodeManager.incBytecodes(4);
                if (n != 0) {
                    final int n2 = characteristics & 0xFFFFBFBF;
                    BytecodeManager.incBytecodes(4);
                    final int n3 = n2;
                    final Spliterator<P_IN> spliterator = this.spliterator;
                    BytecodeManager.incBytecodes(4);
                    characteristics = (n3 | (spliterator.characteristics() & 0x4040));
                    BytecodeManager.incBytecodes(4);
                }
                final int n4 = characteristics;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super P_OUT> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (!hasCharacteristics) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparator<? super P_OUT> comparator = null;
                BytecodeManager.incBytecodes(2);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final String toString() {
            try {
                final String format = "%s[%s]";
                final Object[] args = new Object[2];
                final int n = 0;
                BytecodeManager.incBytecodes(6);
                final Class<? extends AbstractWrappingSpliterator> class1 = this.getClass();
                BytecodeManager.incBytecodes(1);
                args[n] = class1.getName();
                args[1] = this.spliterator;
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
    
    static final class WrappingSpliterator<P_IN, P_OUT> extends AbstractWrappingSpliterator<P_IN, P_OUT, SpinedBuffer<P_OUT>>
    {
        WrappingSpliterator(final PipelineHelper<P_OUT> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, supplier, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        WrappingSpliterator(final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, spliterator, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        WrappingSpliterator<P_IN, P_OUT> wrap(final Spliterator<P_IN> spliterator) {
            try {
                final PipelineHelper<P_OUT> ph = this.ph;
                final boolean isParallel = this.isParallel;
                BytecodeManager.incBytecodes(8);
                final WrappingSpliterator wrappingSpliterator = new WrappingSpliterator<P_IN, P_OUT>((PipelineHelper<Object>)ph, (Spliterator<Object>)spliterator, isParallel);
                BytecodeManager.incBytecodes(1);
                return wrappingSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        void initPartialTraversalState() {
            try {
                BytecodeManager.incBytecodes(3);
                final SpinedBuffer<Object> buffer = new SpinedBuffer<Object>();
                BytecodeManager.incBytecodes(1);
                this.buffer = (T_BUFFER)buffer;
                BytecodeManager.incBytecodes(3);
                final PipelineHelper<P_OUT> ph = this.ph;
                final SpinedBuffer<Object> spinedBuffer = buffer;
                BytecodeManager.incBytecodes(6);
                spinedBuffer.getClass();
                final Sink sink = spinedBuffer::accept;
                BytecodeManager.incBytecodes(2);
                this.bufferSink = (Sink<P_IN>)ph.wrapSink((Sink<P_OUT>)sink);
                BytecodeManager.incBytecodes(1);
                Spliterator<P_IN> spliterator;
                Sink<P_IN> bufferSink;
                final boolean b;
                this.pusher = (() -> {
                    try {
                        spliterator = this.spliterator;
                        bufferSink = this.bufferSink;
                        BytecodeManager.incBytecodes(5);
                        spliterator.tryAdvance(bufferSink);
                        BytecodeManager.incBytecodes(1);
                        return b;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                });
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super P_OUT> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final boolean doAdvance = this.doAdvance();
                BytecodeManager.incBytecodes(1);
                final boolean b = doAdvance;
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final SpinedBuffer spinedBuffer = (SpinedBuffer)this.buffer;
                    final long nextToConsume = this.nextToConsume;
                    BytecodeManager.incBytecodes(7);
                    final Object value = spinedBuffer.get(nextToConsume);
                    BytecodeManager.incBytecodes(1);
                    consumer.accept((Object)value);
                }
                final boolean b2 = doAdvance;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super P_OUT> consumer) {
            try {
                final AbstractSpinedBuffer buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                Label_0117: {
                    if (buffer == null) {
                        final boolean finished = this.finished;
                        BytecodeManager.incBytecodes(3);
                        if (!finished) {
                            BytecodeManager.incBytecodes(2);
                            Objects.requireNonNull(consumer);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            this.init();
                            final PipelineHelper<P_OUT> ph = this.ph;
                            BytecodeManager.incBytecodes(5);
                            consumer.getClass();
                            final Sink<P_OUT> sink = consumer::accept;
                            final Spliterator<P_IN> spliterator = this.spliterator;
                            BytecodeManager.incBytecodes(4);
                            ph.wrapAndCopyInto((Sink<P_OUT>)sink, spliterator);
                            BytecodeManager.incBytecodes(1);
                            this.finished = true;
                            BytecodeManager.incBytecodes(4);
                            break Label_0117;
                        }
                    }
                    boolean tryAdvance;
                    do {
                        BytecodeManager.incBytecodes(3);
                        tryAdvance = this.tryAdvance(consumer);
                        BytecodeManager.incBytecodes(1);
                    } while (tryAdvance);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class IntWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Integer, SpinedBuffer.OfInt> implements Spliterator.OfInt
    {
        IntWrappingSpliterator(final PipelineHelper<Integer> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, supplier, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        IntWrappingSpliterator(final PipelineHelper<Integer> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, spliterator, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        AbstractWrappingSpliterator<P_IN, Integer, ?> wrap(final Spliterator<P_IN> spliterator) {
            try {
                final PipelineHelper<P_OUT> ph = this.ph;
                final boolean isParallel = this.isParallel;
                BytecodeManager.incBytecodes(8);
                final IntWrappingSpliterator intWrappingSpliterator = new IntWrappingSpliterator((PipelineHelper<Integer>)ph, (Spliterator<Object>)spliterator, isParallel);
                BytecodeManager.incBytecodes(1);
                return intWrappingSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        void initPartialTraversalState() {
            try {
                BytecodeManager.incBytecodes(3);
                final SpinedBuffer.OfInt buffer = new SpinedBuffer.OfInt();
                BytecodeManager.incBytecodes(1);
                this.buffer = (T_BUFFER)buffer;
                BytecodeManager.incBytecodes(3);
                final PipelineHelper<P_OUT> ph = this.ph;
                final SpinedBuffer.OfInt ofInt = buffer;
                BytecodeManager.incBytecodes(6);
                ofInt.getClass();
                final Sink.OfInt ofInt2 = ofInt::accept;
                BytecodeManager.incBytecodes(2);
                this.bufferSink = (Sink<P_IN>)ph.wrapSink((Sink<P_OUT>)ofInt2);
                BytecodeManager.incBytecodes(1);
                Spliterator<P_IN> spliterator;
                Sink<P_IN> bufferSink;
                final boolean b;
                this.pusher = (() -> {
                    try {
                        spliterator = this.spliterator;
                        bufferSink = this.bufferSink;
                        BytecodeManager.incBytecodes(5);
                        spliterator.tryAdvance(bufferSink);
                        BytecodeManager.incBytecodes(1);
                        return b;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                });
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfInt ofInt = (Spliterator.OfInt)super.trySplit();
                BytecodeManager.incBytecodes(2);
                return ofInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(intConsumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final boolean doAdvance = this.doAdvance();
                BytecodeManager.incBytecodes(1);
                final boolean b = doAdvance;
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final SpinedBuffer.OfInt ofInt = (SpinedBuffer.OfInt)this.buffer;
                    final long nextToConsume = this.nextToConsume;
                    BytecodeManager.incBytecodes(7);
                    final int value = ofInt.get(nextToConsume);
                    BytecodeManager.incBytecodes(1);
                    intConsumer.accept(value);
                }
                final boolean b2 = doAdvance;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final IntConsumer intConsumer) {
            try {
                final AbstractSpinedBuffer buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                Label_0117: {
                    if (buffer == null) {
                        final boolean finished = this.finished;
                        BytecodeManager.incBytecodes(3);
                        if (!finished) {
                            BytecodeManager.incBytecodes(2);
                            Objects.requireNonNull(intConsumer);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            this.init();
                            final PipelineHelper<P_OUT> ph = this.ph;
                            BytecodeManager.incBytecodes(5);
                            intConsumer.getClass();
                            final Sink.OfInt ofInt = intConsumer::accept;
                            final Spliterator<P_IN> spliterator = this.spliterator;
                            BytecodeManager.incBytecodes(4);
                            ph.wrapAndCopyInto(ofInt, spliterator);
                            BytecodeManager.incBytecodes(1);
                            this.finished = true;
                            BytecodeManager.incBytecodes(4);
                            break Label_0117;
                        }
                    }
                    boolean tryAdvance;
                    do {
                        BytecodeManager.incBytecodes(3);
                        tryAdvance = this.tryAdvance(intConsumer);
                        BytecodeManager.incBytecodes(1);
                    } while (tryAdvance);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LongWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Long, SpinedBuffer.OfLong> implements Spliterator.OfLong
    {
        LongWrappingSpliterator(final PipelineHelper<Long> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, supplier, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        LongWrappingSpliterator(final PipelineHelper<Long> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, spliterator, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        AbstractWrappingSpliterator<P_IN, Long, ?> wrap(final Spliterator<P_IN> spliterator) {
            try {
                final PipelineHelper<P_OUT> ph = this.ph;
                final boolean isParallel = this.isParallel;
                BytecodeManager.incBytecodes(8);
                final LongWrappingSpliterator longWrappingSpliterator = new LongWrappingSpliterator((PipelineHelper<Long>)ph, (Spliterator<Object>)spliterator, isParallel);
                BytecodeManager.incBytecodes(1);
                return longWrappingSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        void initPartialTraversalState() {
            try {
                BytecodeManager.incBytecodes(3);
                final SpinedBuffer.OfLong buffer = new SpinedBuffer.OfLong();
                BytecodeManager.incBytecodes(1);
                this.buffer = (T_BUFFER)buffer;
                BytecodeManager.incBytecodes(3);
                final PipelineHelper<P_OUT> ph = this.ph;
                final SpinedBuffer.OfLong ofLong = buffer;
                BytecodeManager.incBytecodes(6);
                ofLong.getClass();
                final Sink.OfLong ofLong2 = ofLong::accept;
                BytecodeManager.incBytecodes(2);
                this.bufferSink = (Sink<P_IN>)ph.wrapSink((Sink<P_OUT>)ofLong2);
                BytecodeManager.incBytecodes(1);
                Spliterator<P_IN> spliterator;
                Sink<P_IN> bufferSink;
                final boolean b;
                this.pusher = (() -> {
                    try {
                        spliterator = this.spliterator;
                        bufferSink = this.bufferSink;
                        BytecodeManager.incBytecodes(5);
                        spliterator.tryAdvance(bufferSink);
                        BytecodeManager.incBytecodes(1);
                        return b;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                });
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfLong ofLong = (Spliterator.OfLong)super.trySplit();
                BytecodeManager.incBytecodes(2);
                return ofLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(longConsumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final boolean doAdvance = this.doAdvance();
                BytecodeManager.incBytecodes(1);
                final boolean b = doAdvance;
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final SpinedBuffer.OfLong ofLong = (SpinedBuffer.OfLong)this.buffer;
                    final long nextToConsume = this.nextToConsume;
                    BytecodeManager.incBytecodes(7);
                    final long value = ofLong.get(nextToConsume);
                    BytecodeManager.incBytecodes(1);
                    longConsumer.accept(value);
                }
                final boolean b2 = doAdvance;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final LongConsumer longConsumer) {
            try {
                final AbstractSpinedBuffer buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                Label_0117: {
                    if (buffer == null) {
                        final boolean finished = this.finished;
                        BytecodeManager.incBytecodes(3);
                        if (!finished) {
                            BytecodeManager.incBytecodes(2);
                            Objects.requireNonNull(longConsumer);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            this.init();
                            final PipelineHelper<P_OUT> ph = this.ph;
                            BytecodeManager.incBytecodes(5);
                            longConsumer.getClass();
                            final Sink.OfLong ofLong = longConsumer::accept;
                            final Spliterator<P_IN> spliterator = this.spliterator;
                            BytecodeManager.incBytecodes(4);
                            ph.wrapAndCopyInto(ofLong, spliterator);
                            BytecodeManager.incBytecodes(1);
                            this.finished = true;
                            BytecodeManager.incBytecodes(4);
                            break Label_0117;
                        }
                    }
                    boolean tryAdvance;
                    do {
                        BytecodeManager.incBytecodes(3);
                        tryAdvance = this.tryAdvance(longConsumer);
                        BytecodeManager.incBytecodes(1);
                    } while (tryAdvance);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class DoubleWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Double, SpinedBuffer.OfDouble> implements Spliterator.OfDouble
    {
        DoubleWrappingSpliterator(final PipelineHelper<Double> pipelineHelper, final Supplier<Spliterator<P_IN>> supplier, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, supplier, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        DoubleWrappingSpliterator(final PipelineHelper<Double> pipelineHelper, final Spliterator<P_IN> spliterator, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                super(pipelineHelper, spliterator, b);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        AbstractWrappingSpliterator<P_IN, Double, ?> wrap(final Spliterator<P_IN> spliterator) {
            try {
                final PipelineHelper<P_OUT> ph = this.ph;
                final boolean isParallel = this.isParallel;
                BytecodeManager.incBytecodes(8);
                final DoubleWrappingSpliterator doubleWrappingSpliterator = new DoubleWrappingSpliterator((PipelineHelper<Double>)ph, (Spliterator<Object>)spliterator, isParallel);
                BytecodeManager.incBytecodes(1);
                return doubleWrappingSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        void initPartialTraversalState() {
            try {
                BytecodeManager.incBytecodes(3);
                final SpinedBuffer.OfDouble buffer = new SpinedBuffer.OfDouble();
                BytecodeManager.incBytecodes(1);
                this.buffer = (T_BUFFER)buffer;
                BytecodeManager.incBytecodes(3);
                final PipelineHelper<P_OUT> ph = this.ph;
                final SpinedBuffer.OfDouble ofDouble = buffer;
                BytecodeManager.incBytecodes(6);
                ofDouble.getClass();
                final Sink.OfDouble ofDouble2 = ofDouble::accept;
                BytecodeManager.incBytecodes(2);
                this.bufferSink = (Sink<P_IN>)ph.wrapSink((Sink<P_OUT>)ofDouble2);
                BytecodeManager.incBytecodes(1);
                Spliterator<P_IN> spliterator;
                Sink<P_IN> bufferSink;
                final boolean b;
                this.pusher = (() -> {
                    try {
                        spliterator = this.spliterator;
                        bufferSink = this.bufferSink;
                        BytecodeManager.incBytecodes(5);
                        spliterator.tryAdvance(bufferSink);
                        BytecodeManager.incBytecodes(1);
                        return b;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                });
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfDouble ofDouble = (Spliterator.OfDouble)super.trySplit();
                BytecodeManager.incBytecodes(2);
                return ofDouble;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(doubleConsumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final boolean doAdvance = this.doAdvance();
                BytecodeManager.incBytecodes(1);
                final boolean b = doAdvance;
                BytecodeManager.incBytecodes(2);
                if (b) {
                    final SpinedBuffer.OfDouble ofDouble = (SpinedBuffer.OfDouble)this.buffer;
                    final long nextToConsume = this.nextToConsume;
                    BytecodeManager.incBytecodes(7);
                    final double value = ofDouble.get(nextToConsume);
                    BytecodeManager.incBytecodes(1);
                    doubleConsumer.accept(value);
                }
                final boolean b2 = doAdvance;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                final AbstractSpinedBuffer buffer = this.buffer;
                BytecodeManager.incBytecodes(3);
                Label_0117: {
                    if (buffer == null) {
                        final boolean finished = this.finished;
                        BytecodeManager.incBytecodes(3);
                        if (!finished) {
                            BytecodeManager.incBytecodes(2);
                            Objects.requireNonNull(doubleConsumer);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(2);
                            this.init();
                            final PipelineHelper<P_OUT> ph = this.ph;
                            BytecodeManager.incBytecodes(5);
                            doubleConsumer.getClass();
                            final Sink.OfDouble ofDouble = doubleConsumer::accept;
                            final Spliterator<P_IN> spliterator = this.spliterator;
                            BytecodeManager.incBytecodes(4);
                            ph.wrapAndCopyInto(ofDouble, spliterator);
                            BytecodeManager.incBytecodes(1);
                            this.finished = true;
                            BytecodeManager.incBytecodes(4);
                            break Label_0117;
                        }
                    }
                    boolean tryAdvance;
                    do {
                        BytecodeManager.incBytecodes(3);
                        tryAdvance = this.tryAdvance(doubleConsumer);
                        BytecodeManager.incBytecodes(1);
                    } while (tryAdvance);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class DelegatingSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T>
    {
        private final Supplier<? extends T_SPLITR> supplier;
        private T_SPLITR s;
        
        DelegatingSpliterator(final Supplier<? extends T_SPLITR> supplier) {
            try {
                BytecodeManager.incBytecodes(2);
                this.supplier = supplier;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        T_SPLITR get() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                if (s == null) {
                    final Supplier<? extends T_SPLITR> supplier = this.supplier;
                    BytecodeManager.incBytecodes(4);
                    this.s = (T_SPLITR)supplier.get();
                    BytecodeManager.incBytecodes(2);
                }
                final Spliterator<T> s2 = this.s;
                BytecodeManager.incBytecodes(3);
                return (T_SPLITR)s2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T_SPLITR trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final Spliterator<T> trySplit = value.trySplit();
                BytecodeManager.incBytecodes(1);
                return (T_SPLITR)trySplit;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(2);
                final boolean tryAdvance = value.tryAdvance(consumer);
                BytecodeManager.incBytecodes(1);
                return tryAdvance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super T> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(2);
                value.forEachRemaining(consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final long estimateSize = value.estimateSize();
                BytecodeManager.incBytecodes(1);
                return estimateSize;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final int characteristics = value.characteristics();
                BytecodeManager.incBytecodes(1);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super T> getComparator() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final Comparator<? super T> comparator = value.getComparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long getExactSizeIfKnown() {
            try {
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final long exactSizeIfKnown = value.getExactSizeIfKnown();
                BytecodeManager.incBytecodes(1);
                return exactSizeIfKnown;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final Class<? extends DelegatingSpliterator> class1 = this.getClass();
                BytecodeManager.incBytecodes(1);
                final String name = class1.getName();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append = sb.append(name);
                final String str = "[";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final Spliterator<T> value = this.get();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append3 = append2.append(value);
                final String str2 = "]";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(str2);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static class OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends DelegatingSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>
        {
            OfPrimitive(final Supplier<? extends T_SPLITR> supplier) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(supplier);
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
                    final Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> ofPrimitive = this.get();
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance = ofPrimitive.tryAdvance(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> ofPrimitive = this.get();
                    BytecodeManager.incBytecodes(3);
                    ofPrimitive.forEachRemaining(t_CONS);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt extends DelegatingSpliterator.OfPrimitive<Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt
        {
            OfInt(final Supplier<Spliterator.OfInt> supplier) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(supplier);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends DelegatingSpliterator.OfPrimitive<Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong
        {
            OfLong(final Supplier<Spliterator.OfLong> supplier) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(supplier);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends DelegatingSpliterator.OfPrimitive<Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble
        {
            OfDouble(final Supplier<Spliterator.OfDouble> supplier) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(supplier);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    abstract static class SliceSpliterator<T, T_SPLITR extends Spliterator<T>>
    {
        final long sliceOrigin;
        final long sliceFence;
        T_SPLITR s;
        long index;
        long fence;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        SliceSpliterator(final T_SPLITR s, final long sliceOrigin, final long sliceFence, final long index, final long fence) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = SliceSpliterator.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final int n = 16384;
                    BytecodeManager.incBytecodes(3);
                    final boolean hasCharacteristics = s.hasCharacteristics(n);
                    BytecodeManager.incBytecodes(1);
                    if (!hasCharacteristics) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.s = s;
                BytecodeManager.incBytecodes(3);
                this.sliceOrigin = sliceOrigin;
                BytecodeManager.incBytecodes(3);
                this.sliceFence = sliceFence;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected abstract T_SPLITR makeSpliterator(final T_SPLITR p0, final long p1, final long p2, final long p3, final long p4);
        
        public T_SPLITR trySplit() {
            try {
                final long n = lcmp(this.sliceOrigin, this.fence);
                BytecodeManager.incBytecodes(6);
                if (n >= 0) {
                    final Spliterator<T> spliterator = null;
                    BytecodeManager.incBytecodes(2);
                    return (T_SPLITR)spliterator;
                }
                final long n2 = lcmp(this.index, this.fence);
                BytecodeManager.incBytecodes(6);
                if (n2 >= 0) {
                    final Spliterator<T> spliterator2 = null;
                    BytecodeManager.incBytecodes(2);
                    return (T_SPLITR)spliterator2;
                }
                while (true) {
                    final Spliterator<T> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final Spliterator<T> trySplit = s.trySplit();
                    BytecodeManager.incBytecodes(1);
                    final Spliterator<T> spliterator3 = trySplit;
                    BytecodeManager.incBytecodes(2);
                    if (spliterator3 == null) {
                        final Spliterator<T> spliterator4 = null;
                        BytecodeManager.incBytecodes(2);
                        return (T_SPLITR)spliterator4;
                    }
                    final long index = this.index;
                    final Spliterator<T> spliterator5 = trySplit;
                    BytecodeManager.incBytecodes(4);
                    final long n3 = index + spliterator5.estimateSize();
                    BytecodeManager.incBytecodes(2);
                    final long a = n3;
                    final long sliceFence = this.sliceFence;
                    BytecodeManager.incBytecodes(4);
                    final long min = Math.min(a, sliceFence);
                    BytecodeManager.incBytecodes(1);
                    final long n4 = lcmp(this.sliceOrigin, min);
                    BytecodeManager.incBytecodes(5);
                    if (n4 >= 0) {
                        this.index = min;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final long n5 = lcmp(min, this.sliceFence);
                        BytecodeManager.incBytecodes(5);
                        if (n5 < 0) {
                            final long n6 = lcmp(this.index, this.sliceOrigin);
                            BytecodeManager.incBytecodes(6);
                            if (n6 >= 0) {
                                final long n7 = lcmp(n3, this.sliceFence);
                                BytecodeManager.incBytecodes(5);
                                if (n7 <= 0) {
                                    this.index = min;
                                    BytecodeManager.incBytecodes(3);
                                    final Spliterator<T> spliterator6 = trySplit;
                                    BytecodeManager.incBytecodes(2);
                                    return (T_SPLITR)spliterator6;
                                }
                            }
                            final Spliterator<T> spliterator7 = trySplit;
                            final long sliceOrigin = this.sliceOrigin;
                            final long sliceFence2 = this.sliceFence;
                            final long index2 = this.index;
                            final long index3 = min;
                            this.index = index3;
                            BytecodeManager.incBytecodes(13);
                            final Spliterator<T> spliterator8 = this.makeSpliterator(spliterator7, sliceOrigin, sliceFence2, index2, index3);
                            BytecodeManager.incBytecodes(1);
                            return (T_SPLITR)spliterator8;
                        }
                        this.s = (T_SPLITR)trySplit;
                        BytecodeManager.incBytecodes(3);
                        this.fence = min;
                        BytecodeManager.incBytecodes(4);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public long estimateSize() {
            try {
                final long n = lcmp(this.sliceOrigin, this.fence);
                BytecodeManager.incBytecodes(6);
                long n2;
                if (n < 0) {
                    final long fence = this.fence;
                    final long sliceOrigin = this.sliceOrigin;
                    final long index = this.index;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    n2 = fence - Math.max(sliceOrigin, index);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n2 = 0L;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int characteristics() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final int characteristics = s.characteristics();
                BytecodeManager.incBytecodes(1);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<StreamSpliterators> clazz = StreamSpliterators.class;
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
        
        static final class OfRef<T> extends SliceSpliterator<T, Spliterator<T>> implements Spliterator<T>
        {
            OfRef(final Spliterator<T> spliterator, final long n, final long b) {
                try {
                    final long n2 = 0L;
                    BytecodeManager.incBytecodes(7);
                    final long estimateSize = spliterator.estimateSize();
                    BytecodeManager.incBytecodes(2);
                    final long min = Math.min(estimateSize, b);
                    BytecodeManager.incBytecodes(1);
                    this(spliterator, n, b, n2, min);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private OfRef(final Spliterator<T> spliterator, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(7);
                    super(spliterator, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected Spliterator<T> makeSpliterator(final Spliterator<T> spliterator, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(8);
                    final OfRef ofRef = new OfRef((Spliterator<Object>)spliterator, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return ofRef;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final Consumer<? super T> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(this.sliceOrigin, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n >= 0) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    while (true) {
                        final long n2 = lcmp(this.sliceOrigin, this.index);
                        BytecodeManager.incBytecodes(6);
                        if (n2 <= 0) {
                            break;
                        }
                        final Spliterator<T> s = this.s;
                        final Consumer<? super T> consumer2 = p0 -> {
                            try {
                                BytecodeManager.incBytecodes(1);
                                return;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        };
                        BytecodeManager.incBytecodes(3);
                        s.tryAdvance(consumer2);
                        BytecodeManager.incBytecodes(1);
                        ++this.index;
                        BytecodeManager.incBytecodes(7);
                    }
                    final long n3 = lcmp(this.index, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n3 >= 0) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    ++this.index;
                    BytecodeManager.incBytecodes(6);
                    final Spliterator<T> s2 = this.s;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = s2.tryAdvance((Consumer<? super T>)consumer);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final Consumer<? super T> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(this.sliceOrigin, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n >= 0) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final long n2 = lcmp(this.index, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n2 >= 0) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final long n3 = lcmp(this.index, this.sliceOrigin);
                    BytecodeManager.incBytecodes(6);
                    Label_0257: {
                        if (n3 >= 0) {
                            final long index = this.index;
                            final Spliterator<T> s = this.s;
                            BytecodeManager.incBytecodes(5);
                            final long n4 = lcmp(index + s.estimateSize(), this.sliceFence);
                            BytecodeManager.incBytecodes(5);
                            if (n4 <= 0) {
                                final Spliterator<T> s2 = this.s;
                                BytecodeManager.incBytecodes(4);
                                s2.forEachRemaining((Consumer<? super T>)consumer);
                                this.index = this.fence;
                                BytecodeManager.incBytecodes(5);
                                break Label_0257;
                            }
                        }
                        while (true) {
                            final long n5 = lcmp(this.sliceOrigin, this.index);
                            BytecodeManager.incBytecodes(6);
                            if (n5 <= 0) {
                                break;
                            }
                            final Spliterator<T> s3 = this.s;
                            final Consumer<? super T> consumer2 = p0 -> {
                                try {
                                    BytecodeManager.incBytecodes(1);
                                    return;
                                }
                                finally {
                                    throw loadexception(java.lang.Throwable.class);
                                }
                            };
                            BytecodeManager.incBytecodes(3);
                            s3.tryAdvance(consumer2);
                            BytecodeManager.incBytecodes(1);
                            ++this.index;
                            BytecodeManager.incBytecodes(7);
                        }
                        while (true) {
                            final long n6 = lcmp(this.index, this.fence);
                            BytecodeManager.incBytecodes(6);
                            if (n6 >= 0) {
                                break;
                            }
                            final Spliterator<T> s4 = this.s;
                            BytecodeManager.incBytecodes(4);
                            s4.tryAdvance((Consumer<? super T>)consumer);
                            BytecodeManager.incBytecodes(1);
                            ++this.index;
                            BytecodeManager.incBytecodes(7);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        abstract static class OfPrimitive<T, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_CONS> extends SliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>
        {
            OfPrimitive(final T_SPLITR t_SPLITR, final long n, final long b) {
                try {
                    final long n2 = 0L;
                    BytecodeManager.incBytecodes(7);
                    final long estimateSize = t_SPLITR.estimateSize();
                    BytecodeManager.incBytecodes(2);
                    final long min = Math.min(estimateSize, b);
                    BytecodeManager.incBytecodes(1);
                    this((Spliterator.OfPrimitive)t_SPLITR, n, b, n2, min);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private OfPrimitive(final T_SPLITR t_SPLITR, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(7);
                    super(t_SPLITR, n, n2, n3, n4);
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
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(this.sliceOrigin, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n >= 0) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    while (true) {
                        final long n2 = lcmp(this.sliceOrigin, this.index);
                        BytecodeManager.incBytecodes(6);
                        if (n2 <= 0) {
                            break;
                        }
                        final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.s;
                        BytecodeManager.incBytecodes(5);
                        final Object emptyConsumer = this.emptyConsumer();
                        BytecodeManager.incBytecodes(1);
                        ofPrimitive.tryAdvance(emptyConsumer);
                        BytecodeManager.incBytecodes(1);
                        ++this.index;
                        BytecodeManager.incBytecodes(7);
                    }
                    final long n3 = lcmp(this.index, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n3 >= 0) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    ++this.index;
                    BytecodeManager.incBytecodes(6);
                    final Spliterator.OfPrimitive ofPrimitive2 = (Spliterator.OfPrimitive)this.s;
                    BytecodeManager.incBytecodes(5);
                    final boolean tryAdvance = ofPrimitive2.tryAdvance(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    return tryAdvance;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(this.sliceOrigin, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n >= 0) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final long n2 = lcmp(this.index, this.fence);
                    BytecodeManager.incBytecodes(6);
                    if (n2 >= 0) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    final long n3 = lcmp(this.index, this.sliceOrigin);
                    BytecodeManager.incBytecodes(6);
                    Label_0273: {
                        if (n3 >= 0) {
                            final long index = this.index;
                            final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.s;
                            BytecodeManager.incBytecodes(6);
                            final long n4 = lcmp(index + ofPrimitive.estimateSize(), this.sliceFence);
                            BytecodeManager.incBytecodes(5);
                            if (n4 <= 0) {
                                final Spliterator.OfPrimitive ofPrimitive2 = (Spliterator.OfPrimitive)this.s;
                                BytecodeManager.incBytecodes(5);
                                ofPrimitive2.forEachRemaining(t_CONS);
                                this.index = this.fence;
                                BytecodeManager.incBytecodes(5);
                                break Label_0273;
                            }
                        }
                        while (true) {
                            final long n5 = lcmp(this.sliceOrigin, this.index);
                            BytecodeManager.incBytecodes(6);
                            if (n5 <= 0) {
                                break;
                            }
                            final Spliterator.OfPrimitive ofPrimitive3 = (Spliterator.OfPrimitive)this.s;
                            BytecodeManager.incBytecodes(5);
                            final Object emptyConsumer = this.emptyConsumer();
                            BytecodeManager.incBytecodes(1);
                            ofPrimitive3.tryAdvance(emptyConsumer);
                            BytecodeManager.incBytecodes(1);
                            ++this.index;
                            BytecodeManager.incBytecodes(7);
                        }
                        while (true) {
                            final long n6 = lcmp(this.index, this.fence);
                            BytecodeManager.incBytecodes(6);
                            if (n6 >= 0) {
                                break;
                            }
                            final Spliterator.OfPrimitive ofPrimitive4 = (Spliterator.OfPrimitive)this.s;
                            BytecodeManager.incBytecodes(5);
                            ofPrimitive4.tryAdvance(t_CONS);
                            BytecodeManager.incBytecodes(1);
                            ++this.index;
                            BytecodeManager.incBytecodes(7);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected abstract T_CONS emptyConsumer();
        }
        
        static final class OfInt extends SliceSpliterator.OfPrimitive<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt
        {
            OfInt(final Spliterator.OfInt ofInt, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofInt, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfInt(final Spliterator.OfInt ofInt, final long n, final long n2, final long n3, final long n4) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(8);
                    super((Spliterator.OfPrimitive)ofInt, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfInt makeSpliterator(final Spliterator.OfInt ofInt, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(8);
                    final OfInt ofInt2 = new OfInt(ofInt, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return ofInt2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected IntConsumer emptyConsumer() {
                try {
                    final IntConsumer intConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    return intConsumer;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends SliceSpliterator.OfPrimitive<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong
        {
            OfLong(final Spliterator.OfLong ofLong, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofLong, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfLong(final Spliterator.OfLong ofLong, final long n, final long n2, final long n3, final long n4) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(8);
                    super((Spliterator.OfPrimitive)ofLong, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfLong makeSpliterator(final Spliterator.OfLong ofLong, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(8);
                    final OfLong ofLong2 = new OfLong(ofLong, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return ofLong2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected LongConsumer emptyConsumer() {
                try {
                    final LongConsumer longConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    return longConsumer;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends SliceSpliterator.OfPrimitive<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble
        {
            OfDouble(final Spliterator.OfDouble ofDouble, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofDouble, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfDouble(final Spliterator.OfDouble ofDouble, final long n, final long n2, final long n3, final long n4) {
                try {
                    final Object object = null;
                    BytecodeManager.incBytecodes(8);
                    super((Spliterator.OfPrimitive)ofDouble, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfDouble makeSpliterator(final Spliterator.OfDouble ofDouble, final long n, final long n2, final long n3, final long n4) {
                try {
                    BytecodeManager.incBytecodes(8);
                    final OfDouble ofDouble2 = new OfDouble(ofDouble, n, n2, n3, n4);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected DoubleConsumer emptyConsumer() {
                try {
                    final DoubleConsumer doubleConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    return doubleConsumer;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    abstract static class UnorderedSliceSpliterator<T, T_SPLITR extends Spliterator<T>>
    {
        static final int CHUNK_SIZE = 128;
        protected final T_SPLITR s;
        protected final boolean unlimited;
        private final long skipThreshold;
        private final AtomicLong permits;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        UnorderedSliceSpliterator(final T_SPLITR s, final long n, final long n2) {
            try {
                BytecodeManager.incBytecodes(2);
                this.s = s;
                BytecodeManager.incBytecodes(3);
                final long n3 = lcmp(n2, 0L);
                BytecodeManager.incBytecodes(5);
                boolean unlimited;
                if (n3 < 0) {
                    unlimited = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    unlimited = false;
                    BytecodeManager.incBytecodes(1);
                }
                this.unlimited = unlimited;
                BytecodeManager.incBytecodes(1);
                final long n4 = lcmp(n2, 0L);
                BytecodeManager.incBytecodes(5);
                long skipThreshold;
                if (n4 >= 0) {
                    skipThreshold = n2;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    skipThreshold = 0L;
                    BytecodeManager.incBytecodes(1);
                }
                this.skipThreshold = skipThreshold;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final long n5 = lcmp(n2, 0L);
                BytecodeManager.incBytecodes(6);
                long n6;
                if (n5 >= 0) {
                    n6 = n + n2;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    n6 = n;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                this.permits = new AtomicLong(n6);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        UnorderedSliceSpliterator(final T_SPLITR s, final UnorderedSliceSpliterator<T, T_SPLITR> unorderedSliceSpliterator) {
            try {
                BytecodeManager.incBytecodes(2);
                this.s = s;
                BytecodeManager.incBytecodes(3);
                this.unlimited = unorderedSliceSpliterator.unlimited;
                BytecodeManager.incBytecodes(4);
                this.permits = unorderedSliceSpliterator.permits;
                BytecodeManager.incBytecodes(4);
                this.skipThreshold = unorderedSliceSpliterator.skipThreshold;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final long acquirePermits(final long b) {
            try {
                final boolean $assertionsDisabled = UnorderedSliceSpliterator.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n = lcmp(b, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                boolean compareAndSet;
                long value;
                long min;
                do {
                    final AtomicLong permits = this.permits;
                    BytecodeManager.incBytecodes(3);
                    value = permits.get();
                    BytecodeManager.incBytecodes(1);
                    final long n2 = lcmp(value, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n2 == 0) {
                        final boolean unlimited = this.unlimited;
                        BytecodeManager.incBytecodes(3);
                        long n3;
                        if (unlimited) {
                            n3 = b;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n3 = 0L;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return n3;
                    }
                    final long a = value;
                    BytecodeManager.incBytecodes(3);
                    min = Math.min(a, b);
                    BytecodeManager.incBytecodes(1);
                    final long n4 = lcmp(min, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n4 <= 0) {
                        break;
                    }
                    final AtomicLong permits2 = this.permits;
                    final long n5 = value;
                    final long n6 = value - min;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    compareAndSet = permits2.compareAndSet(n5, n6);
                    BytecodeManager.incBytecodes(1);
                } while (!compareAndSet);
                final boolean unlimited2 = this.unlimited;
                BytecodeManager.incBytecodes(3);
                if (unlimited2) {
                    final long a2 = b - min;
                    final long b2 = 0L;
                    BytecodeManager.incBytecodes(5);
                    final long max = Math.max(a2, b2);
                    BytecodeManager.incBytecodes(1);
                    return max;
                }
                final long n7 = lcmp(value, this.skipThreshold);
                BytecodeManager.incBytecodes(5);
                if (n7 > 0) {
                    final long a3 = min - (value - this.skipThreshold);
                    final long b3 = 0L;
                    BytecodeManager.incBytecodes(8);
                    final long max2 = Math.max(a3, b3);
                    BytecodeManager.incBytecodes(1);
                    return max2;
                }
                final long n8 = min;
                BytecodeManager.incBytecodes(2);
                return n8;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected final PermitStatus permitStatus() {
            try {
                final AtomicLong permits = this.permits;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(permits.get(), 0L);
                BytecodeManager.incBytecodes(3);
                if (n > 0) {
                    final PermitStatus maybe_MORE = PermitStatus.MAYBE_MORE;
                    BytecodeManager.incBytecodes(2);
                    return maybe_MORE;
                }
                final boolean unlimited = this.unlimited;
                BytecodeManager.incBytecodes(3);
                PermitStatus permitStatus;
                if (unlimited) {
                    permitStatus = PermitStatus.UNLIMITED;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    permitStatus = PermitStatus.NO_MORE;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return permitStatus;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final T_SPLITR trySplit() {
            try {
                final AtomicLong permits = this.permits;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(permits.get(), 0L);
                BytecodeManager.incBytecodes(3);
                if (n == 0) {
                    final Spliterator<T> spliterator = null;
                    BytecodeManager.incBytecodes(2);
                    return (T_SPLITR)spliterator;
                }
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Spliterator<T> trySplit = s.trySplit();
                BytecodeManager.incBytecodes(1);
                final Spliterator<T> spliterator2 = trySplit;
                BytecodeManager.incBytecodes(2);
                Spliterator<T> spliterator3;
                if (spliterator2 == null) {
                    spliterator3 = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Spliterator<T> spliterator4 = trySplit;
                    BytecodeManager.incBytecodes(3);
                    spliterator3 = this.makeSpliterator(spliterator4);
                }
                BytecodeManager.incBytecodes(1);
                return (T_SPLITR)spliterator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected abstract T_SPLITR makeSpliterator(final T_SPLITR p0);
        
        public final long estimateSize() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final long estimateSize = s.estimateSize();
                BytecodeManager.incBytecodes(1);
                return estimateSize;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final int characteristics() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final int n = s.characteristics() & 0xFFFFBFAF;
                BytecodeManager.incBytecodes(3);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<StreamSpliterators> clazz = StreamSpliterators.class;
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
        
        enum PermitStatus
        {
            NO_MORE, 
            MAYBE_MORE, 
            UNLIMITED;
            
            private PermitStatus() {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(name, ordinal);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static {
                try {
                    final String s = "NO_MORE";
                    final int n = 0;
                    BytecodeManager.incBytecodes(5);
                    final String s2 = "MAYBE_MORE";
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(6);
                    final String s3 = "UNLIMITED";
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(16);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfRef<T> extends UnorderedSliceSpliterator<T, Spliterator<T>> implements Spliterator<T>, Consumer<T>
        {
            T tmpSlot;
            
            OfRef(final Spliterator<T> spliterator, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(spliterator, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfRef(final Spliterator<T> spliterator, final OfRef<T> ofRef) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(spliterator, (UnorderedSliceSpliterator<Object, Spliterator<T>>)ofRef);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final void accept(final T tmpSlot) {
                try {
                    this.tmpSlot = tmpSlot;
                    BytecodeManager.incBytecodes(3);
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
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    long n;
                    do {
                        BytecodeManager.incBytecodes(2);
                        final PermitStatus permitStatus = this.permitStatus();
                        final PermitStatus no_MORE = PermitStatus.NO_MORE;
                        BytecodeManager.incBytecodes(2);
                        if (permitStatus == no_MORE) {
                            final boolean b = false;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final Spliterator<T> s = this.s;
                        BytecodeManager.incBytecodes(4);
                        final boolean tryAdvance = s.tryAdvance((Consumer<? super T>)this);
                        BytecodeManager.incBytecodes(1);
                        if (!tryAdvance) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        final long n2 = 1L;
                        BytecodeManager.incBytecodes(3);
                        n = lcmp(this.acquirePermits(n2), 1L);
                        BytecodeManager.incBytecodes(3);
                    } while (n != 0);
                    final T tmpSlot = this.tmpSlot;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(tmpSlot);
                    this.tmpSlot = null;
                    BytecodeManager.incBytecodes(3);
                    final boolean b3 = true;
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
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    ArrayBuffer.OfRef<Object> ofRef = null;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final PermitStatus permitStatus = this.permitStatus();
                        final PermitStatus no_MORE = PermitStatus.NO_MORE;
                        BytecodeManager.incBytecodes(4);
                        if (permitStatus == no_MORE) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final PermitStatus permitStatus2 = permitStatus;
                        final PermitStatus maybe_MORE = PermitStatus.MAYBE_MORE;
                        BytecodeManager.incBytecodes(3);
                        if (permitStatus2 != maybe_MORE) {
                            final Spliterator<T> s = this.s;
                            BytecodeManager.incBytecodes(4);
                            s.forEachRemaining((Consumer<? super T>)consumer);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final ArrayBuffer.OfRef<Object> ofRef2 = ofRef;
                        BytecodeManager.incBytecodes(2);
                        if (ofRef2 == null) {
                            final int n = 128;
                            BytecodeManager.incBytecodes(4);
                            ofRef = new ArrayBuffer.OfRef<Object>(n);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final ArrayBuffer.OfRef<Object> ofRef3 = ofRef;
                            BytecodeManager.incBytecodes(2);
                            ofRef3.reset();
                        }
                        long n2 = 0L;
                        BytecodeManager.incBytecodes(2);
                        long n3;
                        do {
                            final Spliterator<T> s2 = this.s;
                            final ArrayBuffer.OfRef<Object> ofRef4 = ofRef;
                            BytecodeManager.incBytecodes(4);
                            final boolean tryAdvance = s2.tryAdvance(ofRef4);
                            BytecodeManager.incBytecodes(1);
                            if (!tryAdvance) {
                                break;
                            }
                            n3 = lcmp(++n2, 128L);
                            BytecodeManager.incBytecodes(8);
                        } while (n3 < 0);
                        final long n4 = lcmp(n2, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n4 == 0) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final ArrayBuffer.OfRef<Object> ofRef5 = ofRef;
                        final long n5 = n2;
                        BytecodeManager.incBytecodes(5);
                        final long acquirePermits = this.acquirePermits(n5);
                        BytecodeManager.incBytecodes(1);
                        ofRef5.forEach((Consumer<? super Object>)consumer, acquirePermits);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected Spliterator<T> makeSpliterator(final Spliterator<T> spliterator) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final OfRef ofRef = new OfRef((Spliterator<Object>)spliterator, (OfRef<Object>)this);
                    BytecodeManager.incBytecodes(1);
                    return ofRef;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        abstract static class OfPrimitive<T, T_CONS, T_BUFF extends ArrayBuffer.OfPrimitive<T_CONS>, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends UnorderedSliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>
        {
            OfPrimitive(final T_SPLITR t_SPLITR, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(t_SPLITR, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfPrimitive(final T_SPLITR t_SPLITR, final OfPrimitive<T, T_CONS, T_BUFF, T_SPLITR> ofPrimitive) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(t_SPLITR, (UnorderedSliceSpliterator<Object, T_SPLITR>)ofPrimitive);
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
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    long n;
                    do {
                        BytecodeManager.incBytecodes(2);
                        final PermitStatus permitStatus = this.permitStatus();
                        final PermitStatus no_MORE = PermitStatus.NO_MORE;
                        BytecodeManager.incBytecodes(2);
                        if (permitStatus == no_MORE) {
                            final boolean b = false;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.s;
                        BytecodeManager.incBytecodes(5);
                        final boolean tryAdvance = ofPrimitive.tryAdvance(this);
                        BytecodeManager.incBytecodes(1);
                        if (!tryAdvance) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        final long n2 = 1L;
                        BytecodeManager.incBytecodes(3);
                        n = lcmp(this.acquirePermits(n2), 1L);
                        BytecodeManager.incBytecodes(3);
                    } while (n != 0);
                    BytecodeManager.incBytecodes(3);
                    this.acceptConsumed(t_CONS);
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected abstract void acceptConsumed(final T_CONS p0);
            
            @Override
            public void forEachRemaining(final T_CONS t_CONS) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(t_CONS);
                    BytecodeManager.incBytecodes(1);
                    ArrayBuffer.OfPrimitive<T_CONS> bufferCreate = null;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final PermitStatus permitStatus = this.permitStatus();
                        final PermitStatus no_MORE = PermitStatus.NO_MORE;
                        BytecodeManager.incBytecodes(4);
                        if (permitStatus == no_MORE) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final PermitStatus permitStatus2 = permitStatus;
                        final PermitStatus maybe_MORE = PermitStatus.MAYBE_MORE;
                        BytecodeManager.incBytecodes(3);
                        if (permitStatus2 != maybe_MORE) {
                            final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.s;
                            BytecodeManager.incBytecodes(5);
                            ofPrimitive.forEachRemaining(t_CONS);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final ArrayBuffer.OfPrimitive<T_CONS> ofPrimitive2 = bufferCreate;
                        BytecodeManager.incBytecodes(2);
                        if (ofPrimitive2 == null) {
                            final int n = 128;
                            BytecodeManager.incBytecodes(3);
                            bufferCreate = this.bufferCreate(n);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final ArrayBuffer.OfPrimitive<T_CONS> ofPrimitive3 = bufferCreate;
                            BytecodeManager.incBytecodes(2);
                            ofPrimitive3.reset();
                        }
                        final ArrayBuffer.OfPrimitive<T_CONS> ofPrimitive4 = bufferCreate;
                        BytecodeManager.incBytecodes(2);
                        long n2 = 0L;
                        BytecodeManager.incBytecodes(2);
                        long n3;
                        do {
                            final Spliterator.OfPrimitive ofPrimitive5 = (Spliterator.OfPrimitive)this.s;
                            final ArrayBuffer.OfPrimitive<T_CONS> ofPrimitive6 = ofPrimitive4;
                            BytecodeManager.incBytecodes(5);
                            final boolean tryAdvance = ofPrimitive5.tryAdvance(ofPrimitive6);
                            BytecodeManager.incBytecodes(1);
                            if (!tryAdvance) {
                                break;
                            }
                            n3 = lcmp(++n2, 128L);
                            BytecodeManager.incBytecodes(8);
                        } while (n3 < 0);
                        final long n4 = lcmp(n2, 0L);
                        BytecodeManager.incBytecodes(4);
                        if (n4 == 0) {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        final ArrayBuffer.OfPrimitive<T_CONS> ofPrimitive7 = bufferCreate;
                        final long n5 = n2;
                        BytecodeManager.incBytecodes(5);
                        final long acquirePermits = this.acquirePermits(n5);
                        BytecodeManager.incBytecodes(1);
                        ofPrimitive7.forEach(t_CONS, acquirePermits);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected abstract T_BUFF bufferCreate(final int p0);
        }
        
        static final class OfInt extends UnorderedSliceSpliterator.OfPrimitive<Integer, IntConsumer, ArrayBuffer.OfInt, Spliterator.OfInt> implements Spliterator.OfInt, IntConsumer
        {
            int tmpValue;
            
            OfInt(final Spliterator.OfInt ofInt, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofInt, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfInt(final Spliterator.OfInt ofInt, final OfInt ofInt2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofInt, (UnorderedSliceSpliterator.OfPrimitive<Object, Object, ArrayBuffer.OfPrimitive, Spliterator.OfInt>)ofInt2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final int tmpValue) {
                try {
                    this.tmpValue = tmpValue;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected void acceptConsumed(final IntConsumer intConsumer) {
                try {
                    final int tmpValue = this.tmpValue;
                    BytecodeManager.incBytecodes(4);
                    intConsumer.accept(tmpValue);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected ArrayBuffer.OfInt bufferCreate(final int n) {
                try {
                    BytecodeManager.incBytecodes(4);
                    final ArrayBuffer.OfInt ofInt = new ArrayBuffer.OfInt(n);
                    BytecodeManager.incBytecodes(1);
                    return ofInt;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfInt makeSpliterator(final Spliterator.OfInt ofInt) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final OfInt ofInt2 = new OfInt(ofInt, this);
                    BytecodeManager.incBytecodes(1);
                    return ofInt2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends UnorderedSliceSpliterator.OfPrimitive<Long, LongConsumer, ArrayBuffer.OfLong, Spliterator.OfLong> implements Spliterator.OfLong, LongConsumer
        {
            long tmpValue;
            
            OfLong(final Spliterator.OfLong ofLong, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofLong, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfLong(final Spliterator.OfLong ofLong, final OfLong ofLong2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofLong, (UnorderedSliceSpliterator.OfPrimitive<Object, Object, ArrayBuffer.OfPrimitive, Spliterator.OfLong>)ofLong2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final long tmpValue) {
                try {
                    this.tmpValue = tmpValue;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected void acceptConsumed(final LongConsumer longConsumer) {
                try {
                    final long tmpValue = this.tmpValue;
                    BytecodeManager.incBytecodes(4);
                    longConsumer.accept(tmpValue);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected ArrayBuffer.OfLong bufferCreate(final int n) {
                try {
                    BytecodeManager.incBytecodes(4);
                    final ArrayBuffer.OfLong ofLong = new ArrayBuffer.OfLong(n);
                    BytecodeManager.incBytecodes(1);
                    return ofLong;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfLong makeSpliterator(final Spliterator.OfLong ofLong) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final OfLong ofLong2 = new OfLong(ofLong, this);
                    BytecodeManager.incBytecodes(1);
                    return ofLong2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends UnorderedSliceSpliterator.OfPrimitive<Double, DoubleConsumer, ArrayBuffer.OfDouble, Spliterator.OfDouble> implements Spliterator.OfDouble, DoubleConsumer
        {
            double tmpValue;
            
            OfDouble(final Spliterator.OfDouble ofDouble, final long n, final long n2) {
                try {
                    BytecodeManager.incBytecodes(5);
                    super(ofDouble, n, n2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            OfDouble(final Spliterator.OfDouble ofDouble, final OfDouble ofDouble2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(ofDouble, (UnorderedSliceSpliterator.OfPrimitive<Object, Object, ArrayBuffer.OfPrimitive, Spliterator.OfDouble>)ofDouble2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final double tmpValue) {
                try {
                    this.tmpValue = tmpValue;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected void acceptConsumed(final DoubleConsumer doubleConsumer) {
                try {
                    final double tmpValue = this.tmpValue;
                    BytecodeManager.incBytecodes(4);
                    doubleConsumer.accept(tmpValue);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected ArrayBuffer.OfDouble bufferCreate(final int n) {
                try {
                    BytecodeManager.incBytecodes(4);
                    final ArrayBuffer.OfDouble ofDouble = new ArrayBuffer.OfDouble(n);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            protected Spliterator.OfDouble makeSpliterator(final Spliterator.OfDouble ofDouble) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final OfDouble ofDouble2 = new OfDouble(ofDouble, this);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class DistinctSpliterator<T> implements Spliterator<T>, Consumer<T>
    {
        private static final Object NULL_VALUE;
        private final Spliterator<T> s;
        private final ConcurrentHashMap<T, Boolean> seen;
        private T tmpSlot;
        
        DistinctSpliterator(final Spliterator<T> spliterator) {
            try {
                BytecodeManager.incBytecodes(5);
                final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                BytecodeManager.incBytecodes(1);
                this(spliterator, concurrentHashMap);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private DistinctSpliterator(final Spliterator<T> s, final ConcurrentHashMap<T, Boolean> seen) {
            try {
                BytecodeManager.incBytecodes(2);
                this.s = s;
                BytecodeManager.incBytecodes(3);
                this.seen = seen;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final T tmpSlot) {
            try {
                this.tmpSlot = tmpSlot;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private T mapNull(final T t) {
            try {
                BytecodeManager.incBytecodes(2);
                Object null_VALUE;
                if (t != null) {
                    null_VALUE = t;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    null_VALUE = DistinctSpliterator.NULL_VALUE;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return (T)null_VALUE;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            try {
                Boolean putIfAbsent;
                do {
                    final Spliterator<T> s = this.s;
                    BytecodeManager.incBytecodes(4);
                    final boolean tryAdvance = s.tryAdvance(this);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final ConcurrentHashMap<T, Boolean> seen = this.seen;
                    final T tmpSlot = this.tmpSlot;
                    BytecodeManager.incBytecodes(6);
                    final Object mapNull = this.mapNull(tmpSlot);
                    final Boolean true = Boolean.TRUE;
                    BytecodeManager.incBytecodes(2);
                    putIfAbsent = seen.putIfAbsent((T)mapNull, true);
                    BytecodeManager.incBytecodes(1);
                } while (putIfAbsent != null);
                final T tmpSlot2 = this.tmpSlot;
                BytecodeManager.incBytecodes(4);
                consumer.accept(tmpSlot2);
                this.tmpSlot = null;
                BytecodeManager.incBytecodes(3);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super T> consumer) {
            try {
                final Spliterator<T> s = this.s;
                ConcurrentHashMap<T, Boolean> seen;
                Boolean true;
                final T t2;
                final Object o;
                final Consumer<? super T> consumer2 = t -> {
                    try {
                        seen = this.seen;
                        BytecodeManager.incBytecodes(5);
                        this.mapNull(t);
                        true = Boolean.TRUE;
                        BytecodeManager.incBytecodes(2);
                        seen.putIfAbsent(t2, true);
                        BytecodeManager.incBytecodes(1);
                        if (o == null) {
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(t);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(5);
                s.forEachRemaining(consumer2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> trySplit() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Spliterator<T> trySplit = s.trySplit();
                BytecodeManager.incBytecodes(1);
                final Spliterator<T> spliterator = trySplit;
                BytecodeManager.incBytecodes(2);
                Spliterator<T> spliterator2;
                if (spliterator != null) {
                    final Spliterator<T> spliterator3;
                    final ConcurrentHashMap<T, Boolean> seen;
                    spliterator2 = new DistinctSpliterator((Spliterator<Object>)spliterator3, (ConcurrentHashMap<Object, Boolean>)seen);
                    spliterator3 = trySplit;
                    seen = this.seen;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    spliterator2 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return spliterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final long estimateSize = s.estimateSize();
                BytecodeManager.incBytecodes(1);
                return estimateSize;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final int n = (s.characteristics() & 0xFFFFBFAB) | 0x1;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super T> getComparator() {
            try {
                final Spliterator<T> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super T> comparator = s.getComparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                NULL_VALUE = new Object();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class InfiniteSupplyingSpliterator<T> implements Spliterator<T>
    {
        long estimate;
        
        protected InfiniteSupplyingSpliterator(final long estimate) {
            try {
                BytecodeManager.incBytecodes(2);
                this.estimate = estimate;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long estimate = this.estimate;
                BytecodeManager.incBytecodes(3);
                return estimate;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 1024;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class OfRef<T> extends InfiniteSupplyingSpliterator<T>
        {
            final Supplier<T> s;
            
            OfRef(final long n, final Supplier<T> s) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(n);
                    this.s = s;
                    BytecodeManager.incBytecodes(3);
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
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final Supplier<T> s = this.s;
                    BytecodeManager.incBytecodes(4);
                    final T value = s.get();
                    BytecodeManager.incBytecodes(1);
                    consumer.accept(value);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<T> trySplit() {
                try {
                    final long n = lcmp(this.estimate, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n == 0) {
                        final Spliterator<T> spliterator = null;
                        BytecodeManager.incBytecodes(2);
                        return spliterator;
                    }
                    final long estimate = this.estimate >>> 1;
                    this.estimate = estimate;
                    final Supplier<T> s = this.s;
                    BytecodeManager.incBytecodes(12);
                    final OfRef ofRef = new OfRef(estimate, (Supplier<Object>)s);
                    BytecodeManager.incBytecodes(1);
                    return ofRef;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfInt extends InfiniteSupplyingSpliterator<Integer> implements Spliterator.OfInt
        {
            final IntSupplier s;
            
            OfInt(final long n, final IntSupplier s) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(n);
                    this.s = s;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final IntConsumer intConsumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(intConsumer);
                    BytecodeManager.incBytecodes(1);
                    final IntSupplier s = this.s;
                    BytecodeManager.incBytecodes(4);
                    final int asInt = s.getAsInt();
                    BytecodeManager.incBytecodes(1);
                    intConsumer.accept(asInt);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfInt trySplit() {
                try {
                    final long n = lcmp(this.estimate, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n == 0) {
                        final Spliterator.OfInt ofInt = null;
                        BytecodeManager.incBytecodes(2);
                        return ofInt;
                    }
                    final long estimate = this.estimate >>> 1;
                    this.estimate = estimate;
                    final IntSupplier s = this.s;
                    BytecodeManager.incBytecodes(12);
                    final OfInt ofInt2 = new OfInt(estimate, s);
                    BytecodeManager.incBytecodes(1);
                    return ofInt2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends InfiniteSupplyingSpliterator<Long> implements Spliterator.OfLong
        {
            final LongSupplier s;
            
            OfLong(final long n, final LongSupplier s) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(n);
                    this.s = s;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final LongConsumer longConsumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(longConsumer);
                    BytecodeManager.incBytecodes(1);
                    final LongSupplier s = this.s;
                    BytecodeManager.incBytecodes(4);
                    final long asLong = s.getAsLong();
                    BytecodeManager.incBytecodes(1);
                    longConsumer.accept(asLong);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfLong trySplit() {
                try {
                    final long n = lcmp(this.estimate, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n == 0) {
                        final Spliterator.OfLong ofLong = null;
                        BytecodeManager.incBytecodes(2);
                        return ofLong;
                    }
                    final long estimate = this.estimate >>> 1;
                    this.estimate = estimate;
                    final LongSupplier s = this.s;
                    BytecodeManager.incBytecodes(12);
                    final OfLong ofLong2 = new OfLong(estimate, s);
                    BytecodeManager.incBytecodes(1);
                    return ofLong2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends InfiniteSupplyingSpliterator<Double> implements Spliterator.OfDouble
        {
            final DoubleSupplier s;
            
            OfDouble(final long n, final DoubleSupplier s) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(n);
                    this.s = s;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final DoubleConsumer doubleConsumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                    final DoubleSupplier s = this.s;
                    BytecodeManager.incBytecodes(4);
                    final double asDouble = s.getAsDouble();
                    BytecodeManager.incBytecodes(1);
                    doubleConsumer.accept(asDouble);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator.OfDouble trySplit() {
                try {
                    final long n = lcmp(this.estimate, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n == 0) {
                        final Spliterator.OfDouble ofDouble = null;
                        BytecodeManager.incBytecodes(2);
                        return ofDouble;
                    }
                    final long estimate = this.estimate >>> 1;
                    this.estimate = estimate;
                    final DoubleSupplier s = this.s;
                    BytecodeManager.incBytecodes(12);
                    final OfDouble ofDouble2 = new OfDouble(estimate, s);
                    BytecodeManager.incBytecodes(1);
                    return ofDouble2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    abstract static class ArrayBuffer
    {
        int index;
        
        ArrayBuffer() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void reset() {
            try {
                this.index = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class OfRef<T> extends ArrayBuffer implements Consumer<T>
        {
            final Object[] array;
            
            OfRef(final int n) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.array = new Object[n];
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
                    this.array[this.index++] = t;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public void forEach(final Consumer<? super T> consumer, final long n) {
                try {
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final long n3 = lcmp((long)n2, n);
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            break;
                        }
                        final Object o = this.array[n2];
                        BytecodeManager.incBytecodes(5);
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept((Object)o2);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        abstract static class OfPrimitive<T_CONS> extends ArrayBuffer
        {
            int index;
            
            OfPrimitive() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            void reset() {
                try {
                    this.index = 0;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            abstract void forEach(final T_CONS p0, final long p1);
        }
        
        static final class OfInt extends OfPrimitive<IntConsumer> implements IntConsumer
        {
            final int[] array;
            
            OfInt(final int n) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.array = new int[n];
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
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public void forEach(final IntConsumer intConsumer, final long n) {
                try {
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final long n3 = lcmp((long)n2, n);
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            break;
                        }
                        final int n4 = this.array[n2];
                        BytecodeManager.incBytecodes(6);
                        intConsumer.accept(n4);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfLong extends OfPrimitive<LongConsumer> implements LongConsumer
        {
            final long[] array;
            
            OfLong(final int n) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.array = new long[n];
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
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            public void forEach(final LongConsumer longConsumer, final long n) {
                try {
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final long n3 = lcmp((long)n2, n);
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            break;
                        }
                        final long n4 = this.array[n2];
                        BytecodeManager.incBytecodes(6);
                        longConsumer.accept(n4);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class OfDouble extends OfPrimitive<DoubleConsumer> implements DoubleConsumer
        {
            final double[] array;
            
            OfDouble(final int n) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.array = new double[n];
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
                    this.array[this.index++] = n;
                    BytecodeManager.incBytecodes(11);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            void forEach(final DoubleConsumer doubleConsumer, final long n) {
                try {
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final long n3 = lcmp((long)n2, n);
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            break;
                        }
                        final double n4 = this.array[n2];
                        BytecodeManager.incBytecodes(6);
                        doubleConsumer.accept(n4);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
}
