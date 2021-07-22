// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.util.DeathException;

public class ThreadManager
{
    private static Thread runningSlave;
    private static ThreadManager runningSlaveInstance;
    private static ScheduleManager scheduleManager;
    private int currentBytecode;
    private boolean hasStarted;
    private Thread slave;
    private boolean isSlavePaused;
    
    ThreadManager(final Thread slave) {
        this.currentBytecode = 0;
        this.hasStarted = false;
        this.isSlavePaused = true;
        this.slave = slave;
    }
    
    static void setScheduleManager(final ScheduleManager scheduleManager) {
        ThreadManager.scheduleManager = scheduleManager;
    }
    
    static void increaseBytecodeOfCurrentSlave(final int n, final boolean b) {
        if (ThreadManager.scheduleManager.isCurrentUnitDead()) {
            throw new DeathException();
        }
        ThreadManager.runningSlaveInstance.increaseBytecode(n, b);
    }
    
    private void increaseBytecode(final int n, final boolean b) {
        this.currentBytecode += n;
        if (this.currentBytecode > BytecodeManager.INF) {
            this.currentBytecode = BytecodeManager.INF;
        }
        if (b) {
            if (!this.hasStarted) {
                return;
            }
            if (ThreadManager.scheduleManager.isCurrentUnitDead() || this.currentBytecode > 15000) {
                resumeMaster();
            }
        }
    }
    
    private void resetBytecode() {
        if (this.hasStarted) {
            this.currentBytecode = Math.max(0, this.currentBytecode - 15000);
        }
    }
    
    static void resumeMaster() {
        final ThreadManager runningSlaveInstance = ThreadManager.runningSlaveInstance;
        ThreadManager.scheduleManager.getCurrentUnit().bytecodeEndTurn = runningSlaveInstance.currentBytecode;
        synchronized (runningSlaveInstance) {
            runningSlaveInstance.setRunningSlave(null);
            runningSlaveInstance.notifyAll();
            runningSlaveInstance.resetBytecode();
            while (runningSlaveInstance.isSlavePaused) {
                try {
                    runningSlaveInstance.wait();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    static void resumeMasterNonStop() {
        final ThreadManager runningSlaveInstance = ThreadManager.runningSlaveInstance;
        ThreadManager.scheduleManager.getCurrentUnit().bytecodeEndTurn = runningSlaveInstance.currentBytecode;
        synchronized (runningSlaveInstance) {
            runningSlaveInstance.setRunningSlave(null);
            runningSlaveInstance.notifyAll();
        }
    }
    
    void resumeSlave() {
        if (ThreadManager.runningSlave != null) {
            if (Game.printWarnings) {
                System.err.println("A slave is already running!!!");
            }
            return;
        }
        synchronized (this) {
            this.setRunningSlave(this.slave);
            if (!this.hasStarted) {
                this.slave.start();
                this.hasStarted = true;
            }
            else {
                this.notifyAll();
            }
            while (!this.isSlavePaused) {
                try {
                    this.wait();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private void setRunningSlave(final Thread runningSlave) {
        ThreadManager.runningSlave = runningSlave;
        if (runningSlave == null) {
            this.isSlavePaused = true;
            ThreadManager.runningSlaveInstance = null;
        }
        else {
            this.isSlavePaused = false;
            ThreadManager.runningSlaveInstance = ThreadManager.scheduleManager.getCurrentUnit().getThreadManager();
        }
    }
    
    public static void punish() {
        increaseBytecodeOfCurrentSlave(500, false);
    }
    
    int getCurrentBytecode() {
        return this.currentBytecode;
    }
    
    static {
        ThreadManager.runningSlave = null;
        ThreadManager.runningSlaveInstance = null;
    }
}
