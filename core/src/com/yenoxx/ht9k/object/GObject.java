package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.Dynamic;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class GObject implements Dynamic {
    Scene scene;

    private float x;
    private float y;
    private float w;
    private float h;

    private float vx;
    private float vy;

    private boolean destroyed;

    private boolean solid;
    private boolean ignoring;

    private String type;

    private Sprite sprite;

    public GObject(Scene scene, float x, float y, float w, float h, Sprite sprite) {
        setScene(scene);

        setX(x);
        setY(y);
        setW(w);
        setH(h);

        setVx(0);
        setVy(0);

        setDestroyed(false);

        setSolid(true);
        setIgnoring(false);

        setType("object");

        setSprite(sprite);
    }

    @Override
    public void update(float dt) {}

    public void collide(GObject object) {}

    public boolean isCollided(float ox, float oy, GObject object) {
        return
                getX() + ox + getW() > object.getX() &&
                getX() + ox < object.getX() + object.getW() &&
                getY() + oy + getH()> object.getY() &&
                getY() + oy < object.getY() + object.getH();
    }

    public void onDestroy() {}

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean isIgnoring() {
        return ignoring;
    }

    public void setIgnoring(boolean ignoring) {
        this.ignoring = ignoring;
    }
}
