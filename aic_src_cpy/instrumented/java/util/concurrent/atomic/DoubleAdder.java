// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import instrumented.java.util.function.DoubleBinaryOperator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class DoubleAdder extends Striped64 implements Serializable
{
    private static final long serialVersionUID = 7249069246863182397L;
    
    public DoubleAdder() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void add(final double n) {
        try {
            final Cell[] cells;
            final Cell[] array = cells = this.cells;
            BytecodeManager.incBytecodes(5);
            Label_0191: {
                if (array == null) {
                    final long base = this.base;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                    final double n2 = Double.longBitsToDouble(base) + n;
                    BytecodeManager.incBytecodes(3);
                    final long doubleToRawLongBits = Double.doubleToRawLongBits(n2);
                    BytecodeManager.incBytecodes(1);
                    final boolean casBase = this.casBase(base, doubleToRawLongBits);
                    BytecodeManager.incBytecodes(1);
                    if (casBase) {
                        break Label_0191;
                    }
                }
                boolean cas = true;
                BytecodeManager.incBytecodes(2);
                final Cell[] array2 = cells;
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int n3 = cells.length - 1;
                    BytecodeManager.incBytecodes(7);
                    if (n3 >= 0) {
                        final Cell[] array3 = cells;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Cell cell2;
                        final Cell cell = cell2 = array3[getProbe() & n3];
                        BytecodeManager.incBytecodes(6);
                        if (cell != null) {
                            final Cell cell3 = cell2;
                            final long value = cell2.value;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final double n4 = Double.longBitsToDouble(value) + n;
                            BytecodeManager.incBytecodes(3);
                            final long doubleToRawLongBits2 = Double.doubleToRawLongBits(n4);
                            BytecodeManager.incBytecodes(1);
                            cas = cell3.cas(value, doubleToRawLongBits2);
                            BytecodeManager.incBytecodes(3);
                            if (cas) {
                                break Label_0191;
                            }
                        }
                    }
                }
                final DoubleBinaryOperator doubleBinaryOperator = null;
                final boolean b = cas;
                BytecodeManager.incBytecodes(5);
                this.doubleAccumulate(n, doubleBinaryOperator, b);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public double sum() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            final long base = this.base;
            BytecodeManager.incBytecodes(3);
            double longBitsToDouble = Double.longBitsToDouble(base);
            BytecodeManager.incBytecodes(1);
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
                        final double n3 = longBitsToDouble;
                        final long value = cell.value;
                        BytecodeManager.incBytecodes(4);
                        longBitsToDouble = n3 + Double.longBitsToDouble(value);
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final double n4 = longBitsToDouble;
            BytecodeManager.incBytecodes(2);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void reset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            this.base = 0L;
            BytecodeManager.incBytecodes(3);
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
                        cell.value = 0L;
                        BytecodeManager.incBytecodes(3);
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
    
    public double sumThenReset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            final long base = this.base;
            BytecodeManager.incBytecodes(3);
            double longBitsToDouble = Double.longBitsToDouble(base);
            BytecodeManager.incBytecodes(1);
            this.base = 0L;
            BytecodeManager.incBytecodes(3);
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
                    final Cell cell2;
                    final Cell cell = cell2 = cells[n];
                    BytecodeManager.incBytecodes(6);
                    if (cell != null) {
                        final long value = cell2.value;
                        BytecodeManager.incBytecodes(3);
                        cell2.value = 0L;
                        BytecodeManager.incBytecodes(3);
                        final double n3 = longBitsToDouble;
                        final long n4 = value;
                        BytecodeManager.incBytecodes(3);
                        longBitsToDouble = n3 + Double.longBitsToDouble(n4);
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final double n5 = longBitsToDouble;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final double sum = this.sum();
            BytecodeManager.incBytecodes(1);
            final String string = Double.toString(sum);
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
            final double sum = this.sum();
            BytecodeManager.incBytecodes(1);
            return sum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final long n = (long)this.sum();
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
            final int n = (int)this.sum();
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
            final float n = (float)this.sum();
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
    
    private static class SerializationProxy implements Serializable
    {
        private static final long serialVersionUID = 7249069246863182397L;
        private final double value;
        
        SerializationProxy(final DoubleAdder doubleAdder) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.value = doubleAdder.sum();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                BytecodeManager.incBytecodes(3);
                final DoubleAdder doubleAdder = new DoubleAdder();
                BytecodeManager.incBytecodes(1);
                final DoubleAdder doubleAdder2 = doubleAdder;
                final double value = this.value;
                BytecodeManager.incBytecodes(4);
                doubleAdder2.base = Double.doubleToRawLongBits(value);
                BytecodeManager.incBytecodes(1);
                final DoubleAdder doubleAdder3 = doubleAdder;
                BytecodeManager.incBytecodes(2);
                return doubleAdder3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
