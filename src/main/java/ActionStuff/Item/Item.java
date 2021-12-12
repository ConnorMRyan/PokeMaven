package ActionStuff.Item;

import ActionStuff.BattleAction;
import MonsterStuff.Monster;

public class Item extends BattleAction {
    @Override
    public void execute(Monster user, Monster defender) {

    }

    @Override
    public int getPriority() {
        return 0;
    }
}
