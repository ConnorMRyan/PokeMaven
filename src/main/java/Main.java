import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //TeamBuilder teamBuilder = new TeamBuilder();
        //teamBuilder.writeTeam();
        //DatabaseConnection db = new DatabaseConnection();


        Team ash = TeamParser.makeTeam(new File("Ash"));
        Team brock = TeamParser.makeTeam(new File("src/main/java/BrockTeam"));
        Battle battle = new Battle(ash, brock);
        battle.activeTeam.getMonster(0);
        Monster geo = ash.getMonster(0);

        System.out.println();
        int damage = geo.basicAttack(geo.getMove(0), brock.getMonster(1));
        System.out.println(geo.getNAME() + " did " + damage + " to " + brock.getMonster(1).getNAME() + " with " + geo.getMove(0));
        int damage2 = geo.basicAttack(geo.getMove(1), brock.getMonster(1));
        System.out.println(geo.getNAME() + " did " + damage2 + " to " + brock.getMonster(1).getNAME() + " with " + geo.getMove(1));
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
