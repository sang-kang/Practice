package dev.sangyoon.exercise.ex8;

import java.util.stream.IntStream;

/**
 * 숫자 N이 주어졌을때 1,2,3 을 반복적으로 사용하여 합이 N이 되는 경우의 수를 구하시오.
 * 단, N의 최대값은 10이다.
 * <p>
 * ex) N = 3 answer 4 because there are 111, 12, 21, 3
 * ex) N = 4 answer 7 because there are 1111, 211, 121, 112, 22, 13, 31
 */
public class CombinationSumBySang {

    class TreeNode {
        private int value;
        private TreeNode[] children = new TreeNode[3];
        TreeNode parent = null;

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode addChild(int value) {
            if (value > 3 || value < 1) {
                throw new IllegalArgumentException("Number 1 to 3 is allowed");
            }
            if (this.children[value - 1] != null) {
                throw new IllegalStateException("Child with value " + value + " already exist");
            }
            this.children[value - 1] = new TreeNode(value);
            this.children[value - 1].parent = this;
            return this.children[value - 1];
        }

        public boolean hasParent() {
            return parent != null;
        }

        public TreeNode getParent() {
            return parent;
        }

        public int getValue() {
            return this.value;
        }
    }


    private int findNumbersSumTo(int n) {
        TreeNode root = new TreeNode(n);
        int sum = 0;
        for (int i = 1; i < 4; i++) {
            int addNumber = addNumber(root, n, 0, i);
            sum += addNumber;
        }
        return sum;
    }

    private int addNumber(TreeNode parent, int targetSum, int currentSum, int value) {
        //termination
        if (currentSum + value == targetSum) {
            System.out.print(value);
            while (parent.hasParent()) {
                System.out.print(parent.getValue());
                parent = parent.getParent();
            }
            System.out.println();
            return 1;
        } /*else if (currentSum + value > targetSum) {        //else if죽이고 밑에 break문 살릴것. break문 살리면 else if죽여도 됨.
            return 0;
        }*/

        TreeNode current = parent.addChild(value);
        int sum = 0;
        for (int i = 1; i < 4; i++) {
             int addNumber = addNumber(current, targetSum,  currentSum + value, i);
            sum += addNumber;
            if (currentSum + value + i >= targetSum) {
                break;
            }
        }
        return sum;
        //recursive call
    }

    public static void main(String... args) {
        CombinationSumBySang combinationSumBySang = new CombinationSumBySang();
        System.out.println("total:" + combinationSumBySang.findNumbersSumTo(4));
    }
}
