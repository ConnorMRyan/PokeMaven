import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, InterruptedException {

    PokeApi pokeApi = new PokeApiClient();
    StatusBoostMove agility = new StatusBoostMove(97);
    StatusBoostMove growl = new StatusBoostMove(483);

    // TeamBuilder teamBuilder = new TeamBuilder();
    // teamBuilder.writeTeam();
    DatabaseConnection db = new DatabaseConnection();
    Monster charmander = db.makeAMonster(4, 100);
    Monster squirtle = db.makeAMonster(7, 100);
    StatusBoostMove doubleGrowl = new StatusBoostMove(growl.printString());

    System.out.println(doubleGrowl);

    // Team ash = TeamParser.makeTeam(new File("Ash"));
    // Team brock = TeamParser.makeTeam(new File("src/main/java/BrockTeam"));
    // Battle battle = new Battle(ash, brock, true);
    // battle.activeTeam.getMonster(0);

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