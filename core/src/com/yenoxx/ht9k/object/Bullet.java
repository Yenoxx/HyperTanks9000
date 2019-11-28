package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Bullet extends Entity {
    private int team;

    public Bullet(Scene scene, float x, float y, float vx, float vy, int team,
                  ResourceManager resources) {
        super(scene, x, y, 8, 8, new Sprite(
                resources.getTextureRegion("bullet"), 0));

        setSolid(false);
        setIgnoring(true);

        setTeam(team);

        setVx(vx);
        setVy(vy);
    }

    @Override
    public void collide(GObject object) {
        if (object.getType().equals("tank")) {
            if (((Tank) object).getTeam() != getTeam()) {
                object.setDestroyed(true);
                getScene().addGObject(new Explosion(getScene(), object.getX(),
                        object.getY(), getScene().getResources()));
                setDestroyed(true);
            }
        }
        else {
            setDestroyed(true);
        }
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
