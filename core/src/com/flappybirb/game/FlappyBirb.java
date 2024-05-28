package com.flappybirb.game;

import com.badlogic.gdx.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FlappyBirb extends Game {
	boolean didLose = false;
	Scores score;




	
	@Override
	public void create () {

		score = new Scores();
		score.highScoreStart();




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
