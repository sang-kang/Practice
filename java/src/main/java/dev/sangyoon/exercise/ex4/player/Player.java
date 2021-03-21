package dev.sangyoon.exercise.ex4.player;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dev.sangyoon.exercise.ex4.action.Action;
import dev.sangyoon.exercise.ex4.action.Work;

public class Player {

    Map<String, Stat> stats = Arrays.stream(Stat.values()).collect(Collectors.toMap(Stat::name, a -> a));

    public void perform(Action action) {
        Map<String, StatChange> statChanges = action.statChanges();
        if(stats.get(Stat.STAMINA.name()).value() + statChanges.get(Stat.STAMINA.name()).changeAmount() < 0) {
            throw new RuntimeException("Not Enough Stamina");
        }
        statChanges.values().forEach(statChange -> stats.get(statChange.type()).add(statChange.changeAmount()));
    }

    public Set<Action> availableActions(){
        return Set.of(new Work());
    }

    @Override
    public String toString() {
        return stats.values().stream().map(stat -> stat.name() + ": " + stat.value()).reduce("", (a, b) -> a + "\n" + b);
    }

    
}
