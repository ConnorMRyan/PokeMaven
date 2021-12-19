package GSONClasses.Move;

import GSONClasses.NamedURL;

public class MetaData{
    int ailment_chance;
    int crit_rate;
    int drain;
    int flinch_chance;
    int healing;
    int stat_chance;
    NamedURL category;
    NamedURL  ailment;
    String name;

    public int getAilment_chance() {
        return ailment_chance;
    }

    public void setAilment_chance(int ailment_chance) {
        this.ailment_chance = ailment_chance;
    }

    public int getCrit_rate() {
        return crit_rate;
    }

    public void setCrit_rate(int crit_rate) {
        this.crit_rate = crit_rate;
    }

    public int getDrain() {
        return drain;
    }

    public void setDrain(int drain) {
        this.drain = drain;
    }

    public int getFlinch_chance() {
        return flinch_chance;
    }

    public void setFlinch_chance(int flinch_chance) {
        this.flinch_chance = flinch_chance;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getStat_chance() {
        return stat_chance;
    }

    public void setStat_chance(int stat_chance) {
        this.stat_chance = stat_chance;
    }

    public NamedURL getCategory() {
        return category;
    }

    public void setCategory(NamedURL category) {
        this.category = category;
    }

    public NamedURL getAilment() {
        return ailment;
    }

    public void setAilment(NamedURL ailment) {
        this.ailment = ailment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

