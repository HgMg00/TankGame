package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Game panel
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    MyTank myTank = null;
    Vector<EnemyTank> enemies = new Vector<>();

    Vector<Bomb> bombs = new Vector<>();

    int enemyTankNumber = 3;

    Image img1 = null;
    Image img2 = null;
    Image img3 = null;

    public MyPanel() {
        myTank = new MyTank(100, 100);

        for (int i = 0; i < enemyTankNumber; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
<<<<<<< HEAD
Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
=======
            Shot shot=new Shot(enemyTank.getX()+20, enemyTank.getY()+60, enemyTank.getDirection());
>>>>>>> b00dcf9 (Using thread to make enemy tank fire bullets)
            enemyTank.shots.add(shot);

            new Thread(shot).start();
            enemies.add(enemyTank);
        }

        img1 = Toolkit.getDefaultToolkit().getImage("src/imgBomb/bomb_1.gif");
        img2 = Toolkit.getDefaultToolkit().getImage("src/imgBomb/bomb_2.gif");
        img3 = Toolkit.getDefaultToolkit().getImage("src/imgBomb/bomb_3.gif");

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), 0);

        if (myTank.shot != null && myTank.shot.visible) {
            g.draw3DRect(myTank.getShotX(), myTank.getShotY(), 1, 1, false);
        }

        for (Bomb bomb : bombs) {
            if (bomb.life > 6) {
                g.drawImage(img1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(img2, bomb.x, bomb.y, 60, 60, this);
            } else
                g.drawImage(img3, bomb.x, bomb.y, 60, 60, this);

            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }


        for (EnemyTank enemyTank : enemies) {
<<<<<<< HEAD
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
                for (int i = 0; i < enemyTank.shots.size(); i++) {
                    Shot shot = enemyTank.shots.get(i);

                    if (shot.visible) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
=======
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
            for (int i = 0; i < enemyTank.shots.size(); i++) {
                Shot shot=enemyTank.shots.get(i);

                if (shot.visible){
                    g.draw3DRect(shot.x, shot.y, 1, 1, false);
                }else {
                    enemyTank.shots.remove(shot);
>>>>>>> b00dcf9 (Using thread to make enemy tank fire bullets)
                }
            }
        }
    }

    /**
     * @param x         x-coordinate
     * @param y         y-coordinate
     * @param g         the Graphics context in which to paint
     * @param direction Tank Direction
     * @param type      Tank Types (0 = my,  1 = enemy)
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.green);
                break;
            case 1:
                g.setColor(Color.pink);
                break;
        }

        //draw tank
        //0=up, 1=right, 2 =down, 3 = left
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }


    }

    //The bullet to hit the enemy tank.
    public void hitTank(Shot s, EnemyTank enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.visible = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 &&
                        s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.visible = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            myTank.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.moveDown();
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            myTank.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shotToEnemy();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Determine the bullet to hit the enemy tank.
            if (myTank.shot != null && myTank.shot.visible) {
                for (EnemyTank enemyTank : enemies) {
                    hitTank(myTank.shot, enemyTank);
                }
            }

            this.repaint();
        }
    }
}
