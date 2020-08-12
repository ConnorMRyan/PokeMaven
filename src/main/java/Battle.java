public class Battle {
    Team teamOne;
    Team teamTwo;

    Battle(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    boolean checkWon() {
        //check if both teams can continue, if they can the battle hasn't been won yet.
        return !(teamOne.canContinue() && teamTwo.canContinue());
    }

    void playerTurn() {

    }

    void changePokemon(Team team) {
        System.out.println("Which pokemon would you like to switch to?");
        for (int i = 0; i < team.numPokemon(); i++) {
            System.out.println("" + (i + 1) + team.getMonster(i));
        }

    }
}