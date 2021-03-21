package dev.sangyoon.exercise.ex4.player;

import java.util.Random;

public class StatChange {
    private String stat;
    private int changeAmount;

    StatChange(String stat, int changeAmount) {
        this.stat = stat;
        this.changeAmount = changeAmount;
    }

    public String type(){
        return this.stat;
    }

    public int changeAmount() {
        return this.changeAmount;
    }

    public static int randomStatChange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static StatChange with(String type, int changeAmount) {
        return new StatChange(type, changeAmount);
    }
}
