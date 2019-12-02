package com.yenoxx.ht9k;

public class HT9KResourceManager extends ResourceManager {
    public HT9KResourceManager() {
        super();

        loadTexture("tiles", "tiles.png");
        loadTexture("menu", "menu.png");

        addTextureRegion("tank11", "tiles",
                0, 0, 16, 16);
        addTextureRegion("tank12", "tiles",
                16, 0, 16, 16);
        addTextureRegion("tank21", "tiles",
                32, 0, 16, 16);
        addTextureRegion("tank22", "tiles",
                48, 0, 16, 16);
        addTextureRegion("wall", "tiles",
                0, 16, 16, 16);
        addTextureRegion("floor", "tiles",
                16, 16, 16, 16);
        addTextureRegion("base1", "tiles",
                32, 16, 16, 16);
        addTextureRegion("base2", "tiles",
                48, 16, 16, 16);
        addTextureRegion("bullet1", "tiles",
                4, 36, 8, 8);
        addTextureRegion("bullet2", "tiles",
                20, 36, 8, 8);
        addTextureRegion("explosion1", "tiles",
                32, 32, 16, 16);
        addTextureRegion("explosion2", "tiles",
                48, 32, 16, 16);

        addTextureRegion("logo", "menu",
                0, 0, 64, 32);
        addTextureRegion("labelWin", "menu",
                0, 32, 64, 16);
        addTextureRegion("labelLose", "menu",
                0, 48, 64, 16);
        addTextureRegion("buttonPlay", "menu",
                0, 64, 32, 16);
        addTextureRegion("buttonExit", "menu",
                32, 64, 32, 16);
        addTextureRegion("buttonNext", "menu",
                0, 80, 32, 16);
        addTextureRegion("buttonAgain", "menu",
                32, 80, 32, 16);
        addTextureRegion("buttonUp", "menu",
                0, 96, 16, 16);
        addTextureRegion("buttonDown", "menu",
                16, 96, 16, 16);
        addTextureRegion("buttonLeft", "menu",
                32, 96, 16, 16);
        addTextureRegion("buttonRight", "menu",
                48, 96, 16, 16);
        addTextureRegion("buttonFire", "menu",
                0, 112, 16, 16);
        addTextureRegion("buttonPause", "menu",
                16, 112, 16, 16);
    }
}
