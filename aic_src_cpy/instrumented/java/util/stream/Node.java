// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.function.DoubleConsumer;
import instrumented.java.util.function.LongConsumer;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.function.IntFunction;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.Spliterator;

interface Node<T>
{
    Spliterator<T> spliterator();
    
    void forEach(final Consumer<? super T> p0);
    
    default int getChildCount() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Node<T> getChild(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Node<T> truncate(final long n, final long n2, final IntFunction<T[]> intFunction) {
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
            BytecodeManager.incBytecodes(2);
            final Spliterator<T> spliterator = this.spliterator();
            BytecodeManager.incBytecodes(1);
            final long n5 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final long n6 = n5;
            BytecodeManager.incBytecodes(3);
            final Builder<T> builder = Nodes.builder(n6, intFunction);
            BytecodeManager.incBytecodes(1);
            final Builder<T> builder2 = builder;
            final long n7 = n5;
            BytecodeManager.incBytecodes(3);
            builder2.begin(n7);
            int n8 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final long n9 = lcmp((long)n8, n);
                BytecodeManager.incBytecodes(5);
                if (n9 >= 0) {
                    break;
                }
                final Spliterator<T> spliterator2 = spliterator;
                final Consumer<? super T> consumer = p0 -> {
                    try {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(2);
                final boolean tryAdvance = spliterator2.tryAdvance(consumer);
                BytecodeManager.incBytecodes(1);
                if (!tryAdvance) {
                    break;
                }
                ++n8;
                BytecodeManager.incBytecodes(2);
            }
            int n10 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final long n11 = lcmp((long)n10, n5);
                BytecodeManager.incBytecodes(5);
                if (n11 >= 0) {
                    break;
                }
                final Spliterator<T> spliterator3 = spliterator;
                final Builder<T> builder3 = builder;
                BytecodeManager.incBytecodes(3);
                final boolean tryAdvance2 = spliterator3.tryAdvance(builder3);
                BytecodeManager.incBytecodes(1);
                if (!tryAdvance2) {
                    break;
                }
                ++n10;
                BytecodeManager.incBytecodes(2);
            }
            final Builder<T> builder4 = builder;
            BytecodeManager.incBytecodes(2);
            builder4.end();
            final Builder<T> builder5 = builder;
            BytecodeManager.incBytecodes(2);
            final Node<T> build = builder5.build();
            BytecodeManager.incBytecodes(1);
            return build;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    T[] asArray(final IntFunction<T[]> p0);
    
    void copyInto(final T[] p0, final int p1);
    
    default StreamShape getShape() {
        try {
            final StreamShape reference = StreamShape.REFERENCE;
            BytecodeManager.incBytecodes(2);
            return reference;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    long count();
    
    public interface OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends Node<T>
    {
        T_SPLITR spliterator();
        
        void forEach(final T_CONS p0);
        
        default T_NODE getChild(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        T_NODE truncate(final long p0, final long p1, final IntFunction<T[]> p2);
        
        default T[] asArray(final IntFunction<T[]> intFunction) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfPrimitive> class1 = this.getClass();
                    final String s = "{0} calling Node.OfPrimitive.asArray";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final long count = this.count();
                BytecodeManager.incBytecodes(1);
                final long n = lcmp(count, 2147483639L);
                BytecodeManager.incBytecodes(4);
                if (n >= 0) {
                    final String s2 = "Stream size exceeds max array size";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(3);
                final int n2 = (int)this.count();
                BytecodeManager.incBytecodes(2);
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
        
        T_ARR asPrimitiveArray();
        
        T_ARR newArray(final int p0);
        
        void copyInto(final T_ARR p0, final int p1);
    }
    
    public interface OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, OfInt>
    {
        default void forEach(final Consumer<? super Integer> consumer) {
            try {
                final boolean b = consumer instanceof IntConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final IntConsumer intConsumer = (IntConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<T, IntConsumer, T_ARR, T_SPLITR, T_NODE>)this).forEach(intConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfInt> class1 = this.getClass();
                        final String s = "{0} calling Node.OfInt.forEachRemaining(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfInt ofInt = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfInt, T_NODE>)this).spliterator();
                    BytecodeManager.incBytecodes(3);
                    ofInt.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void copyInto(final Integer[] array, final int n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfInt> class1 = this.getClass();
                    final String s = "{0} calling Node.OfInt.copyInto(Integer[], int)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final int[] array2 = ((OfPrimitive<T, T_CONS, int[], T_SPLITR, T_NODE>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final int n4 = n + n2;
                    final int i = array2[n2];
                    BytecodeManager.incBytecodes(8);
                    array[n4] = i;
                    BytecodeManager.incBytecodes(1);
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default OfInt truncate(final long n, final long n2, final IntFunction<Integer[]> intFunction) {
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
                final long n5 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfInt ofInt = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfInt, T_NODE>)this).spliterator();
                BytecodeManager.incBytecodes(2);
                final long n6 = n5;
                BytecodeManager.incBytecodes(2);
                final Builder.OfInt intBuilder = Nodes.intBuilder(n6);
                BytecodeManager.incBytecodes(1);
                final Builder.OfInt ofInt2 = intBuilder;
                final long n7 = n5;
                BytecodeManager.incBytecodes(3);
                ofInt2.begin(n7);
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n9 = lcmp((long)n8, n);
                    BytecodeManager.incBytecodes(5);
                    if (n9 >= 0) {
                        break;
                    }
                    final Spliterator.OfInt ofInt3 = ofInt;
                    final IntConsumer intConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(2);
                    final boolean tryAdvance = ofInt3.tryAdvance(intConsumer);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance) {
                        break;
                    }
                    ++n8;
                    BytecodeManager.incBytecodes(2);
                }
                int n10 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n11 = lcmp((long)n10, n5);
                    BytecodeManager.incBytecodes(5);
                    if (n11 >= 0) {
                        break;
                    }
                    final Spliterator.OfInt ofInt4 = ofInt;
                    final Builder.OfInt ofInt5 = intBuilder;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance2 = ofInt4.tryAdvance((IntConsumer)ofInt5);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance2) {
                        break;
                    }
                    ++n10;
                    BytecodeManager.incBytecodes(2);
                }
                final Builder.OfInt ofInt6 = intBuilder;
                BytecodeManager.incBytecodes(2);
                ofInt6.end();
                final Builder.OfInt ofInt7 = intBuilder;
                BytecodeManager.incBytecodes(2);
                final OfInt build = ofInt7.build();
                BytecodeManager.incBytecodes(1);
                return build;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default int[] newArray(final int n) {
            try {
                final int[] array = new int[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default StreamShape getShape() {
            try {
                final StreamShape int_VALUE = StreamShape.INT_VALUE;
                BytecodeManager.incBytecodes(2);
                return int_VALUE;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, OfLong>
    {
        default void forEach(final Consumer<? super Long> consumer) {
            try {
                final boolean b = consumer instanceof LongConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final LongConsumer longConsumer = (LongConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<T, LongConsumer, T_ARR, T_SPLITR, T_NODE>)this).forEach(longConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfLong> class1 = this.getClass();
                        final String s = "{0} calling Node.OfLong.forEachRemaining(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfLong ofLong = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfLong, T_NODE>)this).spliterator();
                    BytecodeManager.incBytecodes(3);
                    ofLong.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void copyInto(final Long[] array, final int n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfLong> class1 = this.getClass();
                    final String s = "{0} calling Node.OfInt.copyInto(Long[], int)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final long[] array2 = ((OfPrimitive<T, T_CONS, long[], T_SPLITR, T_NODE>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final int n4 = n + n2;
                    final long l = array2[n2];
                    BytecodeManager.incBytecodes(8);
                    array[n4] = l;
                    BytecodeManager.incBytecodes(1);
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default OfLong truncate(final long n, final long n2, final IntFunction<Long[]> intFunction) {
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
                final long n5 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfLong ofLong = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfLong, T_NODE>)this).spliterator();
                BytecodeManager.incBytecodes(2);
                final long n6 = n5;
                BytecodeManager.incBytecodes(2);
                final Builder.OfLong longBuilder = Nodes.longBuilder(n6);
                BytecodeManager.incBytecodes(1);
                final Builder.OfLong ofLong2 = longBuilder;
                final long n7 = n5;
                BytecodeManager.incBytecodes(3);
                ofLong2.begin(n7);
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n9 = lcmp((long)n8, n);
                    BytecodeManager.incBytecodes(5);
                    if (n9 >= 0) {
                        break;
                    }
                    final Spliterator.OfLong ofLong3 = ofLong;
                    final LongConsumer longConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(2);
                    final boolean tryAdvance = ofLong3.tryAdvance(longConsumer);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance) {
                        break;
                    }
                    ++n8;
                    BytecodeManager.incBytecodes(2);
                }
                int n10 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n11 = lcmp((long)n10, n5);
                    BytecodeManager.incBytecodes(5);
                    if (n11 >= 0) {
                        break;
                    }
                    final Spliterator.OfLong ofLong4 = ofLong;
                    final Builder.OfLong ofLong5 = longBuilder;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance2 = ofLong4.tryAdvance((LongConsumer)ofLong5);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance2) {
                        break;
                    }
                    ++n10;
                    BytecodeManager.incBytecodes(2);
                }
                final Builder.OfLong ofLong6 = longBuilder;
                BytecodeManager.incBytecodes(2);
                ofLong6.end();
                final Builder.OfLong ofLong7 = longBuilder;
                BytecodeManager.incBytecodes(2);
                final OfLong build = ofLong7.build();
                BytecodeManager.incBytecodes(1);
                return build;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default long[] newArray(final int n) {
            try {
                final long[] array = new long[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default StreamShape getShape() {
            try {
                final StreamShape long_VALUE = StreamShape.LONG_VALUE;
                BytecodeManager.incBytecodes(2);
                return long_VALUE;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, OfDouble>
    {
        default void forEach(final Consumer<? super Double> consumer) {
            try {
                final boolean b = consumer instanceof DoubleConsumer;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final DoubleConsumer doubleConsumer = (DoubleConsumer)consumer;
                    BytecodeManager.incBytecodes(4);
                    ((OfPrimitive<T, DoubleConsumer, T_ARR, T_SPLITR, T_NODE>)this).forEach(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean enabled = Tripwire.ENABLED;
                    BytecodeManager.incBytecodes(2);
                    if (enabled) {
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends OfDouble> class1 = this.getClass();
                        final String s = "{0} calling Node.OfLong.forEachRemaining(Consumer)";
                        BytecodeManager.incBytecodes(2);
                        Tripwire.trip(class1, s);
                    }
                    BytecodeManager.incBytecodes(2);
                    final Spliterator.OfDouble ofDouble = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfDouble, T_NODE>)this).spliterator();
                    BytecodeManager.incBytecodes(3);
                    ofDouble.forEachRemaining(consumer);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default void copyInto(final Double[] array, final int n) {
            try {
                final boolean enabled = Tripwire.ENABLED;
                BytecodeManager.incBytecodes(2);
                if (enabled) {
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends OfDouble> class1 = this.getClass();
                    final String s = "{0} calling Node.OfDouble.copyInto(Double[], int)";
                    BytecodeManager.incBytecodes(2);
                    Tripwire.trip(class1, s);
                }
                BytecodeManager.incBytecodes(2);
                final double[] array2 = ((OfPrimitive<T, T_CONS, double[], T_SPLITR, T_NODE>)this).asPrimitiveArray();
                BytecodeManager.incBytecodes(2);
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = array2.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final int n4 = n + n2;
                    final double d = array2[n2];
                    BytecodeManager.incBytecodes(8);
                    array[n4] = d;
                    BytecodeManager.incBytecodes(1);
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default OfDouble truncate(final long n, final long n2, final IntFunction<Double[]> intFunction) {
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
                final long n5 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(2);
                final Spliterator.OfDouble ofDouble = ((OfPrimitive<T, T_CONS, T_ARR, Spliterator.OfDouble, T_NODE>)this).spliterator();
                BytecodeManager.incBytecodes(2);
                final long n6 = n5;
                BytecodeManager.incBytecodes(2);
                final Builder.OfDouble doubleBuilder = Nodes.doubleBuilder(n6);
                BytecodeManager.incBytecodes(1);
                final Builder.OfDouble ofDouble2 = doubleBuilder;
                final long n7 = n5;
                BytecodeManager.incBytecodes(3);
                ofDouble2.begin(n7);
                int n8 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n9 = lcmp((long)n8, n);
                    BytecodeManager.incBytecodes(5);
                    if (n9 >= 0) {
                        break;
                    }
                    final Spliterator.OfDouble ofDouble3 = ofDouble;
                    final DoubleConsumer doubleConsumer = p0 -> {
                        try {
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(2);
                    final boolean tryAdvance = ofDouble3.tryAdvance(doubleConsumer);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance) {
                        break;
                    }
                    ++n8;
                    BytecodeManager.incBytecodes(2);
                }
                int n10 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final long n11 = lcmp((long)n10, n5);
                    BytecodeManager.incBytecodes(5);
                    if (n11 >= 0) {
                        break;
                    }
                    final Spliterator.OfDouble ofDouble4 = ofDouble;
                    final Builder.OfDouble ofDouble5 = doubleBuilder;
                    BytecodeManager.incBytecodes(3);
                    final boolean tryAdvance2 = ofDouble4.tryAdvance((DoubleConsumer)ofDouble5);
                    BytecodeManager.incBytecodes(1);
                    if (!tryAdvance2) {
                        break;
                    }
                    ++n10;
                    BytecodeManager.incBytecodes(2);
                }
                final Builder.OfDouble ofDouble6 = doubleBuilder;
                BytecodeManager.incBytecodes(2);
                ofDouble6.end();
                final Builder.OfDouble ofDouble7 = doubleBuilder;
                BytecodeManager.incBytecodes(2);
                final OfDouble build = ofDouble7.build();
                BytecodeManager.incBytecodes(1);
                return build;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default double[] newArray(final int n) {
            try {
                final double[] array = new double[n];
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default StreamShape getShape() {
            try {
                final StreamShape double_VALUE = StreamShape.DOUBLE_VALUE;
                BytecodeManager.incBytecodes(2);
                return double_VALUE;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public interface Builder<T> extends Sink<T>
    {
        Node<T> build();
        
        public interface OfInt extends Builder<Integer>, Sink.OfInt
        {
            Node.OfInt build();
        }
        
        public interface OfLong extends Builder<Long>, Sink.OfLong
        {
            Node.OfLong build();
        }
        
        public interface OfDouble extends Builder<Double>, Sink.OfDouble
        {
            Node.OfDouble build();
        }
    }
}
