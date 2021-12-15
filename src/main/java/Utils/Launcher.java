package Utils;

import GSONClasses.Item.BattleStuff.Battle;
import GSONClasses.Item.BattleStuff.Team;
import TeamStuff.TeamBuilder;
import TeamStuff.TeamParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public void Launch() {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1- Build a team");
        System.out.println("2- Have a single player battle");
        System.out.println("3- Have a multiplayer battle");
        System.out.println("4 - Quit");
        if (in.hasNextInt()) {
            int choice = in.nextInt();
            if (choice == 1) {
                TeamBuilder teamBuilder = new TeamBuilder();
                try {
                    teamBuilder.writeTeam();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (choice == 2) {
                singlePlayer();
            }
            if (choice == 3) {
                multiPlayer();
            }
        } else {
            in.close();
            System.out.println("Thanks for playing");
            System.exit(0);
        }
    }


    void singlePlayer() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Where is your trainer name located?");
            Team myTeam = TeamParser.makeTeam(in.next());
            System.out.println("Which opponent would you like to play?");
            Team oppTeam = TeamParser.makeTeam(in.next());
            new Battle(myTeam, oppTeam, true);
        } catch (FileNotFoundException e) {
            System.err.println("Sorry, something went wrong. ");
            singlePlayer();
        }
    }

    void multiPlayer() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Where is your trainer name located?");
            Team firstTeam = TeamParser.makeTeam(in.next());
            System.out.println("Which opponent would you like to play?");
            Team secTeam = TeamParser.makeTeam(in.next());
            new Battle(firstTeam, secTeam);
        } catch (FileNotFoundException e) {
            System.err.println("Sorry, something went wrong. ");
            singlePlayer();
        }

    }
}
