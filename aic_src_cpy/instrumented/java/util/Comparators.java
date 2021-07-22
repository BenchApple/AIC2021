// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.io.Serializable;
import aic2021.engine.BytecodeManager;

class Comparators
{
    private Comparators() {
        try {
            BytecodeManager.incBytecodes(2);
            final String detailMessage = "no instances";
            BytecodeManager.incBytecodes(4);
            final AssertionError assertionError = new AssertionError((Object)detailMessage);
            BytecodeManager.incBytecodes(1);
            throw assertionError;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    enum NaturalOrderComparator implements Comparator<Comparable<Object>>
    {
        INSTANCE;
        
        private NaturalOrderComparator() {
            try {
                BytecodeManager.incBytecodes(4);
                super(name, ordinal);
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
                final int compareTo = comparable.compareTo(comparable2);
                BytecodeManager.incBytecodes(1);
                return compareTo;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<Comparable<Object>> reversed() {
            try {
                BytecodeManager.incBytecodes(1);
                final Comparator<Comparable<Object>> reverseOrder = Comparator.reverseOrder();
                BytecodeManager.incBytecodes(1);
                return reverseOrder;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String s = "INSTANCE";
                final int n = 0;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(7);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class NullComparator<T> implements Comparator<T>, Serializable
    {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        private final Comparator<T> real;
        
        NullComparator(final boolean nullFirst, final Comparator<? super T> real) {
            try {
                BytecodeManager.incBytecodes(2);
                this.nullFirst = nullFirst;
                BytecodeManager.incBytecodes(3);
                this.real = (Comparator<T>)real;
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
                BytecodeManager.incBytecodes(2);
                if (t == null) {
                    BytecodeManager.incBytecodes(2);
                    int n;
                    if (t2 == null) {
                        n = 0;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final boolean nullFirst = this.nullFirst;
                        BytecodeManager.incBytecodes(3);
                        if (nullFirst) {
                            n = -1;
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            n = 1;
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                    return n;
                }
                BytecodeManager.incBytecodes(2);
                if (t2 == null) {
                    final boolean nullFirst2 = this.nullFirst;
                    BytecodeManager.incBytecodes(3);
                    int n2;
                    if (nullFirst2) {
                        n2 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n2 = -1;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return n2;
                }
                final Comparator<T> real = this.real;
                BytecodeManager.incBytecodes(3);
                int compare;
                if (real == null) {
                    compare = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Comparator<T> real2 = this.real;
                    BytecodeManager.incBytecodes(5);
                    compare = real2.compare(t, t2);
                }
                BytecodeManager.incBytecodes(1);
                return compare;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<T> thenComparing(final Comparator<? super T> comparator) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(comparator);
                BytecodeManager.incBytecodes(1);
                final boolean nullFirst = this.nullFirst;
                final Comparator<T> real = this.real;
                BytecodeManager.incBytecodes(7);
                Comparator<? super T> thenComparing;
                if (real == null) {
                    thenComparing = comparator;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Comparator<T> real2 = this.real;
                    BytecodeManager.incBytecodes(4);
                    thenComparing = real2.thenComparing(comparator);
                }
                BytecodeManager.incBytecodes(1);
                final NullComparator nullComparator = new NullComparator(nullFirst, (Comparator<? super Object>)thenComparing);
                BytecodeManager.incBytecodes(1);
                return nullComparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<T> reversed() {
            try {
                final boolean nullFirst = this.nullFirst;
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (!nullFirst) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b = false;
                    BytecodeManager.incBytecodes(1);
                }
                final Comparator<T> real = this.real;
                BytecodeManager.incBytecodes(3);
                Comparator<T> reversed;
                if (real == null) {
                    reversed = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Comparator<T> real2 = this.real;
                    BytecodeManager.incBytecodes(3);
                    reversed = real2.reversed();
                }
                BytecodeManager.incBytecodes(1);
                final NullComparator nullComparator = new NullComparator(b, (Comparator<? super Object>)reversed);
                BytecodeManager.incBytecodes(1);
                return nullComparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
