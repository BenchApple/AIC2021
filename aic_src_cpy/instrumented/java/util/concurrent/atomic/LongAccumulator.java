// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.LongBinaryOperator;
import java.io.Serializable;

public class LongAccumulator extends Striped64 implements Serializable
{
    private static final long serialVersionUID = 7249069246863182397L;
    private final LongBinaryOperator function;
    private final long identity;
    
    public LongAccumulator(final LongBinaryOperator function, final long n) {
        try {
            BytecodeManager.incBytecodes(2);
            this.function = function;
            BytecodeManager.incBytecodes(3);
            this.identity = n;
            this.base = n;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void accumulate(final long n) {
        try {
            final Cell[] cells;
            final Cell[] array = cells = this.cells;
            BytecodeManager.incBytecodes(5);
            Label_0248: {
                if (array == null) {
                    final LongBinaryOperator function = this.function;
                    final long base;
                    final long n2 = base = this.base;
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    final long applyAsLong;
                    final long n3 = lcmp(applyAsLong = function.applyAsLong(n2, n), base);
                    BytecodeManager.incBytecodes(5);
                    if (n3 == 0) {
                        break Label_0248;
                    }
                    final long n4 = base;
                    final long n5 = applyAsLong;
                    BytecodeManager.incBytecodes(4);
                    final boolean casBase = this.casBase(n4, n5);
                    BytecodeManager.incBytecodes(1);
                    if (casBase) {
                        break Label_0248;
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
                            final LongBinaryOperator function2 = this.function;
                            final long value;
                            final long n7 = value = cell2.value;
                            BytecodeManager.incBytecodes(7);
                            BytecodeManager.incBytecodes(1);
                            final long applyAsLong2;
                            final long n8 = lcmp(applyAsLong2 = function2.applyAsLong(n7, n), value);
                            BytecodeManager.incBytecodes(5);
                            boolean b3 = false;
                            boolean b2 = false;
                            Label_0221: {
                                if (n8 != 0) {
                                    final Cell cell3 = cell2;
                                    final long n9 = value;
                                    final long n10 = applyAsLong2;
                                    BytecodeManager.incBytecodes(3);
                                    BytecodeManager.incBytecodes(1);
                                    final boolean cas = cell3.cas(n9, n10);
                                    BytecodeManager.incBytecodes(1);
                                    if (!cas) {
                                        b2 = (b3 = false);
                                        BytecodeManager.incBytecodes(1);
                                        break Label_0221;
                                    }
                                }
                                b2 = (b3 = true);
                                BytecodeManager.incBytecodes(2);
                            }
                            b = b3;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                break Label_0248;
                            }
                        }
                    }
                }
                final LongBinaryOperator function3 = this.function;
                final boolean b4 = b;
                BytecodeManager.incBytecodes(6);
                this.longAccumulate(n, function3, b4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public long get() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            long n = this.base;
            BytecodeManager.incBytecodes(3);
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
                        final LongBinaryOperator function = this.function;
                        final long n4 = n;
                        final long value = cell.value;
                        BytecodeManager.incBytecodes(6);
                        n = function.applyAsLong(n4, value);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n5 = n;
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
    
    public long getThenReset() {
        try {
            final Cell[] cells = this.cells;
            BytecodeManager.incBytecodes(3);
            long n = this.base;
            BytecodeManager.incBytecodes(3);
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
                        cell2.value = this.identity;
                        BytecodeManager.incBytecodes(4);
                        final LongBinaryOperator function = this.function;
                        final long n4 = n;
                        final long n5 = value;
                        BytecodeManager.incBytecodes(5);
                        n = function.applyAsLong(n4, n5);
                        BytecodeManager.incBytecodes(1);
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final long n6 = n;
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
            final long value = this.get();
            BytecodeManager.incBytecodes(1);
            final String string = Long.toString(value);
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
            final long value = this.get();
            BytecodeManager.incBytecodes(1);
            return value;
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
    
    @Override
    public double doubleValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final double n = (double)this.get();
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
    
    static /* synthetic */ LongBinaryOperator access$000(final LongAccumulator longAccumulator) {
        try {
            final LongBinaryOperator function = longAccumulator.function;
            BytecodeManager.incBytecodes(3);
            return function;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long access$100(final LongAccumulator longAccumulator) {
        try {
            final long identity = longAccumulator.identity;
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
        private final long value;
        private final LongBinaryOperator function;
        private final long identity;
        
        SerializationProxy(final LongAccumulator longAccumulator) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.function = LongAccumulator.access$000(longAccumulator);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.identity = LongAccumulator.access$100(longAccumulator);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                this.value = longAccumulator.get();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final LongBinaryOperator function = this.function;
                final long identity = this.identity;
                BytecodeManager.incBytecodes(7);
                final LongAccumulator longAccumulator = new LongAccumulator(function, identity);
                BytecodeManager.incBytecodes(1);
                longAccumulator.base = this.value;
                BytecodeManager.incBytecodes(4);
                final LongAccumulator longAccumulator2 = longAccumulator;
                BytecodeManager.incBytecodes(2);
                return longAccumulator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
