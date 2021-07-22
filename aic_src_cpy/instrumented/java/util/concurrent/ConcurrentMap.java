// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.Objects;
import instrumented.java.util.function.Function;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Map;

public interface ConcurrentMap<K, V> extends Map<K, V>
{
    default V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final V value = this.get(o);
            BytecodeManager.incBytecodes(3);
            V v2;
            if (value != null) {
                v2 = value;
                BytecodeManager.incBytecodes(2);
            }
            else {
                v2 = v;
                BytecodeManager.incBytecodes(1);
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
        //    21: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.entrySet:()Linstrumented/java/util/Set;
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
        //    58: ifeq            163
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
        //   122: goto            140
        //   125: astore          6
        //   127: ldc             501
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: ldc             1
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: goto            42
        //   140: aload_1        
        //   141: aload           4
        //   143: aload           5
        //   145: ldc             4
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokeinterface instrumented/java/util/function/BiConsumer.accept:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   155: ldc             1
        //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   160: goto            42
        //   163: ldc             1
        //   165: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   168: return         
        //   169: athrow         
        //   170: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/BiConsumer<-TK;-TV;>;)V
        //    StackMapTable: 00 06 FC 00 2A 07 00 38 FF 00 52 00 04 07 00 02 07 00 48 07 00 38 07 00 0A 00 01 07 00 27 FD 00 0E 07 00 05 07 00 05 FF 00 16 00 02 07 00 02 07 00 48 00 00 FF 00 05 00 00 00 01 07 00 21 FF 00 00 00 00 00 01 07 00 25
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  81     170    170    171    Ljava/lang/VirtualMachineError;
        //  81     117    125    140    Ljava/lang/IllegalStateException;
        //  0      169    169    170    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0140:
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
    
    V putIfAbsent(final K p0, final V p1);
    
    boolean remove(final Object p0, final Object p1);
    
    boolean replace(final K p0, final V p1, final V p2);
    
    V replace(final K p0, final V p1);
    
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
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokedynamic   BootstrapMethod #0, accept:(Linstrumented/java/util/concurrent/ConcurrentMap;Linstrumented/java/util/function/BiFunction;)Linstrumented/java/util/function/BiConsumer;
        //    23: ldc             4
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.forEach:(Linstrumented/java/util/function/BiConsumer;)V
        //    33: ldc             1
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: return         
        //    39: athrow         
        //    Signature:
        //  (Linstrumented/java/util/function/BiFunction<-TK;-TV;+TV;>;)V
        //    StackMapTable: 00 01 FF 00 27 00 00 00 01 07 00 21
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      39     39     40     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Unsupported node type: com.strobel.decompiler.ast.Lambda
        //     at com.strobel.decompiler.ast.Error.unsupportedNode(Error.java:32)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:612)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:586)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:598)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:586)
        //     at com.strobel.decompiler.ast.GotoRemoval.transformLeaveStatements(GotoRemoval.java:625)
        //     at com.strobel.decompiler.ast.GotoRemoval.removeGotosCore(GotoRemoval.java:57)
        //     at com.strobel.decompiler.ast.GotoRemoval.removeGotos(GotoRemoval.java:53)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:276)
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
    
    default V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(function);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            Object o = this.get(k);
            BytecodeManager.incBytecodes(3);
            Object o4 = null;
            Label_0110: {
                if (o == null) {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final V apply;
                    final Object o2 = apply = (V)function.apply(k);
                    BytecodeManager.incBytecodes(3);
                    if (o2 != null) {
                        final V v = apply;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        final Object o3 = o = this.putIfAbsent(k, v);
                        BytecodeManager.incBytecodes(3);
                        if (o3 == null) {
                            o4 = apply;
                            BytecodeManager.incBytecodes(2);
                            break Label_0110;
                        }
                    }
                }
                o4 = o;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return (V)o4;
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
            while (true) {
                BytecodeManager.incBytecodes(3);
                final V value;
                final V v = value = this.get(k);
                BytecodeManager.incBytecodes(3);
                if (v == null) {
                    final V v2 = value;
                    BytecodeManager.incBytecodes(2);
                    return v2;
                }
                final V v3 = value;
                BytecodeManager.incBytecodes(4);
                final V apply = (V)biFunction.apply(k, v3);
                BytecodeManager.incBytecodes(1);
                final V v4 = apply;
                BytecodeManager.incBytecodes(2);
                if (v4 != null) {
                    final V v5 = value;
                    final V v6 = apply;
                    BytecodeManager.incBytecodes(5);
                    final boolean replace = this.replace(k, v5, v6);
                    BytecodeManager.incBytecodes(1);
                    if (replace) {
                        final V v7 = apply;
                        BytecodeManager.incBytecodes(2);
                        return v7;
                    }
                }
                else {
                    final V v8 = value;
                    BytecodeManager.incBytecodes(4);
                    final boolean remove = this.remove(k, v8);
                    BytecodeManager.incBytecodes(1);
                    if (remove) {
                        final V v9 = null;
                        BytecodeManager.incBytecodes(2);
                        return v9;
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
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
            Object o = this.get(k);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o2 = o;
                BytecodeManager.incBytecodes(4);
                final V apply = (V)biFunction.apply(k, (V)o2);
                BytecodeManager.incBytecodes(1);
                final V v = apply;
                BytecodeManager.incBytecodes(2);
                if (v == null) {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o3 == null) {
                        BytecodeManager.incBytecodes(3);
                        final boolean containsKey = this.containsKey(k);
                        BytecodeManager.incBytecodes(1);
                        if (!containsKey) {
                            final V v2 = null;
                            BytecodeManager.incBytecodes(2);
                            return v2;
                        }
                    }
                    final Object o4 = o;
                    BytecodeManager.incBytecodes(4);
                    final boolean remove = this.remove(k, o4);
                    BytecodeManager.incBytecodes(1);
                    if (remove) {
                        final V v3 = null;
                        BytecodeManager.incBytecodes(2);
                        return v3;
                    }
                    BytecodeManager.incBytecodes(3);
                    o = this.get(k);
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    final Object o5 = o;
                    BytecodeManager.incBytecodes(2);
                    if (o5 != null) {
                        final Object o6 = o;
                        final V v4 = apply;
                        BytecodeManager.incBytecodes(5);
                        final boolean replace = this.replace(k, (V)o6, v4);
                        BytecodeManager.incBytecodes(1);
                        if (replace) {
                            final V v5 = apply;
                            BytecodeManager.incBytecodes(2);
                            return v5;
                        }
                        BytecodeManager.incBytecodes(3);
                        o = this.get(k);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final V v6 = apply;
                        BytecodeManager.incBytecodes(4);
                        final Object o7 = o = this.putIfAbsent(k, v6);
                        BytecodeManager.incBytecodes(3);
                        if (o7 == null) {
                            final V v7 = apply;
                            BytecodeManager.incBytecodes(2);
                            return v7;
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
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
            Object o = this.get(k);
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Object o2 = o;
                BytecodeManager.incBytecodes(2);
                if (o2 != null) {
                    final Object o3 = o;
                    BytecodeManager.incBytecodes(4);
                    final V apply = (V)biFunction.apply((V)o3, v);
                    BytecodeManager.incBytecodes(1);
                    final V v2 = apply;
                    BytecodeManager.incBytecodes(2);
                    if (v2 != null) {
                        final Object o4 = o;
                        final V v3 = apply;
                        BytecodeManager.incBytecodes(5);
                        final boolean replace = this.replace(k, (V)o4, v3);
                        BytecodeManager.incBytecodes(1);
                        if (replace) {
                            final V v4 = apply;
                            BytecodeManager.incBytecodes(2);
                            return v4;
                        }
                    }
                    else {
                        final Object o5 = o;
                        BytecodeManager.incBytecodes(4);
                        final boolean remove = this.remove(k, o5);
                        BytecodeManager.incBytecodes(1);
                        if (remove) {
                            final V v5 = null;
                            BytecodeManager.incBytecodes(2);
                            return v5;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    o = this.get(k);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    BytecodeManager.incBytecodes(4);
                    final Object o6 = o = this.putIfAbsent(k, v);
                    BytecodeManager.incBytecodes(3);
                    if (o6 == null) {
                        BytecodeManager.incBytecodes(2);
                        return v;
                    }
                    continue;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
