package com.yenoxx.ht9k.graphics.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yenoxx.ht9k.Drawable;
import com.yenoxx.ht9k.Utils;

import java.util.ArrayList;

public class UI implements Drawable {
    private ArrayList<Widget> widgets;

    private float size;

    private UIInputAdapter uiInputAdapter;

    public UI(float size) {
        setWidgets(new ArrayList<Widget>());

        setSize(size);

        setUiInputAdapter(new UIInputAdapter(this));
    }

    public void addWidget(Widget widget) {
        getWidgets().add(widget);
    }

    public void removeWidget(Widget widget) {
        getWidgets().remove(widget);
    }

    @Override
    public void draw(SpriteBatch batch, float x, float y, float scale) {
        for (Widget widget : getWidgets()) {
            widget.getSprite().draw(batch, x + widget.getX() * scale,
                    y + widget.getY() * scale, scale);
        }
    }

    public void draw(SpriteBatch batch) {
        draw(batch, 0, 0, getSize());
    }

    public void select() {
        Gdx.input.setInputProcessor(getUiInputAdapter());
    }

    protected ArrayList<Widget> getWidgets() {
        return widgets;
    }

    protected void setWidgets(ArrayList<Widget> widgets) {
        this.widgets = widgets;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public UIInputAdapter getUiInputAdapter() {
        return uiInputAdapter;
    }

    public void setUiInputAdapter(UIInputAdapter uiInputAdapter) {
        this.uiInputAdapter = uiInputAdapter;
    }
}

class UIInputAdapter extends InputAdapter {
    private UI ui;

    public UIInputAdapter(UI ui) {
        setUi(ui);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for (Widget widget : ui.getWidgets()) {
            widget.setClicked(isInsideWidget(screenX, screenY, widget));
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (Widget widget : ui.getWidgets()) {
            widget.setClicked(false);
        }

        return true;
    }

    public boolean isInsideWidget(int x, int y, Widget widget) {
        return
                x >= widget.getX() * getUi().getSize() &&
                        x <= (widget.getX() + widget.getW()) * getUi().getSize() &&
                        (Gdx.graphics.getHeight() - y) >= widget.getY() * getUi().getSize() &&
                        (Gdx.graphics.getHeight() - y) <= (widget.getY() + widget.getH()) *
                                getUi().getSize();
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }
}
