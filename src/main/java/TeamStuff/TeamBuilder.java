package TeamStuff;

import ActionStuff.Move.BattleMove;
import ActionStuff.Move.MoveBase;
import ActionStuff.Move.MoveBuilder;
import BattleStuff.Team;
import GSONClasses.Deserializers.MoveBaseAdapter;
import GSONClasses.Move.Move;
import MonsterStuff.Monster;
import MonsterStuff.MonsterBuilder;
import Utils.types;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TeamBuilder {
    private Scanner tbScan;
    Gson gson = new GsonBuilder().registerTypeAdapter(MoveBase.class, new MoveBaseAdapter()).create();


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
            Monster monster;
            if(isUsingID()) {
                 monster = getPokeStringFromID();
            }else{
                monster = getPokeStringFromName();
            }
            int numMoves = numMoves();
            for (int j = 0; j < numMoves; j++) {
                if (useAPIMove()) {
                    MoveBase pokeMove = pokeMovesID();
                    monster.addMove(pokeMove);
                } else {
                    MoveBase move = pokeMovesName();
                    monster.addMove(move);
                }
            }
            team.addMonster(monster);
        }
        fileWriter.write(gson.toJson(team,Team.class));
        fileWriter.flush();
        fileWriter.close();
        closeScanner();
    }

    boolean validPokemon(String pokemon) {
        // TODO: 12/15/2021 add validation based on the new pokeJSONs
        return true;
    }
    boolean isUsingID(){
        System.out.println("Would you like to use the ID of a pokemon?");
        String ID =  tbScan.next();
        return ID.toUpperCase().charAt(0) == 'Y';
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

    Monster getPokeStringFromID() throws IOException {
        // todo, validate user input;
        System.out.println("What is the DexNO of pokemon you want?");
        String dexNo = tbScan.next();
            int level = getLevel();
            String nick;
            if (hasNick()) {
                nick = getNick();
                return new MonsterBuilder().makeMonsterWithID(dexNo,level,nick);
            }
            return new MonsterBuilder().makeMonsterWithID(dexNo,level);
        }

    Monster getPokeStringFromName() throws IOException {
        // todo, validate user input;
        System.out.println("What is the species of pokemon you want?");
        String species = tbScan.next().toLowerCase();
        int level = getLevel();
        String nick;
        if (hasNick()) {
            nick = getNick();
            return new MonsterBuilder().makeMonsterWithName(species,level,nick);
        }
        return new MonsterBuilder().makeMonsterWithName(species,level);
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

    MoveBase pokeMovesID() throws FileNotFoundException {
        // TODO: 12/15/2021 REWORK THIS WHOLE METHOD based on move JSONs 
        System.out.println("What is the ID of your move?");
        int id = tbScan.nextInt();
        Move move = gson.fromJson(new FileReader("MoveJSONs/ID/"+ id+".json"),Move.class);
        MoveBuilder moveBuilder = new MoveBuilder();
        return moveBuilder.getMoveBase(move);
    }

    MoveBase pokeMovesName() throws FileNotFoundException {
        // TODO: 12/15/2021 REWORK THIS WHOLE METHOD based on move JSONs
        System.out.println("What is the ID of your move?");
        String name = tbScan.next().toLowerCase();
        Move move = gson.fromJson(new FileReader("MoveJSONs/NAME/"+ name+".json"),Move.class);
        MoveBuilder moveBuilder = new MoveBuilder();
        return moveBuilder.getMoveBase(move);
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


}
