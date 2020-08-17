public class MoveBase extends BattleAction {
    int type;
    String name;
    int PP;
    int maxPP;

    void execute(Monster user, Monster defender) {
    }

    void usePP() {
        PP = PP - 1;
    }

    int getPP() {
        return this.PP;
    }

    int getMaxPP() {
        return this.maxPP;
    }
}
