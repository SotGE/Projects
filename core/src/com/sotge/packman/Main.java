package com.sotge.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sotge.packman.utils.Assets;
import com.sotge.packman.views.GameScreen;

public class Main extends Game {

	private Screen gameScreen;
	private Assets assets;

	@Override
	public void create() {
		assets = new Assets();
		gameScreen = new GameScreen();
		((GameScreen) gameScreen).setTextureAtlas(assets.getManager().get("atlas1.atlas", TextureAtlas.class));
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		gameScreen.dispose();
		assets.dispose();
	}
}
