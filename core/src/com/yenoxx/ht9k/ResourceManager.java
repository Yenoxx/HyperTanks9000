package com.yenoxx.ht9k;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class ResourceManager {
    private HashMap<String, Texture> textureMap;
    private HashMap<String, TextureRegion> textureRegionMap;

    public ResourceManager() {
        textureMap = new HashMap<>();
        textureRegionMap = new HashMap<>();
    }

    public void loadTexture(String name, String path) {
        textureMap.put(name, new Texture(path));
    }

    public Texture getTexture(String name) {
        return textureMap.get(name);
    }

    public void addTextureRegion(String name, String textureName, int x, int y, int w, int h) {
        textureRegionMap.put(name, new TextureRegion(getTexture(textureName), x, y, w, h));
    }

    public TextureRegion getTextureRegion(String name) {
        return textureRegionMap.get(name);
    }
}
