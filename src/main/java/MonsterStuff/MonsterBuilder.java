package MonsterStuff;

import GSONClasses.Pokemon.Pokemon;
import Utils.types;
import com.google.gson.Gson;

import java.io.*;

public class MonsterBuilder {

    public Monster makeMonsterWithID(String id) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/ID/"+id+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn,0,null);

    }

    public Monster makeMonsterWithID(String id, int Level) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/ID/"+id+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn,Level,null);

    }

    public Monster makeMonsterWithID(String id, int Level, String nick) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/ID/"+id+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn, Level, nick);

    }

    public Monster makeMonsterWithName(String name) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/ID/"+name+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn,0,null);

    }

    public Monster makeMonsterWithName(String name, int Level) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/ID/"+name+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn,Level,null);

    }

    public Monster makeMonsterWithName(String name, int Level, String nick) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/NAME/"+name+".json";
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        return makeMonster(pkmn, Level, nick);

    }

    private Monster makeMonster(Pokemon pkmn,int lvl, String Nick){
        int HP;
        int ATK;
        int DEF;
        int SPC;
        int SPD;
        int TypeOne;
        int TypeTwo;
        String species;
        HP = pkmn.getStats().get(0).getBase_stat();
        ATK = pkmn.getStats().get(1).getBase_stat();
        DEF = pkmn.getStats().get(2).getBase_stat();
        SPC = pkmn.getStats().get(3).getBase_stat();
        SPD = pkmn.getStats().get(4).getBase_stat();
        TypeOne = types.getType(pkmn.getTypes().get(0).getType().getName());
        TypeTwo = types.NO_TYPE;
        if(pkmn.getTypes().size() == 2) {
            TypeTwo = types.getType(pkmn.getTypes().get(0).getType().getName());
        }
        species = pkmn.getName();
        int level = (lvl < 1) ? lvl : 50;
        String nickName = (Nick != null) ? Nick : species;

        return new Monster(HP,ATK,DEF,SPC,SPD,TypeOne,TypeTwo,level,nickName,species);
    }




}
