import MonsterStuff.Monster;
import TeamStuff.TeamBuilder;
import TeamStuff.TeamParser;
import Utils.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Tests {
    DatabaseConnection db = new DatabaseConnection();
    Monster testmander = db.makeAMonster(4, 5, "Charlie");
    Monster testle = db.makeAMonster("Squirtle", 5);

    public Tests() {
    }

    @Test
    void moveTest() {
        // int damage = testmander.basicAttack(35, Utils.types.NORMAL, testle);
        assert (true);
    }

    @Test
    void createMonsterNameless() {
        String assertedTrue = "Charlie is a level 5 Charmander";
        String methodResult = testmander.toString();
        assert (assertedTrue.equals(methodResult));
    }

    @Test
    void createMonsterNamed() {
        String assertedTrue = "Squirtle is a level 5 Squirtle";
        String methodResult = testle.toString();
        assert (assertedTrue.equals(methodResult));
    }

    @Test
    void equalityCheck() {
        Monster henry = db.makeAMonster(4, 5);
        assert (henry.equals(testmander));
        assert (!henry.equals(testle));
    }

    @Test
    void testTeambuilder() {
        TeamBuilder teamBuilder = new TeamBuilder();
        teamBuilder.createScanner();
        teamBuilder.getNick();
    }

    @Test
    void testTeamParser() {
        try {
            TeamParser.makeTeam("BrockTeam");
            assert (true);
        } catch (Exception e) {
            assert (false);
        }
    }
}

