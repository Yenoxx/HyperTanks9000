package com.yenoxx.ht9k.object;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.scene.Scene;

public class PlayerTank extends Tank {
    public PlayerTank(Scene scene, float x, float y, int level, ResourceManager resources) {
        super(scene, x, y, 1, resources.getTextureRegion("tank11"),
                resources.getTextureRegion("tank12"));

        setCdTime(2 - (level - 1) * 0.1f);
        setSpeed(32 + (level - 1) * 4);
        setBulletSpeed(48 + (level - 1) * 6);
    }
}
