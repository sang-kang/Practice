package dev.sangyoon.exercise.ex3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Ex3Test {
    private PassGenerator generator = new FixedLengthSortPassGenerator();

    @Test
    public void test1() {
        assertListEquals(Arrays.asList("ac", "at", "ct"), generator.generateAll(Arrays.asList('c', 'a', 't'), 2));
    }

    @Test
    public void test2() {
        assertListEquals(
            Arrays.asList("aci", "acs", "act", "ais", "ait", "ast", "cis", "cit", "cst", "ist"), 
            generator.generateAll(Arrays.asList('c', 'a', 't', 'i', 's'), 3));
    }

    private void assertListEquals(List<String> expected, List<String> actual) {
        for(int i = 0; i < expected.size(); i++){
            assertTrue(expected.get(i).compareTo(actual.get(i)) == 0, 
            String.format("expected %s, actual %s", expected.get(i), actual.get(i)));
        }
    }
}
