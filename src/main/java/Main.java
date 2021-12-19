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
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Launcher();
        launcher.Launch();
    }

}