package dev.sangyoon.exercise.ex4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class MultiThreading {
    private ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public void startNewThread() {
        Runnable runnable = () -> {
            int id = new Random().nextInt(1000);
            for (int i = 0; i < 10; i++) {
                Singleton instance = Singleton.getInstance();
                System.out.println(id + ": " + instance.getScore());
                instance.increaseScore();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        threadPool.submit(runnable);
        this.consume(this::lambda);
    }

    private void consume(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }

    private int lambda() {
        int id = new Random().nextInt(1000);
        for (int i = 0; i < 10; i++) {
            Singleton instance = Singleton.getInstance();
            System.out.println(id + ": " + instance.getScore());
            instance.increaseScore();
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public static void main(String... args) {
        MultiThreading multiThreading = new MultiThreading();
        multiThreading.startNewThread();
        multiThreading.startNewThread();
    }

    
}