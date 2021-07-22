// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.util.VisibleCells;
import aic2021.user.Technology;
import java.util.ArrayList;
import java.util.List;
import aic2021.util.random.SymmetricEnum;
import aic2021.util.random.SymmetricRandomDualQueue;
import aic2021.user.UnitType;
import aic2021.util.random.CustomRandom;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.util.HashMap;
import aic2021.user.Direction;
import aic2021.util.Symmetry;
import java.util.HashSet;
import aic2021.util.GameLocation;
import aic2021.util.WinCondition;
import aic2021.user.Team;

public class World
{
    private Team winner;
    private WinCondition winCondition;
    private int round;
    private GameLocation startingLocA;
    private GameLocation startingLocB;
    private TeamInfo teamAInfo;
    private TeamInfo teamBInfo;
    private TeamInfo dummyTeamInfo;
    private Cell[][] grid;
    private HashSet<Integer> usedUnitIDs;
    private int unitInternalId;
    private Symmetry symmetry;
    private MapReader mapReader;
    private ScheduleManager scheduleManager;
    Direction[] directions;
    private HashMap<Integer, Integer> smokeSignals;
    int[] nUnits;
    
    World(final String s, final String s2, final String s3) throws NumberFormatException, IOException {
        this.winner = null;
        this.winCondition = null;
        this.unitInternalId = 0;
        this.directions = Direction.values();
        this.smokeSignals = new HashMap<Integer, Integer>();
        this.round = -1;
        (this.mapReader = new MapReader()).loadMap(this, s);
        this.grid = this.mapReader.getMap();
        this.startingLocA = this.mapReader.getLocationA();
        this.startingLocB = this.mapReader.getLocationB();
        this.teamAInfo = new TeamInfo(Team.A, this.startingLocA, s2, true);
        this.teamBInfo = new TeamInfo(Team.B, this.startingLocB, s3, true);
        this.dummyTeamInfo = new TeamInfo(Team.NEUTRAL, new GameLocation(0, 0), "Neutral", false);
        this.teamAInfo.setOpponent(this.teamBInfo);
        this.teamBInfo.setOpponent(this.teamAInfo);
        this.usedUnitIDs = new HashSet<Integer>();
        this.symmetry = this.mapReader.getSymmetry();
        this.nUnits = new int[Team.values().length];
        this.initialCheck();
    }
    
    void setScheduleManager(final ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }
    
    TeamInfo getOpponent(final Team team) {
        if (team == Team.A) {
            return this.teamBInfo;
        }
        if (team == Team.B) {
            return this.teamAInfo;
        }
        return this.dummyTeamInfo;
    }
    
    void addSignal(final int n) {
        if (this.smokeSignals.containsKey(n)) {
            this.smokeSignals.put(n, this.smokeSignals.get(n) + 1);
        }
        else {
            this.smokeSignals.put(n, 1);
        }
        this.scheduleManager.addSmokeSignal(n);
    }
    
    void removeSignal(final int i) {
        final int intValue = this.smokeSignals.get(i);
        if (intValue > 1) {
            this.smokeSignals.put(i, intValue - 1);
        }
        else {
            this.smokeSignals.remove(i);
        }
    }
    
    public int[] getSmokeSignals() {
        final Set<Integer> keySet = this.smokeSignals.keySet();
        final int[] array = new int[keySet.size()];
        int n = 0;
        final Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            array[n++] = iterator.next();
        }
        return array;
    }
    
    int getNewId() {
        for (int i = 0; i < 1000; ++i) {
            final int j = (int)(CustomRandom.getInstance().getRandom() * 10000.0) + 1;
            if (!this.usedUnitIDs.contains(j)) {
                return j;
            }
        }
        for (int k = 1; k <= 10000; ++k) {
            if (!this.usedUnitIDs.contains(k)) {
                return k;
            }
        }
        return 1;
    }
    
    int getNewInternalId() {
        return ++this.unitInternalId;
    }
    
    Team getWinner() {
        return this.winner;
    }
    
    WinCondition getWinCondition() {
        return this.winCondition;
    }
    
    void setWinner(final Team winner, final WinCondition winCondition) {
        if (this.winner != null) {
            return;
        }
        this.winner = winner;
        this.winCondition = winCondition;
    }
    
    TeamInfo getWinnerInfo() {
        return this.getTeamInfo(this.winner);
    }
    
    public TeamInfo getTeamInfo(final Team team) {
        if (team == Team.A) {
            return this.teamAInfo;
        }
        if (team == Team.B) {
            return this.teamBInfo;
        }
        return this.dummyTeamInfo;
    }
    
    public Symmetry getSymmetry() {
        return this.symmetry;
    }
    
    boolean depositNearby(final Unit unit) {
        final GameLocation gameLocation = unit.getGameLocation();
        final Direction[] values = Direction.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final Cell ins = this.getIns(gameLocation.add(values[i]));
            if (ins != null) {
                final Unit unit2 = ins.getUnit();
                if (unit2 != null) {
                    if (unit2.getTeam() == unit.getTeam()) {
                        if (unit2.getType() == UnitType.BASE || unit2.getType() == UnitType.SETTLEMENT) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public Cell[][] getGrid() {
        return this.grid;
    }
    
    GameLocation getGameLocationA() {
        return this.startingLocA;
    }
    
    GameLocation getGameLocationB() {
        return this.startingLocB;
    }
    
    public int getNRows() {
        return this.grid.length;
    }
    
    public int getNCols() {
        return this.grid[0].length;
    }
    
    public boolean isAccessible(final GameLocation gameLocation, final UnitType unitType, final TeamInfo teamInfo) {
        final Cell ins = this.getIns(gameLocation);
        return ins != null && ins.isAccessible(unitType, teamInfo);
    }
    
    public boolean isOutOfMap(final GameLocation gameLocation) {
        return this.isOutOfMap(gameLocation.x, gameLocation.y);
    }
    
    public boolean isOutOfMap(final int n, final int n2) {
        return n < 0 || n >= this.grid.length || (n2 < 0 || n2 >= this.grid[0].length);
    }
    
    public void moveUnit(final Unit unit, final Direction direction) {
        final GameLocation gameLocation = unit.gameLocation;
        final GameLocation add = gameLocation.add(direction);
        if (add.isEqual(gameLocation)) {
            return;
        }
        if (this.getIns(gameLocation).getUnit() == unit) {
            this.removeUnitAtLocation(gameLocation);
        }
        unit.prevGameLocation = gameLocation;
        this.setUnitAtLocation(unit.gameLocation = add, unit);
    }
    
    void putNewUnit(final Unit unit, final GameLocation gameLocation) {
        assert gameLocation != null;
        if (this.isOutOfMap(gameLocation) || !this.isAccessible(gameLocation, unit.getType(), unit.getTeamInfo())) {
            if (Game.printWarnings) {
                System.err.println("World.putNewUnit: Trying to put a unit out of the map or in a non accessible place!! " + gameLocation.toString());
            }
            return;
        }
        unit.prevGameLocation = gameLocation;
        this.setUnitAtLocation(unit.gameLocation = gameLocation, unit);
        this.usedUnitIDs.add(unit.getUnitId());
        final int[] nUnits = this.nUnits;
        final int ordinal = unit.getTeam().ordinal();
        ++nUnits[ordinal];
    }
    
    void removeUnitPermanently(final Unit unit) {
        if (this.getIns(unit.gameLocation).getUnit() != unit) {
            return;
        }
        this.removeUnitAtLocation(unit.gameLocation);
        this.usedUnitIDs.remove(unit.getUnitId());
        if (unit.getType() == UnitType.BASE) {
            this.setWinner(unit.getTeam().getOpponent(), WinCondition.DESTRUCTION);
        }
        final int[] nUnits = this.nUnits;
        final int ordinal = unit.getTeam().ordinal();
        --nUnits[ordinal];
    }
    
    void checkAllCells() {
        for (int i = 0; i < this.grid.length; ++i) {
            for (int j = 0; j < this.grid[i].length; ++j) {
                this.grid[i][j].check();
            }
        }
    }
    
    void initialCheck() {
        for (int i = 0; i < this.grid.length; ++i) {
            for (int j = 0; j < this.grid[i].length; ++j) {
                if (!this.grid[i][j].checked) {
                    final Cell cell = this.grid[i][j];
                    final Cell symmetric = this.getSymmetric(new GameLocation(i, j));
                    if (cell == symmetric) {
                        cell.checked = true;
                    }
                    else {
                        final SymmetricRandomDualQueue symmetricRandomDualQueue = new SymmetricRandomDualQueue();
                        cell.rand.setDual(symmetricRandomDualQueue, SymmetricEnum.NON_SYMMETRIC);
                        symmetric.rand.setDual(symmetricRandomDualQueue, SymmetricEnum.SYMMETRIC);
                        cell.checked = true;
                        symmetric.checked = true;
                    }
                }
            }
        }
    }
    
    void print() {
        if (!Game.printWarnings) {
            return;
        }
        final int n = -32;
        for (int i = this.grid[0].length - 1; i >= 0; --i) {
            for (int j = 0; j < this.grid.length; ++j) {
                char c = '.';
                if (this.grid[j][i].getUnit() != null) {
                    final Team team = this.grid[j][i].getUnit().getTeam();
                    switch (this.grid[j][i].getUnit().getType()) {
                        case BASE: {
                            c = 'b';
                            break;
                        }
                        case WORKER: {
                            c = 'k';
                            break;
                        }
                        case SETTLEMENT: {
                            c = 's';
                            break;
                        }
                        case BARRACKS: {
                            c = 'r';
                            break;
                        }
                        case FARM: {
                            c = 'f';
                            break;
                        }
                        case SAWMILL: {
                            c = 'i';
                            break;
                        }
                        case QUARRY: {
                            c = 'q';
                            break;
                        }
                        case EXPLORER: {
                            c = 'e';
                            break;
                        }
                        case TRAPPER: {
                            c = 't';
                            break;
                        }
                        case AXEMAN: {
                            c = 'a';
                            break;
                        }
                        case SPEARMAN: {
                            c = 'p';
                            break;
                        }
                        case WOLF: {
                            c = 'o';
                            break;
                        }
                        case DEER: {
                            c = 'd';
                            break;
                        }
                        default: {
                            c = 'x';
                            break;
                        }
                    }
                    if (team == Team.B) {
                        c += (char)n;
                    }
                }
                else if (this.grid[j][i].hasMountain()) {
                    c = '^';
                }
                else if (this.grid[j][i].hasWater()) {
                    c = '-';
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    
    public List<Unit> getUnits() {
        final ArrayList<Unit> list = new ArrayList<Unit>();
        for (int i = 0; i < this.grid.length; ++i) {
            for (int j = 0; j < this.grid[i].length; ++j) {
                final Unit unit = this.grid[i][j].getUnit();
                if (unit != null) {
                    list.add(unit);
                }
            }
        }
        return list;
    }
    
    void putDeer(final GameLocation gameLocation) {
        this.scheduleManager.createUnit(Team.NEUTRAL, gameLocation, null, 0, UnitType.DEER);
    }
    
    private void setUnitAtLocation(final GameLocation gameLocation, final Unit unit) {
        this.setUnitAtLocation(gameLocation.x, gameLocation.y, unit);
    }
    
    private void setUnitAtLocation(final int n, final int n2, final Unit unit) {
        this.grid[n][n2].setUnit(unit);
        final Cell ins = this.getIns(n, n2);
        if (ins == null) {
            return;
        }
        final Unit unit2 = ins.getUnit();
        if (unit2 == null) {
            return;
        }
        int n3 = 0;
        if (unit2.torchIntensity > 0) {
            n3 = unit2.torchIntensity;
        }
        if (unit2.type.luminousIntensity > 0) {
            n3 = unit2.type.luminousIntensity;
        }
        if (n3 > 0) {
            this.addSource(n3, new GameLocation(n, n2), 1);
        }
        if (ins.hasTrap()) {
            unit2.kill();
            ins.removeTrap();
        }
    }
    
    private void removeUnitAtLocation(final GameLocation gameLocation) {
        this.removeUnitAtLocation(gameLocation.x, gameLocation.y);
    }
    
    private void removeUnitAtLocation(final int n, final int n2) {
        final Cell ins = this.getIns(n, n2);
        if (ins == null) {
            return;
        }
        final Unit unit = ins.getUnit();
        if (unit == null) {
            return;
        }
        int n3 = 0;
        if (unit.torchIntensity > 0) {
            n3 = unit.torchIntensity;
        }
        if (unit.type.luminousIntensity > 0) {
            n3 = unit.type.luminousIntensity;
        }
        if (n3 > 0) {
            this.removeSource(n3, new GameLocation(n, n2), 1);
        }
        this.grid[n][n2].setUnit(null);
    }
    
    public Cell getIns(final GameLocation gameLocation) {
        return this.getIns(gameLocation.x, gameLocation.y);
    }
    
    public Cell getIns(final int n, final int n2) {
        return this.isOutOfMap(n, n2) ? null : this.grid[n][n2];
    }
    
    boolean advanceRound() {
        if (this.round < 2000) {
            ++this.round;
            return true;
        }
        return false;
    }
    
    public int getRound() {
        return this.round;
    }
    
    public int computeValue(final Team team) {
        int totalResources = this.getTeamInfo(team).getTotalResources();
        for (int i = 0; i < this.grid.length; ++i) {
            for (int j = 0; j < this.grid[i].length; ++j) {
                final Unit unit = this.grid[i][j].getUnit();
                if (unit != null && unit.getTeam() == team) {
                    totalResources += unit.getType().getTotalCost();
                }
            }
        }
        return totalResources;
    }
    
    Cell getSymmetric(final GameLocation gameLocation) {
        switch (this.symmetry) {
            case HORIZONTAL: {
                return this.getIns(this.grid.length - gameLocation.x - 1, gameLocation.y);
            }
            case VERTICAL: {
                return this.getIns(gameLocation.x, this.grid[0].length - gameLocation.y - 1);
            }
            default: {
                return this.getIns(this.grid.length - gameLocation.x - 1, this.grid[0].length - gameLocation.y - 1);
            }
        }
    }
    
    void researchTech(final TeamInfo teamInfo, final Technology technology) {
        teamInfo.researchTech(technology);
        if (technology == Technology.WHEEL) {
            this.setWinner(teamInfo.team, WinCondition.TECHNOLOGY);
        }
    }
    
    void endGame() {
        if (this.winner != null) {
            return;
        }
        final int techLevel = this.teamAInfo.getTechLevel();
        final int techLevel2 = this.teamBInfo.getTechLevel();
        if (techLevel > techLevel2) {
            this.setWinner(Team.A, WinCondition.TECHLEVEL);
            return;
        }
        if (techLevel2 > techLevel) {
            this.setWinner(Team.B, WinCondition.TECHLEVEL);
            return;
        }
        final int techCosts = this.teamAInfo.getTechCosts();
        final int techCosts2 = this.teamBInfo.getTechCosts();
        if (techCosts > techCosts2) {
            this.setWinner(Team.A, WinCondition.TECHRESOURCES);
            return;
        }
        if (techCosts2 > techCosts) {
            this.setWinner(Team.B, WinCondition.TECHRESOURCES);
            return;
        }
        final int computeValue = this.computeValue(Team.A);
        final int computeValue2 = this.computeValue(Team.B);
        if (computeValue > computeValue2) {
            this.setWinner(Team.A, WinCondition.TOTALRESOURCES);
            return;
        }
        if (computeValue2 > computeValue) {
            this.setWinner(Team.B, WinCondition.TOTALRESOURCES);
            return;
        }
        this.setWinner(((int)(CustomRandom.getInstance().getRandom() * 2.0) == 0) ? Team.A : Team.B, WinCondition.RANDOM);
    }
    
    void addSource(final int n, final GameLocation gameLocation, final int n2) {
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n3 = 0; n3 < instance.sortedLocs.length && instance.sortedLocs[n3].norm() <= instance.maxRangeLuminosity[n]; ++n3) {
            final GameLocation add = gameLocation.add(instance.sortedLocs[n3]);
            if (!this.isOutOfMap(add)) {
                if (n3 == 0) {
                    this.getIns(add).addLuminosity(gameLocation, n, n2);
                }
                else {
                    int n4 = 0;
                    for (final Direction direction : this.directions) {
                        final GameLocation add2 = add.add(direction);
                        if (!this.isOutOfMap(add2)) {
                            if (add2.distanceSquared(gameLocation) < add.distanceSquared(gameLocation)) {
                                final Cell ins = this.getIns(add2);
                                final int n5 = ins.getLuminosity(gameLocation, n2) - direction.luminosityLength() * ins.getOpacity();
                                if (n5 > n4) {
                                    n4 = n5;
                                }
                            }
                        }
                    }
                    this.getIns(add).addLuminosity(gameLocation, n4, n2);
                }
            }
        }
    }
    
    void removeSource(final int n, final GameLocation gameLocation, final int n2) {
        final VisibleCells instance = VisibleCells.getInstance();
        for (int n3 = 0; n3 < instance.sortedLocs.length && instance.sortedLocs[n3].norm() <= instance.maxRangeLuminosity[n]; ++n3) {
            final GameLocation add = gameLocation.add(instance.sortedLocs[n3]);
            if (!this.isOutOfMap(add)) {
                this.getIns(add).removeLuminosity(gameLocation, n2);
            }
        }
    }
    
    public boolean adjacentToLight(final Unit unit) {
        final GameLocation gameLocation = unit.getGameLocation();
        final Direction[] directions = this.directions;
        for (int length = directions.length, i = 0; i < length; ++i) {
            final Cell ins = this.getIns(gameLocation.add(directions[i]));
            if (ins != null) {
                if (ins.hasFire()) {
                    return true;
                }
                final Unit unit2 = ins.getUnit();
                if (unit2 != null) {
                    if (unit2.getId() != unit.getId()) {
                        int n = 0;
                        if (unit2.torchIntensity > 0) {
                            n = unit2.torchIntensity;
                        }
                        if (unit2.type.luminousIntensity > 0) {
                            n = unit2.type.luminousIntensity;
                        }
                        if (n > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
