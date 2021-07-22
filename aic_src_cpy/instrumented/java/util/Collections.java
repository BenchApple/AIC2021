// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.ObjectInputStream;
import instrumented.java.util.function.IntFunction;
import instrumented.java.util.stream.IntStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.stream.StreamSupport;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.stream.Stream;
import instrumented.java.util.function.Predicate;
import java.io.Serializable;
import instrumented.java.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public class Collections
{
    private static final int BINARYSEARCH_THRESHOLD = 5000;
    private static final int REVERSE_THRESHOLD = 18;
    private static final int SHUFFLE_THRESHOLD = 5;
    private static final int FILL_THRESHOLD = 25;
    private static final int ROTATE_THRESHOLD = 100;
    private static final int COPY_THRESHOLD = 10;
    private static final int REPLACEALL_THRESHOLD = 11;
    private static final int INDEXOFSUBLIST_THRESHOLD = 35;
    private static Random r;
    public static final Set EMPTY_SET;
    public static final List EMPTY_LIST;
    public static final Map EMPTY_MAP;
    
    private Collections() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(final List<T> list) {
        try {
            final Comparator<? super T> comparator = null;
            BytecodeManager.incBytecodes(3);
            list.sort(comparator);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void sort(final List<T> list, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(3);
            list.sort(comparator);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> int binarySearch(final List<? extends Comparable<? super T>> list, final T t) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(2);
                final int size = list.size();
                final int n = 5000;
                BytecodeManager.incBytecodes(2);
                if (size >= n) {
                    BytecodeManager.incBytecodes(3);
                    final int iteratorBinarySearch = iteratorBinarySearch((List<? extends Comparable<? super Object>>)list, (Object)t);
                    BytecodeManager.incBytecodes(1);
                    return iteratorBinarySearch;
                }
            }
            BytecodeManager.incBytecodes(3);
            final int indexedBinarySearch = indexedBinarySearch((List<? extends Comparable<? super Object>>)list, (Object)t);
            BytecodeManager.incBytecodes(1);
            return indexedBinarySearch;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> int indexedBinarySearch(final List<? extends Comparable<? super T>> list, final T t) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = list.size() - 1;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final int n5 = -(n + 1);
                    BytecodeManager.incBytecodes(5);
                    return n5;
                }
                final int n6 = n + n2 >>> 1;
                BytecodeManager.incBytecodes(6);
                final int n7 = n6;
                BytecodeManager.incBytecodes(3);
                final Comparable comparable = (Comparable)list.get(n7);
                BytecodeManager.incBytecodes(2);
                final Comparable<T> comparable2 = (Comparable<T>)comparable;
                BytecodeManager.incBytecodes(3);
                final int compareTo = comparable2.compareTo(t);
                BytecodeManager.incBytecodes(1);
                final int n8 = compareTo;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    n = n6 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n9 = compareTo;
                    BytecodeManager.incBytecodes(2);
                    if (n9 <= 0) {
                        final int n10 = n6;
                        BytecodeManager.incBytecodes(2);
                        return n10;
                    }
                    n2 = n6 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> int iteratorBinarySearch(final List<? extends Comparable<? super T>> list, final T t) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = list.size() - 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final ListIterator<? extends Comparable<? super T>> listIterator = list.listIterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final int n5 = -(n + 1);
                    BytecodeManager.incBytecodes(5);
                    return n5;
                }
                final int n6 = n + n2 >>> 1;
                BytecodeManager.incBytecodes(6);
                final ListIterator<? extends Comparable<T>> listIterator2 = (ListIterator<? extends Comparable<T>>)listIterator;
                final int n7 = n6;
                BytecodeManager.incBytecodes(3);
                final Comparable<T> comparable = get(listIterator2, n7);
                BytecodeManager.incBytecodes(2);
                final Comparable<T> comparable2 = comparable;
                BytecodeManager.incBytecodes(3);
                final int compareTo = comparable2.compareTo(t);
                BytecodeManager.incBytecodes(1);
                final int n8 = compareTo;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    n = n6 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n9 = compareTo;
                    BytecodeManager.incBytecodes(2);
                    if (n9 <= 0) {
                        final int n10 = n6;
                        BytecodeManager.incBytecodes(2);
                        return n10;
                    }
                    n2 = n6 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> T get(final ListIterator<? extends T> listIterator, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int nextIndex = listIterator.nextIndex();
            BytecodeManager.incBytecodes(1);
            final int n2 = nextIndex;
            BytecodeManager.incBytecodes(3);
            T t;
            if (n2 <= n) {
                int i;
                do {
                    BytecodeManager.incBytecodes(2);
                    t = (T)listIterator.next();
                    BytecodeManager.incBytecodes(1);
                    i = nextIndex++;
                    BytecodeManager.incBytecodes(4);
                } while (i < n);
                BytecodeManager.incBytecodes(1);
            }
            else {
                int j;
                do {
                    BytecodeManager.incBytecodes(2);
                    t = (T)listIterator.previous();
                    BytecodeManager.incBytecodes(1);
                    j = --nextIndex;
                    BytecodeManager.incBytecodes(4);
                } while (j > n);
            }
            final T t2 = t;
            BytecodeManager.incBytecodes(2);
            return t2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> int binarySearch(final List<? extends T> list, final T t, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(3);
                final int binarySearch = binarySearch((List<? extends Comparable<? super T>>)list, t);
                BytecodeManager.incBytecodes(1);
                return binarySearch;
            }
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(2);
                final int size = list.size();
                final int n = 5000;
                BytecodeManager.incBytecodes(2);
                if (size >= n) {
                    BytecodeManager.incBytecodes(4);
                    final int iteratorBinarySearch = iteratorBinarySearch(list, (Object)t, (Comparator<? super Object>)comparator);
                    BytecodeManager.incBytecodes(1);
                    return iteratorBinarySearch;
                }
            }
            BytecodeManager.incBytecodes(4);
            final int indexedBinarySearch = indexedBinarySearch(list, (Object)t, (Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            return indexedBinarySearch;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> int indexedBinarySearch(final List<? extends T> list, final T t, final Comparator<? super T> comparator) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = list.size() - 1;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final int n5 = -(n + 1);
                    BytecodeManager.incBytecodes(5);
                    return n5;
                }
                final int n6 = n + n2 >>> 1;
                BytecodeManager.incBytecodes(6);
                final int n7 = n6;
                BytecodeManager.incBytecodes(3);
                final T value = (T)list.get(n7);
                BytecodeManager.incBytecodes(1);
                final T t2 = value;
                BytecodeManager.incBytecodes(4);
                final int compare = comparator.compare(t2, t);
                BytecodeManager.incBytecodes(1);
                final int n8 = compare;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    n = n6 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n9 = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n9 <= 0) {
                        final int n10 = n6;
                        BytecodeManager.incBytecodes(2);
                        return n10;
                    }
                    n2 = n6 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> int iteratorBinarySearch(final List<? extends T> list, final T t, final Comparator<? super T> comparator) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            int n2 = list.size() - 1;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final ListIterator<? extends T> listIterator = list.listIterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n3 = n;
                final int n4 = n2;
                BytecodeManager.incBytecodes(3);
                if (n3 > n4) {
                    final int n5 = -(n + 1);
                    BytecodeManager.incBytecodes(5);
                    return n5;
                }
                final int n6 = n + n2 >>> 1;
                BytecodeManager.incBytecodes(6);
                final ListIterator<? extends T> listIterator2 = (ListIterator<? extends T>)listIterator;
                final int n7 = n6;
                BytecodeManager.incBytecodes(3);
                final Object value = get((ListIterator<?>)listIterator2, n7);
                BytecodeManager.incBytecodes(1);
                final Object o = value;
                BytecodeManager.incBytecodes(4);
                final int compare = comparator.compare((Object)o, (Object)t);
                BytecodeManager.incBytecodes(1);
                final int n8 = compare;
                BytecodeManager.incBytecodes(2);
                if (n8 < 0) {
                    n = n6 + 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    final int n9 = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n9 <= 0) {
                        final int n10 = n6;
                        BytecodeManager.incBytecodes(2);
                        return n10;
                    }
                    n2 = n6 - 1;
                    BytecodeManager.incBytecodes(5);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void reverse(final List<?> list) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            final int n2 = 18;
            BytecodeManager.incBytecodes(3);
            Label_0234: {
                if (n >= n2) {
                    final boolean b = list instanceof RandomAccess;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<?> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        final int n3 = size;
                        BytecodeManager.incBytecodes(3);
                        final ListIterator<?> listIterator2 = list.listIterator(n3);
                        BytecodeManager.incBytecodes(1);
                        int n4 = 0;
                        BytecodeManager.incBytecodes(4);
                        final int n5 = list.size() >> 1;
                        BytecodeManager.incBytecodes(3);
                        while (true) {
                            final int n6 = n4;
                            final int n7 = n5;
                            BytecodeManager.incBytecodes(3);
                            if (n6 >= n7) {
                                break Label_0234;
                            }
                            final ListIterator<?> listIterator3 = listIterator;
                            BytecodeManager.incBytecodes(2);
                            final Object next = listIterator3.next();
                            BytecodeManager.incBytecodes(1);
                            final ListIterator<?> listIterator4 = listIterator;
                            final ListIterator<?> listIterator5 = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final Object previous = listIterator5.previous();
                            BytecodeManager.incBytecodes(1);
                            listIterator4.set(previous);
                            final ListIterator<?> listIterator6 = listIterator2;
                            final Object o = next;
                            BytecodeManager.incBytecodes(3);
                            listIterator6.set(o);
                            ++n4;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                int n8 = 0;
                final int n9 = size >> 1;
                int n10 = size - 1;
                BytecodeManager.incBytecodes(10);
                while (true) {
                    final int n11 = n8;
                    final int n12 = n9;
                    BytecodeManager.incBytecodes(3);
                    if (n11 >= n12) {
                        break;
                    }
                    final int n13 = n8;
                    final int n14 = n10;
                    BytecodeManager.incBytecodes(4);
                    swap(list, n13, n14);
                    ++n8;
                    --n10;
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void shuffle(final List<?> list) {
        try {
            Random r = Collections.r;
            BytecodeManager.incBytecodes(2);
            final Random random = r;
            BytecodeManager.incBytecodes(2);
            if (random == null) {
                BytecodeManager.incBytecodes(3);
                r = (Collections.r = new Random());
                BytecodeManager.incBytecodes(3);
            }
            final Random random2 = r;
            BytecodeManager.incBytecodes(3);
            shuffle(list, random2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void shuffle(final List<?> list, final Random random) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            final int n2 = 5;
            BytecodeManager.incBytecodes(3);
            Label_0253: {
                if (n >= n2) {
                    final boolean b = list instanceof RandomAccess;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        BytecodeManager.incBytecodes(2);
                        final Object[] array = list.toArray();
                        BytecodeManager.incBytecodes(1);
                        int n3 = size;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n4 = n3;
                            final int n5 = 1;
                            BytecodeManager.incBytecodes(3);
                            if (n4 <= n5) {
                                break;
                            }
                            final Object[] array2 = array;
                            final int n6 = n3 - 1;
                            final int n7 = n3;
                            BytecodeManager.incBytecodes(7);
                            final int nextInt = random.nextInt(n7);
                            BytecodeManager.incBytecodes(1);
                            swap(array2, n6, nextInt);
                            --n3;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<?> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        int n8 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n9 = n8;
                            final int length = array.length;
                            BytecodeManager.incBytecodes(4);
                            if (n9 >= length) {
                                break Label_0253;
                            }
                            final ListIterator<?> listIterator2 = listIterator;
                            BytecodeManager.incBytecodes(2);
                            listIterator2.next();
                            BytecodeManager.incBytecodes(1);
                            final ListIterator<?> listIterator3 = listIterator;
                            final Object o = array[n8];
                            BytecodeManager.incBytecodes(5);
                            listIterator3.set(o);
                            ++n8;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                int n10 = size;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n11 = n10;
                    final int n12 = 1;
                    BytecodeManager.incBytecodes(3);
                    if (n11 <= n12) {
                        break;
                    }
                    final int n13 = n10 - 1;
                    final int n14 = n10;
                    BytecodeManager.incBytecodes(7);
                    final int nextInt2 = random.nextInt(n14);
                    BytecodeManager.incBytecodes(1);
                    swap(list, n13, nextInt2);
                    --n10;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void swap(final List<?> list, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(7);
            final Object value = list.get(n);
            BytecodeManager.incBytecodes(1);
            final Object set = list.set(n2, value);
            BytecodeManager.incBytecodes(1);
            list.set(n, set);
            BytecodeManager.incBytecodes(1);
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
    
    public static <T> void fill(final List<? super T> list, final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            final int n2 = 25;
            BytecodeManager.incBytecodes(3);
            Label_0171: {
                if (n >= n2) {
                    final boolean b = list instanceof RandomAccess;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<T> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        int n3 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n4 = n3;
                            final int n5 = size;
                            BytecodeManager.incBytecodes(3);
                            if (n4 >= n5) {
                                break Label_0171;
                            }
                            final ListIterator<T> listIterator2 = listIterator;
                            BytecodeManager.incBytecodes(2);
                            listIterator2.next();
                            BytecodeManager.incBytecodes(1);
                            final ListIterator<T> listIterator3 = listIterator;
                            BytecodeManager.incBytecodes(3);
                            listIterator3.set(t);
                            ++n3;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                int n6 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    final int n8 = size;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n8) {
                        break;
                    }
                    final int n9 = n6;
                    BytecodeManager.incBytecodes(4);
                    list.set(n9, t);
                    BytecodeManager.incBytecodes(1);
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> void copy(final List<? super T> list, final List<? extends T> list2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list2.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            BytecodeManager.incBytecodes(3);
            final int size2 = list.size();
            BytecodeManager.incBytecodes(1);
            if (n > size2) {
                final String s = "Source does not fit in dest";
                BytecodeManager.incBytecodes(4);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = size;
            final int n3 = 10;
            BytecodeManager.incBytecodes(3);
            Label_0264: {
                Label_0093: {
                    if (n2 >= n3) {
                        final boolean b = list2 instanceof RandomAccess;
                        BytecodeManager.incBytecodes(3);
                        if (b) {
                            final boolean b2 = list instanceof RandomAccess;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                break Label_0093;
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<T> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<? extends T> listIterator2 = list2.listIterator();
                        BytecodeManager.incBytecodes(1);
                        int n4 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n5 = n4;
                            final int n6 = size;
                            BytecodeManager.incBytecodes(3);
                            if (n5 >= n6) {
                                break Label_0264;
                            }
                            final ListIterator<T> listIterator3 = listIterator;
                            BytecodeManager.incBytecodes(2);
                            listIterator3.next();
                            BytecodeManager.incBytecodes(1);
                            final ListIterator<T> listIterator4 = listIterator;
                            final ListIterator<? extends T> listIterator5 = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final T next = (T)listIterator5.next();
                            BytecodeManager.incBytecodes(1);
                            listIterator4.set(next);
                            ++n4;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                int n7 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n8 = n7;
                    final int n9 = size;
                    BytecodeManager.incBytecodes(3);
                    if (n8 >= n9) {
                        break;
                    }
                    final int n10 = n7;
                    final int n11 = n7;
                    BytecodeManager.incBytecodes(5);
                    final T value = (T)list2.get(n11);
                    BytecodeManager.incBytecodes(1);
                    list.set(n10, value);
                    BytecodeManager.incBytecodes(1);
                    ++n7;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T extends java.lang.Object> T min(final Collection<? extends T> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends T> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<? extends T> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            java.lang.Object next = iterator2.next();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends T> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator3.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends T> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final T next2 = (T)iterator4.next();
                BytecodeManager.incBytecodes(1);
                final Comparable<Object> comparable = (Comparable<Object>)next2;
                final java.lang.Object o = next;
                BytecodeManager.incBytecodes(4);
                final int compareTo = comparable.compareTo(o);
                BytecodeManager.incBytecodes(1);
                if (compareTo < 0) {
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final java.lang.Object o2 = next;
            BytecodeManager.incBytecodes(2);
            return (T)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T min(final Collection<? extends T> collection, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(2);
                final T min = min(collection);
                BytecodeManager.incBytecodes(1);
                return min;
            }
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends T> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<? extends T> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            T next = (T)iterator2.next();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends T> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator3.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends T> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final T next2 = (T)iterator4.next();
                BytecodeManager.incBytecodes(1);
                final T t = next2;
                final T t2 = next;
                BytecodeManager.incBytecodes(4);
                final int compare = comparator.compare(t, t2);
                BytecodeManager.incBytecodes(1);
                if (compare < 0) {
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final T t3 = next;
            BytecodeManager.incBytecodes(2);
            return t3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T extends java.lang.Object> T max(final Collection<? extends T> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends T> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<? extends T> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            java.lang.Object next = iterator2.next();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends T> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator3.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends T> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final T next2 = (T)iterator4.next();
                BytecodeManager.incBytecodes(1);
                final Comparable<Object> comparable = (Comparable<Object>)next2;
                final java.lang.Object o = next;
                BytecodeManager.incBytecodes(4);
                final int compareTo = comparable.compareTo(o);
                BytecodeManager.incBytecodes(1);
                if (compareTo > 0) {
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final java.lang.Object o2 = next;
            BytecodeManager.incBytecodes(2);
            return (T)o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> T max(final Collection<? extends T> collection, final Comparator<? super T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(2);
                final T max = max(collection);
                BytecodeManager.incBytecodes(1);
                return max;
            }
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends T> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            final Iterator<? extends T> iterator2 = iterator;
            BytecodeManager.incBytecodes(2);
            T next = (T)iterator2.next();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends T> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator3.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends T> iterator4 = iterator;
                BytecodeManager.incBytecodes(2);
                final T next2 = (T)iterator4.next();
                BytecodeManager.incBytecodes(1);
                final T t = next2;
                final T t2 = next;
                BytecodeManager.incBytecodes(4);
                final int compare = comparator.compare(t, t2);
                BytecodeManager.incBytecodes(1);
                if (compare > 0) {
                    next = next2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final T t3 = next;
            BytecodeManager.incBytecodes(2);
            return t3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static void rotate(final List<?> list, final int n) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            Label_0061: {
                if (!b) {
                    BytecodeManager.incBytecodes(2);
                    final int size = list.size();
                    final int n2 = 100;
                    BytecodeManager.incBytecodes(2);
                    if (size >= n2) {
                        BytecodeManager.incBytecodes(3);
                        rotate2(list, n);
                        break Label_0061;
                    }
                }
                BytecodeManager.incBytecodes(3);
                rotate1(list, n);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> void rotate1(final List<T> list, int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n2 = size;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            n %= size;
            BytecodeManager.incBytecodes(4);
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            if (n3 < 0) {
                n += size;
                BytecodeManager.incBytecodes(4);
            }
            final boolean b = n != 0;
            BytecodeManager.incBytecodes(2);
            if (!b) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            int n4 = 0;
            int n5 = 0;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n6 = n5;
                final int n7 = size;
                BytecodeManager.incBytecodes(3);
                if (n6 == n7) {
                    break;
                }
                final int n8 = n4;
                BytecodeManager.incBytecodes(3);
                T t = list.get(n8);
                BytecodeManager.incBytecodes(1);
                int n9 = n4;
                BytecodeManager.incBytecodes(2);
                int i;
                int n10;
                do {
                    n9 += n;
                    BytecodeManager.incBytecodes(4);
                    final int n11 = n9;
                    final int n12 = size;
                    BytecodeManager.incBytecodes(3);
                    if (n11 >= n12) {
                        n9 -= size;
                        BytecodeManager.incBytecodes(4);
                    }
                    final int n13 = n9;
                    final T t2 = t;
                    BytecodeManager.incBytecodes(4);
                    t = list.set(n13, t2);
                    BytecodeManager.incBytecodes(1);
                    ++n5;
                    BytecodeManager.incBytecodes(1);
                    i = n9;
                    n10 = n4;
                    BytecodeManager.incBytecodes(3);
                } while (i != n10);
                ++n4;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void rotate2(final List<?> list, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n2 = size;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            int n3 = -n % size;
            BytecodeManager.incBytecodes(5);
            final int n4 = n3;
            BytecodeManager.incBytecodes(2);
            if (n4 < 0) {
                n3 += size;
                BytecodeManager.incBytecodes(4);
            }
            final int n5 = n3;
            BytecodeManager.incBytecodes(2);
            if (n5 == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n6 = 0;
            final int n7 = n3;
            BytecodeManager.incBytecodes(4);
            final List<?> subList = list.subList(n6, n7);
            BytecodeManager.incBytecodes(1);
            reverse(subList);
            final int n8 = n3;
            final int n9 = size;
            BytecodeManager.incBytecodes(4);
            final List<?> subList2 = list.subList(n8, n9);
            BytecodeManager.incBytecodes(1);
            reverse(subList2);
            BytecodeManager.incBytecodes(2);
            reverse(list);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> boolean replaceAll(final List<T> list, final T t, final T t2) {
        try {
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            final int n2 = 11;
            BytecodeManager.incBytecodes(3);
            Label_0427: {
                if (n >= n2) {
                    final boolean b2 = list instanceof RandomAccess;
                    BytecodeManager.incBytecodes(3);
                    if (!b2) {
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<T> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        if (t == null) {
                            int n3 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n4 = n3;
                                final int n5 = size;
                                BytecodeManager.incBytecodes(3);
                                if (n4 >= n5) {
                                    break;
                                }
                                final ListIterator<T> listIterator2 = listIterator;
                                BytecodeManager.incBytecodes(2);
                                final T next = listIterator2.next();
                                BytecodeManager.incBytecodes(1);
                                if (next == null) {
                                    final ListIterator<T> listIterator3 = listIterator;
                                    BytecodeManager.incBytecodes(3);
                                    listIterator3.set(t2);
                                    b = true;
                                    BytecodeManager.incBytecodes(2);
                                }
                                ++n3;
                                BytecodeManager.incBytecodes(2);
                            }
                            BytecodeManager.incBytecodes(1);
                            break Label_0427;
                        }
                        int n6 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n7 = n6;
                            final int n8 = size;
                            BytecodeManager.incBytecodes(3);
                            if (n7 >= n8) {
                                break Label_0427;
                            }
                            final ListIterator<T> listIterator4 = listIterator;
                            BytecodeManager.incBytecodes(3);
                            final T next2 = listIterator4.next();
                            BytecodeManager.incBytecodes(1);
                            final boolean equals = t.equals(next2);
                            BytecodeManager.incBytecodes(1);
                            if (equals) {
                                final ListIterator<T> listIterator5 = listIterator;
                                BytecodeManager.incBytecodes(3);
                                listIterator5.set(t2);
                                b = true;
                                BytecodeManager.incBytecodes(2);
                            }
                            ++n6;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                BytecodeManager.incBytecodes(2);
                if (t == null) {
                    int n9 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n10 = n9;
                        final int n11 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n10 >= n11) {
                            break;
                        }
                        final int n12 = n9;
                        BytecodeManager.incBytecodes(3);
                        final T value = list.get(n12);
                        BytecodeManager.incBytecodes(1);
                        if (value == null) {
                            final int n13 = n9;
                            BytecodeManager.incBytecodes(4);
                            list.set(n13, t2);
                            BytecodeManager.incBytecodes(1);
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        ++n9;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    int n14 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n15 = n14;
                        final int n16 = size;
                        BytecodeManager.incBytecodes(3);
                        if (n15 >= n16) {
                            break;
                        }
                        final int n17 = n14;
                        BytecodeManager.incBytecodes(4);
                        final T value2 = list.get(n17);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals2 = t.equals(value2);
                        BytecodeManager.incBytecodes(1);
                        if (equals2) {
                            final int n18 = n14;
                            BytecodeManager.incBytecodes(4);
                            list.set(n18, t2);
                            BytecodeManager.incBytecodes(1);
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                        ++n14;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final boolean b3 = b;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int indexOfSubList(final List<?> list, final List<?> list2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int size2 = list2.size();
            BytecodeManager.incBytecodes(1);
            final int n = size - size2;
            BytecodeManager.incBytecodes(4);
            final int n2 = size;
            final int n3 = 35;
            BytecodeManager.incBytecodes(3);
            Label_0415: {
                Label_0079: {
                    if (n2 >= n3) {
                        final boolean b = list instanceof RandomAccess;
                        BytecodeManager.incBytecodes(3);
                        if (b) {
                            final boolean b2 = list2 instanceof RandomAccess;
                            BytecodeManager.incBytecodes(3);
                            if (b2) {
                                break Label_0079;
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        final ListIterator<?> listIterator = list.listIterator();
                        BytecodeManager.incBytecodes(1);
                        int n4 = 0;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n5 = n4;
                            final int n6 = n;
                            BytecodeManager.incBytecodes(3);
                            if (n5 > n6) {
                                break Label_0415;
                            }
                            BytecodeManager.incBytecodes(2);
                            final ListIterator<?> listIterator2 = list2.listIterator();
                            BytecodeManager.incBytecodes(1);
                            int n7 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n8 = n7;
                                final int n9 = size2;
                                BytecodeManager.incBytecodes(3);
                                if (n8 >= n9) {
                                    final int n10 = n4;
                                    BytecodeManager.incBytecodes(2);
                                    return n10;
                                }
                                final ListIterator<?> listIterator3 = listIterator2;
                                BytecodeManager.incBytecodes(2);
                                final Object next = listIterator3.next();
                                final ListIterator<?> listIterator4 = listIterator;
                                BytecodeManager.incBytecodes(2);
                                final Object next2 = listIterator4.next();
                                BytecodeManager.incBytecodes(1);
                                final boolean eq = eq(next, next2);
                                BytecodeManager.incBytecodes(1);
                                if (!eq) {
                                    int n11 = 0;
                                    BytecodeManager.incBytecodes(2);
                                    while (true) {
                                        final int n12 = n11;
                                        final int n13 = n7;
                                        BytecodeManager.incBytecodes(3);
                                        if (n12 >= n13) {
                                            break;
                                        }
                                        final ListIterator<?> listIterator5 = listIterator;
                                        BytecodeManager.incBytecodes(2);
                                        listIterator5.previous();
                                        BytecodeManager.incBytecodes(1);
                                        ++n11;
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    ++n4;
                                    BytecodeManager.incBytecodes(2);
                                    break;
                                }
                                ++n7;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
                int n14 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n15 = n14;
                    final int n16 = n;
                    BytecodeManager.incBytecodes(3);
                    if (n15 > n16) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    int n17 = 0;
                    int n18 = n14;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n19 = n17;
                        final int n20 = size2;
                        BytecodeManager.incBytecodes(3);
                        if (n19 >= n20) {
                            final int n21 = n14;
                            BytecodeManager.incBytecodes(2);
                            return n21;
                        }
                        final int n22 = n17;
                        BytecodeManager.incBytecodes(3);
                        final Object value = list2.get(n22);
                        final int n23 = n18;
                        BytecodeManager.incBytecodes(3);
                        final Object value2 = list.get(n23);
                        BytecodeManager.incBytecodes(1);
                        final boolean eq2 = eq(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (!eq2) {
                            BytecodeManager.incBytecodes(1);
                            ++n14;
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        ++n17;
                        ++n18;
                        BytecodeManager.incBytecodes(3);
                    }
                }
            }
            final int n24 = -1;
            BytecodeManager.incBytecodes(2);
            return n24;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int lastIndexOfSubList(final List<?> list, final List<?> list2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = list.size();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final int size2 = list2.size();
            BytecodeManager.incBytecodes(1);
            final int n = size - size2;
            BytecodeManager.incBytecodes(4);
            final int n2 = size;
            final int n3 = 35;
            BytecodeManager.incBytecodes(3);
            Label_0432: {
                if (n2 >= n3) {
                    final boolean b = list instanceof RandomAccess;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final int n4 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n4 < 0) {
                            final int n5 = -1;
                            BytecodeManager.incBytecodes(2);
                            return n5;
                        }
                        final int n6 = n;
                        BytecodeManager.incBytecodes(3);
                        final ListIterator<?> listIterator = list.listIterator(n6);
                        BytecodeManager.incBytecodes(1);
                        int n7 = n;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n8 = n7;
                            BytecodeManager.incBytecodes(2);
                            if (n8 < 0) {
                                break Label_0432;
                            }
                            BytecodeManager.incBytecodes(2);
                            final ListIterator<?> listIterator2 = list2.listIterator();
                            BytecodeManager.incBytecodes(1);
                            int n9 = 0;
                            BytecodeManager.incBytecodes(2);
                            while (true) {
                                final int n10 = n9;
                                final int n11 = size2;
                                BytecodeManager.incBytecodes(3);
                                if (n10 >= n11) {
                                    final int n12 = n7;
                                    BytecodeManager.incBytecodes(2);
                                    return n12;
                                }
                                final ListIterator<?> listIterator3 = listIterator2;
                                BytecodeManager.incBytecodes(2);
                                final Object next = listIterator3.next();
                                final ListIterator<?> listIterator4 = listIterator;
                                BytecodeManager.incBytecodes(2);
                                final Object next2 = listIterator4.next();
                                BytecodeManager.incBytecodes(1);
                                final boolean eq = eq(next, next2);
                                BytecodeManager.incBytecodes(1);
                                if (!eq) {
                                    final int n13 = n7;
                                    BytecodeManager.incBytecodes(2);
                                    if (n13 != 0) {
                                        int n14 = 0;
                                        BytecodeManager.incBytecodes(2);
                                        while (true) {
                                            final int n15 = n14;
                                            final int n16 = n9 + 1;
                                            BytecodeManager.incBytecodes(5);
                                            if (n15 > n16) {
                                                break;
                                            }
                                            final ListIterator<?> listIterator5 = listIterator;
                                            BytecodeManager.incBytecodes(2);
                                            listIterator5.previous();
                                            BytecodeManager.incBytecodes(1);
                                            ++n14;
                                            BytecodeManager.incBytecodes(2);
                                        }
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    --n7;
                                    BytecodeManager.incBytecodes(2);
                                    break;
                                }
                                ++n9;
                                BytecodeManager.incBytecodes(2);
                            }
                        }
                    }
                }
                int n17 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n18 = n17;
                    BytecodeManager.incBytecodes(2);
                    if (n18 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    int n19 = 0;
                    int n20 = n17;
                    BytecodeManager.incBytecodes(4);
                    while (true) {
                        final int n21 = n19;
                        final int n22 = size2;
                        BytecodeManager.incBytecodes(3);
                        if (n21 >= n22) {
                            final int n23 = n17;
                            BytecodeManager.incBytecodes(2);
                            return n23;
                        }
                        final int n24 = n19;
                        BytecodeManager.incBytecodes(3);
                        final Object value = list2.get(n24);
                        final int n25 = n20;
                        BytecodeManager.incBytecodes(3);
                        final Object value2 = list.get(n25);
                        BytecodeManager.incBytecodes(1);
                        final boolean eq2 = eq(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (!eq2) {
                            BytecodeManager.incBytecodes(1);
                            --n17;
                            BytecodeManager.incBytecodes(2);
                            break;
                        }
                        ++n19;
                        ++n20;
                        BytecodeManager.incBytecodes(3);
                    }
                }
            }
            final int n26 = -1;
            BytecodeManager.incBytecodes(2);
            return n26;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collection<T> unmodifiableCollection(final Collection<? extends T> collection) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableCollection<T> collection2 = new UnmodifiableCollection<T>(collection);
            BytecodeManager.incBytecodes(1);
            return collection2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Set<T> unmodifiableSet(final Set<? extends T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableSet<T> set2 = new UnmodifiableSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> SortedSet<T> unmodifiableSortedSet(final SortedSet<T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableSortedSet<T> set2 = new UnmodifiableSortedSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> NavigableSet<T> unmodifiableNavigableSet(final NavigableSet<T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableNavigableSet<T> set2 = new UnmodifiableNavigableSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> List<T> unmodifiableList(final List<? extends T> list) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            UnmodifiableList<T> list2;
            if (b) {
                list2 = new UnmodifiableRandomAccessList<T>(list);
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                list2 = new UnmodifiableList<T>(list);
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return list2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> Map<K, V> unmodifiableMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableMap<K, V> unmodifiableMap = new UnmodifiableMap<K, V>(map);
            BytecodeManager.incBytecodes(1);
            return unmodifiableMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(final SortedMap<K, ? extends V> sortedMap) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableSortedMap<K, V> unmodifiableSortedMap = new UnmodifiableSortedMap<K, V>(sortedMap);
            BytecodeManager.incBytecodes(1);
            return unmodifiableSortedMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(final NavigableMap<K, ? extends V> navigableMap) {
        try {
            BytecodeManager.incBytecodes(4);
            final UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = new UnmodifiableNavigableMap<K, V>(navigableMap);
            BytecodeManager.incBytecodes(1);
            return unmodifiableNavigableMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Collection<T> synchronizedCollection(final Collection<T> collection) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedCollection<T> collection2 = new SynchronizedCollection<T>(collection);
            BytecodeManager.incBytecodes(1);
            return collection2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Collection<T> synchronizedCollection(final Collection<T> collection, final Object o) {
        try {
            BytecodeManager.incBytecodes(5);
            final SynchronizedCollection<T> collection2 = new SynchronizedCollection<T>(collection, o);
            BytecodeManager.incBytecodes(1);
            return collection2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Set<T> synchronizedSet(final Set<T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedSet<T> set2 = new SynchronizedSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Set<T> synchronizedSet(final Set<T> set, final Object o) {
        try {
            BytecodeManager.incBytecodes(5);
            final SynchronizedSet<T> set2 = new SynchronizedSet<T>(set, o);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> SortedSet<T> synchronizedSortedSet(final SortedSet<T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedSortedSet<T> set2 = new SynchronizedSortedSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> NavigableSet<T> synchronizedNavigableSet(final NavigableSet<T> set) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedNavigableSet<T> set2 = new SynchronizedNavigableSet<T>(set);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> List<T> synchronizedList(final List<T> list) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            SynchronizedList<T> list2;
            if (b) {
                list2 = new SynchronizedRandomAccessList<T>(list);
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
            }
            else {
                list2 = new SynchronizedList<T>(list);
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return list2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> List<T> synchronizedList(final List<T> list, final Object o) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            SynchronizedList<T> list2;
            if (b) {
                list2 = new SynchronizedRandomAccessList<T>(list, o);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            else {
                list2 = new SynchronizedList<T>(list, o);
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(1);
            return list2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> Map<K, V> synchronizedMap(final Map<K, V> map) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedMap<K, V> synchronizedMap = new SynchronizedMap<K, V>(map);
            BytecodeManager.incBytecodes(1);
            return synchronizedMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> SortedMap<K, V> synchronizedSortedMap(final SortedMap<K, V> sortedMap) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedSortedMap<K, V> synchronizedSortedMap = new SynchronizedSortedMap<K, V>(sortedMap);
            BytecodeManager.incBytecodes(1);
            return synchronizedSortedMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(final NavigableMap<K, V> navigableMap) {
        try {
            BytecodeManager.incBytecodes(4);
            final SynchronizedNavigableMap<K, V> synchronizedNavigableMap = new SynchronizedNavigableMap<K, V>(navigableMap);
            BytecodeManager.incBytecodes(1);
            return synchronizedNavigableMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> Collection<E> checkedCollection(final Collection<E> collection, final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(5);
            final CheckedCollection<E> collection2 = new CheckedCollection<E>(collection, clazz);
            BytecodeManager.incBytecodes(1);
            return collection2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> T[] zeroLengthArray(final Class<T> componentType) {
        try {
            final int length = 0;
            BytecodeManager.incBytecodes(3);
            final Object[] array = (Object[])Array.newInstance(componentType, length);
            BytecodeManager.incBytecodes(3);
            return (T[])array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> Queue<E> checkedQueue(final Queue<E> queue, final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(5);
            final CheckedQueue<E> checkedQueue = new CheckedQueue<E>(queue, clazz);
            BytecodeManager.incBytecodes(1);
            return checkedQueue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> Set<E> checkedSet(final Set<E> set, final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(5);
            final CheckedSet<E> set2 = new CheckedSet<E>(set, clazz);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> SortedSet<E> checkedSortedSet(final SortedSet<E> set, final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(5);
            final CheckedSortedSet<E> set2 = new CheckedSortedSet<E>(set, clazz);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> NavigableSet<E> checkedNavigableSet(final NavigableSet<E> set, final Class<E> clazz) {
        try {
            BytecodeManager.incBytecodes(5);
            final CheckedNavigableSet<E> set2 = new CheckedNavigableSet<E>(set, clazz);
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> List<E> checkedList(final List<E> list, final Class<E> clazz) {
        try {
            final boolean b = list instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            CheckedList<E> list2;
            if (b) {
                list2 = new CheckedRandomAccessList<E>(list, clazz);
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            else {
                list2 = new CheckedList<E>(list, clazz);
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(1);
            return list2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> Map<K, V> checkedMap(final Map<K, V> map, final Class<K> clazz, final Class<V> clazz2) {
        try {
            BytecodeManager.incBytecodes(6);
            final CheckedMap<K, V> checkedMap = new CheckedMap<K, V>(map, clazz, clazz2);
            BytecodeManager.incBytecodes(1);
            return checkedMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> SortedMap<K, V> checkedSortedMap(final SortedMap<K, V> sortedMap, final Class<K> clazz, final Class<V> clazz2) {
        try {
            BytecodeManager.incBytecodes(6);
            final CheckedSortedMap<K, V> checkedSortedMap = new CheckedSortedMap<K, V>(sortedMap, clazz, clazz2);
            BytecodeManager.incBytecodes(1);
            return checkedSortedMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> NavigableMap<K, V> checkedNavigableMap(final NavigableMap<K, V> navigableMap, final Class<K> clazz, final Class<V> clazz2) {
        try {
            BytecodeManager.incBytecodes(6);
            final CheckedNavigableMap<K, V> checkedNavigableMap = new CheckedNavigableMap<K, V>(navigableMap, clazz, clazz2);
            BytecodeManager.incBytecodes(1);
            return checkedNavigableMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Iterator<T> emptyIterator() {
        try {
            final EmptyIterator<Object> empty_ITERATOR = EmptyIterator.EMPTY_ITERATOR;
            BytecodeManager.incBytecodes(2);
            return (Iterator<T>)empty_ITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> ListIterator<T> emptyListIterator() {
        try {
            final EmptyListIterator<Object> empty_ITERATOR = EmptyListIterator.EMPTY_ITERATOR;
            BytecodeManager.incBytecodes(2);
            return (ListIterator<T>)empty_ITERATOR;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Enumeration<T> emptyEnumeration() {
        try {
            final EmptyEnumeration<Object> empty_ENUMERATION = EmptyEnumeration.EMPTY_ENUMERATION;
            BytecodeManager.incBytecodes(2);
            return (Enumeration<T>)empty_ENUMERATION;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final <T> Set<T> emptySet() {
        try {
            final Set empty_SET = Collections.EMPTY_SET;
            BytecodeManager.incBytecodes(2);
            return (Set<T>)empty_SET;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> SortedSet<E> emptySortedSet() {
        try {
            BytecodeManager.incBytecodes(1);
            final NavigableSet access$000 = UnmodifiableNavigableSet.access$000();
            BytecodeManager.incBytecodes(1);
            return (SortedSet<E>)access$000;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> NavigableSet<E> emptyNavigableSet() {
        try {
            BytecodeManager.incBytecodes(1);
            final NavigableSet access$000 = UnmodifiableNavigableSet.access$000();
            BytecodeManager.incBytecodes(1);
            return (NavigableSet<E>)access$000;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final <T> List<T> emptyList() {
        try {
            final List empty_LIST = Collections.EMPTY_LIST;
            BytecodeManager.incBytecodes(2);
            return (List<T>)empty_LIST;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final <K, V> Map<K, V> emptyMap() {
        try {
            final Map empty_MAP = Collections.EMPTY_MAP;
            BytecodeManager.incBytecodes(2);
            return (Map<K, V>)empty_MAP;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final <K, V> SortedMap<K, V> emptySortedMap() {
        try {
            BytecodeManager.incBytecodes(1);
            final UnmodifiableNavigableMap.EmptyNavigableMap access$100 = UnmodifiableNavigableMap.access$100();
            BytecodeManager.incBytecodes(1);
            return (SortedMap<K, V>)access$100;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final <K, V> NavigableMap<K, V> emptyNavigableMap() {
        try {
            BytecodeManager.incBytecodes(1);
            final UnmodifiableNavigableMap.EmptyNavigableMap access$100 = UnmodifiableNavigableMap.access$100();
            BytecodeManager.incBytecodes(1);
            return (NavigableMap<K, V>)access$100;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Set<T> singleton(final T t) {
        try {
            BytecodeManager.incBytecodes(4);
            final SingletonSet<T> set = new SingletonSet<T>(t);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <E> Iterator<E> singletonIterator(final E e) {
        try {
            BytecodeManager.incBytecodes(4);
            final Iterator<E> iterator = new Iterator<E>() {
                private boolean hasNext = true;
                
                {
                    BytecodeManager.incBytecodes(4);
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        final boolean hasNext = this.hasNext;
                        BytecodeManager.incBytecodes(3);
                        return hasNext;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public E next() {
                    try {
                        final boolean hasNext = this.hasNext;
                        BytecodeManager.incBytecodes(3);
                        if (hasNext) {
                            this.hasNext = false;
                            BytecodeManager.incBytecodes(3);
                            final Object val$e = e;
                            BytecodeManager.incBytecodes(3);
                            return (E)val$e;
                        }
                        BytecodeManager.incBytecodes(3);
                        final NoSuchElementException ex = new NoSuchElementException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void remove() {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final UnsupportedOperationException ex = new UnsupportedOperationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void forEachRemaining(final Consumer<? super E> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final boolean hasNext = this.hasNext;
                        BytecodeManager.incBytecodes(3);
                        if (hasNext) {
                            final Object val$e = e;
                            BytecodeManager.incBytecodes(4);
                            consumer.accept((Object)val$e);
                            this.hasNext = false;
                            BytecodeManager.incBytecodes(3);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <T> Spliterator<T> singletonSpliterator(final T t) {
        try {
            BytecodeManager.incBytecodes(4);
            final Spliterator<T> spliterator = new Spliterator<T>() {
                long est = 1L;
                
                {
                    BytecodeManager.incBytecodes(4);
                }
                
                @Override
                public Spliterator<T> trySplit() {
                    try {
                        final Spliterator<T> spliterator = null;
                        BytecodeManager.incBytecodes(2);
                        return spliterator;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean tryAdvance(final Consumer<? super T> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final long n = lcmp(this.est, 0L);
                        BytecodeManager.incBytecodes(5);
                        if (n > 0) {
                            --this.est;
                            BytecodeManager.incBytecodes(6);
                            final Object val$element = t;
                            BytecodeManager.incBytecodes(4);
                            consumer.accept((Object)val$element);
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void forEachRemaining(final Consumer<? super T> consumer) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        this.tryAdvance(consumer);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public long estimateSize() {
                    try {
                        final long est = this.est;
                        BytecodeManager.incBytecodes(3);
                        return est;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int characteristics() {
                    try {
                        final Object val$element = t;
                        BytecodeManager.incBytecodes(3);
                        int n;
                        if (val$element != null) {
                            n = 256;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n = 0;
                            BytecodeManager.incBytecodes(1);
                        }
                        final int n2 = n;
                        BytecodeManager.incBytecodes(1);
                        final int n3 = n2 | 0x40 | 0x4000 | 0x400 | 0x1 | 0x10;
                        BytecodeManager.incBytecodes(12);
                        return n3;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> List<T> singletonList(final T t) {
        try {
            BytecodeManager.incBytecodes(4);
            final SingletonList<T> list = new SingletonList<T>(t);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <K, V> Map<K, V> singletonMap(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(5);
            final SingletonMap<K, V> singletonMap = new SingletonMap<K, V>(k, v);
            BytecodeManager.incBytecodes(1);
            return singletonMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> List<T> nCopies(final int i, final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "List length = ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(5);
            final CopiesList<T> list = new CopiesList<T>(i, t);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Comparator<T> reverseOrder() {
        try {
            final ReverseComparator reverse_ORDER = ReverseComparator.REVERSE_ORDER;
            BytecodeManager.incBytecodes(2);
            return (Comparator<T>)reverse_ORDER;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Comparator<T> reverseOrder(final Comparator<T> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            if (comparator == null) {
                BytecodeManager.incBytecodes(1);
                final Comparator<T> reverseOrder = reverseOrder();
                BytecodeManager.incBytecodes(1);
                return reverseOrder;
            }
            final boolean b = comparator instanceof ReverseComparator2;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final Comparator<T> cmp = (Comparator<T>)((ReverseComparator2<T>)comparator).cmp;
                BytecodeManager.incBytecodes(4);
                return (Comparator<T>)cmp;
            }
            BytecodeManager.incBytecodes(4);
            final ReverseComparator2<T> reverseComparator2 = new ReverseComparator2<T>(comparator);
            BytecodeManager.incBytecodes(1);
            return reverseComparator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Enumeration<T> enumeration(final Collection<T> collection) {
        try {
            BytecodeManager.incBytecodes(4);
            final Enumeration<T> enumeration = new Enumeration<T>() {
                private final Iterator<T> i;
                
                {
                    final Collection val$c2 = collection;
                    BytecodeManager.incBytecodes(4);
                    this.i = val$c2.iterator();
                    BytecodeManager.incBytecodes(2);
                }
                
                @Override
                public boolean hasMoreElements() {
                    try {
                        final Iterator<T> i = this.i;
                        BytecodeManager.incBytecodes(3);
                        final boolean hasNext = i.hasNext();
                        BytecodeManager.incBytecodes(1);
                        return hasNext;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public T nextElement() {
                    try {
                        final Iterator<T> i = this.i;
                        BytecodeManager.incBytecodes(3);
                        final T next = i.next();
                        BytecodeManager.incBytecodes(1);
                        return next;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            return enumeration;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> ArrayList<T> list(final Enumeration<T> enumeration) {
        try {
            BytecodeManager.incBytecodes(3);
            final ArrayList<T> list = new ArrayList<T>();
            BytecodeManager.incBytecodes(1);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final boolean hasMoreElements = enumeration.hasMoreElements();
                BytecodeManager.incBytecodes(1);
                if (!hasMoreElements) {
                    break;
                }
                final ArrayList<T> list2 = list;
                BytecodeManager.incBytecodes(3);
                final T nextElement = enumeration.nextElement();
                BytecodeManager.incBytecodes(1);
                list2.add(nextElement);
                BytecodeManager.incBytecodes(2);
            }
            final ArrayList<T> list3 = list;
            BytecodeManager.incBytecodes(2);
            return list3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static boolean eq(final Object o, final Object obj) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean equals;
            if (o == null) {
                BytecodeManager.incBytecodes(2);
                if (obj == null) {
                    equals = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    equals = false;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                equals = o.equals(obj);
            }
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static int frequency(final Collection<?> collection, final Object o) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(2);
                final Iterator<?> iterator = collection.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<?> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<?> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Object next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final Object o2 = next;
                    BytecodeManager.incBytecodes(2);
                    if (o2 == null) {
                        ++n;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final Iterator<?> iterator4 = collection.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<?> iterator5 = iterator4;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator5.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<?> iterator6 = iterator4;
                    BytecodeManager.incBytecodes(2);
                    final Object next2 = iterator6.next();
                    BytecodeManager.incBytecodes(1);
                    final Object obj = next2;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        ++n;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static boolean disjoint(final Collection<?> collection, final Collection<?> collection2) {
        try {
            Collection<?> collection3 = collection2;
            BytecodeManager.incBytecodes(2);
            Collection<?> collection4 = collection;
            BytecodeManager.incBytecodes(2);
            final boolean b = collection instanceof Set;
            BytecodeManager.incBytecodes(3);
            Label_0144: {
                if (b) {
                    collection4 = collection2;
                    BytecodeManager.incBytecodes(2);
                    collection3 = collection;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final boolean b2 = collection2 instanceof Set;
                    BytecodeManager.incBytecodes(3);
                    if (!b2) {
                        BytecodeManager.incBytecodes(2);
                        final int size = collection.size();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        final int size2 = collection2.size();
                        BytecodeManager.incBytecodes(1);
                        final int n = size;
                        BytecodeManager.incBytecodes(2);
                        if (n != 0) {
                            final int n2 = size2;
                            BytecodeManager.incBytecodes(2);
                            if (n2 != 0) {
                                final int n3 = size;
                                final int n4 = size2;
                                BytecodeManager.incBytecodes(3);
                                if (n3 > n4) {
                                    collection4 = collection2;
                                    BytecodeManager.incBytecodes(2);
                                    collection3 = collection;
                                    BytecodeManager.incBytecodes(2);
                                }
                                break Label_0144;
                            }
                        }
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                }
            }
            final Collection<?> collection5 = collection4;
            BytecodeManager.incBytecodes(2);
            final Iterator<?> iterator = collection5.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<?> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    final boolean b4 = true;
                    BytecodeManager.incBytecodes(2);
                    return b4;
                }
                final Iterator<?> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final Collection<?> collection6 = collection3;
                final Object o = next;
                BytecodeManager.incBytecodes(3);
                final boolean contains = collection6.contains(o);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final boolean b5 = false;
                    BytecodeManager.incBytecodes(2);
                    return b5;
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @SafeVarargs
    public static <T> boolean addAll(final Collection<? super T> collection, final T... array) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int length = array.length;
            int n2 = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final T t = array[n2];
                BytecodeManager.incBytecodes(4);
                final int n5 = n;
                final T t2 = t;
                BytecodeManager.incBytecodes(4);
                n = (n5 | (collection.add(t2) ? 1 : 0));
                BytecodeManager.incBytecodes(2);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6 != 0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <E> Set<E> newSetFromMap(final Map<E, Boolean> map) {
        try {
            BytecodeManager.incBytecodes(4);
            final SetFromMap<E> setFromMap = new SetFromMap<E>(map);
            BytecodeManager.incBytecodes(1);
            return setFromMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <T> Queue<T> asLifoQueue(final Deque<T> deque) {
        try {
            BytecodeManager.incBytecodes(4);
            final AsLIFOQueue<T> asLIFOQueue = new AsLIFOQueue<T>(deque);
            BytecodeManager.incBytecodes(1);
            return asLIFOQueue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Iterator<E> iterator = null;
            BytecodeManager.incBytecodes(4);
            EMPTY_SET = new EmptySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator2 = null;
            BytecodeManager.incBytecodes(4);
            EMPTY_LIST = new EmptyList();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator3 = null;
            BytecodeManager.incBytecodes(4);
            EMPTY_MAP = new EmptyMap();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class UnmodifiableCollection<E> implements Collection<E>, Serializable
    {
        private static final long serialVersionUID = 1820017752578914078L;
        final Collection<? extends E> c;
        
        UnmodifiableCollection(final Collection<? extends E> c) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                if (c == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.c = c;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final int size = c.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final boolean empty = c.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean contains = c.contains(o);
                BytecodeManager.incBytecodes(1);
                return contains;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Object[] array = c.toArray();
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final T[] array2 = c.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final String string = c.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                BytecodeManager.incBytecodes(4);
                final Iterator<E> iterator = new Iterator<E>() {
                    private final Iterator<? extends E> i;
                    
                    {
                        final Collection<? extends E> c = UnmodifiableCollection.this.c;
                        BytecodeManager.incBytecodes(5);
                        this.i = c.iterator();
                        BytecodeManager.incBytecodes(2);
                    }
                    
                    @Override
                    public boolean hasNext() {
                        try {
                            final Iterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasNext = i.hasNext();
                            BytecodeManager.incBytecodes(1);
                            return hasNext;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E next() {
                        try {
                            final Iterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final E next = (E)i.next();
                            BytecodeManager.incBytecodes(1);
                            return next;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void remove() {
                        try {
                            BytecodeManager.incBytecodes(3);
                            final UnsupportedOperationException ex = new UnsupportedOperationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void forEachRemaining(final Consumer<? super E> consumer) {
                        try {
                            final Iterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(4);
                            i.forEachRemaining(consumer);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean containsAll = c.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(4);
                c.forEach((Consumer)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Spliterator<? extends E> spliterator = c.spliterator();
                BytecodeManager.incBytecodes(1);
                return (Spliterator<E>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<? extends E> stream = c.stream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)stream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<? extends E> parallelStream = c.parallelStream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)parallelStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E>, Serializable
    {
        private static final long serialVersionUID = -9215047833775013803L;
        
        UnmodifiableSet(final Set<? extends E> set) {
            try {
                BytecodeManager.incBytecodes(3);
                super(set);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Collection<? extends E> c = this.c;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = c.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Collection<? extends E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final int hashCode = c.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E>, Serializable
    {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;
        
        UnmodifiableSortedSet(final SortedSet<E> ss) {
            try {
                BytecodeManager.incBytecodes(3);
                super(ss);
                this.ss = ss;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super E> comparator() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super E> comparator = ss.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(7);
                final SortedSet<E> subSet = ss.subSet(e, e2);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedSet set = new UnmodifiableSortedSet((SortedSet<Object>)subSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> headSet(final E e) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(6);
                final SortedSet<E> headSet = ss.headSet(e);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedSet set = new UnmodifiableSortedSet((SortedSet<Object>)headSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> tailSet(final E e) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(6);
                final SortedSet<E> tailSet = ss.tailSet(e);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedSet set = new UnmodifiableSortedSet((SortedSet<Object>)tailSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E first() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final E first = ss.first();
                BytecodeManager.incBytecodes(1);
                return first;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E last() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final E last = ss.last();
                BytecodeManager.incBytecodes(1);
                return last;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class UnmodifiableNavigableSet<E> extends UnmodifiableSortedSet<E> implements NavigableSet<E>, Serializable
    {
        private static final long serialVersionUID = -6027448201786391929L;
        private static final NavigableSet<?> EMPTY_NAVIGABLE_SET;
        private final NavigableSet<E> ns;
        
        UnmodifiableNavigableSet(final NavigableSet<E> ns) {
            try {
                BytecodeManager.incBytecodes(3);
                super(ns);
                this.ns = ns;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E lower(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E lower = ns.lower(e);
                BytecodeManager.incBytecodes(1);
                return lower;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E floor(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E floor = ns.floor(e);
                BytecodeManager.incBytecodes(1);
                return floor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E ceiling(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E ceiling = ns.ceiling(e);
                BytecodeManager.incBytecodes(1);
                return ceiling;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E higher(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E higher = ns.higher(e);
                BytecodeManager.incBytecodes(1);
                return higher;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollFirst() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollLast() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(5);
                final NavigableSet<E> descendingSet = ns.descendingSet();
                BytecodeManager.incBytecodes(1);
                final UnmodifiableNavigableSet set = new UnmodifiableNavigableSet((NavigableSet<Object>)descendingSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableSet<E> descendingSet = this.descendingSet();
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator = descendingSet.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(8);
                BytecodeManager.incBytecodes(1);
                final NavigableSet<E> subSet = ns.subSet(e, b, e2, b2);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableNavigableSet set = new UnmodifiableNavigableSet((NavigableSet<Object>)subSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                final NavigableSet<E> headSet = ns.headSet(e, b);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableNavigableSet set = new UnmodifiableNavigableSet((NavigableSet<Object>)headSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                final NavigableSet<E> tailSet = ns.tailSet(e, b);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableNavigableSet set = new UnmodifiableNavigableSet((NavigableSet<Object>)tailSet);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ NavigableSet access$000() {
            try {
                final NavigableSet<?> empty_NAVIGABLE_SET = UnmodifiableNavigableSet.EMPTY_NAVIGABLE_SET;
                BytecodeManager.incBytecodes(2);
                return empty_NAVIGABLE_SET;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                EMPTY_NAVIGABLE_SET = new EmptyNavigableSet<Object>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static class EmptyNavigableSet<E> extends UnmodifiableNavigableSet<E> implements Serializable
        {
            private static final long serialVersionUID = -6291252904449939134L;
            
            public EmptyNavigableSet() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final TreeSet<Object> set = new TreeSet<Object>();
                    BytecodeManager.incBytecodes(1);
                    super(set);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private Object readResolve() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final NavigableSet access$000 = UnmodifiableNavigableSet.access$000();
                    BytecodeManager.incBytecodes(1);
                    return access$000;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E>
    {
        private static final long serialVersionUID = -283967356065247728L;
        final List<? extends E> list;
        
        UnmodifiableList(final List<? extends E> list) {
            try {
                BytecodeManager.incBytecodes(3);
                super(list);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final List<? extends E> list = this.list;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = list.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(3);
                final int hashCode = list.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int n) {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final E value = (E)list.get(n);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E set(final int n, final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void add(final int n, final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E remove(final int n) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int indexOf(final Object o) {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final int index = list.indexOf(o);
                BytecodeManager.incBytecodes(1);
                return index;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final int lastIndex = list.lastIndexOf(o);
                BytecodeManager.incBytecodes(1);
                return lastIndex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean addAll(final int n, final Collection<? extends E> collection) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final UnaryOperator<E> unaryOperator) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void sort(final Comparator<? super E> comparator) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(n);
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator(final int n) {
            try {
                BytecodeManager.incBytecodes(5);
                final ListIterator<E> listIterator = new ListIterator<E>() {
                    private final ListIterator<? extends E> i;
                    
                    {
                        final List<? extends E> list = UnmodifiableList.this.list;
                        final int val$index2 = n;
                        BytecodeManager.incBytecodes(6);
                        BytecodeManager.incBytecodes(1);
                        this.i = list.listIterator(val$index2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public boolean hasNext() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasNext = i.hasNext();
                            BytecodeManager.incBytecodes(1);
                            return hasNext;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E next() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final E next = (E)i.next();
                            BytecodeManager.incBytecodes(1);
                            return next;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public boolean hasPrevious() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasPrevious = i.hasPrevious();
                            BytecodeManager.incBytecodes(1);
                            return hasPrevious;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E previous() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final E previous = (E)i.previous();
                            BytecodeManager.incBytecodes(1);
                            return previous;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int nextIndex() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final int nextIndex = i.nextIndex();
                            BytecodeManager.incBytecodes(1);
                            return nextIndex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int previousIndex() {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final int previousIndex = i.previousIndex();
                            BytecodeManager.incBytecodes(1);
                            return previousIndex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void remove() {
                        try {
                            BytecodeManager.incBytecodes(3);
                            final UnsupportedOperationException ex = new UnsupportedOperationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void set(final E e) {
                        try {
                            BytecodeManager.incBytecodes(3);
                            final UnsupportedOperationException ex = new UnsupportedOperationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void add(final E e) {
                        try {
                            BytecodeManager.incBytecodes(3);
                            final UnsupportedOperationException ex = new UnsupportedOperationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void forEachRemaining(final Consumer<? super E> consumer) {
                        try {
                            final ListIterator<? extends E> i = this.i;
                            BytecodeManager.incBytecodes(4);
                            i.forEachRemaining(consumer);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(7);
                final List<? extends E> subList = list.subList(n, n2);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableList list2 = new UnmodifiableList(subList);
                BytecodeManager.incBytecodes(1);
                return list2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final boolean b = this.list instanceof RandomAccess;
                BytecodeManager.incBytecodes(4);
                UnmodifiableList list;
                if (b) {
                    final List<? extends E> list2;
                    list = new UnmodifiableRandomAccessList(list2);
                    list2 = this.list;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    list = this;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return list;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess
    {
        private static final long serialVersionUID = -2542308836966382001L;
        
        UnmodifiableRandomAccessList(final List<? extends E> list) {
            try {
                BytecodeManager.incBytecodes(3);
                super(list);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                final List<? extends E> subList = list.subList(n, n2);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableRandomAccessList list2 = new UnmodifiableRandomAccessList(subList);
                BytecodeManager.incBytecodes(1);
                return list2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object writeReplace() {
            try {
                final List<? extends E> list = this.list;
                BytecodeManager.incBytecodes(5);
                final UnmodifiableList list2 = new UnmodifiableList(list);
                BytecodeManager.incBytecodes(1);
                return list2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable
    {
        private static final long serialVersionUID = -1034234728574286014L;
        private final Map<? extends K, ? extends V> m;
        private transient Set<K> keySet;
        private transient Set<Entry<K, V>> entrySet;
        private transient Collection<V> values;
        
        UnmodifiableMap(final Map<? extends K, ? extends V> m) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                if (m == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.m = m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = m.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsValue(final Object o) {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = m.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V get(final Object o) {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final V value = (V)m.get(o);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V put(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> map) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<K> keySet() {
            try {
                final Set<K> keySet = this.keySet;
                BytecodeManager.incBytecodes(3);
                if (keySet == null) {
                    final Map<? extends K, ? extends V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    final Set<? extends K> keySet2 = m.keySet();
                    BytecodeManager.incBytecodes(1);
                    this.keySet = (Set<K>)Collections.unmodifiableSet((Set<?>)keySet2);
                    BytecodeManager.incBytecodes(1);
                }
                final Set<K> keySet3 = this.keySet;
                BytecodeManager.incBytecodes(3);
                return keySet3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Entry<K, V>> entrySet() {
            try {
                final Set<Entry<K, V>> entrySet = this.entrySet;
                BytecodeManager.incBytecodes(3);
                if (entrySet == null) {
                    final Map<? extends K, ? extends V> m = this.m;
                    BytecodeManager.incBytecodes(6);
                    final Set<Entry<? extends K, ? extends V>> entrySet2 = m.entrySet();
                    BytecodeManager.incBytecodes(1);
                    this.entrySet = (Set<Entry<K, V>>)new UnmodifiableEntrySet(entrySet2);
                    BytecodeManager.incBytecodes(1);
                }
                final Set<Entry<K, V>> entrySet3 = this.entrySet;
                BytecodeManager.incBytecodes(3);
                return entrySet3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Collection<V> values() {
            try {
                final Collection<V> values = this.values;
                BytecodeManager.incBytecodes(3);
                if (values == null) {
                    final Map<? extends K, ? extends V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    final Collection<? extends V> values2 = m.values();
                    BytecodeManager.incBytecodes(1);
                    this.values = (Collection<V>)Collections.unmodifiableCollection((Collection<?>)values2);
                    BytecodeManager.incBytecodes(1);
                }
                final Collection<V> values3 = this.values;
                BytecodeManager.incBytecodes(3);
                return values3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Map<? extends K, ? extends V> m = this.m;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = m.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int hashCode = m.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final String string = m.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V getOrDefault(final Object o, final V v) {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V orDefault = m.getOrDefault(o, v);
                BytecodeManager.incBytecodes(1);
                return orDefault;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            try {
                final Map<? extends K, ? extends V> m = this.m;
                BytecodeManager.incBytecodes(4);
                m.forEach(biConsumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Entry<K, V>>
        {
            private static final long serialVersionUID = 7854390611657943733L;
            
            UnmodifiableEntrySet(final Set<? extends Entry<? extends K, ? extends V>> set) {
                try {
                    BytecodeManager.incBytecodes(3);
                    super(set);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static <K, V> Consumer<Entry<K, V>> entryConsumer(final Consumer<? super Entry<K, V>> consumer) {
                try {
                    final Object o;
                    final Consumer<Entry<K, V>> consumer2 = entry -> {
                        try {
                            // new(instrumented.java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry.class)
                            BytecodeManager.incBytecodes(5);
                            new UnmodifiableEntry(entry);
                            BytecodeManager.incBytecodes(1);
                            consumer.accept((Object)o);
                            BytecodeManager.incBytecodes(1);
                            return;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    };
                    BytecodeManager.incBytecodes(2);
                    return consumer2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEach(final Consumer<? super Entry<K, V>> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(consumer);
                    BytecodeManager.incBytecodes(1);
                    final Collection<? extends E> c = this.c;
                    BytecodeManager.incBytecodes(4);
                    final Consumer<Entry<Object, Object>> entryConsumer = entryConsumer((Consumer<? super Entry<Object, Object>>)consumer);
                    BytecodeManager.incBytecodes(1);
                    c.forEach((Consumer)entryConsumer);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<Entry<K, V>> spliterator() {
                try {
                    final Collection<? extends E> c = this.c;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                    final Spliterator<? extends E> spliterator = c.spliterator();
                    BytecodeManager.incBytecodes(1);
                    final UnmodifiableEntrySetSpliterator unmodifiableEntrySetSpliterator = new UnmodifiableEntrySetSpliterator<K, V>(spliterator);
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<Entry<K, V>>)unmodifiableEntrySetSpliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Stream<Entry<K, V>> stream() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Entry<K, V>> spliterator = this.spliterator();
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    final Stream<Entry<K, V>> stream = StreamSupport.stream(spliterator, b);
                    BytecodeManager.incBytecodes(1);
                    return stream;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Stream<Entry<K, V>> parallelStream() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<Entry<K, V>> spliterator = this.spliterator();
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    final Stream<Entry<K, V>> stream = StreamSupport.stream(spliterator, b);
                    BytecodeManager.incBytecodes(1);
                    return stream;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Iterator<Entry<K, V>> iterator() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final Iterator<Entry<K, V>> iterator = new Iterator<Entry<K, V>>() {
                        private final Iterator<? extends Entry<? extends K, ? extends V>> i;
                        
                        {
                            final Collection<? extends E> c = UnmodifiableEntrySet.this.c;
                            BytecodeManager.incBytecodes(5);
                            this.i = (Iterator<? extends Entry<? extends K, ? extends V>>)c.iterator();
                            BytecodeManager.incBytecodes(2);
                        }
                        
                        @Override
                        public boolean hasNext() {
                            try {
                                final Iterator<? extends Entry<? extends K, ? extends V>> i = this.i;
                                BytecodeManager.incBytecodes(3);
                                final boolean hasNext = i.hasNext();
                                BytecodeManager.incBytecodes(1);
                                return hasNext;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                        
                        @Override
                        public Entry<K, V> next() {
                            try {
                                final Iterator<? extends Entry<? extends K, ? extends V>> i = this.i;
                                BytecodeManager.incBytecodes(5);
                                final Entry<? extends K, ? extends V> entry = (Entry<? extends K, ? extends V>)i.next();
                                BytecodeManager.incBytecodes(2);
                                final UnmodifiableEntry unmodifiableEntry = new UnmodifiableEntry<K, V>(entry);
                                BytecodeManager.incBytecodes(1);
                                return (Entry<K, V>)unmodifiableEntry;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                        
                        @Override
                        public void remove() {
                            try {
                                BytecodeManager.incBytecodes(3);
                                final UnsupportedOperationException ex = new UnsupportedOperationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    return iterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Object[] toArray() {
                try {
                    final Collection<? extends E> c = this.c;
                    BytecodeManager.incBytecodes(3);
                    final Object[] array = c.toArray();
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
                        final Object[] array2 = array;
                        final int n3 = n;
                        final Entry entry = (Entry)array[n];
                        BytecodeManager.incBytecodes(9);
                        array2[n3] = new UnmodifiableEntry(entry);
                        BytecodeManager.incBytecodes(1);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Object[] array3 = array;
                    BytecodeManager.incBytecodes(2);
                    return array3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public <T> T[] toArray(final T[] array) {
                try {
                    final Collection<? extends E> c = this.c;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(5);
                    T[] copy;
                    if (length == 0) {
                        copy = array;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        copy = Arrays.copyOf(array, n);
                    }
                    BytecodeManager.incBytecodes(1);
                    final T[] array2 = c.toArray(copy);
                    BytecodeManager.incBytecodes(1);
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int length2 = array2.length;
                        BytecodeManager.incBytecodes(4);
                        if (n3 >= length2) {
                            break;
                        }
                        final T[] array3 = array2;
                        final int n4 = n2;
                        final Entry entry = (Entry)array2[n2];
                        BytecodeManager.incBytecodes(9);
                        array3[n4] = (T)new UnmodifiableEntry(entry);
                        BytecodeManager.incBytecodes(1);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int length3 = array2.length;
                    final int length4 = array.length;
                    BytecodeManager.incBytecodes(5);
                    if (length3 > length4) {
                        final T[] array4 = array2;
                        BytecodeManager.incBytecodes(3);
                        return array4;
                    }
                    final T[] array5 = array2;
                    final int n5 = 0;
                    final int n6 = 0;
                    final int length5 = array2.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array5, n5, array, n6, length5);
                    final int length6 = array.length;
                    final int length7 = array2.length;
                    BytecodeManager.incBytecodes(5);
                    if (length6 > length7) {
                        array[array2.length] = null;
                        BytecodeManager.incBytecodes(5);
                    }
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean contains(final Object o) {
                try {
                    final boolean b = o instanceof Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Collection<? extends E> c = this.c;
                    final Entry entry = (Entry)o;
                    BytecodeManager.incBytecodes(7);
                    final UnmodifiableEntry unmodifiableEntry = new UnmodifiableEntry(entry);
                    BytecodeManager.incBytecodes(1);
                    final boolean contains = c.contains(unmodifiableEntry);
                    BytecodeManager.incBytecodes(1);
                    return contains;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean containsAll(final Collection<?> collection) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Iterator<?> iterator = collection.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<?> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final Iterator<?> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final Object next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                        final Object o = next;
                        BytecodeManager.incBytecodes(3);
                        final boolean contains = this.contains(o);
                        BytecodeManager.incBytecodes(1);
                        if (!contains) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean equals(final Object o) {
                try {
                    BytecodeManager.incBytecodes(3);
                    if (o == this) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final boolean b2 = o instanceof Set;
                    BytecodeManager.incBytecodes(3);
                    if (!b2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final Set set = (Set)o;
                    BytecodeManager.incBytecodes(3);
                    final Set set2 = set;
                    BytecodeManager.incBytecodes(2);
                    final int size = set2.size();
                    final Collection<? extends E> c = this.c;
                    BytecodeManager.incBytecodes(3);
                    final int size2 = c.size();
                    BytecodeManager.incBytecodes(1);
                    if (size != size2) {
                        final boolean b4 = false;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                    final Set<?> set3 = (Set<?>)set;
                    BytecodeManager.incBytecodes(3);
                    final boolean containsAll = this.containsAll(set3);
                    BytecodeManager.incBytecodes(1);
                    return containsAll;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static final class UnmodifiableEntrySetSpliterator<K, V> implements Spliterator<Entry<K, V>>
            {
                final Spliterator<Entry<K, V>> s;
                
                UnmodifiableEntrySetSpliterator(final Spliterator<Entry<K, V>> s) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        this.s = s;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean tryAdvance(final Consumer<? super Entry<K, V>> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(4);
                        final Consumer<Entry<Object, Object>> entryConsumer = UnmodifiableEntrySet.entryConsumer((Consumer<? super Entry<Object, Object>>)consumer);
                        BytecodeManager.incBytecodes(1);
                        final boolean tryAdvance = s.tryAdvance((Consumer<? super Entry<K, V>>)entryConsumer);
                        BytecodeManager.incBytecodes(1);
                        return tryAdvance;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void forEachRemaining(final Consumer<? super Entry<K, V>> consumer) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        Objects.requireNonNull(consumer);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(4);
                        final Consumer<Entry<Object, Object>> entryConsumer = UnmodifiableEntrySet.entryConsumer((Consumer<? super Entry<Object, Object>>)consumer);
                        BytecodeManager.incBytecodes(1);
                        s.forEachRemaining((Consumer<? super Entry<K, V>>)entryConsumer);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Spliterator<Entry<K, V>> trySplit() {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(3);
                        final Spliterator<Entry<K, V>> trySplit = s.trySplit();
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<Entry<K, V>> spliterator = trySplit;
                        BytecodeManager.incBytecodes(2);
                        Object o;
                        if (spliterator == null) {
                            o = null;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final Spliterator<Entry<Object, Object>> spliterator2;
                            o = new UnmodifiableEntrySetSpliterator<Object, Object>(spliterator2);
                            spliterator2 = (Spliterator<Entry<Object, Object>>)trySplit;
                            BytecodeManager.incBytecodes(4);
                        }
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<Entry<K, V>>)o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public long estimateSize() {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(3);
                        final long estimateSize = s.estimateSize();
                        BytecodeManager.incBytecodes(1);
                        return estimateSize;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public long getExactSizeIfKnown() {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(3);
                        final long exactSizeIfKnown = s.getExactSizeIfKnown();
                        BytecodeManager.incBytecodes(1);
                        return exactSizeIfKnown;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int characteristics() {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(3);
                        final int characteristics = s.characteristics();
                        BytecodeManager.incBytecodes(1);
                        return characteristics;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean hasCharacteristics(final int n) {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(4);
                        final boolean hasCharacteristics = s.hasCharacteristics(n);
                        BytecodeManager.incBytecodes(1);
                        return hasCharacteristics;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public Comparator<? super Entry<K, V>> getComparator() {
                    try {
                        final Spliterator<Entry<K, V>> s = this.s;
                        BytecodeManager.incBytecodes(3);
                        final Comparator<? super Entry<K, V>> comparator = s.getComparator();
                        BytecodeManager.incBytecodes(1);
                        return comparator;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
            
            private static class UnmodifiableEntry<K, V> implements Entry<K, V>
            {
                private Entry<? extends K, ? extends V> e;
                
                UnmodifiableEntry(final Entry<? extends K, ? extends V> entry) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(3);
                        this.e = Objects.requireNonNull(entry);
                        BytecodeManager.incBytecodes(3);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public K getKey() {
                    try {
                        final Entry<? extends K, ? extends V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final K key = (K)e.getKey();
                        BytecodeManager.incBytecodes(1);
                        return key;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public V getValue() {
                    try {
                        final Entry<? extends K, ? extends V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final V value = (V)e.getValue();
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public V setValue(final V v) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final UnsupportedOperationException ex = new UnsupportedOperationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int hashCode() {
                    try {
                        final Entry<? extends K, ? extends V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final int hashCode = e.hashCode();
                        BytecodeManager.incBytecodes(1);
                        return hashCode;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean equals(final Object o) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        if (this == o) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final boolean b2 = o instanceof Entry;
                        BytecodeManager.incBytecodes(3);
                        if (!b2) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final Entry entry = (Entry)o;
                        BytecodeManager.incBytecodes(3);
                        final Entry<? extends K, ? extends V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final K key = (K)e.getKey();
                        final Entry<Object, V> entry2 = (Entry<Object, V>)entry;
                        BytecodeManager.incBytecodes(2);
                        final Object key2 = entry2.getKey();
                        BytecodeManager.incBytecodes(1);
                        final boolean eq = Collections.eq(key, key2);
                        BytecodeManager.incBytecodes(1);
                        boolean b4 = false;
                        Label_0148: {
                            if (eq) {
                                final Entry<? extends K, ? extends V> e2 = this.e;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final V value = (V)e2.getValue();
                                final Entry<Object, Object> entry3 = (Entry<Object, Object>)entry;
                                BytecodeManager.incBytecodes(2);
                                final Object value2 = entry3.getValue();
                                BytecodeManager.incBytecodes(1);
                                final boolean eq2 = Collections.eq(value, value2);
                                BytecodeManager.incBytecodes(1);
                                if (eq2) {
                                    b4 = true;
                                    BytecodeManager.incBytecodes(2);
                                    break Label_0148;
                                }
                            }
                            b4 = false;
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                        return b4;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public String toString() {
                    try {
                        final Entry<? extends K, ? extends V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final String string = e.toString();
                        BytecodeManager.incBytecodes(1);
                        return string;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
        }
    }
    
    static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V>, Serializable
    {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, ? extends V> sm;
        
        UnmodifiableSortedMap(final SortedMap<K, ? extends V> sm) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sm);
                this.sm = sm;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super K> comparator = sm.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> subMap(final K k, final K i) {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(7);
                final SortedMap<K, ? extends V> subMap = sm.subMap(k, i);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedMap unmodifiableSortedMap = new UnmodifiableSortedMap((SortedMap<Object, ?>)subMap);
                BytecodeManager.incBytecodes(1);
                return unmodifiableSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> headMap(final K k) {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(6);
                final SortedMap<K, ? extends V> headMap = sm.headMap(k);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedMap unmodifiableSortedMap = new UnmodifiableSortedMap((SortedMap<Object, ?>)headMap);
                BytecodeManager.incBytecodes(1);
                return unmodifiableSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> tailMap(final K k) {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(6);
                final SortedMap<K, ? extends V> tailMap = sm.tailMap(k);
                BytecodeManager.incBytecodes(1);
                final UnmodifiableSortedMap unmodifiableSortedMap = new UnmodifiableSortedMap((SortedMap<Object, ?>)tailMap);
                BytecodeManager.incBytecodes(1);
                return unmodifiableSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K firstKey() {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final K firstKey = sm.firstKey();
                BytecodeManager.incBytecodes(1);
                return firstKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lastKey() {
            try {
                final SortedMap<K, ? extends V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final K lastKey = sm.lastKey();
                BytecodeManager.incBytecodes(1);
                return lastKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class UnmodifiableNavigableMap<K, V> extends UnmodifiableSortedMap<K, V> implements NavigableMap<K, V>, Serializable
    {
        private static final long serialVersionUID = -4858195264774772197L;
        private static final EmptyNavigableMap<?, ?> EMPTY_NAVIGABLE_MAP;
        private final NavigableMap<K, ? extends V> nm;
        
        UnmodifiableNavigableMap(final NavigableMap<K, ? extends V> nm) {
            try {
                BytecodeManager.incBytecodes(3);
                super(nm);
                this.nm = nm;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lowerKey(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K lowerKey = nm.lowerKey(k);
                BytecodeManager.incBytecodes(1);
                return lowerKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K floorKey(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K floorKey = nm.floorKey(k);
                BytecodeManager.incBytecodes(1);
                return floorKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K ceilingKey(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K ceilingKey = nm.ceilingKey(k);
                BytecodeManager.incBytecodes(1);
                return ceilingKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K higherKey(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K higherKey = nm.higherKey(k);
                BytecodeManager.incBytecodes(1);
                return higherKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lowerEntry(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, ? extends V> lowerEntry = nm.lowerEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = lowerEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = lowerEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> floorEntry(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, ? extends V> floorEntry = nm.floorEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = floorEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = floorEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> ceilingEntry(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, ? extends V> ceilingEntry = nm.ceilingEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = ceilingEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = ceilingEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> higherEntry(final K k) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, ? extends V> higherEntry = nm.higherEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = higherEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = higherEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> firstEntry() {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, ? extends V> firstEntry = nm.firstEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = firstEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = firstEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lastEntry() {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, ? extends V> lastEntry = nm.lastEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, ? extends V> entry = null;
                final Map.Entry<K, ? extends V> entry2 = lastEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, ? extends V> entry4;
                    entry3 = new UnmodifiableEntrySet.UnmodifiableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry4);
                    entry4 = lastEntry;
                    BytecodeManager.incBytecodes(4);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollLastEntry() {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> descendingMap() {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableMap<K, ? extends V> descendingMap = nm.descendingMap();
                BytecodeManager.incBytecodes(1);
                final NavigableMap<K, Object> unmodifiableNavigableMap = Collections.unmodifiableNavigableMap((NavigableMap<K, ?>)descendingMap);
                BytecodeManager.incBytecodes(1);
                return (NavigableMap<K, V>)unmodifiableNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> navigableKeySet() {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> navigableKeySet = nm.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                final NavigableSet<K> unmodifiableNavigableSet = Collections.unmodifiableNavigableSet(navigableKeySet);
                BytecodeManager.incBytecodes(1);
                return unmodifiableNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> descendingKeySet = nm.descendingKeySet();
                BytecodeManager.incBytecodes(1);
                final NavigableSet<K> unmodifiableNavigableSet = Collections.unmodifiableNavigableSet(descendingKeySet);
                BytecodeManager.incBytecodes(1);
                return unmodifiableNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                final NavigableMap<K, ? extends V> subMap = nm.subMap(k, b, i, b2);
                BytecodeManager.incBytecodes(1);
                final NavigableMap<K, Object> unmodifiableNavigableMap = Collections.unmodifiableNavigableMap((NavigableMap<K, ?>)subMap);
                BytecodeManager.incBytecodes(1);
                return (NavigableMap<K, V>)unmodifiableNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k, final boolean b) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, ? extends V> headMap = nm.headMap(k, b);
                BytecodeManager.incBytecodes(1);
                final NavigableMap<K, Object> unmodifiableNavigableMap = Collections.unmodifiableNavigableMap((NavigableMap<K, ?>)headMap);
                BytecodeManager.incBytecodes(1);
                return (NavigableMap<K, V>)unmodifiableNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k, final boolean b) {
            try {
                final NavigableMap<K, ? extends V> nm = this.nm;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, ? extends V> tailMap = nm.tailMap(k, b);
                BytecodeManager.incBytecodes(1);
                final NavigableMap<K, Object> unmodifiableNavigableMap = Collections.unmodifiableNavigableMap((NavigableMap<K, ?>)tailMap);
                BytecodeManager.incBytecodes(1);
                return (NavigableMap<K, V>)unmodifiableNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ EmptyNavigableMap access$100() {
            try {
                final EmptyNavigableMap<?, ?> empty_NAVIGABLE_MAP = UnmodifiableNavigableMap.EMPTY_NAVIGABLE_MAP;
                BytecodeManager.incBytecodes(2);
                return empty_NAVIGABLE_MAP;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                EMPTY_NAVIGABLE_MAP = new EmptyNavigableMap<Object, Object>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static class EmptyNavigableMap<K, V> extends UnmodifiableNavigableMap<K, V> implements Serializable
        {
            private static final long serialVersionUID = -2239321462712562324L;
            
            EmptyNavigableMap() {
                try {
                    BytecodeManager.incBytecodes(4);
                    final TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
                    BytecodeManager.incBytecodes(1);
                    super(treeMap);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public NavigableSet<K> navigableKeySet() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final NavigableSet<K> emptyNavigableSet = Collections.emptyNavigableSet();
                    BytecodeManager.incBytecodes(1);
                    return emptyNavigableSet;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private Object readResolve() {
                try {
                    BytecodeManager.incBytecodes(1);
                    final EmptyNavigableMap access$100 = UnmodifiableNavigableMap.access$100();
                    BytecodeManager.incBytecodes(1);
                    return access$100;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static class SynchronizedCollection<E> implements Collection<E>, Serializable
    {
        private static final long serialVersionUID = 3053995032091335093L;
        final Collection<E> c;
        final Object mutex;
        
        SynchronizedCollection(final Collection<E> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.c = Objects.requireNonNull(collection);
                BytecodeManager.incBytecodes(2);
                this.mutex = this;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedCollection(final Collection<E> collection, final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.c = Objects.requireNonNull(collection);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.mutex = Objects.requireNonNull(o);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = collection2.size();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final int n2 = collection2.size();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection2.isEmpty();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection2.isEmpty();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection2.contains(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection2.contains(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Object[] array = collection2.toArray();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return array;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Object[] array = collection2.toArray();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return array;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final T[] array2 = array;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final T[] array3 = collection2.toArray(array2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return array3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final T[] array2 = array;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final T[] array3 = collection2.toArray(array2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return array3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> iterator = c.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final E e2 = e;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection2.add(e2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final E e2 = e;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection2.add(e2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection2.remove(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection2.remove(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection2 = this;
                    final Collection<E> collection3 = collection2.c;
                    final Collection<?> collection4 = collection;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection3.containsAll(collection4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection2 = this;
                final Collection<E> collection3 = collection2.c;
                final Collection<?> collection4 = collection;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection3.containsAll(collection4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection2 = this;
                    final Collection<E> collection3 = collection2.c;
                    final Collection<? extends E> collection4 = collection;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection3.addAll(collection4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection2 = this;
                final Collection<E> collection3 = collection2.c;
                final Collection<? extends E> collection4 = collection;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection3.addAll(collection4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection2 = this;
                    final Collection<E> collection3 = collection2.c;
                    final Collection<?> collection4 = collection;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection3.removeAll(collection4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection2 = this;
                final Collection<E> collection3 = collection2.c;
                final Collection<?> collection4 = collection;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection3.removeAll(collection4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection2 = this;
                    final Collection<E> collection3 = collection2.c;
                    final Collection<?> collection4 = collection;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection3.retainAll(collection4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection2 = this;
                final Collection<E> collection3 = collection2.c;
                final Collection<?> collection4 = collection;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection3.retainAll(collection4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void clear() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedCollection.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedCollection.c:Linstrumented/java/util/Collection;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokeinterface instrumented/java/util/Collection.clear:()V
            //    26: aload_1        
            //    27: pop            
            //    28: ldc             2
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: ldc             1
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: goto            56
            //    41: astore_2       
            //    42: aload_1        
            //    43: pop            
            //    44: ldc             503
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: aload_2        
            //    50: ldc             2
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: athrow         
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: return         
            //    62: athrow         
            //    63: athrow         
            //    StackMapTable: 00 04 FF 00 29 00 02 07 00 02 07 00 05 00 01 07 00 30 FA 00 0E FF 00 05 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 35
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     63     63     64     Ljava/lang/VirtualMachineError;
            //  12     33     41     56     Any
            //  41     49     41     56     Any
            //  0      62     62     63     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0056:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public String toString() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final String s = collection2.toString();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return s;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final String s = collection2.toString();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return s;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        public void forEach(final Consumer<? super E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedCollection.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedCollection.c:Linstrumented/java/util/Collection;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/Collection.forEach:(Linstrumented/java/util/function/Consumer;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Consumer<-TE;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 6F 07 00 05 00 01 07 00 30 FA 00 0E FF 00 05 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 35
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedCollection collection = this;
                    final Collection<E> collection2 = collection.c;
                    final Predicate<? super E> predicate2 = predicate;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = collection2.removeIf(predicate2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedCollection collection = this;
                final Collection<E> collection2 = collection.c;
                final Predicate<? super E> predicate2 = predicate;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = collection2.removeIf(predicate2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> spliterator = c.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<E> stream = c.stream();
                BytecodeManager.incBytecodes(1);
                return stream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<E> parallelStream = c.parallelStream();
                BytecodeManager.incBytecodes(1);
                return parallelStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void writeObject(final ObjectOutputStream p0) throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedCollection.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_1        
            //    13: ldc             2
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokevirtual   java/io/ObjectOutputStream.defaultWriteObject:()V
            //    21: aload_2        
            //    22: pop            
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ldc             1
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: goto            51
            //    36: astore_3       
            //    37: aload_2        
            //    38: pop            
            //    39: ldc             503
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: aload_3        
            //    45: ldc             2
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: athrow         
            //    51: ldc             1
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: return         
            //    57: athrow         
            //    58: athrow         
            //    Exceptions:
            //  throws java.io.IOException
            //    StackMapTable: 00 04 FF 00 24 00 03 07 00 02 07 00 86 07 00 05 00 01 07 00 30 FA 00 0E FF 00 05 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 35
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     58     58     59     Ljava/lang/VirtualMachineError;
            //  12     28     36     51     Any
            //  36     44     36     51     Any
            //  0      57     57     58     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
    
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E>
    {
        private static final long serialVersionUID = 487447009682186044L;
        
        SynchronizedSet(final Set<E> set) {
            try {
                BytecodeManager.incBytecodes(3);
                super(set);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedSet(final Set<E> set, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(set, o);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (this == o) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSet set = this;
                    final Collection<E> collection = set.c;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b2 = collection.equals(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSet set = this;
                final Collection<E> collection = set.c;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b2 = collection.equals(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSet set = this;
                    final Collection<E> collection = set.c;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = collection.hashCode();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSet set = this;
                final Collection<E> collection = set.c;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final int n2 = collection.hashCode();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
    }
    
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E>
    {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;
        
        SynchronizedSortedSet(final SortedSet<E> ss) {
            try {
                BytecodeManager.incBytecodes(3);
                super(ss);
                this.ss = ss;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedSortedSet(final SortedSet<E> ss, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(ss, o);
                this.ss = ss;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super E> comparator() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Comparator<? super E> comparator = set2.comparator();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return comparator;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Comparator<? super E> comparator = set2.comparator();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return comparator;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final E e3 = e;
                    final E e4 = e2;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final SortedSet<E> set3 = set2.subSet(e3, e4);
                    final SynchronizedSortedSet set4 = this;
                    final Object o = set4.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final E e3 = e;
                final E e4 = e2;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final SortedSet<E> set3 = set2.subSet(e3, e4);
                final SynchronizedSortedSet set4 = this;
                final Object o = set4.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedSet<E> headSet(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final E e2 = e;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final SortedSet<E> set3 = set2.headSet(e2);
                    final SynchronizedSortedSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final E e2 = e;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final SortedSet<E> set3 = set2.headSet(e2);
                final SynchronizedSortedSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedSet<E> tailSet(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final E e2 = e;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final SortedSet<E> set3 = set2.tailSet(e2);
                    final SynchronizedSortedSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final E e2 = e;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final SortedSet<E> set3 = set2.tailSet(e2);
                final SynchronizedSortedSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedSortedSet set5 = new SynchronizedSortedSet((SortedSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E first() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final E e = set2.first();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final E e = set2.first();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E last() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedSet set = this;
                    final SortedSet<E> set2 = set.ss;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final E e = set2.last();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedSet set = this;
                final SortedSet<E> set2 = set.ss;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final E e = set2.last();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
    }
    
    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E>
    {
        private static final long serialVersionUID = -5505529816273629798L;
        private final NavigableSet<E> ns;
        
        SynchronizedNavigableSet(final NavigableSet<E> ns) {
            try {
                BytecodeManager.incBytecodes(3);
                super(ns);
                this.ns = ns;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedNavigableSet(final NavigableSet<E> ns, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(ns, o);
                this.ns = ns;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E lower(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final E e3 = set2.lower(e2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final E e3 = set2.lower(e2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E floor(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final E e3 = set2.floor(e2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final E e3 = set2.floor(e2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E ceiling(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final E e3 = set2.ceiling(e2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final E e3 = set2.ceiling(e2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E higher(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final E e3 = set2.higher(e2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final E e3 = set2.higher(e2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E pollFirst() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final E e = set2.pollFirst();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final E e = set2.pollFirst();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E pollLast() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final E e = set2.pollLast();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final E e = set2.pollLast();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.descendingSet();
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.descendingSet();
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final int n = 2;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set2 = set.descendingSet();
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final Iterator<E> iterator = set2.iterator();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return iterator;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set2 = set.descendingSet();
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final Iterator<E> iterator = set2.iterator();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return iterator;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final E e2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e3 = e;
                    final boolean b = true;
                    final E e4 = e2;
                    final boolean b2 = false;
                    final int n = 9;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.subSet(e3, b, e4, b2);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e3 = e;
                final boolean b = true;
                final E e4 = e2;
                final boolean b2 = false;
                final int n = 9;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.subSet(e3, b, e4, b2);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final boolean b = false;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.headSet(e2, b);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final boolean b = false;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.headSet(e2, b);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final boolean b = true;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.tailSet(e2, b);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final boolean b = true;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.tailSet(e2, b);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e3 = e;
                    final boolean b3 = b;
                    final E e4 = e2;
                    final boolean b4 = b2;
                    final int n = 9;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.subSet(e3, b3, e4, b4);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e3 = e;
                final boolean b3 = b;
                final E e4 = e2;
                final boolean b4 = b2;
                final int n = 9;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.subSet(e3, b3, e4, b4);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final boolean b2 = b;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.headSet(e2, b2);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final boolean b2 = b;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.headSet(e2, b2);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableSet set = this;
                    final NavigableSet<E> set2 = set.ns;
                    final E e2 = e;
                    final boolean b2 = b;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<E> set3 = set2.tailSet(e2, b2);
                    final SynchronizedNavigableSet set4 = this;
                    final Object o = set4.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return set5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableSet set = this;
                final NavigableSet<E> set2 = set.ns;
                final E e2 = e;
                final boolean b2 = b;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<E> set3 = set2.tailSet(e2, b2);
                final SynchronizedNavigableSet set4 = this;
                final Object o = set4.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set5 = new SynchronizedNavigableSet((NavigableSet<Object>)set3, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return set5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
    }
    
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E>
    {
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;
        
        SynchronizedList(final List<E> list) {
            try {
                BytecodeManager.incBytecodes(3);
                super(list);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedList(final List<E> list, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(list, o);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (this == o) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b2 = list2.equals(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b2 = list2.equals(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = list2.hashCode();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final int n2 = list2.hashCode();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E get(final int n) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n2 = n;
                    final int n3 = 4;
                    BytecodeManager.incBytecodes(n3);
                    final E e = list2.get(n2);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n2 = n;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final E e = list2.get(n2);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E set(final int n, final E e) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n2 = n;
                    final E e2 = e;
                    final int n3 = 5;
                    BytecodeManager.incBytecodes(n3);
                    final E e3 = list2.set(n2, e2);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n2 = n;
                final E e2 = e;
                final int n3 = 5;
                BytecodeManager.incBytecodes(n3);
                final E e3 = list2.set(n2, e2);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void add(final int p0, final E p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedList.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_3       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedList.list:Linstrumented/java/util/List;
            //    16: iload_1        
            //    17: aload_2        
            //    18: ldc             5
            //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    23: invokeinterface instrumented/java/util/List.add:(ILjava/lang/Object;)V
            //    28: aload_3        
            //    29: pop            
            //    30: ldc             2
            //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    35: ldc             1
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: goto            60
            //    43: astore          4
            //    45: aload_3        
            //    46: pop            
            //    47: ldc             503
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: aload           4
            //    54: ldc             2
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: athrow         
            //    60: ldc             1
            //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    65: return         
            //    66: athrow         
            //    67: athrow         
            //    Signature:
            //  (ITE;)V
            //    StackMapTable: 00 04 FF 00 2B 00 04 07 00 02 01 07 00 3A 07 00 3A 00 01 07 00 27 FA 00 10 FF 00 05 00 00 00 01 07 00 27 FF 00 00 00 00 00 01 07 00 30
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     67     67     68     Ljava/lang/VirtualMachineError;
            //  12     35     43     60     Any
            //  43     52     43     60     Any
            //  0      66     66     67     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0060:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public E remove(final int n) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n2 = n;
                    final int n3 = 4;
                    BytecodeManager.incBytecodes(n3);
                    final E e = list2.remove(n2);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return e;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n2 = n;
                final int n3 = 4;
                BytecodeManager.incBytecodes(n3);
                final E e = list2.remove(n2);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return e;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int indexOf(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = list2.indexOf(o2);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = list2.indexOf(o2);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = list2.lastIndexOf(o2);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = list2.lastIndexOf(o2);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean addAll(final int n, final Collection<? extends E> collection) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n2 = n;
                    final Collection<? extends E> collection2 = collection;
                    final int n3 = 5;
                    BytecodeManager.incBytecodes(n3);
                    final boolean b = list2.addAll(n2, collection2);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n2 = n;
                final Collection<? extends E> collection2 = collection;
                final int n3 = 5;
                BytecodeManager.incBytecodes(n3);
                final boolean b = list2.addAll(n2, collection2);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public ListIterator<E> listIterator() {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = list.listIterator();
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator(final int n) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final ListIterator<E> listIterator = list.listIterator(n);
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedList list = this;
                    final List<E> list2 = list.list;
                    final int n3 = n;
                    final int n4 = n2;
                    final int n5 = 7;
                    BytecodeManager.incBytecodes(n5);
                    final List<E> list3 = list2.subList(n3, n4);
                    final SynchronizedList list4 = this;
                    final Object o = list4.mutex;
                    final int n6 = 3;
                    BytecodeManager.incBytecodes(n6);
                    final SynchronizedList list5 = new SynchronizedList((List<Object>)list3, o);
                    final int n7 = 2;
                    BytecodeManager.incBytecodes(n7);
                    final int n8 = 1;
                    BytecodeManager.incBytecodes(n8);
                    return list5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedList list = this;
                final List<E> list2 = list.list;
                final int n3 = n;
                final int n4 = n2;
                final int n5 = 7;
                BytecodeManager.incBytecodes(n5);
                final List<E> list3 = list2.subList(n3, n4);
                final SynchronizedList list4 = this;
                final Object o = list4.mutex;
                final int n6 = 3;
                BytecodeManager.incBytecodes(n6);
                final SynchronizedList list5 = new SynchronizedList((List<Object>)list3, o);
                final int n7 = 2;
                BytecodeManager.incBytecodes(n7);
                final int n8 = 1;
                BytecodeManager.incBytecodes(n8);
                return list5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void replaceAll(final UnaryOperator<E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedList.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedList.list:Linstrumented/java/util/List;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/List.replaceAll:(Linstrumented/java/util/function/UnaryOperator;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/UnaryOperator<TE;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 6F 07 00 3A 00 01 07 00 27 FA 00 0E FF 00 05 00 00 00 01 07 00 27 FF 00 00 00 00 00 01 07 00 30
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public void sort(final Comparator<? super E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedList.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedList.list:Linstrumented/java/util/List;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/List.sort:(Linstrumented/java/util/Comparator;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/Comparator<-TE;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 75 07 00 3A 00 01 07 00 27 FA 00 0E FF 00 05 00 00 00 01 07 00 27 FF 00 00 00 00 00 01 07 00 30
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private Object readResolve() {
            try {
                final boolean b = this.list instanceof RandomAccess;
                BytecodeManager.incBytecodes(4);
                SynchronizedList list;
                if (b) {
                    final List<E> list2;
                    list = new SynchronizedRandomAccessList(list2);
                    list2 = this.list;
                    BytecodeManager.incBytecodes(5);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    list = this;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return list;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess
    {
        private static final long serialVersionUID = 1530674583602358482L;
        
        SynchronizedRandomAccessList(final List<E> list) {
            try {
                BytecodeManager.incBytecodes(3);
                super(list);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedRandomAccessList(final List<E> list, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(list, o);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedRandomAccessList list = this;
                    final List<E> list2 = list.list;
                    final int n3 = n;
                    final int n4 = n2;
                    final int n5 = 6;
                    BytecodeManager.incBytecodes(n5);
                    final int n6 = 1;
                    BytecodeManager.incBytecodes(n6);
                    final List<E> list3 = list2.subList(n3, n4);
                    final SynchronizedRandomAccessList list4 = this;
                    final Object o = list4.mutex;
                    final int n7 = 3;
                    BytecodeManager.incBytecodes(n7);
                    final SynchronizedRandomAccessList list5 = new SynchronizedRandomAccessList((List<Object>)list3, o);
                    final int n8 = 2;
                    BytecodeManager.incBytecodes(n8);
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(n9);
                    return list5;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedRandomAccessList list = this;
                final List<E> list2 = list.list;
                final int n3 = n;
                final int n4 = n2;
                final int n5 = 6;
                BytecodeManager.incBytecodes(n5);
                final int n6 = 1;
                BytecodeManager.incBytecodes(n6);
                final List<E> list3 = list2.subList(n3, n4);
                final SynchronizedRandomAccessList list4 = this;
                final Object o = list4.mutex;
                final int n7 = 3;
                BytecodeManager.incBytecodes(n7);
                final SynchronizedRandomAccessList list5 = new SynchronizedRandomAccessList((List<Object>)list3, o);
                final int n8 = 2;
                BytecodeManager.incBytecodes(n8);
                final int n9 = 1;
                BytecodeManager.incBytecodes(n9);
                return list5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        private Object writeReplace() {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(5);
                final SynchronizedList list2 = new SynchronizedList(list);
                BytecodeManager.incBytecodes(1);
                return list2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class SynchronizedMap<K, V> implements Map<K, V>, Serializable
    {
        private static final long serialVersionUID = 1978198479659022715L;
        private final Map<K, V> m;
        final Object mutex;
        private transient Set<K> keySet;
        private transient Set<Entry<K, V>> entrySet;
        private transient Collection<V> values;
        
        SynchronizedMap(final Map<K, V> map) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.m = Objects.requireNonNull(map);
                BytecodeManager.incBytecodes(2);
                this.mutex = this;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedMap(final Map<K, V> m, final Object mutex) {
            try {
                BytecodeManager.incBytecodes(2);
                this.m = m;
                BytecodeManager.incBytecodes(3);
                this.mutex = mutex;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = map.size();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final int n2 = map.size();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = map.isEmpty();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final boolean b = map.isEmpty();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = map.containsKey(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = map.containsKey(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean containsValue(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = map.containsValue(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b = map.containsValue(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V get(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final V v = map.get(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final V v = map.get(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V put(final K k, final V v) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final V v2 = v;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v3 = map.put(i, v2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final V v2 = v;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v3 = map.put(i, v2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V remove(final Object o) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final V v = map.remove(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final V v = map.remove(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/Map.putAll:(Linstrumented/java/util/Map;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/Map<+TK;+TV;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 07 07 00 05 00 01 07 00 41 FA 00 0E FF 00 05 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public void clear() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokeinterface instrumented/java/util/Map.clear:()V
            //    26: aload_1        
            //    27: pop            
            //    28: ldc             2
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: ldc             1
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: goto            56
            //    41: astore_2       
            //    42: aload_1        
            //    43: pop            
            //    44: ldc             503
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: aload_2        
            //    50: ldc             2
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: athrow         
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: return         
            //    62: athrow         
            //    63: athrow         
            //    StackMapTable: 00 04 FF 00 29 00 02 07 00 02 07 00 05 00 01 07 00 41 FA 00 0E FF 00 05 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     63     63     64     Ljava/lang/VirtualMachineError;
            //  12     33     41     56     Any
            //  41     49     41     56     Any
            //  0      62     62     63     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0056:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public Set<K> keySet() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.keySet:Linstrumented/java/util/Set;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: ifnonnull       63
            //    24: aload_0        
            //    25: new             Linstrumented/java/util/Collections$SynchronizedSet;
            //    28: dup            
            //    29: aload_0        
            //    30: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    33: ldc             6
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokeinterface instrumented/java/util/Map.keySet:()Linstrumented/java/util/Set;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //    47: ldc             3
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: invokespecial   instrumented/java/util/Collections$SynchronizedSet.<init>:(Linstrumented/java/util/Set;Ljava/lang/Object;)V
            //    55: putfield        instrumented/java/util/Collections$SynchronizedMap.keySet:Linstrumented/java/util/Set;
            //    58: ldc             1
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: aload_0        
            //    64: getfield        instrumented/java/util/Collections$SynchronizedMap.keySet:Linstrumented/java/util/Set;
            //    67: aload_1        
            //    68: pop            
            //    69: ldc             4
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ldc             1
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: areturn        
            //    80: astore_2       
            //    81: aload_1        
            //    82: pop            
            //    83: ldc             503
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_2        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: athrow         
            //    95: athrow         
            //    96: athrow         
            //    Signature:
            //  ()Linstrumented/java/util/Set<TK;>;
            //    StackMapTable: 00 04 FC 00 3F 07 00 05 50 07 00 41 FF 00 0E 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     96     96     97     Ljava/lang/VirtualMachineError;
            //  12     74     80     95     Any
            //  80     88     80     95     Any
            //  0      95     95     96     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public Set<Entry<K, V>> entrySet() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.entrySet:Linstrumented/java/util/Set;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: ifnonnull       63
            //    24: aload_0        
            //    25: new             Linstrumented/java/util/Collections$SynchronizedSet;
            //    28: dup            
            //    29: aload_0        
            //    30: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    33: ldc             6
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //    47: ldc             3
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: invokespecial   instrumented/java/util/Collections$SynchronizedSet.<init>:(Linstrumented/java/util/Set;Ljava/lang/Object;)V
            //    55: putfield        instrumented/java/util/Collections$SynchronizedMap.entrySet:Linstrumented/java/util/Set;
            //    58: ldc             1
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: aload_0        
            //    64: getfield        instrumented/java/util/Collections$SynchronizedMap.entrySet:Linstrumented/java/util/Set;
            //    67: aload_1        
            //    68: pop            
            //    69: ldc             4
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ldc             1
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: areturn        
            //    80: astore_2       
            //    81: aload_1        
            //    82: pop            
            //    83: ldc             503
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_2        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: athrow         
            //    95: athrow         
            //    96: athrow         
            //    Signature:
            //  ()Linstrumented/java/util/Set<Linstrumented/java/util/Map$Entry<TK;TV;>;>;
            //    StackMapTable: 00 04 FC 00 3F 07 00 05 50 07 00 41 FF 00 0E 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     96     96     97     Ljava/lang/VirtualMachineError;
            //  12     74     80     95     Any
            //  80     88     80     95     Any
            //  0      95     95     96     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public Collection<V> values() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.values:Linstrumented/java/util/Collection;
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: ifnonnull       63
            //    24: aload_0        
            //    25: new             Linstrumented/java/util/Collections$SynchronizedCollection;
            //    28: dup            
            //    29: aload_0        
            //    30: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    33: ldc             6
            //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    38: invokeinterface instrumented/java/util/Map.values:()Linstrumented/java/util/Collection;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //    47: ldc             3
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: invokespecial   instrumented/java/util/Collections$SynchronizedCollection.<init>:(Linstrumented/java/util/Collection;Ljava/lang/Object;)V
            //    55: putfield        instrumented/java/util/Collections$SynchronizedMap.values:Linstrumented/java/util/Collection;
            //    58: ldc             1
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: aload_0        
            //    64: getfield        instrumented/java/util/Collections$SynchronizedMap.values:Linstrumented/java/util/Collection;
            //    67: aload_1        
            //    68: pop            
            //    69: ldc             4
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ldc             1
            //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    79: areturn        
            //    80: astore_2       
            //    81: aload_1        
            //    82: pop            
            //    83: ldc             503
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_2        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: athrow         
            //    95: athrow         
            //    96: athrow         
            //    Signature:
            //  ()Linstrumented/java/util/Collection<TV;>;
            //    StackMapTable: 00 04 FC 00 3F 07 00 05 50 07 00 41 FF 00 0E 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     96     96     97     Ljava/lang/VirtualMachineError;
            //  12     74     80     95     Any
            //  80     88     80     95     Any
            //  0      95     95     96     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                if (this == o) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final boolean b2 = map.equals(o2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final boolean b2 = map.equals(o2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = map.hashCode();
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return n2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final int n2 = map.hashCode();
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return n2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public String toString() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final String s = map.toString();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return s;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final String s = map.toString();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return s;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V getOrDefault(final Object o, final V v) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o2 = o;
                    final V v2 = v;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v3 = map.getOrDefault(o2, v2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o2 = o;
                final V v2 = v;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v3 = map.getOrDefault(o2, v2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void forEach(final BiConsumer<? super K, ? super V> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/Map.forEach:(Linstrumented/java/util/function/BiConsumer;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/BiConsumer<-TK;-TV;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 8E 07 00 05 00 01 07 00 41 FA 00 0E FF 00 05 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: getfield        instrumented/java/util/Collections$SynchronizedMap.m:Linstrumented/java/util/Map;
            //    16: aload_1        
            //    17: ldc             4
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokeinterface instrumented/java/util/Map.replaceAll:(Linstrumented/java/util/function/BiFunction;)V
            //    27: aload_2        
            //    28: pop            
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: ldc             1
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: goto            57
            //    42: astore_3       
            //    43: aload_2        
            //    44: pop            
            //    45: ldc             503
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: aload_3        
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: athrow         
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: return         
            //    63: athrow         
            //    64: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/BiFunction<-TK;-TV;+TV;>;)V
            //    StackMapTable: 00 04 FF 00 2A 00 03 07 00 02 07 00 94 07 00 05 00 01 07 00 41 FA 00 0E FF 00 05 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     64     64     65     Ljava/lang/VirtualMachineError;
            //  12     34     42     57     Any
            //  42     50     42     57     Any
            //  0      63     63     64     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final V v2 = v;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v3 = map.putIfAbsent(i, v2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final V v2 = v;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v3 = map.putIfAbsent(i, v2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final Object o3 = o;
                    final Object o4 = o2;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = map.remove(o3, o4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final Object o3 = o;
                final Object o4 = o2;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final boolean b = map.remove(o3, o4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final V v3 = v;
                    final V v4 = v2;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final boolean b = map.replace(i, v3, v4);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return b;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final V v3 = v;
                final V v4 = v2;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final boolean b = map.replace(i, v3, v4);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return b;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final V v2 = v;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v3 = map.replace(i, v2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final V v2 = v;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v3 = map.replace(i, v2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final Function<? super K, ? extends V> function2 = function;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v = map.computeIfAbsent(i, function2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final Function<? super K, ? extends V> function2 = function;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v = map.computeIfAbsent(i, function2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final BiFunction<? super K, ? super V, ? extends V> biFunction2 = biFunction;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v = map.computeIfPresent(i, biFunction2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final BiFunction<? super K, ? super V, ? extends V> biFunction2 = biFunction;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v = map.computeIfPresent(i, biFunction2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final BiFunction<? super K, ? super V, ? extends V> biFunction2 = biFunction;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final V v = map.compute(i, biFunction2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final BiFunction<? super K, ? super V, ? extends V> biFunction2 = biFunction;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final V v = map.compute(i, biFunction2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedMap synchronizedMap = this;
                    final Map<K, V> map = synchronizedMap.m;
                    final K i = k;
                    final V v2 = v;
                    final BiFunction<? super V, ? super V, ? extends V> biFunction2 = biFunction;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final V v3 = map.merge(i, v2, biFunction2);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return v3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedMap synchronizedMap = this;
                final Map<K, V> map = synchronizedMap.m;
                final K i = k;
                final V v2 = v;
                final BiFunction<? super V, ? super V, ? extends V> biFunction2 = biFunction;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final V v3 = map.merge(i, v2, biFunction2);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return v3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        private void writeObject(final ObjectOutputStream p0) throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Collections$SynchronizedMap.mutex:Ljava/lang/Object;
            //     4: dup            
            //     5: astore_2       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_1        
            //    13: ldc             2
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokevirtual   java/io/ObjectOutputStream.defaultWriteObject:()V
            //    21: aload_2        
            //    22: pop            
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: ldc             1
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: goto            51
            //    36: astore_3       
            //    37: aload_2        
            //    38: pop            
            //    39: ldc             503
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: aload_3        
            //    45: ldc             2
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: athrow         
            //    51: ldc             1
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: return         
            //    57: athrow         
            //    58: athrow         
            //    Exceptions:
            //  throws java.io.IOException
            //    StackMapTable: 00 04 FF 00 24 00 03 07 00 02 07 00 B7 07 00 05 00 01 07 00 41 FA 00 0E FF 00 05 00 00 00 01 07 00 41 FF 00 00 00 00 00 01 07 00 46
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     58     58     59     Ljava/lang/VirtualMachineError;
            //  12     28     36     51     Any
            //  36     44     36     51     Any
            //  0      57     57     58     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
    
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V>
    {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;
        
        SynchronizedSortedMap(final SortedMap<K, V> sm) {
            try {
                BytecodeManager.incBytecodes(3);
                super(sm);
                this.sm = sm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedSortedMap(final SortedMap<K, V> sm, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(sm, o);
                this.sm = sm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Comparator<? super K> comparator = sortedMap.comparator();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return comparator;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Comparator<? super K> comparator = sortedMap.comparator();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return comparator;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> subMap(final K k, final K i) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final K j = k;
                    final K l = i;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final SortedMap<K, V> sortedMap2 = sortedMap.subMap(j, l);
                    final SynchronizedSortedMap synchronizedSortedMap2 = this;
                    final Object o = synchronizedSortedMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedSortedMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final K j = k;
                final K l = i;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final SortedMap<K, V> sortedMap2 = sortedMap.subMap(j, l);
                final SynchronizedSortedMap synchronizedSortedMap2 = this;
                final Object o = synchronizedSortedMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedSortedMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> headMap(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final K i = k;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final SortedMap<K, V> sortedMap2 = sortedMap.headMap(i);
                    final SynchronizedSortedMap synchronizedSortedMap2 = this;
                    final Object o = synchronizedSortedMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return synchronizedSortedMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final K i = k;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final SortedMap<K, V> sortedMap2 = sortedMap.headMap(i);
                final SynchronizedSortedMap synchronizedSortedMap2 = this;
                final Object o = synchronizedSortedMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return synchronizedSortedMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> tailMap(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final K i = k;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final SortedMap<K, V> sortedMap2 = sortedMap.tailMap(i);
                    final SynchronizedSortedMap synchronizedSortedMap2 = this;
                    final Object o = synchronizedSortedMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return synchronizedSortedMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final K i = k;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final SortedMap<K, V> sortedMap2 = sortedMap.tailMap(i);
                final SynchronizedSortedMap synchronizedSortedMap2 = this;
                final Object o = synchronizedSortedMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedSortedMap synchronizedSortedMap3 = new SynchronizedSortedMap((SortedMap<Object, Object>)sortedMap2, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return synchronizedSortedMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K firstKey() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final K k = sortedMap.firstKey();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return k;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final K k = sortedMap.firstKey();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return k;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K lastKey() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedSortedMap synchronizedSortedMap = this;
                    final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final K k = sortedMap.lastKey();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return k;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedSortedMap synchronizedSortedMap = this;
                final SortedMap<K, V> sortedMap = synchronizedSortedMap.sm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final K k = sortedMap.lastKey();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return k;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
    }
    
    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V>
    {
        private static final long serialVersionUID = 699392247599746807L;
        private final NavigableMap<K, V> nm;
        
        SynchronizedNavigableMap(final NavigableMap<K, V> nm) {
            try {
                BytecodeManager.incBytecodes(3);
                super(nm);
                this.nm = nm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        SynchronizedNavigableMap(final NavigableMap<K, V> nm, final Object o) {
            try {
                BytecodeManager.incBytecodes(4);
                super(nm, o);
                this.nm = nm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lowerEntry(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.lowerEntry(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.lowerEntry(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K lowerKey(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final K j = navigableMap.lowerKey(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return j;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final K j = navigableMap.lowerKey(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return j;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> floorEntry(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.floorEntry(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.floorEntry(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K floorKey(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final K j = navigableMap.floorKey(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return j;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final K j = navigableMap.floorKey(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return j;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> ceilingEntry(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.ceilingEntry(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.ceilingEntry(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K ceilingKey(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final K j = navigableMap.ceilingKey(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return j;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final K j = navigableMap.ceilingKey(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return j;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> higherEntry(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.higherEntry(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.higherEntry(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public K higherKey(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final K j = navigableMap.higherKey(i);
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return j;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final K j = navigableMap.higherKey(i);
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return j;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> firstEntry() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.firstEntry();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.firstEntry();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> lastEntry() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.lastEntry();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.lastEntry();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.pollFirstEntry();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.pollFirstEntry();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public Map.Entry<K, V> pollLastEntry() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 3;
                    BytecodeManager.incBytecodes(n);
                    final Map.Entry<K, V> entry = navigableMap.pollLastEntry();
                    final int n2 = 2;
                    BytecodeManager.incBytecodes(n2);
                    final int n3 = 1;
                    BytecodeManager.incBytecodes(n3);
                    return entry;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final Map.Entry<K, V> entry = navigableMap.pollLastEntry();
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                final int n3 = 1;
                BytecodeManager.incBytecodes(n3);
                return entry;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableMap<K, V> descendingMap() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 4;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.descendingMap();
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 4;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final NavigableMap<K, V> navigableMap2 = navigableMap.descendingMap();
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<K> keySet() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableSet<K> navigableKeySet = this.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                return navigableKeySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> navigableKeySet() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<K> set = navigableMap.navigableKeySet();
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set2 = new SynchronizedNavigableSet((NavigableSet<Object>)set, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return (NavigableSet<K>)set2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<K> set = navigableMap.navigableKeySet();
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set2 = new SynchronizedNavigableSet(set, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return (NavigableSet<K>)set2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final int n = 5;
                    BytecodeManager.incBytecodes(n);
                    final NavigableSet<K> set = navigableMap.descendingKeySet();
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableSet set2 = new SynchronizedNavigableSet((NavigableSet<Object>)set, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return (NavigableSet<K>)set2;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final int n = 5;
                BytecodeManager.incBytecodes(n);
                final NavigableSet<K> set = navigableMap.descendingKeySet();
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableSet set2 = new SynchronizedNavigableSet(set, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return (NavigableSet<K>)set2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> subMap(final K k, final K i) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K j = k;
                    final boolean b = true;
                    final K l = i;
                    final boolean b2 = false;
                    final int n = 8;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.subMap(j, b, l, b2);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K j = k;
                final boolean b = true;
                final K l = i;
                final boolean b2 = false;
                final int n = 8;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final NavigableMap<K, V> navigableMap2 = navigableMap.subMap(j, b, l, b2);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> headMap(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final boolean b = false;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.headMap(i, b);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final boolean b = false;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableMap<K, V> navigableMap2 = navigableMap.headMap(i, b);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public SortedMap<K, V> tailMap(final K k) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final boolean b = true;
                    final int n = 7;
                    BytecodeManager.incBytecodes(n);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.tailMap(i, b);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n3 = 2;
                    BytecodeManager.incBytecodes(n3);
                    final int n4 = 1;
                    BytecodeManager.incBytecodes(n4);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final boolean b = true;
                final int n = 7;
                BytecodeManager.incBytecodes(n);
                final NavigableMap<K, V> navigableMap2 = navigableMap.tailMap(i, b);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K j = k;
                    final boolean b3 = b;
                    final K l = i;
                    final boolean b4 = b2;
                    final int n = 8;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.subMap(j, b3, l, b4);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K j = k;
                final boolean b3 = b;
                final K l = i;
                final boolean b4 = b2;
                final int n = 8;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final NavigableMap<K, V> navigableMap2 = navigableMap.subMap(j, b3, l, b4);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k, final boolean b) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final boolean b2 = b;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.headMap(i, b2);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final boolean b2 = b;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final NavigableMap<K, V> navigableMap2 = navigableMap.headMap(i, b2);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k, final boolean b) {
            try {
                final Object mutex = this.mutex;
                BytecodeManager.incBytecodes(5);
                try {
                    final SynchronizedNavigableMap synchronizedNavigableMap = this;
                    final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                    final K i = k;
                    final boolean b2 = b;
                    final int n = 6;
                    BytecodeManager.incBytecodes(n);
                    final int n2 = 1;
                    BytecodeManager.incBytecodes(n2);
                    final NavigableMap<K, V> navigableMap2 = navigableMap.tailMap(i, b2);
                    final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                    final Object o = synchronizedNavigableMap2.mutex;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    return synchronizedNavigableMap3;
                }
                finally {
                    BytecodeManager.incBytecodes(503);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final SynchronizedNavigableMap synchronizedNavigableMap = this;
                final NavigableMap<K, V> navigableMap = synchronizedNavigableMap.nm;
                final K i = k;
                final boolean b2 = b;
                final int n = 6;
                BytecodeManager.incBytecodes(n);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final NavigableMap<K, V> navigableMap2 = navigableMap.tailMap(i, b2);
                final SynchronizedNavigableMap synchronizedNavigableMap2 = this;
                final Object o = synchronizedNavigableMap2.mutex;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final SynchronizedNavigableMap synchronizedNavigableMap3 = new SynchronizedNavigableMap((NavigableMap<Object, Object>)navigableMap2, o);
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                return synchronizedNavigableMap3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
    }
    
    static class CheckedCollection<E> implements Collection<E>, Serializable
    {
        private static final long serialVersionUID = 1578914078182001775L;
        final Collection<E> c;
        final Class<E> type;
        private E[] zeroLengthElementArray;
        
        E typeCheck(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    final Class<E> type = this.type;
                    BytecodeManager.incBytecodes(4);
                    final boolean instance = type.isInstance(o);
                    BytecodeManager.incBytecodes(1);
                    if (!instance) {
                        BytecodeManager.incBytecodes(5);
                        final String badElementMsg = this.badElementMsg(o);
                        BytecodeManager.incBytecodes(1);
                        final ClassCastException ex = new ClassCastException(badElementMsg);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                BytecodeManager.incBytecodes(2);
                return (E)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String badElementMsg(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Attempt to insert ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final Class<?> class1 = o.getClass();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(class1);
                final String str2 = " element into collection with element type ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(type);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CheckedCollection(final Collection<E> collection, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(2);
                final String s = "c";
                BytecodeManager.incBytecodes(4);
                this.c = Objects.requireNonNull(collection, s);
                BytecodeManager.incBytecodes(2);
                final String s2 = "type";
                BytecodeManager.incBytecodes(4);
                this.type = Objects.requireNonNull(clazz, s2);
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
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final int size = c.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final boolean empty = c.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean contains = c.contains(o);
                BytecodeManager.incBytecodes(1);
                return contains;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Object[] array = c.toArray();
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final T[] array2 = c.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final String string = c.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean remove = c.remove(o);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                c.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean containsAll = c.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean removeAll = c.removeAll(collection);
                BytecodeManager.incBytecodes(1);
                return removeAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean retainAll = c.retainAll(collection);
                BytecodeManager.incBytecodes(1);
                return retainAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> iterator = c.iterator();
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator2 = iterator;
                BytecodeManager.incBytecodes(5);
                final Iterator<E> iterator3 = new Iterator<E>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public boolean hasNext() {
                        try {
                            final Iterator val$it = iterator2;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasNext = val$it.hasNext();
                            BytecodeManager.incBytecodes(1);
                            return hasNext;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E next() {
                        try {
                            final Iterator val$it = iterator2;
                            BytecodeManager.incBytecodes(3);
                            final E next = val$it.next();
                            BytecodeManager.incBytecodes(1);
                            return next;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void remove() {
                        try {
                            final Iterator val$it = iterator2;
                            BytecodeManager.incBytecodes(3);
                            val$it.remove();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return iterator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final E e) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(5);
                final E typeCheck = this.typeCheck(e);
                BytecodeManager.incBytecodes(1);
                final boolean add = c.add(typeCheck);
                BytecodeManager.incBytecodes(1);
                return add;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private E[] zeroLengthElementArray() {
            try {
                final E[] zeroLengthElementArray = this.zeroLengthElementArray;
                BytecodeManager.incBytecodes(3);
                E[] zeroLengthElementArray2;
                if (zeroLengthElementArray != null) {
                    zeroLengthElementArray2 = this.zeroLengthElementArray;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Class<E> type = this.type;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    zeroLengthElementArray2 = (this.zeroLengthElementArray = Collections.zeroLengthArray(type));
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return zeroLengthElementArray2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Collection<E> checkedCopyOf(final Collection<? extends E> collection) {
            try {
                try {
                    Object[] array2;
                    try {
                        BytecodeManager.incBytecodes(2);
                        final E[] zeroLengthElementArray = this.zeroLengthElementArray();
                        BytecodeManager.incBytecodes(1);
                        final E[] array = zeroLengthElementArray;
                        BytecodeManager.incBytecodes(3);
                        array2 = collection.toArray(array);
                        BytecodeManager.incBytecodes(1);
                        final Object[] array3 = array2;
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends Object[]> class1 = array3.getClass();
                        final E[] array4 = zeroLengthElementArray;
                        BytecodeManager.incBytecodes(2);
                        final Class<? extends Object[]> class2 = array4.getClass();
                        BytecodeManager.incBytecodes(1);
                        if (class1 != class2) {
                            final Object[] array5 = array2;
                            final int length = ((E[])array2).length;
                            final E[] array6 = zeroLengthElementArray;
                            BytecodeManager.incBytecodes(5);
                            final Class<? extends Object[]> class3 = array6.getClass();
                            BytecodeManager.incBytecodes(1);
                            array2 = Arrays.copyOf(array5, length, class3);
                            BytecodeManager.incBytecodes(1);
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (ArrayStoreException ex) {
                        BytecodeManager.incBytecodes(501);
                        BytecodeManager.incBytecodes(2);
                        final Object[] array7 = collection.toArray();
                        BytecodeManager.incBytecodes(1);
                        array2 = array7.clone();
                        BytecodeManager.incBytecodes(2);
                        final Object[] array8 = array2;
                        final int length2 = array8.length;
                        int n = 0;
                        BytecodeManager.incBytecodes(7);
                        while (true) {
                            final int n2 = n;
                            final int n3 = length2;
                            BytecodeManager.incBytecodes(3);
                            if (n2 >= n3) {
                                break;
                            }
                            final Object o = array8[n];
                            BytecodeManager.incBytecodes(4);
                            final Object o2 = o;
                            BytecodeManager.incBytecodes(3);
                            this.typeCheck(o2);
                            BytecodeManager.incBytecodes(1);
                            ++n;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    final E[] array9 = (E[])array2;
                    BytecodeManager.incBytecodes(2);
                    final List<E> list = Arrays.asList(array9);
                    BytecodeManager.incBytecodes(1);
                    return list;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(5);
                final Collection<? extends E> checkedCopy = this.checkedCopyOf(collection);
                BytecodeManager.incBytecodes(1);
                final boolean addAll = c.addAll(checkedCopy);
                BytecodeManager.incBytecodes(1);
                return addAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                c.forEach((Consumer)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(4);
                final boolean removeIf = c.removeIf(predicate);
                BytecodeManager.incBytecodes(1);
                return removeIf;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> spliterator = c.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<E> stream = c.stream();
                BytecodeManager.incBytecodes(1);
                return stream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final Stream<E> parallelStream = c.parallelStream();
                BytecodeManager.incBytecodes(1);
                return parallelStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedQueue<E> extends CheckedCollection<E> implements Queue<E>, Serializable
    {
        private static final long serialVersionUID = 1433151992604707767L;
        final Queue<E> queue;
        
        CheckedQueue(final Queue<E> queue, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(queue, clazz);
                this.queue = queue;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E element() {
            try {
                final Queue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final E element = queue.element();
                BytecodeManager.incBytecodes(1);
                return element;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Collection<E> c = this.c;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = c.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final int hashCode = c.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E peek() {
            try {
                final Queue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final E peek = queue.peek();
                BytecodeManager.incBytecodes(1);
                return peek;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E poll() {
            try {
                final Queue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final E poll = queue.poll();
                BytecodeManager.incBytecodes(1);
                return poll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E remove() {
            try {
                final Queue<E> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final E remove = queue.remove();
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean offer(final E e) {
            try {
                final Queue<E> queue = this.queue;
                BytecodeManager.incBytecodes(5);
                final E typeCheck = this.typeCheck(e);
                BytecodeManager.incBytecodes(1);
                final boolean offer = queue.offer(typeCheck);
                BytecodeManager.incBytecodes(1);
                return offer;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedSet<E> extends CheckedCollection<E> implements Set<E>, Serializable
    {
        private static final long serialVersionUID = 4694047833775013803L;
        
        CheckedSet(final Set<E> set, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(set, clazz);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Collection<E> c = this.c;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = c.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Collection<E> c = this.c;
                BytecodeManager.incBytecodes(3);
                final int hashCode = c.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E>, Serializable
    {
        private static final long serialVersionUID = 1599911165492914959L;
        private final SortedSet<E> ss;
        
        CheckedSortedSet(final SortedSet<E> ss, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(ss, clazz);
                this.ss = ss;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super E> comparator() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super E> comparator = ss.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E first() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final E first = ss.first();
                BytecodeManager.incBytecodes(1);
                return first;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E last() {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(3);
                final E last = ss.last();
                BytecodeManager.incBytecodes(1);
                return last;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(5);
                final SortedSet<E> subSet = ss.subSet(e, e2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final SortedSet<E> checkedSortedSet = Collections.checkedSortedSet(subSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedSortedSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> headSet(final E e) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(4);
                final SortedSet<E> headSet = ss.headSet(e);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final SortedSet<E> checkedSortedSet = Collections.checkedSortedSet(headSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedSortedSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> tailSet(final E e) {
            try {
                final SortedSet<E> ss = this.ss;
                BytecodeManager.incBytecodes(4);
                final SortedSet<E> tailSet = ss.tailSet(e);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final SortedSet<E> checkedSortedSet = Collections.checkedSortedSet(tailSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedSortedSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedNavigableSet<E> extends CheckedSortedSet<E> implements NavigableSet<E>, Serializable
    {
        private static final long serialVersionUID = -5429120189805438922L;
        private final NavigableSet<E> ns;
        
        CheckedNavigableSet(final NavigableSet<E> ns, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(ns, clazz);
                this.ns = ns;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E lower(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E lower = ns.lower(e);
                BytecodeManager.incBytecodes(1);
                return lower;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E floor(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E floor = ns.floor(e);
                BytecodeManager.incBytecodes(1);
                return floor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E ceiling(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E ceiling = ns.ceiling(e);
                BytecodeManager.incBytecodes(1);
                return ceiling;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E higher(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(4);
                final E higher = ns.higher(e);
                BytecodeManager.incBytecodes(1);
                return higher;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollFirst() {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(3);
                final E pollFirst = ns.pollFirst();
                BytecodeManager.incBytecodes(1);
                return pollFirst;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollLast() {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(3);
                final E pollLast = ns.pollLast();
                BytecodeManager.incBytecodes(1);
                return pollLast;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> descendingSet = ns.descendingSet();
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(descendingSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> descendingSet = ns.descendingSet();
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(descendingSet, type);
                BytecodeManager.incBytecodes(1);
                final Iterator<E> iterator = checkedNavigableSet.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final E e2) {
            try {
                final NavigableSet<E> ns = this.ns;
                final boolean b = true;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(7);
                final NavigableSet<E> subSet = ns.subSet(e, b, e2, b2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(subSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                final boolean b = false;
                BytecodeManager.incBytecodes(5);
                final NavigableSet<E> headSet = ns.headSet(e, b);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(headSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e) {
            try {
                final NavigableSet<E> ns = this.ns;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                final NavigableSet<E> tailSet = ns.tailSet(e, b);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(tailSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(7);
                final NavigableSet<E> subSet = ns.subSet(e, b, e2, b2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(subSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(5);
                final NavigableSet<E> headSet = ns.headSet(e, b);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(headSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            try {
                final NavigableSet<E> ns = this.ns;
                BytecodeManager.incBytecodes(5);
                final NavigableSet<E> tailSet = ns.tailSet(e, b);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<E> checkedNavigableSet = Collections.checkedNavigableSet(tailSet, type);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedList<E> extends CheckedCollection<E> implements List<E>
    {
        private static final long serialVersionUID = 65247728283967356L;
        final List<E> list;
        
        CheckedList(final List<E> list, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(list, clazz);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final List<E> list = this.list;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = list.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(3);
                final int hashCode = list.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int n) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final E value = list.get(n);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E remove(final int n) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final E remove = list.remove(n);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int indexOf(final Object o) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final int index = list.indexOf(o);
                BytecodeManager.incBytecodes(1);
                return index;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final int lastIndex = list.lastIndexOf(o);
                BytecodeManager.incBytecodes(1);
                return lastIndex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E set(final int n, final E e) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(6);
                final E typeCheck = this.typeCheck(e);
                BytecodeManager.incBytecodes(1);
                final E set = list.set(n, typeCheck);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void add(final int n, final E e) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(6);
                final E typeCheck = this.typeCheck(e);
                BytecodeManager.incBytecodes(1);
                list.add(n, typeCheck);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean addAll(final int n, final Collection<? extends E> collection) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(6);
                final Collection<? extends E> checkedCopy = this.checkedCopyOf(collection);
                BytecodeManager.incBytecodes(1);
                final boolean addAll = list.addAll(n, checkedCopy);
                BytecodeManager.incBytecodes(1);
                return addAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(n);
                BytecodeManager.incBytecodes(1);
                return listIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator(final int n) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                final ListIterator<E> listIterator = list.listIterator(n);
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(5);
                final ListIterator<E> listIterator3 = new ListIterator<E>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public boolean hasNext() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasNext = val$i.hasNext();
                            BytecodeManager.incBytecodes(1);
                            return hasNext;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E next() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final E next = val$i.next();
                            BytecodeManager.incBytecodes(1);
                            return next;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public boolean hasPrevious() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final boolean hasPrevious = val$i.hasPrevious();
                            BytecodeManager.incBytecodes(1);
                            return hasPrevious;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public E previous() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final E previous = val$i.previous();
                            BytecodeManager.incBytecodes(1);
                            return previous;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int nextIndex() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final int nextIndex = val$i.nextIndex();
                            BytecodeManager.incBytecodes(1);
                            return nextIndex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public int previousIndex() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            final int previousIndex = val$i.previousIndex();
                            BytecodeManager.incBytecodes(1);
                            return previousIndex;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void remove() {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(3);
                            val$i.remove();
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void set(final E e) {
                        try {
                            final ListIterator val$i = listIterator2;
                            final CheckedList this$0 = CheckedList.this;
                            BytecodeManager.incBytecodes(6);
                            final Object typeCheck = this$0.typeCheck(e);
                            BytecodeManager.incBytecodes(1);
                            val$i.set(typeCheck);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void add(final E e) {
                        try {
                            final ListIterator val$i = listIterator2;
                            final CheckedList this$0 = CheckedList.this;
                            BytecodeManager.incBytecodes(6);
                            final Object typeCheck = this$0.typeCheck(e);
                            BytecodeManager.incBytecodes(1);
                            val$i.add(typeCheck);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                    
                    @Override
                    public void forEachRemaining(final Consumer<? super E> consumer) {
                        try {
                            final ListIterator val$i = listIterator2;
                            BytecodeManager.incBytecodes(4);
                            val$i.forEachRemaining(consumer);
                            BytecodeManager.incBytecodes(1);
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                return listIterator3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(7);
                final List<E> subList = list.subList(n, n2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final CheckedList list2 = new CheckedList((List<Object>)subList, (Class<Object>)type);
                BytecodeManager.incBytecodes(1);
                return list2;
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
                final List<E> list = this.list;
                final Object o;
                final Object o2;
                final Function<Object, Object> function = e -> {
                    try {
                        BytecodeManager.incBytecodes(4);
                        unaryOperator.apply(e);
                        BytecodeManager.incBytecodes(1);
                        this.typeCheck(o);
                        BytecodeManager.incBytecodes(1);
                        return o2;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(5);
                list.replaceAll((UnaryOperator<E>)function);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void sort(final Comparator<? super E> comparator) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(4);
                list.sort(comparator);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess
    {
        private static final long serialVersionUID = 1638200125423088369L;
        
        CheckedRandomAccessList(final List<E> list, final Class<E> clazz) {
            try {
                BytecodeManager.incBytecodes(4);
                super(list, clazz);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                final List<E> list = this.list;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
                final List<E> subList = list.subList(n, n2);
                final Class<E> type = this.type;
                BytecodeManager.incBytecodes(3);
                final CheckedRandomAccessList list2 = new CheckedRandomAccessList((List<Object>)subList, (Class<Object>)type);
                BytecodeManager.incBytecodes(1);
                return list2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class CheckedMap<K, V> implements Map<K, V>, Serializable
    {
        private static final long serialVersionUID = 5742860141034234728L;
        private final Map<K, V> m;
        final Class<K> keyType;
        final Class<V> valueType;
        private transient Set<Entry<K, V>> entrySet;
        
        private void typeCheck(final Object o, final Object o2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (o != null) {
                    final Class<K> keyType = this.keyType;
                    BytecodeManager.incBytecodes(4);
                    final boolean instance = keyType.isInstance(o);
                    BytecodeManager.incBytecodes(1);
                    if (!instance) {
                        BytecodeManager.incBytecodes(5);
                        final String badKeyMsg = this.badKeyMsg(o);
                        BytecodeManager.incBytecodes(1);
                        final ClassCastException ex = new ClassCastException(badKeyMsg);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                }
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Class<V> valueType = this.valueType;
                    BytecodeManager.incBytecodes(4);
                    final boolean instance2 = valueType.isInstance(o2);
                    BytecodeManager.incBytecodes(1);
                    if (!instance2) {
                        BytecodeManager.incBytecodes(5);
                        final String badValueMsg = this.badValueMsg(o2);
                        BytecodeManager.incBytecodes(1);
                        final ClassCastException ex2 = new ClassCastException(badValueMsg);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private BiFunction<? super K, ? super V, ? extends V> typeCheck(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(biFunction);
                BytecodeManager.incBytecodes(1);
                final Object o3;
                final Object o4;
                final BiFunction<Object, Object, Object> biFunction2 = (o, o2) -> {
                    try {
                        BytecodeManager.incBytecodes(4);
                        biFunction.apply((Object)o, (Object)o2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(4);
                        this.typeCheck(o, o3);
                        BytecodeManager.incBytecodes(2);
                        return o4;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(3);
                return (BiFunction<? super K, ? super V, ? extends V>)biFunction2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String badKeyMsg(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Attempt to insert ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final Class<?> class1 = o.getClass();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(class1);
                final String str2 = " key into map with key type ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final Class<K> keyType = this.keyType;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(keyType);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String badValueMsg(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final String str = "Attempt to insert ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final Class<?> class1 = o.getClass();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append2 = append.append(class1);
                final String str2 = " value into map with value type ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(valueType);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CheckedMap(final Map<K, V> map, final Class<K> clazz, final Class<V> clazz2) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.m = Objects.requireNonNull(map);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.keyType = Objects.requireNonNull(clazz);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                this.valueType = Objects.requireNonNull(clazz2);
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
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = m.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsValue(final Object o) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = m.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V get(final Object o) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final V value = m.get(o);
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V remove(final Object o) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final V remove = m.remove(o);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<K> keySet() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Set<K> keySet = m.keySet();
                BytecodeManager.incBytecodes(1);
                return keySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Collection<V> values() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Collection<V> values = m.values();
                BytecodeManager.incBytecodes(1);
                return values;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Map<K, V> m = this.m;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = m.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int hashCode = m.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final String string = m.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V put(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(4);
                this.typeCheck(k, v);
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V put = m.put(k, v);
                BytecodeManager.incBytecodes(1);
                return put;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> map) {
            try {
                BytecodeManager.incBytecodes(2);
                final Set<Entry<? extends K, ? extends V>> entrySet = map.entrySet();
                BytecodeManager.incBytecodes(1);
                final Object[] array = entrySet.toArray();
                BytecodeManager.incBytecodes(1);
                final int length = array.length;
                BytecodeManager.incBytecodes(5);
                final ArrayList list = new ArrayList<AbstractMap.SimpleImmutableEntry<Object, Object>>(length);
                BytecodeManager.incBytecodes(1);
                final Object[] array2 = array;
                final int length2 = array2.length;
                int n = 0;
                BytecodeManager.incBytecodes(7);
                while (true) {
                    final int n2 = n;
                    final int n3 = length2;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break;
                    }
                    final Object o = array2[n];
                    BytecodeManager.incBytecodes(4);
                    final Entry<Object, Object> entry = (Entry<Object, Object>)o;
                    BytecodeManager.incBytecodes(3);
                    final Entry<Object, Object> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Entry<Object, Object> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final Object o2 = key;
                    final Object o3 = value;
                    BytecodeManager.incBytecodes(4);
                    this.typeCheck(o2, o3);
                    final ArrayList list2 = list;
                    final Object o4 = key;
                    final Object o5 = value;
                    BytecodeManager.incBytecodes(6);
                    final AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<Object, Object>(o4, o5);
                    BytecodeManager.incBytecodes(1);
                    list2.add((AbstractMap.SimpleImmutableEntry<Object, Object>)simpleImmutableEntry);
                    BytecodeManager.incBytecodes(1);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final ArrayList list3 = list;
                BytecodeManager.incBytecodes(2);
                final Iterator<AbstractMap.SimpleImmutableEntry<Object, Object>> iterator = list3.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<AbstractMap.SimpleImmutableEntry<Object, Object>> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<AbstractMap.SimpleImmutableEntry<Object, Object>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final AbstractMap.SimpleImmutableEntry<Object, Object> simpleImmutableEntry2 = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final Map<K, V> m = this.m;
                    final AbstractMap.SimpleImmutableEntry<Object, Object> simpleImmutableEntry3 = simpleImmutableEntry2;
                    BytecodeManager.incBytecodes(4);
                    final Object key2 = simpleImmutableEntry3.getKey();
                    final AbstractMap.SimpleImmutableEntry<Object, Object> simpleImmutableEntry4 = simpleImmutableEntry2;
                    BytecodeManager.incBytecodes(2);
                    final Object value2 = simpleImmutableEntry4.getValue();
                    BytecodeManager.incBytecodes(1);
                    m.put((K)key2, (V)value2);
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Entry<K, V>> entrySet() {
            try {
                final Set<Entry<K, V>> entrySet = this.entrySet;
                BytecodeManager.incBytecodes(3);
                if (entrySet == null) {
                    final Map<K, V> m = this.m;
                    BytecodeManager.incBytecodes(6);
                    final Set<Entry<K, V>> entrySet2 = m.entrySet();
                    final Class<V> valueType = this.valueType;
                    BytecodeManager.incBytecodes(3);
                    this.entrySet = new CheckedEntrySet<K, V>((Set<Entry<Object, Object>>)entrySet2, (Class<Object>)valueType);
                    BytecodeManager.incBytecodes(1);
                }
                final Set<Entry<K, V>> entrySet3 = this.entrySet;
                BytecodeManager.incBytecodes(3);
                return entrySet3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                m.forEach(biConsumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final BiFunction<? super K, ? super V, ? extends V> typeCheck = this.typeCheck(biFunction);
                BytecodeManager.incBytecodes(1);
                m.replaceAll(typeCheck);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(4);
                this.typeCheck(k, v);
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V putIfAbsent = m.putIfAbsent(k, v);
                BytecodeManager.incBytecodes(1);
                return putIfAbsent;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final boolean remove = m.remove(o, o2);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                BytecodeManager.incBytecodes(4);
                this.typeCheck(k, v2);
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(6);
                final boolean replace = m.replace(k, v, v2);
                BytecodeManager.incBytecodes(1);
                return replace;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(4);
                this.typeCheck(k, v);
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V replace = m.replace(k, v);
                BytecodeManager.incBytecodes(1);
                return replace;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(function);
                BytecodeManager.incBytecodes(1);
                final Map<K, V> m = this.m;
                final Object o2;
                final Object o3;
                final Function<Object, Object> function2 = o -> {
                    try {
                        BytecodeManager.incBytecodes(3);
                        function.apply((Object)o);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(4);
                        this.typeCheck(o, o2);
                        BytecodeManager.incBytecodes(2);
                        return o3;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(6);
                final V computeIfAbsent = m.computeIfAbsent(k, (Function<? super K, ? extends V>)function2);
                BytecodeManager.incBytecodes(1);
                return computeIfAbsent;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(6);
                final BiFunction<? super K, ? super V, ? extends V> typeCheck = this.typeCheck(biFunction);
                BytecodeManager.incBytecodes(1);
                final V computeIfPresent = m.computeIfPresent(k, typeCheck);
                BytecodeManager.incBytecodes(1);
                return computeIfPresent;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                final Map<K, V> m = this.m;
                BytecodeManager.incBytecodes(6);
                final BiFunction<? super K, ? super V, ? extends V> typeCheck = this.typeCheck(biFunction);
                BytecodeManager.incBytecodes(1);
                final V compute = m.compute(k, typeCheck);
                BytecodeManager.incBytecodes(1);
                return compute;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(biFunction);
                BytecodeManager.incBytecodes(1);
                final Map<K, V> m = this.m;
                final Object o3;
                final Object o4;
                final Object o5;
                final BiFunction<Object, Object, Object> biFunction2 = (o, o2) -> {
                    try {
                        BytecodeManager.incBytecodes(4);
                        biFunction.apply((Object)o, (Object)o2);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(4);
                        this.typeCheck(o3, o4);
                        BytecodeManager.incBytecodes(2);
                        return o5;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(7);
                final V merge = m.merge(k, v, (BiFunction<? super V, ? super V, ? extends V>)biFunction2);
                BytecodeManager.incBytecodes(1);
                return merge;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static class CheckedEntrySet<K, V> implements Set<Entry<K, V>>
        {
            private final Set<Entry<K, V>> s;
            private final Class<V> valueType;
            
            CheckedEntrySet(final Set<Entry<K, V>> s, final Class<V> valueType) {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.s = s;
                    BytecodeManager.incBytecodes(3);
                    this.valueType = valueType;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int size() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final int size = s.size();
                    BytecodeManager.incBytecodes(1);
                    return size;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean isEmpty() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final boolean empty = s.isEmpty();
                    BytecodeManager.incBytecodes(1);
                    return empty;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public String toString() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final String string = s.toString();
                    BytecodeManager.incBytecodes(1);
                    return string;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int hashCode() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final int hashCode = s.hashCode();
                    BytecodeManager.incBytecodes(1);
                    return hashCode;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void clear() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    s.clear();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean add(final Entry<K, V> entry) {
                try {
                    BytecodeManager.incBytecodes(3);
                    final UnsupportedOperationException ex = new UnsupportedOperationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean addAll(final Collection<? extends Entry<K, V>> collection) {
                try {
                    BytecodeManager.incBytecodes(3);
                    final UnsupportedOperationException ex = new UnsupportedOperationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Iterator<Entry<K, V>> iterator() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final Iterator<Entry<K, V>> iterator = s.iterator();
                    BytecodeManager.incBytecodes(1);
                    final Class<V> valueType = this.valueType;
                    BytecodeManager.incBytecodes(3);
                    final Iterator<Entry<K, V>> iterator2 = iterator;
                    final Class<V> clazz = valueType;
                    BytecodeManager.incBytecodes(6);
                    final Iterator<Entry<K, V>> iterator3 = new Iterator<Entry<K, V>>() {
                        {
                            BytecodeManager.incBytecodes(1);
                        }
                        
                        @Override
                        public boolean hasNext() {
                            try {
                                final Iterator val$i = iterator2;
                                BytecodeManager.incBytecodes(3);
                                final boolean hasNext = val$i.hasNext();
                                BytecodeManager.incBytecodes(1);
                                return hasNext;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                        
                        @Override
                        public void remove() {
                            try {
                                final Iterator val$i = iterator2;
                                BytecodeManager.incBytecodes(3);
                                val$i.remove();
                                BytecodeManager.incBytecodes(1);
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                        
                        @Override
                        public Entry<K, V> next() {
                            try {
                                final Iterator val$i = iterator2;
                                BytecodeManager.incBytecodes(3);
                                final Entry<K, V> entry = val$i.next();
                                final Class val$valueType = clazz;
                                BytecodeManager.incBytecodes(4);
                                final CheckedEntry<K, V, Object> checkedEntry = CheckedEntrySet.checkedEntry((Entry<K, V>)entry, (Class<Object>)val$valueType);
                                BytecodeManager.incBytecodes(1);
                                return checkedEntry;
                            }
                            finally {
                                throw loadexception(java.lang.Throwable.class);
                            }
                        }
                    };
                    BytecodeManager.incBytecodes(1);
                    return iterator3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Object[] toArray() {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final Object[] array = s.toArray();
                    BytecodeManager.incBytecodes(1);
                    final Class<CheckedEntry> clazz = CheckedEntry.class;
                    final Object[] array2 = array;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    BytecodeManager.incBytecodes(1);
                    final boolean instance = clazz.isInstance(componentType);
                    BytecodeManager.incBytecodes(1);
                    Object[] array3;
                    if (instance) {
                        array3 = array;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        array3 = new Object[array.length];
                        BytecodeManager.incBytecodes(2);
                    }
                    final Object[] array4 = array3;
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
                        final Object[] array5 = array4;
                        final int n3 = n;
                        final Entry entry = (Entry)array[n];
                        final Class<V> valueType = this.valueType;
                        BytecodeManager.incBytecodes(9);
                        array5[n3] = checkedEntry((Entry<Object, Object>)entry, valueType);
                        BytecodeManager.incBytecodes(1);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Object[] array6 = array4;
                    BytecodeManager.incBytecodes(2);
                    return array6;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public <T> T[] toArray(final T[] array) {
                try {
                    final Set<Entry<K, V>> s = this.s;
                    final int length = array.length;
                    BytecodeManager.incBytecodes(5);
                    T[] copy;
                    if (length == 0) {
                        copy = array;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        copy = Arrays.copyOf(array, n);
                    }
                    BytecodeManager.incBytecodes(1);
                    final T[] array2 = s.toArray(copy);
                    BytecodeManager.incBytecodes(1);
                    int n2 = 0;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n3 = n2;
                        final int length2 = array2.length;
                        BytecodeManager.incBytecodes(4);
                        if (n3 >= length2) {
                            break;
                        }
                        final T[] array3 = array2;
                        final int n4 = n2;
                        final Entry entry = (Entry)array2[n2];
                        final Class<V> valueType = this.valueType;
                        BytecodeManager.incBytecodes(9);
                        array3[n4] = (T)checkedEntry((Entry<Object, Object>)entry, valueType);
                        BytecodeManager.incBytecodes(1);
                        ++n2;
                        BytecodeManager.incBytecodes(2);
                    }
                    final int length3 = array2.length;
                    final int length4 = array.length;
                    BytecodeManager.incBytecodes(5);
                    if (length3 > length4) {
                        final T[] array4 = array2;
                        BytecodeManager.incBytecodes(2);
                        return array4;
                    }
                    final T[] array5 = array2;
                    final int n5 = 0;
                    final int n6 = 0;
                    final int length5 = array2.length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array5, n5, array, n6, length5);
                    final int length6 = array.length;
                    final int length7 = array2.length;
                    BytecodeManager.incBytecodes(5);
                    if (length6 > length7) {
                        array[array2.length] = null;
                        BytecodeManager.incBytecodes(5);
                    }
                    BytecodeManager.incBytecodes(2);
                    return array;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean contains(final Object o) {
                try {
                    final boolean b = o instanceof Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Entry entry = (Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final Set<Entry<K, V>> s = this.s;
                    final boolean b3 = entry instanceof CheckedEntry;
                    BytecodeManager.incBytecodes(5);
                    Entry checkedEntry;
                    if (b3) {
                        checkedEntry = entry;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Entry entry2 = entry;
                        final Class<V> valueType = this.valueType;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        checkedEntry = checkedEntry((Entry<Object, Object>)entry2, valueType);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean contains = s.contains(checkedEntry);
                    BytecodeManager.incBytecodes(1);
                    return contains;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean containsAll(final Collection<?> collection) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Iterator<?> iterator = collection.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<?> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final Iterator<?> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final Object next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                        final Object o = next;
                        BytecodeManager.incBytecodes(3);
                        final boolean contains = this.contains(o);
                        BytecodeManager.incBytecodes(1);
                        if (!contains) {
                            final boolean b2 = false;
                            BytecodeManager.incBytecodes(2);
                            return b2;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean remove(final Object o) {
                try {
                    final boolean b = o instanceof Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Set<Entry<K, V>> s = this.s;
                    final Entry entry = (Entry)o;
                    BytecodeManager.incBytecodes(7);
                    final AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
                    BytecodeManager.incBytecodes(1);
                    final boolean remove = s.remove(simpleImmutableEntry);
                    BytecodeManager.incBytecodes(1);
                    return remove;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean removeAll(final Collection<?> collection) {
                try {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(4);
                    final boolean batchRemove = this.batchRemove(collection, b);
                    BytecodeManager.incBytecodes(1);
                    return batchRemove;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean retainAll(final Collection<?> collection) {
                try {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(4);
                    final boolean batchRemove = this.batchRemove(collection, b);
                    BytecodeManager.incBytecodes(1);
                    return batchRemove;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private boolean batchRemove(final Collection<?> collection, final boolean b) {
                try {
                    BytecodeManager.incBytecodes(2);
                    Objects.requireNonNull(collection);
                    BytecodeManager.incBytecodes(1);
                    boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    final Iterator<Entry<K, V>> iterator = this.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<Entry<K, V>> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        final Iterator<Entry<K, V>> iterator3 = iterator;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> next = iterator3.next();
                        BytecodeManager.incBytecodes(1);
                        final boolean contains = collection.contains(next);
                        BytecodeManager.incBytecodes(2);
                        if (contains == b) {
                            continue;
                        }
                        final Iterator<Entry<K, V>> iterator4 = iterator;
                        BytecodeManager.incBytecodes(2);
                        iterator4.remove();
                        b2 = true;
                        BytecodeManager.incBytecodes(3);
                    }
                    final boolean b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean equals(final Object o) {
                try {
                    BytecodeManager.incBytecodes(3);
                    if (o == this) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final boolean b2 = o instanceof Set;
                    BytecodeManager.incBytecodes(3);
                    if (!b2) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final Set set = (Set)o;
                    BytecodeManager.incBytecodes(3);
                    final Set set2 = set;
                    BytecodeManager.incBytecodes(2);
                    final int size = set2.size();
                    final Set<Entry<K, V>> s = this.s;
                    BytecodeManager.incBytecodes(3);
                    final int size2 = s.size();
                    BytecodeManager.incBytecodes(1);
                    boolean b4 = false;
                    Label_0117: {
                        if (size == size2) {
                            final Set<?> set3 = (Set<?>)set;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                            final boolean containsAll = this.containsAll(set3);
                            BytecodeManager.incBytecodes(1);
                            if (containsAll) {
                                b4 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0117;
                            }
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            static <K, V, T> CheckedEntry<K, V, T> checkedEntry(final Entry<K, V> entry, final Class<T> clazz) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final CheckedEntry<K, V, T> checkedEntry = new CheckedEntry<K, V, T>(entry, clazz);
                    BytecodeManager.incBytecodes(1);
                    return checkedEntry;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private static class CheckedEntry<K, V, T> implements Entry<K, V>
            {
                private final Entry<K, V> e;
                private final Class<T> valueType;
                
                CheckedEntry(final Entry<K, V> entry, final Class<T> clazz) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(3);
                        this.e = Objects.requireNonNull(entry);
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(3);
                        this.valueType = Objects.requireNonNull(clazz);
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public K getKey() {
                    try {
                        final Entry<K, V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final K key = e.getKey();
                        BytecodeManager.incBytecodes(1);
                        return key;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public V getValue() {
                    try {
                        final Entry<K, V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final V value = e.getValue();
                        BytecodeManager.incBytecodes(1);
                        return value;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public int hashCode() {
                    try {
                        final Entry<K, V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final int hashCode = e.hashCode();
                        BytecodeManager.incBytecodes(1);
                        return hashCode;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public String toString() {
                    try {
                        final Entry<K, V> e = this.e;
                        BytecodeManager.incBytecodes(3);
                        final String string = e.toString();
                        BytecodeManager.incBytecodes(1);
                        return string;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public V setValue(final V value) {
                    try {
                        BytecodeManager.incBytecodes(2);
                        if (value != null) {
                            final Class<T> valueType = this.valueType;
                            BytecodeManager.incBytecodes(4);
                            final boolean instance = valueType.isInstance(value);
                            BytecodeManager.incBytecodes(1);
                            if (!instance) {
                                BytecodeManager.incBytecodes(5);
                                final String badValueMsg = this.badValueMsg(value);
                                BytecodeManager.incBytecodes(1);
                                final ClassCastException ex = new ClassCastException(badValueMsg);
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                        }
                        final Entry<K, V> e = this.e;
                        BytecodeManager.incBytecodes(4);
                        final V setValue = e.setValue(value);
                        BytecodeManager.incBytecodes(1);
                        return setValue;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                private String badValueMsg(final Object o) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Attempt to insert ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        BytecodeManager.incBytecodes(2);
                        final Class<?> class1 = o.getClass();
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append2 = append.append(class1);
                        final String str2 = " value into map with value type ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str2);
                        final Class<T> valueType = this.valueType;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append4 = append3.append(valueType);
                        BytecodeManager.incBytecodes(1);
                        final String string = append4.toString();
                        BytecodeManager.incBytecodes(1);
                        return string;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public boolean equals(final Object o) {
                    try {
                        BytecodeManager.incBytecodes(3);
                        if (o == this) {
                            final boolean b = true;
                            BytecodeManager.incBytecodes(2);
                            return b;
                        }
                        final boolean b2 = o instanceof Entry;
                        BytecodeManager.incBytecodes(3);
                        if (!b2) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                        final Entry<K, V> e = this.e;
                        final Entry entry = (Entry)o;
                        BytecodeManager.incBytecodes(7);
                        final AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(entry);
                        BytecodeManager.incBytecodes(1);
                        final boolean equals = e.equals(simpleImmutableEntry);
                        BytecodeManager.incBytecodes(1);
                        return equals;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            }
        }
    }
    
    static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V>, Serializable
    {
        private static final long serialVersionUID = 1599671320688067438L;
        private final SortedMap<K, V> sm;
        
        CheckedSortedMap(final SortedMap<K, V> sm, final Class<K> clazz, final Class<V> clazz2) {
            try {
                BytecodeManager.incBytecodes(5);
                super(sm, clazz, clazz2);
                this.sm = sm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super K> comparator = sm.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K firstKey() {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final K firstKey = sm.firstKey();
                BytecodeManager.incBytecodes(1);
                return firstKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lastKey() {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(3);
                final K lastKey = sm.lastKey();
                BytecodeManager.incBytecodes(1);
                return lastKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> subMap(final K k, final K i) {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(5);
                final SortedMap<K, V> subMap = sm.subMap(k, i);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final SortedMap<K, V> checkedSortedMap = Collections.checkedSortedMap(subMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> headMap(final K k) {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(4);
                final SortedMap<K, V> headMap = sm.headMap(k);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final SortedMap<K, V> checkedSortedMap = Collections.checkedSortedMap(headMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> tailMap(final K k) {
            try {
                final SortedMap<K, V> sm = this.sm;
                BytecodeManager.incBytecodes(4);
                final SortedMap<K, V> tailMap = sm.tailMap(k);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final SortedMap<K, V> checkedSortedMap = Collections.checkedSortedMap(tailMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedSortedMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class CheckedNavigableMap<K, V> extends CheckedSortedMap<K, V> implements NavigableMap<K, V>, Serializable
    {
        private static final long serialVersionUID = -4852462692372534096L;
        private final NavigableMap<K, V> nm;
        
        CheckedNavigableMap(final NavigableMap<K, V> nm, final Class<K> clazz, final Class<V> clazz2) {
            try {
                BytecodeManager.incBytecodes(5);
                super(nm, clazz, clazz2);
                this.nm = nm;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super Object> comparator = nm.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K firstKey() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Object firstKey = nm.firstKey();
                BytecodeManager.incBytecodes(1);
                return (K)firstKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lastKey() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Object lastKey = nm.lastKey();
                BytecodeManager.incBytecodes(1);
                return (K)lastKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lowerEntry(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> lowerEntry = nm.lowerEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = lowerEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = lowerEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lowerKey(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K lowerKey = nm.lowerKey(k);
                BytecodeManager.incBytecodes(1);
                return lowerKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> floorEntry(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> floorEntry = nm.floorEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = floorEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = floorEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K floorKey(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K floorKey = nm.floorKey(k);
                BytecodeManager.incBytecodes(1);
                return floorKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> ceilingEntry(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> ceilingEntry = nm.ceilingEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = ceilingEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = ceilingEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K ceilingKey(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K ceilingKey = nm.ceilingKey(k);
                BytecodeManager.incBytecodes(1);
                return ceilingKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> higherEntry(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final Map.Entry<K, V> higherEntry = nm.higherEntry(k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = higherEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = higherEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K higherKey(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(4);
                final K higherKey = nm.higherKey(k);
                BytecodeManager.incBytecodes(1);
                return higherKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> firstEntry() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, V> firstEntry = nm.firstEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = firstEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = firstEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> lastEntry() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, V> lastEntry = nm.lastEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = lastEntry;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry3;
                if (entry != entry2) {
                    final Map.Entry<K, V> entry4;
                    final Class<V> valueType;
                    entry3 = new CheckedEntrySet.CheckedEntry<K, V, Object>(entry4, valueType);
                    entry4 = lastEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    entry3 = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, V> pollFirstEntry = nm.pollFirstEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = pollFirstEntry;
                BytecodeManager.incBytecodes(3);
                CheckedEntrySet.CheckedEntry checkedEntry;
                if (entry == entry2) {
                    checkedEntry = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<K, V> entry3;
                    final Class<V> valueType;
                    checkedEntry = new CheckedEntrySet.CheckedEntry<K, V, Object>((Map.Entry<Object, Object>)entry3, (Class<Object>)valueType);
                    entry3 = pollFirstEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return (Map.Entry<K, V>)checkedEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> pollLastEntry() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<K, V> pollLastEntry = nm.pollLastEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> entry = null;
                final Map.Entry<K, V> entry2 = pollLastEntry;
                BytecodeManager.incBytecodes(3);
                CheckedEntrySet.CheckedEntry checkedEntry;
                if (entry == entry2) {
                    checkedEntry = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<K, V> entry3;
                    final Class<V> valueType;
                    checkedEntry = new CheckedEntrySet.CheckedEntry<K, V, Object>((Map.Entry<Object, Object>)entry3, (Class<Object>)valueType);
                    entry3 = pollLastEntry;
                    valueType = this.valueType;
                    BytecodeManager.incBytecodes(6);
                }
                BytecodeManager.incBytecodes(1);
                return (Map.Entry<K, V>)checkedEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> descendingMap() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableMap<K, V> descendingMap = nm.descendingMap();
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(descendingMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> keySet() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableSet<K> navigableKeySet = this.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                return navigableKeySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> navigableKeySet() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> navigableKeySet = nm.navigableKeySet();
                final Class<K> keyType = this.keyType;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> checkedNavigableSet = Collections.checkedNavigableSet(navigableKeySet, keyType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> descendingKeySet = nm.descendingKeySet();
                final Class<K> keyType = this.keyType;
                BytecodeManager.incBytecodes(3);
                final NavigableSet<K> checkedNavigableSet = Collections.checkedNavigableSet(descendingKeySet, keyType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableSet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final K i) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                final boolean b = true;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(7);
                final NavigableMap<K, V> subMap = nm.subMap(k, b, i, b2);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(subMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                final boolean b = false;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> headMap = nm.headMap(k, b);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(headMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                final boolean b = true;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> tailMap = nm.tailMap(k, b);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(tailMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(7);
                final NavigableMap<K, V> subMap = nm.subMap(k, b, i, b2);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(subMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k, final boolean b) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> headMap = nm.headMap(k, b);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(headMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k, final boolean b) {
            try {
                final NavigableMap<K, V> nm = this.nm;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> tailMap = nm.tailMap(k, b);
                final Class<K> keyType = this.keyType;
                final Class<V> valueType = this.valueType;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<K, V> checkedNavigableMap = Collections.checkedNavigableMap(tailMap, keyType, valueType);
                BytecodeManager.incBytecodes(1);
                return checkedNavigableMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptyIterator<E> implements Iterator<E>
    {
        static final EmptyIterator<Object> EMPTY_ITERATOR;
        
        private EmptyIterator() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E next() {
            try {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                BytecodeManager.incBytecodes(3);
                final IllegalStateException ex = new IllegalStateException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                EMPTY_ITERATOR = new EmptyIterator<Object>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptyListIterator<E> extends EmptyIterator<E> implements ListIterator<E>
    {
        static final EmptyListIterator<Object> EMPTY_ITERATOR;
        
        private EmptyListIterator() {
            try {
                final Iterator<E> iterator = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasPrevious() {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E previous() {
            try {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int nextIndex() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int previousIndex() {
            try {
                final int n = -1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                final IllegalStateException ex = new IllegalStateException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void add(final E e) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                EMPTY_ITERATOR = new EmptyListIterator<Object>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptyEnumeration<E> implements Enumeration<E>
    {
        static final EmptyEnumeration<Object> EMPTY_ENUMERATION;
        
        private EmptyEnumeration() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasMoreElements() {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E nextElement() {
            try {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                EMPTY_ENUMERATION = new EmptyEnumeration<Object>();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptySet<E> extends AbstractSet<E> implements Serializable
    {
        private static final long serialVersionUID = 1582296315990362920L;
        
        private EmptySet() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                BytecodeManager.incBytecodes(1);
                final Iterator<E> emptyIterator = Collections.emptyIterator();
                BytecodeManager.incBytecodes(1);
                return emptyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean empty = collection.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Object[] array = new Object[0];
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
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                if (length > 0) {
                    array[0] = null;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(2);
                return array;
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
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(predicate);
                BytecodeManager.incBytecodes(1);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                BytecodeManager.incBytecodes(1);
                final Spliterator<E> emptySpliterator = Spliterators.emptySpliterator();
                BytecodeManager.incBytecodes(1);
                return emptySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final Set empty_SET = Collections.EMPTY_SET;
                BytecodeManager.incBytecodes(2);
                return empty_SET;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptyList<E> extends AbstractList<E> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 8842843931221139166L;
        
        private EmptyList() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                BytecodeManager.incBytecodes(1);
                final Iterator<E> emptyIterator = Collections.emptyIterator();
                BytecodeManager.incBytecodes(1);
                return emptyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ListIterator<E> listIterator() {
            try {
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> emptyListIterator = Collections.emptyListIterator();
                BytecodeManager.incBytecodes(1);
                return emptyListIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean empty = collection.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Object[] array = new Object[0];
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
                final int length = array.length;
                BytecodeManager.incBytecodes(3);
                if (length > 0) {
                    array[0] = null;
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
        public E get(final int i) {
            try {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Index: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                final boolean b = o instanceof List;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0049: {
                    if (b) {
                        final List list = (List)o;
                        BytecodeManager.incBytecodes(3);
                        final boolean empty = list.isEmpty();
                        BytecodeManager.incBytecodes(1);
                        if (empty) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0049;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(predicate);
                BytecodeManager.incBytecodes(1);
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
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
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void sort(final Comparator<? super E> comparator) {
            try {
                BytecodeManager.incBytecodes(1);
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
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                BytecodeManager.incBytecodes(1);
                final Spliterator<E> emptySpliterator = Spliterators.emptySpliterator();
                BytecodeManager.incBytecodes(1);
                return emptySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final List empty_LIST = Collections.EMPTY_LIST;
                BytecodeManager.incBytecodes(2);
                return empty_LIST;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EmptyMap<K, V> extends AbstractMap<K, V> implements Serializable
    {
        private static final long serialVersionUID = 6428348081105594320L;
        
        private EmptyMap() {
            try {
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
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsValue(final Object o) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V get(final Object o) {
            try {
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<K> keySet() {
            try {
                BytecodeManager.incBytecodes(1);
                final Set<K> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return emptySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Collection<V> values() {
            try {
                BytecodeManager.incBytecodes(1);
                final Set<Object> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return (Collection<V>)emptySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                BytecodeManager.incBytecodes(1);
                final Set<Map.Entry<K, V>> emptySet = Collections.emptySet();
                BytecodeManager.incBytecodes(1);
                return emptySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Map;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0049: {
                    if (b) {
                        final Map map = (Map)o;
                        BytecodeManager.incBytecodes(3);
                        final boolean empty = map.isEmpty();
                        BytecodeManager.incBytecodes(1);
                        if (empty) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0049;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V getOrDefault(final Object o, final V v) {
            try {
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(biConsumer);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(biFunction);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final Map empty_MAP = Collections.EMPTY_MAP;
                BytecodeManager.incBytecodes(2);
                return empty_MAP;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class SingletonSet<E> extends AbstractSet<E> implements Serializable
    {
        private static final long serialVersionUID = 3193687207550431679L;
        private final E element;
        
        SingletonSet(final E element) {
            try {
                BytecodeManager.incBytecodes(2);
                this.element = element;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> singletonIterator = Collections.singletonIterator(element);
                BytecodeManager.incBytecodes(1);
                return singletonIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, element);
                BytecodeManager.incBytecodes(1);
                return eq;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(4);
                consumer.accept(element);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> singletonSpliterator = Collections.singletonSpliterator(element);
                BytecodeManager.incBytecodes(1);
                return singletonSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class SingletonList<E> extends AbstractList<E> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 3093736618740652951L;
        private final E element;
        
        SingletonList(final E element) {
            try {
                BytecodeManager.incBytecodes(2);
                this.element = element;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> singletonIterator = Collections.singletonIterator(element);
                BytecodeManager.incBytecodes(1);
                return singletonIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, element);
                BytecodeManager.incBytecodes(1);
                return eq;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int i) {
            try {
                BytecodeManager.incBytecodes(2);
                if (i != 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Index: ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(i);
                    final String str2 = ", Size: 1";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str2);
                    BytecodeManager.incBytecodes(1);
                    final String string = append3.toString();
                    BytecodeManager.incBytecodes(1);
                    final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                return element;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(4);
                consumer.accept(element);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final UnaryOperator<E> unaryOperator) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void sort(final Comparator<? super E> comparator) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> singletonSpliterator = Collections.singletonSpliterator(element);
                BytecodeManager.incBytecodes(1);
                return singletonSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable
    {
        private static final long serialVersionUID = -6979724477215052911L;
        private final K k;
        private final V v;
        private transient Set<K> keySet;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Collection<V> values;
        
        SingletonMap(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(2);
                this.k = k;
                BytecodeManager.incBytecodes(3);
                this.v = v;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsKey(final Object o) {
            try {
                final K k = this.k;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, k);
                BytecodeManager.incBytecodes(1);
                return eq;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsValue(final Object o) {
            try {
                final V v = this.v;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, v);
                BytecodeManager.incBytecodes(1);
                return eq;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V get(final Object o) {
            try {
                final K k = this.k;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, k);
                BytecodeManager.incBytecodes(1);
                V v;
                if (eq) {
                    v = this.v;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    v = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<K> keySet() {
            try {
                final Set<K> keySet = this.keySet;
                BytecodeManager.incBytecodes(3);
                if (keySet == null) {
                    final K k = this.k;
                    BytecodeManager.incBytecodes(4);
                    this.keySet = Collections.singleton(k);
                    BytecodeManager.incBytecodes(1);
                }
                final Set<K> keySet2 = this.keySet;
                BytecodeManager.incBytecodes(3);
                return keySet2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                final Set<Map.Entry<K, V>> entrySet = this.entrySet;
                BytecodeManager.incBytecodes(3);
                if (entrySet == null) {
                    final K k = this.k;
                    final V v = this.v;
                    BytecodeManager.incBytecodes(8);
                    final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry<K, V>(k, v);
                    BytecodeManager.incBytecodes(1);
                    this.entrySet = (Set<Map.Entry<K, V>>)Collections.singleton(simpleImmutableEntry);
                    BytecodeManager.incBytecodes(1);
                }
                final Set<Map.Entry<K, V>> entrySet2 = this.entrySet;
                BytecodeManager.incBytecodes(3);
                return entrySet2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Collection<V> values() {
            try {
                final Collection<V> values = this.values;
                BytecodeManager.incBytecodes(3);
                if (values == null) {
                    final V v = this.v;
                    BytecodeManager.incBytecodes(4);
                    this.values = Collections.singleton(v);
                    BytecodeManager.incBytecodes(1);
                }
                final Collection<V> values2 = this.values;
                BytecodeManager.incBytecodes(3);
                return values2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V getOrDefault(final Object o, final V v) {
            try {
                final K k = this.k;
                BytecodeManager.incBytecodes(4);
                final boolean eq = Collections.eq(o, k);
                BytecodeManager.incBytecodes(1);
                V v2;
                if (eq) {
                    v2 = this.v;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    v2 = v;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return v2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            try {
                final K k = this.k;
                final V v = this.v;
                BytecodeManager.incBytecodes(6);
                biConsumer.accept(k, v);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V putIfAbsent(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean replace(final K k, final V v, final V v2) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V replace(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
            try {
                BytecodeManager.incBytecodes(3);
                final UnsupportedOperationException ex = new UnsupportedOperationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class CopiesList<E> extends AbstractList<E> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 2739099268398711800L;
        final int n;
        final E element;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        CopiesList(final int n, final E element) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = CopiesList.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (n < 0) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.n = n;
                BytecodeManager.incBytecodes(3);
                this.element = element;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final int n = this.n;
                BytecodeManager.incBytecodes(3);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final int n = this.n;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (n != 0) {
                        final E element = this.element;
                        BytecodeManager.incBytecodes(4);
                        final boolean eq = Collections.eq(o, element);
                        BytecodeManager.incBytecodes(1);
                        if (eq) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0048;
                        }
                    }
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
        public int indexOf(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean contains = this.contains(o);
                BytecodeManager.incBytecodes(1);
                int n;
                if (contains) {
                    n = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean contains = this.contains(o);
                BytecodeManager.incBytecodes(1);
                int n;
                if (contains) {
                    n = this.n - 1;
                    BytecodeManager.incBytecodes(5);
                }
                else {
                    n = -1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E get(final int i) {
            try {
                BytecodeManager.incBytecodes(2);
                if (i >= 0) {
                    final int n = this.n;
                    BytecodeManager.incBytecodes(4);
                    if (i < n) {
                        final E element = this.element;
                        BytecodeManager.incBytecodes(3);
                        return element;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Index: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                final String str2 = ", Size: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final int n2 = this.n;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(n2);
                BytecodeManager.incBytecodes(1);
                final String string = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Object[] array = new Object[this.n];
                BytecodeManager.incBytecodes(3);
                final E element = this.element;
                BytecodeManager.incBytecodes(3);
                if (element != null) {
                    final Object[] array2 = array;
                    final int n = 0;
                    final int n2 = this.n;
                    final E element2 = this.element;
                    BytecodeManager.incBytecodes(7);
                    Arrays.fill(array2, n, n2, element2);
                }
                final Object[] array3 = array;
                BytecodeManager.incBytecodes(2);
                return array3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(T[] array) {
            try {
                final int n = this.n;
                BytecodeManager.incBytecodes(3);
                final int length = array.length;
                final int n2 = n;
                BytecodeManager.incBytecodes(4);
                if (length < n2) {
                    final T[] array2 = array;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends Object[]> class1 = array2.getClass();
                    BytecodeManager.incBytecodes(1);
                    final Class<?> componentType = class1.getComponentType();
                    final int length2 = n;
                    BytecodeManager.incBytecodes(2);
                    array = (T[])Array.newInstance(componentType, length2);
                    BytecodeManager.incBytecodes(3);
                    final E element = this.element;
                    BytecodeManager.incBytecodes(3);
                    if (element != null) {
                        final T[] array3 = array;
                        final int n3 = 0;
                        final int n4 = n;
                        final E element2 = this.element;
                        BytecodeManager.incBytecodes(6);
                        Arrays.fill(array3, n3, n4, element2);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                else {
                    final T[] array4 = array;
                    final int n5 = 0;
                    final int n6 = n;
                    final E element3 = this.element;
                    BytecodeManager.incBytecodes(6);
                    Arrays.fill(array4, n5, n6, element3);
                    final int length3 = array.length;
                    final int n7 = n;
                    BytecodeManager.incBytecodes(4);
                    if (length3 > n7) {
                        array[n] = null;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final T[] array5 = array;
                BytecodeManager.incBytecodes(2);
                return array5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<E> subList(final int n, final int n2) {
            try {
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "fromIndex = ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(n);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n3 = this.n;
                BytecodeManager.incBytecodes(4);
                if (n2 > n3) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb2 = new StringBuilder();
                    final String str2 = "toIndex = ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = sb2.append(str2);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = append3.append(n2);
                    BytecodeManager.incBytecodes(1);
                    final String string2 = append4.toString();
                    BytecodeManager.incBytecodes(1);
                    final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(3);
                if (n > n2) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb3 = new StringBuilder();
                    final String str3 = "fromIndex(";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append5 = sb3.append(str3);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append6 = append5.append(n);
                    final String str4 = ") > toIndex(";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append7 = append6.append(str4);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append8 = append7.append(n2);
                    final String str5 = ")";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append9 = append8.append(str5);
                    BytecodeManager.incBytecodes(1);
                    final String string3 = append9.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex3 = new IllegalArgumentException(string3);
                    BytecodeManager.incBytecodes(1);
                    throw ex3;
                }
                final int n4 = n2 - n;
                final E element = this.element;
                BytecodeManager.incBytecodes(8);
                final CopiesList list = new CopiesList(n4, element);
                BytecodeManager.incBytecodes(1);
                return list;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final int n = 0;
                final int n2 = this.n;
                BytecodeManager.incBytecodes(4);
                final IntStream range = IntStream.range(n, n2);
                Object element;
                final IntFunction<Object> intFunction = p0 -> {
                    try {
                        element = this.element;
                        BytecodeManager.incBytecodes(3);
                        return element;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(2);
                final Stream<Object> mapToObj = range.mapToObj((IntFunction<?>)intFunction);
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)mapToObj;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final int n = 0;
                final int n2 = this.n;
                BytecodeManager.incBytecodes(4);
                final IntStream range = IntStream.range(n, n2);
                BytecodeManager.incBytecodes(1);
                final IntStream parallel = range.parallel();
                Object element;
                final IntFunction<Object> intFunction = p0 -> {
                    try {
                        element = this.element;
                        BytecodeManager.incBytecodes(3);
                        return element;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(2);
                final Stream<Object> mapToObj = (Stream<Object>)parallel.mapToObj((IntFunction<? extends E>)intFunction);
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)mapToObj;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                BytecodeManager.incBytecodes(2);
                final Stream<E> stream = this.stream();
                BytecodeManager.incBytecodes(1);
                final Spliterator<E> spliterator = stream.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Collections> clazz = Collections.class;
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
    
    private static class ReverseComparator implements Comparator<Comparable<Object>>, Serializable
    {
        private static final long serialVersionUID = 7207038068494060240L;
        static final ReverseComparator REVERSE_ORDER;
        
        private ReverseComparator() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int compare(final Comparable<Object> comparable, final Comparable<Object> comparable2) {
            try {
                BytecodeManager.incBytecodes(3);
                final int compareTo = comparable2.compareTo(comparable);
                BytecodeManager.incBytecodes(1);
                return compareTo;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                BytecodeManager.incBytecodes(1);
                final Comparator<Object> reverseOrder = Collections.reverseOrder();
                BytecodeManager.incBytecodes(1);
                return reverseOrder;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<Comparable<Object>> reversed() {
            try {
                BytecodeManager.incBytecodes(1);
                final Comparator<Comparable<Object>> naturalOrder = Comparator.naturalOrder();
                BytecodeManager.incBytecodes(1);
                return naturalOrder;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                REVERSE_ORDER = new ReverseComparator();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class ReverseComparator2<T> implements Comparator<T>, Serializable
    {
        private static final long serialVersionUID = 4374092139857L;
        final Comparator<T> cmp;
        static final /* synthetic */ boolean $assertionsDisabled;
        
        ReverseComparator2(final Comparator<T> cmp) {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean $assertionsDisabled = ReverseComparator2.$assertionsDisabled;
                BytecodeManager.incBytecodes(2);
                if (!$assertionsDisabled) {
                    BytecodeManager.incBytecodes(2);
                    if (cmp == null) {
                        BytecodeManager.incBytecodes(3);
                        final AssertionError assertionError = new AssertionError();
                        BytecodeManager.incBytecodes(1);
                        throw assertionError;
                    }
                }
                this.cmp = cmp;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int compare(final T t, final T t2) {
            try {
                final Comparator<T> cmp = this.cmp;
                BytecodeManager.incBytecodes(5);
                final int compare = cmp.compare(t2, t);
                BytecodeManager.incBytecodes(1);
                return compare;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0071: {
                    Label_0056: {
                        if (o != this) {
                            final boolean b = o instanceof ReverseComparator2;
                            BytecodeManager.incBytecodes(3);
                            if (b) {
                                final Comparator<T> cmp = this.cmp;
                                final Comparator<T> cmp2 = ((ReverseComparator2)o).cmp;
                                BytecodeManager.incBytecodes(5);
                                BytecodeManager.incBytecodes(1);
                                final boolean equals = cmp.equals(cmp2);
                                BytecodeManager.incBytecodes(1);
                                if (equals) {
                                    break Label_0056;
                                }
                            }
                            b2 = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0071;
                        }
                    }
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Comparator<T> cmp = this.cmp;
                BytecodeManager.incBytecodes(3);
                final int n = cmp.hashCode() ^ Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(3);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<T> reversed() {
            try {
                final Comparator<T> cmp = this.cmp;
                BytecodeManager.incBytecodes(3);
                return cmp;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final Class<Collections> clazz = Collections.class;
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
    
    private static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable
    {
        private final Map<E, Boolean> m;
        private transient Set<E> s;
        private static final long serialVersionUID = 2454657854757543876L;
        
        SetFromMap(final Map<E, Boolean> m) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                if (!empty) {
                    final String s = "Map is non-empty";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.m = m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.s = m.keySet();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(3);
                final int size = m.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(3);
                final boolean empty = m.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = m.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(4);
                final Boolean remove = m.remove(o);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (remove != null) {
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
        public boolean add(final E e) {
            try {
                final Map<E, Boolean> m = this.m;
                final Boolean true = Boolean.TRUE;
                BytecodeManager.incBytecodes(5);
                final Boolean put = m.put(e, true);
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (put == null) {
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
        public Iterator<E> iterator() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> iterator = s.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Object[] array = s.toArray();
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                final T[] array2 = s.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final String string = s.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int hashCode() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final int hashCode = s.hashCode();
                BytecodeManager.incBytecodes(1);
                return hashCode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0048: {
                    if (o != this) {
                        final Set<E> s = this.s;
                        BytecodeManager.incBytecodes(4);
                        final boolean equals = s.equals(o);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            b = false;
                            BytecodeManager.incBytecodes(1);
                            break Label_0048;
                        }
                    }
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                final boolean containsAll = s.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                final boolean removeAll = s.removeAll(collection);
                BytecodeManager.incBytecodes(1);
                return removeAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                final boolean retainAll = s.retainAll(collection);
                BytecodeManager.incBytecodes(1);
                return retainAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                s.forEach((Consumer)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(4);
                final boolean removeIf = s.removeIf(predicate);
                BytecodeManager.incBytecodes(1);
                return removeIf;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> spliterator = s.spliterator();
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Stream<Object> stream = s.stream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)stream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final Set<E> s = this.s;
                BytecodeManager.incBytecodes(3);
                final Stream<Object> parallelStream = s.parallelStream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)parallelStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            try {
                BytecodeManager.incBytecodes(2);
                objectInputStream.defaultReadObject();
                final Map<E, Boolean> m = this.m;
                BytecodeManager.incBytecodes(4);
                this.s = m.keySet();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class AsLIFOQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable
    {
        private static final long serialVersionUID = 1802017725587941708L;
        private final Deque<E> q;
        
        AsLIFOQueue(final Deque<E> q) {
            try {
                BytecodeManager.incBytecodes(2);
                this.q = q;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean add(final E e) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                q.addFirst(e);
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean offer(final E e) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean offerFirst = q.offerFirst(e);
                BytecodeManager.incBytecodes(1);
                return offerFirst;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E poll() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final E pollFirst = q.pollFirst();
                BytecodeManager.incBytecodes(1);
                return pollFirst;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E remove() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final E removeFirst = q.removeFirst();
                BytecodeManager.incBytecodes(1);
                return removeFirst;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E peek() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final E peekFirst = q.peekFirst();
                BytecodeManager.incBytecodes(1);
                return peekFirst;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E element() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final E first = q.getFirst();
                BytecodeManager.incBytecodes(1);
                return first;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                q.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final int size = q.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isEmpty() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final boolean empty = q.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean contains = q.contains(o);
                BytecodeManager.incBytecodes(1);
                return contains;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean remove = q.remove(o);
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final Iterator<E> iterator = q.iterator();
                BytecodeManager.incBytecodes(1);
                return iterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final Object[] array = q.toArray();
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final Object[] array2 = q.toArray((Object[])array);
                BytecodeManager.incBytecodes(1);
                return (T[])array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final String string = q.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean containsAll = q.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean removeAll = q.removeAll(collection);
                BytecodeManager.incBytecodes(1);
                return removeAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean retainAll = q.retainAll(collection);
                BytecodeManager.incBytecodes(1);
                return retainAll;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                q.forEach((Consumer)consumer);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean removeIf(final Predicate<? super E> predicate) {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(4);
                final boolean removeIf = q.removeIf(predicate);
                BytecodeManager.incBytecodes(1);
                return removeIf;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<E> spliterator() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final Spliterator<Object> spliterator = q.spliterator();
                BytecodeManager.incBytecodes(1);
                return (Spliterator<E>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> stream() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final Stream<Object> stream = q.stream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)stream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Stream<E> parallelStream() {
            try {
                final Deque<E> q = this.q;
                BytecodeManager.incBytecodes(3);
                final Stream<Object> parallelStream = q.parallelStream();
                BytecodeManager.incBytecodes(1);
                return (Stream<E>)parallelStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
