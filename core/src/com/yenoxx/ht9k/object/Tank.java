package com.yenoxx.ht9k.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Tank extends Entity {
    private int team;

    private float speed;

    public Tank(Scene scene, float x, float y, int team, TextureRegion t1, TextureRegion t2) {
        super(scene, x, y, 16, 16, new Sprite(
                t1, t2, 0.2f));

        setTeam(team);
        setSpeed(10);
    }

    @Override
    public void update(float dt) {
        if (getVy() > 0) {
            getSprite().setRotation(0);
            getSprite().setUt(0.2f);
        }
        else if (getVy() < 0) {
            getSprite().setRotation(180);
            getSprite().setUt(0.2f);
        }
        else if (getVx() > 0) {
            getSprite().setRotation(270);
            getSprite().setUt(0.2f);
        }
        else if (getVx() < 0) {
            getSprite().setRotation(90);
            getSprite().setUt(0.2f);
        }
        else {
            getSprite().setUt(0);
        }

        super.update(dt);
    }

    public int getTeam() {
        return team;
    }

    private void setTeam(int team) {
        this.team = team;
    }

    public float getSpeed() {
        return speed;
    }

    private void setSpeed(float speed) {
        this.speed = speed;
    }
}
