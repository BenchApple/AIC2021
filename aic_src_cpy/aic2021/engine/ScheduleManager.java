// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.engine;

import aic2021.user.UnitType;
import aic2021.util.GameLocation;
import aic2021.user.Team;
import java.util.LinkedList;
import java.util.ListIterator;
import aic2021.gamelogs.GameLog;

class ScheduleManager
{
    World world;
    GameLog gameLog;
    private ListIterator<Action> iterator;
    private LinkedList<Action> actions;
    private Unit currentUnit;
    private Action currentAction;
    
    ScheduleManager(final World world, final GameLog gameLog) {
        this.world = world;
        this.gameLog = gameLog;
        this.actions = new LinkedList<Action>();
    }
    
    Unit createUnit(final Team team, final GameLocation gameLocation, final Unit unit, final int n, final UnitType unitType) {
        final Unit unit2 = new Unit(this, this.world, this.gameLog, team, n, unitType);
        if (unit == null) {
            this.actions.addLast(new ScheduleUnitAction(unit2));
        }
        else if (team == Team.NEUTRAL) {
            this.addBack(new ScheduleUnitAction(unit2));
        }
        else {
            this.addForward(new ScheduleUnitAction(unit2));
        }
        this.world.putNewUnit(unit2, gameLocation);
        return unit2;
    }
    
    private void addForward(final Action action) {
        this.iterator.add(action);
        this.iterator.previous();
        this.iterator.previous();
        this.iterator.next();
    }
    
    void addBack(final Action action) {
        this.iterator.previous();
        this.iterator.add(action);
        this.iterator.next();
    }
    
    void addSmokeSignal(final int n) {
        this.addBack(new SmokeSignal(n));
    }
    
    void resetIndex() {
        this.iterator = this.actions.listIterator();
    }
    
    Unit getCurrentUnit() {
        return this.currentUnit;
    }
    
    boolean hasNextAction() {
        return this.iterator.hasNext();
    }
    
    Action nextAction() {
        this.currentAction = this.iterator.next();
        this.currentUnit = ((this.currentAction instanceof ScheduleUnitAction) ? ((ScheduleUnitAction)this.currentAction).unit : null);
        return this.currentAction;
    }
    
    void killUnit(final Unit unit) {
        unit.kill();
    }
    
    void removeCurrentAction() {
        this.iterator.remove();
    }
    
    void killCurrentUnit() {
        this.killUnit(this.getCurrentUnit());
    }
    
    boolean isCurrentUnitDead() {
        return this.getCurrentUnit().isDead();
    }
    
    int getActionCount() {
        return this.actions.size();
    }
    
    class SmokeSignal extends Action
    {
        int code;
        
        SmokeSignal(final int code) {
            this.code = code;
        }
        
        void act() {
            ScheduleManager.this.world.removeSignal(this.code);
            ScheduleManager.this.removeCurrentAction();
        }
    }
    
    class Action
    {
    }
    
    class ScheduleUnitAction extends Action
    {
        Unit unit;
        
        ScheduleUnitAction(final Unit unit) {
            this.unit = unit;
        }
    }
}
