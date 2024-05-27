package com.flappybirb.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen {
    SpriteBatch batch;
    final FlappyBirb game;
    OrthographicCamera camera;
    Texture background;
    Texture click;


    public MainMenu(final FlappyBirb game){
        this.game = game;
        batch = new SpriteBatch();
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
        batch.draw(click,0,250);
        batch.end();
        if (Gdx.input.isTouched()){
            game.setScreen(new FlappyScreen());
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

    }
}
