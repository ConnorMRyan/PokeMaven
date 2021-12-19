package Utils;

import GSONClasses.Move.Move;
import GSONClasses.Pokemon.Pokemon;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    static APIParser apiParser = new APIParser();
    public static void saveMoves(int begining, int ending) throws Exception {
        for (int i = begining; i <= ending; i++) {
            FileWriter fw = new FileWriter(new File("MoveJSONs/ID/" + i + ".json"));
            fw.write(apiParser.getAMove("" + i));
            fw.flush();
            fw.close();
        }
    }
    public static void saveMonsters(int begining, int ending) throws Exception {
        for (int i = begining; i <= ending; i++) {
            FileWriter fw = new FileWriter(new File("PokemonJSONs\\ID\\" + i + ".json"));
            fw.write(apiParser.getAMonster("" + i));
            fw.flush();
            fw.close();
        }
    }

    public static  void  convertIDMoves()  {
        String location = "MoveJSONs/";
        try {
            convertAllIDJSONs(location,true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void convertIDMon(){
        String location = "PokemonJSONs/";
        try {
            convertAllIDJSONs(location,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void convertAllIDJSONs(String location,boolean isMoves) throws IOException {
        File folder = new File(location + "/ID");

        File[] listOfFiles = folder.listFiles();
        Gson gson = new Gson();

        assert listOfFiles != null;
        if (isMoves) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Move move = gson.fromJson(new FileReader(file), Move.class);
                    String name = move.getName();
                    FileWriter fw = new FileWriter(location + "/NAME/" + name + ".json");
                    fw.write(gson.toJson(move));
                    fw.flush();
                    fw.close();
                }
            }
        } else {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Pokemon mon = gson.fromJson(new FileReader(file), Pokemon.class);
                    String name = mon.getName();
                    FileWriter fw = new FileWriter(location + "/NAME/" + name + ".json");
                    fw.write(gson.toJson(mon));
                    fw.flush();
                    fw.close();
                }
            }
        }
    }
}
