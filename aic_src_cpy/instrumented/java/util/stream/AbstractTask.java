// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.concurrent.ForkJoinPool;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.concurrent.CountedCompleter;

abstract class AbstractTask<P_IN, P_OUT, R, K extends AbstractTask<P_IN, P_OUT, R, K>> extends CountedCompleter<R>
{
    static final int LEAF_TARGET;
    protected final PipelineHelper<P_OUT> helper;
    protected Spliterator<P_IN> spliterator;
    protected long targetSize;
    protected K leftChild;
    protected K rightChild;
    private R localResult;
    
    protected AbstractTask(final PipelineHelper<P_OUT> helper, final Spliterator<P_IN> spliterator) {
        try {
            final CountedCompleter countedCompleter = null;
            BytecodeManager.incBytecodes(3);
            super(countedCompleter);
            this.helper = helper;
            BytecodeManager.incBytecodes(3);
            this.spliterator = spliterator;
            BytecodeManager.incBytecodes(3);
            this.targetSize = 0L;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AbstractTask(final K k, final Spliterator<P_IN> spliterator) {
        try {
            BytecodeManager.incBytecodes(3);
            super(k);
            this.spliterator = spliterator;
            BytecodeManager.incBytecodes(3);
            this.helper = k.helper;
            BytecodeManager.incBytecodes(4);
            this.targetSize = k.targetSize;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract K makeChild(final Spliterator<P_IN> p0);
    
    protected abstract R doLeaf();
    
    public static long suggestTargetSize(final long n) {
        try {
            final long n2 = n / AbstractTask.LEAF_TARGET;
            BytecodeManager.incBytecodes(5);
            final long n3 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            long n4;
            if (n3 > 0) {
                n4 = n2;
                BytecodeManager.incBytecodes(2);
            }
            else {
                n4 = 1L;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return n4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected final long getTargetSize(final long n) {
        try {
            final long targetSize;
            final long n2 = lcmp(targetSize = this.targetSize, 0L);
            BytecodeManager.incBytecodes(7);
            long n3;
            if (n2 != 0) {
                n3 = targetSize;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                n3 = (this.targetSize = suggestTargetSize(n));
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return n3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public R getRawResult() {
        try {
            final R localResult = this.localResult;
            BytecodeManager.incBytecodes(3);
            return localResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void setRawResult(final R r) {
        try {
            BytecodeManager.incBytecodes(2);
            if (r != null) {
                BytecodeManager.incBytecodes(3);
                final IllegalStateException ex = new IllegalStateException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected R getLocalResult() {
        try {
            final R localResult = this.localResult;
            BytecodeManager.incBytecodes(3);
            return localResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void setLocalResult(final R localResult) {
        try {
            this.localResult = localResult;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected boolean isLeaf() {
        try {
            final AbstractTask<P_IN, P_OUT, R, K> leftChild = this.leftChild;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (leftChild == null) {
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
    
    protected boolean isRoot() {
        try {
            BytecodeManager.incBytecodes(2);
            final Object parent = this.getParent();
            BytecodeManager.incBytecodes(1);
            boolean b;
            if (parent == null) {
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
    
    protected K getParent() {
        try {
            BytecodeManager.incBytecodes(2);
            final AbstractTask abstractTask = (AbstractTask)this.getCompleter();
            BytecodeManager.incBytecodes(2);
            return (K)abstractTask;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void compute() {
        try {
            Spliterator<P_IN> spliterator = this.spliterator;
            BytecodeManager.incBytecodes(3);
            final Spliterator<P_IN> spliterator2 = spliterator;
            BytecodeManager.incBytecodes(2);
            long n = spliterator2.estimateSize();
            BytecodeManager.incBytecodes(1);
            final long n2 = n;
            BytecodeManager.incBytecodes(3);
            final long targetSize = this.getTargetSize(n2);
            BytecodeManager.incBytecodes(1);
            boolean b = false;
            BytecodeManager.incBytecodes(2);
            AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask = (AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>>)this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final long n3 = lcmp(n, targetSize);
                BytecodeManager.incBytecodes(4);
                if (n3 <= 0) {
                    break;
                }
                final Spliterator<P_IN> spliterator3 = spliterator;
                BytecodeManager.incBytecodes(2);
                final Spliterator<P_IN> trySplit;
                final Spliterator<P_IN> spliterator4 = trySplit = spliterator3.trySplit();
                BytecodeManager.incBytecodes(3);
                if (spliterator4 == null) {
                    break;
                }
                final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask2 = abstractTask;
                final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask3 = abstractTask;
                final Spliterator<P_IN> spliterator5 = trySplit;
                BytecodeManager.incBytecodes(4);
                final AbstractTask<P_IN, P_OUT, R, K> abstractTask4 = (AbstractTask<P_IN, P_OUT, R, K>)(abstractTask2.leftChild = abstractTask3.makeChild(spliterator5));
                BytecodeManager.incBytecodes(3);
                final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask5 = abstractTask;
                final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask6 = abstractTask;
                final Spliterator<P_IN> spliterator6 = spliterator;
                BytecodeManager.incBytecodes(4);
                final AbstractTask<P_IN, P_OUT, R, K> abstractTask7 = (AbstractTask<P_IN, P_OUT, R, K>)(abstractTask5.rightChild = abstractTask6.makeChild(spliterator6));
                BytecodeManager.incBytecodes(3);
                final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask8 = abstractTask;
                final int pendingCount = 1;
                BytecodeManager.incBytecodes(3);
                abstractTask8.setPendingCount(pendingCount);
                final boolean b2 = b;
                BytecodeManager.incBytecodes(2);
                AbstractTask<P_IN, P_OUT, R, K> abstractTask9;
                if (b2) {
                    b = false;
                    BytecodeManager.incBytecodes(2);
                    spliterator = trySplit;
                    BytecodeManager.incBytecodes(2);
                    abstractTask = (AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>>)abstractTask4;
                    BytecodeManager.incBytecodes(2);
                    abstractTask9 = abstractTask7;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                    abstractTask = (AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>>)abstractTask7;
                    BytecodeManager.incBytecodes(2);
                    abstractTask9 = abstractTask4;
                    BytecodeManager.incBytecodes(2);
                }
                final AbstractTask<P_IN, P_OUT, R, K> abstractTask10 = abstractTask9;
                BytecodeManager.incBytecodes(2);
                abstractTask10.fork();
                BytecodeManager.incBytecodes(1);
                final Spliterator<P_IN> spliterator7 = spliterator;
                BytecodeManager.incBytecodes(2);
                n = spliterator7.estimateSize();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask11 = abstractTask;
            final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask12 = abstractTask;
            BytecodeManager.incBytecodes(3);
            final R doLeaf = abstractTask12.doLeaf();
            BytecodeManager.incBytecodes(1);
            abstractTask11.setLocalResult(doLeaf);
            final AbstractTask<P_IN, P_OUT, R, AbstractTask<P_IN, P_OUT, Object, AbstractTask>> abstractTask13 = abstractTask;
            BytecodeManager.incBytecodes(2);
            abstractTask13.tryComplete();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void onCompletion(final CountedCompleter<?> countedCompleter) {
        try {
            this.spliterator = null;
            BytecodeManager.incBytecodes(3);
            final AbstractTask<P_IN, P_OUT, R, K> abstractTask = null;
            this.rightChild = (K)abstractTask;
            this.leftChild = (K)abstractTask;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected boolean isLeftmostNode() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_1        
        //     8: ldc             2
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: ifnull          75
        //    16: aload_1        
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: invokevirtual   instrumented/java/util/stream/AbstractTask.getParent:()Linstrumented/java/util/stream/AbstractTask;
        //    25: astore_2       
        //    26: ldc             1
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: aload_2        
        //    32: ldc             2
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: ifnull          60
        //    40: aload_2        
        //    41: getfield        instrumented/java/util/stream/AbstractTask.leftChild:Linstrumented/java/util/stream/AbstractTask;
        //    44: aload_1        
        //    45: ldc             4
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: if_acmpeq       60
        //    53: iconst_0       
        //    54: ldc             2
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: ireturn        
        //    60: aload_2        
        //    61: astore_1       
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ldc             1
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: goto            7
        //    75: iconst_1       
        //    76: ldc             2
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ireturn        
        //    82: athrow         
        //    StackMapTable: 00 04 FC 00 07 07 00 02 FC 00 34 07 00 02 FA 00 0E FF 00 06 00 00 00 01 07 00 2C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      82     82     83     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:276)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:770)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:881)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypesForVariables(TypeAnalysis.java:586)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:397)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
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
    
    static {
        try {
            BytecodeManager.incBytecodes(1);
            LEAF_TARGET = ForkJoinPool.getCommonPoolParallelism() << 2;
            BytecodeManager.incBytecodes(4);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
