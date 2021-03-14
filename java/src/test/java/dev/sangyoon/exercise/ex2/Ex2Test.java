package dev.sangyoon.exercise.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class Ex2Test {
    private FindMedian finder = new MedianFinder();

    @Test
    public void test(){
        assertEquals(1, finder.addNumber(1));
        assertEquals(1, finder.addNumber(5));
        assertEquals(2, finder.addNumber(2));
        assertEquals(2, finder.addNumber(10));
        assertEquals(2, finder.addNumber(-99));
    }
}
