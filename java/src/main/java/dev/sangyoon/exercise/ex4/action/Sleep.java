package dev.sangyoon.exercise.ex4.action;

import java.util.Set;

import dev.sangyoon.exercise.ex4.player.Stat;
import dev.sangyoon.exercise.ex4.player.StatChange;

public class Sleep implements Action {
    
    @Override
    public Set<StatChange> statChanges() {
        return Set.of(
            StatChange.with(Stat.STRESS.name(), StatChange.randomStatChange(-50, -20))
        );
    }
}
