// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.util.DeathException;

public class BytecodeManager
{
    static int INF;
    
    public static void incBytecodes(int inf) throws DeathException {
        if (inf <= 0) {
            return;
        }
        if (inf > BytecodeManager.INF) {
            inf = BytecodeManager.INF;
        }
        ThreadManager.increaseBytecodeOfCurrentSlave(inf, true);
    }
    
    static {
        BytecodeManager.INF = 150000000;
    }
}
