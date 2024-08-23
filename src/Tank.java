package src;

/**
 * Class of Tank
 * x and y are coordinates
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed=2;
    boolean isLive=true;
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveUp() {
        this.y -= this.speed;
    }

    public void moveDown() {
        this.y += this.speed;
    }

    public void moveLeft() {
        this.x -= this.speed;
    }

    public void moveRight() {
        this.x += this.speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
