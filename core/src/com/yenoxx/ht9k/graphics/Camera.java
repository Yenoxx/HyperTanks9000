package com.yenoxx.ht9k.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yenoxx.ht9k.Drawable;
import com.yenoxx.ht9k.object.GObject;
import com.yenoxx.ht9k.scene.Scene;

public class Camera implements Drawable {
    private float x;
    private float y;

    private Scene scene;

    public Camera(Scene scene) {
        setX(0);
        setY(0);

        setScene(scene);
    }

    @Override
    public void draw(SpriteBatch batch, float x, float y, float scale) {
        for (GObject object : getScene().getBackground()) {
            object.getSprite().draw(
                    batch, x + object.getX() * scale, y + object.getY() * scale, scale);
        }
        for (GObject object : getScene().getObjects()) {
            object.getSprite().draw(
                    batch, x + object.getX() * scale, y + object.getY() * scale, scale);
        }
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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
