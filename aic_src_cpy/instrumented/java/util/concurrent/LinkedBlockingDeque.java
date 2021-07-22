// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.function.Consumer;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import instrumented.java.util.Spliterator;
import java.util.Iterator;
import instrumented.java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import instrumented.java.util.Collection;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.concurrent.locks.Condition;
import instrumented.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;
import instrumented.java.util.AbstractQueue;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable
{
    private static final long serialVersionUID = -387911632671998426L;
    transient Node<E> first;
    transient Node<E> last;
    private transient int count;
    private final int capacity;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    
    public LinkedBlockingDeque() {
        try {
            final int n = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(3);
            this(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedBlockingDeque(final int capacity) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.lock = new ReentrantLock();
            BytecodeManager.incBytecodes(1);
            final ReentrantLock lock = this.lock;
            BytecodeManager.incBytecodes(4);
            this.notEmpty = lock.newCondition();
            BytecodeManager.incBytecodes(1);
            final ReentrantLock lock2 = this.lock;
            BytecodeManager.incBytecodes(4);
            this.notFull = lock2.newCondition();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            if (capacity <= 0) {
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.capacity = capacity;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedBlockingDeque(final Collection<? extends E> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2147483647
        //     3: ldc             3
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.<init>:(I)V
        //    11: aload_0        
        //    12: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    15: astore_2       
        //    16: ldc             3
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: aload_2        
        //    22: ldc             2
        //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    27: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    30: aload_1        
        //    31: ldc             2
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokeinterface instrumented/java/util/Collection.iterator:()Ljava/util/Iterator;
        //    41: astore_3       
        //    42: ldc             1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload_3        
        //    48: ldc             2
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokeinterface java/util/Iterator.hasNext:()Z
        //    58: ldc             1
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ifeq            171
        //    66: aload_3        
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    77: astore          4
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: aload           4
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: ifnonnull       112
        //    94: new             Ljava/lang/NullPointerException;
        //    97: dup            
        //    98: ldc             3
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   java/lang/NullPointerException.<init>:()V
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: athrow         
        //   112: aload_0        
        //   113: new             Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   116: dup            
        //   117: aload           4
        //   119: ldc             5
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$Node.<init>:(Ljava/lang/Object;)V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.linkLast:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Z
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ifne            163
        //   143: new             Ljava/lang/IllegalStateException;
        //   146: dup            
        //   147: ldc             "Deque full"
        //   149: ldc             4
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   157: ldc             1
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: athrow         
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: goto            47
        //   171: aload_2        
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: goto            212
        //   188: astore          5
        //   190: ldc             501
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: aload_2        
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   204: aload           5
        //   206: ldc             2
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: athrow         
        //   212: ldc             1
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: return         
        //   218: athrow         
        //   219: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<+TE;>;)V
        //    StackMapTable: 00 08 FF 00 2F 00 04 07 00 02 07 00 57 07 00 3F 07 00 5D 00 00 FC 00 40 07 00 6A FA 00 32 FA 00 07 50 07 00 3A 17 FF 00 05 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  30     219    219    220    Ljava/lang/VirtualMachineError;
        //  30     171    188    212    Any
        //  188    195    188    212    Any
        //  0      218    218    219    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    private boolean linkFirst(final Node<E> prev) {
        try {
            final int count = this.count;
            final int capacity = this.capacity;
            BytecodeManager.incBytecodes(5);
            if (count >= capacity) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            prev.next = first;
            BytecodeManager.incBytecodes(3);
            this.first = prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            if (last == null) {
                this.last = prev;
                BytecodeManager.incBytecodes(4);
            }
            else {
                first.prev = prev;
                BytecodeManager.incBytecodes(3);
            }
            ++this.count;
            BytecodeManager.incBytecodes(6);
            final Condition notEmpty = this.notEmpty;
            BytecodeManager.incBytecodes(3);
            notEmpty.signal();
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean linkLast(final Node<E> next) {
        try {
            final int count = this.count;
            final int capacity = this.capacity;
            BytecodeManager.incBytecodes(5);
            if (count >= capacity) {
                final boolean b = false;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            next.prev = last;
            BytecodeManager.incBytecodes(3);
            this.last = next;
            BytecodeManager.incBytecodes(3);
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            if (first == null) {
                this.first = next;
                BytecodeManager.incBytecodes(4);
            }
            else {
                last.next = next;
                BytecodeManager.incBytecodes(3);
            }
            ++this.count;
            BytecodeManager.incBytecodes(6);
            final Condition notEmpty = this.notEmpty;
            BytecodeManager.incBytecodes(3);
            notEmpty.signal();
            final boolean b2 = true;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E unlinkFirst() {
        try {
            final Node<E> first = this.first;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = first;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                final E e = null;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            final Node<E> next = first.next;
            BytecodeManager.incBytecodes(3);
            final E item = first.item;
            BytecodeManager.incBytecodes(3);
            first.item = null;
            BytecodeManager.incBytecodes(3);
            first.next = first;
            BytecodeManager.incBytecodes(3);
            this.first = next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = next;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                this.last = null;
                BytecodeManager.incBytecodes(4);
            }
            else {
                next.prev = null;
                BytecodeManager.incBytecodes(3);
            }
            --this.count;
            BytecodeManager.incBytecodes(6);
            final Condition notFull = this.notFull;
            BytecodeManager.incBytecodes(3);
            notFull.signal();
            final E e2 = item;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private E unlinkLast() {
        try {
            final Node<E> last = this.last;
            BytecodeManager.incBytecodes(3);
            final Node<E> node = last;
            BytecodeManager.incBytecodes(2);
            if (node == null) {
                final E e = null;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            final Node<E> prev = last.prev;
            BytecodeManager.incBytecodes(3);
            final E item = last.item;
            BytecodeManager.incBytecodes(3);
            last.item = null;
            BytecodeManager.incBytecodes(3);
            last.prev = last;
            BytecodeManager.incBytecodes(3);
            this.last = prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                this.first = null;
                BytecodeManager.incBytecodes(4);
            }
            else {
                prev.next = null;
                BytecodeManager.incBytecodes(3);
            }
            --this.count;
            BytecodeManager.incBytecodes(6);
            final Condition notFull = this.notFull;
            BytecodeManager.incBytecodes(3);
            notFull.signal();
            final E e2 = item;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void unlink(final Node<E> node) {
        try {
            final Node<E> prev = node.prev;
            BytecodeManager.incBytecodes(3);
            final Node<E> next = node.next;
            BytecodeManager.incBytecodes(3);
            final Node<E> node2 = prev;
            BytecodeManager.incBytecodes(2);
            if (node2 == null) {
                BytecodeManager.incBytecodes(2);
                this.unlinkFirst();
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Node<E> node3 = next;
                BytecodeManager.incBytecodes(2);
                if (node3 == null) {
                    BytecodeManager.incBytecodes(2);
                    this.unlinkLast();
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    prev.next = next;
                    BytecodeManager.incBytecodes(3);
                    next.prev = prev;
                    BytecodeManager.incBytecodes(3);
                    node.item = null;
                    BytecodeManager.incBytecodes(3);
                    --this.count;
                    BytecodeManager.incBytecodes(6);
                    final Condition notFull = this.notFull;
                    BytecodeManager.incBytecodes(3);
                    notFull.signal();
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addFirst(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean offerFirst = this.offerFirst(e);
            BytecodeManager.incBytecodes(1);
            if (!offerFirst) {
                final String s = "Deque full";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void addLast(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean offerLast = this.offerLast(e);
            BytecodeManager.incBytecodes(1);
            if (!offerLast) {
                final String s = "Deque full";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offerFirst(final E e) {
        Node<E> node;
        ReentrantLock lock;
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            node = new Node<E>(e);
            BytecodeManager.incBytecodes(1);
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final Node<E> node2 = node;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final boolean b = linkedBlockingDeque.linkFirst(node2);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final ReentrantLock reentrantLock2 = lock;
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                reentrantLock2.unlock();
                final boolean b2 = b;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                return b2;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final Node<E> node2 = node;
            final int n = 3;
            BytecodeManager.incBytecodes(n);
            final boolean b = linkedBlockingDeque.linkFirst(node2);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final ReentrantLock reentrantLock2 = lock;
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            reentrantLock2.unlock();
            final boolean b2 = b;
            final int n4 = 2;
            BytecodeManager.incBytecodes(n4);
            return b2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public boolean offerLast(final E e) {
        Node<E> node;
        ReentrantLock lock;
        try {
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            node = new Node<E>(e);
            BytecodeManager.incBytecodes(1);
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final Node<E> node2 = node;
                final int n = 3;
                BytecodeManager.incBytecodes(n);
                final boolean b = linkedBlockingDeque.linkLast(node2);
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final ReentrantLock reentrantLock2 = lock;
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                reentrantLock2.unlock();
                final boolean b2 = b;
                final int n4 = 2;
                BytecodeManager.incBytecodes(n4);
                return b2;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final Node<E> node2 = node;
            final int n = 3;
            BytecodeManager.incBytecodes(n);
            final boolean b = linkedBlockingDeque.linkLast(node2);
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final ReentrantLock reentrantLock2 = lock;
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            reentrantLock2.unlock();
            final boolean b2 = b;
            final int n4 = 2;
            BytecodeManager.incBytecodes(n4);
            return b2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public void putFirst(final E p0) throws InterruptedException {
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
        //    27: new             Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    30: dup            
        //    31: aload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$Node.<init>:(Ljava/lang/Object;)V
        //    40: astore_2       
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    50: astore_3       
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: aload_3        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    65: aload_0        
        //    66: aload_2        
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.linkFirst:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Z
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ifne            105
        //    83: aload_0        
        //    84: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notFull:Linstrumented/java/util/concurrent/locks/Condition;
        //    87: ldc             3
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokeinterface instrumented/java/util/concurrent/locks/Condition.await:()V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: goto            65
        //   105: aload_3        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: goto            146
        //   122: astore          4
        //   124: ldc             501
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload_3        
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   138: aload           4
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: athrow         
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: return         
        //   152: athrow         
        //   153: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (TE;)V
        //    StackMapTable: 00 07 1B FD 00 25 07 00 18 07 00 3F 27 50 07 00 3A 17 FF 00 05 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  65     153    153    154    Ljava/lang/VirtualMachineError;
        //  65     105    122    146    Any
        //  122    129    122    146    Any
        //  0      152    152    153    Any
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
    public void putLast(final E p0) throws InterruptedException {
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
        //    27: new             Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    30: dup            
        //    31: aload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$Node.<init>:(Ljava/lang/Object;)V
        //    40: astore_2       
        //    41: ldc             1
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    50: astore_3       
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: aload_3        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    65: aload_0        
        //    66: aload_2        
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.linkLast:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Z
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ifne            105
        //    83: aload_0        
        //    84: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notFull:Linstrumented/java/util/concurrent/locks/Condition;
        //    87: ldc             3
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokeinterface instrumented/java/util/concurrent/locks/Condition.await:()V
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: goto            65
        //   105: aload_3        
        //   106: ldc             2
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: goto            146
        //   122: astore          4
        //   124: ldc             501
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: aload_3        
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   138: aload           4
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: athrow         
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: return         
        //   152: athrow         
        //   153: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (TE;)V
        //    StackMapTable: 00 07 1B FD 00 25 07 00 18 07 00 3F 27 50 07 00 3A 17 FF 00 05 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  65     153    153    154    Ljava/lang/VirtualMachineError;
        //  65     105    122    146    Any
        //  122    129    122    146    Any
        //  0      152    152    153    Any
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
    public boolean offerFirst(final E p0, final long p1, final TimeUnit p2) throws InterruptedException {
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
        //    27: new             Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    30: dup            
        //    31: aload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$Node.<init>:(Ljava/lang/Object;)V
        //    40: astore          5
        //    42: ldc             1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload           4
        //    49: lload_2        
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: invokevirtual   java/util/concurrent/TimeUnit.toNanos:(J)J
        //    58: lstore          6
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: aload_0        
        //    66: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    69: astore          8
        //    71: ldc             3
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload           8
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lockInterruptibly:()V
        //    86: aload_0        
        //    87: aload           5
        //    89: ldc             3
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.linkFirst:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Z
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: ifne            169
        //   105: lload           6
        //   107: lconst_0       
        //   108: lcmp           
        //   109: ldc             4
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: ifgt            143
        //   117: iconst_0       
        //   118: istore          9
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: aload           8
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   135: iload           9
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ireturn        
        //   143: aload_0        
        //   144: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notFull:Linstrumented/java/util/concurrent/locks/Condition;
        //   147: lload           6
        //   149: ldc             4
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: invokeinterface instrumented/java/util/concurrent/locks/Condition.awaitNanos:(J)J
        //   159: lstore          6
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            86
        //   169: iconst_1       
        //   170: istore          9
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: aload           8
        //   179: ldc             2
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   187: iload           9
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ireturn        
        //   195: astore          10
        //   197: ldc             501
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: aload           8
        //   204: ldc             2
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   212: aload           10
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: athrow         
        //   220: athrow         
        //   221: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (TE;JLjava/util/concurrent/TimeUnit;)Z
        //    StackMapTable: 00 07 1B FE 00 3A 07 00 18 04 07 00 3F 38 19 59 07 00 3A FF 00 18 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  86     221    221    222    Ljava/lang/VirtualMachineError;
        //  86     125    195    220    Any
        //  143    177    195    220    Any
        //  195    202    195    220    Any
        //  0      220    220    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0086:
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
    public boolean offerLast(final E p0, final long p1, final TimeUnit p2) throws InterruptedException {
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
        //    27: new             Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    30: dup            
        //    31: aload_1        
        //    32: ldc             4
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$Node.<init>:(Ljava/lang/Object;)V
        //    40: astore          5
        //    42: ldc             1
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload           4
        //    49: lload_2        
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: invokevirtual   java/util/concurrent/TimeUnit.toNanos:(J)J
        //    58: lstore          6
        //    60: ldc             1
        //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    65: aload_0        
        //    66: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    69: astore          8
        //    71: ldc             3
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload           8
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lockInterruptibly:()V
        //    86: aload_0        
        //    87: aload           5
        //    89: ldc             3
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.linkLast:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Z
        //    97: ldc             1
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: ifne            169
        //   105: lload           6
        //   107: lconst_0       
        //   108: lcmp           
        //   109: ldc             4
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: ifgt            143
        //   117: iconst_0       
        //   118: istore          9
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: aload           8
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   135: iload           9
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ireturn        
        //   143: aload_0        
        //   144: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notFull:Linstrumented/java/util/concurrent/locks/Condition;
        //   147: lload           6
        //   149: ldc             4
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: invokeinterface instrumented/java/util/concurrent/locks/Condition.awaitNanos:(J)J
        //   159: lstore          6
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            86
        //   169: iconst_1       
        //   170: istore          9
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: aload           8
        //   179: ldc             2
        //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   184: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   187: iload           9
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ireturn        
        //   195: astore          10
        //   197: ldc             501
        //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   202: aload           8
        //   204: ldc             2
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   212: aload           10
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: athrow         
        //   220: athrow         
        //   221: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (TE;JLjava/util/concurrent/TimeUnit;)Z
        //    StackMapTable: 00 07 1B FE 00 3A 07 00 18 04 07 00 3F 38 19 59 07 00 3A FF 00 18 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  86     221    221    222    Ljava/lang/VirtualMachineError;
        //  86     125    195    220    Any
        //  143    177    195    220    Any
        //  195    202    195    220    Any
        //  0      220    220    221    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0086:
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
    public E removeFirst() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollFirst = this.pollFirst();
            BytecodeManager.incBytecodes(1);
            final E e = pollFirst;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = pollFirst;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E removeLast() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollLast = this.pollLast();
            BytecodeManager.incBytecodes(1);
            final E e = pollLast;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = pollLast;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollFirst() {
        ReentrantLock lock;
        try {
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Object o = linkedBlockingDeque.unlinkFirst();
                final boolean b = true;
                BytecodeManager.incBytecodes(b ? 1 : 0);
                final ReentrantLock reentrantLock2 = lock;
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                reentrantLock2.unlock();
                final Object o2 = o;
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                return (E)o2;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Object o = linkedBlockingDeque.unlinkFirst();
            final boolean b = true;
            BytecodeManager.incBytecodes(b ? 1 : 0);
            final ReentrantLock reentrantLock2 = lock;
            final int n2 = 2;
            BytecodeManager.incBytecodes(n2);
            reentrantLock2.unlock();
            final Object o2 = o;
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            return (E)o2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public E pollLast() {
        ReentrantLock lock;
        try {
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final Object o = linkedBlockingDeque.unlinkLast();
                final boolean b = true;
                BytecodeManager.incBytecodes(b ? 1 : 0);
                final ReentrantLock reentrantLock2 = lock;
                final int n2 = 2;
                BytecodeManager.incBytecodes(n2);
                reentrantLock2.unlock();
                final Object o2 = o;
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                return (E)o2;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final Object o = linkedBlockingDeque.unlinkLast();
            final boolean b = true;
            BytecodeManager.incBytecodes(b ? 1 : 0);
            final ReentrantLock reentrantLock2 = lock;
            final int n2 = 2;
            BytecodeManager.incBytecodes(n2);
            reentrantLock2.unlock();
            final Object o2 = o;
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            return (E)o2;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public E takeFirst() throws InterruptedException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.unlinkFirst:()Ljava/lang/Object;
        //    28: dup            
        //    29: astore_2       
        //    30: ldc             3
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifnonnull       60
        //    38: aload_0        
        //    39: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notEmpty:Linstrumented/java/util/concurrent/locks/Condition;
        //    42: ldc             3
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokeinterface instrumented/java/util/concurrent/locks/Condition.await:()V
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: goto            19
        //    60: aload_2        
        //    61: astore_3       
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: aload_1        
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    76: aload_3        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: areturn        
        //    83: astore          4
        //    85: ldc             501
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: aload_1        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    99: aload           4
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: athrow         
        //   107: athrow         
        //   108: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  ()TE;
        //    StackMapTable: 00 05 FC 00 13 07 00 3F FC 00 28 07 00 6A FF 00 16 00 02 07 00 02 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     108    108    109    Ljava/lang/VirtualMachineError;
        //  19     67     83     107    Any
        //  83     90     83     107    Any
        //  0      107    107    108    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0019:
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
    public E takeLast() throws InterruptedException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.unlinkLast:()Ljava/lang/Object;
        //    28: dup            
        //    29: astore_2       
        //    30: ldc             3
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifnonnull       60
        //    38: aload_0        
        //    39: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notEmpty:Linstrumented/java/util/concurrent/locks/Condition;
        //    42: ldc             3
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: invokeinterface instrumented/java/util/concurrent/locks/Condition.await:()V
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: goto            19
        //    60: aload_2        
        //    61: astore_3       
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: aload_1        
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    76: aload_3        
        //    77: ldc             2
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: areturn        
        //    83: astore          4
        //    85: ldc             501
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: aload_1        
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    99: aload           4
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: athrow         
        //   107: athrow         
        //   108: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  ()TE;
        //    StackMapTable: 00 05 FC 00 13 07 00 3F FC 00 28 07 00 6A FF 00 16 00 02 07 00 02 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     108    108    109    Ljava/lang/VirtualMachineError;
        //  19     67     83     107    Any
        //  83     90     83     107    Any
        //  0      107    107    108    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0019:
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
    public E pollFirst(final long p0, final TimeUnit p1) throws InterruptedException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   java/util/concurrent/TimeUnit.toNanos:(J)J
        //    10: lstore          4
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_0        
        //    18: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    21: astore          6
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: aload           6
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lockInterruptibly:()V
        //    38: aload_0        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.unlinkFirst:()Ljava/lang/Object;
        //    47: dup            
        //    48: astore          7
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: ifnonnull       122
        //    58: lload           4
        //    60: lconst_0       
        //    61: lcmp           
        //    62: ldc             4
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ifgt            96
        //    70: aconst_null    
        //    71: astore          8
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload           6
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    88: aload           8
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: areturn        
        //    96: aload_0        
        //    97: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notEmpty:Linstrumented/java/util/concurrent/locks/Condition;
        //   100: lload           4
        //   102: ldc             4
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokeinterface instrumented/java/util/concurrent/locks/Condition.awaitNanos:(J)J
        //   112: lstore          4
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: goto            38
        //   122: aload           7
        //   124: astore          8
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload           6
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   141: aload           8
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: areturn        
        //   149: astore          9
        //   151: ldc             501
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: aload           6
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   166: aload           9
        //   168: ldc             2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: athrow         
        //   174: athrow         
        //   175: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (JLjava/util/concurrent/TimeUnit;)TE;
        //    StackMapTable: 00 06 FD 00 26 04 07 00 3F FC 00 39 07 00 6A 19 FF 00 1A 00 05 07 00 02 04 07 00 B0 04 07 00 3F 00 01 07 00 3A FF 00 18 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  38     175    175    176    Ljava/lang/VirtualMachineError;
        //  38     78     149    174    Any
        //  96     131    149    174    Any
        //  149    156    149    174    Any
        //  0      174    174    175    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
    public E pollLast(final long p0, final TimeUnit p1) throws InterruptedException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lload_1        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokevirtual   java/util/concurrent/TimeUnit.toNanos:(J)J
        //    10: lstore          4
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_0        
        //    18: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    21: astore          6
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: aload           6
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lockInterruptibly:()V
        //    38: aload_0        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.unlinkLast:()Ljava/lang/Object;
        //    47: dup            
        //    48: astore          7
        //    50: ldc             3
        //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    55: ifnonnull       122
        //    58: lload           4
        //    60: lconst_0       
        //    61: lcmp           
        //    62: ldc             4
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ifgt            96
        //    70: aconst_null    
        //    71: astore          8
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload           6
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    88: aload           8
        //    90: ldc             2
        //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    95: areturn        
        //    96: aload_0        
        //    97: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notEmpty:Linstrumented/java/util/concurrent/locks/Condition;
        //   100: lload           4
        //   102: ldc             4
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: invokeinterface instrumented/java/util/concurrent/locks/Condition.awaitNanos:(J)J
        //   112: lstore          4
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: goto            38
        //   122: aload           7
        //   124: astore          8
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: aload           6
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   141: aload           8
        //   143: ldc             2
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: areturn        
        //   149: astore          9
        //   151: ldc             501
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: aload           6
        //   158: ldc             2
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   166: aload           9
        //   168: ldc             2
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: athrow         
        //   174: athrow         
        //   175: athrow         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    Signature:
        //  (JLjava/util/concurrent/TimeUnit;)TE;
        //    StackMapTable: 00 06 FD 00 26 04 07 00 3F FC 00 39 07 00 6A 19 FF 00 1A 00 05 07 00 02 04 07 00 B0 04 07 00 3F 00 01 07 00 3A FF 00 18 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  38     175    175    176    Ljava/lang/VirtualMachineError;
        //  38     78     149    174    Any
        //  96     131    149    174    Any
        //  149    156    149    174    Any
        //  0      174    174    175    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
    public E getFirst() {
        try {
            BytecodeManager.incBytecodes(2);
            final E peekFirst = this.peekFirst();
            BytecodeManager.incBytecodes(1);
            final E e = peekFirst;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = peekFirst;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E getLast() {
        try {
            BytecodeManager.incBytecodes(2);
            final E peekLast = this.peekLast();
            BytecodeManager.incBytecodes(1);
            final E e = peekLast;
            BytecodeManager.incBytecodes(2);
            if (e == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final E e2 = peekLast;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peekFirst() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ifnonnull       40
        //    31: aconst_null    
        //    32: ldc             2
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: goto            52
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    44: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    47: ldc             3
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: astore_2       
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: aload_1        
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    67: aload_2        
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: areturn        
        //    74: astore_3       
        //    75: aload_1        
        //    76: ldc             503
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    84: aload_3        
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: athrow         
        //    91: athrow         
        //    92: athrow         
        //    Signature:
        //  ()TE;
        //    StackMapTable: 00 05 FC 00 28 07 00 3F 4B 07 00 6A 55 07 00 3A FF 00 10 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     92     92     93     Ljava/lang/VirtualMachineError;
        //  19     58     74     91     Any
        //  0      91     91     92     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
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
    public E peekLast() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.last:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ifnonnull       40
        //    31: aconst_null    
        //    32: ldc             2
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: goto            52
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.last:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    44: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    47: ldc             3
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: astore_2       
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: aload_1        
        //    59: ldc             2
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    67: aload_2        
        //    68: ldc             2
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: areturn        
        //    74: astore_3       
        //    75: aload_1        
        //    76: ldc             503
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    84: aload_3        
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: athrow         
        //    91: athrow         
        //    92: athrow         
        //    Signature:
        //  ()TE;
        //    StackMapTable: 00 05 FC 00 28 07 00 3F 4B 07 00 6A 55 07 00 3A FF 00 10 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     92     92     93     Ljava/lang/VirtualMachineError;
        //  19     58     74     91     Any
        //  0      91     91     92     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
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
    public boolean removeFirstOccurrence(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       16
        //     9: iconst_0       
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ireturn        
        //    16: aload_0        
        //    17: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    20: astore_2       
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload_2        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    35: aload_0        
        //    36: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    39: astore_3       
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_3        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifnull          123
        //    54: aload_1        
        //    55: aload_3        
        //    56: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: ifeq            110
        //    75: aload_0        
        //    76: aload_3        
        //    77: ldc             3
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokevirtual   instrumented/java/util/concurrent/LinkedBlockingDeque.unlink:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)V
        //    85: iconst_1       
        //    86: istore          4
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_2        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   102: iload           4
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ireturn        
        //   110: aload_3        
        //   111: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   114: astore_3       
        //   115: ldc             4
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: goto            45
        //   123: iconst_0       
        //   124: istore_3       
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: aload_2        
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   139: iload_3        
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ireturn        
        //   146: astore          5
        //   148: ldc             501
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: aload_2        
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   162: aload           5
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: athrow         
        //   170: athrow         
        //   171: athrow         
        //    StackMapTable: 00 07 10 FD 00 1C 07 00 3F 07 00 18 FB 00 40 FA 00 0C 56 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  35     171    171    172    Ljava/lang/VirtualMachineError;
        //  35     93     146    170    Any
        //  110    130    146    170    Any
        //  146    153    146    170    Any
        //  0      170    170    171    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
    public boolean removeLastOccurrence(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       16
        //     9: iconst_0       
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ireturn        
        //    16: aload_0        
        //    17: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    20: astore_2       
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload_2        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    35: aload_0        
        //    36: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.last:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    39: astore_3       
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_3        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifnull          123
        //    54: aload_1        
        //    55: aload_3        
        //    56: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: ifeq            110
        //    75: aload_0        
        //    76: aload_3        
        //    77: ldc             3
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: invokevirtual   instrumented/java/util/concurrent/LinkedBlockingDeque.unlink:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)V
        //    85: iconst_1       
        //    86: istore          4
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: aload_2        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   102: iload           4
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ireturn        
        //   110: aload_3        
        //   111: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.prev:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   114: astore_3       
        //   115: ldc             4
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: goto            45
        //   123: iconst_0       
        //   124: istore_3       
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: aload_2        
        //   131: ldc             2
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   139: iload_3        
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ireturn        
        //   146: astore          5
        //   148: ldc             501
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: aload_2        
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   162: aload           5
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: athrow         
        //   170: athrow         
        //   171: athrow         
        //    StackMapTable: 00 07 10 FD 00 1C 07 00 3F 07 00 18 FB 00 40 FA 00 0C 56 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  35     171    171    172    Ljava/lang/VirtualMachineError;
        //  35     93     146    170    Any
        //  110    130    146    170    Any
        //  146    153    146    170    Any
        //  0      170    170    171    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
        try {
            BytecodeManager.incBytecodes(3);
            this.addLast(e);
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
            BytecodeManager.incBytecodes(3);
            final boolean offerLast = this.offerLast(e);
            BytecodeManager.incBytecodes(1);
            return offerLast;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void put(final E e) throws InterruptedException {
        try {
            BytecodeManager.incBytecodes(3);
            this.putLast(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean offer(final E e, final long n, final TimeUnit timeUnit) throws InterruptedException {
        try {
            BytecodeManager.incBytecodes(5);
            final boolean offerLast = this.offerLast(e, n, timeUnit);
            BytecodeManager.incBytecodes(1);
            return offerLast;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E remove() {
        try {
            BytecodeManager.incBytecodes(2);
            final E removeFirst = this.removeFirst();
            BytecodeManager.incBytecodes(1);
            return removeFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E poll() {
        try {
            BytecodeManager.incBytecodes(2);
            final E pollFirst = this.pollFirst();
            BytecodeManager.incBytecodes(1);
            return pollFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E take() throws InterruptedException {
        try {
            BytecodeManager.incBytecodes(2);
            final E takeFirst = this.takeFirst();
            BytecodeManager.incBytecodes(1);
            return takeFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E poll(final long n, final TimeUnit timeUnit) throws InterruptedException {
        try {
            BytecodeManager.incBytecodes(4);
            final E pollFirst = this.pollFirst(n, timeUnit);
            BytecodeManager.incBytecodes(1);
            return pollFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E element() {
        try {
            BytecodeManager.incBytecodes(2);
            final E first = this.getFirst();
            BytecodeManager.incBytecodes(1);
            return first;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E peek() {
        try {
            BytecodeManager.incBytecodes(2);
            final E peekFirst = this.peekFirst();
            BytecodeManager.incBytecodes(1);
            return peekFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int remainingCapacity() {
        ReentrantLock lock;
        try {
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final int n = linkedBlockingDeque.capacity;
                final LinkedBlockingDeque linkedBlockingDeque2 = this;
                final int n2 = linkedBlockingDeque2.count;
                final int n3 = n - n2;
                final int n4 = 6;
                BytecodeManager.incBytecodes(n4);
                final ReentrantLock reentrantLock2 = lock;
                final int n5 = 2;
                BytecodeManager.incBytecodes(n5);
                reentrantLock2.unlock();
                final int n6 = n3;
                final int n7 = 2;
                BytecodeManager.incBytecodes(n7);
                return n6;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final int n = linkedBlockingDeque.capacity;
            final LinkedBlockingDeque linkedBlockingDeque2 = this;
            final int n2 = linkedBlockingDeque2.count;
            final int n3 = n - n2;
            final int n4 = 6;
            BytecodeManager.incBytecodes(n4);
            final ReentrantLock reentrantLock2 = lock;
            final int n5 = 2;
            BytecodeManager.incBytecodes(n5);
            reentrantLock2.unlock();
            final int n6 = n3;
            final int n7 = 2;
            BytecodeManager.incBytecodes(n7);
            return n6;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public int drainTo(final Collection<? super E> collection) {
        try {
            final int n = Integer.MAX_VALUE;
            BytecodeManager.incBytecodes(4);
            final int drainTo = this.drainTo(collection, n);
            BytecodeManager.incBytecodes(1);
            return drainTo;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int drainTo(final Collection<? super E> p0, final int p1) {
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
        //    27: aload_1        
        //    28: aload_0        
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: if_acmpne       55
        //    37: new             Ljava/lang/IllegalArgumentException;
        //    40: dup            
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokespecial   java/lang/IllegalArgumentException.<init>:()V
        //    49: ldc             1
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: athrow         
        //    55: iload_2        
        //    56: ldc             2
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ifgt            71
        //    64: iconst_0       
        //    65: ldc             2
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: ireturn        
        //    71: aload_0        
        //    72: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    75: astore_3       
        //    76: ldc             3
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_3        
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    90: iload_2        
        //    91: aload_0        
        //    92: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.count:I
        //    95: ldc             4
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokestatic    java/lang/Math.min:(II)I
        //   103: istore          4
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: iconst_0       
        //   111: istore          5
        //   113: ldc             2
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: iload           5
        //   120: iload           4
        //   122: ldc             3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: if_icmpge       180
        //   130: aload_1        
        //   131: aload_0        
        //   132: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   135: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //   138: ldc             5
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokeinterface instrumented/java/util/Collection.add:(Ljava/lang/Object;)Z
        //   148: pop            
        //   149: ldc             1
        //   151: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   154: aload_0        
        //   155: ldc             2
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque.unlinkFirst:()Ljava/lang/Object;
        //   163: pop            
        //   164: ldc             1
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: iinc            5, 1
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: goto            118
        //   180: iload           4
        //   182: istore          5
        //   184: ldc             2
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: aload_3        
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   198: iload           5
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: ireturn        
        //   206: astore          6
        //   208: ldc             501
        //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   213: aload_3        
        //   214: ldc             2
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   222: aload           6
        //   224: ldc             2
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: athrow         
        //   230: athrow         
        //   231: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Collection<-TE;>;I)I
        //    StackMapTable: 00 08 1B 1B 0F FE 00 2E 07 00 3F 01 01 FA 00 3D FF 00 19 00 04 07 00 02 07 00 57 01 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  90     231    231    232    Ljava/lang/VirtualMachineError;
        //  90     189    206    230    Any
        //  206    213    206    230    Any
        //  0      230    230    231    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
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
    public void push(final E e) {
        try {
            BytecodeManager.incBytecodes(3);
            this.addFirst(e);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pop() {
        try {
            BytecodeManager.incBytecodes(2);
            final E removeFirst = this.removeFirst();
            BytecodeManager.incBytecodes(1);
            return removeFirst;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean removeFirstOccurrence = this.removeFirstOccurrence(o);
            BytecodeManager.incBytecodes(1);
            return removeFirstOccurrence;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        ReentrantLock lock;
        try {
            lock = this.lock;
            BytecodeManager.incBytecodes(3);
            final ReentrantLock reentrantLock = lock;
            BytecodeManager.incBytecodes(2);
            reentrantLock.lock();
            try {
                final LinkedBlockingDeque linkedBlockingDeque = this;
                final int n = linkedBlockingDeque.count;
                final int n2 = 3;
                BytecodeManager.incBytecodes(n2);
                final ReentrantLock reentrantLock2 = lock;
                final int n3 = 2;
                BytecodeManager.incBytecodes(n3);
                reentrantLock2.unlock();
                final int n4 = n;
                final int n5 = 2;
                BytecodeManager.incBytecodes(n5);
                return n4;
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
            final LinkedBlockingDeque linkedBlockingDeque = this;
            final int n = linkedBlockingDeque.count;
            final int n2 = 3;
            BytecodeManager.incBytecodes(n2);
            final ReentrantLock reentrantLock2 = lock;
            final int n3 = 2;
            BytecodeManager.incBytecodes(n3);
            reentrantLock2.unlock();
            final int n4 = n;
            final int n5 = 2;
            BytecodeManager.incBytecodes(n5);
            return n4;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    @Override
    public boolean contains(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       16
        //     9: iconst_0       
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ireturn        
        //    16: aload_0        
        //    17: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //    20: astore_2       
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: aload_2        
        //    27: ldc             2
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    35: aload_0        
        //    36: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    39: astore_3       
        //    40: ldc             3
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: aload_3        
        //    46: ldc             2
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: ifnull          113
        //    54: aload_1        
        //    55: aload_3        
        //    56: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: ifeq            100
        //    75: iconst_1       
        //    76: istore          4
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: aload_2        
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    92: iload           4
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: ireturn        
        //   100: aload_3        
        //   101: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   104: astore_3       
        //   105: ldc             4
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: goto            45
        //   113: iconst_0       
        //   114: istore_3       
        //   115: ldc             2
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: aload_2        
        //   121: ldc             2
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   129: iload_3        
        //   130: ldc             2
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: ireturn        
        //   136: astore          5
        //   138: ldc             501
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: aload_2        
        //   144: ldc             2
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   152: aload           5
        //   154: ldc             2
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: athrow         
        //   160: athrow         
        //   161: athrow         
        //    StackMapTable: 00 07 10 FD 00 1C 07 00 3F 07 00 18 36 FA 00 0C 56 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  35     161    161    162    Ljava/lang/VirtualMachineError;
        //  35     83     136    160    Any
        //  100    120    136    160    Any
        //  136    143    136    160    Any
        //  0      160    160    161    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
    public Object[] toArray() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.count:I
        //    23: anewarray       Ljava/lang/Object;
        //    26: astore_2       
        //    27: ldc             3
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: iconst_0       
        //    33: istore_3       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: aload_0        
        //    40: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    43: astore          4
        //    45: ldc             3
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: aload           4
        //    52: ldc             2
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: ifnull          91
        //    60: aload_2        
        //    61: iload_3        
        //    62: iinc            3, 1
        //    65: aload           4
        //    67: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    70: aastore        
        //    71: ldc             6
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: aload           4
        //    78: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    81: astore          4
        //    83: ldc             4
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: goto            50
        //    91: aload_2        
        //    92: astore          4
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_1        
        //   100: ldc             2
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   108: aload           4
        //   110: ldc             2
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: areturn        
        //   116: astore          5
        //   118: ldc             501
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: aload_1        
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   132: aload           5
        //   134: ldc             2
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: athrow         
        //   140: athrow         
        //   141: athrow         
        //    StackMapTable: 00 05 FF 00 32 00 05 07 00 02 07 00 3F 07 01 09 01 07 00 18 00 00 FA 00 28 FF 00 18 00 02 07 00 02 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     141    141    142    Ljava/lang/VirtualMachineError;
        //  19     99     116    140    Any
        //  116    123    116    140    Any
        //  0      140    140    141    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
    public <T> T[] toArray(final T[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_2       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_2        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_1        
        //    20: arraylength    
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.count:I
        //    25: ldc             5
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: if_icmpge       79
        //    33: aload_1        
        //    34: ldc             1
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ldc             1
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokevirtual   java/lang/Class.getComponentType:()Ljava/lang/Class;
        //    55: aload_0        
        //    56: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.count:I
        //    59: ldc             3
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: invokestatic    java/lang/reflect/Array.newInstance:(Ljava/lang/Class;I)Ljava/lang/Object;
        //    67: checkcast       [Ljava/lang/Object;
        //    70: checkcast       [Ljava/lang/Object;
        //    73: astore_1       
        //    74: ldc             3
        //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    79: iconst_0       
        //    80: istore_3       
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: aload_0        
        //    87: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    90: astore          4
        //    92: ldc             3
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: aload           4
        //    99: ldc             2
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ifnull          138
        //   107: aload_1        
        //   108: iload_3        
        //   109: iinc            3, 1
        //   112: aload           4
        //   114: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //   117: aastore        
        //   118: ldc             6
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: aload           4
        //   125: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   128: astore          4
        //   130: ldc             4
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: goto            97
        //   138: aload_1        
        //   139: arraylength    
        //   140: iload_3        
        //   141: ldc             4
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: if_icmple       158
        //   149: aload_1        
        //   150: iload_3        
        //   151: aconst_null    
        //   152: aastore        
        //   153: ldc             4
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: aload_1        
        //   159: astore          4
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_2        
        //   167: ldc             2
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   175: aload           4
        //   177: ldc             2
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: areturn        
        //   183: astore          5
        //   185: ldc             501
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: aload_2        
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   199: aload           5
        //   201: ldc             2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: athrow         
        //   207: athrow         
        //   208: athrow         
        //    Signature:
        //  <T:Ljava/lang/Object;>([TT;)[TT;
        //    StackMapTable: 00 07 FC 00 4F 07 00 3F FD 00 11 01 07 00 18 FA 00 28 13 FF 00 18 00 03 07 00 02 07 01 09 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     208    208    209    Ljava/lang/VirtualMachineError;
        //  19     166    183    207    Any
        //  183    190    183    207    Any
        //  0      207    207    208    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
    public String toString() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    23: astore_2       
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_2        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifnonnull       63
        //    38: ldc_w           "[]"
        //    41: astore_3       
        //    42: ldc             2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: aload_1        
        //    48: ldc             2
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    56: aload_3        
        //    57: ldc             2
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: areturn        
        //    63: new             Ljava/lang/StringBuilder;
        //    66: dup            
        //    67: ldc             3
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokespecial   java/lang/StringBuilder.<init>:()V
        //    75: astore_3       
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_3        
        //    82: bipush          91
        //    84: ldc             3
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    92: pop            
        //    93: ldc             1
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: aload_2        
        //    99: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //   102: astore          4
        //   104: ldc             3
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: aload_3        
        //   110: aload           4
        //   112: aload_0        
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: if_acmpne       132
        //   121: ldc_w           "(this Collection)"
        //   124: ldc             2
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: goto            139
        //   132: aload           4
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   147: pop            
        //   148: ldc             1
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: aload_2        
        //   154: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   157: astore_2       
        //   158: ldc             3
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: aload_2        
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: ifnonnull       215
        //   172: aload_3        
        //   173: bipush          93
        //   175: ldc             3
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   183: ldc             1
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   191: astore          5
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: aload_1        
        //   199: ldc             2
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   207: aload           5
        //   209: ldc             2
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: areturn        
        //   215: aload_3        
        //   216: bipush          44
        //   218: ldc             3
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   226: bipush          32
        //   228: ldc             2
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   236: pop            
        //   237: ldc             1
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: ldc             1
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: goto            98
        //   250: astore          6
        //   252: ldc             501
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: aload_1        
        //   258: ldc             2
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   266: aload           6
        //   268: ldc             2
        //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   273: athrow         
        //   274: athrow         
        //   275: athrow         
        //    StackMapTable: 00 08 FD 00 3F 07 00 3F 07 00 18 FC 00 22 07 01 1F FF 00 21 00 05 07 00 02 07 00 3F 07 00 18 07 01 1F 07 00 6A 00 01 07 01 1F FF 00 06 00 05 07 00 02 07 00 3F 07 00 18 07 01 1F 07 00 6A 00 02 07 01 1F 07 00 6A FB 00 4B FF 00 22 00 02 07 00 02 07 00 3F 00 01 07 00 3A FF 00 17 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     275    275    276    Ljava/lang/VirtualMachineError;
        //  19     47     250    274    Any
        //  63     198    250    274    Any
        //  215    257    250    274    Any
        //  0      274    274    275    Any
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
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_1       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_1        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    23: astore_2       
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_2        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifnull          93
        //    38: aload_2        
        //    39: aconst_null    
        //    40: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    43: ldc             3
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: aload_2        
        //    49: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    52: astore_3       
        //    53: ldc             3
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: aload_2        
        //    59: aconst_null    
        //    60: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.prev:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: aload_2        
        //    69: aconst_null    
        //    70: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    73: ldc             3
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload_3        
        //    79: astore_2       
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: ldc             1
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            29
        //    93: aload_0        
        //    94: aload_0        
        //    95: aconst_null    
        //    96: dup_x1         
        //    97: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque.last:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   100: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //   103: ldc             6
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: aload_0        
        //   109: iconst_0       
        //   110: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque.count:I
        //   113: ldc             3
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: aload_0        
        //   119: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.notFull:Linstrumented/java/util/concurrent/locks/Condition;
        //   122: ldc             3
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: invokeinterface instrumented/java/util/concurrent/locks/Condition.signalAll:()V
        //   132: aload_1        
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   141: ldc             1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: goto            173
        //   149: astore          4
        //   151: ldc             501
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: aload_1        
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   165: aload           4
        //   167: ldc             2
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: athrow         
        //   173: ldc             1
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: return         
        //   179: athrow         
        //   180: athrow         
        //    StackMapTable: 00 06 FD 00 1D 07 00 3F 07 00 18 FA 00 3F 77 07 00 3A 17 FF 00 05 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     180    180    181    Ljava/lang/VirtualMachineError;
        //  19     132    149    173    Any
        //  149    156    149    173    Any
        //  0      179    179    180    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0029:
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
    public Iterator<E> descendingIterator() {
        try {
            final Object object = null;
            BytecodeManager.incBytecodes(5);
            final DescendingItr descendingItr = new DescendingItr();
            BytecodeManager.incBytecodes(1);
            return descendingItr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            BytecodeManager.incBytecodes(4);
            final LBDSpliterator<E> lbdSpliterator = new LBDSpliterator<E>(this);
            BytecodeManager.incBytecodes(1);
            return lbdSpliterator;
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
        //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
        //     4: astore_2       
        //     5: ldc             3
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: aload_2        
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
        //    19: aload_1        
        //    20: ldc             2
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: invokevirtual   java/io/ObjectOutputStream.defaultWriteObject:()V
        //    28: aload_0        
        //    29: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    32: astore_3       
        //    33: ldc             3
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: aload_3        
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: ifnull          73
        //    47: aload_1        
        //    48: aload_3        
        //    49: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
        //    52: ldc             4
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    60: aload_3        
        //    61: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
        //    64: astore_3       
        //    65: ldc             4
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: goto            38
        //    73: aload_1        
        //    74: aconst_null    
        //    75: ldc             3
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    83: aload_2        
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: goto            124
        //   100: astore          4
        //   102: ldc             501
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: aload_2        
        //   108: ldc             2
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   116: aload           4
        //   118: ldc             2
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: athrow         
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: return         
        //   130: athrow         
        //   131: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 06 FD 00 26 07 00 3F 07 00 18 FA 00 22 5A 07 00 3A 17 FF 00 05 00 00 00 01 07 00 3A FF 00 00 00 00 00 01 07 00 53
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     131    131    132    Ljava/lang/VirtualMachineError;
        //  19     83     100    124    Any
        //  100    107    100    124    Any
        //  0      130    130    131    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(2);
            objectInputStream.defaultReadObject();
            this.count = 0;
            BytecodeManager.incBytecodes(3);
            this.first = null;
            BytecodeManager.incBytecodes(3);
            this.last = null;
            BytecodeManager.incBytecodes(3);
            while (true) {
                BytecodeManager.incBytecodes(2);
                final Object object = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                final Object o = object;
                BytecodeManager.incBytecodes(2);
                if (o == null) {
                    break;
                }
                final Object o2 = object;
                BytecodeManager.incBytecodes(3);
                this.add((E)o2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final class Node<E>
    {
        E item;
        Node<E> prev;
        Node<E> next;
        
        Node(final E item) {
            try {
                BytecodeManager.incBytecodes(2);
                this.item = item;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private abstract class AbstractItr implements Iterator<E>
    {
        Node<E> next;
        E nextItem;
        private Node<E> lastRet;
        
        abstract Node<E> firstNode();
        
        abstract Node<E> nextNode(final Node<E> p0);
        
        AbstractItr(final LinkedBlockingDeque p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.this$0:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //     5: aload_0        
            //     6: ldc             5
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: invokespecial   java/lang/Object.<init>:()V
            //    14: aload_1        
            //    15: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    18: astore_2       
            //    19: ldc             3
            //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    24: aload_2        
            //    25: ldc             2
            //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    30: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    33: aload_0        
            //    34: aload_0        
            //    35: ldc             3
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: invokevirtual   instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.firstNode:()Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    43: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    46: ldc             1
            //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    51: aload_0        
            //    52: aload_0        
            //    53: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    56: ldc             4
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: ifnonnull       73
            //    64: aconst_null    
            //    65: ldc             2
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: goto            85
            //    73: aload_0        
            //    74: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    77: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //    80: ldc             3
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.nextItem:Ljava/lang/Object;
            //    88: ldc             1
            //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    93: aload_2        
            //    94: ldc             2
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   102: ldc             1
            //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   107: goto            127
            //   110: astore_3       
            //   111: aload_2        
            //   112: ldc             503
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   120: aload_3        
            //   121: ldc             2
            //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   126: athrow         
            //   127: ldc             1
            //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   132: return         
            //   133: athrow         
            //   134: athrow         
            //    StackMapTable: 00 06 FF 00 49 00 03 07 00 02 07 00 0A 07 00 33 00 01 07 00 02 FF 00 0B 00 03 07 00 02 07 00 0A 07 00 33 00 02 07 00 02 07 00 05 58 07 00 45 10 FF 00 05 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 00 1F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  33     134    134    135    Ljava/lang/VirtualMachineError;
            //  33     93     110    127    Any
            //  0      133    133    134    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
        
        private Node<E> succ(Node<E> node) {
            try {
                while (true) {
                    final Node<E> node2 = node;
                    BytecodeManager.incBytecodes(3);
                    final Node<E> nextNode = this.nextNode(node2);
                    BytecodeManager.incBytecodes(1);
                    final Node<E> node3 = nextNode;
                    BytecodeManager.incBytecodes(2);
                    if (node3 == null) {
                        final Node<E> node4 = null;
                        BytecodeManager.incBytecodes(2);
                        return node4;
                    }
                    final E item = nextNode.item;
                    BytecodeManager.incBytecodes(3);
                    if (item != null) {
                        final Node<E> node5 = nextNode;
                        BytecodeManager.incBytecodes(2);
                        return node5;
                    }
                    final Node<E> node6 = nextNode;
                    final Node<E> node7 = node;
                    BytecodeManager.incBytecodes(3);
                    if (node6 == node7) {
                        BytecodeManager.incBytecodes(2);
                        final Node<E> firstNode = this.firstNode();
                        BytecodeManager.incBytecodes(1);
                        return firstNode;
                    }
                    node = nextNode;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void advance() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     4: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //     7: astore_1       
            //     8: ldc             4
            //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    13: aload_1        
            //    14: ldc             2
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    22: aload_0        
            //    23: aload_0        
            //    24: aload_0        
            //    25: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    28: ldc             5
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: invokespecial   instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.succ:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    36: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    39: ldc             1
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: aload_0        
            //    45: aload_0        
            //    46: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    49: ldc             4
            //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    54: ifnonnull       66
            //    57: aconst_null    
            //    58: ldc             2
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: goto            78
            //    66: aload_0        
            //    67: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    70: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //    73: ldc             3
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.nextItem:Ljava/lang/Object;
            //    81: ldc             1
            //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    86: aload_1        
            //    87: ldc             2
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //    95: ldc             1
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: goto            120
            //   103: astore_2       
            //   104: aload_1        
            //   105: ldc             503
            //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   110: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   113: aload_2        
            //   114: ldc             2
            //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   119: athrow         
            //   120: ldc             1
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: return         
            //   126: athrow         
            //   127: athrow         
            //    StackMapTable: 00 06 FF 00 42 00 02 07 00 02 07 00 33 00 01 07 00 02 FF 00 0B 00 02 07 00 02 07 00 33 00 02 07 00 02 07 00 05 58 07 00 45 10 FF 00 05 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 00 1F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     127    127    128    Ljava/lang/VirtualMachineError;
            //  22     86     103    120    Any
            //  0      126    126    127    Any
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
        public boolean hasNext() {
            try {
                final Node<E> next = this.next;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (next != null) {
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
                final Node<E> next = this.next;
                BytecodeManager.incBytecodes(3);
                if (next == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                this.lastRet = this.next;
                BytecodeManager.incBytecodes(4);
                final E nextItem = this.nextItem;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                this.advance();
                final E e = nextItem;
                BytecodeManager.incBytecodes(2);
                return e;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.lastRet:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //     4: astore_1       
            //     5: ldc             3
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: aload_1        
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ifnonnull       37
            //    19: new             Ljava/lang/IllegalStateException;
            //    22: dup            
            //    23: ldc             3
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    31: ldc             1
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: athrow         
            //    37: aload_0        
            //    38: aconst_null    
            //    39: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.lastRet:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    42: ldc             3
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_0        
            //    48: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.this$0:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //    51: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    54: astore_2       
            //    55: ldc             4
            //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    60: aload_2        
            //    61: ldc             2
            //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    66: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    69: aload_1        
            //    70: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //    73: ldc             3
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: ifnull          94
            //    81: aload_0        
            //    82: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$AbstractItr.this$0:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //    85: aload_1        
            //    86: ldc             4
            //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    91: invokevirtual   instrumented/java/util/concurrent/LinkedBlockingDeque.unlink:(Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;)V
            //    94: aload_2        
            //    95: ldc             2
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   103: ldc             1
            //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   108: goto            128
            //   111: astore_3       
            //   112: aload_2        
            //   113: ldc             503
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   121: aload_3        
            //   122: ldc             2
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: athrow         
            //   128: ldc             1
            //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   133: return         
            //   134: athrow         
            //   135: athrow         
            //    StackMapTable: 00 06 FC 00 25 07 00 0D FC 00 38 07 00 33 50 07 00 45 10 FF 00 05 00 00 00 01 07 00 45 FF 00 00 00 00 00 01 07 00 1F
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  69     135    135    136    Ljava/lang/VirtualMachineError;
            //  69     94     111    128    Any
            //  0      134    134    135    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
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
    
    private class Itr extends AbstractItr
    {
        private Itr() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> firstNode() {
            try {
                final Node<E> first = LinkedBlockingDeque.this.first;
                BytecodeManager.incBytecodes(4);
                return first;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> nextNode(final Node<E> node) {
            try {
                final Node<E> next = node.next;
                BytecodeManager.incBytecodes(3);
                return next;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class DescendingItr extends AbstractItr
    {
        private DescendingItr() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> firstNode() {
            try {
                final Node<E> last = LinkedBlockingDeque.this.last;
                BytecodeManager.incBytecodes(4);
                return last;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Node<E> nextNode(final Node<E> node) {
            try {
                final Node<E> prev = node.prev;
                BytecodeManager.incBytecodes(3);
                return prev;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class LBDSpliterator<E> implements Spliterator<E>
    {
        static final int MAX_BATCH = 33554432;
        final LinkedBlockingDeque<E> queue;
        Node<E> current;
        int batch;
        boolean exhausted;
        long est;
        
        LBDSpliterator(final LinkedBlockingDeque<E> queue) {
            try {
                BytecodeManager.incBytecodes(2);
                this.queue = queue;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(3);
                this.est = queue.size();
                BytecodeManager.incBytecodes(2);
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
        public Spliterator<E> trySplit() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.queue:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //     4: astore_2       
            //     5: ldc             3
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: aload_0        
            //    11: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.batch:I
            //    14: istore_3       
            //    15: ldc             3
            //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    20: iload_3        
            //    21: ldc             2
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: ifgt            38
            //    29: iconst_1       
            //    30: ldc             2
            //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    35: goto            67
            //    38: iload_3        
            //    39: ldc             33554432
            //    41: ldc             3
            //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    46: if_icmplt       59
            //    49: ldc             33554432
            //    51: ldc             2
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: goto            67
            //    59: iload_3        
            //    60: iconst_1       
            //    61: iadd           
            //    62: ldc             3
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: istore          4
            //    69: ldc             1
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: aload_0        
            //    75: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //    78: ldc             3
            //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    83: ifne            420
            //    86: aload_0        
            //    87: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    90: dup            
            //    91: astore_1       
            //    92: ldc             5
            //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    97: ifnonnull       114
            //   100: aload_2        
            //   101: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   104: dup            
            //   105: astore_1       
            //   106: ldc             5
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: ifnull          420
            //   114: aload_1        
            //   115: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   118: ldc             3
            //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   123: ifnull          420
            //   126: iload           4
            //   128: anewarray       Ljava/lang/Object;
            //   131: astore          5
            //   133: ldc             2
            //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   138: aload_2        
            //   139: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //   142: astore          6
            //   144: ldc             3
            //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   149: iconst_0       
            //   150: istore          7
            //   152: ldc             2
            //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   157: aload_0        
            //   158: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   161: astore          8
            //   163: ldc             3
            //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   168: aload           6
            //   170: ldc             2
            //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   175: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //   178: aload           8
            //   180: ldc             2
            //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   185: ifnonnull       203
            //   188: aload_2        
            //   189: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   192: dup            
            //   193: astore          8
            //   195: ldc             5
            //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   200: ifnull          258
            //   203: aload           5
            //   205: iload           7
            //   207: aload           8
            //   209: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //   212: dup_x2         
            //   213: aastore        
            //   214: ldc             7
            //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   219: ifnull          230
            //   222: iinc            7, 1
            //   225: ldc             1
            //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   230: aload           8
            //   232: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   235: dup            
            //   236: astore          8
            //   238: ldc             5
            //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   243: ifnull          258
            //   246: iload           7
            //   248: iload           4
            //   250: ldc             3
            //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   255: if_icmplt       203
            //   258: aload           6
            //   260: ldc             2
            //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   265: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   268: ldc             1
            //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   273: goto            301
            //   276: astore          9
            //   278: ldc             501
            //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   283: aload           6
            //   285: ldc             2
            //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   290: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   293: aload           9
            //   295: ldc             2
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: athrow         
            //   301: aload_0        
            //   302: aload           8
            //   304: dup_x1         
            //   305: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   308: ldc             5
            //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   313: ifnonnull       339
            //   316: aload_0        
            //   317: lconst_0       
            //   318: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.est:J
            //   321: ldc             3
            //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   326: aload_0        
            //   327: iconst_1       
            //   328: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //   331: ldc             4
            //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   336: goto            372
            //   339: aload_0        
            //   340: dup            
            //   341: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.est:J
            //   344: iload           7
            //   346: i2l            
            //   347: lsub           
            //   348: dup2_x1        
            //   349: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.est:J
            //   352: lconst_0       
            //   353: lcmp           
            //   354: ldc             11
            //   356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   359: ifge            372
            //   362: aload_0        
            //   363: lconst_0       
            //   364: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.est:J
            //   367: ldc             3
            //   369: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   372: iload           7
            //   374: ldc             2
            //   376: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   379: ifle            420
            //   382: aload_0        
            //   383: iload           7
            //   385: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.batch:I
            //   388: ldc             3
            //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   393: aload           5
            //   395: iconst_0       
            //   396: iload           7
            //   398: sipush          4368
            //   401: ldc             4
            //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   406: ldc             1
            //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   411: invokestatic    instrumented/java/util/Spliterators.spliterator:([Ljava/lang/Object;III)Linstrumented/java/util/Spliterator;
            //   414: ldc             1
            //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   419: areturn        
            //   420: aconst_null    
            //   421: ldc             2
            //   423: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   426: areturn        
            //   427: athrow         
            //   428: athrow         
            //    Signature:
            //  ()Linstrumented/java/util/Spliterator<TE;>;
            //    StackMapTable: 00 0E FE 00 26 00 07 00 0A 01 14 47 01 FF 00 2E 00 05 07 00 02 07 00 0D 07 00 0A 01 01 00 00 FF 00 58 00 09 07 00 02 07 00 0D 07 00 0A 01 01 07 00 51 07 00 4D 01 07 00 0D 00 00 1A 1B 51 07 00 34 18 25 20 FF 00 2F 00 05 07 00 02 00 07 00 0A 01 01 00 00 FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  178    428    428    429    Ljava/lang/VirtualMachineError;
            //  178    258    276    301    Any
            //  276    283    276    301    Any
            //  0      427    427    428    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0203:
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
        public void forEachRemaining(final Consumer<? super E> p0) {
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
            //    28: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.queue:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //    31: astore_2       
            //    32: ldc             3
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: aload_2        
            //    38: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    41: astore_3       
            //    42: ldc             3
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_0        
            //    48: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //    51: ldc             3
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: ifne            244
            //    59: aload_0        
            //    60: iconst_1       
            //    61: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //    64: ldc             3
            //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    69: aload_0        
            //    70: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    73: astore          4
            //    75: ldc             3
            //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    80: aconst_null    
            //    81: astore          5
            //    83: ldc             2
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: aload_3        
            //    89: ldc             2
            //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    94: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    97: aload           4
            //    99: ldc             2
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: ifnonnull       118
            //   107: aload_2        
            //   108: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   111: astore          4
            //   113: ldc             3
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: aload           4
            //   120: ldc             2
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: ifnull          170
            //   128: aload           4
            //   130: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //   133: astore          5
            //   135: ldc             3
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: aload           4
            //   142: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   145: astore          4
            //   147: ldc             3
            //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   152: aload           5
            //   154: ldc             2
            //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   159: ifnull          118
            //   162: ldc             1
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: goto            170
            //   170: aload_3        
            //   171: ldc             2
            //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   176: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   179: ldc             1
            //   181: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   184: goto            211
            //   187: astore          6
            //   189: ldc             501
            //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   194: aload_3        
            //   195: ldc             2
            //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   200: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   203: aload           6
            //   205: ldc             2
            //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   210: athrow         
            //   211: aload           5
            //   213: ldc             2
            //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   218: ifnull          234
            //   221: aload_1        
            //   222: aload           5
            //   224: ldc             3
            //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   229: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
            //   234: aload           4
            //   236: ldc             2
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: ifnonnull       80
            //   244: ldc             1
            //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   249: return         
            //   250: athrow         
            //   251: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Consumer<-TE;>;)V
            //    StackMapTable: 00 0A 1B FE 00 34 07 00 0A 07 00 4D 07 00 0D FC 00 25 07 00 05 33 50 07 00 34 17 FA 00 16 FA 00 09 FF 00 05 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  97     251    251    252    Ljava/lang/VirtualMachineError;
            //  97     170    187    211    Any
            //  187    194    187    211    Any
            //  0      250    250    251    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
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
        public boolean tryAdvance(final Consumer<? super E> p0) {
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
            //    28: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.queue:Linstrumented/java/util/concurrent/LinkedBlockingDeque;
            //    31: astore_2       
            //    32: ldc             3
            //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    37: aload_2        
            //    38: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.lock:Linstrumented/java/util/concurrent/locks/ReentrantLock;
            //    41: astore_3       
            //    42: ldc             3
            //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    47: aload_0        
            //    48: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //    51: ldc             3
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: ifne            254
            //    59: aconst_null    
            //    60: astore          4
            //    62: ldc             2
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: aload_3        
            //    68: ldc             2
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.lock:()V
            //    76: aload_0        
            //    77: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    80: ldc             3
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: ifnonnull       101
            //    88: aload_0        
            //    89: aload_2        
            //    90: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque.first:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    93: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //    96: ldc             4
            //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   101: aload_0        
            //   102: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   105: ldc             3
            //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   110: ifnull          161
            //   113: aload_0        
            //   114: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   117: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.item:Ljava/lang/Object;
            //   120: astore          4
            //   122: ldc             4
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: aload_0        
            //   128: aload_0        
            //   129: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   132: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$Node.next:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   135: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   138: ldc             5
            //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   143: aload           4
            //   145: ldc             2
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: ifnull          101
            //   153: ldc             1
            //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   158: goto            161
            //   161: aload_3        
            //   162: ldc             2
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   170: ldc             1
            //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   175: goto            202
            //   178: astore          5
            //   180: ldc             501
            //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   185: aload_3        
            //   186: ldc             2
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: invokevirtual   instrumented/java/util/concurrent/locks/ReentrantLock.unlock:()V
            //   194: aload           5
            //   196: ldc             2
            //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   201: athrow         
            //   202: aload_0        
            //   203: getfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.current:Linstrumented/java/util/concurrent/LinkedBlockingDeque$Node;
            //   206: ldc             3
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: ifnonnull       224
            //   214: aload_0        
            //   215: iconst_1       
            //   216: putfield        instrumented/java/util/concurrent/LinkedBlockingDeque$LBDSpliterator.exhausted:Z
            //   219: ldc             3
            //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   224: aload           4
            //   226: ldc             2
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: ifnull          254
            //   234: aload_1        
            //   235: aload           4
            //   237: ldc             3
            //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   242: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
            //   247: iconst_1       
            //   248: ldc             2
            //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   253: ireturn        
            //   254: iconst_0       
            //   255: ldc             2
            //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   260: ireturn        
            //   261: athrow         
            //   262: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Consumer<-TE;>;)Z
            //    StackMapTable: 00 09 1B FE 00 49 07 00 0A 07 00 4D 07 00 05 3B 50 07 00 34 17 15 FA 00 1D FF 00 06 00 00 00 01 07 00 34 FF 00 00 00 00 00 01 07 00 3A
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  76     262    262    263    Ljava/lang/VirtualMachineError;
            //  76     161    178    202    Any
            //  178    185    178    202    Any
            //  0      261    261    262    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
        public int characteristics() {
            try {
                final int n = 4368;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
