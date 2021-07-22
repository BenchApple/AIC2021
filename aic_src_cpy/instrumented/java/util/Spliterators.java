// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.function.Consumer;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public final class Spliterators
{
    private static final Spliterator<Object> EMPTY_SPLITERATOR;
    private static final Spliterator.OfInt EMPTY_INT_SPLITERATOR;
    private static final Spliterator.OfLong EMPTY_LONG_SPLITERATOR;
    private static final Spliterator.OfDouble EMPTY_DOUBLE_SPLITERATOR;
    
    private Spliterators() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> emptySpliterator() {
        try {
            final Spliterator<Object> empty_SPLITERATOR = Spliterators.EMPTY_SPLITERATOR;
            BytecodeManager.incBytecodes(2);
            return (Spliterator<T>)empty_SPLITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt emptyIntSpliterator() {
        try {
            final Spliterator.OfInt empty_INT_SPLITERATOR = Spliterators.EMPTY_INT_SPLITERATOR;
            BytecodeManager.incBytecodes(2);
            return empty_INT_SPLITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong emptyLongSpliterator() {
        try {
            final Spliterator.OfLong empty_LONG_SPLITERATOR = Spliterators.EMPTY_LONG_SPLITERATOR;
            BytecodeManager.incBytecodes(2);
            return empty_LONG_SPLITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble emptyDoubleSpliterator() {
        try {
            final Spliterator.OfDouble empty_DOUBLE_SPLITERATOR = Spliterators.EMPTY_DOUBLE_SPLITERATOR;
            BytecodeManager.incBytecodes(2);
            return empty_DOUBLE_SPLITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final Object[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Object[] array2 = Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(3);
            final ArraySpliterator arraySpliterator = new ArraySpliterator<T>(array2, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)arraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final Object[] array, final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = Objects.requireNonNull(array).length;
            BytecodeManager.incBytecodes(5);
            checkFromToBounds(length, n, n2);
            BytecodeManager.incBytecodes(7);
            final ArraySpliterator<T> arraySpliterator = new ArraySpliterator<T>(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return arraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliterator(final int[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final int[] array2 = Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(3);
            final IntArraySpliterator intArraySpliterator = new IntArraySpliterator(array2, n);
            BytecodeManager.incBytecodes(1);
            return intArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliterator(final int[] array, final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = Objects.requireNonNull(array).length;
            BytecodeManager.incBytecodes(5);
            checkFromToBounds(length, n, n2);
            BytecodeManager.incBytecodes(7);
            final IntArraySpliterator intArraySpliterator = new IntArraySpliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return intArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliterator(final long[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final long[] array2 = Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(3);
            final LongArraySpliterator longArraySpliterator = new LongArraySpliterator(array2, n);
            BytecodeManager.incBytecodes(1);
            return longArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliterator(final long[] array, final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = Objects.requireNonNull(array).length;
            BytecodeManager.incBytecodes(5);
            checkFromToBounds(length, n, n2);
            BytecodeManager.incBytecodes(7);
            final LongArraySpliterator longArraySpliterator = new LongArraySpliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return longArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliterator(final double[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final double[] array2 = Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(3);
            final DoubleArraySpliterator doubleArraySpliterator = new DoubleArraySpliterator(array2, n);
            BytecodeManager.incBytecodes(1);
            return doubleArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliterator(final double[] array, final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = Objects.requireNonNull(array).length;
            BytecodeManager.incBytecodes(5);
            checkFromToBounds(length, n, n2);
            BytecodeManager.incBytecodes(7);
            final DoubleArraySpliterator doubleArraySpliterator = new DoubleArraySpliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return doubleArraySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void checkFromToBounds(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n2 > n3) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "origin(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n2);
                final String str2 = ") > fence(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n3);
                final String str3 = ")";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException(n2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            if (n3 > n) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex3 = new ArrayIndexOutOfBoundsException(n3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final Collection<? extends T> collection, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Collection<? extends T> collection2 = Objects.requireNonNull(collection);
            BytecodeManager.incBytecodes(3);
            final IteratorSpliterator iteratorSpliterator = new IteratorSpliterator<T>(collection2, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)iteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final Iterator<? extends T> iterator, final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Iterator<? extends T> iterator2 = Objects.requireNonNull(iterator);
            BytecodeManager.incBytecodes(4);
            final IteratorSpliterator iteratorSpliterator = new IteratorSpliterator<T>(iterator2, n, n2);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)iteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliteratorUnknownSize(final Iterator<? extends T> iterator, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Iterator<? extends T> iterator2 = Objects.requireNonNull(iterator);
            BytecodeManager.incBytecodes(3);
            final IteratorSpliterator iteratorSpliterator = new IteratorSpliterator<T>(iterator2, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)iteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliterator(final PrimitiveIterator.OfInt ofInt, final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfInt ofInt2 = Objects.requireNonNull(ofInt);
            BytecodeManager.incBytecodes(4);
            final IntIteratorSpliterator intIteratorSpliterator = new IntIteratorSpliterator(ofInt2, n, n2);
            BytecodeManager.incBytecodes(1);
            return intIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliteratorUnknownSize(final PrimitiveIterator.OfInt ofInt, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfInt ofInt2 = Objects.requireNonNull(ofInt);
            BytecodeManager.incBytecodes(3);
            final IntIteratorSpliterator intIteratorSpliterator = new IntIteratorSpliterator(ofInt2, n);
            BytecodeManager.incBytecodes(1);
            return intIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliterator(final PrimitiveIterator.OfLong ofLong, final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfLong ofLong2 = Objects.requireNonNull(ofLong);
            BytecodeManager.incBytecodes(4);
            final LongIteratorSpliterator longIteratorSpliterator = new LongIteratorSpliterator(ofLong2, n, n2);
            BytecodeManager.incBytecodes(1);
            return longIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliteratorUnknownSize(final PrimitiveIterator.OfLong ofLong, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfLong ofLong2 = Objects.requireNonNull(ofLong);
            BytecodeManager.incBytecodes(3);
            final LongIteratorSpliterator longIteratorSpliterator = new LongIteratorSpliterator(ofLong2, n);
            BytecodeManager.incBytecodes(1);
            return longIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliterator(final PrimitiveIterator.OfDouble ofDouble, final long n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfDouble ofDouble2 = Objects.requireNonNull(ofDouble);
            BytecodeManager.incBytecodes(4);
            final DoubleIteratorSpliterator doubleIteratorSpliterator = new DoubleIteratorSpliterator(ofDouble2, n, n2);
            BytecodeManager.incBytecodes(1);
            return doubleIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliteratorUnknownSize(final PrimitiveIterator.OfDouble ofDouble, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final PrimitiveIterator.OfDouble ofDouble2 = Objects.requireNonNull(ofDouble);
            BytecodeManager.incBytecodes(3);
            final DoubleIteratorSpliterator doubleIteratorSpliterator = new DoubleIteratorSpliterator(ofDouble2, n);
            BytecodeManager.incBytecodes(1);
            return doubleIteratorSpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Iterator<T> iterator(final Spliterator<? extends T> spliterator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(spliterator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            class Adapter implements Iterator<T>, Consumer<T>
            {
                boolean valueReady;
                T nextElement;
                
                Adapter() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(4);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T nextElement) {
                    try {
                        this.valueReady = true;
                        BytecodeManager.incBytecodes(3);
                        this.nextElement = nextElement;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            final Spliterator val$spliterator = spliterator;
                            BytecodeManager.incBytecodes(4);
                            val$spliterator.tryAdvance(this);
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean valueReady2 = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        return valueReady2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public T next() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = this.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(3);
                        final T nextElement = this.nextElement;
                        BytecodeManager.incBytecodes(3);
                        return nextElement;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Adapter adapter = new Adapter();
            BytecodeManager.incBytecodes(1);
            return adapter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static PrimitiveIterator.OfInt iterator(final Spliterator.OfInt ofInt) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(ofInt);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            class Adapter implements PrimitiveIterator.OfInt, IntConsumer
            {
                boolean valueReady;
                int nextElement;
                
                Adapter() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(4);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final int nextElement) {
                    try {
                        this.valueReady = true;
                        BytecodeManager.incBytecodes(3);
                        this.nextElement = nextElement;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            final Spliterator.OfInt val$spliterator = ofInt;
                            BytecodeManager.incBytecodes(4);
                            val$spliterator.tryAdvance((IntConsumer)this);
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean valueReady2 = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        return valueReady2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int nextInt() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = this.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(3);
                        final int nextElement = this.nextElement;
                        BytecodeManager.incBytecodes(3);
                        return nextElement;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Adapter adapter = new Adapter();
            BytecodeManager.incBytecodes(1);
            return adapter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static PrimitiveIterator.OfLong iterator(final Spliterator.OfLong ofLong) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(ofLong);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            class Adapter implements PrimitiveIterator.OfLong, LongConsumer
            {
                boolean valueReady;
                long nextElement;
                
                Adapter() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(4);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final long nextElement) {
                    try {
                        this.valueReady = true;
                        BytecodeManager.incBytecodes(3);
                        this.nextElement = nextElement;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            final Spliterator.OfLong val$spliterator = ofLong;
                            BytecodeManager.incBytecodes(4);
                            val$spliterator.tryAdvance((LongConsumer)this);
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean valueReady2 = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        return valueReady2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public long nextLong() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = this.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(3);
                        final long nextElement = this.nextElement;
                        BytecodeManager.incBytecodes(3);
                        return nextElement;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Adapter adapter = new Adapter();
            BytecodeManager.incBytecodes(1);
            return adapter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static PrimitiveIterator.OfDouble iterator(final Spliterator.OfDouble ofDouble) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(ofDouble);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            class Adapter implements PrimitiveIterator.OfDouble, DoubleConsumer
            {
                boolean valueReady;
                double nextElement;
                
                Adapter() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(4);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final double nextElement) {
                    try {
                        this.valueReady = true;
                        BytecodeManager.incBytecodes(3);
                        this.nextElement = nextElement;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            final Spliterator.OfDouble val$spliterator = ofDouble;
                            BytecodeManager.incBytecodes(4);
                            val$spliterator.tryAdvance((DoubleConsumer)this);
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean valueReady2 = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        return valueReady2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public double nextDouble() {
                    try {
                        final boolean valueReady = this.valueReady;
                        BytecodeManager.incBytecodes(3);
                        if (!valueReady) {
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = this.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                BytecodeManager.incBytecodes(3);
                                final NoSuchElementException ex = new NoSuchElementException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                        this.valueReady = false;
                        BytecodeManager.incBytecodes(3);
                        final double nextElement = this.nextElement;
                        BytecodeManager.incBytecodes(3);
                        return nextElement;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            final Adapter adapter = new Adapter();
            BytecodeManager.incBytecodes(1);
            return adapter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            EMPTY_SPLITERATOR = new EmptySpliterator.OfRef<Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_INT_SPLITERATOR = new EmptySpliterator.OfInt();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_LONG_SPLITERATOR = new EmptySpliterator.OfLong();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            EMPTY_DOUBLE_SPLITERATOR = new EmptySpliterator.OfDouble();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private abstract static class EmptySpliterator<T, S extends Spliterator<T>, C>
    {
        EmptySpliterator() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
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
        
        public boolean tryAdvance(final C c) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(c);
                BytecodeManager.incBytecodes(1);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEachRemaining(final C c) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(c);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public long estimateSize() {
            try {
                final long n = 0L;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public int characteristics() {
            try {
                final int n = 16448;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static final class OfRef<T> extends EmptySpliterator<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T>
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
        }
        
        private static final class OfInt extends EmptySpliterator<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt
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
        }
        
        private static final class OfLong extends EmptySpliterator<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong
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
        }
        
        private static final class OfDouble extends EmptySpliterator<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble
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
        }
    }
    
    static final class ArraySpliterator<T> implements Spliterator<T>
    {
        private final Object[] array;
        private int index;
        private final int fence;
        private final int characteristics;
        
        public ArraySpliterator(final Object[] array, final int n) {
            try {
                final int n2 = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(7);
                this(array, n2, length, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public ArraySpliterator(final Object[] array, final int index, final int fence, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n | 0x40 | 0x4000);
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> trySplit() {
            try {
                final int index = this.index;
                final int n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                Spliterator<T> spliterator;
                if (n2 >= n3) {
                    spliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object[] array;
                    final int n4;
                    final int index2;
                    final int characteristics;
                    spliterator = new ArraySpliterator(array, n4, index2, characteristics);
                    array = this.array;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    characteristics = this.characteristics;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super T> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] array;
                final int length = (array = this.array).length;
                final int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(10);
                if (length >= n) {
                    int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= 0) {
                        final int n3 = index;
                        final int index2 = fence;
                        this.index = index2;
                        BytecodeManager.incBytecodes(6);
                        if (n3 < index2) {
                            int i;
                            int n4;
                            do {
                                final Object o = array[index];
                                BytecodeManager.incBytecodes(5);
                                consumer.accept((Object)o);
                                i = ++index;
                                n4 = fence;
                                BytecodeManager.incBytecodes(4);
                            } while (i < n4);
                        }
                    }
                }
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
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                if (index >= 0) {
                    final int index2 = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index2 < fence) {
                        final Object o = this.array[this.index++];
                        BytecodeManager.incBytecodes(11);
                        final Object o2 = o;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept((Object)o2);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
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
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
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
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super T> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super T> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class IntArraySpliterator implements Spliterator.OfInt
    {
        private final int[] array;
        private int index;
        private final int fence;
        private final int characteristics;
        
        public IntArraySpliterator(final int[] array, final int n) {
            try {
                final int n2 = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(7);
                this(array, n2, length, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public IntArraySpliterator(final int[] array, final int index, final int fence, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n | 0x40 | 0x4000);
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt trySplit() {
            try {
                final int index = this.index;
                final int n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                Spliterator.OfInt ofInt;
                if (n2 >= n3) {
                    ofInt = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int[] array;
                    final int n4;
                    final int index2;
                    final int characteristics;
                    ofInt = new IntArraySpliterator(array, n4, index2, characteristics);
                    array = this.array;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    characteristics = this.characteristics;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return ofInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int[] array;
                final int length = (array = this.array).length;
                final int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(10);
                if (length >= n) {
                    int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= 0) {
                        final int n3 = index;
                        final int index2 = fence;
                        this.index = index2;
                        BytecodeManager.incBytecodes(6);
                        if (n3 < index2) {
                            int i;
                            int n4;
                            do {
                                final int n5 = array[index];
                                BytecodeManager.incBytecodes(5);
                                intConsumer.accept(n5);
                                i = ++index;
                                n4 = fence;
                                BytecodeManager.incBytecodes(4);
                            } while (i < n4);
                        }
                    }
                }
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
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                if (index >= 0) {
                    final int index2 = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index2 < fence) {
                        final int n = this.array[this.index++];
                        BytecodeManager.incBytecodes(12);
                        intConsumer.accept(n);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
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
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
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
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Integer> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Integer> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class LongArraySpliterator implements Spliterator.OfLong
    {
        private final long[] array;
        private int index;
        private final int fence;
        private final int characteristics;
        
        public LongArraySpliterator(final long[] array, final int n) {
            try {
                final int n2 = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(7);
                this(array, n2, length, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public LongArraySpliterator(final long[] array, final int index, final int fence, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n | 0x40 | 0x4000);
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong trySplit() {
            try {
                final int index = this.index;
                final int n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                Spliterator.OfLong ofLong;
                if (n2 >= n3) {
                    ofLong = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final long[] array;
                    final int n4;
                    final int index2;
                    final int characteristics;
                    ofLong = new LongArraySpliterator(array, n4, index2, characteristics);
                    array = this.array;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    characteristics = this.characteristics;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return ofLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long[] array;
                final int length = (array = this.array).length;
                final int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(10);
                if (length >= n) {
                    int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= 0) {
                        final int n3 = index;
                        final int index2 = fence;
                        this.index = index2;
                        BytecodeManager.incBytecodes(6);
                        if (n3 < index2) {
                            int i;
                            int n4;
                            do {
                                final long n5 = array[index];
                                BytecodeManager.incBytecodes(5);
                                longConsumer.accept(n5);
                                i = ++index;
                                n4 = fence;
                                BytecodeManager.incBytecodes(4);
                            } while (i < n4);
                        }
                    }
                }
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
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                if (index >= 0) {
                    final int index2 = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index2 < fence) {
                        final long n = this.array[this.index++];
                        BytecodeManager.incBytecodes(12);
                        longConsumer.accept(n);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
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
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
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
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Long> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Long> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class DoubleArraySpliterator implements Spliterator.OfDouble
    {
        private final double[] array;
        private int index;
        private final int fence;
        private final int characteristics;
        
        public DoubleArraySpliterator(final double[] array, final int n) {
            try {
                final int n2 = 0;
                final int length = array.length;
                BytecodeManager.incBytecodes(7);
                this(array, n2, length, n);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public DoubleArraySpliterator(final double[] array, final int index, final int fence, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n | 0x40 | 0x4000);
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble trySplit() {
            try {
                final int index = this.index;
                final int n = index + this.fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                Spliterator.OfDouble ofDouble;
                if (n2 >= n3) {
                    ofDouble = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final double[] array;
                    final int n4;
                    final int index2;
                    final int characteristics;
                    ofDouble = new DoubleArraySpliterator(array, n4, index2, characteristics);
                    array = this.array;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    characteristics = this.characteristics;
                    BytecodeManager.incBytecodes(12);
                }
                BytecodeManager.incBytecodes(1);
                return ofDouble;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final double[] array;
                final int length = (array = this.array).length;
                final int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(10);
                if (length >= n) {
                    int index;
                    final int n2 = index = this.index;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= 0) {
                        final int n3 = index;
                        final int index2 = fence;
                        this.index = index2;
                        BytecodeManager.incBytecodes(6);
                        if (n3 < index2) {
                            int i;
                            int n4;
                            do {
                                final double n5 = array[index];
                                BytecodeManager.incBytecodes(5);
                                doubleConsumer.accept(n5);
                                i = ++index;
                                n4 = fence;
                                BytecodeManager.incBytecodes(4);
                            } while (i < n4);
                        }
                    }
                }
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
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int index = this.index;
                BytecodeManager.incBytecodes(3);
                if (index >= 0) {
                    final int index2 = this.index;
                    final int fence = this.fence;
                    BytecodeManager.incBytecodes(5);
                    if (index2 < fence) {
                        final double n = this.array[this.index++];
                        BytecodeManager.incBytecodes(12);
                        doubleConsumer.accept(n);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
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
        public long estimateSize() {
            try {
                final long n = this.fence - this.index;
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
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Double> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Double> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    public abstract static class AbstractSpliterator<T> implements Spliterator<T>
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private final int characteristics;
        private long est;
        private int batch;
        
        protected AbstractSpliterator(final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x40;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 != 0) {
                    characteristics = (n | 0x4000);
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> trySplit() {
            try {
                BytecodeManager.incBytecodes(3);
                final HoldingConsumer<Object> holdingConsumer = new HoldingConsumer<Object>();
                BytecodeManager.incBytecodes(1);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final HoldingConsumer<Object> holdingConsumer2 = holdingConsumer;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance = this.tryAdvance(holdingConsumer2);
                    BytecodeManager.incBytecodes(1);
                    if (tryAdvance) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final Object[] array = new Object[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean tryAdvance2;
                        do {
                            array[batch] = holdingConsumer.value;
                            final int n6 = ++batch;
                            final int n7 = n2;
                            BytecodeManager.incBytecodes(9);
                            if (n6 >= n7) {
                                break;
                            }
                            final HoldingConsumer<Object> holdingConsumer3 = holdingConsumer;
                            BytecodeManager.incBytecodes(3);
                            tryAdvance2 = this.tryAdvance(holdingConsumer3);
                            BytecodeManager.incBytecodes(1);
                        } while (tryAdvance2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n8 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n8 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final Object[] array2 = array;
                        final int n9 = 0;
                        final int n10 = batch;
                        BytecodeManager.incBytecodes(7);
                        final int characteristics = this.characteristics();
                        BytecodeManager.incBytecodes(1);
                        final ArraySpliterator arraySpliterator = new ArraySpliterator<T>(array2, n9, n10, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<T>)arraySpliterator;
                    }
                }
                final Spliterator<T> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class HoldingConsumer<T> implements Consumer<T>
        {
            Object value;
            
            HoldingConsumer() {
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
                    this.value = value;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    public abstract static class AbstractIntSpliterator implements Spliterator.OfInt
    {
        static final int MAX_BATCH = 33554432;
        static final int BATCH_UNIT = 1024;
        private final int characteristics;
        private long est;
        private int batch;
        
        protected AbstractIntSpliterator(final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x40;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 != 0) {
                    characteristics = (n | 0x4000);
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt trySplit() {
            try {
                BytecodeManager.incBytecodes(3);
                final HoldingIntConsumer holdingIntConsumer = new HoldingIntConsumer();
                BytecodeManager.incBytecodes(1);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final HoldingIntConsumer holdingIntConsumer2 = holdingIntConsumer;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance = this.tryAdvance((IntConsumer)holdingIntConsumer2);
                    BytecodeManager.incBytecodes(1);
                    if (tryAdvance) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int[] array = new int[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean tryAdvance2;
                        do {
                            array[batch] = holdingIntConsumer.value;
                            final int n6 = ++batch;
                            final int n7 = n2;
                            BytecodeManager.incBytecodes(9);
                            if (n6 >= n7) {
                                break;
                            }
                            final HoldingIntConsumer holdingIntConsumer3 = holdingIntConsumer;
                            BytecodeManager.incBytecodes(3);
                            tryAdvance2 = this.tryAdvance((IntConsumer)holdingIntConsumer3);
                            BytecodeManager.incBytecodes(1);
                        } while (tryAdvance2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n8 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n8 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final int[] array2 = array;
                        final int n9 = 0;
                        final int n10 = batch;
                        BytecodeManager.incBytecodes(7);
                        final int characteristics = this.characteristics();
                        BytecodeManager.incBytecodes(1);
                        final IntArraySpliterator intArraySpliterator = new IntArraySpliterator(array2, n9, n10, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return intArraySpliterator;
                    }
                }
                final Spliterator.OfInt ofInt = null;
                BytecodeManager.incBytecodes(2);
                return ofInt;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class HoldingIntConsumer implements IntConsumer
        {
            int value;
            
            HoldingIntConsumer() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final int value) {
                try {
                    this.value = value;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    public abstract static class AbstractLongSpliterator implements Spliterator.OfLong
    {
        static final int MAX_BATCH = 33554432;
        static final int BATCH_UNIT = 1024;
        private final int characteristics;
        private long est;
        private int batch;
        
        protected AbstractLongSpliterator(final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x40;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 != 0) {
                    characteristics = (n | 0x4000);
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong trySplit() {
            try {
                BytecodeManager.incBytecodes(3);
                final HoldingLongConsumer holdingLongConsumer = new HoldingLongConsumer();
                BytecodeManager.incBytecodes(1);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final HoldingLongConsumer holdingLongConsumer2 = holdingLongConsumer;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance = this.tryAdvance((LongConsumer)holdingLongConsumer2);
                    BytecodeManager.incBytecodes(1);
                    if (tryAdvance) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long[] array = new long[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean tryAdvance2;
                        do {
                            array[batch] = holdingLongConsumer.value;
                            final int n6 = ++batch;
                            final int n7 = n2;
                            BytecodeManager.incBytecodes(9);
                            if (n6 >= n7) {
                                break;
                            }
                            final HoldingLongConsumer holdingLongConsumer3 = holdingLongConsumer;
                            BytecodeManager.incBytecodes(3);
                            tryAdvance2 = this.tryAdvance((LongConsumer)holdingLongConsumer3);
                            BytecodeManager.incBytecodes(1);
                        } while (tryAdvance2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n8 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n8 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final long[] array2 = array;
                        final int n9 = 0;
                        final int n10 = batch;
                        BytecodeManager.incBytecodes(7);
                        final int characteristics = this.characteristics();
                        BytecodeManager.incBytecodes(1);
                        final LongArraySpliterator longArraySpliterator = new LongArraySpliterator(array2, n9, n10, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return longArraySpliterator;
                    }
                }
                final Spliterator.OfLong ofLong = null;
                BytecodeManager.incBytecodes(2);
                return ofLong;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class HoldingLongConsumer implements LongConsumer
        {
            long value;
            
            HoldingLongConsumer() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final long value) {
                try {
                    this.value = value;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    public abstract static class AbstractDoubleSpliterator implements Spliterator.OfDouble
    {
        static final int MAX_BATCH = 33554432;
        static final int BATCH_UNIT = 1024;
        private final int characteristics;
        private long est;
        private int batch;
        
        protected AbstractDoubleSpliterator(final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x40;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 != 0) {
                    characteristics = (n | 0x4000);
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble trySplit() {
            try {
                BytecodeManager.incBytecodes(3);
                final HoldingDoubleConsumer holdingDoubleConsumer = new HoldingDoubleConsumer();
                BytecodeManager.incBytecodes(1);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final HoldingDoubleConsumer holdingDoubleConsumer2 = holdingDoubleConsumer;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance = this.tryAdvance((DoubleConsumer)holdingDoubleConsumer2);
                    BytecodeManager.incBytecodes(1);
                    if (tryAdvance) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final double[] array = new double[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean tryAdvance2;
                        do {
                            array[batch] = holdingDoubleConsumer.value;
                            final int n6 = ++batch;
                            final int n7 = n2;
                            BytecodeManager.incBytecodes(9);
                            if (n6 >= n7) {
                                break;
                            }
                            final HoldingDoubleConsumer holdingDoubleConsumer3 = holdingDoubleConsumer;
                            BytecodeManager.incBytecodes(3);
                            tryAdvance2 = this.tryAdvance((DoubleConsumer)holdingDoubleConsumer3);
                            BytecodeManager.incBytecodes(1);
                        } while (tryAdvance2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n8 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n8 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final double[] array2 = array;
                        final int n9 = 0;
                        final int n10 = batch;
                        BytecodeManager.incBytecodes(7);
                        final int characteristics = this.characteristics();
                        BytecodeManager.incBytecodes(1);
                        final DoubleArraySpliterator doubleArraySpliterator = new DoubleArraySpliterator(array2, n9, n10, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return doubleArraySpliterator;
                    }
                }
                final Spliterator.OfDouble ofDouble = null;
                BytecodeManager.incBytecodes(2);
                return ofDouble;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class HoldingDoubleConsumer implements DoubleConsumer
        {
            double value;
            
            HoldingDoubleConsumer() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void accept(final double value) {
                try {
                    this.value = value;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static class IteratorSpliterator<T> implements Spliterator<T>
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private final Collection<? extends T> collection;
        private Iterator<? extends T> it;
        private final int characteristics;
        private long est;
        private int batch;
        
        public IteratorSpliterator(final Collection<? extends T> collection, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.collection = collection;
                BytecodeManager.incBytecodes(3);
                this.it = null;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x1000;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 == 0) {
                    characteristics = (n | 0x40 | 0x4000);
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public IteratorSpliterator(final Iterator<? extends T> it, final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.collection = null;
                BytecodeManager.incBytecodes(3);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x1000;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 == 0) {
                    characteristics = (n | 0x40 | 0x4000);
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public IteratorSpliterator(final Iterator<? extends T> it, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.collection = null;
                BytecodeManager.incBytecodes(3);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n & 0xFFFFBFBF);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<T> trySplit() {
            try {
                Iterator<? extends T> it;
                final Iterator<? extends T> iterator = it = this.it;
                BytecodeManager.incBytecodes(5);
                long est2;
                if (iterator == null) {
                    final Collection<? extends T> collection = this.collection;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<? extends T> iterator2 = collection.iterator();
                    this.it = iterator2;
                    it = iterator2;
                    BytecodeManager.incBytecodes(3);
                    final Collection<? extends T> collection2 = this.collection;
                    BytecodeManager.incBytecodes(4);
                    final long est = collection2.size();
                    this.est = est;
                    est2 = est;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    est2 = this.est;
                    BytecodeManager.incBytecodes(3);
                }
                final long n = lcmp(est2, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final Iterator<? extends T> iterator3 = it;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator3.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est2);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est2;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final Object[] array = new Object[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean hasNext2;
                        do {
                            final Object[] array2 = array;
                            final int n6 = batch;
                            final Iterator<? extends T> iterator4 = it;
                            BytecodeManager.incBytecodes(4);
                            array2[n6] = iterator4.next();
                            final int n7 = ++batch;
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 >= n8) {
                                break;
                            }
                            final Iterator<? extends T> iterator5 = it;
                            BytecodeManager.incBytecodes(2);
                            hasNext2 = iterator5.hasNext();
                            BytecodeManager.incBytecodes(1);
                        } while (hasNext2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n9 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n9 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final Object[] array3 = array;
                        final int n10 = 0;
                        final int n11 = batch;
                        final int characteristics = this.characteristics;
                        BytecodeManager.incBytecodes(8);
                        final ArraySpliterator arraySpliterator = new ArraySpliterator<T>(array3, n10, n11, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<T>)arraySpliterator;
                    }
                }
                final Spliterator<T> spliterator = null;
                BytecodeManager.incBytecodes(2);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super T> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                Iterator<? extends T> it = this.it;
                BytecodeManager.incBytecodes(5);
                if (it == null) {
                    final Collection<? extends T> collection = this.collection;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<? extends T> iterator = collection.iterator();
                    this.it = iterator;
                    it = iterator;
                    BytecodeManager.incBytecodes(3);
                    final Collection<? extends T> collection2 = this.collection;
                    BytecodeManager.incBytecodes(4);
                    this.est = collection2.size();
                    BytecodeManager.incBytecodes(2);
                }
                final Iterator<? extends T> iterator2 = it;
                BytecodeManager.incBytecodes(3);
                iterator2.forEachRemaining((Consumer)consumer);
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
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Iterator<? extends T> it = this.it;
                BytecodeManager.incBytecodes(3);
                if (it == null) {
                    final Collection<? extends T> collection = this.collection;
                    BytecodeManager.incBytecodes(4);
                    this.it = collection.iterator();
                    BytecodeManager.incBytecodes(1);
                    final Collection<? extends T> collection2 = this.collection;
                    BytecodeManager.incBytecodes(4);
                    this.est = collection2.size();
                    BytecodeManager.incBytecodes(2);
                }
                final Iterator<? extends T> it2 = this.it;
                BytecodeManager.incBytecodes(3);
                final boolean hasNext = it2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (hasNext) {
                    final Iterator<? extends T> it3 = this.it;
                    BytecodeManager.incBytecodes(4);
                    final T next = (T)it3.next();
                    BytecodeManager.incBytecodes(1);
                    consumer.accept(next);
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
        public long estimateSize() {
            try {
                final Iterator<? extends T> it = this.it;
                BytecodeManager.incBytecodes(3);
                if (it == null) {
                    final Collection<? extends T> collection = this.collection;
                    BytecodeManager.incBytecodes(4);
                    this.it = collection.iterator();
                    BytecodeManager.incBytecodes(1);
                    final Collection<? extends T> collection2 = this.collection;
                    BytecodeManager.incBytecodes(4);
                    final long est = collection2.size();
                    this.est = est;
                    BytecodeManager.incBytecodes(4);
                    return est;
                }
                final long est2 = this.est;
                BytecodeManager.incBytecodes(3);
                return est2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super T> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super T> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class IntIteratorSpliterator implements Spliterator.OfInt
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private PrimitiveIterator.OfInt it;
        private final int characteristics;
        private long est;
        private int batch;
        
        public IntIteratorSpliterator(final PrimitiveIterator.OfInt it, final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x1000;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 == 0) {
                    characteristics = (n | 0x40 | 0x4000);
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public IntIteratorSpliterator(final PrimitiveIterator.OfInt it, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n & 0xFFFFBFBF);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfInt trySplit() {
            try {
                final PrimitiveIterator.OfInt it = this.it;
                BytecodeManager.incBytecodes(3);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final PrimitiveIterator.OfInt ofInt = it;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = ofInt.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final int[] array = new int[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean hasNext2;
                        do {
                            final int[] array2 = array;
                            final int n6 = batch;
                            final PrimitiveIterator.OfInt ofInt2 = it;
                            BytecodeManager.incBytecodes(4);
                            array2[n6] = ofInt2.nextInt();
                            final int n7 = ++batch;
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 >= n8) {
                                break;
                            }
                            final PrimitiveIterator.OfInt ofInt3 = it;
                            BytecodeManager.incBytecodes(2);
                            hasNext2 = ofInt3.hasNext();
                            BytecodeManager.incBytecodes(1);
                        } while (hasNext2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n9 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n9 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final int[] array3 = array;
                        final int n10 = 0;
                        final int n11 = batch;
                        final int characteristics = this.characteristics;
                        BytecodeManager.incBytecodes(8);
                        final IntArraySpliterator intArraySpliterator = new IntArraySpliterator(array3, n10, n11, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return intArraySpliterator;
                    }
                }
                final Spliterator.OfInt ofInt4 = null;
                BytecodeManager.incBytecodes(2);
                return ofInt4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final IntConsumer intConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfInt it = this.it;
                BytecodeManager.incBytecodes(4);
                it.forEachRemaining(intConsumer);
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
                if (intConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfInt it = this.it;
                BytecodeManager.incBytecodes(3);
                final boolean hasNext = it.hasNext();
                BytecodeManager.incBytecodes(1);
                if (hasNext) {
                    final PrimitiveIterator.OfInt it2 = this.it;
                    BytecodeManager.incBytecodes(4);
                    final int nextInt = it2.nextInt();
                    BytecodeManager.incBytecodes(1);
                    intConsumer.accept(nextInt);
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
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Integer> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Integer> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class LongIteratorSpliterator implements Spliterator.OfLong
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private PrimitiveIterator.OfLong it;
        private final int characteristics;
        private long est;
        private int batch;
        
        public LongIteratorSpliterator(final PrimitiveIterator.OfLong it, final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x1000;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 == 0) {
                    characteristics = (n | 0x40 | 0x4000);
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public LongIteratorSpliterator(final PrimitiveIterator.OfLong it, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n & 0xFFFFBFBF);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfLong trySplit() {
            try {
                final PrimitiveIterator.OfLong it = this.it;
                BytecodeManager.incBytecodes(3);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final PrimitiveIterator.OfLong ofLong = it;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = ofLong.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final long[] array = new long[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean hasNext2;
                        do {
                            final long[] array2 = array;
                            final int n6 = batch;
                            final PrimitiveIterator.OfLong ofLong2 = it;
                            BytecodeManager.incBytecodes(4);
                            array2[n6] = ofLong2.nextLong();
                            final int n7 = ++batch;
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 >= n8) {
                                break;
                            }
                            final PrimitiveIterator.OfLong ofLong3 = it;
                            BytecodeManager.incBytecodes(2);
                            hasNext2 = ofLong3.hasNext();
                            BytecodeManager.incBytecodes(1);
                        } while (hasNext2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n9 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n9 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final long[] array3 = array;
                        final int n10 = 0;
                        final int n11 = batch;
                        final int characteristics = this.characteristics;
                        BytecodeManager.incBytecodes(8);
                        final LongArraySpliterator longArraySpliterator = new LongArraySpliterator(array3, n10, n11, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return longArraySpliterator;
                    }
                }
                final Spliterator.OfLong ofLong4 = null;
                BytecodeManager.incBytecodes(2);
                return ofLong4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final LongConsumer longConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfLong it = this.it;
                BytecodeManager.incBytecodes(4);
                it.forEachRemaining(longConsumer);
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
                if (longConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfLong it = this.it;
                BytecodeManager.incBytecodes(3);
                final boolean hasNext = it.hasNext();
                BytecodeManager.incBytecodes(1);
                if (hasNext) {
                    final PrimitiveIterator.OfLong it2 = this.it;
                    BytecodeManager.incBytecodes(4);
                    final long nextLong = it2.nextLong();
                    BytecodeManager.incBytecodes(1);
                    longConsumer.accept(nextLong);
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
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Long> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Long> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
    
    static final class DoubleIteratorSpliterator implements Spliterator.OfDouble
    {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private PrimitiveIterator.OfDouble it;
        private final int characteristics;
        private long est;
        private int batch;
        
        public DoubleIteratorSpliterator(final PrimitiveIterator.OfDouble it, final long est, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                final int n2 = n & 0x1000;
                BytecodeManager.incBytecodes(5);
                int characteristics;
                if (n2 == 0) {
                    characteristics = (n | 0x40 | 0x4000);
                    BytecodeManager.incBytecodes(6);
                }
                else {
                    characteristics = n;
                    BytecodeManager.incBytecodes(1);
                }
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public DoubleIteratorSpliterator(final PrimitiveIterator.OfDouble it, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.it = it;
                BytecodeManager.incBytecodes(3);
                this.est = Long.MAX_VALUE;
                BytecodeManager.incBytecodes(3);
                this.characteristics = (n & 0xFFFFBFBF);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator.OfDouble trySplit() {
            try {
                final PrimitiveIterator.OfDouble it = this.it;
                BytecodeManager.incBytecodes(3);
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                final long n = lcmp(est, 1L);
                BytecodeManager.incBytecodes(4);
                if (n > 0) {
                    final PrimitiveIterator.OfDouble ofDouble = it;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = ofDouble.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        int n2 = this.batch + 1024;
                        BytecodeManager.incBytecodes(5);
                        final long n3 = lcmp((long)n2, est);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            n2 = (int)est;
                            BytecodeManager.incBytecodes(3);
                        }
                        final int n4 = n2;
                        final int n5 = 33554432;
                        BytecodeManager.incBytecodes(3);
                        if (n4 > n5) {
                            n2 = 33554432;
                            BytecodeManager.incBytecodes(2);
                        }
                        final double[] array = new double[n2];
                        BytecodeManager.incBytecodes(2);
                        int batch = 0;
                        BytecodeManager.incBytecodes(2);
                        boolean hasNext2;
                        do {
                            final double[] array2 = array;
                            final int n6 = batch;
                            final PrimitiveIterator.OfDouble ofDouble2 = it;
                            BytecodeManager.incBytecodes(4);
                            array2[n6] = ofDouble2.nextDouble();
                            final int n7 = ++batch;
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 >= n8) {
                                break;
                            }
                            final PrimitiveIterator.OfDouble ofDouble3 = it;
                            BytecodeManager.incBytecodes(2);
                            hasNext2 = ofDouble3.hasNext();
                            BytecodeManager.incBytecodes(1);
                        } while (hasNext2);
                        this.batch = batch;
                        BytecodeManager.incBytecodes(3);
                        final long n9 = lcmp(this.est, Long.MAX_VALUE);
                        BytecodeManager.incBytecodes(5);
                        if (n9 != 0) {
                            this.est -= batch;
                            BytecodeManager.incBytecodes(7);
                        }
                        final double[] array3 = array;
                        final int n10 = 0;
                        final int n11 = batch;
                        final int characteristics = this.characteristics;
                        BytecodeManager.incBytecodes(8);
                        final DoubleArraySpliterator doubleArraySpliterator = new DoubleArraySpliterator(array3, n10, n11, characteristics);
                        BytecodeManager.incBytecodes(1);
                        return doubleArraySpliterator;
                    }
                }
                final Spliterator.OfDouble ofDouble4 = null;
                BytecodeManager.incBytecodes(2);
                return ofDouble4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final DoubleConsumer doubleConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfDouble it = this.it;
                BytecodeManager.incBytecodes(4);
                it.forEachRemaining(doubleConsumer);
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
                if (doubleConsumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final PrimitiveIterator.OfDouble it = this.it;
                BytecodeManager.incBytecodes(3);
                final boolean hasNext = it.hasNext();
                BytecodeManager.incBytecodes(1);
                if (hasNext) {
                    final PrimitiveIterator.OfDouble it2 = this.it;
                    BytecodeManager.incBytecodes(4);
                    final double nextDouble = it2.nextDouble();
                    BytecodeManager.incBytecodes(1);
                    doubleConsumer.accept(nextDouble);
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
        public long estimateSize() {
            try {
                final long est = this.est;
                BytecodeManager.incBytecodes(3);
                return est;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super Double> getComparator() {
            try {
                final int n = 4;
                BytecodeManager.incBytecodes(3);
                final boolean hasCharacteristics = this.hasCharacteristics(n);
                BytecodeManager.incBytecodes(1);
                if (hasCharacteristics) {
                    final Comparator<? super Double> comparator = null;
                    BytecodeManager.incBytecodes(2);
                    return comparator;
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
    }
}
