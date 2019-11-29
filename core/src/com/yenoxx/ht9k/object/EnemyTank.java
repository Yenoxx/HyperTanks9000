package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.scene.Scene;

public class EnemyTank extends Tank {
    public static int count;
    public float turnCd;

    public EnemyTank(Scene scene, float x, float y, ResourceManager resources) {
        super(scene, x, y, 2, resources.getTextureRegion("tank21"),
                resources.getTextureRegion("tank22"));
        count++;

        turnCd = 0;

        setDir((int) Math.floor(Math.random() * 3));
    }

    @Override
    public void update(float dt) {
        if (getDir() == 0) {
            setVx(0);
            setVy(getSpeed());
        }
        else if (getDir() == 1) {
            setVx(-getSpeed());
            setVy(0);
        }
        else if (getDir() == 2) {
            setVx(0);
            setVy(-getSpeed());
        }
        else if (getDir() == 3) {
            setVx(getSpeed());
            setVy(0);
        }

        if (turnCd > 0) turnCd -= dt;

        shoot();

        super.update(dt);
    }

    @Override
    public void collide(GObject object) {
        if (turnCd <= 0) {
            if (object.getType().equals("wall") || object.getType().equals("tank")) {
                if (Math.random() < 0.5) setDir((getDir() + 1) % 4);
                else setDir((getDir() + 3) % 4);
            }
            turnCd = 0.5f;
        }
    }

    @Override
    public void onDestroy() {
        count--;
    }
}
