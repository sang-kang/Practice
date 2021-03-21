package dev.sangyoon.exercise.ex4;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dev.sangyoon.exercise.ex4.action.Action;
import dev.sangyoon.exercise.ex4.player.Player;

public class Game {
    
    public static void main(String ... args) {
        Player player = new Player();
        List<Action> availableActions = player.availableActions().stream().collect(Collectors.toList());
        Random random = new Random();
        IntStream.range(1, 10).forEach(i -> {
            try {
                player.perform(availableActions.get(random.nextInt(availableActions.size())));
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        });
        System.out.println(player);
    }
}
