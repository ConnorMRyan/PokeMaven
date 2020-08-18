/**
 * The highest level base class for battle actions(Moves, Items, Switching.) All must have the ability to be executed and a priority.
 */

abstract class BattleAction {
    private int priority;

    abstract void execute(Monster user, Monster defender);

    abstract int getPriority();
}
