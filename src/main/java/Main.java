import ActionStuff.Move.BattleMove;
import GSONClasses.Move.Move;
import GUIStuff.PokePanel;
import MonsterStuff.Monster;
import MonsterStuff.MonsterBuilder;
import Utils.APIParser;
import Utils.FileCreator;
import Utils.Launcher;
import com.google.gson.Gson;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        File folder = new File("MoveJSONs/ID/");
        File[] listOfFiles = folder.listFiles();
        Gson gson = new Gson();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.toString());
                Move move = gson.fromJson(new FileReader(file),Move.class);
                String name = move.getName();
                FileWriter fw = new FileWriter("C:\\Users\\mynam\\IdeaProjects\\PokeMaven\\MoveJSONs\\NAME\\"+name+".json");
                fw.write(gson.toJson(move));
                fw.flush();
                fw.close();
            }
        }


    }

}