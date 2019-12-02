package com.yenoxx.ht9k.scene;

import com.yenoxx.ht9k.ResourceManager;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.object.EnemyTank;
import com.yenoxx.ht9k.object.GObject;
import com.yenoxx.ht9k.object.PlayerTank;
import com.yenoxx.ht9k.object.Wall;

public class LevelScene extends Scene {
    public static final String[][] LEVELS = {
            {
                    "####################",
                    "##   E             #",
                    "#      #   E   #   #",
                    "# #                #",
                    "#           #      #",
                    "#    E#            #",
                    "##         #####   #",
                    "# E #      #   #   #",
                    "#          # P #   #",
                    "##     #   #       #",
                    "#  E       ##### ###",
                    "#                  #",
                    "#    #     E   #   #",
                    "#    E   #         #",
                    "#     #       E    #",
                    "####################",
            },
            {
                    "####################",
                    "#   E     E    E   #",
                    "#  ####  ######  # #",
                    "#  E  #    # E   # #",
                    "# #######  ####  ###",
                    "#     E    #    E  #",
                    "##  #########  #####",
                    "# E #    E  #   E  #",
                    "# ### #####   ######",
                    "#   #  # E    #    #",
                    "##   # #####  #### #",
                    "#    #  #    E    E#",
                    "# ##### ############",
                    "#     #            #",
                    "#  E  #       P    #",
                    "####################",
            },
            {
                    "####################",
                    "##  #  #  #  #  #  #",
                    "#       E       E  #",
                    "#   E      E       #",
                    "#  #  #  #  #  #  ##",
                    "#       E       E  #",
                    "#   E      E       #",
                    "##  #  #  #  #  #  #",
                    "#         E     E  #",
                    "#  E    E          #",
                    "#  #  #  #  #  #  ##",
                    "#            E     #",
                    "#     E            #",
                    "##  #  #  #  #  # ##",
                    "#               P ##",
                    "####################",
            },
            {
                    "####################",
                    "#      #  E  #     #",
                    "#   E  #     #     #",
                    "#   #  #  #  #  #  #",
                    "#   #  #  #  #E #  #",
                    "#   #  #  #  #  #  #",
                    "#   # E#  #E #  #  #",
                    "#  E#  #  #  #  #  #",
                    "#   #  #E #  #  #  #",
                    "#E  #  #  #  #E #  #",
                    "#   #  #  #  #  #  #",
                    "#   #  #  #  #  #  #",
                    "#  E#  #  #  #  #  #",
                    "#   #     #     #  #",
                    "#E  #  E  #  E  #P #",
                    "####################",
            },
            {
                    "####################",
                    "#    E   ### E     #",
                    "# E      ###    E  #",
                    "#   ## #  E   ##   #",
                    "#E  ##      # ##   #",
                    "#    # E###    # E #",
                    "####    ######     #",
                    "####  ########  ####",
                    "####  ########  ####",
                    "#     E  ###       #",
                    "#  E     ###       #",
                    "#   ## #      ##   #",
                    "#E  ##      # ##   #",
                    "#  E    ###        #",
                    "#     E ###     P  #",
                    "####################",
            },
    };

    private PlayerTank playerTank;

    public LevelScene(ResourceManager resources) {
        super(resources);
    }

    public void loadLevel(int level) {
        getObjects().clear();
        for (int y = 0; y < LEVELS[level - 1].length; y++) {
            String row = LEVELS[level - 1][y];
            for (int x = 0; x < row.length(); x++) {
                char c = row.charAt(x);
                if (c == '#') {
                    addGObject(new Wall(this, x * 16, y * 16, getResources()));
                }
                else if (c == 'P') {
                    setPlayerTank(new PlayerTank(this, x * 16, y * 16, level,
                            getResources()));
                    addGObject(getPlayerTank());
                }
                else if (c == 'E') {
                    addGObject(new EnemyTank(this, x * 16, y * 16, getResources()));
                }
                addBKGGObject(new GObject(this, x * 16, y * 16, 16, 16,
                        new Sprite(getResources().getTextureRegion("floor"), 0)));
            }
        }
    }

    public PlayerTank getPlayerTank() {
        return playerTank;
    }

    public void setPlayerTank(PlayerTank playerTank) {
        this.playerTank = playerTank;
    }
}
