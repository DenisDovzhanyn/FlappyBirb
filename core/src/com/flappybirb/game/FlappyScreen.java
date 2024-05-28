package com.flappybirb.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import java.awt.*;
import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


//pipes are 75 500 fish is 40 30

public class FlappyScreen implements Screen {
    final FlappyBirb game;

    OrthographicCamera camera;
    SpriteBatch batch;
    Texture background;
    Texture fishy;
    Texture pipeUp;
    Texture pipeDown;
    Rectangle fish;
    Rectangle floor;
    Array<Rectangle> pipesDown;
    Array<Rectangle> pipesUp;
    long pipeTime;

    public FlappyScreen(final FlappyBirb game){
        this.game = game;

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,300,500);

        background = new Texture(Gdx.files.internal("flappyBackground.png"));
        fishy = new Texture(Gdx.files.internal("fishy.png"));
        pipeUp = new Texture(Gdx.files.internal("pipefacingup.png"));
        pipeDown = new Texture(Gdx.files.internal("pipefacingdown.png"));

        fish = new Rectangle();
        fish.width = 40;
        fish.height = 30;
        fish.x = 75;
        fish.y = 300;

        floor = new Rectangle();
        floor.width = 300;
        floor.height = 43;
        floor.x = 0;
        floor.y = 0;

        pipesDown = new Array<Rectangle>();
        pipesUp = new Array<Rectangle>();
        spawnPipes();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background,0,0);
        batch.draw(fishy,fish.x,fish.y);

        for (Rectangle pipe : pipesDown){
            batch.draw(pipeDown,pipe.x,pipe.y );
        }
        for (Rectangle pipe : pipesUp){
            batch.draw(pipeUp,pipe.x,pipe.y);
        }
        batch.end();

        if (Gdx.input.justTouched()){
            fish.y += 3500 * Gdx.graphics.getDeltaTime();
        } else{
            fish.y -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (fish.y > 500 - 30) fish.y = 500 - 30;

        if (TimeUtils.nanoTime() - pipeTime > 2000000000){
            spawnPipes();
        }

        for (Iterator<Rectangle> pipeDown = pipesDown.iterator(); pipeDown.hasNext();){

                Rectangle pipeGoingDown = pipeDown.next();


                pipeGoingDown.x -= 200 * Gdx.graphics.getDeltaTime();


                if (pipeGoingDown.x + 75 < 0 ) pipeDown.remove();
                if (pipeGoingDown.overlaps(fish) ) System.out.println("youlost");



        }
        for(Iterator<Rectangle> pipeUp = pipesUp.iterator(); pipeUp.hasNext();){

            Rectangle pipeGoingUp = pipeUp.next();


            pipeGoingUp.x -= 200 * Gdx.graphics.getDeltaTime();

            if (pipeGoingUp.x + 75 < 0) pipeUp.remove();
            if (pipeGoingUp.overlaps(fish)) System.out.println("youlost");
        }



    }

    public void spawnPipes(){
        Rectangle pipe1 = new Rectangle();
        Rectangle pipe2 = new Rectangle();

        pipe1.x = 300;
        pipe2.x = pipe1.x;

        pipe1.y = MathUtils.random(175, 500);
        pipe2.y = pipe1.y - 650;
        pipe1.width = 75;
        pipe1.height = 500;
        pipe2.width = pipe1.width;
        pipe2.height = pipe1.height;
        pipesDown.add(pipe1);
        pipesUp.add(pipe2);

        pipeTime = TimeUtils.nanoTime();

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
