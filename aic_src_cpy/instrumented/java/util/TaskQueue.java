// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import aic2021.engine.BytecodeManager;

class TaskQueue
{
    private TimerTask[] queue;
    private int size;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    TaskQueue() {
        try {
            BytecodeManager.incBytecodes(2);
            this.queue = new TimerTask[128];
            BytecodeManager.incBytecodes(3);
            this.size = 0;
            BytecodeManager.incBytecodes(4);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    int size() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            return size;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void add(final TimerTask timerTask) {
        try {
            final int n = this.size + 1;
            final int length = this.queue.length;
            BytecodeManager.incBytecodes(8);
            if (n == length) {
                final TimerTask[] queue = this.queue;
                final int n2 = 2 * this.queue.length;
                BytecodeManager.incBytecodes(9);
                this.queue = Arrays.copyOf(queue, n2);
                BytecodeManager.incBytecodes(2);
            }
            this.queue[++this.size] = timerTask;
            BytecodeManager.incBytecodes(11);
            final int size = this.size;
            BytecodeManager.incBytecodes(4);
            this.fixUp(size);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    TimerTask getMin() {
        try {
            final TimerTask timerTask = this.queue[1];
            BytecodeManager.incBytecodes(5);
            return timerTask;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    TimerTask get(final int n) {
        try {
            final TimerTask timerTask = this.queue[n];
            BytecodeManager.incBytecodes(5);
            return timerTask;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void removeMin() {
        try {
            this.queue[1] = this.queue[this.size];
            BytecodeManager.incBytecodes(9);
            this.queue[this.size--] = null;
            BytecodeManager.incBytecodes(11);
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            this.fixDown(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void quickRemove(final int n) {
        try {
            final boolean $assertionsDisabled = TaskQueue.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n > size) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            this.queue[n] = this.queue[this.size];
            BytecodeManager.incBytecodes(9);
            this.queue[this.size--] = null;
            BytecodeManager.incBytecodes(11);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void rescheduleMin(final long nextExecutionTime) {
        try {
            this.queue[1].nextExecutionTime = nextExecutionTime;
            BytecodeManager.incBytecodes(6);
            final int n = 1;
            BytecodeManager.incBytecodes(3);
            this.fixDown(n);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    boolean isEmpty() {
        try {
            final int size = this.size;
            BytecodeManager.incBytecodes(3);
            boolean b;
            if (size == 0) {
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
    
    void clear() {
        try {
            int n = 1;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final int n2 = n;
                final int size = this.size;
                BytecodeManager.incBytecodes(4);
                if (n2 > size) {
                    break;
                }
                this.queue[n] = null;
                BytecodeManager.incBytecodes(5);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            this.size = 0;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void fixUp(int n) {
        try {
            while (true) {
                final int n2 = n;
                final int n3 = 1;
                BytecodeManager.incBytecodes(3);
                if (n2 <= n3) {
                    break;
                }
                final int n4 = n >> 1;
                BytecodeManager.incBytecodes(4);
                final long n5 = lcmp(this.queue[n4].nextExecutionTime, this.queue[n].nextExecutionTime);
                BytecodeManager.incBytecodes(12);
                if (n5 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final TimerTask timerTask = this.queue[n4];
                this.queue[n4] = this.queue[n];
                this.queue[n] = timerTask;
                BytecodeManager.incBytecodes(18);
                n = n4;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void fixDown(int n) {
        try {
            while (true) {
                int n3;
                final int n2 = n3 = n << 1;
                final int size = this.size;
                BytecodeManager.incBytecodes(8);
                if (n2 > size) {
                    break;
                }
                final int n4 = n3;
                BytecodeManager.incBytecodes(2);
                if (n4 <= 0) {
                    break;
                }
                final int n5 = n3;
                final int size2 = this.size;
                BytecodeManager.incBytecodes(4);
                if (n5 < size2) {
                    final long n6 = lcmp(this.queue[n3].nextExecutionTime, this.queue[n3 + 1].nextExecutionTime);
                    BytecodeManager.incBytecodes(14);
                    if (n6 > 0) {
                        ++n3;
                        BytecodeManager.incBytecodes(1);
                    }
                }
                final long n7 = lcmp(this.queue[n].nextExecutionTime, this.queue[n3].nextExecutionTime);
                BytecodeManager.incBytecodes(12);
                if (n7 <= 0) {
                    BytecodeManager.incBytecodes(1);
                    break;
                }
                final TimerTask timerTask = this.queue[n3];
                this.queue[n3] = this.queue[n];
                this.queue[n] = timerTask;
                BytecodeManager.incBytecodes(18);
                n = n3;
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    void heapify() {
        try {
            int n = this.size / 2;
            BytecodeManager.incBytecodes(5);
            while (true) {
                final int n2 = n;
                final int n3 = 1;
                BytecodeManager.incBytecodes(3);
                if (n2 < n3) {
                    break;
                }
                final int n4 = n;
                BytecodeManager.incBytecodes(3);
                this.fixDown(n4);
                --n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<TaskQueue> clazz = TaskQueue.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(2);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
