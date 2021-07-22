// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.IntSupplier;
import instrumented.java.util.function.IntConsumer;
import aic2021.engine.BytecodeManager;

public final class OptionalInt
{
    private static final OptionalInt EMPTY;
    private final boolean isPresent;
    private final int value;
    
    private OptionalInt() {
        try {
            BytecodeManager.incBytecodes(2);
            this.isPresent = false;
            BytecodeManager.incBytecodes(3);
            this.value = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static OptionalInt empty() {
        try {
            final OptionalInt empty = OptionalInt.EMPTY;
            BytecodeManager.incBytecodes(2);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private OptionalInt(final int value) {
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
    
    public static OptionalInt of(final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final OptionalInt optionalInt = new OptionalInt(n);
            BytecodeManager.incBytecodes(1);
            return optionalInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getAsInt() {
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
            final int value = this.value;
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
    
    public void ifPresent(final IntConsumer intConsumer) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final int value = this.value;
                BytecodeManager.incBytecodes(4);
                intConsumer.accept(value);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int orElse(final int n) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            int value;
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
    
    public int orElseGet(final IntSupplier intSupplier) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            int n;
            if (isPresent) {
                n = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                n = intSupplier.getAsInt();
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <X extends Throwable> int orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final int value = this.value;
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
            final boolean b2 = o instanceof OptionalInt;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final OptionalInt optionalInt = (OptionalInt)o;
            BytecodeManager.incBytecodes(3);
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            boolean b4 = false;
            Label_0135: {
                if (isPresent) {
                    final boolean isPresent2 = optionalInt.isPresent;
                    BytecodeManager.incBytecodes(3);
                    if (isPresent2) {
                        final int value = this.value;
                        final int value2 = optionalInt.value;
                        BytecodeManager.incBytecodes(5);
                        if (value == value2) {
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0135;
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(2);
                        break Label_0135;
                    }
                }
                final boolean isPresent3 = this.isPresent;
                final boolean isPresent4 = optionalInt.isPresent;
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
                final int value = this.value;
                BytecodeManager.incBytecodes(3);
                hashCode = Integer.hashCode(value);
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
                final String format = "OptionalInt[%s]";
                final Object[] args = { null };
                final int n = 0;
                final int value = this.value;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                args[n] = value;
                BytecodeManager.incBytecodes(2);
                format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
            }
            else {
                format2 = "OptionalInt.empty";
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
            EMPTY = new OptionalInt();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
