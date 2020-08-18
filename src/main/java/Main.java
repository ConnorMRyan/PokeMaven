import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, InterruptedException {
    Launcher ln = new Launcher();
    ln.Launch();
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