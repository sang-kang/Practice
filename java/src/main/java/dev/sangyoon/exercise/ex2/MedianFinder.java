package dev.sangyoon.exercise.ex2;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder implements FindMedian{

    private List<Integer> numbers = new ArrayList<>();

    /**
     * 0, 0, 1, 1, 2, 2
     */
    @Override
    public int addNumber(int aNumber) {
        numbers.add(aNumber);
        numbers.sort(Integer::compareTo);
        double medianIndex = Math.floor((numbers.size() - 1) / 2.0);
        System.out.println(medianIndex);
        return numbers.get((int)medianIndex);
    }
    
}
