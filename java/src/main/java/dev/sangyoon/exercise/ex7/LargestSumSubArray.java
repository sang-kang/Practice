package dev.sangyoon.exercise.ex7;
/**
 * 가장 기본적인 탐색문제
 * Largest sum subarray
 * In the array below, the largest sum subarray starts at index 3 and ends at 6, and with the largest sum being 12.
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * -2
 * -2 +1
 * -2 +1 -3
 * -2 +1 -3 +4
 * -2 +1 -3 +4 -1
 * -2 +1 -3 +4 -1 +2
 * -2 +1 -3 +4 -1 +2 +1
 * -2 +1 -3 +4 -1 +2 +1 -5
 * -2 +1 -3 +4 -1 +2 +1 -5 +4
 * <p>
 * 1
 * 1 -3
 * 1 -3 +4
 * 1 -3 +4 -1
 * 1 -3 +4 -1 +2
 * 1 -3 +4 -1 +2 +1
 * 1 -3 +4 -1 +2 +1 -5
 * 1 -3 +4 -1 +2 +1 -5 +4
 * <p>
 * -3
 * -3 +4
 * -3 +4 -1
 * -3 +4 -1 +2
 * -3 +4 -1 +2 +1
 * -3 +4 -1 +2 +1 -5
 * -3 +4 -1 +2 +1 -5 +4
 * <p>
 * 4
 * 4 -1
 * 4 -1 +2
 * 4 -1 +2 +1
 * 4 -1 +2 +1 -5
 * 4 -1 +2 +1 -5 +4
 * <p>
 * -1
 * -1 +2
 * -1 +2 +1
 * -1 +2 +1 -5
 * -1 +2 +1 -5 +4
 * <p>
 * 2
 * 2 +1
 * 2 +1 -5
 * 2 +1 -5 +4
 * <p>
 * 1
 * 1 -5
 * 1 -5 +4
 * <p>
 * -5
 * -5 +4
 * <p>
 * 4
 **/

/**
 * 처음 시작점이 -이면 다 재끼면 되지 않을까?
 **/

public class LargestSumSubArray {
//    int largestSum = 0;
//    int startingIndexForLargestSum = -1;
//    int endIndexForLargestSum = -1;
//
//    public void sum(int[] input) {
//        for (int i = 0; i < input.length - 1; i++) {
//            int sum = input[i];
//            if (sum > largestSum) {
//                largestSum = sum;
//                startingIndexForLargestSum = i;
//                endIndexForLargestSum = -1;
//            }
//            for (int j = i + 1; j < input.length; j++) {
//                sum += input[j];
//                if (sum > largestSum) {
//                    largestSum = sum;
//                    startingIndexForLargestSum = i;
//                    endIndexForLargestSum = j;
//                }
//            }
//        }
//        System.out.printf("%d index 부터 %d index 까지의 합은 %d 이다 ", startingIndexForLargestSum, endIndexForLargestSum, largestSum);
//    }
//
//    //전부 다 음수일 경우 에러발생할것.
//    public void sumFromPositiveInteger(int[] input) {       //최초 시작점이 음수면 건너뛰자.
//        for (int i = 0; i < input.length - 1; i++) {
//            if (input[i] < 0) {
//                continue;
//            }
//            int sum = input[i];
//            if (sum > largestSum) {
//                largestSum = sum;
//                startingIndexForLargestSum = i;
//                endIndexForLargestSum = -1;
//            }
//            for (int j = i + 1; j < input.length; j++) {
//                sum += input[j];
//                if (sum > largestSum) {
//                    largestSum = sum;
//                    startingIndexForLargestSum = i;
//                    endIndexForLargestSum = j;
//                }
//            }
//        }
//        System.out.printf("%d index 부터 %d index 까지의 합은 %d 이다 ", startingIndexForLargestSum, endIndexForLargestSum, largestSum);
//    }
//
//    //잘못된풀이
//    public void getLargestSumFromLeftSide(int[] input) {
//        int startLeftIndex = 0;
//        int endLeftIndex = 0;
//        int sumWithNegativeResult = 0;
//        int largestSum = 0;
//        boolean isLargestSumStarted = false;
//        String leftMax;
//
//        /**
//         * sum 두 개 돌려.  sumWithNegativeResult, largestSum
//         * sumWithNegativeResult는 0넘는지 아닌지 체크하는 놈.
//         * largestSum은 0넘으면 그 순간부터 계쏙 더하는 놈(sumWithNegativeResult가 0이 안넘을지라도). 근데 이거 언제까지 더해야하나나         **/
//
//
//        for (int i = 0; i < input.length; i++) {
//            endLeftIndex = i;
//            leftMax = startLeftIndex + ", " + endLeftIndex + ", " + sumWithNegativeResult;
//
//
//            //0보다 커지면 다시 0으로 만들어줌
//            sumWithNegativeResult += input[i];
//            if (sumWithNegativeResult >= 0) {
//                System.out.println("index : " + i);
//                //이 조건 통과하면 i 전 까지의 합은 음수니까 재끼면된다.
//                //이 점부터 새로운 인덱스 시작
//                largestSum += input[i];
//
//                leftMax = i + ", " + i + ", " + sumWithNegativeResult;
//                System.out.println(leftMax);
//
//                sumWithNegativeResult = 0;
//
//            }
////            System.out.println("leftMax:" + leftMax);
//        }
//        System.out.println(largestSum);
//    }

    //잘된풀이. 그러나 온전히 내가 생각한 사고는 아니다.
    public void getLargestSum(int[] input) {
        int currentStart = 0;
        int currentEnd = 0;
        int currentSum = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxSum = 0;

        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                currentStart = i;
                currentEnd = i;
                currentSum = input[i];
                maxStart = i;
                maxEnd = i;
                maxSum = input[i];
                continue;
            }

            if (currentSum <= 0) {
                currentStart = i;
                currentEnd = i;
                currentSum = input[i];
                if (currentSum > maxSum) {
                    maxStart = currentStart;
                    maxEnd = currentEnd;
                    maxSum = currentSum;
                }
            } else {
                currentEnd++;
                currentSum += input[i];
                if (currentSum > maxSum) {
                    maxStart = currentStart;
                    maxEnd = currentEnd;
                    maxSum = currentSum;
                }
            }
        }

        System.out.printf("%d 부터 %d 까지의 합 %d 가 가장 크다", maxStart, maxEnd, maxSum);
    }


    public static void main(String... args) {
        LargestSumSubArray largestSumSubarray = new LargestSumSubArray();
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        largestSumSubarray.getLargestSum(input);
    }
}
