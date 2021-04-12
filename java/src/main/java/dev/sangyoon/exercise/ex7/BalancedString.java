package dev.sangyoon.exercise.ex7;

/**이거 해결못했음**/


/**
 * 문제설명
 * 문제 0과 1로 이루어진 이진 문자열 0101101은 0과 1의 개수의 차이가 1 이하이다. 뿐만 아니라, 첫번째 문자를 포함하는 모든 부분 문자열 0, 01, 010, 0101, 01011, 010110, 0101101 모두 0과 1의 개수의 차이가 1 이하이다.
 * 0한개 1은 0개, 0한개 1한개
 * 이와 같이, 이진 문자열 중에서 첫번째 문자를 포함하는 모든 부분 문자열의 0과 1의 개수의 차이가 1이하인 문자열을 균형잡힌 문자열이라 부른다. 문자열 자체도 자신의 부분 문자열이다.
 * 양의 정수 n 이 주어질 때, 길이가 n 인 이진 문자열 중에서 균형잡힌 문자열의 수를 구하는 프로그램을 작성하시오.
 * 예를 들어, n = 3인 경우에는 010, 011, 100, 101 네 개의 문자열이 균형잡힌 문자열이다.
 * <p>
 * 입력
 * 입력은 표준입력을 사용한다. 첫 번째 줄에 양의 정수 n (1 ≤ n ≤ 100,000)이 주어진다.
 * <p>
 * 출력
 * 출력은 표준출력을 사용한다. 길이가 n 인 이진 문자열 중에서 균형잡힌 문자열의 개수를 16769023로 나눈 나머지 값을 한 줄에 출력한다.
 **/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 0과 1의 개수 차이가 1 이하.
 * 전체 문자열에서 0과 1의 개수의 차이도 1이하이고, '첫번째 문자'에서 시작하는 모든 부분문자열도 0과 1의 개수의 차이가 1이하이다. 균형잡힌 문자열이라 부른다.
 * <p>
 * 양의정수 n이 주어졌을때, 길이가 n인 이진문자열. 즉 n = 3이면 000, 001, 010, 011, 100, 101, 110, 111 가 이진문자열 전체경우의수
 * 길이가 n인 이진문자열 중에 균형잡힌 문자열의 수를 구하라. 이 중에서 균형잡힌 문자열은 0, 1 // 01, 010, 011 // 10, 100, 101이다.
 * 결과값 = '길이가 n' 인 균형잡힌 문자열의 개수 % 16769023
 * <p>
 * 첫번쨰 문자가 0이면 그 다음 문자는 반드시 1이어야 한다. 그 다음은 0이나 1이나 상관없다
 * <p>
 * 첫번쨰 문자가 1이면 그 다음 문자는 반드시 0이어야 한다. 그 다음은 0이나 1이나 상관없다.
 * 10 0
 * 1
 **/

public class BalancedString {
    //질문할 것 : 시간복잡도
    //밑에 16769023 이 수는 어디서 나온걸까?

//    public int getTheNumberOfBalancedStrings(int n) {
//      수식으로 푸는건 증명할 수 있을때만, 그리고 프로그램 연습하는 지금은 이렇게 하면 안좋다.
//        //n = 1     2개
//        //n = 2     2개
//
//        //n = 3     4개
//        //n = 4     4개
//
//        //n = 5     8개
//        //n = 6     8개
//
//        //n = 7     16개
//        //n = 8     16개
//
//        //n = 9     32개
//        //n = 10    32개
//
//        //수식 어떻게 짜야할까...
//        //n * 뭐 = 4 이렇게 나와야 하는데..
//        //일단 홀수 짝수 나눠서 생각해야 될거같다.
////        int pow = (int) Math.pow(2, n - n / 2);     //9 - 4.5
////        System.out.println(pow);
//
//        return (int) Math.pow(2, n - n / 2);     // 9/2 = 4.5인데 4로 바뀌나?
//    }

    public void getTheNumberOfBalancedStrings(int n) {
        //int n = 4;
        Set<List<Integer>> numberOfCasesSet = new HashSet<>();

        int[] arr = {0, 1};
//        int[] output = new int[n];
        List<Integer> output = new ArrayList<>(4);
        output.add(0);
        output.add(0);
        output.add(0);
        output.add(0);
        numberOfCasesSet.add(output);
//        System.out.println(output);

        int totalNumberOfCases = (int) Math.pow(2, n);
        for (int i = 0; i < totalNumberOfCases; i++) {
            //일단 0000부터 시작,
            if (output.get(output.size() - 1) == 0) {
                output.set(output.size() - 1, 1);
                numberOfCasesSet.add(output);
                //현재 상태 0001
            } else if (output.get(output.size() - 1) == 1) {
                output.set(output.size() - 1, 0);
                numberOfCasesSet.add(output);

            }
        }
    }

    public static void main(String... args) {
        int n = 4;
        BalancedString balancedString = new BalancedString();
        balancedString.getTheNumberOfBalancedStrings(n);
//        int numberOfBalancedStrings = balancedString.getTheNumberOfBalancedStrings(n);
//        int result = numberOfBalancedStrings % 16769023;        //16769023 이 수는 어디서 나온걸까?
//        System.out.println(result);
    }
}
