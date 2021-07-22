// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

class RegularEnumSet<E extends Enum<E>> extends EnumSet<E>
{
    private static final long serialVersionUID = 3411599620347842686L;
    private long elements;
    
    RegularEnumSet(final Class<E> clazz, final Enum<?>[] array) {
        try {
            BytecodeManager.incBytecodes(4);
            super(clazz, array);
            this.elements = 0L;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void addRange(final E e, final E e2) {
        try {
            final long n = -1L;
            BytecodeManager.incBytecodes(4);
            final int ordinal = e.ordinal();
            BytecodeManager.incBytecodes(2);
            final long n2 = n >>> ordinal - e2.ordinal() - 1;
            BytecodeManager.incBytecodes(6);
            this.elements = n2 << e.ordinal();
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void addAll() {
        try {
            final int length = this.universe.length;
            BytecodeManager.incBytecodes(4);
            if (length != 0) {
                this.elements = -1L >>> -this.universe.length;
                BytecodeManager.incBytecodes(8);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void complement() {
        try {
            final int length = this.universe.length;
            BytecodeManager.incBytecodes(4);
            if (length != 0) {
                this.elements ^= -1L;
                BytecodeManager.incBytecodes(6);
                this.elements &= -1L >>> -this.universe.length;
                BytecodeManager.incBytecodes(11);
            }
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
            final long elements = this.elements;
            BytecodeManager.incBytecodes(3);
            final int bitCount = Long.bitCount(elements);
            BytecodeManager.incBytecodes(1);
            return bitCount;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final long n = lcmp(this.elements, 0L);
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (n == 0) {
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
            final long elements = this.elements;
            final long n = 1L;
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(6);
            final long n2 = lcmp(elements & n << enum1.ordinal(), 0L);
            BytecodeManager.incBytecodes(5);
            boolean b3;
            if (n2 != 0) {
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
            final long elements = this.elements;
            BytecodeManager.incBytecodes(3);
            final long elements2 = this.elements;
            final long n = 1L;
            BytecodeManager.incBytecodes(6);
            this.elements = (elements2 | n << e.ordinal());
            BytecodeManager.incBytecodes(3);
            final long n2 = lcmp(this.elements, elements);
            BytecodeManager.incBytecodes(5);
            boolean b;
            if (n2 != 0) {
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
            final long elements = this.elements;
            BytecodeManager.incBytecodes(3);
            final long elements2 = this.elements;
            final long n = 1L;
            final Enum enum1 = (Enum)o;
            BytecodeManager.incBytecodes(7);
            this.elements = (elements2 & ~(n << enum1.ordinal()));
            BytecodeManager.incBytecodes(5);
            final long n2 = lcmp(this.elements, elements);
            BytecodeManager.incBytecodes(5);
            boolean b3;
            if (n2 != 0) {
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
    public boolean containsAll(final Collection<?> collection) {
        try {
            final boolean b = collection instanceof RegularEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean containsAll = super.containsAll(collection);
                BytecodeManager.incBytecodes(1);
                return containsAll;
            }
            final RegularEnumSet<?> set = (RegularEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final RegularEnumSet<?> set2 = set;
                BytecodeManager.incBytecodes(2);
                final boolean empty = set2.isEmpty();
                BytecodeManager.incBytecodes(1);
                return empty;
            }
            final long n = lcmp(set.elements & ~this.elements, 0L);
            BytecodeManager.incBytecodes(10);
            boolean b2;
            if (n == 0) {
                b2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
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
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            final boolean b = collection instanceof RegularEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean addAll = super.addAll(collection);
                BytecodeManager.incBytecodes(1);
                return addAll;
            }
            final RegularEnumSet<? extends E> set = (RegularEnumSet<? extends E>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<? extends E> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType == elementType2) {
                final long elements = this.elements;
                BytecodeManager.incBytecodes(3);
                this.elements |= set.elements;
                BytecodeManager.incBytecodes(7);
                final long n = lcmp(this.elements, elements);
                BytecodeManager.incBytecodes(5);
                boolean b2;
                if (n != 0) {
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            final RegularEnumSet<? extends E> set2 = set;
            BytecodeManager.incBytecodes(2);
            final boolean empty = set2.isEmpty();
            BytecodeManager.incBytecodes(1);
            if (empty) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
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
            final boolean b = collection instanceof RegularEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean removeAll = super.removeAll(collection);
                BytecodeManager.incBytecodes(1);
                return removeAll;
            }
            final RegularEnumSet<?> set = (RegularEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            final long elements = this.elements;
            BytecodeManager.incBytecodes(3);
            this.elements &= ~set.elements;
            BytecodeManager.incBytecodes(9);
            final long n = lcmp(this.elements, elements);
            BytecodeManager.incBytecodes(5);
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
    public boolean retainAll(final Collection<?> collection) {
        try {
            final boolean b = collection instanceof RegularEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean retainAll = super.retainAll(collection);
                BytecodeManager.incBytecodes(1);
                return retainAll;
            }
            final RegularEnumSet<?> set = (RegularEnumSet<?>)collection;
            BytecodeManager.incBytecodes(3);
            final Class<?> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final long n = lcmp(this.elements, 0L);
                BytecodeManager.incBytecodes(5);
                boolean b2;
                if (n != 0) {
                    b2 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b3 = b2;
                BytecodeManager.incBytecodes(1);
                this.elements = 0L;
                BytecodeManager.incBytecodes(3);
                final boolean b4 = b3;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final long elements = this.elements;
            BytecodeManager.incBytecodes(3);
            this.elements &= set.elements;
            BytecodeManager.incBytecodes(7);
            final long n2 = lcmp(this.elements, elements);
            BytecodeManager.incBytecodes(5);
            boolean b5;
            if (n2 != 0) {
                b5 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                b5 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            this.elements = 0L;
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
            final boolean b = o instanceof RegularEnumSet;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(3);
                final boolean equals = super.equals(o);
                BytecodeManager.incBytecodes(1);
                return equals;
            }
            final RegularEnumSet set = (RegularEnumSet)o;
            BytecodeManager.incBytecodes(3);
            final Class<E> elementType = set.elementType;
            final Class<E> elementType2 = this.elementType;
            BytecodeManager.incBytecodes(5);
            if (elementType != elementType2) {
                final long n = lcmp(this.elements, 0L);
                BytecodeManager.incBytecodes(5);
                boolean b2 = false;
                Label_0097: {
                    if (n == 0) {
                        final long n2 = lcmp(set.elements, 0L);
                        BytecodeManager.incBytecodes(5);
                        if (n2 == 0) {
                            b2 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0097;
                        }
                    }
                    b2 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            final long n3 = lcmp(set.elements, this.elements);
            BytecodeManager.incBytecodes(6);
            boolean b3;
            if (n3 == 0) {
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
    
    static /* synthetic */ long access$000(final RegularEnumSet set) {
        try {
            final long elements = set.elements;
            BytecodeManager.incBytecodes(3);
            return elements;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ long access$002(final RegularEnumSet set, final long elements) {
        try {
            set.elements = elements;
            BytecodeManager.incBytecodes(5);
            return elements;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private class EnumSetIterator<E extends Enum<E>> implements Iterator<E>
    {
        long unseen;
        long lastReturned;
        
        EnumSetIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.lastReturned = 0L;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.unseen = RegularEnumSet.access$000(RegularEnumSet.this);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final long n = lcmp(this.unseen, 0L);
                BytecodeManager.incBytecodes(5);
                boolean b;
                if (n != 0) {
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
                final long n = lcmp(this.unseen, 0L);
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastReturned = (this.unseen & -this.unseen);
                BytecodeManager.incBytecodes(8);
                this.unseen -= this.lastReturned;
                BytecodeManager.incBytecodes(7);
                final Enum<?>[] universe = RegularEnumSet.this.universe;
                final long lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(6);
                final Enum<?> enum1 = universe[Long.numberOfTrailingZeros(lastReturned)];
                BytecodeManager.incBytecodes(2);
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
                final RegularEnumSet this$0 = RegularEnumSet.this;
                final RegularEnumSet this$2 = RegularEnumSet.this;
                BytecodeManager.incBytecodes(5);
                final long n2 = RegularEnumSet.access$000(this$2) & ~this.lastReturned;
                BytecodeManager.incBytecodes(6);
                RegularEnumSet.access$002(this$0, n2);
                BytecodeManager.incBytecodes(1);
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
