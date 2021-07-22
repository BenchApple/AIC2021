// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import java.lang.reflect.Field;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

public abstract class CountedCompleter<T> extends ForkJoinTask<T>
{
    private static final long serialVersionUID = 5232453752276485070L;
    final CountedCompleter<?> completer;
    volatile int pending;
    private static final Unsafe U;
    private static final long PENDING;
    
    protected CountedCompleter(final CountedCompleter<?> completer, final int pending) {
        try {
            BytecodeManager.incBytecodes(2);
            this.completer = completer;
            BytecodeManager.incBytecodes(3);
            this.pending = pending;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected CountedCompleter(final CountedCompleter<?> completer) {
        try {
            BytecodeManager.incBytecodes(2);
            this.completer = completer;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected CountedCompleter() {
        try {
            BytecodeManager.incBytecodes(2);
            this.completer = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract void compute();
    
    public void onCompletion(final CountedCompleter<?> countedCompleter) {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean onExceptionalCompletion(final Throwable t, final CountedCompleter<?> countedCompleter) {
        try {
            final boolean b = true;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final CountedCompleter<?> getCompleter() {
        try {
            final CountedCompleter<?> completer = this.completer;
            BytecodeManager.incBytecodes(3);
            return completer;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int getPendingCount() {
        try {
            final int pending = this.pending;
            BytecodeManager.incBytecodes(3);
            return pending;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void setPendingCount(final int pending) {
        try {
            this.pending = pending;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void addToPendingCount(final int delta) {
        try {
            final Unsafe u = CountedCompleter.U;
            final long pending = CountedCompleter.PENDING;
            BytecodeManager.incBytecodes(5);
            u.getAndAddInt(this, pending, delta);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final boolean compareAndSetPendingCount(final int expected, final int x) {
        try {
            final Unsafe u = CountedCompleter.U;
            final long pending = CountedCompleter.PENDING;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapInt = u.compareAndSwapInt(this, pending, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapInt;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final int decrementPendingCountUnlessZero() {
        try {
            boolean compareAndSwapInt;
            int pending;
            do {
                final int n = pending = this.pending;
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    break;
                }
                final Unsafe u = CountedCompleter.U;
                final long pending2 = CountedCompleter.PENDING;
                final int expected = pending;
                final int x = pending - 1;
                BytecodeManager.incBytecodes(7);
                BytecodeManager.incBytecodes(1);
                compareAndSwapInt = u.compareAndSwapInt(this, pending2, expected, x);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSwapInt);
            final int n2 = pending;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final CountedCompleter<?> getRoot() {
        try {
            CountedCompleter<?> countedCompleter = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final CountedCompleter<?> completer = countedCompleter.completer;
                BytecodeManager.incBytecodes(5);
                if (completer == null) {
                    break;
                }
                countedCompleter = completer;
                BytecodeManager.incBytecodes(3);
            }
            final CountedCompleter<?> countedCompleter2 = countedCompleter;
            BytecodeManager.incBytecodes(2);
            return countedCompleter2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void tryComplete() {
        try {
            CountedCompleter<?> countedCompleter;
            CountedCompleter<?> completer = countedCompleter = this;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int pending;
                final int n = pending = completer.pending;
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    final CountedCompleter<?> countedCompleter2 = completer;
                    final CountedCompleter<?> countedCompleter3 = countedCompleter;
                    BytecodeManager.incBytecodes(3);
                    countedCompleter2.onCompletion(countedCompleter3);
                    final CountedCompleter<?> countedCompleter4 = completer = (countedCompleter = completer).completer;
                    BytecodeManager.incBytecodes(7);
                    if (countedCompleter4 == null) {
                        final CountedCompleter<?> countedCompleter5 = countedCompleter;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter5.quietlyComplete();
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
                else {
                    final Unsafe u = CountedCompleter.U;
                    final CountedCompleter<?> o = completer;
                    final long pending2 = CountedCompleter.PENDING;
                    final int expected = pending;
                    final int x = pending - 1;
                    BytecodeManager.incBytecodes(8);
                    final boolean compareAndSwapInt = u.compareAndSwapInt(o, pending2, expected, x);
                    BytecodeManager.incBytecodes(1);
                    if (compareAndSwapInt) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void propagateCompletion() {
        try {
            CountedCompleter<?> completer = this;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final int pending;
                final int n = pending = completer.pending;
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    final CountedCompleter<?> countedCompleter2;
                    final CountedCompleter<?> countedCompleter = completer = (countedCompleter2 = completer).completer;
                    BytecodeManager.incBytecodes(7);
                    if (countedCompleter == null) {
                        final CountedCompleter<?> countedCompleter3 = countedCompleter2;
                        BytecodeManager.incBytecodes(2);
                        countedCompleter3.quietlyComplete();
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
                else {
                    final Unsafe u = CountedCompleter.U;
                    final CountedCompleter<?> o = completer;
                    final long pending2 = CountedCompleter.PENDING;
                    final int expected = pending;
                    final int x = pending - 1;
                    BytecodeManager.incBytecodes(8);
                    final boolean compareAndSwapInt = u.compareAndSwapInt(o, pending2, expected, x);
                    BytecodeManager.incBytecodes(1);
                    if (compareAndSwapInt) {
                        BytecodeManager.incBytecodes(1);
                        return;
                    }
                    continue;
                }
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void complete(final T rawResult) {
        try {
            BytecodeManager.incBytecodes(3);
            this.setRawResult(rawResult);
            BytecodeManager.incBytecodes(3);
            this.onCompletion(this);
            BytecodeManager.incBytecodes(2);
            this.quietlyComplete();
            final CountedCompleter<?> completer = this.completer;
            BytecodeManager.incBytecodes(5);
            if (completer != null) {
                final CountedCompleter<?> countedCompleter = completer;
                BytecodeManager.incBytecodes(2);
                countedCompleter.tryComplete();
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final CountedCompleter<?> firstComplete() {
        try {
            boolean compareAndSwapInt;
            do {
                final int pending;
                final int n = pending = this.pending;
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    BytecodeManager.incBytecodes(2);
                    return this;
                }
                final Unsafe u = CountedCompleter.U;
                final long pending2 = CountedCompleter.PENDING;
                final int expected = pending;
                final int x = pending - 1;
                BytecodeManager.incBytecodes(8);
                compareAndSwapInt = u.compareAndSwapInt(this, pending2, expected, x);
                BytecodeManager.incBytecodes(1);
            } while (!compareAndSwapInt);
            final CountedCompleter<?> countedCompleter = null;
            BytecodeManager.incBytecodes(2);
            return countedCompleter;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final CountedCompleter<?> nextComplete() {
        try {
            final CountedCompleter<?> completer = this.completer;
            BytecodeManager.incBytecodes(5);
            if (completer != null) {
                final CountedCompleter<?> countedCompleter = completer;
                BytecodeManager.incBytecodes(2);
                final CountedCompleter firstComplete = countedCompleter.firstComplete();
                BytecodeManager.incBytecodes(1);
                return (CountedCompleter<?>)firstComplete;
            }
            BytecodeManager.incBytecodes(2);
            this.quietlyComplete();
            final CountedCompleter<?> countedCompleter2 = null;
            BytecodeManager.incBytecodes(2);
            return countedCompleter2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void quietlyCompleteRoot() {
        try {
            CountedCompleter<?> countedCompleter = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final CountedCompleter<?> completer = countedCompleter.completer;
                BytecodeManager.incBytecodes(5);
                if (completer == null) {
                    break;
                }
                countedCompleter = completer;
                BytecodeManager.incBytecodes(3);
            }
            final CountedCompleter<?> countedCompleter2 = countedCompleter;
            BytecodeManager.incBytecodes(2);
            countedCompleter2.quietlyComplete();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final void helpComplete(final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            if (n > 0) {
                final int status = this.status;
                BytecodeManager.incBytecodes(3);
                if (status >= 0) {
                    BytecodeManager.incBytecodes(1);
                    final Thread currentThread;
                    final boolean b = (currentThread = Thread.currentThread()) instanceof ForkJoinWorkerThread;
                    BytecodeManager.incBytecodes(4);
                    if (b) {
                        final ForkJoinWorkerThread forkJoinWorkerThread;
                        final ForkJoinPool pool = (forkJoinWorkerThread = (ForkJoinWorkerThread)currentThread).pool;
                        final ForkJoinPool.WorkQueue workQueue = forkJoinWorkerThread.workQueue;
                        BytecodeManager.incBytecodes(9);
                        BytecodeManager.incBytecodes(1);
                        pool.helpComplete(workQueue, this, n);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final ForkJoinPool common = ForkJoinPool.common;
                        BytecodeManager.incBytecodes(4);
                        common.externalHelpComplete(this, n);
                        BytecodeManager.incBytecodes(1);
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
    void internalPropagateException(final Throwable t) {
        try {
            CountedCompleter<?> countedCompleter;
            CountedCompleter<?> completer = countedCompleter = this;
            BytecodeManager.incBytecodes(4);
            while (true) {
                final CountedCompleter<?> countedCompleter2 = completer;
                final CountedCompleter<?> countedCompleter3 = countedCompleter;
                BytecodeManager.incBytecodes(4);
                final boolean onExceptionalCompletion = countedCompleter2.onExceptionalCompletion(t, countedCompleter3);
                BytecodeManager.incBytecodes(1);
                if (!onExceptionalCompletion) {
                    break;
                }
                final CountedCompleter<?> countedCompleter4 = completer = (countedCompleter = completer).completer;
                BytecodeManager.incBytecodes(7);
                if (countedCompleter4 == null) {
                    break;
                }
                final int status = completer.status;
                BytecodeManager.incBytecodes(3);
                if (status < 0) {
                    break;
                }
                final CountedCompleter<?> countedCompleter5 = completer;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final int recordExceptionalCompletion = countedCompleter5.recordExceptionalCompletion(t);
                final int n = Integer.MIN_VALUE;
                BytecodeManager.incBytecodes(2);
                if (recordExceptionalCompletion != n) {
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
    protected final boolean exec() {
        try {
            BytecodeManager.incBytecodes(2);
            this.compute();
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public T getRawResult() {
        try {
            final T t = null;
            BytecodeManager.incBytecodes(2);
            return t;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    protected void setRawResult(final T t) {
        try {
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
                    U = Unsafe.getUnsafe();
                    BytecodeManager.incBytecodes(1);
                    final Unsafe u = CountedCompleter.U;
                    final Class<CountedCompleter> clazz = CountedCompleter.class;
                    final String name = "pending";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    PENDING = u.objectFieldOffset(declaredField);
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
