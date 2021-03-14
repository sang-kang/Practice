package dev.sangyoon.exercise.ex2;

import static org.junit.Assert.*;

import dev.sangyoon.exercise.ex2.FindMedian;

import org.junit.jupiter.api.Test;


public class Test {
    private FindMedian finder;

    @Test
    public void test(){
        assertEquals(1, finder.add(1));
        assertEquals(1, finder.add(5));
        assertEquals(2, finder.add(2));
        assertEquals(2, finder.add(10));
        assertEquals(2, finder.add(-99));
    }
}
