// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.lang.ref.WeakReference;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.lang.ref.Reference;
import java.util.Iterator;
import aic2021.engine.BytecodeManager;
import java.lang.ref.ReferenceQueue;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor;
    private final ReferenceQueue<Object> queue;
    int modCount;
    private static final Object NULL_KEY;
    private transient Set<Map.Entry<K, V>> entrySet;
    
    private Entry<K, V>[] newTable(final int n) {
        try {
            final Entry[] array = new Entry[n];
            BytecodeManager.incBytecodes(3);
            return (Entry<K, V>[])array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public WeakHashMap(int n, final float f) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.queue = new ReferenceQueue<Object>();
            BytecodeManager.incBytecodes(1);
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            if (n2 < 0) {
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str = "Illegal Initial Capacity: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str);
                final int i = n;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(i);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final IllegalArgumentException ex = new IllegalArgumentException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int n3 = n;
            final int n4 = 1073741824;
            BytecodeManager.incBytecodes(3);
            if (n3 > n4) {
                n = 1073741824;
                BytecodeManager.incBytecodes(2);
            }
            final float n5 = fcmpg(f, 0.0f);
            BytecodeManager.incBytecodes(4);
            if (n5 > 0) {
                BytecodeManager.incBytecodes(2);
                final boolean naN = Float.isNaN(f);
                BytecodeManager.incBytecodes(1);
                if (!naN) {
                    int n6 = 1;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final int n7 = n6;
                        final int n8 = n;
                        BytecodeManager.incBytecodes(3);
                        if (n7 >= n8) {
                            break;
                        }
                        n6 <<= 1;
                        BytecodeManager.incBytecodes(5);
                    }
                    final int n9 = n6;
                    BytecodeManager.incBytecodes(4);
                    this.table = this.newTable(n9);
                    BytecodeManager.incBytecodes(1);
                    this.loadFactor = f;
                    BytecodeManager.incBytecodes(3);
                    this.threshold = (int)(n6 * f);
                    BytecodeManager.incBytecodes(7);
                    BytecodeManager.incBytecodes(1);
                    return;
                }
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb2 = new StringBuilder();
            final String str2 = "Illegal Load factor: ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = sb2.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(f);
            BytecodeManager.incBytecodes(1);
            final String string2 = append4.toString();
            BytecodeManager.incBytecodes(1);
            final IllegalArgumentException ex2 = new IllegalArgumentException(string2);
            BytecodeManager.incBytecodes(1);
            throw ex2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public WeakHashMap(final int n) {
        try {
            final float n2 = 0.75f;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public WeakHashMap() {
        try {
            final int n = 16;
            final float n2 = 0.75f;
            BytecodeManager.incBytecodes(4);
            this(n, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public WeakHashMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(3);
            final int a = (int)(map.size() / 0.75f) + 1;
            final int b = 16;
            BytecodeManager.incBytecodes(8);
            final int max = Math.max(a, b);
            final float n = 0.75f;
            BytecodeManager.incBytecodes(2);
            this(max, n);
            BytecodeManager.incBytecodes(3);
            this.putAll(map);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Object maskNull(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            Object null_KEY;
            if (o == null) {
                null_KEY = WeakHashMap.NULL_KEY;
                BytecodeManager.incBytecodes(2);
            }
            else {
                null_KEY = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return null_KEY;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Object unmaskNull(final Object o) {
        try {
            final Object null_KEY = WeakHashMap.NULL_KEY;
            BytecodeManager.incBytecodes(3);
            Object o2;
            if (o == null_KEY) {
                o2 = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                o2 = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return o2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean eq(final Object o, final Object obj) {
        try {
            BytecodeManager.incBytecodes(3);
            boolean b = false;
            Label_0043: {
                if (o != obj) {
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = o.equals(obj);
                    BytecodeManager.incBytecodes(1);
                    if (!equals) {
                        b = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0043;
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
    
    final int hash(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final int hashCode = o.hashCode();
            BytecodeManager.incBytecodes(1);
            final int n = hashCode ^ (hashCode >>> 20 ^ hashCode >>> 12);
            BytecodeManager.incBytecodes(10);
            final int n2 = n ^ n >>> 7 ^ n >>> 4;
            BytecodeManager.incBytecodes(10);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static int indexFor(final int n, final int n2) {
        try {
            final int n3 = n & n2 - 1;
            BytecodeManager.incBytecodes(6);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void expungeStaleEntries() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/WeakHashMap.queue:Ljava/lang/ref/ReferenceQueue;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokevirtual   java/lang/ref/ReferenceQueue.poll:()Ljava/lang/ref/Reference;
        //    12: dup            
        //    13: astore_1       
        //    14: ldc             3
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: ifnull          263
        //    22: aload_0        
        //    23: getfield        instrumented/java/util/WeakHashMap.queue:Ljava/lang/ref/ReferenceQueue;
        //    26: dup            
        //    27: astore_2       
        //    28: pop            
        //    29: ldc             5
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: aload_1        
        //    35: checkcast       Linstrumented/java/util/WeakHashMap$Entry;
        //    38: astore_3       
        //    39: ldc             3
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: aload_3        
        //    45: getfield        instrumented/java/util/WeakHashMap$Entry.hash:I
        //    48: aload_0        
        //    49: getfield        instrumented/java/util/WeakHashMap.table:[Linstrumented/java/util/WeakHashMap$Entry;
        //    52: arraylength    
        //    53: ldc             6
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokestatic    instrumented/java/util/WeakHashMap.indexFor:(II)I
        //    61: istore          4
        //    63: ldc             1
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: aload_0        
        //    69: getfield        instrumented/java/util/WeakHashMap.table:[Linstrumented/java/util/WeakHashMap$Entry;
        //    72: iload           4
        //    74: aaload         
        //    75: astore          5
        //    77: ldc             5
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: aload           5
        //    84: astore          6
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: aload           6
        //    93: ldc             2
        //    95: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    98: ifnull          223
        //   101: aload           6
        //   103: getfield        instrumented/java/util/WeakHashMap$Entry.next:Linstrumented/java/util/WeakHashMap$Entry;
        //   106: astore          7
        //   108: ldc             3
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: aload           6
        //   115: aload_3        
        //   116: ldc             3
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: if_acmpne       197
        //   124: aload           5
        //   126: aload_3        
        //   127: ldc             3
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: if_acmpne       152
        //   135: aload_0        
        //   136: getfield        instrumented/java/util/WeakHashMap.table:[Linstrumented/java/util/WeakHashMap$Entry;
        //   139: iload           4
        //   141: aload           7
        //   143: aastore        
        //   144: ldc             6
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            164
        //   152: aload           5
        //   154: aload           7
        //   156: putfield        instrumented/java/util/WeakHashMap$Entry.next:Linstrumented/java/util/WeakHashMap$Entry;
        //   159: ldc             3
        //   161: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   164: aload_3        
        //   165: aconst_null    
        //   166: putfield        instrumented/java/util/WeakHashMap$Entry.value:Ljava/lang/Object;
        //   169: ldc             3
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: aload_0        
        //   175: dup            
        //   176: getfield        instrumented/java/util/WeakHashMap.size:I
        //   179: iconst_1       
        //   180: isub           
        //   181: putfield        instrumented/java/util/WeakHashMap.size:I
        //   184: ldc             6
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: goto            223
        //   197: aload           6
        //   199: astore          5
        //   201: ldc             2
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: aload           7
        //   208: astore          6
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: goto            91
        //   223: aload_2        
        //   224: pop            
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: ldc             1
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: goto            255
        //   238: astore          8
        //   240: aload_2        
        //   241: pop            
        //   242: ldc             503
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: aload           8
        //   249: ldc             2
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: athrow         
        //   255: ldc             1
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: goto            0
        //   263: ldc             1
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: return         
        //   269: athrow         
        //   270: athrow         
        //    StackMapTable: 00 0B 00 FF 00 5A 00 07 07 00 02 07 00 A0 07 00 A0 07 00 0D 01 07 00 0D 07 00 0D 00 00 FC 00 3C 07 00 0D 0B 20 FF 00 19 00 03 07 00 02 07 00 A0 07 00 A0 00 00 4E 07 00 53 FA 00 10 FA 00 07 FF 00 05 00 00 00 01 07 00 53 FF 00 00 00 00 00 01 07 00 B2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  34     270    270    271    Ljava/lang/VirtualMachineError;
        //  34     230    238    255    Any
        //  238    247    238    255    Any
        //  0      269    269    270    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0091:
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
    
    private Entry<K, V>[] getTable() {
        try {
            BytecodeManager.incBytecodes(2);
            this.expungeStaleEntries();
            final Entry<K, V>[] table = this.table;
            BytecodeManager.incBytecodes(3);
            return table;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public int size() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            if (size == 0) {
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            BytecodeManager.incBytecodes(2);
            this.expungeStaleEntries();
            final int size2 = this.size;
            BytecodeManager.incBytecodes(3);
            return size2;
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
    
    @Override
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object o2 = maskNull;
            BytecodeManager.incBytecodes(3);
            final int hash = this.hash(o2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            final int length = table.length;
            BytecodeManager.incBytecodes(4);
            final int index = indexFor(n, length);
            BytecodeManager.incBytecodes(1);
            Entry<K, V> next = table[index];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int hash2 = next.hash;
                final int n2 = hash;
                BytecodeManager.incBytecodes(4);
                if (hash2 == n2) {
                    final Object o3 = maskNull;
                    final Entry<K, V> entry2 = next;
                    BytecodeManager.incBytecodes(3);
                    final Object value = entry2.get();
                    BytecodeManager.incBytecodes(1);
                    final boolean eq = eq(o3, value);
                    BytecodeManager.incBytecodes(1);
                    if (eq) {
                        final V value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        return value2;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
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
    
    Entry<K, V> getEntry(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object o2 = maskNull;
            BytecodeManager.incBytecodes(3);
            final int hash = this.hash(o2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            final int length = table.length;
            BytecodeManager.incBytecodes(4);
            final int index = indexFor(n, length);
            BytecodeManager.incBytecodes(1);
            Entry<K, V> next = table[index];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    break;
                }
                final int hash2 = next.hash;
                final int n2 = hash;
                BytecodeManager.incBytecodes(4);
                if (hash2 == n2) {
                    final Object o3 = maskNull;
                    final Entry<K, V> entry2 = next;
                    BytecodeManager.incBytecodes(3);
                    final Object value = entry2.get();
                    BytecodeManager.incBytecodes(1);
                    final boolean eq = eq(o3, value);
                    BytecodeManager.incBytecodes(1);
                    if (eq) {
                        break;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
            final Entry<K, V> entry3 = next;
            BytecodeManager.incBytecodes(2);
            return entry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V put(final K k, final V value) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(k);
            BytecodeManager.incBytecodes(1);
            final Object o = maskNull;
            BytecodeManager.incBytecodes(3);
            final int hash = this.hash(o);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            final int length = table.length;
            BytecodeManager.incBytecodes(4);
            final int index = indexFor(n, length);
            BytecodeManager.incBytecodes(1);
            Entry<K, V> next = table[index];
            BytecodeManager.incBytecodes(4);
            while (true) {
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    ++this.modCount;
                    BytecodeManager.incBytecodes(6);
                    final Entry<K, V> entry2 = table[index];
                    BytecodeManager.incBytecodes(4);
                    final Entry<K, V>[] array = table;
                    final int n2 = index;
                    final Object o2 = maskNull;
                    final ReferenceQueue<Object> queue = this.queue;
                    final int n3 = hash;
                    final Entry<K, V> entry3 = entry2;
                    BytecodeManager.incBytecodes(11);
                    array[n2] = new Entry<K, V>(o2, value, queue, n3, (Entry<Object, Object>)entry3);
                    BytecodeManager.incBytecodes(1);
                    final int n4 = ++this.size;
                    final int threshold = this.threshold;
                    BytecodeManager.incBytecodes(10);
                    if (n4 >= threshold) {
                        final int n5 = table.length * 2;
                        BytecodeManager.incBytecodes(6);
                        this.resize(n5);
                    }
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final int n6 = hash;
                final int hash2 = next.hash;
                BytecodeManager.incBytecodes(4);
                if (n6 == hash2) {
                    final Object o3 = maskNull;
                    final Entry<K, V> entry4 = next;
                    BytecodeManager.incBytecodes(3);
                    final Object value2 = entry4.get();
                    BytecodeManager.incBytecodes(1);
                    final boolean eq = eq(o3, value2);
                    BytecodeManager.incBytecodes(1);
                    if (eq) {
                        final V value3 = next.value;
                        BytecodeManager.incBytecodes(3);
                        final V v2 = value3;
                        BytecodeManager.incBytecodes(3);
                        if (value != v2) {
                            next.value = value;
                            BytecodeManager.incBytecodes(3);
                        }
                        final V v3 = value3;
                        BytecodeManager.incBytecodes(2);
                        return v3;
                    }
                }
                next = next.next;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void resize(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final int length = table.length;
            BytecodeManager.incBytecodes(3);
            final int n2 = length;
            final int n3 = 1073741824;
            BytecodeManager.incBytecodes(3);
            if (n2 == n3) {
                this.threshold = Integer.MAX_VALUE;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                return;
            }
            BytecodeManager.incBytecodes(3);
            final Entry<K, V>[] table2 = this.newTable(n);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V>[] array = table;
            final Entry<K, V>[] array2 = table2;
            BytecodeManager.incBytecodes(4);
            this.transfer(array, array2);
            this.table = table2;
            BytecodeManager.incBytecodes(3);
            final int size = this.size;
            final int n4 = this.threshold / 2;
            BytecodeManager.incBytecodes(7);
            if (size >= n4) {
                this.threshold = (int)(n * this.loadFactor);
                BytecodeManager.incBytecodes(9);
            }
            else {
                BytecodeManager.incBytecodes(2);
                this.expungeStaleEntries();
                final Entry<K, V>[] array3 = table2;
                final Entry<K, V>[] array4 = table;
                BytecodeManager.incBytecodes(4);
                this.transfer(array3, array4);
                this.table = table;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void transfer(final Entry<K, V>[] array, final Entry<K, V>[] array2) {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int length = array.length;
                BytecodeManager.incBytecodes(4);
                if (n2 >= length) {
                    break;
                }
                Entry<K, V> entry = array[n];
                BytecodeManager.incBytecodes(4);
                array[n] = null;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break;
                    }
                    final Entry<K, V> next = entry.next;
                    BytecodeManager.incBytecodes(3);
                    final Entry<K, V> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry3.get();
                    BytecodeManager.incBytecodes(1);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o == null) {
                        entry.next = null;
                        BytecodeManager.incBytecodes(3);
                        entry.value = null;
                        BytecodeManager.incBytecodes(3);
                        --this.size;
                        BytecodeManager.incBytecodes(7);
                    }
                    else {
                        final int hash = entry.hash;
                        final int length2 = array2.length;
                        BytecodeManager.incBytecodes(5);
                        final int index = indexFor(hash, length2);
                        BytecodeManager.incBytecodes(1);
                        entry.next = array2[index];
                        BytecodeManager.incBytecodes(5);
                        array2[index] = entry;
                        BytecodeManager.incBytecodes(4);
                    }
                    entry = next;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
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
    public void putAll(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            final int size = map.size();
            BytecodeManager.incBytecodes(1);
            final int n = size;
            BytecodeManager.incBytecodes(2);
            if (n == 0) {
                BytecodeManager.incBytecodes(1);
                return;
            }
            final int n2 = size;
            final int threshold = this.threshold;
            BytecodeManager.incBytecodes(4);
            if (n2 > threshold) {
                int n3 = (int)(size / this.loadFactor + 1.0f);
                BytecodeManager.incBytecodes(9);
                final int n4 = n3;
                final int n5 = 1073741824;
                BytecodeManager.incBytecodes(3);
                if (n4 > n5) {
                    n3 = 1073741824;
                    BytecodeManager.incBytecodes(2);
                }
                int length = this.table.length;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final int n6 = length;
                    final int n7 = n3;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n7) {
                        break;
                    }
                    length <<= 1;
                    BytecodeManager.incBytecodes(5);
                }
                final int n8 = length;
                final int length2 = this.table.length;
                BytecodeManager.incBytecodes(5);
                if (n8 > length2) {
                    final int n9 = length;
                    BytecodeManager.incBytecodes(3);
                    this.resize(n9);
                }
            }
            BytecodeManager.incBytecodes(2);
            final Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<? extends K, ? extends V>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Map.Entry<? extends K, ? extends V>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Map.Entry<? extends K, ? extends V>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<? extends K, ? extends V> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Map.Entry<? extends K, ? extends V> entry2 = entry;
                BytecodeManager.incBytecodes(3);
                final K key = (K)entry2.getKey();
                final Map.Entry<? extends K, ? extends V> entry3 = entry;
                BytecodeManager.incBytecodes(2);
                final V value = (V)entry3.getValue();
                BytecodeManager.incBytecodes(1);
                this.put(key, value);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V remove(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            final Object maskNull = maskNull(o);
            BytecodeManager.incBytecodes(1);
            final Object o2 = maskNull;
            BytecodeManager.incBytecodes(3);
            final int hash = this.hash(o2);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            final int length = table.length;
            BytecodeManager.incBytecodes(4);
            final int index = indexFor(n, length);
            BytecodeManager.incBytecodes(1);
            Entry<K, V> entry = table[index];
            BytecodeManager.incBytecodes(4);
            Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<K, V> entry3 = entry2;
                BytecodeManager.incBytecodes(2);
                if (entry3 == null) {
                    final V v = null;
                    BytecodeManager.incBytecodes(2);
                    return v;
                }
                final Entry<K, V> next = entry2.next;
                BytecodeManager.incBytecodes(3);
                final int n2 = hash;
                final int hash2 = entry2.hash;
                BytecodeManager.incBytecodes(4);
                if (n2 == hash2) {
                    final Object o3 = maskNull;
                    final Entry<K, V> entry4 = entry2;
                    BytecodeManager.incBytecodes(3);
                    final Object value = entry4.get();
                    BytecodeManager.incBytecodes(1);
                    final boolean eq = eq(o3, value);
                    BytecodeManager.incBytecodes(1);
                    if (eq) {
                        ++this.modCount;
                        BytecodeManager.incBytecodes(6);
                        --this.size;
                        BytecodeManager.incBytecodes(6);
                        final Entry<K, V> entry5 = entry;
                        final Entry<K, V> entry6 = entry2;
                        BytecodeManager.incBytecodes(3);
                        if (entry5 == entry6) {
                            table[index] = next;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            entry.next = next;
                            BytecodeManager.incBytecodes(3);
                        }
                        final V value2 = entry2.value;
                        BytecodeManager.incBytecodes(3);
                        return value2;
                    }
                }
                entry = entry2;
                BytecodeManager.incBytecodes(2);
                entry2 = next;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean removeMapping(final Object o) {
        try {
            final boolean b = o instanceof Map.Entry;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final boolean b2 = false;
                BytecodeManager.incBytecodes(2);
                return b2;
            }
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final Map.Entry entry = (Map.Entry)o;
            BytecodeManager.incBytecodes(3);
            final Map.Entry entry2 = entry;
            BytecodeManager.incBytecodes(2);
            final Object key = entry2.getKey();
            BytecodeManager.incBytecodes(1);
            final Object maskNull = maskNull(key);
            BytecodeManager.incBytecodes(1);
            final Object o2 = maskNull;
            BytecodeManager.incBytecodes(3);
            final int hash = this.hash(o2);
            BytecodeManager.incBytecodes(1);
            final int n = hash;
            final int length = table.length;
            BytecodeManager.incBytecodes(4);
            final int index = indexFor(n, length);
            BytecodeManager.incBytecodes(1);
            Entry<K, V> entry3 = table[index];
            BytecodeManager.incBytecodes(4);
            Entry<K, V> entry4 = entry3;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final Entry<K, V> entry5 = entry4;
                BytecodeManager.incBytecodes(2);
                if (entry5 == null) {
                    final boolean b3 = false;
                    BytecodeManager.incBytecodes(2);
                    return b3;
                }
                final Entry<K, V> next = entry4.next;
                BytecodeManager.incBytecodes(3);
                final int n2 = hash;
                final int hash2 = entry4.hash;
                BytecodeManager.incBytecodes(4);
                if (n2 == hash2) {
                    final Entry<K, V> entry6 = entry4;
                    final Map.Entry entry7 = entry;
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = entry6.equals(entry7);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        ++this.modCount;
                        BytecodeManager.incBytecodes(6);
                        --this.size;
                        BytecodeManager.incBytecodes(6);
                        final Entry<K, V> entry8 = entry3;
                        final Entry<K, V> entry9 = entry4;
                        BytecodeManager.incBytecodes(3);
                        if (entry8 == entry9) {
                            table[index] = next;
                            BytecodeManager.incBytecodes(5);
                        }
                        else {
                            entry3.next = next;
                            BytecodeManager.incBytecodes(3);
                        }
                        final boolean b4 = true;
                        BytecodeManager.incBytecodes(2);
                        return b4;
                    }
                }
                entry3 = entry4;
                BytecodeManager.incBytecodes(2);
                entry4 = next;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            while (true) {
                final ReferenceQueue<Object> queue = this.queue;
                BytecodeManager.incBytecodes(3);
                final Reference<?> poll = queue.poll();
                BytecodeManager.incBytecodes(1);
                if (poll == null) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            ++this.modCount;
            BytecodeManager.incBytecodes(6);
            final Entry<K, V>[] table = this.table;
            final Object o = null;
            BytecodeManager.incBytecodes(4);
            Arrays.fill(table, o);
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final ReferenceQueue<Object> queue2 = this.queue;
                BytecodeManager.incBytecodes(3);
                final Reference<?> poll2 = queue2.poll();
                BytecodeManager.incBytecodes(1);
                if (poll2 == null) {
                    break;
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(2);
                final boolean containsNullValue = this.containsNullValue();
                BytecodeManager.incBytecodes(1);
                return containsNullValue;
            }
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            int length = table.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n = length--;
                BytecodeManager.incBytecodes(3);
                if (n <= 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                Entry<K, V> next = table[length];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final V value = next.value;
                    BytecodeManager.incBytecodes(4);
                    final boolean equals = o.equals(value);
                    BytecodeManager.incBytecodes(1);
                    if (equals) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private boolean containsNullValue() {
        try {
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            int length = table.length;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n = length--;
                BytecodeManager.incBytecodes(3);
                if (n <= 0) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                Entry<K, V> next = table[length];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        BytecodeManager.incBytecodes(1);
                        break;
                    }
                    final V value = next.value;
                    BytecodeManager.incBytecodes(3);
                    if (value == null) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(4);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<K> keySet() {
        try {
            final Set<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(3);
            final Set<K> set = keySet;
            BytecodeManager.incBytecodes(2);
            Set<K> set2;
            if (set != null) {
                set2 = keySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final KeySet keySet2 = (KeySet)(set2 = new KeySet());
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                this.keySet = keySet2;
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
                final Object object = null;
                BytecodeManager.incBytecodes(6);
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
            final Set<Map.Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(3);
            final Set<Map.Entry<K, V>> set = entrySet;
            BytecodeManager.incBytecodes(2);
            Set<Map.Entry<K, V>> set2;
            if (set != null) {
                set2 = entrySet;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final EntrySet entrySet2 = (EntrySet)(set2 = new EntrySet());
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                this.entrySet = entrySet2;
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
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biConsumer);
            BytecodeManager.incBytecodes(1);
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(2);
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final Entry<K, V>[] array = table;
            final int length = array.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                Entry<?, ?> next = array[n];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<?, ?> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        ++n;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                    final Entry<?, ?> entry2 = next;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry2.get();
                    BytecodeManager.incBytecodes(1);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Object o2 = value;
                        BytecodeManager.incBytecodes(3);
                        final Object unmaskNull = unmaskNull(o2);
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        biConsumer.accept((Object)unmaskNull, (Object)value2);
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(3);
                    final int n4 = modCount;
                    final int modCount2 = this.modCount;
                    BytecodeManager.incBytecodes(4);
                    if (n4 != modCount2) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    BytecodeManager.incBytecodes(1);
                }
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
            final Entry<K, V>[] table = this.getTable();
            BytecodeManager.incBytecodes(1);
            final Entry<K, V>[] array = table;
            final int length = array.length;
            int n = 0;
            BytecodeManager.incBytecodes(7);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    BytecodeManager.incBytecodes(1);
                    return;
                }
                Entry<?, ?> next = array[n];
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<?, ?> entry = next;
                    BytecodeManager.incBytecodes(2);
                    if (entry == null) {
                        ++n;
                        BytecodeManager.incBytecodes(2);
                        break;
                    }
                    final Entry<?, ?> entry2 = next;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry2.get();
                    BytecodeManager.incBytecodes(1);
                    final Object o = value;
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final Entry<?, ?> entry3 = next;
                        final Object o2 = value;
                        BytecodeManager.incBytecodes(4);
                        final Object unmaskNull = unmaskNull(o2);
                        final Object value2 = next.value;
                        BytecodeManager.incBytecodes(3);
                        entry3.value = biFunction.apply((Object)unmaskNull, (Object)value2);
                        BytecodeManager.incBytecodes(1);
                    }
                    next = next.next;
                    BytecodeManager.incBytecodes(3);
                    final int n4 = modCount;
                    final int modCount2 = this.modCount;
                    BytecodeManager.incBytecodes(4);
                    if (n4 != modCount2) {
                        BytecodeManager.incBytecodes(3);
                        final ConcurrentModificationException ex = new ConcurrentModificationException();
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            BytecodeManager.incBytecodes(3);
            NULL_KEY = new Object();
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class Entry<K, V> extends WeakReference<Object> implements Map.Entry<K, V>
    {
        V value;
        final int hash;
        Entry<K, V> next;
        
        Entry(final Object referent, final V value, final ReferenceQueue<Object> q, final int hash, final Entry<K, V> next) {
            try {
                BytecodeManager.incBytecodes(4);
                super(referent, q);
                this.value = value;
                BytecodeManager.incBytecodes(3);
                this.hash = hash;
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
        public K getKey() {
            try {
                BytecodeManager.incBytecodes(2);
                final Object value = this.get();
                BytecodeManager.incBytecodes(1);
                final Object unmaskNull = WeakHashMap.unmaskNull(value);
                BytecodeManager.incBytecodes(1);
                return (K)unmaskNull;
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
                BytecodeManager.incBytecodes(2);
                final Object key = this.getKey();
                BytecodeManager.incBytecodes(1);
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Object key2 = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Object o2 = key;
                final Object o3 = key2;
                BytecodeManager.incBytecodes(3);
                Label_0184: {
                    if (o2 != o3) {
                        final Object o4 = key;
                        BytecodeManager.incBytecodes(2);
                        if (o4 == null) {
                            break Label_0184;
                        }
                        final Object o5 = key;
                        final Object obj = key2;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = o5.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (!equals) {
                            break Label_0184;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final Object value = this.getValue();
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value2 = entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final Object o6 = value;
                    final Object o7 = value2;
                    BytecodeManager.incBytecodes(3);
                    if (o6 != o7) {
                        final Object o8 = value;
                        BytecodeManager.incBytecodes(2);
                        if (o8 == null) {
                            break Label_0184;
                        }
                        final Object o9 = value;
                        final Object obj2 = value2;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals2 = o9.equals(obj2);
                        BytecodeManager.incBytecodes(1);
                        if (!equals2) {
                            break Label_0184;
                        }
                    }
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(2);
                    return b3;
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
        public int hashCode() {
            try {
                BytecodeManager.incBytecodes(2);
                final Object key = this.getKey();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final Object value = this.getValue();
                BytecodeManager.incBytecodes(1);
                final Object o = key;
                BytecodeManager.incBytecodes(2);
                final int hashCode = Objects.hashCode(o);
                final Object o2 = value;
                BytecodeManager.incBytecodes(2);
                final int n = hashCode ^ Objects.hashCode(o2);
                BytecodeManager.incBytecodes(2);
                return n;
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
                BytecodeManager.incBytecodes(2);
                final K key = this.getKey();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append = sb.append(key);
                final String str = "=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(2);
                final V value = this.getValue();
                BytecodeManager.incBytecodes(1);
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
    
    private abstract class HashIterator<T> implements Iterator<T>
    {
        private int index;
        private Entry<K, V> entry;
        private Entry<K, V> lastReturned;
        private int expectedModCount;
        private Object nextKey;
        private Object currentKey;
        
        HashIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.expectedModCount = WeakHashMap.this.modCount;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(3);
                final boolean empty = WeakHashMap.this.isEmpty();
                BytecodeManager.incBytecodes(1);
                int length;
                if (empty) {
                    length = 0;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    length = WeakHashMap.this.table.length;
                    BytecodeManager.incBytecodes(3);
                }
                this.index = length;
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
                final Entry<K, V>[] table = WeakHashMap.this.table;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Object nextKey = this.nextKey;
                    BytecodeManager.incBytecodes(3);
                    if (nextKey != null) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    Entry<K, V> entry = this.entry;
                    BytecodeManager.incBytecodes(3);
                    int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    while (true) {
                        final Entry<K, V> entry2 = entry;
                        BytecodeManager.incBytecodes(2);
                        if (entry2 != null) {
                            break;
                        }
                        final int n = index;
                        BytecodeManager.incBytecodes(2);
                        if (n <= 0) {
                            break;
                        }
                        entry = table[--index];
                        BytecodeManager.incBytecodes(6);
                    }
                    this.entry = entry;
                    BytecodeManager.incBytecodes(3);
                    this.index = index;
                    BytecodeManager.incBytecodes(3);
                    final Entry<K, V> entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry3 == null) {
                        this.currentKey = null;
                        BytecodeManager.incBytecodes(3);
                        final boolean b2 = false;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                    final Entry<K, V> entry4 = entry;
                    BytecodeManager.incBytecodes(3);
                    this.nextKey = entry4.get();
                    BytecodeManager.incBytecodes(1);
                    final Object nextKey2 = this.nextKey;
                    BytecodeManager.incBytecodes(3);
                    if (nextKey2 == null) {
                        this.entry = this.entry.next;
                        BytecodeManager.incBytecodes(5);
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        protected Entry<K, V> nextEntry() {
            try {
                final int modCount = WeakHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Object nextKey = this.nextKey;
                BytecodeManager.incBytecodes(3);
                if (nextKey == null) {
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = this.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        BytecodeManager.incBytecodes(3);
                        final NoSuchElementException ex2 = new NoSuchElementException();
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                }
                this.lastReturned = this.entry;
                BytecodeManager.incBytecodes(4);
                this.entry = this.entry.next;
                BytecodeManager.incBytecodes(5);
                this.currentKey = this.nextKey;
                BytecodeManager.incBytecodes(4);
                this.nextKey = null;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> lastReturned = this.lastReturned;
                BytecodeManager.incBytecodes(3);
                return lastReturned;
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
                final int modCount = WeakHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                final WeakHashMap this$0 = WeakHashMap.this;
                final Object currentKey = this.currentKey;
                BytecodeManager.incBytecodes(5);
                this$0.remove(currentKey);
                BytecodeManager.incBytecodes(1);
                this.expectedModCount = WeakHashMap.this.modCount;
                BytecodeManager.incBytecodes(5);
                this.lastReturned = null;
                BytecodeManager.incBytecodes(3);
                this.currentKey = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class ValueIterator extends HashIterator<V>
    {
        private ValueIterator() {
            try {
                BytecodeManager.incBytecodes(6);
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
    
    private class KeyIterator extends HashIterator<K>
    {
        private KeyIterator() {
            try {
                BytecodeManager.incBytecodes(6);
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
                final Entry<K, V> nextEntry = this.nextEntry();
                BytecodeManager.incBytecodes(1);
                final K key = nextEntry.getKey();
                BytecodeManager.incBytecodes(1);
                return key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class EntryIterator extends HashIterator<Map.Entry<K, V>>
    {
        private EntryIterator() {
            try {
                BytecodeManager.incBytecodes(6);
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
    
    private class KeySet extends AbstractSet<K>
    {
        private KeySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Iterator<K> iterator() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final KeyIterator keyIterator = new KeyIterator();
                BytecodeManager.incBytecodes(1);
                return keyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
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
                final WeakHashMap this$0 = WeakHashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = this$0.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = this$0.containsKey(o);
                BytecodeManager.incBytecodes(1);
                if (containsKey) {
                    final WeakHashMap this$2 = WeakHashMap.this;
                    BytecodeManager.incBytecodes(4);
                    this$2.remove(o);
                    BytecodeManager.incBytecodes(1);
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
        public void clear() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<K> spliterator() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final KeySpliterator keySpliterator = new KeySpliterator<K, Object>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)keySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class Values extends AbstractCollection<V>
    {
        private Values() {
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
                final WeakHashMap this$0 = WeakHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final ValueIterator valueIterator = new ValueIterator();
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
                final WeakHashMap this$0 = WeakHashMap.this;
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
                final WeakHashMap this$0 = WeakHashMap.this;
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
        public void clear() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
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
                final WeakHashMap this$0 = WeakHashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final ValueSpliterator valueSpliterator = new ValueSpliterator<Object, V>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<V>)valueSpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        private EntrySet() {
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
                final WeakHashMap this$0 = WeakHashMap.this;
                final Object object = null;
                BytecodeManager.incBytecodes(6);
                final EntryIterator entryIterator = new EntryIterator();
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
                final WeakHashMap this$0 = WeakHashMap.this;
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry3 = this$0.getEntry(key);
                BytecodeManager.incBytecodes(1);
                final Entry<K, V> entry4 = entry3;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                Label_0100: {
                    if (entry4 != null) {
                        final Entry<K, V> entry5 = entry3;
                        final Map.Entry entry6 = entry;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = entry5.equals(entry6);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0100;
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
                final WeakHashMap this$0 = WeakHashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean removeMapping = this$0.removeMapping(o);
                BytecodeManager.incBytecodes(1);
                return removeMapping;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public int size() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
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
                final WeakHashMap this$0 = WeakHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private List<Map.Entry<K, V>> deepCopy() {
            try {
                BytecodeManager.incBytecodes(4);
                final int size = this.size();
                BytecodeManager.incBytecodes(1);
                final ArrayList list = new ArrayList<SimpleEntry>(size);
                BytecodeManager.incBytecodes(1);
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
                    final Iterator<Map.Entry<K, V>> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final Map.Entry<K, V> entry = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final ArrayList list2 = list;
                    final Map.Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(5);
                    final SimpleEntry simpleEntry = new SimpleEntry(entry2);
                    BytecodeManager.incBytecodes(1);
                    list2.add(simpleEntry);
                    BytecodeManager.incBytecodes(2);
                }
                final ArrayList list3 = list;
                BytecodeManager.incBytecodes(2);
                return (List<Map.Entry<K, V>>)list3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Object[] toArray() {
            try {
                BytecodeManager.incBytecodes(2);
                final List<Map.Entry<K, V>> deepCopy = this.deepCopy();
                BytecodeManager.incBytecodes(1);
                final Object[] array = deepCopy.toArray();
                BytecodeManager.incBytecodes(1);
                return array;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            try {
                BytecodeManager.incBytecodes(2);
                final List<Map.Entry<K, V>> deepCopy = this.deepCopy();
                BytecodeManager.incBytecodes(2);
                final T[] array2 = deepCopy.toArray(array);
                BytecodeManager.incBytecodes(1);
                return array2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Spliterator<Map.Entry<K, V>> spliterator() {
            try {
                final WeakHashMap this$0 = WeakHashMap.this;
                final int n = 0;
                final int n2 = -1;
                final int n3 = 0;
                final int n4 = 0;
                BytecodeManager.incBytecodes(9);
                final EntrySpliterator entrySpliterator = new EntrySpliterator<K, V>(this$0, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Map.Entry<K, V>>)entrySpliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static class WeakHashMapSpliterator<K, V>
    {
        final WeakHashMap<K, V> map;
        Entry<K, V> current;
        int index;
        int fence;
        int est;
        int expectedModCount;
        
        WeakHashMapSpliterator(final WeakHashMap<K, V> map, final int index, final int fence, final int est, final int expectedModCount) {
            try {
                BytecodeManager.incBytecodes(2);
                this.map = map;
                BytecodeManager.incBytecodes(3);
                this.index = index;
                BytecodeManager.incBytecodes(3);
                this.fence = fence;
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
        
        final int getFence() {
            try {
                int fence = this.fence;
                BytecodeManager.incBytecodes(5);
                if (fence < 0) {
                    final WeakHashMap<K, V> map = this.map;
                    BytecodeManager.incBytecodes(3);
                    final WeakHashMap<K, V> weakHashMap = map;
                    BytecodeManager.incBytecodes(3);
                    this.est = weakHashMap.size();
                    BytecodeManager.incBytecodes(1);
                    this.expectedModCount = map.modCount;
                    BytecodeManager.incBytecodes(4);
                    final int length = map.table.length;
                    this.fence = length;
                    fence = length;
                    BytecodeManager.incBytecodes(7);
                }
                final int n = fence;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final long estimateSize() {
            try {
                BytecodeManager.incBytecodes(2);
                this.getFence();
                BytecodeManager.incBytecodes(1);
                final long n = this.est;
                BytecodeManager.incBytecodes(4);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class KeySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<K>
    {
        KeySpliterator(final WeakHashMap<K, V> weakHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(weakHashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public KeySpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                KeySpliterator<K, V> keySpliterator;
                if (n2 >= n3) {
                    keySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final WeakHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    keySpliterator = new KeySpliterator<K, V>((WeakHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
                }
                BytecodeManager.incBytecodes(1);
                return keySpliterator;
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
                final WeakHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final int length = table.length;
                    this.fence = length;
                    fence = length;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final int length2 = table.length;
                final int n2 = fence;
                BytecodeManager.incBytecodes(4);
                Label_0304: {
                    if (length2 >= n2) {
                        int index;
                        final int n3 = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            final int n4 = index;
                            final int index2 = fence;
                            this.index = index2;
                            BytecodeManager.incBytecodes(6);
                            if (n4 >= index2) {
                                final Entry<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    break Label_0304;
                                }
                            }
                            Entry<K, V> entry = this.current;
                            BytecodeManager.incBytecodes(3);
                            this.current = null;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final Entry<K, V> entry2 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry2 == null) {
                                    entry = table[index++];
                                    BytecodeManager.incBytecodes(6);
                                }
                                else {
                                    final Entry<K, V> entry3 = entry;
                                    BytecodeManager.incBytecodes(2);
                                    final Object value = entry3.get();
                                    BytecodeManager.incBytecodes(1);
                                    entry = entry.next;
                                    BytecodeManager.incBytecodes(3);
                                    final Object o = value;
                                    BytecodeManager.incBytecodes(2);
                                    if (o != null) {
                                        final Object o2 = value;
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final Object unmaskNull = WeakHashMap.unmaskNull(o2);
                                        BytecodeManager.incBytecodes(1);
                                        final Object o3 = unmaskNull;
                                        BytecodeManager.incBytecodes(3);
                                        consumer.accept((Object)o3);
                                    }
                                }
                                final Entry<K, V> entry4 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry4 == null) {
                                    final int n5 = index;
                                    final int n6 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 >= n6) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
                final int modCount2 = map.modCount;
                final int n7 = expectedModCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n7) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
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
                final Entry<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(3);
                if (length >= fence) {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index >= 0) {
                        while (true) {
                            final Entry<K, V> current = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current == null) {
                                final int index2 = this.index;
                                final int n = fence;
                                BytecodeManager.incBytecodes(4);
                                if (index2 >= n) {
                                    break;
                                }
                            }
                            final Entry<K, V> current2 = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current2 == null) {
                                this.current = table[this.index++];
                                BytecodeManager.incBytecodes(12);
                            }
                            else {
                                final Entry<K, V> current3 = this.current;
                                BytecodeManager.incBytecodes(3);
                                final Object value = current3.get();
                                BytecodeManager.incBytecodes(1);
                                this.current = this.current.next;
                                BytecodeManager.incBytecodes(5);
                                final Object o = value;
                                BytecodeManager.incBytecodes(2);
                                if (o != null) {
                                    final Object o2 = value;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final Object unmaskNull = WeakHashMap.unmaskNull(o2);
                                    BytecodeManager.incBytecodes(1);
                                    final Object o3 = unmaskNull;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept((Object)o3);
                                    final int modCount = this.map.modCount;
                                    final int expectedModCount = this.expectedModCount;
                                    BytecodeManager.incBytecodes(6);
                                    if (modCount != expectedModCount) {
                                        BytecodeManager.incBytecodes(3);
                                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                    final boolean b = true;
                                    BytecodeManager.incBytecodes(2);
                                    return b;
                                }
                                else {
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
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
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ValueSpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<V>
    {
        ValueSpliterator(final WeakHashMap<K, V> weakHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(weakHashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ValueSpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                ValueSpliterator<K, V> valueSpliterator;
                if (n2 >= n3) {
                    valueSpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final WeakHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    valueSpliterator = new ValueSpliterator<K, V>((WeakHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
                }
                BytecodeManager.incBytecodes(1);
                return valueSpliterator;
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
                final WeakHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final int length = table.length;
                    this.fence = length;
                    fence = length;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final int length2 = table.length;
                final int n2 = fence;
                BytecodeManager.incBytecodes(4);
                Label_0294: {
                    if (length2 >= n2) {
                        int index;
                        final int n3 = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            final int n4 = index;
                            final int index2 = fence;
                            this.index = index2;
                            BytecodeManager.incBytecodes(6);
                            if (n4 >= index2) {
                                final Entry<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    break Label_0294;
                                }
                            }
                            Entry<K, V> entry = this.current;
                            BytecodeManager.incBytecodes(3);
                            this.current = null;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final Entry<K, V> entry2 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry2 == null) {
                                    entry = table[index++];
                                    BytecodeManager.incBytecodes(6);
                                }
                                else {
                                    final Entry<K, V> entry3 = entry;
                                    BytecodeManager.incBytecodes(2);
                                    final Object value = entry3.get();
                                    BytecodeManager.incBytecodes(1);
                                    final V value2 = entry.value;
                                    BytecodeManager.incBytecodes(3);
                                    entry = entry.next;
                                    BytecodeManager.incBytecodes(3);
                                    final Object o = value;
                                    BytecodeManager.incBytecodes(2);
                                    if (o != null) {
                                        final V v = value2;
                                        BytecodeManager.incBytecodes(3);
                                        consumer.accept(v);
                                    }
                                }
                                final Entry<K, V> entry4 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry4 == null) {
                                    final int n5 = index;
                                    final int n6 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 >= n6) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
                final int modCount2 = map.modCount;
                final int n7 = expectedModCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n7) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
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
                final Entry<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(3);
                if (length >= fence) {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index >= 0) {
                        while (true) {
                            final Entry<K, V> current = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current == null) {
                                final int index2 = this.index;
                                final int n = fence;
                                BytecodeManager.incBytecodes(4);
                                if (index2 >= n) {
                                    break;
                                }
                            }
                            final Entry<K, V> current2 = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current2 == null) {
                                this.current = table[this.index++];
                                BytecodeManager.incBytecodes(12);
                            }
                            else {
                                final Entry<K, V> current3 = this.current;
                                BytecodeManager.incBytecodes(3);
                                final Object value = current3.get();
                                BytecodeManager.incBytecodes(1);
                                final V value2 = this.current.value;
                                BytecodeManager.incBytecodes(4);
                                this.current = this.current.next;
                                BytecodeManager.incBytecodes(5);
                                final Object o = value;
                                BytecodeManager.incBytecodes(2);
                                if (o != null) {
                                    final V v = value2;
                                    BytecodeManager.incBytecodes(3);
                                    consumer.accept(v);
                                    final int modCount = this.map.modCount;
                                    final int expectedModCount = this.expectedModCount;
                                    BytecodeManager.incBytecodes(6);
                                    if (modCount != expectedModCount) {
                                        BytecodeManager.incBytecodes(3);
                                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                    final boolean b = true;
                                    BytecodeManager.incBytecodes(2);
                                    return b;
                                }
                                else {
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
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
                final int n = 0;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class EntrySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>>
    {
        EntrySpliterator(final WeakHashMap<K, V> weakHashMap, final int n, final int n2, final int n3, final int n4) {
            try {
                BytecodeManager.incBytecodes(7);
                super(weakHashMap, n, n2, n3, n4);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public EntrySpliterator<K, V> trySplit() {
            try {
                BytecodeManager.incBytecodes(2);
                final int fence = this.getFence();
                final int index = this.index;
                final int n = index + fence >>> 1;
                BytecodeManager.incBytecodes(10);
                final int n2 = index;
                final int n3 = n;
                BytecodeManager.incBytecodes(3);
                EntrySpliterator<K, V> entrySpliterator;
                if (n2 >= n3) {
                    entrySpliterator = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final WeakHashMap<K, V> map;
                    final int n4;
                    final int index2;
                    final int est;
                    final int expectedModCount;
                    entrySpliterator = new EntrySpliterator<K, V>((WeakHashMap<Object, Object>)map, n4, index2, est, expectedModCount);
                    map = this.map;
                    n4 = index;
                    index2 = n;
                    this.index = index2;
                    est = this.est >>> 1;
                    this.est = est;
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(19);
                }
                BytecodeManager.incBytecodes(1);
                return entrySpliterator;
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
                final WeakHashMap<K, V> map = this.map;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V>[] table = map.table;
                BytecodeManager.incBytecodes(3);
                int fence;
                final int n = fence = this.fence;
                BytecodeManager.incBytecodes(5);
                int expectedModCount;
                if (n < 0) {
                    final int modCount = map.modCount;
                    this.expectedModCount = modCount;
                    expectedModCount = modCount;
                    BytecodeManager.incBytecodes(6);
                    final int length = table.length;
                    this.fence = length;
                    fence = length;
                    BytecodeManager.incBytecodes(7);
                }
                else {
                    expectedModCount = this.expectedModCount;
                    BytecodeManager.incBytecodes(3);
                }
                final int length2 = table.length;
                final int n2 = fence;
                BytecodeManager.incBytecodes(4);
                Label_0330: {
                    if (length2 >= n2) {
                        int index;
                        final int n3 = index = this.index;
                        BytecodeManager.incBytecodes(5);
                        if (n3 >= 0) {
                            final int n4 = index;
                            final int index2 = fence;
                            this.index = index2;
                            BytecodeManager.incBytecodes(6);
                            if (n4 >= index2) {
                                final Entry<K, V> current = this.current;
                                BytecodeManager.incBytecodes(3);
                                if (current == null) {
                                    break Label_0330;
                                }
                            }
                            Entry<K, V> entry = this.current;
                            BytecodeManager.incBytecodes(3);
                            this.current = null;
                            BytecodeManager.incBytecodes(3);
                            while (true) {
                                final Entry<K, V> entry2 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry2 == null) {
                                    entry = table[index++];
                                    BytecodeManager.incBytecodes(6);
                                }
                                else {
                                    final Entry<K, V> entry3 = entry;
                                    BytecodeManager.incBytecodes(2);
                                    final Object value = entry3.get();
                                    BytecodeManager.incBytecodes(1);
                                    final V value2 = entry.value;
                                    BytecodeManager.incBytecodes(3);
                                    entry = entry.next;
                                    BytecodeManager.incBytecodes(3);
                                    final Object o = value;
                                    BytecodeManager.incBytecodes(2);
                                    if (o != null) {
                                        final Object o2 = value;
                                        BytecodeManager.incBytecodes(1);
                                        BytecodeManager.incBytecodes(1);
                                        final Object unmaskNull = WeakHashMap.unmaskNull(o2);
                                        BytecodeManager.incBytecodes(1);
                                        final Object o3 = unmaskNull;
                                        final V v = value2;
                                        BytecodeManager.incBytecodes(6);
                                        final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(o3, v);
                                        BytecodeManager.incBytecodes(1);
                                        consumer.accept((Object)simpleImmutableEntry);
                                    }
                                }
                                final Entry<K, V> entry4 = entry;
                                BytecodeManager.incBytecodes(2);
                                if (entry4 == null) {
                                    final int n5 = index;
                                    final int n6 = fence;
                                    BytecodeManager.incBytecodes(3);
                                    if (n5 >= n6) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
                final int modCount2 = map.modCount;
                final int n7 = expectedModCount;
                BytecodeManager.incBytecodes(4);
                if (modCount2 != n7) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
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
                final Entry<K, V>[] table = this.map.table;
                BytecodeManager.incBytecodes(4);
                final int length = table.length;
                BytecodeManager.incBytecodes(4);
                final int fence = this.getFence();
                BytecodeManager.incBytecodes(3);
                if (length >= fence) {
                    final int index = this.index;
                    BytecodeManager.incBytecodes(3);
                    if (index >= 0) {
                        while (true) {
                            final Entry<K, V> current = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current == null) {
                                final int index2 = this.index;
                                final int n = fence;
                                BytecodeManager.incBytecodes(4);
                                if (index2 >= n) {
                                    break;
                                }
                            }
                            final Entry<K, V> current2 = this.current;
                            BytecodeManager.incBytecodes(3);
                            if (current2 == null) {
                                this.current = table[this.index++];
                                BytecodeManager.incBytecodes(12);
                            }
                            else {
                                final Entry<K, V> current3 = this.current;
                                BytecodeManager.incBytecodes(3);
                                final Object value = current3.get();
                                BytecodeManager.incBytecodes(1);
                                final V value2 = this.current.value;
                                BytecodeManager.incBytecodes(4);
                                this.current = this.current.next;
                                BytecodeManager.incBytecodes(5);
                                final Object o = value;
                                BytecodeManager.incBytecodes(2);
                                if (o != null) {
                                    final Object o2 = value;
                                    BytecodeManager.incBytecodes(1);
                                    BytecodeManager.incBytecodes(1);
                                    final Object unmaskNull = WeakHashMap.unmaskNull(o2);
                                    BytecodeManager.incBytecodes(1);
                                    final Object o3 = unmaskNull;
                                    final V v = value2;
                                    BytecodeManager.incBytecodes(6);
                                    final SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(o3, v);
                                    BytecodeManager.incBytecodes(1);
                                    consumer.accept((Object)simpleImmutableEntry);
                                    final int modCount = this.map.modCount;
                                    final int expectedModCount = this.expectedModCount;
                                    BytecodeManager.incBytecodes(6);
                                    if (modCount != expectedModCount) {
                                        BytecodeManager.incBytecodes(3);
                                        final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                                        BytecodeManager.incBytecodes(1);
                                        throw ex2;
                                    }
                                    final boolean b = true;
                                    BytecodeManager.incBytecodes(2);
                                    return b;
                                }
                                else {
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                        }
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
                final int n = 1;
                BytecodeManager.incBytecodes(2);
                return n;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
