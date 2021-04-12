//package dev.sangyoon.exercise.ex4.player;
//
//import java.util.Arrays;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import dev.sangyoon.exercise.ex4.action.Action;
//import dev.sangyoon.exercise.ex4.action.Eat;
//import dev.sangyoon.exercise.ex4.action.Sleep;
//import dev.sangyoon.exercise.ex4.action.Work;
//
//public class Player {
//
//    Map<String, Stat> stats = Arrays.stream(Stat.values()).collect(Collectors.toMap(Stat::name, a -> a));
//
//    public void perform(Action action) {
//        Map<String, StatChange> statChanges = action.statChanges();
//        Set<Stat> exceptions = Arrays.asList(Stat.STAMINA, Stat.MONEY).stream()
//            .filter(stat -> statChanges.containsKey(stat.name()) && (stats.get(stat.name()).value() + statChanges.get(stat.name()).changeAmount() < 0))
//            .collect(Collectors.toSet());
//        if(!exceptions.isEmpty()) {
//            throw new RuntimeException("Not Enough " +
//                exceptions.stream().map(Stat::name).collect(Collectors.joining(",", "[", "]")) +
//                " to perform " + action.getClass().getSimpleName());
//        }
//        if(stats.get(Stat.STRESS.name()).value() + statChanges.get(Stat.STRESS.name()).changeAmount() >= Stat.STRESS.maxValue().get().intValue()){
//            throw new RuntimeException("Too much stress to perform " + action.getClass().getSimpleName());
//        }
//        statChanges.values().forEach(statChange -> stats.get(statChange.type()).add(statChange.changeAmount()));
//    }
//
//    public Set<Action> availableActions(){
//        return Set.of(new Work(), new Eat(), new Sleep());
//    }
//
//    @Override
//    public String toString() {
//        return stats.values().stream().map(stat -> stat.name() + ": " + stat.value()).collect(Collectors.joining("\n"));
//    }
//
//
//}
