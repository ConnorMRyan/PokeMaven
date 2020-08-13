import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Move;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

public class PokeMove {
  int power;
  int accuracy;
  String moveName;
  int type;
  int PP;

  PokeMove(int moveID) {
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

    PokeMove(int power, int accuracy, int type, int PP, String moveName) {
        this.power = power;
        this.accuracy = accuracy;
        this.moveName = moveName;
        this.type = type;
        this.PP = PP;
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
                + types.typeName(type) +
                +'}';
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
  public int getType() {
    return type;
  }
  public String getMoveName() {
    return moveName;
  }
}
