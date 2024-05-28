package com.flappybirb.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Scores {
    int highScore = 0;
    File highScoreSheet;

    public Scores(){
        highScoreSheet = new File("assets/highScore.txt");

        try {
            highScoreSheet.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void checkHighScore(){
        int fileHighScore = 0;

        try(Scanner scanner = new Scanner(highScoreSheet)){

            while (scanner.hasNext()){
                fileHighScore = scanner.nextInt();
            }

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }


        if (fileHighScore < highScore){
            try(PrintWriter overWrite = new PrintWriter(highScoreSheet)){
                overWrite.print(highScore);

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
