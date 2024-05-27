package com.flappybirb.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyBirb extends Game {

	
	@Override
	public void create () {
		this.setScreen(new MainMenu(this));


	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
