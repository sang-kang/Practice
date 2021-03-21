package dev.sangyoon.exercise.ex4.player;

import java.util.Optional;

public enum Stat {
    STAMINA(50, 100), MONEY(100), STRESS(0, 100);
    Stat(int initialValue) {
        this.value = initialValue;
    }
    Stat(int initialValue, int maxValue) {
        this(initialValue);
        this.maxValue = Optional.of(maxValue);
    }
    int value = 0;
    Optional<Integer> maxValue = Optional.empty();
    public int value(){
        return value;
    }
    public void add(int value){
        this.value += value;
    }
}
