package src;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    public Vector<Shot> shots = new Vector<Shot>();
    public boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            if (isLive && shots.isEmpty()) {
                Shot shot = null;
                switch (getDirection()) {
                    case 0:
                        shot = new Shot(getX() + 20, getY(), getDirection());
                        break;
                    case 1:
                        shot = new Shot(getX() + 60, getY() + 20, getDirection());
                        break;
                    case 2:
                        shot = new Shot(getX() + 20, getY() + 60, getDirection());
                        break;
                    case 3:
                        shot = new Shot(getX(), getY() + 20, getDirection());
                        break;
                }
                shots.add(shot);
                new Thread(shot).start();
            }

            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0)
                            moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000)
                            moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750)
                            moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0)
                            moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            setDirection((int) (Math.random() * 4));

            if (!isLive)
                break;
        }
    }
}
