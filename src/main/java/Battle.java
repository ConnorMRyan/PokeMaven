import java.util.Collections;
import java.util.Scanner;

public class Battle {
  Team teamOne;
  Team teamTwo;
  Team activeTeam;
  Scanner in = new Scanner(System.in);

  Battle(Team teamOne, Team teamTwo) {
    this.teamOne = teamOne;
    this.activeTeam = teamOne;
    this.teamTwo = teamTwo;
    teamOne.setActiveMonster(teamOne.getMonster(0));
    teamTwo.setActiveMonster(teamTwo.getMonster(0));
  }

  boolean checkWon() {
    // check if both teams can continue, if they can the battle hasn't been won yet.
    return !(teamOne.canContinue() && teamTwo.canContinue());
  }

  void playerTurn() {
  }

  void changePokemon(Team team) {
    System.out.println("Which pokemon would you like to switch to?");
    for (int i = 0; i < team.numPokemon(); i++) {
      System.out.println("" + (i + 1) + ":- " + team.getMonster(i));
    }
    int num = in.nextInt() - 1;
    team.setActiveMonster(team.getMonster(num));
    Collections.swap(team.teamList, 0, num);
  }

  void printBattleMenu() {
    System.out.println("-_-_-Battle Menu-_-_-");
    System.out.println("1: Attack");
    System.out.println("2: Use item");
    System.out.println("3: Switch Pokemon");
    System.out.println("----------------------");
  }

  void displayAttacks() {
    System.out.println("--" + activeTeam.activeMonster.getNAME() + "--");
    System.out.println("------Moves-----");
    for (int i = 0; i < activeTeam.activeMonster.getMovesList().size(); i++) {
      System.out.println("" + (i + 1) + "- " + activeTeam.activeMonster.getMove(i));
    }
    System.out.println("----------------");
  }

  void switchActive() {
    if (activeTeam == teamOne) {
      activeTeam = teamTwo;
    }
    if (activeTeam == teamTwo) activeTeam = teamOne;
  }

  int getMenuItem(int menuMax) {
    Scanner in = new Scanner(System.in);
    int menuItem = in.nextInt();
    in.close();
    if (menuItem > 0 && menuItem < menuMax) {
      return menuItem - 1;
    }
    System.out.println("Sorry, not a valid input");
    return getMenuItem(menuMax);
  }
}
