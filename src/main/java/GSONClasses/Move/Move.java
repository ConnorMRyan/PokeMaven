package GSONClasses.Move;

import GSONClasses.Game.Generation;
import GSONClasses.Game.VersionGroup;
import GSONClasses.NamedURL;
import GSONClasses.Pokemon.Type;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Move {
    @Expose
    int accuracy;
    @Expose
    ContestCombo contest_combos;
    @Expose
    URL contest_effect;
    @Expose
    NamedURL contest_type;
    @Expose
    NamedURL damage_class;
    @Expose
    int  effect_chance;
    @Expose
    List<NamedURL> effect_changes;
    @Expose
    List<EffectEntry> effect_entries;
    @Expose
    List<FlavorText> flavor_text_entries;
    @Expose
    NamedURL generation;
    @Expose
    int id;
    @Expose
    List<NamedURL> learned_by_pokemon;
    @Expose
    List<Machine> machines;
    @Expose
    MetaData meta;
    @Expose
    String name;
    @Expose
    List<OtherName> names;
    @Expose
    List<PastValue> past_values;
    @Expose
    int power;
    @Expose
    int pp;
    @Expose
    int priority;
    @Expose
    List<StatChange> stat_changes;
    @Expose
    URL super_contest_effect;
    @Expose
    NamedURL target;
    @Expose
    Type type;

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public ContestCombo getContest_combos() {
        return contest_combos;
    }

    public void setContest_combos(ContestCombo contest_combos) {
        this.contest_combos = contest_combos;
    }

    public URL getContest_effect() {
        return contest_effect;
    }

    public void setContest_effect(URL contest_effect) {
        this.contest_effect = contest_effect;
    }

    public NamedURL getContest_type() {
        return contest_type;
    }

    public void setContest_type(NamedURL contest_type) {
        this.contest_type = contest_type;
    }

    public NamedURL getDamage_class() {
        return damage_class;
    }

    public void setDamage_class(NamedURL damage_class) {
        this.damage_class = damage_class;
    }

    public int getEffect_chance() {
        return effect_chance;
    }

    public void setEffect_chance(int effect_chance) {
        this.effect_chance = effect_chance;
    }

    public List<NamedURL> getEffect_changes() {
        return effect_changes;
    }

    public void setEffect_changes(List<NamedURL> effect_changes) {
        this.effect_changes = effect_changes;
    }

    public List<EffectEntry> getEffect_entries() {
        return effect_entries;
    }

    public void setEffect_entries(List<EffectEntry> effect_entries) {
        this.effect_entries = effect_entries;
    }

    public List<FlavorText> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(List<FlavorText> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }

    public NamedURL getGeneration() {
        return generation;
    }

    public void setGeneration(NamedURL generation) {
        this.generation = generation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NamedURL> getLearned_by_pokemon() {
        return learned_by_pokemon;
    }

    public void setLearned_by_pokemon(List<NamedURL> learned_by_pokemon) {
        this.learned_by_pokemon = learned_by_pokemon;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OtherName> getNames() {
        return names;
    }

    public void setNames(List<OtherName> names) {
        this.names = names;
    }

    public List<PastValue> getPast_values() {
        return past_values;
    }

    public void setPast_values(List<PastValue> past_values) {
        this.past_values = past_values;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<StatChange> getStat_changes() {
        return stat_changes;
    }

    public void setStat_changes(List<StatChange> stat_changes) {
        this.stat_changes = stat_changes;
    }

    public URL getSuper_contest_effect() {
        return super_contest_effect;
    }

    public void setSuper_contest_effect(URL super_contest_effect) {
        this.super_contest_effect = super_contest_effect;
    }

    public NamedURL getTarget() {
        return target;
    }

    public void setTarget(NamedURL target) {
        this.target = target;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

class ContestEffect{
    String url;
}

class EffectEntry{
    String effect;
    NamedURL language;
    String short_effect;
}

class OtherName{
    NamedURL language;
    String name;
}

class FlavorText{
    String flavor_text;
    NamedURL language;
    NamedURL versionGroup;
}

class MetaData{
    int ailment_chance;
    int crit_rate;
    int drain;
    int flinch_chance;
    int healing;
    int stat_chance;
    NamedURL category;
    NamedURL  ailment;
    String name;
}

class StatChange{
    int change;
    NamedURL stat;
}



class PastValue{
    int accuracy;
    int effect_chance;
    List<EffectEntry> effect_entries;
    int power;
    int pp;
    NamedURL type;
    NamedURL version_group;
}

class Machine{
    URL machine;
    NamedURL version_group;
}


