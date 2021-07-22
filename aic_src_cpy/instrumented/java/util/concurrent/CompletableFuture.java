// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import instrumented.java.util.concurrent.locks.LockSupport;
import java.util.concurrent.TimeUnit;
import instrumented.java.util.function.Supplier;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import instrumented.java.util.function.Consumer;
import instrumented.java.util.function.Function;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

public class CompletableFuture<T> implements Future<T>, CompletionStage<T>
{
    volatile Object result;
    volatile Completion stack;
    static final AltResult NIL;
    private static final boolean useCommonPool;
    private static final Executor asyncPool;
    static final int SYNC = 0;
    static final int ASYNC = 1;
    static final int NESTED = -1;
    private static final Unsafe UNSAFE;
    private static final long RESULT;
    private static final long STACK;
    private static final long NEXT;
    
    final boolean internalComplete(final Object x) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean casStack(final Completion expected, final Completion x) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long stack = CompletableFuture.STACK;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, stack, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean tryPushStack(final Completion x) {
        try {
            final Completion stack = this.stack;
            BytecodeManager.incBytecodes(3);
            final Completion completion = stack;
            BytecodeManager.incBytecodes(3);
            lazySetNext(x, completion);
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long stack2 = CompletableFuture.STACK;
            final Completion expected = stack;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, stack2, expected, x);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void pushStack(final Completion completion) {
        try {
            boolean tryPushStack;
            do {
                BytecodeManager.incBytecodes(3);
                tryPushStack = this.tryPushStack(completion);
                BytecodeManager.incBytecodes(1);
            } while (!tryPushStack);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean completeNull() {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            final AltResult nil = CompletableFuture.NIL;
            BytecodeManager.incBytecodes(6);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, nil);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final Object encodeValue(final T t) {
        try {
            BytecodeManager.incBytecodes(2);
            Object nil;
            if (t == null) {
                nil = CompletableFuture.NIL;
                BytecodeManager.incBytecodes(2);
            }
            else {
                nil = t;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return nil;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean completeValue(final T t) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            BytecodeManager.incBytecodes(6);
            Object nil;
            if (t == null) {
                nil = CompletableFuture.NIL;
                BytecodeManager.incBytecodes(2);
            }
            else {
                nil = t;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, nil);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static AltResult encodeThrowable(final Throwable t) {
        try {
            final boolean b = t instanceof CompletionException;
            BytecodeManager.incBytecodes(5);
            Throwable t2;
            if (b) {
                t2 = t;
                BytecodeManager.incBytecodes(2);
            }
            else {
                t2 = new CompletionException(t);
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
            final AltResult altResult = new AltResult(t2);
            BytecodeManager.incBytecodes(1);
            return altResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean completeThrowable(final Throwable t) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final AltResult encodeThrowable = encodeThrowable(t);
            BytecodeManager.incBytecodes(1);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, encodeThrowable);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Object encodeThrowable(Throwable t, final Object o) {
        try {
            final boolean b = t instanceof CompletionException;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                final Throwable t2 = t;
                BytecodeManager.incBytecodes(4);
                t = new CompletionException(t2);
                BytecodeManager.incBytecodes(2);
            }
            else {
                final boolean b2 = o instanceof AltResult;
                BytecodeManager.incBytecodes(3);
                if (b2) {
                    final Throwable t3 = t;
                    final Throwable ex = ((AltResult)o).ex;
                    BytecodeManager.incBytecodes(5);
                    if (t3 == ex) {
                        BytecodeManager.incBytecodes(2);
                        return o;
                    }
                }
            }
            final Throwable t4 = t;
            BytecodeManager.incBytecodes(4);
            final AltResult altResult = new AltResult(t4);
            BytecodeManager.incBytecodes(1);
            return altResult;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean completeThrowable(final Throwable t, final Object o) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
            final Object encodeThrowable = encodeThrowable(t, o);
            BytecodeManager.incBytecodes(1);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, encodeThrowable);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    Object encodeOutcome(final T t, final Throwable t2) {
        try {
            BytecodeManager.incBytecodes(2);
            Object o;
            if (t2 == null) {
                BytecodeManager.incBytecodes(2);
                if (t == null) {
                    o = CompletableFuture.NIL;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    o = t;
                    BytecodeManager.incBytecodes(2);
                }
            }
            else {
                BytecodeManager.incBytecodes(2);
                o = encodeThrowable(t2);
            }
            BytecodeManager.incBytecodes(1);
            return o;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Object encodeRelay(final Object o) {
        try {
            final boolean b = o instanceof AltResult;
            BytecodeManager.incBytecodes(3);
            Object o2 = null;
            Label_0080: {
                if (b) {
                    final Throwable ex;
                    final Throwable t = ex = ((AltResult)o).ex;
                    BytecodeManager.incBytecodes(6);
                    if (t != null) {
                        final boolean b2 = ex instanceof CompletionException;
                        BytecodeManager.incBytecodes(3);
                        if (!b2) {
                            final CompletionException ex2;
                            o2 = new AltResult(ex2);
                            final Throwable t2 = ex;
                            BytecodeManager.incBytecodes(6);
                            ex2 = new CompletionException(t2);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            break Label_0080;
                        }
                    }
                }
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
    
    final boolean completeRelay(final Object o) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long result = CompletableFuture.RESULT;
            final Object expected = null;
            BytecodeManager.incBytecodes(5);
            BytecodeManager.incBytecodes(1);
            final Object encodeRelay = encodeRelay(o);
            BytecodeManager.incBytecodes(1);
            final boolean compareAndSwapObject = unsafe.compareAndSwapObject(this, result, expected, encodeRelay);
            BytecodeManager.incBytecodes(1);
            return compareAndSwapObject;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> T reportGet(final Object o) throws InterruptedException, ExecutionException {
        try {
            BytecodeManager.incBytecodes(2);
            if (o == null) {
                BytecodeManager.incBytecodes(3);
                final InterruptedException ex = new InterruptedException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final boolean b = o instanceof AltResult;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                return (T)o;
            }
            Throwable ex2;
            final Throwable t = ex2 = ((AltResult)o).ex;
            BytecodeManager.incBytecodes(6);
            if (t == null) {
                final T t2 = null;
                BytecodeManager.incBytecodes(2);
                return t2;
            }
            final boolean b2 = ex2 instanceof CancellationException;
            BytecodeManager.incBytecodes(3);
            if (b2) {
                final CancellationException ex3 = (CancellationException)ex2;
                BytecodeManager.incBytecodes(3);
                throw ex3;
            }
            final boolean b3 = ex2 instanceof CompletionException;
            BytecodeManager.incBytecodes(3);
            if (b3) {
                final CancellationException ex4 = (CancellationException)ex2;
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
                final Throwable cause;
                final Throwable t3 = cause = ex4.getCause();
                BytecodeManager.incBytecodes(3);
                if (t3 != null) {
                    ex2 = cause;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final CancellationException ex5 = (CancellationException)ex2;
            BytecodeManager.incBytecodes(4);
            final ExecutionException ex6 = new ExecutionException(ex5);
            BytecodeManager.incBytecodes(1);
            throw ex6;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static <T> T reportJoin(final Object o) {
        try {
            final boolean b = o instanceof AltResult;
            BytecodeManager.incBytecodes(3);
            if (!b) {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                return (T)o;
            }
            final Throwable ex;
            final Throwable t = ex = ((AltResult)o).ex;
            BytecodeManager.incBytecodes(6);
            if (t == null) {
                final T t2 = null;
                BytecodeManager.incBytecodes(2);
                return t2;
            }
            final boolean b2 = ex instanceof CancellationException;
            BytecodeManager.incBytecodes(3);
            if (b2) {
                final CancellationException ex2 = (CancellationException)ex;
                BytecodeManager.incBytecodes(3);
                throw ex2;
            }
            final boolean b3 = ex instanceof CompletionException;
            BytecodeManager.incBytecodes(3);
            if (b3) {
                final CompletionException ex3 = (CompletionException)ex;
                BytecodeManager.incBytecodes(3);
                throw ex3;
            }
            final CompletionException ex4 = (CompletionException)ex;
            BytecodeManager.incBytecodes(4);
            final CompletionException ex5 = new CompletionException(ex4);
            BytecodeManager.incBytecodes(1);
            throw ex5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static Executor screenExecutor(final Executor executor) {
        try {
            final boolean useCommonPool = CompletableFuture.useCommonPool;
            BytecodeManager.incBytecodes(2);
            if (!useCommonPool) {
                BytecodeManager.incBytecodes(2);
                final ForkJoinPool commonPool = ForkJoinPool.commonPool();
                BytecodeManager.incBytecodes(1);
                if (executor == commonPool) {
                    final Executor asyncPool = CompletableFuture.asyncPool;
                    BytecodeManager.incBytecodes(2);
                    return asyncPool;
                }
            }
            BytecodeManager.incBytecodes(2);
            if (executor == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(2);
            return executor;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void lazySetNext(final Completion o, final Completion x) {
        try {
            final Unsafe unsafe = CompletableFuture.UNSAFE;
            final long next = CompletableFuture.NEXT;
            BytecodeManager.incBytecodes(5);
            unsafe.putOrderedObject(o, next, x);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void postComplete() {
        try {
            CompletableFuture completableFuture = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                Completion completion2;
                final Completion completion = completion2 = completableFuture.stack;
                BytecodeManager.incBytecodes(5);
                if (completion == null) {
                    final CompletableFuture completableFuture2 = completableFuture;
                    BytecodeManager.incBytecodes(3);
                    if (completableFuture2 == this) {
                        break;
                    }
                    completableFuture = this;
                    final Completion completion3 = completion2 = this.stack;
                    BytecodeManager.incBytecodes(7);
                    if (completion3 == null) {
                        break;
                    }
                }
                final CompletableFuture completableFuture3 = completableFuture;
                final Completion completion4 = completion2;
                final Completion next = completion2.next;
                BytecodeManager.incBytecodes(7);
                final boolean casStack = completableFuture3.casStack(completion4, next);
                BytecodeManager.incBytecodes(1);
                if (casStack) {
                    final Completion completion5 = next;
                    BytecodeManager.incBytecodes(2);
                    if (completion5 != null) {
                        final CompletableFuture completableFuture4 = completableFuture;
                        BytecodeManager.incBytecodes(3);
                        if (completableFuture4 != this) {
                            final Completion completion6 = completion2;
                            BytecodeManager.incBytecodes(3);
                            this.pushStack(completion6);
                            BytecodeManager.incBytecodes(1);
                            continue;
                        }
                        completion2.next = null;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Completion completion7 = completion2;
                    final int n = -1;
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<?> tryFire = completion7.tryFire(n);
                    BytecodeManager.incBytecodes(3);
                    CompletableFuture<?> completableFuture5;
                    if (tryFire == null) {
                        completableFuture5 = this;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        completableFuture5 = tryFire;
                        BytecodeManager.incBytecodes(1);
                    }
                    completableFuture = completableFuture5;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void cleanStack() {
        try {
            Completion completion = null;
            Completion completion2 = this.stack;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final Completion completion3 = completion2;
                BytecodeManager.incBytecodes(2);
                if (completion3 == null) {
                    break;
                }
                final Completion next = completion2.next;
                BytecodeManager.incBytecodes(3);
                final Completion completion4 = completion2;
                BytecodeManager.incBytecodes(2);
                final boolean live = completion4.isLive();
                BytecodeManager.incBytecodes(1);
                if (live) {
                    completion = completion2;
                    BytecodeManager.incBytecodes(2);
                    completion2 = next;
                    BytecodeManager.incBytecodes(3);
                }
                else {
                    final Completion completion5 = completion;
                    BytecodeManager.incBytecodes(2);
                    if (completion5 == null) {
                        final Completion completion6 = completion2;
                        final Completion completion7 = next;
                        BytecodeManager.incBytecodes(4);
                        this.casStack(completion6, completion7);
                        BytecodeManager.incBytecodes(1);
                        completion2 = this.stack;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        completion.next = next;
                        BytecodeManager.incBytecodes(3);
                        final Completion completion8 = completion;
                        BytecodeManager.incBytecodes(2);
                        final boolean live2 = completion8.isLive();
                        BytecodeManager.incBytecodes(1);
                        if (live2) {
                            completion2 = next;
                            BytecodeManager.incBytecodes(3);
                        }
                        else {
                            completion = null;
                            BytecodeManager.incBytecodes(2);
                            completion2 = this.stack;
                            BytecodeManager.incBytecodes(3);
                        }
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void push(final UniCompletion<?, ?> uniCompletion) {
        try {
            BytecodeManager.incBytecodes(2);
            if (uniCompletion != null) {
                while (true) {
                    final Object result = this.result;
                    BytecodeManager.incBytecodes(3);
                    if (result != null) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final boolean tryPushStack = this.tryPushStack(uniCompletion);
                    BytecodeManager.incBytecodes(1);
                    if (tryPushStack) {
                        break;
                    }
                    final Completion completion = null;
                    BytecodeManager.incBytecodes(3);
                    lazySetNext(uniCompletion, completion);
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final CompletableFuture<T> postFire(final CompletableFuture<?> completableFuture, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            Label_0068: {
                if (completableFuture != null) {
                    final Completion stack = completableFuture.stack;
                    BytecodeManager.incBytecodes(3);
                    if (stack != null) {
                        BytecodeManager.incBytecodes(2);
                        if (n >= 0) {
                            final Object result = completableFuture.result;
                            BytecodeManager.incBytecodes(3);
                            if (result != null) {
                                BytecodeManager.incBytecodes(2);
                                completableFuture.postComplete();
                                break Label_0068;
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        completableFuture.cleanStack();
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final Object result2 = this.result;
            BytecodeManager.incBytecodes(3);
            if (result2 != null) {
                final Completion stack2 = this.stack;
                BytecodeManager.incBytecodes(3);
                if (stack2 != null) {
                    BytecodeManager.incBytecodes(2);
                    if (n < 0) {
                        BytecodeManager.incBytecodes(2);
                        return this;
                    }
                    BytecodeManager.incBytecodes(2);
                    this.postComplete();
                }
            }
            final CompletableFuture<T> completableFuture2 = null;
            BytecodeManager.incBytecodes(2);
            return completableFuture2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <S> boolean uniApply(final CompletableFuture<S> p0, final Function<? super S, ? extends T> p1, final UniApply<S, T> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       227
        //    52: aload           4
        //    54: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            119
        //    65: aload           4
        //    67: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    70: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    73: dup            
        //    74: astore          5
        //    76: ldc             6
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifnull          111
        //    84: aload_0        
        //    85: aload           5
        //    87: aload           4
        //    89: ldc             4
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //    97: pop            
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: goto            227
        //   111: aconst_null    
        //   112: astore          4
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload_3        
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: ifnull          157
        //   128: aload_3        
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniApply.claim:()Z
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ifne            157
        //   145: iconst_0       
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ireturn        
        //   157: aload           4
        //   159: astore          6
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_0        
        //   167: aload_2        
        //   168: aload           6
        //   170: ldc             4
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
        //   188: pop            
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: goto            227
        //   202: astore          6
        //   204: ldc_w           501
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: aload_0        
        //   211: aload           6
        //   213: ldc             3
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   221: pop            
        //   222: ldc             1
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: iconst_1       
        //   228: ldc             2
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: ireturn        
        //   234: athrow         
        //   235: athrow         
        //    Signature:
        //  <S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/Function<-TS;+TT;>;Linstrumented/java/util/concurrent/CompletableFuture$UniApply<TS;TT;>;)Z
        //    StackMapTable: 00 09 21 FC 00 06 07 00 05 FC 00 46 07 00 89 FA 00 07 25 6C 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  119    235    235    236    Ljava/lang/VirtualMachineError;
        //  119    151    202    227    Ljava/lang/Throwable;
        //  157    194    202    227    Ljava/lang/Throwable;
        //  0      234    234    235    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119:
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
    
    private <V> CompletableFuture<V> uniApplyStage(final Executor executor, final Function<? super T, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> completableFuture = new CompletableFuture<Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0125: {
                if (executor == null) {
                    final CompletableFuture<Object> completableFuture2 = completableFuture;
                    final UniApply<Object, Object> uniApply = null;
                    BytecodeManager.incBytecodes(5);
                    final boolean uniApply2 = completableFuture2.uniApply((CompletableFuture<Object>)this, (Function<? super Object, ?>)function, uniApply);
                    BytecodeManager.incBytecodes(1);
                    if (uniApply2) {
                        break Label_0125;
                    }
                }
                final CompletableFuture<Object> completableFuture3 = completableFuture;
                BytecodeManager.incBytecodes(7);
                final UniApply uniApply3 = new UniApply<Object, Object>(executor, completableFuture3, (CompletableFuture<Object>)this, (Function<? super Object, ?>)function);
                BytecodeManager.incBytecodes(1);
                final UniApply uniApply4 = uniApply3;
                BytecodeManager.incBytecodes(3);
                this.push(uniApply4);
                final UniApply uniApply5 = uniApply3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniApply5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<Object> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return (CompletableFuture<V>)completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <S> boolean uniAccept(final CompletableFuture<S> p0, final Consumer<? super S> p1, final UniAccept<S> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       227
        //    52: aload           4
        //    54: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            119
        //    65: aload           4
        //    67: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    70: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    73: dup            
        //    74: astore          5
        //    76: ldc             6
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifnull          111
        //    84: aload_0        
        //    85: aload           5
        //    87: aload           4
        //    89: ldc             4
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //    97: pop            
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: goto            227
        //   111: aconst_null    
        //   112: astore          4
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload_3        
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: ifnull          157
        //   128: aload_3        
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniAccept.claim:()Z
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ifne            157
        //   145: iconst_0       
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ireturn        
        //   157: aload           4
        //   159: astore          6
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_2        
        //   167: aload           6
        //   169: ldc             3
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
        //   179: aload_0        
        //   180: ldc             2
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   188: pop            
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: goto            227
        //   202: astore          6
        //   204: ldc_w           501
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: aload_0        
        //   211: aload           6
        //   213: ldc             3
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   221: pop            
        //   222: ldc             1
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: iconst_1       
        //   228: ldc             2
        //   230: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   233: ireturn        
        //   234: athrow         
        //   235: athrow         
        //    Signature:
        //  <S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/Consumer<-TS;>;Linstrumented/java/util/concurrent/CompletableFuture$UniAccept<TS;>;)Z
        //    StackMapTable: 00 09 21 FC 00 06 07 00 05 FC 00 46 07 00 89 FA 00 07 25 6C 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  119    235    235    236    Ljava/lang/VirtualMachineError;
        //  119    151    202    227    Ljava/lang/Throwable;
        //  157    194    202    227    Ljava/lang/Throwable;
        //  0      234    234    235    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119:
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
    
    private CompletableFuture<Void> uniAcceptStage(final Executor executor, final Consumer<? super T> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> completableFuture = new CompletableFuture<Void>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0125: {
                if (executor == null) {
                    final CompletableFuture<Void> completableFuture2 = completableFuture;
                    final UniAccept<S> uniAccept = null;
                    BytecodeManager.incBytecodes(5);
                    final boolean uniAccept2 = completableFuture2.uniAccept((CompletableFuture<Object>)this, (Consumer<? super Object>)consumer, (UniAccept<Object>)uniAccept);
                    BytecodeManager.incBytecodes(1);
                    if (uniAccept2) {
                        break Label_0125;
                    }
                }
                final CompletableFuture<Void> completableFuture3 = completableFuture;
                BytecodeManager.incBytecodes(7);
                final UniAccept uniAccept3 = new UniAccept<Object>(executor, completableFuture3, (CompletableFuture<Object>)this, (Consumer<? super Object>)consumer);
                BytecodeManager.incBytecodes(1);
                final UniAccept uniAccept4 = uniAccept3;
                BytecodeManager.incBytecodes(3);
                this.push(uniAccept4);
                final UniAccept uniAccept5 = uniAccept3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniAccept5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<Void> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean uniRun(final CompletableFuture<?> p0, final Runnable p1, final UniRun<?> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       203
        //    52: aload           4
        //    54: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            106
        //    65: aload           4
        //    67: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    70: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    73: dup            
        //    74: astore          5
        //    76: ldc             6
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifnull          106
        //    84: aload_0        
        //    85: aload           5
        //    87: aload           4
        //    89: ldc             4
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //    97: pop            
        //    98: ldc             2
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: goto            203
        //   106: aload_3        
        //   107: ldc             2
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: ifnull          144
        //   115: aload_3        
        //   116: ldc             2
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniRun.claim:()Z
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: ifne            144
        //   132: iconst_0       
        //   133: ldc             1
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: ldc             1
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: ireturn        
        //   144: aload_2        
        //   145: ldc             2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: invokeinterface java/lang/Runnable.run:()V
        //   155: aload_0        
        //   156: ldc             2
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   164: pop            
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            203
        //   178: astore          6
        //   180: ldc_w           501
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: aload_0        
        //   187: aload           6
        //   189: ldc             3
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   197: pop            
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: iconst_1       
        //   204: ldc             2
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: ireturn        
        //   210: athrow         
        //   211: athrow         
        //    Signature:
        //  (Linstrumented/java/util/concurrent/CompletableFuture<*>;Ljava/lang/Runnable;Linstrumented/java/util/concurrent/CompletableFuture$UniRun<*>;)Z
        //    StackMapTable: 00 08 21 FC 00 06 07 00 05 FB 00 41 25 61 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  106    211    211    212    Ljava/lang/VirtualMachineError;
        //  106    138    178    203    Ljava/lang/Throwable;
        //  144    170    178    203    Ljava/lang/Throwable;
        //  0      210    210    211    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
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
    
    private CompletableFuture<Void> uniRunStage(final Executor executor, final Runnable runnable) {
        try {
            BytecodeManager.incBytecodes(2);
            if (runnable == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> completableFuture = new CompletableFuture<Void>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0125: {
                if (executor == null) {
                    final CompletableFuture<Void> completableFuture2 = completableFuture;
                    final UniRun<?> uniRun = null;
                    BytecodeManager.incBytecodes(5);
                    final boolean uniRun2 = completableFuture2.uniRun(this, runnable, uniRun);
                    BytecodeManager.incBytecodes(1);
                    if (uniRun2) {
                        break Label_0125;
                    }
                }
                final CompletableFuture<Void> completableFuture3 = completableFuture;
                BytecodeManager.incBytecodes(7);
                final UniRun uniRun3 = new UniRun<Object>(executor, completableFuture3, (CompletableFuture<Object>)this, runnable);
                BytecodeManager.incBytecodes(1);
                final UniRun uniRun4 = uniRun3;
                BytecodeManager.incBytecodes(3);
                this.push(uniRun4);
                final UniRun uniRun5 = uniRun3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniRun5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<Void> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean uniWhenComplete(final CompletableFuture<T> p0, final BiConsumer<? super T, ? super Throwable> p1, final UniWhenComplete<T> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          6
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: aload_1        
        //     9: ldc             2
        //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    14: ifnull          41
        //    17: aload_1        
        //    18: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: ldc             5
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: ifnull          41
        //    32: aload_2        
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: ifnonnull       48
        //    41: iconst_0       
        //    42: ldc             2
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: ireturn        
        //    48: aload_0        
        //    49: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    52: ldc             3
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: ifnonnull       263
        //    60: aload_3        
        //    61: ldc             2
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: ifnull          98
        //    69: aload_3        
        //    70: ldc             2
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniWhenComplete.claim:()Z
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifne            98
        //    86: iconst_0       
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: ldc             1
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: ireturn        
        //    98: aload           4
        //   100: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   103: ldc             3
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ifeq            137
        //   111: aload           4
        //   113: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   116: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   119: astore          6
        //   121: ldc             4
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: aconst_null    
        //   127: astore          5
        //   129: ldc             3
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: goto            155
        //   137: aload           4
        //   139: astore          7
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: aload           7
        //   148: astore          5
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: aload_2        
        //   156: aload           5
        //   158: aload           6
        //   160: ldc             4
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: invokeinterface instrumented/java/util/function/BiConsumer.accept:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   170: aload           6
        //   172: ldc             2
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: ifnonnull       209
        //   180: aload_0        
        //   181: aload           4
        //   183: ldc             3
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.internalComplete:(Ljava/lang/Object;)Z
        //   191: pop            
        //   192: ldc             1
        //   194: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   197: iconst_1       
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: ireturn        
        //   209: ldc             1
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: goto            244
        //   217: astore          7
        //   219: ldc_w           501
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: aload           6
        //   227: ldc             2
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: ifnonnull       244
        //   235: aload           7
        //   237: astore          6
        //   239: ldc             2
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload_0        
        //   245: aload           6
        //   247: aload           4
        //   249: ldc             4
        //   251: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   254: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   257: pop            
        //   258: ldc             1
        //   260: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   263: iconst_1       
        //   264: ldc             2
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: ireturn        
        //   270: athrow         
        //   271: athrow         
        //    Signature:
        //  (Linstrumented/java/util/concurrent/CompletableFuture<TT;>;Linstrumented/java/util/function/BiConsumer<-TT;-Ljava/lang/Throwable;>;Linstrumented/java/util/concurrent/CompletableFuture$UniWhenComplete<TT;>;)Z
        //    StackMapTable: 00 0B FE 00 29 00 00 07 00 89 FF 00 06 00 07 07 00 02 07 00 02 07 01 42 07 00 57 07 00 05 00 07 00 89 00 00 31 26 FF 00 11 00 07 07 00 02 07 00 02 07 01 42 07 00 57 07 00 05 07 00 05 07 00 89 00 00 35 FF 00 07 00 07 07 00 02 07 00 02 07 01 42 07 00 57 07 00 05 00 07 00 89 00 01 07 00 89 1A 12 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  60     271    271    272    Ljava/lang/VirtualMachineError;
        //  60     92     217    244    Ljava/lang/Throwable;
        //  98     203    217    244    Ljava/lang/Throwable;
        //  0      270    270    271    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0098:
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
    
    private CompletableFuture<T> uniWhenCompleteStage(final Executor executor, final BiConsumer<? super T, ? super Throwable> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> completableFuture = (CompletableFuture<Object>)new CompletableFuture<T>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0125: {
                if (executor == null) {
                    final CompletableFuture<Object> completableFuture2 = completableFuture;
                    final UniWhenComplete<Object> uniWhenComplete = null;
                    BytecodeManager.incBytecodes(5);
                    final boolean uniWhenComplete2 = completableFuture2.uniWhenComplete((CompletableFuture<Object>)this, (BiConsumer<? super Object, ? super Throwable>)biConsumer, uniWhenComplete);
                    BytecodeManager.incBytecodes(1);
                    if (uniWhenComplete2) {
                        break Label_0125;
                    }
                }
                final CompletableFuture<Object> completableFuture3 = completableFuture;
                BytecodeManager.incBytecodes(7);
                final UniWhenComplete uniWhenComplete3 = new UniWhenComplete<Object>(executor, completableFuture3, (CompletableFuture<Object>)this, (BiConsumer<? super Object, ? super Throwable>)biConsumer);
                BytecodeManager.incBytecodes(1);
                final UniWhenComplete uniWhenComplete4 = uniWhenComplete3;
                BytecodeManager.incBytecodes(3);
                this.push(uniWhenComplete4);
                final UniWhenComplete uniWhenComplete5 = uniWhenComplete3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniWhenComplete5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<Object> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return (CompletableFuture<T>)completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <S> boolean uniHandle(final CompletableFuture<S> p0, final BiFunction<? super S, Throwable, ? extends T> p1, final UniHandle<S, T> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       218
        //    52: aload_3        
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: ifnull          90
        //    61: aload_3        
        //    62: ldc             2
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniHandle.claim:()Z
        //    70: ldc             1
        //    72: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    75: ifne            90
        //    78: iconst_0       
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ireturn        
        //    90: aload           4
        //    92: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    95: ldc             3
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: ifeq            129
        //   103: aload           4
        //   105: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   108: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   111: astore          6
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: aconst_null    
        //   119: astore          5
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: goto            155
        //   129: aconst_null    
        //   130: astore          6
        //   132: ldc             2
        //   134: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   137: aload           4
        //   139: astore          7
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: aload           7
        //   148: astore          5
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: aload_0        
        //   156: aload_2        
        //   157: aload           5
        //   159: aload           6
        //   161: ldc             5
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   171: ldc             1
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
        //   179: pop            
        //   180: ldc             1
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: ldc             1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: goto            218
        //   193: astore          7
        //   195: ldc_w           501
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: aload_0        
        //   202: aload           7
        //   204: ldc             3
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   212: pop            
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: iconst_1       
        //   219: ldc             2
        //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   224: ireturn        
        //   225: athrow         
        //   226: athrow         
        //    Signature:
        //  <S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/BiFunction<-TS;Ljava/lang/Throwable;+TT;>;Linstrumented/java/util/concurrent/CompletableFuture$UniHandle<TS;TT;>;)Z
        //    StackMapTable: 00 09 21 FC 00 06 07 00 05 31 26 FD 00 19 07 00 05 07 00 89 FF 00 25 00 05 07 00 02 07 00 02 07 01 55 07 00 4E 07 00 05 00 01 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  52     226    226    227    Ljava/lang/VirtualMachineError;
        //  52     84     193    218    Ljava/lang/Throwable;
        //  90     185    193    218    Ljava/lang/Throwable;
        //  0      225    225    226    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0090:
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
    
    private <V> CompletableFuture<V> uniHandleStage(final Executor executor, final BiFunction<? super T, Throwable, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> completableFuture = new CompletableFuture<Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            Label_0125: {
                if (executor == null) {
                    final CompletableFuture<Object> completableFuture2 = completableFuture;
                    final UniHandle<Object, Object> uniHandle = null;
                    BytecodeManager.incBytecodes(5);
                    final boolean uniHandle2 = completableFuture2.uniHandle((CompletableFuture<Object>)this, (BiFunction<? super Object, Throwable, ?>)biFunction, uniHandle);
                    BytecodeManager.incBytecodes(1);
                    if (uniHandle2) {
                        break Label_0125;
                    }
                }
                final CompletableFuture<Object> completableFuture3 = completableFuture;
                BytecodeManager.incBytecodes(7);
                final UniHandle uniHandle3 = new UniHandle<Object, Object>(executor, completableFuture3, (CompletableFuture<Object>)this, (BiFunction<? super Object, Throwable, ?>)biFunction);
                BytecodeManager.incBytecodes(1);
                final UniHandle uniHandle4 = uniHandle3;
                BytecodeManager.incBytecodes(3);
                this.push(uniHandle4);
                final UniHandle uniHandle5 = uniHandle3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniHandle5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<Object> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return (CompletableFuture<V>)completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean uniExceptionally(final CompletableFuture<T> p0, final Function<? super Throwable, ? extends T> p1, final UniExceptionally<T> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       203
        //    52: aload           4
        //    54: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            153
        //    65: aload           4
        //    67: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    70: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    73: dup            
        //    74: astore          5
        //    76: ldc             6
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifnull          153
        //    84: aload_3        
        //    85: ldc             2
        //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    90: ifnull          122
        //    93: aload_3        
        //    94: ldc             2
        //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    99: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniExceptionally.claim:()Z
        //   102: ldc             1
        //   104: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   107: ifne            122
        //   110: iconst_0       
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: ldc             1
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: ireturn        
        //   122: aload_0        
        //   123: aload_2        
        //   124: aload           5
        //   126: ldc             4
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   136: ldc             1
        //   138: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   141: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
        //   144: pop            
        //   145: ldc             2
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            170
        //   153: aload_0        
        //   154: aload           4
        //   156: ldc             3
        //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   161: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.internalComplete:(Ljava/lang/Object;)Z
        //   164: pop            
        //   165: ldc             1
        //   167: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   170: ldc             1
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: goto            203
        //   178: astore          6
        //   180: ldc_w           501
        //   183: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   186: aload_0        
        //   187: aload           6
        //   189: ldc             3
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   197: pop            
        //   198: ldc             1
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: iconst_1       
        //   204: ldc             2
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: ireturn        
        //   210: athrow         
        //   211: athrow         
        //    Signature:
        //  (Linstrumented/java/util/concurrent/CompletableFuture<TT;>;Linstrumented/java/util/function/Function<-Ljava/lang/Throwable;+TT;>;Linstrumented/java/util/concurrent/CompletableFuture$UniExceptionally<TT;>;)Z
        //    StackMapTable: 00 09 21 FC 00 06 07 00 05 FC 00 51 07 00 89 FA 00 1E 10 47 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  52     211    211    212    Ljava/lang/VirtualMachineError;
        //  52     116    178    203    Ljava/lang/Throwable;
        //  122    170    178    203    Ljava/lang/Throwable;
        //  0      210    210    211    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0122:
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
    
    private CompletableFuture<T> uniExceptionallyStage(final Function<Throwable, ? extends T> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<T> completableFuture = new CompletableFuture<T>();
            BytecodeManager.incBytecodes(1);
            final CompletableFuture<T> completableFuture2 = completableFuture;
            final UniExceptionally<T> uniExceptionally = null;
            BytecodeManager.incBytecodes(5);
            final boolean uniExceptionally2 = completableFuture2.uniExceptionally(this, function, uniExceptionally);
            BytecodeManager.incBytecodes(1);
            if (!uniExceptionally2) {
                final CompletableFuture<Object> completableFuture3 = (CompletableFuture<Object>)completableFuture;
                BytecodeManager.incBytecodes(6);
                final UniExceptionally uniExceptionally3 = new UniExceptionally<Object>(completableFuture3, (CompletableFuture<Object>)this, function);
                BytecodeManager.incBytecodes(1);
                final UniExceptionally uniExceptionally4 = uniExceptionally3;
                BytecodeManager.incBytecodes(3);
                this.push(uniExceptionally4);
                final UniExceptionally uniExceptionally5 = uniExceptionally3;
                final int n = 0;
                BytecodeManager.incBytecodes(3);
                uniExceptionally5.tryFire(n);
                BytecodeManager.incBytecodes(1);
            }
            final CompletableFuture<T> completableFuture4 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean uniRelay(final CompletableFuture<T> completableFuture) {
        try {
            BytecodeManager.incBytecodes(2);
            if (completableFuture != null) {
                final Object result = completableFuture.result;
                BytecodeManager.incBytecodes(5);
                if (result != null) {
                    final Object result2 = this.result;
                    BytecodeManager.incBytecodes(3);
                    if (result2 == null) {
                        final Object o = result;
                        BytecodeManager.incBytecodes(3);
                        this.completeRelay(o);
                        BytecodeManager.incBytecodes(1);
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
    
    final <S> boolean uniCompose(final CompletableFuture<S> p0, final Function<? super S, ? extends CompletionStage<T>> p1, final UniCompose<S, T> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          33
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          4
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          33
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       40
        //    33: iconst_0       
        //    34: ldc             2
        //    36: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    39: ireturn        
        //    40: aload_0        
        //    41: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifnonnull       339
        //    52: aload           4
        //    54: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    57: ldc             3
        //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    62: ifeq            119
        //    65: aload           4
        //    67: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    70: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    73: dup            
        //    74: astore          5
        //    76: ldc             6
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: ifnull          111
        //    84: aload_0        
        //    85: aload           5
        //    87: aload           4
        //    89: ldc             4
        //    91: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    94: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //    97: pop            
        //    98: ldc             1
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: goto            339
        //   111: aconst_null    
        //   112: astore          4
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: aload_3        
        //   120: ldc             2
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: ifnull          157
        //   128: aload_3        
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniCompose.claim:()Z
        //   137: ldc             1
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ifne            157
        //   145: iconst_0       
        //   146: ldc             1
        //   148: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: ireturn        
        //   157: aload           4
        //   159: astore          6
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_2        
        //   167: aload           6
        //   169: ldc             3
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   179: checkcast       Linstrumented/java/util/concurrent/CompletionStage;
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokeinterface instrumented/java/util/concurrent/CompletionStage.toCompletableFuture:()Linstrumented/java/util/concurrent/CompletableFuture;
        //   192: astore          7
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: aload           7
        //   201: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   204: ldc             3
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: ifnull          231
        //   212: aload_0        
        //   213: aload           7
        //   215: ldc             3
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.uniRelay:(Linstrumented/java/util/concurrent/CompletableFuture;)Z
        //   223: ldc             1
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifne            306
        //   231: new             Linstrumented/java/util/concurrent/CompletableFuture$UniRelay;
        //   234: dup            
        //   235: aload_0        
        //   236: aload           7
        //   238: ldc             5
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: invokespecial   instrumented/java/util/concurrent/CompletableFuture$UniRelay.<init>:(Linstrumented/java/util/concurrent/CompletableFuture;Linstrumented/java/util/concurrent/CompletableFuture;)V
        //   246: astore          8
        //   248: ldc             1
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: aload           7
        //   255: aload           8
        //   257: ldc             3
        //   259: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   262: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.push:(Linstrumented/java/util/concurrent/CompletableFuture$UniCompletion;)V
        //   265: aload           8
        //   267: iconst_0       
        //   268: ldc             3
        //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   273: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniRelay.tryFire:(I)Linstrumented/java/util/concurrent/CompletableFuture;
        //   276: pop            
        //   277: ldc             1
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: aload_0        
        //   283: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   286: ldc             3
        //   288: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   291: ifnonnull       306
        //   294: iconst_0       
        //   295: ldc             1
        //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   300: ldc             1
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: ireturn        
        //   306: ldc             1
        //   308: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   311: goto            339
        //   314: astore          6
        //   316: ldc_w           501
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: aload_0        
        //   323: aload           6
        //   325: ldc             3
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   333: pop            
        //   334: ldc             1
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: iconst_1       
        //   340: ldc             2
        //   342: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   345: ireturn        
        //   346: athrow         
        //   347: athrow         
        //    Signature:
        //  <S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/Function<-TS;+Linstrumented/java/util/concurrent/CompletionStage<TT;>;>;Linstrumented/java/util/concurrent/CompletableFuture$UniCompose<TS;TT;>;)Z
        //    StackMapTable: 00 0B 21 FC 00 06 07 00 05 FC 00 46 07 00 89 FA 00 07 25 FE 00 49 00 07 00 05 07 00 02 F8 00 4A 47 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  119    347    347    348    Ljava/lang/VirtualMachineError;
        //  119    151    314    339    Ljava/lang/Throwable;
        //  157    300    314    339    Ljava/lang/Throwable;
        //  0      346    346    347    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119:
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
    
    private <V> CompletableFuture<V> uniComposeStage(final Executor p0, final Function<? super T, ? extends CompletionStage<V>> p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnonnull       27
        //     9: new             Ljava/lang/NullPointerException;
        //    12: dup            
        //    13: ldc             3
        //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    18: invokespecial   java/lang/NullPointerException.<init>:()V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: athrow         
        //    27: aload_1        
        //    28: ldc             2
        //    30: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    33: ifnonnull       327
        //    36: aload_0        
        //    37: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    40: dup            
        //    41: astore_3       
        //    42: ldc             5
        //    44: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    47: ifnull          327
        //    50: aload_3        
        //    51: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: ifeq            116
        //    62: aload_3        
        //    63: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    66: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    69: dup            
        //    70: astore          4
        //    72: ldc             6
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: ifnull          109
        //    80: new             Linstrumented/java/util/concurrent/CompletableFuture;
        //    83: dup            
        //    84: aload           4
        //    86: aload_3        
        //    87: ldc             5
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokestatic    instrumented/java/util/concurrent/CompletableFuture.encodeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: ldc             1
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokespecial   instrumented/java/util/concurrent/CompletableFuture.<init>:(Ljava/lang/Object;)V
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: areturn        
        //   109: aconst_null    
        //   110: astore_3       
        //   111: ldc             2
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: aload_3        
        //   117: astore          5
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: aload_2        
        //   125: aload           5
        //   127: ldc             3
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: checkcast       Linstrumented/java/util/concurrent/CompletionStage;
        //   140: ldc             2
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: invokeinterface instrumented/java/util/concurrent/CompletionStage.toCompletableFuture:()Linstrumented/java/util/concurrent/CompletableFuture;
        //   150: astore          6
        //   152: ldc             1
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: aload           6
        //   159: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   162: astore          7
        //   164: ldc             3
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: aload           7
        //   171: ldc             2
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: ifnull          207
        //   179: new             Linstrumented/java/util/concurrent/CompletableFuture;
        //   182: dup            
        //   183: aload           7
        //   185: ldc             4
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: invokestatic    instrumented/java/util/concurrent/CompletableFuture.encodeRelay:(Ljava/lang/Object;)Ljava/lang/Object;
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokespecial   instrumented/java/util/concurrent/CompletableFuture.<init>:(Ljava/lang/Object;)V
        //   201: ldc             1
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: areturn        
        //   207: new             Linstrumented/java/util/concurrent/CompletableFuture;
        //   210: dup            
        //   211: ldc             3
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokespecial   instrumented/java/util/concurrent/CompletableFuture.<init>:()V
        //   219: astore          8
        //   221: ldc             1
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: new             Linstrumented/java/util/concurrent/CompletableFuture$UniRelay;
        //   229: dup            
        //   230: aload           8
        //   232: aload           6
        //   234: ldc             5
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: invokespecial   instrumented/java/util/concurrent/CompletableFuture$UniRelay.<init>:(Linstrumented/java/util/concurrent/CompletableFuture;Linstrumented/java/util/concurrent/CompletableFuture;)V
        //   242: astore          9
        //   244: ldc             1
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: aload           6
        //   251: aload           9
        //   253: ldc             3
        //   255: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   258: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.push:(Linstrumented/java/util/concurrent/CompletableFuture$UniCompletion;)V
        //   261: aload           9
        //   263: iconst_0       
        //   264: ldc             3
        //   266: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   269: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniRelay.tryFire:(I)Linstrumented/java/util/concurrent/CompletableFuture;
        //   272: pop            
        //   273: ldc             1
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: aload           8
        //   280: ldc             1
        //   282: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   285: ldc             1
        //   287: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   290: areturn        
        //   291: astore          5
        //   293: ldc_w           501
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: new             Linstrumented/java/util/concurrent/CompletableFuture;
        //   302: dup            
        //   303: aload           5
        //   305: ldc             4
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: invokestatic    instrumented/java/util/concurrent/CompletableFuture.encodeThrowable:(Ljava/lang/Throwable;)Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   313: ldc             1
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: invokespecial   instrumented/java/util/concurrent/CompletableFuture.<init>:(Ljava/lang/Object;)V
        //   321: ldc             1
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: areturn        
        //   327: new             Linstrumented/java/util/concurrent/CompletableFuture;
        //   330: dup            
        //   331: ldc             3
        //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   336: invokespecial   instrumented/java/util/concurrent/CompletableFuture.<init>:()V
        //   339: astore          5
        //   341: ldc             1
        //   343: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   346: new             Linstrumented/java/util/concurrent/CompletableFuture$UniCompose;
        //   349: dup            
        //   350: aload_1        
        //   351: aload           5
        //   353: aload_0        
        //   354: aload_2        
        //   355: ldc             7
        //   357: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   360: invokespecial   instrumented/java/util/concurrent/CompletableFuture$UniCompose.<init>:(Linstrumented/java/util/concurrent/Executor;Linstrumented/java/util/concurrent/CompletableFuture;Linstrumented/java/util/concurrent/CompletableFuture;Linstrumented/java/util/function/Function;)V
        //   363: astore          6
        //   365: ldc             1
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: aload_0        
        //   371: aload           6
        //   373: ldc             3
        //   375: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   378: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.push:(Linstrumented/java/util/concurrent/CompletableFuture$UniCompletion;)V
        //   381: aload           6
        //   383: iconst_0       
        //   384: ldc             3
        //   386: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   389: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$UniCompose.tryFire:(I)Linstrumented/java/util/concurrent/CompletableFuture;
        //   392: pop            
        //   393: ldc             1
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: aload           5
        //   400: ldc             2
        //   402: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   405: areturn        
        //   406: athrow         
        //   407: athrow         
        //    Signature:
        //  <V:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/Executor;Linstrumented/java/util/function/Function<-TT;+Linstrumented/java/util/concurrent/CompletionStage<TV;>;>;)Linstrumented/java/util/concurrent/CompletableFuture<TV;>;
        //    StackMapTable: 00 08 1B FD 00 51 07 00 05 07 00 89 FA 00 06 FF 00 5A 00 08 07 00 02 07 01 81 07 01 08 07 00 05 00 07 00 05 07 00 02 07 00 05 00 00 FF 00 53 00 04 07 00 02 07 01 81 07 01 08 07 00 05 00 01 07 00 89 FA 00 23 FF 00 4E 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  116    407    407    408    Ljava/lang/VirtualMachineError;
        //  116    201    291    327    Ljava/lang/Throwable;
        //  207    285    291    327    Ljava/lang/Throwable;
        //  0      406    406    407    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0116:
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
    
    final void bipush(final CompletableFuture<?> completableFuture, final BiCompletion<?, ?, ?> biCompletion) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biCompletion != null) {
                Object result;
                while (true) {
                    result = this.result;
                    BytecodeManager.incBytecodes(5);
                    if (result != null) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final boolean tryPushStack = this.tryPushStack(biCompletion);
                    BytecodeManager.incBytecodes(1);
                    if (tryPushStack) {
                        break;
                    }
                    final Completion completion = null;
                    BytecodeManager.incBytecodes(3);
                    lazySetNext(biCompletion, completion);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    if (completableFuture != this) {
                        final Object result2 = completableFuture.result;
                        BytecodeManager.incBytecodes(3);
                        if (result2 == null) {
                            final Object o = result;
                            BytecodeManager.incBytecodes(2);
                            Completion completion2;
                            if (o != null) {
                                completion2 = biCompletion;
                                BytecodeManager.incBytecodes(2);
                            }
                            else {
                                completion2 = new CoCompletion(biCompletion);
                                BytecodeManager.incBytecodes(4);
                            }
                            final Completion completion3 = completion2;
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final Object result3 = completableFuture.result;
                                BytecodeManager.incBytecodes(3);
                                if (result3 != null) {
                                    break;
                                }
                                final Completion completion4 = completion3;
                                BytecodeManager.incBytecodes(3);
                                final boolean tryPushStack2 = completableFuture.tryPushStack(completion4);
                                BytecodeManager.incBytecodes(1);
                                if (tryPushStack2) {
                                    break;
                                }
                                final Completion completion5 = completion3;
                                final Completion completion6 = null;
                                BytecodeManager.incBytecodes(3);
                                lazySetNext(completion5, completion6);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final CompletableFuture<T> postFire(final CompletableFuture<?> completableFuture, final CompletableFuture<?> completableFuture2, final int n) {
        try {
            BytecodeManager.incBytecodes(2);
            Label_0068: {
                if (completableFuture2 != null) {
                    final Completion stack = completableFuture2.stack;
                    BytecodeManager.incBytecodes(3);
                    if (stack != null) {
                        BytecodeManager.incBytecodes(2);
                        if (n >= 0) {
                            final Object result = completableFuture2.result;
                            BytecodeManager.incBytecodes(3);
                            if (result != null) {
                                BytecodeManager.incBytecodes(2);
                                completableFuture2.postComplete();
                                break Label_0068;
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        completableFuture2.cleanStack();
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<T> postFire = this.postFire(completableFuture, n);
            BytecodeManager.incBytecodes(1);
            return postFire;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <R, S> boolean biApply(final CompletableFuture<R> p0, final CompletableFuture<S> p1, final BiFunction<? super R, ? super S, ? extends T> p2, final BiApply<R, S, T> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          5
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          57
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnull          57
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          6
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       331
        //    76: aload           5
        //    78: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    81: ldc             3
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: ifeq            143
        //    89: aload           5
        //    91: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    94: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    97: dup            
        //    98: astore          7
        //   100: ldc             6
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifnull          135
        //   108: aload_0        
        //   109: aload           7
        //   111: aload           5
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   121: pop            
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: goto            331
        //   135: aconst_null    
        //   136: astore          5
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: aload           6
        //   145: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   148: ldc             3
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifeq            210
        //   156: aload           6
        //   158: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   161: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   164: dup            
        //   165: astore          7
        //   167: ldc             6
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: ifnull          202
        //   175: aload_0        
        //   176: aload           7
        //   178: aload           6
        //   180: ldc             4
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   188: pop            
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: goto            331
        //   202: aconst_null    
        //   203: astore          6
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: aload           4
        //   212: ldc             2
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ifnull          250
        //   220: aload           4
        //   222: ldc             2
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$BiApply.claim:()Z
        //   230: ldc             1
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ifne            250
        //   238: iconst_0       
        //   239: ldc             1
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: ldc             1
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: ireturn        
        //   250: aload           5
        //   252: astore          8
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: aload           6
        //   261: astore          9
        //   263: ldc             2
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload_0        
        //   269: aload_3        
        //   270: aload           8
        //   272: aload           9
        //   274: ldc             5
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: invokeinterface instrumented/java/util/function/BiFunction.apply:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   284: ldc             1
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
        //   292: pop            
        //   293: ldc             1
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: ldc             1
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: goto            331
        //   306: astore          8
        //   308: ldc_w           501
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: aload_0        
        //   315: aload           8
        //   317: ldc             3
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   325: pop            
        //   326: ldc             1
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: iconst_1       
        //   332: ldc             2
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: ireturn        
        //   338: athrow         
        //   339: athrow         
        //    Signature:
        //  <R:Ljava/lang/Object;S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TR;>;Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/BiFunction<-TR;-TS;+TT;>;Linstrumented/java/util/concurrent/CompletableFuture$BiApply<TR;TS;TT;>;)Z
        //    StackMapTable: 00 0B 39 FD 00 06 07 00 05 07 00 05 FC 00 46 07 00 89 FA 00 07 FC 00 3A 07 00 89 FA 00 07 27 77 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  210    339    339    340    Ljava/lang/VirtualMachineError;
        //  210    244    306    331    Ljava/lang/Throwable;
        //  250    298    306    331    Ljava/lang/Throwable;
        //  0      338    338    339    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0210:
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
    
    private <U, V> CompletableFuture<V> biApplyStage(final Executor executor, final CompletionStage<U> completionStage, final BiFunction<? super T, ? super U, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<U> completableFuture2;
                final CompletableFuture<U> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Object> completableFuture3 = new CompletableFuture<Object>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Object> completableFuture4 = completableFuture3;
                            final CompletableFuture<U> completableFuture5 = completableFuture2;
                            final BiApply<Object, U, Object> biApply = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean biApply2 = completableFuture4.biApply((CompletableFuture<Object>)this, completableFuture5, (BiFunction<? super Object, ? super U, ?>)biFunction, biApply);
                            BytecodeManager.incBytecodes(1);
                            if (biApply2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Object> completableFuture6 = completableFuture3;
                        final CompletableFuture<U> completableFuture7 = completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final BiApply biApply3 = new BiApply<Object, Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, (CompletableFuture<Object>)completableFuture7, (BiFunction<? super Object, ? super Object, ?>)biFunction);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<U> completableFuture8 = completableFuture2;
                        final BiApply biApply4 = biApply3;
                        BytecodeManager.incBytecodes(4);
                        this.bipush(completableFuture8, biApply4);
                        final BiApply biApply5 = biApply3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        biApply5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Object> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return (CompletableFuture<V>)completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <R, S> boolean biAccept(final CompletableFuture<R> p0, final CompletableFuture<S> p1, final BiConsumer<? super R, ? super S> p2, final BiAccept<R, S> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          5
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          57
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnull          57
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          6
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       331
        //    76: aload           5
        //    78: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    81: ldc             3
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: ifeq            143
        //    89: aload           5
        //    91: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    94: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    97: dup            
        //    98: astore          7
        //   100: ldc             6
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifnull          135
        //   108: aload_0        
        //   109: aload           7
        //   111: aload           5
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   121: pop            
        //   122: ldc             1
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: ldc             1
        //   129: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   132: goto            331
        //   135: aconst_null    
        //   136: astore          5
        //   138: ldc             2
        //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   143: aload           6
        //   145: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   148: ldc             3
        //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   153: ifeq            210
        //   156: aload           6
        //   158: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   161: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   164: dup            
        //   165: astore          7
        //   167: ldc             6
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: ifnull          202
        //   175: aload_0        
        //   176: aload           7
        //   178: aload           6
        //   180: ldc             4
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   188: pop            
        //   189: ldc             1
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: ldc             1
        //   196: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   199: goto            331
        //   202: aconst_null    
        //   203: astore          6
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: aload           4
        //   212: ldc             2
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: ifnull          250
        //   220: aload           4
        //   222: ldc             2
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$BiAccept.claim:()Z
        //   230: ldc             1
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ifne            250
        //   238: iconst_0       
        //   239: ldc             1
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: ldc             1
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: ireturn        
        //   250: aload           5
        //   252: astore          8
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: aload           6
        //   261: astore          9
        //   263: ldc             2
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: aload_3        
        //   269: aload           8
        //   271: aload           9
        //   273: ldc             4
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: invokeinterface instrumented/java/util/function/BiConsumer.accept:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   283: aload_0        
        //   284: ldc             2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   292: pop            
        //   293: ldc             1
        //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   298: ldc             1
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: goto            331
        //   306: astore          8
        //   308: ldc_w           501
        //   311: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   314: aload_0        
        //   315: aload           8
        //   317: ldc             3
        //   319: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   322: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   325: pop            
        //   326: ldc             1
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: iconst_1       
        //   332: ldc             2
        //   334: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   337: ireturn        
        //   338: athrow         
        //   339: athrow         
        //    Signature:
        //  <R:Ljava/lang/Object;S:Ljava/lang/Object;>(Linstrumented/java/util/concurrent/CompletableFuture<TR;>;Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/BiConsumer<-TR;-TS;>;Linstrumented/java/util/concurrent/CompletableFuture$BiAccept<TR;TS;>;)Z
        //    StackMapTable: 00 0B 39 FD 00 06 07 00 05 07 00 05 FC 00 46 07 00 89 FA 00 07 FC 00 3A 07 00 89 FA 00 07 27 77 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  210    339    339    340    Ljava/lang/VirtualMachineError;
        //  210    244    306    331    Ljava/lang/Throwable;
        //  250    298    306    331    Ljava/lang/Throwable;
        //  0      338    338    339    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0210:
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
    
    private <U> CompletableFuture<Void> biAcceptStage(final Executor executor, final CompletionStage<U> completionStage, final BiConsumer<? super T, ? super U> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<U> completableFuture2;
                final CompletableFuture<U> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Void> completableFuture3 = new CompletableFuture<Void>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Void> completableFuture4 = completableFuture3;
                            final CompletableFuture<U> completableFuture5 = completableFuture2;
                            final BiAccept<Object, U> biAccept = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean biAccept2 = completableFuture4.biAccept((CompletableFuture<Object>)this, completableFuture5, (BiConsumer<? super Object, ? super U>)biConsumer, biAccept);
                            BytecodeManager.incBytecodes(1);
                            if (biAccept2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Void> completableFuture6 = completableFuture3;
                        final CompletableFuture<U> completableFuture7 = completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final BiAccept biAccept3 = new BiAccept<Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, (CompletableFuture<Object>)completableFuture7, (BiConsumer<? super Object, ? super Object>)biConsumer);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<U> completableFuture8 = completableFuture2;
                        final BiAccept biAccept4 = biAccept3;
                        BytecodeManager.incBytecodes(4);
                        this.bipush(completableFuture8, biAccept4);
                        final BiAccept biAccept5 = biAccept3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        biAccept5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Void> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean biRun(final CompletableFuture<?> p0, final CompletableFuture<?> p1, final Runnable p2, final BiRun<?, ?> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_1        
        //    10: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    13: dup            
        //    14: astore          5
        //    16: ldc             5
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ifnull          57
        //    24: aload_2        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnull          57
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          6
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       283
        //    76: aload           5
        //    78: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    81: ldc             3
        //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    86: ifeq            130
        //    89: aload           5
        //    91: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    94: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //    97: dup            
        //    98: astore          7
        //   100: ldc             6
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ifnull          130
        //   108: aload_0        
        //   109: aload           7
        //   111: aload           5
        //   113: ldc             4
        //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   118: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   121: pop            
        //   122: ldc             2
        //   124: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   127: goto            283
        //   130: aload           6
        //   132: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   135: ldc             3
        //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   140: ifeq            184
        //   143: aload           6
        //   145: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   148: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   151: dup            
        //   152: astore          7
        //   154: ldc             6
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: ifnull          184
        //   162: aload_0        
        //   163: aload           7
        //   165: aload           6
        //   167: ldc             4
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   175: pop            
        //   176: ldc             2
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: goto            283
        //   184: aload           4
        //   186: ldc             2
        //   188: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   191: ifnull          224
        //   194: aload           4
        //   196: ldc             2
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$BiRun.claim:()Z
        //   204: ldc             1
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: ifne            224
        //   212: iconst_0       
        //   213: ldc             1
        //   215: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   218: ldc             1
        //   220: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   223: ireturn        
        //   224: aload_3        
        //   225: ldc             2
        //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   230: invokeinterface java/lang/Runnable.run:()V
        //   235: aload_0        
        //   236: ldc             2
        //   238: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   241: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   244: pop            
        //   245: ldc             1
        //   247: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   250: ldc             1
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: goto            283
        //   258: astore          8
        //   260: ldc_w           501
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: aload_0        
        //   267: aload           8
        //   269: ldc             3
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   277: pop            
        //   278: ldc             1
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: iconst_1       
        //   284: ldc             2
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: ireturn        
        //   290: athrow         
        //   291: athrow         
        //    Signature:
        //  (Linstrumented/java/util/concurrent/CompletableFuture<*>;Linstrumented/java/util/concurrent/CompletableFuture<*>;Ljava/lang/Runnable;Linstrumented/java/util/concurrent/CompletableFuture$BiRun<**>;)Z
        //    StackMapTable: 00 09 39 FD 00 06 07 00 05 07 00 05 FB 00 41 35 27 61 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  184    291    291    292    Ljava/lang/VirtualMachineError;
        //  184    218    258    283    Ljava/lang/Throwable;
        //  224    250    258    283    Ljava/lang/Throwable;
        //  0      290    290    291    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0184:
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
    
    private CompletableFuture<Void> biRunStage(final Executor executor, final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            BytecodeManager.incBytecodes(2);
            if (runnable != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<?> completableFuture2;
                final CompletableFuture<?> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Void> completableFuture3 = new CompletableFuture<Void>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Void> completableFuture4 = completableFuture3;
                            final CompletableFuture<?> completableFuture5 = completableFuture2;
                            final BiRun<?, ?> biRun = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean biRun2 = completableFuture4.biRun(this, completableFuture5, runnable, biRun);
                            BytecodeManager.incBytecodes(1);
                            if (biRun2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Void> completableFuture6 = completableFuture3;
                        final CompletableFuture<Object> completableFuture7 = (CompletableFuture<Object>)completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final BiRun biRun3 = new BiRun<Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, completableFuture7, runnable);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<Object> completableFuture8 = (CompletableFuture<Object>)completableFuture2;
                        final BiRun biRun4 = biRun3;
                        BytecodeManager.incBytecodes(4);
                        this.bipush(completableFuture8, biRun4);
                        final BiRun biRun5 = biRun3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        biRun5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Void> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean biRelay(final CompletableFuture<?> completableFuture, final CompletableFuture<?> completableFuture2) {
        try {
            BytecodeManager.incBytecodes(2);
            if (completableFuture != null) {
                final Object result;
                final Object o = result = completableFuture.result;
                BytecodeManager.incBytecodes(5);
                if (o != null) {
                    BytecodeManager.incBytecodes(2);
                    if (completableFuture2 != null) {
                        final Object result2;
                        final Object o2 = result2 = completableFuture2.result;
                        BytecodeManager.incBytecodes(5);
                        if (o2 != null) {
                            final Object result3 = this.result;
                            BytecodeManager.incBytecodes(3);
                            Label_0186: {
                                if (result3 == null) {
                                    final boolean b = result instanceof AltResult;
                                    BytecodeManager.incBytecodes(3);
                                    if (b) {
                                        final Throwable ex = ((AltResult)result).ex;
                                        BytecodeManager.incBytecodes(6);
                                        if (ex != null) {
                                            final Throwable t = ex;
                                            final AltResult altResult = (AltResult)result;
                                            BytecodeManager.incBytecodes(4);
                                            this.completeThrowable(t, altResult);
                                            BytecodeManager.incBytecodes(2);
                                            break Label_0186;
                                        }
                                    }
                                    final boolean b2 = result2 instanceof AltResult;
                                    BytecodeManager.incBytecodes(3);
                                    if (b2) {
                                        final Throwable ex2 = ((AltResult)result2).ex;
                                        BytecodeManager.incBytecodes(6);
                                        if (ex2 != null) {
                                            final Throwable t2 = ex2;
                                            final AltResult altResult2 = (AltResult)result2;
                                            BytecodeManager.incBytecodes(4);
                                            this.completeThrowable(t2, altResult2);
                                            BytecodeManager.incBytecodes(2);
                                            break Label_0186;
                                        }
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    this.completeNull();
                                    BytecodeManager.incBytecodes(1);
                                }
                            }
                            final boolean b3 = true;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
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
    
    static CompletableFuture<Void> andTree(final CompletableFuture<?>[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> completableFuture = new CompletableFuture<Void>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            Label_0273: {
                if (n <= n2) {
                    final int n3 = n + n2 >>> 1;
                    BytecodeManager.incBytecodes(6);
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    CompletableFuture<Void> andTree;
                    CompletableFuture<?> completableFuture2;
                    if (n == n4) {
                        completableFuture2 = (andTree = (CompletableFuture<Void>)array[n]);
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final int n5 = n3;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        completableFuture2 = (andTree = andTree(array, n, n5));
                    }
                    final CompletableFuture<Void> completableFuture3 = andTree;
                    BytecodeManager.incBytecodes(3);
                    if (completableFuture2 != null) {
                        BytecodeManager.incBytecodes(3);
                        CompletableFuture<Void> andTree2;
                        CompletableFuture<?> completableFuture4;
                        if (n == n2) {
                            completableFuture4 = (andTree2 = completableFuture3);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n6 = n3 + 1;
                            BytecodeManager.incBytecodes(5);
                            if (n2 == n6) {
                                completableFuture4 = (andTree2 = (CompletableFuture<Void>)array[n2]);
                                BytecodeManager.incBytecodes(4);
                            }
                            else {
                                final int n7 = n3 + 1;
                                BytecodeManager.incBytecodes(5);
                                BytecodeManager.incBytecodes(1);
                                completableFuture4 = (andTree2 = andTree(array, n7, n2));
                            }
                        }
                        final CompletableFuture<Void> completableFuture5 = andTree2;
                        BytecodeManager.incBytecodes(3);
                        if (completableFuture4 != null) {
                            final CompletableFuture<Void> completableFuture6 = completableFuture;
                            final CompletableFuture<Void> completableFuture7 = completableFuture3;
                            final CompletableFuture<Void> completableFuture8 = completableFuture5;
                            BytecodeManager.incBytecodes(4);
                            final boolean biRelay = completableFuture6.biRelay(completableFuture7, completableFuture8);
                            BytecodeManager.incBytecodes(1);
                            if (!biRelay) {
                                final CompletableFuture<Void> completableFuture9 = completableFuture;
                                final CompletableFuture<Void> completableFuture10 = completableFuture3;
                                final CompletableFuture<Void> completableFuture11 = completableFuture5;
                                BytecodeManager.incBytecodes(6);
                                final BiRelay biRelay2 = new BiRelay<Object, Object>(completableFuture9, (CompletableFuture<Object>)completableFuture10, (CompletableFuture<Object>)completableFuture11);
                                BytecodeManager.incBytecodes(1);
                                final CompletableFuture<Void> completableFuture12 = completableFuture3;
                                final CompletableFuture<Void> completableFuture13 = completableFuture5;
                                final BiRelay biRelay3 = biRelay2;
                                BytecodeManager.incBytecodes(4);
                                completableFuture12.bipush(completableFuture13, biRelay3);
                                final BiRelay biRelay4 = biRelay2;
                                final int n8 = 0;
                                BytecodeManager.incBytecodes(3);
                                biRelay4.tryFire(n8);
                                BytecodeManager.incBytecodes(1);
                            }
                            break Label_0273;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                completableFuture.result = CompletableFuture.NIL;
                BytecodeManager.incBytecodes(4);
            }
            final CompletableFuture<Void> completableFuture14 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final void orpush(final CompletableFuture<?> completableFuture, final BiCompletion<?, ?, ?> biCompletion) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biCompletion != null) {
                while (true) {
                    BytecodeManager.incBytecodes(2);
                    if (completableFuture != null) {
                        final Object result = completableFuture.result;
                        BytecodeManager.incBytecodes(3);
                        if (result != null) {
                            break;
                        }
                    }
                    final Object result2 = this.result;
                    BytecodeManager.incBytecodes(3);
                    if (result2 != null) {
                        break;
                    }
                    BytecodeManager.incBytecodes(3);
                    final boolean tryPushStack = this.tryPushStack(biCompletion);
                    BytecodeManager.incBytecodes(1);
                    if (tryPushStack) {
                        BytecodeManager.incBytecodes(2);
                        if (completableFuture == null) {
                            break;
                        }
                        BytecodeManager.incBytecodes(3);
                        if (completableFuture == this) {
                            break;
                        }
                        final Object result3 = completableFuture.result;
                        BytecodeManager.incBytecodes(3);
                        if (result3 == null) {
                            BytecodeManager.incBytecodes(4);
                            final CoCompletion coCompletion = new CoCompletion(biCompletion);
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final Object result4 = this.result;
                                BytecodeManager.incBytecodes(3);
                                if (result4 != null) {
                                    break;
                                }
                                final Object result5 = completableFuture.result;
                                BytecodeManager.incBytecodes(3);
                                if (result5 != null) {
                                    break;
                                }
                                final CoCompletion coCompletion2 = coCompletion;
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                                final boolean tryPushStack2 = completableFuture.tryPushStack(coCompletion2);
                                BytecodeManager.incBytecodes(1);
                                if (tryPushStack2) {
                                    break;
                                }
                                final CoCompletion coCompletion3 = coCompletion;
                                final Completion completion = null;
                                BytecodeManager.incBytecodes(3);
                                lazySetNext(coCompletion3, completion);
                                BytecodeManager.incBytecodes(1);
                            }
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        break;
                    }
                    else {
                        final Completion completion2 = null;
                        BytecodeManager.incBytecodes(3);
                        lazySetNext(biCompletion, completion2);
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
    
    final <R, S extends R> boolean orApply(final CompletableFuture<R> p0, final CompletableFuture<S> p1, final Function<? super R, ? extends T> p2, final OrApply<R, S, T> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_2        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnull          57
        //    18: aload_1        
        //    19: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    22: dup            
        //    23: astore          5
        //    25: ldc             5
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       48
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          5
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       253
        //    76: aload           4
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifnull          116
        //    86: aload           4
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$OrApply.claim:()Z
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifne            116
        //   104: iconst_0       
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ireturn        
        //   116: aload           5
        //   118: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ifeq            183
        //   129: aload           5
        //   131: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   134: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   137: dup            
        //   138: astore          6
        //   140: ldc             6
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ifnull          175
        //   148: aload_0        
        //   149: aload           6
        //   151: aload           5
        //   153: ldc             4
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   161: pop            
        //   162: ldc             1
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: goto            253
        //   175: aconst_null    
        //   176: astore          5
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload           5
        //   185: astore          7
        //   187: ldc             2
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: aload_0        
        //   193: aload_3        
        //   194: aload           7
        //   196: ldc             4
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: invokeinterface instrumented/java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
        //   206: ldc             1
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
        //   214: pop            
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: ldc             1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: goto            253
        //   228: astore          7
        //   230: ldc_w           501
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: aload_0        
        //   237: aload           7
        //   239: ldc             3
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   247: pop            
        //   248: ldc             1
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: iconst_1       
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: ireturn        
        //   260: athrow         
        //   261: athrow         
        //    Signature:
        //  <R:Ljava/lang/Object;S:TR;>(Linstrumented/java/util/concurrent/CompletableFuture<TR;>;Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/Function<-TR;+TT;>;Linstrumented/java/util/concurrent/CompletableFuture$OrApply<TR;TS;TT;>;)Z
        //    StackMapTable: 00 0A FC 00 30 07 00 05 FA 00 08 FC 00 06 07 00 05 33 FC 00 3A 07 00 89 FA 00 07 6C 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  76     261    261    262    Ljava/lang/VirtualMachineError;
        //  76     110    228    253    Ljava/lang/Throwable;
        //  116    167    228    253    Ljava/lang/Throwable;
        //  175    220    228    253    Ljava/lang/Throwable;
        //  0      260    260    261    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0116:
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
    
    private <U extends T, V> CompletableFuture<V> orApplyStage(final Executor executor, final CompletionStage<U> completionStage, final Function<? super T, ? extends V> function) {
        try {
            BytecodeManager.incBytecodes(2);
            if (function != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<U> completableFuture2;
                final CompletableFuture<U> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Object> completableFuture3 = new CompletableFuture<Object>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Object> completableFuture4 = completableFuture3;
                            final CompletableFuture<U> completableFuture5 = completableFuture2;
                            final OrApply<Object, U, Object> orApply = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean orApply2 = completableFuture4.orApply((CompletableFuture<Object>)this, completableFuture5, (Function<? super Object, ?>)function, orApply);
                            BytecodeManager.incBytecodes(1);
                            if (orApply2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Object> completableFuture6 = completableFuture3;
                        final CompletableFuture<U> completableFuture7 = completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final OrApply orApply3 = new OrApply<Object, Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, (CompletableFuture<Object>)completableFuture7, (Function<? super Object, ?>)function);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<U> completableFuture8 = completableFuture2;
                        final OrApply orApply4 = orApply3;
                        BytecodeManager.incBytecodes(4);
                        this.orpush(completableFuture8, orApply4);
                        final OrApply orApply5 = orApply3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        orApply5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Object> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return (CompletableFuture<V>)completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final <R, S extends R> boolean orAccept(final CompletableFuture<R> p0, final CompletableFuture<S> p1, final Consumer<? super R> p2, final OrAccept<R, S> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_2        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnull          57
        //    18: aload_1        
        //    19: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    22: dup            
        //    23: astore          5
        //    25: ldc             5
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       48
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          5
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       253
        //    76: aload           4
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifnull          116
        //    86: aload           4
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$OrAccept.claim:()Z
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifne            116
        //   104: iconst_0       
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ireturn        
        //   116: aload           5
        //   118: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ifeq            183
        //   129: aload           5
        //   131: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   134: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   137: dup            
        //   138: astore          6
        //   140: ldc             6
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ifnull          175
        //   148: aload_0        
        //   149: aload           6
        //   151: aload           5
        //   153: ldc             4
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   161: pop            
        //   162: ldc             1
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: ldc             1
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: goto            253
        //   175: aconst_null    
        //   176: astore          5
        //   178: ldc             2
        //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   183: aload           5
        //   185: astore          7
        //   187: ldc             2
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: aload_3        
        //   193: aload           7
        //   195: ldc             3
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: invokeinterface instrumented/java/util/function/Consumer.accept:(Ljava/lang/Object;)V
        //   205: aload_0        
        //   206: ldc             2
        //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   211: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   214: pop            
        //   215: ldc             1
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: ldc             1
        //   222: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   225: goto            253
        //   228: astore          7
        //   230: ldc_w           501
        //   233: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   236: aload_0        
        //   237: aload           7
        //   239: ldc             3
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   247: pop            
        //   248: ldc             1
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: iconst_1       
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: ireturn        
        //   260: athrow         
        //   261: athrow         
        //    Signature:
        //  <R:Ljava/lang/Object;S:TR;>(Linstrumented/java/util/concurrent/CompletableFuture<TR;>;Linstrumented/java/util/concurrent/CompletableFuture<TS;>;Linstrumented/java/util/function/Consumer<-TR;>;Linstrumented/java/util/concurrent/CompletableFuture$OrAccept<TR;TS;>;)Z
        //    StackMapTable: 00 0A FC 00 30 07 00 05 FA 00 08 FC 00 06 07 00 05 33 FC 00 3A 07 00 89 FA 00 07 6C 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  76     261    261    262    Ljava/lang/VirtualMachineError;
        //  76     110    228    253    Ljava/lang/Throwable;
        //  116    167    228    253    Ljava/lang/Throwable;
        //  175    220    228    253    Ljava/lang/Throwable;
        //  0      260    260    261    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0116:
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
    
    private <U extends T> CompletableFuture<Void> orAcceptStage(final Executor executor, final CompletionStage<U> completionStage, final Consumer<? super T> consumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (consumer != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<U> completableFuture2;
                final CompletableFuture<U> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Void> completableFuture3 = new CompletableFuture<Void>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Void> completableFuture4 = completableFuture3;
                            final CompletableFuture<U> completableFuture5 = completableFuture2;
                            final OrAccept<Object, U> orAccept = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean orAccept2 = completableFuture4.orAccept((CompletableFuture<Object>)this, completableFuture5, (Consumer<? super Object>)consumer, orAccept);
                            BytecodeManager.incBytecodes(1);
                            if (orAccept2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Void> completableFuture6 = completableFuture3;
                        final CompletableFuture<U> completableFuture7 = completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final OrAccept orAccept3 = new OrAccept<Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, (CompletableFuture<Object>)completableFuture7, (Consumer<? super Object>)consumer);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<U> completableFuture8 = completableFuture2;
                        final OrAccept orAccept4 = orAccept3;
                        BytecodeManager.incBytecodes(4);
                        this.orpush(completableFuture8, orAccept4);
                        final OrAccept orAccept5 = orAccept3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        orAccept5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Void> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean orRun(final CompletableFuture<?> p0, final CompletableFuture<?> p1, final Runnable p2, final OrRun<?, ?> p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: ifnull          57
        //     9: aload_2        
        //    10: ldc             2
        //    12: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    15: ifnull          57
        //    18: aload_1        
        //    19: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    22: dup            
        //    23: astore          5
        //    25: ldc             5
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       48
        //    33: aload_2        
        //    34: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    37: dup            
        //    38: astore          5
        //    40: ldc             5
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: ifnull          57
        //    48: aload_3        
        //    49: ldc             2
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: ifnonnull       64
        //    57: iconst_0       
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ireturn        
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    68: ldc             3
        //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    73: ifnonnull       229
        //    76: aload           4
        //    78: ldc             2
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifnull          116
        //    86: aload           4
        //    88: ldc             2
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: invokevirtual   instrumented/java/util/concurrent/CompletableFuture$OrRun.claim:()Z
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ifne            116
        //   104: iconst_0       
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: ldc             1
        //   112: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   115: ireturn        
        //   116: aload           5
        //   118: instanceof      Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ifeq            170
        //   129: aload           5
        //   131: checkcast       Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //   134: getfield        instrumented/java/util/concurrent/CompletableFuture$AltResult.ex:Ljava/lang/Throwable;
        //   137: dup            
        //   138: astore          6
        //   140: ldc             6
        //   142: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   145: ifnull          170
        //   148: aload_0        
        //   149: aload           6
        //   151: aload           5
        //   153: ldc             4
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;Ljava/lang/Object;)Z
        //   161: pop            
        //   162: ldc             2
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: goto            196
        //   170: aload_3        
        //   171: ldc             2
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: invokeinterface java/lang/Runnable.run:()V
        //   181: aload_0        
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
        //   190: pop            
        //   191: ldc             1
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: ldc             1
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: goto            229
        //   204: astore          7
        //   206: ldc_w           501
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: aload_0        
        //   213: aload           7
        //   215: ldc             3
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
        //   223: pop            
        //   224: ldc             1
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: iconst_1       
        //   230: ldc             2
        //   232: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   235: ireturn        
        //   236: athrow         
        //   237: athrow         
        //    Signature:
        //  (Linstrumented/java/util/concurrent/CompletableFuture<*>;Linstrumented/java/util/concurrent/CompletableFuture<*>;Ljava/lang/Runnable;Linstrumented/java/util/concurrent/CompletableFuture$OrRun<**>;)Z
        //    StackMapTable: 00 0A FC 00 30 07 00 05 FA 00 08 FC 00 06 07 00 05 33 35 19 47 07 00 89 18 FF 00 06 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  76     237    237    238    Ljava/lang/VirtualMachineError;
        //  76     110    204    229    Ljava/lang/Throwable;
        //  116    196    204    229    Ljava/lang/Throwable;
        //  0      236    236    237    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0116:
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
    
    private CompletableFuture<Void> orRunStage(final Executor executor, final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            BytecodeManager.incBytecodes(2);
            if (runnable != null) {
                BytecodeManager.incBytecodes(2);
                final CompletableFuture<?> completableFuture2;
                final CompletableFuture<?> completableFuture = completableFuture2 = completionStage.toCompletableFuture();
                BytecodeManager.incBytecodes(3);
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<Void> completableFuture3 = new CompletableFuture<Void>();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    Label_0157: {
                        if (executor == null) {
                            final CompletableFuture<Void> completableFuture4 = completableFuture3;
                            final CompletableFuture<?> completableFuture5 = completableFuture2;
                            final OrRun<?, ?> orRun = null;
                            BytecodeManager.incBytecodes(6);
                            final boolean orRun2 = completableFuture4.orRun(this, completableFuture5, runnable, orRun);
                            BytecodeManager.incBytecodes(1);
                            if (orRun2) {
                                break Label_0157;
                            }
                        }
                        final CompletableFuture<Void> completableFuture6 = completableFuture3;
                        final CompletableFuture<Object> completableFuture7 = (CompletableFuture<Object>)completableFuture2;
                        BytecodeManager.incBytecodes(8);
                        final OrRun orRun3 = new OrRun<Object, Object>(executor, completableFuture6, (CompletableFuture<Object>)this, completableFuture7, runnable);
                        BytecodeManager.incBytecodes(1);
                        final CompletableFuture<Object> completableFuture8 = (CompletableFuture<Object>)completableFuture2;
                        final OrRun orRun4 = orRun3;
                        BytecodeManager.incBytecodes(4);
                        this.orpush(completableFuture8, orRun4);
                        final OrRun orRun5 = orRun3;
                        final int n = 0;
                        BytecodeManager.incBytecodes(3);
                        orRun5.tryFire(n);
                        BytecodeManager.incBytecodes(1);
                    }
                    final CompletableFuture<Void> completableFuture9 = completableFuture3;
                    BytecodeManager.incBytecodes(2);
                    return completableFuture9;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    final boolean orRelay(final CompletableFuture<?> completableFuture, final CompletableFuture<?> completableFuture2) {
        try {
            BytecodeManager.incBytecodes(2);
            Label_0046: {
                if (completableFuture != null) {
                    BytecodeManager.incBytecodes(2);
                    if (completableFuture2 != null) {
                        Object o = completableFuture.result;
                        BytecodeManager.incBytecodes(5);
                        if (o == null) {
                            final Object o2 = o = completableFuture2.result;
                            BytecodeManager.incBytecodes(5);
                            if (o2 == null) {
                                break Label_0046;
                            }
                        }
                        final Object result = this.result;
                        BytecodeManager.incBytecodes(3);
                        if (result == null) {
                            final Object o3 = o;
                            BytecodeManager.incBytecodes(3);
                            this.completeRelay(o3);
                            BytecodeManager.incBytecodes(1);
                        }
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
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
    
    static CompletableFuture<Object> orTree(final CompletableFuture<?>[] array, final int n, final int n2) {
        try {
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> completableFuture = new CompletableFuture<Object>();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            Label_0258: {
                if (n <= n2) {
                    final int n3 = n + n2 >>> 1;
                    BytecodeManager.incBytecodes(6);
                    final int n4 = n3;
                    BytecodeManager.incBytecodes(3);
                    CompletableFuture<Object> orTree;
                    CompletableFuture<?> completableFuture2;
                    if (n == n4) {
                        completableFuture2 = (orTree = (CompletableFuture<Object>)array[n]);
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        final int n5 = n3;
                        BytecodeManager.incBytecodes(3);
                        BytecodeManager.incBytecodes(1);
                        completableFuture2 = (orTree = orTree(array, n, n5));
                    }
                    final CompletableFuture<Object> completableFuture3 = orTree;
                    BytecodeManager.incBytecodes(3);
                    if (completableFuture2 != null) {
                        BytecodeManager.incBytecodes(3);
                        CompletableFuture<Object> orTree2;
                        CompletableFuture<?> completableFuture4;
                        if (n == n2) {
                            completableFuture4 = (orTree2 = completableFuture3);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final int n6 = n3 + 1;
                            BytecodeManager.incBytecodes(5);
                            if (n2 == n6) {
                                completableFuture4 = (orTree2 = (CompletableFuture<Object>)array[n2]);
                                BytecodeManager.incBytecodes(4);
                            }
                            else {
                                final int n7 = n3 + 1;
                                BytecodeManager.incBytecodes(5);
                                BytecodeManager.incBytecodes(1);
                                completableFuture4 = (orTree2 = orTree(array, n7, n2));
                            }
                        }
                        final CompletableFuture<Object> completableFuture5 = orTree2;
                        BytecodeManager.incBytecodes(3);
                        if (completableFuture4 != null) {
                            final CompletableFuture<Object> completableFuture6 = completableFuture;
                            final CompletableFuture<Object> completableFuture7 = completableFuture3;
                            final CompletableFuture<Object> completableFuture8 = completableFuture5;
                            BytecodeManager.incBytecodes(4);
                            final boolean orRelay = completableFuture6.orRelay(completableFuture7, completableFuture8);
                            BytecodeManager.incBytecodes(1);
                            if (!orRelay) {
                                final CompletableFuture<Object> completableFuture9 = completableFuture;
                                final CompletableFuture<Object> completableFuture10 = completableFuture3;
                                final CompletableFuture<Object> completableFuture11 = completableFuture5;
                                BytecodeManager.incBytecodes(6);
                                final OrRelay orRelay2 = new OrRelay<Object, Object>(completableFuture9, completableFuture10, completableFuture11);
                                BytecodeManager.incBytecodes(1);
                                final CompletableFuture<Object> completableFuture12 = completableFuture3;
                                final CompletableFuture<Object> completableFuture13 = completableFuture5;
                                final OrRelay orRelay3 = orRelay2;
                                BytecodeManager.incBytecodes(4);
                                completableFuture12.orpush(completableFuture13, orRelay3);
                                final OrRelay orRelay4 = orRelay2;
                                final int n8 = 0;
                                BytecodeManager.incBytecodes(3);
                                orRelay4.tryFire(n8);
                                BytecodeManager.incBytecodes(1);
                            }
                            break Label_0258;
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            final CompletableFuture<Object> completableFuture14 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture14;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static <U> CompletableFuture<U> asyncSupplyStage(final Executor executor, final Supplier<U> supplier) {
        try {
            BytecodeManager.incBytecodes(2);
            if (supplier == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> completableFuture = new CompletableFuture<Object>();
            BytecodeManager.incBytecodes(1);
            final CompletableFuture<Object> completableFuture2 = completableFuture;
            BytecodeManager.incBytecodes(6);
            final AsyncSupply asyncSupply = new AsyncSupply<Object>(completableFuture2, (Supplier<Object>)supplier);
            BytecodeManager.incBytecodes(1);
            executor.execute(asyncSupply);
            final CompletableFuture<Object> completableFuture3 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return (CompletableFuture<U>)completableFuture3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static CompletableFuture<Void> asyncRunStage(final Executor executor, final Runnable runnable) {
        try {
            BytecodeManager.incBytecodes(2);
            if (runnable == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> completableFuture = new CompletableFuture<Void>();
            BytecodeManager.incBytecodes(1);
            final CompletableFuture<Void> completableFuture2 = completableFuture;
            BytecodeManager.incBytecodes(6);
            final AsyncRun asyncRun = new AsyncRun(completableFuture2, runnable);
            BytecodeManager.incBytecodes(1);
            executor.execute(asyncRun);
            final CompletableFuture<Void> completableFuture3 = completableFuture;
            BytecodeManager.incBytecodes(2);
            return completableFuture3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private Object waitingGet(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: iconst_0       
        //     8: istore_3       
        //     9: ldc             2
        //    11: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    14: iconst_m1      
        //    15: istore          4
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_0        
        //    23: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //    26: dup            
        //    27: astore          5
        //    29: ldc             5
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: ifnonnull       311
        //    37: iload           4
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: ifge            99
        //    47: ldc             1
        //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    52: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //    55: ldc             1
        //    57: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    60: invokevirtual   java/lang/Runtime.availableProcessors:()I
        //    63: iconst_1       
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: if_icmple       83
        //    72: sipush          256
        //    75: ldc             2
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: goto            89
        //    83: iconst_0       
        //    84: ldc             1
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: istore          4
        //    91: ldc             2
        //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    96: goto            22
        //    99: iload           4
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: ifle            136
        //   109: ldc             1
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokestatic    instrumented/java/util/concurrent/ThreadLocalRandom.nextSecondarySeed:()I
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: iflt            22
        //   125: iinc            4, -1
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: goto            22
        //   136: aload_2        
        //   137: ldc             2
        //   139: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   142: ifnonnull       169
        //   145: new             Linstrumented/java/util/concurrent/CompletableFuture$Signaller;
        //   148: dup            
        //   149: iload_1        
        //   150: lconst_0       
        //   151: lconst_0       
        //   152: ldc             6
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokespecial   instrumented/java/util/concurrent/CompletableFuture$Signaller.<init>:(ZJJ)V
        //   160: astore_2       
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            22
        //   169: iload_3        
        //   170: ldc             2
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: ifne            197
        //   178: aload_0        
        //   179: aload_2        
        //   180: ldc             3
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.tryPushStack:(Linstrumented/java/util/concurrent/CompletableFuture$Completion;)Z
        //   188: istore_3       
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: goto            22
        //   197: iload_1        
        //   198: ldc             2
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ifeq            244
        //   206: aload_2        
        //   207: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   210: ldc             3
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: ifge            244
        //   218: aload_2        
        //   219: aconst_null    
        //   220: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   223: ldc             3
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: aload_0        
        //   229: ldc             2
        //   231: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   234: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.cleanStack:()V
        //   237: aconst_null    
        //   238: ldc             2
        //   240: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   243: areturn        
        //   244: aload_2        
        //   245: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   248: ldc             3
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: ifnull          22
        //   256: aload_0        
        //   257: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   260: ldc             3
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: ifnonnull       22
        //   268: aload_2        
        //   269: ldc             2
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: invokestatic    instrumented/java/util/concurrent/ForkJoinPool.managedBlock:(Linstrumented/java/util/concurrent/ForkJoinPool$ManagedBlocker;)V
        //   277: ldc             1
        //   279: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   282: goto            22
        //   285: astore          6
        //   287: ldc_w           501
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: aload_2        
        //   294: iconst_m1      
        //   295: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   298: ldc             3
        //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   303: ldc             1
        //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   308: goto            22
        //   311: aload_2        
        //   312: ldc             2
        //   314: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   317: ifnull          378
        //   320: aload_2        
        //   321: aconst_null    
        //   322: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   325: ldc             3
        //   327: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   330: aload_2        
        //   331: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   334: ldc             3
        //   336: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   339: ifge            378
        //   342: iload_1        
        //   343: ldc             2
        //   345: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   348: ifeq            362
        //   351: aconst_null    
        //   352: astore          5
        //   354: ldc             3
        //   356: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   359: goto            378
        //   362: ldc             1
        //   364: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   367: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   370: ldc             1
        //   372: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   375: invokevirtual   java/lang/Thread.interrupt:()V
        //   378: aload_0        
        //   379: ldc             2
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.postComplete:()V
        //   387: aload           5
        //   389: ldc             2
        //   391: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   394: areturn        
        //   395: athrow         
        //   396: athrow         
        //    StackMapTable: 00 0E FE 00 16 07 00 39 01 01 FC 00 3C 07 00 05 45 01 09 24 20 1B 2E 68 07 00 C2 19 32 0F FF 00 10 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  268    396    396    397    Ljava/lang/VirtualMachineError;
        //  268    277    285    311    Ljava/lang/InterruptedException;
        //  0      395    395    396    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0311:
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
    
    private Object timedGet(final long p0) throws TimeoutException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     5: invokestatic    java/lang/Thread.interrupted:()Z
        //     8: ldc             1
        //    10: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    13: ifeq            23
        //    16: aconst_null    
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: areturn        
        //    23: lload_1        
        //    24: lconst_0       
        //    25: lcmp           
        //    26: ldc             4
        //    28: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    31: ifgt            52
        //    34: new             Linstrumented/java/util/concurrent/TimeoutException;
        //    37: dup            
        //    38: ldc             3
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: invokespecial   instrumented/java/util/concurrent/TimeoutException.<init>:()V
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: athrow         
        //    52: ldc             1
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokestatic    java/lang/System.nanoTime:()J
        //    60: lload_1        
        //    61: ladd           
        //    62: lstore_3       
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: new             Linstrumented/java/util/concurrent/CompletableFuture$Signaller;
        //    71: dup            
        //    72: iconst_1       
        //    73: lload_1        
        //    74: lload_3        
        //    75: lconst_0       
        //    76: lcmp           
        //    77: ldc_w           8
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: ifne            95
        //    86: lconst_1       
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: goto            101
        //    95: lload_3        
        //    96: ldc             1
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: ldc             1
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: invokespecial   instrumented/java/util/concurrent/CompletableFuture$Signaller.<init>:(ZJJ)V
        //   109: astore          5
        //   111: ldc             1
        //   113: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   116: iconst_0       
        //   117: istore          6
        //   119: ldc             2
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   128: dup            
        //   129: astore          7
        //   131: ldc             5
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: ifnonnull       326
        //   139: iload           6
        //   141: ldc             2
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: ifne            170
        //   149: aload_0        
        //   150: aload           5
        //   152: ldc             3
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.tryPushStack:(Linstrumented/java/util/concurrent/CompletableFuture$Completion;)Z
        //   160: istore          6
        //   162: ldc             2
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: goto            124
        //   170: aload           5
        //   172: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   175: ldc             3
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: iflt            198
        //   183: aload           5
        //   185: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.nanos:J
        //   188: lconst_0       
        //   189: lcmp           
        //   190: ldc             5
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: ifgt            256
        //   198: aload           5
        //   200: aconst_null    
        //   201: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   204: ldc             3
        //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   209: aload_0        
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.cleanStack:()V
        //   218: aload           5
        //   220: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   223: ldc             3
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: ifge            238
        //   231: aconst_null    
        //   232: ldc             2
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: areturn        
        //   238: new             Linstrumented/java/util/concurrent/TimeoutException;
        //   241: dup            
        //   242: ldc             3
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: invokespecial   instrumented/java/util/concurrent/TimeoutException.<init>:()V
        //   250: ldc             1
        //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   255: athrow         
        //   256: aload           5
        //   258: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   261: ldc             3
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: ifnull          124
        //   269: aload_0        
        //   270: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
        //   273: ldc             3
        //   275: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   278: ifnonnull       124
        //   281: aload           5
        //   283: ldc             2
        //   285: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   288: invokestatic    instrumented/java/util/concurrent/ForkJoinPool.managedBlock:(Linstrumented/java/util/concurrent/ForkJoinPool$ManagedBlocker;)V
        //   291: ldc             1
        //   293: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   296: goto            124
        //   299: astore          8
        //   301: ldc_w           501
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: aload           5
        //   309: iconst_m1      
        //   310: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   313: ldc             3
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: ldc             1
        //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   323: goto            124
        //   326: aload           5
        //   328: getfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.interruptControl:I
        //   331: ldc             3
        //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   336: ifge            347
        //   339: aconst_null    
        //   340: astore          7
        //   342: ldc             2
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: aload           5
        //   349: aconst_null    
        //   350: putfield        instrumented/java/util/concurrent/CompletableFuture$Signaller.thread:Ljava/lang/Thread;
        //   353: ldc             3
        //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   358: aload_0        
        //   359: ldc             2
        //   361: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   364: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.postComplete:()V
        //   367: aload           7
        //   369: ldc             2
        //   371: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   374: areturn        
        //   375: athrow         
        //   376: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.concurrent.TimeoutException
        //    StackMapTable: 00 0E 17 1C FF 00 2A 00 03 07 00 02 04 04 00 04 08 00 44 08 00 44 01 04 FF 00 05 00 03 07 00 02 04 04 00 05 08 00 44 08 00 44 01 04 04 FD 00 16 07 00 39 01 FC 00 2D 07 00 05 1B 27 11 6A 07 00 C2 1A 14 FF 00 1B 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  281    376    376    377    Ljava/lang/VirtualMachineError;
        //  281    291    299    326    Ljava/lang/InterruptedException;
        //  0      375    375    376    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0326:
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
    
    public CompletableFuture() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private CompletableFuture(final Object result) {
        try {
            BytecodeManager.incBytecodes(2);
            this.result = result;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <U> CompletableFuture<U> supplyAsync(final Supplier<U> supplier) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<U> asyncSupplyStage = asyncSupplyStage(asyncPool, supplier);
            BytecodeManager.incBytecodes(1);
            return asyncSupplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <U> CompletableFuture<U> supplyAsync(final Supplier<U> supplier, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(2);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<U> asyncSupplyStage = asyncSupplyStage(screenExecutor, supplier);
            BytecodeManager.incBytecodes(1);
            return asyncSupplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static CompletableFuture<Void> runAsync(final Runnable runnable) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> asyncRunStage = asyncRunStage(asyncPool, runnable);
            BytecodeManager.incBytecodes(1);
            return asyncRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static CompletableFuture<Void> runAsync(final Runnable runnable, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(2);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Void> asyncRunStage = asyncRunStage(screenExecutor, runnable);
            BytecodeManager.incBytecodes(1);
            return asyncRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static <U> CompletableFuture<U> completedFuture(final U u) {
        try {
            BytecodeManager.incBytecodes(4);
            Object nil;
            if (u == null) {
                nil = CompletableFuture.NIL;
                BytecodeManager.incBytecodes(2);
            }
            else {
                nil = u;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final CompletableFuture completableFuture = new CompletableFuture<U>(nil);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)completableFuture;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isDone() {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (result != null) {
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
    public T get() throws InterruptedException, ExecutionException {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(5);
            Object waitingGet;
            if (result == null) {
                final boolean b = true;
                BytecodeManager.incBytecodes(3);
                waitingGet = this.waitingGet(b);
                BytecodeManager.incBytecodes(1);
            }
            else {
                waitingGet = result;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final Object reportGet = reportGet(waitingGet);
            BytecodeManager.incBytecodes(1);
            return (T)reportGet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public T get(final long duration, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        try {
            BytecodeManager.incBytecodes(3);
            final long nanos = timeUnit.toNanos(duration);
            BytecodeManager.incBytecodes(1);
            final Object result = this.result;
            BytecodeManager.incBytecodes(5);
            Object timedGet;
            if (result == null) {
                final long n = nanos;
                BytecodeManager.incBytecodes(3);
                timedGet = this.timedGet(n);
                BytecodeManager.incBytecodes(1);
            }
            else {
                timedGet = result;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final Object reportGet = reportGet(timedGet);
            BytecodeManager.incBytecodes(1);
            return (T)reportGet;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T join() {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(5);
            Object waitingGet;
            if (result == null) {
                final boolean b = false;
                BytecodeManager.incBytecodes(3);
                waitingGet = this.waitingGet(b);
                BytecodeManager.incBytecodes(1);
            }
            else {
                waitingGet = result;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            final Object reportJoin = reportJoin(waitingGet);
            BytecodeManager.incBytecodes(1);
            return (T)reportJoin;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public T getNow(final T t) {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(5);
            T reportJoin;
            if (result == null) {
                reportJoin = t;
                BytecodeManager.incBytecodes(2);
            }
            else {
                final Object o = result;
                BytecodeManager.incBytecodes(2);
                reportJoin = (T)reportJoin(o);
            }
            BytecodeManager.incBytecodes(1);
            return reportJoin;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean complete(final T t) {
        try {
            BytecodeManager.incBytecodes(3);
            final boolean completeValue = this.completeValue(t);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.postComplete();
            final boolean b = completeValue;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public boolean completeExceptionally(final Throwable t) {
        try {
            BytecodeManager.incBytecodes(2);
            if (t == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(5);
            final AltResult altResult = new AltResult(t);
            BytecodeManager.incBytecodes(1);
            final boolean internalComplete = this.internalComplete(altResult);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.postComplete();
            final boolean b = internalComplete;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenApply(final Function<? super T, ? extends U> function) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniApplyStage = this.uniApplyStage(executor, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenApplyAsync(final Function<? super T, ? extends U> function) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniApplyStage = this.uniApplyStage(asyncPool, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenApplyAsync(final Function<? super T, ? extends U> function, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Object> uniApplyStage = this.uniApplyStage(screenExecutor, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenAccept(final Consumer<? super T> consumer) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Void> uniAcceptStage = this.uniAcceptStage(executor, consumer);
            BytecodeManager.incBytecodes(1);
            return uniAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenAcceptAsync(final Consumer<? super T> consumer) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Void> uniAcceptStage = this.uniAcceptStage(asyncPool, consumer);
            BytecodeManager.incBytecodes(1);
            return uniAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenAcceptAsync(final Consumer<? super T> consumer, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Void> uniAcceptStage = this.uniAcceptStage(screenExecutor, consumer);
            BytecodeManager.incBytecodes(1);
            return uniAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenRun(final Runnable runnable) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Void> uniRunStage = this.uniRunStage(executor, runnable);
            BytecodeManager.incBytecodes(1);
            return uniRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenRunAsync(final Runnable runnable) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Void> uniRunStage = this.uniRunStage(asyncPool, runnable);
            BytecodeManager.incBytecodes(1);
            return uniRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> thenRunAsync(final Runnable runnable, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Void> uniRunStage = this.uniRunStage(screenExecutor, runnable);
            BytecodeManager.incBytecodes(1);
            return uniRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U, V> CompletableFuture<V> thenCombine(final CompletionStage<? extends U> completionStage, final BiFunction<? super T, ? super U, ? extends V> biFunction) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Object> biApplyStage = this.biApplyStage(executor, (CompletionStage<Object>)completionStage, (BiFunction<? super T, ? super Object, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<V>)biApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U, V> CompletableFuture<V> thenCombineAsync(final CompletionStage<? extends U> completionStage, final BiFunction<? super T, ? super U, ? extends V> biFunction) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Object> biApplyStage = this.biApplyStage(asyncPool, (CompletionStage<Object>)completionStage, (BiFunction<? super T, ? super Object, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<V>)biApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U, V> CompletableFuture<V> thenCombineAsync(final CompletionStage<? extends U> completionStage, final BiFunction<? super T, ? super U, ? extends V> biFunction, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> biApplyStage = this.biApplyStage(screenExecutor, (CompletionStage<Object>)completionStage, (BiFunction<? super T, ? super Object, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<V>)biApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<Void> thenAcceptBoth(final CompletionStage<? extends U> completionStage, final BiConsumer<? super T, ? super U> biConsumer) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> biAcceptStage = this.biAcceptStage(executor, (CompletionStage<Object>)completionStage, (BiConsumer<? super T, ? super Object>)biConsumer);
            BytecodeManager.incBytecodes(1);
            return biAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<Void> thenAcceptBothAsync(final CompletionStage<? extends U> completionStage, final BiConsumer<? super T, ? super U> biConsumer) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> biAcceptStage = this.biAcceptStage(asyncPool, (CompletionStage<Object>)completionStage, (BiConsumer<? super T, ? super Object>)biConsumer);
            BytecodeManager.incBytecodes(1);
            return biAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<Void> thenAcceptBothAsync(final CompletionStage<? extends U> completionStage, final BiConsumer<? super T, ? super U> biConsumer, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> biAcceptStage = this.biAcceptStage(screenExecutor, (CompletionStage<Object>)completionStage, (BiConsumer<? super T, ? super Object>)biConsumer);
            BytecodeManager.incBytecodes(1);
            return biAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterBoth(final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> biRunStage = this.biRunStage(executor, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return biRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterBothAsync(final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> biRunStage = this.biRunStage(asyncPool, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return biRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterBothAsync(final CompletionStage<?> completionStage, final Runnable runnable, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> biRunStage = this.biRunStage(screenExecutor, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return biRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> applyToEither(final CompletionStage<? extends T> completionStage, final Function<? super T, U> function) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Object> orApplyStage = this.orApplyStage(executor, (CompletionStage<Object>)completionStage, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)orApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> applyToEitherAsync(final CompletionStage<? extends T> completionStage, final Function<? super T, U> function) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Object> orApplyStage = this.orApplyStage(asyncPool, (CompletionStage<Object>)completionStage, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)orApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> applyToEitherAsync(final CompletionStage<? extends T> completionStage, final Function<? super T, U> function, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Object> orApplyStage = this.orApplyStage(screenExecutor, (CompletionStage<Object>)completionStage, (Function<? super T, ?>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)orApplyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> acceptEither(final CompletionStage<? extends T> completionStage, final Consumer<? super T> consumer) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> orAcceptStage = this.orAcceptStage(executor, (CompletionStage<Object>)completionStage, consumer);
            BytecodeManager.incBytecodes(1);
            return orAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> acceptEitherAsync(final CompletionStage<? extends T> completionStage, final Consumer<? super T> consumer) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> orAcceptStage = this.orAcceptStage(asyncPool, (CompletionStage<Object>)completionStage, consumer);
            BytecodeManager.incBytecodes(1);
            return orAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> acceptEitherAsync(final CompletionStage<? extends T> completionStage, final Consumer<? super T> consumer, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> orAcceptStage = this.orAcceptStage(screenExecutor, (CompletionStage<Object>)completionStage, consumer);
            BytecodeManager.incBytecodes(1);
            return orAcceptStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterEither(final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> orRunStage = this.orRunStage(executor, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return orRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterEitherAsync(final CompletionStage<?> completionStage, final Runnable runnable) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(5);
            final CompletableFuture<Void> orRunStage = this.orRunStage(asyncPool, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return orRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<Void> runAfterEitherAsync(final CompletionStage<?> completionStage, final Runnable runnable, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<Void> orRunStage = this.orRunStage(screenExecutor, completionStage, runnable);
            BytecodeManager.incBytecodes(1);
            return orRunStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenCompose(final Function<? super T, ? extends CompletionStage<U>> function) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniComposeStage = this.uniComposeStage(executor, (Function<? super T, ? extends CompletionStage<Object>>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniComposeStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenComposeAsync(final Function<? super T, ? extends CompletionStage<U>> function) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniComposeStage = this.uniComposeStage(asyncPool, (Function<? super T, ? extends CompletionStage<Object>>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniComposeStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> thenComposeAsync(final Function<? super T, ? extends CompletionStage<U>> function, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Object> uniComposeStage = this.uniComposeStage(screenExecutor, (Function<? super T, ? extends CompletionStage<Object>>)function);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniComposeStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<T> whenComplete(final BiConsumer<? super T, ? super Throwable> biConsumer) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<T> uniWhenCompleteStage = this.uniWhenCompleteStage(executor, biConsumer);
            BytecodeManager.incBytecodes(1);
            return uniWhenCompleteStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<T> whenCompleteAsync(final BiConsumer<? super T, ? super Throwable> biConsumer) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<T> uniWhenCompleteStage = this.uniWhenCompleteStage(asyncPool, biConsumer);
            BytecodeManager.incBytecodes(1);
            return uniWhenCompleteStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<T> whenCompleteAsync(final BiConsumer<? super T, ? super Throwable> biConsumer, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<T> uniWhenCompleteStage = this.uniWhenCompleteStage(screenExecutor, biConsumer);
            BytecodeManager.incBytecodes(1);
            return uniWhenCompleteStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> handle(final BiFunction<? super T, Throwable, ? extends U> biFunction) {
        try {
            final Executor executor = null;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniHandleStage = this.uniHandleStage(executor, (BiFunction<? super T, Throwable, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniHandleStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> handleAsync(final BiFunction<? super T, Throwable, ? extends U> biFunction) {
        try {
            final Executor asyncPool = CompletableFuture.asyncPool;
            BytecodeManager.incBytecodes(4);
            final CompletableFuture<Object> uniHandleStage = this.uniHandleStage(asyncPool, (BiFunction<? super T, Throwable, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniHandleStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public <U> CompletableFuture<U> handleAsync(final BiFunction<? super T, Throwable, ? extends U> biFunction, final Executor executor) {
        try {
            BytecodeManager.incBytecodes(3);
            final Executor screenExecutor = screenExecutor(executor);
            BytecodeManager.incBytecodes(2);
            final CompletableFuture<Object> uniHandleStage = this.uniHandleStage(screenExecutor, (BiFunction<? super T, Throwable, ?>)biFunction);
            BytecodeManager.incBytecodes(1);
            return (CompletableFuture<U>)uniHandleStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<T> toCompletableFuture() {
        try {
            BytecodeManager.incBytecodes(2);
            return this;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public CompletableFuture<T> exceptionally(final Function<Throwable, ? extends T> function) {
        try {
            BytecodeManager.incBytecodes(3);
            final CompletableFuture<T> uniExceptionallyStage = this.uniExceptionallyStage(function);
            BytecodeManager.incBytecodes(1);
            return uniExceptionallyStage;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static CompletableFuture<Void> allOf(final CompletableFuture<?>... array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            BytecodeManager.incBytecodes(7);
            final CompletableFuture<Void> andTree = andTree(array, n, n2);
            BytecodeManager.incBytecodes(1);
            return andTree;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static CompletableFuture<Object> anyOf(final CompletableFuture<?>... array) {
        try {
            final int n = 0;
            final int n2 = array.length - 1;
            BytecodeManager.incBytecodes(7);
            final CompletableFuture<Object> orTree = orTree(array, n, n2);
            BytecodeManager.incBytecodes(1);
            return orTree;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean cancel(final boolean b) {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(3);
            boolean b2 = false;
            Label_0068: {
                if (result == null) {
                    BytecodeManager.incBytecodes(6);
                    final CancellationException ex = new CancellationException();
                    BytecodeManager.incBytecodes(1);
                    final AltResult altResult = new AltResult(ex);
                    BytecodeManager.incBytecodes(1);
                    final boolean internalComplete = this.internalComplete(altResult);
                    BytecodeManager.incBytecodes(1);
                    if (internalComplete) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0068;
                    }
                }
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            final boolean b3 = b2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.postComplete();
            final boolean b4 = b3;
            BytecodeManager.incBytecodes(2);
            boolean b5 = false;
            Label_0124: {
                if (!b4) {
                    BytecodeManager.incBytecodes(2);
                    final boolean cancelled = this.isCancelled();
                    BytecodeManager.incBytecodes(1);
                    if (!cancelled) {
                        b5 = false;
                        BytecodeManager.incBytecodes(1);
                        break Label_0124;
                    }
                }
                b5 = true;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
            return b5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean isCancelled() {
        try {
            final Object result;
            final boolean b = (result = this.result) instanceof AltResult;
            BytecodeManager.incBytecodes(6);
            boolean b3 = false;
            Label_0050: {
                if (b) {
                    final boolean b2 = ((AltResult)result).ex instanceof CancellationException;
                    BytecodeManager.incBytecodes(5);
                    if (b2) {
                        b3 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0050;
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
    
    public boolean isCompletedExceptionally() {
        try {
            final Object result;
            final boolean b = (result = this.result) instanceof AltResult;
            BytecodeManager.incBytecodes(6);
            boolean b2 = false;
            Label_0044: {
                if (b) {
                    final Object o = result;
                    final AltResult nil = CompletableFuture.NIL;
                    BytecodeManager.incBytecodes(3);
                    if (o != nil) {
                        b2 = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0044;
                    }
                }
                b2 = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void obtrudeValue(final T t) {
        try {
            BytecodeManager.incBytecodes(3);
            Object nil;
            if (t == null) {
                nil = CompletableFuture.NIL;
                BytecodeManager.incBytecodes(2);
            }
            else {
                nil = t;
                BytecodeManager.incBytecodes(1);
            }
            this.result = nil;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.postComplete();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void obtrudeException(final Throwable t) {
        try {
            BytecodeManager.incBytecodes(2);
            if (t == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(5);
            this.result = new AltResult(t);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(2);
            this.postComplete();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getNumberOfDependents() {
        try {
            int n = 0;
            BytecodeManager.incBytecodes(2);
            Completion completion = this.stack;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Completion completion2 = completion;
                BytecodeManager.incBytecodes(2);
                if (completion2 == null) {
                    break;
                }
                ++n;
                BytecodeManager.incBytecodes(1);
                completion = completion.next;
                BytecodeManager.incBytecodes(4);
            }
            final int n2 = n;
            BytecodeManager.incBytecodes(2);
            return n2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public String toString() {
        try {
            final Object result = this.result;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final String string = super.toString();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append = sb.append(string);
            final Object o = result;
            BytecodeManager.incBytecodes(2);
            String string2 = null;
            Label_0188: {
                if (o == null) {
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final int numberOfDependents = this.getNumberOfDependents();
                    BytecodeManager.incBytecodes(3);
                    if (numberOfDependents == 0) {
                        string2 = "[Not completed]";
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder sb2 = new StringBuilder();
                        final String str = "[Not completed, ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = sb2.append(str);
                        final int i = numberOfDependents;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(i);
                        final String str2 = " dependents]";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(str2);
                        BytecodeManager.incBytecodes(1);
                        string2 = append4.toString();
                        BytecodeManager.incBytecodes(1);
                    }
                }
                else {
                    final boolean b = result instanceof AltResult;
                    BytecodeManager.incBytecodes(3);
                    if (b) {
                        final Throwable ex = ((AltResult)result).ex;
                        BytecodeManager.incBytecodes(4);
                        if (ex != null) {
                            string2 = "[Completed exceptionally]";
                            BytecodeManager.incBytecodes(2);
                            break Label_0188;
                        }
                    }
                    string2 = "[Completed normally]";
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            final StringBuilder append5 = append.append(string2);
            BytecodeManager.incBytecodes(1);
            final String string3 = append5.toString();
            BytecodeManager.incBytecodes(1);
            return string3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aconst_null    
        //     5: ldc             4
        //     7: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    10: invokespecial   instrumented/java/util/concurrent/CompletableFuture$AltResult.<init>:(Ljava/lang/Throwable;)V
        //    13: putstatic       instrumented/java/util/concurrent/CompletableFuture.NIL:Linstrumented/java/util/concurrent/CompletableFuture$AltResult;
        //    16: ldc             1
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: ldc             1
        //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    26: invokestatic    instrumented/java/util/concurrent/ForkJoinPool.getCommonPoolParallelism:()I
        //    29: iconst_1       
        //    30: ldc             2
        //    32: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    35: if_icmple       47
        //    38: iconst_1       
        //    39: ldc             2
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: goto            53
        //    47: iconst_0       
        //    48: ldc             1
        //    50: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    53: putstatic       instrumented/java/util/concurrent/CompletableFuture.useCommonPool:Z
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: getstatic       instrumented/java/util/concurrent/CompletableFuture.useCommonPool:Z
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: ifeq            88
        //    72: ldc             1
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: invokestatic    instrumented/java/util/concurrent/ForkJoinPool.commonPool:()Linstrumented/java/util/concurrent/ForkJoinPool;
        //    80: ldc             1
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: goto            100
        //    88: new             Linstrumented/java/util/concurrent/CompletableFuture$ThreadPerTaskExecutor;
        //    91: dup            
        //    92: ldc             3
        //    94: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    97: invokespecial   instrumented/java/util/concurrent/CompletableFuture$ThreadPerTaskExecutor.<init>:()V
        //   100: putstatic       instrumented/java/util/concurrent/CompletableFuture.asyncPool:Linstrumented/java/util/concurrent/Executor;
        //   103: ldc             1
        //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   108: ldc             1
        //   110: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   113: invokestatic    sun/misc/Unsafe.getUnsafe:()Lsun/misc/Unsafe;
        //   116: dup            
        //   117: astore_0       
        //   118: putstatic       instrumented/java/util/concurrent/CompletableFuture.UNSAFE:Lsun/misc/Unsafe;
        //   121: ldc             3
        //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   126: ldc             Linstrumented/java/util/concurrent/CompletableFuture;.class
        //   128: astore_1       
        //   129: ldc             2
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: aload_0        
        //   135: aload_1        
        //   136: ldc_w           "result"
        //   139: ldc             4
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   147: ldc             1
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   155: putstatic       instrumented/java/util/concurrent/CompletableFuture.RESULT:J
        //   158: ldc             1
        //   160: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   163: aload_0        
        //   164: aload_1        
        //   165: ldc_w           "stack"
        //   168: ldc             4
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   176: ldc             1
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   184: putstatic       instrumented/java/util/concurrent/CompletableFuture.STACK:J
        //   187: ldc             1
        //   189: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   192: aload_0        
        //   193: ldc             Linstrumented/java/util/concurrent/CompletableFuture$Completion;.class
        //   195: ldc_w           "next"
        //   198: ldc             3
        //   200: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   203: ldc             1
        //   205: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   208: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   211: ldc             1
        //   213: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   216: invokevirtual   sun/misc/Unsafe.objectFieldOffset:(Ljava/lang/reflect/Field;)J
        //   219: putstatic       instrumented/java/util/concurrent/CompletableFuture.NEXT:J
        //   222: ldc             1
        //   224: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   227: ldc             1
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: goto            261
        //   235: astore_0       
        //   236: ldc_w           501
        //   239: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   242: new             Ljava/lang/Error;
        //   245: dup            
        //   246: aload_0        
        //   247: ldc             4
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: invokespecial   java/lang/Error.<init>:(Ljava/lang/Throwable;)V
        //   255: ldc             1
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: athrow         
        //   261: ldc             1
        //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   266: return         
        //   267: athrow         
        //   268: athrow         
        //    StackMapTable: 00 08 2F 45 01 22 4B 07 01 81 F7 00 86 07 03 20 19 FF 00 05 00 00 00 01 07 00 89 FF 00 00 00 00 00 01 07 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  108    268    268    269    Ljava/lang/VirtualMachineError;
        //  108    227    235    261    Ljava/lang/Exception;
        //  0      267    267    268    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0261:
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
    
    static final class AltResult
    {
        final Throwable ex;
        
        AltResult(final Throwable ex) {
            try {
                BytecodeManager.incBytecodes(2);
                this.ex = ex;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class ThreadPerTaskExecutor implements Executor
    {
        ThreadPerTaskExecutor() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void execute(final Runnable target) {
            try {
                BytecodeManager.incBytecodes(4);
                final Thread thread = new Thread(target);
                BytecodeManager.incBytecodes(1);
                thread.start();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class Completion extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask
    {
        volatile Completion next;
        
        Completion() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        abstract CompletableFuture<?> tryFire(final int p0);
        
        abstract boolean isLive();
        
        @Override
        public final void run() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                this.tryFire(n);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final boolean exec() {
            try {
                final int n = 1;
                BytecodeManager.incBytecodes(3);
                this.tryFire(n);
                final boolean b = true;
                BytecodeManager.incBytecodes(3);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Void getRawResult() {
            try {
                final Void void1 = null;
                BytecodeManager.incBytecodes(2);
                return void1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void setRawResult(final Void void1) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class UniCompletion<T, V> extends Completion
    {
        Executor executor;
        CompletableFuture<V> dep;
        CompletableFuture<T> src;
        
        UniCompletion(final Executor executor, final CompletableFuture<V> dep, final CompletableFuture<T> src) {
            try {
                BytecodeManager.incBytecodes(2);
                this.executor = executor;
                this.dep = dep;
                this.src = src;
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        final boolean claim() {
            try {
                final Executor executor = this.executor;
                BytecodeManager.incBytecodes(3);
                final short n = 0;
                final short n2 = 1;
                BytecodeManager.incBytecodes(4);
                final boolean compareAndSetForkJoinTaskTag = this.compareAndSetForkJoinTaskTag(n, n2);
                BytecodeManager.incBytecodes(1);
                if (compareAndSetForkJoinTaskTag) {
                    final Executor executor2 = executor;
                    BytecodeManager.incBytecodes(2);
                    if (executor2 == null) {
                        final boolean b = true;
                        BytecodeManager.incBytecodes(2);
                        return b;
                    }
                    this.executor = null;
                    BytecodeManager.incBytecodes(3);
                    final Executor executor3 = executor;
                    BytecodeManager.incBytecodes(3);
                    executor3.execute(this);
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
        final boolean isLive() {
            try {
                final CompletableFuture<V> dep = this.dep;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (dep != null) {
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
    }
    
    static final class UniApply<T, V> extends UniCompletion<T, V>
    {
        Function<? super T, ? extends V> fn;
        
        UniApply(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final Function<? super T, ? extends V> fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<V> tryFire(final int n) {
            try {
                final CompletableFuture<V> dep;
                final CompletableFuture<V> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<V> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final Function<? super T, ? extends V> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniApply<T, V> uniApply;
                    if (n > 0) {
                        uniApply = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniApply = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniApply2 = completableFuture2.uniApply(src, fn, uniApply);
                    BytecodeManager.incBytecodes(1);
                    if (uniApply2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final CompletableFuture<V> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<V> postFire = completableFuture3.postFire(completableFuture4, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<V> completableFuture5 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniAccept<T> extends UniCompletion<T, Void>
    {
        Consumer<? super T> fn;
        
        UniAccept(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final Consumer<? super T> fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final Consumer<? super T> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniAccept<T> uniAccept;
                    if (n > 0) {
                        uniAccept = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniAccept = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniAccept2 = ((CompletableFuture)future).uniAccept((CompletableFuture<T>)src, fn, uniAccept);
                    BytecodeManager.incBytecodes(1);
                    if (uniAccept2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = (CompletableFuture<T>)src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<Void> postFire = ((CompletableFuture<Void>)future2).postFire(completableFuture2, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture3 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniRun<T> extends UniCompletion<T, Void>
    {
        Runnable fn;
        
        UniRun(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final Runnable fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final Runnable fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniRun uniRun;
                    if (n > 0) {
                        uniRun = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniRun = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniRun2 = ((CompletableFuture)future).uniRun(src, fn, uniRun);
                    BytecodeManager.incBytecodes(1);
                    if (uniRun2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<Void> postFire = ((CompletableFuture<Void>)future2).postFire(completableFuture2, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture3 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniWhenComplete<T> extends UniCompletion<T, T>
    {
        BiConsumer<? super T, ? super Throwable> fn;
        
        UniWhenComplete(final Executor executor, final CompletableFuture<T> completableFuture, final CompletableFuture<T> completableFuture2, final BiConsumer<? super T, ? super Throwable> fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<T> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final BiConsumer<? super T, ? super Throwable> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniWhenComplete uniWhenComplete;
                    if (n > 0) {
                        uniWhenComplete = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniWhenComplete = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniWhenComplete2 = ((CompletableFuture<V>)future).uniWhenComplete((CompletableFuture<V>)src, (BiConsumer<? super V, ? super Throwable>)fn, (UniWhenComplete<V>)uniWhenComplete);
                    BytecodeManager.incBytecodes(1);
                    if (uniWhenComplete2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<T> postFire = ((CompletableFuture<T>)future2).postFire(completableFuture2, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<T> completableFuture3 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniHandle<T, V> extends UniCompletion<T, V>
    {
        BiFunction<? super T, Throwable, ? extends V> fn;
        
        UniHandle(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final BiFunction<? super T, Throwable, ? extends V> fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<V> tryFire(final int n) {
            try {
                final CompletableFuture<V> dep;
                final CompletableFuture<V> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<V> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final BiFunction<? super T, Throwable, ? extends V> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniHandle<T, V> uniHandle;
                    if (n > 0) {
                        uniHandle = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniHandle = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniHandle2 = completableFuture2.uniHandle(src, fn, uniHandle);
                    BytecodeManager.incBytecodes(1);
                    if (uniHandle2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final CompletableFuture<V> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<V> postFire = completableFuture3.postFire(completableFuture4, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<V> completableFuture5 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniExceptionally<T> extends UniCompletion<T, T>
    {
        Function<? super Throwable, ? extends T> fn;
        
        UniExceptionally(final CompletableFuture<T> completableFuture, final CompletableFuture<T> completableFuture2, final Function<? super Throwable, ? extends T> fn) {
            try {
                final Executor executor = null;
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<T> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final Function<? super Throwable, ? extends T> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    final boolean uniExceptionally = ((CompletableFuture<V>)future).uniExceptionally((CompletableFuture<V>)src, (Function<? super Throwable, ? extends V>)fn, (UniExceptionally<V>)this);
                    BytecodeManager.incBytecodes(1);
                    if (uniExceptionally) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<T> postFire = ((CompletableFuture<T>)future2).postFire(completableFuture2, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<T> completableFuture3 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniRelay<T> extends UniCompletion<T, T>
    {
        UniRelay(final CompletableFuture<T> completableFuture, final CompletableFuture<T> completableFuture2) {
            try {
                final Executor executor = null;
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<T> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    BytecodeManager.incBytecodes(6);
                    final boolean uniRelay = ((CompletableFuture<V>)future).uniRelay((CompletableFuture<V>)src);
                    BytecodeManager.incBytecodes(1);
                    if (uniRelay) {
                        this.src = null;
                        this.dep = null;
                        BytecodeManager.incBytecodes(6);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<T> postFire = ((CompletableFuture<T>)future2).postFire(completableFuture2, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<T> completableFuture3 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class UniCompose<T, V> extends UniCompletion<T, V>
    {
        Function<? super T, ? extends CompletionStage<V>> fn;
        
        UniCompose(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final Function<? super T, ? extends CompletionStage<V>> fn) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<V> tryFire(final int n) {
            try {
                final CompletableFuture<V> dep;
                final CompletableFuture<V> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<V> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final Function<? super T, ? extends CompletionStage<V>> fn = this.fn;
                    BytecodeManager.incBytecodes(9);
                    UniCompose<T, V> uniCompose;
                    if (n > 0) {
                        uniCompose = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        uniCompose = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean uniCompose2 = completableFuture2.uniCompose(src, fn, uniCompose);
                    BytecodeManager.incBytecodes(1);
                    if (uniCompose2) {
                        this.dep = null;
                        this.src = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(9);
                        final CompletableFuture<V> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        BytecodeManager.incBytecodes(4);
                        final CompletableFuture<V> postFire = completableFuture3.postFire(completableFuture4, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<V> completableFuture5 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract static class BiCompletion<T, U, V> extends UniCompletion<T, V>
    {
        CompletableFuture<U> snd;
        
        BiCompletion(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> snd) {
            try {
                BytecodeManager.incBytecodes(5);
                super(executor, completableFuture, completableFuture2);
                this.snd = snd;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class CoCompletion extends Completion
    {
        BiCompletion<?, ?, ?> base;
        
        CoCompletion(final BiCompletion<?, ?, ?> base) {
            try {
                BytecodeManager.incBytecodes(2);
                this.base = base;
                BytecodeManager.incBytecodes(4);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<?> tryFire(final int n) {
            try {
                final BiCompletion<?, ?, ?> base = this.base;
                BytecodeManager.incBytecodes(5);
                if (base != null) {
                    final BiCompletion<?, ?, ?> biCompletion = base;
                    BytecodeManager.incBytecodes(3);
                    final CompletableFuture<?> tryFire = biCompletion.tryFire(n);
                    BytecodeManager.incBytecodes(3);
                    if (tryFire != null) {
                        this.base = null;
                        BytecodeManager.incBytecodes(3);
                        final CompletableFuture<?> completableFuture = tryFire;
                        BytecodeManager.incBytecodes(2);
                        return completableFuture;
                    }
                }
                final CompletableFuture<?> completableFuture2 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final boolean isLive() {
            try {
                final BiCompletion<?, ?, ?> base = this.base;
                BytecodeManager.incBytecodes(5);
                boolean b = false;
                Label_0041: {
                    if (base != null) {
                        final CompletableFuture<V> dep = base.dep;
                        BytecodeManager.incBytecodes(3);
                        if (dep != null) {
                            b = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0041;
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
    }
    
    static final class BiApply<T, U, V> extends BiCompletion<T, U, V>
    {
        BiFunction<? super T, ? super U, ? extends V> fn;
        
        BiApply(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final BiFunction<? super T, ? super U, ? extends V> fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<V> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final BiFunction<? super T, ? super U, ? extends V> fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    BiApply<T, U, V> biApply;
                    if (n > 0) {
                        biApply = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        biApply = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean biApply2 = ((CompletableFuture<V>)future).biApply((CompletableFuture<T>)src, snd, (BiFunction<? super T, ? super U, ? extends V>)fn, (BiApply<T, U, V>)biApply);
                    BytecodeManager.incBytecodes(1);
                    if (biApply2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = (CompletableFuture<T>)src;
                        final CompletableFuture<U> completableFuture3 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<V> postFire = ((CompletableFuture<V>)future2).postFire(completableFuture2, completableFuture3, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<V> completableFuture4 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BiAccept<T, U> extends BiCompletion<T, U, Void>
    {
        BiConsumer<? super T, ? super U> fn;
        
        BiAccept(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final BiConsumer<? super T, ? super U> fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final BiConsumer<? super T, ? super U> fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    BiAccept<T, U> biAccept;
                    if (n > 0) {
                        biAccept = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        biAccept = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean biAccept2 = completableFuture2.biAccept(src, (CompletableFuture<U>)snd, fn, biAccept);
                    BytecodeManager.incBytecodes(1);
                    if (biAccept2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = (CompletableFuture<U>)snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Void>)postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BiRun<T, U> extends BiCompletion<T, U, Void>
    {
        Runnable fn;
        
        BiRun(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final Runnable fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final Runnable fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    BiRun biRun;
                    if (n > 0) {
                        biRun = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        biRun = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean biRun2 = completableFuture2.biRun(src, snd, fn, biRun);
                    BytecodeManager.incBytecodes(1);
                    if (biRun2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Void>)postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class BiRelay<T, U> extends BiCompletion<T, U, Void>
    {
        BiRelay(final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3) {
            try {
                final Executor executor = null;
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    BytecodeManager.incBytecodes(10);
                    final boolean biRelay = completableFuture2.biRelay(src, snd);
                    BytecodeManager.incBytecodes(1);
                    if (biRelay) {
                        this.src = null;
                        this.snd = null;
                        this.dep = null;
                        BytecodeManager.incBytecodes(9);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Void>)postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class OrApply<T, U extends T, V> extends BiCompletion<T, U, V>
    {
        Function<? super T, ? extends V> fn;
        
        OrApply(final Executor executor, final CompletableFuture<V> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final Function<? super T, ? extends V> fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<V> tryFire(final int n) {
            try {
                final Future<T> dep;
                final CompletableFuture<V> completableFuture = (CompletableFuture<V>)(dep = (Future<T>)this.dep);
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final Future<T> future = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final Function<? super T, ? extends V> fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    OrApply<T, U, V> orApply;
                    if (n > 0) {
                        orApply = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        orApply = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean orApply2 = ((CompletableFuture<V>)future).orApply((CompletableFuture<T>)src, snd, (Function<? super T, ? extends V>)fn, (OrApply<T, U, V>)orApply);
                    BytecodeManager.incBytecodes(1);
                    if (orApply2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final Future<T> future2 = dep;
                        final CompletableFuture<T> completableFuture2 = (CompletableFuture<T>)src;
                        final CompletableFuture<U> completableFuture3 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<V> postFire = ((CompletableFuture<V>)future2).postFire(completableFuture2, completableFuture3, n);
                        BytecodeManager.incBytecodes(1);
                        return postFire;
                    }
                }
                final CompletableFuture<V> completableFuture4 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture4;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class OrAccept<T, U extends T> extends BiCompletion<T, U, Void>
    {
        Consumer<? super T> fn;
        
        OrAccept(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final Consumer<? super T> fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final Consumer<? super T> fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    OrAccept<T, U> orAccept;
                    if (n > 0) {
                        orAccept = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        orAccept = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean orAccept2 = completableFuture2.orAccept(src, (CompletableFuture<U>)snd, fn, orAccept);
                    BytecodeManager.incBytecodes(1);
                    if (orAccept2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = (CompletableFuture<U>)snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Void>)postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class OrRun<T, U> extends BiCompletion<T, U, Void>
    {
        Runnable fn;
        
        OrRun(final Executor executor, final CompletableFuture<Void> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3, final Runnable fn) {
            try {
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                this.fn = fn;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Void> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    final Runnable fn = this.fn;
                    BytecodeManager.incBytecodes(13);
                    OrRun orRun;
                    if (n > 0) {
                        orRun = null;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        orRun = this;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    final boolean orRun2 = completableFuture2.orRun(src, snd, fn, orRun);
                    BytecodeManager.incBytecodes(1);
                    if (orRun2) {
                        this.dep = null;
                        this.src = null;
                        this.snd = null;
                        this.fn = null;
                        BytecodeManager.incBytecodes(12);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Void>)postFire;
                    }
                }
                final CompletableFuture<Void> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class OrRelay<T, U> extends BiCompletion<T, U, Object>
    {
        OrRelay(final CompletableFuture<Object> completableFuture, final CompletableFuture<T> completableFuture2, final CompletableFuture<U> completableFuture3) {
            try {
                final Executor executor = null;
                BytecodeManager.incBytecodes(6);
                super(executor, completableFuture, completableFuture2, completableFuture3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<Object> tryFire(final int n) {
            try {
                final CompletableFuture<U> dep;
                final CompletableFuture<U> completableFuture = dep = this.dep;
                BytecodeManager.incBytecodes(5);
                if (completableFuture != null) {
                    final CompletableFuture<U> completableFuture2 = dep;
                    final CompletableFuture<T> src = this.src;
                    final CompletableFuture<U> snd = this.snd;
                    BytecodeManager.incBytecodes(10);
                    final boolean orRelay = completableFuture2.orRelay(src, snd);
                    BytecodeManager.incBytecodes(1);
                    if (orRelay) {
                        this.src = null;
                        this.snd = null;
                        this.dep = null;
                        BytecodeManager.incBytecodes(9);
                        final CompletableFuture<U> completableFuture3 = dep;
                        final CompletableFuture<T> completableFuture4 = src;
                        final CompletableFuture<U> completableFuture5 = snd;
                        BytecodeManager.incBytecodes(5);
                        final CompletableFuture<U> postFire = completableFuture3.postFire(completableFuture4, completableFuture5, n);
                        BytecodeManager.incBytecodes(1);
                        return (CompletableFuture<Object>)postFire;
                    }
                }
                final CompletableFuture<Object> completableFuture6 = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture6;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    static final class AsyncSupply<T> extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask
    {
        CompletableFuture<T> dep;
        Supplier<T> fn;
        
        AsyncSupply(final CompletableFuture<T> dep, final Supplier<T> fn) {
            try {
                BytecodeManager.incBytecodes(2);
                this.dep = dep;
                this.fn = fn;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Void getRawResult() {
            try {
                final Void void1 = null;
                BytecodeManager.incBytecodes(2);
                return void1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void setRawResult(final Void void1) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final boolean exec() {
            try {
                BytecodeManager.incBytecodes(2);
                this.run();
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/CompletableFuture$AsyncSupply.dep:Linstrumented/java/util/concurrent/CompletableFuture;
            //     4: dup            
            //     5: astore_1       
            //     6: ldc             5
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: ifnull          120
            //    14: aload_0        
            //    15: getfield        instrumented/java/util/concurrent/CompletableFuture$AsyncSupply.fn:Linstrumented/java/util/function/Supplier;
            //    18: dup            
            //    19: astore_2       
            //    20: ldc             5
            //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    25: ifnull          120
            //    28: aload_0        
            //    29: aconst_null    
            //    30: putfield        instrumented/java/util/concurrent/CompletableFuture$AsyncSupply.dep:Linstrumented/java/util/concurrent/CompletableFuture;
            //    33: aload_0        
            //    34: aconst_null    
            //    35: putfield        instrumented/java/util/concurrent/CompletableFuture$AsyncSupply.fn:Linstrumented/java/util/function/Supplier;
            //    38: ldc             6
            //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    43: aload_1        
            //    44: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
            //    47: ldc             3
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: ifnonnull       111
            //    55: aload_1        
            //    56: aload_2        
            //    57: ldc             3
            //    59: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    62: invokeinterface instrumented/java/util/function/Supplier.get:()Ljava/lang/Object;
            //    67: ldc             1
            //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    72: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeValue:(Ljava/lang/Object;)Z
            //    75: pop            
            //    76: ldc             1
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: ldc             1
            //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    86: goto            111
            //    89: astore_3       
            //    90: ldc             501
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: aload_1        
            //    96: aload_3        
            //    97: ldc             3
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
            //   105: pop            
            //   106: ldc             1
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: aload_1        
            //   112: ldc             2
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.postComplete:()V
            //   120: ldc             1
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: return         
            //   126: athrow         
            //   127: athrow         
            //    StackMapTable: 00 05 FF 00 59 00 03 07 00 02 07 00 0C 07 00 3B 00 01 07 00 28 15 FA 00 08 FF 00 05 00 00 00 01 07 00 28 FF 00 00 00 00 00 01 07 00 33
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  55     127    127    128    Ljava/lang/VirtualMachineError;
            //  55     81     89     111    Ljava/lang/Throwable;
            //  0      126    126    127    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0111:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    }
    
    static final class AsyncRun extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask
    {
        CompletableFuture<Void> dep;
        Runnable fn;
        
        AsyncRun(final CompletableFuture<Void> dep, final Runnable fn) {
            try {
                BytecodeManager.incBytecodes(2);
                this.dep = dep;
                this.fn = fn;
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Void getRawResult() {
            try {
                final Void void1 = null;
                BytecodeManager.incBytecodes(2);
                return void1;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void setRawResult(final Void void1) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final boolean exec() {
            try {
                BytecodeManager.incBytecodes(2);
                this.run();
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        instrumented/java/util/concurrent/CompletableFuture$AsyncRun.dep:Linstrumented/java/util/concurrent/CompletableFuture;
            //     4: dup            
            //     5: astore_1       
            //     6: ldc             5
            //     8: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    11: ifnull          120
            //    14: aload_0        
            //    15: getfield        instrumented/java/util/concurrent/CompletableFuture$AsyncRun.fn:Ljava/lang/Runnable;
            //    18: dup            
            //    19: astore_2       
            //    20: ldc             5
            //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    25: ifnull          120
            //    28: aload_0        
            //    29: aconst_null    
            //    30: putfield        instrumented/java/util/concurrent/CompletableFuture$AsyncRun.dep:Linstrumented/java/util/concurrent/CompletableFuture;
            //    33: aload_0        
            //    34: aconst_null    
            //    35: putfield        instrumented/java/util/concurrent/CompletableFuture$AsyncRun.fn:Ljava/lang/Runnable;
            //    38: ldc             6
            //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    43: aload_1        
            //    44: getfield        instrumented/java/util/concurrent/CompletableFuture.result:Ljava/lang/Object;
            //    47: ldc             3
            //    49: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    52: ifnonnull       111
            //    55: aload_2        
            //    56: ldc             2
            //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    61: invokeinterface java/lang/Runnable.run:()V
            //    66: aload_1        
            //    67: ldc             2
            //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    72: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeNull:()Z
            //    75: pop            
            //    76: ldc             1
            //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    81: ldc             1
            //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    86: goto            111
            //    89: astore_3       
            //    90: ldc             501
            //    92: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    95: aload_1        
            //    96: aload_3        
            //    97: ldc             3
            //    99: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   102: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.completeThrowable:(Ljava/lang/Throwable;)Z
            //   105: pop            
            //   106: ldc             1
            //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   111: aload_1        
            //   112: ldc             2
            //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   117: invokevirtual   instrumented/java/util/concurrent/CompletableFuture.postComplete:()V
            //   120: ldc             1
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: return         
            //   126: athrow         
            //   127: athrow         
            //    StackMapTable: 00 05 FF 00 59 00 03 07 00 02 07 00 0C 07 00 07 00 01 07 00 27 15 FA 00 08 FF 00 05 00 00 00 01 07 00 27 FF 00 00 00 00 00 01 07 00 32
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  55     127    127    128    Ljava/lang/VirtualMachineError;
            //  55     81     89     111    Ljava/lang/Throwable;
            //  0      126    126    127    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0111:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
    }
    
    static final class Signaller extends Completion implements ForkJoinPool.ManagedBlocker
    {
        long nanos;
        final long deadline;
        volatile int interruptControl;
        volatile Thread thread;
        
        Signaller(final boolean b, final long nanos, final long deadline) {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                this.thread = Thread.currentThread();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                int interruptControl;
                if (b) {
                    interruptControl = 1;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    interruptControl = 0;
                    BytecodeManager.incBytecodes(1);
                }
                this.interruptControl = interruptControl;
                BytecodeManager.incBytecodes(1);
                this.nanos = nanos;
                BytecodeManager.incBytecodes(3);
                this.deadline = deadline;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final CompletableFuture<?> tryFire(final int n) {
            try {
                final Thread thread = this.thread;
                BytecodeManager.incBytecodes(5);
                if (thread != null) {
                    this.thread = null;
                    BytecodeManager.incBytecodes(3);
                    final Thread thread2 = thread;
                    BytecodeManager.incBytecodes(2);
                    LockSupport.unpark(thread2);
                }
                final CompletableFuture<?> completableFuture = null;
                BytecodeManager.incBytecodes(2);
                return completableFuture;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean isReleasable() {
            try {
                final Thread thread = this.thread;
                BytecodeManager.incBytecodes(3);
                if (thread == null) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                BytecodeManager.incBytecodes(1);
                final boolean interrupted = Thread.interrupted();
                BytecodeManager.incBytecodes(1);
                if (interrupted) {
                    final int interruptControl = this.interruptControl;
                    BytecodeManager.incBytecodes(3);
                    this.interruptControl = -1;
                    BytecodeManager.incBytecodes(3);
                    final int n = interruptControl;
                    BytecodeManager.incBytecodes(2);
                    if (n > 0) {
                        final boolean b2 = true;
                        BytecodeManager.incBytecodes(2);
                        return b2;
                    }
                }
                final long n2 = lcmp(this.deadline, 0L);
                BytecodeManager.incBytecodes(5);
                Label_0149: {
                    if (n2 != 0) {
                        final long n3 = lcmp(this.nanos, 0L);
                        BytecodeManager.incBytecodes(5);
                        if (n3 > 0) {
                            final long deadline = this.deadline;
                            BytecodeManager.incBytecodes(3);
                            BytecodeManager.incBytecodes(1);
                            final long nanos = deadline - System.nanoTime();
                            this.nanos = nanos;
                            final long n4 = lcmp(nanos, 0L);
                            BytecodeManager.incBytecodes(6);
                            if (n4 > 0) {
                                break Label_0149;
                            }
                        }
                        this.thread = null;
                        BytecodeManager.incBytecodes(3);
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
        public boolean block() {
            try {
                BytecodeManager.incBytecodes(2);
                final boolean releasable = this.isReleasable();
                BytecodeManager.incBytecodes(1);
                if (releasable) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final long n = lcmp(this.deadline, 0L);
                BytecodeManager.incBytecodes(5);
                if (n == 0) {
                    BytecodeManager.incBytecodes(2);
                    LockSupport.park(this);
                    BytecodeManager.incBytecodes(1);
                }
                else {
                    final long n2 = lcmp(this.nanos, 0L);
                    BytecodeManager.incBytecodes(5);
                    if (n2 > 0) {
                        final long nanos = this.nanos;
                        BytecodeManager.incBytecodes(4);
                        LockSupport.parkNanos(this, nanos);
                    }
                }
                BytecodeManager.incBytecodes(2);
                final boolean releasable2 = this.isReleasable();
                BytecodeManager.incBytecodes(1);
                return releasable2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        final boolean isLive() {
            try {
                final Thread thread = this.thread;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (thread != null) {
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
    }
    
    public interface AsynchronousCompletionTask
    {
    }
}
