// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.Collection;
import instrumented.java.util.Collections;
import instrumented.java.util.EnumSet;
import instrumented.java.util.Objects;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Set;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.Supplier;

public interface Collector<T, A, R>
{
    Supplier<A> supplier();
    
    BiConsumer<A, T> accumulator();
    
    BinaryOperator<A> combiner();
    
    Function<A, R> finisher();
    
    Set<Characteristics> characteristics();
    
    default <T, R> Collector<T, R, R> of(final Supplier<R> supplier, final BiConsumer<R, T> biConsumer, final BinaryOperator<R> binaryOperator, final Characteristics... array) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            Set<Characteristics> set;
            if (length == 0) {
                set = Collectors.CH_ID;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Characteristics identity_FINISH = Characteristics.IDENTITY_FINISH;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final EnumSet<Characteristics> of = EnumSet.of(identity_FINISH, array);
                BytecodeManager.incBytecodes(1);
                set = (Set<Characteristics>)Collections.unmodifiableSet((Set<?>)of);
            }
            final Set<Characteristics> set2 = set;
            BytecodeManager.incBytecodes(1);
            final Set<Characteristics> set3 = set2;
            BytecodeManager.incBytecodes(7);
            final Collectors.CollectorImpl collectorImpl = new Collectors.CollectorImpl<T, R, R>((Supplier<Object>)supplier, (BiConsumer<Object, Object>)biConsumer, (BinaryOperator<Object>)binaryOperator, set3);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, R, R>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default <T, A, R> Collector<T, A, R> of(final Supplier<A> supplier, final BiConsumer<A, T> biConsumer, final BinaryOperator<A> binaryOperator, final Function<A, R> function, final Characteristics... array) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(supplier);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(array);
            BytecodeManager.incBytecodes(1);
            Set<Characteristics> set = Collectors.CH_NOID;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length > 0) {
                final Class<Characteristics> clazz = Characteristics.class;
                BytecodeManager.incBytecodes(2);
                final EnumSet<Enum> none = EnumSet.noneOf((Class<Enum>)clazz);
                BytecodeManager.incBytecodes(1);
                final EnumSet<Enum> set2 = none;
                BytecodeManager.incBytecodes(3);
                Collections.addAll(set2, array);
                BytecodeManager.incBytecodes(1);
                final Collection<? super T> collection = (Collection<? super T>)none;
                BytecodeManager.incBytecodes(2);
                set = Collections.unmodifiableSet((Set<? extends Characteristics>)collection);
                BytecodeManager.incBytecodes(1);
            }
            final Set<Characteristics> set3 = set;
            BytecodeManager.incBytecodes(8);
            final Collectors.CollectorImpl collectorImpl = new Collectors.CollectorImpl<T, A, R>(supplier, biConsumer, binaryOperator, function, set3);
            BytecodeManager.incBytecodes(1);
            return (Collector<T, A, R>)collectorImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public enum Characteristics
    {
        CONCURRENT, 
        UNORDERED, 
        IDENTITY_FINISH;
        
        private Characteristics() {
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
                final String s = "CONCURRENT";
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s2 = "UNORDERED";
                final int n2 = 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final String s3 = "IDENTITY_FINISH";
                final int n3 = 2;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(15);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
