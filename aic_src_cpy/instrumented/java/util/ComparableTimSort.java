// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

class ComparableTimSort
{
    private static final int MIN_MERGE = 32;
    private final Object[] a;
    private static final int MIN_GALLOP = 7;
    private int minGallop;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private Object[] tmp;
    private int tmpBase;
    private int tmpLen;
    private int stackSize;
    private final int[] runBase;
    private final int[] runLen;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    private ComparableTimSort(final Object[] a, final Object[] tmp, final int tmpBase, final int tmpLen) {
        try {
            BytecodeManager.incBytecodes(2);
            this.minGallop = 7;
            BytecodeManager.incBytecodes(3);
            this.stackSize = 0;
            BytecodeManager.incBytecodes(3);
            this.a = a;
            BytecodeManager.incBytecodes(3);
            final int length = a.length;
            BytecodeManager.incBytecodes(3);
            final int n = length;
            final int n2 = 512;
            BytecodeManager.incBytecodes(3);
            int n3;
            if (n < n2) {
                n3 = length >>> 1;
                BytecodeManager.incBytecodes(4);
            }
            else {
                n3 = 256;
                BytecodeManager.incBytecodes(1);
            }
            final int tmpLen2 = n3;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0193: {
                if (tmp != null) {
                    final int n4 = tmpLen2;
                    BytecodeManager.incBytecodes(3);
                    if (tmpLen >= n4) {
                        final int n5 = tmpBase + tmpLen2;
                        final int length2 = tmp.length;
                        BytecodeManager.incBytecodes(6);
                        if (n5 <= length2) {
                            this.tmp = tmp;
                            BytecodeManager.incBytecodes(3);
                            this.tmpBase = tmpBase;
                            BytecodeManager.incBytecodes(3);
                            this.tmpLen = tmpLen;
                            BytecodeManager.incBytecodes(3);
                            break Label_0193;
                        }
                    }
                }
                this.tmp = new Object[tmpLen2];
                BytecodeManager.incBytecodes(3);
                this.tmpBase = 0;
                BytecodeManager.incBytecodes(3);
                this.tmpLen = tmpLen2;
                BytecodeManager.incBytecodes(4);
            }
            final int n6 = length;
            final int n7 = 120;
            BytecodeManager.incBytecodes(3);
            int n8;
            if (n6 < n7) {
                n8 = 5;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final int n9 = length;
                final int n10 = 1542;
                BytecodeManager.incBytecodes(3);
                if (n9 < n10) {
                    n8 = 10;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final int n11 = length;
                    final int n12 = 119151;
                    BytecodeManager.incBytecodes(3);
                    if (n11 < n12) {
                        n8 = 24;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n8 = 49;
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final int n13 = n8;
            BytecodeManager.incBytecodes(1);
            this.runBase = new int[n13];
            BytecodeManager.incBytecodes(3);
            this.runLen = new int[n13];
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void sort(final Object[] array, int n, final int n2, final Object[] array2, final int n3, final int n4) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0068: {
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final int n5 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n5 >= 0) {
                            final int n6 = n;
                            BytecodeManager.incBytecodes(3);
                            if (n6 <= n2) {
                                final int length = array.length;
                                BytecodeManager.incBytecodes(4);
                                if (n2 <= length) {
                                    break Label_0068;
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n7 = n2 - n;
            BytecodeManager.incBytecodes(4);
            final int n8 = n7;
            final int n9 = 2;
            BytecodeManager.incBytecodes(3);
            if (n8 < n9) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n10 = n7;
            final int n11 = 32;
            BytecodeManager.incBytecodes(3);
            if (n10 < n11) {
                final int n12 = n;
                BytecodeManager.incBytecodes(4);
                final int countRunAndMakeAscending = countRunAndMakeAscending(array, n12, n2);
                BytecodeManager.incBytecodes(1);
                final int n13 = n;
                final int n14 = n + countRunAndMakeAscending;
                BytecodeManager.incBytecodes(7);
                binarySort(array, n13, n2, n14);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(7);
            final ComparableTimSort comparableTimSort = new ComparableTimSort(array, array2, n3, n4);
            BytecodeManager.incBytecodes(1);
            final int n15 = n7;
            BytecodeManager.incBytecodes(2);
            final int minRunLength = minRunLength(n15);
            BytecodeManager.incBytecodes(1);
            int i;
            do {
                final int n16 = n;
                BytecodeManager.incBytecodes(4);
                int countRunAndMakeAscending2 = countRunAndMakeAscending(array, n16, n2);
                BytecodeManager.incBytecodes(1);
                final int n17 = countRunAndMakeAscending2;
                final int n18 = minRunLength;
                BytecodeManager.incBytecodes(3);
                if (n17 < n18) {
                    final int n19 = n7;
                    final int n20 = minRunLength;
                    BytecodeManager.incBytecodes(3);
                    int n21;
                    if (n19 <= n20) {
                        n21 = n7;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n21 = minRunLength;
                        BytecodeManager.incBytecodes(1);
                    }
                    final int n22 = n21;
                    BytecodeManager.incBytecodes(1);
                    final int n23 = n;
                    final int n24 = n + n22;
                    final int n25 = n + countRunAndMakeAscending2;
                    BytecodeManager.incBytecodes(9);
                    binarySort(array, n23, n24, n25);
                    countRunAndMakeAscending2 = n22;
                    BytecodeManager.incBytecodes(2);
                }
                final ComparableTimSort comparableTimSort2 = comparableTimSort;
                final int n26 = n;
                final int n27 = countRunAndMakeAscending2;
                BytecodeManager.incBytecodes(4);
                comparableTimSort2.pushRun(n26, n27);
                final ComparableTimSort comparableTimSort3 = comparableTimSort;
                BytecodeManager.incBytecodes(2);
                comparableTimSort3.mergeCollapse();
                n += countRunAndMakeAscending2;
                BytecodeManager.incBytecodes(4);
                n7 -= countRunAndMakeAscending2;
                BytecodeManager.incBytecodes(4);
                i = n7;
                BytecodeManager.incBytecodes(2);
            } while (i != 0);
            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled2) {
                final int n28 = n;
                BytecodeManager.incBytecodes(3);
                if (n28 != n2) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            final ComparableTimSort comparableTimSort4 = comparableTimSort;
            BytecodeManager.incBytecodes(2);
            comparableTimSort4.mergeForceCollapse();
            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final int stackSize = comparableTimSort.stackSize;
                final int n29 = 1;
                BytecodeManager.incBytecodes(4);
                if (stackSize != n29) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError3 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError3;
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void binarySort(final Object[] array, final int n, final int n2, int n3) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0049: {
                if (!$assertionsDisabled) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n <= n4) {
                        final int n5 = n3;
                        BytecodeManager.incBytecodes(3);
                        if (n5 <= n2) {
                            break Label_0049;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final int n6 = n3;
            BytecodeManager.incBytecodes(3);
            if (n6 == n) {
                ++n3;
                BytecodeManager.incBytecodes(1);
            }
            while (true) {
                final int n7 = n3;
                BytecodeManager.incBytecodes(3);
                if (n7 >= n2) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Comparable comparable = (Comparable)array[n3];
                BytecodeManager.incBytecodes(5);
                int n8 = n;
                BytecodeManager.incBytecodes(2);
                int n9 = n3;
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled2) {
                    final int n10 = n8;
                    final int n11 = n9;
                    BytecodeManager.incBytecodes(3);
                    if (n10 > n11) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError2 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError2;
                    }
                }
                while (true) {
                    final int n12 = n8;
                    final int n13 = n9;
                    BytecodeManager.incBytecodes(3);
                    if (n12 >= n13) {
                        break;
                    }
                    final int n14 = n8 + n9 >>> 1;
                    BytecodeManager.incBytecodes(6);
                    final Comparable<Object> comparable2 = (Comparable<Object>)comparable;
                    final Object o = array[n14];
                    BytecodeManager.incBytecodes(5);
                    final int compareTo = comparable2.compareTo(o);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo < 0) {
                        n9 = n14;
                        BytecodeManager.incBytecodes(3);
                    }
                    else {
                        n8 = n14 + 1;
                        BytecodeManager.incBytecodes(4);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled3) {
                    final int n15 = n8;
                    final int n16 = n9;
                    BytecodeManager.incBytecodes(3);
                    if (n15 != n16) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError3 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError3;
                    }
                }
                final int n17 = n3 - n8;
                BytecodeManager.incBytecodes(4);
                final int n18 = n17;
                BytecodeManager.incBytecodes(2);
                switch (n18) {
                    case 2: {
                        array[n8 + 2] = array[n8 + 1];
                        BytecodeManager.incBytecodes(10);
                    }
                    case 1: {
                        array[n8 + 1] = array[n8];
                        BytecodeManager.incBytecodes(8);
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    default: {
                        final int n19 = n8;
                        final int n20 = n8 + 1;
                        final int n21 = n17;
                        BytecodeManager.incBytecodes(8);
                        System.arraycopy(array, n19, array, n20, n21);
                        break;
                    }
                }
                array[n8] = comparable;
                BytecodeManager.incBytecodes(4);
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int countRunAndMakeAscending(final Object[] array, final int n, final int n2) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                BytecodeManager.incBytecodes(3);
                if (n >= n2) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n3 = n + 1;
            BytecodeManager.incBytecodes(4);
            final int n4 = n3;
            BytecodeManager.incBytecodes(3);
            if (n4 == n2) {
                final int n5 = 1;
                BytecodeManager.incBytecodes(2);
                return n5;
            }
            final Comparable comparable = (Comparable)array[n3++];
            final Object o = array[n];
            BytecodeManager.incBytecodes(9);
            final int compareTo = comparable.compareTo(o);
            BytecodeManager.incBytecodes(1);
            if (compareTo < 0) {
                while (true) {
                    final int n6 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n2) {
                        break;
                    }
                    final Comparable comparable2 = (Comparable)array[n3];
                    final Object o2 = array[n3 - 1];
                    BytecodeManager.incBytecodes(10);
                    final int compareTo2 = comparable2.compareTo(o2);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo2 >= 0) {
                        break;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
                final int n7 = n3;
                BytecodeManager.incBytecodes(4);
                reverseRange(array, n, n7);
                BytecodeManager.incBytecodes(1);
            }
            else {
                while (true) {
                    final int n8 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n2) {
                        break;
                    }
                    final Comparable comparable3 = (Comparable)array[n3];
                    final Object o3 = array[n3 - 1];
                    BytecodeManager.incBytecodes(10);
                    final int compareTo3 = comparable3.compareTo(o3);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo3 < 0) {
                        break;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n9 = n3 - n;
            BytecodeManager.incBytecodes(4);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void reverseRange(final Object[] array, int n, int n2) {
        try {
            --n2;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object o = array[n];
                BytecodeManager.incBytecodes(4);
                array[n++] = array[n2];
                BytecodeManager.incBytecodes(7);
                array[n2--] = o;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int minRunLength(int n) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n4 = n;
                final int n5 = 32;
                BytecodeManager.incBytecodes(3);
                if (n4 < n5) {
                    break;
                }
                n3 |= (n & 0x1);
                BytecodeManager.incBytecodes(6);
                n >>= 1;
                BytecodeManager.incBytecodes(5);
            }
            final int n6 = n + n3;
            BytecodeManager.incBytecodes(4);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void pushRun(final int n, final int n2) {
        try {
            this.runBase[this.stackSize] = n;
            BytecodeManager.incBytecodes(6);
            this.runLen[this.stackSize] = n2;
            BytecodeManager.incBytecodes(6);
            ++this.stackSize;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mergeCollapse() {
        try {
            while (true) {
                final int stackSize = this.stackSize;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                if (stackSize <= n) {
                    break;
                }
                int n2 = this.stackSize - 2;
                BytecodeManager.incBytecodes(5);
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                Label_0147: {
                    if (n3 > 0) {
                        final int n4 = this.runLen[n2 - 1];
                        final int n5 = this.runLen[n2] + this.runLen[n2 + 1];
                        BytecodeManager.incBytecodes(18);
                        if (n4 <= n5) {
                            final int n6 = this.runLen[n2 - 1];
                            final int n7 = this.runLen[n2 + 1];
                            BytecodeManager.incBytecodes(13);
                            if (n6 < n7) {
                                --n2;
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n8 = n2;
                            BytecodeManager.incBytecodes(3);
                            this.mergeAt(n8);
                            BytecodeManager.incBytecodes(1);
                            break Label_0147;
                        }
                    }
                    final int n9 = this.runLen[n2];
                    final int n10 = this.runLen[n2 + 1];
                    BytecodeManager.incBytecodes(11);
                    if (n9 > n10) {
                        break;
                    }
                    final int n11 = n2;
                    BytecodeManager.incBytecodes(3);
                    this.mergeAt(n11);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mergeForceCollapse() {
        try {
            while (true) {
                final int stackSize = this.stackSize;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                if (stackSize <= n) {
                    break;
                }
                int n2 = this.stackSize - 2;
                BytecodeManager.incBytecodes(5);
                final int n3 = n2;
                BytecodeManager.incBytecodes(2);
                if (n3 > 0) {
                    final int n4 = this.runLen[n2 - 1];
                    final int n5 = this.runLen[n2 + 1];
                    BytecodeManager.incBytecodes(13);
                    if (n4 < n5) {
                        --n2;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final int n6 = n2;
                BytecodeManager.incBytecodes(3);
                this.mergeAt(n6);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mergeAt(final int n) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int stackSize = this.stackSize;
                final int n2 = 2;
                BytecodeManager.incBytecodes(4);
                if (stackSize < n2) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled2) {
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final int n3 = this.stackSize - 2;
                BytecodeManager.incBytecodes(6);
                if (n != n3) {
                    final int n4 = this.stackSize - 3;
                    BytecodeManager.incBytecodes(6);
                    if (n != n4) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError3 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError3;
                    }
                }
            }
            final int n5 = this.runBase[n];
            BytecodeManager.incBytecodes(5);
            final int n6 = this.runLen[n];
            BytecodeManager.incBytecodes(5);
            final int n7 = this.runBase[n + 1];
            BytecodeManager.incBytecodes(7);
            final int n8 = this.runLen[n + 1];
            BytecodeManager.incBytecodes(7);
            final boolean $assertionsDisabled4 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0241: {
                if (!$assertionsDisabled4) {
                    final int n9 = n6;
                    BytecodeManager.incBytecodes(2);
                    if (n9 > 0) {
                        final int n10 = n8;
                        BytecodeManager.incBytecodes(2);
                        if (n10 > 0) {
                            break Label_0241;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError4 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError4;
                }
            }
            final boolean $assertionsDisabled5 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled5) {
                final int n11 = n5 + n6;
                final int n12 = n7;
                BytecodeManager.incBytecodes(5);
                if (n11 != n12) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError5 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError5;
                }
            }
            this.runLen[n] = n6 + n8;
            BytecodeManager.incBytecodes(7);
            final int n13 = this.stackSize - 3;
            BytecodeManager.incBytecodes(6);
            if (n == n13) {
                this.runBase[n + 1] = this.runBase[n + 2];
                BytecodeManager.incBytecodes(12);
                this.runLen[n + 1] = this.runLen[n + 2];
                BytecodeManager.incBytecodes(12);
            }
            --this.stackSize;
            BytecodeManager.incBytecodes(6);
            final Comparable comparable = (Comparable)this.a[n7];
            final Object[] a = this.a;
            final int n14 = n5;
            final int n15 = n6;
            final int n16 = 0;
            BytecodeManager.incBytecodes(11);
            final int gallopRight = gallopRight(comparable, a, n14, n15, n16);
            BytecodeManager.incBytecodes(1);
            final boolean $assertionsDisabled6 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled6) {
                final int n17 = gallopRight;
                BytecodeManager.incBytecodes(2);
                if (n17 < 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError6 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError6;
                }
            }
            final int n18 = n5 + gallopRight;
            BytecodeManager.incBytecodes(4);
            final int n19 = n6 - gallopRight;
            BytecodeManager.incBytecodes(4);
            final int n20 = n19;
            BytecodeManager.incBytecodes(2);
            if (n20 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final Comparable comparable2 = (Comparable)this.a[n18 + n19 - 1];
            final Object[] a2 = this.a;
            final int n21 = n7;
            final int n22 = n8;
            final int n23 = n8 - 1;
            BytecodeManager.incBytecodes(17);
            final int gallopLeft = gallopLeft(comparable2, a2, n21, n22, n23);
            BytecodeManager.incBytecodes(1);
            final boolean $assertionsDisabled7 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled7) {
                final int n24 = gallopLeft;
                BytecodeManager.incBytecodes(2);
                if (n24 < 0) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError7 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError7;
                }
            }
            final int n25 = gallopLeft;
            BytecodeManager.incBytecodes(2);
            if (n25 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n26 = n19;
            final int n27 = gallopLeft;
            BytecodeManager.incBytecodes(3);
            if (n26 <= n27) {
                final int n28 = n18;
                final int n29 = n19;
                final int n30 = n7;
                final int n31 = gallopLeft;
                BytecodeManager.incBytecodes(6);
                this.mergeLo(n28, n29, n30, n31);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n32 = n18;
                final int n33 = n19;
                final int n34 = n7;
                final int n35 = gallopLeft;
                BytecodeManager.incBytecodes(6);
                this.mergeHi(n32, n33, n34, n35);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int gallopLeft(final Comparable<Object> comparable, final Object[] array, final int n, final int n2, final int n3) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0059: {
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (n2 > 0) {
                        BytecodeManager.incBytecodes(2);
                        if (n3 >= 0) {
                            BytecodeManager.incBytecodes(3);
                            if (n3 < n2) {
                                break Label_0059;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n4 = 0;
            BytecodeManager.incBytecodes(2);
            int n5 = 1;
            BytecodeManager.incBytecodes(2);
            final Object o = array[n + n3];
            BytecodeManager.incBytecodes(7);
            final int compareTo = comparable.compareTo(o);
            BytecodeManager.incBytecodes(1);
            int n12;
            int n13;
            if (compareTo > 0) {
                final int n6 = n2 - n3;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n7 = n5;
                    final int n8 = n6;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        break;
                    }
                    final Object o2 = array[n + n3 + n5];
                    BytecodeManager.incBytecodes(9);
                    final int compareTo2 = comparable.compareTo(o2);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo2 <= 0) {
                        break;
                    }
                    n4 = n5;
                    BytecodeManager.incBytecodes(2);
                    n5 = (n5 << 1) + 1;
                    BytecodeManager.incBytecodes(6);
                    final int n9 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n9 > 0) {
                        continue;
                    }
                    n5 = n6;
                    BytecodeManager.incBytecodes(3);
                }
                final int n10 = n5;
                final int n11 = n6;
                BytecodeManager.incBytecodes(3);
                if (n10 > n11) {
                    n5 = n6;
                    BytecodeManager.incBytecodes(2);
                }
                n12 = n4 + n3;
                BytecodeManager.incBytecodes(4);
                n13 = n5 + n3;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n14 = n3 + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n15 = n5;
                    final int n16 = n14;
                    BytecodeManager.incBytecodes(3);
                    if (n15 >= n16) {
                        break;
                    }
                    final Object o3 = array[n + n3 - n5];
                    BytecodeManager.incBytecodes(9);
                    final int compareTo3 = comparable.compareTo(o3);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo3 > 0) {
                        break;
                    }
                    n4 = n5;
                    BytecodeManager.incBytecodes(2);
                    n5 = (n5 << 1) + 1;
                    BytecodeManager.incBytecodes(6);
                    final int n17 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n17 > 0) {
                        continue;
                    }
                    n5 = n14;
                    BytecodeManager.incBytecodes(3);
                }
                final int n18 = n5;
                final int n19 = n14;
                BytecodeManager.incBytecodes(3);
                if (n18 > n19) {
                    n5 = n14;
                    BytecodeManager.incBytecodes(2);
                }
                final int n20 = n4;
                BytecodeManager.incBytecodes(2);
                n12 = n3 - n5;
                BytecodeManager.incBytecodes(4);
                n13 = n3 - n20;
                BytecodeManager.incBytecodes(4);
            }
            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0460: {
                if (!$assertionsDisabled2) {
                    final int n21 = -1;
                    final int n22 = n12;
                    BytecodeManager.incBytecodes(3);
                    if (n21 <= n22) {
                        final int n23 = n12;
                        final int n24 = n13;
                        BytecodeManager.incBytecodes(3);
                        if (n23 < n24) {
                            final int n25 = n13;
                            BytecodeManager.incBytecodes(3);
                            if (n25 <= n2) {
                                break Label_0460;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            ++n12;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n26 = n12;
                final int n27 = n13;
                BytecodeManager.incBytecodes(3);
                if (n26 >= n27) {
                    break;
                }
                final int n28 = n12 + (n13 - n12 >>> 1);
                BytecodeManager.incBytecodes(8);
                final Object o4 = array[n + n28];
                BytecodeManager.incBytecodes(7);
                final int compareTo4 = comparable.compareTo(o4);
                BytecodeManager.incBytecodes(1);
                if (compareTo4 > 0) {
                    n12 = n28 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n13 = n28;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final int n29 = n12;
                final int n30 = n13;
                BytecodeManager.incBytecodes(3);
                if (n29 != n30) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError3 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError3;
                }
            }
            final int n31 = n13;
            BytecodeManager.incBytecodes(2);
            return n31;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int gallopRight(final Comparable<Object> comparable, final Object[] array, final int n, final int n2, final int n3) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0059: {
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (n2 > 0) {
                        BytecodeManager.incBytecodes(2);
                        if (n3 >= 0) {
                            BytecodeManager.incBytecodes(3);
                            if (n3 < n2) {
                                break Label_0059;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            int n4 = 1;
            BytecodeManager.incBytecodes(2);
            int n5 = 0;
            BytecodeManager.incBytecodes(2);
            final Object o = array[n + n3];
            BytecodeManager.incBytecodes(7);
            final int compareTo = comparable.compareTo(o);
            BytecodeManager.incBytecodes(1);
            int n13;
            int n14;
            if (compareTo < 0) {
                final int n6 = n3 + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n7 = n4;
                    final int n8 = n6;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        break;
                    }
                    final Object o2 = array[n + n3 - n4];
                    BytecodeManager.incBytecodes(9);
                    final int compareTo2 = comparable.compareTo(o2);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo2 >= 0) {
                        break;
                    }
                    n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    n4 = (n4 << 1) + 1;
                    BytecodeManager.incBytecodes(6);
                    final int n9 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n9 > 0) {
                        continue;
                    }
                    n4 = n6;
                    BytecodeManager.incBytecodes(3);
                }
                final int n10 = n4;
                final int n11 = n6;
                BytecodeManager.incBytecodes(3);
                if (n10 > n11) {
                    n4 = n6;
                    BytecodeManager.incBytecodes(2);
                }
                final int n12 = n5;
                BytecodeManager.incBytecodes(2);
                n13 = n3 - n4;
                BytecodeManager.incBytecodes(4);
                n14 = n3 - n12;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final int n15 = n2 - n3;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n16 = n4;
                    final int n17 = n15;
                    BytecodeManager.incBytecodes(3);
                    if (n16 >= n17) {
                        break;
                    }
                    final Object o3 = array[n + n3 + n4];
                    BytecodeManager.incBytecodes(9);
                    final int compareTo3 = comparable.compareTo(o3);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo3 < 0) {
                        break;
                    }
                    n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    n4 = (n4 << 1) + 1;
                    BytecodeManager.incBytecodes(6);
                    final int n18 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n18 > 0) {
                        continue;
                    }
                    n4 = n15;
                    BytecodeManager.incBytecodes(3);
                }
                final int n19 = n4;
                final int n20 = n15;
                BytecodeManager.incBytecodes(3);
                if (n19 > n20) {
                    n4 = n15;
                    BytecodeManager.incBytecodes(2);
                }
                n13 = n5 + n3;
                BytecodeManager.incBytecodes(4);
                n14 = n4 + n3;
                BytecodeManager.incBytecodes(4);
            }
            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0460: {
                if (!$assertionsDisabled2) {
                    final int n21 = -1;
                    final int n22 = n13;
                    BytecodeManager.incBytecodes(3);
                    if (n21 <= n22) {
                        final int n23 = n13;
                        final int n24 = n14;
                        BytecodeManager.incBytecodes(3);
                        if (n23 < n24) {
                            final int n25 = n14;
                            BytecodeManager.incBytecodes(3);
                            if (n25 <= n2) {
                                break Label_0460;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
            }
            ++n13;
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n26 = n13;
                final int n27 = n14;
                BytecodeManager.incBytecodes(3);
                if (n26 >= n27) {
                    break;
                }
                final int n28 = n13 + (n14 - n13 >>> 1);
                BytecodeManager.incBytecodes(8);
                final Object o4 = array[n + n28];
                BytecodeManager.incBytecodes(7);
                final int compareTo4 = comparable.compareTo(o4);
                BytecodeManager.incBytecodes(1);
                if (compareTo4 < 0) {
                    n14 = n28;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    n13 = n28 + 1;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled3) {
                final int n29 = n13;
                final int n30 = n14;
                BytecodeManager.incBytecodes(3);
                if (n29 != n30) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError3 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError3;
                }
            }
            final int n31 = n14;
            BytecodeManager.incBytecodes(2);
            return n31;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mergeLo(final int n, int n2, final int n3, int n4) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0060: {
                if (!$assertionsDisabled) {
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n5 > 0) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n6 > 0) {
                            final int n7 = n + n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 == n3) {
                                break Label_0060;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final Object[] a = this.a;
            BytecodeManager.incBytecodes(3);
            final int n8 = n2;
            BytecodeManager.incBytecodes(3);
            final Object[] ensureCapacity = this.ensureCapacity(n8);
            BytecodeManager.incBytecodes(1);
            int tmpBase = this.tmpBase;
            BytecodeManager.incBytecodes(3);
            int n9 = n3;
            BytecodeManager.incBytecodes(2);
            int n10 = n;
            BytecodeManager.incBytecodes(2);
            final Object[] array = a;
            final Object[] array2 = ensureCapacity;
            final int n11 = tmpBase;
            final int n12 = n2;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array, n, array2, n11, n12);
            a[n10++] = a[n9++];
            BytecodeManager.incBytecodes(8);
            final int n13 = --n4;
            BytecodeManager.incBytecodes(3);
            if (n13 == 0) {
                final Object[] array3 = ensureCapacity;
                final int n14 = tmpBase;
                final Object[] array4 = a;
                final int n15 = n10;
                final int n16 = n2;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array3, n14, array4, n15, n16);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final boolean b = n2 != 0;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(3);
            if (b == b2) {
                final Object[] array5 = a;
                final int n17 = n9;
                final Object[] array6 = a;
                final int n18 = n10;
                final int n19 = n4;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array5, n17, array6, n18, n19);
                a[n10 + n4] = ensureCapacity[tmpBase];
                BytecodeManager.incBytecodes(8);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int minGallop = this.minGallop;
            BytecodeManager.incBytecodes(3);
            Label_0937: {
                Label_0509: {
                Label_0298:
                    while (true) {
                        int n20 = 0;
                        BytecodeManager.incBytecodes(2);
                        int n21 = 0;
                        BytecodeManager.incBytecodes(2);
                        int i;
                        int n22;
                        do {
                            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled2) {
                                final int n23 = n2;
                                final int n24 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n23 <= n24) {
                                    break Label_0298;
                                }
                                final int n25 = n4;
                                BytecodeManager.incBytecodes(2);
                                if (n25 <= 0) {
                                    break Label_0298;
                                }
                            }
                            final Comparable comparable = (Comparable)a[n9];
                            final Object o = ensureCapacity[tmpBase];
                            BytecodeManager.incBytecodes(8);
                            final int compareTo = comparable.compareTo(o);
                            BytecodeManager.incBytecodes(1);
                            if (compareTo < 0) {
                                a[n10++] = a[n9++];
                                BytecodeManager.incBytecodes(8);
                                ++n21;
                                BytecodeManager.incBytecodes(1);
                                n20 = 0;
                                BytecodeManager.incBytecodes(2);
                                final int n26 = --n4;
                                BytecodeManager.incBytecodes(3);
                                if (n26 == 0) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0937;
                                }
                            }
                            else {
                                a[n10++] = ensureCapacity[tmpBase++];
                                BytecodeManager.incBytecodes(8);
                                ++n20;
                                BytecodeManager.incBytecodes(1);
                                n21 = 0;
                                BytecodeManager.incBytecodes(2);
                                final int n27 = --n2;
                                final int n28 = 1;
                                BytecodeManager.incBytecodes(4);
                                if (n27 == n28) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0937;
                                }
                            }
                            i = (n20 | n21);
                            n22 = minGallop;
                            BytecodeManager.incBytecodes(5);
                        } while (i < n22);
                        boolean b3;
                        do {
                            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled3) {
                                final int n29 = n2;
                                final int n30 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n29 <= n30) {
                                    break Label_0509;
                                }
                                final int n31 = n4;
                                BytecodeManager.incBytecodes(2);
                                if (n31 <= 0) {
                                    break Label_0509;
                                }
                            }
                            final Comparable comparable2 = (Comparable)a[n9];
                            final Object[] array7 = ensureCapacity;
                            final int n32 = tmpBase;
                            final int n33 = n2;
                            final int n34 = 0;
                            BytecodeManager.incBytecodes(9);
                            final int gallopRight = gallopRight(comparable2, array7, n32, n33, n34);
                            BytecodeManager.incBytecodes(1);
                            final int n35 = gallopRight;
                            BytecodeManager.incBytecodes(2);
                            if (n35 != 0) {
                                final Object[] array8 = ensureCapacity;
                                final int n36 = tmpBase;
                                final Object[] array9 = a;
                                final int n37 = n10;
                                final int n38 = gallopRight;
                                BytecodeManager.incBytecodes(6);
                                System.arraycopy(array8, n36, array9, n37, n38);
                                n10 += gallopRight;
                                BytecodeManager.incBytecodes(4);
                                tmpBase += gallopRight;
                                BytecodeManager.incBytecodes(4);
                                n2 -= gallopRight;
                                BytecodeManager.incBytecodes(4);
                                final int n39 = n2;
                                final int n40 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n39 <= n40) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0937;
                                }
                            }
                            a[n10++] = a[n9++];
                            BytecodeManager.incBytecodes(8);
                            final int n41 = --n4;
                            BytecodeManager.incBytecodes(3);
                            if (n41 == 0) {
                                BytecodeManager.incBytecodes(1);
                                break Label_0937;
                            }
                            final Comparable comparable3 = (Comparable)ensureCapacity[tmpBase];
                            final Object[] array10 = a;
                            final int n42 = n9;
                            final int n43 = n4;
                            final int n44 = 0;
                            BytecodeManager.incBytecodes(9);
                            final int gallopLeft = gallopLeft(comparable3, array10, n42, n43, n44);
                            BytecodeManager.incBytecodes(1);
                            final int n45 = gallopLeft;
                            BytecodeManager.incBytecodes(2);
                            if (n45 != 0) {
                                final Object[] array11 = a;
                                final int n46 = n9;
                                final Object[] array12 = a;
                                final int n47 = n10;
                                final int n48 = gallopLeft;
                                BytecodeManager.incBytecodes(6);
                                System.arraycopy(array11, n46, array12, n47, n48);
                                n10 += gallopLeft;
                                BytecodeManager.incBytecodes(4);
                                n9 += gallopLeft;
                                BytecodeManager.incBytecodes(4);
                                n4 -= gallopLeft;
                                BytecodeManager.incBytecodes(4);
                                final boolean b4 = n4 != 0;
                                BytecodeManager.incBytecodes(2);
                                if (!b4) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_0937;
                                }
                            }
                            a[n10++] = ensureCapacity[tmpBase++];
                            BytecodeManager.incBytecodes(8);
                            final int n49 = --n2;
                            final int n50 = 1;
                            BytecodeManager.incBytecodes(4);
                            if (n49 == n50) {
                                BytecodeManager.incBytecodes(1);
                                break Label_0937;
                            }
                            --minGallop;
                            BytecodeManager.incBytecodes(1);
                            final int n51 = gallopRight;
                            final int n52 = 7;
                            BytecodeManager.incBytecodes(3);
                            boolean b5;
                            if (n51 >= n52) {
                                b5 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b5 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n53 = gallopLeft;
                            final int n54 = 7;
                            BytecodeManager.incBytecodes(3);
                            boolean b6;
                            if (n53 >= n54) {
                                b6 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b6 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            b3 = (b5 | b6);
                            BytecodeManager.incBytecodes(2);
                        } while (b3);
                        final int n55 = minGallop;
                        BytecodeManager.incBytecodes(2);
                        if (n55 < 0) {
                            minGallop = 0;
                            BytecodeManager.incBytecodes(2);
                        }
                        minGallop += 2;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
                BytecodeManager.incBytecodes(3);
                final AssertionError assertionError3 = new AssertionError();
                BytecodeManager.incBytecodes(1);
                throw assertionError3;
            }
            final int n56 = minGallop;
            final int n57 = 1;
            BytecodeManager.incBytecodes(4);
            int minGallop2;
            if (n56 < n57) {
                minGallop2 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                minGallop2 = minGallop;
                BytecodeManager.incBytecodes(1);
            }
            this.minGallop = minGallop2;
            BytecodeManager.incBytecodes(1);
            final boolean b7 = n2 != 0;
            final boolean b8 = true;
            BytecodeManager.incBytecodes(3);
            if (b7 == b8) {
                final boolean $assertionsDisabled4 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled4) {
                    final int n58 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n58 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError4 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError4;
                    }
                }
                final Object[] array13 = a;
                final int n59 = n9;
                final Object[] array14 = a;
                final int n60 = n10;
                final int n61 = n4;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array13, n59, array14, n60, n61);
                a[n10 + n4] = ensureCapacity[tmpBase];
                BytecodeManager.incBytecodes(9);
            }
            else {
                final boolean b9 = n2 != 0;
                BytecodeManager.incBytecodes(2);
                if (!b9) {
                    final String s = "Comparison method violates its general contract!";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean $assertionsDisabled5 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled5) {
                    final boolean b10 = n4 != 0;
                    BytecodeManager.incBytecodes(2);
                    if (b10) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError5 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError5;
                    }
                }
                final boolean $assertionsDisabled6 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled6) {
                    final int n62 = n2;
                    final int n63 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n62 <= n63) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError6 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError6;
                    }
                }
                final Object[] array15 = ensureCapacity;
                final int n64 = tmpBase;
                final Object[] array16 = a;
                final int n65 = n10;
                final int n66 = n2;
                BytecodeManager.incBytecodes(6);
                System.arraycopy(array15, n64, array16, n65, n66);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void mergeHi(final int n, int n2, final int n3, int n4) {
        try {
            final boolean $assertionsDisabled = ComparableTimSort.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            Label_0060: {
                if (!$assertionsDisabled) {
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n5 > 0) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(2);
                        if (n6 > 0) {
                            final int n7 = n + n2;
                            BytecodeManager.incBytecodes(5);
                            if (n7 == n3) {
                                break Label_0060;
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            final Object[] a = this.a;
            BytecodeManager.incBytecodes(3);
            final int n8 = n4;
            BytecodeManager.incBytecodes(3);
            final Object[] ensureCapacity = this.ensureCapacity(n8);
            BytecodeManager.incBytecodes(1);
            final int tmpBase = this.tmpBase;
            BytecodeManager.incBytecodes(3);
            final Object[] array = a;
            final Object[] array2 = ensureCapacity;
            final int n9 = tmpBase;
            final int n10 = n4;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array, n3, array2, n9, n10);
            int n11 = n + n2 - 1;
            BytecodeManager.incBytecodes(6);
            int n12 = tmpBase + n4 - 1;
            BytecodeManager.incBytecodes(6);
            int n13 = n3 + n4 - 1;
            BytecodeManager.incBytecodes(6);
            a[n13--] = a[n11--];
            BytecodeManager.incBytecodes(8);
            final int n14 = --n2;
            BytecodeManager.incBytecodes(3);
            if (n14 == 0) {
                final Object[] array3 = ensureCapacity;
                final int n15 = tmpBase;
                final Object[] array4 = a;
                final int n16 = n13 - (n4 - 1);
                final int n17 = n4;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(array3, n15, array4, n16, n17);
                BytecodeManager.incBytecodes(1);
                return;
            }
            final boolean b = n4 != 0;
            final boolean b2 = true;
            BytecodeManager.incBytecodes(3);
            if (b == b2) {
                final int n18 = n13 - n2;
                BytecodeManager.incBytecodes(4);
                final int n19 = n11 - n2;
                BytecodeManager.incBytecodes(4);
                final Object[] array5 = a;
                final int n20 = n19 + 1;
                final Object[] array6 = a;
                final int n21 = n18 + 1;
                final int n22 = n2;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(array5, n20, array6, n21, n22);
                a[n18] = ensureCapacity[n12];
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                return;
            }
            int minGallop = this.minGallop;
            BytecodeManager.incBytecodes(3);
            Label_1007: {
                Label_0562: {
                Label_0351:
                    while (true) {
                        int n23 = 0;
                        BytecodeManager.incBytecodes(2);
                        int n24 = 0;
                        BytecodeManager.incBytecodes(2);
                        int i;
                        int n25;
                        do {
                            final boolean $assertionsDisabled2 = ComparableTimSort.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled2) {
                                final int n26 = n2;
                                BytecodeManager.incBytecodes(2);
                                if (n26 <= 0) {
                                    break Label_0351;
                                }
                                final int n27 = n4;
                                final int n28 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n27 <= n28) {
                                    break Label_0351;
                                }
                            }
                            final Comparable comparable = (Comparable)ensureCapacity[n12];
                            final Object o = a[n11];
                            BytecodeManager.incBytecodes(8);
                            final int compareTo = comparable.compareTo(o);
                            BytecodeManager.incBytecodes(1);
                            if (compareTo < 0) {
                                a[n13--] = a[n11--];
                                BytecodeManager.incBytecodes(8);
                                ++n23;
                                BytecodeManager.incBytecodes(1);
                                n24 = 0;
                                BytecodeManager.incBytecodes(2);
                                final int n29 = --n2;
                                BytecodeManager.incBytecodes(3);
                                if (n29 == 0) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_1007;
                                }
                            }
                            else {
                                a[n13--] = ensureCapacity[n12--];
                                BytecodeManager.incBytecodes(8);
                                ++n24;
                                BytecodeManager.incBytecodes(1);
                                n23 = 0;
                                BytecodeManager.incBytecodes(2);
                                final int n30 = --n4;
                                final int n31 = 1;
                                BytecodeManager.incBytecodes(4);
                                if (n30 == n31) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_1007;
                                }
                            }
                            i = (n23 | n24);
                            n25 = minGallop;
                            BytecodeManager.incBytecodes(5);
                        } while (i < n25);
                        boolean b3;
                        do {
                            final boolean $assertionsDisabled3 = ComparableTimSort.$assertionsDisabled;
                            BytecodeManager.incBytecodes(2);
                            if (!$assertionsDisabled3) {
                                final int n32 = n2;
                                BytecodeManager.incBytecodes(2);
                                if (n32 <= 0) {
                                    break Label_0562;
                                }
                                final int n33 = n4;
                                final int n34 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n33 <= n34) {
                                    break Label_0562;
                                }
                            }
                            final int n35 = n2;
                            final Comparable comparable2 = (Comparable)ensureCapacity[n12];
                            final Object[] array7 = a;
                            final int n36 = n2;
                            final int n37 = n2 - 1;
                            BytecodeManager.incBytecodes(12);
                            final int n38 = n35 - gallopRight(comparable2, array7, n, n36, n37);
                            BytecodeManager.incBytecodes(2);
                            final int n39 = n38;
                            BytecodeManager.incBytecodes(2);
                            if (n39 != 0) {
                                n13 -= n38;
                                BytecodeManager.incBytecodes(4);
                                n11 -= n38;
                                BytecodeManager.incBytecodes(4);
                                n2 -= n38;
                                BytecodeManager.incBytecodes(4);
                                final Object[] array8 = a;
                                final int n40 = n11 + 1;
                                final Object[] array9 = a;
                                final int n41 = n13 + 1;
                                final int n42 = n38;
                                BytecodeManager.incBytecodes(10);
                                System.arraycopy(array8, n40, array9, n41, n42);
                                final boolean b4 = n2 != 0;
                                BytecodeManager.incBytecodes(2);
                                if (!b4) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_1007;
                                }
                            }
                            a[n13--] = ensureCapacity[n12--];
                            BytecodeManager.incBytecodes(8);
                            final int n43 = --n4;
                            final int n44 = 1;
                            BytecodeManager.incBytecodes(4);
                            if (n43 == n44) {
                                BytecodeManager.incBytecodes(1);
                                break Label_1007;
                            }
                            final int n45 = n4;
                            final Comparable comparable3 = (Comparable)a[n11];
                            final Object[] array10 = ensureCapacity;
                            final int n46 = tmpBase;
                            final int n47 = n4;
                            final int n48 = n4 - 1;
                            BytecodeManager.incBytecodes(12);
                            final int n49 = n45 - gallopLeft(comparable3, array10, n46, n47, n48);
                            BytecodeManager.incBytecodes(2);
                            final int n50 = n49;
                            BytecodeManager.incBytecodes(2);
                            if (n50 != 0) {
                                n13 -= n49;
                                BytecodeManager.incBytecodes(4);
                                n12 -= n49;
                                BytecodeManager.incBytecodes(4);
                                n4 -= n49;
                                BytecodeManager.incBytecodes(4);
                                final Object[] array11 = ensureCapacity;
                                final int n51 = n12 + 1;
                                final Object[] array12 = a;
                                final int n52 = n13 + 1;
                                final int n53 = n49;
                                BytecodeManager.incBytecodes(10);
                                System.arraycopy(array11, n51, array12, n52, n53);
                                final int n54 = n4;
                                final int n55 = 1;
                                BytecodeManager.incBytecodes(3);
                                if (n54 <= n55) {
                                    BytecodeManager.incBytecodes(1);
                                    break Label_1007;
                                }
                            }
                            a[n13--] = a[n11--];
                            BytecodeManager.incBytecodes(8);
                            final int n56 = --n2;
                            BytecodeManager.incBytecodes(3);
                            if (n56 == 0) {
                                BytecodeManager.incBytecodes(1);
                                break Label_1007;
                            }
                            --minGallop;
                            BytecodeManager.incBytecodes(1);
                            final int n57 = n38;
                            final int n58 = 7;
                            BytecodeManager.incBytecodes(3);
                            boolean b5;
                            if (n57 >= n58) {
                                b5 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b5 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            final int n59 = n49;
                            final int n60 = 7;
                            BytecodeManager.incBytecodes(3);
                            boolean b6;
                            if (n59 >= n60) {
                                b6 = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                b6 = false;
                                BytecodeManager.incBytecodes(1);
                            }
                            b3 = (b5 | b6);
                            BytecodeManager.incBytecodes(2);
                        } while (b3);
                        final int n61 = minGallop;
                        BytecodeManager.incBytecodes(2);
                        if (n61 < 0) {
                            minGallop = 0;
                            BytecodeManager.incBytecodes(2);
                        }
                        minGallop += 2;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError2 = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError2;
                }
                BytecodeManager.incBytecodes(3);
                final AssertionError assertionError3 = new AssertionError();
                BytecodeManager.incBytecodes(1);
                throw assertionError3;
            }
            final int n62 = minGallop;
            final int n63 = 1;
            BytecodeManager.incBytecodes(4);
            int minGallop2;
            if (n62 < n63) {
                minGallop2 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                minGallop2 = minGallop;
                BytecodeManager.incBytecodes(1);
            }
            this.minGallop = minGallop2;
            BytecodeManager.incBytecodes(1);
            final boolean b7 = n4 != 0;
            final boolean b8 = true;
            BytecodeManager.incBytecodes(3);
            if (b7 == b8) {
                final boolean $assertionsDisabled4 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled4) {
                    final int n64 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n64 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError4 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError4;
                    }
                }
                final int n65 = n13 - n2;
                BytecodeManager.incBytecodes(4);
                final int n66 = n11 - n2;
                BytecodeManager.incBytecodes(4);
                final Object[] array13 = a;
                final int n67 = n66 + 1;
                final Object[] array14 = a;
                final int n68 = n65 + 1;
                final int n69 = n2;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(array13, n67, array14, n68, n69);
                a[n65] = ensureCapacity[n12];
                BytecodeManager.incBytecodes(7);
            }
            else {
                final boolean b9 = n4 != 0;
                BytecodeManager.incBytecodes(2);
                if (!b9) {
                    final String s = "Comparison method violates its general contract!";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final boolean $assertionsDisabled5 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled5) {
                    final boolean b10 = n2 != 0;
                    BytecodeManager.incBytecodes(2);
                    if (b10) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError5 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError5;
                    }
                }
                final boolean $assertionsDisabled6 = ComparableTimSort.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled6) {
                    final int n70 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n70 <= 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError6 = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError6;
                    }
                }
                final Object[] array15 = ensureCapacity;
                final int n71 = tmpBase;
                final Object[] array16 = a;
                final int n72 = n13 - (n4 - 1);
                final int n73 = n4;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(array15, n71, array16, n72, n73);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object[] ensureCapacity(final int n) {
        try {
            final int tmpLen = this.tmpLen;
            BytecodeManager.incBytecodes(4);
            if (tmpLen < n) {
                BytecodeManager.incBytecodes(2);
                final int n2 = n | n >> 1;
                BytecodeManager.incBytecodes(6);
                final int n3 = n2 | n2 >> 2;
                BytecodeManager.incBytecodes(6);
                final int n4 = n3 | n3 >> 4;
                BytecodeManager.incBytecodes(6);
                final int n5 = n4 | n4 >> 8;
                BytecodeManager.incBytecodes(6);
                int n6 = n5 | n5 >> 16;
                BytecodeManager.incBytecodes(6);
                ++n6;
                BytecodeManager.incBytecodes(1);
                final int n7 = n6;
                BytecodeManager.incBytecodes(2);
                int min;
                if (n7 < 0) {
                    min = n;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final int a = n6;
                    final int b = this.a.length >>> 1;
                    BytecodeManager.incBytecodes(7);
                    min = Math.min(a, b);
                    BytecodeManager.incBytecodes(1);
                }
                final Object[] tmp = new Object[min];
                BytecodeManager.incBytecodes(2);
                this.tmp = tmp;
                BytecodeManager.incBytecodes(3);
                this.tmpLen = min;
                BytecodeManager.incBytecodes(3);
                this.tmpBase = 0;
                BytecodeManager.incBytecodes(3);
            }
            final Object[] tmp2 = this.tmp;
            BytecodeManager.incBytecodes(3);
            return tmp2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<ComparableTimSort> clazz = ComparableTimSort.class;
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
}
