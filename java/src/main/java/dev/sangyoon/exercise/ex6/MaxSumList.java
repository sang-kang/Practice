package dev.sangyoon.exercise.ex6;

public class MaxSumList {
    
    public static void main(String ... args) {
        // int[] input = {-2,1,-3,4,-1,2,1,-5,4};  // 3 6 6
        // int[] input = {-2,1,-3,4,-10,-9,2,1,-5,4};  // 3 3 4
        // int[] input = {1,2,3,4,5,6,7,8,9};  // 0 8 45
        int[] input = {0,0,0,1,0,0,0};  // 3 3 1
        int currentStart = -1;
        int currentSum = -1;
        int maxSum = Integer.MIN_VALUE;
        int maxStart = -1;
        int maxEnd = -1;
        for(int i = 0; i < input.length; i++){
            if(currentSum <= 0) {
                currentStart = i;
                currentSum = 0;
            }
            currentSum += input[i];
            if(currentSum > maxSum) {
                maxStart = currentStart;
                maxEnd = i;
                maxSum = currentSum;
            }
        }
        System.out.println(maxStart + ", " + maxEnd + ", " + maxSum);
    }
}
