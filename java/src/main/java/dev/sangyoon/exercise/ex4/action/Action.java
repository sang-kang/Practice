package dev.sangyoon.exercise.ex4.action;

import java.util.Map;

import dev.sangyoon.exercise.ex4.player.StatChange;

public interface Action {
    Map<String, StatChange> statChanges();
}
