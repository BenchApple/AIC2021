// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.Comparator;
import instrumented.java.util.Objects;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.Spliterator;
import aic2021.engine.BytecodeManager;

final class Streams
{
    static final Object NONE;
    
    private Streams() {
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
    
    static Runnable composeWithExceptions(final Runnable runnable, final Runnable runnable2) {
        try {
            BytecodeManager.incBytecodes(5);
            final Runnable runnable3 = new Runnable() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public void run() {
                    try {
                        try {
                            try {
                                final Runnable val$a = runnable;
                                BytecodeManager.incBytecodes(3);
                                val$a.run();
                                BytecodeManager.incBytecodes(1);
                            }
                            catch (Throwable t2) {
                                BytecodeManager.incBytecodes(501);
                                try {
                                    final Runnable val$b = runnable2;
                                    BytecodeManager.incBytecodes(3);
                                    val$b.run();
                                    BytecodeManager.incBytecodes(1);
                                }
                                catch (Throwable t3) {
                                    BytecodeManager.incBytecodes(501);
                                    try {
                                        final Throwable t = t2;
                                        final Throwable exception = t3;
                                        BytecodeManager.incBytecodes(3);
                                        t.addSuppressed(exception);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    catch (Throwable t5) {
                                        BytecodeManager.incBytecodes(501);
                                    }
                                }
                                final Throwable t4 = t2;
                                BytecodeManager.incBytecodes(2);
                                throw t4;
                            }
                            final Runnable val$b2 = runnable2;
                            BytecodeManager.incBytecodes(3);
                            val$b2.run();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    catch (VirtualMachineError virtualMachineError) {
                        throw virtualMachineError;
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return runnable3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Runnable composedClose(final BaseStream<?, ?> baseStream, final BaseStream<?, ?> baseStream2) {
        try {
            BytecodeManager.incBytecodes(5);
            final Runnable runnable = new Runnable() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public void run() {
                    try {
                        try {
                            try {
                                final BaseStream val$a = baseStream;
                                BytecodeManager.incBytecodes(3);
                                val$a.close();
                                BytecodeManager.incBytecodes(1);
                            }
                            catch (Throwable t2) {
                                BytecodeManager.incBytecodes(501);
                                try {
                                    final BaseStream val$b = baseStream2;
                                    BytecodeManager.incBytecodes(3);
                                    val$b.close();
                                    BytecodeManager.incBytecodes(1);
                                }
                                catch (Throwable t3) {
                                    BytecodeManager.incBytecodes(501);
                                    try {
                                        final Throwable t = t2;
                                        final Throwable exception = t3;
                                        BytecodeManager.incBytecodes(3);
                                        t.addSuppressed(exception);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    catch (Throwable t5) {
                                        BytecodeManager.incBytecodes(501);
                                    }
                                }
                                final Throwable t4 = t2;
                                BytecodeManager.incBytecodes(2);
                                throw t4;
                            }
                            final BaseStream val$b2 = baseStream2;
                            BytecodeManager.incBytecodes(3);
                            val$b2.close();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    catch (VirtualMachineError virtualMachineError) {
                        throw virtualMachineError;
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return runnable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            NONE = new Object();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class RangeIntSpliterator implements Spliterator.OfInt
    {
        private int from;
        private final int upTo;
        private int last;
        private static final int BALANCED_SPLIT_THRESHOLD = 16777216;
        private static final int RIGHT_BALANCED_SPLIT_RATIO = 8;
        
        RangeIntSpliterator(final int n, final int n2, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                int n3;
                if (b) {
                    n3 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                this(n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private RangeIntSpliterator(final int from, final int upTo, final int last) {
            try {
                BytecodeManager.incBytecodes(2);
                this.from = from;
                BytecodeManager.incBytecodes(3);
                this.upTo = upTo;
                BytecodeManager.incBytecodes(3);
                this.last = last;
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
                final int from = this.from;
                BytecodeManager.incBytecodes(3);
                final int n = from;
                final int upTo = this.upTo;
                BytecodeManager.incBytecodes(4);
                if (n < upTo) {
                    ++this.from;
                    BytecodeManager.incBytecodes(6);
                    final int n2 = from;
                    BytecodeManager.incBytecodes(3);
                    intConsumer.accept(n2);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int last = this.last;
                BytecodeManager.incBytecodes(3);
                if (last > 0) {
                    this.last = 0;
                    BytecodeManager.incBytecodes(3);
                    final int n3 = from;
                    BytecodeManager.incBytecodes(3);
                    intConsumer.accept(n3);
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(intConsumer);
                BytecodeManager.incBytecodes(1);
                int from = this.from;
                BytecodeManager.incBytecodes(3);
                final int upTo = this.upTo;
                BytecodeManager.incBytecodes(3);
                final int last = this.last;
                BytecodeManager.incBytecodes(3);
                this.from = this.upTo;
                BytecodeManager.incBytecodes(4);
                this.last = 0;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n = from;
                    final int n2 = upTo;
                    BytecodeManager.incBytecodes(3);
                    if (n >= n2) {
                        break;
                    }
                    final int n3 = from++;
                    BytecodeManager.incBytecodes(4);
                    intConsumer.accept(n3);
                    BytecodeManager.incBytecodes(1);
                }
                final int n4 = last;
                BytecodeManager.incBytecodes(2);
                if (n4 > 0) {
                    final int n5 = from;
                    BytecodeManager.incBytecodes(3);
                    intConsumer.accept(n5);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = this.upTo - (long)this.from + this.last;
                BytecodeManager.incBytecodes(12);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17749;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Integer> getComparator() {
            try {
                final Comparator<? super Integer> comparator = null;
                BytecodeManager.incBytecodes(2);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final long estimateSize = this.estimateSize();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(estimateSize, 1L);
                BytecodeManager.incBytecodes(4);
                Spliterator.OfInt ofInt;
                if (n <= 0) {
                    ofInt = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int from;
                    final int from2;
                    final int n2;
                    ofInt = new RangeIntSpliterator(from, from2, n2);
                    from = this.from;
                    final int from3 = this.from;
                    final long n3 = estimateSize;
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    from2 = from3 + this.splitPoint(n3);
                    this.from = from2;
                    n2 = 0;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
                return ofInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int splitPoint(final long n) {
            try {
                final long n2 = lcmp(n, 16777216L);
                BytecodeManager.incBytecodes(4);
                int n3;
                if (n2 < 0) {
                    n3 = 2;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = 8;
                    BytecodeManager.incBytecodes(1);
                }
                final int n4 = n3;
                BytecodeManager.incBytecodes(1);
                final int n5 = (int)(n / n4);
                BytecodeManager.incBytecodes(6);
                return n5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class RangeLongSpliterator implements Spliterator.OfLong
    {
        private long from;
        private final long upTo;
        private int last;
        private static final long BALANCED_SPLIT_THRESHOLD = 16777216L;
        private static final long RIGHT_BALANCED_SPLIT_RATIO = 8L;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        RangeLongSpliterator(final long n, final long n2, final boolean b) {
            try {
                BytecodeManager.incBytecodes(5);
                int n3;
                if (b) {
                    n3 = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = 0;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                this(n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private RangeLongSpliterator(final long from, final long upTo, final int last) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = RangeLongSpliterator.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    final long n = lcmp(upTo - from + last, 0L);
                    BytecodeManager.incBytecodes(9);
                    if (n <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.from = from;
                BytecodeManager.incBytecodes(3);
                this.upTo = upTo;
                BytecodeManager.incBytecodes(3);
                this.last = last;
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
                final long from = this.from;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(from, this.upTo);
                BytecodeManager.incBytecodes(5);
                if (n < 0) {
                    ++this.from;
                    BytecodeManager.incBytecodes(6);
                    final long n2 = from;
                    BytecodeManager.incBytecodes(3);
                    longConsumer.accept(n2);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int last = this.last;
                BytecodeManager.incBytecodes(3);
                if (last > 0) {
                    this.last = 0;
                    BytecodeManager.incBytecodes(3);
                    final long n3 = from;
                    BytecodeManager.incBytecodes(3);
                    longConsumer.accept(n3);
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(longConsumer);
                BytecodeManager.incBytecodes(1);
                long from = this.from;
                BytecodeManager.incBytecodes(3);
                final long upTo = this.upTo;
                BytecodeManager.incBytecodes(3);
                final int last = this.last;
                BytecodeManager.incBytecodes(3);
                this.from = this.upTo;
                BytecodeManager.incBytecodes(4);
                this.last = 0;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final long n = lcmp(from, upTo);
                    BytecodeManager.incBytecodes(4);
                    if (n >= 0) {
                        break;
                    }
                    final long n2 = from++;
                    BytecodeManager.incBytecodes(7);
                    longConsumer.accept(n2);
                    BytecodeManager.incBytecodes(1);
                }
                final int n3 = last;
                BytecodeManager.incBytecodes(2);
                if (n3 > 0) {
                    final long n4 = from;
                    BytecodeManager.incBytecodes(3);
                    longConsumer.accept(n4);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = this.upTo - this.from + this.last;
                BytecodeManager.incBytecodes(10);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17749;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Long> getComparator() {
            try {
                final Comparator<? super Long> comparator = null;
                BytecodeManager.incBytecodes(2);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final long estimateSize = this.estimateSize();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(estimateSize, 1L);
                BytecodeManager.incBytecodes(4);
                Spliterator.OfLong ofLong;
                if (n <= 0) {
                    ofLong = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long from;
                    final long from2;
                    final int n2;
                    ofLong = new RangeLongSpliterator(from, from2, n2);
                    from = this.from;
                    final long from3 = this.from;
                    final long n3 = estimateSize;
                    BytecodeManager.incBytecodes(9);
                    BytecodeManager.incBytecodes(1);
                    from2 = from3 + this.splitPoint(n3);
                    this.from = from2;
                    n2 = 0;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
                return ofLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private long splitPoint(final long n) {
            try {
                final long n2 = lcmp(n, 16777216L);
                BytecodeManager.incBytecodes(4);
                long n3;
                if (n2 < 0) {
                    n3 = 2L;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n3 = 8L;
                    BytecodeManager.incBytecodes(1);
                }
                final long n4 = n3;
                BytecodeManager.incBytecodes(1);
                final long n5 = n / n4;
                BytecodeManager.incBytecodes(4);
                return n5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Streams> clazz = Streams.class;
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
    
    private abstract static class AbstractStreamBuilderImpl<T, S extends Spliterator<T>> implements Spliterator<T>
    {
        int count;
        
        private AbstractStreamBuilderImpl() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public S trySplit() {
            try {
                final Spliterator<T> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return (S)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long n = -this.count - 1;
                BytecodeManager.incBytecodes(7);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 17488;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class StreamBuilderImpl<T> extends AbstractStreamBuilderImpl<T, Spliterator<T>> implements Stream.Builder<T>
    {
        T first;
        SpinedBuffer<T> buffer;
        
        StreamBuilderImpl() {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        StreamBuilderImpl(final T first) {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                this.first = first;
                BytecodeManager.incBytecodes(3);
                this.count = -2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final T first) {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                if (count == 0) {
                    this.first = first;
                    BytecodeManager.incBytecodes(3);
                    ++this.count;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final int count2 = this.count;
                    BytecodeManager.incBytecodes(3);
                    if (count2 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final SpinedBuffer<T> buffer = this.buffer;
                    BytecodeManager.incBytecodes(3);
                    if (buffer == null) {
                        BytecodeManager.incBytecodes(4);
                        this.buffer = new SpinedBuffer<T>();
                        BytecodeManager.incBytecodes(1);
                        final SpinedBuffer<T> buffer2 = this.buffer;
                        final T first2 = this.first;
                        BytecodeManager.incBytecodes(5);
                        buffer2.accept(first2);
                        ++this.count;
                        BytecodeManager.incBytecodes(6);
                    }
                    final SpinedBuffer<T> buffer3 = this.buffer;
                    BytecodeManager.incBytecodes(4);
                    buffer3.accept(first);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream.Builder<T> add(final T t) {
            try {
                BytecodeManager.incBytecodes(3);
                this.accept(t);
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<T> build() {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                final int n = count;
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    this.count = -this.count - 1;
                    BytecodeManager.incBytecodes(7);
                    final int n2 = count;
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(3);
                    Stream<T> stream;
                    if (n2 < n3) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(3);
                        stream = StreamSupport.stream((Spliterator<T>)this, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final SpinedBuffer<T> buffer = this.buffer;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator<T> spliterator = buffer.spliterator();
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        stream = StreamSupport.stream(spliterator, b2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return stream;
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
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final T first = this.first;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final T first = this.first;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class IntStreamBuilderImpl extends AbstractStreamBuilderImpl<Integer, Spliterator.OfInt> implements IntStream.Builder, Spliterator.OfInt
    {
        int first;
        SpinedBuffer.OfInt buffer;
        
        IntStreamBuilderImpl() {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        IntStreamBuilderImpl(final int first) {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                this.first = first;
                BytecodeManager.incBytecodes(3);
                this.count = -2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final int first) {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                if (count == 0) {
                    this.first = first;
                    BytecodeManager.incBytecodes(3);
                    ++this.count;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final int count2 = this.count;
                    BytecodeManager.incBytecodes(3);
                    if (count2 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final SpinedBuffer.OfInt buffer = this.buffer;
                    BytecodeManager.incBytecodes(3);
                    if (buffer == null) {
                        BytecodeManager.incBytecodes(4);
                        this.buffer = new SpinedBuffer.OfInt();
                        BytecodeManager.incBytecodes(1);
                        final SpinedBuffer.OfInt buffer2 = this.buffer;
                        final int first2 = this.first;
                        BytecodeManager.incBytecodes(5);
                        buffer2.accept(first2);
                        ++this.count;
                        BytecodeManager.incBytecodes(6);
                    }
                    final SpinedBuffer.OfInt buffer3 = this.buffer;
                    BytecodeManager.incBytecodes(4);
                    buffer3.accept(first);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public IntStream build() {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                final int n = count;
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    this.count = -this.count - 1;
                    BytecodeManager.incBytecodes(7);
                    final int n2 = count;
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(3);
                    IntStream intStream;
                    if (n2 < n3) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(3);
                        intStream = StreamSupport.intStream(this, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final SpinedBuffer.OfInt buffer = this.buffer;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator.OfInt spliterator = buffer.spliterator();
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        intStream = StreamSupport.intStream(spliterator, b2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return intStream;
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
        public boolean tryAdvance(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(intConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final int first = this.first;
                    BytecodeManager.incBytecodes(4);
                    intConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(intConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final int first = this.first;
                    BytecodeManager.incBytecodes(4);
                    intConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LongStreamBuilderImpl extends AbstractStreamBuilderImpl<Long, Spliterator.OfLong> implements LongStream.Builder, Spliterator.OfLong
    {
        long first;
        SpinedBuffer.OfLong buffer;
        
        LongStreamBuilderImpl() {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        LongStreamBuilderImpl(final long first) {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                this.first = first;
                BytecodeManager.incBytecodes(3);
                this.count = -2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final long first) {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                if (count == 0) {
                    this.first = first;
                    BytecodeManager.incBytecodes(3);
                    ++this.count;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final int count2 = this.count;
                    BytecodeManager.incBytecodes(3);
                    if (count2 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final SpinedBuffer.OfLong buffer = this.buffer;
                    BytecodeManager.incBytecodes(3);
                    if (buffer == null) {
                        BytecodeManager.incBytecodes(4);
                        this.buffer = new SpinedBuffer.OfLong();
                        BytecodeManager.incBytecodes(1);
                        final SpinedBuffer.OfLong buffer2 = this.buffer;
                        final long first2 = this.first;
                        BytecodeManager.incBytecodes(5);
                        buffer2.accept(first2);
                        ++this.count;
                        BytecodeManager.incBytecodes(6);
                    }
                    final SpinedBuffer.OfLong buffer3 = this.buffer;
                    BytecodeManager.incBytecodes(4);
                    buffer3.accept(first);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public LongStream build() {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                final int n = count;
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    this.count = -this.count - 1;
                    BytecodeManager.incBytecodes(7);
                    final int n2 = count;
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(3);
                    LongStream longStream;
                    if (n2 < n3) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(3);
                        longStream = StreamSupport.longStream(this, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final SpinedBuffer.OfLong buffer = this.buffer;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator.OfLong spliterator = buffer.spliterator();
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        longStream = StreamSupport.longStream(spliterator, b2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return longStream;
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
        public boolean tryAdvance(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(longConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final long first = this.first;
                    BytecodeManager.incBytecodes(4);
                    longConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(longConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final long first = this.first;
                    BytecodeManager.incBytecodes(4);
                    longConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class DoubleStreamBuilderImpl extends AbstractStreamBuilderImpl<Double, Spliterator.OfDouble> implements DoubleStream.Builder, Spliterator.OfDouble
    {
        double first;
        SpinedBuffer.OfDouble buffer;
        
        DoubleStreamBuilderImpl() {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        DoubleStreamBuilderImpl(final double first) {
            try {
                final Runnable runnable = null;
                BytecodeManager.incBytecodes(3);
                this.first = first;
                BytecodeManager.incBytecodes(3);
                this.count = -2;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void accept(final double first) {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                if (count == 0) {
                    this.first = first;
                    BytecodeManager.incBytecodes(3);
                    ++this.count;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    final int count2 = this.count;
                    BytecodeManager.incBytecodes(3);
                    if (count2 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final SpinedBuffer.OfDouble buffer = this.buffer;
                    BytecodeManager.incBytecodes(3);
                    if (buffer == null) {
                        BytecodeManager.incBytecodes(4);
                        this.buffer = new SpinedBuffer.OfDouble();
                        BytecodeManager.incBytecodes(1);
                        final SpinedBuffer.OfDouble buffer2 = this.buffer;
                        final double first2 = this.first;
                        BytecodeManager.incBytecodes(5);
                        buffer2.accept(first2);
                        ++this.count;
                        BytecodeManager.incBytecodes(6);
                    }
                    final SpinedBuffer.OfDouble buffer3 = this.buffer;
                    BytecodeManager.incBytecodes(4);
                    buffer3.accept(first);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public DoubleStream build() {
            try {
                final int count = this.count;
                BytecodeManager.incBytecodes(3);
                final int n = count;
                BytecodeManager.incBytecodes(2);
                if (n >= 0) {
                    this.count = -this.count - 1;
                    BytecodeManager.incBytecodes(7);
                    final int n2 = count;
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(3);
                    DoubleStream doubleStream;
                    if (n2 < n3) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(3);
                        doubleStream = StreamSupport.doubleStream(this, b);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final SpinedBuffer.OfDouble buffer = this.buffer;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator.OfDouble spliterator = buffer.spliterator();
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        doubleStream = StreamSupport.doubleStream(spliterator, b2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return doubleStream;
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
        public boolean tryAdvance(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(doubleConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final double first = this.first;
                    BytecodeManager.incBytecodes(4);
                    doubleConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean b2 = false;
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(doubleConsumer);
                BytecodeManager.incBytecodes(1);
                final int count = this.count;
                final int n = -2;
                BytecodeManager.incBytecodes(4);
                if (count == n) {
                    final double first = this.first;
                    BytecodeManager.incBytecodes(4);
                    doubleConsumer.accept(first);
                    this.count = -1;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class ConcatSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T>
    {
        protected final T_SPLITR aSpliterator;
        protected final T_SPLITR bSpliterator;
        boolean beforeSplit;
        final boolean unsized;
        
        public ConcatSpliterator(final T_SPLITR aSpliterator, final T_SPLITR bSpliterator) {
            try {
                BytecodeManager.incBytecodes(2);
                this.aSpliterator = aSpliterator;
                BytecodeManager.incBytecodes(3);
                this.bSpliterator = bSpliterator;
                BytecodeManager.incBytecodes(3);
                this.beforeSplit = true;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                final long estimateSize = aSpliterator.estimateSize();
                BytecodeManager.incBytecodes(2);
                final long n = lcmp(estimateSize + bSpliterator.estimateSize(), 0L);
                BytecodeManager.incBytecodes(4);
                boolean unsized;
                if (n < 0) {
                    unsized = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    unsized = false;
                    BytecodeManager.incBytecodes(1);
                }
                this.unsized = unsized;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public T_SPLITR trySplit() {
            try {
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                Spliterator<T> spliterator;
                if (beforeSplit) {
                    spliterator = this.aSpliterator;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Spliterator<T> bSpliterator = this.bSpliterator;
                    BytecodeManager.incBytecodes(3);
                    spliterator = bSpliterator.trySplit();
                }
                final Spliterator<T> spliterator2 = spliterator;
                BytecodeManager.incBytecodes(1);
                this.beforeSplit = false;
                BytecodeManager.incBytecodes(3);
                final Spliterator<T> spliterator3 = spliterator2;
                BytecodeManager.incBytecodes(2);
                return (T_SPLITR)spliterator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            try {
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (beforeSplit) {
                    final Spliterator<T> aSpliterator = this.aSpliterator;
                    BytecodeManager.incBytecodes(4);
                    b = aSpliterator.tryAdvance(consumer);
                    BytecodeManager.incBytecodes(1);
                    final boolean b2 = b;
                    BytecodeManager.incBytecodes(2);
                    if (!b2) {
                        this.beforeSplit = false;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator<T> bSpliterator = this.bSpliterator;
                        BytecodeManager.incBytecodes(4);
                        b = bSpliterator.tryAdvance(consumer);
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    final Spliterator<T> bSpliterator2 = this.bSpliterator;
                    BytecodeManager.incBytecodes(4);
                    b = bSpliterator2.tryAdvance(consumer);
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b3 = b;
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
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                if (beforeSplit) {
                    final Spliterator<T> aSpliterator = this.aSpliterator;
                    BytecodeManager.incBytecodes(4);
                    aSpliterator.forEachRemaining(consumer);
                }
                final Spliterator<T> bSpliterator = this.bSpliterator;
                BytecodeManager.incBytecodes(4);
                bSpliterator.forEachRemaining(consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                if (beforeSplit) {
                    final Spliterator<T> aSpliterator = this.aSpliterator;
                    BytecodeManager.incBytecodes(3);
                    final long estimateSize = aSpliterator.estimateSize();
                    final Spliterator<T> bSpliterator = this.bSpliterator;
                    BytecodeManager.incBytecodes(3);
                    final long n = estimateSize + bSpliterator.estimateSize();
                    BytecodeManager.incBytecodes(2);
                    final long n2 = lcmp(n, 0L);
                    BytecodeManager.incBytecodes(4);
                    long n3;
                    if (n2 >= 0) {
                        n3 = n;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n3 = Long.MAX_VALUE;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n3;
                }
                final Spliterator<T> bSpliterator2 = this.bSpliterator;
                BytecodeManager.incBytecodes(3);
                final long estimateSize2 = bSpliterator2.estimateSize();
                BytecodeManager.incBytecodes(1);
                return estimateSize2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                if (beforeSplit) {
                    final Spliterator<T> aSpliterator = this.aSpliterator;
                    BytecodeManager.incBytecodes(3);
                    final int characteristics = aSpliterator.characteristics();
                    final Spliterator<T> bSpliterator = this.bSpliterator;
                    BytecodeManager.incBytecodes(3);
                    final int n = characteristics & bSpliterator.characteristics();
                    final int n2 = 5;
                    final boolean unsized = this.unsized;
                    BytecodeManager.incBytecodes(5);
                    int n3;
                    if (unsized) {
                        n3 = 16448;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n3 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n4 = n & ~(n2 | n3);
                    BytecodeManager.incBytecodes(5);
                    return n4;
                }
                final Spliterator<T> bSpliterator2 = this.bSpliterator;
                BytecodeManager.incBytecodes(3);
                final int characteristics2 = bSpliterator2.characteristics();
                BytecodeManager.incBytecodes(1);
                return characteristics2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super T> getComparator() {
            try {
                final boolean beforeSplit = this.beforeSplit;
                BytecodeManager.incBytecodes(3);
                if (beforeSplit) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Spliterator<T> bSpliterator = this.bSpliterator;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super T> comparator = bSpliterator.getComparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static class OfRef<T> extends ConcatSpliterator<T, Spliterator<T>>
        {
            OfRef(final Spliterator<T> spliterator, final Spliterator<T> spliterator2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(spliterator, spliterator2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        private abstract static class OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends ConcatSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>
        {
            private OfPrimitive(final T_SPLITR t_SPLITR, final T_SPLITR t_SPLITR2) {
                try {
                    BytecodeManager.incBytecodes(4);
                    super(t_SPLITR, t_SPLITR2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final T_CONS t_CONS) {
                try {
                    final boolean beforeSplit = this.beforeSplit;
                    BytecodeManager.incBytecodes(3);
                    boolean b;
                    if (beforeSplit) {
                        final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.aSpliterator;
                        BytecodeManager.incBytecodes(5);
                        b = ofPrimitive.tryAdvance(t_CONS);
                        BytecodeManager.incBytecodes(1);
                        final boolean b2 = b;
                        BytecodeManager.incBytecodes(2);
                        if (!b2) {
                            this.beforeSplit = false;
                            BytecodeManager.incBytecodes(3);
                            final Spliterator.OfPrimitive ofPrimitive2 = (Spliterator.OfPrimitive)this.bSpliterator;
                            BytecodeManager.incBytecodes(5);
                            b = ofPrimitive2.tryAdvance(t_CONS);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    else {
                        final Spliterator.OfPrimitive ofPrimitive3 = (Spliterator.OfPrimitive)this.bSpliterator;
                        BytecodeManager.incBytecodes(5);
                        b = ofPrimitive3.tryAdvance(t_CONS);
                        BytecodeManager.incBytecodes(1);
                    }
                    final boolean b3 = b;
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
                    final boolean beforeSplit = this.beforeSplit;
                    BytecodeManager.incBytecodes(3);
                    if (beforeSplit) {
                        final Spliterator.OfPrimitive ofPrimitive = (Spliterator.OfPrimitive)this.aSpliterator;
                        BytecodeManager.incBytecodes(5);
                        ofPrimitive.forEachRemaining(t_CONS);
                    }
                    final Spliterator.OfPrimitive ofPrimitive2 = (Spliterator.OfPrimitive)this.bSpliterator;
                    BytecodeManager.incBytecodes(5);
                    ofPrimitive2.forEachRemaining(t_CONS);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static class OfInt extends ConcatSpliterator.OfPrimitive<Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt
        {
            OfInt(final Spliterator.OfInt ofInt, final Spliterator.OfInt ofInt2) {
                try {
                    final Runnable runnable = null;
                    BytecodeManager.incBytecodes(5);
                    super((Spliterator.OfPrimitive)ofInt, (Spliterator.OfPrimitive)ofInt2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static class OfLong extends ConcatSpliterator.OfPrimitive<Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong
        {
            OfLong(final Spliterator.OfLong ofLong, final Spliterator.OfLong ofLong2) {
                try {
                    final Runnable runnable = null;
                    BytecodeManager.incBytecodes(5);
                    super((Spliterator.OfPrimitive)ofLong, (Spliterator.OfPrimitive)ofLong2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static class OfDouble extends ConcatSpliterator.OfPrimitive<Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble
        {
            OfDouble(final Spliterator.OfDouble ofDouble, final Spliterator.OfDouble ofDouble2) {
                try {
                    final Runnable runnable = null;
                    BytecodeManager.incBytecodes(5);
                    super((Spliterator.OfPrimitive)ofDouble, (Spliterator.OfPrimitive)ofDouble2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
}
