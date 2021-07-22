// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.LongSupplier;
import instrumented.java.util.function.LongConsumer;
import aic2021.engine.BytecodeManager;

public final class OptionalLong
{
    private static final OptionalLong EMPTY;
    private final boolean isPresent;
    private final long value;
    
    private OptionalLong() {
        try {
            BytecodeManager.incBytecodes(2);
            this.isPresent = false;
            BytecodeManager.incBytecodes(3);
            this.value = 0L;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static OptionalLong empty() {
        try {
            final OptionalLong empty = OptionalLong.EMPTY;
            BytecodeManager.incBytecodes(2);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private OptionalLong(final long value) {
        try {
            BytecodeManager.incBytecodes(2);
            this.isPresent = true;
            BytecodeManager.incBytecodes(3);
            this.value = value;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static OptionalLong of(final long n) {
        try {
            BytecodeManager.incBytecodes(4);
            final OptionalLong optionalLong = new OptionalLong(n);
            BytecodeManager.incBytecodes(1);
            return optionalLong;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long getAsLong() {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (!isPresent) {
                final String s = "No value present";
                BytecodeManager.incBytecodes(4);
                final NoSuchElementException ex = new NoSuchElementException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long value = this.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean isPresent() {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            return isPresent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void ifPresent(final LongConsumer longConsumer) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final long value = this.value;
                BytecodeManager.incBytecodes(4);
                longConsumer.accept(value);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long orElse(final long n) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            long value;
            if (isPresent) {
                value = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                value = n;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long orElseGet(final LongSupplier longSupplier) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            long n;
            if (isPresent) {
                n = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                n = longSupplier.getAsLong();
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <X extends Throwable> long orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final long value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            BytecodeManager.incBytecodes(2);
            final Throwable t = supplier.get();
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
            final boolean b2 = o instanceof OptionalLong;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final OptionalLong optionalLong = (OptionalLong)o;
            BytecodeManager.incBytecodes(3);
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            boolean b4 = false;
            Label_0136: {
                if (isPresent) {
                    final boolean isPresent2 = optionalLong.isPresent;
                    BytecodeManager.incBytecodes(3);
                    if (isPresent2) {
                        final long n = lcmp(this.value, optionalLong.value);
                        BytecodeManager.incBytecodes(6);
                        if (n == 0) {
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0136;
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(2);
                        break Label_0136;
                    }
                }
                final boolean isPresent3 = this.isPresent;
                final boolean isPresent4 = optionalLong.isPresent;
                BytecodeManager.incBytecodes(5);
                if (isPresent3 == isPresent4) {
                    b4 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b4 = false;
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            return b4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int hashCode() {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            int hashCode;
            if (isPresent) {
                final long value = this.value;
                BytecodeManager.incBytecodes(3);
                hashCode = Long.hashCode(value);
                BytecodeManager.incBytecodes(1);
            }
            else {
                hashCode = 0;
                BytecodeManager.incBytecodes(1);
            }
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
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            String format2;
            if (isPresent) {
                final String format = "OptionalLong[%s]";
                final Object[] args = { null };
                final int n = 0;
                final long value = this.value;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                args[n] = value;
                BytecodeManager.incBytecodes(2);
                format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
            }
            else {
                format2 = "OptionalLong.empty";
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
            EMPTY = new OptionalLong();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
