// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

public class Observable
{
    private boolean changed;
    private Vector<Observer> obs;
    
    public Observable() {
        try {
            BytecodeManager.incBytecodes(2);
            this.changed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.obs = new Vector<Observer>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void addObserver(final Observer observer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (observer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final Vector<Observer> obs = this.obs;
            BytecodeManager.incBytecodes(4);
            final boolean contains = obs.contains(observer);
            BytecodeManager.incBytecodes(1);
            if (!contains) {
                final Vector<Observer> obs2 = this.obs;
                BytecodeManager.incBytecodes(4);
                obs2.addElement(observer);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized void deleteObserver(final Observer observer) {
        try {
            final Vector<Observer> obs = this.obs;
            BytecodeManager.incBytecodes(4);
            obs.removeElement(observer);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void notifyObservers() {
        try {
            final Object o = null;
            BytecodeManager.incBytecodes(3);
            this.notifyObservers(o);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void notifyObservers(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore_3       
        //     3: pop            
        //     4: ldc             4
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: aload_0        
        //    10: getfield        instrumented/java/util/Observable.changed:Z
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: ifne            34
        //    21: aload_3        
        //    22: pop            
        //    23: ldc             2
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: ldc             1
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: return         
        //    34: aload_0        
        //    35: getfield        instrumented/java/util/Observable.obs:Linstrumented/java/util/Vector;
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokevirtual   instrumented/java/util/Vector.toArray:()[Ljava/lang/Object;
        //    46: astore_2       
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: aload_0        
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokevirtual   instrumented/java/util/Observable.clearChanged:()V
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
        //    93: aload_2        
        //    94: arraylength    
        //    95: iconst_1       
        //    96: isub           
        //    97: istore_3       
        //    98: ldc             5
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: iload_3        
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: iflt            141
        //   112: aload_2        
        //   113: iload_3        
        //   114: aaload         
        //   115: checkcast       Linstrumented/java/util/Observer;
        //   118: aload_0        
        //   119: aload_1        
        //   120: ldc             7
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: invokeinterface instrumented/java/util/Observer.update:(Linstrumented/java/util/Observable;Ljava/lang/Object;)V
        //   130: iinc            3, -1
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: goto            103
        //   141: ldc             1
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: return         
        //   147: athrow         
        //   148: athrow         
        //    StackMapTable: 00 07 FD 00 22 00 07 00 04 69 07 00 21 FF 00 10 00 03 07 00 02 07 00 04 07 00 41 00 00 FC 00 09 01 FA 00 25 FF 00 05 00 00 00 01 07 00 21 FF 00 00 00 00 00 01 07 00 37
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  9      148    148    149    Ljava/lang/VirtualMachineError;
        //  9      28     76     93     Any
        //  34     68     76     93     Any
        //  76     85     76     93     Any
        //  0      147    147    148    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
    
    public synchronized void deleteObservers() {
        try {
            final Vector<Observer> obs = this.obs;
            BytecodeManager.incBytecodes(3);
            obs.removeAllElements();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected synchronized void setChanged() {
        try {
            this.changed = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected synchronized void clearChanged() {
        try {
            this.changed = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized boolean hasChanged() {
        try {
            final boolean changed = this.changed;
            BytecodeManager.incBytecodes(3);
            return changed;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public synchronized int countObservers() {
        try {
            final Vector<Observer> obs = this.obs;
            BytecodeManager.incBytecodes(3);
            final int size = obs.size();
            BytecodeManager.incBytecodes(1);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
