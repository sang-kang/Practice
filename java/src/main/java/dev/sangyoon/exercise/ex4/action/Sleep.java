package dev.sangyoon.exercise.ex4.action;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dev.sangyoon.exercise.ex4.player.Stat;
import dev.sangyoon.exercise.ex4.player.StatChange;

public class Sleep implements Action {
    
    @Override
    public Map<String, StatChange> statChanges() {
        return Set.of(
            StatChange.with(Stat.STRESS.name(), StatChange.randomStatChange(-50, -20))
        ).stream().collect(Collectors.toMap(StatChange::type, a -> a));
    }
}
