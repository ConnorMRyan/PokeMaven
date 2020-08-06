import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        Monster charmander = db.makeAMonster(4, 5, "Charlie");
        Monster squirtle = db.makeAMonster("Squirtle", 5);

        int damage = charmander.basicAttack(40, types.NORMAL, squirtle);
        squirtle.takeDamage(damage);
        System.out.println("Charmander dealt " + damage + " damage");
        System.out.println("Squirtle has " + squirtle.getCurrentHp() + " out of " + squirtle.getTOTAL_HP());

        System.out.println(charmander);
        System.out.println(squirtle);


    }

    static String superEffective(int typeOne, int typeTwo) {
        double effectiveness = types.TYPE_EFFECTIVNESS[typeOne][typeTwo];
        if (effectiveness == 0) {
            return "not effective";
        } else if (effectiveness == .5) {
            return "not very effective";
        } else if (effectiveness == 1) {
            return "normally effective";
        } else if (effectiveness == 2) {
            return "super effective!";
        } else {
            return "something broke";
        }
    }
}
