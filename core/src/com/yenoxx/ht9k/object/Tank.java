package com.yenoxx.ht9k.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Tank extends Entity {
    private static final float SPRITE_UT = 0.05f;

    private int team;

    private float speed;
    private float bulletSpeed;

    private int dir;

    private float cd;

    private Bullet bullet;

    public Tank(Scene scene, float x, float y, int team, TextureRegion t1, TextureRegion t2) {
        super(scene, x, y, 15.9f, 15.9f, new Sprite(
                t1, t2, SPRITE_UT));

        setSolid(true);
        setType("tank");
        setTeam(team);
        setSpeed(32);
        setBulletSpeed(48);

        setBullet(new Bullet(getScene(), 0, 0, 0, 0, getTeam(),
                getScene().getResources()));
        getBullet().setDestroyed(true);
    }

    @Override
    public void update(float dt) {
        if (getVy() > 0) {
            setDir(0);
            getSprite().setRotation(0);
            getSprite().setUt(SPRITE_UT);
        }
        else if (getVy() < 0) {
            setDir(2);
            getSprite().setRotation(180);
            getSprite().setUt(SPRITE_UT);
        }
        else if (getVx() > 0) {
            setDir(3);
            getSprite().setRotation(270);
            getSprite().setUt(SPRITE_UT);
        }
        else if (getVx() < 0) {
            setDir(1);
            getSprite().setRotation(90);
            getSprite().setUt(SPRITE_UT);
        }
        else {
            getSprite().setUt(0);
        }

        if (cd > 0) cd -= dt;

        super.update(dt);
    }

    public void shoot() {
        if (cd <= 0) {
            if (getBullet().isDestroyed()) {
                getBullet().setDestroyed(false);
                if (getDir() == 0) {
                    getBullet().setX(getX() + 4);
                    getBullet().setY(getY() + 12);
                    getBullet().setVx(0);
                    getBullet().setVy(getBulletSpeed());
                } else if (getDir() == 1) {
                    getBullet().setX(getX() + -4);
                    getBullet().setY(getY() + 4);
                    getBullet().setVx(-getBulletSpeed());
                    getBullet().setVy(0);
                } else if (getDir() == 2) {
                    getBullet().setX(getX() + 4);
                    getBullet().setY(getY() + -4);
                    getBullet().setVx(0);
                    getBullet().setVy(-getBulletSpeed());
                } else {
                    getBullet().setX(getX() + 12);
                    getBullet().setY(getY() + 4);
                    getBullet().setVx(getBulletSpeed());
                    getBullet().setVy(0);
                }
                getScene().addGObject(getBullet());
            }
            cd = 2;
        }
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(float bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
