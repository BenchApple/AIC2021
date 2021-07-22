// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.concurrent.ForkJoinPool;
import instrumented.java.util.function.BinaryOperator;
import instrumented.java.util.concurrent.CountedCompleter;
import aic2021.engine.BytecodeManager;

class ArrayPrefixHelpers
{
    static final int CUMULATE = 1;
    static final int SUMMED = 2;
    static final int FINISHED = 4;
    static final int MIN_PARTITION = 16;
    
    private ArrayPrefixHelpers() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class CumulateTask<T> extends CountedCompleter<Void>
    {
        final T[] array;
        final BinaryOperator<T> function;
        CumulateTask<T> left;
        CumulateTask<T> right;
        T in;
        T out;
        final int lo;
        final int hi;
        final int origin;
        final int fence;
        final int threshold;
        
        public CumulateTask(final CumulateTask<T> cumulateTask, final BinaryOperator<T> function, final T[] array, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(3);
                super(cumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = n;
                this.lo = n;
                this.fence = n2;
                this.hi = n2;
                BytecodeManager.incBytecodes(12);
                final int n3 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int n4 = n3 / (ForkJoinPool.getCommonPoolParallelism() << 3);
                final int n5 = 16;
                BytecodeManager.incBytecodes(7);
                int threshold;
                if (n4 <= n5) {
                    threshold = 16;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    threshold = n4;
                    BytecodeManager.incBytecodes(1);
                }
                this.threshold = threshold;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CumulateTask(final CumulateTask<T> cumulateTask, final BinaryOperator<T> function, final T[] array, final int origin, final int fence, final int threshold, final int lo, final int hi) {
            try {
                BytecodeManager.incBytecodes(3);
                super(cumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = origin;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
                this.threshold = threshold;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                this.hi = hi;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final BinaryOperator<T> function;
                final BinaryOperator<T> binaryOperator = function = this.function;
                BytecodeManager.incBytecodes(5);
                if (binaryOperator != null) {
                    final T[] array2;
                    final T[] array = array2 = this.array;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        final int threshold = this.threshold;
                        final int origin = this.origin;
                        final int fence = this.fence;
                        BytecodeManager.incBytecodes(9);
                        CountedCompleter<Object> countedCompleter = (CountedCompleter<Object>)this;
                        BytecodeManager.incBytecodes(2);
                        Label_1356: {
                            Block_14: {
                                int lo;
                                int hi;
                                while (true) {
                                    final int n = lo = ((CumulateTask)countedCompleter).lo;
                                    BytecodeManager.incBytecodes(5);
                                    if (n < 0) {
                                        break Label_1356;
                                    }
                                    final int n2 = hi = ((CumulateTask)countedCompleter).hi;
                                    final int length = array2.length;
                                    BytecodeManager.incBytecodes(7);
                                    if (n2 > length) {
                                        break Label_1356;
                                    }
                                    final int n3 = hi - lo;
                                    final int n4 = threshold;
                                    BytecodeManager.incBytecodes(5);
                                    if (n3 <= n4) {
                                        break;
                                    }
                                    final CumulateTask<T> left = ((CumulateTask)countedCompleter).left;
                                    final CumulateTask<T> right = ((CumulateTask)countedCompleter).right;
                                    BytecodeManager.incBytecodes(6);
                                    final CumulateTask<T> cumulateTask = left;
                                    BytecodeManager.incBytecodes(2);
                                    CumulateTask cumulateTask2 = null;
                                    Label_0547: {
                                        if (cumulateTask != null) {
                                            final T in = ((CumulateTask)countedCompleter).in;
                                            BytecodeManager.incBytecodes(3);
                                            left.in = in;
                                            BytecodeManager.incBytecodes(3);
                                            countedCompleter = (CountedCompleter<Object>)(cumulateTask2 = null);
                                            BytecodeManager.incBytecodes(4);
                                            final CumulateTask<T> cumulateTask3 = right;
                                            BytecodeManager.incBytecodes(2);
                                            while (true) {
                                                Label_0438: {
                                                    if (cumulateTask3 != null) {
                                                        final T out = left.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final CumulateTask<T> cumulateTask4 = right;
                                                        final int n5 = lo;
                                                        final int n6 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        T apply;
                                                        if (n5 == n6) {
                                                            apply = out;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final BinaryOperator<T> binaryOperator2 = function;
                                                            final T t = in;
                                                            final T t2 = out;
                                                            BytecodeManager.incBytecodes(3);
                                                            BytecodeManager.incBytecodes(1);
                                                            apply = (T)binaryOperator2.apply(t, t2);
                                                        }
                                                        cumulateTask4.in = apply;
                                                        BytecodeManager.incBytecodes(1);
                                                        boolean compareAndSetPendingCount;
                                                        do {
                                                            final CumulateTask<T> cumulateTask5 = right;
                                                            BytecodeManager.incBytecodes(2);
                                                            final int pendingCount;
                                                            final int n7 = (pendingCount = cumulateTask5.getPendingCount()) & 0x1;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n7 != 0) {
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_0438;
                                                            }
                                                            final CumulateTask<T> cumulateTask6 = right;
                                                            final int n8 = pendingCount;
                                                            final int n9 = pendingCount | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount = cumulateTask6.compareAndSetPendingCount(n8, n9);
                                                            BytecodeManager.incBytecodes(1);
                                                        } while (!compareAndSetPendingCount);
                                                        countedCompleter = (CountedCompleter<Object>)right;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    boolean compareAndSetPendingCount2;
                                                    do {
                                                        final CumulateTask<T> cumulateTask7 = left;
                                                        BytecodeManager.incBytecodes(2);
                                                        final int pendingCount2;
                                                        final int n10 = (pendingCount2 = cumulateTask7.getPendingCount()) & 0x1;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n10 != 0) {
                                                            BytecodeManager.incBytecodes(1);
                                                            final CumulateTask cumulateTask8 = (CumulateTask)countedCompleter;
                                                            BytecodeManager.incBytecodes(2);
                                                            if (cumulateTask8 == null) {
                                                                break Block_14;
                                                            }
                                                            break Label_0547;
                                                        }
                                                        else {
                                                            final CumulateTask<T> cumulateTask9 = left;
                                                            final int n11 = pendingCount2;
                                                            final int n12 = pendingCount2 | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount2 = cumulateTask9.compareAndSetPendingCount(n11, n12);
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    } while (!compareAndSetPendingCount2);
                                                }
                                                final CumulateTask cumulateTask10 = (CumulateTask)countedCompleter;
                                                BytecodeManager.incBytecodes(2);
                                                if (cumulateTask10 != null) {
                                                    cumulateTask2 = (CumulateTask)countedCompleter;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                countedCompleter = (CountedCompleter<Object>)left;
                                                BytecodeManager.incBytecodes(2);
                                                BytecodeManager.incBytecodes(1);
                                                continue;
                                            }
                                        }
                                        final int n13 = lo + hi >>> 1;
                                        BytecodeManager.incBytecodes(6);
                                        final CumulateTask cumulateTask11 = (CumulateTask)countedCompleter;
                                        final CumulateTask<Object> cumulateTask12 = (CumulateTask<Object>)countedCompleter;
                                        final BinaryOperator<T> binaryOperator3 = function;
                                        final T[] array3 = array2;
                                        final int n14 = origin;
                                        final int n15 = fence;
                                        final int n16 = threshold;
                                        final int n17 = n13;
                                        final int n18 = hi;
                                        BytecodeManager.incBytecodes(12);
                                        final CumulateTask right2 = new CumulateTask(cumulateTask12, (BinaryOperator<Object>)binaryOperator3, array3, n14, n15, n16, n17, n18);
                                        cumulateTask11.right = right2;
                                        cumulateTask2 = right2;
                                        BytecodeManager.incBytecodes(5);
                                        final CumulateTask<Object> cumulateTask13 = (CumulateTask<Object>)countedCompleter;
                                        final CumulateTask<Object> cumulateTask14 = (CumulateTask<Object>)countedCompleter;
                                        final BinaryOperator<Object> binaryOperator4 = (BinaryOperator<Object>)function;
                                        final T[] array4 = array2;
                                        final int n19 = origin;
                                        final int n20 = fence;
                                        final int n21 = threshold;
                                        final int n22 = lo;
                                        final int n23 = n13;
                                        BytecodeManager.incBytecodes(12);
                                        final CumulateTask left2 = new CumulateTask<T>(cumulateTask14, binaryOperator4, array4, n19, n20, n21, n22, n23);
                                        cumulateTask13.left = (CumulateTask<Object>)left2;
                                        countedCompleter = (CountedCompleter<Object>)left2;
                                        BytecodeManager.incBytecodes(5);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final CumulateTask cumulateTask15 = cumulateTask2;
                                    BytecodeManager.incBytecodes(2);
                                    if (cumulateTask15 != null) {
                                        final CumulateTask cumulateTask16 = cumulateTask2;
                                        BytecodeManager.incBytecodes(2);
                                        cumulateTask16.fork();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                boolean compareAndSetPendingCount3;
                                int n29;
                                do {
                                    final CumulateTask<Object> cumulateTask17 = (CumulateTask<Object>)countedCompleter;
                                    BytecodeManager.incBytecodes(2);
                                    final int pendingCount3;
                                    final int n24 = (pendingCount3 = cumulateTask17.getPendingCount()) & 0x4;
                                    BytecodeManager.incBytecodes(5);
                                    if (n24 != 0) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1356;
                                    }
                                    final int n25 = pendingCount3 & 0x1;
                                    BytecodeManager.incBytecodes(4);
                                    int n26;
                                    if (n25 != 0) {
                                        n26 = 4;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final int n27 = lo;
                                        final int n28 = origin;
                                        BytecodeManager.incBytecodes(3);
                                        if (n27 > n28) {
                                            n26 = 2;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            n26 = 6;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    n29 = n26;
                                    BytecodeManager.incBytecodes(1);
                                    final CumulateTask<Object> cumulateTask18 = (CumulateTask<Object>)countedCompleter;
                                    final int n30 = pendingCount3;
                                    final int n31 = pendingCount3 | n29;
                                    BytecodeManager.incBytecodes(6);
                                    compareAndSetPendingCount3 = cumulateTask18.compareAndSetPendingCount(n30, n31);
                                    BytecodeManager.incBytecodes(1);
                                } while (!compareAndSetPendingCount3);
                                BytecodeManager.incBytecodes(1);
                                final int n32 = n29;
                                final int n33 = 2;
                                BytecodeManager.incBytecodes(3);
                                T out2;
                                if (n32 != n33) {
                                    final int n34 = lo;
                                    final int n35 = origin;
                                    BytecodeManager.incBytecodes(3);
                                    int n36;
                                    if (n34 == n35) {
                                        out2 = array2[origin];
                                        BytecodeManager.incBytecodes(4);
                                        n36 = origin + 1;
                                        BytecodeManager.incBytecodes(5);
                                    }
                                    else {
                                        out2 = ((CumulateTask)countedCompleter).in;
                                        BytecodeManager.incBytecodes(3);
                                        n36 = lo;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    int n37 = n36;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n38 = n37;
                                        final int n39 = hi;
                                        BytecodeManager.incBytecodes(3);
                                        if (n38 >= n39) {
                                            break;
                                        }
                                        final T[] array5 = array2;
                                        final int n40 = n37;
                                        final BinaryOperator<T> binaryOperator5 = function;
                                        final T t3 = out2;
                                        final T t4 = array2[n37];
                                        BytecodeManager.incBytecodes(8);
                                        out2 = (array5[n40] = (T)binaryOperator5.apply(t3, t4));
                                        BytecodeManager.incBytecodes(3);
                                        ++n37;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n41 = hi;
                                    final int n42 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n41 < n42) {
                                        out2 = array2[lo];
                                        BytecodeManager.incBytecodes(4);
                                        int n43 = lo + 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n44 = n43;
                                            final int n45 = hi;
                                            BytecodeManager.incBytecodes(3);
                                            if (n44 >= n45) {
                                                break;
                                            }
                                            final BinaryOperator<T> binaryOperator6 = function;
                                            final T t5 = out2;
                                            final T t6 = array2[n43];
                                            BytecodeManager.incBytecodes(6);
                                            out2 = (T)binaryOperator6.apply(t5, t6);
                                            BytecodeManager.incBytecodes(1);
                                            ++n43;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        out2 = ((CumulateTask)countedCompleter).in;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                ((CumulateTask)countedCompleter).out = out2;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final CumulateTask cumulateTask19 = (CumulateTask)countedCompleter;
                                    BytecodeManager.incBytecodes(2);
                                    final CumulateTask<Object> cumulateTask21;
                                    final CumulateTask<Object> cumulateTask20 = cumulateTask21 = (CumulateTask<Object>)cumulateTask19.getCompleter();
                                    BytecodeManager.incBytecodes(4);
                                    if (cumulateTask20 == null) {
                                        final int n46 = n29 & 0x4;
                                        BytecodeManager.incBytecodes(4);
                                        if (n46 != 0) {
                                            final CumulateTask cumulateTask22 = (CumulateTask)countedCompleter;
                                            BytecodeManager.incBytecodes(2);
                                            cumulateTask22.quietlyComplete();
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        break Label_1356;
                                    }
                                    else {
                                        final CumulateTask<Object> cumulateTask23 = cumulateTask21;
                                        BytecodeManager.incBytecodes(2);
                                        final int pendingCount4 = cumulateTask23.getPendingCount();
                                        BytecodeManager.incBytecodes(1);
                                        final int n47 = pendingCount4 & n29 & 0x4;
                                        BytecodeManager.incBytecodes(6);
                                        if (n47 != 0) {
                                            countedCompleter = (CountedCompleter<Object>)cumulateTask21;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            final int n48 = pendingCount4 & n29 & 0x2;
                                            BytecodeManager.incBytecodes(6);
                                            if (n48 != 0) {
                                                final CumulateTask<Object> left3 = cumulateTask21.left;
                                                BytecodeManager.incBytecodes(5);
                                                if (left3 != null) {
                                                    final CumulateTask<Object> right3;
                                                    final CumulateTask<Object> cumulateTask24 = right3 = cumulateTask21.right;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (cumulateTask24 != null) {
                                                        final Object out3 = left3.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final CumulateTask<Object> cumulateTask25 = cumulateTask21;
                                                        final int hi2 = right3.hi;
                                                        final int n49 = fence;
                                                        BytecodeManager.incBytecodes(5);
                                                        T apply2;
                                                        if (hi2 == n49) {
                                                            apply2 = (T)out3;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final BinaryOperator<T> binaryOperator7 = function;
                                                            final T t7 = (T)out3;
                                                            final Object out4 = right3.out;
                                                            BytecodeManager.incBytecodes(4);
                                                            BytecodeManager.incBytecodes(1);
                                                            apply2 = (T)binaryOperator7.apply(t7, (T)out4);
                                                        }
                                                        cumulateTask25.out = apply2;
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                final int n50 = pendingCount4 & 0x1;
                                                BytecodeManager.incBytecodes(4);
                                                int n52 = 0;
                                                Label_1209: {
                                                    if (n50 == 0) {
                                                        final int lo2 = cumulateTask21.lo;
                                                        final int n51 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        if (lo2 == n51) {
                                                            n52 = 1;
                                                            BytecodeManager.incBytecodes(2);
                                                            break Label_1209;
                                                        }
                                                    }
                                                    n52 = 0;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                final int n53 = n52;
                                                BytecodeManager.incBytecodes(1);
                                                final int n54 = pendingCount4 | n29 | n53;
                                                final int n55 = pendingCount4;
                                                BytecodeManager.incBytecodes(9);
                                                Label_1307: {
                                                    if (n54 != n55) {
                                                        final CumulateTask<Object> cumulateTask26 = cumulateTask21;
                                                        final int n56 = pendingCount4;
                                                        final int n57 = n54;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final boolean compareAndSetPendingCount4 = cumulateTask26.compareAndSetPendingCount(n56, n57);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (!compareAndSetPendingCount4) {
                                                            break Label_1307;
                                                        }
                                                    }
                                                    n29 = 2;
                                                    BytecodeManager.incBytecodes(2);
                                                    countedCompleter = (CountedCompleter<Object>)cumulateTask21;
                                                    BytecodeManager.incBytecodes(2);
                                                    final int n58 = n53;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (n58 != 0) {
                                                        final CumulateTask<Object> cumulateTask27 = cumulateTask21;
                                                        BytecodeManager.incBytecodes(2);
                                                        cumulateTask27.fork();
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final CumulateTask<Object> cumulateTask28 = cumulateTask21;
                                                final int n59 = pendingCount4;
                                                final int n60 = pendingCount4 | n29;
                                                BytecodeManager.incBytecodes(6);
                                                final boolean compareAndSetPendingCount5 = cumulateTask28.compareAndSetPendingCount(n59, n60);
                                                BytecodeManager.incBytecodes(1);
                                                if (compareAndSetPendingCount5) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_1356;
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LongCumulateTask extends CountedCompleter<Void>
    {
        final long[] array;
        final LongBinaryOperator function;
        LongCumulateTask left;
        LongCumulateTask right;
        long in;
        long out;
        final int lo;
        final int hi;
        final int origin;
        final int fence;
        final int threshold;
        
        public LongCumulateTask(final LongCumulateTask longCumulateTask, final LongBinaryOperator function, final long[] array, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(3);
                super(longCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = n;
                this.lo = n;
                this.fence = n2;
                this.hi = n2;
                BytecodeManager.incBytecodes(12);
                final int n3 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int n4 = n3 / (ForkJoinPool.getCommonPoolParallelism() << 3);
                final int n5 = 16;
                BytecodeManager.incBytecodes(7);
                int threshold;
                if (n4 <= n5) {
                    threshold = 16;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    threshold = n4;
                    BytecodeManager.incBytecodes(1);
                }
                this.threshold = threshold;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        LongCumulateTask(final LongCumulateTask longCumulateTask, final LongBinaryOperator function, final long[] array, final int origin, final int fence, final int threshold, final int lo, final int hi) {
            try {
                BytecodeManager.incBytecodes(3);
                super(longCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = origin;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
                this.threshold = threshold;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                this.hi = hi;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final LongBinaryOperator function;
                final LongBinaryOperator longBinaryOperator = function = this.function;
                BytecodeManager.incBytecodes(5);
                if (longBinaryOperator != null) {
                    final long[] array2;
                    final long[] array = array2 = this.array;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        final int threshold = this.threshold;
                        final int origin = this.origin;
                        final int fence = this.fence;
                        BytecodeManager.incBytecodes(9);
                        LongCumulateTask longCumulateTask = this;
                        BytecodeManager.incBytecodes(2);
                        Label_1356: {
                            Block_14: {
                                int lo;
                                int hi;
                                while (true) {
                                    final int n = lo = longCumulateTask.lo;
                                    BytecodeManager.incBytecodes(5);
                                    if (n < 0) {
                                        break Label_1356;
                                    }
                                    final int n2 = hi = longCumulateTask.hi;
                                    final int length = array2.length;
                                    BytecodeManager.incBytecodes(7);
                                    if (n2 > length) {
                                        break Label_1356;
                                    }
                                    final int n3 = hi - lo;
                                    final int n4 = threshold;
                                    BytecodeManager.incBytecodes(5);
                                    if (n3 <= n4) {
                                        break;
                                    }
                                    final LongCumulateTask left = longCumulateTask.left;
                                    final LongCumulateTask right = longCumulateTask.right;
                                    BytecodeManager.incBytecodes(6);
                                    final LongCumulateTask longCumulateTask2 = left;
                                    BytecodeManager.incBytecodes(2);
                                    LongCumulateTask longCumulateTask3 = null;
                                    Label_0547: {
                                        if (longCumulateTask2 != null) {
                                            final long in = longCumulateTask.in;
                                            BytecodeManager.incBytecodes(3);
                                            left.in = in;
                                            BytecodeManager.incBytecodes(3);
                                            longCumulateTask = (longCumulateTask3 = null);
                                            BytecodeManager.incBytecodes(4);
                                            final LongCumulateTask longCumulateTask4 = right;
                                            BytecodeManager.incBytecodes(2);
                                            while (true) {
                                                Label_0438: {
                                                    if (longCumulateTask4 != null) {
                                                        final long out = left.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final LongCumulateTask longCumulateTask5 = right;
                                                        final int n5 = lo;
                                                        final int n6 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        long applyAsLong;
                                                        if (n5 == n6) {
                                                            applyAsLong = out;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final LongBinaryOperator longBinaryOperator2 = function;
                                                            final long n7 = in;
                                                            final long n8 = out;
                                                            BytecodeManager.incBytecodes(3);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsLong = longBinaryOperator2.applyAsLong(n7, n8);
                                                        }
                                                        longCumulateTask5.in = applyAsLong;
                                                        BytecodeManager.incBytecodes(1);
                                                        boolean compareAndSetPendingCount;
                                                        do {
                                                            final LongCumulateTask longCumulateTask6 = right;
                                                            BytecodeManager.incBytecodes(2);
                                                            final int pendingCount;
                                                            final int n9 = (pendingCount = longCumulateTask6.getPendingCount()) & 0x1;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n9 != 0) {
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_0438;
                                                            }
                                                            final LongCumulateTask longCumulateTask7 = right;
                                                            final int n10 = pendingCount;
                                                            final int n11 = pendingCount | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount = longCumulateTask7.compareAndSetPendingCount(n10, n11);
                                                            BytecodeManager.incBytecodes(1);
                                                        } while (!compareAndSetPendingCount);
                                                        longCumulateTask = right;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    boolean compareAndSetPendingCount2;
                                                    do {
                                                        final LongCumulateTask longCumulateTask8 = left;
                                                        BytecodeManager.incBytecodes(2);
                                                        final int pendingCount2;
                                                        final int n12 = (pendingCount2 = longCumulateTask8.getPendingCount()) & 0x1;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n12 != 0) {
                                                            BytecodeManager.incBytecodes(1);
                                                            final LongCumulateTask longCumulateTask9 = longCumulateTask;
                                                            BytecodeManager.incBytecodes(2);
                                                            if (longCumulateTask9 == null) {
                                                                break Block_14;
                                                            }
                                                            break Label_0547;
                                                        }
                                                        else {
                                                            final LongCumulateTask longCumulateTask10 = left;
                                                            final int n13 = pendingCount2;
                                                            final int n14 = pendingCount2 | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount2 = longCumulateTask10.compareAndSetPendingCount(n13, n14);
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    } while (!compareAndSetPendingCount2);
                                                }
                                                final LongCumulateTask longCumulateTask11 = longCumulateTask;
                                                BytecodeManager.incBytecodes(2);
                                                if (longCumulateTask11 != null) {
                                                    longCumulateTask3 = longCumulateTask;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                longCumulateTask = left;
                                                BytecodeManager.incBytecodes(2);
                                                BytecodeManager.incBytecodes(1);
                                                continue;
                                            }
                                        }
                                        final int n15 = lo + hi >>> 1;
                                        BytecodeManager.incBytecodes(6);
                                        final LongCumulateTask longCumulateTask12 = longCumulateTask;
                                        final LongCumulateTask longCumulateTask13 = longCumulateTask;
                                        final LongBinaryOperator longBinaryOperator3 = function;
                                        final long[] array3 = array2;
                                        final int n16 = origin;
                                        final int n17 = fence;
                                        final int n18 = threshold;
                                        final int n19 = n15;
                                        final int n20 = hi;
                                        BytecodeManager.incBytecodes(12);
                                        final LongCumulateTask right2 = new LongCumulateTask(longCumulateTask13, longBinaryOperator3, array3, n16, n17, n18, n19, n20);
                                        longCumulateTask12.right = right2;
                                        longCumulateTask3 = right2;
                                        BytecodeManager.incBytecodes(5);
                                        final LongCumulateTask longCumulateTask14 = longCumulateTask;
                                        final LongCumulateTask longCumulateTask15 = longCumulateTask;
                                        final LongBinaryOperator longBinaryOperator4 = function;
                                        final long[] array4 = array2;
                                        final int n21 = origin;
                                        final int n22 = fence;
                                        final int n23 = threshold;
                                        final int n24 = lo;
                                        final int n25 = n15;
                                        BytecodeManager.incBytecodes(12);
                                        final LongCumulateTask left2 = new LongCumulateTask(longCumulateTask15, longBinaryOperator4, array4, n21, n22, n23, n24, n25);
                                        longCumulateTask14.left = left2;
                                        longCumulateTask = left2;
                                        BytecodeManager.incBytecodes(5);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final LongCumulateTask longCumulateTask16 = longCumulateTask3;
                                    BytecodeManager.incBytecodes(2);
                                    if (longCumulateTask16 != null) {
                                        final LongCumulateTask longCumulateTask17 = longCumulateTask3;
                                        BytecodeManager.incBytecodes(2);
                                        longCumulateTask17.fork();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                boolean compareAndSetPendingCount3;
                                int n31;
                                do {
                                    final LongCumulateTask longCumulateTask18 = longCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final int pendingCount3;
                                    final int n26 = (pendingCount3 = longCumulateTask18.getPendingCount()) & 0x4;
                                    BytecodeManager.incBytecodes(5);
                                    if (n26 != 0) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1356;
                                    }
                                    final int n27 = pendingCount3 & 0x1;
                                    BytecodeManager.incBytecodes(4);
                                    int n28;
                                    if (n27 != 0) {
                                        n28 = 4;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final int n29 = lo;
                                        final int n30 = origin;
                                        BytecodeManager.incBytecodes(3);
                                        if (n29 > n30) {
                                            n28 = 2;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            n28 = 6;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    n31 = n28;
                                    BytecodeManager.incBytecodes(1);
                                    final LongCumulateTask longCumulateTask19 = longCumulateTask;
                                    final int n32 = pendingCount3;
                                    final int n33 = pendingCount3 | n31;
                                    BytecodeManager.incBytecodes(6);
                                    compareAndSetPendingCount3 = longCumulateTask19.compareAndSetPendingCount(n32, n33);
                                    BytecodeManager.incBytecodes(1);
                                } while (!compareAndSetPendingCount3);
                                BytecodeManager.incBytecodes(1);
                                final int n34 = n31;
                                final int n35 = 2;
                                BytecodeManager.incBytecodes(3);
                                long out2;
                                if (n34 != n35) {
                                    final int n36 = lo;
                                    final int n37 = origin;
                                    BytecodeManager.incBytecodes(3);
                                    int n38;
                                    if (n36 == n37) {
                                        out2 = array2[origin];
                                        BytecodeManager.incBytecodes(4);
                                        n38 = origin + 1;
                                        BytecodeManager.incBytecodes(5);
                                    }
                                    else {
                                        out2 = longCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                        n38 = lo;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    int n39 = n38;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n40 = n39;
                                        final int n41 = hi;
                                        BytecodeManager.incBytecodes(3);
                                        if (n40 >= n41) {
                                            break;
                                        }
                                        final long[] array5 = array2;
                                        final int n42 = n39;
                                        final LongBinaryOperator longBinaryOperator5 = function;
                                        final long n43 = out2;
                                        final long n44 = array2[n39];
                                        BytecodeManager.incBytecodes(8);
                                        out2 = (array5[n42] = longBinaryOperator5.applyAsLong(n43, n44));
                                        BytecodeManager.incBytecodes(3);
                                        ++n39;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n45 = hi;
                                    final int n46 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n45 < n46) {
                                        out2 = array2[lo];
                                        BytecodeManager.incBytecodes(4);
                                        int n47 = lo + 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n48 = n47;
                                            final int n49 = hi;
                                            BytecodeManager.incBytecodes(3);
                                            if (n48 >= n49) {
                                                break;
                                            }
                                            final LongBinaryOperator longBinaryOperator6 = function;
                                            final long n50 = out2;
                                            final long n51 = array2[n47];
                                            BytecodeManager.incBytecodes(6);
                                            out2 = longBinaryOperator6.applyAsLong(n50, n51);
                                            BytecodeManager.incBytecodes(1);
                                            ++n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        out2 = longCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                longCumulateTask.out = out2;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final LongCumulateTask longCumulateTask20 = longCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final LongCumulateTask longCumulateTask22;
                                    final LongCumulateTask longCumulateTask21 = longCumulateTask22 = (LongCumulateTask)longCumulateTask20.getCompleter();
                                    BytecodeManager.incBytecodes(4);
                                    if (longCumulateTask21 == null) {
                                        final int n52 = n31 & 0x4;
                                        BytecodeManager.incBytecodes(4);
                                        if (n52 != 0) {
                                            final LongCumulateTask longCumulateTask23 = longCumulateTask;
                                            BytecodeManager.incBytecodes(2);
                                            longCumulateTask23.quietlyComplete();
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        break Label_1356;
                                    }
                                    else {
                                        final LongCumulateTask longCumulateTask24 = longCumulateTask22;
                                        BytecodeManager.incBytecodes(2);
                                        final int pendingCount4 = longCumulateTask24.getPendingCount();
                                        BytecodeManager.incBytecodes(1);
                                        final int n53 = pendingCount4 & n31 & 0x4;
                                        BytecodeManager.incBytecodes(6);
                                        if (n53 != 0) {
                                            longCumulateTask = longCumulateTask22;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            final int n54 = pendingCount4 & n31 & 0x2;
                                            BytecodeManager.incBytecodes(6);
                                            if (n54 != 0) {
                                                final LongCumulateTask left3 = longCumulateTask22.left;
                                                BytecodeManager.incBytecodes(5);
                                                if (left3 != null) {
                                                    final LongCumulateTask right3;
                                                    final LongCumulateTask longCumulateTask25 = right3 = longCumulateTask22.right;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (longCumulateTask25 != null) {
                                                        final long out3 = left3.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final LongCumulateTask longCumulateTask26 = longCumulateTask22;
                                                        final int hi2 = right3.hi;
                                                        final int n55 = fence;
                                                        BytecodeManager.incBytecodes(5);
                                                        long applyAsLong2;
                                                        if (hi2 == n55) {
                                                            applyAsLong2 = out3;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final LongBinaryOperator longBinaryOperator7 = function;
                                                            final long n56 = out3;
                                                            final long out4 = right3.out;
                                                            BytecodeManager.incBytecodes(4);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsLong2 = longBinaryOperator7.applyAsLong(n56, out4);
                                                        }
                                                        longCumulateTask26.out = applyAsLong2;
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                final int n57 = pendingCount4 & 0x1;
                                                BytecodeManager.incBytecodes(4);
                                                int n59 = 0;
                                                Label_1209: {
                                                    if (n57 == 0) {
                                                        final int lo2 = longCumulateTask22.lo;
                                                        final int n58 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        if (lo2 == n58) {
                                                            n59 = 1;
                                                            BytecodeManager.incBytecodes(2);
                                                            break Label_1209;
                                                        }
                                                    }
                                                    n59 = 0;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                final int n60 = n59;
                                                BytecodeManager.incBytecodes(1);
                                                final int n61 = pendingCount4 | n31 | n60;
                                                final int n62 = pendingCount4;
                                                BytecodeManager.incBytecodes(9);
                                                Label_1307: {
                                                    if (n61 != n62) {
                                                        final LongCumulateTask longCumulateTask27 = longCumulateTask22;
                                                        final int n63 = pendingCount4;
                                                        final int n64 = n61;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final boolean compareAndSetPendingCount4 = longCumulateTask27.compareAndSetPendingCount(n63, n64);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (!compareAndSetPendingCount4) {
                                                            break Label_1307;
                                                        }
                                                    }
                                                    n31 = 2;
                                                    BytecodeManager.incBytecodes(2);
                                                    longCumulateTask = longCumulateTask22;
                                                    BytecodeManager.incBytecodes(2);
                                                    final int n65 = n60;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (n65 != 0) {
                                                        final LongCumulateTask longCumulateTask28 = longCumulateTask22;
                                                        BytecodeManager.incBytecodes(2);
                                                        longCumulateTask28.fork();
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final LongCumulateTask longCumulateTask29 = longCumulateTask22;
                                                final int n66 = pendingCount4;
                                                final int n67 = pendingCount4 | n31;
                                                BytecodeManager.incBytecodes(6);
                                                final boolean compareAndSetPendingCount5 = longCumulateTask29.compareAndSetPendingCount(n66, n67);
                                                BytecodeManager.incBytecodes(1);
                                                if (compareAndSetPendingCount5) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_1356;
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class DoubleCumulateTask extends CountedCompleter<Void>
    {
        final double[] array;
        final DoubleBinaryOperator function;
        DoubleCumulateTask left;
        DoubleCumulateTask right;
        double in;
        double out;
        final int lo;
        final int hi;
        final int origin;
        final int fence;
        final int threshold;
        
        public DoubleCumulateTask(final DoubleCumulateTask doubleCumulateTask, final DoubleBinaryOperator function, final double[] array, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(3);
                super(doubleCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = n;
                this.lo = n;
                this.fence = n2;
                this.hi = n2;
                BytecodeManager.incBytecodes(12);
                final int n3 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int n4 = n3 / (ForkJoinPool.getCommonPoolParallelism() << 3);
                final int n5 = 16;
                BytecodeManager.incBytecodes(7);
                int threshold;
                if (n4 <= n5) {
                    threshold = 16;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    threshold = n4;
                    BytecodeManager.incBytecodes(1);
                }
                this.threshold = threshold;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        DoubleCumulateTask(final DoubleCumulateTask doubleCumulateTask, final DoubleBinaryOperator function, final double[] array, final int origin, final int fence, final int threshold, final int lo, final int hi) {
            try {
                BytecodeManager.incBytecodes(3);
                super(doubleCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = origin;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
                this.threshold = threshold;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                this.hi = hi;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final DoubleBinaryOperator function;
                final DoubleBinaryOperator doubleBinaryOperator = function = this.function;
                BytecodeManager.incBytecodes(5);
                if (doubleBinaryOperator != null) {
                    final double[] array2;
                    final double[] array = array2 = this.array;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        final int threshold = this.threshold;
                        final int origin = this.origin;
                        final int fence = this.fence;
                        BytecodeManager.incBytecodes(9);
                        DoubleCumulateTask doubleCumulateTask = this;
                        BytecodeManager.incBytecodes(2);
                        Label_1356: {
                            Block_14: {
                                int lo;
                                int hi;
                                while (true) {
                                    final int n = lo = doubleCumulateTask.lo;
                                    BytecodeManager.incBytecodes(5);
                                    if (n < 0) {
                                        break Label_1356;
                                    }
                                    final int n2 = hi = doubleCumulateTask.hi;
                                    final int length = array2.length;
                                    BytecodeManager.incBytecodes(7);
                                    if (n2 > length) {
                                        break Label_1356;
                                    }
                                    final int n3 = hi - lo;
                                    final int n4 = threshold;
                                    BytecodeManager.incBytecodes(5);
                                    if (n3 <= n4) {
                                        break;
                                    }
                                    final DoubleCumulateTask left = doubleCumulateTask.left;
                                    final DoubleCumulateTask right = doubleCumulateTask.right;
                                    BytecodeManager.incBytecodes(6);
                                    final DoubleCumulateTask doubleCumulateTask2 = left;
                                    BytecodeManager.incBytecodes(2);
                                    DoubleCumulateTask doubleCumulateTask3 = null;
                                    Label_0547: {
                                        if (doubleCumulateTask2 != null) {
                                            final double in = doubleCumulateTask.in;
                                            BytecodeManager.incBytecodes(3);
                                            left.in = in;
                                            BytecodeManager.incBytecodes(3);
                                            doubleCumulateTask = (doubleCumulateTask3 = null);
                                            BytecodeManager.incBytecodes(4);
                                            final DoubleCumulateTask doubleCumulateTask4 = right;
                                            BytecodeManager.incBytecodes(2);
                                            while (true) {
                                                Label_0438: {
                                                    if (doubleCumulateTask4 != null) {
                                                        final double out = left.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final DoubleCumulateTask doubleCumulateTask5 = right;
                                                        final int n5 = lo;
                                                        final int n6 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        double applyAsDouble;
                                                        if (n5 == n6) {
                                                            applyAsDouble = out;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final DoubleBinaryOperator doubleBinaryOperator2 = function;
                                                            final double n7 = in;
                                                            final double n8 = out;
                                                            BytecodeManager.incBytecodes(3);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsDouble = doubleBinaryOperator2.applyAsDouble(n7, n8);
                                                        }
                                                        doubleCumulateTask5.in = applyAsDouble;
                                                        BytecodeManager.incBytecodes(1);
                                                        boolean compareAndSetPendingCount;
                                                        do {
                                                            final DoubleCumulateTask doubleCumulateTask6 = right;
                                                            BytecodeManager.incBytecodes(2);
                                                            final int pendingCount;
                                                            final int n9 = (pendingCount = doubleCumulateTask6.getPendingCount()) & 0x1;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n9 != 0) {
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_0438;
                                                            }
                                                            final DoubleCumulateTask doubleCumulateTask7 = right;
                                                            final int n10 = pendingCount;
                                                            final int n11 = pendingCount | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount = doubleCumulateTask7.compareAndSetPendingCount(n10, n11);
                                                            BytecodeManager.incBytecodes(1);
                                                        } while (!compareAndSetPendingCount);
                                                        doubleCumulateTask = right;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    boolean compareAndSetPendingCount2;
                                                    do {
                                                        final DoubleCumulateTask doubleCumulateTask8 = left;
                                                        BytecodeManager.incBytecodes(2);
                                                        final int pendingCount2;
                                                        final int n12 = (pendingCount2 = doubleCumulateTask8.getPendingCount()) & 0x1;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n12 != 0) {
                                                            BytecodeManager.incBytecodes(1);
                                                            final DoubleCumulateTask doubleCumulateTask9 = doubleCumulateTask;
                                                            BytecodeManager.incBytecodes(2);
                                                            if (doubleCumulateTask9 == null) {
                                                                break Block_14;
                                                            }
                                                            break Label_0547;
                                                        }
                                                        else {
                                                            final DoubleCumulateTask doubleCumulateTask10 = left;
                                                            final int n13 = pendingCount2;
                                                            final int n14 = pendingCount2 | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount2 = doubleCumulateTask10.compareAndSetPendingCount(n13, n14);
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    } while (!compareAndSetPendingCount2);
                                                }
                                                final DoubleCumulateTask doubleCumulateTask11 = doubleCumulateTask;
                                                BytecodeManager.incBytecodes(2);
                                                if (doubleCumulateTask11 != null) {
                                                    doubleCumulateTask3 = doubleCumulateTask;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                doubleCumulateTask = left;
                                                BytecodeManager.incBytecodes(2);
                                                BytecodeManager.incBytecodes(1);
                                                continue;
                                            }
                                        }
                                        final int n15 = lo + hi >>> 1;
                                        BytecodeManager.incBytecodes(6);
                                        final DoubleCumulateTask doubleCumulateTask12 = doubleCumulateTask;
                                        final DoubleCumulateTask doubleCumulateTask13 = doubleCumulateTask;
                                        final DoubleBinaryOperator doubleBinaryOperator3 = function;
                                        final double[] array3 = array2;
                                        final int n16 = origin;
                                        final int n17 = fence;
                                        final int n18 = threshold;
                                        final int n19 = n15;
                                        final int n20 = hi;
                                        BytecodeManager.incBytecodes(12);
                                        final DoubleCumulateTask right2 = new DoubleCumulateTask(doubleCumulateTask13, doubleBinaryOperator3, array3, n16, n17, n18, n19, n20);
                                        doubleCumulateTask12.right = right2;
                                        doubleCumulateTask3 = right2;
                                        BytecodeManager.incBytecodes(5);
                                        final DoubleCumulateTask doubleCumulateTask14 = doubleCumulateTask;
                                        final DoubleCumulateTask doubleCumulateTask15 = doubleCumulateTask;
                                        final DoubleBinaryOperator doubleBinaryOperator4 = function;
                                        final double[] array4 = array2;
                                        final int n21 = origin;
                                        final int n22 = fence;
                                        final int n23 = threshold;
                                        final int n24 = lo;
                                        final int n25 = n15;
                                        BytecodeManager.incBytecodes(12);
                                        final DoubleCumulateTask left2 = new DoubleCumulateTask(doubleCumulateTask15, doubleBinaryOperator4, array4, n21, n22, n23, n24, n25);
                                        doubleCumulateTask14.left = left2;
                                        doubleCumulateTask = left2;
                                        BytecodeManager.incBytecodes(5);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final DoubleCumulateTask doubleCumulateTask16 = doubleCumulateTask3;
                                    BytecodeManager.incBytecodes(2);
                                    if (doubleCumulateTask16 != null) {
                                        final DoubleCumulateTask doubleCumulateTask17 = doubleCumulateTask3;
                                        BytecodeManager.incBytecodes(2);
                                        doubleCumulateTask17.fork();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                boolean compareAndSetPendingCount3;
                                int n31;
                                do {
                                    final DoubleCumulateTask doubleCumulateTask18 = doubleCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final int pendingCount3;
                                    final int n26 = (pendingCount3 = doubleCumulateTask18.getPendingCount()) & 0x4;
                                    BytecodeManager.incBytecodes(5);
                                    if (n26 != 0) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1356;
                                    }
                                    final int n27 = pendingCount3 & 0x1;
                                    BytecodeManager.incBytecodes(4);
                                    int n28;
                                    if (n27 != 0) {
                                        n28 = 4;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final int n29 = lo;
                                        final int n30 = origin;
                                        BytecodeManager.incBytecodes(3);
                                        if (n29 > n30) {
                                            n28 = 2;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            n28 = 6;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    n31 = n28;
                                    BytecodeManager.incBytecodes(1);
                                    final DoubleCumulateTask doubleCumulateTask19 = doubleCumulateTask;
                                    final int n32 = pendingCount3;
                                    final int n33 = pendingCount3 | n31;
                                    BytecodeManager.incBytecodes(6);
                                    compareAndSetPendingCount3 = doubleCumulateTask19.compareAndSetPendingCount(n32, n33);
                                    BytecodeManager.incBytecodes(1);
                                } while (!compareAndSetPendingCount3);
                                BytecodeManager.incBytecodes(1);
                                final int n34 = n31;
                                final int n35 = 2;
                                BytecodeManager.incBytecodes(3);
                                double out2;
                                if (n34 != n35) {
                                    final int n36 = lo;
                                    final int n37 = origin;
                                    BytecodeManager.incBytecodes(3);
                                    int n38;
                                    if (n36 == n37) {
                                        out2 = array2[origin];
                                        BytecodeManager.incBytecodes(4);
                                        n38 = origin + 1;
                                        BytecodeManager.incBytecodes(5);
                                    }
                                    else {
                                        out2 = doubleCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                        n38 = lo;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    int n39 = n38;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n40 = n39;
                                        final int n41 = hi;
                                        BytecodeManager.incBytecodes(3);
                                        if (n40 >= n41) {
                                            break;
                                        }
                                        final double[] array5 = array2;
                                        final int n42 = n39;
                                        final DoubleBinaryOperator doubleBinaryOperator5 = function;
                                        final double n43 = out2;
                                        final double n44 = array2[n39];
                                        BytecodeManager.incBytecodes(8);
                                        out2 = (array5[n42] = doubleBinaryOperator5.applyAsDouble(n43, n44));
                                        BytecodeManager.incBytecodes(3);
                                        ++n39;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n45 = hi;
                                    final int n46 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n45 < n46) {
                                        out2 = array2[lo];
                                        BytecodeManager.incBytecodes(4);
                                        int n47 = lo + 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n48 = n47;
                                            final int n49 = hi;
                                            BytecodeManager.incBytecodes(3);
                                            if (n48 >= n49) {
                                                break;
                                            }
                                            final DoubleBinaryOperator doubleBinaryOperator6 = function;
                                            final double n50 = out2;
                                            final double n51 = array2[n47];
                                            BytecodeManager.incBytecodes(6);
                                            out2 = doubleBinaryOperator6.applyAsDouble(n50, n51);
                                            BytecodeManager.incBytecodes(1);
                                            ++n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        out2 = doubleCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                doubleCumulateTask.out = out2;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final DoubleCumulateTask doubleCumulateTask20 = doubleCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final DoubleCumulateTask doubleCumulateTask22;
                                    final DoubleCumulateTask doubleCumulateTask21 = doubleCumulateTask22 = (DoubleCumulateTask)doubleCumulateTask20.getCompleter();
                                    BytecodeManager.incBytecodes(4);
                                    if (doubleCumulateTask21 == null) {
                                        final int n52 = n31 & 0x4;
                                        BytecodeManager.incBytecodes(4);
                                        if (n52 != 0) {
                                            final DoubleCumulateTask doubleCumulateTask23 = doubleCumulateTask;
                                            BytecodeManager.incBytecodes(2);
                                            doubleCumulateTask23.quietlyComplete();
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        break Label_1356;
                                    }
                                    else {
                                        final DoubleCumulateTask doubleCumulateTask24 = doubleCumulateTask22;
                                        BytecodeManager.incBytecodes(2);
                                        final int pendingCount4 = doubleCumulateTask24.getPendingCount();
                                        BytecodeManager.incBytecodes(1);
                                        final int n53 = pendingCount4 & n31 & 0x4;
                                        BytecodeManager.incBytecodes(6);
                                        if (n53 != 0) {
                                            doubleCumulateTask = doubleCumulateTask22;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            final int n54 = pendingCount4 & n31 & 0x2;
                                            BytecodeManager.incBytecodes(6);
                                            if (n54 != 0) {
                                                final DoubleCumulateTask left3 = doubleCumulateTask22.left;
                                                BytecodeManager.incBytecodes(5);
                                                if (left3 != null) {
                                                    final DoubleCumulateTask right3;
                                                    final DoubleCumulateTask doubleCumulateTask25 = right3 = doubleCumulateTask22.right;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (doubleCumulateTask25 != null) {
                                                        final double out3 = left3.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final DoubleCumulateTask doubleCumulateTask26 = doubleCumulateTask22;
                                                        final int hi2 = right3.hi;
                                                        final int n55 = fence;
                                                        BytecodeManager.incBytecodes(5);
                                                        double applyAsDouble2;
                                                        if (hi2 == n55) {
                                                            applyAsDouble2 = out3;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final DoubleBinaryOperator doubleBinaryOperator7 = function;
                                                            final double n56 = out3;
                                                            final double out4 = right3.out;
                                                            BytecodeManager.incBytecodes(4);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsDouble2 = doubleBinaryOperator7.applyAsDouble(n56, out4);
                                                        }
                                                        doubleCumulateTask26.out = applyAsDouble2;
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                final int n57 = pendingCount4 & 0x1;
                                                BytecodeManager.incBytecodes(4);
                                                int n59 = 0;
                                                Label_1209: {
                                                    if (n57 == 0) {
                                                        final int lo2 = doubleCumulateTask22.lo;
                                                        final int n58 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        if (lo2 == n58) {
                                                            n59 = 1;
                                                            BytecodeManager.incBytecodes(2);
                                                            break Label_1209;
                                                        }
                                                    }
                                                    n59 = 0;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                final int n60 = n59;
                                                BytecodeManager.incBytecodes(1);
                                                final int n61 = pendingCount4 | n31 | n60;
                                                final int n62 = pendingCount4;
                                                BytecodeManager.incBytecodes(9);
                                                Label_1307: {
                                                    if (n61 != n62) {
                                                        final DoubleCumulateTask doubleCumulateTask27 = doubleCumulateTask22;
                                                        final int n63 = pendingCount4;
                                                        final int n64 = n61;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final boolean compareAndSetPendingCount4 = doubleCumulateTask27.compareAndSetPendingCount(n63, n64);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (!compareAndSetPendingCount4) {
                                                            break Label_1307;
                                                        }
                                                    }
                                                    n31 = 2;
                                                    BytecodeManager.incBytecodes(2);
                                                    doubleCumulateTask = doubleCumulateTask22;
                                                    BytecodeManager.incBytecodes(2);
                                                    final int n65 = n60;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (n65 != 0) {
                                                        final DoubleCumulateTask doubleCumulateTask28 = doubleCumulateTask22;
                                                        BytecodeManager.incBytecodes(2);
                                                        doubleCumulateTask28.fork();
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final DoubleCumulateTask doubleCumulateTask29 = doubleCumulateTask22;
                                                final int n66 = pendingCount4;
                                                final int n67 = pendingCount4 | n31;
                                                BytecodeManager.incBytecodes(6);
                                                final boolean compareAndSetPendingCount5 = doubleCumulateTask29.compareAndSetPendingCount(n66, n67);
                                                BytecodeManager.incBytecodes(1);
                                                if (compareAndSetPendingCount5) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_1356;
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class IntCumulateTask extends CountedCompleter<Void>
    {
        final int[] array;
        final IntBinaryOperator function;
        IntCumulateTask left;
        IntCumulateTask right;
        int in;
        int out;
        final int lo;
        final int hi;
        final int origin;
        final int fence;
        final int threshold;
        
        public IntCumulateTask(final IntCumulateTask intCumulateTask, final IntBinaryOperator function, final int[] array, final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(3);
                super(intCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = n;
                this.lo = n;
                this.fence = n2;
                this.hi = n2;
                BytecodeManager.incBytecodes(12);
                final int n3 = n2 - n;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                final int n4 = n3 / (ForkJoinPool.getCommonPoolParallelism() << 3);
                final int n5 = 16;
                BytecodeManager.incBytecodes(7);
                int threshold;
                if (n4 <= n5) {
                    threshold = 16;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    threshold = n4;
                    BytecodeManager.incBytecodes(1);
                }
                this.threshold = threshold;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        IntCumulateTask(final IntCumulateTask intCumulateTask, final IntBinaryOperator function, final int[] array, final int origin, final int fence, final int threshold, final int lo, final int hi) {
            try {
                BytecodeManager.incBytecodes(3);
                super(intCumulateTask);
                this.function = function;
                this.array = array;
                BytecodeManager.incBytecodes(6);
                this.origin = origin;
                this.fence = fence;
                BytecodeManager.incBytecodes(6);
                this.threshold = threshold;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                this.hi = hi;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                final IntBinaryOperator function;
                final IntBinaryOperator intBinaryOperator = function = this.function;
                BytecodeManager.incBytecodes(5);
                if (intBinaryOperator != null) {
                    final int[] array2;
                    final int[] array = array2 = this.array;
                    BytecodeManager.incBytecodes(5);
                    if (array != null) {
                        final int threshold = this.threshold;
                        final int origin = this.origin;
                        final int fence = this.fence;
                        BytecodeManager.incBytecodes(9);
                        IntCumulateTask intCumulateTask = this;
                        BytecodeManager.incBytecodes(2);
                        Label_1356: {
                            Block_14: {
                                int lo;
                                int hi;
                                while (true) {
                                    final int n = lo = intCumulateTask.lo;
                                    BytecodeManager.incBytecodes(5);
                                    if (n < 0) {
                                        break Label_1356;
                                    }
                                    final int n2 = hi = intCumulateTask.hi;
                                    final int length = array2.length;
                                    BytecodeManager.incBytecodes(7);
                                    if (n2 > length) {
                                        break Label_1356;
                                    }
                                    final int n3 = hi - lo;
                                    final int n4 = threshold;
                                    BytecodeManager.incBytecodes(5);
                                    if (n3 <= n4) {
                                        break;
                                    }
                                    final IntCumulateTask left = intCumulateTask.left;
                                    final IntCumulateTask right = intCumulateTask.right;
                                    BytecodeManager.incBytecodes(6);
                                    final IntCumulateTask intCumulateTask2 = left;
                                    BytecodeManager.incBytecodes(2);
                                    IntCumulateTask intCumulateTask3 = null;
                                    Label_0547: {
                                        if (intCumulateTask2 != null) {
                                            final int in = intCumulateTask.in;
                                            BytecodeManager.incBytecodes(3);
                                            left.in = in;
                                            BytecodeManager.incBytecodes(3);
                                            intCumulateTask = (intCumulateTask3 = null);
                                            BytecodeManager.incBytecodes(4);
                                            final IntCumulateTask intCumulateTask4 = right;
                                            BytecodeManager.incBytecodes(2);
                                            while (true) {
                                                Label_0438: {
                                                    if (intCumulateTask4 != null) {
                                                        final int out = left.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final IntCumulateTask intCumulateTask5 = right;
                                                        final int n5 = lo;
                                                        final int n6 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        int applyAsInt;
                                                        if (n5 == n6) {
                                                            applyAsInt = out;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final IntBinaryOperator intBinaryOperator2 = function;
                                                            final int n7 = in;
                                                            final int n8 = out;
                                                            BytecodeManager.incBytecodes(3);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsInt = intBinaryOperator2.applyAsInt(n7, n8);
                                                        }
                                                        intCumulateTask5.in = applyAsInt;
                                                        BytecodeManager.incBytecodes(1);
                                                        boolean compareAndSetPendingCount;
                                                        do {
                                                            final IntCumulateTask intCumulateTask6 = right;
                                                            BytecodeManager.incBytecodes(2);
                                                            final int pendingCount;
                                                            final int n9 = (pendingCount = intCumulateTask6.getPendingCount()) & 0x1;
                                                            BytecodeManager.incBytecodes(5);
                                                            if (n9 != 0) {
                                                                BytecodeManager.incBytecodes(1);
                                                                break Label_0438;
                                                            }
                                                            final IntCumulateTask intCumulateTask7 = right;
                                                            final int n10 = pendingCount;
                                                            final int n11 = pendingCount | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount = intCumulateTask7.compareAndSetPendingCount(n10, n11);
                                                            BytecodeManager.incBytecodes(1);
                                                        } while (!compareAndSetPendingCount);
                                                        intCumulateTask = right;
                                                        BytecodeManager.incBytecodes(2);
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    boolean compareAndSetPendingCount2;
                                                    do {
                                                        final IntCumulateTask intCumulateTask8 = left;
                                                        BytecodeManager.incBytecodes(2);
                                                        final int pendingCount2;
                                                        final int n12 = (pendingCount2 = intCumulateTask8.getPendingCount()) & 0x1;
                                                        BytecodeManager.incBytecodes(5);
                                                        if (n12 != 0) {
                                                            BytecodeManager.incBytecodes(1);
                                                            final IntCumulateTask intCumulateTask9 = intCumulateTask;
                                                            BytecodeManager.incBytecodes(2);
                                                            if (intCumulateTask9 == null) {
                                                                break Block_14;
                                                            }
                                                            break Label_0547;
                                                        }
                                                        else {
                                                            final IntCumulateTask intCumulateTask10 = left;
                                                            final int n13 = pendingCount2;
                                                            final int n14 = pendingCount2 | 0x1;
                                                            BytecodeManager.incBytecodes(6);
                                                            compareAndSetPendingCount2 = intCumulateTask10.compareAndSetPendingCount(n13, n14);
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    } while (!compareAndSetPendingCount2);
                                                }
                                                final IntCumulateTask intCumulateTask11 = intCumulateTask;
                                                BytecodeManager.incBytecodes(2);
                                                if (intCumulateTask11 != null) {
                                                    intCumulateTask3 = intCumulateTask;
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                intCumulateTask = left;
                                                BytecodeManager.incBytecodes(2);
                                                BytecodeManager.incBytecodes(1);
                                                continue;
                                            }
                                        }
                                        final int n15 = lo + hi >>> 1;
                                        BytecodeManager.incBytecodes(6);
                                        final IntCumulateTask intCumulateTask12 = intCumulateTask;
                                        final IntCumulateTask intCumulateTask13 = intCumulateTask;
                                        final IntBinaryOperator intBinaryOperator3 = function;
                                        final int[] array3 = array2;
                                        final int n16 = origin;
                                        final int n17 = fence;
                                        final int n18 = threshold;
                                        final int n19 = n15;
                                        final int n20 = hi;
                                        BytecodeManager.incBytecodes(12);
                                        final IntCumulateTask right2 = new IntCumulateTask(intCumulateTask13, intBinaryOperator3, array3, n16, n17, n18, n19, n20);
                                        intCumulateTask12.right = right2;
                                        intCumulateTask3 = right2;
                                        BytecodeManager.incBytecodes(5);
                                        final IntCumulateTask intCumulateTask14 = intCumulateTask;
                                        final IntCumulateTask intCumulateTask15 = intCumulateTask;
                                        final IntBinaryOperator intBinaryOperator4 = function;
                                        final int[] array4 = array2;
                                        final int n21 = origin;
                                        final int n22 = fence;
                                        final int n23 = threshold;
                                        final int n24 = lo;
                                        final int n25 = n15;
                                        BytecodeManager.incBytecodes(12);
                                        final IntCumulateTask left2 = new IntCumulateTask(intCumulateTask15, intBinaryOperator4, array4, n21, n22, n23, n24, n25);
                                        intCumulateTask14.left = left2;
                                        intCumulateTask = left2;
                                        BytecodeManager.incBytecodes(5);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    final IntCumulateTask intCumulateTask16 = intCumulateTask3;
                                    BytecodeManager.incBytecodes(2);
                                    if (intCumulateTask16 != null) {
                                        final IntCumulateTask intCumulateTask17 = intCumulateTask3;
                                        BytecodeManager.incBytecodes(2);
                                        intCumulateTask17.fork();
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                boolean compareAndSetPendingCount3;
                                int n31;
                                do {
                                    final IntCumulateTask intCumulateTask18 = intCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final int pendingCount3;
                                    final int n26 = (pendingCount3 = intCumulateTask18.getPendingCount()) & 0x4;
                                    BytecodeManager.incBytecodes(5);
                                    if (n26 != 0) {
                                        BytecodeManager.incBytecodes(1);
                                        break Label_1356;
                                    }
                                    final int n27 = pendingCount3 & 0x1;
                                    BytecodeManager.incBytecodes(4);
                                    int n28;
                                    if (n27 != 0) {
                                        n28 = 4;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final int n29 = lo;
                                        final int n30 = origin;
                                        BytecodeManager.incBytecodes(3);
                                        if (n29 > n30) {
                                            n28 = 2;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            n28 = 6;
                                            BytecodeManager.incBytecodes(1);
                                        }
                                    }
                                    n31 = n28;
                                    BytecodeManager.incBytecodes(1);
                                    final IntCumulateTask intCumulateTask19 = intCumulateTask;
                                    final int n32 = pendingCount3;
                                    final int n33 = pendingCount3 | n31;
                                    BytecodeManager.incBytecodes(6);
                                    compareAndSetPendingCount3 = intCumulateTask19.compareAndSetPendingCount(n32, n33);
                                    BytecodeManager.incBytecodes(1);
                                } while (!compareAndSetPendingCount3);
                                BytecodeManager.incBytecodes(1);
                                final int n34 = n31;
                                final int n35 = 2;
                                BytecodeManager.incBytecodes(3);
                                int out2;
                                if (n34 != n35) {
                                    final int n36 = lo;
                                    final int n37 = origin;
                                    BytecodeManager.incBytecodes(3);
                                    int n38;
                                    if (n36 == n37) {
                                        out2 = array2[origin];
                                        BytecodeManager.incBytecodes(4);
                                        n38 = origin + 1;
                                        BytecodeManager.incBytecodes(5);
                                    }
                                    else {
                                        out2 = intCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                        n38 = lo;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    int n39 = n38;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n40 = n39;
                                        final int n41 = hi;
                                        BytecodeManager.incBytecodes(3);
                                        if (n40 >= n41) {
                                            break;
                                        }
                                        final int[] array5 = array2;
                                        final int n42 = n39;
                                        final IntBinaryOperator intBinaryOperator5 = function;
                                        final int n43 = out2;
                                        final int n44 = array2[n39];
                                        BytecodeManager.incBytecodes(8);
                                        out2 = (array5[n42] = intBinaryOperator5.applyAsInt(n43, n44));
                                        BytecodeManager.incBytecodes(3);
                                        ++n39;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                }
                                else {
                                    final int n45 = hi;
                                    final int n46 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n45 < n46) {
                                        out2 = array2[lo];
                                        BytecodeManager.incBytecodes(4);
                                        int n47 = lo + 1;
                                        BytecodeManager.incBytecodes(4);
                                        while (true) {
                                            final int n48 = n47;
                                            final int n49 = hi;
                                            BytecodeManager.incBytecodes(3);
                                            if (n48 >= n49) {
                                                break;
                                            }
                                            final IntBinaryOperator intBinaryOperator6 = function;
                                            final int n50 = out2;
                                            final int n51 = array2[n47];
                                            BytecodeManager.incBytecodes(6);
                                            out2 = intBinaryOperator6.applyAsInt(n50, n51);
                                            BytecodeManager.incBytecodes(1);
                                            ++n47;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    else {
                                        out2 = intCumulateTask.in;
                                        BytecodeManager.incBytecodes(3);
                                    }
                                }
                                intCumulateTask.out = out2;
                                BytecodeManager.incBytecodes(3);
                                while (true) {
                                    final IntCumulateTask intCumulateTask20 = intCumulateTask;
                                    BytecodeManager.incBytecodes(2);
                                    final IntCumulateTask intCumulateTask22;
                                    final IntCumulateTask intCumulateTask21 = intCumulateTask22 = (IntCumulateTask)intCumulateTask20.getCompleter();
                                    BytecodeManager.incBytecodes(4);
                                    if (intCumulateTask21 == null) {
                                        final int n52 = n31 & 0x4;
                                        BytecodeManager.incBytecodes(4);
                                        if (n52 != 0) {
                                            final IntCumulateTask intCumulateTask23 = intCumulateTask;
                                            BytecodeManager.incBytecodes(2);
                                            intCumulateTask23.quietlyComplete();
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        break Label_1356;
                                    }
                                    else {
                                        final IntCumulateTask intCumulateTask24 = intCumulateTask22;
                                        BytecodeManager.incBytecodes(2);
                                        final int pendingCount4 = intCumulateTask24.getPendingCount();
                                        BytecodeManager.incBytecodes(1);
                                        final int n53 = pendingCount4 & n31 & 0x4;
                                        BytecodeManager.incBytecodes(6);
                                        if (n53 != 0) {
                                            intCumulateTask = intCumulateTask22;
                                            BytecodeManager.incBytecodes(3);
                                        }
                                        else {
                                            final int n54 = pendingCount4 & n31 & 0x2;
                                            BytecodeManager.incBytecodes(6);
                                            if (n54 != 0) {
                                                final IntCumulateTask left3 = intCumulateTask22.left;
                                                BytecodeManager.incBytecodes(5);
                                                if (left3 != null) {
                                                    final IntCumulateTask right3;
                                                    final IntCumulateTask intCumulateTask25 = right3 = intCumulateTask22.right;
                                                    BytecodeManager.incBytecodes(5);
                                                    if (intCumulateTask25 != null) {
                                                        final int out3 = left3.out;
                                                        BytecodeManager.incBytecodes(3);
                                                        final IntCumulateTask intCumulateTask26 = intCumulateTask22;
                                                        final int hi2 = right3.hi;
                                                        final int n55 = fence;
                                                        BytecodeManager.incBytecodes(5);
                                                        int applyAsInt2;
                                                        if (hi2 == n55) {
                                                            applyAsInt2 = out3;
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final IntBinaryOperator intBinaryOperator7 = function;
                                                            final int n56 = out3;
                                                            final int out4 = right3.out;
                                                            BytecodeManager.incBytecodes(4);
                                                            BytecodeManager.incBytecodes(1);
                                                            applyAsInt2 = intBinaryOperator7.applyAsInt(n56, out4);
                                                        }
                                                        intCumulateTask26.out = applyAsInt2;
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                final int n57 = pendingCount4 & 0x1;
                                                BytecodeManager.incBytecodes(4);
                                                int n59 = 0;
                                                Label_1209: {
                                                    if (n57 == 0) {
                                                        final int lo2 = intCumulateTask22.lo;
                                                        final int n58 = origin;
                                                        BytecodeManager.incBytecodes(4);
                                                        if (lo2 == n58) {
                                                            n59 = 1;
                                                            BytecodeManager.incBytecodes(2);
                                                            break Label_1209;
                                                        }
                                                    }
                                                    n59 = 0;
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                final int n60 = n59;
                                                BytecodeManager.incBytecodes(1);
                                                final int n61 = pendingCount4 | n31 | n60;
                                                final int n62 = pendingCount4;
                                                BytecodeManager.incBytecodes(9);
                                                Label_1307: {
                                                    if (n61 != n62) {
                                                        final IntCumulateTask intCumulateTask27 = intCumulateTask22;
                                                        final int n63 = pendingCount4;
                                                        final int n64 = n61;
                                                        BytecodeManager.incBytecodes(3);
                                                        BytecodeManager.incBytecodes(1);
                                                        final boolean compareAndSetPendingCount4 = intCumulateTask27.compareAndSetPendingCount(n63, n64);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (!compareAndSetPendingCount4) {
                                                            break Label_1307;
                                                        }
                                                    }
                                                    n31 = 2;
                                                    BytecodeManager.incBytecodes(2);
                                                    intCumulateTask = intCumulateTask22;
                                                    BytecodeManager.incBytecodes(2);
                                                    final int n65 = n60;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (n65 != 0) {
                                                        final IntCumulateTask intCumulateTask28 = intCumulateTask22;
                                                        BytecodeManager.incBytecodes(2);
                                                        intCumulateTask28.fork();
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final IntCumulateTask intCumulateTask29 = intCumulateTask22;
                                                final int n66 = pendingCount4;
                                                final int n67 = pendingCount4 | n31;
                                                BytecodeManager.incBytecodes(6);
                                                final boolean compareAndSetPendingCount5 = intCumulateTask29.compareAndSetPendingCount(n66, n67);
                                                BytecodeManager.incBytecodes(1);
                                                if (compareAndSetPendingCount5) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_1356;
                                                }
                                            }
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                }
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
