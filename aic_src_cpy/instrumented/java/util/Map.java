// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.lang.invoke.SerializedLambda;
import java.io.Serializable;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import aic2021.engine.BytecodeManager;

public interface Map<K, V>
{
    int size();
    
    boolean isEmpty();
    
    boolean containsKey(final Object p0);
    
    boolean containsValue(final Object p0);
    
    V get(final Object p0);
    
    V put(final K p0, final V p1);
    
    V remove(final Object p0);
    
    void putAll(final Map<? extends K, ? extends V> p0);
    
    void clear();
    
    Set<K> keySet();
    
    Collection<V> values();
    
    Set<Entry<K, V>> entrySet();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    default V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final V value = this.get(o);
            BytecodeManager.incBytecodes(3);
            V v2 = null;
            Label_0057: {
                if (value == null) {
                    BytecodeManager.incBytecodes(3);
                    final boolean containsKey = this.containsKey(o);
                    BytecodeManager.incBytecodes(1);
                    if (!containsKey) {
                        v2 = v;
                        BytecodeManager.incBytecodes(1);
                        break Label_0057;
                    }
                }
                v2 = value;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return v2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default void forEach(final BiConsumer<? super K, ? super V> p0) {
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
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //    36: astore_2       
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_2        
        //    43: ldc             2
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: ifeq            175
        //    61: aload_2        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: checkcast       Linstrumented/java/util/Map$Entry;
        //    75: astore_3       
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_3        
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    92: astore          4
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_3        
        //   100: ldc             2
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   110: astore          5
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: goto            152
        //   125: astore          6
        //   127: ldc             501
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: new             Linstrumented/java/util/ConcurrentModificationException;
        //   135: dup            
        //   136: aload           6
        //   138: ldc             4
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:(Ljava/lang/Throwable;)V
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: athrow         
        //   152: aload_1        
        //   153: aload           4
        //   155: aload           5
        //   157: ldc             4
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: invokeinterface instrumented/java/util/function/BiConsumer.accept:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: goto            42
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: return         
        //   181: athrow         
        //   182: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/BiConsumer<-TK;-TV;>;)V
        //    StackMapTable: 00 06 FC 00 2A 07 00 45 FF 00 52 00 04 07 00 02 07 00 54 07 00 45 07 00 08 00 01 07 00 36 FD 00 1A 07 00 05 07 00 05 FF 00 16 00 02 07 00 02 07 00 54 00 00 FF 00 05 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 34
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  81     182    182    183    Ljava/lang/VirtualMachineError;
        //  81     117    125    152    Ljava/lang/IllegalStateException;
        //  0      181    181    182    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0152:
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
    
    default void replaceAll(final BiFunction<? super K, ? super V, ? extends V> p0) {
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
        //    16: ldc             2
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: invokeinterface instrumented/java/util/Map.entrySet:()Linstrumented/java/util/Set;
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: invokeinterface instrumented/java/util/Set.iterator:()Ljava/util/Iterator;
        //    36: astore_2       
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: aload_2        
        //    43: ldc             2
        //    45: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ldc             1
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: ifeq            236
        //    61: aload_2        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: checkcast       Linstrumented/java/util/Map$Entry;
        //    75: astore_3       
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: aload_3        
        //    82: ldc             2
        //    84: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    87: invokeinterface instrumented/java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    92: astore          4
        //    94: ldc             1
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: aload_3        
        //   100: ldc             2
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: invokeinterface instrumented/java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   110: astore          5
        //   112: ldc             1
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: goto            152
        //   125: astore          6
        //   127: ldc             501
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: new             Linstrumented/java/util/ConcurrentModificationException;
        //   135: dup            
        //   136: aload           6
        //   138: ldc             4
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:(Ljava/lang/Throwable;)V
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: athrow         
        //   152: aload_1        
        //   153: aload           4
        //   155: aload           5
        //   157: ldc             4
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   167: astore          5
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: aload_3        
        //   175: aload           5
        //   177: ldc             3
        //   179: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   182: invokeinterface instrumented/java/util/Map$Entry.setValue:(Ljava/lang/Object;)Ljava/lang/Object;
        //   187: pop            
        //   188: ldc             1
        //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: goto            228
        //   201: astore          6
        //   203: ldc             501
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: new             Linstrumented/java/util/ConcurrentModificationException;
        //   211: dup            
        //   212: aload           6
        //   214: ldc             4
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokespecial   instrumented/java/util/ConcurrentModificationException.<init>:(Ljava/lang/Throwable;)V
        //   222: ldc             1
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: athrow         
        //   228: ldc             1
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: goto            42
        //   236: ldc             1
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: return         
        //   242: athrow         
        //   243: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/BiFunction<-TK;-TV;+TV;>;)V
        //    StackMapTable: 00 08 FC 00 2A 07 00 45 FF 00 52 00 04 07 00 02 07 00 64 07 00 45 07 00 08 00 01 07 00 36 FD 00 1A 07 00 05 07 00 05 70 07 00 36 F8 00 1A FA 00 07 FF 00 05 00 00 00 01 07 00 30 FF 00 00 00 00 00 01 07 00 34
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  81     243    243    244    Ljava/lang/VirtualMachineError;
        //  81     117    125    152    Ljava/lang/IllegalStateException;
        //  174    193    201    228    Ljava/lang/IllegalStateException;
        //  0      242    242    243    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0152:
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
    
    default V putIfAbsent(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            Object o = this.get(k);
            BytecodeManager.incBytecodes(1);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                BytecodeManager.incBytecodes(4);
                o = this.put(k, v);
                BytecodeManager.incBytecodes(1);
            }
            final Object o3 = o;
            BytecodeManager.incBytecodes(2);
            return (V)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default boolean remove(final Object o, final Object o2) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(o);
            BytecodeManager.incBytecodes(1);
            final Object o3 = value;
            BytecodeManager.incBytecodes(3);
            final boolean equals = Objects.equals(o3, o2);
            BytecodeManager.incBytecodes(1);
            Label_0070: {
                if (equals) {
                    final Object o4 = value;
                    BytecodeManager.incBytecodes(2);
                    if (o4 == null) {
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean containsKey = this.containsKey(o);
                        BytecodeManager.incBytecodes(1);
                        if (!containsKey) {
                            break Label_0070;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    this.remove(o);
                    BytecodeManager.incBytecodes(1);
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
    
    default boolean replace(final K k, final V v, final V v2) {
        try {
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(k);
            BytecodeManager.incBytecodes(1);
            final Object o = value;
            BytecodeManager.incBytecodes(3);
            final boolean equals = Objects.equals(o, v);
            BytecodeManager.incBytecodes(1);
            Label_0073: {
                if (equals) {
                    final Object o2 = value;
                    BytecodeManager.incBytecodes(2);
                    if (o2 == null) {
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                        final boolean containsKey = this.containsKey(k);
                        BytecodeManager.incBytecodes(1);
                        if (!containsKey) {
                            break Label_0073;
                        }
                    }
                    BytecodeManager.incBytecodes(4);
                    this.put(k, v2);
                    BytecodeManager.incBytecodes(1);
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
    
    default V replace(final K k, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            Object o2;
            final Object o = o2 = this.get(k);
            BytecodeManager.incBytecodes(3);
            Label_0061: {
                if (o == null) {
                    BytecodeManager.incBytecodes(3);
                    final boolean containsKey = this.containsKey(k);
                    BytecodeManager.incBytecodes(1);
                    if (!containsKey) {
                        break Label_0061;
                    }
                }
                BytecodeManager.incBytecodes(4);
                o2 = this.put(k, v);
                BytecodeManager.incBytecodes(1);
            }
            final Object o3 = o2;
            BytecodeManager.incBytecodes(2);
            return (V)o3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final V value = this.get(k);
            BytecodeManager.incBytecodes(3);
            if (value == null) {
                BytecodeManager.incBytecodes(3);
                final V apply;
                final Object o = apply = (V)function.apply(k);
                BytecodeManager.incBytecodes(3);
                if (o != null) {
                    final V v = apply;
                    BytecodeManager.incBytecodes(4);
                    this.put(k, v);
                    BytecodeManager.incBytecodes(1);
                    final V v2 = apply;
                    BytecodeManager.incBytecodes(2);
                    return v2;
                }
            }
            final V v3 = value;
            BytecodeManager.incBytecodes(2);
            return v3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default V computeIfPresent(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(k);
            BytecodeManager.incBytecodes(3);
            if (value == null) {
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final Object o = value;
            BytecodeManager.incBytecodes(4);
            final V apply = (V)biFunction.apply(k, (Object)o);
            BytecodeManager.incBytecodes(1);
            final V v2 = apply;
            BytecodeManager.incBytecodes(2);
            if (v2 != null) {
                final V v3 = apply;
                BytecodeManager.incBytecodes(4);
                this.put(k, v3);
                BytecodeManager.incBytecodes(1);
                final V v4 = apply;
                BytecodeManager.incBytecodes(2);
                return v4;
            }
            BytecodeManager.incBytecodes(3);
            this.remove(k);
            BytecodeManager.incBytecodes(1);
            final V v5 = null;
            BytecodeManager.incBytecodes(2);
            return v5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default V compute(final K k, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(k);
            BytecodeManager.incBytecodes(1);
            final Object o = value;
            BytecodeManager.incBytecodes(4);
            final V apply = (V)biFunction.apply(k, (Object)o);
            BytecodeManager.incBytecodes(1);
            final V v = apply;
            BytecodeManager.incBytecodes(2);
            if (v == null) {
                final Object o2 = value;
                BytecodeManager.incBytecodes(2);
                if (o2 == null) {
                    BytecodeManager.incBytecodes(3);
                    final boolean containsKey = this.containsKey(k);
                    BytecodeManager.incBytecodes(1);
                    if (!containsKey) {
                        final V v2 = null;
                        BytecodeManager.incBytecodes(2);
                        return v2;
                    }
                }
                BytecodeManager.incBytecodes(3);
                this.remove(k);
                BytecodeManager.incBytecodes(1);
                final V v3 = null;
                BytecodeManager.incBytecodes(2);
                return v3;
            }
            final V v4 = apply;
            BytecodeManager.incBytecodes(4);
            this.put(k, v4);
            BytecodeManager.incBytecodes(1);
            final V v5 = apply;
            BytecodeManager.incBytecodes(2);
            return v5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    default V merge(final K k, final V v, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(biFunction);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(v);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            final Object value = this.get(k);
            BytecodeManager.incBytecodes(1);
            final Object o = value;
            BytecodeManager.incBytecodes(2);
            V apply;
            if (o == null) {
                apply = v;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Object o2 = value;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                apply = (V)biFunction.apply(o2, v);
            }
            final V v2 = apply;
            BytecodeManager.incBytecodes(1);
            final V v3 = v2;
            BytecodeManager.incBytecodes(2);
            if (v3 == null) {
                BytecodeManager.incBytecodes(3);
                this.remove(k);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final V v4 = v2;
                BytecodeManager.incBytecodes(4);
                this.put(k, v4);
                BytecodeManager.incBytecodes(1);
            }
            final V v5 = v2;
            BytecodeManager.incBytecodes(2);
            return v5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public interface Entry<K, V>
    {
        K getKey();
        
        V getValue();
        
        V setValue(final V p0);
        
        boolean equals(final Object p0);
        
        int hashCode();
        
        default <K extends Comparable<? super K>, V> Comparator<Entry<K, V>> comparingByKey() {
            try {
                Comparable<Object> comparable;
                final Object o;
                final int n;
                final Comparator comparator = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(2);
                        comparable = entry.getKey();
                        BytecodeManager.incBytecodes(3);
                        entry2.getKey();
                        BytecodeManager.incBytecodes(1);
                        comparable.compareTo(o);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(3);
                return (Comparator<Entry<K, V>>)comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default <K, V extends Comparable<? super V>> Comparator<Entry<K, V>> comparingByValue() {
            try {
                Comparable<Object> comparable;
                final Object o;
                final int n;
                final Comparator comparator = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(2);
                        comparable = entry.getValue();
                        BytecodeManager.incBytecodes(3);
                        entry2.getValue();
                        BytecodeManager.incBytecodes(1);
                        comparable.compareTo(o);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(3);
                return (Comparator<Entry<K, V>>)comparator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default <K, V> Comparator<Entry<K, V>> comparingByKey(final Comparator<? super K> comparator) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(comparator);
                BytecodeManager.incBytecodes(1);
                final Object o;
                final Object o2;
                final int n;
                final Comparator comparator2 = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(3);
                        entry.getKey();
                        BytecodeManager.incBytecodes(2);
                        entry2.getKey();
                        BytecodeManager.incBytecodes(1);
                        comparator.compare((Object)o, (Object)o2);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(4);
                return (Comparator<Entry<K, V>>)comparator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        default <K, V> Comparator<Entry<K, V>> comparingByValue(final Comparator<? super V> comparator) {
            try {
                BytecodeManager.incBytecodes(2);
                Objects.requireNonNull(comparator);
                BytecodeManager.incBytecodes(1);
                final Object o;
                final Object o2;
                final int n;
                final Comparator comparator2 = (entry, entry2) -> {
                    try {
                        BytecodeManager.incBytecodes(3);
                        entry.getValue();
                        BytecodeManager.incBytecodes(2);
                        entry2.getValue();
                        BytecodeManager.incBytecodes(1);
                        comparator.compare((Object)o, (Object)o2);
                        BytecodeManager.incBytecodes(1);
                        return n;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                };
                BytecodeManager.incBytecodes(4);
                return (Comparator<Entry<K, V>>)comparator2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
