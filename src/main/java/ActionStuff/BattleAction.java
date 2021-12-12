package ActionStuff;

import MonsterStuff.Monster;

/**
 * The highest level base class for battle actions(Moves, Items, Switching.) All must have the ability to be executed and a priority.
 */

public abstract class BattleAction {
    protected int priority;

    public abstract void execute(Monster user, Monster defender);

    public abstract int getPriority();
}
