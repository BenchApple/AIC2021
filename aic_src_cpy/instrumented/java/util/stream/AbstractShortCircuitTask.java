// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.stream;

import instrumented.java.util.concurrent.CountedCompleter;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.Spliterator;
import instrumented.java.util.concurrent.atomic.AtomicReference;

abstract class AbstractShortCircuitTask<P_IN, P_OUT, R, K extends AbstractShortCircuitTask<P_IN, P_OUT, R, K>> extends AbstractTask<P_IN, P_OUT, R, K>
{
    protected final AtomicReference<R> sharedResult;
    protected volatile boolean canceled;
    
    protected AbstractShortCircuitTask(final PipelineHelper<P_OUT> pipelineHelper, final Spliterator<P_IN> spliterator) {
        try {
            BytecodeManager.incBytecodes(4);
            super(pipelineHelper, spliterator);
            final R r = null;
            BytecodeManager.incBytecodes(5);
            this.sharedResult = new AtomicReference<R>(r);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected AbstractShortCircuitTask(final K k, final Spliterator<P_IN> spliterator) {
        try {
            BytecodeManager.incBytecodes(4);
            super(k, spliterator);
            this.sharedResult = k.sharedResult;
            BytecodeManager.incBytecodes(4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract R getEmptyResult();
    
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
            AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask = (AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask>)this;
            BytecodeManager.incBytecodes(2);
            final AtomicReference<R> sharedResult = this.sharedResult;
            BytecodeManager.incBytecodes(3);
            Object o = null;
            Label_0371: {
                Label_0168: {
                    while (true) {
                        final AtomicReference<R> atomicReference = sharedResult;
                        BytecodeManager.incBytecodes(2);
                        final R r = (R)(o = atomicReference.get());
                        BytecodeManager.incBytecodes(3);
                        if (r != null) {
                            break Label_0371;
                        }
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask2 = abstractShortCircuitTask;
                        BytecodeManager.incBytecodes(2);
                        final boolean taskCanceled = abstractShortCircuitTask2.taskCanceled();
                        BytecodeManager.incBytecodes(1);
                        if (taskCanceled) {
                            break;
                        }
                        final long n3 = lcmp(n, targetSize);
                        BytecodeManager.incBytecodes(4);
                        if (n3 <= 0) {
                            break Label_0168;
                        }
                        final Spliterator<P_IN> spliterator3 = spliterator;
                        BytecodeManager.incBytecodes(2);
                        final Spliterator<P_IN> trySplit;
                        final Spliterator<P_IN> spliterator4 = trySplit = spliterator3.trySplit();
                        BytecodeManager.incBytecodes(3);
                        if (spliterator4 == null) {
                            break Label_0168;
                        }
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask3 = abstractShortCircuitTask;
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask4 = abstractShortCircuitTask;
                        final Spliterator<P_IN> spliterator5 = trySplit;
                        BytecodeManager.incBytecodes(4);
                        final AbstractTask<P_IN, P_OUT, R, K> abstractTask = (AbstractTask<P_IN, P_OUT, R, K>)(abstractShortCircuitTask3.leftChild = (AbstractShortCircuitTask<P_IN, Object, Object, AbstractShortCircuitTask>)abstractShortCircuitTask4.makeChild(spliterator5));
                        BytecodeManager.incBytecodes(4);
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask5 = abstractShortCircuitTask;
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask6 = abstractShortCircuitTask;
                        final Spliterator<P_IN> spliterator6 = spliterator;
                        BytecodeManager.incBytecodes(4);
                        final AbstractTask<P_IN, P_OUT, R, K> abstractTask2 = (AbstractTask<P_IN, P_OUT, R, K>)(abstractShortCircuitTask5.rightChild = (AbstractShortCircuitTask<P_IN, P_OUT, Object, AbstractShortCircuitTask<P_IN, P_OUT, Object, AbstractShortCircuitTask<P_IN, P_OUT, Object, AbstractShortCircuitTask<P_IN, P_OUT, Object, AbstractShortCircuitTask<P_IN, P_OUT, Object, K>>>>>)abstractShortCircuitTask6.makeChild(spliterator6));
                        BytecodeManager.incBytecodes(4);
                        final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask7 = abstractShortCircuitTask;
                        final int pendingCount = 1;
                        BytecodeManager.incBytecodes(3);
                        abstractShortCircuitTask7.setPendingCount(pendingCount);
                        final boolean b2 = b;
                        BytecodeManager.incBytecodes(2);
                        CountedCompleter<R> countedCompleter;
                        if (b2) {
                            b = false;
                            BytecodeManager.incBytecodes(2);
                            spliterator = trySplit;
                            BytecodeManager.incBytecodes(2);
                            abstractShortCircuitTask = (AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask>)abstractTask;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = abstractTask2;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            abstractShortCircuitTask = (AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask>)abstractTask2;
                            BytecodeManager.incBytecodes(2);
                            countedCompleter = abstractTask;
                            BytecodeManager.incBytecodes(2);
                        }
                        final CountedCompleter<R> countedCompleter2 = countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter2.fork();
                        BytecodeManager.incBytecodes(1);
                        final Spliterator<P_IN> spliterator7 = spliterator;
                        BytecodeManager.incBytecodes(2);
                        n = spliterator7.estimateSize();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask8 = abstractShortCircuitTask;
                    BytecodeManager.incBytecodes(2);
                    o = abstractShortCircuitTask8.getEmptyResult();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    break Label_0371;
                }
                final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask9 = abstractShortCircuitTask;
                BytecodeManager.incBytecodes(2);
                o = abstractShortCircuitTask9.doLeaf();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask10 = abstractShortCircuitTask;
            final Object localResult = o;
            BytecodeManager.incBytecodes(3);
            abstractShortCircuitTask10.setLocalResult(localResult);
            final AbstractShortCircuitTask<P_IN, Object, Object, AbstractTask> abstractShortCircuitTask11 = abstractShortCircuitTask;
            BytecodeManager.incBytecodes(2);
            abstractShortCircuitTask11.tryComplete();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void shortCircuit(final R r) {
        try {
            BytecodeManager.incBytecodes(2);
            if (r != null) {
                final AtomicReference<R> sharedResult = this.sharedResult;
                final R r2 = null;
                BytecodeManager.incBytecodes(5);
                sharedResult.compareAndSet(r2, r);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void setLocalResult(final R localResult) {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean root = this.isRoot();
            BytecodeManager.incBytecodes(1);
            if (root) {
                BytecodeManager.incBytecodes(2);
                if (localResult != null) {
                    final AtomicReference<R> sharedResult = this.sharedResult;
                    final R r = null;
                    BytecodeManager.incBytecodes(5);
                    sharedResult.compareAndSet(r, localResult);
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                BytecodeManager.incBytecodes(3);
                super.setLocalResult(localResult);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public R getRawResult() {
        try {
            BytecodeManager.incBytecodes(2);
            final R localResult = this.getLocalResult();
            BytecodeManager.incBytecodes(1);
            return localResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public R getLocalResult() {
        try {
            BytecodeManager.incBytecodes(2);
            final boolean root = this.isRoot();
            BytecodeManager.incBytecodes(1);
            if (root) {
                final AtomicReference<R> sharedResult = this.sharedResult;
                BytecodeManager.incBytecodes(3);
                final R value = sharedResult.get();
                BytecodeManager.incBytecodes(1);
                final R r = value;
                BytecodeManager.incBytecodes(2);
                R emptyResult;
                if (r == null) {
                    BytecodeManager.incBytecodes(2);
                    emptyResult = this.getEmptyResult();
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    emptyResult = value;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return emptyResult;
            }
            BytecodeManager.incBytecodes(2);
            final R localResult = super.getLocalResult();
            BytecodeManager.incBytecodes(1);
            return localResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void cancel() {
        try {
            this.canceled = true;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected boolean taskCanceled() {
        try {
            boolean b = this.canceled;
            BytecodeManager.incBytecodes(3);
            final boolean b2 = b;
            BytecodeManager.incBytecodes(2);
            if (!b2) {
                BytecodeManager.incBytecodes(2);
                AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask = this.getParent();
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final boolean b3 = b;
                    BytecodeManager.incBytecodes(2);
                    if (b3) {
                        break;
                    }
                    final AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask2 = abstractShortCircuitTask;
                    BytecodeManager.incBytecodes(2);
                    if (abstractShortCircuitTask2 == null) {
                        break;
                    }
                    b = abstractShortCircuitTask.canceled;
                    BytecodeManager.incBytecodes(3);
                    final AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask3 = abstractShortCircuitTask;
                    BytecodeManager.incBytecodes(2);
                    abstractShortCircuitTask = abstractShortCircuitTask3.getParent();
                    BytecodeManager.incBytecodes(3);
                }
            }
            final boolean b4 = b;
            BytecodeManager.incBytecodes(2);
            return b4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void cancelLaterNodes() {
        try {
            BytecodeManager.incBytecodes(2);
            AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask = this.getParent();
            AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask2 = (AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask>)this;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask3 = abstractShortCircuitTask;
                BytecodeManager.incBytecodes(2);
                if (abstractShortCircuitTask3 == null) {
                    break;
                }
                final AbstractShortCircuitTask leftChild = abstractShortCircuitTask.leftChild;
                final AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask> abstractShortCircuitTask4 = abstractShortCircuitTask2;
                BytecodeManager.incBytecodes(4);
                if (leftChild == abstractShortCircuitTask4) {
                    final AbstractShortCircuitTask abstractShortCircuitTask5 = abstractShortCircuitTask.rightChild;
                    BytecodeManager.incBytecodes(4);
                    final boolean canceled = abstractShortCircuitTask5.canceled;
                    BytecodeManager.incBytecodes(3);
                    if (!canceled) {
                        final AbstractShortCircuitTask abstractShortCircuitTask6 = abstractShortCircuitTask5;
                        BytecodeManager.incBytecodes(2);
                        abstractShortCircuitTask6.cancel();
                    }
                }
                abstractShortCircuitTask2 = abstractShortCircuitTask;
                final AbstractTask<Object, Object, Object, AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask>> abstractTask = (AbstractTask<Object, Object, Object, AbstractShortCircuitTask<Object, Object, Object, AbstractShortCircuitTask>>)abstractShortCircuitTask;
                BytecodeManager.incBytecodes(4);
                abstractShortCircuitTask = abstractTask.getParent();
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
