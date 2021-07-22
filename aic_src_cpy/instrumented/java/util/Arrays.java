// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.function.Consumer;
import java.io.Serializable;
import java.security.PrivilegedAction;
import java.security.AccessController;
import sun.security.action.GetBooleanAction;
import instrumented.java.util.stream.DoubleStream;
import instrumented.java.util.stream.LongStream;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.stream.Stream;
import instrumented.java.util.function.IntToDoubleFunction;
import instrumented.java.util.function.IntToLongFunction;
import instrumented.java.util.function.IntUnaryOperator;
import instrumented.java.util.function.IntConsumer;
import instrumented.java.util.stream.IntStream;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.function.IntBinaryOperator;
import instrumented.java.util.function.DoubleBinaryOperator;
import instrumented.java.util.function.LongBinaryOperator;
import instrumented.java.util.function.BinaryOperator;
import java.lang.reflect.Array;
import instrumented.java.util.concurrent.CountedCompleter;
import instrumented.java.util.concurrent.ForkJoinPool;
import aic2021.engine.BytecodeManager;

public class Arrays
{
    private static final int MIN_ARRAY_SORT_GRAN = 8192;
    private static final int INSERTIONSORT_THRESHOLD = 7;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private Arrays() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void rangeCheck(final int n, final int n2, final int n3) {
        try {
            BytecodeManager.incBytecodes(3);
            if (n2 > n3) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(n2);
                final String str2 = ") > toIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n3);
                final String str3 = ")";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                BytecodeManager.incBytecodes(1);
                final String string = append5.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException(n2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            if (n3 > n) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex3 = new ArrayIndexOutOfBoundsException(n3);
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final int[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final int[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final int[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final int[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final long[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final long[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final long[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final long[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final short[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final short[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final short[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final short[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final char[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final char[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final char[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final char[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final byte[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            BytecodeManager.incBytecodes(7);
            DualPivotQuicksort.sort(array, n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final byte[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            BytecodeManager.incBytecodes(6);
            DualPivotQuicksort.sort(array, n, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final float[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final float[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final float[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final float[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final double[] array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            final double[] array2 = null;
            final int n3 = 0;
            final int n4 = 0;
            BytecodeManager.incBytecodes(10);
            DualPivotQuicksort.sort(array, n, n2, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final double[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - 1;
            final double[] array2 = null;
            final int n4 = 0;
            final int n5 = 0;
            BytecodeManager.incBytecodes(9);
            DualPivotQuicksort.sort(array, n, n3, array2, n4, n5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final byte[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0129: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final byte[] array2 = new byte[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJByte.Sorter sorter = new ArraysParallelSortHelpers.FJByte.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0129;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                BytecodeManager.incBytecodes(6);
                DualPivotQuicksort.sort(array, n10, n11);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final byte[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0146: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final byte[] array2 = new byte[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJByte.Sorter sorter = new ArraysParallelSortHelpers.FJByte.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0146;
                    }
                }
                final int n12 = n2 - 1;
                BytecodeManager.incBytecodes(6);
                DualPivotQuicksort.sort(array, n, n12);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final char[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final char[] array2 = new char[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJChar.Sorter sorter = new ArraysParallelSortHelpers.FJChar.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final char[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final char[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final char[] array2 = new char[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJChar.Sorter sorter = new ArraysParallelSortHelpers.FJChar.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final char[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final short[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final short[] array2 = new short[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJShort.Sorter sorter = new ArraysParallelSortHelpers.FJShort.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final short[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final short[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final short[] array2 = new short[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJShort.Sorter sorter = new ArraysParallelSortHelpers.FJShort.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final short[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final int[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final int[] array2 = new int[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJInt.Sorter sorter = new ArraysParallelSortHelpers.FJInt.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final int[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final int[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final int[] array2 = new int[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJInt.Sorter sorter = new ArraysParallelSortHelpers.FJInt.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final int[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final long[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final long[] array2 = new long[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJLong.Sorter sorter = new ArraysParallelSortHelpers.FJLong.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final long[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final long[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final long[] array2 = new long[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJLong.Sorter sorter = new ArraysParallelSortHelpers.FJLong.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final long[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final float[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final float[] array2 = new float[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJFloat.Sorter sorter = new ArraysParallelSortHelpers.FJFloat.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final float[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final float[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final float[] array2 = new float[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJFloat.Sorter sorter = new ArraysParallelSortHelpers.FJFloat.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final float[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final double[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0132: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        final double[] array2 = new double[length];
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJDouble.Sorter sorter = new ArraysParallelSortHelpers.FJDouble.Sorter(countedCompleter, array, array2, n4, n5, n6, n9);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0132;
                    }
                }
                final int n10 = 0;
                final int n11 = length - 1;
                final double[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n10, n11, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSort(final double[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0149: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        final double[] array2 = new double[n3];
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(17);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        final ArraysParallelSortHelpers.FJDouble.Sorter sorter = new ArraysParallelSortHelpers.FJDouble.Sorter(countedCompleter, array, array2, n, n7, n8, n11);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0149;
                    }
                }
                final int n12 = n2 - 1;
                final double[] array3 = null;
                final int n13 = 0;
                final int n14 = 0;
                BytecodeManager.incBytecodes(9);
                DualPivotQuicksort.sort(array, n, n12, array3, n13, n14);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T extends Comparable<? super T>> void parallelSort(final T[] array) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0171: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final Class<? extends Comparable[]> class1 = array.getClass();
                        BytecodeManager.incBytecodes(1);
                        final Class<?> componentType = class1.getComponentType();
                        final int length2 = length;
                        BytecodeManager.incBytecodes(2);
                        final Comparable[] array2 = (Comparable[])Array.newInstance(componentType, length2);
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(14);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        final NaturalOrder instance = NaturalOrder.INSTANCE;
                        BytecodeManager.incBytecodes(2);
                        final ArraysParallelSortHelpers.FJObject.Sorter sorter = new ArraysParallelSortHelpers.FJObject.Sorter(countedCompleter, array, array2, n4, n5, n6, n9, instance);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0171;
                    }
                }
                final int n10 = 0;
                final int n11 = length;
                final NaturalOrder instance2 = NaturalOrder.INSTANCE;
                final T[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(8);
                TimSort.sort(array, n10, n11, instance2, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T extends Comparable<? super T>> void parallelSort(final T[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0188: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final Class<? extends Comparable[]> class1 = array.getClass();
                        BytecodeManager.incBytecodes(1);
                        final Class<?> componentType = class1.getComponentType();
                        final int length2 = n3;
                        BytecodeManager.incBytecodes(2);
                        final Comparable[] array2 = (Comparable[])Array.newInstance(componentType, length2);
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(14);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        final NaturalOrder instance = NaturalOrder.INSTANCE;
                        BytecodeManager.incBytecodes(2);
                        final ArraysParallelSortHelpers.FJObject.Sorter sorter = new ArraysParallelSortHelpers.FJObject.Sorter(countedCompleter, array, array2, n, n7, n8, n11, instance);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0188;
                    }
                }
                final NaturalOrder instance2 = NaturalOrder.INSTANCE;
                final T[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(8);
                TimSort.sort(array, n, n2, instance2, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void parallelSort(final T[] array, Comparator<? super T> instance) {
        try {
            final NaturalOrder naturalOrder = instance;
            BytecodeManager.incBytecodes(2);
            if (naturalOrder == null) {
                instance = NaturalOrder.INSTANCE;
                BytecodeManager.incBytecodes(2);
            }
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0187: {
                if (n > n2) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n3) {
                        final CountedCompleter<?> countedCompleter = null;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final Class<? extends Object[]> class1 = array.getClass();
                        BytecodeManager.incBytecodes(1);
                        final Class<?> componentType = class1.getComponentType();
                        final int length2 = length;
                        BytecodeManager.incBytecodes(2);
                        final Object[] array2 = (Object[])Array.newInstance(componentType, length2);
                        final int n4 = 0;
                        final int n5 = length;
                        final int n6 = 0;
                        final int n7 = length / (commonPoolParallelism << 2);
                        final int n8 = 8192;
                        BytecodeManager.incBytecodes(14);
                        int n9;
                        if (n7 <= n8) {
                            n9 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n9 = n7;
                            BytecodeManager.incBytecodes(1);
                        }
                        final NaturalOrder naturalOrder2 = instance;
                        BytecodeManager.incBytecodes(2);
                        final ArraysParallelSortHelpers.FJObject.Sorter sorter = new ArraysParallelSortHelpers.FJObject.Sorter(countedCompleter, array, array2, n4, n5, n6, n9, naturalOrder2);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0187;
                    }
                }
                final int n10 = 0;
                final int n11 = length;
                final NaturalOrder naturalOrder3 = instance;
                final T[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(8);
                TimSort.sort(array, n10, n11, naturalOrder3, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void parallelSort(final T[] array, final int n, final int n2, Comparator<? super T> instance) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            final NaturalOrder naturalOrder = instance;
            BytecodeManager.incBytecodes(2);
            if (naturalOrder == null) {
                instance = NaturalOrder.INSTANCE;
                BytecodeManager.incBytecodes(2);
            }
            final int n3 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            final int n5 = 8192;
            BytecodeManager.incBytecodes(3);
            Label_0207: {
                if (n4 > n5) {
                    BytecodeManager.incBytecodes(1);
                    final int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(4);
                    if (commonPoolParallelism != n6) {
                        final CountedCompleter<?> countedCompleter = null;
                        BytecodeManager.incBytecodes(5);
                        BytecodeManager.incBytecodes(1);
                        final Class<? extends Object[]> class1 = array.getClass();
                        BytecodeManager.incBytecodes(1);
                        final Class<?> componentType = class1.getComponentType();
                        final int length2 = n3;
                        BytecodeManager.incBytecodes(2);
                        final Object[] array2 = (Object[])Array.newInstance(componentType, length2);
                        final int n7 = n3;
                        final int n8 = 0;
                        final int n9 = n3 / (commonPoolParallelism << 2);
                        final int n10 = 8192;
                        BytecodeManager.incBytecodes(14);
                        int n11;
                        if (n9 <= n10) {
                            n11 = 8192;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n11 = n9;
                            BytecodeManager.incBytecodes(1);
                        }
                        final NaturalOrder naturalOrder2 = instance;
                        BytecodeManager.incBytecodes(2);
                        final ArraysParallelSortHelpers.FJObject.Sorter sorter = new ArraysParallelSortHelpers.FJObject.Sorter(countedCompleter, array, array2, n, n7, n8, n11, naturalOrder2);
                        BytecodeManager.incBytecodes(1);
                        sorter.invoke();
                        BytecodeManager.incBytecodes(1);
                        break Label_0207;
                    }
                }
                final NaturalOrder naturalOrder3 = instance;
                final T[] array3 = null;
                final int n12 = 0;
                final int n13 = 0;
                BytecodeManager.incBytecodes(8);
                TimSort.sort(array, n, n2, naturalOrder3, array3, n12, n13);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(1);
            final boolean access$000 = LegacyMergeSort.access$000();
            BytecodeManager.incBytecodes(1);
            if (access$000) {
                BytecodeManager.incBytecodes(2);
                legacyMergeSort(array);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n = 0;
                final int length = array.length;
                final Object[] array2 = null;
                final int n2 = 0;
                final int n3 = 0;
                BytecodeManager.incBytecodes(8);
                ComparableTimSort.sort(array, n, length, array2, n2, n3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void legacyMergeSort(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array2 = array.clone();
            BytecodeManager.incBytecodes(2);
            final Object[] array3 = array2;
            final int n = 0;
            final int length = array.length;
            final int n2 = 0;
            BytecodeManager.incBytecodes(7);
            mergeSort(array3, array, n, length, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void sort(final Object[] array, final int n, final int n2) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(1);
            final boolean access$000 = LegacyMergeSort.access$000();
            BytecodeManager.incBytecodes(1);
            if (access$000) {
                BytecodeManager.incBytecodes(4);
                legacyMergeSort(array, n, n2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final Object[] array2 = null;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(7);
                ComparableTimSort.sort(array, n, n2, array2, n3, n4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void legacyMergeSort(final Object[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Object[] copyOfRange = copyOfRange(array, n, n2);
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = copyOfRange;
            final int n3 = -n;
            BytecodeManager.incBytecodes(7);
            mergeSort(array2, array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void mergeSort(final Object[] array, final Object[] array2, int n, int n2, final int n3) {
        try {
            final int n4 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4;
            final int n6 = 7;
            BytecodeManager.incBytecodes(3);
            if (n5 < n6) {
                int n7 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n7;
                    final int n9 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        break;
                    }
                    int n10 = n7;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n11 = n10;
                        final int n12 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n11 <= n12) {
                            break;
                        }
                        final Comparable comparable = (Comparable)array2[n10 - 1];
                        final Object o = array2[n10];
                        BytecodeManager.incBytecodes(9);
                        BytecodeManager.incBytecodes(1);
                        final int compareTo = comparable.compareTo(o);
                        BytecodeManager.incBytecodes(1);
                        if (compareTo <= 0) {
                            break;
                        }
                        final int n13 = n10;
                        final int n14 = n10 - 1;
                        BytecodeManager.incBytecodes(6);
                        swap(array2, n13, n14);
                        --n10;
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n15 = n;
            BytecodeManager.incBytecodes(2);
            final int n16 = n2;
            BytecodeManager.incBytecodes(2);
            n += n3;
            BytecodeManager.incBytecodes(4);
            n2 += n3;
            BytecodeManager.incBytecodes(4);
            final int n17 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n18 = n;
            final int n19 = n17;
            final int n20 = -n3;
            BytecodeManager.incBytecodes(7);
            mergeSort(array2, array, n18, n19, n20);
            final int n21 = n17;
            final int n22 = n2;
            final int n23 = -n3;
            BytecodeManager.incBytecodes(7);
            mergeSort(array2, array, n21, n22, n23);
            final Comparable comparable2 = (Comparable)array[n17 - 1];
            final Object o2 = array[n17];
            BytecodeManager.incBytecodes(10);
            final int compareTo2 = comparable2.compareTo(o2);
            BytecodeManager.incBytecodes(1);
            if (compareTo2 <= 0) {
                final int n24 = n;
                final int n25 = n15;
                final int n26 = n4;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array, n24, array2, n25, n26);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int n27 = n15;
            int n28 = n;
            int n29 = n17;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n30 = n27;
                final int n31 = n16;
                BytecodeManager.incBytecodes(3);
                if (n30 >= n31) {
                    break;
                }
                final int n32 = n29;
                final int n33 = n2;
                BytecodeManager.incBytecodes(3);
                Label_0387: {
                    Label_0352: {
                        if (n32 < n33) {
                            final int n34 = n28;
                            final int n35 = n17;
                            BytecodeManager.incBytecodes(3);
                            if (n34 < n35) {
                                final Comparable comparable3 = (Comparable)array[n28];
                                final Object o3 = array[n29];
                                BytecodeManager.incBytecodes(8);
                                final int compareTo3 = comparable3.compareTo(o3);
                                BytecodeManager.incBytecodes(1);
                                if (compareTo3 <= 0) {
                                    break Label_0352;
                                }
                            }
                            array2[n27] = array[n29++];
                            BytecodeManager.incBytecodes(7);
                            break Label_0387;
                        }
                    }
                    array2[n27] = array[n28++];
                    BytecodeManager.incBytecodes(8);
                }
                ++n27;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void swap(final Object[] array, final int n, final int n2) {
        try {
            final Object o = array[n];
            BytecodeManager.incBytecodes(4);
            array[n] = array[n2];
            BytecodeManager.incBytecodes(6);
            array[n2] = o;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void sort(final T[] array, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(2);
                sort(array);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(1);
                final boolean access$000 = LegacyMergeSort.access$000();
                BytecodeManager.incBytecodes(1);
                if (access$000) {
                    BytecodeManager.incBytecodes(3);
                    legacyMergeSort((Object[])array, (Comparator<? super Object>)comparator);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final int n = 0;
                    final int length = array.length;
                    final T[] array2 = null;
                    final int n2 = 0;
                    final int n3 = 0;
                    BytecodeManager.incBytecodes(9);
                    TimSort.sort(array, n, length, comparator, array2, n2, n3);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> void legacyMergeSort(final T[] array, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            final T[] array2 = array.clone();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                final T[] array3 = array2;
                final int n = 0;
                final int length = array.length;
                final int n2 = 0;
                BytecodeManager.incBytecodes(7);
                mergeSort(array3, array, n, length, n2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final T[] array4 = array2;
                final int n3 = 0;
                final int length2 = array.length;
                final int n4 = 0;
                BytecodeManager.incBytecodes(8);
                mergeSort(array4, array, n3, length2, n4, comparator);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void sort(final T[] array, final int n, final int n2, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(4);
                sort(array, n, n2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int length = array.length;
                BytecodeManager.incBytecodes(5);
                rangeCheck(length, n, n2);
                BytecodeManager.incBytecodes(1);
                final boolean access$000 = LegacyMergeSort.access$000();
                BytecodeManager.incBytecodes(1);
                if (access$000) {
                    BytecodeManager.incBytecodes(5);
                    legacyMergeSort((Object[])array, n, n2, (Comparator<? super Object>)comparator);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final T[] array2 = null;
                    final int n3 = 0;
                    final int n4 = 0;
                    BytecodeManager.incBytecodes(8);
                    TimSort.sort(array, n, n2, comparator, array2, n3, n4);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> void legacyMergeSort(final T[] array, final int n, final int n2, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(4);
            final T[] copyOfRange = copyOfRange(array, n, n2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                final T[] array2 = copyOfRange;
                final int n3 = -n;
                BytecodeManager.incBytecodes(7);
                mergeSort(array2, array, n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final T[] array3 = copyOfRange;
                final int n4 = -n;
                BytecodeManager.incBytecodes(8);
                mergeSort(array3, array, n, n2, n4, comparator);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void mergeSort(final Object[] array, final Object[] array2, int n, int n2, final int n3, final Comparator comparator) {
        try {
            final int n4 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n5 = n4;
            final int n6 = 7;
            BytecodeManager.incBytecodes(3);
            if (n5 < n6) {
                int n7 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n7;
                    final int n9 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        break;
                    }
                    int n10 = n7;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n11 = n10;
                        final int n12 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n11 <= n12) {
                            break;
                        }
                        final Object o = array2[n10 - 1];
                        final Object o2 = array2[n10];
                        BytecodeManager.incBytecodes(10);
                        final int compare = comparator.compare(o, o2);
                        BytecodeManager.incBytecodes(1);
                        if (compare <= 0) {
                            break;
                        }
                        final int n13 = n10;
                        final int n14 = n10 - 1;
                        BytecodeManager.incBytecodes(6);
                        swap(array2, n13, n14);
                        --n10;
                        BytecodeManager.incBytecodes(2);
                    }
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n15 = n;
            BytecodeManager.incBytecodes(2);
            final int n16 = n2;
            BytecodeManager.incBytecodes(2);
            n += n3;
            BytecodeManager.incBytecodes(4);
            n2 += n3;
            BytecodeManager.incBytecodes(4);
            final int n17 = n + n2 >>> 1;
            BytecodeManager.incBytecodes(6);
            final int n18 = n;
            final int n19 = n17;
            final int n20 = -n3;
            BytecodeManager.incBytecodes(8);
            mergeSort(array2, array, n18, n19, n20, comparator);
            final int n21 = n17;
            final int n22 = n2;
            final int n23 = -n3;
            BytecodeManager.incBytecodes(8);
            mergeSort(array2, array, n21, n22, n23, comparator);
            final Object o3 = array[n17 - 1];
            final Object o4 = array[n17];
            BytecodeManager.incBytecodes(10);
            final int compare2 = comparator.compare(o3, o4);
            BytecodeManager.incBytecodes(1);
            if (compare2 <= 0) {
                final int n24 = n;
                final int n25 = n15;
                final int n26 = n4;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array, n24, array2, n25, n26);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int n27 = n15;
            int n28 = n;
            int n29 = n17;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n30 = n27;
                final int n31 = n16;
                BytecodeManager.incBytecodes(3);
                if (n30 >= n31) {
                    break;
                }
                final int n32 = n29;
                final int n33 = n2;
                BytecodeManager.incBytecodes(3);
                Label_0383: {
                    Label_0348: {
                        if (n32 < n33) {
                            final int n34 = n28;
                            final int n35 = n17;
                            BytecodeManager.incBytecodes(3);
                            if (n34 < n35) {
                                final Object o5 = array[n28];
                                final Object o6 = array[n29];
                                BytecodeManager.incBytecodes(8);
                                final int compare3 = comparator.compare(o5, o6);
                                BytecodeManager.incBytecodes(1);
                                if (compare3 <= 0) {
                                    break Label_0348;
                                }
                            }
                            array2[n27] = array[n29++];
                            BytecodeManager.incBytecodes(7);
                            break Label_0383;
                        }
                    }
                    array2[n27] = array[n28++];
                    BytecodeManager.incBytecodes(8);
                }
                ++n27;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void parallelPrefix(final T[] array, final BinaryOperator<T> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length > 0) {
                final ArrayPrefixHelpers.CumulateTask<Object> cumulateTask = null;
                final int n = 0;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(9);
                final ArrayPrefixHelpers.CumulateTask cumulateTask2 = new ArrayPrefixHelpers.CumulateTask(cumulateTask, binaryOperator, array, n, length2);
                BytecodeManager.incBytecodes(1);
                cumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void parallelPrefix(final T[] array, final int n, final int n2, final BinaryOperator<T> binaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(binaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final ArrayPrefixHelpers.CumulateTask<Object> cumulateTask = null;
                BytecodeManager.incBytecodes(8);
                final ArrayPrefixHelpers.CumulateTask cumulateTask2 = new ArrayPrefixHelpers.CumulateTask(cumulateTask, binaryOperator, array, n, n2);
                BytecodeManager.incBytecodes(1);
                cumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final long[] array, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length > 0) {
                final ArrayPrefixHelpers.LongCumulateTask longCumulateTask = null;
                final int n = 0;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(9);
                final ArrayPrefixHelpers.LongCumulateTask longCumulateTask2 = new ArrayPrefixHelpers.LongCumulateTask(longCumulateTask, longBinaryOperator, array, n, length2);
                BytecodeManager.incBytecodes(1);
                longCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final long[] array, final int n, final int n2, final LongBinaryOperator longBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(longBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final ArrayPrefixHelpers.LongCumulateTask longCumulateTask = null;
                BytecodeManager.incBytecodes(8);
                final ArrayPrefixHelpers.LongCumulateTask longCumulateTask2 = new ArrayPrefixHelpers.LongCumulateTask(longCumulateTask, longBinaryOperator, array, n, n2);
                BytecodeManager.incBytecodes(1);
                longCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final double[] array, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length > 0) {
                final ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask = null;
                final int n = 0;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(9);
                final ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask2 = new ArrayPrefixHelpers.DoubleCumulateTask(doubleCumulateTask, doubleBinaryOperator, array, n, length2);
                BytecodeManager.incBytecodes(1);
                doubleCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final double[] array, final int n, final int n2, final DoubleBinaryOperator doubleBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(doubleBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask = null;
                BytecodeManager.incBytecodes(8);
                final ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask2 = new ArrayPrefixHelpers.DoubleCumulateTask(doubleCumulateTask, doubleBinaryOperator, array, n, n2);
                BytecodeManager.incBytecodes(1);
                doubleCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final int[] array, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length > 0) {
                final ArrayPrefixHelpers.IntCumulateTask intCumulateTask = null;
                final int n = 0;
                final int length2 = array.length;
                BytecodeManager.incBytecodes(9);
                final ArrayPrefixHelpers.IntCumulateTask intCumulateTask2 = new ArrayPrefixHelpers.IntCumulateTask(intCumulateTask, intBinaryOperator, array, n, length2);
                BytecodeManager.incBytecodes(1);
                intCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelPrefix(final int[] array, final int n, final int n2, final IntBinaryOperator intBinaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intBinaryOperator);
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(3);
            if (n < n2) {
                final ArrayPrefixHelpers.IntCumulateTask intCumulateTask = null;
                BytecodeManager.incBytecodes(8);
                final ArrayPrefixHelpers.IntCumulateTask intCumulateTask2 = new ArrayPrefixHelpers.IntCumulateTask(intCumulateTask, intBinaryOperator, array, n, n2);
                BytecodeManager.incBytecodes(1);
                intCumulateTask2.invoke();
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final long[] array, final long n) {
        try {
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n2, length, n);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final long[] array, final int n, final int n2, final long n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final long[] array, final int n, final int n2, final long n3) {
        try {
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            int n5 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n6 = n4;
                final int n7 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 > n7) {
                    final int n8 = -(n4 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n8;
                }
                final int n9 = n4 + n5 >>> 1;
                BytecodeManager.incBytecodes(6);
                final long n10 = array[n9];
                BytecodeManager.incBytecodes(4);
                final long n11 = lcmp(n10, n3);
                BytecodeManager.incBytecodes(4);
                if (n11 < 0) {
                    n4 = n9 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final long n12 = lcmp(n10, n3);
                    BytecodeManager.incBytecodes(4);
                    if (n12 <= 0) {
                        final int n13 = n9;
                        BytecodeManager.incBytecodes(2);
                        return n13;
                    }
                    n5 = n9 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final int[] array, final int n) {
        try {
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n2, length, n);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final int[] array, final int n, final int n2, final int n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final int[] array, final int n, final int n2, final int n3) {
        try {
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            int n5 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n6 = n4;
                final int n7 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 > n7) {
                    final int n8 = -(n4 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n8;
                }
                final int n9 = n4 + n5 >>> 1;
                BytecodeManager.incBytecodes(6);
                final int n10 = array[n9];
                BytecodeManager.incBytecodes(4);
                final int n11 = n10;
                BytecodeManager.incBytecodes(3);
                if (n11 < n3) {
                    n4 = n9 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n12 = n10;
                    BytecodeManager.incBytecodes(3);
                    if (n12 <= n3) {
                        final int n13 = n9;
                        BytecodeManager.incBytecodes(2);
                        return n13;
                    }
                    n5 = n9 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final short[] array, final short n) {
        try {
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n2, length, n);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final short[] array, final int n, final int n2, final short n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final short[] array, final int n, final int n2, final short n3) {
        try {
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            int n5 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n6 = n4;
                final int n7 = n5;
                BytecodeManager.incBytecodes(3);
                if (n6 > n7) {
                    final int n8 = -(n4 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n8;
                }
                final int n9 = n4 + n5 >>> 1;
                BytecodeManager.incBytecodes(6);
                final short n10 = array[n9];
                BytecodeManager.incBytecodes(4);
                final short n11 = n10;
                BytecodeManager.incBytecodes(3);
                if (n11 < n3) {
                    n4 = n9 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final short n12 = n10;
                    BytecodeManager.incBytecodes(3);
                    if (n12 <= n3) {
                        final int n13 = n9;
                        BytecodeManager.incBytecodes(2);
                        return n13;
                    }
                    n5 = n9 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final char[] array, final char c) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n, length, c);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final char[] array, final int n, final int n2, final char c) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, c);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final char[] array, final int n, final int n2, final char c) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final char c2 = array[n8];
                BytecodeManager.incBytecodes(4);
                final char c3 = c2;
                BytecodeManager.incBytecodes(3);
                if (c3 < c) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final char c4 = c2;
                    BytecodeManager.incBytecodes(3);
                    if (c4 <= c) {
                        final int n9 = n8;
                        BytecodeManager.incBytecodes(2);
                        return n9;
                    }
                    n4 = n8 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final byte[] array, final byte b) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n, length, b);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final byte[] array, final int n, final int n2, final byte b) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, b);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final byte[] array, final int n, final int n2, final byte b) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final byte b2 = array[n8];
                BytecodeManager.incBytecodes(4);
                final byte b3 = b2;
                BytecodeManager.incBytecodes(3);
                if (b3 < b) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final byte b4 = b2;
                    BytecodeManager.incBytecodes(3);
                    if (b4 <= b) {
                        final int n9 = n8;
                        BytecodeManager.incBytecodes(2);
                        return n9;
                    }
                    n4 = n8 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final double[] array, final double n) {
        try {
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n2, length, n);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final double[] array, final int n, final int n2, final double n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final double[] array, final int n, final int n2, final double value) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final double n9 = array[n8];
                BytecodeManager.incBytecodes(4);
                final double n10 = dcmpg(n9, value);
                BytecodeManager.incBytecodes(4);
                if (n10 < 0) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final double n11 = dcmpl(n9, value);
                    BytecodeManager.incBytecodes(4);
                    if (n11 > 0) {
                        n4 = n8 - 1;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        final double value2 = n9;
                        BytecodeManager.incBytecodes(2);
                        final long doubleToLongBits = Double.doubleToLongBits(value2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final long doubleToLongBits2 = Double.doubleToLongBits(value);
                        BytecodeManager.incBytecodes(1);
                        final long n12 = lcmp(doubleToLongBits, doubleToLongBits2);
                        BytecodeManager.incBytecodes(4);
                        if (n12 == 0) {
                            final int n13 = n8;
                            BytecodeManager.incBytecodes(2);
                            return n13;
                        }
                        final long n14 = lcmp(doubleToLongBits, doubleToLongBits2);
                        BytecodeManager.incBytecodes(4);
                        if (n14 < 0) {
                            n3 = n8 + 1;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            n4 = n8 - 1;
                            BytecodeManager.incBytecodes(4);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final float[] array, final float n) {
        try {
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n2, length, n);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final float[] array, final int n, final int n2, final float n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final float[] array, final int n, final int n2, final float value) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final float n9 = array[n8];
                BytecodeManager.incBytecodes(4);
                final float n10 = fcmpg(n9, value);
                BytecodeManager.incBytecodes(4);
                if (n10 < 0) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final float n11 = fcmpl(n9, value);
                    BytecodeManager.incBytecodes(4);
                    if (n11 > 0) {
                        n4 = n8 - 1;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        final float value2 = n9;
                        BytecodeManager.incBytecodes(2);
                        final int floatToIntBits = Float.floatToIntBits(value2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final int floatToIntBits2 = Float.floatToIntBits(value);
                        BytecodeManager.incBytecodes(1);
                        final int n12 = floatToIntBits;
                        final int n13 = floatToIntBits2;
                        BytecodeManager.incBytecodes(3);
                        if (n12 == n13) {
                            final int n14 = n8;
                            BytecodeManager.incBytecodes(2);
                            return n14;
                        }
                        final int n15 = floatToIntBits;
                        final int n16 = floatToIntBits2;
                        BytecodeManager.incBytecodes(3);
                        if (n15 < n16) {
                            n3 = n8 + 1;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            n4 = n8 - 1;
                            BytecodeManager.incBytecodes(4);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final Object[] array, final Object o) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n, length, o);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int binarySearch(final Object[] array, final int n, final int n2, final Object o) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(5);
            final int binarySearch0 = binarySearch0(array, n, n2, o);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int binarySearch0(final Object[] array, final int n, final int n2, final Object o) {
        try {
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final Comparable comparable = (Comparable)array[n8];
                BytecodeManager.incBytecodes(5);
                final Comparable<Object> comparable2 = (Comparable<Object>)comparable;
                BytecodeManager.incBytecodes(3);
                final int compareTo = comparable2.compareTo(o);
                BytecodeManager.incBytecodes(1);
                final int n9 = compareTo;
                BytecodeManager.incBytecodes(2);
                if (n9 < 0) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n10 = compareTo;
                    BytecodeManager.incBytecodes(2);
                    if (n10 <= 0) {
                        final int n11 = n8;
                        BytecodeManager.incBytecodes(2);
                        return n11;
                    }
                    n4 = n8 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> int binarySearch(final T[] array, final T t, final Comparator<? super T> comparator) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            final int binarySearch0 = binarySearch0(array, n, length, t, comparator);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> int binarySearch(final T[] array, final int n, final int n2, final T t, final Comparator<? super T> comparator) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            BytecodeManager.incBytecodes(6);
            final int binarySearch0 = binarySearch0(array, n, n2, (Object)t, (Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            return binarySearch0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> int binarySearch0(final T[] array, final int n, final int n2, final T t, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(5);
                final int binarySearch0 = binarySearch0(array, n, n2, t);
                BytecodeManager.incBytecodes(1);
                return binarySearch0;
            }
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            int n4 = n2 - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 > n6) {
                    final int n7 = -(n3 + 1);
                    BytecodeManager.incBytecodes(5);
                    return n7;
                }
                final int n8 = n3 + n4 >>> 1;
                BytecodeManager.incBytecodes(6);
                final T t2 = array[n8];
                BytecodeManager.incBytecodes(4);
                final T t3 = t2;
                BytecodeManager.incBytecodes(4);
                final int compare = comparator.compare(t3, t);
                BytecodeManager.incBytecodes(1);
                final int n9 = compare;
                BytecodeManager.incBytecodes(2);
                if (n9 < 0) {
                    n3 = n8 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n10 = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n10 <= 0) {
                        final int n11 = n8;
                        BytecodeManager.incBytecodes(2);
                        return n11;
                    }
                    n4 = n8 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final long[] array, final long[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final long n5 = lcmp(array[n2], array2[n2]);
                        BytecodeManager.incBytecodes(8);
                        if (n5 != 0) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final int[] array, final int[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final int n5 = array[n2];
                        final int n6 = array2[n2];
                        BytecodeManager.incBytecodes(7);
                        if (n5 != n6) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final short[] array, final short[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final short n5 = array[n2];
                        final short n6 = array2[n2];
                        BytecodeManager.incBytecodes(7);
                        if (n5 != n6) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final char[] array, final char[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final char c = array[n2];
                        final char c2 = array2[n2];
                        BytecodeManager.incBytecodes(7);
                        if (c != c2) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final byte[] array, final byte[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final byte b4 = array[n2];
                        final byte b5 = array2[n2];
                        BytecodeManager.incBytecodes(7);
                        if (b4 != b5) {
                            final boolean b6 = false;
                            BytecodeManager.incBytecodes(2);
                            return b6;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b7 = false;
            BytecodeManager.incBytecodes(2);
            return b7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final boolean[] array, final boolean[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final boolean b4 = array[n2];
                        final boolean b5 = array2[n2];
                        BytecodeManager.incBytecodes(7);
                        if (b4 != b5) {
                            final boolean b6 = false;
                            BytecodeManager.incBytecodes(2);
                            return b6;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b7 = false;
            BytecodeManager.incBytecodes(2);
            return b7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final double[] array, final double[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final double value = array[n2];
                        BytecodeManager.incBytecodes(4);
                        final long doubleToLongBits = Double.doubleToLongBits(value);
                        final double value2 = array2[n2];
                        BytecodeManager.incBytecodes(4);
                        final long n5 = lcmp(doubleToLongBits, Double.doubleToLongBits(value2));
                        BytecodeManager.incBytecodes(2);
                        if (n5 != 0) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final float[] array, final float[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final float value = array[n2];
                        BytecodeManager.incBytecodes(4);
                        final int floatToIntBits = Float.floatToIntBits(value);
                        final float value2 = array2[n2];
                        BytecodeManager.incBytecodes(4);
                        final int floatToIntBits2 = Float.floatToIntBits(value2);
                        BytecodeManager.incBytecodes(1);
                        if (floatToIntBits != floatToIntBits2) {
                            final boolean b4 = false;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean equals(final Object[] array, final Object[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    Label_0171: {
                        while (true) {
                            final int n3 = n2;
                            final int n4 = length;
                            BytecodeManager.incBytecodes(3);
                            if (n3 >= n4) {
                                break Label_0171;
                            }
                            final Object o = array[n2];
                            BytecodeManager.incBytecodes(4);
                            final Object o2 = array2[n2];
                            BytecodeManager.incBytecodes(4);
                            final Object o3 = o;
                            BytecodeManager.incBytecodes(2);
                            if (o3 == null) {
                                final Object o4 = o2;
                                BytecodeManager.incBytecodes(2);
                                if (o4 != null) {
                                    break;
                                }
                                BytecodeManager.incBytecodes(1);
                            }
                            else {
                                final Object o5 = o;
                                final Object obj = o2;
                                BytecodeManager.incBytecodes(3);
                                final boolean equals = o5.equals(obj);
                                BytecodeManager.incBytecodes(1);
                                if (!equals) {
                                    break;
                                }
                            }
                            ++n2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final boolean b4 = true;
                    BytecodeManager.incBytecodes(2);
                    return b4;
                }
            }
            final boolean b5 = false;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final long[] array, final long n) {
        try {
            int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                array[n2] = n;
                BytecodeManager.incBytecodes(4);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final long[] array, final int n, final int n2, final long n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n2) {
                    break;
                }
                array[n4] = n3;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final int[] array, final int n) {
        try {
            int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                array[n2] = n;
                BytecodeManager.incBytecodes(4);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final int[] array, final int n, final int n2, final int n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n2) {
                    break;
                }
                array[n4] = n3;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final short[] array, final short n) {
        try {
            int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                array[n2] = n;
                BytecodeManager.incBytecodes(4);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final short[] array, final int n, final int n2, final short n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n2) {
                    break;
                }
                array[n4] = n3;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final char[] array, final char c) {
        try {
            int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                array[n] = c;
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final char[] array, final int n, final int n2, final char c) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    break;
                }
                array[n3] = c;
                BytecodeManager.incBytecodes(4);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final byte[] array, final byte b) {
        try {
            int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                array[n] = b;
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final byte[] array, final int n, final int n2, final byte b) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    break;
                }
                array[n3] = b;
                BytecodeManager.incBytecodes(4);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final boolean[] array, final boolean b) {
        try {
            int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                array[n] = b;
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final boolean[] array, final int n, final int n2, final boolean b) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    break;
                }
                array[n3] = b;
                BytecodeManager.incBytecodes(4);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final double[] array, final double n) {
        try {
            int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                array[n2] = n;
                BytecodeManager.incBytecodes(4);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final double[] array, final int n, final int n2, final double n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n2) {
                    break;
                }
                array[n4] = n3;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final float[] array, final float n) {
        try {
            int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                array[n2] = n;
                BytecodeManager.incBytecodes(4);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final float[] array, final int n, final int n2, final float n3) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n4 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n5 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n2) {
                    break;
                }
                array[n4] = n3;
                BytecodeManager.incBytecodes(4);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final Object[] array, final Object o) {
        try {
            int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                array[n] = o;
                BytecodeManager.incBytecodes(4);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void fill(final Object[] array, final int n, final int n2, final Object o) {
        try {
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            rangeCheck(length, n, n2);
            int n3 = n;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n2) {
                    break;
                }
                array[n3] = o;
                BytecodeManager.incBytecodes(4);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T[] copyOf(final T[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(4);
            final Class<? extends Object[]> class1 = array.getClass();
            BytecodeManager.incBytecodes(1);
            final T[] array2 = copyOf(array, n, (Class<? extends T[]>)class1);
            BytecodeManager.incBytecodes(2);
            return array2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, U> T[] copyOf(final U[] array, final int n, final Class<? extends T[]> clazz) {
        try {
            final Class<Object[]> clazz2 = Object[].class;
            BytecodeManager.incBytecodes(3);
            Object[] array2;
            if (clazz == clazz2) {
                array2 = new Object[n];
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<?> componentType = clazz.getComponentType();
                BytecodeManager.incBytecodes(2);
                array2 = (Object[])Array.newInstance(componentType, n);
                BytecodeManager.incBytecodes(2);
            }
            final Object[] array3 = array2;
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            final Object[] array4 = array3;
            final int n3 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, n);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n2, array4, n3, min);
            final Object[] array5 = array3;
            BytecodeManager.incBytecodes(2);
            return (T[])array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static byte[] copyOf(final byte[] array, final int b) {
        try {
            final byte[] array2 = new byte[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final byte[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final byte[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static short[] copyOf(final short[] array, final int b) {
        try {
            final short[] array2 = new short[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final short[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final short[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int[] copyOf(final int[] array, final int b) {
        try {
            final int[] array2 = new int[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final int[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static long[] copyOf(final long[] array, final int b) {
        try {
            final long[] array2 = new long[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final long[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final long[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static char[] copyOf(final char[] array, final int b) {
        try {
            final char[] array2 = new char[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final char[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final char[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static float[] copyOf(final float[] array, final int b) {
        try {
            final float[] array2 = new float[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final float[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final float[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static double[] copyOf(final double[] array, final int b) {
        try {
            final double[] array2 = new double[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final double[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final double[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean[] copyOf(final boolean[] array, final int b) {
        try {
            final boolean[] array2 = new boolean[b];
            BytecodeManager.incBytecodes(2);
            final int n = 0;
            final boolean[] array3 = array2;
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(7);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(length, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, n, array3, n2, min);
            final boolean[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T[] copyOfRange(final T[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(5);
            final Class<? extends Object[]> class1 = array.getClass();
            BytecodeManager.incBytecodes(1);
            final Object[] copyOfRange = copyOfRange(array, n, n2, class1);
            BytecodeManager.incBytecodes(1);
            return (T[])copyOfRange;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T, U> T[] copyOfRange(final U[] array, final int i, final int j, final Class<? extends T[]> clazz) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Class<Object[]> clazz2 = Object[].class;
            BytecodeManager.incBytecodes(3);
            Object[] array2;
            if (clazz == clazz2) {
                array2 = new Object[n];
                BytecodeManager.incBytecodes(3);
            }
            else {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Class<?> componentType = clazz.getComponentType();
                final int length = n;
                BytecodeManager.incBytecodes(2);
                array2 = (Object[])Array.newInstance(componentType, length);
                BytecodeManager.incBytecodes(2);
            }
            final Object[] array3 = array2;
            BytecodeManager.incBytecodes(1);
            final Object[] array4 = array3;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array4, n3, min);
            final Object[] array5 = array3;
            BytecodeManager.incBytecodes(2);
            return (T[])array5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static byte[] copyOfRange(final byte[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final byte[] array2 = new byte[n];
            BytecodeManager.incBytecodes(2);
            final byte[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final byte[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static short[] copyOfRange(final short[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final short[] array2 = new short[n];
            BytecodeManager.incBytecodes(2);
            final short[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final short[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int[] copyOfRange(final int[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int[] array2 = new int[n];
            BytecodeManager.incBytecodes(2);
            final int[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final int[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static long[] copyOfRange(final long[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long[] array2 = new long[n];
            BytecodeManager.incBytecodes(2);
            final long[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final long[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static char[] copyOfRange(final char[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final char[] array2 = new char[n];
            BytecodeManager.incBytecodes(2);
            final char[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final char[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static float[] copyOfRange(final float[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final float[] array2 = new float[n];
            BytecodeManager.incBytecodes(2);
            final float[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final float[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static double[] copyOfRange(final double[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final double[] array2 = new double[n];
            BytecodeManager.incBytecodes(2);
            final double[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final double[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean[] copyOfRange(final boolean[] array, final int i, final int j) {
        try {
            final int n = j - i;
            BytecodeManager.incBytecodes(4);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(j);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final boolean[] array2 = new boolean[n];
            BytecodeManager.incBytecodes(2);
            final boolean[] array3 = array2;
            final int n3 = 0;
            final int a = array.length - i;
            final int b = n;
            BytecodeManager.incBytecodes(9);
            BytecodeManager.incBytecodes(1);
            final int min = Math.min(a, b);
            BytecodeManager.incBytecodes(1);
            System.arraycopy(array, i, array3, n3, min);
            final boolean[] array4 = array2;
            BytecodeManager.incBytecodes(2);
            return array4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @SafeVarargs
    public static <T> List<T> asList(final T... array) {
        try {
            BytecodeManager.incBytecodes(4);
            final ArrayList<T> list = new ArrayList<T>(array);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final long[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final long n6 = array[n3];
                BytecodeManager.incBytecodes(4);
                final int n7 = (int)(n6 ^ n6 >>> 32);
                BytecodeManager.incBytecodes(7);
                n2 = 31 * n2 + n7;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = n2;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final int[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final int n6 = array[n3];
                BytecodeManager.incBytecodes(4);
                n2 = 31 * n2 + n6;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final short[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final short n6 = array[n3];
                BytecodeManager.incBytecodes(4);
                n2 = 31 * n2 + n6;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final char[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final char c = array[n3];
                BytecodeManager.incBytecodes(4);
                n2 = 31 * n2 + c;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n2;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final byte b = array[n3];
                BytecodeManager.incBytecodes(4);
                n2 = 31 * n2 + b;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n2;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final boolean[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final boolean b = array[n3];
                BytecodeManager.incBytecodes(4);
                final int n6 = 31 * n2;
                final boolean b2 = b;
                BytecodeManager.incBytecodes(5);
                int n7;
                if (b2) {
                    n7 = 1231;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n7 = 1237;
                    BytecodeManager.incBytecodes(1);
                }
                n2 = n6 + n7;
                BytecodeManager.incBytecodes(2);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = n2;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final float[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final float n6 = array[n3];
                BytecodeManager.incBytecodes(4);
                final int n7 = 31 * n2;
                final float value = n6;
                BytecodeManager.incBytecodes(5);
                n2 = n7 + Float.floatToIntBits(value);
                BytecodeManager.incBytecodes(2);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n8 = n2;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final double[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final double n6 = array[n3];
                BytecodeManager.incBytecodes(4);
                final double value = n6;
                BytecodeManager.incBytecodes(2);
                final long doubleToLongBits = Double.doubleToLongBits(value);
                BytecodeManager.incBytecodes(1);
                n2 = 31 * n2 + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
                BytecodeManager.incBytecodes(11);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int hashCode(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final Object o = array[n3];
                BytecodeManager.incBytecodes(4);
                final int n6 = 31 * n2;
                final Object o2 = o;
                BytecodeManager.incBytecodes(5);
                int hashCode;
                if (o2 == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    hashCode = o3.hashCode();
                }
                n2 = n6 + hashCode;
                BytecodeManager.incBytecodes(2);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int deepHashCode(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            int n2 = 1;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n3 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n4 = n3;
                final int n5 = length;
                BytecodeManager.incBytecodes(3);
                if (n4 >= n5) {
                    break;
                }
                final Object o = array[n3];
                BytecodeManager.incBytecodes(4);
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                final boolean b = o instanceof Object[];
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final Object[] array2 = (Object[])o;
                    BytecodeManager.incBytecodes(4);
                    n6 = deepHashCode(array2);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final boolean b2 = o instanceof byte[];
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final byte[] array3 = (byte[])o;
                        BytecodeManager.incBytecodes(4);
                        n6 = hashCode(array3);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final boolean b3 = o instanceof short[];
                        BytecodeManager.incBytecodes(3);
                        if (b3) {
                            final short[] array4 = (short[])o;
                            BytecodeManager.incBytecodes(4);
                            n6 = hashCode(array4);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final boolean b4 = o instanceof int[];
                            BytecodeManager.incBytecodes(3);
                            if (b4) {
                                final int[] array5 = (int[])o;
                                BytecodeManager.incBytecodes(4);
                                n6 = hashCode(array5);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final boolean b5 = o instanceof long[];
                                BytecodeManager.incBytecodes(3);
                                if (b5) {
                                    final long[] array6 = (long[])o;
                                    BytecodeManager.incBytecodes(4);
                                    n6 = hashCode(array6);
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final boolean b6 = o instanceof char[];
                                    BytecodeManager.incBytecodes(3);
                                    if (b6) {
                                        final char[] array7 = (char[])o;
                                        BytecodeManager.incBytecodes(4);
                                        n6 = hashCode(array7);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final boolean b7 = o instanceof float[];
                                        BytecodeManager.incBytecodes(3);
                                        if (b7) {
                                            final float[] array8 = (float[])o;
                                            BytecodeManager.incBytecodes(4);
                                            n6 = hashCode(array8);
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final boolean b8 = o instanceof double[];
                                            BytecodeManager.incBytecodes(3);
                                            if (b8) {
                                                final double[] array9 = (double[])o;
                                                BytecodeManager.incBytecodes(4);
                                                n6 = hashCode(array9);
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                final boolean b9 = o instanceof boolean[];
                                                BytecodeManager.incBytecodes(3);
                                                if (b9) {
                                                    final boolean[] array10 = (boolean[])o;
                                                    BytecodeManager.incBytecodes(4);
                                                    n6 = hashCode(array10);
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final boolean[] array11 = (boolean[])o;
                                                    BytecodeManager.incBytecodes(2);
                                                    if (array11 != null) {
                                                        final boolean[] array12 = (boolean[])o;
                                                        BytecodeManager.incBytecodes(2);
                                                        n6 = array12.hashCode();
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                n2 = 31 * n2 + n6;
                BytecodeManager.incBytecodes(6);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int n7 = n2;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean deepEquals(final Object[] array, final Object[] array2) {
        try {
            BytecodeManager.incBytecodes(3);
            if (array == array2) {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            if (array != null) {
                BytecodeManager.incBytecodes(2);
                if (array2 != null) {
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int length2 = array2.length;
                    final int n = length;
                    BytecodeManager.incBytecodes(4);
                    if (length2 != n) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int n4 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n3 >= n4) {
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final Object o = array[n2];
                        BytecodeManager.incBytecodes(4);
                        final Object o2 = array2[n2];
                        BytecodeManager.incBytecodes(4);
                        final Object o3 = o;
                        final Object o4 = o2;
                        BytecodeManager.incBytecodes(3);
                        if (o3 == o4) {
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final Object o5 = o;
                            BytecodeManager.incBytecodes(2);
                            if (o5 == null) {
                                final boolean b4 = false;
                                BytecodeManager.incBytecodes(2);
                                return b4;
                            }
                            final Object o6 = o;
                            final Object o7 = o2;
                            BytecodeManager.incBytecodes(3);
                            final boolean deepEquals0 = deepEquals0(o6, o7);
                            BytecodeManager.incBytecodes(1);
                            final boolean b5 = deepEquals0;
                            BytecodeManager.incBytecodes(2);
                            if (!b5) {
                                final boolean b6 = false;
                                BytecodeManager.incBytecodes(2);
                                return b6;
                            }
                        }
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            final boolean b7 = false;
            BytecodeManager.incBytecodes(2);
            return b7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean deepEquals0(final Object o, final Object obj) {
        try {
            final boolean $assertionsDisabled = Arrays.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean b = o instanceof Object[];
            BytecodeManager.incBytecodes(3);
            boolean b3 = false;
            Label_0549: {
                if (b) {
                    final boolean b2 = obj instanceof Object[];
                    BytecodeManager.incBytecodes(3);
                    if (b2) {
                        final Object[] array = (Object[])o;
                        final Object[] array2 = (Object[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = deepEquals(array, array2);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b4 = o instanceof byte[];
                BytecodeManager.incBytecodes(3);
                if (b4) {
                    final boolean b5 = obj instanceof byte[];
                    BytecodeManager.incBytecodes(3);
                    if (b5) {
                        final byte[] array3 = (byte[])o;
                        final byte[] array4 = (byte[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array3, array4);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b6 = o instanceof short[];
                BytecodeManager.incBytecodes(3);
                if (b6) {
                    final boolean b7 = obj instanceof short[];
                    BytecodeManager.incBytecodes(3);
                    if (b7) {
                        final short[] array5 = (short[])o;
                        final short[] array6 = (short[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array5, array6);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b8 = o instanceof int[];
                BytecodeManager.incBytecodes(3);
                if (b8) {
                    final boolean b9 = obj instanceof int[];
                    BytecodeManager.incBytecodes(3);
                    if (b9) {
                        final int[] array7 = (int[])o;
                        final int[] array8 = (int[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array7, array8);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b10 = o instanceof long[];
                BytecodeManager.incBytecodes(3);
                if (b10) {
                    final boolean b11 = obj instanceof long[];
                    BytecodeManager.incBytecodes(3);
                    if (b11) {
                        final long[] array9 = (long[])o;
                        final long[] array10 = (long[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array9, array10);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b12 = o instanceof char[];
                BytecodeManager.incBytecodes(3);
                if (b12) {
                    final boolean b13 = obj instanceof char[];
                    BytecodeManager.incBytecodes(3);
                    if (b13) {
                        final char[] array11 = (char[])o;
                        final char[] array12 = (char[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array11, array12);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b14 = o instanceof float[];
                BytecodeManager.incBytecodes(3);
                if (b14) {
                    final boolean b15 = obj instanceof float[];
                    BytecodeManager.incBytecodes(3);
                    if (b15) {
                        final float[] array13 = (float[])o;
                        final float[] array14 = (float[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array13, array14);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b16 = o instanceof double[];
                BytecodeManager.incBytecodes(3);
                if (b16) {
                    final boolean b17 = obj instanceof double[];
                    BytecodeManager.incBytecodes(3);
                    if (b17) {
                        final double[] array15 = (double[])o;
                        final double[] array16 = (double[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array15, array16);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                final boolean b18 = o instanceof boolean[];
                BytecodeManager.incBytecodes(3);
                if (b18) {
                    final boolean b19 = obj instanceof boolean[];
                    BytecodeManager.incBytecodes(3);
                    if (b19) {
                        final boolean[] array17 = (boolean[])o;
                        final boolean[] array18 = (boolean[])obj;
                        BytecodeManager.incBytecodes(7);
                        b3 = equals(array17, array18);
                        BytecodeManager.incBytecodes(2);
                        break Label_0549;
                    }
                }
                BytecodeManager.incBytecodes(3);
                b3 = o.equals(obj);
                BytecodeManager.incBytecodes(1);
            }
            final boolean b20 = b3;
            BytecodeManager.incBytecodes(2);
            return b20;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final long[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final long lng = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(lng);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final int[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final int i = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(i);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final short[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final short i = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(i);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final char[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final char c2 = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(c2);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c3 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c3);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final byte[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final byte i = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(i);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final boolean[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final boolean b = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(b);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final float[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final float f = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(f);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final double[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final double d = array[n4];
                BytecodeManager.incBytecodes(5);
                sb3.append(d);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String toString(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String s2 = "[]";
                BytecodeManager.incBytecodes(2);
                return s2;
            }
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb2.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final StringBuilder sb3 = sb;
                final Object obj = array[n4];
                BytecodeManager.incBytecodes(5);
                final String value = String.valueOf(obj);
                BytecodeManager.incBytecodes(1);
                sb3.append(value);
                BytecodeManager.incBytecodes(1);
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final StringBuilder sb4 = sb;
                final String str = ", ";
                BytecodeManager.incBytecodes(3);
                sb4.append(str);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            final StringBuilder sb5 = sb;
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb5.append(c2);
            BytecodeManager.incBytecodes(1);
            final String string = append.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static String deepToString(final Object[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String s = "null";
                BytecodeManager.incBytecodes(2);
                return s;
            }
            int n = 20 * array.length;
            BytecodeManager.incBytecodes(5);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            if (length != 0) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 <= 0) {
                    n = Integer.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int capacity = n;
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder(capacity);
            BytecodeManager.incBytecodes(1);
            final StringBuilder sb2 = sb;
            BytecodeManager.incBytecodes(5);
            final HashSet<Object[]> set = new HashSet<Object[]>();
            BytecodeManager.incBytecodes(1);
            deepToString(array, sb2, set);
            final StringBuilder sb3 = sb;
            BytecodeManager.incBytecodes(2);
            final String string = sb3.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void deepToString(final Object[] array, final StringBuilder sb, final Set<Object[]> set) {
        try {
            BytecodeManager.incBytecodes(2);
            if (array == null) {
                final String str = "null";
                BytecodeManager.incBytecodes(3);
                sb.append(str);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(5);
            final int n2 = n;
            final int n3 = -1;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                final String str2 = "[]";
                BytecodeManager.incBytecodes(3);
                sb.append(str2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(3);
            set.add(array);
            BytecodeManager.incBytecodes(1);
            final char c = '[';
            BytecodeManager.incBytecodes(3);
            sb.append(c);
            BytecodeManager.incBytecodes(1);
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Object o = array[n4];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 == null) {
                    final String str3 = "null";
                    BytecodeManager.incBytecodes(3);
                    sb.append(str3);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    final Class<? extends Object[]> class1 = ((Object[])o3).getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> clazz = class1;
                    BytecodeManager.incBytecodes(2);
                    final boolean array2 = clazz.isArray();
                    BytecodeManager.incBytecodes(1);
                    if (array2) {
                        final Class<? extends Object[]> clazz2 = class1;
                        final Class<byte[]> clazz3 = byte[].class;
                        BytecodeManager.incBytecodes(3);
                        if (clazz2 == clazz3) {
                            final byte[] array3 = (byte[])o;
                            BytecodeManager.incBytecodes(5);
                            final String string = toString(array3);
                            BytecodeManager.incBytecodes(1);
                            sb.append(string);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final Class<? extends Object[]> clazz4 = class1;
                            final Class<short[]> clazz5 = short[].class;
                            BytecodeManager.incBytecodes(3);
                            if (clazz4 == clazz5) {
                                final short[] array4 = (short[])o;
                                BytecodeManager.incBytecodes(5);
                                final String string2 = toString(array4);
                                BytecodeManager.incBytecodes(1);
                                sb.append(string2);
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                final Class<? extends Object[]> clazz6 = class1;
                                final Class<int[]> clazz7 = int[].class;
                                BytecodeManager.incBytecodes(3);
                                if (clazz6 == clazz7) {
                                    final int[] array5 = (int[])o;
                                    BytecodeManager.incBytecodes(5);
                                    final String string3 = toString(array5);
                                    BytecodeManager.incBytecodes(1);
                                    sb.append(string3);
                                    BytecodeManager.incBytecodes(2);
                                }
                                else {
                                    final Class<? extends Object[]> clazz8 = class1;
                                    final Class<long[]> clazz9 = long[].class;
                                    BytecodeManager.incBytecodes(3);
                                    if (clazz8 == clazz9) {
                                        final long[] array6 = (long[])o;
                                        BytecodeManager.incBytecodes(5);
                                        final String string4 = toString(array6);
                                        BytecodeManager.incBytecodes(1);
                                        sb.append(string4);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        final Class<? extends Object[]> clazz10 = class1;
                                        final Class<char[]> clazz11 = char[].class;
                                        BytecodeManager.incBytecodes(3);
                                        if (clazz10 == clazz11) {
                                            final char[] array7 = (char[])o;
                                            BytecodeManager.incBytecodes(5);
                                            final String string5 = toString(array7);
                                            BytecodeManager.incBytecodes(1);
                                            sb.append(string5);
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        else {
                                            final Class<? extends Object[]> clazz12 = class1;
                                            final Class<float[]> clazz13 = float[].class;
                                            BytecodeManager.incBytecodes(3);
                                            if (clazz12 == clazz13) {
                                                final float[] array8 = (float[])o;
                                                BytecodeManager.incBytecodes(5);
                                                final String string6 = toString(array8);
                                                BytecodeManager.incBytecodes(1);
                                                sb.append(string6);
                                                BytecodeManager.incBytecodes(2);
                                            }
                                            else {
                                                final Class<? extends Object[]> clazz14 = class1;
                                                final Class<double[]> clazz15 = double[].class;
                                                BytecodeManager.incBytecodes(3);
                                                if (clazz14 == clazz15) {
                                                    final double[] array9 = (double[])o;
                                                    BytecodeManager.incBytecodes(5);
                                                    final String string7 = toString(array9);
                                                    BytecodeManager.incBytecodes(1);
                                                    sb.append(string7);
                                                    BytecodeManager.incBytecodes(2);
                                                }
                                                else {
                                                    final Class<? extends Object[]> clazz16 = class1;
                                                    final Class<boolean[]> clazz17 = boolean[].class;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (clazz16 == clazz17) {
                                                        final boolean[] array10 = (boolean[])o;
                                                        BytecodeManager.incBytecodes(5);
                                                        final String string8 = toString(array10);
                                                        BytecodeManager.incBytecodes(1);
                                                        sb.append(string8);
                                                        BytecodeManager.incBytecodes(2);
                                                    }
                                                    else {
                                                        final boolean[] array11 = (boolean[])o;
                                                        BytecodeManager.incBytecodes(3);
                                                        final boolean contains = set.contains(array11);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (contains) {
                                                            final String str4 = "[...]";
                                                            BytecodeManager.incBytecodes(3);
                                                            sb.append(str4);
                                                            BytecodeManager.incBytecodes(2);
                                                        }
                                                        else {
                                                            final Object[] array12 = (Object[])o;
                                                            BytecodeManager.incBytecodes(6);
                                                            deepToString(array12, sb, set);
                                                            BytecodeManager.incBytecodes(1);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        final Object[] array13 = (Object[])o;
                        BytecodeManager.incBytecodes(3);
                        final String string9 = array13.toString();
                        BytecodeManager.incBytecodes(1);
                        sb.append(string9);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n5 = n4;
                final int n6 = n;
                BytecodeManager.incBytecodes(3);
                if (n5 == n6) {
                    break;
                }
                final String str5 = ", ";
                BytecodeManager.incBytecodes(3);
                sb.append(str5);
                BytecodeManager.incBytecodes(1);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            final char c2 = ']';
            BytecodeManager.incBytecodes(3);
            sb.append(c2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            set.remove(array);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void setAll(final T[] array, final IntFunction<? extends T> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intFunction);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = n;
                final int n4 = n;
                BytecodeManager.incBytecodes(5);
                array[n3] = (T)intFunction.apply(n4);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void parallelSetAll(final T[] array, final IntFunction<? extends T> intFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intFunction);
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            final IntStream range = IntStream.range(n2, length);
            BytecodeManager.incBytecodes(1);
            final IntStream parallel = range.parallel();
            final IntConsumer intConsumer = n -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    array[n] = (T)intFunction.apply(n);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            parallel.forEach(intConsumer);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void setAll(final int[] array, final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = n;
                final int n4 = n;
                BytecodeManager.incBytecodes(5);
                array[n3] = intUnaryOperator.applyAsInt(n4);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSetAll(final int[] array, final IntUnaryOperator intUnaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intUnaryOperator);
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            final IntStream range = IntStream.range(n2, length);
            BytecodeManager.incBytecodes(1);
            final IntStream parallel = range.parallel();
            final IntConsumer intConsumer = n -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    array[n] = intUnaryOperator.applyAsInt(n);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            parallel.forEach(intConsumer);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void setAll(final long[] array, final IntToLongFunction intToLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToLongFunction);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = n;
                final int n4 = n;
                BytecodeManager.incBytecodes(5);
                array[n3] = intToLongFunction.applyAsLong(n4);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSetAll(final long[] array, final IntToLongFunction intToLongFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToLongFunction);
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            final IntStream range = IntStream.range(n2, length);
            BytecodeManager.incBytecodes(1);
            final IntStream parallel = range.parallel();
            final IntConsumer intConsumer = n -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    array[n] = intToLongFunction.applyAsLong(n);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            parallel.forEach(intConsumer);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void setAll(final double[] array, final IntToDoubleFunction intToDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToDoubleFunction);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                final int n3 = n;
                final int n4 = n;
                BytecodeManager.incBytecodes(5);
                array[n3] = intToDoubleFunction.applyAsDouble(n4);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void parallelSetAll(final double[] array, final IntToDoubleFunction intToDoubleFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(intToDoubleFunction);
            BytecodeManager.incBytecodes(1);
            final int n2 = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            final IntStream range = IntStream.range(n2, length);
            BytecodeManager.incBytecodes(1);
            final IntStream parallel = range.parallel();
            final IntConsumer intConsumer = n -> {
                try {
                    BytecodeManager.incBytecodes(5);
                    array[n] = intToDoubleFunction.applyAsDouble(n);
                    BytecodeManager.incBytecodes(2);
                    return;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            };
            BytecodeManager.incBytecodes(3);
            parallel.forEach(intConsumer);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final T[] array) {
        try {
            final int n = 1040;
            BytecodeManager.incBytecodes(3);
            final Spliterator<Object> spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Spliterator<T> spliterator(final T[] array, final int n, final int n2) {
        try {
            final int n3 = 1040;
            BytecodeManager.incBytecodes(5);
            final Spliterator<Object> spliterator = Spliterators.spliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<T>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliterator(final int[] array) {
        try {
            final int n = 1040;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfInt spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfInt spliterator(final int[] array, final int n, final int n2) {
        try {
            final int n3 = 1040;
            BytecodeManager.incBytecodes(5);
            final Spliterator.OfInt spliterator = Spliterators.spliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliterator(final long[] array) {
        try {
            final int n = 1040;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfLong spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfLong spliterator(final long[] array, final int n, final int n2) {
        try {
            final int n3 = 1040;
            BytecodeManager.incBytecodes(5);
            final Spliterator.OfLong spliterator = Spliterators.spliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliterator(final double[] array) {
        try {
            final int n = 1040;
            BytecodeManager.incBytecodes(3);
            final Spliterator.OfDouble spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static Spliterator.OfDouble spliterator(final double[] array, final int n, final int n2) {
        try {
            final int n3 = 1040;
            BytecodeManager.incBytecodes(5);
            final Spliterator.OfDouble spliterator = Spliterators.spliterator(array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Stream<T> stream(final T[] array) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            final Stream<T> stream = stream(array, n, length);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Stream<T> stream(final T[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Spliterator<T> spliterator = spliterator(array, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final Stream<T> stream = StreamSupport.stream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static IntStream stream(final int[] array) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            final IntStream stream = stream(array, n, length);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static IntStream stream(final int[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Spliterator.OfInt spliterator = spliterator(array, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final IntStream intStream = StreamSupport.intStream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return intStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static LongStream stream(final long[] array) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            final LongStream stream = stream(array, n, length);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static LongStream stream(final long[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Spliterator.OfLong spliterator = spliterator(array, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final LongStream longStream = StreamSupport.longStream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return longStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static DoubleStream stream(final double[] array) {
        try {
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(5);
            final DoubleStream stream = stream(array, n, length);
            BytecodeManager.incBytecodes(1);
            return stream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static DoubleStream stream(final double[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final Spliterator.OfDouble spliterator = spliterator(array, n, n2);
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            final DoubleStream doubleStream = StreamSupport.doubleStream(spliterator, b);
            BytecodeManager.incBytecodes(1);
            return doubleStream;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<Arrays> clazz = Arrays.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class NaturalOrder implements Comparator<Object>
    {
        static final NaturalOrder INSTANCE;
        
        NaturalOrder() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int compare(final Object o, final Object o2) {
            try {
                final Comparable comparable = (Comparable)o;
                BytecodeManager.incBytecodes(4);
                final int compareTo = comparable.compareTo(o2);
                BytecodeManager.incBytecodes(1);
                return compareTo;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                INSTANCE = new NaturalOrder();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LegacyMergeSort
    {
        private static final boolean userRequested;
        
        LegacyMergeSort() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ boolean access$000() {
            try {
                final boolean userRequested = LegacyMergeSort.userRequested;
                BytecodeManager.incBytecodes(2);
                return userRequested;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String theProp = "java.util.Arrays.useLegacyMergeSort";
                BytecodeManager.incBytecodes(4);
                final GetBooleanAction action = new GetBooleanAction(theProp);
                BytecodeManager.incBytecodes(1);
                final Boolean b = AccessController.doPrivileged((PrivilegedAction<Boolean>)action);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                userRequested = b;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;
        
        ArrayList(final E[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.a = Objects.requireNonNull(array);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int length = this.a.length;
                BytecodeManager.incBytecodes(4);
                return length;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final E[] a = this.a;
                BytecodeManager.incBytecodes(3);
                final E[] array = a.clone();
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                final int n = size;
                BytecodeManager.incBytecodes(4);
                if (length < n) {
                    final E[] a = this.a;
                    final int n2 = size;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> class1 = array.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Object[] copy = Arrays.copyOf(a, n2, (Class<? extends T[]>)class1);
                    BytecodeManager.incBytecodes(1);
                    return (T[])copy;
                }
                final E[] a2 = this.a;
                final int n3 = 0;
                final int n4 = 0;
                final int n5 = size;
                BytecodeManager.incBytecodes(7);
                System.arraycopy(a2, n3, array, n4, n5);
                final int length2 = array.length;
                final int n6 = size;
                BytecodeManager.incBytecodes(4);
                if (length2 > n6) {
                    array[size] = null;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(2);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int n) {
            try {
                final E e = this.a[n];
                BytecodeManager.incBytecodes(5);
                return e;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E set(final int n, final E e) {
            try {
                final E e2 = this.a[n];
                BytecodeManager.incBytecodes(5);
                this.a[n] = e;
                BytecodeManager.incBytecodes(5);
                final E e3 = e2;
                BytecodeManager.incBytecodes(2);
                return e3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int indexOf(final Object o) {
            try {
                final E[] a = this.a;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    int n = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n2 = n;
                        final int length = a.length;
                        BytecodeManager.incBytecodes(4);
                        if (n2 >= length) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final E e = a[n];
                        BytecodeManager.incBytecodes(4);
                        if (e == null) {
                            final int n3 = n;
                            BytecodeManager.incBytecodes(2);
                            return n3;
                        }
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                else {
                    int n4 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n5 = n4;
                        final int length2 = a.length;
                        BytecodeManager.incBytecodes(4);
                        if (n5 >= length2) {
                            break;
                        }
                        final E obj = a[n4];
                        BytecodeManager.incBytecodes(5);
                        final boolean equals = o.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            final int n6 = n4;
                            BytecodeManager.incBytecodes(2);
                            return n6;
                        }
                        ++n4;
                        BytecodeManager.incBytecodes(2);
                    }
                }
                final int n7 = -1;
                BytecodeManager.incBytecodes(2);
                return n7;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final int index = this.indexOf(o);
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (index != n) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final E[] a = this.a;
                final int n = 16;
                BytecodeManager.incBytecodes(4);
                final Spliterator<Object> spliterator = Spliterators.spliterator(a, n);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<E>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final E[] a = this.a;
                final int length = a.length;
                int n = 0;
                BytecodeManager.incBytecodes(8);
                while (true) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    final E e = a[n];
                    BytecodeManager.incBytecodes(4);
                    final E e2 = e;
                    BytecodeManager.incBytecodes(3);
                    consumer.accept(e2);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final UnaryOperator<E> unaryOperator) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(unaryOperator);
                BytecodeManager.incBytecodes(1);
                final E[] a = this.a;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = a.length;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= length) {
                        break;
                    }
                    final E[] array = a;
                    final int n3 = n;
                    final E e = a[n];
                    BytecodeManager.incBytecodes(7);
                    array[n3] = (E)unaryOperator.apply(e);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void sort(final Comparator<? super E> comparator) {
            try {
                final E[] a = this.a;
                BytecodeManager.incBytecodes(4);
                Arrays.sort(a, comparator);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
