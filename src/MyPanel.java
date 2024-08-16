package src;

import javax.swing.*;
import java.awt.*;

/**
 * Game panel
 */
public class MyPanel extends JPanel
{
    MyTank myTank=null;
    public MyPanel(){
        myTank = new MyTank(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
    }
}
