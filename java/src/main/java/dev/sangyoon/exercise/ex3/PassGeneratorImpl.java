package dev.sangyoon.exercise.ex3;

import javafx.scene.effect.SepiaTone;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.*;

public class PassGeneratorImpl implements PassGenerator {
    List<String> passwordLists = new ArrayList<String>();
    Stack<Character> stack = new Stack<>();

    @Override
    public List<String> generateAll(List<Character> alphabets, int length) {
        //Collections.sort(alphabets); 밑이 더 알아보기 쉽다
        alphabets.sort(Character::compareTo);


//        //앞뒤 바뀌는건 상관없는건가?
//        //length만큼 반복문 추가될거 같은데.. length가 2면 반복문 2개
//        for (int i = 0; i < alphabets.size(); i++) {
//            for (int j = i + 1; j < alphabets.size(); j++) {
//                //character to string
//                StringBuilder stringBuilder = new StringBuilder().append(alphabets.get(i)).append(alphabets.get(j));
//                String password = stringBuilder.toString();
//                passwordLists.add(password);
//            }
//        }
//
//        return passwordLists;
        int start = 0;
        makeRecursive(start, alphabets, length, stack);
        return null;
    }

    public void makeRecursive(int start, List<Character> alphabets, int length, Stack<Character> stack) {
        for (int i = start; i < alphabets.size(); i++) {
            System.out.println("i 값: " + i);
            System.out.println("start 값: " + start);
            stack.push(alphabets.get(i));
            System.out.println("what pushed in stack: " + stack);
            if (i <= length) {
                makeRecursive(i + 1, alphabets, length, stack);
                System.out.println("if통과후 i값: " + i);
                System.out.println("if통과후 start값: " + start);

            } else {
                System.out.println("print stack: " + stack);
            }
            try {
//                stack.pop();
                System.out.println("what pop from stack: " + stack.pop());
            } catch (EmptyStackException e) {
                System.out.println("stack is empty");
            }
        }
    }

    public static void main(String... args) {
        PassGeneratorImpl passGenerator = new PassGeneratorImpl();
        List<Character> alphabets = new ArrayList<>();
        alphabets.add('b');
        alphabets.add('a');
        alphabets.add('c');
        alphabets.add('e');
        alphabets.add('d');
        alphabets.add('f');

        passGenerator.generateAll(alphabets, 3);
    }
}
