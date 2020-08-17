import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Move;

import java.util.HashMap;
import java.util.Map;

public class StatusBoostMove extends MoveBase {
  Map<String, Integer> statsMap = new HashMap<>();
  boolean targetOpp;

  StatusBoostMove(int moveID) {
    PokeApi pokeApi = new PokeApiClient();
    Move move = pokeApi.getMove(moveID);
    for (int i = 0; i < move.getStatChanges().size(); i++) {
      statsMap.put(
              move.getStatChanges().get(0).getStat().getName(),
              move.getStatChanges().get(0).getChange());
    }
    targetOpp = !move.getTarget().getName().equals("user");
  }

  @Override
  void execute(Monster user, Monster defender) {
    Monster target;

    if (targetOpp) {
      target = defender;

    } else {
      target = user;

    }
    if (statsMap.containsKey("speed")) {
      target.setSpdMod(target.getSpdMod() + statsMap.get("speed"));
      if (target.getSpdMod() + statsMap.get("speed") > 6) {
        System.out.println("Speed is maxed!");
        target.setSpdMod(6);
      }
      if (target.getSpdMod() <= -6) {
        System.out.println("speed is min!");
        target.setSpdMod(-6);
      }
    }
    if (statsMap.containsKey("attack")) {
      target.setAtkMod(target.getAtkMod() + (statsMap.get("attack")));
      if (target.getAtkMod() >= 6) {
        System.out.println("attack is maxed!");
        target.setAtkMod(6);
      }
      if (target.getAtkMod() <= -6) {
        System.out.println("attack is min!");
        target.setAtkMod(-6);
      }
    }
    if (statsMap.containsKey("defense")) {
      target.setDefMod(target.getDefMod() + (statsMap.get("defense")));
      if (target.getDefMod() >= 6) {
        System.out.println("defense is maxed!");
        target.setDefMod(6);
      }
      if (target.getDefMod() <= -6) {
        System.out.println("defense is min!");
        target.setDefMod(-6);
      }
    }
    if (statsMap.containsKey("special-attack")) {
      target.setSpcMod(target.getSpcMod() + (statsMap.get("special-attack")));
      if (target.getSpcMod() >= 6) {
        System.out.println("Special is maxed!");
        target.setSpcMod(6);
      }
      if (target.getSpcMod() <= -6) {
        System.out.println("Special is min!");
        target.setSpcMod(-6);
      }
    }
  }

  @Override
  public String toString() {
    return "StatusBoostMove{" + "statsMap=" + statsMap + ", targetOpp=" + targetOpp + '}';
  }
}
