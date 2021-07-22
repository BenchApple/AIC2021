// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import instrumented.java.util.function.LongBinaryOperator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class LongAdder extends Striped64 implements Serializable
{
    private static final long serialVersionUID = 7249069246863182397L;
    
    public LongAdder() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void add(final long n) {
        try {
            final Cell[] cells;
            final Cell[] array = cells = this.cells;
            BytecodeManager.incBytecodes(5);
            Label_0154: {
                if (array == null) {
                    final long base = this.base;
                    final long n2 = base + n;
                    BytecodeManager.incBytecodes(9);
                    final boolean casBase = this.casBase(base, n2);
                    BytecodeManager.incBytecodes(1);
                    if (casBase) {
                        break Label_0154;
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
                            final long n4 = value + n;
                            BytecodeManager.incBytecodes(8);
                            BytecodeManager.incBytecodes(1);
                            cas = cell3.cas(value, n4);
                            BytecodeManager.incBytecodes(3);
                            if (cas) {
                                break Label_0154;
                            }
                        }
                    }
                }
                final LongBinaryOperator longBinaryOperator = null;
                final boolean b = cas;
                BytecodeManager.incBytecodes(5);
                this.longAccumulate(n, longBinaryOperator, b);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void increment() {
        try {
            final long n = 1L;
            BytecodeManager.incBytecodes(3);
            this.add(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void decrement() {
        try {
            final long n = -1L;
            BytecodeManager.incBytecodes(3);
            this.add(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long sum() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            long base = this.base;
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
                        base += cell.value;
                        BytecodeManager.incBytecodes(5);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n3 = base;
            BytecodeManager.incBytecodes(2);
            return n3;
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
    
    public long sumThenReset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            long base = this.base;
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
                    final Cell cell2;
                    final Cell cell = cell2 = cells[n];
                    BytecodeManager.incBytecodes(6);
                    if (cell != null) {
                        base += cell2.value;
                        BytecodeManager.incBytecodes(5);
                        cell2.value = 0L;
                        BytecodeManager.incBytecodes(3);
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n3 = base;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final long sum = this.sum();
            BytecodeManager.incBytecodes(1);
            final String string = Long.toString(sum);
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public long longValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final long sum = this.sum();
            BytecodeManager.incBytecodes(1);
            return sum;
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
    
    @Override
    public double doubleValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final double n = (double)this.sum();
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
        private final long value;
        
        SerializationProxy(final LongAdder longAdder) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.value = longAdder.sum();
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
                final LongAdder longAdder = new LongAdder();
                BytecodeManager.incBytecodes(1);
                longAdder.base = this.value;
                BytecodeManager.incBytecodes(4);
                final LongAdder longAdder2 = longAdder;
                BytecodeManager.incBytecodes(2);
                return longAdder2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
