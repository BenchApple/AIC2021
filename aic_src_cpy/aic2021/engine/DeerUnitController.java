// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.UnitType;
import java.util.ArrayList;
import aic2021.util.GameLocation;
import java.util.LinkedList;
import aic2021.util.DeathException;
import aic2021.util.random.SymmetricEnum;
import aic2021.util.Symmetry;
import aic2021.user.UnitController;
import aic2021.user.Direction;

public class DeerUnitController
{
    Direction[] usefulDirs;
    World world;
    Unit me;
    UnitController uc;
    
    public DeerUnitController() {
        this.usefulDirs = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTHWEST, Direction.SOUTHWEST, Direction.NORTHEAST, Direction.SOUTHEAST };
    }
    
    void symmetrize() {
        final Symmetry symmetry = this.world.getSymmetry();
        for (int i = 0; i < 8; ++i) {
            this.usefulDirs[i] = symmetry.getSymmetric(this.usefulDirs[i]);
        }
    }
    
    void run(final World world, final Unit me, final UnitController uc) throws DeathException {
        this.world = world;
        this.me = me;
        this.uc = uc;
        if (me.rand.getSym() == SymmetricEnum.SYMMETRIC) {
            this.symmetrize();
        }
        while (true) {
            BytecodeManager.incBytecodes(1);
            if (!this.BFS()) {
                this.moveRandom();
            }
            uc.yield();
        }
    }
    
    boolean BFS() {
        if (!this.uc.canMove()) {
            return true;
        }
        final int[][] array = new int[this.world.getNRows()][this.world.getNCols()];
        final Direction[][] array2 = new Direction[this.world.getNRows()][this.world.getNCols()];
        final LinkedList<GameLocation> list = new LinkedList<GameLocation>();
        final GameLocation gameLocation = new GameLocation(this.uc.getLocation());
        array[gameLocation.x][gameLocation.y] = 1;
        array2[gameLocation.x][gameLocation.y] = Direction.ZERO;
        final ArrayList<GameLocation> list2 = new ArrayList<GameLocation>();
        int n = -1;
        list.add(gameLocation);
        while (!list.isEmpty()) {
            final GameLocation gameLocation2 = list.poll();
            final int n2 = array[gameLocation2.x][gameLocation2.y];
            final Direction direction = array2[gameLocation2.x][gameLocation2.y];
            if (n >= 0 && n2 > n) {
                break;
            }
            for (final Direction direction2 : this.usefulDirs) {
                final GameLocation add = gameLocation2.add(direction2);
                if (!this.world.isOutOfMap(add)) {
                    if (array[add.x][add.y] <= 0) {
                        array[add.x][add.y] = n2 + 1;
                        array2[add.x][add.y] = ((n2 == 1) ? direction2 : direction);
                        if (this.world.isAccessible(add, UnitType.DEER, null)) {
                            list.add(add);
                        }
                        if (this.world.getIns(add).getLuminosity() <= 6) {
                            list2.add(add);
                            n = n2;
                        }
                    }
                }
            }
        }
        final GameLocation randomSelect = this.randomSelect(list2);
        if (randomSelect != null && this.uc.canMove(array2[randomSelect.x][randomSelect.y])) {
            this.uc.move(array2[randomSelect.x][randomSelect.y]);
            return true;
        }
        return false;
    }
    
    GameLocation randomSelect(final ArrayList<GameLocation> list) {
        if (list.size() == 0) {
            return null;
        }
        return list.get((int)(this.me.getNextRandom() * list.size()));
    }
    
    void moveRandom() {
        if (!this.uc.canMove()) {
            return;
        }
        for (int i = 0; i < 20; ++i) {
            final Direction direction = this.usefulDirs[(int)(this.me.getNextRandom() * 8.0)];
            if (this.uc.canMove(direction)) {
                this.uc.move(direction);
                return;
            }
        }
    }
}
