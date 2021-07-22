// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.gamelogs;

import java.io.IOException;
import aic2021.util.random.CustomRandom;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import aic2021.user.UnitType;
import java.util.Iterator;
import aic2021.user.FireInfo;
import aic2021.user.ResourceInfo;
import aic2021.user.Resource;
import aic2021.engine.Unit;
import java.awt.Color;
import aic2021.util.GameAction;
import aic2021.util.GameLocation;
import aic2021.engine.Cell;
import aic2021.engine.World;
import aic2021.user.Team;
import aic2021.util.WinCondition;
import aic2021.engine.TeamInfo;
import java.util.ArrayList;
import java.util.List;

public class GameLogImpl implements GameLog
{
    final String ln;
    String filePath;
    String mapName;
    String teamAName;
    String teamBName;
    String winner;
    String winCondition;
    int nRows;
    int nCols;
    int nActionsA;
    int nActionsB;
    StringBuffer actionsABuffer;
    StringBuffer actionsBBuffer;
    int nDebugsA;
    int nDebugsB;
    StringBuffer debugsABuffer;
    StringBuffer debugsBBuffer;
    StringBuffer mapInvariants;
    List<StringBuffer> rounds;
    List<SmokeInfo> smokes;
    
    public GameLogImpl(final String filePath) {
        this.ln = System.lineSeparator();
        this.filePath = filePath;
        final int n = 0;
        this.nActionsB = n;
        this.nActionsA = n;
        this.actionsABuffer = new StringBuffer();
        this.actionsBBuffer = new StringBuffer();
        final int n2 = 0;
        this.nDebugsB = n2;
        this.nDebugsA = n2;
        this.debugsABuffer = new StringBuffer();
        this.debugsBBuffer = new StringBuffer();
        this.mapInvariants = new StringBuffer();
        this.rounds = new ArrayList<StringBuffer>();
        this.smokes = new ArrayList<SmokeInfo>();
    }
    
    @Override
    public void writeMap(final String mapName) {
        this.mapName = mapName;
    }
    
    @Override
    public void writeTeams(final String teamAName, final String teamBName) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
    }
    
    @Override
    public void writeConstants() {
    }
    
    @Override
    public void writeWinner(final TeamInfo teamInfo, final WinCondition winCondition) {
        if (teamInfo.getTeam() == Team.A) {
            this.winner = "A";
        }
        else {
            this.winner = "B";
        }
        this.winCondition = winCondition.condition;
    }
    
    @Override
    public void writeBoardSize(final int nRows, final int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
    }
    
    @Override
    public void writeMapInvariants(final World world) {
        final Cell[][] grid = world.getGrid();
        final StringBuilder s = new StringBuilder();
        int i = 0;
        for (final Cell[] array2 : grid) {
            for (final Cell cell : array2) {
                final GameLocation gameLocation = cell.getGameLocation();
                if (cell.hasMountain()) {
                    ++i;
                    s.append("M ").append(gameLocation.x).append(" ").append(gameLocation.y).append(this.ln);
                }
                if (cell.hasWater()) {
                    ++i;
                    s.append("W ").append(gameLocation.x).append(" ").append(gameLocation.y).append(this.ln);
                }
            }
        }
        this.mapInvariants.append(i).append(this.ln).append((CharSequence)s);
    }
    
    @Override
    public void writeSmokeInfo(final GameLocation gameLocation, final int n) {
        this.smokes.add(new SmokeInfo(gameLocation, n));
    }
    
    @Override
    public void writeAction(final GameAction gameAction, final Team team, final Object[] array) {
        boolean b = true;
        final StringBuilder sb = new StringBuilder();
        boolean b2 = true;
        final StringBuilder sb2 = new StringBuilder();
        if (gameAction == GameAction.ATTACK) {
            final GameLocation gameLocation = (GameLocation)array[0];
            final GameLocation gameLocation2 = (GameLocation)array[1];
            sb.append("A").append(" ");
            sb.append(gameLocation.x).append(" ").append(gameLocation.y).append(" ");
            sb.append(gameLocation2.x).append(" ").append(gameLocation2.y).append(this.ln);
        }
        else {
            b = false;
        }
        if (gameAction == GameAction.DEBUG) {
            sb2.append("P").append(" ").append(array[0]).append(" ").append((String)array[1]).append(this.ln);
        }
        else if (gameAction == GameAction.DRAW_POINT) {
            final Integer obj = (Integer)array[0];
            final GameLocation gameLocation3 = (GameLocation)array[1];
            final Color color = (Color)array[2];
            sb2.append("D").append(" ").append(obj).append(" ");
            sb2.append(gameLocation3.x).append(" ").append(gameLocation3.y).append(" ");
            sb2.append(this.colorToString(color)).append(this.ln);
        }
        else if (gameAction == GameAction.DRAW_LINE) {
            final Integer obj2 = (Integer)array[0];
            final GameLocation gameLocation4 = (GameLocation)array[1];
            final GameLocation gameLocation5 = (GameLocation)array[2];
            final Color color2 = (Color)array[3];
            sb2.append("L").append(" ").append(obj2).append(" ");
            sb2.append(gameLocation4.x).append(" ").append(gameLocation4.y).append(" ");
            sb2.append(gameLocation5.x).append(" ").append(gameLocation5.y).append(" ");
            sb2.append(this.colorToString(color2)).append(this.ln);
        }
        else {
            b2 = false;
        }
        if (team == Team.A) {
            if (b) {
                ++this.nActionsA;
                this.actionsABuffer.append((CharSequence)sb);
            }
            else if (b2) {
                ++this.nDebugsA;
                this.debugsABuffer.append((CharSequence)sb2);
            }
        }
        else if (team == Team.B) {
            if (b) {
                ++this.nActionsB;
                this.actionsBBuffer.append((CharSequence)sb);
            }
            else if (b2) {
                ++this.nDebugsB;
                this.debugsBBuffer.append((CharSequence)sb2);
            }
        }
    }
    
    @Override
    public void writeRoundInfo(final World world) {
        final StringBuilder s = new StringBuilder();
        final Cell[][] grid = world.getGrid();
        for (int i = 0; i < grid[0].length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                s.append(grid[j][i].getLuminosity()).append(" ");
            }
            s.append(this.ln);
        }
        final StringBuilder s2 = new StringBuilder();
        int k = 0;
        for (int l = 0; l < grid.length; ++l) {
            for (int m = 0; m < grid[l].length; ++m) {
                final Cell cell = grid[l][m];
                final String string = "" + l + " " + m;
                final ResourceInfo woodInfo = cell.getWoodInfo();
                final ResourceInfo stoneInfo = cell.getStoneInfo();
                final ResourceInfo foodInfo = cell.getFoodInfo();
                final FireInfo fireInfo = cell.getFireInfo();
                final int rockArt = cell.getRockArt();
                final boolean hasTrap = cell.hasTrap();
                if (woodInfo != null) {
                    s2.append("D ").append(string).append(" ").append(woodInfo.amount).append(this.ln);
                    ++k;
                }
                if (stoneInfo != null) {
                    s2.append("N ").append(string).append(" ").append(stoneInfo.amount).append(this.ln);
                    ++k;
                }
                if (foodInfo != null) {
                    s2.append("M ").append(string).append(" ").append(foodInfo.amount).append(this.ln);
                    ++k;
                }
                if (fireInfo != null) {
                    s2.append("F ").append(string).append(" ").append(fireInfo.duration).append(this.ln);
                    ++k;
                }
                if (rockArt != 0) {
                    s2.append("P ").append(string).append(" ").append(rockArt).append(this.ln);
                    ++k;
                }
                if (hasTrap) {
                    s2.append("T ").append(string).append(this.ln);
                    ++k;
                }
            }
        }
        for (final SmokeInfo smokeInfo : this.smokes) {
            s2.append("S ").append("" + smokeInfo.gLoc.x + " " + smokeInfo.gLoc.y).append(" ").append(smokeInfo.value).append(this.ln);
            ++k;
        }
        final StringBuilder s3 = new StringBuilder();
        final StringBuilder s4 = new StringBuilder();
        final StringBuilder s5 = new StringBuilder();
        final List<Unit> units = world.getUnits();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (final Unit unit : units) {
            final StringBuilder sb = new StringBuilder();
            sb.append(unit.getUnitId()).append(" ").append(unit.getInternalId());
            sb.append(" ").append(this.getUnitTypeChar(unit.getType()));
            sb.append(" ").append(unit.getGameLocation().x).append(" ").append(unit.getGameLocation().y);
            sb.append(" ").append(unit.getPrevGameLocation().x).append(" ").append(unit.getPrevGameLocation().y);
            sb.append(" ").append(unit.getHealth());
            if (this.isTeamedUnit(unit.getType())) {
                sb.append(" ").append(unit.getBytecodeEndTurn());
                final int constructionTurns = unit.getConstructionTurns();
                if (constructionTurns > 0) {
                    sb.append(" C ").append(constructionTurns);
                }
                else {
                    sb.append(" H 0");
                }
            }
            if (this.isAttackingUnit(unit.getType())) {
                sb.append(" ").append(unit.getCurrentAttackCooldown());
            }
            if (this.isMovingUnit(unit.getType())) {
                sb.append(" ").append(unit.getCurrentMoveCooldown());
            }
            if (this.isCarryingUnit(unit.getType())) {
                final int[] resources = unit.getResources();
                sb.append(" ").append(resources[Resource.FOOD.ordinal()]);
                sb.append(" ").append(resources[Resource.STONE.ordinal()]);
                sb.append(" ").append(resources[Resource.WOOD.ordinal()]);
            }
            if (unit.getTeam() == Team.A) {
                ++i2;
                s3.append(sb.toString()).append(this.ln);
            }
            else if (unit.getTeam() == Team.B) {
                ++i3;
                s4.append(sb.toString()).append(this.ln);
            }
            else {
                if (unit.getTeam() != Team.NEUTRAL) {
                    continue;
                }
                ++i4;
                s5.append(sb.toString()).append(this.ln);
            }
        }
        final StringBuffer sb2 = new StringBuffer();
        sb2.append((CharSequence)s);
        sb2.append(k).append(this.ln).append((CharSequence)s2);
        sb2.append(world.computeValue(Team.A)).append(" ");
        sb2.append(world.getTeamInfo(Team.A).getResource(Resource.FOOD)).append(" ");
        sb2.append(world.getTeamInfo(Team.A).getResource(Resource.STONE)).append(" ");
        sb2.append(world.getTeamInfo(Team.A).getResource(Resource.WOOD)).append(" ");
        sb2.append(world.getTeamInfo(Team.A).getTechLevel()).append(" ");
        sb2.append(world.getTeamInfo(Team.A).getNTechs()).append(this.ln);
        sb2.append(i2).append(this.ln).append((CharSequence)s3);
        sb2.append(this.nActionsA).append(this.ln).append(this.actionsABuffer);
        sb2.append(this.nDebugsA).append(this.ln).append(this.debugsABuffer);
        sb2.append(world.computeValue(Team.B)).append(" ");
        sb2.append(world.getTeamInfo(Team.B).getResource(Resource.FOOD)).append(" ");
        sb2.append(world.getTeamInfo(Team.B).getResource(Resource.STONE)).append(" ");
        sb2.append(world.getTeamInfo(Team.B).getResource(Resource.WOOD)).append(" ");
        sb2.append(world.getTeamInfo(Team.B).getTechLevel()).append(" ");
        sb2.append(world.getTeamInfo(Team.B).getNTechs()).append(this.ln);
        sb2.append(i3).append(this.ln).append((CharSequence)s4);
        sb2.append(this.nActionsB).append(this.ln).append(this.actionsBBuffer);
        sb2.append(this.nDebugsB).append(this.ln).append(this.debugsBBuffer);
        sb2.append(i4).append(this.ln).append((CharSequence)s5);
        this.rounds.add(sb2);
        final int n = 0;
        this.nActionsB = n;
        this.nActionsA = n;
        this.actionsABuffer = new StringBuffer();
        this.actionsBBuffer = new StringBuffer();
        final int n2 = 0;
        this.nDebugsB = n2;
        this.nDebugsA = n2;
        this.debugsABuffer = new StringBuffer();
        this.debugsBBuffer = new StringBuffer();
        this.smokes = new ArrayList<SmokeInfo>();
    }
    
    private char getUnitTypeChar(final UnitType unitType) {
        switch (unitType) {
            case WORKER: {
                return 'W';
            }
            case EXPLORER: {
                return 'S';
            }
            case TRAPPER: {
                return 'T';
            }
            case AXEMAN: {
                return 'A';
            }
            case SPEARMAN: {
                return 'L';
            }
            case WOLF: {
                return 'F';
            }
            case BASE: {
                return 'B';
            }
            case SETTLEMENT: {
                return 'E';
            }
            case BARRACKS: {
                return 'R';
            }
            case FARM: {
                return 'M';
            }
            case SAWMILL: {
                return 'I';
            }
            case QUARRY: {
                return 'Q';
            }
            case DEER: {
                return 'D';
            }
            default: {
                return '.';
            }
        }
    }
    
    private boolean isTeamedUnit(final UnitType unitType) {
        switch (unitType) {
            case WORKER:
            case EXPLORER:
            case TRAPPER:
            case AXEMAN:
            case SPEARMAN:
            case WOLF:
            case BASE:
            case SETTLEMENT:
            case BARRACKS:
            case FARM:
            case SAWMILL:
            case QUARRY: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    private boolean isAttackingUnit(final UnitType unitType) {
        return unitType.canAttack();
    }
    
    private boolean isMovingUnit(final UnitType unitType) {
        return unitType.canMove();
    }
    
    private boolean isCarryingUnit(final UnitType unitType) {
        switch (unitType) {
            case WORKER:
            case TRAPPER:
            case AXEMAN:
            case SPEARMAN:
            case WOLF: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    private String colorToString(final Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
    
    @Override
    public void writeOutput() {
        try (final FileWriter out = new FileWriter(this.filePath, true);
             final BufferedWriter out2 = new BufferedWriter(out);
             final PrintWriter printWriter = new PrintWriter(out2)) {
            printWriter.println("AIC2021");
            printWriter.println(this.mapName);
            printWriter.println(CustomRandom.getInstance().getSeed());
            printWriter.println(this.teamAName);
            printWriter.println(this.teamBName);
            printWriter.println(this.winner);
            printWriter.println(this.winCondition);
            printWriter.println("" + this.nRows + " " + this.nCols);
            printWriter.println("" + GameLocation.offsetX + " " + GameLocation.offsetY);
            printWriter.println("15000");
            printWriter.println(this.rounds.size());
            printWriter.print(this.mapInvariants);
            final Iterator<StringBuffer> iterator = this.rounds.iterator();
            while (iterator.hasNext()) {
                printWriter.print(iterator.next());
            }
        }
        catch (IOException ex) {
            System.err.println("Error: Could not write game log!");
        }
    }
    
    static class SmokeInfo
    {
        GameLocation gLoc;
        int value;
        
        SmokeInfo(final GameLocation gLoc, final int value) {
            this.gLoc = gLoc;
            this.value = value;
        }
    }
}
