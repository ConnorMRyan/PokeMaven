package TeamStuff;

import ActionStuff.Move.BattleMove;
import ActionStuff.Move.StatusBoostMove;
import BattleStuff.Team;
import MonsterStuff.Monster;
import Utils.DatabaseConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Takes in and creates a new team from a File

public class TeamParser {
    public static Team makeTeam(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        DatabaseConnection db = new DatabaseConnection();
        String teamName = in.nextLine();
        Team team = new Team(teamName);
        int numPokemon = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numPokemon; i++) {
            int numMoves = in.nextInt();
            in.nextLine();
            String pokeString = in.nextLine();
            Scanner pokeScanner = new Scanner(pokeString);
            pokeScanner.useDelimiter(",");
            String name = pokeScanner.next();
            int level = pokeScanner.nextInt();
            if (pokeScanner.hasNext()) {
                String nick = pokeScanner.next();
                Monster monster = db.makeAMonster(name, level, nick);
                getMove(in, team, numMoves, monster);
            } else {
                Monster monster = db.makeAMonster(name, level);
                getMove(in, team, numMoves, monster);
            }
            pokeScanner.close();
        }
        in.close();
        return team;
    }

    private static void getMove(Scanner in, Team team, int numMoves, Monster monster) {
        for (int j = 0; j < numMoves; j++) {
            int moveType = in.nextInt();
            in.nextLine();
            String moveString = in.nextLine();
            if (moveType == 0) {
                monster.addMove(new BattleMove(moveString));
            }
            if (moveType == 2) {
                monster.addMove(new StatusBoostMove(moveString));
            }
        }

        team.addMonster(monster);
    }

    static void saveTeam(Team team) {

    }
}
