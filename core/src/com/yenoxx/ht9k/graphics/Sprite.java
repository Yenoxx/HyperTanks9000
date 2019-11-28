package com.yenoxx.ht9k.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yenoxx.ht9k.Drawable;
import com.yenoxx.ht9k.Dynamic;

import java.util.ArrayList;

public class Sprite implements Drawable, Dynamic {
    private ArrayList<TextureRegion> frames;

    private int frameCount;
    private int index;

    private float ut;
    private float time;

    private float width;
    private float height;
    private float rotation;

    private Sprite(float ut) {
        frames = new ArrayList<>();

        setFrameCount(0);
        setIndex(0);

        setUt(ut);
        setTime(0);

        setWidth(0);
        setHeight(0);
        setRotation(0);
    }

    public Sprite(TextureRegion t1, float ut) {
        this(ut);
        setFrameCount(1);

        frames.add(t1);

        setWidth(t1.getRegionWidth());
        setHeight(t1.getRegionHeight());
    }

    public Sprite(TextureRegion t1, TextureRegion t2, float ut) {
        this(ut);
        setFrameCount(2);

        frames.add(t1);
        frames.add(t2);

        setWidth(t1.getRegionWidth());
        setHeight(t1.getRegionHeight());
    }

    @Override
    public void update(float dt) {
        if (ut > 0) {
            setTime(getTime() + dt);
            if (getTime() > getUt()) {
                setTime(0);
                setIndex(getIndex() + 1);
                if (getIndex() >= getFrameCount()) {
                    setIndex(0);
                }
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch, float x, float y, float scale) {
        batch.draw(getFrames().get(getIndex()), x, y,
                getWidth() / 2 * scale, getHeight() / 2 * scale,
                getWidth() * scale,
                getHeight() * scale,
                1, 1, getRotation());
    }

    public ArrayList<TextureRegion> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<TextureRegion> frames) {
        this.frames = frames;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getUt() {
        return ut;
    }

    public void setUt(float ut) {
        this.ut = ut;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getWidth() {
        return width;
    }

    private void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    private void setHeight(float height) {
        this.height = height;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
