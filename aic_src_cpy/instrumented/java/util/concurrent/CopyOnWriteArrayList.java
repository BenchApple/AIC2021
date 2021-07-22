// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.ConcurrentModificationException;
import instrumented.java.util.AbstractList;
import instrumented.java.util.Objects;
import instrumented.java.util.NoSuchElementException;
import java.lang.reflect.Field;
import instrumented.java.util.Spliterators;
import instrumented.java.util.Spliterator;
import instrumented.java.util.ListIterator;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.Comparator;
import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.function.Consumer;
import java.util.Iterator;
import instrumented.java.util.Arrays;
import instrumented.java.util.Collection;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import instrumented.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;
import instrumented.java.util.RandomAccess;
import instrumented.java.util.List;

public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable
{
    private static final long serialVersionUID = 8673264195747942595L;
    final transient ReentrantLock lock;
    private transient volatile Object[] array;
    private static final Unsafe UNSAFE;
    private static final long lockOffset;
    
    final Object[] getArray() {
        try {
            final Object[] array = this.array;
            BytecodeManager.incBytecodes(3);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void setArray(final Object[] array) {
        try {
            this.array = array;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CopyOnWriteArrayList() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.lock = new ReentrantLock();
            BytecodeManager.incBytecodes(1);
            final Object[] array = new Object[0];
            BytecodeManager.incBytecodes(3);
            this.setArray(array);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CopyOnWriteArrayList(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.lock = new ReentrantLock();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Class<? extends CopyOnWriteArrayList> class1 = ((CopyOnWriteArrayList<? extends E>)collection).getClass();
            final Class<CopyOnWriteArrayList> clazz = CopyOnWriteArrayList.class;
            BytecodeManager.incBytecodes(2);
            Object[] array;
            if (class1 == clazz) {
                final CopyOnWriteArrayList<? extends E> list = (CopyOnWriteArrayList<? extends E>)collection;
                BytecodeManager.incBytecodes(3);
                array = list.getArray();
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                array = collection.toArray();
                BytecodeManager.incBytecodes(1);
                final Object[] array2 = array;
                BytecodeManager.incBytecodes(2);
                final Class<? extends Object[]> class2 = array2.getClass();
                final Class<Object[]> clazz2 = Object[].class;
                BytecodeManager.incBytecodes(2);
                if (class2 != clazz2) {
                    final Object[] array3 = array;
                    final int length = array.length;
                    final Class<Object[]> clazz3 = Object[].class;
                    BytecodeManager.incBytecodes(5);
                    array = Arrays.copyOf(array3, length, (Class<? extends Object[]>)clazz3);
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Object[] array4 = array;
            BytecodeManager.incBytecodes(3);
            this.setArray(array4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public CopyOnWriteArrayList(final E[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.lock = new ReentrantLock();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            final Class<Object[]> clazz = Object[].class;
            BytecodeManager.incBytecodes(6);
            final Object[] copy = Arrays.copyOf(array, length, (Class<? extends Object[]>)clazz);
            BytecodeManager.incBytecodes(1);
            this.setArray(copy);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            BytecodeManager.incBytecodes(2);
            final int length = this.getArray().length;
            BytecodeManager.incBytecodes(2);
            return length;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
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
    
    private static boolean eq(final Object o, final Object obj) {
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
    
    private static int indexOf(final Object o, final Object[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n3 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n4 >= n2) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = array[n3];
                    BytecodeManager.incBytecodes(4);
                    if (o2 == null) {
                        final int n5 = n3;
                        BytecodeManager.incBytecodes(2);
                        return n5;
                    }
                    ++n3;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n6 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n7 = n6;
                    BytecodeManager.incBytecodes(3);
                    if (n7 >= n2) {
                        break;
                    }
                    final Object obj = array[n6];
                    BytecodeManager.incBytecodes(5);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n8 = n6;
                        BytecodeManager.incBytecodes(2);
                        return n8;
                    }
                    ++n6;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n9 = -1;
            BytecodeManager.incBytecodes(2);
            return n9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int lastIndexOf(final Object o, final Object[] array, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n2 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n3 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = array[n2];
                    BytecodeManager.incBytecodes(4);
                    if (o2 == null) {
                        final int n4 = n2;
                        BytecodeManager.incBytecodes(2);
                        return n4;
                    }
                    --n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n5 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    BytecodeManager.incBytecodes(2);
                    if (n6 < 0) {
                        break;
                    }
                    final Object obj = array[n5];
                    BytecodeManager.incBytecodes(5);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n7 = n5;
                        BytecodeManager.incBytecodes(2);
                        return n7;
                    }
                    --n5;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n8 = -1;
            BytecodeManager.incBytecodes(2);
            return n8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int index = indexOf(o, array2, n, length);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (index >= 0) {
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
    public int indexOf(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int index = indexOf(o, array2, n, length);
            BytecodeManager.incBytecodes(1);
            return index;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int indexOf(final E e, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int index = indexOf(e, array2, n, length);
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
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int n = array.length - 1;
            BytecodeManager.incBytecodes(7);
            final int lastIndex = lastIndexOf(o, array2, n);
            BytecodeManager.incBytecodes(1);
            return lastIndex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int lastIndexOf(final E e, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            BytecodeManager.incBytecodes(4);
            final int lastIndex = lastIndexOf(e, array2, n);
            BytecodeManager.incBytecodes(1);
            return lastIndex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final CopyOnWriteArrayList list = (CopyOnWriteArrayList)super.clone();
                BytecodeManager.incBytecodes(2);
                final CopyOnWriteArrayList list2 = list;
                BytecodeManager.incBytecodes(2);
                list2.resetLock();
                final CopyOnWriteArrayList list3 = list;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return list3;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
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
    public Object[] toArray() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            final Object[] copy = Arrays.copyOf(array2, length);
            BytecodeManager.incBytecodes(1);
            return copy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array2 = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array2.length;
            BytecodeManager.incBytecodes(3);
            final int length2 = array.length;
            final int n = length;
            BytecodeManager.incBytecodes(4);
            if (length2 < n) {
                final Object[] array3 = array2;
                final int n2 = length;
                BytecodeManager.incBytecodes(4);
                final Class<? extends Object[]> class1 = array.getClass();
                BytecodeManager.incBytecodes(1);
                final T[] array4 = Arrays.copyOf(array3, n2, (Class<? extends T[]>)class1);
                BytecodeManager.incBytecodes(2);
                return array4;
            }
            final Object[] array5 = array2;
            final int n3 = 0;
            final int n4 = 0;
            final int n5 = length;
            BytecodeManager.incBytecodes(6);
            System.arraycopy(array5, n3, array, n4, n5);
            final int length3 = array.length;
            final int n6 = length;
            BytecodeManager.incBytecodes(4);
            if (length3 > n6) {
                array[length] = null;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E get(final Object[] array, final int n) {
        try {
            final Object o = array[n];
            BytecodeManager.incBytecodes(4);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E get(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(2);
            final E value = this.get(array, n);
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E set(final int p0, final E p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_3        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload_0        
        //    36: aload           4
        //    38: iload_1        
        //    39: ldc             4
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList.get:([Ljava/lang/Object;I)Ljava/lang/Object;
        //    47: astore          5
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: aload           5
        //    56: aload_2        
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_acmpeq       123
        //    65: aload           4
        //    67: arraylength    
        //    68: istore          6
        //    70: ldc             3
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: aload           4
        //    77: iload           6
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    87: astore          7
        //    89: ldc             1
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: aload           7
        //    96: iload_1        
        //    97: aload_2        
        //    98: aastore        
        //    99: ldc             4
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: aload_0        
        //   105: aload           7
        //   107: ldc             3
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: goto            134
        //   123: aload_0        
        //   124: aload           4
        //   126: ldc             3
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   134: aload           5
        //   136: astore          6
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: aload_3        
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   152: aload           6
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: areturn        
        //   160: astore          8
        //   162: ldc             501
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: aload_3        
        //   168: ldc             2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   176: aload           8
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: athrow         
        //   184: athrow         
        //   185: athrow         
        //    Signature:
        //  (ITE;)TE;
        //    StackMapTable: 00 05 FE 00 7B 07 00 3B 07 00 4E 07 00 05 0A FF 00 19 00 04 07 00 02 01 07 00 05 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     185    185    186    Ljava/lang/VirtualMachineError;
        //  19     143    160    184    Any
        //  160    167    160    184    Any
        //  0      184    184    185    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0123:
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
    public boolean add(final E e) {
        ReentrantLock lock;
        try {
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final CopyOnWriteArrayList list = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Object[] array = list.getArray();
                final boolean b = true;
                BytecodeManager.incBytecodes(b ? 1 : 0);
                final Object[] array2 = array;
                final int n2 = array2.length;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final Object[] array3 = array;
                final int n4 = n2;
                final int n5 = 1;
                final int n6 = n4 + n5;
                final int n7 = 5;
                BytecodeManager.incBytecodes(n7);
                final Object[] array4 = Arrays.copyOf(array3, n6);
                final boolean b2 = true;
                BytecodeManager.incBytecodes(b2 ? 1 : 0);
                final Object[] array5 = array4;
                final int n8 = n2;
                final E e2 = e;
                array5[n8] = e2;
                final int n9 = 4;
                BytecodeManager.incBytecodes(n9);
                final CopyOnWriteArrayList list2 = this;
                final Object[] array6 = array4;
                final int n10 = 3;
                BytecodeManager.incBytecodes(n10);
                list2.setArray(array6);
                final int n11 = 1;
                final int n12 = 2;
                BytecodeManager.incBytecodes(n12);
                final ReentrantLock reentrantLock2 = lock;
                final int n13 = 2;
                BytecodeManager.incBytecodes(n13);
                reentrantLock2.unlock();
                final int n14 = n11;
                final int n15 = 2;
                BytecodeManager.incBytecodes(n15);
                return n14 != 0;
            }
            finally {
                BytecodeManager.incBytecodes(501);
                final ReentrantLock reentrantLock3 = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock3.unlock();
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {}
        try {
            final CopyOnWriteArrayList list = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Object[] array = list.getArray();
            final boolean b = true;
            BytecodeManager.incBytecodes(b ? 1 : 0);
            final Object[] array2 = array;
            final int n2 = array2.length;
            final int n3 = 3;
            BytecodeManager.incBytecodes(n3);
            final Object[] array3 = array;
            final int n4 = n2;
            final int n5 = 1;
            final int n6 = n4 + n5;
            final int n7 = 5;
            BytecodeManager.incBytecodes(n7);
            final Object[] array4 = Arrays.copyOf(array3, n6);
            final boolean b2 = true;
            BytecodeManager.incBytecodes(b2 ? 1 : 0);
            final Object[] array5 = array4;
            final int n8 = n2;
            final E e2 = e;
            array5[n8] = e2;
            final int n9 = 4;
            BytecodeManager.incBytecodes(n9);
            final CopyOnWriteArrayList list2 = this;
            final Object[] array6 = array4;
            final int n10 = 3;
            BytecodeManager.incBytecodes(n10);
            list2.setArray(array6);
            final int n11 = 1;
            final int n12 = 2;
            BytecodeManager.incBytecodes(n12);
            final ReentrantLock reentrantLock2 = lock;
            final int n13 = 2;
            BytecodeManager.incBytecodes(n13);
            reentrantLock2.unlock();
            final int n14 = n11;
            final int n15 = 2;
            BytecodeManager.incBytecodes(n15);
            return n14 != 0;
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
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_3        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload           4
        //    37: arraylength    
        //    38: istore          5
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: iload_1        
        //    46: iload           5
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: if_icmpgt       65
        //    56: iload_1        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifge            142
        //    65: new             Ljava/lang/IndexOutOfBoundsException;
        //    68: dup            
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: ldc             5
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokespecial   java/lang/StringBuilder.<init>:()V
        //    81: ldc             "Index: "
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    91: iload_1        
        //    92: ldc             2
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   100: ldc             ", Size: "
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: iload           5
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   128: ldc             1
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokespecial   java/lang/IndexOutOfBoundsException.<init>:(Ljava/lang/String;)V
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: athrow         
        //   142: iload           5
        //   144: iload_1        
        //   145: isub           
        //   146: istore          7
        //   148: ldc             4
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: iload           7
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: ifne            187
        //   163: aload           4
        //   165: iload           5
        //   167: iconst_1       
        //   168: iadd           
        //   169: ldc             5
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   177: astore          6
        //   179: ldc             2
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: goto            234
        //   187: iload           5
        //   189: iconst_1       
        //   190: iadd           
        //   191: anewarray       Ljava/lang/Object;
        //   194: astore          6
        //   196: ldc             4
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: aload           4
        //   203: iconst_0       
        //   204: aload           6
        //   206: iconst_0       
        //   207: iload_1        
        //   208: ldc             6
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   216: aload           4
        //   218: iload_1        
        //   219: aload           6
        //   221: iload_1        
        //   222: iconst_1       
        //   223: iadd           
        //   224: iload           7
        //   226: ldc             8
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   234: aload           6
        //   236: iload_1        
        //   237: aload_2        
        //   238: aastore        
        //   239: ldc             4
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_0        
        //   245: aload           6
        //   247: ldc             3
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   255: aload_3        
        //   256: ldc             2
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   264: ldc             1
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: goto            296
        //   272: astore          8
        //   274: ldc             501
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: aload_3        
        //   280: ldc             2
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   288: aload           8
        //   290: ldc             2
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: athrow         
        //   296: ldc             1
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: return         
        //   302: athrow         
        //   303: athrow         
        //    Signature:
        //  (ITE;)V
        //    StackMapTable: 00 08 FE 00 41 07 00 3B 07 00 4E 01 FB 00 4C FD 00 2C 00 01 FF 00 2E 00 08 07 00 02 01 07 00 05 07 00 3B 07 00 4E 01 07 00 4E 01 00 00 FF 00 25 00 04 07 00 02 01 07 00 05 07 00 3B 00 01 07 00 31 17 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     303    303    304    Ljava/lang/VirtualMachineError;
        //  19     255    272    296    Any
        //  272    279    272    296    Any
        //  0      302    302    303    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0065:
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
    public E remove(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_2       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_2        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore_3       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: aload_3        
        //    35: arraylength    
        //    36: istore          4
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: aload_0        
        //    44: aload_3        
        //    45: iload_1        
        //    46: ldc             4
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList.get:([Ljava/lang/Object;I)Ljava/lang/Object;
        //    54: astore          5
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: iload           4
        //    63: iload_1        
        //    64: isub           
        //    65: iconst_1       
        //    66: isub           
        //    67: istore          6
        //    69: ldc             6
        //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    74: iload           6
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifne            114
        //    84: aload_0        
        //    85: aload_3        
        //    86: iload           4
        //    88: iconst_1       
        //    89: isub           
        //    90: ldc             6
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: goto            170
        //   114: iload           4
        //   116: iconst_1       
        //   117: isub           
        //   118: anewarray       Ljava/lang/Object;
        //   121: astore          7
        //   123: ldc             4
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: aload_3        
        //   129: iconst_0       
        //   130: aload           7
        //   132: iconst_0       
        //   133: iload_1        
        //   134: ldc             6
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   142: aload_3        
        //   143: iload_1        
        //   144: iconst_1       
        //   145: iadd           
        //   146: aload           7
        //   148: iload_1        
        //   149: iload           6
        //   151: ldc             8
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   159: aload_0        
        //   160: aload           7
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   170: aload           5
        //   172: astore          7
        //   174: ldc             2
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: aload_2        
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   188: aload           7
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: areturn        
        //   196: astore          8
        //   198: ldc             501
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: aload_2        
        //   204: ldc             2
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   212: aload           8
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: athrow         
        //   220: athrow         
        //   221: athrow         
        //    Signature:
        //  (I)TE;
        //    StackMapTable: 00 05 FF 00 72 00 07 07 00 02 01 07 00 3B 07 00 4E 01 07 00 05 01 00 00 37 FF 00 19 00 03 07 00 02 01 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     221    221    222    Ljava/lang/VirtualMachineError;
        //  19     179    196    220    Any
        //  196    203    196    220    Any
        //  0      220    220    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0114:
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
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int index = indexOf(o, array2, n, length);
            BytecodeManager.incBytecodes(1);
            final int n2 = index;
            BytecodeManager.incBytecodes(2);
            boolean remove;
            if (n2 < 0) {
                remove = false;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Object[] array3 = array;
                final int n3 = index;
                BytecodeManager.incBytecodes(5);
                remove = this.remove(o, array3, n3);
            }
            BytecodeManager.incBytecodes(1);
            return remove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean remove(final Object p0, final Object[] p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore          4
        //     6: ldc             3
        //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    11: aload           4
        //    13: ldc             2
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    21: aload_0        
        //    22: ldc             2
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    30: astore          5
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload           5
        //    39: arraylength    
        //    40: istore          6
        //    42: ldc             3
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload_2        
        //    48: aload           5
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: if_acmpeq       275
        //    58: iload_3        
        //    59: iload           6
        //    61: ldc             3
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokestatic    java/lang/Math.min:(II)I
        //    69: istore          7
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: iconst_0       
        //    77: istore          8
        //    79: ldc             2
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: iload           8
        //    86: iload           7
        //    88: ldc             3
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: if_icmpge       162
        //    96: aload           5
        //    98: iload           8
        //   100: aaload         
        //   101: aload_2        
        //   102: iload           8
        //   104: aaload         
        //   105: ldc             7
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: if_acmpeq       151
        //   113: aload_1        
        //   114: aload           5
        //   116: iload           8
        //   118: aaload         
        //   119: ldc             5
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ifeq            151
        //   135: iload           8
        //   137: istore_3       
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: ldc             1
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: goto            275
        //   151: iinc            8, 1
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: goto            84
        //   162: iload_3        
        //   163: iload           6
        //   165: ldc             3
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: if_icmplt       199
        //   173: iconst_0       
        //   174: istore          8
        //   176: ldc             2
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: aload           4
        //   183: ldc             2
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   191: iload           8
        //   193: ldc             2
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: ireturn        
        //   199: aload           5
        //   201: iload_3        
        //   202: aaload         
        //   203: aload_1        
        //   204: ldc             5
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: if_acmpne       220
        //   212: ldc             1
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: goto            275
        //   220: aload_1        
        //   221: aload           5
        //   223: iload_3        
        //   224: iload           6
        //   226: ldc             5
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.indexOf:(Ljava/lang/Object;[Ljava/lang/Object;II)I
        //   234: istore_3       
        //   235: ldc             1
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: iload_3        
        //   241: ldc             2
        //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   246: ifge            275
        //   249: iconst_0       
        //   250: istore          8
        //   252: ldc             2
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: aload           4
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   267: iload           8
        //   269: ldc             2
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: ireturn        
        //   275: iload           6
        //   277: iconst_1       
        //   278: isub           
        //   279: anewarray       Ljava/lang/Object;
        //   282: astore          7
        //   284: ldc             4
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: aload           5
        //   291: iconst_0       
        //   292: aload           7
        //   294: iconst_0       
        //   295: iload_3        
        //   296: ldc             6
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   304: aload           5
        //   306: iload_3        
        //   307: iconst_1       
        //   308: iadd           
        //   309: aload           7
        //   311: iload_3        
        //   312: iload           6
        //   314: iload_3        
        //   315: isub           
        //   316: iconst_1       
        //   317: isub           
        //   318: ldc             12
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   326: aload_0        
        //   327: aload           7
        //   329: ldc             3
        //   331: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   334: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   337: iconst_1       
        //   338: istore          8
        //   340: ldc             2
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: aload           4
        //   347: ldc             2
        //   349: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   352: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   355: iload           8
        //   357: ldc             2
        //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   362: ireturn        
        //   363: astore          9
        //   365: ldc             501
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: aload           4
        //   372: ldc             2
        //   374: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   377: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   380: aload           9
        //   382: ldc             2
        //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   387: athrow         
        //   388: athrow         
        //   389: athrow         
        //    StackMapTable: 00 09 FF 00 54 00 09 07 00 02 07 00 05 07 00 4E 01 07 00 3B 07 00 4E 01 01 01 00 00 FB 00 42 FA 00 0A 24 14 FA 00 36 FF 00 57 00 05 07 00 02 07 00 05 07 00 4E 01 07 00 3B 00 01 07 00 31 FF 00 18 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  21     389    389    390    Ljava/lang/VirtualMachineError;
        //  21     181    363    388    Any
        //  199    257    363    388    Any
        //  275    345    363    388    Any
        //  363    370    363    388    Any
        //  0      388    388    389    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0084:
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
    
    void removeRange(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_3        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload           4
        //    37: arraylength    
        //    38: istore          5
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: iload_1        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: iflt            75
        //    54: iload_2        
        //    55: iload           5
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpgt       75
        //    65: iload_2        
        //    66: iload_1        
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: if_icmpge       93
        //    75: new             Ljava/lang/IndexOutOfBoundsException;
        //    78: dup            
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: athrow         
        //    93: iload           5
        //    95: iload_2        
        //    96: iload_1        
        //    97: isub           
        //    98: isub           
        //    99: istore          6
        //   101: ldc             6
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: iload           5
        //   108: iload_2        
        //   109: isub           
        //   110: istore          7
        //   112: ldc             4
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: iload           7
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: ifne            156
        //   127: aload_0        
        //   128: aload           4
        //   130: iload           6
        //   132: ldc             4
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   140: ldc             1
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: goto            210
        //   156: iload           6
        //   158: anewarray       Ljava/lang/Object;
        //   161: astore          8
        //   163: ldc             2
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: aload           4
        //   170: iconst_0       
        //   171: aload           8
        //   173: iconst_0       
        //   174: iload_1        
        //   175: ldc             6
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   183: aload           4
        //   185: iload_2        
        //   186: aload           8
        //   188: iload_1        
        //   189: iload           7
        //   191: ldc             6
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   199: aload_0        
        //   200: aload           8
        //   202: ldc             3
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   210: aload_3        
        //   211: ldc             2
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   219: ldc             1
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: goto            251
        //   227: astore          9
        //   229: ldc             501
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: aload_3        
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   243: aload           9
        //   245: ldc             2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: athrow         
        //   251: ldc             1
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: return         
        //   257: athrow         
        //   258: athrow         
        //    StackMapTable: 00 08 FE 00 4B 07 00 3B 07 00 4E 01 11 FD 00 3E 01 01 FF 00 35 00 04 07 00 02 01 01 07 00 3B 00 00 50 07 00 31 17 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     258    258    259    Ljava/lang/VirtualMachineError;
        //  19     210    227    251    Any
        //  227    234    227    251    Any
        //  0      257    257    258    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0075:
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
    
    public boolean addIfAbsent(final E e) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final Object[] array2 = array;
            final int n = 0;
            final int length = array.length;
            BytecodeManager.incBytecodes(6);
            final int index = indexOf(e, array2, n, length);
            BytecodeManager.incBytecodes(1);
            boolean addIfAbsent;
            if (index >= 0) {
                addIfAbsent = false;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Object[] array3 = array;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                addIfAbsent = this.addIfAbsent(e, array3);
            }
            BytecodeManager.incBytecodes(1);
            return addIfAbsent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean addIfAbsent(final E p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_3        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload           4
        //    37: arraylength    
        //    38: istore          5
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_2        
        //    46: aload           4
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: if_acmpeq       218
        //    56: aload_2        
        //    57: arraylength    
        //    58: iload           5
        //    60: ldc             4
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: invokestatic    java/lang/Math.min:(II)I
        //    68: istore          6
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: iconst_0       
        //    76: istore          7
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: iload           7
        //    85: iload           6
        //    87: ldc             3
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: if_icmpge       170
        //    95: aload           4
        //    97: iload           7
        //    99: aaload         
        //   100: aload_2        
        //   101: iload           7
        //   103: aaload         
        //   104: ldc             7
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: if_acmpeq       159
        //   112: aload_1        
        //   113: aload           4
        //   115: iload           7
        //   117: aaload         
        //   118: ldc             5
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   126: ldc             1
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ifeq            159
        //   134: iconst_0       
        //   135: istore          8
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: aload_3        
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   151: iload           8
        //   153: ldc             2
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: ireturn        
        //   159: iinc            7, 1
        //   162: ldc             2
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: goto            83
        //   170: aload_1        
        //   171: aload           4
        //   173: iload           6
        //   175: iload           5
        //   177: ldc             5
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.indexOf:(Ljava/lang/Object;[Ljava/lang/Object;II)I
        //   185: ldc             1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: iflt            218
        //   193: iconst_0       
        //   194: istore          7
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: aload_3        
        //   202: ldc             2
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   210: iload           7
        //   212: ldc             2
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ireturn        
        //   218: aload           4
        //   220: iload           5
        //   222: iconst_1       
        //   223: iadd           
        //   224: ldc             5
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   232: astore          6
        //   234: ldc             1
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: aload           6
        //   241: iload           5
        //   243: aload_1        
        //   244: aastore        
        //   245: ldc             4
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: aload_0        
        //   251: aload           6
        //   253: ldc             3
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   261: iconst_1       
        //   262: istore          7
        //   264: ldc             2
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: aload_3        
        //   270: ldc             2
        //   272: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   275: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   278: iload           7
        //   280: ldc             2
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: ireturn        
        //   286: astore          9
        //   288: ldc             501
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: aload_3        
        //   294: ldc             2
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   302: aload           9
        //   304: ldc             2
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: athrow         
        //   310: athrow         
        //   311: athrow         
        //    Signature:
        //  (TE;[Ljava/lang/Object;)Z
        //    StackMapTable: 00 07 FF 00 53 00 08 07 00 02 07 00 05 07 00 4E 07 00 3B 07 00 4E 01 01 01 00 00 FB 00 4B FA 00 0A FA 00 2F FF 00 43 00 04 07 00 02 07 00 05 07 00 4E 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     311    311    312    Ljava/lang/VirtualMachineError;
        //  19     142    286    310    Any
        //  159    201    286    310    Any
        //  218    269    286    310    Any
        //  286    293    286    310    Any
        //  0      310    310    311    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0083:
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
    public boolean containsAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
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
                final Object[] array2 = array;
                final int n = 0;
                final int n2 = length;
                BytecodeManager.incBytecodes(5);
                final int index = indexOf(o, array2, n, n2);
                BytecodeManager.incBytecodes(1);
                if (index < 0) {
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
    public boolean removeAll(final Collection<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    31: astore_2       
        //    32: ldc             3
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_2        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    55: astore_3       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_3        
        //    62: arraylength    
        //    63: istore          4
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: iload           4
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifeq            236
        //    80: iconst_0       
        //    81: istore          5
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: iload           4
        //    90: anewarray       Ljava/lang/Object;
        //    93: astore          6
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: iconst_0       
        //   101: istore          7
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: iload           7
        //   110: iload           4
        //   112: ldc             3
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: if_icmpge       178
        //   120: aload_3        
        //   121: iload           7
        //   123: aaload         
        //   124: astore          8
        //   126: ldc             4
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload_1        
        //   132: aload           8
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokeinterface instrumented/java/util/Collection.contains:(Ljava/lang/Object;)Z
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: ifne            167
        //   152: aload           6
        //   154: iload           5
        //   156: iinc            5, 1
        //   159: aload           8
        //   161: aastore        
        //   162: ldc             5
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: iinc            7, 1
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            108
        //   178: iload           5
        //   180: iload           4
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: if_icmpeq       236
        //   190: aload_0        
        //   191: aload           6
        //   193: iload           5
        //   195: ldc             4
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   211: iconst_1       
        //   212: istore          7
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: aload_2        
        //   220: ldc             2
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   228: iload           7
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ireturn        
        //   236: iconst_0       
        //   237: istore          5
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_2        
        //   245: ldc             2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   253: iload           5
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: ireturn        
        //   261: astore          9
        //   263: ldc             501
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload_2        
        //   269: ldc             2
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   277: aload           9
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: athrow         
        //   285: athrow         
        //   286: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<*>;)Z
        //    StackMapTable: 00 08 1B FF 00 50 00 08 07 00 02 07 00 4A 07 00 3B 07 00 4E 01 01 07 00 4E 01 00 00 3A FA 00 0A F9 00 39 FF 00 18 00 03 07 00 02 07 00 4A 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     286    286    287    Ljava/lang/VirtualMachineError;
        //  46     219    261    285    Any
        //  236    244    261    285    Any
        //  261    268    261    285    Any
        //  0      285    285    286    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
    public boolean retainAll(final Collection<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    31: astore_2       
        //    32: ldc             3
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_2        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    55: astore_3       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_3        
        //    62: arraylength    
        //    63: istore          4
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: iload           4
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifeq            236
        //    80: iconst_0       
        //    81: istore          5
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: iload           4
        //    90: anewarray       Ljava/lang/Object;
        //    93: astore          6
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: iconst_0       
        //   101: istore          7
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: iload           7
        //   110: iload           4
        //   112: ldc             3
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: if_icmpge       178
        //   120: aload_3        
        //   121: iload           7
        //   123: aaload         
        //   124: astore          8
        //   126: ldc             4
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload_1        
        //   132: aload           8
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokeinterface instrumented/java/util/Collection.contains:(Ljava/lang/Object;)Z
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: ifeq            167
        //   152: aload           6
        //   154: iload           5
        //   156: iinc            5, 1
        //   159: aload           8
        //   161: aastore        
        //   162: ldc             5
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: iinc            7, 1
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            108
        //   178: iload           5
        //   180: iload           4
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: if_icmpeq       236
        //   190: aload_0        
        //   191: aload           6
        //   193: iload           5
        //   195: ldc             4
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   211: iconst_1       
        //   212: istore          7
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: aload_2        
        //   220: ldc             2
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   228: iload           7
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ireturn        
        //   236: iconst_0       
        //   237: istore          5
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_2        
        //   245: ldc             2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   253: iload           5
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: ireturn        
        //   261: astore          9
        //   263: ldc             501
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload_2        
        //   269: ldc             2
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   277: aload           9
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: athrow         
        //   285: athrow         
        //   286: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<*>;)Z
        //    StackMapTable: 00 08 1B FF 00 50 00 08 07 00 02 07 00 4A 07 00 3B 07 00 4E 01 01 07 00 4E 01 00 00 3A FA 00 0A F9 00 39 FF 00 18 00 03 07 00 02 07 00 4A 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     286    286    287    Ljava/lang/VirtualMachineError;
        //  46     219    261    285    Any
        //  236    244    261    285    Any
        //  261    268    261    285    Any
        //  0      285    285    286    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
    
    public int addAllAbsent(final Collection<? extends E> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface instrumented/java/util/Collection.toArray:()[Ljava/lang/Object;
        //    11: astore_2       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_2        
        //    18: arraylength    
        //    19: ldc             3
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: ifne            34
        //    27: iconst_0       
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ireturn        
        //    34: aload_0        
        //    35: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    38: astore_3       
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: aload_3        
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    53: aload_0        
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    62: astore          4
        //    64: ldc             1
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: aload           4
        //    71: arraylength    
        //    72: istore          5
        //    74: ldc             3
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: iconst_0       
        //    80: istore          6
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: iconst_0       
        //    88: istore          7
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: iload           7
        //    97: aload_2        
        //    98: arraylength    
        //    99: ldc             4
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: if_icmpge       193
        //   107: aload_2        
        //   108: iload           7
        //   110: aaload         
        //   111: astore          8
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: aload           8
        //   120: aload           4
        //   122: iconst_0       
        //   123: iload           5
        //   125: ldc             5
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.indexOf:(Ljava/lang/Object;[Ljava/lang/Object;II)I
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: ifge            182
        //   141: aload           8
        //   143: aload_2        
        //   144: iconst_0       
        //   145: iload           6
        //   147: ldc             4
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: ldc             1
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokestatic    instrumented/java/util/concurrent/CopyOnWriteArrayList.indexOf:(Ljava/lang/Object;[Ljava/lang/Object;II)I
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: ifge            182
        //   168: aload_2        
        //   169: iload           6
        //   171: iinc            6, 1
        //   174: aload           8
        //   176: aastore        
        //   177: ldc             5
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: iinc            7, 1
        //   185: ldc             2
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: goto            95
        //   193: iload           6
        //   195: ldc             2
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: ifle            252
        //   203: aload           4
        //   205: iload           5
        //   207: iload           6
        //   209: iadd           
        //   210: ldc             5
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   218: astore          7
        //   220: ldc             1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: aload_2        
        //   226: iconst_0       
        //   227: aload           7
        //   229: iload           5
        //   231: iload           6
        //   233: ldc             6
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   241: aload_0        
        //   242: aload           7
        //   244: ldc             3
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   252: iload           6
        //   254: istore          7
        //   256: ldc             2
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: aload_3        
        //   262: ldc             2
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   270: iload           7
        //   272: ldc             2
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: ireturn        
        //   278: astore          9
        //   280: ldc             501
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: aload_3        
        //   286: ldc             2
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   294: aload           9
        //   296: ldc             2
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: athrow         
        //   302: athrow         
        //   303: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<+TE;>;)I
        //    StackMapTable: 00 08 FC 00 22 07 00 4E FF 00 3C 00 08 07 00 02 07 00 4A 07 00 4E 07 00 3B 07 00 4E 01 01 01 00 00 FB 00 56 FA 00 0A 3A FF 00 19 00 04 07 00 02 07 00 4A 07 00 4E 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  53     303    303    304    Ljava/lang/VirtualMachineError;
        //  53     261    278    302    Any
        //  278    285    278    302    Any
        //  0      302    302    303    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0095:
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
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: iconst_0       
        //    21: anewarray       Ljava/lang/Object;
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //    32: aload_1        
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: goto            66
        //    49: astore_2       
        //    50: aload_1        
        //    51: ldc             503
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    59: aload_2        
        //    60: ldc             2
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: athrow         
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: return         
        //    72: athrow         
        //    73: athrow         
        //    StackMapTable: 00 04 FF 00 31 00 02 07 00 02 07 00 3B 00 01 07 00 31 10 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     73     73     74     Ljava/lang/VirtualMachineError;
        //  19     32     49     66     Any
        //  0      72     72     73     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
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
    public boolean addAll(final Collection<? extends E> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //     9: ldc             Linstrumented/java/util/concurrent/CopyOnWriteArrayList;.class
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: if_acmpne       44
        //    19: aload_1        
        //    20: checkcast       Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
        //    23: ldc             2
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    36: ldc             1
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: goto            55
        //    44: aload_1        
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: invokeinterface instrumented/java/util/Collection.toArray:()[Ljava/lang/Object;
        //    55: astore_2       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_2        
        //    62: arraylength    
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: ifne            78
        //    71: iconst_0       
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ireturn        
        //    78: aload_0        
        //    79: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    82: astore_3       
        //    83: ldc             3
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: aload_3        
        //    89: ldc             2
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    97: aload_0        
        //    98: ldc             2
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //   106: astore          4
        //   108: ldc             1
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: aload           4
        //   115: arraylength    
        //   116: istore          5
        //   118: ldc             3
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: iload           5
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: ifne            170
        //   133: aload_2        
        //   134: ldc             2
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   142: ldc             [Ljava/lang/Object;.class
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: if_acmpne       170
        //   152: aload_0        
        //   153: aload_2        
        //   154: ldc             3
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   162: ldc             1
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: goto            219
        //   170: aload           4
        //   172: iload           5
        //   174: aload_2        
        //   175: arraylength    
        //   176: iadd           
        //   177: ldc             6
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   185: astore          6
        //   187: ldc             1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: aload_2        
        //   193: iconst_0       
        //   194: aload           6
        //   196: iload           5
        //   198: aload_2        
        //   199: arraylength    
        //   200: ldc             7
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   208: aload_0        
        //   209: aload           6
        //   211: ldc             3
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   219: iconst_1       
        //   220: istore          6
        //   222: ldc             2
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: aload_3        
        //   228: ldc             2
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   236: iload           6
        //   238: ldc             2
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: ireturn        
        //   244: astore          7
        //   246: ldc             501
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: aload_3        
        //   252: ldc             2
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   260: aload           7
        //   262: ldc             2
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: athrow         
        //   268: athrow         
        //   269: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<+TE;>;)Z
        //    StackMapTable: 00 08 2C 4A 07 00 4E FC 00 16 07 00 4E FE 00 5B 07 00 3B 07 00 4E 01 30 FF 00 18 00 04 07 00 02 07 00 4A 07 00 4E 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  97     269    269    270    Ljava/lang/VirtualMachineError;
        //  97     227    244    268    Any
        //  244    251    244    268    Any
        //  0      268    268    269    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0170:
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
    public boolean addAll(final int p0, final Collection<? extends E> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface instrumented/java/util/Collection.toArray:()[Ljava/lang/Object;
        //    11: astore_3       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_0        
        //    18: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    21: astore          4
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: aload           4
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    38: aload_0        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    47: astore          5
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: aload           5
        //    56: arraylength    
        //    57: istore          6
        //    59: ldc             3
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: iload_1        
        //    65: iload           6
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: if_icmpgt       84
        //    75: iload_1        
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifge            161
        //    84: new             Ljava/lang/IndexOutOfBoundsException;
        //    87: dup            
        //    88: new             Ljava/lang/StringBuilder;
        //    91: dup            
        //    92: ldc             5
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokespecial   java/lang/StringBuilder.<init>:()V
        //   100: ldc             "Index: "
        //   102: ldc             2
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: iload_1        
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   119: ldc             ", Size: "
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   129: iload           6
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: invokespecial   java/lang/IndexOutOfBoundsException.<init>:(Ljava/lang/String;)V
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: athrow         
        //   161: aload_3        
        //   162: arraylength    
        //   163: ldc             3
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: ifne            197
        //   171: iconst_0       
        //   172: istore          7
        //   174: ldc             2
        //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   179: aload           4
        //   181: ldc             2
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   189: iload           7
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: ireturn        
        //   197: iload           6
        //   199: iload_1        
        //   200: isub           
        //   201: istore          7
        //   203: ldc             4
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: iload           7
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: ifne            243
        //   218: aload           5
        //   220: iload           6
        //   222: aload_3        
        //   223: arraylength    
        //   224: iadd           
        //   225: ldc             6
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   233: astore          8
        //   235: ldc             2
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: goto            292
        //   243: iload           6
        //   245: aload_3        
        //   246: arraylength    
        //   247: iadd           
        //   248: anewarray       Ljava/lang/Object;
        //   251: astore          8
        //   253: ldc             5
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: aload           5
        //   260: iconst_0       
        //   261: aload           8
        //   263: iconst_0       
        //   264: iload_1        
        //   265: ldc             6
        //   267: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   270: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   273: aload           5
        //   275: iload_1        
        //   276: aload           8
        //   278: iload_1        
        //   279: aload_3        
        //   280: arraylength    
        //   281: iadd           
        //   282: iload           7
        //   284: ldc             9
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   292: aload_3        
        //   293: iconst_0       
        //   294: aload           8
        //   296: iload_1        
        //   297: aload_3        
        //   298: arraylength    
        //   299: ldc             7
        //   301: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   304: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   307: aload_0        
        //   308: aload           8
        //   310: ldc             3
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   318: iconst_1       
        //   319: istore          9
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: aload           4
        //   328: ldc             2
        //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   333: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   336: iload           9
        //   338: ldc             2
        //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   343: ireturn        
        //   344: astore          10
        //   346: ldc             501
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: aload           4
        //   353: ldc             2
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   361: aload           10
        //   363: ldc             2
        //   365: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   368: athrow         
        //   369: athrow         
        //   370: athrow         
        //    Signature:
        //  (ILinstrumented/java/util/Collection<+TE;>;)Z
        //    StackMapTable: 00 08 FF 00 54 00 07 07 00 02 01 07 00 4A 07 00 4E 07 00 3B 07 00 4E 01 00 00 FB 00 4C 23 FC 00 2D 01 FC 00 30 07 00 4E FF 00 33 00 05 07 00 02 01 07 00 4A 07 00 4E 07 00 3B 00 01 07 00 31 FF 00 18 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  38     370    370    371    Ljava/lang/VirtualMachineError;
        //  38     179    344    369    Any
        //  197    326    344    369    Any
        //  344    351    344    369    Any
        //  0      369    369    370    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0084:
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
    
    public void forEach(final Consumer<? super E> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final Object o = array[n];
                BytecodeManager.incBytecodes(4);
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                consumer.accept((Object)o2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeIf(final Predicate<? super E> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    31: astore_2       
        //    32: ldc             3
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_2        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    55: astore_3       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_3        
        //    62: arraylength    
        //    63: istore          4
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: iload           4
        //    72: ldc             2
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifeq            236
        //    80: iconst_0       
        //    81: istore          5
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: iload           4
        //    90: anewarray       Ljava/lang/Object;
        //    93: astore          6
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: iconst_0       
        //   101: istore          7
        //   103: ldc             2
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: iload           7
        //   110: iload           4
        //   112: ldc             3
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: if_icmpge       178
        //   120: aload_3        
        //   121: iload           7
        //   123: aaload         
        //   124: astore          8
        //   126: ldc             4
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload_1        
        //   132: aload           8
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: invokeinterface instrumented/java/util/function/Predicate.test:(Ljava/lang/Object;)Z
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: ifne            167
        //   152: aload           6
        //   154: iload           5
        //   156: iinc            5, 1
        //   159: aload           8
        //   161: aastore        
        //   162: ldc             5
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: iinc            7, 1
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            108
        //   178: iload           5
        //   180: iload           4
        //   182: ldc             3
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: if_icmpeq       236
        //   190: aload_0        
        //   191: aload           6
        //   193: iload           5
        //   195: ldc             4
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   211: iconst_1       
        //   212: istore          7
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: aload_2        
        //   220: ldc             2
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   228: iload           7
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ireturn        
        //   236: iconst_0       
        //   237: istore          5
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_2        
        //   245: ldc             2
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   253: iload           5
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: ireturn        
        //   261: astore          9
        //   263: ldc             501
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload_2        
        //   269: ldc             2
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   277: aload           9
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: athrow         
        //   285: athrow         
        //   286: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/Predicate<-TE;>;)Z
        //    StackMapTable: 00 08 1B FF 00 50 00 08 07 00 02 07 00 E9 07 00 3B 07 00 4E 01 01 07 00 4E 01 00 00 3A FA 00 0A F9 00 39 FF 00 18 00 03 07 00 02 07 00 E9 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     286    286    287    Ljava/lang/VirtualMachineError;
        //  46     219    261    285    Any
        //  236    244    261    285    Any
        //  261    268    261    285    Any
        //  0      285    285    286    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
    public void replaceAll(final UnaryOperator<E> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_0        
        //    28: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    31: astore_2       
        //    32: ldc             3
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: aload_2        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    46: aload_0        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    55: astore_3       
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: aload_3        
        //    62: arraylength    
        //    63: istore          4
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: aload_3        
        //    71: iload           4
        //    73: ldc             3
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    81: astore          5
        //    83: ldc             1
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: iconst_0       
        //    89: istore          6
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: iload           6
        //    98: iload           4
        //   100: ldc             3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: if_icmpge       153
        //   108: aload_3        
        //   109: iload           6
        //   111: aaload         
        //   112: astore          7
        //   114: ldc             4
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload           5
        //   121: iload           6
        //   123: aload_1        
        //   124: aload           7
        //   126: ldc             5
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokeinterface instrumented/java/util/function/UnaryOperator.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   136: aastore        
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: iinc            6, 1
        //   145: ldc             2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            96
        //   153: aload_0        
        //   154: aload           5
        //   156: ldc             3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //   164: aload_2        
        //   165: ldc             2
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   173: ldc             1
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: goto            205
        //   181: astore          8
        //   183: ldc             501
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: aload_2        
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   197: aload           8
        //   199: ldc             2
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: athrow         
        //   205: ldc             1
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: return         
        //   211: athrow         
        //   212: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/UnaryOperator<TE;>;)V
        //    StackMapTable: 00 07 1B FF 00 44 00 07 07 00 02 07 00 F0 07 00 3B 07 00 4E 01 07 00 4E 01 00 00 FA 00 38 FF 00 1B 00 03 07 00 02 07 00 F0 07 00 3B 00 01 07 00 31 17 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  46     212    212    213    Ljava/lang/VirtualMachineError;
        //  46     164    181    205    Any
        //  181    188    181    205    Any
        //  0      211    211    212    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0096:
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
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_2       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_2        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore_3       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: aload_3        
        //    35: aload_3        
        //    36: arraylength    
        //    37: ldc             4
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    45: astore          4
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload           4
        //    54: checkcast       [Ljava/lang/Object;
        //    57: astore          5
        //    59: ldc             3
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload           5
        //    66: aload_1        
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokestatic    instrumented/java/util/Arrays.sort:([Ljava/lang/Object;Linstrumented/java/util/Comparator;)V
        //    75: aload_0        
        //    76: aload           4
        //    78: ldc             3
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
        //    86: aload_2        
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    95: ldc             1
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: goto            127
        //   103: astore          6
        //   105: ldc             501
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: aload_2        
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   119: aload           6
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: athrow         
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: return         
        //   133: athrow         
        //   134: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Comparator<-TE;>;)V
        //    StackMapTable: 00 04 FF 00 67 00 03 07 00 02 07 00 FB 07 00 3B 00 01 07 00 31 17 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     134    134    135    Ljava/lang/VirtualMachineError;
        //  19     86     103    127    Any
        //  103    110    103    127    Any
        //  0      133    133    134    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0127:
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(length);
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
                final Object obj = o;
                BytecodeManager.incBytecodes(3);
                objectOutputStream.writeObject(obj);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            BytecodeManager.incBytecodes(2);
            this.resetLock();
            BytecodeManager.incBytecodes(2);
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final Object[] array = new Object[int1];
            BytecodeManager.incBytecodes(2);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int n3 = int1;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final Object[] array2 = array;
                final int n4 = n;
                BytecodeManager.incBytecodes(4);
                array2[n4] = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final Object[] array3 = array;
            BytecodeManager.incBytecodes(3);
            this.setArray(array3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final String string = Arrays.toString(array);
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
            final boolean b2 = o instanceof List;
            BytecodeManager.incBytecodes(3);
            if (!b2) {
                final boolean b3 = false;
                BytecodeManager.incBytecodes(2);
                return b3;
            }
            final List list = (List)o;
            BytecodeManager.incBytecodes(4);
            final List<Object> list2 = (List<Object>)list;
            BytecodeManager.incBytecodes(2);
            final Iterator<Object> iterator = list2.iterator();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Label_0181: {
                while (true) {
                    final int n2 = n;
                    final int n3 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n2 >= n3) {
                        break Label_0181;
                    }
                    final Iterator<Object> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Object o2 = array[n];
                    final Iterator<Object> iterator3 = iterator;
                    BytecodeManager.incBytecodes(5);
                    final Object next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    final boolean eq = eq(o2, next);
                    BytecodeManager.incBytecodes(1);
                    if (!eq) {
                        break;
                    }
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            final Iterator<Object> iterator4 = iterator;
            BytecodeManager.incBytecodes(2);
            final boolean hasNext2 = iterator4.hasNext();
            BytecodeManager.incBytecodes(1);
            if (hasNext2) {
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            final boolean b6 = true;
            BytecodeManager.incBytecodes(2);
            return b6;
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
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n3 = n2;
                final int n4 = length;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object o = array[n2];
                BytecodeManager.incBytecodes(4);
                final int n5 = 31 * n;
                final Object o2 = o;
                BytecodeManager.incBytecodes(5);
                int hashCode;
                if (o2 == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    hashCode = o3.hashCode();
                }
                n = n5 + hashCode;
                BytecodeManager.incBytecodes(2);
                ++n2;
                BytecodeManager.incBytecodes(2);
            }
            final int n6 = n;
            BytecodeManager.incBytecodes(2);
            return n6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final Object[] array = this.getArray();
            final int n = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(3);
            final COWIterator cowIterator = new COWIterator<E>(array, n);
            BytecodeManager.incBytecodes(1);
            return (Iterator<E>)cowIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ListIterator<E> listIterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final Object[] array = this.getArray();
            final int n = 0;
            final Object object = null;
            BytecodeManager.incBytecodes(3);
            final COWIterator cowIterator = new COWIterator<E>(array, n);
            BytecodeManager.incBytecodes(1);
            return (ListIterator<E>)cowIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public ListIterator<E> listIterator(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object[] array = this.getArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                final int n = length;
                BytecodeManager.incBytecodes(3);
                if (i <= n) {
                    final Object[] array2 = array;
                    final Object object = null;
                    BytecodeManager.incBytecodes(6);
                    final COWIterator cowIterator = new COWIterator<E>(array2, i);
                    BytecodeManager.incBytecodes(1);
                    return (ListIterator<E>)cowIterator;
                }
            }
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
    public Spliterator<E> spliterator() {
        try {
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Object[] array = this.getArray();
            final int n = 1040;
            BytecodeManager.incBytecodes(2);
            final Spliterator<Object> spliterator = Spliterators.spliterator(array, n);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public List<E> subList(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_3       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_3        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
        //    28: astore          4
        //    30: ldc             1
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: aload           4
        //    37: arraylength    
        //    38: istore          5
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: iload_1        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: iflt            75
        //    54: iload_2        
        //    55: iload           5
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: if_icmpgt       75
        //    65: iload_1        
        //    66: iload_2        
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: if_icmple       93
        //    75: new             Ljava/lang/IndexOutOfBoundsException;
        //    78: dup            
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: athrow         
        //    93: new             Linstrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList;
        //    96: dup            
        //    97: aload_0        
        //    98: iload_1        
        //    99: iload_2        
        //   100: ldc             6
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.<init>:(Linstrumented/java/util/concurrent/CopyOnWriteArrayList;II)V
        //   108: astore          6
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: aload_3        
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   124: aload           6
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: areturn        
        //   132: astore          7
        //   134: ldc             501
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: aload_3        
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   148: aload           7
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: athrow         
        //   156: athrow         
        //   157: athrow         
        //    Signature:
        //  (II)Linstrumented/java/util/List<TE;>;
        //    StackMapTable: 00 05 FE 00 4B 07 00 3B 07 00 4E 01 11 FF 00 26 00 04 07 00 02 01 01 07 00 3B 00 01 07 00 31 FF 00 17 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     157    157    158    Ljava/lang/VirtualMachineError;
        //  19     115    132    156    Any
        //  132    139    132    156    Any
        //  0      156    156    157    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0075:
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
    
    private void resetLock() {
        try {
            final Unsafe unsafe = CopyOnWriteArrayList.UNSAFE;
            final long lockOffset = CopyOnWriteArrayList.lockOffset;
            BytecodeManager.incBytecodes(6);
            final ReentrantLock x = new ReentrantLock();
            BytecodeManager.incBytecodes(1);
            unsafe.putObjectVolatile(this, lockOffset, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(1);
                    UNSAFE = Unsafe.getUnsafe();
                    BytecodeManager.incBytecodes(1);
                    final Class<CopyOnWriteArrayList> clazz = CopyOnWriteArrayList.class;
                    BytecodeManager.incBytecodes(2);
                    final Unsafe unsafe = CopyOnWriteArrayList.UNSAFE;
                    final Class<CopyOnWriteArrayList> clazz2 = clazz;
                    final String name = "lock";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz2.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    lockOffset = unsafe.objectFieldOffset(declaredField);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                catch (Exception ex) {
                    BytecodeManager.incBytecodes(501);
                    final Exception cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final Error error = new Error(cause);
                    BytecodeManager.incBytecodes(1);
                    throw error;
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
    
    static final class COWIterator<E> implements ListIterator<E>
    {
        private final Object[] snapshot;
        private int cursor;
        
        private COWIterator(final Object[] snapshot, final int cursor) {
            try {
                BytecodeManager.incBytecodes(2);
                this.cursor = cursor;
                BytecodeManager.incBytecodes(3);
                this.snapshot = snapshot;
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
                final int cursor = this.cursor;
                final int length = this.snapshot.length;
                BytecodeManager.incBytecodes(6);
                boolean b;
                if (cursor < length) {
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
        public boolean hasPrevious() {
            try {
                final int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (cursor > 0) {
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
                final Object o = this.snapshot[this.cursor++];
                BytecodeManager.incBytecodes(11);
                return (E)o;
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
                if (!hasPrevious) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object[] snapshot = this.snapshot;
                final int cursor = this.cursor - 1;
                this.cursor = cursor;
                final Object o = snapshot[cursor];
                BytecodeManager.incBytecodes(11);
                return (E)o;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final Object[] snapshot = this.snapshot;
                BytecodeManager.incBytecodes(3);
                final int length = snapshot.length;
                BytecodeManager.incBytecodes(3);
                int cursor = this.cursor;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final int n = cursor;
                    final int n2 = length;
                    BytecodeManager.incBytecodes(3);
                    if (n >= n2) {
                        break;
                    }
                    final Object o = snapshot[cursor];
                    BytecodeManager.incBytecodes(4);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(3);
                    consumer.accept((Object)o2);
                    ++cursor;
                    BytecodeManager.incBytecodes(2);
                }
                this.cursor = length;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class COWSubList<E> extends AbstractList<E> implements RandomAccess
    {
        private final CopyOnWriteArrayList<E> l;
        private final int offset;
        private int size;
        private Object[] expectedArray;
        
        COWSubList(final CopyOnWriteArrayList<E> l, final int offset, final int n) {
            try {
                BytecodeManager.incBytecodes(2);
                this.l = l;
                BytecodeManager.incBytecodes(3);
                final CopyOnWriteArrayList<E> i = this.l;
                BytecodeManager.incBytecodes(4);
                this.expectedArray = i.getArray();
                BytecodeManager.incBytecodes(1);
                this.offset = offset;
                BytecodeManager.incBytecodes(3);
                this.size = n - offset;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void checkForComodification() {
            try {
                final CopyOnWriteArrayList<E> l = this.l;
                BytecodeManager.incBytecodes(3);
                final Object[] array = l.getArray();
                final Object[] expectedArray = this.expectedArray;
                BytecodeManager.incBytecodes(3);
                if (array != expectedArray) {
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
        
        private void rangeCheck(final int i) {
            try {
                BytecodeManager.incBytecodes(2);
                if (i >= 0) {
                    final int size = this.size;
                    BytecodeManager.incBytecodes(4);
                    if (i < size) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Index: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                final String str2 = ",Size: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = append2.append(str2);
                final int size2 = this.size;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(size2);
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
        public E set(final int n, final E e) {
            ReentrantLock lock;
            try {
                lock = this.l.lock;
                BytecodeManager.incBytecodes(4);
                final ReentrantLock reentrantLock = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock.lock();
                try {
                    final COWSubList list = this;
                    final int n2 = n;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    list.rangeCheck(n2);
                    final COWSubList list2 = this;
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    list2.checkForComodification();
                    final COWSubList list3 = this;
                    final CopyOnWriteArrayList<E> list4 = list3.l;
                    final int n5 = n;
                    final COWSubList list5 = this;
                    final int n6 = list5.offset;
                    final int n7 = n5 + n6;
                    final E e2 = e;
                    final int n8 = 8;
                    BytecodeManager.incBytecodes(n8);
                    final E e3 = list4.set(n7, e2);
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(n9);
                    final COWSubList list6 = this;
                    final COWSubList list7 = this;
                    final CopyOnWriteArrayList<E> list8 = list7.l;
                    final int n10 = 4;
                    BytecodeManager.incBytecodes(n10);
                    final Object[] array = list8.getArray();
                    list6.expectedArray = array;
                    final int n11 = 1;
                    BytecodeManager.incBytecodes(n11);
                    final E e4 = e3;
                    final int n12 = 2;
                    BytecodeManager.incBytecodes(n12);
                    final ReentrantLock reentrantLock2 = lock;
                    final int n13 = 2;
                    BytecodeManager.incBytecodes(n13);
                    reentrantLock2.unlock();
                    final E e5 = e4;
                    final int n14 = 2;
                    BytecodeManager.incBytecodes(n14);
                    return e5;
                }
                finally {
                    BytecodeManager.incBytecodes(501);
                    final ReentrantLock reentrantLock3 = lock;
                    BytecodeManager.incBytecodes(2);
                    reentrantLock3.unlock();
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final COWSubList list = this;
                final int n2 = n;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                list.rangeCheck(n2);
                final COWSubList list2 = this;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                list2.checkForComodification();
                final COWSubList list3 = this;
                final CopyOnWriteArrayList<E> list4 = list3.l;
                final int n5 = n;
                final COWSubList list5 = this;
                final int n6 = list5.offset;
                final int n7 = n5 + n6;
                final E e2 = e;
                final int n8 = 8;
                BytecodeManager.incBytecodes(n8);
                final E e3 = list4.set(n7, e2);
                final int n9 = 1;
                BytecodeManager.incBytecodes(n9);
                final COWSubList list6 = this;
                final COWSubList list7 = this;
                final CopyOnWriteArrayList<E> list8 = list7.l;
                final int n10 = 4;
                BytecodeManager.incBytecodes(n10);
                final Object[] array = list8.getArray();
                list6.expectedArray = array;
                final int n11 = 1;
                BytecodeManager.incBytecodes(n11);
                final E e4 = e3;
                final int n12 = 2;
                BytecodeManager.incBytecodes(n12);
                final ReentrantLock reentrantLock2 = lock;
                final int n13 = 2;
                BytecodeManager.incBytecodes(n13);
                reentrantLock2.unlock();
                final E e5 = e4;
                final int n14 = 2;
                BytecodeManager.incBytecodes(n14);
                return e5;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public E get(final int n) {
            ReentrantLock lock;
            try {
                lock = this.l.lock;
                BytecodeManager.incBytecodes(4);
                final ReentrantLock reentrantLock = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock.lock();
                try {
                    final COWSubList list = this;
                    final int n2 = n;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    list.rangeCheck(n2);
                    final COWSubList list2 = this;
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    list2.checkForComodification();
                    final COWSubList list3 = this;
                    final CopyOnWriteArrayList<E> list4 = list3.l;
                    final int n5 = n;
                    final COWSubList list5 = this;
                    final int n6 = list5.offset;
                    final int n7 = n5 + n6;
                    final int n8 = 7;
                    BytecodeManager.incBytecodes(n8);
                    final E e = list4.get(n7);
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(n9);
                    final ReentrantLock reentrantLock2 = lock;
                    final int n10 = 2;
                    BytecodeManager.incBytecodes(n10);
                    reentrantLock2.unlock();
                    final E e2 = e;
                    final int n11 = 2;
                    BytecodeManager.incBytecodes(n11);
                    return e2;
                }
                finally {
                    BytecodeManager.incBytecodes(501);
                    final ReentrantLock reentrantLock3 = lock;
                    BytecodeManager.incBytecodes(2);
                    reentrantLock3.unlock();
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final COWSubList list = this;
                final int n2 = n;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                list.rangeCheck(n2);
                final COWSubList list2 = this;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                list2.checkForComodification();
                final COWSubList list3 = this;
                final CopyOnWriteArrayList<E> list4 = list3.l;
                final int n5 = n;
                final COWSubList list5 = this;
                final int n6 = list5.offset;
                final int n7 = n5 + n6;
                final int n8 = 7;
                BytecodeManager.incBytecodes(n8);
                final E e = list4.get(n7);
                final int n9 = 1;
                BytecodeManager.incBytecodes(n9);
                final ReentrantLock reentrantLock2 = lock;
                final int n10 = 2;
                BytecodeManager.incBytecodes(n10);
                reentrantLock2.unlock();
                final E e2 = e;
                final int n11 = 2;
                BytecodeManager.incBytecodes(n11);
                return e2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public int size() {
            ReentrantLock lock;
            try {
                lock = this.l.lock;
                BytecodeManager.incBytecodes(4);
                final ReentrantLock reentrantLock = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock.lock();
                try {
                    final COWSubList list = this;
                    final int n = 2;
                    BytecodeManager.incBytecodes(n);
                    list.checkForComodification();
                    final COWSubList list2 = this;
                    final int n2 = list2.size;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    final ReentrantLock reentrantLock2 = lock;
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    reentrantLock2.unlock();
                    final int n5 = n2;
                    final int n6 = 2;
                    BytecodeManager.incBytecodes(n6);
                    return n5;
                }
                finally {
                    final ReentrantLock reentrantLock3 = lock;
                    BytecodeManager.incBytecodes(503);
                    reentrantLock3.unlock();
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final COWSubList list = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                list.checkForComodification();
                final COWSubList list2 = this;
                final int n2 = list2.size;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                final ReentrantLock reentrantLock2 = lock;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                reentrantLock2.unlock();
                final int n5 = n2;
                final int n6 = 2;
                BytecodeManager.incBytecodes(n6);
                return n5;
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
            //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //     4: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_3       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_3        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.checkForComodification:()V
            //    31: iload_1        
            //    32: ldc             2
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: iflt            53
            //    40: iload_1        
            //    41: aload_0        
            //    42: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    45: ldc             4
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: if_icmple       71
            //    53: new             Ljava/lang/IndexOutOfBoundsException;
            //    56: dup            
            //    57: ldc             3
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //    65: ldc             1
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: athrow         
            //    71: aload_0        
            //    72: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    75: iload_1        
            //    76: aload_0        
            //    77: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    80: iadd           
            //    81: aload_2        
            //    82: ldc             8
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.add:(ILjava/lang/Object;)V
            //    90: aload_0        
            //    91: aload_0        
            //    92: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    95: ldc             4
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //   103: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   106: ldc             1
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: aload_0        
            //   112: dup            
            //   113: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   116: iconst_1       
            //   117: iadd           
            //   118: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   121: ldc             6
            //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   126: aload_3        
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   135: ldc             1
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: goto            167
            //   143: astore          4
            //   145: ldc             501
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: aload_3        
            //   151: ldc             2
            //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   156: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   159: aload           4
            //   161: ldc             2
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: athrow         
            //   167: ldc             1
            //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   172: return         
            //   173: athrow         
            //   174: athrow         
            //    Signature:
            //  (ITE;)V
            //    StackMapTable: 00 06 FC 00 35 07 00 5A 11 F7 00 47 07 00 34 17 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     174    174    175    Ljava/lang/VirtualMachineError;
            //  22     126    143    167    Any
            //  143    150    143    167    Any
            //  0      173    173    174    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
            //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //     4: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_1       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_1        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.checkForComodification:()V
            //    31: aload_0        
            //    32: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    35: aload_0        
            //    36: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    39: aload_0        
            //    40: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    47: iadd           
            //    48: ldc             10
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.removeRange:(II)V
            //    56: aload_0        
            //    57: aload_0        
            //    58: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    61: ldc             4
            //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    66: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //    69: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //    72: ldc             1
            //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    77: aload_0        
            //    78: iconst_0       
            //    79: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    82: ldc             3
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: aload_1        
            //    88: ldc             2
            //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    93: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //    96: ldc             1
            //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   101: goto            121
            //   104: astore_2       
            //   105: aload_1        
            //   106: ldc             503
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   114: aload_2        
            //   115: ldc             2
            //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   120: athrow         
            //   121: ldc             1
            //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   126: return         
            //   127: athrow         
            //   128: athrow         
            //    StackMapTable: 00 04 FF 00 68 00 02 07 00 02 07 00 5A 00 01 07 00 34 10 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     128    128    129    Ljava/lang/VirtualMachineError;
            //  22     87     104    121    Any
            //  0      127    127    128    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
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
            ReentrantLock lock;
            try {
                lock = this.l.lock;
                BytecodeManager.incBytecodes(4);
                final ReentrantLock reentrantLock = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock.lock();
                try {
                    final COWSubList list = this;
                    final int n2 = n;
                    final int n3 = 3;
                    BytecodeManager.incBytecodes(n3);
                    list.rangeCheck(n2);
                    final COWSubList list2 = this;
                    final int n4 = 2;
                    BytecodeManager.incBytecodes(n4);
                    list2.checkForComodification();
                    final COWSubList list3 = this;
                    final CopyOnWriteArrayList<E> list4 = list3.l;
                    final int n5 = n;
                    final COWSubList list5 = this;
                    final int n6 = list5.offset;
                    final int n7 = n5 + n6;
                    final int n8 = 7;
                    BytecodeManager.incBytecodes(n8);
                    final E e = list4.remove(n7);
                    final int n9 = 1;
                    BytecodeManager.incBytecodes(n9);
                    final COWSubList list6 = this;
                    final COWSubList list7 = this;
                    final CopyOnWriteArrayList<E> list8 = list7.l;
                    final int n10 = 4;
                    BytecodeManager.incBytecodes(n10);
                    final Object[] array = list8.getArray();
                    list6.expectedArray = array;
                    final int n11 = 1;
                    BytecodeManager.incBytecodes(n11);
                    final COWSubList list9 = this;
                    final int n12 = list9.size;
                    final int n13 = 1;
                    final int n14 = n12 - n13;
                    list9.size = n14;
                    final int n15 = 6;
                    BytecodeManager.incBytecodes(n15);
                    final E e2 = e;
                    final int n16 = 2;
                    BytecodeManager.incBytecodes(n16);
                    final ReentrantLock reentrantLock2 = lock;
                    final int n17 = 2;
                    BytecodeManager.incBytecodes(n17);
                    reentrantLock2.unlock();
                    final E e3 = e2;
                    final int n18 = 2;
                    BytecodeManager.incBytecodes(n18);
                    return e3;
                }
                finally {
                    BytecodeManager.incBytecodes(501);
                    final ReentrantLock reentrantLock3 = lock;
                    BytecodeManager.incBytecodes(2);
                    reentrantLock3.unlock();
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final COWSubList list = this;
                final int n2 = n;
                final int n3 = 3;
                BytecodeManager.incBytecodes(n3);
                list.rangeCheck(n2);
                final COWSubList list2 = this;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                list2.checkForComodification();
                final COWSubList list3 = this;
                final CopyOnWriteArrayList<E> list4 = list3.l;
                final int n5 = n;
                final COWSubList list5 = this;
                final int n6 = list5.offset;
                final int n7 = n5 + n6;
                final int n8 = 7;
                BytecodeManager.incBytecodes(n8);
                final E e = list4.remove(n7);
                final int n9 = 1;
                BytecodeManager.incBytecodes(n9);
                final COWSubList list6 = this;
                final COWSubList list7 = this;
                final CopyOnWriteArrayList<E> list8 = list7.l;
                final int n10 = 4;
                BytecodeManager.incBytecodes(n10);
                final Object[] array = list8.getArray();
                list6.expectedArray = array;
                final int n11 = 1;
                BytecodeManager.incBytecodes(n11);
                final COWSubList list9 = this;
                final int n12 = list9.size;
                final int n13 = 1;
                final int n14 = n12 - n13;
                list9.size = n14;
                final int n15 = 6;
                BytecodeManager.incBytecodes(n15);
                final E e2 = e;
                final int n16 = 2;
                BytecodeManager.incBytecodes(n16);
                final ReentrantLock reentrantLock2 = lock;
                final int n17 = 2;
                BytecodeManager.incBytecodes(n17);
                reentrantLock2.unlock();
                final E e3 = e2;
                final int n18 = 2;
                BytecodeManager.incBytecodes(n18);
                return e3;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final int index = this.indexOf(o);
                BytecodeManager.incBytecodes(1);
                final int n = index;
                final int n2 = -1;
                BytecodeManager.incBytecodes(3);
                if (n == n2) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final int n3 = index;
                BytecodeManager.incBytecodes(3);
                this.remove(n3);
                BytecodeManager.incBytecodes(1);
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
            ReentrantLock lock;
            try {
                lock = this.l.lock;
                BytecodeManager.incBytecodes(4);
                final ReentrantLock reentrantLock = lock;
                BytecodeManager.incBytecodes(2);
                reentrantLock.lock();
                try {
                    final COWSubList list = this;
                    final int n = 2;
                    BytecodeManager.incBytecodes(n);
                    list.checkForComodification();
                    final COWSubList list2 = this;
                    final CopyOnWriteArrayList<E> list3 = list2.l;
                    final int n2 = 0;
                    final COWSubList list4 = this;
                    final int n3 = list4.offset;
                    final COWSubList list5 = this;
                    final int n4 = list5.size;
                    final int n5 = 10;
                    BytecodeManager.incBytecodes(n5);
                    final COWSubListIterator cowSubListIterator = new COWSubListIterator(list3, n2, n3, n4);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(b ? 1 : 0);
                    final ReentrantLock reentrantLock2 = lock;
                    final int n6 = 2;
                    BytecodeManager.incBytecodes(n6);
                    reentrantLock2.unlock();
                    final COWSubListIterator cowSubListIterator2 = cowSubListIterator;
                    final int n7 = 2;
                    BytecodeManager.incBytecodes(n7);
                    return (Iterator<E>)cowSubListIterator2;
                }
                finally {
                    final ReentrantLock reentrantLock3 = lock;
                    BytecodeManager.incBytecodes(503);
                    reentrantLock3.unlock();
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {}
            try {
                final COWSubList list = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                list.checkForComodification();
                final COWSubList list2 = this;
                final CopyOnWriteArrayList<E> list3 = list2.l;
                final int n2 = 0;
                final COWSubList list4 = this;
                final int n3 = list4.offset;
                final COWSubList list5 = this;
                final int n4 = list5.size;
                final int n5 = 10;
                BytecodeManager.incBytecodes(n5);
                final COWSubListIterator cowSubListIterator = new COWSubListIterator(list3, n2, n3, n4);
                final boolean b = true;
                BytecodeManager.incBytecodes(b ? 1 : 0);
                final ReentrantLock reentrantLock2 = lock;
                final int n6 = 2;
                BytecodeManager.incBytecodes(n6);
                reentrantLock2.unlock();
                final COWSubListIterator cowSubListIterator2 = cowSubListIterator;
                final int n7 = 2;
                BytecodeManager.incBytecodes(n7);
                return (Iterator<E>)cowSubListIterator2;
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        @Override
        public ListIterator<E> listIterator(final int p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //     4: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_2       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_2        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.checkForComodification:()V
            //    31: iload_1        
            //    32: ldc             2
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: iflt            53
            //    40: iload_1        
            //    41: aload_0        
            //    42: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    45: ldc             4
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: if_icmple       132
            //    53: new             Ljava/lang/IndexOutOfBoundsException;
            //    56: dup            
            //    57: new             Ljava/lang/StringBuilder;
            //    60: dup            
            //    61: ldc             5
            //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    66: invokespecial   java/lang/StringBuilder.<init>:()V
            //    69: ldc             "Index: "
            //    71: ldc             2
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    79: iload_1        
            //    80: ldc             2
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
            //    88: ldc             ", Size: "
            //    90: ldc             2
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    98: aload_0        
            //    99: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   102: ldc             3
            //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   107: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
            //   110: ldc             1
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   118: ldc             1
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: invokespecial   java/lang/IndexOutOfBoundsException.<init>:(Ljava/lang/String;)V
            //   126: ldc             1
            //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   131: athrow         
            //   132: new             Linstrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubListIterator;
            //   135: dup            
            //   136: aload_0        
            //   137: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   140: iload_1        
            //   141: aload_0        
            //   142: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //   145: aload_0        
            //   146: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   149: ldc             10
            //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   154: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubListIterator.<init>:(Linstrumented/java/util/List;III)V
            //   157: astore_3       
            //   158: ldc             1
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: aload_2        
            //   164: ldc             2
            //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   169: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   172: aload_3        
            //   173: ldc             2
            //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   178: areturn        
            //   179: astore          4
            //   181: ldc             501
            //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   186: aload_2        
            //   187: ldc             2
            //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   192: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   195: aload           4
            //   197: ldc             2
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: athrow         
            //   203: athrow         
            //   204: athrow         
            //    Signature:
            //  (I)Linstrumented/java/util/ListIterator<TE;>;
            //    StackMapTable: 00 05 FC 00 35 07 00 5A FB 00 4E 6E 07 00 34 FF 00 17 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     204    204    205    Ljava/lang/VirtualMachineError;
            //  22     163    179    203    Any
            //  179    186    179    203    Any
            //  0      203    203    204    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0053:
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
        public List<E> subList(final int p0, final int p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //     4: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_3       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_3        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.checkForComodification:()V
            //    31: iload_1        
            //    32: ldc             2
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: iflt            63
            //    40: iload_2        
            //    41: aload_0        
            //    42: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    45: ldc             4
            //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    50: if_icmpgt       63
            //    53: iload_1        
            //    54: iload_2        
            //    55: ldc             3
            //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    60: if_icmple       81
            //    63: new             Ljava/lang/IndexOutOfBoundsException;
            //    66: dup            
            //    67: ldc             3
            //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    72: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //    75: ldc             1
            //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    80: athrow         
            //    81: new             Linstrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList;
            //    84: dup            
            //    85: aload_0        
            //    86: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    89: iload_1        
            //    90: aload_0        
            //    91: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    94: iadd           
            //    95: iload_2        
            //    96: aload_0        
            //    97: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //   100: iadd           
            //   101: ldc             13
            //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   106: invokespecial   instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.<init>:(Linstrumented/java/util/concurrent/CopyOnWriteArrayList;II)V
            //   109: astore          4
            //   111: ldc             1
            //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   116: aload_3        
            //   117: ldc             2
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   125: aload           4
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: areturn        
            //   133: astore          5
            //   135: ldc             501
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: aload_3        
            //   141: ldc             2
            //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   146: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   149: aload           5
            //   151: ldc             2
            //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   156: athrow         
            //   157: athrow         
            //   158: athrow         
            //    Signature:
            //  (II)Linstrumented/java/util/List<TE;>;
            //    StackMapTable: 00 05 FC 00 3F 07 00 5A 11 73 07 00 34 FF 00 17 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     158    158    159    Ljava/lang/VirtualMachineError;
            //  22     116    133    157    Any
            //  133    140    133    157    Any
            //  0      157    157    158    Any
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
        
        public void forEach(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int offset = this.offset;
                BytecodeManager.incBytecodes(3);
                final int n = this.offset + this.size;
                BytecodeManager.incBytecodes(6);
                final Object[] expectedArray = this.expectedArray;
                BytecodeManager.incBytecodes(3);
                final CopyOnWriteArrayList<E> l = this.l;
                BytecodeManager.incBytecodes(3);
                final Object[] array = l.getArray();
                final Object[] array2 = expectedArray;
                BytecodeManager.incBytecodes(2);
                if (array != array2) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final int n2 = offset;
                BytecodeManager.incBytecodes(2);
                if (n2 >= 0) {
                    final int n3 = n;
                    final int length = expectedArray.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 <= length) {
                        int n4 = offset;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final int n5 = n4;
                            final int n6 = n;
                            BytecodeManager.incBytecodes(3);
                            if (n5 >= n6) {
                                break;
                            }
                            final Object o = expectedArray[n4];
                            BytecodeManager.incBytecodes(4);
                            final Object o2 = o;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept((Object)o2);
                            ++n4;
                            BytecodeManager.incBytecodes(2);
                        }
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex3 = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void replaceAll(final UnaryOperator<E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnonnull       27
            //     9: new             Ljava/lang/NullPointerException;
            //    12: dup            
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokespecial   java/lang/NullPointerException.<init>:()V
            //    21: ldc             1
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: athrow         
            //    27: aload_0        
            //    28: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    31: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    34: astore_2       
            //    35: ldc             4
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: aload_2        
            //    41: ldc             2
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    49: aload_0        
            //    50: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    53: istore_3       
            //    54: ldc             3
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: aload_0        
            //    60: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    63: aload_0        
            //    64: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    67: iadd           
            //    68: istore          4
            //    70: ldc             6
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: aload_0        
            //    76: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //    79: astore          5
            //    81: ldc             3
            //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    86: aload_0        
            //    87: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    90: ldc             3
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //    98: aload           5
            //   100: ldc             2
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: if_acmpeq       126
            //   108: new             Linstrumented/java/util/ConcurrentModificationException;
            //   111: dup            
            //   112: ldc             3
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   120: ldc             1
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: athrow         
            //   126: aload           5
            //   128: arraylength    
            //   129: istore          6
            //   131: ldc             3
            //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   136: iload_3        
            //   137: ldc             2
            //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   142: iflt            157
            //   145: iload           4
            //   147: iload           6
            //   149: ldc             3
            //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   154: if_icmple       175
            //   157: new             Ljava/lang/IndexOutOfBoundsException;
            //   160: dup            
            //   161: ldc             3
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //   169: ldc             1
            //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   174: athrow         
            //   175: aload           5
            //   177: iload           6
            //   179: ldc             3
            //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   184: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
            //   187: astore          7
            //   189: ldc             1
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: iload_3        
            //   195: istore          8
            //   197: ldc             2
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: iload           8
            //   204: iload           4
            //   206: ldc             3
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: if_icmpge       260
            //   214: aload           5
            //   216: iload           8
            //   218: aaload         
            //   219: astore          9
            //   221: ldc             4
            //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   226: aload           7
            //   228: iload           8
            //   230: aload_1        
            //   231: aload           9
            //   233: ldc             5
            //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   238: invokeinterface instrumented/java/util/function/UnaryOperator.apply:(Ljava/lang/Object;)Ljava/lang/Object;
            //   243: aastore        
            //   244: ldc             1
            //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   249: iinc            8, 1
            //   252: ldc             2
            //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   257: goto            202
            //   260: aload_0        
            //   261: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   264: aload_0        
            //   265: aload           7
            //   267: dup_x1         
            //   268: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   271: ldc             7
            //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   276: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
            //   279: aload_2        
            //   280: ldc             2
            //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   285: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   288: ldc             1
            //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   293: goto            320
            //   296: astore          10
            //   298: ldc             501
            //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   303: aload_2        
            //   304: ldc             2
            //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   309: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   312: aload           10
            //   314: ldc             2
            //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   319: athrow         
            //   320: ldc             1
            //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   325: return         
            //   326: athrow         
            //   327: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/UnaryOperator<TE;>;)V
            //    StackMapTable: 00 0A 1B FF 00 62 00 06 07 00 02 07 00 A3 07 00 5A 01 01 07 00 99 00 00 FC 00 1E 01 11 FD 00 1A 07 00 99 01 FA 00 39 FF 00 23 00 03 07 00 02 07 00 A3 07 00 5A 00 01 07 00 34 17 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  49     327    327    328    Ljava/lang/VirtualMachineError;
            //  49     279    296    320    Any
            //  296    303    296    320    Any
            //  0      326    326    327    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0126:
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
            //     1: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //     4: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_2       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_2        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    26: istore_3       
            //    27: ldc             3
            //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    32: aload_0        
            //    33: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    36: aload_0        
            //    37: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    40: iadd           
            //    41: istore          4
            //    43: ldc             6
            //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    48: aload_0        
            //    49: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //    52: astore          5
            //    54: ldc             3
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: aload_0        
            //    60: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    63: ldc             3
            //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    68: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //    71: aload           5
            //    73: ldc             2
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: if_acmpeq       99
            //    81: new             Linstrumented/java/util/ConcurrentModificationException;
            //    84: dup            
            //    85: ldc             3
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //    93: ldc             1
            //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    98: athrow         
            //    99: aload           5
            //   101: arraylength    
            //   102: istore          6
            //   104: ldc             3
            //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   109: iload_3        
            //   110: ldc             2
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: iflt            130
            //   118: iload           4
            //   120: iload           6
            //   122: ldc             3
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: if_icmple       148
            //   130: new             Ljava/lang/IndexOutOfBoundsException;
            //   133: dup            
            //   134: ldc             3
            //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   139: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //   142: ldc             1
            //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   147: athrow         
            //   148: aload           5
            //   150: iload           6
            //   152: ldc             3
            //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   157: invokestatic    instrumented/java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
            //   160: astore          7
            //   162: ldc             1
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: aload           7
            //   169: checkcast       [Ljava/lang/Object;
            //   172: astore          8
            //   174: ldc             3
            //   176: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   179: aload           8
            //   181: iload_3        
            //   182: iload           4
            //   184: aload_1        
            //   185: ldc             5
            //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   190: invokestatic    instrumented/java/util/Arrays.sort:([Ljava/lang/Object;IILinstrumented/java/util/Comparator;)V
            //   193: aload_0        
            //   194: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   197: aload_0        
            //   198: aload           7
            //   200: dup_x1         
            //   201: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   204: ldc             7
            //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   209: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
            //   212: aload_2        
            //   213: ldc             2
            //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   218: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   221: ldc             1
            //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   226: goto            253
            //   229: astore          9
            //   231: ldc             501
            //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   236: aload_2        
            //   237: ldc             2
            //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   242: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   245: aload           9
            //   247: ldc             2
            //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   252: athrow         
            //   253: ldc             1
            //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   258: return         
            //   259: athrow         
            //   260: athrow         
            //    Signature:
            //  (Linstrumented/java/util/Comparator<-TE;>;)V
            //    StackMapTable: 00 07 FF 00 63 00 06 07 00 02 07 00 B5 07 00 5A 01 01 07 00 99 00 00 FC 00 1E 01 11 FF 00 50 00 03 07 00 02 07 00 B5 07 00 5A 00 01 07 00 34 17 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     260    260    261    Ljava/lang/VirtualMachineError;
            //  22     212    229    253    Any
            //  229    236    229    253    Any
            //  0      259    259    260    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0099:
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
        public boolean removeAll(final Collection<?> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnonnull       27
            //     9: new             Ljava/lang/NullPointerException;
            //    12: dup            
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokespecial   java/lang/NullPointerException.<init>:()V
            //    21: ldc             1
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: athrow         
            //    27: iconst_0       
            //    28: istore_2       
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: aload_0        
            //    35: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    38: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    41: astore_3       
            //    42: ldc             4
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_3        
            //    48: ldc             2
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    60: istore          4
            //    62: ldc             3
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: iload           4
            //    69: ldc             2
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ifle            427
            //    77: aload_0        
            //    78: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    81: istore          5
            //    83: ldc             3
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_0        
            //    89: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    92: iload           4
            //    94: iadd           
            //    95: istore          6
            //    97: ldc             5
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: aload_0        
            //   103: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   106: astore          7
            //   108: ldc             3
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: aload_0        
            //   114: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   117: ldc             3
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //   125: aload           7
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: if_acmpeq       153
            //   135: new             Linstrumented/java/util/ConcurrentModificationException;
            //   138: dup            
            //   139: ldc             3
            //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   144: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   147: ldc             1
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: athrow         
            //   153: aload           7
            //   155: arraylength    
            //   156: istore          8
            //   158: ldc             3
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: iload           5
            //   165: ldc             2
            //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   170: iflt            185
            //   173: iload           6
            //   175: iload           8
            //   177: ldc             3
            //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   182: if_icmple       203
            //   185: new             Ljava/lang/IndexOutOfBoundsException;
            //   188: dup            
            //   189: ldc             3
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //   197: ldc             1
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: athrow         
            //   203: iconst_0       
            //   204: istore          9
            //   206: ldc             2
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: iload           4
            //   213: anewarray       Ljava/lang/Object;
            //   216: astore          10
            //   218: ldc             2
            //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   223: iload           5
            //   225: istore          11
            //   227: ldc             2
            //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   232: iload           11
            //   234: iload           6
            //   236: ldc             3
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: if_icmpge       303
            //   244: aload           7
            //   246: iload           11
            //   248: aaload         
            //   249: astore          12
            //   251: ldc             4
            //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   256: aload_1        
            //   257: aload           12
            //   259: ldc             3
            //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   264: invokeinterface instrumented/java/util/Collection.contains:(Ljava/lang/Object;)Z
            //   269: ldc             1
            //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   274: ifne            292
            //   277: aload           10
            //   279: iload           9
            //   281: iinc            9, 1
            //   284: aload           12
            //   286: aastore        
            //   287: ldc             5
            //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   292: iinc            11, 1
            //   295: ldc             2
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: goto            232
            //   303: iload           9
            //   305: iload           4
            //   307: ldc             3
            //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   312: if_icmpeq       427
            //   315: iload           8
            //   317: iload           4
            //   319: isub           
            //   320: iload           9
            //   322: iadd           
            //   323: anewarray       Ljava/lang/Object;
            //   326: astore          11
            //   328: ldc             6
            //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   333: aload           7
            //   335: iconst_0       
            //   336: aload           11
            //   338: iconst_0       
            //   339: iload           5
            //   341: ldc             6
            //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   346: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   349: aload           10
            //   351: iconst_0       
            //   352: aload           11
            //   354: iload           5
            //   356: iload           9
            //   358: ldc             6
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   366: aload           7
            //   368: iload           6
            //   370: aload           11
            //   372: iload           5
            //   374: iload           9
            //   376: iadd           
            //   377: iload           8
            //   379: iload           6
            //   381: isub           
            //   382: ldc             10
            //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   387: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   390: aload_0        
            //   391: iload           9
            //   393: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   396: ldc             3
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: iconst_1       
            //   402: istore_2       
            //   403: ldc             2
            //   405: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   408: aload_0        
            //   409: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   412: aload_0        
            //   413: aload           11
            //   415: dup_x1         
            //   416: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   419: ldc             7
            //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   424: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
            //   427: aload_3        
            //   428: ldc             2
            //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   433: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   436: ldc             1
            //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   441: goto            468
            //   444: astore          13
            //   446: ldc             501
            //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   451: aload_3        
            //   452: ldc             2
            //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   457: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   460: aload           13
            //   462: ldc             2
            //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   467: athrow         
            //   468: iload_2        
            //   469: ldc             2
            //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   474: ireturn        
            //   475: athrow         
            //   476: athrow         
            //    Signature:
            //  (Linstrumented/java/util/Collection<*>;)Z
            //    StackMapTable: 00 0C 1B FF 00 7D 00 08 07 00 02 07 00 BC 01 07 00 5A 01 01 01 07 00 99 00 00 FC 00 1F 01 11 FE 00 1C 01 07 00 99 01 3B FA 00 0A FF 00 7B 00 04 07 00 02 07 00 BC 01 07 00 5A 00 00 50 07 00 34 17 FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  56     476    476    477    Ljava/lang/VirtualMachineError;
            //  56     427    444    468    Any
            //  444    451    444    468    Any
            //  0      475    475    476    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0153:
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
        public boolean retainAll(final Collection<?> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnonnull       27
            //     9: new             Ljava/lang/NullPointerException;
            //    12: dup            
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokespecial   java/lang/NullPointerException.<init>:()V
            //    21: ldc             1
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: athrow         
            //    27: iconst_0       
            //    28: istore_2       
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: aload_0        
            //    35: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    38: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    41: astore_3       
            //    42: ldc             4
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_3        
            //    48: ldc             2
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    60: istore          4
            //    62: ldc             3
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: iload           4
            //    69: ldc             2
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ifle            427
            //    77: aload_0        
            //    78: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    81: istore          5
            //    83: ldc             3
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_0        
            //    89: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    92: iload           4
            //    94: iadd           
            //    95: istore          6
            //    97: ldc             5
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: aload_0        
            //   103: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   106: astore          7
            //   108: ldc             3
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: aload_0        
            //   114: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   117: ldc             3
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //   125: aload           7
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: if_acmpeq       153
            //   135: new             Linstrumented/java/util/ConcurrentModificationException;
            //   138: dup            
            //   139: ldc             3
            //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   144: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   147: ldc             1
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: athrow         
            //   153: aload           7
            //   155: arraylength    
            //   156: istore          8
            //   158: ldc             3
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: iload           5
            //   165: ldc             2
            //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   170: iflt            185
            //   173: iload           6
            //   175: iload           8
            //   177: ldc             3
            //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   182: if_icmple       203
            //   185: new             Ljava/lang/IndexOutOfBoundsException;
            //   188: dup            
            //   189: ldc             3
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //   197: ldc             1
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: athrow         
            //   203: iconst_0       
            //   204: istore          9
            //   206: ldc             2
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: iload           4
            //   213: anewarray       Ljava/lang/Object;
            //   216: astore          10
            //   218: ldc             2
            //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   223: iload           5
            //   225: istore          11
            //   227: ldc             2
            //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   232: iload           11
            //   234: iload           6
            //   236: ldc             3
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: if_icmpge       303
            //   244: aload           7
            //   246: iload           11
            //   248: aaload         
            //   249: astore          12
            //   251: ldc             4
            //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   256: aload_1        
            //   257: aload           12
            //   259: ldc             3
            //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   264: invokeinterface instrumented/java/util/Collection.contains:(Ljava/lang/Object;)Z
            //   269: ldc             1
            //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   274: ifeq            292
            //   277: aload           10
            //   279: iload           9
            //   281: iinc            9, 1
            //   284: aload           12
            //   286: aastore        
            //   287: ldc             5
            //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   292: iinc            11, 1
            //   295: ldc             2
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: goto            232
            //   303: iload           9
            //   305: iload           4
            //   307: ldc             3
            //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   312: if_icmpeq       427
            //   315: iload           8
            //   317: iload           4
            //   319: isub           
            //   320: iload           9
            //   322: iadd           
            //   323: anewarray       Ljava/lang/Object;
            //   326: astore          11
            //   328: ldc             6
            //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   333: aload           7
            //   335: iconst_0       
            //   336: aload           11
            //   338: iconst_0       
            //   339: iload           5
            //   341: ldc             6
            //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   346: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   349: aload           10
            //   351: iconst_0       
            //   352: aload           11
            //   354: iload           5
            //   356: iload           9
            //   358: ldc             6
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   366: aload           7
            //   368: iload           6
            //   370: aload           11
            //   372: iload           5
            //   374: iload           9
            //   376: iadd           
            //   377: iload           8
            //   379: iload           6
            //   381: isub           
            //   382: ldc             10
            //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   387: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   390: aload_0        
            //   391: iload           9
            //   393: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   396: ldc             3
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: iconst_1       
            //   402: istore_2       
            //   403: ldc             2
            //   405: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   408: aload_0        
            //   409: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   412: aload_0        
            //   413: aload           11
            //   415: dup_x1         
            //   416: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   419: ldc             7
            //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   424: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
            //   427: aload_3        
            //   428: ldc             2
            //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   433: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   436: ldc             1
            //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   441: goto            468
            //   444: astore          13
            //   446: ldc             501
            //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   451: aload_3        
            //   452: ldc             2
            //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   457: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   460: aload           13
            //   462: ldc             2
            //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   467: athrow         
            //   468: iload_2        
            //   469: ldc             2
            //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   474: ireturn        
            //   475: athrow         
            //   476: athrow         
            //    Signature:
            //  (Linstrumented/java/util/Collection<*>;)Z
            //    StackMapTable: 00 0C 1B FF 00 7D 00 08 07 00 02 07 00 BC 01 07 00 5A 01 01 01 07 00 99 00 00 FC 00 1F 01 11 FE 00 1C 01 07 00 99 01 3B FA 00 0A FF 00 7B 00 04 07 00 02 07 00 BC 01 07 00 5A 00 00 50 07 00 34 17 FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  56     476    476    477    Ljava/lang/VirtualMachineError;
            //  56     427    444    468    Any
            //  444    451    444    468    Any
            //  0      475    475    476    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0153:
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
        public boolean removeIf(final Predicate<? super E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: ifnonnull       27
            //     9: new             Ljava/lang/NullPointerException;
            //    12: dup            
            //    13: ldc             3
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokespecial   java/lang/NullPointerException.<init>:()V
            //    21: ldc             1
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: athrow         
            //    27: iconst_0       
            //    28: istore_2       
            //    29: ldc             2
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: aload_0        
            //    35: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //    38: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    41: astore_3       
            //    42: ldc             4
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_3        
            //    48: ldc             2
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //    60: istore          4
            //    62: ldc             3
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: iload           4
            //    69: ldc             2
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: ifle            427
            //    77: aload_0        
            //    78: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    81: istore          5
            //    83: ldc             3
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_0        
            //    89: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.offset:I
            //    92: iload           4
            //    94: iadd           
            //    95: istore          6
            //    97: ldc             5
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: aload_0        
            //   103: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   106: astore          7
            //   108: ldc             3
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: aload_0        
            //   114: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   117: ldc             3
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.getArray:()[Ljava/lang/Object;
            //   125: aload           7
            //   127: ldc             2
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: if_acmpeq       153
            //   135: new             Linstrumented/java/util/ConcurrentModificationException;
            //   138: dup            
            //   139: ldc             3
            //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   144: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   147: ldc             1
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: athrow         
            //   153: aload           7
            //   155: arraylength    
            //   156: istore          8
            //   158: ldc             3
            //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   163: iload           5
            //   165: ldc             2
            //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   170: iflt            185
            //   173: iload           6
            //   175: iload           8
            //   177: ldc             3
            //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   182: if_icmple       203
            //   185: new             Ljava/lang/IndexOutOfBoundsException;
            //   188: dup            
            //   189: ldc             3
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: invokespecial   java/lang/IndexOutOfBoundsException.<init>:()V
            //   197: ldc             1
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: athrow         
            //   203: iconst_0       
            //   204: istore          9
            //   206: ldc             2
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: iload           4
            //   213: anewarray       Ljava/lang/Object;
            //   216: astore          10
            //   218: ldc             2
            //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   223: iload           5
            //   225: istore          11
            //   227: ldc             2
            //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   232: iload           11
            //   234: iload           6
            //   236: ldc             3
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: if_icmpge       303
            //   244: aload           7
            //   246: iload           11
            //   248: aaload         
            //   249: astore          12
            //   251: ldc             4
            //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   256: aload_1        
            //   257: aload           12
            //   259: ldc             3
            //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   264: invokeinterface instrumented/java/util/function/Predicate.test:(Ljava/lang/Object;)Z
            //   269: ldc             1
            //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   274: ifne            292
            //   277: aload           10
            //   279: iload           9
            //   281: iinc            9, 1
            //   284: aload           12
            //   286: aastore        
            //   287: ldc             5
            //   289: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   292: iinc            11, 1
            //   295: ldc             2
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: goto            232
            //   303: iload           9
            //   305: iload           4
            //   307: ldc             3
            //   309: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   312: if_icmpeq       427
            //   315: iload           8
            //   317: iload           4
            //   319: isub           
            //   320: iload           9
            //   322: iadd           
            //   323: anewarray       Ljava/lang/Object;
            //   326: astore          11
            //   328: ldc             6
            //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   333: aload           7
            //   335: iconst_0       
            //   336: aload           11
            //   338: iconst_0       
            //   339: iload           5
            //   341: ldc             6
            //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   346: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   349: aload           10
            //   351: iconst_0       
            //   352: aload           11
            //   354: iload           5
            //   356: iload           9
            //   358: ldc             6
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   366: aload           7
            //   368: iload           6
            //   370: aload           11
            //   372: iload           5
            //   374: iload           9
            //   376: iadd           
            //   377: iload           8
            //   379: iload           6
            //   381: isub           
            //   382: ldc             10
            //   384: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   387: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
            //   390: aload_0        
            //   391: iload           9
            //   393: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.size:I
            //   396: ldc             3
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: iconst_1       
            //   402: istore_2       
            //   403: ldc             2
            //   405: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   408: aload_0        
            //   409: getfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.l:Linstrumented/java/util/concurrent/CopyOnWriteArrayList;
            //   412: aload_0        
            //   413: aload           11
            //   415: dup_x1         
            //   416: putfield        instrumented/java/util/concurrent/CopyOnWriteArrayList$COWSubList.expectedArray:[Ljava/lang/Object;
            //   419: ldc             7
            //   421: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   424: invokevirtual   instrumented/java/util/concurrent/CopyOnWriteArrayList.setArray:([Ljava/lang/Object;)V
            //   427: aload_3        
            //   428: ldc             2
            //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   433: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   436: ldc             1
            //   438: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   441: goto            468
            //   444: astore          13
            //   446: ldc             501
            //   448: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   451: aload_3        
            //   452: ldc             2
            //   454: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   457: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   460: aload           13
            //   462: ldc             2
            //   464: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   467: athrow         
            //   468: iload_2        
            //   469: ldc             2
            //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   474: ireturn        
            //   475: athrow         
            //   476: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Predicate<-TE;>;)Z
            //    StackMapTable: 00 0C 1B FF 00 7D 00 08 07 00 02 07 00 CA 01 07 00 5A 01 01 01 07 00 99 00 00 FC 00 1F 01 11 FE 00 1C 01 07 00 99 01 3B FA 00 0A FF 00 7B 00 04 07 00 02 07 00 CA 01 07 00 5A 00 00 50 07 00 34 17 FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 54
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  56     476    476    477    Ljava/lang/VirtualMachineError;
            //  56     427    444    468    Any
            //  444    451    444    468    Any
            //  0      475    475    476    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0153:
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
        public Spliterator<E> spliterator() {
            try {
                final int offset = this.offset;
                BytecodeManager.incBytecodes(3);
                final int n = this.offset + this.size;
                BytecodeManager.incBytecodes(6);
                final Object[] expectedArray = this.expectedArray;
                BytecodeManager.incBytecodes(3);
                final CopyOnWriteArrayList<E> l = this.l;
                BytecodeManager.incBytecodes(3);
                final Object[] array = l.getArray();
                final Object[] array2 = expectedArray;
                BytecodeManager.incBytecodes(2);
                if (array != array2) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int n2 = offset;
                BytecodeManager.incBytecodes(2);
                if (n2 >= 0) {
                    final int n3 = n;
                    final int length = expectedArray.length;
                    BytecodeManager.incBytecodes(4);
                    if (n3 <= length) {
                        final Object[] array3 = expectedArray;
                        final int n4 = offset;
                        final int n5 = n;
                        final int n6 = 1040;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<Object> spliterator = (Spliterator<Object>)Spliterators.spliterator(array3, n4, n5, n6);
                        BytecodeManager.incBytecodes(1);
                        return (Spliterator<E>)spliterator;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final IndexOutOfBoundsException ex2 = new IndexOutOfBoundsException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class COWSubListIterator<E> implements ListIterator<E>
    {
        private final ListIterator<E> it;
        private final int offset;
        private final int size;
        
        COWSubListIterator(final List<E> list, final int n, final int offset, final int size) {
            try {
                BytecodeManager.incBytecodes(2);
                this.offset = offset;
                BytecodeManager.incBytecodes(3);
                this.size = size;
                BytecodeManager.incBytecodes(3);
                final int n2 = n + offset;
                BytecodeManager.incBytecodes(6);
                this.it = list.listIterator(n2);
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
                BytecodeManager.incBytecodes(2);
                final int nextIndex = this.nextIndex();
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (nextIndex < size) {
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
                    final ListIterator<E> it = this.it;
                    BytecodeManager.incBytecodes(3);
                    final E next = it.next();
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
                    final ListIterator<E> it = this.it;
                    BytecodeManager.incBytecodes(3);
                    final E previous = it.previous();
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
                final ListIterator<E> it = this.it;
                BytecodeManager.incBytecodes(3);
                final int n = it.nextIndex() - this.offset;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int previousIndex() {
            try {
                final ListIterator<E> it = this.it;
                BytecodeManager.incBytecodes(3);
                final int n = it.previousIndex() - this.offset;
                BytecodeManager.incBytecodes(4);
                return n;
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
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(consumer);
                BytecodeManager.incBytecodes(1);
                final int size = this.size;
                BytecodeManager.incBytecodes(3);
                final ListIterator<E> it = this.it;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    final int nextIndex = this.nextIndex();
                    final int n = size;
                    BytecodeManager.incBytecodes(2);
                    if (nextIndex >= n) {
                        break;
                    }
                    final ListIterator<E> listIterator = it;
                    BytecodeManager.incBytecodes(3);
                    final E next = listIterator.next();
                    BytecodeManager.incBytecodes(1);
                    consumer.accept(next);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
