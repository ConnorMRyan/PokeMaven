import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Takes in and creates a new team from a File

public class TeamParser {
    static Team makeTeam(File file) throws FileNotFoundException {
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
                for (int j = 0; j < numMoves; j++) {
                    String moveString = in.nextLine();
                    Scanner moveScan = new Scanner(moveString);
                    moveScan.useDelimiter(",");
                    monster.addMove(
                            new BattleMove(
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.next()));
                }
                team.addMonster(monster);
            } else {
                Monster monster = db.makeAMonster(name, level);
                for (int j = 0; j < numMoves; j++) {
                    String moveString = in.next();
                    Scanner moveScan = new Scanner(moveString);
                    moveScan.useDelimiter(",");
                    monster.addMove(
                            new BattleMove(
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.nextInt(),
                                    moveScan.next()));
                }
                team.addMonster(monster);
            }
            pokeScanner.close();
        }
        in.close();
        return team;
    }

    static void saveTeam(Team team) {

    }
}
