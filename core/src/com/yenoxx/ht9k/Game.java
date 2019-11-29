package com.yenoxx.ht9k;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yenoxx.ht9k.graphics.Camera;
import com.yenoxx.ht9k.graphics.Sprite;
import com.yenoxx.ht9k.graphics.ui.UI;
import com.yenoxx.ht9k.graphics.ui.Widget;
import com.yenoxx.ht9k.object.EnemyTank;
import com.yenoxx.ht9k.object.Entity;
import com.yenoxx.ht9k.object.GObject;
import com.yenoxx.ht9k.object.Tank;
import com.yenoxx.ht9k.scene.LevelScene;
import com.yenoxx.ht9k.scene.Scene;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;

	private ResourceManager resources;

	private LevelScene sceneMain;
	private Camera camera;
	private Player player;

	private UI menu;
	private Widget buttonPlay;
	private Widget buttonExit;

	private UI winMenu;
	private Widget buttonNext;

	private UI loseMenu;
	private Widget buttonAgain;

	private UI ui;
	private Widget buttonUp;
	private Widget buttonDown;
	private Widget buttonLeft;
	private Widget buttonRight;
	private Widget buttonFire;

	private float scale;

	private String state;

	private int currentLevel;

	@Override
	public void create () {
		batch = new SpriteBatch();
		scale = Gdx.graphics.getHeight() / 512f;

		state = "menu";

		currentLevel = 1;

		// ########## RESOURCE MANAGEMENT ##########
		resources = new ResourceManager();

		resources.loadTexture("tiles", "tiles.png");
		resources.loadTexture("menu", "menu.png");

		resources.addTextureRegion("tank11", "tiles",
				0, 0, 16, 16);
		resources.addTextureRegion("tank12", "tiles",
				16, 0, 16, 16);
		resources.addTextureRegion("tank21", "tiles",
				32, 0, 16, 16);
		resources.addTextureRegion("tank22", "tiles",
				48, 0, 16, 16);
		resources.addTextureRegion("wall", "tiles",
				0, 16, 16, 16);
		resources.addTextureRegion("floor", "tiles",
				16, 16, 16, 16);
		resources.addTextureRegion("base1", "tiles",
				32, 16, 16, 16);
		resources.addTextureRegion("base2", "tiles",
				48, 16, 16, 16);
		resources.addTextureRegion("buttonFire", "tiles",
				0, 32, 16, 16);
		resources.addTextureRegion("buttonUp", "tiles",
				16, 32, 16, 16);
		resources.addTextureRegion("explosion1", "tiles",
				32, 32, 16, 16);
		resources.addTextureRegion("explosion2", "tiles",
				48, 32, 16, 16);
		resources.addTextureRegion("buttonLeft", "tiles",
				0, 48, 16, 16);
		resources.addTextureRegion("buttonDown", "tiles",
				16, 48, 16, 16);
		resources.addTextureRegion("buttonRight", "tiles",
				32, 48, 16, 16);
		resources.addTextureRegion("bullet", "tiles",
				52, 52, 8, 8);

		resources.addTextureRegion("logo", "menu",
				0, 0, 64, 32);
		resources.addTextureRegion("labelWin", "menu",
				0, 32, 64, 16);
		resources.addTextureRegion("labelLose", "menu",
				0, 48, 64, 16);
		resources.addTextureRegion("buttonPlay", "menu",
				0, 64, 32, 16);
		resources.addTextureRegion("buttonExit", "menu",
				32, 64, 32, 16);
		resources.addTextureRegion("buttonNext", "menu",
				0, 80, 32, 16);
		resources.addTextureRegion("buttonAgain", "menu",
				32, 80, 32, 16);


		// ########## SCENE MANAGEMENT ##########
		sceneMain = new LevelScene(resources);
		camera = new Camera(sceneMain);

		sceneMain.loadLevel(currentLevel);

		player = new Player(sceneMain.getPlayerTank());


		// ########## USER INTERFACE ##########
		ui = new UI(6 * scale); // In-game UI

		buttonUp = new Widget(18, 18, 16, 16,
				new Sprite(resources.getTextureRegion("buttonUp"), 0));
		buttonDown = new Widget(18, 2, 16, 16,
				new Sprite(resources.getTextureRegion("buttonDown"), 0));
		buttonLeft = new Widget(2, 2, 16, 16,
				new Sprite(resources.getTextureRegion("buttonLeft"), 0));
		buttonRight = new Widget(34, 2, 16, 16,
				new Sprite(resources.getTextureRegion("buttonRight"), 0));
		buttonFire = new Widget((int) (Gdx.graphics.getWidth() / ui.getSize()) - 18,
				2, 16, 16,
				new Sprite(resources.getTextureRegion("buttonFire"), 0));

		ui.addWidget(buttonUp);
		ui.addWidget(buttonDown);
		ui.addWidget(buttonLeft);
		ui.addWidget(buttonRight);
		ui.addWidget(buttonFire);

		menu = new UI(6 * scale); // Menu UI
		menu.select();

		buttonPlay = new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 16,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 64, 32, 16,
				new Sprite(resources.getTextureRegion("buttonPlay"), 0));
		buttonExit = new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 16,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 82, 32, 16,
				new Sprite(resources.getTextureRegion("buttonExit"), 0));

		menu.addWidget(new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 32,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 34, 64, 32,
				new Sprite(resources.getTextureRegion("logo"), 0)));
		menu.addWidget(buttonPlay);
		menu.addWidget(buttonExit);

		winMenu = new UI(6 * scale); // Win menu UI

		buttonNext = new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 16,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 64, 32, 16,
				new Sprite(resources.getTextureRegion("buttonNext"), 0));

		winMenu.addWidget(new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 32,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 34, 64, 32,
				new Sprite(resources.getTextureRegion("labelWin"), 0)));
		winMenu.addWidget(buttonNext);

		loseMenu = new UI(6 * scale); // Lose menu UI

		buttonAgain = new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 16,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 64, 32, 16,
				new Sprite(resources.getTextureRegion("buttonAgain"), 0));

		loseMenu.addWidget(new Widget((int) (Gdx.graphics.getWidth() / ui.getSize() / 2) - 32,
				(int) (Gdx.graphics.getHeight() / ui.getSize()) - 34, 64, 32,
				new Sprite(resources.getTextureRegion("labelLose"), 0)));
		loseMenu.addWidget(buttonAgain);
	}

	@Override
	public void render() {
		if (state.equals("menu")) {
			if (buttonPlay.isClicked()) {
                buttonPlay.setClicked(false);
				state = "game";
				ui.select();
			}
			if (buttonExit.isClicked()) {
                buttonExit.setClicked(false);
				Gdx.app.exit();
			}

			Gdx.gl.glClearColor(0.2f, 0.3f, 0.2f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			menu.draw(batch);
			batch.end();
		}
	 	else if (state.equals("game")) {
			sceneMain.update(Gdx.graphics.getDeltaTime());
			player.updateState(buttonUp.isClicked(), buttonDown.isClicked(),
					buttonLeft.isClicked(), buttonRight.isClicked(), buttonFire.isClicked());

			if (EnemyTank.count <= 0) {
				state = "menu_win";
				winMenu.select();
			}
			if (player.getTank().isDestroyed()) {
				state = "menu_lose";
				loseMenu.select();
			}

			Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			camera.draw(batch, Gdx.graphics.getWidth() / 2f - 320 * scale, 0,
					2 * scale);
			ui.draw(batch);
			batch.end();
		} else if (state.equals("menu_win")) {
	 		if (buttonNext.isClicked()) {
	 		    buttonNext.setClicked(false);

	 			currentLevel += 1;
	 			if (currentLevel > LevelScene.LEVELS.length) currentLevel = 1;

	 			EnemyTank.count = 0;
	 			sceneMain.loadLevel(currentLevel);
				player = new Player(sceneMain.getPlayerTank());

				state = "game";
				ui.select();
			}

			Gdx.gl.glClearColor(0.3f, 0.4f, 0.3f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			winMenu.draw(batch);
			batch.end();
		}
		else if (state.equals("menu_lose")) {
			if (buttonAgain.isClicked()) {
                buttonAgain.setClicked(false);

				EnemyTank.count = 0;
				sceneMain.loadLevel(currentLevel);
				player = new Player(sceneMain.getPlayerTank());

				state = "game";
				ui.select();
			}

			Gdx.gl.glClearColor(0.3f, 0.2f, 0.2f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			loseMenu.draw(batch);
			batch.end();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
