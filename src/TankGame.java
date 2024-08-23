package src;

import javax.swing.*;

public class TankGame extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    public TankGame() {
        myPanel = new MyPanel();
        new Thread(myPanel).start();
        this.add(myPanel);
        this.setTitle("src.Tank Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 950);
        this.setVisible(true);
        this.addKeyListener(myPanel);
    }
}
