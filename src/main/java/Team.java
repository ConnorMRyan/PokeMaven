import java.util.ArrayList;

public class Team {
    String trainerName;
    ArrayList<Monster> teamList = new ArrayList<Monster>();

    Team(String trainerName) {
        this.trainerName = trainerName;

    }

    void addMonster(Monster monster) {
        if (teamList.size() <= 6) {
            this.teamList.add(monster);
        } else {
            System.err.println("You can only have 6 pokemon");
        }
    }

    void removeMonster(int ID) {
        teamList.remove(ID);
    }
}
