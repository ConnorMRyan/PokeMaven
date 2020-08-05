public class Monster {
    private int TOTAL_HP; //Amount of health
    private int CURRENT_HP; // Amount of current health
    private int ATK; // Physical attacking power
    private int DEF; // Physical defensive power
    private int SPC; // Special attack and defense
    private int SPD; // Speed
    private int typeOne; // Monster's primary type
    private int typeTwo; // Optional secondary type
    private int level;
    private final Status status;

    Monster() {
        status = new Status();
    }

    public int basicAttack(int modifier, int attackPower, int defenderDEF, int attackType) {
        getModifier(attackType, 0);
        return (((((2 * level) / 5) + 2) * attackPower * (ATK / defenderDEF)) / 50 + 2) * modifier;
    }

    public int getModifier(int attackType, int crit) {
        return 0;
        //crit * random * STAB * type * status;
    }
}
