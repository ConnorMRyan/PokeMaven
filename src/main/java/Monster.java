import java.util.Random;

public class Monster {
    private final int TOTAL_HP; // Amount of health
    private int CURRENT_HP; // Amount of current health
    private final int ATK; // Physical attacking power
    private final int DEF; // Physical defensive power
    private final int SPC; // Special attack and defense
    private final int SPD; // Speed
    private final int typeOne; // Monster's primary type
    private final int typeTwo; // Optional secondary type
    private final int level;
    public boolean fainted;
    private final Status status;

    Monster(int HP, int ATK, int DEF, int SPC, int SPD, int typeOne, int typeTwo, int level) {
        status = new Status();
        this.level = level;
        this.TOTAL_HP = convertBaseStat(HP) + 5 + level;
        this.CURRENT_HP = convertBaseStat(HP) + 5 + level;
        this.ATK = convertBaseStat(ATK);
        this.DEF = convertBaseStat(DEF);
        this.SPC = convertBaseStat(SPC);
        this.SPD = convertBaseStat(SPD);
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;

    }

    public int basicAttack(int attackPower, int attackType, Monster defender) {
        double modifier = getModifier(attackType, defender);
        int crit = 1;
        if (isACrit()) {
            System.out.println("Was a crit");
            crit = 2;
        }
        return (int)
                Math.round(
                        ((((((2 * level * crit) / 5.) + 2) * attackPower * (ATK / (double) defender.DEF)) / 50.
                                + 2) * modifier));
    }

    public double getModifier(int attackType, Monster defender) {
        Random random = new Random();
        int val = random.nextInt(38);
        double STAB = 1;
        if (typeOne == attackType || typeTwo == attackType) {
            STAB = 1.5;
        }
        return ((217 + val) / 255.)
                * STAB
                * types.TYPE_EFFECTIVNESS[attackType][defender.typeOne]
                * types.TYPE_EFFECTIVNESS[attackType][defender.typeTwo];
        //  * status;
    }

    private boolean isACrit() {
        int tVal = SPD / 2;
        Random random = new Random();
        int target = random.nextInt(256);
        int critNum = Math.min(255, tVal);
        return target < critNum;
    }

    private boolean isACrit(boolean highCritMove, boolean modifier) {
        int tVal = SPD / 2;
        if (modifier) {
            tVal = tVal / 2;
        }
        if (highCritMove) {
            tVal = tVal * 4;
        }
        Random random = new Random();
        int target = random.nextInt(256);
        int critNum = Math.min(255, tVal);
        return target > critNum;
    }

    void takeDamage(int damage) {
        CURRENT_HP = CURRENT_HP - damage;
        if (CURRENT_HP <= 0) {
            CURRENT_HP = 0;
            fainted = true;
        }
    }

    public int getCURRENT_HP() {
        return CURRENT_HP;
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getLevel() {
        return level;
    }

    public int getSPC() {
        return SPC;
    }

    public int getSPD() {
        return SPD;
    }

    public int getTOTAL_HP() {
        return TOTAL_HP;
    }

    public int getTypeOne() {
        return typeOne;
    }

    public int getTypeTwo() {
        return typeTwo;
    }

    public Status getStatus() {
        return status;
    }

    private int convertBaseStat(int stat) {
        return (((((stat + 15) * 2) + 63) * this.level) / 100) + 5;
    }
}
