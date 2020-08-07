public class Move {
    int power;
    int accuracy;
    String moveName;
    int type;
    int PP;

    Move(int power, int accuracy, int type, int PP, String moveName) {
        this.power = power;
        this.accuracy = accuracy;
        this.moveName = moveName;
        this.type = type;
        this.PP = PP;
    }

    @Override
    public String toString() {
        return "Move{" +
                "power=" + power +
                ", accuracy=" + accuracy +
                ", moveName='" + moveName + '\'' +
                ", type=" + type +
                '}';
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPower() {
        return power;
    }

    public void usePP() {
        PP = PP - 1;
    }

    public int getPP() {
        return PP;
    }

    public int getType() {
        return type;
    }

    public String getMoveName() {
        return moveName;
    }
}
