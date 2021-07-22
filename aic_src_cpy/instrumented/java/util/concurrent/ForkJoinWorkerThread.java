// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.concurrent;

import java.security.PermissionCollection;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.lang.reflect.Field;
import java.security.AccessControlContext;
import aic2021.engine.BytecodeManager;
import sun.misc.Unsafe;

public class ForkJoinWorkerThread extends Thread
{
    final ForkJoinPool pool;
    final ForkJoinPool.WorkQueue workQueue;
    private static final Unsafe U;
    private static final long THREADLOCALS;
    private static final long INHERITABLETHREADLOCALS;
    private static final long INHERITEDACCESSCONTROLCONTEXT;
    
    protected ForkJoinWorkerThread(final ForkJoinPool pool) {
        try {
            final String name = "aForkJoinWorkerThread";
            BytecodeManager.incBytecodes(3);
            super(name);
            this.pool = pool;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.workQueue = pool.registerWorker(this);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    ForkJoinWorkerThread(final ForkJoinPool pool, final ThreadGroup group, final AccessControlContext x) {
        try {
            final Runnable target = null;
            final String name = "aForkJoinWorkerThread";
            BytecodeManager.incBytecodes(5);
            super(group, target, name);
            final Unsafe u = ForkJoinWorkerThread.U;
            final long inheritedaccesscontrolcontext = ForkJoinWorkerThread.INHERITEDACCESSCONTROLCONTEXT;
            BytecodeManager.incBytecodes(5);
            u.putOrderedObject(this, inheritedaccesscontrolcontext, x);
            BytecodeManager.incBytecodes(2);
            this.eraseThreadLocals();
            this.pool = pool;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(4);
            this.workQueue = pool.registerWorker(this);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ForkJoinPool getPool() {
        try {
            final ForkJoinPool pool = this.pool;
            BytecodeManager.incBytecodes(3);
            return pool;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public int getPoolIndex() {
        try {
            final ForkJoinPool.WorkQueue workQueue = this.workQueue;
            BytecodeManager.incBytecodes(3);
            final int poolIndex = workQueue.getPoolIndex();
            BytecodeManager.incBytecodes(1);
            return poolIndex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void onStart() {
        try {
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void onTermination(final Throwable t) {
        try {
            BytecodeManager.incBytecodes(1);
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
        //     1: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.workQueue:Linstrumented/java/util/concurrent/ForkJoinPool$WorkQueue;
        //     4: getfield        instrumented/java/util/concurrent/ForkJoinPool$WorkQueue.array:[Linstrumented/java/util/concurrent/ForkJoinTask;
        //     7: ldc             4
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: ifnonnull       401
        //    15: aconst_null    
        //    16: astore_1       
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aload_0        
        //    23: ldc             2
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokevirtual   instrumented/java/util/concurrent/ForkJoinWorkerThread.onStart:()V
        //    31: aload_0        
        //    32: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //    35: aload_0        
        //    36: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.workQueue:Linstrumented/java/util/concurrent/ForkJoinPool$WorkQueue;
        //    39: ldc             5
        //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    44: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.runWorker:(Linstrumented/java/util/concurrent/ForkJoinPool$WorkQueue;)V
        //    47: aload_0        
        //    48: aload_1        
        //    49: ldc             3
        //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    54: invokevirtual   instrumented/java/util/concurrent/ForkJoinWorkerThread.onTermination:(Ljava/lang/Throwable;)V
        //    57: aload_0        
        //    58: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //    61: aload_0        
        //    62: aload_1        
        //    63: ldc             5
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //    71: ldc             1
        //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    76: goto            145
        //    79: astore_2       
        //    80: ldc             501
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: aload_1        
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: ifnonnull       101
        //    94: aload_2        
        //    95: astore_1       
        //    96: ldc             2
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: aload_0        
        //   102: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   105: aload_0        
        //   106: aload_1        
        //   107: ldc             5
        //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   112: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   115: ldc             1
        //   117: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   120: goto            145
        //   123: astore_3       
        //   124: aload_0        
        //   125: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   128: aload_0        
        //   129: aload_1        
        //   130: ldc             506
        //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   135: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   138: aload_3        
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: athrow         
        //   145: ldc             1
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: goto            401
        //   153: astore_2       
        //   154: ldc             501
        //   156: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   159: aload_2        
        //   160: astore_1       
        //   161: ldc             2
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: aload_0        
        //   167: aload_1        
        //   168: ldc             3
        //   170: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   173: invokevirtual   instrumented/java/util/concurrent/ForkJoinWorkerThread.onTermination:(Ljava/lang/Throwable;)V
        //   176: aload_0        
        //   177: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   180: aload_0        
        //   181: aload_1        
        //   182: ldc             5
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   190: ldc             1
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: goto            271
        //   198: astore_2       
        //   199: ldc             501
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: aload_1        
        //   205: ldc             2
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: ifnonnull       220
        //   213: aload_2        
        //   214: astore_1       
        //   215: ldc             2
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: aload_0        
        //   221: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   224: aload_0        
        //   225: aload_1        
        //   226: ldc             5
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   234: ldc             1
        //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   239: goto            271
        //   242: astore          4
        //   244: ldc             501
        //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   249: aload_0        
        //   250: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   253: aload_0        
        //   254: aload_1        
        //   255: ldc             5
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   263: aload           4
        //   265: ldc             2
        //   267: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   270: athrow         
        //   271: ldc             1
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: goto            401
        //   279: astore          5
        //   281: ldc             501
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: aload_0        
        //   287: aload_1        
        //   288: ldc             3
        //   290: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   293: invokevirtual   instrumented/java/util/concurrent/ForkJoinWorkerThread.onTermination:(Ljava/lang/Throwable;)V
        //   296: aload_0        
        //   297: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   300: aload_0        
        //   301: aload_1        
        //   302: ldc             5
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   310: ldc             1
        //   312: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   315: goto            393
        //   318: astore          6
        //   320: ldc             501
        //   322: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   325: aload_1        
        //   326: ldc             2
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: ifnonnull       342
        //   334: aload           6
        //   336: astore_1       
        //   337: ldc             2
        //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   342: aload_0        
        //   343: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   346: aload_0        
        //   347: aload_1        
        //   348: ldc             5
        //   350: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   353: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: goto            393
        //   364: astore          7
        //   366: ldc             501
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: aload_0        
        //   372: getfield        instrumented/java/util/concurrent/ForkJoinWorkerThread.pool:Linstrumented/java/util/concurrent/ForkJoinPool;
        //   375: aload_0        
        //   376: aload_1        
        //   377: ldc             5
        //   379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   382: invokevirtual   instrumented/java/util/concurrent/ForkJoinPool.deregisterWorker:(Linstrumented/java/util/concurrent/ForkJoinWorkerThread;Ljava/lang/Throwable;)V
        //   385: aload           7
        //   387: ldc             2
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: athrow         
        //   393: aload           5
        //   395: ldc             2
        //   397: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   400: athrow         
        //   401: ldc             1
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: return         
        //   407: athrow         
        //   408: athrow         
        //    StackMapTable: 00 11 FF 00 4F 00 02 07 00 02 07 00 31 00 01 07 00 31 15 55 07 00 31 15 47 07 00 31 6C 07 00 31 15 55 07 00 31 1C 47 07 00 31 FF 00 26 00 06 07 00 02 07 00 31 00 00 00 07 00 31 00 01 07 00 31 17 55 07 00 31 1C FF 00 07 00 01 07 00 02 00 00 FF 00 05 00 00 00 01 07 00 31 FF 00 00 00 00 00 01 07 00 51
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  22     408    408    409    Ljava/lang/VirtualMachineError;
        //  47     57     79     123    Ljava/lang/Throwable;
        //  47     57     123    145    Any
        //  79     101    123    145    Any
        //  22     47     153    279    Ljava/lang/Throwable;
        //  166    176    198    242    Ljava/lang/Throwable;
        //  166    176    242    271    Any
        //  198    220    242    271    Any
        //  242    249    242    271    Any
        //  22     47     279    401    Any
        //  153    166    279    401    Any
        //  286    296    318    364    Ljava/lang/Throwable;
        //  286    296    364    393    Any
        //  318    342    364    393    Any
        //  364    371    364    393    Any
        //  279    286    279    401    Any
        //  0      407    407    408    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
    
    final void eraseThreadLocals() {
        try {
            final Unsafe u = ForkJoinWorkerThread.U;
            final long threadlocals = ForkJoinWorkerThread.THREADLOCALS;
            final Object x = null;
            BytecodeManager.incBytecodes(5);
            u.putObject(this, threadlocals, x);
            final Unsafe u2 = ForkJoinWorkerThread.U;
            final long inheritablethreadlocals = ForkJoinWorkerThread.INHERITABLETHREADLOCALS;
            final Object x2 = null;
            BytecodeManager.incBytecodes(5);
            u2.putObject(this, inheritablethreadlocals, x2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void afterTopLevelExec() {
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
                    final Class<Thread> clazz = Thread.class;
                    BytecodeManager.incBytecodes(2);
                    final Unsafe u = ForkJoinWorkerThread.U;
                    final Class<Thread> clazz2 = clazz;
                    final String name = "threadLocals";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField = clazz2.getDeclaredField(name);
                    BytecodeManager.incBytecodes(1);
                    THREADLOCALS = u.objectFieldOffset(declaredField);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe u2 = ForkJoinWorkerThread.U;
                    final Class<Thread> clazz3 = clazz;
                    final String name2 = "inheritableThreadLocals";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField2 = clazz3.getDeclaredField(name2);
                    BytecodeManager.incBytecodes(1);
                    INHERITABLETHREADLOCALS = u2.objectFieldOffset(declaredField2);
                    BytecodeManager.incBytecodes(1);
                    final Unsafe u3 = ForkJoinWorkerThread.U;
                    final Class<Thread> clazz4 = clazz;
                    final String name3 = "inheritedAccessControlContext";
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(1);
                    final Field declaredField3 = clazz4.getDeclaredField(name3);
                    BytecodeManager.incBytecodes(1);
                    INHERITEDACCESSCONTROLCONTEXT = u3.objectFieldOffset(declaredField3);
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
    
    static final class InnocuousForkJoinWorkerThread extends ForkJoinWorkerThread
    {
        private static final ThreadGroup innocuousThreadGroup;
        private static final AccessControlContext INNOCUOUS_ACC;
        
        InnocuousForkJoinWorkerThread(final ForkJoinPool forkJoinPool) {
            try {
                final ThreadGroup innocuousThreadGroup = InnocuousForkJoinWorkerThread.innocuousThreadGroup;
                final AccessControlContext innocuous_ACC = InnocuousForkJoinWorkerThread.INNOCUOUS_ACC;
                BytecodeManager.incBytecodes(5);
                super(forkJoinPool, innocuousThreadGroup, innocuous_ACC);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        void afterTopLevelExec() {
            try {
                BytecodeManager.incBytecodes(2);
                this.eraseThreadLocals();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public ClassLoader getContextClassLoader() {
            try {
                BytecodeManager.incBytecodes(1);
                final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                BytecodeManager.incBytecodes(1);
                return systemClassLoader;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void setUncaughtExceptionHandler(final UncaughtExceptionHandler uncaughtExceptionHandler) {
            try {
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void setContextClassLoader(final ClassLoader classLoader) {
            try {
                final String s = "setContextClassLoader";
                BytecodeManager.incBytecodes(4);
                final SecurityException ex = new SecurityException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static ThreadGroup createThreadGroup() {
            try {
                try {
                    try {
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe = Unsafe.getUnsafe();
                        BytecodeManager.incBytecodes(1);
                        final Class<Thread> clazz = Thread.class;
                        BytecodeManager.incBytecodes(2);
                        final Class<ThreadGroup> clazz2 = ThreadGroup.class;
                        BytecodeManager.incBytecodes(2);
                        final Unsafe unsafe2 = unsafe;
                        final Class<Thread> clazz3 = clazz;
                        final String name = "group";
                        BytecodeManager.incBytecodes(4);
                        final Field declaredField = clazz3.getDeclaredField(name);
                        BytecodeManager.incBytecodes(1);
                        final long objectFieldOffset = unsafe2.objectFieldOffset(declaredField);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe3 = unsafe;
                        final Class<ThreadGroup> clazz4 = clazz2;
                        final String name2 = "parent";
                        BytecodeManager.incBytecodes(4);
                        final Field declaredField2 = clazz4.getDeclaredField(name2);
                        BytecodeManager.incBytecodes(1);
                        final long objectFieldOffset2 = unsafe3.objectFieldOffset(declaredField2);
                        BytecodeManager.incBytecodes(1);
                        final Unsafe unsafe4 = unsafe;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Thread currentThread = Thread.currentThread();
                        final long offset = objectFieldOffset;
                        BytecodeManager.incBytecodes(2);
                        ThreadGroup threadGroup = (ThreadGroup)unsafe4.getObject(currentThread, offset);
                        BytecodeManager.incBytecodes(2);
                        while (true) {
                            final ThreadGroup threadGroup2 = threadGroup;
                            BytecodeManager.incBytecodes(2);
                            if (threadGroup2 == null) {
                                BytecodeManager.incBytecodes(1);
                                break;
                            }
                            final Unsafe unsafe5 = unsafe;
                            final ThreadGroup o = threadGroup;
                            final long offset2 = objectFieldOffset2;
                            BytecodeManager.incBytecodes(4);
                            final ThreadGroup threadGroup3 = (ThreadGroup)unsafe5.getObject(o, offset2);
                            BytecodeManager.incBytecodes(2);
                            final ThreadGroup threadGroup4 = threadGroup3;
                            BytecodeManager.incBytecodes(2);
                            if (threadGroup4 == null) {
                                final ThreadGroup parent = threadGroup;
                                final String name3 = "InnocuousForkJoinWorkerThreadGroup";
                                BytecodeManager.incBytecodes(5);
                                final ThreadGroup threadGroup5 = new ThreadGroup(parent, name3);
                                BytecodeManager.incBytecodes(1);
                                return threadGroup5;
                            }
                            threadGroup = threadGroup3;
                            BytecodeManager.incBytecodes(2);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    catch (Exception ex) {
                        BytecodeManager.incBytecodes(501);
                        final Exception cause = ex;
                        BytecodeManager.incBytecodes(4);
                        final Error error = new Error(cause);
                        BytecodeManager.incBytecodes(1);
                        throw error;
                    }
                    final String message = "Cannot create ThreadGroup";
                    BytecodeManager.incBytecodes(4);
                    final Error error2 = new Error(message);
                    BytecodeManager.incBytecodes(1);
                    throw error2;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(1);
                innocuousThreadGroup = createThreadGroup();
                BytecodeManager.incBytecodes(1);
                final ProtectionDomain[] context = { null };
                final int n = 0;
                final CodeSource codesource = null;
                final PermissionCollection permissions = null;
                BytecodeManager.incBytecodes(10);
                context[n] = new ProtectionDomain(codesource, permissions);
                BytecodeManager.incBytecodes(2);
                INNOCUOUS_ACC = new AccessControlContext(context);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
