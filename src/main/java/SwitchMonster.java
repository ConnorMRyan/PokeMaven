import java.util.ArrayList;
import java.util.Collections;

public class SwitchMonster extends BattleAction {
    private final Team team;
    private final int id;
    private final int priority;

    SwitchMonster(Team team, int id) {
        this.team = team;
        this.id = id;
        this.priority = 0;

    }

    @Override
    void execute(Monster user, Monster defender) {
        ArrayList<Monster> tl = team.getTeamList();
        Collections.swap(tl, tl.indexOf(user), id);
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
