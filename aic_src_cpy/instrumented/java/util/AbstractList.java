// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>
{
    protected transient int modCount;
    
    protected AbstractList() {
        try {
            BytecodeManager.incBytecodes(2);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final int size = this.size();
            BytecodeManager.incBytecodes(2);
            this.add(size, e);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public abstract E get(final int p0);
    
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
            BytecodeManager.incBytecodes(2);
            final ListIterator<E> listIterator = this.listIterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0143: {
                if (o == null) {
                    E next;
                    do {
                        final ListIterator<E> listIterator2 = listIterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = listIterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break Label_0143;
                        }
                        final ListIterator<E> listIterator3 = listIterator;
                        BytecodeManager.incBytecodes(2);
                        next = listIterator3.next();
                        BytecodeManager.incBytecodes(1);
                    } while (next != null);
                    final ListIterator<E> listIterator4 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final int previousIndex = listIterator4.previousIndex();
                    BytecodeManager.incBytecodes(1);
                    return previousIndex;
                }
                boolean equals;
                do {
                    final ListIterator<E> listIterator5 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = listIterator5.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break Label_0143;
                    }
                    final ListIterator<E> listIterator6 = listIterator;
                    BytecodeManager.incBytecodes(3);
                    final E next2 = listIterator6.next();
                    BytecodeManager.incBytecodes(1);
                    equals = o.equals(next2);
                    BytecodeManager.incBytecodes(1);
                } while (!equals);
                final ListIterator<E> listIterator7 = listIterator;
                BytecodeManager.incBytecodes(2);
                final int previousIndex2 = listIterator7.previousIndex();
                BytecodeManager.incBytecodes(1);
                return previousIndex2;
            }
            final int n = -1;
            BytecodeManager.incBytecodes(2);
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
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            final ListIterator<E> listIterator = this.listIterator(size);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0152: {
                if (o == null) {
                    E previous;
                    do {
                        final ListIterator<E> listIterator2 = listIterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasPrevious = listIterator2.hasPrevious();
                        BytecodeManager.incBytecodes(1);
                        if (!hasPrevious) {
                            break Label_0152;
                        }
                        final ListIterator<E> listIterator3 = listIterator;
                        BytecodeManager.incBytecodes(2);
                        previous = listIterator3.previous();
                        BytecodeManager.incBytecodes(1);
                    } while (previous != null);
                    final ListIterator<E> listIterator4 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final int nextIndex = listIterator4.nextIndex();
                    BytecodeManager.incBytecodes(1);
                    return nextIndex;
                }
                boolean equals;
                do {
                    final ListIterator<E> listIterator5 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasPrevious2 = listIterator5.hasPrevious();
                    BytecodeManager.incBytecodes(1);
                    if (!hasPrevious2) {
                        break Label_0152;
                    }
                    final ListIterator<E> listIterator6 = listIterator;
                    BytecodeManager.incBytecodes(3);
                    final E previous2 = listIterator6.previous();
                    BytecodeManager.incBytecodes(1);
                    equals = o.equals(previous2);
                    BytecodeManager.incBytecodes(1);
                } while (!equals);
                final ListIterator<E> listIterator7 = listIterator;
                BytecodeManager.incBytecodes(2);
                final int nextIndex2 = listIterator7.nextIndex();
                BytecodeManager.incBytecodes(1);
                return nextIndex2;
            }
            final int n = -1;
            BytecodeManager.incBytecodes(2);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            this.removeRange(n, size);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean addAll(int n, final Collection<? extends E> collection) {
        try {
            final int n2 = n;
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n2);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<? extends E> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<? extends E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<? extends E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final E next = (E)iterator3.next();
                BytecodeManager.incBytecodes(1);
                final int n3 = n++;
                final E e = next;
                BytecodeManager.incBytecodes(5);
                this.add(n3, e);
                b = true;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            final boolean b2 = b;
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
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final Itr itr = new Itr();
            BytecodeManager.incBytecodes(1);
            return itr;
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
            BytecodeManager.incBytecodes(3);
            this.rangeCheckForAdd(n);
            BytecodeManager.incBytecodes(5);
            final ListItr listItr = new ListItr(n);
            BytecodeManager.incBytecodes(1);
            return listItr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public List<E> subList(final int n, final int n2) {
        try {
            final boolean b = this instanceof RandomAccess;
            BytecodeManager.incBytecodes(3);
            SubList<E> list;
            if (b) {
                list = new RandomAccessSubList<E>(this, n, n2);
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            else {
                list = new SubList<E>(this, n, n2);
                BytecodeManager.incBytecodes(6);
            }
            BytecodeManager.incBytecodes(1);
            return list;
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
            final boolean b2 = o instanceof List;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            BytecodeManager.incBytecodes(2);
            final ListIterator<E> listIterator = this.listIterator();
            BytecodeManager.incBytecodes(1);
            final List list = (List)o;
            BytecodeManager.incBytecodes(3);
            final ListIterator<Object> listIterator2 = list.listIterator();
            BytecodeManager.incBytecodes(1);
            Label_0208: {
                while (true) {
                    final ListIterator<E> listIterator3 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = listIterator3.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break Label_0208;
                    }
                    final ListIterator<Object> listIterator4 = listIterator2;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = listIterator4.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break Label_0208;
                    }
                    final ListIterator<E> listIterator5 = listIterator;
                    BytecodeManager.incBytecodes(2);
                    final E next = listIterator5.next();
                    BytecodeManager.incBytecodes(1);
                    final ListIterator<Object> listIterator6 = listIterator2;
                    BytecodeManager.incBytecodes(2);
                    final Object next2 = listIterator6.next();
                    BytecodeManager.incBytecodes(1);
                    final E e = next;
                    BytecodeManager.incBytecodes(2);
                    if (e == null) {
                        final Object o2 = next2;
                        BytecodeManager.incBytecodes(2);
                        if (o2 != null) {
                            break;
                        }
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final E e2 = next;
                        final Object obj = next2;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = e2.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            break;
                        }
                    }
                    BytecodeManager.incBytecodes(1);
                }
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final ListIterator<E> listIterator7 = listIterator;
            BytecodeManager.incBytecodes(2);
            final boolean hasNext3 = listIterator7.hasNext();
            BytecodeManager.incBytecodes(1);
            boolean b5 = false;
            Label_0261: {
                if (!hasNext3) {
                    final ListIterator<Object> listIterator8 = listIterator2;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext4 = listIterator8.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext4) {
                        b5 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0261;
                    }
                }
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
    public int hashCode() {
        try {
            int n = 1;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final E next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final int n2 = 31 * n;
                final E e = next;
                BytecodeManager.incBytecodes(5);
                int hashCode;
                if (e == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final E e2 = next;
                    BytecodeManager.incBytecodes(2);
                    hashCode = e2.hashCode();
                }
                n = n2 + hashCode;
                BytecodeManager.incBytecodes(3);
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void removeRange(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final ListIterator<E> listIterator = this.listIterator(n);
            BytecodeManager.incBytecodes(1);
            int n3 = 0;
            final int n4 = n2 - n;
            BytecodeManager.incBytecodes(6);
            while (true) {
                final int n5 = n3;
                final int n6 = n4;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n6) {
                    break;
                }
                final ListIterator<E> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(2);
                listIterator2.next();
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator3 = listIterator;
                BytecodeManager.incBytecodes(2);
                listIterator3.remove();
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rangeCheckForAdd(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                BytecodeManager.incBytecodes(3);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
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
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
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
    
    private class Itr implements Iterator<E>
    {
        int cursor;
        int lastRet;
        int expectedModCount;
        final /* synthetic */ AbstractList this$0;
        
        private Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                this.cursor = 0;
                BytecodeManager.incBytecodes(3);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = AbstractList.this.modCount;
                BytecodeManager.incBytecodes(6);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean hasNext() {
            try {
                final int cursor = this.cursor;
                final AbstractList this$0 = AbstractList.this;
                BytecodeManager.incBytecodes(5);
                final int size = this$0.size();
                BytecodeManager.incBytecodes(1);
                boolean b;
                if (cursor != size) {
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
                this.checkForComodification();
                try {
                    final Itr itr = this;
                    final int n = itr.cursor;
                    final int n2 = 3;
                    BytecodeManager.incBytecodes(n2);
                    final Itr itr2 = this;
                    final AbstractList list = itr2.this$0;
                    final int n3 = n;
                    final int n4 = 4;
                    BytecodeManager.incBytecodes(n4);
                    final Object o = list.get(n3);
                    final int n5 = 1;
                    BytecodeManager.incBytecodes(n5);
                    final Itr itr3 = this;
                    final int n6 = n;
                    itr3.lastRet = n6;
                    final int n7 = 3;
                    BytecodeManager.incBytecodes(n7);
                    final Itr itr4 = this;
                    final int n8 = n;
                    final int n9 = 1;
                    final int n10 = n8 + n9;
                    itr4.cursor = n10;
                    final int n11 = 5;
                    BytecodeManager.incBytecodes(n11);
                    final Object o2 = o;
                    final int n12 = 1;
                    BytecodeManager.incBytecodes(n12);
                    final int n13 = 1;
                    BytecodeManager.incBytecodes(n13);
                    return (E)o2;
                }
                catch (IndexOutOfBoundsException ex2) {
                    BytecodeManager.incBytecodes(501);
                    final Itr itr5 = this;
                    BytecodeManager.incBytecodes(2);
                    itr5.checkForComodification();
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            finally {}
            try {
                final Itr itr = this;
                final int n = itr.cursor;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final Itr itr2 = this;
                final AbstractList list = itr2.this$0;
                final int n3 = n;
                final int n4 = 4;
                BytecodeManager.incBytecodes(n4);
                final Object o = list.get(n3);
                final int n5 = 1;
                BytecodeManager.incBytecodes(n5);
                final Itr itr3 = this;
                final int n6 = n;
                itr3.lastRet = n6;
                final int n7 = 3;
                BytecodeManager.incBytecodes(n7);
                final Itr itr4 = this;
                final int n8 = n;
                final int n9 = 1;
                final int n10 = n8 + n9;
                itr4.cursor = n10;
                final int n11 = 5;
                BytecodeManager.incBytecodes(n11);
                final Object o2 = o;
                final int n12 = 1;
                BytecodeManager.incBytecodes(n12);
                final int n13 = 1;
                BytecodeManager.incBytecodes(n13);
                return (E)o2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public void remove() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/AbstractList$Itr.lastRet:I
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifge            30
            //    12: new             Ljava/lang/IllegalStateException;
            //    15: dup            
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: athrow         
            //    30: aload_0        
            //    31: ldc             2
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokevirtual   instrumented/java/util/AbstractList$Itr.checkForComodification:()V
            //    39: aload_0        
            //    40: getfield        instrumented/java/util/AbstractList$Itr.this$0:Linstrumented/java/util/AbstractList;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/AbstractList$Itr.lastRet:I
            //    47: ldc             5
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: invokevirtual   instrumented/java/util/AbstractList.remove:(I)Ljava/lang/Object;
            //    55: pop            
            //    56: ldc             1
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: aload_0        
            //    62: getfield        instrumented/java/util/AbstractList$Itr.lastRet:I
            //    65: aload_0        
            //    66: getfield        instrumented/java/util/AbstractList$Itr.cursor:I
            //    69: ldc             5
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: if_icmpge       92
            //    77: aload_0        
            //    78: dup            
            //    79: getfield        instrumented/java/util/AbstractList$Itr.cursor:I
            //    82: iconst_1       
            //    83: isub           
            //    84: putfield        instrumented/java/util/AbstractList$Itr.cursor:I
            //    87: ldc             6
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: aload_0        
            //    93: iconst_m1      
            //    94: putfield        instrumented/java/util/AbstractList$Itr.lastRet:I
            //    97: ldc             3
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: aload_0        
            //   103: aload_0        
            //   104: getfield        instrumented/java/util/AbstractList$Itr.this$0:Linstrumented/java/util/AbstractList;
            //   107: getfield        instrumented/java/util/AbstractList.modCount:I
            //   110: putfield        instrumented/java/util/AbstractList$Itr.expectedModCount:I
            //   113: ldc             5
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: ldc             1
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: goto            150
            //   126: astore_1       
            //   127: ldc             501
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: new             Linstrumented/java/util/ConcurrentModificationException;
            //   135: dup            
            //   136: ldc             3
            //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   141: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   144: ldc             1
            //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   149: athrow         
            //   150: ldc             1
            //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   155: return         
            //   156: athrow         
            //   157: athrow         
            //    StackMapTable: 00 06 1E 3D 61 07 00 3C 17 FF 00 05 00 00 00 01 07 00 2E FF 00 00 00 00 00 01 07 00 3A
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  39     157    157    158    Ljava/lang/VirtualMachineError;
            //  39     118    126    150    Ljava/lang/IndexOutOfBoundsException;
            //  0      156    156    157    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0092:
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
        
        final void checkForComodification() {
            try {
                final int modCount = AbstractList.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
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
    }
    
    private class ListItr extends Itr implements ListIterator<E>
    {
        final /* synthetic */ AbstractList this$0;
        
        ListItr(final int cursor) {
            try {
                final Object object = null;
                BytecodeManager.incBytecodes(7);
                this.cursor = cursor;
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
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (cursor != 0) {
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
                this.checkForComodification();
                try {
                    final ListItr listItr = this;
                    final int n = listItr.cursor;
                    final int n2 = 1;
                    final int n3 = n - n2;
                    final int n4 = 5;
                    BytecodeManager.incBytecodes(n4);
                    final ListItr listItr2 = this;
                    final AbstractList list = listItr2.this$0;
                    final int n5 = n3;
                    final int n6 = 4;
                    BytecodeManager.incBytecodes(n6);
                    final Object o = list.get(n5);
                    final int n7 = 1;
                    BytecodeManager.incBytecodes(n7);
                    final ListItr listItr3 = this;
                    final ListItr listItr4 = this;
                    final int n8 = n3;
                    listItr4.cursor = n8;
                    listItr3.lastRet = n8;
                    final int n9 = 6;
                    BytecodeManager.incBytecodes(n9);
                    final Object o2 = o;
                    final int n10 = 1;
                    BytecodeManager.incBytecodes(n10);
                    final int n11 = 1;
                    BytecodeManager.incBytecodes(n11);
                    return (E)o2;
                }
                catch (IndexOutOfBoundsException ex2) {
                    BytecodeManager.incBytecodes(501);
                    final ListItr listItr5 = this;
                    BytecodeManager.incBytecodes(2);
                    listItr5.checkForComodification();
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            finally {}
            try {
                final ListItr listItr = this;
                final int n = listItr.cursor;
                final int n2 = 1;
                final int n3 = n - n2;
                final int n4 = 5;
                BytecodeManager.incBytecodes(n4);
                final ListItr listItr2 = this;
                final AbstractList list = listItr2.this$0;
                final int n5 = n3;
                final int n6 = 4;
                BytecodeManager.incBytecodes(n6);
                final Object o = list.get(n5);
                final int n7 = 1;
                BytecodeManager.incBytecodes(n7);
                final ListItr listItr3 = this;
                final ListItr listItr4 = this;
                final int n8 = n3;
                listItr4.cursor = n8;
                listItr3.lastRet = n8;
                final int n9 = 6;
                BytecodeManager.incBytecodes(n9);
                final Object o2 = o;
                final int n10 = 1;
                BytecodeManager.incBytecodes(n10);
                final int n11 = 1;
                BytecodeManager.incBytecodes(n11);
                return (E)o2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int nextIndex() {
            try {
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                return cursor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int previousIndex() {
            try {
                final int n = this.cursor - 1;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void set(final E p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/AbstractList$ListItr.lastRet:I
            //     4: ldc             3
            //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     9: ifge            30
            //    12: new             Ljava/lang/IllegalStateException;
            //    15: dup            
            //    16: ldc             3
            //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    21: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    24: ldc             1
            //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    29: athrow         
            //    30: aload_0        
            //    31: ldc             2
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokevirtual   instrumented/java/util/AbstractList$ListItr.checkForComodification:()V
            //    39: aload_0        
            //    40: getfield        instrumented/java/util/AbstractList$ListItr.this$0:Linstrumented/java/util/AbstractList;
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/AbstractList$ListItr.lastRet:I
            //    47: aload_1        
            //    48: ldc             6
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/AbstractList.set:(ILjava/lang/Object;)Ljava/lang/Object;
            //    56: pop            
            //    57: ldc             1
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: aload_0        
            //    63: aload_0        
            //    64: getfield        instrumented/java/util/AbstractList$ListItr.this$0:Linstrumented/java/util/AbstractList;
            //    67: getfield        instrumented/java/util/AbstractList.modCount:I
            //    70: putfield        instrumented/java/util/AbstractList$ListItr.expectedModCount:I
            //    73: ldc             5
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: ldc             1
            //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    83: goto            110
            //    86: astore_2       
            //    87: ldc             501
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: new             Linstrumented/java/util/ConcurrentModificationException;
            //    95: dup            
            //    96: ldc             3
            //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   101: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   104: ldc             1
            //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   109: athrow         
            //   110: ldc             1
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: return         
            //   116: athrow         
            //   117: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 05 1E 77 07 00 2F 17 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 2D
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  39     117    117    118    Ljava/lang/VirtualMachineError;
            //  39     78     86     110    Ljava/lang/IndexOutOfBoundsException;
            //  0      116    116    117    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
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
        public void add(final E p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokevirtual   instrumented/java/util/AbstractList$ListItr.checkForComodification:()V
            //     9: aload_0        
            //    10: getfield        instrumented/java/util/AbstractList$ListItr.cursor:I
            //    13: istore_2       
            //    14: ldc             3
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: aload_0        
            //    20: getfield        instrumented/java/util/AbstractList$ListItr.this$0:Linstrumented/java/util/AbstractList;
            //    23: iload_2        
            //    24: aload_1        
            //    25: ldc             5
            //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    30: invokevirtual   instrumented/java/util/AbstractList.add:(ILjava/lang/Object;)V
            //    33: aload_0        
            //    34: iconst_m1      
            //    35: putfield        instrumented/java/util/AbstractList$ListItr.lastRet:I
            //    38: ldc             3
            //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    43: aload_0        
            //    44: iload_2        
            //    45: iconst_1       
            //    46: iadd           
            //    47: putfield        instrumented/java/util/AbstractList$ListItr.cursor:I
            //    50: ldc             5
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: aload_0        
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/AbstractList$ListItr.this$0:Linstrumented/java/util/AbstractList;
            //    60: getfield        instrumented/java/util/AbstractList.modCount:I
            //    63: putfield        instrumented/java/util/AbstractList$ListItr.expectedModCount:I
            //    66: ldc             5
            //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    71: ldc             1
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: goto            103
            //    79: astore_2       
            //    80: ldc             501
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: new             Linstrumented/java/util/ConcurrentModificationException;
            //    88: dup            
            //    89: ldc             3
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //    97: ldc             1
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: athrow         
            //   103: ldc             1
            //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   108: return         
            //   109: athrow         
            //   110: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 04 F7 00 4F 07 00 2F 17 FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 2D
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                 
            //  -----  -----  -----  -----  -------------------------------------
            //  9      110    110    111    Ljava/lang/VirtualMachineError;
            //  9      71     79     103    Ljava/lang/IndexOutOfBoundsException;
            //  0      109    109    110    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
}
