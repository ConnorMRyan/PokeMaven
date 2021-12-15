package ActionStuff.Move;

import MonsterStuff.Monster;

public class HealMove extends MoveBase {
    private static final String CLASS_META_KEY = "HealMove";

    int priority = 0;
    int amountHealed = 0;

    HealMove(int amountHealed) {
        this.amountHealed = amountHealed;
    }

    @Override
    public void execute(Monster user, Monster defender) {
        user.heal(amountHealed);
    }

    @Override
    public String printMove() {
        return null;
    }

    @Override
    public int estimateEffect(Monster user, Monster defender) {
        return -1 * amountHealed;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
