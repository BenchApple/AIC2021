// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class Stack<E> extends Vector<E>
{
    private static final long serialVersionUID = 1224463164541339165L;
    
    public Stack() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public E push(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addElement(e);
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized E pop() {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final E peek = this.peek();
            BytecodeManager.incBytecodes(1);
            final int n = size - 1;
            BytecodeManager.incBytecodes(5);
            this.removeElementAt(n);
            final E e = peek;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized E peek() {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(3);
                final EmptyStackException ex = new EmptyStackException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n2 = size - 1;
            BytecodeManager.incBytecodes(5);
            final E element = this.elementAt(n2);
            BytecodeManager.incBytecodes(1);
            return element;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean empty() {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(1);
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
    
    public synchronized int search(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int lastIndex = this.lastIndexOf(o);
            BytecodeManager.incBytecodes(1);
            final int n = lastIndex;
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                BytecodeManager.incBytecodes(2);
                final int n2 = this.size() - lastIndex;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            final int n3 = -1;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
