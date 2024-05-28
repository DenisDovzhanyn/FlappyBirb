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
	int highScore = 0;
	File highScoreSheet = new File("assets/highScore.txt");



	
	@Override
	public void create () {

		try {
			highScoreSheet.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		highScoreStart();


		this.setScreen(new MainMenu(this));

    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}

	public void checkHighScore(){
		int fileHighScore = 0;

		try(Scanner scanner = new Scanner(highScoreSheet)){

			while (scanner.hasNext()){
				fileHighScore = scanner.nextInt();
			}

		}catch (FileNotFoundException e){
			System.out.println("file not found");
		}catch (NoSuchElementException e){
			System.out.println("element does not exist");
		}


		if (fileHighScore < highScore){
			try(PrintWriter overWrite = new PrintWriter(highScoreSheet)){
				overWrite.println(highScore);

			}catch (FileNotFoundException e){
				System.out.println("file not found");
			}
		}

	}

	public void highScoreStart(){
		try(Scanner scanner = new Scanner(highScoreSheet)){
			if (scanner.hasNext()) highScore = scanner.nextInt();
		}catch (FileNotFoundException e){

		}
	}
}
