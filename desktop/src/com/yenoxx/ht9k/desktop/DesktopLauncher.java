package com.yenoxx.ht9k.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yenoxx.ht9k.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 800;
		config.height = 512;

		config.resizable = false;
		config.pauseWhenBackground = true;
		config.pauseWhenMinimized = true;

		new LwjglApplication(new Game(), config);
	}
}
