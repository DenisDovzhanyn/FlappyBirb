package com.flappybirb.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen {
    SpriteBatch batch;
    final FlappyBirb game;
    OrthographicCamera camera;
    Texture background;
    Texture click;
    BitmapFont font;


    public MainMenu(final FlappyBirb game){
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("Cloudy-0W244.ttf.fnt"), false);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,300,500);
        background = new Texture(Gdx.files.internal("flappyBackground.png"));
        click = new Texture(Gdx.files.internal("clickanywheretobegin.png"));





    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background,0,0);
        batch.draw(click,0,100);
        font.draw(batch,"High Score",30, 490);
        font.draw(batch,String.valueOf(game.highScore), 140, 450);
        if (game.didLose){
            font.draw(batch,"Game Over", 35, 350);
        }
        batch.end();
        if (Gdx.input.isTouched()){
            game.setScreen(new FlappyScreen(game));
            dispose();

        }



    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        click.dispose();
        font.dispose();

    }
}
