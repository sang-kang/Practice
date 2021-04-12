package dev.sangyoon.exercise.ex4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {
    private ExecutorService executor = Executors.newFixedThreadPool(3);
    Person person = Person.getInstance();

//    public void startNewThread() {
//        Runnable runnable = () -> {
//            for (int i = 0; i < 11; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(new Random().nextInt(1000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        executor.submit(runnable);
//    }


    public void controlAppetiteThread() {
        Runnable runnable = () -> {
            //스테미너가 얼마 이하로 떨어지면 먹을려는 욕구가 생겨서 먹음.
            while (true) {
                synchronized (person) {
                    if (person.getAssets() <= 0 || person.getStamina() > 100) {
                        try {
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    person.eat();
                    System.out.println("밥먹자: " + person);
                }
            }
        };
        executor.submit(runnable);
    }

    public void controlDesireToIncreaseAssetsThread() {
        //끈임없음.
        Runnable runnable = () -> {
            //돈이 계속 쌓였으면 좋겠음
            while (true) {
                synchronized (person) {
                    if (person.getStamina() <= 0 || person.getFatigue() >= 100) {
                        try {
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    person.work();
                    System.out.println("돈 쌓인다: " + person);
                }
            }
        };
        executor.submit(runnable);

    }

    public void controlDesireToRestThread() {
        Runnable runnable = () -> {
            //피로도가 얼마이상 쌓이면 쉬고싶음.
            while (true) {
                synchronized (person) {
                    if (person.getFatigue() <= 0) {
                        try {
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    person.rest();
                    System.out.println("쉬자: " + person);
                }
            }
        };
        executor.submit(runnable);
    }

    //forloop열번 돌려서 밥먹고 일하고 쉬고 밤먹고 일하고 쉬고를 주기적으로 10번 반복해서 끝에 돈이랑 피로도랑 스태미너가 얼마남았는지 출력하는 프로그램 짜볼것.
    public void getStatusOfPerson(Person person) {
        for (int i = 0; i < 11; i++) {
            person.work();
            person.eat();
            person.rest();
        }
        System.out.println(person);
    }


    public static void main(String... args) {
        MyThread myThread = new MyThread();
////        myThread.startNewThread();
////        myThread.startNewThread();
        myThread.controlAppetiteThread();
        myThread.controlDesireToIncreaseAssetsThread();
        myThread.controlDesireToRestThread();

//        Person person = Person.getInstance();
//        myThread.getStatusOfPerson(person);
    }
}
