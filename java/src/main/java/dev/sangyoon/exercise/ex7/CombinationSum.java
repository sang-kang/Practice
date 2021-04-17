package dev.sangyoon.exercise.ex7;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 숫자 N이 주어졌을때 1,2,3 을 반복적으로 사용하여 합이 N이 되는 경우의 수를 구하시오.
 * 단, N의 최대값은 10이다.
 * 
 * ex) N = 3 answer 4 because there are 111, 12, 21, 3
 * ex) N = 4 answer 7 because there are 1111, 211, 121, 112, 22, 13, 31
 */
public class CombinationSum {

    class TreeNode {
        private int value;
        private TreeNode[] children = new TreeNode[3];
        TreeNode parent = null;

        public TreeNode() {}

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode addChild(int value) {
            if(value > 3 || value < 1) {
                throw new IllegalArgumentException("Number 1 to 3 is allowed");
            }
            if(this.children[value - 1] != null) {
                throw new IllegalStateException("Child with value " + value + " already exist");
            }
            this.children[value - 1] = new TreeNode(value);
            this.children[value - 1].parent = this;
            return this.children[value - 1];
        }

        public boolean hasParent(){
            return parent != null;
        }

        public TreeNode getParent() {
            return parent;
        }

        public int getValue() {
            return this.value;
        }
    }

    // Solution #1 Recursive
    public int findNumbersSumTo(int n) {
        TreeNode root = new TreeNode();
        return IntStream.range(1, 4)
            .map(i -> addNumber(root, n, 0, i))
            .sum();
    }

    private int addNumber(TreeNode parent, int targetSum, int currentSum, int value){
        if(currentSum + value == targetSum) {
            System.out.print(value);
            while(parent.hasParent()){
                System.out.print(parent.getValue());
                parent = parent.getParent();
            }
            System.out.println();
            return 1;
        } else if(currentSum + value > targetSum) {
            return 0;
        }
        TreeNode current = parent.addChild(value);
        return IntStream.range(1, 4)
            .map(i -> addNumber(current, targetSum, currentSum + value, i))
            .sum();    
    }

    //Solution #2 Loop with queue
    public int findNumbersSumTo2(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(Integer.valueOf(0));
        int ret = 0;
        while(!queue.isEmpty()){
            Integer currentSum = queue.poll();
            ret += IntStream.range(1, 4)
                .map(value -> {
                    int newSum = currentSum + value;
                    if(newSum == n) {
                        return 1;
                    } else if(newSum < n) {
                        queue.add(newSum);
                    }
                    return 0;
                })
                .sum();
        }
        return ret;
    }


    public static void main(String ... args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println("total:" + combinationSum.findNumbersSumTo(10));
        System.out.println("total:" + combinationSum.findNumbersSumTo2(10));
    }
}
