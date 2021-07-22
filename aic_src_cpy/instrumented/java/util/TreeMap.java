// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.lang.invoke.SerializedLambda;
import instrumented.java.util.function.Consumer;
import java.io.ObjectOutputStream;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.io.Serializable;

public class TreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable
{
    private final Comparator<? super K> comparator;
    private transient Entry<K, V> root;
    private transient int size;
    private transient int modCount;
    private transient EntrySet entrySet;
    private transient KeySet<K> navigableKeySet;
    private transient NavigableMap<K, V> descendingMap;
    private static final Object UNBOUNDED;
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private static final long serialVersionUID = 919286545866124006L;
    
    public TreeMap() {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            this.comparator = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TreeMap(final Comparator<? super K> comparator) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            this.comparator = comparator;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TreeMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.modCount = 0;
            BytecodeManager.incBytecodes(3);
            this.comparator = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public TreeMap(final SortedMap<K, ? extends V> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokespecial   instrumented/java/util/AbstractMap.<init>:()V
        //     9: aload_0        
        //    10: iconst_0       
        //    11: putfield        instrumented/java/util/TreeMap.size:I
        //    14: ldc             3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: aload_0        
        //    20: iconst_0       
        //    21: putfield        instrumented/java/util/TreeMap.modCount:I
        //    24: ldc             3
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: aload_0        
        //    30: aload_1        
        //    31: ldc             3
        //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    36: invokeinterface instrumented/java/util/SortedMap.comparator:()Linstrumented/java/util/Comparator;
        //    41: putfield        instrumented/java/util/TreeMap.comparator:Linstrumented/java/util/Comparator;
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: aload_0        
        //    50: aload_1        
        //    51: ldc             3
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokeinterface instrumented/java/util/SortedMap.size:()I
        //    61: aload_1        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokeinterface instrumented/java/util/SortedMap.entrySet:()Linstrumented/java/util/Set;
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //    82: aconst_null    
        //    83: aconst_null    
        //    84: ldc             3
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: invokespecial   instrumented/java/util/TreeMap.buildFromSorted:(ILjava/util/Iterator;Ljava/io/ObjectInputStream;Ljava/lang/Object;)V
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: goto            120
        //   100: astore_2       
        //   101: ldc             501
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: goto            120
        //   114: astore_2       
        //   115: ldc             501
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: return         
        //   126: athrow         
        //   127: athrow         
        //    Signature:
        //  (Linstrumented/java/util/SortedMap<TK;+TV;>;)V
        //    StackMapTable: 00 05 FF 00 64 00 02 07 00 02 07 00 88 00 01 07 00 84 4D 07 00 86 05 FF 00 05 00 00 00 01 07 00 7A FF 00 00 00 00 00 01 07 00 82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  49     127    127    128    Ljava/lang/VirtualMachineError;
        //  49     92     100    114    Ljava/io/IOException;
        //  49     92     114    120    Ljava/lang/ClassNotFoundException;
        //  0      126    126    127    Any
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
    public boolean containsKey(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = this.getEntry(o);
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (entry != null) {
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
    public boolean containsValue(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            Entry<Object, Object> entry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Entry<Object, Object> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final Object value = entry.value;
                BytecodeManager.incBytecodes(4);
                final boolean valEquals = valEquals(o, value);
                BytecodeManager.incBytecodes(1);
                if (valEquals) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Entry<Object, Object> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                entry = successor(entry3);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = this.getEntry(o);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            V value;
            if (entry2 == null) {
                value = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                value = entry.value;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Comparator<? super K> comparator() {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            return comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K firstKey() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> firstEntry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            final K key = key(firstEntry);
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K lastKey() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> lastEntry = this.getLastEntry();
            BytecodeManager.incBytecodes(1);
            final K key = key(lastEntry);
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface instrumented/java/util/Map.size:()I
        //    11: istore_2       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_0        
        //    18: getfield        instrumented/java/util/TreeMap.size:I
        //    21: ldc             3
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: ifne            199
        //    29: iload_2        
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: ifeq            199
        //    38: aload_1        
        //    39: instanceof      Linstrumented/java/util/SortedMap;
        //    42: ldc             3
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: ifeq            199
        //    50: aload_1        
        //    51: checkcast       Linstrumented/java/util/SortedMap;
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokeinterface instrumented/java/util/SortedMap.comparator:()Linstrumented/java/util/Comparator;
        //    64: astore_3       
        //    65: ldc             1
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: aload_3        
        //    71: aload_0        
        //    72: getfield        instrumented/java/util/TreeMap.comparator:Linstrumented/java/util/Comparator;
        //    75: ldc             4
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: if_acmpeq       115
        //    83: aload_3        
        //    84: ldc             2
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ifnull          199
        //    92: aload_3        
        //    93: aload_0        
        //    94: getfield        instrumented/java/util/TreeMap.comparator:Linstrumented/java/util/Comparator;
        //    97: ldc             4
        //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   102: invokeinterface instrumented/java/util/Comparator.equals:(Ljava/lang/Object;)Z
        //   107: ldc             1
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: ifeq            199
        //   115: aload_0        
        //   116: dup            
        //   117: getfield        instrumented/java/util/TreeMap.modCount:I
        //   120: iconst_1       
        //   121: iadd           
        //   122: putfield        instrumented/java/util/TreeMap.modCount:I
        //   125: ldc             6
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: aload_0        
        //   131: iload_2        
        //   132: aload_1        
        //   133: ldc             4
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //   143: ldc             1
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //   153: aconst_null    
        //   154: aconst_null    
        //   155: ldc             3
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: invokespecial   instrumented/java/util/TreeMap.buildFromSorted:(ILjava/util/Iterator;Ljava/io/ObjectInputStream;Ljava/lang/Object;)V
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: goto            193
        //   171: astore          4
        //   173: ldc             501
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: ldc             1
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: goto            193
        //   186: astore          4
        //   188: ldc             501
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: return         
        //   199: aload_0        
        //   200: aload_1        
        //   201: ldc             3
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokespecial   instrumented/java/util/AbstractMap.putAll:(Linstrumented/java/util/Map;)V
        //   209: ldc             1
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: return         
        //   215: athrow         
        //   216: athrow         
        //    Signature:
        //  (Linstrumented/java/util/Map<+TK;+TV;>;)V
        //    StackMapTable: 00 07 FD 00 73 01 07 00 C4 77 07 00 84 4E 07 00 86 06 FA 00 05 FF 00 0F 00 00 00 01 07 00 7A FF 00 00 00 00 00 01 07 00 82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  130    216    216    217    Ljava/lang/VirtualMachineError;
        //  130    163    171    186    Ljava/io/IOException;
        //  130    163    186    193    Ljava/lang/ClassNotFoundException;
        //  0      215    215    216    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0193:
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
    
    final Entry<K, V> getEntry(final Object o) {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            if (comparator != null) {
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entryUsingComparator = this.getEntryUsingComparator(o);
                BytecodeManager.incBytecodes(1);
                return entryUsingComparator;
            }
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Comparable comparable = (Comparable)o;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Entry<K, V> entry3 = null;
                    BytecodeManager.incBytecodes(2);
                    return entry3;
                }
                final Comparable<K> comparable2 = (Comparable<K>)comparable;
                final K key = entry.key;
                BytecodeManager.incBytecodes(4);
                final int compareTo = comparable2.compareTo(key);
                BytecodeManager.incBytecodes(1);
                final int n = compareTo;
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final int n2 = compareTo;
                    BytecodeManager.incBytecodes(2);
                    if (n2 <= 0) {
                        final Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry4;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getEntryUsingComparator(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            final Comparator<? super K> comparator2 = comparator;
            BytecodeManager.incBytecodes(2);
            if (comparator2 != null) {
                Entry<K, V> entry = this.root;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break;
                    }
                    final Comparator<? super K> comparator3 = comparator;
                    final K key = entry.key;
                    BytecodeManager.incBytecodes(5);
                    final int compare = comparator3.compare(o, key);
                    BytecodeManager.incBytecodes(1);
                    final int n = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n < 0) {
                        entry = entry.left;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final int n2 = compare;
                        BytecodeManager.incBytecodes(2);
                        if (n2 <= 0) {
                            final Entry<K, V> entry3 = entry;
                            BytecodeManager.incBytecodes(2);
                            return entry3;
                        }
                        entry = entry.right;
                        BytecodeManager.incBytecodes(4);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Entry<K, V> entry4 = null;
            BytecodeManager.incBytecodes(2);
            return entry4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getCeilingEntry(final K k) {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Entry<K, V> entry3 = null;
                    BytecodeManager.incBytecodes(2);
                    return entry3;
                }
                final K key = entry.key;
                BytecodeManager.incBytecodes(5);
                final int compare = this.compare(k, key);
                BytecodeManager.incBytecodes(1);
                final int n = compare;
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    final Entry<K, V> left = entry.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        final Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry4;
                    }
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final int n2 = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n2 <= 0) {
                        final Entry<K, V> entry5 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry5;
                    }
                    final Entry<K, V> right = entry.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        Entry<K, V> entry6 = entry.parent;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry7 = entry;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final Entry<K, V> entry8 = entry6;
                            BytecodeManager.incBytecodes(2);
                            if (entry8 == null) {
                                break;
                            }
                            final Entry<K, V> entry9 = entry7;
                            final Entry<K, V> right2 = entry6.right;
                            BytecodeManager.incBytecodes(4);
                            if (entry9 != right2) {
                                break;
                            }
                            entry7 = entry6;
                            BytecodeManager.incBytecodes(2);
                            entry6 = entry6.parent;
                            BytecodeManager.incBytecodes(4);
                        }
                        final Entry<K, V> entry10 = entry6;
                        BytecodeManager.incBytecodes(2);
                        return entry10;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getFloorEntry(final K k) {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Entry<K, V> entry3 = null;
                    BytecodeManager.incBytecodes(2);
                    return entry3;
                }
                final K key = entry.key;
                BytecodeManager.incBytecodes(5);
                final int compare = this.compare(k, key);
                BytecodeManager.incBytecodes(1);
                final int n = compare;
                BytecodeManager.incBytecodes(2);
                if (n > 0) {
                    final Entry<K, V> right = entry.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        final Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry4;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final int n2 = compare;
                    BytecodeManager.incBytecodes(2);
                    if (n2 >= 0) {
                        final Entry<K, V> entry5 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry5;
                    }
                    final Entry<K, V> left = entry.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        Entry<K, V> entry6 = entry.parent;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry7 = entry;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final Entry<K, V> entry8 = entry6;
                            BytecodeManager.incBytecodes(2);
                            if (entry8 == null) {
                                break;
                            }
                            final Entry<K, V> entry9 = entry7;
                            final Entry<K, V> left2 = entry6.left;
                            BytecodeManager.incBytecodes(4);
                            if (entry9 != left2) {
                                break;
                            }
                            entry7 = entry6;
                            BytecodeManager.incBytecodes(2);
                            entry6 = entry6.parent;
                            BytecodeManager.incBytecodes(4);
                        }
                        final Entry<K, V> entry10 = entry6;
                        BytecodeManager.incBytecodes(2);
                        return entry10;
                    }
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getHigherEntry(final K k) {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Entry<K, V> entry3 = null;
                    BytecodeManager.incBytecodes(2);
                    return entry3;
                }
                final K key = entry.key;
                BytecodeManager.incBytecodes(5);
                final int compare = this.compare(k, key);
                BytecodeManager.incBytecodes(1);
                final int n = compare;
                BytecodeManager.incBytecodes(2);
                if (n < 0) {
                    final Entry<K, V> left = entry.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        final Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry4;
                    }
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Entry<K, V> right = entry.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        Entry<K, V> entry5 = entry.parent;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry6 = entry;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final Entry<K, V> entry7 = entry5;
                            BytecodeManager.incBytecodes(2);
                            if (entry7 == null) {
                                break;
                            }
                            final Entry<K, V> entry8 = entry6;
                            final Entry<K, V> right2 = entry5.right;
                            BytecodeManager.incBytecodes(4);
                            if (entry8 != right2) {
                                break;
                            }
                            entry6 = entry5;
                            BytecodeManager.incBytecodes(2);
                            entry5 = entry5.parent;
                            BytecodeManager.incBytecodes(4);
                        }
                        final Entry<K, V> entry9 = entry5;
                        BytecodeManager.incBytecodes(2);
                        return entry9;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getLowerEntry(final K k) {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    final Entry<K, V> entry3 = null;
                    BytecodeManager.incBytecodes(2);
                    return entry3;
                }
                final K key = entry.key;
                BytecodeManager.incBytecodes(5);
                final int compare = this.compare(k, key);
                BytecodeManager.incBytecodes(1);
                final int n = compare;
                BytecodeManager.incBytecodes(2);
                if (n > 0) {
                    final Entry<K, V> right = entry.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        final Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(2);
                        return entry4;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Entry<K, V> left = entry.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        Entry<K, V> entry5 = entry.parent;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry6 = entry;
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final Entry<K, V> entry7 = entry5;
                            BytecodeManager.incBytecodes(2);
                            if (entry7 == null) {
                                break;
                            }
                            final Entry<K, V> entry8 = entry6;
                            final Entry<K, V> left2 = entry5.left;
                            BytecodeManager.incBytecodes(4);
                            if (entry8 != left2) {
                                break;
                            }
                            entry6 = entry5;
                            BytecodeManager.incBytecodes(2);
                            entry5 = entry5.parent;
                            BytecodeManager.incBytecodes(4);
                        }
                        final Entry<K, V> entry9 = entry5;
                        BytecodeManager.incBytecodes(2);
                        return entry9;
                    }
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V put(final K k, final V v) {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 == null) {
                BytecodeManager.incBytecodes(4);
                this.compare(k, k);
                BytecodeManager.incBytecodes(1);
                final Entry<Object, Object> entry3 = null;
                BytecodeManager.incBytecodes(7);
                this.root = new Entry<K, V>(k, v, entry3);
                BytecodeManager.incBytecodes(1);
                this.size = 1;
                BytecodeManager.incBytecodes(3);
                ++this.modCount;
                BytecodeManager.incBytecodes(6);
                final V v2 = null;
                BytecodeManager.incBytecodes(2);
                return v2;
            }
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            final Comparator<? super K> comparator2 = comparator;
            BytecodeManager.incBytecodes(2);
            Entry<K, V> entry5;
            int n;
            if (comparator2 != null) {
                Entry<K, V> entry4;
                do {
                    entry5 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Comparator<K> comparator3 = (Comparator<K>)comparator;
                    final K key = entry.key;
                    BytecodeManager.incBytecodes(5);
                    n = comparator3.compare(k, key);
                    BytecodeManager.incBytecodes(1);
                    final int n2 = n;
                    BytecodeManager.incBytecodes(2);
                    if (n2 < 0) {
                        entry = entry.left;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final int n3 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n3 <= 0) {
                            final Entry<K, V> entry6 = entry;
                            BytecodeManager.incBytecodes(3);
                            final V setValue = entry6.setValue(v);
                            BytecodeManager.incBytecodes(1);
                            return setValue;
                        }
                        entry = entry.right;
                        BytecodeManager.incBytecodes(4);
                    }
                    entry4 = entry;
                    BytecodeManager.incBytecodes(2);
                } while (entry4 != null);
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                if (k == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Comparable comparable = (Comparable)k;
                BytecodeManager.incBytecodes(3);
                Entry<K, V> entry7;
                do {
                    entry5 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Comparable<K> comparable2 = (Comparable<K>)comparable;
                    final K key2 = entry.key;
                    BytecodeManager.incBytecodes(4);
                    n = comparable2.compareTo(key2);
                    BytecodeManager.incBytecodes(1);
                    final int n4 = n;
                    BytecodeManager.incBytecodes(2);
                    if (n4 < 0) {
                        entry = entry.left;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final int n5 = n;
                        BytecodeManager.incBytecodes(2);
                        if (n5 <= 0) {
                            final Entry<K, V> entry8 = entry;
                            BytecodeManager.incBytecodes(3);
                            final V setValue2 = entry8.setValue(v);
                            BytecodeManager.incBytecodes(1);
                            return setValue2;
                        }
                        entry = entry.right;
                        BytecodeManager.incBytecodes(4);
                    }
                    entry7 = entry;
                    BytecodeManager.incBytecodes(2);
                } while (entry7 != null);
            }
            final Entry<K, V> entry9 = entry5;
            BytecodeManager.incBytecodes(6);
            final Entry entry10 = new Entry<K, V>((K)k, (V)v, (Entry<K, V>)entry9);
            BytecodeManager.incBytecodes(1);
            final int n6 = n;
            BytecodeManager.incBytecodes(2);
            if (n6 < 0) {
                entry5.left = (Entry<K, V>)entry10;
                BytecodeManager.incBytecodes(4);
            }
            else {
                entry5.right = (Entry<K, V>)entry10;
                BytecodeManager.incBytecodes(3);
            }
            final Entry entry11 = entry10;
            BytecodeManager.incBytecodes(3);
            this.fixAfterInsertion(entry11);
            ++this.size;
            BytecodeManager.incBytecodes(6);
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final V v3 = null;
            BytecodeManager.incBytecodes(2);
            return v3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = this.getEntry(o);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 == null) {
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final V value = entry.value;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry3 = entry;
            BytecodeManager.incBytecodes(3);
            this.deleteEntry(entry3);
            final V v2 = value;
            BytecodeManager.incBytecodes(2);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            this.root = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Object clone() {
        try {
            try {
                TreeMap treeMap;
                try {
                    BytecodeManager.incBytecodes(2);
                    treeMap = (TreeMap)super.clone();
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                catch (CloneNotSupportedException ex) {
                    BytecodeManager.incBytecodes(501);
                    final CloneNotSupportedException cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final InternalError internalError = new InternalError(cause);
                    BytecodeManager.incBytecodes(1);
                    throw internalError;
                }
                treeMap.root = null;
                BytecodeManager.incBytecodes(3);
                treeMap.size = 0;
                BytecodeManager.incBytecodes(3);
                treeMap.modCount = 0;
                BytecodeManager.incBytecodes(3);
                treeMap.entrySet = null;
                BytecodeManager.incBytecodes(3);
                treeMap.navigableKeySet = null;
                BytecodeManager.incBytecodes(3);
                treeMap.descendingMap = null;
                BytecodeManager.incBytecodes(3);
                try {
                    final TreeMap treeMap2 = treeMap;
                    final int size = this.size;
                    BytecodeManager.incBytecodes(5);
                    final Set<Map.Entry<K, V>> entrySet = this.entrySet();
                    BytecodeManager.incBytecodes(1);
                    final Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
                    final ObjectInputStream objectInputStream = null;
                    final Object o = null;
                    BytecodeManager.incBytecodes(3);
                    treeMap2.buildFromSorted(size, iterator, objectInputStream, o);
                    BytecodeManager.incBytecodes(1);
                }
                catch (IOException ex2) {
                    BytecodeManager.incBytecodes(501);
                    BytecodeManager.incBytecodes(1);
                }
                catch (ClassNotFoundException ex3) {
                    BytecodeManager.incBytecodes(501);
                }
                final TreeMap treeMap3 = treeMap;
                BytecodeManager.incBytecodes(2);
                return treeMap3;
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
    public Map.Entry<K, V> firstEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> firstEntry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry(firstEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> lastEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> lastEntry = this.getLastEntry();
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry(lastEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> pollFirstEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> firstEntry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry = firstEntry;
            BytecodeManager.incBytecodes(2);
            final Map.Entry<K, V> exportEntry = exportEntry(entry);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = firstEntry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                final Entry<K, V> entry3 = firstEntry;
                BytecodeManager.incBytecodes(3);
                this.deleteEntry(entry3);
            }
            final Map.Entry<K, V> entry4 = exportEntry;
            BytecodeManager.incBytecodes(2);
            return entry4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> pollLastEntry() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V> lastEntry = this.getLastEntry();
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry = lastEntry;
            BytecodeManager.incBytecodes(2);
            final Map.Entry<K, V> exportEntry = exportEntry(entry);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = lastEntry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                final Entry<K, V> entry3 = lastEntry;
                BytecodeManager.incBytecodes(3);
                this.deleteEntry(entry3);
            }
            final Map.Entry<K, V> entry4 = exportEntry;
            BytecodeManager.incBytecodes(2);
            return entry4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> lowerEntry(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> lowerEntry = this.getLowerEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry((Entry<K, V>)lowerEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K lowerKey(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> lowerEntry = this.getLowerEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final K keyOrNull = keyOrNull((Entry<K, V>)lowerEntry);
            BytecodeManager.incBytecodes(1);
            return keyOrNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> floorEntry(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> floorEntry = this.getFloorEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry((Entry<K, V>)floorEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K floorKey(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> floorEntry = this.getFloorEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final K keyOrNull = keyOrNull((Entry<K, V>)floorEntry);
            BytecodeManager.incBytecodes(1);
            return keyOrNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> ceilingEntry(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> ceilingEntry = this.getCeilingEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry((Entry<K, V>)ceilingEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K ceilingKey(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> ceilingEntry = this.getCeilingEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final K keyOrNull = keyOrNull((Entry<K, V>)ceilingEntry);
            BytecodeManager.incBytecodes(1);
            return keyOrNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Map.Entry<K, V> higherEntry(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> higherEntry = this.getHigherEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final Map.Entry<K, V> exportEntry = exportEntry((Entry<K, V>)higherEntry);
            BytecodeManager.incBytecodes(1);
            return exportEntry;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public K higherKey(final K k) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> higherEntry = this.getHigherEntry((K)k);
            BytecodeManager.incBytecodes(1);
            final K keyOrNull = keyOrNull((Entry<K, V>)higherEntry);
            BytecodeManager.incBytecodes(1);
            return keyOrNull;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<K> keySet() {
        try {
            BytecodeManager.incBytecodes(2);
            final NavigableSet<K> navigableKeySet = this.navigableKeySet();
            BytecodeManager.incBytecodes(1);
            return navigableKeySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<K> navigableKeySet() {
        try {
            final KeySet<K> navigableKeySet = this.navigableKeySet;
            BytecodeManager.incBytecodes(3);
            final KeySet<K> set = navigableKeySet;
            BytecodeManager.incBytecodes(2);
            KeySet<K> set2;
            if (set != null) {
                set2 = navigableKeySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final KeySet<K> navigableKeySet2 = set2 = new KeySet<K>(this);
                BytecodeManager.incBytecodes(5);
                this.navigableKeySet = navigableKeySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return set2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableSet<K> descendingKeySet() {
        try {
            BytecodeManager.incBytecodes(2);
            final NavigableMap<K, V> descendingMap = this.descendingMap();
            BytecodeManager.incBytecodes(1);
            final NavigableSet<K> navigableKeySet = descendingMap.navigableKeySet();
            BytecodeManager.incBytecodes(1);
            return navigableKeySet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final Collection<V> values = this.values;
            BytecodeManager.incBytecodes(3);
            final Collection<V> collection = values;
            BytecodeManager.incBytecodes(2);
            Collection<V> collection2;
            if (collection != null) {
                collection2 = values;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Values values2 = (Values)(collection2 = new Values());
                BytecodeManager.incBytecodes(5);
                this.values = values2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return collection2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final EntrySet entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            final EntrySet set = entrySet;
            BytecodeManager.incBytecodes(2);
            EntrySet entrySet2 = null;
            if (set != null) {
                BytecodeManager.incBytecodes(2);
            }
            else {
                entrySet2 = new EntrySet();
                BytecodeManager.incBytecodes(5);
                this.entrySet = entrySet2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return entrySet2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableMap<K, V> descendingMap() {
        try {
            final NavigableMap<K, V> descendingMap = this.descendingMap;
            BytecodeManager.incBytecodes(3);
            final NavigableMap<K, V> navigableMap = descendingMap;
            BytecodeManager.incBytecodes(2);
            NavigableMap<K, V> navigableMap2;
            if (navigableMap != null) {
                navigableMap2 = descendingMap;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final boolean b;
                final K k;
                final boolean b2;
                final boolean b3;
                final K i;
                final boolean b4;
                final DescendingSubMap<K, V> descendingMap2 = (DescendingSubMap<K, V>)(navigableMap2 = new DescendingSubMap<K, V>((TreeMap<Object, Object>)this, b, k, b2, b3, i, b4));
                b = true;
                k = null;
                b2 = true;
                b3 = true;
                i = null;
                b4 = true;
                BytecodeManager.incBytecodes(11);
                this.descendingMap = descendingMap2;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return navigableMap2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
        try {
            final boolean b3 = false;
            final boolean b4 = false;
            BytecodeManager.incBytecodes(10);
            final AscendingSubMap ascendingSubMap = new AscendingSubMap<K, V>(this, b3, k, b, b4, i, b2);
            BytecodeManager.incBytecodes(1);
            return (NavigableMap<K, V>)ascendingSubMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableMap<K, V> headMap(final K k, final boolean b) {
        try {
            final boolean b2 = true;
            final K i = null;
            final boolean b3 = true;
            final boolean b4 = false;
            BytecodeManager.incBytecodes(10);
            final AscendingSubMap ascendingSubMap = new AscendingSubMap<K, V>(this, b2, i, b3, b4, k, b);
            BytecodeManager.incBytecodes(1);
            return (NavigableMap<K, V>)ascendingSubMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public NavigableMap<K, V> tailMap(final K k, final boolean b) {
        try {
            final boolean b2 = false;
            final boolean b3 = true;
            final K i = null;
            final boolean b4 = true;
            BytecodeManager.incBytecodes(10);
            final AscendingSubMap ascendingSubMap = new AscendingSubMap<K, V>(this, b2, k, b, b3, i, b4);
            BytecodeManager.incBytecodes(1);
            return (NavigableMap<K, V>)ascendingSubMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public SortedMap<K, V> subMap(final K k, final K i) {
        try {
            final boolean b = true;
            final boolean b2 = false;
            BytecodeManager.incBytecodes(6);
            final NavigableMap<K, V> subMap = this.subMap(k, b, i, b2);
            BytecodeManager.incBytecodes(1);
            return subMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public SortedMap<K, V> headMap(final K k) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            final NavigableMap<K, V> headMap = this.headMap(k, b);
            BytecodeManager.incBytecodes(1);
            return headMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public SortedMap<K, V> tailMap(final K k) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(4);
            final NavigableMap<K, V> tailMap = this.tailMap(k, b);
            BytecodeManager.incBytecodes(1);
            return tailMap;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean replace(final K k, final V v, final V value) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = this.getEntry(k);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                final V value2 = entry.value;
                BytecodeManager.incBytecodes(4);
                final boolean equals = Objects.equals(v, value2);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    entry.value = value;
                    BytecodeManager.incBytecodes(3);
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V replace(final K k, final V value) {
        try {
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = this.getEntry(k);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                final V value2 = entry.value;
                BytecodeManager.incBytecodes(3);
                entry.value = value;
                BytecodeManager.incBytecodes(3);
                final V v = value2;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final V v2 = null;
            BytecodeManager.incBytecodes(2);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            Entry<Object, Object> entry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Entry<Object, Object> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Object key = entry.key;
                final Object value = entry.value;
                BytecodeManager.incBytecodes(6);
                biConsumer.accept((Object)key, (Object)value);
                final int n = modCount;
                final int modCount2 = this.modCount;
                BytecodeManager.incBytecodes(4);
                if (n != modCount2) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Entry<Object, Object> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                entry = successor(entry3);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            Entry<Object, Object> entry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Entry<Object, Object> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                final Entry<Object, Object> entry3 = entry;
                final Object key = entry.key;
                final Object value = entry.value;
                BytecodeManager.incBytecodes(7);
                entry3.value = biFunction.apply((Object)key, (Object)value);
                BytecodeManager.incBytecodes(1);
                final int n = modCount;
                final int modCount2 = this.modCount;
                BytecodeManager.incBytecodes(4);
                if (n != modCount2) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Entry<Object, Object> entry4 = entry;
                BytecodeManager.incBytecodes(2);
                entry = successor(entry4);
                BytecodeManager.incBytecodes(2);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Iterator<K> keyIterator() {
        try {
            BytecodeManager.incBytecodes(5);
            final Entry<K, V> firstEntry = this.getFirstEntry();
            BytecodeManager.incBytecodes(1);
            final KeyIterator keyIterator = new KeyIterator(firstEntry);
            BytecodeManager.incBytecodes(1);
            return keyIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Iterator<K> descendingKeyIterator() {
        try {
            BytecodeManager.incBytecodes(5);
            final Entry<K, V> lastEntry = this.getLastEntry();
            BytecodeManager.incBytecodes(1);
            final DescendingKeyIterator descendingKeyIterator = new DescendingKeyIterator(lastEntry);
            BytecodeManager.incBytecodes(1);
            return descendingKeyIterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final int compare(final Object o, final Object o2) {
        try {
            final Comparator<? super K> comparator = this.comparator;
            BytecodeManager.incBytecodes(3);
            int n;
            if (comparator == null) {
                final Comparable comparable = (Comparable)o;
                BytecodeManager.incBytecodes(4);
                n = comparable.compareTo(o2);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final Comparator<? super K> comparator2 = this.comparator;
                BytecodeManager.incBytecodes(4);
                BytecodeManager.incBytecodes(1);
                n = comparator2.compare(o, o2);
            }
            BytecodeManager.incBytecodes(1);
            return n;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static final boolean valEquals(final Object o, final Object obj) {
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
    
    static <K, V> Map.Entry<K, V> exportEntry(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            Map.Entry<K, V> entry2;
            if (entry == null) {
                entry2 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                entry2 = new SimpleImmutableEntry<K, V>((Map.Entry<? extends K, ? extends V>)entry);
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            return entry2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <K, V> K keyOrNull(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            K key;
            if (entry == null) {
                key = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                key = entry.key;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <K> K key(final Entry<K, ?> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry == null) {
                BytecodeManager.incBytecodes(3);
                final NoSuchElementException ex = new NoSuchElementException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final K key = entry.key;
            BytecodeManager.incBytecodes(3);
            return key;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getFirstEntry() {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                while (true) {
                    final Entry<K, V> left = entry.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        break;
                    }
                    entry = entry.left;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final Entry<K, V> entry3 = entry;
            BytecodeManager.incBytecodes(2);
            return entry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Entry<K, V> getLastEntry() {
        try {
            Entry<K, V> entry = this.root;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            if (entry2 != null) {
                while (true) {
                    final Entry<K, V> right = entry.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        break;
                    }
                    entry = entry.right;
                    BytecodeManager.incBytecodes(4);
                }
            }
            final Entry<K, V> entry3 = entry;
            BytecodeManager.incBytecodes(2);
            return entry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <K, V> Entry<K, V> successor(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry == null) {
                final Entry<K, V> entry2 = null;
                BytecodeManager.incBytecodes(2);
                return entry2;
            }
            final Entry<K, V> right = entry.right;
            BytecodeManager.incBytecodes(3);
            if (right != null) {
                Entry<K, V> entry3 = entry.right;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Entry<K, V> left = entry3.left;
                    BytecodeManager.incBytecodes(3);
                    if (left == null) {
                        break;
                    }
                    entry3 = entry3.left;
                    BytecodeManager.incBytecodes(4);
                }
                final Entry<K, V> entry4 = entry3;
                BytecodeManager.incBytecodes(2);
                return entry4;
            }
            Entry<K, V> entry5 = entry.parent;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry6 = entry;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<K, V> entry7 = entry5;
                BytecodeManager.incBytecodes(2);
                if (entry7 == null) {
                    break;
                }
                final Entry<K, V> entry8 = entry6;
                final Entry<K, V> right2 = entry5.right;
                BytecodeManager.incBytecodes(4);
                if (entry8 != right2) {
                    break;
                }
                entry6 = entry5;
                BytecodeManager.incBytecodes(2);
                entry5 = entry5.parent;
                BytecodeManager.incBytecodes(4);
            }
            final Entry<K, V> entry9 = entry5;
            BytecodeManager.incBytecodes(2);
            return entry9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <K, V> Entry<K, V> predecessor(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry == null) {
                final Entry<K, V> entry2 = null;
                BytecodeManager.incBytecodes(2);
                return entry2;
            }
            final Entry<K, V> left = entry.left;
            BytecodeManager.incBytecodes(3);
            if (left != null) {
                Entry<K, V> entry3 = entry.left;
                BytecodeManager.incBytecodes(3);
                while (true) {
                    final Entry<K, V> right = entry3.right;
                    BytecodeManager.incBytecodes(3);
                    if (right == null) {
                        break;
                    }
                    entry3 = entry3.right;
                    BytecodeManager.incBytecodes(4);
                }
                final Entry<K, V> entry4 = entry3;
                BytecodeManager.incBytecodes(2);
                return entry4;
            }
            Entry<K, V> entry5 = entry.parent;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry6 = entry;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<K, V> entry7 = entry5;
                BytecodeManager.incBytecodes(2);
                if (entry7 == null) {
                    break;
                }
                final Entry<K, V> entry8 = entry6;
                final Entry<K, V> left2 = entry5.left;
                BytecodeManager.incBytecodes(4);
                if (entry8 != left2) {
                    break;
                }
                entry6 = entry5;
                BytecodeManager.incBytecodes(2);
                entry5 = entry5.parent;
                BytecodeManager.incBytecodes(4);
            }
            final Entry<K, V> entry9 = entry5;
            BytecodeManager.incBytecodes(2);
            return entry9;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V> boolean colorOf(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean color;
            if (entry == null) {
                color = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                color = entry.color;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return color;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V> Entry<K, V> parentOf(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            Entry<K, V> parent;
            if (entry == null) {
                parent = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                parent = entry.parent;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return parent;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V> void setColor(final Entry<K, V> entry, final boolean color) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry != null) {
                entry.color = color;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V> Entry<K, V> leftOf(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            Entry<K, V> left;
            if (entry == null) {
                left = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                left = entry.left;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return left;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <K, V> Entry<K, V> rightOf(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            Entry<K, V> right;
            if (entry == null) {
                right = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                right = entry.right;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return right;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rotateLeft(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry != null) {
                final Entry<K, V> right = entry.right;
                BytecodeManager.incBytecodes(3);
                entry.right = right.left;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> left = right.left;
                BytecodeManager.incBytecodes(3);
                if (left != null) {
                    right.left.parent = entry;
                    BytecodeManager.incBytecodes(4);
                }
                right.parent = entry.parent;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> parent = entry.parent;
                BytecodeManager.incBytecodes(3);
                if (parent == null) {
                    this.root = right;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Entry<K, V> left2 = entry.parent.left;
                    BytecodeManager.incBytecodes(5);
                    if (left2 == entry) {
                        entry.parent.left = right;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        entry.parent.right = right;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                right.left = entry;
                BytecodeManager.incBytecodes(3);
                entry.parent = right;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void rotateRight(final Entry<K, V> entry) {
        try {
            BytecodeManager.incBytecodes(2);
            if (entry != null) {
                final Entry<K, V> left = entry.left;
                BytecodeManager.incBytecodes(3);
                entry.left = left.right;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> right = left.right;
                BytecodeManager.incBytecodes(3);
                if (right != null) {
                    left.right.parent = entry;
                    BytecodeManager.incBytecodes(4);
                }
                left.parent = entry.parent;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> parent = entry.parent;
                BytecodeManager.incBytecodes(3);
                if (parent == null) {
                    this.root = left;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Entry<K, V> right2 = entry.parent.right;
                    BytecodeManager.incBytecodes(5);
                    if (right2 == entry) {
                        entry.parent.right = left;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        entry.parent.left = left;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                left.right = entry;
                BytecodeManager.incBytecodes(3);
                entry.parent = left;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void fixAfterInsertion(Entry<K, V> entry) {
        try {
            entry.color = false;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    break;
                }
                final Entry<K, V> entry3 = entry;
                final Entry<K, V> root = this.root;
                BytecodeManager.incBytecodes(4);
                if (entry3 == root) {
                    break;
                }
                final boolean color = entry.parent.color;
                BytecodeManager.incBytecodes(4);
                if (color) {
                    break;
                }
                final Entry<K, V> entry4 = entry;
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> parent = parentOf(entry4);
                final Entry<K, V> entry5 = entry;
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> parent2 = parentOf(entry5);
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> parent3 = parentOf(parent2);
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> left = leftOf(parent3);
                BytecodeManager.incBytecodes(1);
                if (parent == left) {
                    final Entry<K, V> entry6 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> parent4 = parentOf(entry6);
                    BytecodeManager.incBytecodes(1);
                    final Entry<K, V> parent5 = parentOf(parent4);
                    BytecodeManager.incBytecodes(1);
                    final Entry<K, V> right = rightOf((Entry<K, V>)parent5);
                    BytecodeManager.incBytecodes(1);
                    final Entry<Object, Object> entry7 = (Entry<Object, Object>)right;
                    BytecodeManager.incBytecodes(2);
                    final boolean color2 = colorOf(entry7);
                    BytecodeManager.incBytecodes(1);
                    if (!color2) {
                        final Entry<K, V> entry8 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent6 = parentOf(entry8);
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent6, b);
                        final Entry<K, V> entry9 = right;
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(3);
                        setColor(entry9, b2);
                        final Entry<K, V> entry10 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent7 = parentOf(entry10);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent8 = parentOf((Entry<K, V>)parent7);
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)parent8, b3);
                        final Entry<K, V> entry11 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent9 = parentOf(entry11);
                        BytecodeManager.incBytecodes(1);
                        entry = parentOf(parent9);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Entry<K, V> entry12 = entry;
                        final Entry<K, V> entry13 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent10 = parentOf(entry13);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> right2 = rightOf(parent10);
                        BytecodeManager.incBytecodes(1);
                        if (entry12 == right2) {
                            final Entry<K, V> entry14 = entry;
                            BytecodeManager.incBytecodes(2);
                            entry = parentOf(entry14);
                            BytecodeManager.incBytecodes(1);
                            final Entry<K, V> entry15 = entry;
                            BytecodeManager.incBytecodes(3);
                            this.rotateLeft(entry15);
                        }
                        final Entry<K, V> entry16 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent11 = parentOf(entry16);
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent11, b4);
                        final Entry<K, V> entry17 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent12 = parentOf(entry17);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent13 = parentOf((Entry<K, V>)parent12);
                        final boolean b5 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)parent13, b5);
                        final Entry<K, V> entry18 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent14 = parentOf(entry18);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent15 = parentOf(parent14);
                        BytecodeManager.incBytecodes(1);
                        this.rotateRight(parent15);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Entry<K, V> entry19 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> parent16 = parentOf(entry19);
                    BytecodeManager.incBytecodes(1);
                    final Entry<K, V> parent17 = parentOf(parent16);
                    BytecodeManager.incBytecodes(1);
                    final Entry<K, V> left2 = leftOf((Entry<K, V>)parent17);
                    BytecodeManager.incBytecodes(1);
                    final Entry<Object, Object> entry20 = (Entry<Object, Object>)left2;
                    BytecodeManager.incBytecodes(2);
                    final boolean color3 = colorOf(entry20);
                    BytecodeManager.incBytecodes(1);
                    if (!color3) {
                        final Entry<K, V> entry21 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent18 = parentOf(entry21);
                        final boolean b6 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent18, b6);
                        final Entry<K, V> entry22 = left2;
                        final boolean b7 = true;
                        BytecodeManager.incBytecodes(3);
                        setColor(entry22, b7);
                        final Entry<K, V> entry23 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent19 = parentOf(entry23);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent20 = parentOf((Entry<K, V>)parent19);
                        final boolean b8 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)parent20, b8);
                        final Entry<K, V> entry24 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent21 = parentOf(entry24);
                        BytecodeManager.incBytecodes(1);
                        entry = parentOf(parent21);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final Entry<K, V> entry25 = entry;
                        final Entry<K, V> entry26 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent22 = parentOf(entry26);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> left3 = leftOf(parent22);
                        BytecodeManager.incBytecodes(1);
                        if (entry25 == left3) {
                            final Entry<K, V> entry27 = entry;
                            BytecodeManager.incBytecodes(2);
                            entry = parentOf(entry27);
                            BytecodeManager.incBytecodes(1);
                            final Entry<K, V> entry28 = entry;
                            BytecodeManager.incBytecodes(3);
                            this.rotateRight(entry28);
                        }
                        final Entry<K, V> entry29 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent23 = parentOf(entry29);
                        final boolean b9 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent23, b9);
                        final Entry<K, V> entry30 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent24 = parentOf(entry30);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent25 = parentOf((Entry<K, V>)parent24);
                        final boolean b10 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)parent25, b10);
                        final Entry<K, V> entry31 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent26 = parentOf(entry31);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> parent27 = parentOf(parent26);
                        BytecodeManager.incBytecodes(1);
                        this.rotateLeft(parent27);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            this.root.color = true;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void deleteEntry(Entry<K, V> entry) {
        try {
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            --this.size;
            BytecodeManager.incBytecodes(6);
            final Entry<K, V> left = entry.left;
            BytecodeManager.incBytecodes(3);
            if (left != null) {
                final Entry<K, V> right = entry.right;
                BytecodeManager.incBytecodes(3);
                if (right != null) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> successor = successor(entry2);
                    BytecodeManager.incBytecodes(1);
                    entry.key = successor.key;
                    BytecodeManager.incBytecodes(4);
                    entry.value = successor.value;
                    BytecodeManager.incBytecodes(4);
                    entry = successor;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final Entry<K, V> left2 = entry.left;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry3;
            if (left2 != null) {
                entry3 = entry.left;
                BytecodeManager.incBytecodes(3);
            }
            else {
                entry3 = entry.right;
                BytecodeManager.incBytecodes(2);
            }
            final Entry<K, V> right2 = entry3;
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry4 = right2;
            BytecodeManager.incBytecodes(2);
            if (entry4 != null) {
                right2.parent = entry.parent;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> parent = entry.parent;
                BytecodeManager.incBytecodes(3);
                if (parent == null) {
                    this.root = right2;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final Entry<K, V> entry5 = entry;
                    final Entry<K, V> left3 = entry.parent.left;
                    BytecodeManager.incBytecodes(5);
                    if (entry5 == left3) {
                        entry.parent.left = right2;
                        BytecodeManager.incBytecodes(5);
                    }
                    else {
                        entry.parent.right = right2;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final Entry<K, V> entry6 = entry;
                final Entry<K, V> entry7 = entry;
                final Entry<K, V> entry8 = entry;
                final Entry<K, V> left4 = null;
                entry8.parent = (Entry<K, V>)left4;
                entry7.right = (Entry<K, V>)left4;
                entry6.left = (Entry<K, V>)left4;
                BytecodeManager.incBytecodes(9);
                final boolean color = entry.color;
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                if (color == b) {
                    final Entry<K, V> entry9 = right2;
                    BytecodeManager.incBytecodes(3);
                    this.fixAfterDeletion(entry9);
                    BytecodeManager.incBytecodes(1);
                }
            }
            else {
                final Entry<K, V> parent2 = entry.parent;
                BytecodeManager.incBytecodes(3);
                if (parent2 == null) {
                    this.root = null;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final boolean color2 = entry.color;
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(4);
                    if (color2 == b2) {
                        final Entry<K, V> entry10 = entry;
                        BytecodeManager.incBytecodes(3);
                        this.fixAfterDeletion(entry10);
                    }
                    final Entry<K, V> parent3 = entry.parent;
                    BytecodeManager.incBytecodes(3);
                    if (parent3 != null) {
                        final Entry<K, V> entry11 = entry;
                        final Entry<K, V> left5 = entry.parent.left;
                        BytecodeManager.incBytecodes(5);
                        if (entry11 == left5) {
                            entry.parent.left = null;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            final Entry<K, V> entry12 = entry;
                            final Entry<K, V> right3 = entry.parent.right;
                            BytecodeManager.incBytecodes(5);
                            if (entry12 == right3) {
                                entry.parent.right = null;
                                BytecodeManager.incBytecodes(4);
                            }
                        }
                        entry.parent = null;
                        BytecodeManager.incBytecodes(3);
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void fixAfterDeletion(Entry<K, V> entry) {
        try {
            while (true) {
                final Entry<K, V> entry2 = entry;
                final Entry<K, V> root = this.root;
                BytecodeManager.incBytecodes(4);
                if (entry2 == root) {
                    break;
                }
                final Entry<K, V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final boolean color = colorOf(entry3);
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                if (color != b) {
                    break;
                }
                final Entry<K, V> entry4 = entry;
                final Entry<K, V> entry5 = entry;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> parent = parentOf(entry5);
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> left = leftOf(parent);
                BytecodeManager.incBytecodes(1);
                if (entry4 == left) {
                    final Entry<K, V> entry6 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> parent2 = parentOf(entry6);
                    BytecodeManager.incBytecodes(1);
                    Object o = rightOf((Entry<K, V>)parent2);
                    BytecodeManager.incBytecodes(1);
                    final Object o2 = o;
                    BytecodeManager.incBytecodes(2);
                    final boolean color2 = colorOf((Entry<Object, Object>)o2);
                    BytecodeManager.incBytecodes(1);
                    if (!color2) {
                        final Object o3 = o;
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(3);
                        setColor((Entry<Object, Object>)o3, b2);
                        final Entry<K, V> entry7 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent3 = parentOf(entry7);
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent3, b3);
                        final Entry<K, V> entry8 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent4 = parentOf(entry8);
                        BytecodeManager.incBytecodes(1);
                        this.rotateLeft(parent4);
                        final Entry<K, V> entry9 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent5 = parentOf(entry9);
                        BytecodeManager.incBytecodes(1);
                        o = rightOf((Entry<K, V>)parent5);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Object o4 = o;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> left2 = leftOf((Entry<K, V>)o4);
                    BytecodeManager.incBytecodes(1);
                    final boolean color3 = colorOf((Entry<Object, Object>)left2);
                    final boolean b4 = true;
                    BytecodeManager.incBytecodes(2);
                    Label_0428: {
                        if (color3 == b4) {
                            final Object o5 = o;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Entry<K, V> right = rightOf((Entry<K, V>)o5);
                            BytecodeManager.incBytecodes(1);
                            final boolean color4 = colorOf((Entry<Object, Object>)right);
                            final boolean b5 = true;
                            BytecodeManager.incBytecodes(2);
                            if (color4 == b5) {
                                final Entry<K, V> entry10 = (Entry<K, V>)o;
                                final boolean b6 = false;
                                BytecodeManager.incBytecodes(3);
                                setColor((Entry<K, V>)entry10, b6);
                                final Entry<K, V> entry11 = entry;
                                BytecodeManager.incBytecodes(2);
                                entry = parentOf(entry11);
                                BytecodeManager.incBytecodes(2);
                                break Label_0428;
                            }
                        }
                        final Entry<K, V> entry12 = (Entry<K, V>)o;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> right2 = rightOf((Entry<K, V>)entry12);
                        BytecodeManager.incBytecodes(1);
                        final boolean color5 = colorOf((Entry<Object, Object>)right2);
                        final boolean b7 = true;
                        BytecodeManager.incBytecodes(2);
                        if (color5 == b7) {
                            final Entry<K, V> entry13 = (Entry<K, V>)o;
                            BytecodeManager.incBytecodes(2);
                            final Entry<K, V> left3 = leftOf((Entry<K, V>)entry13);
                            final boolean b8 = true;
                            BytecodeManager.incBytecodes(2);
                            setColor((Entry<Object, Object>)left3, b8);
                            final Entry<K, V> entry14 = (Entry<K, V>)o;
                            final boolean b9 = false;
                            BytecodeManager.incBytecodes(3);
                            setColor((Entry<K, V>)entry14, b9);
                            final Entry<K, V> entry15 = (Entry<K, V>)o;
                            BytecodeManager.incBytecodes(3);
                            this.rotateRight((Entry<K, V>)entry15);
                            final Entry<K, V> entry16 = entry;
                            BytecodeManager.incBytecodes(2);
                            final Entry<K, V> parent6 = parentOf(entry16);
                            BytecodeManager.incBytecodes(1);
                            o = rightOf((Entry<K, V>)parent6);
                            BytecodeManager.incBytecodes(1);
                        }
                        final Entry<K, V> entry17 = (Entry<K, V>)o;
                        final Entry<K, V> entry18 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent7 = parentOf(entry18);
                        BytecodeManager.incBytecodes(1);
                        final boolean color6 = colorOf(parent7);
                        BytecodeManager.incBytecodes(1);
                        setColor((Entry<K, V>)entry17, color6);
                        final Entry<K, V> entry19 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent8 = parentOf(entry19);
                        final boolean b10 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent8, b10);
                        final Entry<K, V> entry20 = (Entry<K, V>)o;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> right3 = rightOf((Entry<K, V>)entry20);
                        final boolean b11 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)right3, b11);
                        final Entry<K, V> entry21 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent9 = parentOf(entry21);
                        BytecodeManager.incBytecodes(1);
                        this.rotateLeft(parent9);
                        entry = this.root;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final Entry<K, V> entry22 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> parent10 = parentOf(entry22);
                    BytecodeManager.incBytecodes(1);
                    Object o6 = leftOf((Entry<K, V>)parent10);
                    BytecodeManager.incBytecodes(1);
                    final Object o7 = o6;
                    BytecodeManager.incBytecodes(2);
                    final boolean color7 = colorOf((Entry<Object, Object>)o7);
                    BytecodeManager.incBytecodes(1);
                    if (!color7) {
                        final Object o8 = o6;
                        final boolean b12 = true;
                        BytecodeManager.incBytecodes(3);
                        setColor((Entry<Object, Object>)o8, b12);
                        final Entry<K, V> entry23 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent11 = parentOf(entry23);
                        final boolean b13 = false;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent11, b13);
                        final Entry<K, V> entry24 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent12 = parentOf(entry24);
                        BytecodeManager.incBytecodes(1);
                        this.rotateRight(parent12);
                        final Entry<K, V> entry25 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent13 = parentOf(entry25);
                        BytecodeManager.incBytecodes(1);
                        o6 = leftOf((Entry<K, V>)parent13);
                        BytecodeManager.incBytecodes(1);
                    }
                    final Object o9 = o6;
                    BytecodeManager.incBytecodes(2);
                    final Entry<K, V> right4 = rightOf((Entry<K, V>)o9);
                    BytecodeManager.incBytecodes(1);
                    final boolean color8 = colorOf((Entry<Object, Object>)right4);
                    final boolean b14 = true;
                    BytecodeManager.incBytecodes(2);
                    Label_0807: {
                        if (color8 == b14) {
                            final Object o10 = o6;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final Entry<K, V> left4 = leftOf((Entry<K, V>)o10);
                            BytecodeManager.incBytecodes(1);
                            final boolean color9 = colorOf((Entry<Object, Object>)left4);
                            final boolean b15 = true;
                            BytecodeManager.incBytecodes(2);
                            if (color9 == b15) {
                                final Entry<K, V> entry26 = (Entry<K, V>)o6;
                                final boolean b16 = false;
                                BytecodeManager.incBytecodes(3);
                                setColor((Entry<K, V>)entry26, b16);
                                final Entry<K, V> entry27 = entry;
                                BytecodeManager.incBytecodes(2);
                                entry = parentOf(entry27);
                                BytecodeManager.incBytecodes(2);
                                break Label_0807;
                            }
                        }
                        final Entry<K, V> entry28 = (Entry<K, V>)o6;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> left5 = leftOf((Entry<K, V>)entry28);
                        BytecodeManager.incBytecodes(1);
                        final boolean color10 = colorOf((Entry<Object, Object>)left5);
                        final boolean b17 = true;
                        BytecodeManager.incBytecodes(2);
                        if (color10 == b17) {
                            final Entry<K, V> entry29 = (Entry<K, V>)o6;
                            BytecodeManager.incBytecodes(2);
                            final Entry<K, V> right5 = rightOf((Entry<K, V>)entry29);
                            final boolean b18 = true;
                            BytecodeManager.incBytecodes(2);
                            setColor((Entry<Object, Object>)right5, b18);
                            final Entry<K, V> entry30 = (Entry<K, V>)o6;
                            final boolean b19 = false;
                            BytecodeManager.incBytecodes(3);
                            setColor((Entry<K, V>)entry30, b19);
                            final Entry<K, V> entry31 = (Entry<K, V>)o6;
                            BytecodeManager.incBytecodes(3);
                            this.rotateLeft((Entry<K, V>)entry31);
                            final Entry<K, V> entry32 = entry;
                            BytecodeManager.incBytecodes(2);
                            final Entry<K, V> parent14 = parentOf(entry32);
                            BytecodeManager.incBytecodes(1);
                            o6 = leftOf((Entry<K, V>)parent14);
                            BytecodeManager.incBytecodes(1);
                        }
                        final Entry<K, V> entry33 = (Entry<K, V>)o6;
                        final Entry<K, V> entry34 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent15 = parentOf(entry34);
                        BytecodeManager.incBytecodes(1);
                        final boolean color11 = colorOf(parent15);
                        BytecodeManager.incBytecodes(1);
                        setColor((Entry<K, V>)entry33, color11);
                        final Entry<K, V> entry35 = entry;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> parent16 = parentOf(entry35);
                        final boolean b20 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor(parent16, b20);
                        final Entry<K, V> entry36 = (Entry<K, V>)o6;
                        BytecodeManager.incBytecodes(2);
                        final Entry<K, V> left6 = leftOf((Entry<K, V>)entry36);
                        final boolean b21 = true;
                        BytecodeManager.incBytecodes(2);
                        setColor((Entry<Object, Object>)left6, b21);
                        final Entry<K, V> entry37 = entry;
                        BytecodeManager.incBytecodes(3);
                        final Entry<K, V> parent17 = parentOf(entry37);
                        BytecodeManager.incBytecodes(1);
                        this.rotateRight(parent17);
                        entry = this.root;
                        BytecodeManager.incBytecodes(3);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            final Entry<K, V> entry38 = entry;
            final boolean b22 = true;
            BytecodeManager.incBytecodes(3);
            setColor(entry38, b22);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            BytecodeManager.incBytecodes(2);
            objectOutputStream.defaultWriteObject();
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            objectOutputStream.writeInt(size);
            BytecodeManager.incBytecodes(2);
            final Set<Map.Entry<K, V>> entrySet = this.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Map.Entry<K, V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Map.Entry<K, V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(3);
                final K key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                objectOutputStream.writeObject(key);
                final Map.Entry<K, V> entry3 = entry;
                BytecodeManager.incBytecodes(3);
                final V value = entry3.getValue();
                BytecodeManager.incBytecodes(1);
                objectOutputStream.writeObject(value);
                BytecodeManager.incBytecodes(1);
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
            final int int1 = objectInputStream.readInt();
            BytecodeManager.incBytecodes(1);
            final int n = int1;
            final Iterator<?> iterator = null;
            final V v = null;
            BytecodeManager.incBytecodes(6);
            this.buildFromSorted(n, iterator, objectInputStream, v);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void readTreeSet(final int n, final ObjectInputStream objectInputStream, final V v) throws IOException, ClassNotFoundException {
        try {
            final Iterator<?> iterator = null;
            BytecodeManager.incBytecodes(6);
            this.buildFromSorted(n, iterator, objectInputStream, v);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void addAllForTreeSet(final SortedSet<? extends K> set, final V v) {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(3);
                    final int size = set.size();
                    BytecodeManager.incBytecodes(2);
                    final Iterator<?> iterator = set.iterator();
                    final ObjectInputStream objectInputStream = null;
                    BytecodeManager.incBytecodes(3);
                    this.buildFromSorted(size, iterator, objectInputStream, v);
                    BytecodeManager.incBytecodes(1);
                }
                catch (IOException ex) {
                    BytecodeManager.incBytecodes(501);
                    BytecodeManager.incBytecodes(1);
                }
                catch (ClassNotFoundException ex2) {
                    BytecodeManager.incBytecodes(501);
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
    
    private void buildFromSorted(final int size, final Iterator<?> iterator, final ObjectInputStream objectInputStream, final V v) throws IOException, ClassNotFoundException {
        try {
            this.size = size;
            BytecodeManager.incBytecodes(3);
            final int n = 0;
            final int n2 = 0;
            final int n3 = size - 1;
            BytecodeManager.incBytecodes(9);
            final int computeRedLevel = computeRedLevel(size);
            BytecodeManager.incBytecodes(4);
            this.root = this.buildFromSorted(n, n2, n3, computeRedLevel, iterator, objectInputStream, v);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private final Entry<K, V> buildFromSorted(final int n, final int n2, final int n3, final int n4, final Iterator<?> iterator, final ObjectInputStream objectInputStream, final V v) throws IOException, ClassNotFoundException {
        try {
            BytecodeManager.incBytecodes(3);
            if (n3 < n2) {
                final Entry<K, V> entry = null;
                BytecodeManager.incBytecodes(2);
                return entry;
            }
            final int n5 = n2 + n3 >>> 1;
            BytecodeManager.incBytecodes(6);
            Entry<Object, Object> buildFromSorted = null;
            BytecodeManager.incBytecodes(2);
            final int n6 = n5;
            BytecodeManager.incBytecodes(3);
            if (n2 < n6) {
                final int n7 = n + 1;
                final int n8 = n5 - 1;
                BytecodeManager.incBytecodes(13);
                buildFromSorted = (Entry<Object, Object>)this.buildFromSorted(n7, n2, n8, n4, iterator, objectInputStream, (V)v);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(2);
            Object o;
            Object value;
            if (iterator != null) {
                BytecodeManager.incBytecodes(2);
                if (v == null) {
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry entry2 = (Map.Entry)iterator.next();
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry entry3 = entry2;
                    BytecodeManager.incBytecodes(2);
                    o = entry3.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry entry4 = entry2;
                    BytecodeManager.incBytecodes(2);
                    value = entry4.getValue();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    o = iterator.next();
                    BytecodeManager.incBytecodes(1);
                    value = v;
                    BytecodeManager.incBytecodes(3);
                }
            }
            else {
                BytecodeManager.incBytecodes(2);
                o = objectInputStream.readObject();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                Object object;
                if (v != null) {
                    object = v;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    BytecodeManager.incBytecodes(2);
                    object = objectInputStream.readObject();
                }
                value = object;
                BytecodeManager.incBytecodes(1);
            }
            final Object o2 = o;
            final Object o3 = value;
            final Entry<K, V> entry5 = null;
            BytecodeManager.incBytecodes(6);
            final Entry entry6 = new Entry<K, V>(o2, o3, (Entry<Object, Object>)entry5);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            if (n == n4) {
                entry6.color = false;
                BytecodeManager.incBytecodes(3);
            }
            final Entry<Object, Object> entry7 = buildFromSorted;
            BytecodeManager.incBytecodes(2);
            if (entry7 != null) {
                entry6.left = (Entry<K, V>)buildFromSorted;
                BytecodeManager.incBytecodes(3);
                buildFromSorted.parent = (Entry<Object, Object>)entry6;
                BytecodeManager.incBytecodes(3);
            }
            final int n9 = n5;
            BytecodeManager.incBytecodes(3);
            if (n9 < n3) {
                final int n10 = n + 1;
                final int n11 = n5 + 1;
                BytecodeManager.incBytecodes(13);
                final Entry<K, V> buildFromSorted2 = this.buildFromSorted(n10, n11, n3, n4, iterator, objectInputStream, (V)v);
                BytecodeManager.incBytecodes(1);
                entry6.right = (Entry<K, V>)buildFromSorted2;
                BytecodeManager.incBytecodes(3);
                buildFromSorted2.parent = (Entry<K, V>)entry6;
                BytecodeManager.incBytecodes(3);
            }
            final Entry entry8 = entry6;
            BytecodeManager.incBytecodes(2);
            return (Entry<K, V>)entry8;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int computeRedLevel(final int n) {
        try {
            int n2 = 0;
            BytecodeManager.incBytecodes(2);
            int n3 = n - 1;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 < 0) {
                    break;
                }
                ++n2;
                BytecodeManager.incBytecodes(1);
                n3 = n3 / 2 - 1;
                BytecodeManager.incBytecodes(7);
            }
            final int n5 = n2;
            BytecodeManager.incBytecodes(2);
            return n5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <K> Spliterator<K> keySpliteratorFor(final NavigableMap<K, ?> navigableMap) {
        try {
            final boolean b = navigableMap instanceof TreeMap;
            BytecodeManager.incBytecodes(3);
            if (b) {
                final TreeMap<K, V> treeMap = (TreeMap<K, V>)navigableMap;
                BytecodeManager.incBytecodes(3);
                final TreeMap<K, V> treeMap2 = treeMap;
                BytecodeManager.incBytecodes(2);
                final Spliterator<K> keySpliterator = treeMap2.keySpliterator();
                BytecodeManager.incBytecodes(1);
                return keySpliterator;
            }
            final boolean b2 = navigableMap instanceof DescendingSubMap;
            BytecodeManager.incBytecodes(3);
            if (b2) {
                final DescendingSubMap descendingSubMap = (DescendingSubMap)navigableMap;
                BytecodeManager.incBytecodes(3);
                final TreeMap<K, V> m = descendingSubMap.m;
                BytecodeManager.incBytecodes(3);
                final DescendingSubMap descendingSubMap2 = descendingSubMap;
                final NavigableMap<K, V> descendingMap = m.descendingMap;
                BytecodeManager.incBytecodes(4);
                if (descendingSubMap2 == descendingMap) {
                    final TreeMap<K, V> treeMap3 = m;
                    BytecodeManager.incBytecodes(2);
                    final TreeMap<K, V> treeMap4 = treeMap3;
                    BytecodeManager.incBytecodes(2);
                    final Spliterator<K> descendingKeySpliterator = treeMap4.descendingKeySpliterator();
                    BytecodeManager.incBytecodes(1);
                    return (Spliterator<K>)descendingKeySpliterator;
                }
            }
            final DescendingSubMap<Object, Object> descendingSubMap3 = (DescendingSubMap<Object, Object>)navigableMap;
            BytecodeManager.incBytecodes(3);
            final DescendingSubMap<Object, Object> descendingSubMap4 = descendingSubMap3;
            BytecodeManager.incBytecodes(2);
            final Spliterator<Object> keySpliterator2 = descendingSubMap4.keySpliterator();
            BytecodeManager.incBytecodes(1);
            return (Spliterator<K>)keySpliterator2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Spliterator<K> keySpliterator() {
        try {
            final Entry<Object, Object> entry = null;
            final Entry<K, ?> entry2 = null;
            final int n = 0;
            final int n2 = -1;
            final int n3 = 0;
            BytecodeManager.incBytecodes(9);
            final KeySpliterator keySpliterator = new KeySpliterator<K, Object>(this, entry, entry2, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<K>)keySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Spliterator<K> descendingKeySpliterator() {
        try {
            final Entry<Object, Object> entry = null;
            final Entry<K, ?> entry2 = null;
            final int n = 0;
            final int n2 = -2;
            final int n3 = 0;
            BytecodeManager.incBytecodes(9);
            final DescendingKeySpliterator descendingKeySpliterator = new DescendingKeySpliterator<K, Object>(this, entry, entry2, n, n2, n3);
            BytecodeManager.incBytecodes(1);
            return (Spliterator<K>)descendingKeySpliterator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ void access$000(final TreeMap treeMap, final Entry entry) {
        try {
            BytecodeManager.incBytecodes(3);
            treeMap.deleteEntry(entry);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$100(final TreeMap treeMap) {
        try {
            final int modCount = treeMap.modCount;
            BytecodeManager.incBytecodes(3);
            return modCount;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Object access$200() {
        try {
            final Object unbounded = TreeMap.UNBOUNDED;
            BytecodeManager.incBytecodes(2);
            return unbounded;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Comparator access$300(final TreeMap treeMap) {
        try {
            final Comparator<? super K> comparator = treeMap.comparator;
            BytecodeManager.incBytecodes(3);
            return comparator;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ int access$400(final TreeMap treeMap) {
        try {
            final int size = treeMap.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static /* synthetic */ Entry access$500(final TreeMap treeMap) {
        try {
            final Entry<K, V> root = treeMap.root;
            BytecodeManager.incBytecodes(3);
            return root;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            UNBOUNDED = new Object();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    class Values extends AbstractCollection<V>
    {
        Values() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<V> iterator() {
            try {
                final TreeMap this$0 = TreeMap.this;
                final TreeMap this$2 = TreeMap.this;
                BytecodeManager.incBytecodes(7);
                final Entry<K, V> firstEntry = this$2.getFirstEntry();
                BytecodeManager.incBytecodes(1);
                final ValueIterator valueIterator = new ValueIterator(firstEntry);
                BytecodeManager.incBytecodes(1);
                return valueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int size = this$0.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = this$0.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                Map.Entry<K, V> entry = (Map.Entry<K, V>)this$0.getFirstEntry();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Map.Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        final boolean b = false;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    final Map.Entry<K, V> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = ((Entry<K, Object>)entry3).getValue();
                    BytecodeManager.incBytecodes(2);
                    final boolean valEquals = TreeMap.valEquals(value, o);
                    BytecodeManager.incBytecodes(1);
                    if (valEquals) {
                        final TreeMap this$2 = TreeMap.this;
                        final Map.Entry<K, V> entry4 = entry;
                        BytecodeManager.incBytecodes(4);
                        TreeMap.access$000(this$2, (Entry)entry4);
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Map.Entry<K, V> entry5 = entry;
                    BytecodeManager.incBytecodes(2);
                    entry = (Map.Entry<K, V>)TreeMap.successor((Entry<K, Object>)entry5);
                    BytecodeManager.incBytecodes(2);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<V> spliterator() {
            try {
                final TreeMap this$0 = TreeMap.this;
                final Entry<?, V> entry = null;
                final Entry<?, V> entry2 = null;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                BytecodeManager.incBytecodes(10);
                final ValueSpliterator valueSpliterator = new ValueSpliterator<Object, V>(this$0, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<V>)valueSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        EntrySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            try {
                final TreeMap this$0 = TreeMap.this;
                final TreeMap this$2 = TreeMap.this;
                BytecodeManager.incBytecodes(7);
                final Entry<K, V> firstEntry = this$2.getFirstEntry();
                BytecodeManager.incBytecodes(1);
                final EntryIterator entryIterator = new EntryIterator(firstEntry);
                BytecodeManager.incBytecodes(1);
                return entryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean contains(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry2.getValue();
                BytecodeManager.incBytecodes(1);
                final TreeMap this$0 = TreeMap.this;
                final Map.Entry entry3 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry3.getKey();
                BytecodeManager.incBytecodes(1);
                final Entry<K, Object> entry4 = this$0.getEntry(key);
                BytecodeManager.incBytecodes(1);
                final Entry<K, Object> entry5 = entry4;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                Label_0128: {
                    if (entry5 != null) {
                        final Entry<K, Object> entry6 = entry4;
                        BytecodeManager.incBytecodes(2);
                        final Object value2 = entry6.getValue();
                        final Object o2 = value;
                        BytecodeManager.incBytecodes(2);
                        final boolean valEquals = TreeMap.valEquals(value2, o2);
                        BytecodeManager.incBytecodes(1);
                        if (valEquals) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0128;
                        }
                    }
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
        public boolean remove(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Object value = entry2.getValue();
                BytecodeManager.incBytecodes(1);
                final TreeMap this$0 = TreeMap.this;
                final Map.Entry entry3 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry3.getKey();
                BytecodeManager.incBytecodes(1);
                final Entry<K, Object> entry4 = this$0.getEntry(key);
                BytecodeManager.incBytecodes(1);
                final Entry<K, Object> entry5 = entry4;
                BytecodeManager.incBytecodes(2);
                if (entry5 != null) {
                    final Entry<K, Object> entry6 = entry4;
                    BytecodeManager.incBytecodes(2);
                    final Object value2 = entry6.getValue();
                    final Object o2 = value;
                    BytecodeManager.incBytecodes(2);
                    final boolean valEquals = TreeMap.valEquals(value2, o2);
                    BytecodeManager.incBytecodes(1);
                    if (valEquals) {
                        final TreeMap this$2 = TreeMap.this;
                        final Entry<K, Object> entry7 = entry4;
                        BytecodeManager.incBytecodes(4);
                        TreeMap.access$000(this$2, entry7);
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                }
                final boolean b4 = false;
                BytecodeManager.incBytecodes(2);
                return b4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int size = this$0.size();
                BytecodeManager.incBytecodes(1);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void clear() {
            try {
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Map.Entry<K, V>> spliterator() {
            try {
                final TreeMap this$0 = TreeMap.this;
                final Entry<K, V> entry = null;
                final Entry<K, V> entry2 = null;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                BytecodeManager.incBytecodes(10);
                final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>(this$0, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Map.Entry<K, V>>)entrySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySet<E> extends AbstractSet<E> implements NavigableSet<E>
    {
        private final NavigableMap<E, ?> m;
        
        KeySet(final NavigableMap<E, ?> m) {
            try {
                BytecodeManager.incBytecodes(2);
                this.m = m;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> iterator() {
            try {
                final boolean b = this.m instanceof TreeMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final TreeMap treeMap = (TreeMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<E> keyIterator = treeMap.keyIterator();
                    BytecodeManager.incBytecodes(1);
                    return keyIterator;
                }
                final NavigableSubMap navigableSubMap = (NavigableSubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Iterator<E> keyIterator2 = navigableSubMap.keyIterator();
                BytecodeManager.incBytecodes(1);
                return keyIterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            try {
                final boolean b = this.m instanceof TreeMap;
                BytecodeManager.incBytecodes(4);
                if (b) {
                    final TreeMap treeMap = (TreeMap)this.m;
                    BytecodeManager.incBytecodes(4);
                    final Iterator<E> descendingKeyIterator = treeMap.descendingKeyIterator();
                    BytecodeManager.incBytecodes(1);
                    return descendingKeyIterator;
                }
                final NavigableSubMap navigableSubMap = (NavigableSubMap)this.m;
                BytecodeManager.incBytecodes(4);
                final Iterator<E> descendingKeyIterator2 = navigableSubMap.descendingKeyIterator();
                BytecodeManager.incBytecodes(1);
                return descendingKeyIterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
        public void clear() {
            try {
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                m.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E lower(final E e) {
            try {
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
        public E first() {
            try {
                final NavigableMap<E, ?> m = this.m;
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
                final NavigableMap<E, ?> m = this.m;
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
        public Comparator<? super E> comparator() {
            try {
                final NavigableMap<E, ?> m = this.m;
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
        public E pollFirst() {
            try {
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<E, ?> pollFirstEntry = m.pollFirstEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<E, ?> entry = pollFirstEntry;
                BytecodeManager.incBytecodes(2);
                E key;
                if (entry == null) {
                    key = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<E, ?> entry2 = pollFirstEntry;
                    BytecodeManager.incBytecodes(2);
                    key = entry2.getKey();
                }
                BytecodeManager.incBytecodes(1);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public E pollLast() {
            try {
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Map.Entry<E, ?> pollLastEntry = m.pollLastEntry();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<E, ?> entry = pollLastEntry;
                BytecodeManager.incBytecodes(2);
                E key;
                if (entry == null) {
                    key = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Map.Entry<E, ?> entry2 = pollLastEntry;
                    BytecodeManager.incBytecodes(2);
                    key = entry2.getKey();
                }
                BytecodeManager.incBytecodes(1);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(2);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(4);
                m.remove(o);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final int size2 = this.size();
                final int n = size;
                BytecodeManager.incBytecodes(2);
                boolean b;
                if (size2 != n) {
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
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            try {
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(9);
                final NavigableMap<E, ?> subMap = m.subMap(e, b, e2, b2);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((NavigableMap<Object, ?>)subMap);
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
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(7);
                final NavigableMap<E, ?> headMap = m.headMap(e, b);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((NavigableMap<Object, ?>)headMap);
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
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(7);
                final NavigableMap<E, ?> tailMap = m.tailMap(e, b);
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((NavigableMap<Object, ?>)tailMap);
                BytecodeManager.incBytecodes(1);
                return set;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
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
        public SortedSet<E> headSet(final E e) {
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
        public SortedSet<E> tailSet(final E e) {
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
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(5);
                final NavigableMap<E, ?> descendingMap = m.descendingMap();
                BytecodeManager.incBytecodes(1);
                final KeySet set = new KeySet((NavigableMap<Object, ?>)descendingMap);
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
                final NavigableMap<E, ?> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Spliterator<E> keySpliterator = TreeMap.keySpliteratorFor(m);
                BytecodeManager.incBytecodes(1);
                return keySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract class PrivateEntryIterator<T> implements Iterator<T>
    {
        Entry<K, V> next;
        Entry<K, V> lastReturned;
        int expectedModCount;
        
        PrivateEntryIterator(final Entry<K, V> next) {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = TreeMap.access$100(TreeMap.this);
                BytecodeManager.incBytecodes(1);
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                this.next = next;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean hasNext() {
            try {
                final Entry<K, V> next = this.next;
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
        
        final Entry<K, V> nextEntry() {
            try {
                final Entry<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$100 = TreeMap.access$100(this$0);
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(3);
                if (access$100 != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final Entry<K, V> entry2 = next;
                BytecodeManager.incBytecodes(3);
                this.next = TreeMap.successor(entry2);
                BytecodeManager.incBytecodes(1);
                this.lastReturned = next;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry3 = next;
                BytecodeManager.incBytecodes(2);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final Entry<K, V> prevEntry() {
            try {
                final Entry<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$100 = TreeMap.access$100(this$0);
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(3);
                if (access$100 != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final Entry<K, V> entry2 = next;
                BytecodeManager.incBytecodes(3);
                this.next = TreeMap.predecessor(entry2);
                BytecodeManager.incBytecodes(1);
                this.lastReturned = next;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry3 = next;
                BytecodeManager.incBytecodes(2);
                return entry3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final Entry<K, V> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                if (lastReturned == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$100 = TreeMap.access$100(this$0);
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(3);
                if (access$100 != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final Entry<K, V> left = this.lastReturned.left;
                BytecodeManager.incBytecodes(4);
                if (left != null) {
                    final Entry<K, V> right = this.lastReturned.right;
                    BytecodeManager.incBytecodes(4);
                    if (right != null) {
                        this.next = this.lastReturned;
                        BytecodeManager.incBytecodes(4);
                    }
                }
                final TreeMap this$2 = TreeMap.this;
                final Entry<K, V> lastReturned2 = this.lastReturned;
                BytecodeManager.incBytecodes(5);
                TreeMap.access$000(this$2, lastReturned2);
                final TreeMap this$3 = TreeMap.this;
                BytecodeManager.incBytecodes(4);
                this.expectedModCount = TreeMap.access$100(this$3);
                BytecodeManager.incBytecodes(1);
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class EntryIterator extends PrivateEntryIterator<Map.Entry<K, V>>
    {
        EntryIterator(final Entry<K, V> entry) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(entry);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Map.Entry<K, V> next() {
            try {
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> nextEntry = this.nextEntry();
                BytecodeManager.incBytecodes(1);
                return nextEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class ValueIterator extends PrivateEntryIterator<V>
    {
        ValueIterator(final Entry<K, V> entry) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(entry);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V next() {
            try {
                BytecodeManager.incBytecodes(2);
                final V value = this.nextEntry().value;
                BytecodeManager.incBytecodes(2);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class KeyIterator extends PrivateEntryIterator<K>
    {
        KeyIterator(final Entry<K, V> entry) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(entry);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K next() {
            try {
                BytecodeManager.incBytecodes(2);
                final K key = this.nextEntry().key;
                BytecodeManager.incBytecodes(2);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class DescendingKeyIterator extends PrivateEntryIterator<K>
    {
        DescendingKeyIterator(final Entry<K, V> entry) {
            try {
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(4);
                super(entry);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K next() {
            try {
                BytecodeManager.incBytecodes(2);
                final K key = this.prevEntry().key;
                BytecodeManager.incBytecodes(2);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void remove() {
            try {
                final Entry<K, V> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                if (lastReturned == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap this$0 = TreeMap.this;
                BytecodeManager.incBytecodes(3);
                final int access$100 = TreeMap.access$100(this$0);
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(3);
                if (access$100 != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final TreeMap this$2 = TreeMap.this;
                final Entry<K, V> lastReturned2 = this.lastReturned;
                BytecodeManager.incBytecodes(5);
                TreeMap.access$000(this$2, lastReturned2);
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                final TreeMap this$3 = TreeMap.this;
                BytecodeManager.incBytecodes(4);
                this.expectedModCount = TreeMap.access$100(this$3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class NavigableSubMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable
    {
        private static final long serialVersionUID = -2102997345730753016L;
        final TreeMap<K, V> m;
        final K lo;
        final K hi;
        final boolean fromStart;
        final boolean toEnd;
        final boolean loInclusive;
        final boolean hiInclusive;
        transient NavigableMap<K, V> descendingMapView;
        transient EntrySetView entrySetView;
        transient KeySet<K> navigableKeySetView;
        
        NavigableSubMap(final TreeMap<K, V> m, final boolean fromStart, final K lo, final boolean loInclusive, final boolean toEnd, final K hi, final boolean hiInclusive) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                Label_0123: {
                    if (!fromStart) {
                        BytecodeManager.incBytecodes(2);
                        if (!toEnd) {
                            BytecodeManager.incBytecodes(4);
                            final int compare = m.compare(lo, hi);
                            BytecodeManager.incBytecodes(1);
                            if (compare > 0) {
                                final String s = "fromKey > toKey";
                                BytecodeManager.incBytecodes(4);
                                final IllegalArgumentException ex = new IllegalArgumentException(s);
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            break Label_0123;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    if (!fromStart) {
                        BytecodeManager.incBytecodes(4);
                        m.compare(lo, lo);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    if (!toEnd) {
                        BytecodeManager.incBytecodes(4);
                        m.compare(hi, hi);
                        BytecodeManager.incBytecodes(1);
                    }
                }
                this.m = m;
                BytecodeManager.incBytecodes(3);
                this.fromStart = fromStart;
                BytecodeManager.incBytecodes(3);
                this.lo = lo;
                BytecodeManager.incBytecodes(3);
                this.loInclusive = loInclusive;
                BytecodeManager.incBytecodes(3);
                this.toEnd = toEnd;
                BytecodeManager.incBytecodes(3);
                this.hi = hi;
                BytecodeManager.incBytecodes(3);
                this.hiInclusive = hiInclusive;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean tooLow(final Object o) {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                Label_0072: {
                    if (!fromStart) {
                        final TreeMap<K, V> m = this.m;
                        final K lo = this.lo;
                        BytecodeManager.incBytecodes(6);
                        final int compare = m.compare(o, lo);
                        BytecodeManager.incBytecodes(1);
                        final int n = compare;
                        BytecodeManager.incBytecodes(2);
                        if (n >= 0) {
                            final int n2 = compare;
                            BytecodeManager.incBytecodes(2);
                            if (n2 != 0) {
                                break Label_0072;
                            }
                            final boolean loInclusive = this.loInclusive;
                            BytecodeManager.incBytecodes(3);
                            if (loInclusive) {
                                break Label_0072;
                            }
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean tooHigh(final Object o) {
            try {
                final boolean toEnd = this.toEnd;
                BytecodeManager.incBytecodes(3);
                Label_0072: {
                    if (!toEnd) {
                        final TreeMap<K, V> m = this.m;
                        final K hi = this.hi;
                        BytecodeManager.incBytecodes(6);
                        final int compare = m.compare(o, hi);
                        BytecodeManager.incBytecodes(1);
                        final int n = compare;
                        BytecodeManager.incBytecodes(2);
                        if (n <= 0) {
                            final int n2 = compare;
                            BytecodeManager.incBytecodes(2);
                            if (n2 != 0) {
                                break Label_0072;
                            }
                            final boolean hiInclusive = this.hiInclusive;
                            BytecodeManager.incBytecodes(3);
                            if (hiInclusive) {
                                break Label_0072;
                            }
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean inRange(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean tooLow = this.tooLow(o);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0051: {
                    if (!tooLow) {
                        BytecodeManager.incBytecodes(3);
                        final boolean tooHigh = this.tooHigh(o);
                        BytecodeManager.incBytecodes(1);
                        if (!tooHigh) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0051;
                        }
                    }
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
        
        final boolean inClosedRange(final Object o) {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0094: {
                    Label_0088: {
                        if (!fromStart) {
                            final TreeMap<K, V> m = this.m;
                            final K lo = this.lo;
                            BytecodeManager.incBytecodes(6);
                            final int compare = m.compare(o, lo);
                            BytecodeManager.incBytecodes(1);
                            if (compare < 0) {
                                break Label_0088;
                            }
                        }
                        final boolean toEnd = this.toEnd;
                        BytecodeManager.incBytecodes(3);
                        if (!toEnd) {
                            final TreeMap<K, V> i = this.m;
                            final K hi = this.hi;
                            BytecodeManager.incBytecodes(5);
                            BytecodeManager.incBytecodes(1);
                            final int compare2 = i.compare(hi, o);
                            BytecodeManager.incBytecodes(1);
                            if (compare2 < 0) {
                                break Label_0088;
                            }
                        }
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0094;
                    }
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
        
        final boolean inRange(final Object o, final boolean b) {
            try {
                BytecodeManager.incBytecodes(2);
                boolean b2;
                if (b) {
                    BytecodeManager.incBytecodes(3);
                    b2 = this.inRange(o);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(3);
                    b2 = this.inClosedRange(o);
                }
                BytecodeManager.incBytecodes(1);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absLowest() {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                TreeMap.Entry<K, V> entry;
                if (fromStart) {
                    final TreeMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    entry = m.getFirstEntry();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean loInclusive = this.loInclusive;
                    BytecodeManager.incBytecodes(3);
                    if (loInclusive) {
                        final TreeMap<K, V> i = this.m;
                        final K lo = this.lo;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = i.getCeilingEntry(lo);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final TreeMap<K, V> j = this.m;
                        final K lo2 = this.lo;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = j.getHigherEntry(lo2);
                    }
                }
                final TreeMap.Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry3 = entry2;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry4 = null;
                Label_0150: {
                    if (entry3 != null) {
                        final K key = entry2.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooHigh = this.tooHigh(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooHigh) {
                            entry4 = entry2;
                            BytecodeManager.incBytecodes(1);
                            break Label_0150;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absHighest() {
            try {
                final boolean toEnd = this.toEnd;
                BytecodeManager.incBytecodes(3);
                TreeMap.Entry<K, V> entry;
                if (toEnd) {
                    final TreeMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    entry = m.getLastEntry();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final boolean hiInclusive = this.hiInclusive;
                    BytecodeManager.incBytecodes(3);
                    if (hiInclusive) {
                        final TreeMap<K, V> i = this.m;
                        final K hi = this.hi;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = i.getFloorEntry(hi);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final TreeMap<K, V> j = this.m;
                        final K hi2 = this.hi;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = j.getLowerEntry(hi2);
                    }
                }
                final TreeMap.Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry3 = entry2;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry4 = null;
                Label_0150: {
                    if (entry3 != null) {
                        final K key = entry2.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooLow = this.tooLow(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooLow) {
                            entry4 = entry2;
                            BytecodeManager.incBytecodes(1);
                            break Label_0150;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absCeiling(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean tooLow = this.tooLow(k);
                BytecodeManager.incBytecodes(1);
                if (tooLow) {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> absLowest = this.absLowest();
                    BytecodeManager.incBytecodes(1);
                    return absLowest;
                }
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final TreeMap.Entry<K, V> ceilingEntry = m.getCeilingEntry(k);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = ceilingEntry;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry2 = null;
                Label_0097: {
                    if (entry != null) {
                        final K key = ceilingEntry.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooHigh = this.tooHigh(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooHigh) {
                            entry2 = ceilingEntry;
                            BytecodeManager.incBytecodes(1);
                            break Label_0097;
                        }
                    }
                    entry2 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absHigher(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean tooLow = this.tooLow(k);
                BytecodeManager.incBytecodes(1);
                if (tooLow) {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> absLowest = this.absLowest();
                    BytecodeManager.incBytecodes(1);
                    return absLowest;
                }
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final TreeMap.Entry<K, V> higherEntry = m.getHigherEntry(k);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = higherEntry;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry2 = null;
                Label_0097: {
                    if (entry != null) {
                        final K key = higherEntry.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooHigh = this.tooHigh(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooHigh) {
                            entry2 = higherEntry;
                            BytecodeManager.incBytecodes(1);
                            break Label_0097;
                        }
                    }
                    entry2 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absFloor(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean tooHigh = this.tooHigh(k);
                BytecodeManager.incBytecodes(1);
                if (tooHigh) {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> absHighest = this.absHighest();
                    BytecodeManager.incBytecodes(1);
                    return absHighest;
                }
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final TreeMap.Entry<K, V> floorEntry = m.getFloorEntry(k);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = floorEntry;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry2 = null;
                Label_0097: {
                    if (entry != null) {
                        final K key = floorEntry.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooLow = this.tooLow(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooLow) {
                            entry2 = floorEntry;
                            BytecodeManager.incBytecodes(1);
                            break Label_0097;
                        }
                    }
                    entry2 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absLower(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean tooHigh = this.tooHigh(k);
                BytecodeManager.incBytecodes(1);
                if (tooHigh) {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> absHighest = this.absHighest();
                    BytecodeManager.incBytecodes(1);
                    return absHighest;
                }
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(4);
                final TreeMap.Entry<K, V> lowerEntry = m.getLowerEntry(k);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = lowerEntry;
                BytecodeManager.incBytecodes(2);
                TreeMap.Entry<K, V> entry2 = null;
                Label_0097: {
                    if (entry != null) {
                        final K key = lowerEntry.key;
                        BytecodeManager.incBytecodes(4);
                        final boolean tooLow = this.tooLow(key);
                        BytecodeManager.incBytecodes(1);
                        if (!tooLow) {
                            entry2 = lowerEntry;
                            BytecodeManager.incBytecodes(1);
                            break Label_0097;
                        }
                    }
                    entry2 = null;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return entry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absHighFence() {
            try {
                final boolean toEnd = this.toEnd;
                BytecodeManager.incBytecodes(3);
                TreeMap.Entry<K, V> entry;
                if (toEnd) {
                    entry = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final boolean hiInclusive = this.hiInclusive;
                    BytecodeManager.incBytecodes(3);
                    if (hiInclusive) {
                        final TreeMap<K, V> m = this.m;
                        final K hi = this.hi;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = m.getHigherEntry(hi);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final TreeMap<K, V> i = this.m;
                        final K hi2 = this.hi;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = i.getCeilingEntry(hi2);
                    }
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final TreeMap.Entry<K, V> absLowFence() {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                TreeMap.Entry<K, V> entry;
                if (fromStart) {
                    entry = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final boolean loInclusive = this.loInclusive;
                    BytecodeManager.incBytecodes(3);
                    if (loInclusive) {
                        final TreeMap<K, V> m = this.m;
                        final K lo = this.lo;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = m.getLowerEntry(lo);
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        final TreeMap<K, V> i = this.m;
                        final K lo2 = this.lo;
                        BytecodeManager.incBytecodes(4);
                        BytecodeManager.incBytecodes(1);
                        entry = i.getFloorEntry(lo2);
                    }
                }
                BytecodeManager.incBytecodes(1);
                return entry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract TreeMap.Entry<K, V> subLowest();
        
        abstract TreeMap.Entry<K, V> subHighest();
        
        abstract TreeMap.Entry<K, V> subCeiling(final K p0);
        
        abstract TreeMap.Entry<K, V> subHigher(final K p0);
        
        abstract TreeMap.Entry<K, V> subFloor(final K p0);
        
        abstract TreeMap.Entry<K, V> subLower(final K p0);
        
        abstract Iterator<K> keyIterator();
        
        abstract Spliterator<K> keySpliterator();
        
        abstract Iterator<K> descendingKeyIterator();
        
        @Override
        public boolean isEmpty() {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                boolean b = false;
                Label_0063: {
                    if (fromStart) {
                        final boolean toEnd = this.toEnd;
                        BytecodeManager.incBytecodes(3);
                        if (toEnd) {
                            final TreeMap<K, V> m = this.m;
                            BytecodeManager.incBytecodes(3);
                            b = m.isEmpty();
                            BytecodeManager.incBytecodes(1);
                            break Label_0063;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final Set<Map.Entry<K, V>> entrySet = this.entrySet();
                    BytecodeManager.incBytecodes(1);
                    b = entrySet.isEmpty();
                }
                BytecodeManager.incBytecodes(1);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final boolean fromStart = this.fromStart;
                BytecodeManager.incBytecodes(3);
                int n = 0;
                Label_0063: {
                    if (fromStart) {
                        final boolean toEnd = this.toEnd;
                        BytecodeManager.incBytecodes(3);
                        if (toEnd) {
                            final TreeMap<K, V> m = this.m;
                            BytecodeManager.incBytecodes(3);
                            n = m.size();
                            BytecodeManager.incBytecodes(1);
                            break Label_0063;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final Set<Map.Entry<K, V>> entrySet = this.entrySet();
                    BytecodeManager.incBytecodes(1);
                    n = entrySet.size();
                }
                BytecodeManager.incBytecodes(1);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean containsKey(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean inRange = this.inRange(o);
                BytecodeManager.incBytecodes(1);
                boolean b = false;
                Label_0054: {
                    if (inRange) {
                        final TreeMap<K, V> m = this.m;
                        BytecodeManager.incBytecodes(4);
                        final boolean containsKey = m.containsKey(o);
                        BytecodeManager.incBytecodes(1);
                        if (containsKey) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0054;
                        }
                    }
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
        public final V put(final K k, final V v) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean inRange = this.inRange(k);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "key out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(5);
                final V put = m.put(k, v);
                BytecodeManager.incBytecodes(1);
                return put;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V get(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean inRange = this.inRange(o);
                BytecodeManager.incBytecodes(1);
                V value;
                if (!inRange) {
                    value = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TreeMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    value = m.get(o);
                }
                BytecodeManager.incBytecodes(1);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V remove(final Object o) {
            try {
                BytecodeManager.incBytecodes(3);
                final boolean inRange = this.inRange(o);
                BytecodeManager.incBytecodes(1);
                V remove;
                if (!inRange) {
                    remove = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TreeMap<K, V> m = this.m;
                    BytecodeManager.incBytecodes(4);
                    remove = m.remove(o);
                }
                BytecodeManager.incBytecodes(1);
                return remove;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> ceilingEntry(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subCeiling = this.subCeiling((K)k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry((TreeMap.Entry<K, V>)subCeiling);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K ceilingKey(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subCeiling = this.subCeiling((K)k);
                BytecodeManager.incBytecodes(1);
                final K keyOrNull = TreeMap.keyOrNull((TreeMap.Entry<K, V>)subCeiling);
                BytecodeManager.incBytecodes(1);
                return keyOrNull;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> higherEntry(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subHigher = this.subHigher((K)k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry((TreeMap.Entry<K, V>)subHigher);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K higherKey(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subHigher = this.subHigher((K)k);
                BytecodeManager.incBytecodes(1);
                final K keyOrNull = TreeMap.keyOrNull((TreeMap.Entry<K, V>)subHigher);
                BytecodeManager.incBytecodes(1);
                return keyOrNull;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> floorEntry(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subFloor = this.subFloor((K)k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry((TreeMap.Entry<K, V>)subFloor);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K floorKey(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subFloor = this.subFloor((K)k);
                BytecodeManager.incBytecodes(1);
                final K keyOrNull = TreeMap.keyOrNull((TreeMap.Entry<K, V>)subFloor);
                BytecodeManager.incBytecodes(1);
                return keyOrNull;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> lowerEntry(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subLower = this.subLower((K)k);
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry((TreeMap.Entry<K, V>)subLower);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K lowerKey(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> subLower = this.subLower((K)k);
                BytecodeManager.incBytecodes(1);
                final K keyOrNull = TreeMap.keyOrNull((TreeMap.Entry<K, V>)subLower);
                BytecodeManager.incBytecodes(1);
                return keyOrNull;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K firstKey() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subLowest = this.subLowest();
                BytecodeManager.incBytecodes(1);
                final K key = TreeMap.key(subLowest);
                BytecodeManager.incBytecodes(1);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K lastKey() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subHighest = this.subHighest();
                BytecodeManager.incBytecodes(1);
                final K key = TreeMap.key(subHighest);
                BytecodeManager.incBytecodes(1);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> firstEntry() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subLowest = this.subLowest();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry(subLowest);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> lastEntry() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subHighest = this.subHighest();
                BytecodeManager.incBytecodes(1);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry(subHighest);
                BytecodeManager.incBytecodes(1);
                return exportEntry;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> pollFirstEntry() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subLowest = this.subLowest();
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = subLowest;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry(entry);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry2 = subLowest;
                BytecodeManager.incBytecodes(2);
                if (entry2 != null) {
                    final TreeMap<K, V> m = this.m;
                    final TreeMap.Entry<K, V> entry3 = subLowest;
                    BytecodeManager.incBytecodes(4);
                    TreeMap.access$000((TreeMap<Object, Object>)m, entry3);
                }
                final Map.Entry<K, V> entry4 = exportEntry;
                BytecodeManager.incBytecodes(2);
                return entry4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> pollLastEntry() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> subHighest = this.subHighest();
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry = subHighest;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<K, V> exportEntry = TreeMap.exportEntry(entry);
                BytecodeManager.incBytecodes(1);
                final TreeMap.Entry<K, V> entry2 = subHighest;
                BytecodeManager.incBytecodes(2);
                if (entry2 != null) {
                    final TreeMap<K, V> m = this.m;
                    final TreeMap.Entry<K, V> entry3 = subHighest;
                    BytecodeManager.incBytecodes(4);
                    TreeMap.access$000((TreeMap<Object, Object>)m, entry3);
                }
                final Map.Entry<K, V> entry4 = exportEntry;
                BytecodeManager.incBytecodes(2);
                return entry4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final NavigableSet<K> navigableKeySet() {
            try {
                final KeySet<K> navigableKeySetView = this.navigableKeySetView;
                BytecodeManager.incBytecodes(3);
                final KeySet<K> set = navigableKeySetView;
                BytecodeManager.incBytecodes(2);
                KeySet<K> set2;
                if (set != null) {
                    set2 = navigableKeySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final KeySet<K> navigableKeySetView2 = set2 = new KeySet<K>(this);
                    BytecodeManager.incBytecodes(5);
                    this.navigableKeySetView = navigableKeySetView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return set2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Set<K> keySet() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableSet<K> navigableKeySet = this.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                return navigableKeySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            try {
                BytecodeManager.incBytecodes(2);
                final NavigableMap<K, V> descendingMap = this.descendingMap();
                BytecodeManager.incBytecodes(1);
                final NavigableSet<K> navigableKeySet = descendingMap.navigableKeySet();
                BytecodeManager.incBytecodes(1);
                return navigableKeySet;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final SortedMap<K, V> subMap(final K k, final K i) {
            try {
                final boolean b = true;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(6);
                final NavigableMap<K, Object> subMap = this.subMap(k, b, i, b2);
                BytecodeManager.incBytecodes(1);
                return (SortedMap<K, V>)subMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final SortedMap<K, V> headMap(final K k) {
            try {
                final boolean b = false;
                BytecodeManager.incBytecodes(4);
                final NavigableMap<K, Object> headMap = this.headMap(k, b);
                BytecodeManager.incBytecodes(1);
                return (SortedMap<K, V>)headMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final SortedMap<K, V> tailMap(final K k) {
            try {
                final boolean b = true;
                BytecodeManager.incBytecodes(4);
                final NavigableMap<K, Object> tailMap = this.tailMap(k, b);
                BytecodeManager.incBytecodes(1);
                return (SortedMap<K, V>)tailMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract class EntrySetView extends AbstractSet<Map.Entry<K, V>>
        {
            private transient int size;
            private transient int sizeModCount;
            
            EntrySetView() {
                try {
                    BytecodeManager.incBytecodes(5);
                    this.size = -1;
                    BytecodeManager.incBytecodes(4);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int size() {
                try {
                    final boolean fromStart = NavigableSubMap.this.fromStart;
                    BytecodeManager.incBytecodes(4);
                    if (fromStart) {
                        final boolean toEnd = NavigableSubMap.this.toEnd;
                        BytecodeManager.incBytecodes(4);
                        if (toEnd) {
                            final TreeMap<K, V> m = NavigableSubMap.this.m;
                            BytecodeManager.incBytecodes(4);
                            final int size = m.size();
                            BytecodeManager.incBytecodes(1);
                            return size;
                        }
                    }
                    final int size2 = this.size;
                    final int n = -1;
                    BytecodeManager.incBytecodes(4);
                    Label_0194: {
                        if (size2 != n) {
                            final int sizeModCount = this.sizeModCount;
                            final TreeMap<K, V> i = NavigableSubMap.this.m;
                            BytecodeManager.incBytecodes(6);
                            final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)i);
                            BytecodeManager.incBytecodes(1);
                            if (sizeModCount == access$100) {
                                break Label_0194;
                            }
                        }
                        final TreeMap<K, V> j = NavigableSubMap.this.m;
                        BytecodeManager.incBytecodes(5);
                        this.sizeModCount = TreeMap.access$100((TreeMap<Object, Object>)j);
                        BytecodeManager.incBytecodes(1);
                        this.size = 0;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(2);
                        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Iterator<Map.Entry<K, V>> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break;
                            }
                            ++this.size;
                            BytecodeManager.incBytecodes(6);
                            final Iterator<Map.Entry<K, V>> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            iterator3.next();
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    final int size3 = this.size;
                    BytecodeManager.incBytecodes(3);
                    return size3;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean isEmpty() {
                try {
                    final NavigableSubMap this$0 = NavigableSubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap.Entry<K, V> absLowest = this$0.absLowest();
                    BytecodeManager.incBytecodes(1);
                    final TreeMap.Entry<K, V> entry = absLowest;
                    BytecodeManager.incBytecodes(2);
                    boolean b = false;
                    Label_0066: {
                        if (entry != null) {
                            final NavigableSubMap this$2 = NavigableSubMap.this;
                            final K key = absLowest.key;
                            BytecodeManager.incBytecodes(5);
                            final boolean tooHigh = this$2.tooHigh(key);
                            BytecodeManager.incBytecodes(1);
                            if (!tooHigh) {
                                b = false;
                                BytecodeManager.incBytecodes(1);
                                break Label_0066;
                            }
                        }
                        b = true;
                        BytecodeManager.incBytecodes(2);
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
                    final boolean b = o instanceof Map.Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Map.Entry entry = (Map.Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final Map.Entry<Object, V> entry2 = (Map.Entry<Object, V>)entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final NavigableSubMap this$0 = NavigableSubMap.this;
                    final Object o2 = key;
                    BytecodeManager.incBytecodes(4);
                    final boolean inRange = this$0.inRange(o2);
                    BytecodeManager.incBytecodes(1);
                    if (!inRange) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final TreeMap<K, V> m = NavigableSubMap.this.m;
                    final Object o3 = key;
                    BytecodeManager.incBytecodes(5);
                    final TreeMap.Entry<K, V> entry3 = m.getEntry(o3);
                    BytecodeManager.incBytecodes(1);
                    final TreeMap.Entry<K, V> entry4 = entry3;
                    BytecodeManager.incBytecodes(2);
                    boolean b4 = false;
                    Label_0164: {
                        if (entry4 != null) {
                            final TreeMap.Entry<K, V> entry5 = entry3;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final V value = entry5.getValue();
                            final Map.Entry<Object, Object> entry6 = (Map.Entry<Object, Object>)entry;
                            BytecodeManager.incBytecodes(2);
                            final Object value2 = entry6.getValue();
                            BytecodeManager.incBytecodes(1);
                            final boolean valEquals = TreeMap.valEquals(value, value2);
                            BytecodeManager.incBytecodes(1);
                            if (valEquals) {
                                b4 = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0164;
                            }
                        }
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean remove(final Object o) {
                try {
                    final boolean b = o instanceof Map.Entry;
                    BytecodeManager.incBytecodes(3);
                    if (!b) {
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Map.Entry entry = (Map.Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final Map.Entry<Object, V> entry2 = (Map.Entry<Object, V>)entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final NavigableSubMap this$0 = NavigableSubMap.this;
                    final Object o2 = key;
                    BytecodeManager.incBytecodes(4);
                    final boolean inRange = this$0.inRange(o2);
                    BytecodeManager.incBytecodes(1);
                    if (!inRange) {
                        final boolean b3 = false;
                        BytecodeManager.incBytecodes(2);
                        return b3;
                    }
                    final TreeMap<K, V> m = NavigableSubMap.this.m;
                    final Object o3 = key;
                    BytecodeManager.incBytecodes(5);
                    final TreeMap.Entry<K, V> entry3 = m.getEntry(o3);
                    BytecodeManager.incBytecodes(1);
                    final TreeMap.Entry<K, V> entry4 = entry3;
                    BytecodeManager.incBytecodes(2);
                    if (entry4 != null) {
                        final TreeMap.Entry<K, V> entry5 = entry3;
                        BytecodeManager.incBytecodes(2);
                        final V value = entry5.getValue();
                        final Map.Entry<Object, Object> entry6 = (Map.Entry<Object, Object>)entry;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Object value2 = entry6.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean valEquals = TreeMap.valEquals(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (valEquals) {
                            final TreeMap<K, V> i = NavigableSubMap.this.m;
                            final TreeMap.Entry<K, V> entry7 = entry3;
                            BytecodeManager.incBytecodes(5);
                            TreeMap.access$000((TreeMap<Object, Object>)i, entry7);
                            final boolean b4 = true;
                            BytecodeManager.incBytecodes(2);
                            return b4;
                        }
                    }
                    final boolean b5 = false;
                    BytecodeManager.incBytecodes(2);
                    return b5;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        abstract class SubMapIterator<T> implements Iterator<T>
        {
            TreeMap.Entry<K, V> lastReturned;
            TreeMap.Entry<K, V> next;
            final Object fenceKey;
            int expectedModCount;
            
            SubMapIterator(final TreeMap.Entry<K, V> next, final TreeMap.Entry<K, V> entry) {
                try {
                    BytecodeManager.incBytecodes(5);
                    final TreeMap<K, V> m = NavigableSubMap.this.m;
                    BytecodeManager.incBytecodes(4);
                    this.expectedModCount = TreeMap.access$100((TreeMap<Object, Object>)m);
                    BytecodeManager.incBytecodes(1);
                    this.lastReturned = null;
                    BytecodeManager.incBytecodes(3);
                    this.next = next;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(3);
                    Object fenceKey;
                    if (entry == null) {
                        BytecodeManager.incBytecodes(1);
                        fenceKey = TreeMap.access$200();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        fenceKey = entry.key;
                        BytecodeManager.incBytecodes(2);
                    }
                    this.fenceKey = fenceKey;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final boolean hasNext() {
                try {
                    final TreeMap.Entry<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    boolean b = false;
                    Label_0046: {
                        if (next != null) {
                            final K key = this.next.key;
                            final Object fenceKey = this.fenceKey;
                            BytecodeManager.incBytecodes(6);
                            if (key != fenceKey) {
                                b = true;
                                BytecodeManager.incBytecodes(2);
                                break Label_0046;
                            }
                        }
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
            
            final TreeMap.Entry<K, V> nextEntry() {
                try {
                    final TreeMap.Entry<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap.Entry<K, V> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry != null) {
                        final K key = next.key;
                        final Object fenceKey = this.fenceKey;
                        BytecodeManager.incBytecodes(5);
                        if (key != fenceKey) {
                            final TreeMap<K, V> m = NavigableSubMap.this.m;
                            BytecodeManager.incBytecodes(4);
                            final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)m);
                            final int expectedModCount = this.expectedModCount;
                            BytecodeManager.incBytecodes(3);
                            if (access$100 != expectedModCount) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            final TreeMap.Entry<K, V> entry2 = next;
                            BytecodeManager.incBytecodes(3);
                            this.next = TreeMap.successor(entry2);
                            BytecodeManager.incBytecodes(1);
                            this.lastReturned = next;
                            BytecodeManager.incBytecodes(3);
                            final TreeMap.Entry<K, V> entry3 = next;
                            BytecodeManager.incBytecodes(2);
                            return entry3;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex2 = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            final TreeMap.Entry<K, V> prevEntry() {
                try {
                    final TreeMap.Entry<K, V> next = this.next;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap.Entry<K, V> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry != null) {
                        final K key = next.key;
                        final Object fenceKey = this.fenceKey;
                        BytecodeManager.incBytecodes(5);
                        if (key != fenceKey) {
                            final TreeMap<K, V> m = NavigableSubMap.this.m;
                            BytecodeManager.incBytecodes(4);
                            final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)m);
                            final int expectedModCount = this.expectedModCount;
                            BytecodeManager.incBytecodes(3);
                            if (access$100 != expectedModCount) {
                                BytecodeManager.incBytecodes(3);
                                final ConcurrentModificationException ex = new ConcurrentModificationException();
                                BytecodeManager.incBytecodes(1);
                                throw ex;
                            }
                            final TreeMap.Entry<K, V> entry2 = next;
                            BytecodeManager.incBytecodes(3);
                            this.next = TreeMap.predecessor(entry2);
                            BytecodeManager.incBytecodes(1);
                            this.lastReturned = next;
                            BytecodeManager.incBytecodes(3);
                            final TreeMap.Entry<K, V> entry3 = next;
                            BytecodeManager.incBytecodes(2);
                            return entry3;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex2 = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            final void removeAscending() {
                try {
                    final TreeMap.Entry<K, V> lastReturned = this.lastReturned;
                    BytecodeManager.incBytecodes(3);
                    if (lastReturned == null) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final TreeMap<K, V> m = NavigableSubMap.this.m;
                    BytecodeManager.incBytecodes(4);
                    final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)m);
                    final int expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                    if (access$100 != expectedModCount) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final TreeMap.Entry<K, V> left = this.lastReturned.left;
                    BytecodeManager.incBytecodes(4);
                    if (left != null) {
                        final TreeMap.Entry<K, V> right = this.lastReturned.right;
                        BytecodeManager.incBytecodes(4);
                        if (right != null) {
                            this.next = this.lastReturned;
                            BytecodeManager.incBytecodes(4);
                        }
                    }
                    final TreeMap<K, V> i = NavigableSubMap.this.m;
                    final TreeMap.Entry<K, V> lastReturned2 = this.lastReturned;
                    BytecodeManager.incBytecodes(6);
                    TreeMap.access$000((TreeMap<Object, Object>)i, lastReturned2);
                    this.lastReturned = null;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap<K, V> j = NavigableSubMap.this.m;
                    BytecodeManager.incBytecodes(5);
                    this.expectedModCount = TreeMap.access$100((TreeMap<Object, Object>)j);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            final void removeDescending() {
                try {
                    final TreeMap.Entry<K, V> lastReturned = this.lastReturned;
                    BytecodeManager.incBytecodes(3);
                    if (lastReturned == null) {
                        BytecodeManager.incBytecodes(3);
                        final IllegalStateException ex = new IllegalStateException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final TreeMap<K, V> m = NavigableSubMap.this.m;
                    BytecodeManager.incBytecodes(4);
                    final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)m);
                    final int expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                    if (access$100 != expectedModCount) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final TreeMap<K, V> i = NavigableSubMap.this.m;
                    final TreeMap.Entry<K, V> lastReturned2 = this.lastReturned;
                    BytecodeManager.incBytecodes(6);
                    TreeMap.access$000((TreeMap<Object, Object>)i, lastReturned2);
                    this.lastReturned = null;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap<K, V> j = NavigableSubMap.this.m;
                    BytecodeManager.incBytecodes(5);
                    this.expectedModCount = TreeMap.access$100((TreeMap<Object, Object>)j);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class SubMapEntryIterator extends SubMapIterator<Map.Entry<K, V>>
        {
            SubMapEntryIterator(final TreeMap.Entry<K, V> entry, final TreeMap.Entry<K, V> entry2) {
                try {
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    super(entry, entry2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Map.Entry<K, V> next() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> nextEntry = this.nextEntry();
                    BytecodeManager.incBytecodes(1);
                    return nextEntry;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void remove() {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.removeAscending();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class DescendingSubMapEntryIterator extends SubMapIterator<Map.Entry<K, V>>
        {
            DescendingSubMapEntryIterator(final TreeMap.Entry<K, V> entry, final TreeMap.Entry<K, V> entry2) {
                try {
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    super(entry, entry2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Map.Entry<K, V> next() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final TreeMap.Entry<K, V> prevEntry = this.prevEntry();
                    BytecodeManager.incBytecodes(1);
                    return prevEntry;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void remove() {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.removeDescending();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class SubMapKeyIterator extends SubMapIterator<K> implements Spliterator<K>
        {
            SubMapKeyIterator(final TreeMap.Entry<K, V> entry, final TreeMap.Entry<K, V> entry2) {
                try {
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    super(entry, entry2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public K next() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final K key = this.nextEntry().key;
                    BytecodeManager.incBytecodes(2);
                    return key;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void remove() {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.removeAscending();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<K> trySplit() {
                try {
                    final Spliterator<K> spliterator = null;
                    BytecodeManager.incBytecodes(2);
                    return spliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final Consumer<? super K> consumer) {
                try {
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = this.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final Consumer<? super K> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
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
            
            @Override
            public long estimateSize() {
                try {
                    final long n = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 21;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public final Comparator<? super K> getComparator() {
                try {
                    final NavigableSubMap this$0 = NavigableSubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final Comparator<? super Object> comparator = this$0.comparator();
                    BytecodeManager.incBytecodes(1);
                    return comparator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
        
        final class DescendingSubMapKeyIterator extends SubMapIterator<K> implements Spliterator<K>
        {
            DescendingSubMapKeyIterator(final TreeMap.Entry<K, V> entry, final TreeMap.Entry<K, V> entry2) {
                try {
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(5);
                    super(entry, entry2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public K next() {
                try {
                    BytecodeManager.incBytecodes(2);
                    final K key = this.prevEntry().key;
                    BytecodeManager.incBytecodes(2);
                    return key;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void remove() {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.removeDescending();
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Spliterator<K> trySplit() {
                try {
                    final Spliterator<K> spliterator = null;
                    BytecodeManager.incBytecodes(2);
                    return spliterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public void forEachRemaining(final Consumer<? super K> consumer) {
                try {
                    while (true) {
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = this.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public boolean tryAdvance(final Consumer<? super K> consumer) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (hasNext) {
                        BytecodeManager.incBytecodes(3);
                        final Object next = this.next();
                        BytecodeManager.incBytecodes(1);
                        consumer.accept((Object)next);
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
            
            @Override
            public long estimateSize() {
                try {
                    final long n = Long.MAX_VALUE;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public int characteristics() {
                try {
                    final int n = 17;
                    BytecodeManager.incBytecodes(2);
                    return n;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class AscendingSubMap<K, V> extends NavigableSubMap<K, V>
    {
        private static final long serialVersionUID = 912986545866124060L;
        
        AscendingSubMap(final TreeMap<K, V> treeMap, final boolean b, final K k, final boolean b2, final boolean b3, final K i, final boolean b4) {
            try {
                BytecodeManager.incBytecodes(9);
                super(treeMap, b, k, b2, b3, i, b4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                final Comparator<? super K> comparator = m.comparator();
                BytecodeManager.incBytecodes(1);
                return comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "fromKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(4);
                final boolean inRange2 = this.inRange(i, b2);
                BytecodeManager.incBytecodes(1);
                if (!inRange2) {
                    final String s2 = "toKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final TreeMap<K, V> m = this.m;
                final boolean b3 = false;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(11);
                final AscendingSubMap ascendingSubMap = new AscendingSubMap((TreeMap<Object, Object>)m, b3, k, b, b4, i, b2);
                BytecodeManager.incBytecodes(1);
                return ascendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "toKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap<K, V> m = this.m;
                final boolean fromStart = this.fromStart;
                final K lo = this.lo;
                final boolean loInclusive = this.loInclusive;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(14);
                final AscendingSubMap ascendingSubMap = new AscendingSubMap((TreeMap<Object, Object>)m, fromStart, lo, loInclusive, b2, k, b);
                BytecodeManager.incBytecodes(1);
                return ascendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "fromKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap<K, V> m = this.m;
                final boolean b2 = false;
                final boolean toEnd = this.toEnd;
                final K hi = this.hi;
                final boolean hiInclusive = this.hiInclusive;
                BytecodeManager.incBytecodes(14);
                final AscendingSubMap ascendingSubMap = new AscendingSubMap((TreeMap<Object, Object>)m, b2, k, b, toEnd, hi, hiInclusive);
                BytecodeManager.incBytecodes(1);
                return ascendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> descendingMap() {
            try {
                final NavigableMap<K, V> descendingMapView = this.descendingMapView;
                BytecodeManager.incBytecodes(3);
                final NavigableMap<K, V> navigableMap = descendingMapView;
                BytecodeManager.incBytecodes(2);
                NavigableMap<K, V> navigableMap2;
                if (navigableMap != null) {
                    navigableMap2 = descendingMapView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TreeMap<K, V> m;
                    final boolean fromStart;
                    final K lo;
                    final boolean loInclusive;
                    final boolean toEnd;
                    final K hi;
                    final boolean hiInclusive;
                    final DescendingSubMap<K, V> descendingMapView2 = (DescendingSubMap<K, V>)(navigableMap2 = new DescendingSubMap<K, V>((TreeMap<Object, Object>)m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive));
                    m = this.m;
                    fromStart = this.fromStart;
                    lo = this.lo;
                    loInclusive = this.loInclusive;
                    toEnd = this.toEnd;
                    hi = this.hi;
                    hiInclusive = this.hiInclusive;
                    BytecodeManager.incBytecodes(18);
                    this.descendingMapView = descendingMapView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return navigableMap2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Iterator<K> keyIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absLowest = this.absLowest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absHighFence = this.absHighFence();
                BytecodeManager.incBytecodes(1);
                final SubMapKeyIterator subMapKeyIterator = new SubMapKeyIterator((TreeMap.Entry<K, V>)absLowest, (TreeMap.Entry<K, V>)absHighFence);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)subMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Spliterator<K> keySpliterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absLowest = this.absLowest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absHighFence = this.absHighFence();
                BytecodeManager.incBytecodes(1);
                final SubMapKeyIterator subMapKeyIterator = new SubMapKeyIterator((TreeMap.Entry<K, V>)absLowest, (TreeMap.Entry<K, V>)absHighFence);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)subMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Iterator<K> descendingKeyIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absHighest = this.absHighest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absLowFence = this.absLowFence();
                BytecodeManager.incBytecodes(1);
                final DescendingSubMapKeyIterator descendingSubMapKeyIterator = new DescendingSubMapKeyIterator((TreeMap.Entry<K, V>)absHighest, (TreeMap.Entry<K, V>)absLowFence);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)descendingSubMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                final EntrySetView entrySetView = this.entrySetView;
                BytecodeManager.incBytecodes(3);
                final EntrySetView entrySetView2 = entrySetView;
                BytecodeManager.incBytecodes(2);
                EntrySetView entrySetView3;
                if (entrySetView2 != null) {
                    entrySetView3 = entrySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final AscendingEntrySetView entrySetView4 = (AscendingEntrySetView)(entrySetView3 = new AscendingEntrySetView());
                    BytecodeManager.incBytecodes(5);
                    this.entrySetView = entrySetView4;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return (Set<Map.Entry<K, V>>)entrySetView3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subLowest() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absLowest = this.absLowest();
                BytecodeManager.incBytecodes(1);
                return absLowest;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subHighest() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absHighest = this.absHighest();
                BytecodeManager.incBytecodes(1);
                return absHighest;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subCeiling(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absCeiling = this.absCeiling(k);
                BytecodeManager.incBytecodes(1);
                return absCeiling;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subHigher(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absHigher = this.absHigher(k);
                BytecodeManager.incBytecodes(1);
                return absHigher;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subFloor(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absFloor = this.absFloor(k);
                BytecodeManager.incBytecodes(1);
                return absFloor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subLower(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absLower = this.absLower(k);
                BytecodeManager.incBytecodes(1);
                return absLower;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final class AscendingEntrySetView extends EntrySetView
        {
            AscendingEntrySetView() {
                try {
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                try {
                    final AscendingSubMap this$0 = AscendingSubMap.this;
                    final AscendingSubMap this$2 = AscendingSubMap.this;
                    BytecodeManager.incBytecodes(7);
                    final TreeMap.Entry<Object, Object> absLowest = this$2.absLowest();
                    final AscendingSubMap this$3 = AscendingSubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap.Entry<Object, Object> absHighFence = this$3.absHighFence();
                    BytecodeManager.incBytecodes(1);
                    final SubMapEntryIterator subMapEntryIterator = new SubMapEntryIterator((TreeMap.Entry<K, V>)absLowest, (TreeMap.Entry<K, V>)absHighFence);
                    BytecodeManager.incBytecodes(1);
                    return (Iterator<Map.Entry<K, V>>)subMapEntryIterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    static final class DescendingSubMap<K, V> extends NavigableSubMap<K, V>
    {
        private static final long serialVersionUID = 912986545866120460L;
        private final Comparator<? super K> reverseComparator;
        
        DescendingSubMap(final TreeMap<K, V> treeMap, final boolean b, final K k, final boolean b2, final boolean b3, final K i, final boolean b4) {
            try {
                BytecodeManager.incBytecodes(9);
                super(treeMap, b, k, b2, b3, i, b4);
                final TreeMap<K, V> m = this.m;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Comparator access$300 = TreeMap.access$300((TreeMap<Object, Object>)m);
                BytecodeManager.incBytecodes(1);
                this.reverseComparator = Collections.reverseOrder((Comparator<? super K>)access$300);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                final Comparator<? super K> reverseComparator = this.reverseComparator;
                BytecodeManager.incBytecodes(3);
                return reverseComparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "fromKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(4);
                final boolean inRange2 = this.inRange(i, b2);
                BytecodeManager.incBytecodes(1);
                if (!inRange2) {
                    final String s2 = "toKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final TreeMap<K, V> m = this.m;
                final boolean b3 = false;
                final boolean b4 = false;
                BytecodeManager.incBytecodes(11);
                final DescendingSubMap descendingSubMap = new DescendingSubMap((TreeMap<Object, Object>)m, b3, i, b2, b4, k, b);
                BytecodeManager.incBytecodes(1);
                return descendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> headMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "toKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap<K, V> m = this.m;
                final boolean b2 = false;
                final boolean toEnd = this.toEnd;
                final K hi = this.hi;
                final boolean hiInclusive = this.hiInclusive;
                BytecodeManager.incBytecodes(14);
                final DescendingSubMap descendingSubMap = new DescendingSubMap((TreeMap<Object, Object>)m, b2, k, b, toEnd, hi, hiInclusive);
                BytecodeManager.incBytecodes(1);
                return descendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> tailMap(final K k, final boolean b) {
            try {
                BytecodeManager.incBytecodes(4);
                final boolean inRange = this.inRange(k, b);
                BytecodeManager.incBytecodes(1);
                if (!inRange) {
                    final String s = "fromKey out of range";
                    BytecodeManager.incBytecodes(4);
                    final IllegalArgumentException ex = new IllegalArgumentException(s);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final TreeMap<K, V> m = this.m;
                final boolean fromStart = this.fromStart;
                final K lo = this.lo;
                final boolean loInclusive = this.loInclusive;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(14);
                final DescendingSubMap descendingSubMap = new DescendingSubMap((TreeMap<Object, Object>)m, fromStart, lo, loInclusive, b2, k, b);
                BytecodeManager.incBytecodes(1);
                return descendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public NavigableMap<K, V> descendingMap() {
            try {
                final NavigableMap<K, V> descendingMapView = this.descendingMapView;
                BytecodeManager.incBytecodes(3);
                final NavigableMap<K, V> navigableMap = descendingMapView;
                BytecodeManager.incBytecodes(2);
                NavigableMap<K, V> navigableMap2;
                if (navigableMap != null) {
                    navigableMap2 = descendingMapView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final TreeMap<K, V> m;
                    final boolean fromStart;
                    final K lo;
                    final boolean loInclusive;
                    final boolean toEnd;
                    final K hi;
                    final boolean hiInclusive;
                    final AscendingSubMap<K, V> descendingMapView2 = (AscendingSubMap<K, V>)(navigableMap2 = new AscendingSubMap<K, V>((TreeMap<Object, Object>)m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive));
                    m = this.m;
                    fromStart = this.fromStart;
                    lo = this.lo;
                    loInclusive = this.loInclusive;
                    toEnd = this.toEnd;
                    hi = this.hi;
                    hiInclusive = this.hiInclusive;
                    BytecodeManager.incBytecodes(18);
                    this.descendingMapView = descendingMapView2;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return navigableMap2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Iterator<K> keyIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absHighest = this.absHighest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absLowFence = this.absLowFence();
                BytecodeManager.incBytecodes(1);
                final DescendingSubMapKeyIterator descendingSubMapKeyIterator = new DescendingSubMapKeyIterator((TreeMap.Entry<K, V>)absHighest, (TreeMap.Entry<K, V>)absLowFence);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)descendingSubMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Spliterator<K> keySpliterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absHighest = this.absHighest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absLowFence = this.absLowFence();
                BytecodeManager.incBytecodes(1);
                final DescendingSubMapKeyIterator descendingSubMapKeyIterator = new DescendingSubMapKeyIterator((TreeMap.Entry<K, V>)absHighest, (TreeMap.Entry<K, V>)absLowFence);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)descendingSubMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        Iterator<K> descendingKeyIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                final TreeMap.Entry<K, V> absLowest = this.absLowest();
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absHighFence = this.absHighFence();
                BytecodeManager.incBytecodes(1);
                final SubMapKeyIterator subMapKeyIterator = new SubMapKeyIterator((TreeMap.Entry<K, V>)absLowest, (TreeMap.Entry<K, V>)absHighFence);
                BytecodeManager.incBytecodes(1);
                return (Iterator<K>)subMapKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                final EntrySetView entrySetView = this.entrySetView;
                BytecodeManager.incBytecodes(3);
                final EntrySetView entrySetView2 = entrySetView;
                BytecodeManager.incBytecodes(2);
                EntrySetView entrySetView3;
                if (entrySetView2 != null) {
                    entrySetView3 = entrySetView;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final DescendingEntrySetView entrySetView4 = (DescendingEntrySetView)(entrySetView3 = new DescendingEntrySetView());
                    BytecodeManager.incBytecodes(5);
                    this.entrySetView = entrySetView4;
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
                return (Set<Map.Entry<K, V>>)entrySetView3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subLowest() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absHighest = this.absHighest();
                BytecodeManager.incBytecodes(1);
                return absHighest;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subHighest() {
            try {
                BytecodeManager.incBytecodes(2);
                final TreeMap.Entry<K, V> absLowest = this.absLowest();
                BytecodeManager.incBytecodes(1);
                return absLowest;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subCeiling(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absFloor = this.absFloor(k);
                BytecodeManager.incBytecodes(1);
                return absFloor;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subHigher(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absLower = this.absLower(k);
                BytecodeManager.incBytecodes(1);
                return absLower;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subFloor(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absCeiling = this.absCeiling(k);
                BytecodeManager.incBytecodes(1);
                return absCeiling;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        TreeMap.Entry<K, V> subLower(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final TreeMap.Entry<K, V> absHigher = this.absHigher(k);
                BytecodeManager.incBytecodes(1);
                return absHigher;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final class DescendingEntrySetView extends EntrySetView
        {
            DescendingEntrySetView() {
                try {
                    BytecodeManager.incBytecodes(6);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                try {
                    final DescendingSubMap this$0 = DescendingSubMap.this;
                    final DescendingSubMap this$2 = DescendingSubMap.this;
                    BytecodeManager.incBytecodes(7);
                    final TreeMap.Entry<Object, Object> absHighest = this$2.absHighest();
                    final DescendingSubMap this$3 = DescendingSubMap.this;
                    BytecodeManager.incBytecodes(3);
                    final TreeMap.Entry<Object, Object> absLowFence = this$3.absLowFence();
                    BytecodeManager.incBytecodes(1);
                    final DescendingSubMapEntryIterator descendingSubMapEntryIterator = new DescendingSubMapEntryIterator((TreeMap.Entry<K, V>)absHighest, (TreeMap.Entry<K, V>)absLowFence);
                    BytecodeManager.incBytecodes(1);
                    return (Iterator<Map.Entry<K, V>>)descendingSubMapEntryIterator;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private class SubMap extends AbstractMap<K, V> implements SortedMap<K, V>, Serializable
    {
        private static final long serialVersionUID = -6520786458950516097L;
        private boolean fromStart;
        private boolean toEnd;
        private K fromKey;
        private K toKey;
        
        private SubMap() {
            try {
                BytecodeManager.incBytecodes(5);
                this.fromStart = false;
                this.toEnd = false;
                BytecodeManager.incBytecodes(7);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Object readResolve() {
            try {
                final TreeMap this$0 = TreeMap.this;
                final boolean fromStart = this.fromStart;
                final K fromKey = this.fromKey;
                final boolean b = true;
                final boolean toEnd = this.toEnd;
                final K toKey = this.toKey;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(15);
                final AscendingSubMap ascendingSubMap = new AscendingSubMap(this$0, fromStart, fromKey, b, toEnd, toKey, b2);
                BytecodeManager.incBytecodes(1);
                return ascendingSubMap;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K lastKey() {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K firstKey() {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> subMap(final K k, final K i) {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> headMap(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public SortedMap<K, V> tailMap(final K k) {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<? super K> comparator() {
            try {
                BytecodeManager.incBytecodes(3);
                final InternalError internalError = new InternalError();
                BytecodeManager.incBytecodes(1);
                throw internalError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class Entry<K, V> implements Map.Entry<K, V>
    {
        K key;
        V value;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;
        boolean color;
        
        Entry(final K key, final V value, final Entry<K, V> parent) {
            try {
                BytecodeManager.incBytecodes(2);
                this.color = true;
                BytecodeManager.incBytecodes(3);
                this.key = key;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                this.parent = parent;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public K getKey() {
            try {
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V getValue() {
            try {
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public V setValue(final V value) {
            try {
                final V value2 = this.value;
                BytecodeManager.incBytecodes(3);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                final V v = value2;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final K key = this.key;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key2 = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final boolean valEquals = TreeMap.valEquals(key, key2);
                BytecodeManager.incBytecodes(1);
                boolean b3 = false;
                Label_0106: {
                    if (valEquals) {
                        final V value = this.value;
                        final Map.Entry entry3 = entry;
                        BytecodeManager.incBytecodes(4);
                        final Object value2 = entry3.getValue();
                        BytecodeManager.incBytecodes(1);
                        final boolean valEquals2 = TreeMap.valEquals(value, value2);
                        BytecodeManager.incBytecodes(1);
                        if (valEquals2) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0106;
                        }
                    }
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
        public int hashCode() {
            try {
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                int hashCode;
                if (key == null) {
                    hashCode = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final K key2 = this.key;
                    BytecodeManager.incBytecodes(3);
                    hashCode = key2.hashCode();
                }
                final int n = hashCode;
                BytecodeManager.incBytecodes(1);
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                int hashCode2;
                if (value == null) {
                    hashCode2 = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final V value2 = this.value;
                    BytecodeManager.incBytecodes(3);
                    hashCode2 = value2.hashCode();
                }
                final int n2 = hashCode2;
                BytecodeManager.incBytecodes(1);
                final int n3 = n ^ n2;
                BytecodeManager.incBytecodes(4);
                return n3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb = new StringBuilder();
                final K key = this.key;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append = sb.append(key);
                final String str = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                final V value = this.value;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append3 = append2.append(value);
                BytecodeManager.incBytecodes(1);
                final String string = append3.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class TreeMapSpliterator<K, V>
    {
        final TreeMap<K, V> tree;
        Entry<K, V> current;
        Entry<K, V> fence;
        int side;
        int est;
        int expectedModCount;
        
        TreeMapSpliterator(final TreeMap<K, V> tree, final Entry<K, V> current, final Entry<K, V> fence, final int side, final int est, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.tree = tree;
                BytecodeManager.incBytecodes(3);
                this.current = current;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
                BytecodeManager.incBytecodes(3);
                this.side = side;
                BytecodeManager.incBytecodes(3);
                this.est = est;
                BytecodeManager.incBytecodes(3);
                this.expectedModCount = expectedModCount;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final int getEstimate() {
            try {
                int est;
                final int n = est = this.est;
                BytecodeManager.incBytecodes(5);
                if (n < 0) {
                    final TreeMap<K, V> tree;
                    final TreeMap<K, V> treeMap = tree = this.tree;
                    BytecodeManager.incBytecodes(5);
                    if (treeMap != null) {
                        final int n2 = est;
                        final int n3 = -1;
                        BytecodeManager.incBytecodes(4);
                        Entry<K, V> current;
                        if (n2 == n3) {
                            final TreeMap<K, V> treeMap2 = tree;
                            BytecodeManager.incBytecodes(2);
                            current = treeMap2.getFirstEntry();
                            BytecodeManager.incBytecodes(1);
                        }
                        else {
                            final TreeMap<K, V> treeMap3 = tree;
                            BytecodeManager.incBytecodes(2);
                            current = treeMap3.getLastEntry();
                        }
                        this.current = current;
                        BytecodeManager.incBytecodes(1);
                        final TreeMap<Object, Object> treeMap4 = (TreeMap<Object, Object>)tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$400 = TreeMap.access$400(treeMap4);
                        this.est = access$400;
                        est = access$400;
                        BytecodeManager.incBytecodes(3);
                        final TreeMap<K, V> treeMap5 = tree;
                        BytecodeManager.incBytecodes(3);
                        this.expectedModCount = TreeMap.access$100((TreeMap<Object, Object>)treeMap5);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final int est2 = 0;
                        this.est = est2;
                        est = est2;
                        BytecodeManager.incBytecodes(5);
                    }
                }
                final int n4 = est;
                BytecodeManager.incBytecodes(2);
                return n4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                final long n = this.getEstimate();
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<K>
    {
        KeySpliterator(final TreeMap<K, V> treeMap, final Entry<K, V> entry, final Entry<K, V> entry2, final int n, final int n2, final int n3) {
            try {
                BytecodeManager.incBytecodes(8);
                super(treeMap, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public KeySpliterator<K, V> trySplit() {
            try {
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> current = this.current;
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final Entry<K, V> entry = current;
                BytecodeManager.incBytecodes(2);
                Entry<K, V> entry4 = null;
                Label_0171: {
                    if (entry != null) {
                        final Entry<K, V> entry2 = current;
                        final Entry<K, V> entry3 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry2 != entry3) {
                            final int n = side;
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final TreeMap<K, V> tree = this.tree;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                entry4 = (Entry<K, V>)TreeMap.access$500((TreeMap<Object, Object>)tree);
                                BytecodeManager.incBytecodes(1);
                                break Label_0171;
                            }
                            final int n2 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n2 > 0) {
                                entry4 = current.right;
                                BytecodeManager.incBytecodes(3);
                                break Label_0171;
                            }
                            final int n3 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n3 < 0) {
                                final Entry<K, V> entry5 = fence;
                                BytecodeManager.incBytecodes(2);
                                if (entry5 != null) {
                                    entry4 = fence.left;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0171;
                                }
                            }
                            entry4 = null;
                            BytecodeManager.incBytecodes(1);
                            break Label_0171;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                final Entry<K, V> entry6 = entry4;
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry7 = entry6;
                BytecodeManager.incBytecodes(2);
                if (entry7 != null) {
                    final Entry<K, V> entry8 = entry6;
                    final Entry<K, V> entry9 = current;
                    BytecodeManager.incBytecodes(3);
                    if (entry8 != entry9) {
                        final Entry<K, V> entry10 = entry6;
                        final Entry<K, V> entry11 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry10 != entry11) {
                            final TreeMap<K, V> tree2 = this.tree;
                            final K key = current.key;
                            final K key2 = entry6.key;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final int compare = tree2.compare(key, key2);
                            BytecodeManager.incBytecodes(1);
                            if (compare < 0) {
                                this.side = 1;
                                BytecodeManager.incBytecodes(3);
                                final TreeMap<K, V> tree3 = this.tree;
                                final Entry<Object, Object> entry12 = (Entry<Object, Object>)current;
                                final Entry<Object, Object> current2 = (Entry<Object, Object>)entry6;
                                this.current = (Entry<K, V>)current2;
                                final int n4 = -1;
                                final int est2 = this.est >>> 1;
                                this.est = est2;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(20);
                                final KeySpliterator keySpliterator = new KeySpliterator<K, V>((TreeMap<Object, Object>)tree3, entry12, current2, n4, est2, expectedModCount);
                                BytecodeManager.incBytecodes(1);
                                return keySpliterator;
                            }
                        }
                    }
                }
                final KeySpliterator<K, V> keySpliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return keySpliterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> entry3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (entry2 != entry3) {
                        this.current = fence;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry4;
                        Entry<K, V> entry5;
                        do {
                            final K key = current.key;
                            BytecodeManager.incBytecodes(4);
                            consumer.accept(key);
                            Entry<K, V> entry7;
                            final Entry<K, V> entry6 = entry7 = current.right;
                            BytecodeManager.incBytecodes(5);
                            if (entry6 != null) {
                                while (true) {
                                    final Entry<K, V> left = entry7.left;
                                    BytecodeManager.incBytecodes(5);
                                    if (left == null) {
                                        break;
                                    }
                                    entry7 = left;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            else {
                                while (true) {
                                    final Entry<K, V> entry8 = entry7 = current.parent;
                                    BytecodeManager.incBytecodes(5);
                                    if (entry8 == null) {
                                        break;
                                    }
                                    final Entry<K, V> entry9 = current;
                                    final Entry<K, V> right = entry7.right;
                                    BytecodeManager.incBytecodes(4);
                                    if (entry9 != right) {
                                        break;
                                    }
                                    current = entry7;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            final Entry<K, V> entry10 = current = entry7;
                            BytecodeManager.incBytecodes(4);
                            if (entry10 == null) {
                                break;
                            }
                            entry4 = current;
                            entry5 = fence;
                            BytecodeManager.incBytecodes(3);
                        } while (entry4 != entry5);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> fence = this.fence;
                    BytecodeManager.incBytecodes(4);
                    if (entry2 != fence) {
                        final Entry<K, V> entry3 = current;
                        BytecodeManager.incBytecodes(3);
                        this.current = (Entry<K, V>)TreeMap.successor((Entry<K, V>)entry3);
                        BytecodeManager.incBytecodes(1);
                        final K key = current.key;
                        BytecodeManager.incBytecodes(4);
                        consumer.accept(key);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                int n;
                if (side == 0) {
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n2 = n | 0x1 | 0x4 | 0x10;
                BytecodeManager.incBytecodes(7);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Comparator<? super K> getComparator() {
            try {
                final TreeMap<K, V> tree = this.tree;
                BytecodeManager.incBytecodes(3);
                final Comparator access$300 = TreeMap.access$300((TreeMap<Object, Object>)tree);
                BytecodeManager.incBytecodes(1);
                return (Comparator<? super K>)access$300;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class DescendingKeySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<K>
    {
        DescendingKeySpliterator(final TreeMap<K, V> treeMap, final Entry<K, V> entry, final Entry<K, V> entry2, final int n, final int n2, final int n3) {
            try {
                BytecodeManager.incBytecodes(8);
                super(treeMap, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public DescendingKeySpliterator<K, V> trySplit() {
            try {
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> current = this.current;
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final Entry<K, V> entry = current;
                BytecodeManager.incBytecodes(2);
                Entry<K, V> entry4 = null;
                Label_0171: {
                    if (entry != null) {
                        final Entry<K, V> entry2 = current;
                        final Entry<K, V> entry3 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry2 != entry3) {
                            final int n = side;
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final TreeMap<K, V> tree = this.tree;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                entry4 = (Entry<K, V>)TreeMap.access$500((TreeMap<Object, Object>)tree);
                                BytecodeManager.incBytecodes(1);
                                break Label_0171;
                            }
                            final int n2 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n2 < 0) {
                                entry4 = current.left;
                                BytecodeManager.incBytecodes(3);
                                break Label_0171;
                            }
                            final int n3 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n3 > 0) {
                                final Entry<K, V> entry5 = fence;
                                BytecodeManager.incBytecodes(2);
                                if (entry5 != null) {
                                    entry4 = fence.right;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0171;
                                }
                            }
                            entry4 = null;
                            BytecodeManager.incBytecodes(1);
                            break Label_0171;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                final Entry<K, V> entry6 = entry4;
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry7 = entry6;
                BytecodeManager.incBytecodes(2);
                if (entry7 != null) {
                    final Entry<K, V> entry8 = entry6;
                    final Entry<K, V> entry9 = current;
                    BytecodeManager.incBytecodes(3);
                    if (entry8 != entry9) {
                        final Entry<K, V> entry10 = entry6;
                        final Entry<K, V> entry11 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry10 != entry11) {
                            final TreeMap<K, V> tree2 = this.tree;
                            final K key = current.key;
                            final K key2 = entry6.key;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final int compare = tree2.compare(key, key2);
                            BytecodeManager.incBytecodes(1);
                            if (compare > 0) {
                                this.side = 1;
                                BytecodeManager.incBytecodes(3);
                                final TreeMap<K, V> tree3 = this.tree;
                                final Entry<Object, Object> entry12 = (Entry<Object, Object>)current;
                                final Entry<Object, Object> current2 = (Entry<Object, Object>)entry6;
                                this.current = (Entry<K, V>)current2;
                                final int n4 = -1;
                                final int est2 = this.est >>> 1;
                                this.est = est2;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(20);
                                final DescendingKeySpliterator descendingKeySpliterator = new DescendingKeySpliterator<K, V>((TreeMap<Object, Object>)tree3, entry12, current2, n4, est2, expectedModCount);
                                BytecodeManager.incBytecodes(1);
                                return descendingKeySpliterator;
                            }
                        }
                    }
                }
                final DescendingKeySpliterator<K, V> descendingKeySpliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return descendingKeySpliterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> entry3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (entry2 != entry3) {
                        this.current = fence;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry4;
                        Entry<K, V> entry5;
                        do {
                            final K key = current.key;
                            BytecodeManager.incBytecodes(4);
                            consumer.accept(key);
                            Entry<K, V> entry7;
                            final Entry<K, V> entry6 = entry7 = current.left;
                            BytecodeManager.incBytecodes(5);
                            if (entry6 != null) {
                                while (true) {
                                    final Entry<K, V> right = entry7.right;
                                    BytecodeManager.incBytecodes(5);
                                    if (right == null) {
                                        break;
                                    }
                                    entry7 = right;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            else {
                                while (true) {
                                    final Entry<K, V> entry8 = entry7 = current.parent;
                                    BytecodeManager.incBytecodes(5);
                                    if (entry8 == null) {
                                        break;
                                    }
                                    final Entry<K, V> entry9 = current;
                                    final Entry<K, V> left = entry7.left;
                                    BytecodeManager.incBytecodes(4);
                                    if (entry9 != left) {
                                        break;
                                    }
                                    current = entry7;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            final Entry<K, V> entry10 = current = entry7;
                            BytecodeManager.incBytecodes(4);
                            if (entry10 == null) {
                                break;
                            }
                            entry4 = current;
                            entry5 = fence;
                            BytecodeManager.incBytecodes(3);
                        } while (entry4 != entry5);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> fence = this.fence;
                    BytecodeManager.incBytecodes(4);
                    if (entry2 != fence) {
                        final Entry<K, V> entry3 = current;
                        BytecodeManager.incBytecodes(3);
                        this.current = (Entry<K, V>)TreeMap.predecessor((Entry<K, V>)entry3);
                        BytecodeManager.incBytecodes(1);
                        final K key = current.key;
                        BytecodeManager.incBytecodes(4);
                        consumer.accept(key);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                int n;
                if (side == 0) {
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n2 = n | 0x1 | 0x10;
                BytecodeManager.incBytecodes(5);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueSpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<V>
    {
        ValueSpliterator(final TreeMap<K, V> treeMap, final Entry<K, V> entry, final Entry<K, V> entry2, final int n, final int n2, final int n3) {
            try {
                BytecodeManager.incBytecodes(8);
                super(treeMap, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ValueSpliterator<K, V> trySplit() {
            try {
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> current = this.current;
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final Entry<K, V> entry = current;
                BytecodeManager.incBytecodes(2);
                Entry<K, V> entry4 = null;
                Label_0171: {
                    if (entry != null) {
                        final Entry<K, V> entry2 = current;
                        final Entry<K, V> entry3 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry2 != entry3) {
                            final int n = side;
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final TreeMap<K, V> tree = this.tree;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                entry4 = (Entry<K, V>)TreeMap.access$500((TreeMap<Object, Object>)tree);
                                BytecodeManager.incBytecodes(1);
                                break Label_0171;
                            }
                            final int n2 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n2 > 0) {
                                entry4 = current.right;
                                BytecodeManager.incBytecodes(3);
                                break Label_0171;
                            }
                            final int n3 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n3 < 0) {
                                final Entry<K, V> entry5 = fence;
                                BytecodeManager.incBytecodes(2);
                                if (entry5 != null) {
                                    entry4 = fence.left;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0171;
                                }
                            }
                            entry4 = null;
                            BytecodeManager.incBytecodes(1);
                            break Label_0171;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                final Entry<K, V> entry6 = entry4;
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry7 = entry6;
                BytecodeManager.incBytecodes(2);
                if (entry7 != null) {
                    final Entry<K, V> entry8 = entry6;
                    final Entry<K, V> entry9 = current;
                    BytecodeManager.incBytecodes(3);
                    if (entry8 != entry9) {
                        final Entry<K, V> entry10 = entry6;
                        final Entry<K, V> entry11 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry10 != entry11) {
                            final TreeMap<K, V> tree2 = this.tree;
                            final K key = current.key;
                            final K key2 = entry6.key;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final int compare = tree2.compare(key, key2);
                            BytecodeManager.incBytecodes(1);
                            if (compare < 0) {
                                this.side = 1;
                                BytecodeManager.incBytecodes(3);
                                final TreeMap<K, V> tree3 = this.tree;
                                final Entry<Object, Object> entry12 = (Entry<Object, Object>)current;
                                final Entry<Object, Object> current2 = (Entry<Object, Object>)entry6;
                                this.current = (Entry<K, V>)current2;
                                final int n4 = -1;
                                final int est2 = this.est >>> 1;
                                this.est = est2;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(20);
                                final ValueSpliterator valueSpliterator = new ValueSpliterator<K, V>((TreeMap<Object, Object>)tree3, entry12, current2, n4, est2, expectedModCount);
                                BytecodeManager.incBytecodes(1);
                                return valueSpliterator;
                            }
                        }
                    }
                }
                final ValueSpliterator<K, V> valueSpliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return valueSpliterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> entry3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (entry2 != entry3) {
                        this.current = fence;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry4;
                        Entry<K, V> entry5;
                        do {
                            final V value = current.value;
                            BytecodeManager.incBytecodes(4);
                            consumer.accept(value);
                            Entry<K, V> entry7;
                            final Entry<K, V> entry6 = entry7 = current.right;
                            BytecodeManager.incBytecodes(5);
                            if (entry6 != null) {
                                while (true) {
                                    final Entry<K, V> left = entry7.left;
                                    BytecodeManager.incBytecodes(5);
                                    if (left == null) {
                                        break;
                                    }
                                    entry7 = left;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            else {
                                while (true) {
                                    final Entry<K, V> entry8 = entry7 = current.parent;
                                    BytecodeManager.incBytecodes(5);
                                    if (entry8 == null) {
                                        break;
                                    }
                                    final Entry<K, V> entry9 = current;
                                    final Entry<K, V> right = entry7.right;
                                    BytecodeManager.incBytecodes(4);
                                    if (entry9 != right) {
                                        break;
                                    }
                                    current = entry7;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            final Entry<K, V> entry10 = current = entry7;
                            BytecodeManager.incBytecodes(4);
                            if (entry10 == null) {
                                break;
                            }
                            entry4 = current;
                            entry5 = fence;
                            BytecodeManager.incBytecodes(3);
                        } while (entry4 != entry5);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> fence = this.fence;
                    BytecodeManager.incBytecodes(4);
                    if (entry2 != fence) {
                        final Entry<K, V> entry3 = current;
                        BytecodeManager.incBytecodes(3);
                        this.current = (Entry<K, V>)TreeMap.successor((Entry<K, V>)entry3);
                        BytecodeManager.incBytecodes(1);
                        final V value = current.value;
                        BytecodeManager.incBytecodes(4);
                        consumer.accept(value);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                int n;
                if (side == 0) {
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n2 = n | 0x10;
                BytecodeManager.incBytecodes(3);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>>
    {
        EntrySpliterator(final TreeMap<K, V> treeMap, final Entry<K, V> entry, final Entry<K, V> entry2, final int n, final int n2, final int n3) {
            try {
                BytecodeManager.incBytecodes(8);
                super(treeMap, entry, entry2, n, n2, n3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public EntrySpliterator<K, V> trySplit() {
            try {
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> current = this.current;
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(6);
                final Entry<K, V> entry = current;
                BytecodeManager.incBytecodes(2);
                Entry<K, V> entry4 = null;
                Label_0171: {
                    if (entry != null) {
                        final Entry<K, V> entry2 = current;
                        final Entry<K, V> entry3 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry2 != entry3) {
                            final int n = side;
                            BytecodeManager.incBytecodes(2);
                            if (n == 0) {
                                final TreeMap<K, V> tree = this.tree;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                entry4 = (Entry<K, V>)TreeMap.access$500((TreeMap<Object, Object>)tree);
                                BytecodeManager.incBytecodes(1);
                                break Label_0171;
                            }
                            final int n2 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n2 > 0) {
                                entry4 = current.right;
                                BytecodeManager.incBytecodes(3);
                                break Label_0171;
                            }
                            final int n3 = side;
                            BytecodeManager.incBytecodes(2);
                            if (n3 < 0) {
                                final Entry<K, V> entry5 = fence;
                                BytecodeManager.incBytecodes(2);
                                if (entry5 != null) {
                                    entry4 = fence.left;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0171;
                                }
                            }
                            entry4 = null;
                            BytecodeManager.incBytecodes(1);
                            break Label_0171;
                        }
                    }
                    entry4 = null;
                    BytecodeManager.incBytecodes(2);
                }
                final Entry<K, V> entry6 = entry4;
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry7 = entry6;
                BytecodeManager.incBytecodes(2);
                if (entry7 != null) {
                    final Entry<K, V> entry8 = entry6;
                    final Entry<K, V> entry9 = current;
                    BytecodeManager.incBytecodes(3);
                    if (entry8 != entry9) {
                        final Entry<K, V> entry10 = entry6;
                        final Entry<K, V> entry11 = fence;
                        BytecodeManager.incBytecodes(3);
                        if (entry10 != entry11) {
                            final TreeMap<K, V> tree2 = this.tree;
                            final K key = current.key;
                            final K key2 = entry6.key;
                            BytecodeManager.incBytecodes(6);
                            BytecodeManager.incBytecodes(1);
                            final int compare = tree2.compare(key, key2);
                            BytecodeManager.incBytecodes(1);
                            if (compare < 0) {
                                this.side = 1;
                                BytecodeManager.incBytecodes(3);
                                final TreeMap<K, V> tree3 = this.tree;
                                final Entry<Object, Object> entry12 = (Entry<Object, Object>)current;
                                final Entry<Object, Object> current2 = (Entry<Object, Object>)entry6;
                                this.current = (Entry<K, V>)current2;
                                final int n4 = -1;
                                final int est2 = this.est >>> 1;
                                this.est = est2;
                                final int expectedModCount = this.expectedModCount;
                                BytecodeManager.incBytecodes(20);
                                final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>((TreeMap<Object, Object>)tree3, entry12, current2, n4, est2, expectedModCount);
                                BytecodeManager.incBytecodes(1);
                                return entrySpliterator;
                            }
                        }
                    }
                }
                final EntrySpliterator<K, V> entrySpliterator2 = null;
                BytecodeManager.incBytecodes(2);
                return entrySpliterator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void forEachRemaining(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> fence = this.fence;
                BytecodeManager.incBytecodes(3);
                Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> entry3 = fence;
                    BytecodeManager.incBytecodes(3);
                    if (entry2 != entry3) {
                        this.current = fence;
                        BytecodeManager.incBytecodes(3);
                        Entry<K, V> entry4;
                        Entry<K, V> entry5;
                        do {
                            final Entry<K, V> entry6 = current;
                            BytecodeManager.incBytecodes(3);
                            consumer.accept(entry6);
                            Entry<K, V> entry8;
                            final Entry<K, V> entry7 = entry8 = current.right;
                            BytecodeManager.incBytecodes(5);
                            if (entry7 != null) {
                                while (true) {
                                    final Entry<K, V> left = entry8.left;
                                    BytecodeManager.incBytecodes(5);
                                    if (left == null) {
                                        break;
                                    }
                                    entry8 = left;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            else {
                                while (true) {
                                    final Entry<K, V> entry9 = entry8 = current.parent;
                                    BytecodeManager.incBytecodes(5);
                                    if (entry9 == null) {
                                        break;
                                    }
                                    final Entry<K, V> entry10 = current;
                                    final Entry<K, V> right = entry8.right;
                                    BytecodeManager.incBytecodes(4);
                                    if (entry10 != right) {
                                        break;
                                    }
                                    current = entry8;
                                    BytecodeManager.incBytecodes(3);
                                }
                            }
                            final Entry<K, V> entry11 = current = entry8;
                            BytecodeManager.incBytecodes(4);
                            if (entry11 == null) {
                                break;
                            }
                            entry4 = current;
                            entry5 = fence;
                            BytecodeManager.incBytecodes(3);
                        } while (entry4 != entry5);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean tryAdvance(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int est = this.est;
                BytecodeManager.incBytecodes(3);
                if (est < 0) {
                    BytecodeManager.incBytecodes(2);
                    this.getEstimate();
                    BytecodeManager.incBytecodes(1);
                }
                final Entry<K, V> current;
                final Entry<K, V> entry = current = this.current;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = current;
                    final Entry<K, V> fence = this.fence;
                    BytecodeManager.incBytecodes(4);
                    if (entry2 != fence) {
                        final Entry<K, V> entry3 = current;
                        BytecodeManager.incBytecodes(3);
                        this.current = (Entry<K, V>)TreeMap.successor((Entry<K, V>)entry3);
                        BytecodeManager.incBytecodes(1);
                        final Entry<K, V> entry4 = current;
                        BytecodeManager.incBytecodes(3);
                        consumer.accept(entry4);
                        final TreeMap<K, V> tree = this.tree;
                        BytecodeManager.incBytecodes(3);
                        final int access$100 = TreeMap.access$100((TreeMap<Object, Object>)tree);
                        final int expectedModCount = this.expectedModCount;
                        BytecodeManager.incBytecodes(3);
                        if (access$100 != expectedModCount) {
                            BytecodeManager.incBytecodes(3);
                            final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                            BytecodeManager.incBytecodes(1);
                            throw ex2;
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                }
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int characteristics() {
            try {
                final int side = this.side;
                BytecodeManager.incBytecodes(3);
                int n;
                if (side == 0) {
                    n = 64;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    n = 0;
                    BytecodeManager.incBytecodes(1);
                }
                final int n2 = n | 0x1 | 0x4 | 0x10;
                BytecodeManager.incBytecodes(7);
                return n2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Comparator<Map.Entry<K, V>> getComparator() {
            try {
                final TreeMap<K, V> tree = this.tree;
                BytecodeManager.incBytecodes(3);
                final Comparator access$300 = TreeMap.access$300((TreeMap<Object, Object>)tree);
                BytecodeManager.incBytecodes(1);
                if (access$300 != null) {
                    final TreeMap<K, V> tree2 = this.tree;
                    BytecodeManager.incBytecodes(3);
                    final Comparator access$301 = TreeMap.access$300((TreeMap<Object, Object>)tree2);
                    BytecodeManager.incBytecodes(1);
                    final Comparator<Map.Entry<K, V>> comparingByKey = Map.Entry.comparingByKey((Comparator<? super K>)access$301);
                    BytecodeManager.incBytecodes(1);
                    return comparingByKey;
                }
                Comparable<Object> comparable;
                final Comparable<Object> comparable2;
                final Object o;
                final int n;
                final Comparator comparator = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(2);
                        comparable = entry.getKey();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(3);
                        entry2.getKey();
                        BytecodeManager.incBytecodes(1);
                        comparable2.compareTo(o);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(3);
                return (Comparator<Map.Entry<K, V>>)comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
