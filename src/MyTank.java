package src;

/**
 * Class of MyTank
 */
public class MyTank extends Tank {
    private Shot shot = null;

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shotToEnemy() {
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

        new Thread(shot).start();
    }

    public boolean shotOn (){
        return shot != null && shot.visible;
    }

    public int getShotX() {
        return shot.x;
    }
    public int getShotY() {
        return shot.y;
    }
}
