package GSONClasses.Pokemon;

import com.google.gson.annotations.Expose;

public class MetaStat {
    @Expose
    int base_stat;
    int effort;
    @Expose
    Stat stat;

    public MetaStat() {
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
