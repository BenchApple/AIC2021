// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.function.LongConsumer;

public class LongSummaryStatistics implements LongConsumer, IntConsumer
{
    private long count;
    private long sum;
    private long min;
    private long max;
    
    public LongSummaryStatistics() {
        try {
            BytecodeManager.incBytecodes(2);
            this.min = Long.MAX_VALUE;
            BytecodeManager.incBytecodes(3);
            this.max = Long.MIN_VALUE;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void accept(final int n) {
        try {
            final long n2 = n;
            BytecodeManager.incBytecodes(4);
            this.accept(n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void accept(final long n) {
        try {
            ++this.count;
            BytecodeManager.incBytecodes(6);
            this.sum += n;
            BytecodeManager.incBytecodes(6);
            final long min = this.min;
            BytecodeManager.incBytecodes(5);
            this.min = Math.min(min, n);
            BytecodeManager.incBytecodes(1);
            final long max = this.max;
            BytecodeManager.incBytecodes(5);
            this.max = Math.max(max, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void combine(final LongSummaryStatistics longSummaryStatistics) {
        try {
            this.count += longSummaryStatistics.count;
            BytecodeManager.incBytecodes(7);
            this.sum += longSummaryStatistics.sum;
            BytecodeManager.incBytecodes(7);
            final long min = this.min;
            final long min2 = longSummaryStatistics.min;
            BytecodeManager.incBytecodes(6);
            this.min = Math.min(min, min2);
            BytecodeManager.incBytecodes(1);
            final long max = this.max;
            final long max2 = longSummaryStatistics.max;
            BytecodeManager.incBytecodes(6);
            this.max = Math.max(max, max2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getCount() {
        try {
            final long count = this.count;
            BytecodeManager.incBytecodes(3);
            return count;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getSum() {
        try {
            final long sum = this.sum;
            BytecodeManager.incBytecodes(3);
            return sum;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getMin() {
        try {
            final long min = this.min;
            BytecodeManager.incBytecodes(3);
            return min;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final long getMax() {
        try {
            final long max = this.max;
            BytecodeManager.incBytecodes(3);
            return max;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final double getAverage() {
        try {
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(this.getCount(), 0L);
            BytecodeManager.incBytecodes(3);
            double n3;
            if (n > 0) {
                BytecodeManager.incBytecodes(2);
                final double n2 = (double)this.getSum();
                BytecodeManager.incBytecodes(3);
                n3 = n2 / this.getCount();
                BytecodeManager.incBytecodes(3);
            }
            else {
                n3 = 0.0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final String format = "%s{count=%d, sum=%d, min=%d, average=%f, max=%d}";
            final Object[] args = new Object[6];
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final Class<? extends LongSummaryStatistics> class1 = this.getClass();
            BytecodeManager.incBytecodes(1);
            args[n] = class1.getSimpleName();
            final int n2 = 1;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final long count = this.getCount();
            BytecodeManager.incBytecodes(1);
            args[n2] = count;
            final int n3 = 2;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final long sum = this.getSum();
            BytecodeManager.incBytecodes(1);
            args[n3] = sum;
            final int n4 = 3;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final long min = this.getMin();
            BytecodeManager.incBytecodes(1);
            args[n4] = min;
            final int n5 = 4;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final double average = this.getAverage();
            BytecodeManager.incBytecodes(1);
            args[n5] = average;
            final int n6 = 5;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final long max = this.getMax();
            BytecodeManager.incBytecodes(1);
            args[n6] = max;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final String format2 = String.format(format, args);
            BytecodeManager.incBytecodes(1);
            return format2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
