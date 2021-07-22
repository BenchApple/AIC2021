// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.lang.invoke.SerializedLambda;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.function.Function;
import java.io.Serializable;
import aic2021.engine.BytecodeManager;

@FunctionalInterface
public interface Comparator<T>
{
    int compare(final T p0, final T p1);
    
    boolean equals(final Object p0);
    
    default Comparator<T> reversed() {
        try {
            BytecodeManager.incBytecodes(2);
            final Comparator<T> reverseOrder = Collections.reverseOrder(this);
            BytecodeManager.incBytecodes(1);
            return reverseOrder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Comparator<T> thenComparing(final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(comparator);
            BytecodeManager.incBytecodes(1);
            final Object o;
            int compare = 0;
            final Comparator comparator2 = (t, t2) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    this.compare(t, t2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    if (o != 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(4);
                        compare = comparator.compare((Object)t, (Object)t2);
                    }
                    BytecodeManager.incBytecodes(1);
                    return compare;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(5);
            return comparator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <U> Comparator<T> thenComparing(final Function<? super T, ? extends U> function, final Comparator<? super U> comparator) {
        try {
            BytecodeManager.incBytecodes(4);
            final Comparator<Object> comparing = comparing((Function<? super Object, ?>)function, (Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            final Comparator<T> thenComparing = this.thenComparing(comparing);
            BytecodeManager.incBytecodes(1);
            return thenComparing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <U extends Comparable<? super U>> Comparator<T> thenComparing(final Function<? super T, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(3);
            final Comparator<Object> comparing = comparing((Function<? super Object, ? extends Comparable>)function);
            BytecodeManager.incBytecodes(1);
            final Comparator<T> thenComparing = this.thenComparing(comparing);
            BytecodeManager.incBytecodes(1);
            return thenComparing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Comparator<T> thenComparingInt(final ToIntFunction<? super T> toIntFunction) {
        try {
            BytecodeManager.incBytecodes(3);
            final Comparator<Object> comparingInt = comparingInt((ToIntFunction<? super Object>)toIntFunction);
            BytecodeManager.incBytecodes(1);
            final Comparator<T> thenComparing = this.thenComparing(comparingInt);
            BytecodeManager.incBytecodes(1);
            return thenComparing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Comparator<T> thenComparingLong(final ToLongFunction<? super T> toLongFunction) {
        try {
            BytecodeManager.incBytecodes(3);
            final Comparator<Object> comparingLong = comparingLong((ToLongFunction<? super Object>)toLongFunction);
            BytecodeManager.incBytecodes(1);
            final Comparator<T> thenComparing = this.thenComparing(comparingLong);
            BytecodeManager.incBytecodes(1);
            return thenComparing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default Comparator<T> thenComparingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(3);
            final Comparator<Object> comparingDouble = comparingDouble((ToDoubleFunction<? super Object>)toDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final Comparator<T> thenComparing = this.thenComparing(comparingDouble);
            BytecodeManager.incBytecodes(1);
            return thenComparing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        try {
            BytecodeManager.incBytecodes(1);
            final Comparator<T> reverseOrder = Collections.reverseOrder();
            BytecodeManager.incBytecodes(1);
            return reverseOrder;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        try {
            final Comparators.NaturalOrderComparator instance = Comparators.NaturalOrderComparator.INSTANCE;
            BytecodeManager.incBytecodes(2);
            return (Comparator<T>)instance;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(5);
            final Comparators.NullComparator nullComparator = new Comparators.NullComparator<T>(b, comparator);
            BytecodeManager.incBytecodes(1);
            return (Comparator<T>)nullComparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(5);
            final Comparators.NullComparator nullComparator = new Comparators.NullComparator<T>(b, comparator);
            BytecodeManager.incBytecodes(1);
            return (Comparator<T>)nullComparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T, U> Comparator<T> comparing(final Function<? super T, ? extends U> function, final Comparator<? super U> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(comparator);
            BytecodeManager.incBytecodes(1);
            final U u;
            final U u2;
            final int n;
            final Comparator comparator2 = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    function.apply((Object)o);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    function.apply((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    comparator.compare(u, u2);
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(5);
            return (Comparator<T>)comparator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T, U extends Comparable<? super U>> Comparator<T> comparing(final Function<? super T, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            Comparable comparable;
            final U u;
            final int n;
            final Comparator comparator = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    comparable = (Comparable)function.apply((Object)o);
                    BytecodeManager.incBytecodes(4);
                    function.apply((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    comparable.compareTo(u);
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            return (Comparator<T>)comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Comparator<T> comparingInt(final ToIntFunction<? super T> toIntFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toIntFunction);
            BytecodeManager.incBytecodes(1);
            final int x;
            final int y;
            final int n;
            final Comparator comparator = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    toIntFunction.applyAsInt((Object)o);
                    BytecodeManager.incBytecodes(3);
                    toIntFunction.applyAsInt((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    Integer.compare(x, y);
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            return (Comparator<T>)comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Comparator<T> comparingLong(final ToLongFunction<? super T> toLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toLongFunction);
            BytecodeManager.incBytecodes(1);
            final long x;
            final long y;
            final int n;
            final Comparator comparator = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    toLongFunction.applyAsLong((Object)o);
                    BytecodeManager.incBytecodes(3);
                    toLongFunction.applyAsLong((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    Long.compare(x, y);
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            return (Comparator<T>)comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T> Comparator<T> comparingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(toDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final double d1;
            final double d2;
            final int n;
            final Comparator comparator = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(3);
                    toDoubleFunction.applyAsDouble((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    Double.compare(d1, d2);
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            return (Comparator<T>)comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
