package dev.sangyoon.exercise.ex1;

import java.util.Arrays;

public class MidFinder {
    public int find(int[] input) {
        Arrays.sort(input);
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        int average = 0;
        try {
            average = sum / input.length;
        } catch (ArithmeticException e) {
            //System.out.println("Array is empty");
            return -1;
        }

        int index = Arrays.binarySearch(input, average);
        int valueClosestToTheMean;
        if (index > 0) {
            valueClosestToTheMean = input[index];
        } else {
            index = -index - 1;
            int numberBeforeIndex = Math.abs(average - input[index - 1]);   //1
            int numberAtIndex = Math.abs(average - input[index]);           //2
            valueClosestToTheMean = (numberBeforeIndex <= numberAtIndex) ? input[index - 1] : input[index];
        }
        return valueClosestToTheMean;
    }

    public static void main(String... args) {
        MidFinder midFinder = new MidFinder();
        int[] array = {1, 5, 8, 10};
        System.out.println(midFinder.find(array));
    }
}
