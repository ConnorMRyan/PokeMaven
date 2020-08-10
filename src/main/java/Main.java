import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        TeamBuilder teamBuilder = new TeamBuilder();
        teamBuilder.writeTeam();
        //DatabaseConnection db = new DatabaseConnection();
        Team one = TeamParser.makeTeam(new File("Ash"));
        Monster geo = one.getMonster(0);
        int damage = geo.basicAttack(geo.getMove(0), one.getMonster(1));
        System.out.println(geo.getNAME() + " did " + damage + " to " + one.getMonster(1).getNAME());
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
