// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.function.Consumer;
import aic2021.engine.BytecodeManager;

public final class Optional<T>
{
    private static final Optional<?> EMPTY;
    private final T value;
    
    private Optional() {
        try {
            BytecodeManager.incBytecodes(2);
            this.value = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Optional<T> empty() {
        try {
            final Optional<?> empty = Optional.EMPTY;
            BytecodeManager.incBytecodes(2);
            final Optional<?> optional = empty;
            BytecodeManager.incBytecodes(2);
            return (Optional<T>)optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Optional(final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.value = Objects.requireNonNull(t);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Optional<T> of(final T t) {
        try {
            BytecodeManager.incBytecodes(4);
            final Optional<T> optional = new Optional<T>(t);
            BytecodeManager.incBytecodes(1);
            return optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Optional<T> ofNullable(final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            Object o;
            if (t == null) {
                BytecodeManager.incBytecodes(1);
                o = empty();
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                o = of((Object)t);
            }
            BytecodeManager.incBytecodes(1);
            return (Optional<T>)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T get() {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            if (value == null) {
                final String s = "No value present";
                BytecodeManager.incBytecodes(4);
                final NoSuchElementException ex = new NoSuchElementException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final T value2 = this.value;
            BytecodeManager.incBytecodes(3);
            return value2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isPresent() {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (value != null) {
                b = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void ifPresent(final Consumer<? super T> consumer) {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            if (value != null) {
                final T value2 = this.value;
                BytecodeManager.incBytecodes(4);
                consumer.accept(value2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Optional<T> filter(final Predicate<? super T> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean present = this.isPresent();
            BytecodeManager.incBytecodes(1);
            if (!present) {
                BytecodeManager.incBytecodes(2);
                return this;
            }
            final T value = this.value;
            BytecodeManager.incBytecodes(4);
            final boolean test = predicate.test(value);
            BytecodeManager.incBytecodes(1);
            Optional empty;
            if (test) {
                empty = this;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(1);
                empty = empty();
            }
            BytecodeManager.incBytecodes(1);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> Optional<U> map(final Function<? super T, ? extends U> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean present = this.isPresent();
            BytecodeManager.incBytecodes(1);
            if (!present) {
                BytecodeManager.incBytecodes(1);
                final Optional<U> empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final T value = this.value;
            BytecodeManager.incBytecodes(4);
            final U apply = (U)function.apply(value);
            BytecodeManager.incBytecodes(1);
            final Optional<U> ofNullable = ofNullable(apply);
            BytecodeManager.incBytecodes(1);
            return ofNullable;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <U> Optional<U> flatMap(final Function<? super T, Optional<U>> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final boolean present = this.isPresent();
            BytecodeManager.incBytecodes(1);
            if (!present) {
                BytecodeManager.incBytecodes(1);
                final Optional<U> empty = empty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final T value = this.value;
            BytecodeManager.incBytecodes(4);
            final Optional<U> apply = function.apply(value);
            BytecodeManager.incBytecodes(1);
            final Optional<U> optional = Objects.requireNonNull(apply);
            BytecodeManager.incBytecodes(2);
            return optional;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T orElse(final T t) {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            T value2;
            if (value != null) {
                value2 = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                value2 = t;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return value2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T orElseGet(final Supplier<? extends T> supplier) {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            T t;
            if (value != null) {
                t = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                t = (T)supplier.get();
            }
            BytecodeManager.incBytecodes(1);
            return t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <X extends Throwable> T orElseThrow(final Supplier<? extends X> supplier) throws X, Throwable {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            if (value != null) {
                final T value2 = this.value;
                BytecodeManager.incBytecodes(3);
                return value2;
            }
            BytecodeManager.incBytecodes(2);
            final Throwable t = (Throwable)supplier.get();
            BytecodeManager.incBytecodes(2);
            throw t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            if (this == o) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = o instanceof Optional;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final Optional optional = (Optional)o;
            BytecodeManager.incBytecodes(3);
            final T value = this.value;
            final T value2 = optional.value;
            BytecodeManager.incBytecodes(5);
            final boolean equals = Objects.equals(value, value2);
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            final int hashCode = Objects.hashCode(value);
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final T value = this.value;
            BytecodeManager.incBytecodes(3);
            String format2;
            if (value != null) {
                final String format = "Optional[%s]";
                final Object[] args = { this.value };
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
            }
            else {
                format2 = "Optional.empty";
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return format2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            EMPTY = new Optional<Object>();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
