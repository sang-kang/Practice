package dev.sangyoon.exercise.ex8;

import java.util.ArrayList;
import java.util.List;

/**
 * 형은 이 문제를 CombinataionSum의 방식으로 풀었고, 내 나름대로 수정한게 CombinationSumBySang
 * **/
public class SumWith123 {

    public List<List<Integer>> permute(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();

        //합이 n이 되는 경우의수를 sumEqualToNList에 넣고 얘를 또 result에 넣자
        List<Integer> listThatSumOfAllElementsIsN = new ArrayList<>();
        helper(result, listThatSumOfAllElementsIsN, nums, n);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> listThatSumOfAllElementsIsN, int[] nums, int n) {
        //1. termination
        int sum = listThatSumOfAllElementsIsN.stream().reduce(0, Integer::sum);
        if (sum == n) {
            result.add(new ArrayList<>(listThatSumOfAllElementsIsN));
            System.out.println(result);
            return;
        }

        if (sum > n) {
            return;
        }
        //2. operation
        for (int i = 0; i < nums.length; i++) {
            //nums[0] ~ nums[2]까지 한바퀴씩 다 돌아야 되니까.
            listThatSumOfAllElementsIsN.add(nums[i]);
            helper(result, listThatSumOfAllElementsIsN, nums, n);
            listThatSumOfAllElementsIsN.remove(listThatSumOfAllElementsIsN.size() - 1);
            //지금 보면 remove할때 list의 맨 마지막꺼 빼도록 코드가 작성되어있다, 코드 흐름상 봤을때 list에 add할때 맨 뒤에 삽입되어야 하는데, list자료구조는 add하는게 맨 뒤에 들어간다는 보장이 없다.
            //자바 arrayList의 경우는 add하면 맨뒤에 들어가긴 하지만. .따라서 맨 뒤에 삽입을 확실이 보장해주고, 맨뒤의 값을 제거할 수 있는 Deque 자료구조를 쓰는게 맞는 방법이다.

            //또한 나처럼 이렇게 풀거면 굳이 재귀를 할 필요가 없다 형 코드 참조하자.
        }
        //3. recursive call
    }

    public static void main(String... args) {
        int[] nums = {1, 2, 3};
        int n = 7;
        SumWith123 sumWith123 = new SumWith123();
        sumWith123.permute(nums, n);
    }
}
