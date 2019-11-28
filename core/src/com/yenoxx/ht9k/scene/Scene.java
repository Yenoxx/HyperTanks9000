package com.yenoxx.ht9k.scene;

import com.yenoxx.ht9k.Dynamic;
import com.yenoxx.ht9k.object.GObject;

import java.util.ArrayList;

public class Scene implements Dynamic {
    private ArrayList<GObject> objects;

    public Scene() {
        setObjects(new ArrayList<GObject>());
    }

    @Override
    public void update(float dt) {
        ArrayList<GObject> removeList = new ArrayList<>();
        for (GObject object : getObjects()) {
            object.update(dt);
            if (object.isDestroyed()) {
                removeList.add(object);
            }
        }
        for (GObject object : removeList) {
            removeGObject(object);
        }
    }

    public void addGObject(GObject object) {
        getObjects().add(object);
    }

    public void removeGObject(GObject object) {
        getObjects().remove(object);
    }

    public ArrayList<GObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GObject> objects) {
        this.objects = objects;
    }
}
