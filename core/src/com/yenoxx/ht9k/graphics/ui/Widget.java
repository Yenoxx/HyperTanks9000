package com.yenoxx.ht9k.graphics.ui;

import com.yenoxx.ht9k.Utils;
import com.yenoxx.ht9k.graphics.Sprite;

public class Widget {
    private int x;
    private int y;
    private int w;
    private int h;

    private boolean clicked;

    private Sprite sprite;

    public Widget(int x, int y, int w, int h, Sprite sprite) {
        setX(x);
        setY(y);
        setW(w);
        setH(h);

        setSprite(sprite);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
