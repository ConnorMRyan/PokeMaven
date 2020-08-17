import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Move;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

import java.util.Random;
import java.util.stream.IntStream;

public class BattleMove extends MoveBase {
  int power;
  int accuracy;
  String moveName;
  int type;
  int PP;
  int maxPP;
  int priority = 1;


  BattleMove(String moveString) {


  }

  BattleMove(int moveID) {
    PokeApi pokeApi = new PokeApiClient();
    Move move = pokeApi.getMove(moveID);
    if (move.getPower() != null) {
      this.power = move.getPower();
    } else {
      System.err.println("The moves power is bugged. it has been set to 50");
      this.power = 50;
    }
    if (move.getAccuracy() != null) {
      this.accuracy = move.getAccuracy();
    } else {
      System.err.println("The moves accuracy is bugged. it has been set to 80");
      this.power = 80;
    }
    NamedApiResource type = move.getType();
    this.type = types.getType(type.getName());
    if (move.getPp() != null) {
      this.PP = move.getPp();
    } else {
      System.err.println("The moves PP is bugged. It has been set to 15");
      this.PP = 15;
    }
    this.moveName = move.getName();
  }

  BattleMove(int power, int accuracy, int type, int PP, String moveName) {
    this.power = power;
    this.accuracy = accuracy;
    this.moveName = moveName;
    this.type = type;
    this.PP = PP;
    this.maxPP = PP;
  }

  @Override
  void execute(Monster user, Monster target) {
    double modifier = getModifier(user, target);
    int crit = 1;
    if (isACrit(user)) {
      System.out.println("Was a crit");
      crit = 2;
    }
    if (IntStream.of(types.physical).anyMatch(x -> x == type)) {
      int damage =
              (int)
                      Math.round(
                              ((((((2 * user.getLEVEL() * crit) / 5.) + 2)
                                      * this.getPower()
                                      * (user.getATK() / (double) target.getDEF()))
                                      / 50
                                      + 2)
                                      * modifier));
      System.out.println(
              user.getNAME() + " did " + damage + " to " + target.getNAME() + " with " + moveName);
      target.takeDamage(damage);
    }
    if (IntStream.of(types.special).anyMatch(x -> x == type)) {
      int damage =
              (int)
                      Math.round(
                              ((((((2 * user.getLEVEL() * crit) / 5.) + 2)
                                      * this.getPower()
                                      * (user.getSPC() / (double) target.getSPC()))
                                      / 50
                                      + 2)
                                      * modifier));
      System.out.println(
              user.getNAME() + " did " + damage + " to " + target.getNAME() + " with " + moveName);
      target.takeDamage(damage);
    }


  }

  public double getModifier(Monster user, Monster defender) {
    Random random = new Random();
    int val = random.nextInt(38);
    double STAB = 1;
    if (user.getType1() == type || user.getType2() == type) {
      STAB = 1.5;
    }
    return ((217 + val) / 255.)
            * STAB
            * types.TYPE_EFFECTIVNESS[type][defender.getType1()]
            * types.TYPE_EFFECTIVNESS[type][defender.getType2()];
  }

  private boolean isACrit(Monster user) {
    int tVal = user.getSPD() / 2;
    Random random = new Random();
    int target = random.nextInt(256);
    int critNum = Math.min(255, tVal);
    return target < critNum;
  }

  @Override
  public String toString() {
    return moveName;
  }

  public String fancyString() {
    return "Move{"
            + "power="
            + power
            + ", accuracy="
            + accuracy
            + ", moveName='"
            + moveName
            + '\''
            + ", type="
            + types.typeName(type)
            + +'}';
  }

  public int getAccuracy() {
    return accuracy;
  }

  public int getPower() {
    return power;
  }

  public void usePP() {
    PP = PP - 1;
  }

  public int getPP() {
    return PP;
  }

  public int getMaxPP() {
    return maxPP;
  }

  public int getType() {
    return type;
  }

  public String getMoveName() {
    return moveName;
  }

  @Override
  public int getPriority() {
    return priority;
  }

  public String printMove() {
    return ""
            + this.power
            + ","
            + this.accuracy
            + ","
            + this.type
            + ","
            + this.PP
            + ","
            + this.moveName
            + "\n";
  }
}
