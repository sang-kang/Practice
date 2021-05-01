//package dev.sangyoon.exercise.ex5;
//
//import java.math.BigInteger;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * 문제설명
//문제 0과 1로 이루어진 이진 문자열 0101101은 0과 1의 개수의 차이가 1 이하이다. 뿐만 아니라, 첫번째 문자를 포함하는 모든 부분 문자열 0, 01, 010, 0101, 01011, 010110, 0101101 모두 0과 1의 개수의 차이가 1 이하이다.
//
//이와 같이, 이진 문자열 중에서 첫번째 문자를 포함하는 모든 부분 문자열의 0과 1의 개수의 차이가 1이하인 문자열을 균형잡힌 문자열이라 부른다. 문자열 자체도 자신의 부분 문자열이다.
//
//양의 정수 n 이 주어질 때, 길이가 n 인 이진 문자열 중에서 균형잡힌 문자열의 수를 구하는 프로그램을 작성하시오.
//
//예를 들어, n = 3인 경우에는 010, 011, 100, 101 네 개의 문자열이 균형잡힌 문자열이다.
//
//입력
//입력은 표준입력을 사용한다. 첫 번째 줄에 양의 정수 n (1 ≤ n ≤ 100,000)이 주어진다.
//
//출력
//출력은 표준출력을 사용한다. 길이가 n 인 이진 문자열 중에서 균형잡힌 문자열의 개수를 16769023로 나눈 나머지 값을 한 줄에 출력한다.
// */
//public class BalancedString {
//
//    private static final int MAX_LENGTH = 100000;
//    private Set<String> balancedStrings = new HashSet<>();
//
//    public Set<String> buildBalancedStrings(int length) {
//        balancedStrings = Arrays.stream(new String[]{"0", "1"}).collect(Collectors.toSet());
//        for(int i = 2; i <= length; i++){
//            balancedStrings = balancedStrings.stream()
//                .flatMap(string -> {
//                    long zeroCount = string.chars().filter(digit -> digit == '0').count();
//                    long oneCount = string.chars().filter(digit -> digit == '1').count();
//                    if(zeroCount > oneCount) {
//                        return Arrays.stream(new String[]{string + "1"});
//                    } else if(zeroCount < oneCount) {
//                        return Arrays.stream(new String[]{string + "0"});
//                    } else {
//                        return Arrays.stream(new String[]{string + "0", string + "1"});
//                    }
//                })
//                .collect(Collectors.toSet());
//        }
//        return balancedStrings;
//    }
//
//    public Set<String> findBalancedStrings(int length) {
//        if(length == 1) {
//            return Arrays.stream(new String[]{"0", "1"}).collect(Collectors.toSet());
//        } else if(length == 2) {
//            return Arrays.stream(new String[]{"01", "10"}).collect(Collectors.toSet());
//        }
//        for(int i = (int)Math.pow(2, length - 2); i < (int)Math.pow(2, length); i++) {
//            String binaryString = Integer.toBinaryString(i);
//            if(binaryString.length() > MAX_LENGTH) {
//                break;
//            }
//            if(binaryString.length() > length) {
//                break;
//            }
//            String zeroPaddedString = String.format("%" + length + "s", binaryString).replace(' ', '0');
//            if(isBalancedString(zeroPaddedString)) {
//                balancedStrings.add(zeroPaddedString);
//            }
//        }
//        return balancedStrings;
//    }
//
//    public BigInteger countBalancedStrings(int length) {
//        BigInteger zeroBalancedCount = BigInteger.ZERO;
//        BigInteger oneBalancedCount = BigInteger.TWO;
//        if(length < 1) {
//            return BigInteger.ZERO;
//        }
//        for(int i = 2; i <= length; i++){
//            BigInteger newZeroBalancedCount = oneBalancedCount;
//            BigInteger newOneBalancedCount = zeroBalancedCount.multiply(BigInteger.TWO);
//            zeroBalancedCount = newZeroBalancedCount;
//            oneBalancedCount = newOneBalancedCount;
//        }
//        return zeroBalancedCount.add(oneBalancedCount).mod(BigInteger.valueOf(16769023));
//    }
//
//    private boolean isBalancedString(String string) {
//        if(balancedStrings.contains(string)){
//            return true;
//        }
//        for(int i = 1; i <= string.length(); i++){
//            String subString = string.substring(0, i);
//            long zeroCount = subString.chars().filter(digit -> digit == '0').count();
//            long oneCount = subString.chars().filter(digit -> digit == '1').count();
//            if(Math.abs(zeroCount - oneCount) > 1){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String ... args) {
//        for (int i = 0; i < 15; i++) {
//            System.out.println(i + ": " + new BalancedString().findBalancedStrings(i).size() + ", " + new BalancedString().countBalancedStrings(i));
//            // System.out.println(i);
//            // new BalancedString().buildBalancedStrings(i).forEach(string -> System.out.println(string));
//            // System.out.println();
//        }
//        System.out.println(new BalancedString().countBalancedStrings(1000));
//    }
//
//
//}
