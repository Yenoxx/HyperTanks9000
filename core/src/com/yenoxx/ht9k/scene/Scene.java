package com.yenoxx.ht9k.scene;

import com.yenoxx.ht9k.Dynamic;
import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.object.GObject;

import java.util.ArrayList;

public class Scene implements Dynamic {
    private ArrayList<GObject> objects;
    private ArrayList<GObject> background;

    private ArrayList<GObject> addList;

    private ResourceManager resources;

    public Scene(ResourceManager resources) {
        setObjects(new ArrayList<GObject>());
        setBackground(new ArrayList<GObject>());

        setAddList(new ArrayList<GObject>());

        setResources(resources);
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
            object.onDestroy();
            removeGObject(object);
        }
        for (GObject object : getAddList()) {
            getObjects().add(object);
        }
        getAddList().clear();
    }

    public void addGObject(GObject object) {
        getAddList().add(object);
    }

    public void removeGObject(GObject object) {
        getObjects().remove(object);
    }

    public void addBKGGObject(GObject object) {
        getBackground().add(object);
    }

    public void removeBKGGObject(GObject object) {
        getBackground().remove(object);
    }

    public ArrayList<GObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GObject> objects) {
        this.objects = objects;
    }

    public ResourceManager getResources() {
        return resources;
    }

    public void setResources(ResourceManager resources) {
        this.resources = resources;
    }

    public ArrayList<GObject> getBackground() {
        return background;
    }

    public void setBackground(ArrayList<GObject> background) {
        this.background = background;
    }

    public ArrayList<GObject> getAddList() {
        return addList;
    }

    public void setAddList(ArrayList<GObject> addList) {
        this.addList = addList;
    }
}
