package src;

import java.util.Vector;

public class EnemyTank extends Tank {
<<<<<<< HEAD
public Vector<Shot> shots = new Vector<Shot>();
    public boolean isLive=true;
=======
    Vector<Shot> shots = new Vector<Shot>();
>>>>>>> b00dcf9 (Using thread to make enemy tank fire bullets)
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
