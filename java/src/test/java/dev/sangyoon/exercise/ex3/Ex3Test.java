package dev.sangyoon.exercise.ex3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Ex3Test {
    private PassGenerator generator;

    @Test
    public void test() {
        assertListEquals(Arrays.asList("ac, at"), generator.generateAll(Arrays.asList('c', 'a', 't'), 2));
    }

    private void assertListEquals(List<String> expected, List<String> actual) {
        for(int i = 0; i < expected.size(); i++){
            assertTrue(expected.get(i).compareTo(actual.get(i)) == 0, String.format("expected %s, actual %s", expected.get(i), actual.get(i));
        }
    }
}
