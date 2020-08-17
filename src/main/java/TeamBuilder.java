import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeamBuilder {
  private Scanner in;
  private DatabaseConnection db;

  TeamBuilder() {

  }

  public static void main(String[] args) throws IOException {
    TeamBuilder teamBuilder = new TeamBuilder();
    teamBuilder.writeTeam();
  }

  public void writeTeam() throws IOException {
    createScanner();
    String nick = getUsername();
    FileWriter fileWriter = new FileWriter(nick + ".txt");
    fileWriter.write(nick + "\n");
    int numPoke = numPokemon();
    fileWriter.write(numPoke + "\n");
    for (int i = 0; i < numPoke; i++) {
      int numMoves = numMoves();
      fileWriter.write(numMoves + "\n");
      fileWriter.write(getPokeString());
      for (int j = 0; j < numMoves; j++) {
        if (useAPIMove()) {
          BattleMove pokeMove = pokeMovesAPI();
          fileWriter.write(pokeMove.printMove());
        } else {
          String move = pokemonMovesMan();
          fileWriter.write(move);
        }
      }
    }
    fileWriter.flush();
    fileWriter.close();
    closeScanner();
  }

  boolean validPokemon(String pokemon) {
    db = new DatabaseConnection();
    return db.isValidPoke(pokemon);
  }

  String getUsername() {
    System.out.println("What would you like as a username?");
    return in.next();
  }

  int numPokemon() {
    System.out.println("How many pokemon would you like to create? [6 Max]");
    int numPokemon = in.nextInt();
    if (numPokemon > 0 && numPokemon <= 6) {
      return numPokemon;
    } else {
      System.out.println("Sorry you need at least 1 pokemon and can't have more than 6");
      return numPokemon();
    }
  }

  String getPokeString() {
    // todo, validate user input;
    System.out.println("What is the species of pokemon you want ");
    String familyName = in.next();
    if (validPokemon(familyName)) {
      int level = getLevel();

      String nick;
      if (hasNick()) {
        nick = getNick();
      } else {
        nick = familyName;
      }
      return familyName + "," + level + "," + nick + "\n";
    } else {
      return getPokeString();
    }
  }

  boolean useAPIMove() {
    System.out.println("Would you like to use the ID to find the move? (y/N)");
    char val = in.next().toUpperCase().charAt(0);
    if (val == 'Y') {
      return true;
    }
    if (val == 'N') {
      return false;
    } else {
      System.out.println("Sorry I didn't understand");
      return useAPIMove();
    }
  }

  int getLevel() {
    System.out.println("What level is the pokemon? [1-100]");
    int level = in.nextInt();
    if (level < 0 || level > 100) {
      System.out.println("Sorry, that's not a valid level.");
      return getLevel();
    }
    return level;
  }

  boolean hasNick() {
    System.out.println("Does the pokemon have a nickname? [y/N]");
    String hasNick = in.next();
    return hasNick.toLowerCase().charAt(0) == 'y';
  }

  // todo consider adding nickname scanning for 'foul' language.
  String getNick() {
    System.out.println("What is the pokemon's nickname?");
    return in.next();
  }

  void createScanner() {
    this.in = new Scanner(System.in);
  }

  BattleMove pokeMovesAPI() {
    System.out.println("What is the ID of your move?");
    return new BattleMove(in.nextInt());
  }

  String pokemonMovesMan() {
    // This is an example move for rockthrow "50,90,12,15,RockThrow"
    System.out.println("What is the name of the move?");
    String movename = in.next();
    System.out.println("What is the power of the move?");
    int pow = in.nextInt();
    System.out.println("What is the accuracy of the move?");
    int accuracy = in.nextInt();
    System.out.println("What is the type of the move?");
    int type = types.getType(in.next());
    System.out.println("How many PP does the move have?");
    int PP = in.nextInt();

    return "" + pow + "," + accuracy + "," + type + "," + PP + "," + movename + "\n";
  }

  int numMoves() {
    System.out.println("How many moves does this pokemon know?(1-4)");
    int numMoves = in.nextInt();
    if (numMoves < 1 || numMoves > 4) {
      System.out.println("Sorry you aren't allowed to have that many moves.");
      return numMoves();
    }
    return numMoves;
  }

  void closeScanner() {
    in.close();
  }
}
