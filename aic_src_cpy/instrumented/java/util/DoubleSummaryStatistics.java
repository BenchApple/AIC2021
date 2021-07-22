// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import instrumented.java.util.function.DoubleConsumer;

public class DoubleSummaryStatistics implements DoubleConsumer
{
    private long count;
    private double sum;
    private double sumCompensation;
    private double simpleSum;
    private double min;
    private double max;
    
    public DoubleSummaryStatistics() {
        try {
            BytecodeManager.incBytecodes(2);
            this.min = Double.POSITIVE_INFINITY;
            BytecodeManager.incBytecodes(3);
            this.max = Double.NEGATIVE_INFINITY;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void accept(final double n) {
        try {
            ++this.count;
            BytecodeManager.incBytecodes(6);
            this.simpleSum += n;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(3);
            this.sumWithCompensation(n);
            final double min = this.min;
            BytecodeManager.incBytecodes(5);
            this.min = Math.min(min, n);
            BytecodeManager.incBytecodes(1);
            final double max = this.max;
            BytecodeManager.incBytecodes(5);
            this.max = Math.max(max, n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void combine(final DoubleSummaryStatistics doubleSummaryStatistics) {
        try {
            this.count += doubleSummaryStatistics.count;
            BytecodeManager.incBytecodes(7);
            this.simpleSum += doubleSummaryStatistics.simpleSum;
            BytecodeManager.incBytecodes(7);
            final double sum = doubleSummaryStatistics.sum;
            BytecodeManager.incBytecodes(4);
            this.sumWithCompensation(sum);
            final double sumCompensation = doubleSummaryStatistics.sumCompensation;
            BytecodeManager.incBytecodes(4);
            this.sumWithCompensation(sumCompensation);
            final double min = this.min;
            final double min2 = doubleSummaryStatistics.min;
            BytecodeManager.incBytecodes(6);
            this.min = Math.min(min, min2);
            BytecodeManager.incBytecodes(1);
            final double max = this.max;
            final double max2 = doubleSummaryStatistics.max;
            BytecodeManager.incBytecodes(6);
            this.max = Math.max(max, max2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void sumWithCompensation(final double n) {
        try {
            final double n2 = n - this.sumCompensation;
            BytecodeManager.incBytecodes(5);
            final double sum = this.sum + n2;
            BytecodeManager.incBytecodes(5);
            this.sumCompensation = sum - this.sum - n2;
            BytecodeManager.incBytecodes(8);
            this.sum = sum;
            BytecodeManager.incBytecodes(3);
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
    
    public final double getSum() {
        try {
            final double n = this.sum + this.sumCompensation;
            BytecodeManager.incBytecodes(6);
            final double v = n;
            BytecodeManager.incBytecodes(2);
            final boolean naN = Double.isNaN(v);
            BytecodeManager.incBytecodes(1);
            if (naN) {
                final double simpleSum = this.simpleSum;
                BytecodeManager.incBytecodes(3);
                final boolean infinite = Double.isInfinite(simpleSum);
                BytecodeManager.incBytecodes(1);
                if (infinite) {
                    final double simpleSum2 = this.simpleSum;
                    BytecodeManager.incBytecodes(3);
                    return simpleSum2;
                }
            }
            final double n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final double getMin() {
        try {
            final double min = this.min;
            BytecodeManager.incBytecodes(3);
            return min;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final double getMax() {
        try {
            final double max = this.max;
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
            double n2;
            if (n > 0) {
                BytecodeManager.incBytecodes(2);
                final double sum = this.getSum();
                BytecodeManager.incBytecodes(2);
                n2 = sum / this.getCount();
                BytecodeManager.incBytecodes(3);
            }
            else {
                n2 = 0.0;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final String format = "%s{count=%d, sum=%f, min=%f, average=%f, max=%f}";
            final Object[] args = new Object[6];
            final int n = 0;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final Class<? extends DoubleSummaryStatistics> class1 = this.getClass();
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
            final double sum = this.getSum();
            BytecodeManager.incBytecodes(1);
            args[n3] = sum;
            final int n4 = 3;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
            final double min = this.getMin();
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
            final double max = this.getMax();
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
