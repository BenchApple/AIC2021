// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import java.util.Iterator;
import aic2021.engine.BytecodeManager;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>
{
    protected AbstractSet() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
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
        //    46: aload_2        
        //    47: ldc             2
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokeinterface instrumented/java/util/Collection.size:()I
        //    57: aload_0        
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: invokevirtual   instrumented/java/util/AbstractSet.size:()I
        //    66: ldc             1
        //    68: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    71: if_icmpeq       81
        //    74: iconst_0       
        //    75: ldc             2
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: ireturn        
        //    81: aload_0        
        //    82: aload_2        
        //    83: ldc             3
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: invokevirtual   instrumented/java/util/AbstractSet.containsAll:(Linstrumented/java/util/Collection;)Z
        //    91: ldc             1
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: ireturn        
        //    97: astore_3       
        //    98: ldc             501
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: iconst_0       
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ireturn        
        //   110: astore_3       
        //   111: ldc             501
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: iconst_0       
        //   117: ldc             2
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: ireturn        
        //   123: athrow         
        //   124: athrow         
        //    StackMapTable: 00 07 11 12 FC 00 2C 07 00 21 4F 07 00 1C 4C 07 00 1E FF 00 0C 00 00 00 01 07 00 16 FF 00 00 00 00 00 01 07 00 1A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  81     124    124    125    Ljava/lang/VirtualMachineError;
        //  81     91     97     110    Ljava/lang/ClassCastException;
        //  81     91     110    123    Ljava/lang/NullPointerException;
        //  0      123    123    124    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0081:
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
    public int hashCode() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final Iterator<E> iterator = this.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<E> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<E> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final E next = iterator3.next();
                BytecodeManager.incBytecodes(1);
                final E e = next;
                BytecodeManager.incBytecodes(2);
                if (e != null) {
                    final int n2 = n;
                    final E e2 = next;
                    BytecodeManager.incBytecodes(3);
                    n = n2 + e2.hashCode();
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            final int n3 = n;
            BytecodeManager.incBytecodes(2);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        try {
            BytecodeManager.incBytecodes(2);
            Objects.requireNonNull(collection);
            BytecodeManager.incBytecodes(1);
            int n = 0;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(2);
            final int size = this.size();
            BytecodeManager.incBytecodes(2);
            final int size2 = collection.size();
            BytecodeManager.incBytecodes(1);
            if (size > size2) {
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
                    final boolean b = n != 0;
                    final Iterator<?> iterator3 = iterator;
                    BytecodeManager.incBytecodes(4);
                    final Object next = iterator3.next();
                    BytecodeManager.incBytecodes(1);
                    n = ((b | this.remove(next)) ? 1 : 0);
                    BytecodeManager.incBytecodes(3);
                }
                BytecodeManager.incBytecodes(1);
            }
            else {
                BytecodeManager.incBytecodes(2);
                final Iterator<Object> iterator4 = this.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<Object> iterator5 = iterator4;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext2 = iterator5.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext2) {
                        break;
                    }
                    final Iterator<Object> iterator6 = iterator4;
                    BytecodeManager.incBytecodes(3);
                    final Object next2 = iterator6.next();
                    BytecodeManager.incBytecodes(1);
                    final boolean contains = collection.contains(next2);
                    BytecodeManager.incBytecodes(1);
                    if (!contains) {
                        continue;
                    }
                    final Iterator<Object> iterator7 = iterator4;
                    BytecodeManager.incBytecodes(2);
                    iterator7.remove();
                    n = (true ? 1 : 0);
                    BytecodeManager.incBytecodes(3);
                }
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2 != 0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
