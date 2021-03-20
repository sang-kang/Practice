package dev.sangyoon.exercise.ex4;

public class Singleton {
    private static Singleton me = new Singleton();
    private int score = 0;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return me;
    }
    
    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
    
}
