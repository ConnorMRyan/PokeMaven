package TeamStuff;

import ActionStuff.Move.BattleMove;
import ActionStuff.Move.MoveBase;
import ActionStuff.Move.StatusBoostMove;
import GSONClasses.Item.BattleStuff.Team;
import GSONClasses.Deserializers.MoveBaseAdapter;
import MonsterStuff.Monster;
import MonsterStuff.MonsterBuilder;
import Utils.DatabaseConnection;
import Utils.types;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeamBuilder {
    private Scanner tbScan;
    private DatabaseConnection db;

    /**
     * Creates a text file in the format required to make a team,
     */

    public TeamBuilder() {
        createScanner();
    }

    public void writeTeam() throws IOException {
        String nick = getUsername();
        FileWriter fileWriter = new FileWriter("C:/Users/mynam/IdeaProjects/PokeMaven/Teams/" + nick + ".json");
        Team team = new Team(nick);
        int numPoke = numPokemon();
        for (int i = 0; i < numPoke; i++) {
            int numMoves = numMoves();
            Monster monster = getPokeString();
            for (int j = 0; j < numMoves; j++) {
                if (useAPIMove()) {
                    MoveBase pokeMove = pokeMovesAPI();
                    monster.addMove(pokeMove);
                } else {
                    MoveBase move = pokemonMovesMan();
                    monster.addMove(move);
                }
            }
            team.addMonster(monster);
        }
        Gson gson = new GsonBuilder().registerTypeAdapter(MoveBase.class, new MoveBaseAdapter()).create();
        fileWriter.write(gson.toJson(team,Team.class));
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
        return tbScan.nextLine();
    }

    int numPokemon() {
        System.out.println("How many pokemon would you like to create? [6 Max]");
        int numPokemon = tbScan.nextInt();
        if (numPokemon > 0 && numPokemon <= 6) {
            return numPokemon;
        } else {
            System.out.println("Sorry you need at least 1 pokemon and can't have more than 6");
            return numPokemon();
        }
    }

    Monster getPokeString() throws IOException {
        // todo, validate user input;
        System.out.println("What is the DexNO of pokemon you want ");
        String dexNo = tbScan.next();

            int level = getLevel();
            String nick;
            if (hasNick()) {
                nick = getNick();
                return new MonsterBuilder().makeMonsterWithAPI(dexNo,level,nick);
            }
            return new MonsterBuilder().makeMonsterWithAPI(dexNo,level);
        }

    boolean useAPIMove() {
        System.out.println("Would you like to use the ID to find the move? (y/N)");
        char val = tbScan.next().toUpperCase().charAt(0);
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
        int level = tbScan.nextInt();
        if (level < 0 || level > 100) {
            System.out.println("Sorry, that's not a valid level.");
            return getLevel();
        }
        return level;
    }

    boolean hasNick() {
        System.out.println("Does the pokemon have a nickname? [y/N]");
        String hasNick = tbScan.next();
        return hasNick.toLowerCase().charAt(0) == 'y';
    }

    // todo consider adding nickname scanning for 'foul' language.
    public String getNick() {
        System.out.println("What is the pokemon's nickname?");
        return tbScan.next();
    }

    public void createScanner() {
        this.tbScan = new Scanner(System.in);
    }

    MoveBase pokeMovesAPI() {
        System.out.println("What is the ID of your move?");
        int id = tbScan.nextInt();
        PokeApi pokeApi = new PokeApiClient();
        String cat = pokeApi.getMove(id).getMeta().getCategory().getName();
        int type = findMoveType(id, cat);
        switch (type) {
            case (0):
                return new BattleMove("" +id);
            case (2):
                return new StatusBoostMove("" +id);
            default:
                return null;
        }

    }

    MoveBase pokemonMovesMan() {
        // This is an example move for rockthrow "50,90,12,15,RockThrow"
        System.out.println("What is the name of the move?");
        String movename = tbScan.next();
        System.out.println("What is the power of the move?");
        int pow = tbScan.nextInt();
        System.out.println("What is the accuracy of the move?");
        int accuracy = tbScan.nextInt();
        System.out.println("What is the type of the move?");
        int type = types.getType(tbScan.next());
        System.out.println("How many PP does the move have?");
        int PP = tbScan.nextInt();
        BattleMove battleMove = new BattleMove(pow,accuracy,type,PP,movename);
        return battleMove;
    }

    int numMoves() {
        System.out.println("How many moves does this pokemon know?(1-4)");
        int numMoves = tbScan.nextInt();
        if (numMoves < 1 || numMoves > 4) {
            System.out.println("Sorry you aren't allowed to have that many moves.");
            return numMoves();
        }
        return numMoves;
    }

    void closeScanner() {
        tbScan.close();
    }

    int findMoveType(int id, String cat) {
        System.out.println(cat);
        switch (cat) {
            case ("damage"):
                return 0;
            case ("ailment"):
                return 1;
            case ("net-good-stats"):
                return 2;
            case ("heal"):
                return 3;
            case ("damage+ailment"):
                return 0;
            case ("swagger"):
                return 5;
            case ("damage+lower"):
                return 6;
            case ("damage+raise"):
                return 7;
            case ("damage+heal"):
                return 8;
            case ("ohko"):
                return 9;
            case ("whole-field-effect"):
                return 10;
            case ("field-effect"):
                return 11;
            case ("force-switch"):
                return 12;
            case ("unique"):
                return 13;
            default:
                return -1;
        }
    }
}
