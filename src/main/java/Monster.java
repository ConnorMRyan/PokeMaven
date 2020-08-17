import java.util.*;

public class Monster {
  private final int TOTAL_HP; // Amount of health
  private int currentHp; // Amount of current health
  private final int ATK; // Physical attacking power
  private int atkMod = 0;
  private final int DEF; // Physical defensive power
  private int defMod = 0;
  private final int SPC; // Special attack and defense
  private int spcMod = 0;
  private final int SPD; // Speed
  private int spdMod = 0;
  private final int TYPE_ONE; // Monster's primary type
  private final int TYPE_TWO; // Optional secondary type
  private final int LEVEL;
  private final Status status;
  private final String NAME;
  private final String FAMILY_NAME;
  private final ArrayList<MoveBase> movesList = new ArrayList<>();
  public boolean fainted;

  Monster(
          int HP,
          int ATK,
          int DEF,
          int SPC,
          int SPD,
          int TYPE_ONE,
          int TYPE_TWO,
          int LEVEL,
          String NAME,
          String FAMILY_NAME) {
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

  Monster(
          int HP,
          int ATK,
          int DEF,
          int SPC,
          int SPD,
          int TYPE_ONE,
          int TYPE_TWO,
          int LEVEL,
          String FAMILY_NAME) {
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


  public int getType1() {
    return TYPE_ONE;
  }

  public int getType2() {
    return TYPE_TWO;
  }


  public void addMove(MoveBase pokeMove) {
    movesList.add(pokeMove);
  }

  public MoveBase getMove(int ID) {
    return movesList.get(ID);
  }

  public void printMoves() {
    for (MoveBase pokeMove : movesList) {
      System.out.println(pokeMove);
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
      return (((Monster) obj).ATK == this.ATK)
              && (((Monster) obj).DEF == this.DEF)
              && (((Monster) obj).SPC == this.SPC)
              && (((Monster) obj).SPD == this.SPD)
              && (((Monster) obj).TOTAL_HP == this.TOTAL_HP)
              && (((Monster) obj).FAMILY_NAME.equals(this.FAMILY_NAME));
    } else {
      return false;
    }
  }

  public int getATK() {
    return getStat(ATK, atkMod);
  }

  public int getAtkMod() {
    return atkMod;
  }

  public void setAtkMod(int atkMod) {
    this.atkMod = atkMod;
  }

  public int getDEF() {
    return getStat(DEF, defMod);
  }

  public int getDefMod() {
    return defMod;
  }

  public void setDefMod(int defMod) {
    this.defMod = defMod;
  }

  public int getSPC() {
    return getStat(SPC, spcMod);
  }

  public int getSpcMod() {
    return spcMod;
  }

  public void setSpcMod(int spcMod) {
    this.spcMod = spcMod;
  }

  public int getSPD() {
    return getStat(SPD, spdMod);
  }

  public int getSpdMod() {
    return spdMod;
  }

  public void setSpdMod(int spdMod) {
    this.spdMod = spdMod;
  }

  public int getLEVEL() {
    return LEVEL;
  }

  public int getTOTAL_HP() {
    return TOTAL_HP;
  }

  public Status getStatus() {
    return status;
  }

  public ArrayList<MoveBase> getMovesList() {
    return movesList;
  }

  private int convertBaseStat(int stat) {
    return (((((stat + 15) * 2) + 63) * this.LEVEL) / 100) + 5;
  }

  public int getStat(int statBase, int statMod) {
    switch (statMod) {
      case -6:
        return (statBase * 25) / 100;
      case -5:
        return (statBase * 28) / 100;
      case -4:
        return (statBase * 33) / 100;
      case -3:
        return (statBase * 40) / 100;
      case -2:
        return (statBase * 50) / 100;
      case -1:
        return (statBase * 66) / 100;

      case 1:
        return (statBase * 150) / 100;
      case 2:
        return (statBase * 200) / 100;
      case 3:
        return (statBase * 250) / 100;
      case 4:
        return (statBase * 300) / 100;
      case 5:
        return (statBase * 350) / 100;
      case 6:
        return (statBase * 400) / 100;
      default:
        return statBase;
    }
  }
}
