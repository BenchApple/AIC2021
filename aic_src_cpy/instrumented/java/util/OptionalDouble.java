// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.DoubleSupplier;
import instrumented.java.util.function.DoubleConsumer;
import aic2021.engine.BytecodeManager;

public final class OptionalDouble
{
    private static final OptionalDouble EMPTY;
    private final boolean isPresent;
    private final double value;
    
    private OptionalDouble() {
        try {
            BytecodeManager.incBytecodes(2);
            this.isPresent = false;
            BytecodeManager.incBytecodes(3);
            this.value = Double.NaN;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static OptionalDouble empty() {
        try {
            final OptionalDouble empty = OptionalDouble.EMPTY;
            BytecodeManager.incBytecodes(2);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private OptionalDouble(final double value) {
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
    
    public static OptionalDouble of(final double n) {
        try {
            BytecodeManager.incBytecodes(4);
            final OptionalDouble optionalDouble = new OptionalDouble(n);
            BytecodeManager.incBytecodes(1);
            return optionalDouble;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double getAsDouble() {
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
            final double value = this.value;
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
    
    public void ifPresent(final DoubleConsumer doubleConsumer) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final double value = this.value;
                BytecodeManager.incBytecodes(4);
                doubleConsumer.accept(value);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double orElse(final double n) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            double value;
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
    
    public double orElseGet(final DoubleSupplier doubleSupplier) {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            double n;
            if (isPresent) {
                n = this.value;
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(2);
                n = doubleSupplier.getAsDouble();
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public <X extends Throwable> double orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        try {
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            if (isPresent) {
                final double value = this.value;
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
            final boolean b2 = o instanceof OptionalDouble;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final OptionalDouble optionalDouble = (OptionalDouble)o;
            BytecodeManager.incBytecodes(3);
            final boolean isPresent = this.isPresent;
            BytecodeManager.incBytecodes(3);
            boolean b4 = false;
            Label_0148: {
                if (isPresent) {
                    final boolean isPresent2 = optionalDouble.isPresent;
                    BytecodeManager.incBytecodes(3);
                    if (isPresent2) {
                        final double value = this.value;
                        final double value2 = optionalDouble.value;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final int compare = Double.compare(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (compare == 0) {
                            b4 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0148;
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(2);
                        break Label_0148;
                    }
                }
                final boolean isPresent3 = this.isPresent;
                final boolean isPresent4 = optionalDouble.isPresent;
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
                final double value = this.value;
                BytecodeManager.incBytecodes(3);
                hashCode = Double.hashCode(value);
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
                final String format = "OptionalDouble[%s]";
                final Object[] args = { null };
                final int n = 0;
                final double value = this.value;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                args[n] = value;
                BytecodeManager.incBytecodes(2);
                format2 = String.format(format, args);
                BytecodeManager.incBytecodes(1);
            }
            else {
                format2 = "OptionalDouble.empty";
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
            EMPTY = new OptionalDouble();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
