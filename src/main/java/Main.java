import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //TeamBuilder teamBuilder = new TeamBuilder();
        //teamBuilder.writeTeam();
        //DatabaseConnection db = new DatabaseConnection();
        PokeApiClient apiClient = new PokeApiClient();
        Pokemon squirtle = apiClient.getPokemon(7);
        System.out.println(squirtle.component14().get(1));

        Team one = TeamParser.makeTeam(new File("Connor.txt"));
        //Team two = TeamParser.makeTeam(new File("src/main/java/BrockTeam"));
        //Battle battle = new Battle();
        Monster geo = one.getMonster(0);
        for (PokeMove pokeMove : geo.getMovesList()) {
            System.out.println(pokeMove);

        }
        //int damage = geo.basicAttack(geo.getMove(0), one.getMonster(1));
        //System.out.println(geo.getNAME() + " did " + damage + " to " + one.getMonster(1).getNAME());
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
