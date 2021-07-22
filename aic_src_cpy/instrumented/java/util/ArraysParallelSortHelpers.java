// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.concurrent.CountedCompleter;
import aic2021.engine.BytecodeManager;

class ArraysParallelSortHelpers
{
    ArraysParallelSortHelpers() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class EmptyCompleter extends CountedCompleter<Void>
    {
        static final long serialVersionUID = 2446542900576103244L;
        
        EmptyCompleter(final CountedCompleter<?> countedCompleter) {
            try {
                BytecodeManager.incBytecodes(3);
                super(countedCompleter);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Relay extends CountedCompleter<Void>
    {
        static final long serialVersionUID = 2446542900576103244L;
        final CountedCompleter<?> task;
        
        Relay(final CountedCompleter<?> task) {
            try {
                final CountedCompleter countedCompleter = null;
                final int n = 1;
                BytecodeManager.incBytecodes(4);
                super(countedCompleter, n);
                this.task = task;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void compute() {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void onCompletion(final CountedCompleter<?> countedCompleter) {
            try {
                final CountedCompleter<?> task = this.task;
                BytecodeManager.incBytecodes(3);
                task.compute();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class FJObject
    {
        FJObject() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter<T> extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            final T[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            Comparator<? super T> comparator;
            
            Sorter(final CountedCompleter<?> countedCompleter, final T[] a, final T[] w, final int base, final int size, final int wbase, final int gran, final Comparator<? super T> comparator) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
                    BytecodeManager.incBytecodes(6);
                    this.comparator = comparator;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final void compute() {
                try {
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final Comparator<? super T> comparator = this.comparator;
                    BytecodeManager.incBytecodes(3);
                    final T[] a = this.a;
                    final T[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final?[] array = (Object[])w;
                        final?[] array2 = (Object[])a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        final Comparator<? super Object> comparator2 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(19);
                        final Merger merger = new Merger<Object>(countedCompleter2, (Object[])array, (Object[])array2, n6, n7, n8, n9, n10, n11, comparator2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final?[] array3 = (Object[])a;
                        final?[] array4 = (Object[])w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        final Comparator<? super Object> comparator3 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(23);
                        final Merger merger2 = new Merger<Object>(relay2, (Object[])array3, (Object[])array4, n12, n13, n14, n15, n16, n17, comparator3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final T[] array5 = a;
                        final T[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        final Comparator<? super Object> comparator4 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(17);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21, comparator4);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final T[] array7 = a;
                        final T[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        final Comparator<? super Object> comparator5 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(15);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25, comparator5);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final?[] array9 = (Object[])a;
                        final?[] array10 = (Object[])w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        final Comparator<? super Object> comparator6 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(19);
                        final Merger merger3 = new Merger<Object>(relay6, (Object[])array9, (Object[])array10, n26, n27, n28, n29, n30, n31, comparator6);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final T[] array11 = a;
                        final T[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        final Comparator<? super Object> comparator7 = (Comparator<? super Object>)comparator;
                        BytecodeManager.incBytecodes(17);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35, comparator7);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final T[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size;
                    final Comparator<? super Object> comparator8 = (Comparator<? super Object>)comparator;
                    final T[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(10);
                    TimSort.sort(array13, n36, n37, comparator8, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger<T> extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            final T[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            Comparator<? super T> comparator;
            
            Merger(final CountedCompleter<?> countedCompleter, final T[] a, final T[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran, final Comparator<? super T> comparator) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
                    BytecodeManager.incBytecodes(6);
                    this.comparator = comparator;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final void compute() {
                try {
                    final Comparator<? super T> comparator = this.comparator;
                    BytecodeManager.incBytecodes(3);
                    final T[] a = this.a;
                    final T[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final T[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final T[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        final Comparator<? super T> comparator2 = comparator;
                                        BytecodeManager.incBytecodes(2);
                                        if (comparator2 != null) {
                                            while (true) {
                                                final int n4 = lsize;
                                                final int n5 = rsize;
                                                BytecodeManager.incBytecodes(3);
                                                int n8;
                                                int n9;
                                                if (n4 >= n5) {
                                                    final int n6 = lsize;
                                                    final int n7 = gran;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n6 <= n7) {
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                    n8 = rsize;
                                                    BytecodeManager.incBytecodes(2);
                                                    final T t = a[(n9 = lsize >>> 1) + lbase];
                                                    BytecodeManager.incBytecodes(10);
                                                    int n10 = 0;
                                                    BytecodeManager.incBytecodes(2);
                                                    while (true) {
                                                        final int n11 = n10;
                                                        final int n12 = n8;
                                                        BytecodeManager.incBytecodes(3);
                                                        if (n11 >= n12) {
                                                            break;
                                                        }
                                                        final int n13 = n10 + n8 >>> 1;
                                                        BytecodeManager.incBytecodes(6);
                                                        final Comparator<? super T> comparator3 = comparator;
                                                        final T t2 = t;
                                                        final T t3 = a[n13 + rbase];
                                                        BytecodeManager.incBytecodes(8);
                                                        final int compare = comparator3.compare(t2, t3);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (compare <= 0) {
                                                            n8 = n13;
                                                            BytecodeManager.incBytecodes(3);
                                                        }
                                                        else {
                                                            n10 = n13 + 1;
                                                            BytecodeManager.incBytecodes(4);
                                                        }
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                else {
                                                    final int n14 = rsize;
                                                    final int n15 = gran;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n14 <= n15) {
                                                        BytecodeManager.incBytecodes(1);
                                                        break;
                                                    }
                                                    n9 = lsize;
                                                    BytecodeManager.incBytecodes(2);
                                                    final T t4 = a[(n8 = rsize >>> 1) + rbase];
                                                    BytecodeManager.incBytecodes(10);
                                                    int n16 = 0;
                                                    BytecodeManager.incBytecodes(2);
                                                    while (true) {
                                                        final int n17 = n16;
                                                        final int n18 = n9;
                                                        BytecodeManager.incBytecodes(3);
                                                        if (n17 >= n18) {
                                                            break;
                                                        }
                                                        final int n19 = n16 + n9 >>> 1;
                                                        BytecodeManager.incBytecodes(6);
                                                        final Comparator<? super T> comparator4 = comparator;
                                                        final T t5 = t4;
                                                        final T t6 = a[n19 + lbase];
                                                        BytecodeManager.incBytecodes(8);
                                                        final int compare2 = comparator4.compare(t5, t6);
                                                        BytecodeManager.incBytecodes(1);
                                                        if (compare2 <= 0) {
                                                            n9 = n19;
                                                            BytecodeManager.incBytecodes(3);
                                                        }
                                                        else {
                                                            n16 = n19 + 1;
                                                            BytecodeManager.incBytecodes(4);
                                                        }
                                                        BytecodeManager.incBytecodes(1);
                                                    }
                                                }
                                                final T[] array3 = a;
                                                final T[] array4 = w;
                                                final int n20 = lbase + n9;
                                                final int n21 = lsize - n9;
                                                final int n22 = rbase + n8;
                                                final int n23 = rsize - n8;
                                                final int n24 = wbase + n9 + n8;
                                                final int n25 = gran;
                                                final Comparator<? super T> comparator5 = comparator;
                                                BytecodeManager.incBytecodes(25);
                                                final Merger merger = new Merger(this, array3, array4, n20, n21, n22, n23, n24, n25, (Comparator<? super Object>)comparator5);
                                                BytecodeManager.incBytecodes(1);
                                                rsize = n8;
                                                BytecodeManager.incBytecodes(2);
                                                lsize = n9;
                                                BytecodeManager.incBytecodes(2);
                                                final int n26 = 1;
                                                BytecodeManager.incBytecodes(3);
                                                this.addToPendingCount(n26);
                                                final Merger merger2 = merger;
                                                BytecodeManager.incBytecodes(2);
                                                merger2.fork();
                                                BytecodeManager.incBytecodes(1);
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            final int n27 = lbase + lsize;
                                            final int n28 = rbase + rsize;
                                            BytecodeManager.incBytecodes(8);
                                            while (true) {
                                                final int n29 = lbase;
                                                final int n30 = n27;
                                                BytecodeManager.incBytecodes(3);
                                                if (n29 >= n30) {
                                                    break;
                                                }
                                                final int n31 = rbase;
                                                final int n32 = n28;
                                                BytecodeManager.incBytecodes(3);
                                                if (n31 >= n32) {
                                                    break;
                                                }
                                                final Comparator<? super T> comparator6 = comparator;
                                                final T t7 = a[lbase];
                                                final T t8 = a[rbase];
                                                BytecodeManager.incBytecodes(12);
                                                final int compare3 = comparator6.compare(t7, t8);
                                                BytecodeManager.incBytecodes(1);
                                                T t9;
                                                if (compare3 <= 0) {
                                                    ++lbase;
                                                    t9 = t7;
                                                    BytecodeManager.incBytecodes(4);
                                                }
                                                else {
                                                    ++rbase;
                                                    t9 = t8;
                                                    BytecodeManager.incBytecodes(3);
                                                }
                                                w[wbase++] = t9;
                                                BytecodeManager.incBytecodes(5);
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            final int n33 = rbase;
                                            final int n34 = n28;
                                            BytecodeManager.incBytecodes(3);
                                            if (n33 < n34) {
                                                final T[] array5 = a;
                                                final int n35 = rbase;
                                                final T[] array6 = w;
                                                final int n36 = wbase;
                                                final int n37 = n28 - rbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array5, n35, array6, n36, n37);
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n38 = lbase;
                                                final int n39 = n27;
                                                BytecodeManager.incBytecodes(3);
                                                if (n38 < n39) {
                                                    final T[] array7 = a;
                                                    final int n40 = lbase;
                                                    final T[] array8 = w;
                                                    final int n41 = wbase;
                                                    final int n42 = n27 - lbase;
                                                    BytecodeManager.incBytecodes(8);
                                                    System.arraycopy(array7, n40, array8, n41, n42);
                                                }
                                            }
                                            BytecodeManager.incBytecodes(2);
                                            this.tryComplete();
                                            BytecodeManager.incBytecodes(1);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJByte
    {
        FJByte() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final byte[] a;
            final byte[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final byte[] a, final byte[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final byte[] a = this.a;
                    final byte[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final byte[] array = w;
                        final byte[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final byte[] array3 = a;
                        final byte[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final byte[] array5 = a;
                        final byte[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final byte[] array7 = a;
                        final byte[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final byte[] array9 = a;
                        final byte[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final byte[] array11 = a;
                        final byte[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final byte[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    BytecodeManager.incBytecodes(8);
                    DualPivotQuicksort.sort(array13, n36, n37);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final byte[] a;
            final byte[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final byte[] a, final byte[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final byte[] a = this.a;
                    final byte[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final byte[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final byte[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n9;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final byte b = a[(n9 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n10 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n11 = n10;
                                                    final int n12 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n11 >= n12) {
                                                        break;
                                                    }
                                                    final int n13 = n10 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final byte b2 = b;
                                                    final byte b3 = a[n13 + rbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (b2 <= b3) {
                                                        n8 = n13;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n10 = n13 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n14 = rsize;
                                                final int n15 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n14 <= n15) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n9 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final byte b4 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n16 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n17 = n16;
                                                    final int n18 = n9;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n17 >= n18) {
                                                        break;
                                                    }
                                                    final int n19 = n16 + n9 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final byte b5 = b4;
                                                    final byte b6 = a[n19 + lbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (b5 <= b6) {
                                                        n9 = n19;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n16 = n19 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final byte[] array3 = a;
                                            final byte[] array4 = w;
                                            final int n20 = lbase + n9;
                                            final int n21 = lsize - n9;
                                            final int n22 = rbase + n8;
                                            final int n23 = rsize - n8;
                                            final int n24 = wbase + n9 + n8;
                                            final int n25 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n20, n21, n22, n23, n24, n25);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n9;
                                            BytecodeManager.incBytecodes(2);
                                            final int n26 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n26);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n27 = lbase + lsize;
                                        final int n28 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n29 = lbase;
                                            final int n30 = n27;
                                            BytecodeManager.incBytecodes(3);
                                            if (n29 >= n30) {
                                                break;
                                            }
                                            final int n31 = rbase;
                                            final int n32 = n28;
                                            BytecodeManager.incBytecodes(3);
                                            if (n31 >= n32) {
                                                break;
                                            }
                                            final byte b7 = a[lbase];
                                            final byte b8 = a[rbase];
                                            BytecodeManager.incBytecodes(11);
                                            byte b9;
                                            if (b7 <= b8) {
                                                ++lbase;
                                                b9 = b7;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                b9 = b8;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = b9;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n33 = rbase;
                                        final int n34 = n28;
                                        BytecodeManager.incBytecodes(3);
                                        if (n33 < n34) {
                                            final byte[] array5 = a;
                                            final int n35 = rbase;
                                            final byte[] array6 = w;
                                            final int n36 = wbase;
                                            final int n37 = n28 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n35, array6, n36, n37);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n38 = lbase;
                                            final int n39 = n27;
                                            BytecodeManager.incBytecodes(3);
                                            if (n38 < n39) {
                                                final byte[] array7 = a;
                                                final int n40 = lbase;
                                                final byte[] array8 = w;
                                                final int n41 = wbase;
                                                final int n42 = n27 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n40, array8, n41, n42);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJChar
    {
        FJChar() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final char[] a;
            final char[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final char[] a, final char[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final char[] a = this.a;
                    final char[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final char[] array = w;
                        final char[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final char[] array3 = a;
                        final char[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final char[] array5 = a;
                        final char[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final char[] array7 = a;
                        final char[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final char[] array9 = a;
                        final char[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final char[] array11 = a;
                        final char[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final char[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final char[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final char[] a;
            final char[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final char[] a, final char[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final char[] a = this.a;
                    final char[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final char[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final char[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n9;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final char c = a[(n9 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n10 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n11 = n10;
                                                    final int n12 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n11 >= n12) {
                                                        break;
                                                    }
                                                    final int n13 = n10 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final char c2 = c;
                                                    final char c3 = a[n13 + rbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (c2 <= c3) {
                                                        n8 = n13;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n10 = n13 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n14 = rsize;
                                                final int n15 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n14 <= n15) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n9 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final char c4 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n16 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n17 = n16;
                                                    final int n18 = n9;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n17 >= n18) {
                                                        break;
                                                    }
                                                    final int n19 = n16 + n9 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final char c5 = c4;
                                                    final char c6 = a[n19 + lbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (c5 <= c6) {
                                                        n9 = n19;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n16 = n19 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final char[] array3 = a;
                                            final char[] array4 = w;
                                            final int n20 = lbase + n9;
                                            final int n21 = lsize - n9;
                                            final int n22 = rbase + n8;
                                            final int n23 = rsize - n8;
                                            final int n24 = wbase + n9 + n8;
                                            final int n25 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n20, n21, n22, n23, n24, n25);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n9;
                                            BytecodeManager.incBytecodes(2);
                                            final int n26 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n26);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n27 = lbase + lsize;
                                        final int n28 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n29 = lbase;
                                            final int n30 = n27;
                                            BytecodeManager.incBytecodes(3);
                                            if (n29 >= n30) {
                                                break;
                                            }
                                            final int n31 = rbase;
                                            final int n32 = n28;
                                            BytecodeManager.incBytecodes(3);
                                            if (n31 >= n32) {
                                                break;
                                            }
                                            final char c7 = a[lbase];
                                            final char c8 = a[rbase];
                                            BytecodeManager.incBytecodes(11);
                                            char c9;
                                            if (c7 <= c8) {
                                                ++lbase;
                                                c9 = c7;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                c9 = c8;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = c9;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n33 = rbase;
                                        final int n34 = n28;
                                        BytecodeManager.incBytecodes(3);
                                        if (n33 < n34) {
                                            final char[] array5 = a;
                                            final int n35 = rbase;
                                            final char[] array6 = w;
                                            final int n36 = wbase;
                                            final int n37 = n28 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n35, array6, n36, n37);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n38 = lbase;
                                            final int n39 = n27;
                                            BytecodeManager.incBytecodes(3);
                                            if (n38 < n39) {
                                                final char[] array7 = a;
                                                final int n40 = lbase;
                                                final char[] array8 = w;
                                                final int n41 = wbase;
                                                final int n42 = n27 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n40, array8, n41, n42);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJShort
    {
        FJShort() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final short[] a;
            final short[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final short[] a, final short[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final short[] a = this.a;
                    final short[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final short[] array = w;
                        final short[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final short[] array3 = a;
                        final short[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final short[] array5 = a;
                        final short[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final short[] array7 = a;
                        final short[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final short[] array9 = a;
                        final short[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final short[] array11 = a;
                        final short[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final short[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final short[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final short[] a;
            final short[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final short[] a, final short[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final short[] a = this.a;
                    final short[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final short[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final short[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n10;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final short n9 = a[(n10 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n11 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n12 = n11;
                                                    final int n13 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n12 >= n13) {
                                                        break;
                                                    }
                                                    final int n14 = n11 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final short n15 = n9;
                                                    final short n16 = a[n14 + rbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (n15 <= n16) {
                                                        n8 = n14;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n11 = n14 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n17 = rsize;
                                                final int n18 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n17 <= n18) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n10 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final short n19 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n20 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n21 = n20;
                                                    final int n22 = n10;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n21 >= n22) {
                                                        break;
                                                    }
                                                    final int n23 = n20 + n10 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final short n24 = n19;
                                                    final short n25 = a[n23 + lbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (n24 <= n25) {
                                                        n10 = n23;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n20 = n23 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final short[] array3 = a;
                                            final short[] array4 = w;
                                            final int n26 = lbase + n10;
                                            final int n27 = lsize - n10;
                                            final int n28 = rbase + n8;
                                            final int n29 = rsize - n8;
                                            final int n30 = wbase + n10 + n8;
                                            final int n31 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n26, n27, n28, n29, n30, n31);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n10;
                                            BytecodeManager.incBytecodes(2);
                                            final int n32 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n32);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n33 = lbase + lsize;
                                        final int n34 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n35 = lbase;
                                            final int n36 = n33;
                                            BytecodeManager.incBytecodes(3);
                                            if (n35 >= n36) {
                                                break;
                                            }
                                            final int n37 = rbase;
                                            final int n38 = n34;
                                            BytecodeManager.incBytecodes(3);
                                            if (n37 >= n38) {
                                                break;
                                            }
                                            final short n39 = a[lbase];
                                            final short n40 = a[rbase];
                                            BytecodeManager.incBytecodes(11);
                                            short n41;
                                            if (n39 <= n40) {
                                                ++lbase;
                                                n41 = n39;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                n41 = n40;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = n41;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n42 = rbase;
                                        final int n43 = n34;
                                        BytecodeManager.incBytecodes(3);
                                        if (n42 < n43) {
                                            final short[] array5 = a;
                                            final int n44 = rbase;
                                            final short[] array6 = w;
                                            final int n45 = wbase;
                                            final int n46 = n34 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n44, array6, n45, n46);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n47 = lbase;
                                            final int n48 = n33;
                                            BytecodeManager.incBytecodes(3);
                                            if (n47 < n48) {
                                                final short[] array7 = a;
                                                final int n49 = lbase;
                                                final short[] array8 = w;
                                                final int n50 = wbase;
                                                final int n51 = n33 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n49, array8, n50, n51);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJInt
    {
        FJInt() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final int[] a;
            final int[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final int[] a, final int[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final int[] a = this.a;
                    final int[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final int[] array = w;
                        final int[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final int[] array3 = a;
                        final int[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final int[] array5 = a;
                        final int[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final int[] array7 = a;
                        final int[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final int[] array9 = a;
                        final int[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final int[] array11 = a;
                        final int[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final int[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final int[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final int[] a;
            final int[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final int[] a, final int[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final int[] a = this.a;
                    final int[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final int[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final int[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n10;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final int n9 = a[(n10 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n11 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n12 = n11;
                                                    final int n13 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n12 >= n13) {
                                                        break;
                                                    }
                                                    final int n14 = n11 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final int n15 = n9;
                                                    final int n16 = a[n14 + rbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (n15 <= n16) {
                                                        n8 = n14;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n11 = n14 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n17 = rsize;
                                                final int n18 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n17 <= n18) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n10 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final int n19 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n20 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n21 = n20;
                                                    final int n22 = n10;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n21 >= n22) {
                                                        break;
                                                    }
                                                    final int n23 = n20 + n10 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final int n24 = n19;
                                                    final int n25 = a[n23 + lbase];
                                                    BytecodeManager.incBytecodes(7);
                                                    if (n24 <= n25) {
                                                        n10 = n23;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n20 = n23 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final int[] array3 = a;
                                            final int[] array4 = w;
                                            final int n26 = lbase + n10;
                                            final int n27 = lsize - n10;
                                            final int n28 = rbase + n8;
                                            final int n29 = rsize - n8;
                                            final int n30 = wbase + n10 + n8;
                                            final int n31 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n26, n27, n28, n29, n30, n31);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n10;
                                            BytecodeManager.incBytecodes(2);
                                            final int n32 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n32);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n33 = lbase + lsize;
                                        final int n34 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n35 = lbase;
                                            final int n36 = n33;
                                            BytecodeManager.incBytecodes(3);
                                            if (n35 >= n36) {
                                                break;
                                            }
                                            final int n37 = rbase;
                                            final int n38 = n34;
                                            BytecodeManager.incBytecodes(3);
                                            if (n37 >= n38) {
                                                break;
                                            }
                                            final int n39 = a[lbase];
                                            final int n40 = a[rbase];
                                            BytecodeManager.incBytecodes(11);
                                            int n41;
                                            if (n39 <= n40) {
                                                ++lbase;
                                                n41 = n39;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                n41 = n40;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = n41;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n42 = rbase;
                                        final int n43 = n34;
                                        BytecodeManager.incBytecodes(3);
                                        if (n42 < n43) {
                                            final int[] array5 = a;
                                            final int n44 = rbase;
                                            final int[] array6 = w;
                                            final int n45 = wbase;
                                            final int n46 = n34 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n44, array6, n45, n46);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n47 = lbase;
                                            final int n48 = n33;
                                            BytecodeManager.incBytecodes(3);
                                            if (n47 < n48) {
                                                final int[] array7 = a;
                                                final int n49 = lbase;
                                                final int[] array8 = w;
                                                final int n50 = wbase;
                                                final int n51 = n33 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n49, array8, n50, n51);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJLong
    {
        FJLong() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final long[] a;
            final long[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final long[] a, final long[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final long[] a = this.a;
                    final long[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final long[] array = w;
                        final long[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final long[] array3 = a;
                        final long[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final long[] array5 = a;
                        final long[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final long[] array7 = a;
                        final long[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final long[] array9 = a;
                        final long[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final long[] array11 = a;
                        final long[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final long[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final long[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final long[] a;
            final long[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final long[] a, final long[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final long[] a = this.a;
                    final long[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final long[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final long[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n10;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final long n9 = a[(n10 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n11 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n12 = n11;
                                                    final int n13 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n12 >= n13) {
                                                        break;
                                                    }
                                                    final int n14 = n11 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final long n15 = lcmp(n9, a[n14 + rbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n15 <= 0) {
                                                        n8 = n14;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n11 = n14 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n16 = rsize;
                                                final int n17 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n16 <= n17) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n10 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final long n18 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n19 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n20 = n19;
                                                    final int n21 = n10;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n20 >= n21) {
                                                        break;
                                                    }
                                                    final int n22 = n19 + n10 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final long n23 = lcmp(n18, a[n22 + lbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n23 <= 0) {
                                                        n10 = n22;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n19 = n22 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final long[] array3 = a;
                                            final long[] array4 = w;
                                            final int n24 = lbase + n10;
                                            final int n25 = lsize - n10;
                                            final int n26 = rbase + n8;
                                            final int n27 = rsize - n8;
                                            final int n28 = wbase + n10 + n8;
                                            final int n29 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n24, n25, n26, n27, n28, n29);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n10;
                                            BytecodeManager.incBytecodes(2);
                                            final int n30 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n30);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n31 = lbase + lsize;
                                        final int n32 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n33 = lbase;
                                            final int n34 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n33 >= n34) {
                                                break;
                                            }
                                            final int n35 = rbase;
                                            final int n36 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n35 >= n36) {
                                                break;
                                            }
                                            final long n37 = a[lbase];
                                            final long n39;
                                            final long n38 = lcmp(n37, n39 = a[rbase]);
                                            BytecodeManager.incBytecodes(12);
                                            long n40;
                                            if (n38 <= 0) {
                                                ++lbase;
                                                n40 = n37;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                n40 = n39;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = n40;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n41 = rbase;
                                        final int n42 = n32;
                                        BytecodeManager.incBytecodes(3);
                                        if (n41 < n42) {
                                            final long[] array5 = a;
                                            final int n43 = rbase;
                                            final long[] array6 = w;
                                            final int n44 = wbase;
                                            final int n45 = n32 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n43, array6, n44, n45);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n46 = lbase;
                                            final int n47 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n46 < n47) {
                                                final long[] array7 = a;
                                                final int n48 = lbase;
                                                final long[] array8 = w;
                                                final int n49 = wbase;
                                                final int n50 = n31 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n48, array8, n49, n50);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJFloat
    {
        FJFloat() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final float[] a;
            final float[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final float[] a, final float[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final float[] a = this.a;
                    final float[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final float[] array = w;
                        final float[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final float[] array3 = a;
                        final float[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final float[] array5 = a;
                        final float[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final float[] array7 = a;
                        final float[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final float[] array9 = a;
                        final float[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final float[] array11 = a;
                        final float[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final float[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final float[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final float[] a;
            final float[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final float[] a, final float[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final float[] a = this.a;
                    final float[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final float[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final float[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n10;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final float n9 = a[(n10 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n11 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n12 = n11;
                                                    final int n13 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n12 >= n13) {
                                                        break;
                                                    }
                                                    final int n14 = n11 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final float n15 = fcmpg(n9, a[n14 + rbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n15 <= 0) {
                                                        n8 = n14;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n11 = n14 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n16 = rsize;
                                                final int n17 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n16 <= n17) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n10 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final float n18 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n19 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n20 = n19;
                                                    final int n21 = n10;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n20 >= n21) {
                                                        break;
                                                    }
                                                    final int n22 = n19 + n10 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final float n23 = fcmpg(n18, a[n22 + lbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n23 <= 0) {
                                                        n10 = n22;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n19 = n22 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final float[] array3 = a;
                                            final float[] array4 = w;
                                            final int n24 = lbase + n10;
                                            final int n25 = lsize - n10;
                                            final int n26 = rbase + n8;
                                            final int n27 = rsize - n8;
                                            final int n28 = wbase + n10 + n8;
                                            final int n29 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n24, n25, n26, n27, n28, n29);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n10;
                                            BytecodeManager.incBytecodes(2);
                                            final int n30 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n30);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n31 = lbase + lsize;
                                        final int n32 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n33 = lbase;
                                            final int n34 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n33 >= n34) {
                                                break;
                                            }
                                            final int n35 = rbase;
                                            final int n36 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n35 >= n36) {
                                                break;
                                            }
                                            final float n37 = a[lbase];
                                            final float n39;
                                            final float n38 = fcmpg(n37, n39 = a[rbase]);
                                            BytecodeManager.incBytecodes(12);
                                            float n40;
                                            if (n38 <= 0) {
                                                ++lbase;
                                                n40 = n37;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                n40 = n39;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = n40;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n41 = rbase;
                                        final int n42 = n32;
                                        BytecodeManager.incBytecodes(3);
                                        if (n41 < n42) {
                                            final float[] array5 = a;
                                            final int n43 = rbase;
                                            final float[] array6 = w;
                                            final int n44 = wbase;
                                            final int n45 = n32 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n43, array6, n44, n45);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n46 = lbase;
                                            final int n47 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n46 < n47) {
                                                final float[] array7 = a;
                                                final int n48 = lbase;
                                                final float[] array8 = w;
                                                final int n49 = wbase;
                                                final int n50 = n31 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n48, array8, n49, n50);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class FJDouble
    {
        FJDouble() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static final class Sorter extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final double[] a;
            final double[] w;
            final int base;
            final int size;
            final int wbase;
            final int gran;
            
            Sorter(final CountedCompleter<?> countedCompleter, final double[] a, final double[] w, final int base, final int size, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    this.base = base;
                    this.size = size;
                    BytecodeManager.incBytecodes(12);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    CountedCompleter<Void> countedCompleter = this;
                    BytecodeManager.incBytecodes(2);
                    final double[] a = this.a;
                    final double[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    final int base = this.base;
                    int size = this.size;
                    final int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(12);
                    while (true) {
                        final int n = size;
                        final int n2 = gran;
                        BytecodeManager.incBytecodes(3);
                        if (n <= n2) {
                            break;
                        }
                        final int n3 = size >>> 1;
                        final int n4 = n3 >>> 1;
                        final int n5 = n3 + n4;
                        BytecodeManager.incBytecodes(12);
                        final CountedCompleter<Void> countedCompleter2 = countedCompleter;
                        final double[] array = w;
                        final double[] array2 = a;
                        final int n6 = wbase;
                        final int n7 = n3;
                        final int n8 = wbase + n3;
                        final int n9 = size - n3;
                        final int n10 = base;
                        final int n11 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger = new Merger(countedCompleter2, array, array2, n6, n7, n8, n9, n10, n11);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay = new Relay(merger);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay2 = relay;
                        final double[] array3 = a;
                        final double[] array4 = w;
                        final int n12 = base + n3;
                        final int n13 = n4;
                        final int n14 = base + n5;
                        final int n15 = size - n5;
                        final int n16 = wbase + n3;
                        final int n17 = gran;
                        BytecodeManager.incBytecodes(22);
                        final Merger merger2 = new Merger(relay2, array3, array4, n12, n13, n14, n15, n16, n17);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay3 = new Relay(merger2);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay4 = relay3;
                        final double[] array5 = a;
                        final double[] array6 = w;
                        final int n18 = base + n5;
                        final int n19 = size - n5;
                        final int n20 = wbase + n5;
                        final int n21 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter = new Sorter(relay4, array5, array6, n18, n19, n20, n21);
                        BytecodeManager.incBytecodes(1);
                        sorter.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay5 = relay3;
                        final double[] array7 = a;
                        final double[] array8 = w;
                        final int n22 = base + n3;
                        final int n23 = n4;
                        final int n24 = wbase + n3;
                        final int n25 = gran;
                        BytecodeManager.incBytecodes(14);
                        final Sorter sorter2 = new Sorter(relay5, array7, array8, n22, n23, n24, n25);
                        BytecodeManager.incBytecodes(1);
                        sorter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay6 = relay;
                        final double[] array9 = a;
                        final double[] array10 = w;
                        final int n26 = base;
                        final int n27 = n4;
                        final int n28 = base + n4;
                        final int n29 = n3 - n4;
                        final int n30 = wbase;
                        final int n31 = gran;
                        BytecodeManager.incBytecodes(18);
                        final Merger merger3 = new Merger(relay6, array9, array10, n26, n27, n28, n29, n30, n31);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay7 = new Relay(merger3);
                        BytecodeManager.incBytecodes(1);
                        final Relay relay8 = relay7;
                        final double[] array11 = a;
                        final double[] array12 = w;
                        final int n32 = base + n4;
                        final int n33 = n3 - n4;
                        final int n34 = wbase + n4;
                        final int n35 = gran;
                        BytecodeManager.incBytecodes(16);
                        final Sorter sorter3 = new Sorter(relay8, array11, array12, n32, n33, n34, n35);
                        BytecodeManager.incBytecodes(1);
                        sorter3.fork();
                        BytecodeManager.incBytecodes(1);
                        final Relay relay9 = relay7;
                        BytecodeManager.incBytecodes(4);
                        countedCompleter = new EmptyCompleter(relay9);
                        BytecodeManager.incBytecodes(1);
                        size = n4;
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    final double[] array13 = a;
                    final int n36 = base;
                    final int n37 = base + size - 1;
                    final double[] array14 = w;
                    final int n38 = wbase;
                    final int n39 = size;
                    BytecodeManager.incBytecodes(11);
                    DualPivotQuicksort.sort(array13, n36, n37, array14, n38, n39);
                    final CountedCompleter<Void> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(2);
                    countedCompleter3.tryComplete();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        static final class Merger extends CountedCompleter<Void>
        {
            static final long serialVersionUID = 2446542900576103244L;
            final double[] a;
            final double[] w;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int wbase;
            final int gran;
            
            Merger(final CountedCompleter<?> countedCompleter, final double[] a, final double[] w, final int lbase, final int lsize, final int rbase, final int rsize, final int wbase, final int gran) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(countedCompleter);
                    this.a = a;
                    this.w = w;
                    BytecodeManager.incBytecodes(6);
                    this.lbase = lbase;
                    this.lsize = lsize;
                    BytecodeManager.incBytecodes(6);
                    this.rbase = rbase;
                    this.rsize = rsize;
                    BytecodeManager.incBytecodes(6);
                    this.wbase = wbase;
                    this.gran = gran;
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
                    final double[] a = this.a;
                    final double[] w = this.w;
                    BytecodeManager.incBytecodes(6);
                    int lbase = this.lbase;
                    int lsize = this.lsize;
                    int rbase = this.rbase;
                    BytecodeManager.incBytecodes(9);
                    int rsize = this.rsize;
                    int wbase = this.wbase;
                    final int gran = this.gran;
                    BytecodeManager.incBytecodes(9);
                    final double[] array = a;
                    BytecodeManager.incBytecodes(2);
                    if (array != null) {
                        final double[] array2 = w;
                        BytecodeManager.incBytecodes(2);
                        if (array2 != null) {
                            final int n = lbase;
                            BytecodeManager.incBytecodes(2);
                            if (n >= 0) {
                                final int n2 = rbase;
                                BytecodeManager.incBytecodes(2);
                                if (n2 >= 0) {
                                    final int n3 = wbase;
                                    BytecodeManager.incBytecodes(2);
                                    if (n3 >= 0) {
                                        while (true) {
                                            final int n4 = lsize;
                                            final int n5 = rsize;
                                            BytecodeManager.incBytecodes(3);
                                            int n8;
                                            int n10;
                                            if (n4 >= n5) {
                                                final int n6 = lsize;
                                                final int n7 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n6 <= n7) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n8 = rsize;
                                                BytecodeManager.incBytecodes(2);
                                                final double n9 = a[(n10 = lsize >>> 1) + lbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n11 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n12 = n11;
                                                    final int n13 = n8;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n12 >= n13) {
                                                        break;
                                                    }
                                                    final int n14 = n11 + n8 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final double n15 = dcmpg(n9, a[n14 + rbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n15 <= 0) {
                                                        n8 = n14;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n11 = n14 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                                BytecodeManager.incBytecodes(1);
                                            }
                                            else {
                                                final int n16 = rsize;
                                                final int n17 = gran;
                                                BytecodeManager.incBytecodes(3);
                                                if (n16 <= n17) {
                                                    BytecodeManager.incBytecodes(1);
                                                    break;
                                                }
                                                n10 = lsize;
                                                BytecodeManager.incBytecodes(2);
                                                final double n18 = a[(n8 = rsize >>> 1) + rbase];
                                                BytecodeManager.incBytecodes(10);
                                                int n19 = 0;
                                                BytecodeManager.incBytecodes(2);
                                                while (true) {
                                                    final int n20 = n19;
                                                    final int n21 = n10;
                                                    BytecodeManager.incBytecodes(3);
                                                    if (n20 >= n21) {
                                                        break;
                                                    }
                                                    final int n22 = n19 + n10 >>> 1;
                                                    BytecodeManager.incBytecodes(6);
                                                    final double n23 = dcmpg(n18, a[n22 + lbase]);
                                                    BytecodeManager.incBytecodes(8);
                                                    if (n23 <= 0) {
                                                        n10 = n22;
                                                        BytecodeManager.incBytecodes(3);
                                                    }
                                                    else {
                                                        n19 = n22 + 1;
                                                        BytecodeManager.incBytecodes(4);
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                }
                                            }
                                            final double[] array3 = a;
                                            final double[] array4 = w;
                                            final int n24 = lbase + n10;
                                            final int n25 = lsize - n10;
                                            final int n26 = rbase + n8;
                                            final int n27 = rsize - n8;
                                            final int n28 = wbase + n10 + n8;
                                            final int n29 = gran;
                                            BytecodeManager.incBytecodes(24);
                                            final Merger merger = new Merger(this, array3, array4, n24, n25, n26, n27, n28, n29);
                                            BytecodeManager.incBytecodes(1);
                                            rsize = n8;
                                            BytecodeManager.incBytecodes(2);
                                            lsize = n10;
                                            BytecodeManager.incBytecodes(2);
                                            final int n30 = 1;
                                            BytecodeManager.incBytecodes(3);
                                            this.addToPendingCount(n30);
                                            final Merger merger2 = merger;
                                            BytecodeManager.incBytecodes(2);
                                            merger2.fork();
                                            BytecodeManager.incBytecodes(1);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n31 = lbase + lsize;
                                        final int n32 = rbase + rsize;
                                        BytecodeManager.incBytecodes(8);
                                        while (true) {
                                            final int n33 = lbase;
                                            final int n34 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n33 >= n34) {
                                                break;
                                            }
                                            final int n35 = rbase;
                                            final int n36 = n32;
                                            BytecodeManager.incBytecodes(3);
                                            if (n35 >= n36) {
                                                break;
                                            }
                                            final double n37 = a[lbase];
                                            final double n39;
                                            final double n38 = dcmpg(n37, n39 = a[rbase]);
                                            BytecodeManager.incBytecodes(12);
                                            double n40;
                                            if (n38 <= 0) {
                                                ++lbase;
                                                n40 = n37;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            else {
                                                ++rbase;
                                                n40 = n39;
                                                BytecodeManager.incBytecodes(3);
                                            }
                                            w[wbase++] = n40;
                                            BytecodeManager.incBytecodes(5);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        final int n41 = rbase;
                                        final int n42 = n32;
                                        BytecodeManager.incBytecodes(3);
                                        if (n41 < n42) {
                                            final double[] array5 = a;
                                            final int n43 = rbase;
                                            final double[] array6 = w;
                                            final int n44 = wbase;
                                            final int n45 = n32 - rbase;
                                            BytecodeManager.incBytecodes(8);
                                            System.arraycopy(array5, n43, array6, n44, n45);
                                            BytecodeManager.incBytecodes(1);
                                        }
                                        else {
                                            final int n46 = lbase;
                                            final int n47 = n31;
                                            BytecodeManager.incBytecodes(3);
                                            if (n46 < n47) {
                                                final double[] array7 = a;
                                                final int n48 = lbase;
                                                final double[] array8 = w;
                                                final int n49 = wbase;
                                                final int n50 = n31 - lbase;
                                                BytecodeManager.incBytecodes(8);
                                                System.arraycopy(array7, n48, array8, n49, n50);
                                            }
                                        }
                                        BytecodeManager.incBytecodes(2);
                                        this.tryComplete();
                                        BytecodeManager.incBytecodes(1);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
}
