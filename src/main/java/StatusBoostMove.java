import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Move;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatusBoostMove extends MoveBase {
  Map<String, Integer> statsMap;
  boolean targetOpp;

  StatusBoostMove(int moveID) {
    PokeApi pokeApi = new PokeApiClient();
    Move move = pokeApi.getMove(moveID);
    statsMap = new HashMap<>();
    for (int i = 0; i < move.getStatChanges().size(); i++) {
      statsMap.put(
              move.getStatChanges().get(i).getStat().getName(),
              move.getStatChanges().get(i).getChange());
    }
    targetOpp = !move.getTarget().getName().equals("user");
  }

  StatusBoostMove(String str) {
    statsMap = new HashMap<>();
    Scanner in = new Scanner(str);
    targetOpp = in.next().equals("true");
    while (in.hasNext()) {
      Scanner out = new Scanner(in.next());
      out.useDelimiter(",");
      statsMap.put(out.next(), out.nextInt());
    }

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

  public String printString() {
    StringBuilder toPrint = new StringBuilder("" + targetOpp + "\n");
    for (String str : statsMap.keySet()) {
      toPrint.append(str).append(",").append(statsMap.get(str)).append("\n");
    }
    return toPrint.toString();
  }

  @Override
  public String toString() {
    return "StatusBoostMove{" +
            "statsMap=" + statsMap +
            ", targetOpp=" + targetOpp +
            '}';
  }
}
