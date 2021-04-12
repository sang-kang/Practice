package dev.sangyoon.exercise.ex4.action;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dev.sangyoon.exercise.ex4.player.Stat;
import dev.sangyoon.exercise.ex4.player.StatChange;

//public class Work implements Action {

//    @Override
//    public Map<String, StatChange> statChanges() {
//        return Set.of(
//            StatChange.with(Stat.STAMINA.name(), StatChange.randomStatChange(-10, -5)),
//            StatChange.with(Stat.MONEY.name(), StatChange.randomStatChange(10, 20)),
//            StatChange.with(Stat.STRESS.name(), StatChange.randomStatChange(2, 3))
//        ).stream().collect(Collectors.toMap(StatChange::type, a -> a));
//    }
//
//}
