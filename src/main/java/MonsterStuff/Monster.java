package MonsterStuff;

import ActionStuff.Move.MoveBase;

import java.util.ArrayList;

public class Monster {
  private final String NAME;
  private final String SPECIES;
  private final int TYPE_ONE; // MonsterStuff.Monster's primary type
  private final int TYPE_TWO; // Optional secondary type
  private final int LEVEL;
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
  //private final MonsterStuff.Status status;
  public boolean fainted;
  private final ArrayList<MoveBase> movesList = new ArrayList<>();

  /**
   * A constructor for monsters with a nickname.
   */
  public Monster(
          int HP,
          int ATK,
          int DEF,
          int SPC,
          int SPD,
          int TYPE_ONE,
          int TYPE_TWO,
          int LEVEL,
          String NICK_NAME,
          String SPECIES) {
    //status = new MonsterStuff.Status();
    this.LEVEL = LEVEL;
    this.TOTAL_HP = convertBaseStat(HP) + 5 + LEVEL;
    this.currentHp = convertBaseStat(HP) + 5 + LEVEL;
    this.ATK = convertBaseStat(ATK);
    this.DEF = convertBaseStat(DEF);
    this.SPC = convertBaseStat(SPC);
    this.SPD = convertBaseStat(SPD);
    this.TYPE_ONE = TYPE_ONE;
    this.TYPE_TWO = TYPE_TWO;
    this.NAME = NICK_NAME;
    this.SPECIES = SPECIES;
  }

  /**
   * This is a constructer for when monsters don't have a nickname, in retrospect I probably could
   * have combined these together and taken care of the nickname during creation.
   */
  public Monster(
          int HP,
          int ATK,
          int DEF,
          int SPC,
          int SPD,
          int TYPE_ONE,
          int TYPE_TWO,
          int LEVEL,
          String SPECIES) {
    //status = new MonsterStuff.Status();
    this.LEVEL = LEVEL;
    this.TOTAL_HP = convertBaseStat(HP) + 5 + LEVEL;
    this.currentHp = convertBaseStat(HP) + 5 + LEVEL;
    this.ATK = convertBaseStat(ATK);
    this.DEF = convertBaseStat(DEF);
    this.SPC = convertBaseStat(SPC);
    this.SPD = convertBaseStat(SPD);
    this.TYPE_ONE = TYPE_ONE;
    this.TYPE_TWO = TYPE_TWO;
    this.NAME = SPECIES;
    this.SPECIES = SPECIES;
  }

  public String toString() {
    return NAME + " is a level " + LEVEL + " " + SPECIES;
  }

  /**
   * Returns a modified stat based on the stat and a modifier from -6 to +6,
   *
   * @param statBase
   * @param statMod
   * @return
   */
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

  public void heal(int amountHeal) {
    this.currentHp = +amountHeal;

    if (currentHp > TOTAL_HP) {
      this.currentHp = TOTAL_HP;
    }

  }

  public void resetStatMods() {
    this.atkMod = 0;
    this.defMod = 0;
    this.spdMod = 0;
    this.spcMod = 0;
  }

  public void addMove(MoveBase pokeMove) {
    movesList.add(pokeMove);
  }

  public MoveBase getMove(int ID) {
    try {
      return movesList.get(ID);
    } catch (Exception e) {
      return movesList.get(0);
    }
  }

  public void printMoves() {
    for (MoveBase pokeMove : movesList) {
      System.out.println(pokeMove);
    }
  }

  public void takeDamage(int damage) {
    currentHp = currentHp - damage;
    if (currentHp <= 0) {
      currentHp = 0;
      fainted = true;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Monster) {
      return (((Monster) obj).ATK == this.ATK)
              && (((Monster) obj).DEF == this.DEF)
              && (((Monster) obj).SPC == this.SPC)
              && (((Monster) obj).SPD == this.SPD)
              && (((Monster) obj).TOTAL_HP == this.TOTAL_HP)
              && (((Monster) obj).SPECIES.equals(this.SPECIES));
    } else {
      return false;
    }
  }

  /**
   * Returns the correct base stats, currently assumes maximum IV and EV values, but may allow for
   * changed in the future.
   *
   * @param stat
   * @return
   */
  private int convertBaseStat(int stat) {
    return (((((stat + 15) * 2) + 63) * this.LEVEL) / 100) + 5;
  }



  /**
   * Various getters and setters
   */

  public String getNAME() {
    return NAME;
  }

  public String getSPECIES() {
    return SPECIES;
  }

  public int getType1() {
    return TYPE_ONE;
  }

  public int getType2() {
    return TYPE_TWO;
  }

  public int getLEVEL() {
    return LEVEL;
  }

  public int getTOTAL_HP() {
    return TOTAL_HP;
  }

  public int getCurrentHp() {
    return currentHp;
  }

  public void setCurrentHp(int currentHp) {
    this.currentHp = currentHp;
  }

  public int getATK() {
    return ATK;
  }

  public int getAtkMod() {
    return atkMod;
  }

  public void setAtkMod(int atkMod) {
    this.atkMod = atkMod;
  }

  public int getDEF() {
    return DEF;
  }

  public int getDefMod() {
    return defMod;
  }

  public void setDefMod(int defMod) {
    this.defMod = defMod;
  }

  public int getSPC() {
    return SPC;
  }

  public int getSpcMod() {
    return spcMod;
  }

  public void setSpcMod(int spcMod) {
    this.spcMod = spcMod;
  }

  public int getSPD() {
    return SPD;
  }

  public int getSpdMod() {
    return spdMod;
  }

  public void setSpdMod(int spdMod) {
    this.spdMod = spdMod;
  }

  public boolean isFainted() {
    return fainted;
  }

  public void setFainted(boolean fainted) {
    this.fainted = fainted;
  }

  public ArrayList<MoveBase> getMovesList() {
    return movesList;
  }
}
