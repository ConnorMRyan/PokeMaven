import GUIStuff.PokePanel;
import MonsterStuff.Monster;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, LifecycleException, ServletException {
        JFrame jFrame = new JFrame();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        PokePanel trainerPanel = new PokePanel(new Monster(5, 5, 5, 5, 5, 5, 5, 5, "Blep", "Bulb"));
        trainerPanel.createPokeImage(
                "src/main/resources/Lapras.jpg");
        PokePanel oppPanel = new PokePanel(new Monster(5, 5, 5, 5, 5, 5, 5, 5, "Saur"));
        oppPanel.createPokeImage("src/main/resources/wartortle.jpg");
        oppPanel.createTextBox();
        trainerPanel.createTextBox();
        topPanel.add(trainerPanel, Component.LEFT_ALIGNMENT);
        topPanel.add(oppPanel, Component.RIGHT_ALIGNMENT);
        jFrame.add(topPanel);


        jFrame.setVisible(true);
        jFrame.setSize(new Dimension(625, 350));
    }
}