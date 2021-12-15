package ActionStuff.Move;

import ActionStuff.BattleAction;
import MonsterStuff.Monster;

public abstract class MoveBase extends BattleAction {
    int type;
    String name;
    int PP;
    int maxPP;
    MoveBase(){
    }
    public void execute(Monster user, Monster defender) {}


    void usePP() {
        PP = PP - 1;
    }

    public int getPP() {
        return this.PP;
    }

    public int getMaxPP() {
        return this.maxPP;
    }

    public abstract String printMove();

    public abstract int estimateEffect(Monster user, Monster defender);
}
