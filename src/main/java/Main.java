import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

public class Main {
  static OkHttpClient client;

  public static void main(String[] args) throws IOException, InterruptedException {

    PokeApi pokeApi = new PokeApiClient();
    StatusBoostMove agility = new StatusBoostMove(97);
    StatusBoostMove growl = new StatusBoostMove(347);


    // TeamBuilder teamBuilder = new TeamBuilder();
    // teamBuilder.writeTeam();
    DatabaseConnection db = new DatabaseConnection();
    Monster charmander = db.makeAMonster(4, 100);
    Monster squirtle = db.makeAMonster(7, 100);
    charmander.addMove(growl);


    Team ash = TeamParser.makeTeam(new File("Ash"));
    Team brock = TeamParser.makeTeam(new File("src/main/java/BrockTeam"));
    Battle battle = new Battle(ash, brock, true);
    //battle.activeTeam.getMonster(0);


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

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static String run(String url) throws IOException {
    Request request = new Request.Builder()
            .url(url)
            .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }
}
