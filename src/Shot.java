package src;


public class Shot implements Runnable {

    int x;
    int y;
    int speed = 2;
    int direct = 0;
    boolean visible = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //0=up, 1=right, 2 =down, 3 = left
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && visible)) {
                visible = false;
                break;
            }

        }
    }
}
