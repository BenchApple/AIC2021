// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.DoubleBinaryOperator;
import java.io.Serializable;

public class DoubleAccumulator extends Striped64 implements Serializable
{
    private static final long serialVersionUID = 7249069246863182397L;
    private final DoubleBinaryOperator function;
    private final long identity;
    
    public DoubleAccumulator(final DoubleBinaryOperator function, final double n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.function = function;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            final long doubleToRawLongBits = Double.doubleToRawLongBits(n);
            this.identity = doubleToRawLongBits;
            this.base = doubleToRawLongBits;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void accumulate(final double n) {
        try {
            final Cell[] cells;
            final Cell[] array = cells = this.cells;
            BytecodeManager.incBytecodes(5);
            Label_0285: {
                if (array == null) {
                    final DoubleBinaryOperator function = this.function;
                    final long base;
                    final long n2 = base = this.base;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final double longBitsToDouble = Double.longBitsToDouble(n2);
                    BytecodeManager.incBytecodes(2);
                    final double applyAsDouble = function.applyAsDouble(longBitsToDouble, n);
                    BytecodeManager.incBytecodes(1);
                    final long doubleToRawLongBits;
                    final long n3 = lcmp(doubleToRawLongBits = Double.doubleToRawLongBits(applyAsDouble), base);
                    BytecodeManager.incBytecodes(5);
                    if (n3 == 0) {
                        break Label_0285;
                    }
                    final long n4 = base;
                    final long n5 = doubleToRawLongBits;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final boolean casBase = this.casBase(n4, n5);
                    BytecodeManager.incBytecodes(1);
                    if (casBase) {
                        break Label_0285;
                    }
                }
                boolean b = true;
                BytecodeManager.incBytecodes(2);
                final Cell[] array2 = cells;
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int n6 = cells.length - 1;
                    BytecodeManager.incBytecodes(7);
                    if (n6 >= 0) {
                        final Cell[] array3 = cells;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Cell cell2;
                        final Cell cell = cell2 = array3[getProbe() & n6];
                        BytecodeManager.incBytecodes(6);
                        if (cell != null) {
                            final DoubleBinaryOperator function2 = this.function;
                            final long value;
                            final long n7 = value = cell2.value;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final double longBitsToDouble2 = Double.longBitsToDouble(n7);
                            BytecodeManager.incBytecodes(2);
                            final double applyAsDouble2 = function2.applyAsDouble(longBitsToDouble2, n);
                            BytecodeManager.incBytecodes(1);
                            final long doubleToRawLongBits2;
                            final long n8 = lcmp(doubleToRawLongBits2 = Double.doubleToRawLongBits(applyAsDouble2), value);
                            BytecodeManager.incBytecodes(5);
                            boolean b3 = false;
                            boolean b2 = false;
                            Label_0258: {
                                if (n8 != 0) {
                                    final Cell cell3 = cell2;
                                    final long n9 = value;
                                    final long n10 = doubleToRawLongBits2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean cas = cell3.cas(n9, n10);
                                    BytecodeManager.incBytecodes(1);
                                    if (!cas) {
                                        b2 = (b3 = false);
                                        BytecodeManager.incBytecodes(1);
                                        break Label_0258;
                                    }
                                }
                                b2 = (b3 = true);
                                BytecodeManager.incBytecodes(2);
                            }
                            b = b3;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                break Label_0285;
                            }
                        }
                    }
                }
                final DoubleBinaryOperator function3 = this.function;
                final boolean b4 = b;
                BytecodeManager.incBytecodes(6);
                this.doubleAccumulate(n, function3, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double get() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            final long base = this.base;
            BytecodeManager.incBytecodes(3);
            double n = Double.longBitsToDouble(base);
            BytecodeManager.incBytecodes(1);
            final Cell[] array = cells;
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = cells.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final Cell cell = cells[n2];
                    BytecodeManager.incBytecodes(6);
                    if (cell != null) {
                        final DoubleBinaryOperator function = this.function;
                        final double n4 = n;
                        final long value = cell.value;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final double longBitsToDouble = Double.longBitsToDouble(value);
                        BytecodeManager.incBytecodes(1);
                        n = function.applyAsDouble(n4, longBitsToDouble);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final double n5 = n;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void reset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            this.base = this.identity;
            BytecodeManager.incBytecodes(4);
            final Cell[] array = cells;
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = cells.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        break;
                    }
                    final Cell cell = cells[n];
                    BytecodeManager.incBytecodes(6);
                    if (cell != null) {
                        cell.value = this.identity;
                        BytecodeManager.incBytecodes(4);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double getThenReset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            final long base = this.base;
            BytecodeManager.incBytecodes(3);
            double n = Double.longBitsToDouble(base);
            BytecodeManager.incBytecodes(1);
            this.base = this.identity;
            BytecodeManager.incBytecodes(4);
            final Cell[] array = cells;
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                int n2 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int length = cells.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= length) {
                        break;
                    }
                    final Cell cell2;
                    final Cell cell = cell2 = cells[n2];
                    BytecodeManager.incBytecodes(6);
                    if (cell != null) {
                        final long value = cell2.value;
                        BytecodeManager.incBytecodes(3);
                        final double longBitsToDouble = Double.longBitsToDouble(value);
                        BytecodeManager.incBytecodes(1);
                        cell2.value = this.identity;
                        BytecodeManager.incBytecodes(4);
                        final DoubleBinaryOperator function = this.function;
                        final double n4 = n;
                        final double n5 = longBitsToDouble;
                        BytecodeManager.incBytecodes(5);
                        n = function.applyAsDouble(n4, n5);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final double n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final double value = this.get();
            BytecodeManager.incBytecodes(1);
            final String string = Double.toString(value);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public double doubleValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final double value = this.get();
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final long n = (long)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int intValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = (int)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public float floatValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final float n = (float)this.get();
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object writeReplace() {
        try {
            BytecodeManager.incBytecodes(4);
            final SerializationProxy serializationProxy = new SerializationProxy(this);
            BytecodeManager.incBytecodes(1);
            return serializationProxy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws InvalidObjectException {
        try {
            final String reason = "Proxy required";
            BytecodeManager.incBytecodes(4);
            final InvalidObjectException ex = new InvalidObjectException(reason);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ DoubleBinaryOperator access$000(final DoubleAccumulator doubleAccumulator) {
        try {
            final DoubleBinaryOperator function = doubleAccumulator.function;
            BytecodeManager.incBytecodes(3);
            return function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long access$100(final DoubleAccumulator doubleAccumulator) {
        try {
            final long identity = doubleAccumulator.identity;
            BytecodeManager.incBytecodes(3);
            return identity;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class SerializationProxy implements Serializable
    {
        private static final long serialVersionUID = 7249069246863182397L;
        private final double value;
        private final DoubleBinaryOperator function;
        private final long identity;
        
        SerializationProxy(final DoubleAccumulator doubleAccumulator) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.function = DoubleAccumulator.access$000(doubleAccumulator);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.identity = DoubleAccumulator.access$100(doubleAccumulator);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.value = doubleAccumulator.get();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final long identity = this.identity;
                BytecodeManager.incBytecodes(3);
                final double longBitsToDouble = Double.longBitsToDouble(identity);
                BytecodeManager.incBytecodes(1);
                final DoubleBinaryOperator function = this.function;
                final double n = longBitsToDouble;
                BytecodeManager.incBytecodes(6);
                final DoubleAccumulator doubleAccumulator = new DoubleAccumulator(function, n);
                BytecodeManager.incBytecodes(1);
                final DoubleAccumulator doubleAccumulator2 = doubleAccumulator;
                final double value = this.value;
                BytecodeManager.incBytecodes(4);
                doubleAccumulator2.base = Double.doubleToRawLongBits(value);
                BytecodeManager.incBytecodes(1);
                final DoubleAccumulator doubleAccumulator3 = doubleAccumulator;
                BytecodeManager.incBytecodes(2);
                return doubleAccumulator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
