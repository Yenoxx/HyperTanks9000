package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.Utils;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Entity extends GObject {
    public Entity(Scene scene, float x, float y, float w, float h, Sprite sprite) {
        super(scene, x, y, w, h, sprite);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        getSprite().update(dt);

        boolean stopX = false;
        boolean stopY = false;

        for (GObject other : getScene().getObjects()) {
            if (!equals(other)) {
                if (isCollided(getVx() * dt, 0, other)) {
                    if (!isIgnoring() && other.isSolid()) {
                        while (!isCollided(0.01f * Utils.sign(getVx()),
                                0, other)) {
                            setX(getX() + 0.01f * Utils.sign(getVx()));
                        }
                        stopX = true;
                    }
                    collide(other);
                    other.collide(this);
                }
                if (isCollided(0, getVy() * dt, other)) {
                    if (!isIgnoring() && other.isSolid()) {
                        while (!isCollided(0,
                                0.01f * Utils.sign(getVy()), other)) {
                            setY(getY() + 0.01f * Utils.sign(getVy()));
                        }
                        stopY = true;
                    }
                    collide(other);
                    other.collide(this);
                }
            }
        }

        if (!stopX) {
            setX(getX() + getVx() * dt);
        }
        if (!stopY) {
            setY(getY() + getVy() * dt);
        }
    }
}
