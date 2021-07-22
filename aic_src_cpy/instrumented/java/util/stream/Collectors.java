// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Arrays;
import instrumented.java.util.AbstractSet;
import instrumented.java.util.AbstractMap;
import java.util.Iterator;
import instrumented.java.util.DoubleSummaryStatistics;
import instrumented.java.util.LongSummaryStatistics;
import instrumented.java.util.IntSummaryStatistics;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import instrumented.java.util.concurrent.ConcurrentMap;
import instrumented.java.util.Objects;
import instrumented.java.util.HashMap;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.ToDoubleFunction;
import instrumented.java.util.function.ToLongFunction;
import instrumented.java.util.function.ToIntFunction;
import instrumented.java.util.Optional;
import instrumented.java.util.Comparator;
import instrumented.java.util.Collections;
import instrumented.java.util.EnumSet;
import instrumented.java.util.Map;
import instrumented.java.util.StringJoiner;
import instrumented.java.util.HashSet;
import instrumented.java.util.ArrayList;
import instrumented.java.util.List;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.Collection;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BinaryOperator;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Set;

public final class Collectors
{
    static final Set<Collector.Characteristics> CH_CONCURRENT_ID;
    static final Set<Collector.Characteristics> CH_CONCURRENT_NOID;
    static final Set<Collector.Characteristics> CH_ID;
    static final Set<Collector.Characteristics> CH_UNORDERED_ID;
    static final Set<Collector.Characteristics> CH_NOID;
    
    private Collectors() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> BinaryOperator<T> throwingMerger() {
        try {
            Object[] args;
            final String format;
            final Object o2;
            final String s;
            final BinaryOperator<T> binaryOperator = (o, p1) -> {
                try {
                    // new(java.lang.IllegalStateException.class)
                    args = new Object[] { o };
                    BytecodeManager.incBytecodes(9);
                    String.format(format, args);
                    BytecodeManager.incBytecodes(1);
                    new IllegalStateException(s);
                    BytecodeManager.incBytecodes(1);
                    throw o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return binaryOperator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <I, R> Function<I, R> castingIdentity() {
        try {
            final Function<Object, Object> function = o -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(1);
            return (Function<I, R>)function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(final Supplier<C> supplier) {
        try {
            final BiConsumer<Object, Object> biConsumer = Collection::add;
            final BinaryOperator<Object> binaryOperator = (collection, collection2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    collection.addAll(collection2);
                    BytecodeManager.incBytecodes(3);
                    return collection;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, C>(supplier, biConsumer, binaryOperator, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, C>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, List<T>> toList() {
        try {
            final Supplier<ArrayList> supplier = ArrayList::new;
            final BiConsumer<?, T> biConsumer = List::add;
            final BinaryOperator<Object> binaryOperator = (list, list2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    list.addAll(list2);
                    BytecodeManager.incBytecodes(3);
                    return list;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(4);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, List<T>>(supplier, biConsumer, binaryOperator, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, List<T>>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Set<T>> toSet() {
        try {
            final Supplier<HashSet> supplier = HashSet::new;
            final BiConsumer<?, T> biConsumer = Set::add;
            final BinaryOperator<Object> binaryOperator = (set, set2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    set.addAll(set2);
                    BytecodeManager.incBytecodes(3);
                    return set;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_UNORDERED_ID = Collectors.CH_UNORDERED_ID;
            BytecodeManager.incBytecodes(4);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Set<T>>(supplier, biConsumer, binaryOperator, ch_UNORDERED_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Set<T>>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Collector<CharSequence, ?, String> joining() {
        try {
            final Supplier<StringBuilder> supplier = StringBuilder::new;
            final BiConsumer<?, CharSequence> biConsumer = StringBuilder::append;
            final BinaryOperator<Object> binaryOperator = (sb, s) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    sb.append((CharSequence)s);
                    BytecodeManager.incBytecodes(3);
                    return sb;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Function<?, String> function = StringBuilder::toString;
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(4);
            final CollectorImpl collectorImpl = new CollectorImpl<CharSequence, Object, String>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<CharSequence, ?, String>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Collector<CharSequence, ?, String> joining(final CharSequence charSequence) {
        try {
            final String s = "";
            final String s2 = "";
            BytecodeManager.incBytecodes(4);
            final Collector<CharSequence, ?, String> joining = joining(charSequence, s, s2);
            BytecodeManager.incBytecodes(1);
            return joining;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Collector<CharSequence, ?, String> joining(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3) {
        try {
            final Object o;
            final Supplier<Object> supplier = () -> {
                try {
                    // new(instrumented.java.util.StringJoiner.class)
                    BytecodeManager.incBytecodes(6);
                    new StringJoiner(charSequence, charSequence2, charSequence3);
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BiConsumer<?, CharSequence> biConsumer = StringJoiner::add;
            final BinaryOperator<Object> binaryOperator = StringJoiner::merge;
            final Function<?, String> function = StringJoiner::toString;
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(7);
            final CollectorImpl collectorImpl = new CollectorImpl<CharSequence, Object, String>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<CharSequence, ?, String>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V, M extends Map<K, V>> BinaryOperator<M> mapMerger(final BinaryOperator<V> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokedynamic   BootstrapMethod #18, apply:(Linstrumented/java/util/function/BinaryOperator;)Linstrumented/java/util/function/BinaryOperator;
        //     6: ldc             2
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: areturn        
        //    12: athrow         
        //    Signature:
        //  <K:Ljava/lang/Object;V:Ljava/lang/Object;M::Linstrumented/java/util/Map<TK;TV;>;>(Linstrumented/java/util/function/BinaryOperator<TV;>;)Linstrumented/java/util/function/BinaryOperator<TM;>;
        //    StackMapTable: 00 01 FF 00 0C 00 00 00 01 07 00 32
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      12     12     13     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:264)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:198)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:276)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static <T, U, A, R> Collector<T, ?, R> mapping(final Function<? super T, ? extends U> function, final Collector<? super U, A, R> collector) {
        try {
            BytecodeManager.incBytecodes(2);
            collector.accumulator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(4);
            final Supplier<A> supplier = collector.supplier();
            final BiConsumer<Object, U> biConsumer2;
            final U u;
            final BiConsumer<?, T> biConsumer = (o, o2) -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    function.apply((Object)o2);
                    BytecodeManager.incBytecodes(1);
                    biConsumer2.accept(o, u);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final BinaryOperator<A> combiner = collector.combiner();
            BytecodeManager.incBytecodes(2);
            final Function<A, R> finisher = collector.finisher();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Set<Collector.Characteristics> characteristics = collector.characteristics();
            BytecodeManager.incBytecodes(1);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, R>(supplier, biConsumer, combiner, finisher, characteristics);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, R>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(final Collector<T, A, R> collector, final Function<R, RR> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Set<Collector.Characteristics> set = collector.characteristics();
            BytecodeManager.incBytecodes(1);
            final Set<Collector.Characteristics> set2 = set;
            final Collector.Characteristics identity_FINISH = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(3);
            final boolean contains = set2.contains(identity_FINISH);
            BytecodeManager.incBytecodes(1);
            if (contains) {
                final Set<Collector.Characteristics> set3 = set;
                BytecodeManager.incBytecodes(2);
                final int size = set3.size();
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                if (size == n) {
                    set = Collectors.CH_NOID;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Set<Enum> set4 = (Set<Enum>)set;
                    BytecodeManager.incBytecodes(2);
                    final EnumSet<Enum> copy = EnumSet.copyOf(set4);
                    BytecodeManager.incBytecodes(1);
                    final EnumSet<Enum> set5 = copy;
                    final Collector.Characteristics identity_FINISH2 = Collector.Characteristics.IDENTITY_FINISH;
                    BytecodeManager.incBytecodes(3);
                    set5.remove(identity_FINISH2);
                    BytecodeManager.incBytecodes(1);
                    final EnumSet<Enum> set6 = copy;
                    BytecodeManager.incBytecodes(2);
                    set = (Set<Collector.Characteristics>)Collections.unmodifiableSet((Set<?>)set6);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(4);
            final Supplier<A> supplier = collector.supplier();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final BiConsumer<A, T> accumulator = collector.accumulator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final BinaryOperator<A> combiner = collector.combiner();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Function<A, R> finisher = collector.finisher();
            BytecodeManager.incBytecodes(2);
            final Function<A, Object> andThen = finisher.andThen((Function<? super R, ?>)function);
            final Collection<Enum> collection = (Collection<Enum>)set;
            BytecodeManager.incBytecodes(2);
            final CollectorImpl collectorImpl = new CollectorImpl<T, A, RR>(supplier, accumulator, combiner, andThen, (Set)collection);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, A, RR>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Long> counting() {
        try {
            final long l = 0L;
            BytecodeManager.incBytecodes(2);
            final Long value = l;
            final long i;
            final Object o;
            final Function<Object, Object> function = p0 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    i;
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BinaryOperator<U> binaryOperator = Long::sum;
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, Long> reducing = reducing(value, (Function<? super Object, ? extends Long>)function, (BinaryOperator<Long>)binaryOperator);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Long>)reducing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Optional<T>> minBy(final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            final BinaryOperator<Object> minBy = BinaryOperator.minBy((Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            final Collector<T, ?, Optional<T>> reducing = reducing((BinaryOperator<T>)minBy);
            BytecodeManager.incBytecodes(1);
            return reducing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Optional<T>> maxBy(final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            final BinaryOperator<Object> maxBy = BinaryOperator.maxBy((Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            final Collector<T, ?, Optional<T>> reducing = reducing((BinaryOperator<T>)maxBy);
            BytecodeManager.incBytecodes(1);
            return reducing;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Integer> summingInt(final ToIntFunction<? super T> toIntFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new int[] { 0 };
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            int n;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    n = array3[n2];
                    BytecodeManager.incBytecodes(7);
                    array3[n2] = n + toIntFunction.applyAsInt((Object)o);
                    BytecodeManager.incBytecodes(3);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n3;
            final BinaryOperator<Object> binaryOperator = (array, array4) -> {
                try {
                    array[n3] += array4[0];
                    BytecodeManager.incBytecodes(11);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            int i;
            final Object o3;
            final Function<Object, Object> function = array2 -> {
                try {
                    i = array2[0];
                    BytecodeManager.incBytecodes(4);
                    i;
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Integer>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Integer>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Long> summingLong(final ToLongFunction<? super T> toLongFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new long[] { 0L };
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            long n;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    n = array3[n2];
                    BytecodeManager.incBytecodes(7);
                    array3[n2] = n + toLongFunction.applyAsLong((Object)o);
                    BytecodeManager.incBytecodes(3);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n3;
            final BinaryOperator<Object> binaryOperator = (array, array4) -> {
                try {
                    array[n3] += array4[0];
                    BytecodeManager.incBytecodes(11);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            long l;
            final Object o3;
            final Function<Object, Object> function = array2 -> {
                try {
                    l = array2[0];
                    BytecodeManager.incBytecodes(4);
                    l;
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Long>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Long>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Double> summingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new double[3];
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final double n;
            final int n3;
            double n2;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(1);
                    sumWithCompensation(array3, n);
                    BytecodeManager.incBytecodes(1);
                    n2 = array3[n3];
                    BytecodeManager.incBytecodes(7);
                    array3[n3] = n2 + toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(3);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            double n4;
            final int n5;
            double n6;
            final Object o3;
            final BiFunction<Object, Object, Object> biFunction = (array, array4) -> {
                try {
                    n4 = array4[0];
                    BytecodeManager.incBytecodes(5);
                    sumWithCompensation(array, n4);
                    BytecodeManager.incBytecodes(1);
                    array[n5] += array4[2];
                    BytecodeManager.incBytecodes(9);
                    n6 = array4[1];
                    BytecodeManager.incBytecodes(5);
                    sumWithCompensation(array, n6);
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final double d;
            final Object o4;
            final Function<Object, Object> function = array2 -> {
                try {
                    BytecodeManager.incBytecodes(2);
                    computeFinalSum(array2);
                    BytecodeManager.incBytecodes(1);
                    d;
                    BytecodeManager.incBytecodes(1);
                    return o4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Double>(supplier, biConsumer, (BinaryOperator)biFunction, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Double>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static double[] sumWithCompensation(final double[] array, final double n) {
        try {
            final double n2 = n - array[1];
            BytecodeManager.incBytecodes(6);
            final double n3 = array[0];
            BytecodeManager.incBytecodes(4);
            final double n4 = n3 + n2;
            BytecodeManager.incBytecodes(4);
            array[1] = n4 - n3 - n2;
            BytecodeManager.incBytecodes(8);
            array[0] = n4;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static double computeFinalSum(final double[] array) {
        try {
            final double n = array[0] + array[1];
            BytecodeManager.incBytecodes(8);
            final double n2 = array[array.length - 1];
            BytecodeManager.incBytecodes(7);
            final double v = n;
            BytecodeManager.incBytecodes(2);
            final boolean naN = Double.isNaN(v);
            BytecodeManager.incBytecodes(1);
            if (naN) {
                final double v2 = n2;
                BytecodeManager.incBytecodes(2);
                final boolean infinite = Double.isInfinite(v2);
                BytecodeManager.incBytecodes(1);
                if (infinite) {
                    final double n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    return n3;
                }
            }
            final double n4 = n;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Double> averagingInt(final ToIntFunction<? super T> toIntFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new long[2];
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            long n;
            final int n3;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    n = array3[n2];
                    BytecodeManager.incBytecodes(7);
                    array3[n2] = n + toIntFunction.applyAsInt((Object)o);
                    ++array3[n3];
                    BytecodeManager.incBytecodes(11);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n4;
            final int n5;
            final BinaryOperator<Object> binaryOperator = (array, array4) -> {
                try {
                    array[n4] += array4[0];
                    array[n5] += array4[1];
                    BytecodeManager.incBytecodes(20);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            long n6;
            double d = 0.0;
            final Object o3;
            final Function<Object, Object> function = array2 -> {
                try {
                    n6 = lcmp(array2[1], 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n6 == 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        d = array2[0] / (double)array2[1];
                        BytecodeManager.incBytecodes(9);
                    }
                    BytecodeManager.incBytecodes(1);
                    d;
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Double>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Double>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Double> averagingLong(final ToLongFunction<? super T> toLongFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new long[2];
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n2;
            long n;
            final int n3;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    n = array3[n2];
                    BytecodeManager.incBytecodes(7);
                    array3[n2] = n + toLongFunction.applyAsLong((Object)o);
                    ++array3[n3];
                    BytecodeManager.incBytecodes(10);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final int n4;
            final int n5;
            final BinaryOperator<Object> binaryOperator = (array, array4) -> {
                try {
                    array[n4] += array4[0];
                    array[n5] += array4[1];
                    BytecodeManager.incBytecodes(20);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            long n6;
            double d = 0.0;
            final Object o3;
            final Function<Object, Object> function = array2 -> {
                try {
                    n6 = lcmp(array2[1], 0L);
                    BytecodeManager.incBytecodes(6);
                    if (n6 == 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        d = array2[0] / (double)array2[1];
                        BytecodeManager.incBytecodes(9);
                    }
                    BytecodeManager.incBytecodes(1);
                    d;
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Double>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Double>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Double> averagingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        try {
            Object o2;
            final Supplier<Object> supplier = () -> {
                try {
                    o2 = new double[4];
                    BytecodeManager.incBytecodes(2);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final double n;
            final int n2;
            final int n4;
            double n3;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(1);
                    sumWithCompensation(array3, n);
                    ++array3[n2];
                    n3 = array3[n4];
                    BytecodeManager.incBytecodes(15);
                    array3[n4] = n3 + toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(3);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            double n5;
            double n6;
            final int n7;
            final int n8;
            final BinaryOperator<Object> binaryOperator = (array, array4) -> {
                try {
                    n5 = array4[0];
                    BytecodeManager.incBytecodes(5);
                    sumWithCompensation(array, n5);
                    n6 = array4[1];
                    BytecodeManager.incBytecodes(6);
                    sumWithCompensation(array, n6);
                    array[n7] += array4[2];
                    array[n8] += array4[3];
                    BytecodeManager.incBytecodes(21);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            double n9;
            double d = 0.0;
            final Object o3;
            final Function<Object, Object> function = array2 -> {
                try {
                    n9 = dcmpl(array2[2], 0.0);
                    BytecodeManager.incBytecodes(6);
                    if (n9 == 0) {
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(2);
                        d = computeFinalSum(array2) / array2[2];
                        BytecodeManager.incBytecodes(4);
                    }
                    BytecodeManager.incBytecodes(1);
                    d;
                    BytecodeManager.incBytecodes(1);
                    return o3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Double>(supplier, biConsumer, binaryOperator, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Double>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, T> reducing(final T t, final BinaryOperator<T> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Supplier<T[]> boxSupplier = boxSupplier(t);
            Object o;
            final int n;
            final BiConsumer<?, T> biConsumer = (array2, t2) -> {
                try {
                    o = array2[0];
                    BytecodeManager.incBytecodes(8);
                    array2[n] = binaryOperator.apply((T)o, t2);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            Object o2;
            Object o3;
            final int n2;
            final BinaryOperator<Object> binaryOperator2 = (array3, array4) -> {
                try {
                    o2 = array3[0];
                    o3 = array4[0];
                    BytecodeManager.incBytecodes(10);
                    array3[n2] = binaryOperator.apply((T)o2, (T)o3);
                    BytecodeManager.incBytecodes(3);
                    return array3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            Object o4;
            final Function<Object, Object> function = array -> {
                try {
                    o4 = array[0];
                    BytecodeManager.incBytecodes(4);
                    return o4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(4);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, T>(boxSupplier, biConsumer, binaryOperator2, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, T>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> Supplier<T[]> boxSupplier(final T t) {
        try {
            Object o;
            final Supplier<Object> supplier = () -> {
                try {
                    o = new Object[] { t };
                    BytecodeManager.incBytecodes(7);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            return (Supplier<T[]>)supplier;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, Optional<T>> reducing(final BinaryOperator<T> binaryOperator) {
        try {
            final Object o;
            class OptionalBox implements Consumer<T>
            {
                T value;
                boolean present;
                
                OptionalBox() {
                    try {
                        BytecodeManager.incBytecodes(5);
                        this.value = null;
                        BytecodeManager.incBytecodes(3);
                        this.present = false;
                        BytecodeManager.incBytecodes(4);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void accept(final T value) {
                    try {
                        final boolean present = this.present;
                        BytecodeManager.incBytecodes(3);
                        if (present) {
                            final BinaryOperator val$op = binaryOperator;
                            final T value2 = this.value;
                            BytecodeManager.incBytecodes(7);
                            this.value = (T)val$op.apply(value2, value);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            this.value = value;
                            BytecodeManager.incBytecodes(3);
                            this.present = true;
                            BytecodeManager.incBytecodes(3);
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
                    // new(instrumented.java.util.stream.Collectors.OptionalBox.class)
                    BytecodeManager.incBytecodes(4);
                    new OptionalBox();
                    BytecodeManager.incBytecodes(1);
                    return o;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BiConsumer<?, T> biConsumer = OptionalBox::accept;
            boolean present;
            T value;
            final BinaryOperator<Object> binaryOperator2 = (optionalBox, optionalBox3) -> {
                try {
                    present = optionalBox3.present;
                    BytecodeManager.incBytecodes(3);
                    if (present) {
                        value = optionalBox3.value;
                        BytecodeManager.incBytecodes(4);
                        optionalBox.accept((Object)value);
                    }
                    BytecodeManager.incBytecodes(2);
                    return optionalBox;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            T value2;
            final Object o2;
            final Function<Object, Object> function = optionalBox2 -> {
                try {
                    value2 = optionalBox2.value;
                    BytecodeManager.incBytecodes(3);
                    Optional.ofNullable(value2);
                    BytecodeManager.incBytecodes(1);
                    return o2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, Optional<T>>(supplier, biConsumer, binaryOperator2, function, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Optional<T>>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, U> Collector<T, ?, U> reducing(final U u, final Function<? super T, ? extends U> function, final BinaryOperator<U> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Supplier<U[]> boxSupplier = boxSupplier(u);
            Object o2;
            final int n;
            final U u2;
            final BiConsumer<?, T> biConsumer = (array3, o) -> {
                try {
                    o2 = array3[0];
                    BytecodeManager.incBytecodes(9);
                    function.apply((Object)o);
                    BytecodeManager.incBytecodes(1);
                    array3[n] = binaryOperator.apply((U)o2, u2);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            Object o3;
            Object o4;
            final int n2;
            final BinaryOperator<Object> binaryOperator2 = (array2, array4) -> {
                try {
                    o3 = array2[0];
                    o4 = array4[0];
                    BytecodeManager.incBytecodes(10);
                    array2[n2] = binaryOperator.apply((U)o3, (U)o4);
                    BytecodeManager.incBytecodes(3);
                    return array2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            Object o5;
            final Function<Object, Object> function2 = array -> {
                try {
                    o5 = array[0];
                    BytecodeManager.incBytecodes(4);
                    return o5;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, U>(boxSupplier, biConsumer, binaryOperator2, function2, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, U>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(final Function<? super T, ? extends K> function) {
        try {
            BytecodeManager.incBytecodes(2);
            final Collector<? super Object, ?, List<? super Object>> list = toList();
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, Map<Object, List<T>>> groupingBy = groupingBy((Function<? super Object, ?>)function, (Collector<? super Object, Object, List<T>>)list);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Map<K, List<T>>>)groupingBy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(final Function<? super T, ? extends K> function, final Collector<? super T, A, D> collector) {
        try {
            final Supplier<HashMap> supplier = HashMap::new;
            BytecodeManager.incBytecodes(3);
            final Collector<Object, ?, Map<K, D>> groupingBy = groupingBy((Function<? super Object, ?>)function, (Supplier<Map<K, D>>)supplier, (Collector<? super Object, A, D>)collector);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Map<K, D>>)groupingBy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(final Function<? super T, ? extends K> function, final Supplier<M> supplier, final Collector<? super T, A, D> collector) {
        try {
            BytecodeManager.incBytecodes(2);
            collector.supplier();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            collector.accumulator();
            BytecodeManager.incBytecodes(1);
            final T t;
            final String s;
            final Supplier<Object> supplier2;
            final Object o3;
            Function<? super K, ?> function2;
            final K k;
            final BiConsumer<Object, Object> biConsumer2;
            final Object o4;
            final BiConsumer<Object, Object> biConsumer = (map2, o2) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    function.apply((Object)o2);
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull((K)t, s);
                    BytecodeManager.incBytecodes(1);
                    function2 = (p1 -> {
                        try {
                            BytecodeManager.incBytecodes(2);
                            supplier2.get();
                            BytecodeManager.incBytecodes(1);
                            return o3;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    });
                    BytecodeManager.incBytecodes(4);
                    map2.computeIfAbsent(k, function2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(4);
                    biConsumer2.accept(o4, o2);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(2);
            final BinaryOperator<A> combiner = collector.combiner();
            BytecodeManager.incBytecodes(1);
            final BinaryOperator<Map> mapMerger = mapMerger(combiner);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Set<Collector.Characteristics> characteristics = collector.characteristics();
            final Collector.Characteristics identity_FINISH = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(2);
            final boolean contains = characteristics.contains(identity_FINISH);
            BytecodeManager.incBytecodes(1);
            if (contains) {
                final BiConsumer<?, T> biConsumer3 = (BiConsumer<?, T>)biConsumer;
                final BinaryOperator<Map> binaryOperator = mapMerger;
                final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
                BytecodeManager.incBytecodes(7);
                final CollectorImpl collectorImpl = new CollectorImpl<T, Object, M>(supplier, biConsumer3, binaryOperator, ch_ID);
                BytecodeManager.incBytecodes(1);
                return (Collector<T, ?, M>)collectorImpl;
            }
            BytecodeManager.incBytecodes(2);
            collector.finisher();
            BytecodeManager.incBytecodes(1);
            final Function<Object, Object> function4;
            final Map map3;
            BiFunction biFunction;
            final Function<Object, Map> function3 = map -> {
                try {
                    biFunction = ((p1, o) -> {
                        try {
                            BytecodeManager.incBytecodes(3);
                            function4.apply(o);
                            BytecodeManager.incBytecodes(1);
                            return map3;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    });
                    BytecodeManager.incBytecodes(3);
                    map.replaceAll(biFunction);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    return map;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(2);
            final BiConsumer<Object, Object> biConsumer4 = biConsumer;
            final BinaryOperator<Map> binaryOperator2 = mapMerger;
            final Function<Object, Map> function5 = function3;
            final Set<Collector.Characteristics> ch_NOID = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(8);
            final CollectorImpl collectorImpl2 = new CollectorImpl<T, Object, M>(supplier, biConsumer4, binaryOperator2, function5, ch_NOID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, M>)collectorImpl2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent(final Function<? super T, ? extends K> function) {
        try {
            final Supplier<ConcurrentHashMap> supplier = ConcurrentHashMap::new;
            BytecodeManager.incBytecodes(2);
            final Collector<? super Object, ?, List<? super Object>> list = toList();
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent = groupingByConcurrent((Function<? super Object, ?>)function, (Supplier<ConcurrentMap<K, List<T>>>)supplier, (Collector<? super Object, Object, Object>)list);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, ConcurrentMap<K, List<T>>>)groupingByConcurrent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> groupingByConcurrent(final Function<? super T, ? extends K> function, final Collector<? super T, A, D> collector) {
        try {
            final Supplier<ConcurrentHashMap> supplier = ConcurrentHashMap::new;
            BytecodeManager.incBytecodes(3);
            final Collector<Object, ?, ConcurrentMap<K, D>> groupingByConcurrent = groupingByConcurrent((Function<? super Object, ?>)function, (Supplier<ConcurrentMap<K, D>>)supplier, (Collector<? super Object, A, D>)collector);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, ConcurrentMap<K, D>>)groupingByConcurrent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, A, D, M extends ConcurrentMap<K, D>> Collector<T, ?, M> groupingByConcurrent(final Function<? super T, ? extends K> p0, final Supplier<M> p1, final Collector<? super T, A, D> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface instrumented/java/util/stream/Collector.supplier:()Linstrumented/java/util/function/Supplier;
        //    11: astore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_2        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: invokeinterface instrumented/java/util/stream/Collector.accumulator:()Linstrumented/java/util/function/BiConsumer;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload_2        
        //    36: ldc             2
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokeinterface instrumented/java/util/stream/Collector.combiner:()Linstrumented/java/util/function/BinaryOperator;
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokestatic    instrumented/java/util/stream/Collectors.mapMerger:(Linstrumented/java/util/function/BinaryOperator;)Linstrumented/java/util/function/BinaryOperator;
        //    54: astore          5
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_1        
        //    62: astore          6
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload_2        
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokeinterface instrumented/java/util/stream/Collector.characteristics:()Linstrumented/java/util/Set;
        //    80: getstatic       instrumented/java/util/stream/Collector$Characteristics.CONCURRENT:Linstrumented/java/util/stream/Collector$Characteristics;
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokeinterface instrumented/java/util/Set.contains:(Ljava/lang/Object;)Z
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ifeq            120
        //   101: aload_0        
        //   102: aload_3        
        //   103: aload           4
        //   105: invokedynamic   BootstrapMethod #61, accept:(Linstrumented/java/util/function/Function;Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;)Linstrumented/java/util/function/BiConsumer;
        //   110: astore          7
        //   112: ldc             5
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: goto            136
        //   120: aload_0        
        //   121: aload_3        
        //   122: aload           4
        //   124: invokedynamic   BootstrapMethod #62, accept:(Linstrumented/java/util/function/Function;Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;)Linstrumented/java/util/function/BiConsumer;
        //   129: astore          7
        //   131: ldc             4
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: aload_2        
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: invokeinterface instrumented/java/util/stream/Collector.characteristics:()Linstrumented/java/util/Set;
        //   147: getstatic       instrumented/java/util/stream/Collector$Characteristics.IDENTITY_FINISH:Linstrumented/java/util/stream/Collector$Characteristics;
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokeinterface instrumented/java/util/Set.contains:(Ljava/lang/Object;)Z
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: ifeq            195
        //   168: new             Linstrumented/java/util/stream/Collectors$CollectorImpl;
        //   171: dup            
        //   172: aload           6
        //   174: aload           7
        //   176: aload           5
        //   178: getstatic       instrumented/java/util/stream/Collectors.CH_CONCURRENT_ID:Linstrumented/java/util/Set;
        //   181: ldc             7
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokespecial   instrumented/java/util/stream/Collectors$CollectorImpl.<init>:(Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;Linstrumented/java/util/function/BinaryOperator;Linstrumented/java/util/Set;)V
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: areturn        
        //   195: aload_2        
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokeinterface instrumented/java/util/stream/Collector.finisher:()Linstrumented/java/util/function/Function;
        //   206: astore          8
        //   208: ldc             1
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: aload           8
        //   215: invokedynamic   BootstrapMethod #63, apply:(Linstrumented/java/util/function/Function;)Linstrumented/java/util/function/Function;
        //   220: astore          9
        //   222: ldc             2
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: new             Linstrumented/java/util/stream/Collectors$CollectorImpl;
        //   230: dup            
        //   231: aload           6
        //   233: aload           7
        //   235: aload           5
        //   237: aload           9
        //   239: getstatic       instrumented/java/util/stream/Collectors.CH_CONCURRENT_NOID:Linstrumented/java/util/Set;
        //   242: ldc_w           8
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: invokespecial   instrumented/java/util/stream/Collectors$CollectorImpl.<init>:(Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;Linstrumented/java/util/function/BinaryOperator;Linstrumented/java/util/function/Function;Linstrumented/java/util/Set;)V
        //   251: ldc             1
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: areturn        
        //   257: athrow         
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;A:Ljava/lang/Object;D:Ljava/lang/Object;M::Linstrumented/java/util/concurrent/ConcurrentMap<TK;TD;>;>(Linstrumented/java/util/function/Function<-TT;+TK;>;Linstrumented/java/util/function/Supplier<TM;>;Linstrumented/java/util/stream/Collector<-TT;TA;TD;>;)Linstrumented/java/util/stream/Collector<TT;*TM;>;
        //    StackMapTable: 00 04 FF 00 78 00 07 07 01 2F 07 02 84 07 00 0E 07 02 84 07 02 86 07 01 51 07 02 84 00 00 FC 00 0F 07 02 86 3A FF 00 3D 00 00 00 01 07 00 32
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      257    257    258    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119_2:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(final Predicate<? super T> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            final Collector<? super Object, ?, List<? super Object>> list = toList();
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, Map<Boolean, List<T>>> partitioningBy = partitioningBy((Predicate<? super Object>)predicate, (Collector<? super Object, Object, List<T>>)list);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Map<Boolean, List<T>>>)partitioningBy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(final Predicate<? super T> p0, final Collector<? super T, A, D> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface instrumented/java/util/stream/Collector.accumulator:()Linstrumented/java/util/function/BiConsumer;
        //    11: astore_2       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_2        
        //    18: aload_0        
        //    19: invokedynamic   BootstrapMethod #64, accept:(Linstrumented/java/util/function/BiConsumer;Linstrumented/java/util/function/Predicate;)Linstrumented/java/util/function/BiConsumer;
        //    24: astore_3       
        //    25: ldc_w           3
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: aload_1        
        //    32: ldc             2
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokeinterface instrumented/java/util/stream/Collector.combiner:()Linstrumented/java/util/function/BinaryOperator;
        //    42: astore          4
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload           4
        //    51: invokedynamic   BootstrapMethod #65, apply:(Linstrumented/java/util/function/BinaryOperator;)Linstrumented/java/util/function/BinaryOperator;
        //    56: astore          5
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: aload_1        
        //    64: invokedynamic   BootstrapMethod #66, get:(Linstrumented/java/util/stream/Collector;)Linstrumented/java/util/function/Supplier;
        //    69: astore          6
        //    71: ldc             2
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload_1        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokeinterface instrumented/java/util/stream/Collector.characteristics:()Linstrumented/java/util/Set;
        //    87: getstatic       instrumented/java/util/stream/Collector$Characteristics.IDENTITY_FINISH:Linstrumented/java/util/stream/Collector$Characteristics;
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokeinterface instrumented/java/util/Set.contains:(Ljava/lang/Object;)Z
        //   100: ldc             1
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifeq            134
        //   108: new             Linstrumented/java/util/stream/Collectors$CollectorImpl;
        //   111: dup            
        //   112: aload           6
        //   114: aload_3        
        //   115: aload           5
        //   117: getstatic       instrumented/java/util/stream/Collectors.CH_ID:Linstrumented/java/util/Set;
        //   120: ldc             7
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokespecial   instrumented/java/util/stream/Collectors$CollectorImpl.<init>:(Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;Linstrumented/java/util/function/BinaryOperator;Linstrumented/java/util/Set;)V
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: areturn        
        //   134: aload_1        
        //   135: invokedynamic   BootstrapMethod #67, apply:(Linstrumented/java/util/stream/Collector;)Linstrumented/java/util/function/Function;
        //   140: astore          7
        //   142: ldc             2
        //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   147: new             Linstrumented/java/util/stream/Collectors$CollectorImpl;
        //   150: dup            
        //   151: aload           6
        //   153: aload_3        
        //   154: aload           5
        //   156: aload           7
        //   158: getstatic       instrumented/java/util/stream/Collectors.CH_NOID:Linstrumented/java/util/Set;
        //   161: ldc_w           8
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokespecial   instrumented/java/util/stream/Collectors$CollectorImpl.<init>:(Linstrumented/java/util/function/Supplier;Linstrumented/java/util/function/BiConsumer;Linstrumented/java/util/function/BinaryOperator;Linstrumented/java/util/function/Function;Linstrumented/java/util/Set;)V
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: areturn        
        //   176: athrow         
        //    Signature:
        //  <T:Ljava/lang/Object;D:Ljava/lang/Object;A:Ljava/lang/Object;>(Linstrumented/java/util/function/Predicate<-TT;>;Linstrumented/java/util/stream/Collector<-TT;TA;TD;>;)Linstrumented/java/util/stream/Collector<TT;*Linstrumented/java/util/Map<Ljava/lang/Boolean;TD;>;>;
        //    StackMapTable: 00 02 FF 00 86 00 07 07 02 D8 07 00 0E 07 02 86 07 02 86 07 01 51 07 01 51 07 02 84 00 00 FF 00 29 00 00 00 01 07 00 32
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      176    176    177    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:264)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:198)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:276)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2) {
        try {
            BytecodeManager.incBytecodes(3);
            final BinaryOperator<Object> throwingMerger = throwingMerger();
            final Supplier<HashMap> supplier = HashMap::new;
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, Map<K, U>> map = toMap((Function<? super Object, ?>)function, (Function<? super Object, ?>)function2, throwingMerger, (Supplier<Map<K, U>>)supplier);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Map<K, U>>)map;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2, final BinaryOperator<U> binaryOperator) {
        try {
            final Supplier<HashMap> supplier = HashMap::new;
            BytecodeManager.incBytecodes(4);
            final Collector<Object, ?, Map<K, U>> map = toMap((Function<? super Object, ?>)function, (Function<? super Object, ? extends U>)function2, binaryOperator, (Supplier<Map<K, U>>)supplier);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, Map<K, U>>)map;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2, final BinaryOperator<U> binaryOperator, final Supplier<M> supplier) {
        try {
            final K k;
            final U u;
            final BiConsumer<Object, Object> biConsumer = (map, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    function.apply((Object)o);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    function2.apply((Object)o);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    map.merge(k, u, (BiFunction<? super U, ? super U, ? extends U>)binaryOperator);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            final BiConsumer<?, T> biConsumer2 = (BiConsumer<?, T>)biConsumer;
            BytecodeManager.incBytecodes(6);
            final BinaryOperator<Object> mapMerger = mapMerger(binaryOperator);
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(2);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, M>(supplier, biConsumer2, mapMerger, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, M>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2) {
        try {
            BytecodeManager.incBytecodes(3);
            final BinaryOperator<Object> throwingMerger = throwingMerger();
            final Supplier<ConcurrentHashMap> supplier = ConcurrentHashMap::new;
            BytecodeManager.incBytecodes(1);
            final Collector<Object, ?, ConcurrentMap<K, U>> concurrentMap = toConcurrentMap((Function<? super Object, ?>)function, (Function<? super Object, ?>)function2, throwingMerger, (Supplier<ConcurrentMap<K, U>>)supplier);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, ConcurrentMap<K, U>>)concurrentMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2, final BinaryOperator<U> binaryOperator) {
        try {
            final Supplier<ConcurrentHashMap> supplier = ConcurrentHashMap::new;
            BytecodeManager.incBytecodes(4);
            final Collector<Object, ?, ConcurrentMap<K, U>> concurrentMap = toConcurrentMap((Function<? super Object, ?>)function, (Function<? super Object, ? extends U>)function2, binaryOperator, (Supplier<ConcurrentMap<K, U>>)supplier);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, ConcurrentMap<K, U>>)concurrentMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<T, ?, M> toConcurrentMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends U> function2, final BinaryOperator<U> binaryOperator, final Supplier<M> supplier) {
        try {
            final K k;
            final U u;
            final BiConsumer<Object, Object> biConsumer = (concurrentMap, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    function.apply((Object)o);
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    function2.apply((Object)o);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    concurrentMap.merge(k, u, (BiFunction<? super U, ? super U, ? extends U>)binaryOperator);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(4);
            final BiConsumer<?, T> biConsumer2 = (BiConsumer<?, T>)biConsumer;
            BytecodeManager.incBytecodes(6);
            final BinaryOperator<Object> mapMerger = mapMerger(binaryOperator);
            final Set<Collector.Characteristics> ch_CONCURRENT_ID = Collectors.CH_CONCURRENT_ID;
            BytecodeManager.incBytecodes(2);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, M>(supplier, biConsumer2, mapMerger, ch_CONCURRENT_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, M>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(final ToIntFunction<? super T> toIntFunction) {
        try {
            final Supplier<IntSummaryStatistics> supplier = IntSummaryStatistics::new;
            final int n;
            final BiConsumer<?, T> biConsumer = (intSummaryStatistics2, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    toIntFunction.applyAsInt((Object)o);
                    BytecodeManager.incBytecodes(1);
                    intSummaryStatistics2.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BinaryOperator<Object> binaryOperator = (intSummaryStatistics, intSummaryStatistics3) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    intSummaryStatistics.combine(intSummaryStatistics3);
                    BytecodeManager.incBytecodes(2);
                    return intSummaryStatistics;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, IntSummaryStatistics>(supplier, biConsumer, binaryOperator, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, IntSummaryStatistics>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(final ToLongFunction<? super T> toLongFunction) {
        try {
            final Supplier<LongSummaryStatistics> supplier = LongSummaryStatistics::new;
            final long n;
            final BiConsumer<?, T> biConsumer = (longSummaryStatistics2, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    toLongFunction.applyAsLong((Object)o);
                    BytecodeManager.incBytecodes(1);
                    longSummaryStatistics2.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BinaryOperator<Object> binaryOperator = (longSummaryStatistics, longSummaryStatistics3) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    longSummaryStatistics.combine(longSummaryStatistics3);
                    BytecodeManager.incBytecodes(2);
                    return longSummaryStatistics;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, LongSummaryStatistics>(supplier, biConsumer, binaryOperator, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, LongSummaryStatistics>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        try {
            final Supplier<DoubleSummaryStatistics> supplier = DoubleSummaryStatistics::new;
            final double n;
            final BiConsumer<?, T> biConsumer = (doubleSummaryStatistics2, o) -> {
                try {
                    BytecodeManager.incBytecodes(4);
                    toDoubleFunction.applyAsDouble((Object)o);
                    BytecodeManager.incBytecodes(1);
                    doubleSummaryStatistics2.accept(n);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final BinaryOperator<Object> binaryOperator = (doubleSummaryStatistics, doubleSummaryStatistics3) -> {
                try {
                    BytecodeManager.incBytecodes(3);
                    doubleSummaryStatistics.combine(doubleSummaryStatistics3);
                    BytecodeManager.incBytecodes(2);
                    return doubleSummaryStatistics;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            final Set<Collector.Characteristics> ch_ID = Collectors.CH_ID;
            BytecodeManager.incBytecodes(5);
            final CollectorImpl collectorImpl = new CollectorImpl<T, Object, DoubleSummaryStatistics>(supplier, biConsumer, binaryOperator, ch_ID);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, ?, DoubleSummaryStatistics>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Function access$000() {
        try {
            BytecodeManager.incBytecodes(1);
            final Function<Object, Object> castingIdentity = castingIdentity();
            BytecodeManager.incBytecodes(1);
            return castingIdentity;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Collector.Characteristics concurrent = Collector.Characteristics.CONCURRENT;
            final Collector.Characteristics unordered = Collector.Characteristics.UNORDERED;
            final Collector.Characteristics identity_FINISH = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final EnumSet<Collector.Characteristics> of = EnumSet.of(concurrent, unordered, identity_FINISH);
            BytecodeManager.incBytecodes(1);
            CH_CONCURRENT_ID = Collections.unmodifiableSet((Set<?>)of);
            BytecodeManager.incBytecodes(1);
            final Collector.Characteristics concurrent2 = Collector.Characteristics.CONCURRENT;
            final Collector.Characteristics unordered2 = Collector.Characteristics.UNORDERED;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<Collector.Characteristics> of2 = EnumSet.of(concurrent2, unordered2);
            BytecodeManager.incBytecodes(1);
            CH_CONCURRENT_NOID = Collections.unmodifiableSet((Set<?>)of2);
            BytecodeManager.incBytecodes(1);
            final Collector.Characteristics identity_FINISH2 = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final EnumSet<Collector.Characteristics> of3 = EnumSet.of(identity_FINISH2);
            BytecodeManager.incBytecodes(1);
            CH_ID = Collections.unmodifiableSet((Set<?>)of3);
            BytecodeManager.incBytecodes(1);
            final Collector.Characteristics unordered3 = Collector.Characteristics.UNORDERED;
            final Collector.Characteristics identity_FINISH3 = Collector.Characteristics.IDENTITY_FINISH;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final EnumSet<Collector.Characteristics> of4 = EnumSet.of(unordered3, identity_FINISH3);
            BytecodeManager.incBytecodes(1);
            CH_UNORDERED_ID = Collections.unmodifiableSet((Set<?>)of4);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            CH_NOID = Collections.emptySet();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class CollectorImpl<T, A, R> implements Collector<T, A, R>
    {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Set<Characteristics> characteristics;
        
        CollectorImpl(final Supplier<A> supplier, final BiConsumer<A, T> accumulator, final BinaryOperator<A> combiner, final Function<A, R> finisher, final Set<Characteristics> characteristics) {
            try {
                BytecodeManager.incBytecodes(2);
                this.supplier = supplier;
                BytecodeManager.incBytecodes(3);
                this.accumulator = accumulator;
                BytecodeManager.incBytecodes(3);
                this.combiner = combiner;
                BytecodeManager.incBytecodes(3);
                this.finisher = finisher;
                BytecodeManager.incBytecodes(3);
                this.characteristics = characteristics;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CollectorImpl(final Supplier<A> supplier, final BiConsumer<A, T> biConsumer, final BinaryOperator<A> binaryOperator, final Set<Characteristics> set) {
            try {
                BytecodeManager.incBytecodes(5);
                final Function access$000 = Collectors.access$000();
                BytecodeManager.incBytecodes(2);
                this(supplier, biConsumer, binaryOperator, access$000, set);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public BiConsumer<A, T> accumulator() {
            try {
                final BiConsumer<A, T> accumulator = this.accumulator;
                BytecodeManager.incBytecodes(3);
                return accumulator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Supplier<A> supplier() {
            try {
                final Supplier<A> supplier = this.supplier;
                BytecodeManager.incBytecodes(3);
                return supplier;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public BinaryOperator<A> combiner() {
            try {
                final BinaryOperator<A> combiner = this.combiner;
                BytecodeManager.incBytecodes(3);
                return combiner;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Function<A, R> finisher() {
            try {
                final Function<A, R> finisher = this.finisher;
                BytecodeManager.incBytecodes(3);
                return finisher;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Characteristics> characteristics() {
            try {
                final Set<Characteristics> characteristics = this.characteristics;
                BytecodeManager.incBytecodes(3);
                return characteristics;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class Partition<T> extends AbstractMap<Boolean, T> implements Map<Boolean, T>
    {
        final T forTrue;
        final T forFalse;
        
        Partition(final T forTrue, final T forFalse) {
            try {
                BytecodeManager.incBytecodes(2);
                this.forTrue = forTrue;
                BytecodeManager.incBytecodes(3);
                this.forFalse = forFalse;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Entry<Boolean, T>> entrySet() {
            try {
                BytecodeManager.incBytecodes(4);
                final AbstractSet<Entry<Boolean, T>> abstractSet = new AbstractSet<Entry<Boolean, T>>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public Iterator<Entry<Boolean, T>> iterator() {
                        try {
                            final boolean b = false;
                            BytecodeManager.incBytecodes(4);
                            final Boolean value = b;
                            final T forFalse = Partition.this.forFalse;
                            BytecodeManager.incBytecodes(4);
                            final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(value, forFalse);
                            BytecodeManager.incBytecodes(1);
                            final boolean b2 = true;
                            BytecodeManager.incBytecodes(4);
                            final Boolean value2 = b2;
                            final T forTrue = Partition.this.forTrue;
                            BytecodeManager.incBytecodes(4);
                            final SimpleImmutableEntry simpleImmutableEntry2 = new SimpleImmutableEntry(value2, forTrue);
                            BytecodeManager.incBytecodes(1);
                            final Entry[] array = { simpleImmutableEntry, simpleImmutableEntry2 };
                            BytecodeManager.incBytecodes(10);
                            final List<Entry<Boolean, T>> list = Arrays.asList((Entry<Boolean, T>[])array);
                            BytecodeManager.incBytecodes(1);
                            final Iterator<Entry<Boolean, T>> iterator = list.iterator();
                            BytecodeManager.incBytecodes(1);
                            return iterator;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int size() {
                        try {
                            final int n = 2;
                            BytecodeManager.incBytecodes(2);
                            return n;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return abstractSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
