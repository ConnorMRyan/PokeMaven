package TeamStuff;

import ActionStuff.Move.BattleMove;
import ActionStuff.Move.MoveBase;
import ActionStuff.Move.StatusBoostMove;
import BattleStuff.Team;
import GSONClasses.Deserializers.MoveBaseAdapter;
import MonsterStuff.Monster;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// Takes in and creates a new team from a File

public class TeamParser {
    public static Team makeTeam(String trainerName) throws FileNotFoundException {
        String file = "Teams/"+trainerName+".json";
        Gson gson = new GsonBuilder().registerTypeAdapter(MoveBase.class, new MoveBaseAdapter())
                .create();
        return gson.fromJson(new FileReader(file),Team.class);

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
