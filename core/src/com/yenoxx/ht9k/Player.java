package com.yenoxx.ht9k;

import com.yenoxx.ht9k.object.EnemyTank;
import com.yenoxx.ht9k.object.Tank;

public class Player {
    private Tank tank;

    public Player(Tank tank) {
        setTank(tank);
    }

    public void updateState(boolean up, boolean down, boolean left, boolean right, boolean fire) {
        if (up) {
            getTank().setVy(getTank().getSpeed());
        }
        else if (down) {
            getTank().setVy(-getTank().getSpeed());
        }
        else if (left) {
            getTank().setVx(-getTank().getSpeed());
        }
        else if (right) {
            getTank().setVx(getTank().getSpeed());
        }
        else if (fire) {
            getTank().shoot();
        }
        else  {
            getTank().setVx(0);
            getTank().setVy(0);
        }

        if (EnemyTank.count <= 0) System.out.println("Win");
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
