package dev.sangyoon.exercise.ex4.action;

import java.util.Set;

import dev.sangyoon.exercise.ex4.player.Stat;
import dev.sangyoon.exercise.ex4.player.StatChange;

public class Eat implements Action {
    
    @Override
    public Set<StatChange> statChanges() {
        return Set.of(
            StatChange.with(Stat.STAMINA.name(), StatChange.randomStatChange(10, 20)),
            StatChange.with(Stat.MONEY.name(), StatChange.randomStatChange(-15, -5)),
            StatChange.with(Stat.STRESS.name(), StatChange.randomStatChange(-2, 0))
        );
    }
}
