import java.util.Random;
import java.util.Scanner;

public class Battle {
  final int BATTLE_MENU_MAX = 3;
  Team teamOne;
  Team teamTwo;
  Team activeTeam;
  Scanner in = new Scanner(System.in);
  int activeID = 1;
  Team inactiveTeam;

  Battle(Team teamOne, Team teamTwo) {
    this.teamOne = teamOne;
    this.activeTeam = teamOne;
    this.teamTwo = teamTwo;
    this.inactiveTeam = teamTwo;
    teamOne.setActiveMonster(teamOne.getMonster(0));
    teamTwo.setActiveMonster(teamTwo.getMonster(0));
    while (!checkWon()) {
      BattleAction playerOne = battleTurn();
      switchActive();
      BattleAction playerTwo = battleTurn();
      switchActive();
      if (playerOne.getPriority() >= playerTwo.getPriority()) {
        playerOne.execute(activeTeam.activeMonster, inactiveTeam.activeMonster);
        switchActive();
        playerTwo.execute(activeTeam.activeMonster, inactiveTeam.activeMonster);
        switchActive();
      }

    }
    if (teamOne.canContinue()) {
      System.out.println(teamOne.trainerName + " Won!");
    }
    if (teamOne.canContinue()) {
      // System.out.println(teamTwo.trainerName + "Won!");
    }
  }

  Battle(Team teamOne, Team teamTwo, Boolean multiplayer) {
    this.teamOne = teamOne;
    this.activeTeam = teamOne;
    this.teamTwo = teamTwo;
    this.inactiveTeam = teamTwo;
    teamOne.setActiveMonster(teamOne.getMonster(0));
    teamTwo.setActiveMonster(teamTwo.getMonster(0));
    while (!checkWon()) {
      BattleAction ba = battleTurn();
      Random rand = new Random();
      MoveBase moveToUse = teamTwo.activeMonster.getMove(rand.nextInt(activeTeam.activeMonster.getMovesList().size() - 1));
      if (ba.getPriority() >= moveToUse.getPriority()) {
        ba.execute(activeTeam.activeMonster, inactiveTeam.activeMonster);
        if (!inactiveTeam.activeMonster.fainted) {
          moveToUse.execute(inactiveTeam.activeMonster, activeTeam.activeMonster);
        } else {
          inactiveTeam.setActiveMonster(inactiveTeam.getMonster(1));
        }
        displayHP(teamOne.activeMonster);
        displayHP(teamTwo.activeMonster);
      }

    }
    if (teamOne.canContinue()) {
      System.out.println(teamOne.trainerName + " Won!");
    }
    if (teamOne.canContinue()) {
      // System.out.println(teamTwo.trainerName + "Won!");
    }


  }

  boolean checkWon() {
    // check if both teams can continue, if they can the battle hasn't been won yet.
    return !(teamOne.canContinue() && teamTwo.canContinue());
  }

  void playerTurn() {
  }

  SwitchMonster changePokemon(Team team) {
    System.out.println("Which pokemon would you like to switch to?");
    for (int i = 0; i < team.numPokemon(); i++) {
      System.out.println("" + (i + 1) + ":- " + team.getMonster(i));
    }
    int num = in.nextInt() - 1;
    return new SwitchMonster(team, num);
  }

  void printBattleMenu() {
    System.out.println("-_-_-Battle Menu-_-_-");
    System.out.println("1: Attack");
    System.out.println("2: Use item");
    System.out.println("3: Switch Pokemon");
    System.out.println("----------------------");
  }

  void displayHP(Monster monster) {
    System.out.println("--" + monster.getNAME() + "--");
    System.out.println(
            ""
                    + monster.getCurrentHp()
                    + " HP out of "
                    + monster.getTOTAL_HP()
                    + "HP");
    System.out.println("-------------------");

  }

  void displayAttacks() {
    System.out.println("------Moves-----");
    for (int i = 0; i < activeTeam.activeMonster.getMovesList().size(); i++) {
      System.out.println("" + (i + 1) + "- " + activeTeam.activeMonster.getMove(i) + " Has " + activeTeam.activeMonster.getMove(i).getPP() + " PP out of " + activeTeam.activeMonster.getMove(i).getMaxPP());
    }
    System.out.println("----------------");
  }

  void switchActive() {
    if (activeID == 1) {
      activeID = 2;
      activeTeam = teamTwo;
      inactiveTeam = teamOne;
    } else {
      activeID = 1;
      activeTeam = teamOne;
      inactiveTeam = teamTwo;
    }
  }

  //int getMenuItem(int menuMax) {
  // if (menuItem > 0 && menuItem < menuMax) {
  // return menuItem - 1;
  // }
  // System.out.println("Sorry, not a valid input");
  // return getMenuItem(menuMax);
  // }

  BattleAction battleTurn() {
    printBattleMenu();
    int choice = in.nextInt() - 1;
    if (choice == 0) {
      displayAttacks();
      return getMove();
    }
    if (choice == 1) {
      // todo implement items, if time allows.
      System.out.println("Sorry, items not yet implemented");
    }
    if (choice == 2) {
      return changePokemon(activeTeam);
    }
    return null;
  }

  void displayActivePokemon() {
  }

  MoveBase getMove() {
    int moveNum = in.nextInt() - 1;
    return activeTeam
            .activeMonster
            .getMove(moveNum);

  }
}
