package com.yenoxx.ht9k.scene;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.object.PlayerTank;
import com.yenoxx.ht9k.object.Wall;

public class LevelScene extends Scene {
    public static final String[][] LEVELS = {
            {
                    "##########",
                    "#______P_#",
                    "#_########",
                    "#____#___#",
                    "##_####__#",
                    "##_#__#__#",
                    "#________#",
                    "##########",
            }
    };

    private PlayerTank playerTank;
    private ResourceManager resources;

    public LevelScene(ResourceManager resources) {
        super();

        setResources(resources);
    }

    public void loadLevel(int level) {
        getObjects().clear();
        for (int y = 0; y < LEVELS[level - 1].length; y++) {
            String row = LEVELS[level - 1][y];
            for (int x = 0; x < row.length(); x++) {
                char c = row.charAt(x);
                if (c == '#') {
                    addGObject(new Wall(this, x * 16, y * 16, resources));
                }
                else if (c == 'P') {
                    setPlayerTank(new PlayerTank(this, x * 16, y * 16, resources));
                    addGObject(getPlayerTank());
                }
            }
        }
    }

    public PlayerTank getPlayerTank() {
        return playerTank;
    }

    public void setPlayerTank(PlayerTank playerTank) {
        this.playerTank = playerTank;
    }

    public ResourceManager getResources() {
        return resources;
    }

    public void setResources(ResourceManager resources) {
        this.resources = resources;
    }
}
