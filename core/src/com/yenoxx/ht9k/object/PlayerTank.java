package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.scene.Scene;

public class PlayerTank extends Tank {
    public PlayerTank(Scene scene, float x, float y, ResourceManager resources) {
        super(scene, x, y, 1, resources.getTextureRegion("tank11"),
                resources.getTextureRegion("tank12"));
    }
}
