package dev.sangyoon.exercise.ex3;

import java.util.List;

/**
 * 일련의 문자들과 암호의 길이를 받아서 가능한 모든 암호를 생성한다.
 * 암호는 알파벳순으로 정렬되어있다.
 * 
 * ex) a, t, c가 주어지고 길이 2의 암호를 생성하면
 * ac, at, ct의 세가지 경우가 있다.
 */
public interface PassGenerator {
    List<String> generateAll(List<Character> alphabets, int length);
}
