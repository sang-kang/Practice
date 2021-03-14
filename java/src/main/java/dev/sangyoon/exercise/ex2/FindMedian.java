package dev.sangyoon.exercise.ex2;

/**
 * 숫자를 하나씩 추가할 때마다 현재까지 추가된 수 중에서 중간에 위치한 수를 돌려준다.
 * ex) 
 * 1 -> return 1
 * 5 -> return 1
 * 2 -> return 2
 * 10 -> return 2
 * -99 -> return 2
 */
public interface FindMedian {
    int addNumber(int aNumber);
}
