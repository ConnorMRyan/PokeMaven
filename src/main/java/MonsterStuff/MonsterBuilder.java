package MonsterStuff;

import GSONClasses.Pokemon;
import GSONClasses.Species;
import GSONClasses.Type;
import Utils.types;
import com.google.gson.Gson;
import okhttp3.ResponseBody;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MonsterBuilder {

    public Monster makeMonsterWithAPI(String id) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/"+id+".json";
        System.out.println(path);
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
        int HP;
        int ATK;
        int DEF;
        int SPC;
        int SPD;
        int TypeOne;
        int TypeTwo;
        int Level;
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
        Level = 50;
        species = pkmn.getName();
        return new Monster(HP,ATK,DEF,SPC,SPD,TypeOne,TypeTwo,Level,species);
    }

    public Monster makeMonsterWithAPI(String id,int Level) throws IOException {
        String path = "C:/Users/mynam/IdeaProjects/PokeMaven/PokemonJSONs/"+id+".json";
        System.out.println(path);
        Pokemon pkmn = new Gson().fromJson(new FileReader(new File(path)),Pokemon.class);
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
        return new Monster(HP,ATK,DEF,SPC,SPD,TypeOne,TypeTwo,Level,species);
    }



}
