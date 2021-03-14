package dev.sangyoon.exercise.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLengthSortPassGenerator implements PassGenerator {

    @Override
    public List<String> generateAll(List<Character> alphabets, int length) {
        if(alphabets.size() < length) {
            return Collections.emptyList();
        }
        alphabets.sort(Character::compareTo);
        List<String> result = new ArrayList<>();
        int[] indexes = new int[length];
        for(int i = 0; i < length; i++){
            indexes[i] = i;
        }
        while(true) {
            String password = Arrays.stream(indexes).mapToObj(i -> alphabets.get(i).toString()).reduce((a, b) -> a + b).get();
            if(isValidPassword(password)) {
                result.add(password);
            }
            for(int i = length - 1; i >= 0; i--){
                if(++indexes[i] < alphabets.size()) {
                    break;
                } else if(i == 0) {
                    return result;
                }
                indexes[i] = 0;
            }
        }
    }

    private boolean isValidPassword(String password) {
        boolean hasDuplicate = password.chars()
            .mapToObj(c -> Character.valueOf((char)c))
            .collect(Collectors.toSet()).size() != password.length();
        boolean isSorted = password.chars()
            .sorted()
            .mapToObj(c -> String.valueOf((char)c))
            .reduce(String::concat).get().compareTo(password) == 0;
        return !hasDuplicate && isSorted;
    }
    
}
