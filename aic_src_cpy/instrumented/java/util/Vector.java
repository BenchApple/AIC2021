// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.UnaryOperator;
import instrumented.java.util.function.Predicate;
import instrumented.java.util.function.Consumer;
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
{
    protected Object[] elementData;
    protected int elementCount;
    protected int capacityIncrement;
    private static final long serialVersionUID = -2767605614048989439L;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    
    public Vector(final int i, final int capacityIncrement) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            if (i < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal Capacity: ";
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
            this.elementData = new Object[i];
            BytecodeManager.incBytecodes(3);
            this.capacityIncrement = capacityIncrement;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Vector(final int n) {
        try {
            final int n2 = 0;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Vector() {
        try {
            final int n = 10;
            BytecodeManager.incBytecodes(3);
            this(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Vector(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(3);
            this.elementData = collection.toArray();
            BytecodeManager.incBytecodes(1);
            this.elementCount = this.elementData.length;
            BytecodeManager.incBytecodes(5);
            final Object[] elementData = this.elementData;
            BytecodeManager.incBytecodes(3);
            final Class<? extends Object[]> class1 = elementData.getClass();
            final Class<Object[]> clazz = Object[].class;
            BytecodeManager.incBytecodes(2);
            if (class1 != clazz) {
                final Object[] elementData2 = this.elementData;
                final int elementCount = this.elementCount;
                final Class<Object[]> clazz2 = Object[].class;
                BytecodeManager.incBytecodes(7);
                this.elementData = Arrays.copyOf(elementData2, elementCount, (Class<? extends Object[]>)clazz2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void copyInto(final Object[] array) {
        try {
            final Object[] elementData = this.elementData;
            final int n = 0;
            final int n2 = 0;
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(elementData, n, array, n2, elementCount);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void trimToSize() {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int length = this.elementData.length;
            BytecodeManager.incBytecodes(4);
            final int elementCount = this.elementCount;
            final int n = length;
            BytecodeManager.incBytecodes(4);
            if (elementCount < n) {
                final Object[] elementData = this.elementData;
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(6);
                this.elementData = Arrays.copyOf(elementData, elementCount2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void ensureCapacity(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                ++this.modCount;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(3);
                this.ensureCapacityHelper(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void ensureCapacityHelper(final int n) {
        try {
            final int n2 = n - this.elementData.length;
            BytecodeManager.incBytecodes(6);
            if (n2 > 0) {
                BytecodeManager.incBytecodes(3);
                this.grow(n);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void grow(final int n) {
        try {
            final int length = this.elementData.length;
            BytecodeManager.incBytecodes(4);
            final int n2 = length;
            final int capacityIncrement = this.capacityIncrement;
            BytecodeManager.incBytecodes(4);
            int capacityIncrement2;
            if (capacityIncrement > 0) {
                capacityIncrement2 = this.capacityIncrement;
                BytecodeManager.incBytecodes(3);
            }
            else {
                capacityIncrement2 = length;
                BytecodeManager.incBytecodes(1);
            }
            int hugeCapacity = n2 + capacityIncrement2;
            BytecodeManager.incBytecodes(2);
            final int n3 = hugeCapacity - n;
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                hugeCapacity = n;
                BytecodeManager.incBytecodes(2);
            }
            final int n4 = hugeCapacity - 2147483639;
            BytecodeManager.incBytecodes(4);
            if (n4 > 0) {
                BytecodeManager.incBytecodes(2);
                hugeCapacity = hugeCapacity(n);
                BytecodeManager.incBytecodes(1);
            }
            final Object[] elementData = this.elementData;
            final int n5 = hugeCapacity;
            BytecodeManager.incBytecodes(5);
            this.elementData = Arrays.copyOf(elementData, n5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int hugeCapacity(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(3);
                final OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
                BytecodeManager.incBytecodes(1);
                throw outOfMemoryError;
            }
            final int n2 = 2147483639;
            BytecodeManager.incBytecodes(3);
            int n3;
            if (n > n2) {
                n3 = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n3 = 2147483639;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setSize(final int elementCount) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int elementCount2 = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (elementCount > elementCount2) {
                BytecodeManager.incBytecodes(3);
                this.ensureCapacityHelper(elementCount);
                BytecodeManager.incBytecodes(1);
            }
            else {
                int n = elementCount;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    final int elementCount3 = this.elementCount;
                    BytecodeManager.incBytecodes(4);
                    if (n2 >= elementCount3) {
                        break;
                    }
                    this.elementData[n] = null;
                    BytecodeManager.incBytecodes(5);
                    ++n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            this.elementCount = elementCount;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized int capacity() {
        try {
            final int length = this.elementData.length;
            BytecodeManager.incBytecodes(4);
            return length;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized int size() {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            return elementCount;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean isEmpty() {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (elementCount == 0) {
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
    
    public Enumeration<E> elements() {
        try {
            BytecodeManager.incBytecodes(4);
            final Enumeration<E> enumeration = new Enumeration<E>() {
                int count = 0;
                
                {
                    BytecodeManager.incBytecodes(4);
                }
                
                @Override
                public boolean hasMoreElements() {
                    try {
                        final int count = this.count;
                        final int elementCount = Vector.this.elementCount;
                        BytecodeManager.incBytecodes(6);
                        boolean b;
                        if (count < elementCount) {
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
                public E nextElement() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        instrumented/java/util/Vector$1.this$0:Linstrumented/java/util/Vector;
                    //     4: dup            
                    //     5: astore_1       
                    //     6: pop            
                    //     7: ldc             5
                    //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    12: aload_0        
                    //    13: getfield        instrumented/java/util/Vector$1.count:I
                    //    16: aload_0        
                    //    17: getfield        instrumented/java/util/Vector$1.this$0:Linstrumented/java/util/Vector;
                    //    20: getfield        instrumented/java/util/Vector.elementCount:I
                    //    23: ldc             6
                    //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    28: if_icmpge       67
                    //    31: aload_0        
                    //    32: getfield        instrumented/java/util/Vector$1.this$0:Linstrumented/java/util/Vector;
                    //    35: aload_0        
                    //    36: dup            
                    //    37: getfield        instrumented/java/util/Vector$1.count:I
                    //    40: dup_x1         
                    //    41: iconst_1       
                    //    42: iadd           
                    //    43: putfield        instrumented/java/util/Vector$1.count:I
                    //    46: ldc             10
                    //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    51: invokevirtual   instrumented/java/util/Vector.elementData:(I)Ljava/lang/Object;
                    //    54: aload_1        
                    //    55: pop            
                    //    56: ldc             2
                    //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    61: ldc             1
                    //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    66: areturn        
                    //    67: aload_1        
                    //    68: pop            
                    //    69: ldc             2
                    //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    74: ldc             1
                    //    76: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    79: goto            97
                    //    82: astore_2       
                    //    83: aload_1        
                    //    84: pop            
                    //    85: ldc             503
                    //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    90: aload_2        
                    //    91: ldc             2
                    //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    96: athrow         
                    //    97: new             Linstrumented/java/util/NoSuchElementException;
                    //   100: dup            
                    //   101: ldc             "Vector Enumeration"
                    //   103: ldc             4
                    //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   108: invokespecial   instrumented/java/util/NoSuchElementException.<init>:(Ljava/lang/String;)V
                    //   111: ldc             1
                    //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //   116: athrow         
                    //   117: athrow         
                    //   118: athrow         
                    //    Signature:
                    //  ()TE;
                    //    StackMapTable: 00 05 FC 00 43 07 00 05 4E 07 00 24 FA 00 0E FF 00 13 00 00 00 01 07 00 24 FF 00 00 00 00 00 01 07 00 30
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                           
                    //  -----  -----  -----  -----  -------------------------------
                    //  12     118    118    119    Ljava/lang/VirtualMachineError;
                    //  12     61     82     97     Any
                    //  67     74     82     97     Any
                    //  82     90     82     97     Any
                    //  0      117    117    118    Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
            };
            BytecodeManager.incBytecodes(1);
            return enumeration;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            final int index = this.indexOf(o, n);
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
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            final int index = this.indexOf(o, n);
            BytecodeManager.incBytecodes(1);
            return index;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized int indexOf(final Object o, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n2 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n3 = n2;
                    final int elementCount = this.elementCount;
                    BytecodeManager.incBytecodes(4);
                    if (n3 >= elementCount) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = this.elementData[n2];
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final int n4 = n2;
                        BytecodeManager.incBytecodes(2);
                        return n4;
                    }
                    ++n2;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n5 = n;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n6 = n5;
                    final int elementCount2 = this.elementCount;
                    BytecodeManager.incBytecodes(4);
                    if (n6 >= elementCount2) {
                        break;
                    }
                    final Object obj = this.elementData[n5];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n7 = n5;
                        BytecodeManager.incBytecodes(2);
                        return n7;
                    }
                    ++n5;
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
    public synchronized int lastIndexOf(final Object o) {
        try {
            final int n = this.elementCount - 1;
            BytecodeManager.incBytecodes(7);
            final int lastIndex = this.lastIndexOf(o, n);
            BytecodeManager.incBytecodes(1);
            return lastIndex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized int lastIndexOf(final Object o, final int i) {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (i >= elementCount) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " >= ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(elementCount2);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final IndexOutOfBoundsException ex = new IndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                int n = i;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n2 = n;
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final Object o2 = this.elementData[n];
                    BytecodeManager.incBytecodes(5);
                    if (o2 == null) {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        return n3;
                    }
                    --n;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                int n4 = i;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n4;
                    BytecodeManager.incBytecodes(2);
                    if (n5 < 0) {
                        break;
                    }
                    final Object obj = this.elementData[n4];
                    BytecodeManager.incBytecodes(6);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final int n6 = n4;
                        BytecodeManager.incBytecodes(2);
                        return n6;
                    }
                    --n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n7 = -1;
            BytecodeManager.incBytecodes(2);
            return n7;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized E elementAt(final int i) {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (i >= elementCount) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " >= ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(elementCount2);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(i);
            BytecodeManager.incBytecodes(1);
            return elementData;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized E firstElement() {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            if (elementCount == 0) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = 0;
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(n);
            BytecodeManager.incBytecodes(1);
            return elementData;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized E lastElement() {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            if (elementCount == 0) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = this.elementCount - 1;
            BytecodeManager.incBytecodes(6);
            final E elementData = this.elementData(n);
            BytecodeManager.incBytecodes(1);
            return elementData;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void setElementAt(final E e, final int i) {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (i >= elementCount) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " >= ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(elementCount2);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            this.elementData[i] = e;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void removeElementAt(final int n) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (n >= elementCount) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(n);
                final String str = " >= ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(elementCount2);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            if (n < 0) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex2 = new ArrayIndexOutOfBoundsException(n);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            final int n2 = this.elementCount - n - 1;
            BytecodeManager.incBytecodes(7);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 > 0) {
                final Object[] elementData = this.elementData;
                final int n4 = n + 1;
                final Object[] elementData2 = this.elementData;
                final int n5 = n2;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(elementData, n4, elementData2, n, n5);
            }
            --this.elementCount;
            BytecodeManager.incBytecodes(6);
            this.elementData[this.elementCount] = null;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void insertElementAt(final E e, final int i) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (i > elementCount) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(i);
                final String str = " > ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(elementCount2);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n = this.elementCount + 1;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityHelper(n);
            final Object[] elementData = this.elementData;
            final Object[] elementData2 = this.elementData;
            final int n2 = i + 1;
            final int n3 = this.elementCount - i;
            BytecodeManager.incBytecodes(13);
            System.arraycopy(elementData, i, elementData2, n2, n3);
            this.elementData[i] = e;
            BytecodeManager.incBytecodes(5);
            ++this.elementCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void addElement(final E e) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n = this.elementCount + 1;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityHelper(n);
            this.elementData[this.elementCount++] = e;
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized boolean removeElement(final Object o) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(3);
            final int index = this.indexOf(o);
            BytecodeManager.incBytecodes(1);
            final int n = index;
            BytecodeManager.incBytecodes(2);
            if (n >= 0) {
                final int n2 = index;
                BytecodeManager.incBytecodes(3);
                this.removeElementAt(n2);
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
    
    public synchronized void removeAllElements() {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int elementCount = this.elementCount;
                BytecodeManager.incBytecodes(4);
                if (n2 >= elementCount) {
                    break;
                }
                this.elementData[n] = null;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            this.elementCount = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized Object clone() {
        try {
            try {
                BytecodeManager.incBytecodes(2);
                final Vector vector = (Vector)super.clone();
                BytecodeManager.incBytecodes(2);
                final Vector vector2 = vector;
                final Object[] elementData = this.elementData;
                final int elementCount = this.elementCount;
                BytecodeManager.incBytecodes(6);
                vector2.elementData = Arrays.copyOf(elementData, elementCount);
                BytecodeManager.incBytecodes(1);
                vector.modCount = 0;
                BytecodeManager.incBytecodes(3);
                final Vector vector3 = vector;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return vector3;
            }
            catch (CloneNotSupportedException ex) {
                BytecodeManager.incBytecodes(501);
                final CloneNotSupportedException cause = ex;
                BytecodeManager.incBytecodes(4);
                final InternalError internalError = new InternalError(cause);
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
    public synchronized Object[] toArray() {
        try {
            final Object[] elementData = this.elementData;
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(5);
            final Object[] copy = Arrays.copyOf(elementData, elementCount);
            BytecodeManager.incBytecodes(1);
            return copy;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized <T> T[] toArray(final T[] array) {
        try {
            final int length = array.length;
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(5);
            if (length < elementCount) {
                final Object[] elementData = this.elementData;
                final int elementCount2 = this.elementCount;
                BytecodeManager.incBytecodes(6);
                final Class<? extends Object[]> class1 = array.getClass();
                BytecodeManager.incBytecodes(1);
                final T[] array2 = Arrays.copyOf(elementData, elementCount2, (Class<? extends T[]>)class1);
                BytecodeManager.incBytecodes(2);
                return array2;
            }
            final Object[] elementData2 = this.elementData;
            final int n = 0;
            final int n2 = 0;
            final int elementCount3 = this.elementCount;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(elementData2, n, array, n2, elementCount3);
            final int length2 = array.length;
            final int elementCount4 = this.elementCount;
            BytecodeManager.incBytecodes(5);
            if (length2 > elementCount4) {
                array[this.elementCount] = null;
                BytecodeManager.incBytecodes(5);
            }
            BytecodeManager.incBytecodes(2);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    E elementData(final int n) {
        try {
            final Object o = this.elementData[n];
            BytecodeManager.incBytecodes(5);
            return (E)o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized E get(final int index) {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (index >= elementCount) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(index);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(index);
            BytecodeManager.incBytecodes(1);
            return elementData;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized E set(final int index, final E e) {
        try {
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (index >= elementCount) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(index);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(index);
            BytecodeManager.incBytecodes(1);
            this.elementData[index] = e;
            BytecodeManager.incBytecodes(5);
            final E e2 = elementData;
            BytecodeManager.incBytecodes(2);
            return e2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean add(final E e) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n = this.elementCount + 1;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityHelper(n);
            this.elementData[this.elementCount++] = e;
            BytecodeManager.incBytecodes(11);
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean removeElement = this.removeElement(o);
            BytecodeManager.incBytecodes(1);
            return removeElement;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void add(final int n, final E e) {
        try {
            BytecodeManager.incBytecodes(4);
            this.insertElementAt(e, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized E remove(final int index) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(4);
            if (index >= elementCount) {
                BytecodeManager.incBytecodes(4);
                final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(index);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final E elementData = this.elementData(index);
            BytecodeManager.incBytecodes(1);
            final int n = this.elementCount - index - 1;
            BytecodeManager.incBytecodes(7);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 > 0) {
                final Object[] elementData2 = this.elementData;
                final int n3 = index + 1;
                final Object[] elementData3 = this.elementData;
                final int n4 = n;
                BytecodeManager.incBytecodes(10);
                System.arraycopy(elementData2, n3, elementData3, index, n4);
            }
            this.elementData[--this.elementCount] = null;
            BytecodeManager.incBytecodes(11);
            final E e = elementData;
            BytecodeManager.incBytecodes(2);
            return e;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            BytecodeManager.incBytecodes(2);
            this.removeAllElements();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean containsAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean containsAll = super.containsAll(collection);
            BytecodeManager.incBytecodes(1);
            return containsAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean addAll(final Collection<? extends E> collection) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(2);
            final Object[] array = collection.toArray();
            BytecodeManager.incBytecodes(1);
            final int length = array.length;
            BytecodeManager.incBytecodes(3);
            final int n = this.elementCount + length;
            BytecodeManager.incBytecodes(6);
            this.ensureCapacityHelper(n);
            final Object[] array2 = array;
            final int n2 = 0;
            final Object[] elementData = this.elementData;
            final int elementCount = this.elementCount;
            final int n3 = length;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(array2, n2, elementData, elementCount, n3);
            this.elementCount += length;
            BytecodeManager.incBytecodes(6);
            final int n4 = length;
            BytecodeManager.incBytecodes(2);
            boolean b;
            if (n4 != 0) {
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
    public synchronized boolean removeAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean removeAll = super.removeAll(collection);
            BytecodeManager.incBytecodes(1);
            return removeAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean retainAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean retainAll = super.retainAll(collection);
            BytecodeManager.incBytecodes(1);
            return retainAll;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean addAll(final int index, final Collection<? extends E> collection) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(2);
            if (index >= 0) {
                final int elementCount = this.elementCount;
                BytecodeManager.incBytecodes(4);
                if (index <= elementCount) {
                    BytecodeManager.incBytecodes(2);
                    final Object[] array = collection.toArray();
                    BytecodeManager.incBytecodes(1);
                    final int length = array.length;
                    BytecodeManager.incBytecodes(3);
                    final int n = this.elementCount + length;
                    BytecodeManager.incBytecodes(6);
                    this.ensureCapacityHelper(n);
                    final int n2 = this.elementCount - index;
                    BytecodeManager.incBytecodes(5);
                    final int n3 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n3 > 0) {
                        final Object[] elementData = this.elementData;
                        final Object[] elementData2 = this.elementData;
                        final int n4 = index + length;
                        final int n5 = n2;
                        BytecodeManager.incBytecodes(10);
                        System.arraycopy(elementData, index, elementData2, n4, n5);
                    }
                    final Object[] array2 = array;
                    final int n6 = 0;
                    final Object[] elementData3 = this.elementData;
                    final int n7 = length;
                    BytecodeManager.incBytecodes(7);
                    System.arraycopy(array2, n6, elementData3, index, n7);
                    this.elementCount += length;
                    BytecodeManager.incBytecodes(6);
                    final int n8 = length;
                    BytecodeManager.incBytecodes(2);
                    boolean b;
                    if (n8 != 0) {
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
            }
            BytecodeManager.incBytecodes(4);
            final ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException(index);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized boolean equals(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean equals = super.equals(o);
            BytecodeManager.incBytecodes(1);
            return equals;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized int hashCode() {
        try {
            BytecodeManager.incBytecodes(2);
            final int hashCode = super.hashCode();
            BytecodeManager.incBytecodes(1);
            return hashCode;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized String toString() {
        try {
            BytecodeManager.incBytecodes(2);
            final String string = super.toString();
            BytecodeManager.incBytecodes(1);
            return string;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized List<E> subList(final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(4);
            final List<E> subList = super.subList(n, n2);
            BytecodeManager.incBytecodes(2);
            final List<E> synchronizedList = Collections.synchronizedList(subList, this);
            BytecodeManager.incBytecodes(1);
            return synchronizedList;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected synchronized void removeRange(final int n, final int n2) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final int n3 = this.elementCount - n2;
            BytecodeManager.incBytecodes(5);
            final Object[] elementData = this.elementData;
            final Object[] elementData2 = this.elementData;
            final int n4 = n3;
            BytecodeManager.incBytecodes(8);
            System.arraycopy(elementData, n2, elementData2, n, n4);
            final int n5 = this.elementCount - (n2 - n);
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int elementCount = this.elementCount;
                final int n6 = n5;
                BytecodeManager.incBytecodes(4);
                if (elementCount == n6) {
                    break;
                }
                this.elementData[--this.elementCount] = null;
                BytecodeManager.incBytecodes(12);
            }
            BytecodeManager.incBytecodes(1);
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
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   java/io/ObjectOutputStream.putFields:()Ljava/io/ObjectOutputStream$PutField;
        //     9: astore_2       
        //    10: ldc             1
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: aload_0        
        //    16: dup            
        //    17: astore          4
        //    19: pop            
        //    20: ldc             4
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload_2        
        //    26: ldc_w           "capacityIncrement"
        //    29: aload_0        
        //    30: getfield        instrumented/java/util/Vector.capacityIncrement:I
        //    33: ldc             5
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokevirtual   java/io/ObjectOutputStream$PutField.put:(Ljava/lang/String;I)V
        //    41: aload_2        
        //    42: ldc_w           "elementCount"
        //    45: aload_0        
        //    46: getfield        instrumented/java/util/Vector.elementCount:I
        //    49: ldc             5
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokevirtual   java/io/ObjectOutputStream$PutField.put:(Ljava/lang/String;I)V
        //    57: aload_0        
        //    58: getfield        instrumented/java/util/Vector.elementData:[Ljava/lang/Object;
        //    61: ldc             3
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    69: checkcast       [Ljava/lang/Object;
        //    72: astore_3       
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: aload           4
        //    80: pop            
        //    81: ldc             2
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: ldc             1
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: goto            113
        //    94: astore          5
        //    96: aload           4
        //    98: pop            
        //    99: ldc_w           503
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: aload           5
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: athrow         
        //   113: aload_2        
        //   114: ldc_w           "elementData"
        //   117: aload_3        
        //   118: ldc             4
        //   120: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   123: invokevirtual   java/io/ObjectOutputStream$PutField.put:(Ljava/lang/String;Ljava/lang/Object;)V
        //   126: aload_1        
        //   127: ldc             2
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokevirtual   java/io/ObjectOutputStream.writeFields:()V
        //   135: ldc             1
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: return         
        //   141: athrow         
        //   142: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 04 FF 00 5E 00 05 07 00 02 07 00 12 07 00 10 00 07 00 4E 00 01 07 00 55 FF 00 12 00 04 07 00 02 07 00 12 07 00 10 07 00 68 00 00 FF 00 1B 00 00 00 01 07 00 55 FF 00 00 00 00 00 01 07 00 CE
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  25     142    142    143    Ljava/lang/VirtualMachineError;
        //  25     86     94     113    Any
        //  94     105    94     113    Any
        //  0      141    141    142    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    public synchronized ListIterator<E> listIterator(final int i) {
        try {
            BytecodeManager.incBytecodes(2);
            if (i >= 0) {
                final int elementCount = this.elementCount;
                BytecodeManager.incBytecodes(4);
                if (i <= elementCount) {
                    BytecodeManager.incBytecodes(5);
                    final ListItr listItr = new ListItr(i);
                    BytecodeManager.incBytecodes(1);
                    return listItr;
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
    public synchronized ListIterator<E> listIterator() {
        try {
            final int n = 0;
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
    public synchronized Iterator<E> iterator() {
        try {
            final Enumeration<E> enumeration = null;
            BytecodeManager.incBytecodes(5);
            final Itr itr = new Itr();
            BytecodeManager.incBytecodes(1);
            return itr;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void forEach(final Consumer<? super E> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(consumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] array = this.elementData;
            BytecodeManager.incBytecodes(4);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n2 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n2) {
                    break;
                }
                final int n3 = n;
                final int n4 = elementCount;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object o = array[n];
                BytecodeManager.incBytecodes(5);
                consumer.accept((Object)o);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n5 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n5) {
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
    
    @Override
    public synchronized boolean removeIf(final Predicate<? super E> predicate) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(predicate);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            final int n2 = elementCount;
            BytecodeManager.incBytecodes(4);
            final BitSet set = new BitSet(n2);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            int n3 = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n4 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n4) {
                    break;
                }
                final int n5 = n3;
                final int n6 = elementCount;
                BytecodeManager.incBytecodes(3);
                if (n5 >= n6) {
                    break;
                }
                final Object o = this.elementData[n3];
                BytecodeManager.incBytecodes(5);
                final Object o2 = o;
                BytecodeManager.incBytecodes(3);
                final boolean test = predicate.test((Object)o2);
                BytecodeManager.incBytecodes(1);
                if (test) {
                    final BitSet set2 = set;
                    final int n7 = n3;
                    BytecodeManager.incBytecodes(3);
                    set2.set(n7);
                    ++n;
                    BytecodeManager.incBytecodes(1);
                }
                ++n3;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n8 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n8) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n9 = n;
            BytecodeManager.incBytecodes(2);
            int n10;
            if (n9 > 0) {
                n10 = 1;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n10 = 0;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b = n10 != 0;
            BytecodeManager.incBytecodes(1);
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            if (b2) {
                final int elementCount2 = elementCount - n;
                BytecodeManager.incBytecodes(4);
                int nextClearBit = 0;
                int n11 = 0;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n12 = nextClearBit;
                    final int n13 = elementCount;
                    BytecodeManager.incBytecodes(3);
                    if (n12 >= n13) {
                        break;
                    }
                    final int n14 = n11;
                    final int n15 = elementCount2;
                    BytecodeManager.incBytecodes(3);
                    if (n14 >= n15) {
                        break;
                    }
                    final BitSet set3 = set;
                    final int n16 = nextClearBit;
                    BytecodeManager.incBytecodes(3);
                    nextClearBit = set3.nextClearBit(n16);
                    BytecodeManager.incBytecodes(1);
                    this.elementData[n11] = this.elementData[nextClearBit];
                    BytecodeManager.incBytecodes(8);
                    ++nextClearBit;
                    ++n11;
                    BytecodeManager.incBytecodes(3);
                }
                int n17 = elementCount2;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n18 = n17;
                    final int n19 = elementCount;
                    BytecodeManager.incBytecodes(3);
                    if (n18 >= n19) {
                        break;
                    }
                    this.elementData[n17] = null;
                    BytecodeManager.incBytecodes(5);
                    ++n17;
                    BytecodeManager.incBytecodes(2);
                }
                this.elementCount = elementCount2;
                BytecodeManager.incBytecodes(3);
                final int modCount4 = this.modCount;
                final int n20 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount4 != n20) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                ++this.modCount;
                BytecodeManager.incBytecodes(6);
            }
            final boolean b3 = b;
            BytecodeManager.incBytecodes(2);
            return b3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void replaceAll(final UnaryOperator<E> unaryOperator) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(unaryOperator);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(3);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int modCount2 = this.modCount;
                final int n2 = modCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n2) {
                    break;
                }
                final int n3 = n;
                final int n4 = elementCount;
                BytecodeManager.incBytecodes(3);
                if (n3 >= n4) {
                    break;
                }
                final Object[] elementData = this.elementData;
                final int n5 = n;
                final Object o = this.elementData[n];
                BytecodeManager.incBytecodes(9);
                elementData[n5] = unaryOperator.apply((E)o);
                BytecodeManager.incBytecodes(1);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            final int modCount3 = this.modCount;
            final int n6 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount3 != n6) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public synchronized void sort(final Comparator<? super E> comparator) {
        try {
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            final Object[] array = this.elementData;
            final int n = 0;
            final int elementCount = this.elementCount;
            BytecodeManager.incBytecodes(8);
            Arrays.sort(array, n, elementCount, (Comparator<? super Object>)comparator);
            final int modCount2 = this.modCount;
            final int n2 = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount2 != n2) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final Object[] array = null;
            final int n = 0;
            final int n2 = -1;
            final int n3 = 0;
            BytecodeManager.incBytecodes(8);
            final VectorSpliterator vectorSpliterator = new VectorSpliterator<E>(this, array, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<E>)vectorSpliterator;
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
        
        private Itr() {
            try {
                BytecodeManager.incBytecodes(5);
                this.lastRet = -1;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = Vector.this.modCount;
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
                final int elementCount = Vector.this.elementCount;
                BytecodeManager.incBytecodes(6);
                boolean b;
                if (cursor != elementCount) {
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
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: ldc             2
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokevirtual   instrumented/java/util/Vector$Itr.checkForComodification:()V
            //    21: aload_0        
            //    22: getfield        instrumented/java/util/Vector$Itr.cursor:I
            //    25: istore_2       
            //    26: ldc             3
            //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    31: iload_2        
            //    32: aload_0        
            //    33: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    36: getfield        instrumented/java/util/Vector.elementCount:I
            //    39: ldc             5
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: if_icmplt       65
            //    47: new             Linstrumented/java/util/NoSuchElementException;
            //    50: dup            
            //    51: ldc             3
            //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    56: invokespecial   instrumented/java/util/NoSuchElementException.<init>:()V
            //    59: ldc             1
            //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    64: athrow         
            //    65: aload_0        
            //    66: iload_2        
            //    67: iconst_1       
            //    68: iadd           
            //    69: putfield        instrumented/java/util/Vector$Itr.cursor:I
            //    72: ldc             5
            //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    77: aload_0        
            //    78: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    81: aload_0        
            //    82: iload_2        
            //    83: dup_x1         
            //    84: putfield        instrumented/java/util/Vector$Itr.lastRet:I
            //    87: ldc             7
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: invokevirtual   instrumented/java/util/Vector.elementData:(I)Ljava/lang/Object;
            //    95: aload_1        
            //    96: pop            
            //    97: ldc             2
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: ldc             1
            //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   107: areturn        
            //   108: astore_3       
            //   109: aload_1        
            //   110: pop            
            //   111: ldc             503
            //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   116: aload_3        
            //   117: ldc             2
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: athrow         
            //   123: athrow         
            //   124: athrow         
            //    Signature:
            //  ()TE;
            //    StackMapTable: 00 04 FD 00 41 07 00 05 01 FF 00 2A 00 02 07 00 02 07 00 05 00 01 07 00 2C FF 00 0E 00 00 00 01 07 00 2C FF 00 00 00 00 00 01 07 00 39
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     124    124    125    Ljava/lang/VirtualMachineError;
            //  12     102    108    123    Any
            //  108    116    108    123    Any
            //  0      123    123    124    Any
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
        public void remove() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Vector$Itr.lastRet:I
            //     4: iconst_m1      
            //     5: ldc             4
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: if_icmpne       31
            //    13: new             Ljava/lang/IllegalStateException;
            //    16: dup            
            //    17: ldc             3
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    25: ldc             1
            //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    30: athrow         
            //    31: aload_0        
            //    32: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    35: dup            
            //    36: astore_1       
            //    37: pop            
            //    38: ldc             5
            //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    43: aload_0        
            //    44: ldc             2
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokevirtual   instrumented/java/util/Vector$Itr.checkForComodification:()V
            //    52: aload_0        
            //    53: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/Vector$Itr.lastRet:I
            //    60: ldc             5
            //    62: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    65: invokevirtual   instrumented/java/util/Vector.remove:(I)Ljava/lang/Object;
            //    68: pop            
            //    69: ldc             1
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: aload_0        
            //    75: aload_0        
            //    76: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    79: getfield        instrumented/java/util/Vector.modCount:I
            //    82: putfield        instrumented/java/util/Vector$Itr.expectedModCount:I
            //    85: ldc             5
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: aload_1        
            //    91: pop            
            //    92: ldc             2
            //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    97: ldc             1
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: goto            120
            //   105: astore_2       
            //   106: aload_1        
            //   107: pop            
            //   108: ldc             503
            //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   113: aload_2        
            //   114: ldc             2
            //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   119: athrow         
            //   120: aload_0        
            //   121: aload_0        
            //   122: getfield        instrumented/java/util/Vector$Itr.lastRet:I
            //   125: putfield        instrumented/java/util/Vector$Itr.cursor:I
            //   128: ldc             4
            //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   133: aload_0        
            //   134: iconst_m1      
            //   135: putfield        instrumented/java/util/Vector$Itr.lastRet:I
            //   138: ldc             3
            //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   143: ldc             1
            //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   148: return         
            //   149: athrow         
            //   150: athrow         
            //    StackMapTable: 00 05 1F FF 00 49 00 02 07 00 02 07 00 05 00 01 07 00 2C FA 00 0E FF 00 1C 00 00 00 01 07 00 2C FF 00 00 00 00 00 01 07 00 39
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  43     150    150    151    Ljava/lang/VirtualMachineError;
            //  43     97     105    120    Any
            //  105    113    105    120    Any
            //  0      149    149    150    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0120:
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
        
        public void forEachRemaining(final Consumer<? super E> p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             2
            //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     6: invokestatic    instrumented/java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
            //     9: pop            
            //    10: ldc             1
            //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    15: aload_0        
            //    16: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    19: dup            
            //    20: astore_2       
            //    21: pop            
            //    22: ldc             5
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: aload_0        
            //    28: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    31: getfield        instrumented/java/util/Vector.elementCount:I
            //    34: istore_3       
            //    35: ldc             4
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: aload_0        
            //    41: getfield        instrumented/java/util/Vector$Itr.cursor:I
            //    44: istore          4
            //    46: ldc             3
            //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    51: iload           4
            //    53: iload_3        
            //    54: ldc             3
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: if_icmplt       75
            //    62: aload_2        
            //    63: pop            
            //    64: ldc             2
            //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    69: ldc             1
            //    71: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    74: return         
            //    75: aload_0        
            //    76: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //    79: getfield        instrumented/java/util/Vector.elementData:[Ljava/lang/Object;
            //    82: checkcast       [Ljava/lang/Object;
            //    85: astore          5
            //    87: ldc             5
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: iload           4
            //    94: aload           5
            //    96: arraylength    
            //    97: ldc             4
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: if_icmplt       123
            //   105: new             Linstrumented/java/util/ConcurrentModificationException;
            //   108: dup            
            //   109: ldc             3
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   117: ldc             1
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: athrow         
            //   123: iload           4
            //   125: iload_3        
            //   126: ldc             3
            //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   131: if_icmpeq       180
            //   134: aload_0        
            //   135: getfield        instrumented/java/util/Vector$Itr.this$0:Linstrumented/java/util/Vector;
            //   138: getfield        instrumented/java/util/Vector.modCount:I
            //   141: aload_0        
            //   142: getfield        instrumented/java/util/Vector$Itr.expectedModCount:I
            //   145: ldc             6
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: if_icmpne       180
            //   153: aload_1        
            //   154: aload           5
            //   156: iload           4
            //   158: iinc            4, 1
            //   161: aaload         
            //   162: ldc             6
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
            //   172: ldc             1
            //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   177: goto            123
            //   180: aload_0        
            //   181: iload           4
            //   183: putfield        instrumented/java/util/Vector$Itr.cursor:I
            //   186: ldc             3
            //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   191: aload_0        
            //   192: iload           4
            //   194: iconst_1       
            //   195: isub           
            //   196: putfield        instrumented/java/util/Vector$Itr.lastRet:I
            //   199: ldc             5
            //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   204: aload_0        
            //   205: ldc             2
            //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   210: invokevirtual   instrumented/java/util/Vector$Itr.checkForComodification:()V
            //   213: aload_2        
            //   214: pop            
            //   215: ldc             2
            //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   220: ldc             1
            //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   225: goto            245
            //   228: astore          6
            //   230: aload_2        
            //   231: pop            
            //   232: ldc             503
            //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   237: aload           6
            //   239: ldc             2
            //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   244: athrow         
            //   245: ldc             1
            //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   250: return         
            //   251: athrow         
            //   252: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Consumer<-TE;>;)V
            //    StackMapTable: 00 07 FE 00 4B 07 00 05 01 01 FC 00 2F 07 00 58 38 FF 00 2F 00 03 07 00 02 07 00 5D 07 00 05 00 01 07 00 2C FA 00 10 FF 00 05 00 00 00 01 07 00 2C FF 00 00 00 00 00 01 07 00 39
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  27     252    252    253    Ljava/lang/VirtualMachineError;
            //  27     69     228    245    Any
            //  75     220    228    245    Any
            //  228    237    228    245    Any
            //  0      251    251    252    Any
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
                final int modCount = Vector.this.modCount;
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
    
    final class ListItr extends Itr implements ListIterator<E>
    {
        ListItr(final int cursor) {
            try {
                BytecodeManager.incBytecodes(3);
                final Enumeration<E> enumeration = null;
                BytecodeManager.incBytecodes(4);
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
        public E previous() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //     4: dup            
            //     5: astore_1       
            //     6: pop            
            //     7: ldc             5
            //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    12: aload_0        
            //    13: ldc             2
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: invokevirtual   instrumented/java/util/Vector$ListItr.checkForComodification:()V
            //    21: aload_0        
            //    22: getfield        instrumented/java/util/Vector$ListItr.cursor:I
            //    25: iconst_1       
            //    26: isub           
            //    27: istore_2       
            //    28: ldc             5
            //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    33: iload_2        
            //    34: ldc             2
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: ifge            60
            //    42: new             Linstrumented/java/util/NoSuchElementException;
            //    45: dup            
            //    46: ldc             3
            //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    51: invokespecial   instrumented/java/util/NoSuchElementException.<init>:()V
            //    54: ldc             1
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: athrow         
            //    60: aload_0        
            //    61: iload_2        
            //    62: putfield        instrumented/java/util/Vector$ListItr.cursor:I
            //    65: ldc             3
            //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    70: aload_0        
            //    71: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    74: aload_0        
            //    75: iload_2        
            //    76: dup_x1         
            //    77: putfield        instrumented/java/util/Vector$ListItr.lastRet:I
            //    80: ldc             7
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: invokevirtual   instrumented/java/util/Vector.elementData:(I)Ljava/lang/Object;
            //    88: aload_1        
            //    89: pop            
            //    90: ldc             2
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: ldc             1
            //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   100: areturn        
            //   101: astore_3       
            //   102: aload_1        
            //   103: pop            
            //   104: ldc             503
            //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   109: aload_3        
            //   110: ldc             2
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: athrow         
            //   116: athrow         
            //   117: athrow         
            //    Signature:
            //  ()TE;
            //    StackMapTable: 00 04 FD 00 3C 07 00 3B 01 FF 00 28 00 02 07 00 02 07 00 3B 00 01 07 00 26 FF 00 0E 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 31
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  12     117    117    118    Ljava/lang/VirtualMachineError;
            //  12     95     101    116    Any
            //  101    109    101    116    Any
            //  0      116    116    117    Any
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
        public void set(final E p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Vector$ListItr.lastRet:I
            //     4: iconst_m1      
            //     5: ldc             4
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: if_icmpne       31
            //    13: new             Ljava/lang/IllegalStateException;
            //    16: dup            
            //    17: ldc             3
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: invokespecial   java/lang/IllegalStateException.<init>:()V
            //    25: ldc             1
            //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    30: athrow         
            //    31: aload_0        
            //    32: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    35: dup            
            //    36: astore_2       
            //    37: pop            
            //    38: ldc             5
            //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    43: aload_0        
            //    44: ldc             2
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: invokevirtual   instrumented/java/util/Vector$ListItr.checkForComodification:()V
            //    52: aload_0        
            //    53: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    56: aload_0        
            //    57: getfield        instrumented/java/util/Vector$ListItr.lastRet:I
            //    60: aload_1        
            //    61: ldc             6
            //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    66: invokevirtual   instrumented/java/util/Vector.set:(ILjava/lang/Object;)Ljava/lang/Object;
            //    69: pop            
            //    70: ldc             1
            //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    75: aload_2        
            //    76: pop            
            //    77: ldc             2
            //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    82: ldc             1
            //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    87: goto            105
            //    90: astore_3       
            //    91: aload_2        
            //    92: pop            
            //    93: ldc             503
            //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    98: aload_3        
            //    99: ldc             2
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: athrow         
            //   105: ldc             1
            //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   110: return         
            //   111: athrow         
            //   112: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 05 1F FF 00 3A 00 03 07 00 02 07 00 3B 07 00 3B 00 01 07 00 26 FA 00 0E FF 00 05 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 31
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  43     112    112    113    Ljava/lang/VirtualMachineError;
            //  43     82     90     105    Any
            //  90     98     90     105    Any
            //  0      111    111    112    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0105:
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
            //     1: getfield        instrumented/java/util/Vector$ListItr.cursor:I
            //     4: istore_2       
            //     5: ldc             3
            //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    10: aload_0        
            //    11: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    14: dup            
            //    15: astore_3       
            //    16: pop            
            //    17: ldc             5
            //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    22: aload_0        
            //    23: ldc             2
            //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    28: invokevirtual   instrumented/java/util/Vector$ListItr.checkForComodification:()V
            //    31: aload_0        
            //    32: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    35: iload_2        
            //    36: aload_1        
            //    37: ldc             5
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: invokevirtual   instrumented/java/util/Vector.add:(ILjava/lang/Object;)V
            //    45: aload_0        
            //    46: aload_0        
            //    47: getfield        instrumented/java/util/Vector$ListItr.this$0:Linstrumented/java/util/Vector;
            //    50: getfield        instrumented/java/util/Vector.modCount:I
            //    53: putfield        instrumented/java/util/Vector$ListItr.expectedModCount:I
            //    56: ldc             5
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: aload_3        
            //    62: pop            
            //    63: ldc             2
            //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    68: ldc             1
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: goto            93
            //    76: astore          4
            //    78: aload_3        
            //    79: pop            
            //    80: ldc             503
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: aload           4
            //    87: ldc             2
            //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    92: athrow         
            //    93: aload_0        
            //    94: iload_2        
            //    95: iconst_1       
            //    96: iadd           
            //    97: putfield        instrumented/java/util/Vector$ListItr.cursor:I
            //   100: ldc             5
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: aload_0        
            //   106: iconst_m1      
            //   107: putfield        instrumented/java/util/Vector$ListItr.lastRet:I
            //   110: ldc             3
            //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   115: ldc             1
            //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   120: return         
            //   121: athrow         
            //   122: athrow         
            //    Signature:
            //  (TE;)V
            //    StackMapTable: 00 04 FF 00 4C 00 04 07 00 02 07 00 3B 01 07 00 3B 00 01 07 00 26 FA 00 10 FF 00 1B 00 00 00 01 07 00 26 FF 00 00 00 00 00 01 07 00 31
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  22     122    122    123    Ljava/lang/VirtualMachineError;
            //  22     68     76     93     Any
            //  76     85     76     93     Any
            //  0      121    121    122    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0093:
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
    
    static final class VectorSpliterator<E> implements Spliterator<E>
    {
        private final Vector<E> list;
        private Object[] array;
        private int index;
        private int fence;
        private int expectedModCount;
        
        VectorSpliterator(final Vector<E> list, final Object[] array, final int index, final int fence, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.list = list;
                BytecodeManager.incBytecodes(3);
                this.array = array;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = expectedModCount;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private int getFence() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/Vector$VectorSpliterator.fence:I
            //     4: dup            
            //     5: istore_1       
            //     6: ldc             5
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: ifge            106
            //    14: aload_0        
            //    15: getfield        instrumented/java/util/Vector$VectorSpliterator.list:Linstrumented/java/util/Vector;
            //    18: dup            
            //    19: astore_2       
            //    20: pop            
            //    21: ldc             5
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: aload_0        
            //    27: aload_0        
            //    28: getfield        instrumented/java/util/Vector$VectorSpliterator.list:Linstrumented/java/util/Vector;
            //    31: getfield        instrumented/java/util/Vector.elementData:[Ljava/lang/Object;
            //    34: putfield        instrumented/java/util/Vector$VectorSpliterator.array:[Ljava/lang/Object;
            //    37: ldc             5
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: aload_0        
            //    43: aload_0        
            //    44: getfield        instrumented/java/util/Vector$VectorSpliterator.list:Linstrumented/java/util/Vector;
            //    47: getfield        instrumented/java/util/Vector.modCount:I
            //    50: putfield        instrumented/java/util/Vector$VectorSpliterator.expectedModCount:I
            //    53: ldc             5
            //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    58: aload_0        
            //    59: aload_0        
            //    60: getfield        instrumented/java/util/Vector$VectorSpliterator.list:Linstrumented/java/util/Vector;
            //    63: getfield        instrumented/java/util/Vector.elementCount:I
            //    66: dup_x1         
            //    67: putfield        instrumented/java/util/Vector$VectorSpliterator.fence:I
            //    70: istore_1       
            //    71: ldc             7
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: aload_2        
            //    77: pop            
            //    78: ldc             2
            //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    83: ldc             1
            //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    88: goto            106
            //    91: astore_3       
            //    92: aload_2        
            //    93: pop            
            //    94: ldc             503
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: aload_3        
            //   100: ldc             2
            //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   105: athrow         
            //   106: iload_1        
            //   107: ldc             2
            //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   112: ireturn        
            //   113: athrow         
            //   114: athrow         
            //    StackMapTable: 00 04 FF 00 5B 00 03 07 00 02 01 07 00 05 00 01 07 00 2E FA 00 0E FF 00 06 00 00 00 01 07 00 2E FF 00 00 00 00 00 01 07 00 32
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  26     114    114    115    Ljava/lang/VirtualMachineError;
            //  26     83     91     106    Any
            //  91     99     91     106    Any
            //  0      113    113    114    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
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
        public Spliterator<E> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                Spliterator<E> spliterator;
                if (n2 >= n3) {
                    spliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Vector<E> list;
                    final Object[] array;
                    final int n4;
                    final int index2;
                    final int expectedModCount;
                    spliterator = new VectorSpliterator((Vector<Object>)list, array, n4, index2, expectedModCount);
                    list = this.list;
                    array = this.array;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(14);
                }
                BytecodeManager.incBytecodes(1);
                return spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super E> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index;
                final int n = index = this.index;
                BytecodeManager.incBytecodes(5);
                if (fence <= n) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                this.index = index + 1;
                BytecodeManager.incBytecodes(5);
                final Object o = this.array[index];
                BytecodeManager.incBytecodes(6);
                consumer.accept((Object)o);
                final int modCount = this.list.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final boolean b2 = true;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
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
            //    28: getfield        instrumented/java/util/Vector$VectorSpliterator.list:Linstrumented/java/util/Vector;
            //    31: dup            
            //    32: astore          4
            //    34: ldc             5
            //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    39: ifnull          267
            //    42: aload_0        
            //    43: getfield        instrumented/java/util/Vector$VectorSpliterator.fence:I
            //    46: dup            
            //    47: istore_3       
            //    48: ldc             5
            //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    53: ifge            156
            //    56: aload           4
            //    58: dup            
            //    59: astore          6
            //    61: pop            
            //    62: ldc             4
            //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    67: aload_0        
            //    68: aload           4
            //    70: getfield        instrumented/java/util/Vector.modCount:I
            //    73: putfield        instrumented/java/util/Vector$VectorSpliterator.expectedModCount:I
            //    76: ldc             4
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: aload_0        
            //    82: aload           4
            //    84: getfield        instrumented/java/util/Vector.elementData:[Ljava/lang/Object;
            //    87: dup_x1         
            //    88: putfield        instrumented/java/util/Vector$VectorSpliterator.array:[Ljava/lang/Object;
            //    91: astore          5
            //    93: ldc             6
            //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    98: aload_0        
            //    99: aload           4
            //   101: getfield        instrumented/java/util/Vector.elementCount:I
            //   104: dup_x1         
            //   105: putfield        instrumented/java/util/Vector$VectorSpliterator.fence:I
            //   108: istore_3       
            //   109: ldc             6
            //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   114: aload           6
            //   116: pop            
            //   117: ldc             2
            //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   122: ldc             1
            //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   127: goto            148
            //   130: astore          7
            //   132: aload           6
            //   134: pop            
            //   135: ldc             503
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: aload           7
            //   142: ldc             2
            //   144: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   147: athrow         
            //   148: ldc             1
            //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   153: goto            167
            //   156: aload_0        
            //   157: getfield        instrumented/java/util/Vector$VectorSpliterator.array:[Ljava/lang/Object;
            //   160: astore          5
            //   162: ldc             3
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: aload           5
            //   169: ldc             2
            //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   174: ifnull          267
            //   177: aload_0        
            //   178: getfield        instrumented/java/util/Vector$VectorSpliterator.index:I
            //   181: dup            
            //   182: istore_2       
            //   183: ldc             5
            //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   188: iflt            267
            //   191: aload_0        
            //   192: iload_3        
            //   193: dup_x1         
            //   194: putfield        instrumented/java/util/Vector$VectorSpliterator.index:I
            //   197: aload           5
            //   199: arraylength    
            //   200: ldc             7
            //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   205: if_icmpgt       267
            //   208: iload_2        
            //   209: iload_3        
            //   210: ldc             3
            //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   215: if_icmpge       244
            //   218: aload_1        
            //   219: aload           5
            //   221: iload_2        
            //   222: iinc            2, 1
            //   225: aaload         
            //   226: ldc             6
            //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   231: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
            //   236: ldc             1
            //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   241: goto            208
            //   244: aload           4
            //   246: getfield        instrumented/java/util/Vector.modCount:I
            //   249: aload_0        
            //   250: getfield        instrumented/java/util/Vector$VectorSpliterator.expectedModCount:I
            //   253: ldc             5
            //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   258: if_icmpne       267
            //   261: ldc             1
            //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   266: return         
            //   267: new             Linstrumented/java/util/ConcurrentModificationException;
            //   270: dup            
            //   271: ldc             3
            //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   276: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:()V
            //   279: ldc             1
            //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   284: athrow         
            //   285: athrow         
            //   286: athrow         
            //    Signature:
            //  (Linstrumented/java/util/function/Consumer<-TE;>;)V
            //    StackMapTable: 00 0A 1B FF 00 66 00 07 07 00 02 07 00 4E 00 01 07 00 0A 00 07 00 05 00 01 07 00 2E FF 00 11 00 06 07 00 02 07 00 4E 00 01 07 00 0A 07 00 59 00 00 FA 00 07 FC 00 0A 07 00 59 FF 00 28 00 06 07 00 02 07 00 4E 01 01 07 00 0A 07 00 59 00 00 23 FF 00 16 00 05 07 00 02 07 00 4E 00 00 07 00 0A 00 00 FF 00 11 00 00 00 01 07 00 2E FF 00 00 00 00 00 01 07 00 32
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  67     286    286    287    Ljava/lang/VirtualMachineError;
            //  67     122    130    148    Any
            //  130    140    130    148    Any
            //  0      285    285    286    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0148:
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
        public long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                final long n = this.getFence() - this.index;
                BytecodeManager.incBytecodes(5);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int n = 16464;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
