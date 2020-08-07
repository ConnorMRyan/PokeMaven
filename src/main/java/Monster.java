import java.util.ArrayList;
import java.util.Random;

public class Monster {
    private final int TOTAL_HP; // Amount of health
    private int currentHp; // Amount of current health
    private final int ATK; // Physical attacking power
    private final int DEF; // Physical defensive power
    private final int SPC; // Special attack and defense
    private final int SPD; // Speed
    private final int TYPE_ONE; // Monster's primary type
    private final int TYPE_TWO; // Optional secondary type
    private final int LEVEL;
    public boolean fainted;
    private final Status status;
    private final String NAME;
    private final String FAMILY_NAME;
    private final ArrayList<Move> movesList = new ArrayList<Move>();

    Monster(int HP, int ATK, int DEF, int SPC, int SPD, int TYPE_ONE, int TYPE_TWO, int LEVEL, String NAME, String FAMILY_NAME) {
        status = new Status();
        this.LEVEL = LEVEL;
        this.TOTAL_HP = convertBaseStat(HP) + 5 + LEVEL;
        this.currentHp = convertBaseStat(HP) + 5 + LEVEL;
        this.ATK = convertBaseStat(ATK);
        this.DEF = convertBaseStat(DEF);
        this.SPC = convertBaseStat(SPC);
        this.SPD = convertBaseStat(SPD);
        this.TYPE_ONE = TYPE_ONE;
        this.TYPE_TWO = TYPE_TWO;
        this.NAME = NAME;
        this.FAMILY_NAME = FAMILY_NAME;


    }

    Monster(int HP, int ATK, int DEF, int SPC, int SPD, int TYPE_ONE, int TYPE_TWO, int LEVEL, String FAMILY_NAME) {
        status = new Status();
        this.LEVEL = LEVEL;
        this.TOTAL_HP = convertBaseStat(HP) + 5 + LEVEL;
        this.currentHp = convertBaseStat(HP) + 5 + LEVEL;
        this.ATK = convertBaseStat(ATK);
        this.DEF = convertBaseStat(DEF);
        this.SPC = convertBaseStat(SPC);
        this.SPD = convertBaseStat(SPD);
        this.TYPE_ONE = TYPE_ONE;
        this.TYPE_TWO = TYPE_TWO;
        this.NAME = FAMILY_NAME;
        this.FAMILY_NAME = FAMILY_NAME;


    }

    public String toString() {
        return NAME + " is a level " + LEVEL + " " + FAMILY_NAME;
    }

    public int basicAttack(Move move, Monster defender) {
        double modifier = getModifier(move.type, defender);
        int crit = 1;
        if (isACrit()) {
            System.out.println("Was a crit");
            crit = 2;
        }
        return (int)
                Math.round(
                        ((((((2 * LEVEL * crit) / 5.) + 2) * move.getPower() * (ATK / (double) defender.DEF)) / 50
                                + 2) * modifier));
    }

    public double getModifier(int attackType, Monster defender) {
        Random random = new Random();
        int val = random.nextInt(38);
        double STAB = 1;
        if (TYPE_ONE == attackType || TYPE_TWO == attackType) {
            STAB = 1.5;
        }
        return ((217 + val) / 255.)
                * STAB
                * types.TYPE_EFFECTIVNESS[attackType][defender.TYPE_ONE]
                * types.TYPE_EFFECTIVNESS[attackType][defender.TYPE_TWO];

    }

    private boolean isACrit() {
        int tVal = SPD / 2;
        Random random = new Random();
        int target = random.nextInt(256);
        int critNum = Math.min(255, tVal);
        return target < critNum;
    }

    public void addMove(Move move) {
        movesList.add(move);
    }

    public Move getMove(int ID) {
        return movesList.get(ID);
    }

    public void printMoves() {
        for (Move move : movesList) {
            System.out.println(move);
        }
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
        currentHp = currentHp - damage;
        if (currentHp <= 0) {
            currentHp = 0;
            fainted = true;
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Monster) {
            return (((Monster) obj).ATK == this.ATK) && (((Monster) obj).DEF == this.DEF)
                    && (((Monster) obj).SPC == this.SPC) && (((Monster) obj).SPD == this.SPD) && (((Monster) obj).TOTAL_HP == this.TOTAL_HP)
                    && (((Monster) obj).FAMILY_NAME.equals(this.FAMILY_NAME));
        } else {
            return false;
        }
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getLEVEL() {
        return LEVEL;
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

    public int getTYPE_ONE() {
        return TYPE_ONE;
    }

    public int getTYPE_TWO() {
        return TYPE_TWO;
    }

    public Status getStatus() {
        return status;
    }

    private int convertBaseStat(int stat) {
        return (((((stat + 15) * 2) + 63) * this.LEVEL) / 100) + 5;
    }
}
