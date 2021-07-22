// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import java.lang.reflect.Field;
import instrumented.java.util.Spliterator;
import instrumented.java.util.Map;
import java.util.Iterator;
import instrumented.java.util.SortedMap;
import instrumented.java.util.SortedSet;
import instrumented.java.util.Collection;
import instrumented.java.util.Comparator;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;
import java.io.Serializable;
import instrumented.java.util.NavigableSet;
import instrumented.java.util.AbstractSet;

public class ConcurrentSkipListSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable
{
    private static final long serialVersionUID = -2479143111061671589L;
    private final ConcurrentNavigableMap<E, Object> m;
    private static final Unsafe UNSAFE;
    private static final long mapOffset;
    
    public ConcurrentSkipListSet() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.m = new ConcurrentSkipListMap<E, Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListSet(final Comparator<? super E> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            this.m = new ConcurrentSkipListMap<E, Object>(comparator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListSet(final Collection<? extends E> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.m = new ConcurrentSkipListMap<E, Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.addAll(collection);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListSet(final SortedSet<E> set) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(5);
            final Comparator<? super E> comparator = set.comparator();
            BytecodeManager.incBytecodes(1);
            this.m = new ConcurrentSkipListMap<E, Object>((Comparator<? super Object>)comparator);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            this.addAll((Collection<? extends E>)set);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    ConcurrentSkipListSet(final ConcurrentNavigableMap<E, Object> m) {
        try {
            BytecodeManager.incBytecodes(2);
            this.m = m;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ConcurrentSkipListSet<E> clone() {
        try {
            try {
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final ConcurrentSkipListSet set = (ConcurrentSkipListSet)super.clone();
                BytecodeManager.incBytecodes(2);
                final ConcurrentSkipListSet set2 = set;
                final ConcurrentNavigableMap<E, Object> m = this.m;
                BytecodeManager.incBytecodes(6);
                final ConcurrentSkipListMap map = new ConcurrentSkipListMap((SortedMap<Object, ?>)m);
                BytecodeManager.incBytecodes(1);
                set2.setMap(map);
                final ConcurrentSkipListSet<E> set3 = set;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                return set3;
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
    public int size() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final int size = m.size();
            BytecodeManager.incBytecodes(1);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final boolean empty = m.isEmpty();
            BytecodeManager.incBytecodes(1);
            return empty;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final boolean containsKey = m.containsKey(o);
            BytecodeManager.incBytecodes(1);
            return containsKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean add(final E e) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            final Boolean true = Boolean.TRUE;
            BytecodeManager.incBytecodes(5);
            final Boolean putIfAbsent = m.putIfAbsent(e, true);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (putIfAbsent == null) {
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
            final ConcurrentNavigableMap<E, Object> m = this.m;
            final Boolean true = Boolean.TRUE;
            BytecodeManager.incBytecodes(5);
            final boolean remove = m.remove(o, true);
            BytecodeManager.incBytecodes(1);
            return remove;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            m.clear();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final NavigableSet<E> navigableKeySet = m.navigableKeySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = navigableKeySet.iterator();
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Iterator<E> descendingIterator() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final NavigableSet<E> descendingKeySet = m.descendingKeySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<E> iterator = descendingKeySet.iterator();
            BytecodeManager.incBytecodes(1);
            return iterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean equals(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: if_acmpne       17
        //    10: iconst_1       
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: ireturn        
        //    17: aload_1        
        //    18: instanceof      Linstrumented/java/util/Set;
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: ifne            36
        //    29: iconst_0       
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ireturn        
        //    36: aload_1        
        //    37: checkcast       Linstrumented/java/util/Collection;
        //    40: astore_2       
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: aload_0        
        //    47: aload_2        
        //    48: ldc             3
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: invokevirtual   instrumented/java/util/concurrent/ConcurrentSkipListSet.containsAll:(Linstrumented/java/util/Collection;)Z
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: ifeq            93
        //    64: aload_2        
        //    65: aload_0        
        //    66: ldc             3
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: invokeinterface instrumented/java/util/Collection.containsAll:(Linstrumented/java/util/Collection;)Z
        //    76: ldc             1
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifeq            93
        //    84: iconst_1       
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: goto            99
        //    93: iconst_0       
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: ldc             1
        //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   104: ireturn        
        //   105: astore_3       
        //   106: ldc             501
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: iconst_0       
        //   112: ldc             2
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: ireturn        
        //   118: astore_3       
        //   119: ldc             501
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: iconst_0       
        //   125: ldc             2
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: ireturn        
        //   131: athrow         
        //   132: athrow         
        //    StackMapTable: 00 08 11 12 FC 00 38 07 00 93 45 01 45 07 00 8D 4C 07 00 8F FF 00 0C 00 00 00 01 07 00 35 FF 00 00 00 00 00 01 07 00 4B
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  46     132    132    133    Ljava/lang/VirtualMachineError;
        //  46     99     105    118    Ljava/lang/ClassCastException;
        //  46     99     118    131    Ljava/lang/NullPointerException;
        //  0      131    131    132    Any
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
    public boolean removeAll(final Collection<?> collection) {
        try {
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<?> iterator = collection.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<?> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<?> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Object next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final Object o = next;
                BytecodeManager.incBytecodes(3);
                final boolean remove = this.remove(o);
                BytecodeManager.incBytecodes(1);
                if (remove) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
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
    public E lower(final E e) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final E lowerKey = m.lowerKey(e);
            BytecodeManager.incBytecodes(1);
            return lowerKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E floor(final E e) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final E floorKey = m.floorKey(e);
            BytecodeManager.incBytecodes(1);
            return floorKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E ceiling(final E e) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final E ceilingKey = m.ceilingKey(e);
            BytecodeManager.incBytecodes(1);
            return ceilingKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E higher(final E e) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(4);
            final E higherKey = m.higherKey(e);
            BytecodeManager.incBytecodes(1);
            return higherKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollFirst() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Map.Entry<Object, V> pollFirstEntry = m.pollFirstEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<Object, V> entry = pollFirstEntry;
            BytecodeManager.incBytecodes(2);
            Object key;
            if (entry == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Map.Entry<Object, V> entry2 = pollFirstEntry;
                BytecodeManager.incBytecodes(2);
                key = entry2.getKey();
            }
            BytecodeManager.incBytecodes(1);
            return (E)key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E pollLast() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Map.Entry<Object, V> pollLastEntry = m.pollLastEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<Object, V> entry = pollLastEntry;
            BytecodeManager.incBytecodes(2);
            Object key;
            if (entry == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Map.Entry<Object, V> entry2 = pollLastEntry;
                BytecodeManager.incBytecodes(2);
                key = entry2.getKey();
            }
            BytecodeManager.incBytecodes(1);
            return (E)key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Comparator<? super E> comparator() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final Comparator<? super Object> comparator = m.comparator();
            BytecodeManager.incBytecodes(1);
            return comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E first() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final E firstKey = m.firstKey();
            BytecodeManager.incBytecodes(1);
            return firstKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public E last() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(3);
            final E lastKey = m.lastKey();
            BytecodeManager.incBytecodes(1);
            return lastKey;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(8);
            BytecodeManager.incBytecodes(1);
            final ConcurrentNavigableMap<E, Object> subMap = m.subMap(e, b, e2, b2);
            BytecodeManager.incBytecodes(1);
            final ConcurrentSkipListSet set = new ConcurrentSkipListSet((ConcurrentNavigableMap<Object, Object>)subMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> headSet(final E e, final boolean b) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(7);
            final ConcurrentNavigableMap<E, Object> headMap = m.headMap(e, b);
            BytecodeManager.incBytecodes(1);
            final ConcurrentSkipListSet set = new ConcurrentSkipListSet((ConcurrentNavigableMap<Object, Object>)headMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> tailSet(final E e, final boolean b) {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(7);
            final ConcurrentNavigableMap<E, Object> tailMap = m.tailMap(e, b);
            BytecodeManager.incBytecodes(1);
            final ConcurrentSkipListSet set = new ConcurrentSkipListSet((ConcurrentNavigableMap<Object, Object>)tailMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> subSet(final E e, final E e2) {
        try {
            final boolean b = true;
            final boolean b2 = false;
            BytecodeManager.incBytecodes(6);
            final NavigableSet<E> subSet = this.subSet(e, b, e2, b2);
            BytecodeManager.incBytecodes(1);
            return subSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> headSet(final E e) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final NavigableSet<E> headSet = this.headSet(e, b);
            BytecodeManager.incBytecodes(1);
            return headSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> tailSet(final E e) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final NavigableSet<E> tailSet = this.tailSet(e, b);
            BytecodeManager.incBytecodes(1);
            return tailSet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<E> descendingSet() {
        try {
            final ConcurrentNavigableMap<E, Object> m = this.m;
            BytecodeManager.incBytecodes(5);
            final ConcurrentNavigableMap<E, Object> descendingMap = m.descendingMap();
            BytecodeManager.incBytecodes(1);
            final ConcurrentSkipListSet set = new ConcurrentSkipListSet((ConcurrentNavigableMap<Object, Object>)descendingMap);
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Spliterator<E> spliterator() {
        try {
            final boolean b = this.m instanceof ConcurrentSkipListMap;
            BytecodeManager.incBytecodes(4);
            if (b) {
                final ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap)this.m;
                BytecodeManager.incBytecodes(4);
                final ConcurrentSkipListMap.KeySpliterator<E, ?> keySpliterator = concurrentSkipListMap.keySpliterator();
                BytecodeManager.incBytecodes(1);
                return keySpliterator;
            }
            final ConcurrentSkipListMap.SubMap subMap = (ConcurrentSkipListMap.SubMap)this.m;
            BytecodeManager.incBytecodes(4);
            final Spliterator spliterator = (Spliterator)subMap.keyIterator();
            BytecodeManager.incBytecodes(2);
            return (Spliterator<E>)spliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void setMap(final ConcurrentNavigableMap<E, Object> x) {
        try {
            final Unsafe unsafe = ConcurrentSkipListSet.UNSAFE;
            final long mapOffset = ConcurrentSkipListSet.mapOffset;
            BytecodeManager.incBytecodes(5);
            unsafe.putObjectVolatile(this, mapOffset, x);
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
                    final Class<ConcurrentSkipListSet> clazz = ConcurrentSkipListSet.class;
                    BytecodeManager.incBytecodes(2);
                    final Unsafe unsafe = ConcurrentSkipListSet.UNSAFE;
                    final Class<ConcurrentSkipListSet> clazz2 = clazz;
                    final String name = "m";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz2.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    mapOffset = unsafe.objectFieldOffset(declaredField);
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
}
