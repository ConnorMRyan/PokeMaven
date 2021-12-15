package GSONClasses.Pokemon;

import GSONClasses.Game.GameIndex;
import GSONClasses.Item.HeldItem;
import GSONClasses.Move.MetaMove;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Pokemon {
    List<Ability> abilities;
    int base_experience;
    List<Form> forms;
    List<GameIndex> game_indices;
    @Expose
    int height;
    List<HeldItem> held_items;
    @Expose
    int id;
    boolean is_default;
    String location_area_ecouncters;
    List<MetaMove> metaMoves;
    @Expose
    String name;
    int order;
    List<String> past_types;
    Species species;
    @Expose
    Sprite sprites;
    @Expose
    List<MetaStat> stats;
    @Expose
    List<MetaType> types;
    @Expose
    int weight;

    Pokemon() {
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGame_indices() {
        return game_indices;
    }

    public void setGame_indices(List<GameIndex> game_indices) {
        this.game_indices = game_indices;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<HeldItem> getHeld_items() {
        return held_items;
    }

    public void setHeld_items(List<HeldItem> held_items) {
        this.held_items = held_items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public String getLocation_area_ecouncters() {
        return location_area_ecouncters;
    }

    public void setLocation_area_ecouncters(String location_area_ecouncters) {
        this.location_area_ecouncters = location_area_ecouncters;
    }

    public List<MetaMove> getMoves() {
        return metaMoves;
    }

    public void setMoves(List<MetaMove> metaMoves) {
        this.metaMoves = metaMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<String> getPast_types() {
        return past_types;
    }

    public void setPast_types(List<String> past_types) {
        this.past_types = past_types;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<MetaStat> getStats() {
        return stats;
    }

    public void setStats(List<MetaStat> stats) {
        this.stats = stats;
    }

    public List<MetaType> getTypes() {
        return types;
    }

    public void setTypes(List<MetaType> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}


