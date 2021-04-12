package dev.sangyoon.exercise.ex2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 숫자를 하나씩 추가할 때마다 현재까지 추가된 수 중에서 중간에 위치한 수를 돌려준다.
 * ex)
 * 1 -> return 1
 * 5 -> return 1
 * 2 -> return 2
 * 10 -> return 2
 * -99 -> return 2
 */
public class FindMedianImpl implements FindMedian {
    List<Integer> addedNumberLists = new ArrayList<Integer>();

    @Override
    public int addNumber(int aNumber) {
        addedNumberLists.add(aNumber);
        Collections.sort(addedNumberLists);                     //5
        //System.out.println(addedNumberLists);
        int medianIndex = addedNumberLists.size() / 2;          //1/2 = 0.5 = 0

        //답은 맞지만 수식이 이상하다. 형꺼(MedianFinder) 참조할것.
        if (addedNumberLists.size() % 2 == 0 && medianIndex != 0) {
            medianIndex--;
        }

        int median = addedNumberLists.get(medianIndex);
        return median;
    }

}
