// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

class SubList<E> extends AbstractList<E>
{
    private final AbstractList<E> l;
    private final int offset;
    private int size;
    
    SubList(final AbstractList<E> l, final int offset, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (offset < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "fromIndex = ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(offset);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final int size = l.size();
            BytecodeManager.incBytecodes(1);
            if (n > size) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "toIndex = ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append4 = append3.append(n);
                BytecodeManager.incBytecodes(1);
                final String string2 = append4.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException(string2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            if (offset > n) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb3 = new StringBuilder();
                final String str3 = "fromIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = sb3.append(str3);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(offset);
                final String str4 = ") > toIndex(";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str4);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append8 = append7.append(n);
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
            this.l = l;
            BytecodeManager.incBytecodes(3);
            this.offset = offset;
            BytecodeManager.incBytecodes(3);
            this.size = n - offset;
            BytecodeManager.incBytecodes(5);
            this.modCount = this.l.modCount;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E set(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n2 = n + this.offset;
            BytecodeManager.incBytecodes(8);
            final E set = l.set(n2, e);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E get(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n2 = n + this.offset;
            BytecodeManager.incBytecodes(7);
            final E value = l.get(n2);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n2 = n + this.offset;
            BytecodeManager.incBytecodes(8);
            l.add(n2, e);
            this.modCount = this.l.modCount;
            BytecodeManager.incBytecodes(5);
            ++this.size;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E remove(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheck(n);
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n2 = n + this.offset;
            BytecodeManager.incBytecodes(7);
            final E remove = l.remove(n2);
            BytecodeManager.incBytecodes(1);
            this.modCount = this.l.modCount;
            BytecodeManager.incBytecodes(5);
            --this.size;
            BytecodeManager.incBytecodes(6);
            final E e = remove;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void removeRange(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n3 = n + this.offset;
            final int n4 = n2 + this.offset;
            BytecodeManager.incBytecodes(11);
            l.removeRange(n3, n4);
            this.modCount = this.l.modCount;
            BytecodeManager.incBytecodes(5);
            this.size -= n2 - n;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(5);
            final boolean addAll = this.addAll(size, collection);
            BytecodeManager.incBytecodes(1);
            return addAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(final int n, final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            BytecodeManager.incBytecodes(2);
            final int size = collection.size();
            BytecodeManager.incBytecodes(1);
            final int n2 = size;
            BytecodeManager.incBytecodes(2);
            if (n2 == 0) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            final AbstractList<E> l = this.l;
            final int n3 = this.offset + n;
            BytecodeManager.incBytecodes(8);
            l.addAll(n3, collection);
            BytecodeManager.incBytecodes(1);
            this.modCount = this.l.modCount;
            BytecodeManager.incBytecodes(5);
            this.size += size;
            BytecodeManager.incBytecodes(6);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            BytecodeManager.incBytecodes(2);
            final ListIterator<E> listIterator = this.listIterator();
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
            BytecodeManager.incBytecodes(2);
            this.checkForComodification();
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            BytecodeManager.incBytecodes(5);
            final ListIterator<E> listIterator = new ListIterator<E>() {
                private final ListIterator<E> i;
                
                {
                    final SubList this$2 = SubList.this;
                    BytecodeManager.incBytecodes(4);
                    final AbstractList access$100 = SubList.access$100(this$2);
                    final int val$index2 = n;
                    final SubList this$3 = SubList.this;
                    BytecodeManager.incBytecodes(5);
                    final int n = val$index2 + SubList.access$000(this$3);
                    BytecodeManager.incBytecodes(2);
                    this.i = access$100.listIterator(n);
                    BytecodeManager.incBytecodes(2);
                }
                
                @Override
                public boolean hasNext() {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final int nextIndex = this.nextIndex();
                        final SubList this$0 = SubList.this;
                        BytecodeManager.incBytecodes(3);
                        final int access$200 = SubList.access$200(this$0);
                        BytecodeManager.incBytecodes(1);
                        boolean b;
                        if (nextIndex < access$200) {
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
                        if (hasNext) {
                            final ListIterator<E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final E next = i.next();
                            BytecodeManager.incBytecodes(1);
                            return next;
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
                public boolean hasPrevious() {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final int previousIndex = this.previousIndex();
                        BytecodeManager.incBytecodes(1);
                        boolean b;
                        if (previousIndex >= 0) {
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
                public E previous() {
                    try {
                        BytecodeManager.incBytecodes(2);
                        final boolean hasPrevious = this.hasPrevious();
                        BytecodeManager.incBytecodes(1);
                        if (hasPrevious) {
                            final ListIterator<E> i = this.i;
                            BytecodeManager.incBytecodes(3);
                            final E previous = i.previous();
                            BytecodeManager.incBytecodes(1);
                            return previous;
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
                public int nextIndex() {
                    try {
                        final ListIterator<E> i = this.i;
                        BytecodeManager.incBytecodes(3);
                        final int nextIndex = i.nextIndex();
                        final SubList this$0 = SubList.this;
                        BytecodeManager.incBytecodes(3);
                        final int n = nextIndex - SubList.access$000(this$0);
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
                        final ListIterator<E> i = this.i;
                        BytecodeManager.incBytecodes(3);
                        final int previousIndex = i.previousIndex();
                        final SubList this$0 = SubList.this;
                        BytecodeManager.incBytecodes(3);
                        final int n = previousIndex - SubList.access$000(this$0);
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void remove() {
                    try {
                        final ListIterator<E> i = this.i;
                        BytecodeManager.incBytecodes(3);
                        i.remove();
                        final SubList this$0 = SubList.this;
                        final SubList this$2 = SubList.this;
                        BytecodeManager.incBytecodes(5);
                        this$0.modCount = SubList.access$100(this$2).modCount;
                        BytecodeManager.incBytecodes(2);
                        final SubList this$3 = SubList.this;
                        BytecodeManager.incBytecodes(3);
                        SubList.access$210(this$3);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void set(final E e) {
                    try {
                        final ListIterator<E> i = this.i;
                        BytecodeManager.incBytecodes(4);
                        i.set(e);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public void add(final E e) {
                    try {
                        final ListIterator<E> i = this.i;
                        BytecodeManager.incBytecodes(4);
                        i.add(e);
                        final SubList this$0 = SubList.this;
                        final SubList this$2 = SubList.this;
                        BytecodeManager.incBytecodes(5);
                        this$0.modCount = SubList.access$100(this$2).modCount;
                        BytecodeManager.incBytecodes(2);
                        final SubList this$3 = SubList.this;
                        BytecodeManager.incBytecodes(3);
                        SubList.access$208(this$3);
                        BytecodeManager.incBytecodes(1);
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
            BytecodeManager.incBytecodes(6);
            final SubList list = new SubList((AbstractList<Object>)this, n, n2);
            BytecodeManager.incBytecodes(1);
            return list;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rangeCheck(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n < size) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final String outOfBoundsMsg = this.outOfBoundsMsg(n);
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rangeCheckForAdd(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n <= size) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final String outOfBoundsMsg = this.outOfBoundsMsg(n);
            BytecodeManager.incBytecodes(1);
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(outOfBoundsMsg);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private String outOfBoundsMsg(final int i) {
        try {
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            final String str = "Index: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(i);
            final String str2 = ", Size: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            final StringBuilder append4 = append3.append(size);
            BytecodeManager.incBytecodes(1);
            final String string = append4.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void checkForComodification() {
        try {
            final int modCount = this.modCount;
            final int modCount2 = this.l.modCount;
            BytecodeManager.incBytecodes(6);
            if (modCount != modCount2) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$000(final SubList list) {
        try {
            final int offset = list.offset;
            BytecodeManager.incBytecodes(3);
            return offset;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ AbstractList access$100(final SubList list) {
        try {
            final AbstractList<E> l = list.l;
            BytecodeManager.incBytecodes(3);
            return l;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$200(final SubList list) {
        try {
            final int size = list.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$210(final SubList list) {
        try {
            final int n = list.size--;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$208(final SubList list) {
        try {
            final int n = list.size++;
            BytecodeManager.incBytecodes(8);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
