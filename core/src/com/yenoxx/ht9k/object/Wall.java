package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.scene.Scene;

public class Wall extends GObject {
    public Wall(Scene scene, float x, float y, ResourceManager resources) {
        super(scene, x, y, 16, 16, new Sprite(
                resources.getTextureRegion("wall"), 0));

        setType("wall");
    }
}
