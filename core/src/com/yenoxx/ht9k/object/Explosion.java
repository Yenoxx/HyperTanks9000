package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Explosion extends GObject {
    private float time;

    public Explosion(Scene scene, float x, float y, ResourceManager resources) {
        super(scene, x, y, 16, 16, new Sprite(
                resources.getTextureRegion("explosion1"),
                resources.getTextureRegion("explosion2"), 0.2f));
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        getSprite().update(dt);

        setSolid(false);

        time += dt;
        if (time > 1) setDestroyed(true);
    }
}
