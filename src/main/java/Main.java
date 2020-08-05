public class Main {
    public static void main(String[] args) {
        System.out.println("Fire is " + superEffective(types.FIRE, types.WATER) + " against Water");
        System.out.println("Water is " + superEffective(types.WATER, types.FIRE) + " against Fire");
        System.out.println("Ice is " + superEffective(types.ICE, types.DRAGON) + " against Dragon");
        System.out.println("Electric is " + superEffective(types.ELECTRIC, types.FLYING) + " against Flying");
        System.out.println("Ghost is " + superEffective(types.GHOST, types.PSYCHIC) + " against Psychic");

    }

    static String superEffective(int typeOne, int typeTwo) {
        double effectiveness = types.TYPE_EFFECTIVNESS[typeOne][typeTwo];
        if (effectiveness == 0) {
            return "not effective";
        } else if (effectiveness == .5) {
            return "not very effective";
        } else if (effectiveness == 1) {
            return "normally effective";
        } else if (effectiveness == 2) {
            return "super effective!";
        } else {
            return "something broke";
        }
    }
}
