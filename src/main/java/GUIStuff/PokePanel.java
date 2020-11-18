package GUIStuff;

import MonsterStuff.Monster;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PokePanel extends JPanel {
    private final Monster monster;
    private final int maxHP;
    private final int currentHP;
    private final String nickName;
    private final int level;
    private int id;

    public PokePanel(Monster monster) {
        this.monster = monster;
        maxHP = monster.getTOTAL_HP();
        currentHP = monster.getCurrentHp();
        nickName = monster.getNAME();
        level = monster.getLEVEL();

    }

    public void createPokeImage(String path) throws IOException {
        Image pokeImage = ImageIO.read(new File(path)).getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        JLabel picture = new JLabel(new ImageIcon(pokeImage));
        this.add(picture, RIGHT_ALIGNMENT);
    }

    public void createTextBox() {
        JTextArea pokeText = new JTextArea(3, 12);
        pokeText.setText(pokeString());
        pokeText.setEditable(false);
        pokeText.setVisible(true);
        this.add(pokeText, LEFT_ALIGNMENT);
    }

    public void updateTextBox() {

    }

    private String pokeString() {
        return "--" + nickName + "--" + "\n" +
                "lvl: " + level + "\n" +
                currentHP + " / " + maxHP + "\n";
    }
}
