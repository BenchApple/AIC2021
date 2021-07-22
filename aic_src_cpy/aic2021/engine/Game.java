// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.Technology;
import aic2021.user.UnitType;
import aic2021.user.Team;
import aic2021.gamelogs.GameLogImpl;
import aic2021.util.random.CustomRandom;
import aic2021.gamelogs.GameLog;

public class Game extends Thread
{
    static boolean printWarnings;
    World world;
    private final ScheduleManager scheduleManager;
    private final GameLog gameLog;
    
    public Game(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final boolean printWarnings, final long n) {
        CustomRandom.getNewInstance(n);
        Game.printWarnings = printWarnings;
        this.world = null;
        try {
            this.world = new World(s3, s, s2);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        (this.gameLog = new GameLogImpl(s4)).writeMap(s3);
        this.gameLog.writeTeams(s5, s6);
        this.gameLog.writeBoardSize(this.world.getNRows(), this.world.getNCols());
        ThreadManager.setScheduleManager(this.scheduleManager = new ScheduleManager(this.world, this.gameLog));
        this.world.setScheduleManager(this.scheduleManager);
    }
    
    @Override
    public void run() {
        this.gameLog.writeMapInvariants(this.world);
        this.addInitialUnits();
        this.gameLog.writeRoundInfo(this.world);
        Team winner = null;
        while (winner == null && this.world.advanceRound()) {
            if (this.world.getRound() > 0 && this.world.getRound() % 300 == 0) {
                System.gc();
            }
            if (this.world.getRound() > 1) {
                this.AddResources(this.world.getTeamInfo(Team.A));
                this.AddResources(this.world.getTeamInfo(Team.B));
            }
            if (this.world.getRound() > 0) {
                this.world.checkAllCells();
                this.world.getTeamInfo(Team.A).printResources(this.gameLog);
                this.world.getTeamInfo(Team.B).printResources(this.gameLog);
            }
            this.scheduleManager.resetIndex();
            while (this.scheduleManager.hasNextAction()) {
                winner = this.world.getWinner();
                if (winner != null) {
                    break;
                }
                final ScheduleManager.Action nextAction = this.scheduleManager.nextAction();
                if (nextAction instanceof ScheduleManager.ScheduleUnitAction) {
                    final Unit unit = ((ScheduleManager.ScheduleUnitAction)nextAction).unit;
                    unit.startTurn();
                    unit.getThreadManager().resumeSlave();
                    unit.endTurn();
                }
                else if (nextAction instanceof ScheduleManager.SmokeSignal) {
                    ((ScheduleManager.SmokeSignal)nextAction).act();
                }
                else {
                    if (!Game.printWarnings) {
                        continue;
                    }
                    System.out.println("Game.run: Unexpected action");
                }
            }
            this.gameLog.writeRoundInfo(this.world);
        }
        this.world.print();
        this.world.endGame();
        final Team winner2 = this.world.getWinner();
        final String condition = this.world.getWinCondition().condition;
        this.gameLog.writeWinner(this.world.getTeamInfo(winner2), this.world.getWinCondition());
        this.gameLog.writeOutput();
        this.stopAllUnitThreads(this.scheduleManager);
        if (Game.printWarnings) {
            System.out.println("Winner: " + this.world.getTeamInfo(winner2).teamName + " (Team " + this.world.getTeamInfo(winner2).getTeam() + ")");
        }
        if (Game.printWarnings) {
            System.out.println("WinCondition: " + condition);
        }
    }
    
    private void addInitialUnits() {
        this.scheduleManager.createUnit(Team.A, this.world.getGameLocationA(), null, 0, UnitType.BASE);
        this.scheduleManager.createUnit(Team.B, this.world.getGameLocationB(), null, 0, UnitType.BASE);
    }
    
    private void AddResources(final TeamInfo teamInfo) {
        int n = 0;
        if (teamInfo.hasTech(Technology.COIN)) {
            ++n;
        }
        if (this.world.getOpponent(teamInfo.team).hasTech(Technology.POISON)) {
            ++n;
        }
        teamInfo.addResources(new int[] { 2 + n, 2 + n, 2 + n });
    }
    
    private void stopAllUnitThreads(final ScheduleManager scheduleManager) {
        while (scheduleManager.getActionCount() > 0) {
            scheduleManager.resetIndex();
            while (scheduleManager.getActionCount() > 0) {
                final ScheduleManager.Action nextAction = scheduleManager.nextAction();
                if (nextAction instanceof ScheduleManager.ScheduleUnitAction) {
                    final Unit unit = ((ScheduleManager.ScheduleUnitAction)nextAction).unit;
                    scheduleManager.killCurrentUnit();
                    unit.getThreadManager().resumeSlave();
                }
                else if (nextAction instanceof ScheduleManager.SmokeSignal) {
                    ((ScheduleManager.SmokeSignal)nextAction).act();
                }
                else {
                    if (!Game.printWarnings) {
                        continue;
                    }
                    System.out.println("Game.run: Unexpected action");
                }
            }
        }
    }
    
    public Team getWinner() {
        return this.world.getWinner();
    }
    
    public static boolean warningsOn() {
        return Game.printWarnings;
    }
    
    static {
        Game.printWarnings = true;
    }
}
