// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

class TimerThread extends Thread
{
    boolean newTasksMayBeScheduled;
    private TaskQueue queue;
    
    TimerThread(final TaskQueue queue) {
        try {
            BytecodeManager.incBytecodes(2);
            this.newTasksMayBeScheduled = true;
            BytecodeManager.incBytecodes(3);
            this.queue = queue;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void run() {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    this.mainLoop();
                    final TaskQueue queue = this.queue;
                    BytecodeManager.incBytecodes(5);
                    try {
                        this.newTasksMayBeScheduled = false;
                        BytecodeManager.incBytecodes(3);
                        final TaskQueue queue2 = this.queue;
                        BytecodeManager.incBytecodes(3);
                        queue2.clear();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        BytecodeManager.incBytecodes(503);
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    final TaskQueue queue3 = this.queue;
                    BytecodeManager.incBytecodes(506);
                    try {
                        this.newTasksMayBeScheduled = false;
                        BytecodeManager.incBytecodes(3);
                        final TaskQueue queue4 = this.queue;
                        BytecodeManager.incBytecodes(3);
                        queue4.clear();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(1);
                    }
                    finally {
                        BytecodeManager.incBytecodes(503);
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(2);
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
    
    private void mainLoop() {
        try {
            try {
                while (true) {
                    try {
                        while (true) {
                            final TaskQueue queue = this.queue;
                            BytecodeManager.incBytecodes(5);
                            TimerTask min;
                            boolean b3;
                            try {
                                while (true) {
                                    final TaskQueue queue2 = this.queue;
                                    BytecodeManager.incBytecodes(3);
                                    final boolean empty = queue2.isEmpty();
                                    BytecodeManager.incBytecodes(1);
                                    if (!empty) {
                                        break;
                                    }
                                    final boolean newTasksMayBeScheduled = this.newTasksMayBeScheduled;
                                    BytecodeManager.incBytecodes(3);
                                    if (!newTasksMayBeScheduled) {
                                        break;
                                    }
                                    final TaskQueue queue3 = this.queue;
                                    BytecodeManager.incBytecodes(3);
                                    queue3.wait();
                                    BytecodeManager.incBytecodes(1);
                                }
                                final TaskQueue queue4 = this.queue;
                                BytecodeManager.incBytecodes(3);
                                final boolean empty2 = queue4.isEmpty();
                                BytecodeManager.incBytecodes(1);
                                if (empty2) {
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                                final TaskQueue queue5 = this.queue;
                                BytecodeManager.incBytecodes(3);
                                min = queue5.getMin();
                                BytecodeManager.incBytecodes(1);
                                final Object lock = min.lock;
                                BytecodeManager.incBytecodes(5);
                                long currentTimeMillis;
                                long nextExecutionTime;
                                try {
                                    final int state = min.state;
                                    final int n = 3;
                                    BytecodeManager.incBytecodes(4);
                                    if (state == n) {
                                        final TaskQueue queue6 = this.queue;
                                        BytecodeManager.incBytecodes(3);
                                        queue6.removeMin();
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(2);
                                        BytecodeManager.incBytecodes(1);
                                        continue;
                                    }
                                    BytecodeManager.incBytecodes(1);
                                    currentTimeMillis = System.currentTimeMillis();
                                    BytecodeManager.incBytecodes(1);
                                    nextExecutionTime = min.nextExecutionTime;
                                    BytecodeManager.incBytecodes(3);
                                    final long n2 = lcmp(nextExecutionTime, currentTimeMillis);
                                    BytecodeManager.incBytecodes(4);
                                    boolean b2;
                                    boolean b;
                                    if (n2 <= 0) {
                                        b = (b2 = true);
                                        BytecodeManager.incBytecodes(2);
                                    }
                                    else {
                                        b = (b2 = false);
                                        BytecodeManager.incBytecodes(1);
                                    }
                                    b3 = b2;
                                    BytecodeManager.incBytecodes(3);
                                    if (b) {
                                        final long n3 = lcmp(min.period, 0L);
                                        BytecodeManager.incBytecodes(5);
                                        if (n3 == 0) {
                                            final TaskQueue queue7 = this.queue;
                                            BytecodeManager.incBytecodes(3);
                                            queue7.removeMin();
                                            min.state = 2;
                                            BytecodeManager.incBytecodes(4);
                                        }
                                        else {
                                            final TaskQueue queue8 = this.queue;
                                            final long n4 = lcmp(min.period, 0L);
                                            BytecodeManager.incBytecodes(7);
                                            long n5;
                                            if (n4 < 0) {
                                                n5 = currentTimeMillis - min.period;
                                                BytecodeManager.incBytecodes(5);
                                            }
                                            else {
                                                n5 = nextExecutionTime + min.period;
                                                BytecodeManager.incBytecodes(4);
                                            }
                                            BytecodeManager.incBytecodes(1);
                                            queue8.rescheduleMin(n5);
                                        }
                                    }
                                    BytecodeManager.incBytecodes(2);
                                    BytecodeManager.incBytecodes(1);
                                }
                                finally {}
                                final boolean b4 = b3;
                                BytecodeManager.incBytecodes(2);
                                if (!b4) {
                                    final TaskQueue queue9 = this.queue;
                                    final long n6 = nextExecutionTime - currentTimeMillis;
                                    BytecodeManager.incBytecodes(6);
                                    queue9.wait(n6);
                                }
                                BytecodeManager.incBytecodes(2);
                                BytecodeManager.incBytecodes(1);
                            }
                            finally {
                                BytecodeManager.incBytecodes(503);
                                BytecodeManager.incBytecodes(2);
                            }
                            final boolean b5 = b3;
                            BytecodeManager.incBytecodes(2);
                            if (b5) {
                                final TimerTask timerTask = min;
                                BytecodeManager.incBytecodes(2);
                                timerTask.run();
                            }
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    catch (InterruptedException min) {
                        BytecodeManager.incBytecodes(501);
                        BytecodeManager.incBytecodes(1);
                        continue;
                    }
                    break;
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
