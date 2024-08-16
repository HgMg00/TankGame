package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Game panel
 */
public class MyPanel extends JPanel implements KeyListener
{
    MyTank myTank=null;
    public MyPanel(){
        myTank = new MyTank(100,100);
        myTank.setSpeed(10);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(myTank.getX(),myTank.getY(),g,myTank.getDirection(),0);
    }

    /**
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param g the Graphics context in which to paint
     * @param direction Tank Direction
     * @param type Tank Types (0 = my,  1 = enemy)
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type){
        switch(type){
            case 0:
                g.setColor(Color.green);
                break;
            case 1:
                g.setColor(Color.red);
                break;
        }

        //draw tank
        //0=up, 1=right, 2 =down, 3 = left
        switch (direction){
            case 0:
                g.fill3DRect(x, y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1:
                g.fill3DRect(x, y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2:
                g.fill3DRect(x, y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3:
                g.fill3DRect(x, y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            myTank.setDirection(0);
            myTank.moveUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirection(1);
            myTank.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirection(2);
            myTank.moveDown();
        }

        if (e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirection(3);
            myTank.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
