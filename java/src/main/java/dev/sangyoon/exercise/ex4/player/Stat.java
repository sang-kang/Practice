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
    private int value = 0;
    private Optional<Integer> maxValue = Optional.empty();
    public int value(){
        return value;
    }
    public Optional<Integer> maxValue() {
        return maxValue;
    }
    public void add(int changeAmount){
        this.value = Math.max(0, this.value + changeAmount);
        this.maxValue.ifPresent(max -> this.value = Math.min(max, this.value));
    }
}
