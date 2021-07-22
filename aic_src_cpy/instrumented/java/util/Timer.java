// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;
import instrumented.java.util.concurrent.atomic.AtomicInteger;

public class Timer
{
    private final TaskQueue queue;
    private final TimerThread thread;
    private final Object threadReaper;
    private static final AtomicInteger nextSerialNumber;
    
    private static int serialNumber() {
        try {
            final AtomicInteger nextSerialNumber = Timer.nextSerialNumber;
            BytecodeManager.incBytecodes(2);
            final int andIncrement = nextSerialNumber.getAndIncrement();
            BytecodeManager.incBytecodes(1);
            return andIncrement;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Timer() {
        try {
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String str = "Timer-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(1);
            final int serialNumber = serialNumber();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(serialNumber);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(1);
            this(string);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Timer(final boolean b) {
        try {
            BytecodeManager.incBytecodes(4);
            final StringBuilder sb = new StringBuilder();
            final String str = "Timer-";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(1);
            final int serialNumber = serialNumber();
            BytecodeManager.incBytecodes(1);
            final StringBuilder append2 = append.append(serialNumber);
            BytecodeManager.incBytecodes(1);
            final String string = append2.toString();
            BytecodeManager.incBytecodes(2);
            this(string, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Timer(final String name) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.queue = new TaskQueue();
            BytecodeManager.incBytecodes(1);
            final TaskQueue queue = this.queue;
            BytecodeManager.incBytecodes(6);
            this.thread = new TimerThread(queue);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            this.threadReaper = new Object() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                protected void finalize() throws Throwable {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //     4: ldc             3
                    //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //     9: invokestatic    instrumented/java/util/Timer.access$000:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TaskQueue;
                    //    12: dup            
                    //    13: astore_1       
                    //    14: pop            
                    //    15: ldc             3
                    //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    20: aload_0        
                    //    21: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //    24: ldc             3
                    //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    29: invokestatic    instrumented/java/util/Timer.access$100:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TimerThread;
                    //    32: iconst_0       
                    //    33: putfield        instrumented/java/util/TimerThread.newTasksMayBeScheduled:Z
                    //    36: ldc             2
                    //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    41: aload_0        
                    //    42: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //    45: ldc             3
                    //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    50: invokestatic    instrumented/java/util/Timer.access$000:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TaskQueue;
                    //    53: ldc             1
                    //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    58: invokevirtual   java/lang/Object.notify:()V
                    //    61: aload_1        
                    //    62: pop            
                    //    63: ldc             2
                    //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    68: ldc             1
                    //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    73: goto            91
                    //    76: astore_2       
                    //    77: aload_1        
                    //    78: pop            
                    //    79: ldc             503
                    //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    84: aload_2        
                    //    85: ldc             2
                    //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    90: athrow         
                    //    91: ldc             1
                    //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    96: return         
                    //    97: athrow         
                    //    98: athrow         
                    //    Exceptions:
                    //  throws java.lang.Throwable
                    //    StackMapTable: 00 04 FF 00 4C 00 02 07 00 02 07 00 04 00 01 07 00 1A FA 00 0E FF 00 05 00 00 00 01 07 00 1A FF 00 00 00 00 00 01 07 00 1D
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                           
                    //  -----  -----  -----  -----  -------------------------------
                    //  20     98     98     99     Ljava/lang/VirtualMachineError;
                    //  20     68     76     91     Any
                    //  76     84     76     91     Any
                    //  0      97     97     98     Any
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
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
            };
            BytecodeManager.incBytecodes(1);
            final TimerThread thread = this.thread;
            BytecodeManager.incBytecodes(4);
            thread.setName(name);
            final TimerThread thread2 = this.thread;
            BytecodeManager.incBytecodes(3);
            thread2.start();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Timer(final String name, final boolean daemon) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(4);
            this.queue = new TaskQueue();
            BytecodeManager.incBytecodes(1);
            final TaskQueue queue = this.queue;
            BytecodeManager.incBytecodes(6);
            this.thread = new TimerThread(queue);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(5);
            this.threadReaper = new Object() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                protected void finalize() throws Throwable {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //     4: ldc             3
                    //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //     9: invokestatic    instrumented/java/util/Timer.access$000:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TaskQueue;
                    //    12: dup            
                    //    13: astore_1       
                    //    14: pop            
                    //    15: ldc             3
                    //    17: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    20: aload_0        
                    //    21: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //    24: ldc             3
                    //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    29: invokestatic    instrumented/java/util/Timer.access$100:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TimerThread;
                    //    32: iconst_0       
                    //    33: putfield        instrumented/java/util/TimerThread.newTasksMayBeScheduled:Z
                    //    36: ldc             2
                    //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    41: aload_0        
                    //    42: getfield        instrumented/java/util/Timer$1.this$0:Linstrumented/java/util/Timer;
                    //    45: ldc             3
                    //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    50: invokestatic    instrumented/java/util/Timer.access$000:(Linstrumented/java/util/Timer;)Linstrumented/java/util/TaskQueue;
                    //    53: ldc             1
                    //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    58: invokevirtual   java/lang/Object.notify:()V
                    //    61: aload_1        
                    //    62: pop            
                    //    63: ldc             2
                    //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    68: ldc             1
                    //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    73: goto            91
                    //    76: astore_2       
                    //    77: aload_1        
                    //    78: pop            
                    //    79: ldc             503
                    //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    84: aload_2        
                    //    85: ldc             2
                    //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    90: athrow         
                    //    91: ldc             1
                    //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
                    //    96: return         
                    //    97: athrow         
                    //    98: athrow         
                    //    Exceptions:
                    //  throws java.lang.Throwable
                    //    StackMapTable: 00 04 FF 00 4C 00 02 07 00 02 07 00 04 00 01 07 00 1A FA 00 0E FF 00 05 00 00 00 01 07 00 1A FF 00 00 00 00 00 01 07 00 1D
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                           
                    //  -----  -----  -----  -----  -------------------------------
                    //  20     98     98     99     Ljava/lang/VirtualMachineError;
                    //  20     68     76     91     Any
                    //  76     84     76     91     Any
                    //  0      97     97     98     Any
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
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                    //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
            };
            BytecodeManager.incBytecodes(1);
            final TimerThread thread = this.thread;
            BytecodeManager.incBytecodes(4);
            thread.setName(name);
            final TimerThread thread2 = this.thread;
            BytecodeManager.incBytecodes(4);
            thread2.setDaemon(daemon);
            final TimerThread thread3 = this.thread;
            BytecodeManager.incBytecodes(3);
            thread3.start();
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void schedule(final TimerTask timerTask, final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 < 0) {
                final String s = "Negative delay.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(3);
            final long n3 = System.currentTimeMillis() + n;
            final long n4 = 0L;
            BytecodeManager.incBytecodes(4);
            this.sched(timerTask, n3, n4);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void schedule(final TimerTask timerTask, final Date date) {
        try {
            BytecodeManager.incBytecodes(4);
            final long time = date.getTime();
            final long n = 0L;
            BytecodeManager.incBytecodes(2);
            this.sched(timerTask, time, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void schedule(final TimerTask timerTask, final long n, final long n2) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                final String s = "Negative delay.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n4 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 <= 0) {
                final String s2 = "Non-positive period.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            final long n5 = System.currentTimeMillis() + n;
            final long n6 = -n2;
            BytecodeManager.incBytecodes(5);
            this.sched(timerTask, n5, n6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void schedule(final TimerTask timerTask, final Date date, final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 <= 0) {
                final String s = "Non-positive period.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            final long time = date.getTime();
            final long n3 = -n;
            BytecodeManager.incBytecodes(3);
            this.sched(timerTask, time, n3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void scheduleAtFixedRate(final TimerTask timerTask, final long n, final long n2) {
        try {
            final long n3 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n3 < 0) {
                final String s = "Negative delay.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final long n4 = lcmp(n2, 0L);
            BytecodeManager.incBytecodes(4);
            if (n4 <= 0) {
                final String s2 = "Non-positive period.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex2 = new IllegalArgumentException(s2);
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(3);
            final long n5 = System.currentTimeMillis() + n;
            BytecodeManager.incBytecodes(4);
            this.sched(timerTask, n5, n2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public void scheduleAtFixedRate(final TimerTask timerTask, final Date date, final long n) {
        try {
            final long n2 = lcmp(n, 0L);
            BytecodeManager.incBytecodes(4);
            if (n2 <= 0) {
                final String s = "Non-positive period.";
                BytecodeManager.incBytecodes(4);
                final IllegalArgumentException ex = new IllegalArgumentException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(4);
            final long time = date.getTime();
            BytecodeManager.incBytecodes(2);
            this.sched(timerTask, time, n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void sched(final TimerTask p0, final long p1, final long p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lconst_0       
        //     2: lcmp           
        //     3: ldc             4
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: ifge            31
        //    11: new             Ljava/lang/IllegalArgumentException;
        //    14: dup            
        //    15: ldc             "Illegal execution time."
        //    17: ldc             4
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    25: ldc             1
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: athrow         
        //    31: lload           4
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: invokestatic    java/lang/Math.abs:(J)J
        //    41: ldc2_w          4611686018427387903
        //    44: lcmp           
        //    45: ldc             3
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: ifle            64
        //    53: lload           4
        //    55: iconst_1       
        //    56: lshr           
        //    57: lstore          4
        //    59: ldc             4
        //    61: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    64: aload_0        
        //    65: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    68: dup            
        //    69: astore          6
        //    71: pop            
        //    72: ldc             5
        //    74: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    77: aload_0        
        //    78: getfield        instrumented/java/util/Timer.thread:Linstrumented/java/util/TimerThread;
        //    81: getfield        instrumented/java/util/TimerThread.newTasksMayBeScheduled:Z
        //    84: ldc             4
        //    86: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    89: ifne            112
        //    92: new             Ljava/lang/IllegalStateException;
        //    95: dup            
        //    96: ldc             "Timer already cancelled."
        //    98: ldc             4
        //   100: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   103: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   106: ldc             1
        //   108: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   111: athrow         
        //   112: aload_1        
        //   113: getfield        instrumented/java/util/TimerTask.lock:Ljava/lang/Object;
        //   116: dup            
        //   117: astore          7
        //   119: pop            
        //   120: ldc             5
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: aload_1        
        //   126: getfield        instrumented/java/util/TimerTask.state:I
        //   129: ldc             3
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: ifeq            157
        //   137: new             Ljava/lang/IllegalStateException;
        //   140: dup            
        //   141: ldc             "Task already scheduled or cancelled"
        //   143: ldc             4
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   151: ldc             1
        //   153: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   156: athrow         
        //   157: aload_1        
        //   158: lload_2        
        //   159: putfield        instrumented/java/util/TimerTask.nextExecutionTime:J
        //   162: ldc             3
        //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   167: aload_1        
        //   168: lload           4
        //   170: putfield        instrumented/java/util/TimerTask.period:J
        //   173: ldc             3
        //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   178: aload_1        
        //   179: iconst_1       
        //   180: putfield        instrumented/java/util/TimerTask.state:I
        //   183: ldc             3
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: aload           7
        //   190: pop            
        //   191: ldc             2
        //   193: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   196: ldc             1
        //   198: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   201: goto            222
        //   204: astore          8
        //   206: aload           7
        //   208: pop            
        //   209: ldc             503
        //   211: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   214: aload           8
        //   216: ldc             2
        //   218: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   221: athrow         
        //   222: aload_0        
        //   223: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //   226: aload_1        
        //   227: ldc             4
        //   229: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   232: invokevirtual   instrumented/java/util/TaskQueue.add:(Linstrumented/java/util/TimerTask;)V
        //   235: aload_0        
        //   236: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //   239: ldc             3
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: invokevirtual   instrumented/java/util/TaskQueue.getMin:()Linstrumented/java/util/TimerTask;
        //   247: aload_1        
        //   248: ldc             2
        //   250: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   253: if_acmpne       268
        //   256: aload_0        
        //   257: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //   260: ldc             3
        //   262: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   265: invokevirtual   java/lang/Object.notify:()V
        //   268: aload           6
        //   270: pop            
        //   271: ldc             2
        //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   276: ldc             1
        //   278: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   281: goto            302
        //   284: astore          9
        //   286: aload           6
        //   288: pop            
        //   289: ldc             503
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: aload           9
        //   296: ldc             2
        //   298: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   301: athrow         
        //   302: ldc             1
        //   304: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   307: return         
        //   308: athrow         
        //   309: athrow         
        //    StackMapTable: 00 0B 1F 20 FC 00 2F 07 00 04 FC 00 2C 07 00 04 6E 07 00 22 FA 00 11 2D 4F 07 00 22 FA 00 11 FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 7A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  77     309    309    310    Ljava/lang/VirtualMachineError;
        //  125    196    204    222    Any
        //  204    214    204    222    Any
        //  77     276    284    302    Any
        //  284    294    284    302    Any
        //  0      308    308    309    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
    
    public void cancel() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //     4: dup            
        //     5: astore_1       
        //     6: pop            
        //     7: ldc             5
        //     9: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    12: aload_0        
        //    13: getfield        instrumented/java/util/Timer.thread:Linstrumented/java/util/TimerThread;
        //    16: iconst_0       
        //    17: putfield        instrumented/java/util/TimerThread.newTasksMayBeScheduled:Z
        //    20: ldc             4
        //    22: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    25: aload_0        
        //    26: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    29: ldc             3
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: invokevirtual   instrumented/java/util/TaskQueue.clear:()V
        //    37: aload_0        
        //    38: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    41: ldc             3
        //    43: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    46: invokevirtual   java/lang/Object.notify:()V
        //    49: aload_1        
        //    50: pop            
        //    51: ldc             2
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: ldc             1
        //    58: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    61: goto            79
        //    64: astore_2       
        //    65: aload_1        
        //    66: pop            
        //    67: ldc             503
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: aload_2        
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: athrow         
        //    79: ldc             1
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: return         
        //    85: athrow         
        //    86: athrow         
        //    StackMapTable: 00 04 FF 00 40 00 02 07 00 02 07 00 04 00 01 07 00 22 FA 00 0E FF 00 05 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 7A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  12     86     86     87     Ljava/lang/VirtualMachineError;
        //  12     56     64     79     Any
        //  64     72     64     79     Any
        //  0      85     85     86     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
    
    public int purge() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: ldc             2
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: aload_0        
        //     8: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    11: dup            
        //    12: astore_2       
        //    13: pop            
        //    14: ldc             5
        //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    19: aload_0        
        //    20: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    23: ldc             3
        //    25: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    28: invokevirtual   instrumented/java/util/TaskQueue.size:()I
        //    31: istore_3       
        //    32: ldc             1
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: iload_3        
        //    38: ldc             2
        //    40: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    43: ifle            103
        //    46: aload_0        
        //    47: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    50: iload_3        
        //    51: ldc             4
        //    53: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    56: invokevirtual   instrumented/java/util/TaskQueue.get:(I)Linstrumented/java/util/TimerTask;
        //    59: getfield        instrumented/java/util/TimerTask.state:I
        //    62: iconst_3       
        //    63: ldc             3
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: if_icmpne       92
        //    71: aload_0        
        //    72: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //    75: iload_3        
        //    76: ldc             4
        //    78: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    81: invokevirtual   instrumented/java/util/TaskQueue.quickRemove:(I)V
        //    84: iinc            1, 1
        //    87: ldc             1
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: iinc            3, -1
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: goto            37
        //   103: iload_1        
        //   104: ldc             2
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ifeq            124
        //   112: aload_0        
        //   113: getfield        instrumented/java/util/Timer.queue:Linstrumented/java/util/TaskQueue;
        //   116: ldc             3
        //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   121: invokevirtual   instrumented/java/util/TaskQueue.heapify:()V
        //   124: aload_2        
        //   125: pop            
        //   126: ldc             2
        //   128: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   131: ldc             1
        //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   136: goto            156
        //   139: astore          4
        //   141: aload_2        
        //   142: pop            
        //   143: ldc             503
        //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   148: aload           4
        //   150: ldc             2
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: athrow         
        //   156: iload_1        
        //   157: ldc             2
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: ireturn        
        //   163: athrow         
        //   164: athrow         
        //    StackMapTable: 00 08 FE 00 25 01 07 00 04 01 36 FA 00 0A 14 4E 07 00 22 FA 00 10 FF 00 06 00 00 00 01 07 00 22 FF 00 00 00 00 00 01 07 00 7A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  19     164    164    165    Ljava/lang/VirtualMachineError;
        //  19     131    139    156    Any
        //  139    148    139    156    Any
        //  0      163    163    164    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0037:
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
    
    static {
        try {
            final int n = 0;
            BytecodeManager.incBytecodes(4);
            nextSerialNumber = new AtomicInteger(n);
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
