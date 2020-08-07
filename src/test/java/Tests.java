import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class Tests {
    DatabaseConnection db = new DatabaseConnection();
    Monster testmander = db.makeAMonster(4, 5, "Charlie");
    Monster testle = db.makeAMonster("Squirtle", 5);

    public Tests() {
    }

    @Test
    void moveTest() {
        //int damage = testmander.basicAttack(35, types.NORMAL, testle);
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
}
