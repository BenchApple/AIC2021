// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.gamelogs;

import aic2021.util.GameLocation;
import aic2021.engine.World;
import aic2021.user.Team;
import aic2021.util.GameAction;
import aic2021.util.WinCondition;
import aic2021.engine.TeamInfo;

public interface GameLog
{
    void writeMap(final String p0);
    
    void writeTeams(final String p0, final String p1);
    
    void writeConstants();
    
    void writeWinner(final TeamInfo p0, final WinCondition p1);
    
    void writeBoardSize(final int p0, final int p1);
    
    void writeOutput();
    
    void writeAction(final GameAction p0, final Team p1, final Object[] p2);
    
    void writeMapInvariants(final World p0);
    
    void writeRoundInfo(final World p0);
    
    void writeSmokeInfo(final GameLocation p0, final int p1);
}
