public class Main {
    public static void main(String[] args) {
        System.out.println("charmander used tackle on squirtle");
        System.out.println("normal is " + superEffective(types.FIRE, types.WATER) + " against Water");

        Monster charmander = new Monster(39, 52, 43, 50, 65, types.FIRE, types.NO_TYPE, 5);
        Monster squirtle = new Monster(44, 48, 65, 50, 43, types.WATER, types.NO_TYPE, 5);

        System.out.println("Attack " + squirtle.getATK() + " Def  " + squirtle.getDEF());

        int damage = charmander.basicAttack(35, types.NORMAL, squirtle);
        squirtle.takeDamage(damage);
        System.out.println("Charmander dealt " + damage + " damage");
        System.out.println("Squirtle has " + squirtle.getCURRENT_HP() + " out of " + squirtle.getTOTAL_HP());

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
