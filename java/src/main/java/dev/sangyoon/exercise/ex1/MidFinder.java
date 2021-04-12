package dev.sangyoon.exercise.ex1;
//질문 int[] input의 평균을 구하고 가장 가까운 값을 return하시오

import java.util.Arrays;
//제약조건에 대한 질문을 생활하하자
//input = [0]일때
//input = []일때
//평균값이 4나왔는데 input = [1,2,3,5,7] 이라면 3을 return할 것인가 5를 return할 것인가.
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
            //binarySearch할때 index값은 이렇게 적자.
            int numberBeforeIndex = Math.abs(average - input[index - 1]);   //1
            //이름이 이상하다. numberBeforeIndex는 [index-1]에만 해당하는 이름.
            int numberAtIndex = Math.abs(average - input[index]);           //2
            //이름이 이상하다. numberAtIndex는 input[index]에만 해당하는 이름
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
