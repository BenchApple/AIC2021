// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

class JumboEnumSet<E extends Enum<E>> extends EnumSet<E>
{
    private static final long serialVersionUID = 334349849919042784L;
    private long[] elements;
    private int size;
    
    JumboEnumSet(final Class<E> clazz, final Enum<?>[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            super(clazz, array);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.elements = new long[array.length + 63 >>> 6];
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void addRange(final E e, final E e2) {
        try {
            BytecodeManager.incBytecodes(2);
            final int n = e.ordinal() >>> 6;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final int n2 = e2.ordinal() >>> 6;
            BytecodeManager.incBytecodes(3);
            final int n3 = n;
            final int n4 = n2;
            BytecodeManager.incBytecodes(3);
            if (n3 == n4) {
                final long[] elements = this.elements;
                final int n5 = n;
                final long n6 = -1L;
                BytecodeManager.incBytecodes(6);
                final int ordinal = e.ordinal();
                BytecodeManager.incBytecodes(2);
                final long n7 = n6 >>> ordinal - e2.ordinal() - 1;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                elements[n5] = n7 << e.ordinal();
                BytecodeManager.incBytecodes(3);
            }
            else {
                final long[] elements2 = this.elements;
                final int n8 = n;
                final long n9 = -1L;
                BytecodeManager.incBytecodes(6);
                elements2[n8] = n9 << e.ordinal();
                BytecodeManager.incBytecodes(2);
                int n10 = n + 1;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n11 = n10;
                    final int n12 = n2;
                    BytecodeManager.incBytecodes(3);
                    if (n11 >= n12) {
                        break;
                    }
                    this.elements[n10] = -1L;
                    BytecodeManager.incBytecodes(5);
                    ++n10;
                    BytecodeManager.incBytecodes(2);
                }
                final long[] elements3 = this.elements;
                final int n13 = n2;
                final long n14 = -1L;
                final int n15 = 63;
                BytecodeManager.incBytecodes(7);
                elements3[n13] = n14 >>> n15 - e2.ordinal();
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(3);
            final int ordinal2 = e2.ordinal();
            BytecodeManager.incBytecodes(2);
            this.size = ordinal2 - e.ordinal() + 1;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void addAll() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                this.elements[n] = -1L;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final long[] elements = this.elements;
            final int n3 = this.elements.length - 1;
            elements[n3] >>>= -this.universe.length;
            BytecodeManager.incBytecodes(15);
            this.size = this.universe.length;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void complement() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                this.elements[n] ^= -1L;
                BytecodeManager.incBytecodes(10);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final long[] elements = this.elements;
            final int n3 = this.elements.length - 1;
            elements[n3] &= -1L >>> -this.universe.length;
            BytecodeManager.incBytecodes(17);
            this.size = this.universe.length - this.size;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final EnumSetIterator<E> enumSetIterator = new EnumSetIterator<E>();
            BytecodeManager.incBytecodes(1);
            return enumSetIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (size == 0) {
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
    public boolean contains(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            final Class<?> class1 = o.getClass();
            BytecodeManager.incBytecodes(1);
            final Class<?> clazz = class1;
            final Class<E> elementType = this.elementType;
            BytecodeManager.incBytecodes(4);
            if (clazz != elementType) {
                final Class<E> clazz2 = (Class<E>)class1;
                BytecodeManager.incBytecodes(2);
                final Class<? super E> superclass = clazz2.getSuperclass();
                final Class<E> elementType2 = this.elementType;
                BytecodeManager.incBytecodes(3);
                if (superclass != elementType2) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
            }
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(3);
            final int ordinal = enum1.ordinal();
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(this.elements[ordinal >>> 6] & 1L << ordinal, 0L);
            BytecodeManager.incBytecodes(13);
            boolean b3;
            if (n != 0) {
                b3 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b3 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.typeCheck(e);
            BytecodeManager.incBytecodes(2);
            final int ordinal = e.ordinal();
            BytecodeManager.incBytecodes(1);
            final int n = ordinal >>> 6;
            BytecodeManager.incBytecodes(4);
            final long n2 = this.elements[n];
            BytecodeManager.incBytecodes(5);
            final long[] elements = this.elements;
            final int n3 = n;
            elements[n3] |= 1L << ordinal;
            BytecodeManager.incBytecodes(10);
            final long n4 = lcmp(this.elements[n], n2);
            BytecodeManager.incBytecodes(7);
            int n5;
            if (n4 != 0) {
                n5 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n5 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final int n6 = n5;
            BytecodeManager.incBytecodes(1);
            final boolean b = n6 != 0;
            BytecodeManager.incBytecodes(2);
            if (b) {
                ++this.size;
                BytecodeManager.incBytecodes(6);
            }
            final boolean b2 = n6 != 0;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            final Class<?> class1 = o.getClass();
            BytecodeManager.incBytecodes(1);
            final Class<?> clazz = class1;
            final Class<E> elementType = this.elementType;
            BytecodeManager.incBytecodes(4);
            if (clazz != elementType) {
                final Class<E> clazz2 = (Class<E>)class1;
                BytecodeManager.incBytecodes(2);
                final Class<? super E> superclass = clazz2.getSuperclass();
                final Class<E> elementType2 = this.elementType;
                BytecodeManager.incBytecodes(3);
                if (superclass != elementType2) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
            }
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(3);
            final int ordinal = enum1.ordinal();
            BytecodeManager.incBytecodes(1);
            final int n = ordinal >>> 6;
            BytecodeManager.incBytecodes(4);
            final long n2 = this.elements[n];
            BytecodeManager.incBytecodes(5);
            final long[] elements = this.elements;
            final int n3 = n;
            elements[n3] &= ~(1L << ordinal);
            BytecodeManager.incBytecodes(12);
            final long n4 = lcmp(this.elements[n], n2);
            BytecodeManager.incBytecodes(7);
            int n5;
            if (n4 != 0) {
                n5 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n5 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b3 = n5 != 0;
            BytecodeManager.incBytecodes(1);
            final boolean b4 = b3;
            BytecodeManager.incBytecodes(2);
            if (b4) {
                --this.size;
                BytecodeManager.incBytecodes(6);
            }
            final boolean b5 = b3;
            BytecodeManager.incBytecodes(2);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        try {
            final boolean b = collection instanceof JumboEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean containsAll = super.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            final JumboEnumSet<?> set = (JumboEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final JumboEnumSet<?> set2 = set;
                BytecodeManager.incBytecodes(2);
                final boolean empty = set2.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final long n3 = lcmp(set.elements[n] & ~this.elements[n], 0L);
                BytecodeManager.incBytecodes(14);
                if (n3 != 0) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                ++n;
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            final boolean b = collection instanceof JumboEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean addAll = super.addAll(collection);
                BytecodeManager.incBytecodes(1);
                return addAll;
            }
            final JumboEnumSet<? extends E> set = (JumboEnumSet<? extends E>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<? extends E> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType == elementType2) {
                int n = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int length = this.elements.length;
                    BytecodeManager.incBytecodes(5);
                    if (n2 >= length) {
                        break;
                    }
                    final long[] elements = this.elements;
                    final int n3 = n;
                    elements[n3] |= set.elements[n];
                    BytecodeManager.incBytecodes(11);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(2);
                final boolean recalculateSize = this.recalculateSize();
                BytecodeManager.incBytecodes(1);
                return recalculateSize;
            }
            final JumboEnumSet<? extends E> set2 = set;
            BytecodeManager.incBytecodes(2);
            final boolean empty = set2.isEmpty();
            BytecodeManager.incBytecodes(1);
            if (empty) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final Class<? extends E> elementType3 = set.elementType;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append = sb.append(elementType3);
            final String str = " != ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(str);
            final Class<E> elementType4 = this.elementType;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append3 = append2.append(elementType4);
            BytecodeManager.incBytecodes(1);
            final String string = append3.toString();
            BytecodeManager.incBytecodes(1);
            final ClassCastException ex = new ClassCastException(string);
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
            final boolean b = collection instanceof JumboEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean removeAll = super.removeAll(collection);
                BytecodeManager.incBytecodes(1);
                return removeAll;
            }
            final JumboEnumSet<?> set = (JumboEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                final long[] elements = this.elements;
                final int n3 = n;
                elements[n3] &= ~set.elements[n];
                BytecodeManager.incBytecodes(13);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            final boolean recalculateSize = this.recalculateSize();
            BytecodeManager.incBytecodes(1);
            return recalculateSize;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        try {
            final boolean b = collection instanceof JumboEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean retainAll = super.retainAll(collection);
                BytecodeManager.incBytecodes(1);
                return retainAll;
            }
            final JumboEnumSet<?> set = (JumboEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                boolean b2;
                if (size != 0) {
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b3 = b2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                this.clear();
                final boolean b4 = b3;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = this.elements.length;
                BytecodeManager.incBytecodes(5);
                if (n2 >= length) {
                    break;
                }
                final long[] elements = this.elements;
                final int n3 = n;
                elements[n3] &= set.elements[n];
                BytecodeManager.incBytecodes(11);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(2);
            final boolean recalculateSize = this.recalculateSize();
            BytecodeManager.incBytecodes(1);
            return recalculateSize;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final long[] elements = this.elements;
            final long n = 0L;
            BytecodeManager.incBytecodes(4);
            Arrays.fill(elements, n);
            this.size = 0;
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
            final boolean b = o instanceof JumboEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean equals = super.equals(o);
                BytecodeManager.incBytecodes(1);
                return equals;
            }
            final JumboEnumSet set = (JumboEnumSet)o;
            BytecodeManager.incBytecodes(3);
            final Class<E> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                boolean b2 = false;
                Label_0093: {
                    if (size == 0) {
                        final int size2 = set.size;
                        BytecodeManager.incBytecodes(3);
                        if (size2 == 0) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0093;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            final long[] elements = set.elements;
            final long[] elements2 = this.elements;
            BytecodeManager.incBytecodes(5);
            final boolean equals2 = Arrays.equals(elements, elements2);
            BytecodeManager.incBytecodes(1);
            return equals2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean recalculateSize() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            final long[] elements = this.elements;
            final int length = elements.length;
            int n = 0;
            BytecodeManager.incBytecodes(8);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final long n4 = elements[n];
                BytecodeManager.incBytecodes(4);
                final int size2 = this.size;
                final long i = n4;
                BytecodeManager.incBytecodes(5);
                this.size = size2 + Long.bitCount(i);
                BytecodeManager.incBytecodes(2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int size3 = this.size;
            final int n5 = size;
            BytecodeManager.incBytecodes(4);
            boolean b;
            if (size3 != n5) {
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
    public EnumSet<E> clone() {
        try {
            BytecodeManager.incBytecodes(2);
            final JumboEnumSet set = (JumboEnumSet)super.clone();
            BytecodeManager.incBytecodes(2);
            final JumboEnumSet set2 = set;
            final long[] elements = set.elements;
            BytecodeManager.incBytecodes(4);
            set2.elements = elements.clone();
            BytecodeManager.incBytecodes(2);
            final JumboEnumSet set3 = set;
            BytecodeManager.incBytecodes(2);
            return set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long[] access$000(final JumboEnumSet set) {
        try {
            final long[] elements = set.elements;
            BytecodeManager.incBytecodes(3);
            return elements;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$110(final JumboEnumSet set) {
        try {
            final int n = set.size--;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class EnumSetIterator<E extends Enum<E>> implements Iterator<E>
    {
        long unseen;
        int unseenIndex;
        long lastReturned;
        int lastReturnedIndex;
        
        EnumSetIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.unseenIndex = 0;
                BytecodeManager.incBytecodes(3);
                this.lastReturned = 0L;
                BytecodeManager.incBytecodes(3);
                this.lastReturnedIndex = 0;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.unseen = JumboEnumSet.access$000(JumboEnumSet.this)[0];
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                while (true) {
                    final long n = lcmp(this.unseen, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n != 0) {
                        break;
                    }
                    final int unseenIndex = this.unseenIndex;
                    final JumboEnumSet this$0 = JumboEnumSet.this;
                    BytecodeManager.incBytecodes(5);
                    final int n2 = JumboEnumSet.access$000(this$0).length - 1;
                    BytecodeManager.incBytecodes(4);
                    if (unseenIndex >= n2) {
                        break;
                    }
                    final JumboEnumSet this$2 = JumboEnumSet.this;
                    BytecodeManager.incBytecodes(4);
                    this.unseen = JumboEnumSet.access$000(this$2)[++this.unseenIndex];
                    BytecodeManager.incBytecodes(10);
                }
                final long n3 = lcmp(this.unseen, 0L);
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (n3 != 0) {
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
        public E next() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = this.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturned = (this.unseen & -this.unseen);
                BytecodeManager.incBytecodes(8);
                this.lastReturnedIndex = this.unseenIndex;
                BytecodeManager.incBytecodes(4);
                this.unseen -= this.lastReturned;
                BytecodeManager.incBytecodes(7);
                final Enum<?>[] universe = JumboEnumSet.this.universe;
                final int n = this.lastReturnedIndex << 6;
                final long lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                final Enum<?> enum1 = universe[n + Long.numberOfTrailingZeros(lastReturned)];
                BytecodeManager.incBytecodes(3);
                return (E)enum1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final long n = lcmp(this.lastReturned, 0L);
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final JumboEnumSet this$0 = JumboEnumSet.this;
                BytecodeManager.incBytecodes(3);
                final long n2 = JumboEnumSet.access$000(this$0)[this.lastReturnedIndex];
                BytecodeManager.incBytecodes(4);
                final JumboEnumSet this$2 = JumboEnumSet.this;
                BytecodeManager.incBytecodes(3);
                final long[] access$000 = JumboEnumSet.access$000(this$2);
                final int lastReturnedIndex = this.lastReturnedIndex;
                access$000[lastReturnedIndex] &= ~this.lastReturned;
                BytecodeManager.incBytecodes(10);
                final long n3 = n2;
                final JumboEnumSet this$3 = JumboEnumSet.this;
                BytecodeManager.incBytecodes(4);
                final long n4 = lcmp(n3, JumboEnumSet.access$000(this$3)[this.lastReturnedIndex]);
                BytecodeManager.incBytecodes(5);
                if (n4 != 0) {
                    final JumboEnumSet this$4 = JumboEnumSet.this;
                    BytecodeManager.incBytecodes(3);
                    JumboEnumSet.access$110(this$4);
                    BytecodeManager.incBytecodes(1);
                }
                this.lastReturned = 0L;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
