package ActionStuff.Move;

import GSONClasses.Move.Move;
import Utils.types;

public class MoveBuilder {

    int findMoveType(String cat) {
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
                return 4;
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

    public MoveBase getMoveBase(Move move){
        int moveType = findMoveType(move.getMeta().getCategory().getName());

        switch (moveType) {
            case (0):
                int power = move.getPower();
                int accuracy = move.getAccuracy();
                int type = types.getType(move.getType().getName());
                int PP = move.getPp();
                String moveName = move.getName();

                return new BattleMove(power,accuracy,type,PP,moveName);
            case (1):
                return null;
            case (2):
                return null;
            case (3):
                return null;
            case (4):
                return null;
            case (5):
                return null;
            case (6):
                return null;
            case (7):
                return null;
            case (8):
                return null;
            case (9):
                return null;
            case (10):
                return null;
            case (11):
                return null;
            case (12):
                return null;
            case (13):
                return null;
            default:
                return null;
        }
    }
}
