package src;

import java.util.Vector;

public class EnemyTank extends Tank {
public Vector<Shot> shots = new Vector<Shot>();
    public boolean isLive=true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
