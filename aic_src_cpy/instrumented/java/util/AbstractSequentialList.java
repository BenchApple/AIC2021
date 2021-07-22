// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractSequentialList<E> extends AbstractList<E>
{
    protected AbstractSequentialList() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E get(final int i) {
        try {
            try {
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(i);
                BytecodeManager.incBytecodes(1);
                final E next = listIterator.next();
                BytecodeManager.incBytecodes(1);
                return next;
            }
            catch (NoSuchElementException ex2) {
                BytecodeManager.incBytecodes(501);
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
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public E set(final int i, final E e) {
        try {
            try {
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(i);
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(2);
                final E next = listIterator2.next();
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator3 = listIterator;
                BytecodeManager.incBytecodes(3);
                listIterator3.set(e);
                final E e2 = next;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return e2;
            }
            catch (NoSuchElementException ex2) {
                BytecodeManager.incBytecodes(501);
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
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public void add(final int i, final E e) {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(3);
                    final ListIterator<E> listIterator = this.listIterator(i);
                    BytecodeManager.incBytecodes(2);
                    listIterator.add(e);
                    BytecodeManager.incBytecodes(1);
                }
                catch (NoSuchElementException ex2) {
                    BytecodeManager.incBytecodes(501);
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
                BytecodeManager.incBytecodes(1);
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
    public E remove(final int i) {
        try {
            try {
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(i);
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator2 = listIterator;
                BytecodeManager.incBytecodes(2);
                final E next = listIterator2.next();
                BytecodeManager.incBytecodes(1);
                final ListIterator<E> listIterator3 = listIterator;
                BytecodeManager.incBytecodes(2);
                listIterator3.remove();
                final E e = next;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return e;
            }
            catch (NoSuchElementException ex2) {
                BytecodeManager.incBytecodes(501);
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
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public boolean addAll(final int i, final Collection<? extends E> collection) {
        try {
            try {
                boolean b = false;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> listIterator = this.listIterator(i);
                BytecodeManager.incBytecodes(1);
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
                    final ListIterator<E> listIterator2 = listIterator;
                    final Iterator<? extends E> iterator3 = iterator;
                    BytecodeManager.incBytecodes(3);
                    final E next = (E)iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    listIterator2.add(next);
                    b = true;
                    BytecodeManager.incBytecodes(3);
                }
                final boolean b2 = b;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            catch (NoSuchElementException ex2) {
                BytecodeManager.incBytecodes(501);
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
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
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
    public abstract ListIterator<E> listIterator(final int p0);
}
