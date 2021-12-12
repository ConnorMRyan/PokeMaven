import GUIStuff.PokePanel;
import MonsterStuff.Monster;
import MonsterStuff.MonsterBuilder;
import Utils.APIParser;
import Utils.Launcher;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        MonsterBuilder mb = new MonsterBuilder();
        Monster monster = mb.makeMonsterWithAPI("1",5);
        System.out.print(monster);

    }
}