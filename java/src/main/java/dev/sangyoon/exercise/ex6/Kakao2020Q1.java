package dev.sangyoon.exercise.ex6;

public class Kakao2020Q1 {
    //같은 값이 연속해서 나타나면
    //'연속'되는 수 만큼 숫자로 나타내고 해당문자 하나를 숫자뒤에 적어준다.

    //근데 위에 방법은 연속되는 문자를 1개 단위를 기준으로 한것.
    //연속되는 문자단위를 1개이상 단위로 자르면 어떻게될까? 그래서 가장 짧게 압축하려면?

    //1개 이상 단위로 문자열을 잘라 압축한 것 중에, 문자열 길이 가장 짧게하는 압축은 "몇개 단위"로 압축한 것인가.
    //해당 단위로 압축한 문자열의 사이즈를 리턴하시오

    public int showCompressedLength(String input, int number) {
        int a = 0, b = number, c = number, d = c + number;

        String xPointer;
        String yPointer;
        String str = input.substring(0, number);
        int count = 1;

        while (b <= input.length() && d <= input.length()) {        //StringIndexOufOfBoundException 일어나기 전까지
            xPointer = input.substring(a, b);
            yPointer = input.substring(c, d);

            if (xPointer.equals(yPointer)) {
                count++;
                //str += count + yPointer;    //xPointer넣든, yPointer넣든 상관없다.

                //xPointer가 yPointer보다 앞에 있는경우, yPointer만 뒤로
                if (b <= c) {
                    str += "," + count + yPointer;
                    c = d;
                    d = c + number;

                    if (d > input.length()) {
                        str += input.substring(c);
                    }

                } else if (d <= a) {    //yPointer가 xPointer보다 앞에 있는 경우, yPointer를 xPointer뒤로 옮김
                    str += "," + count + xPointer;
                    a = b;
                    b = b + number;

                    if (b > input.length()) {
                        str += input.substring(a);
                    }
                }
            } else {
                //xPointer가 yPointer보다 앞에 있는경우, xPointer를 yPointer뒤로 옮김
                if (b <= c) {
                    str += yPointer;
                    a = d;
                    b = a + number;
                    count = 1;

                    if (b > input.length()) {
                        str += input.substring(a);
                    }
                } else if (d <= a) {    //yPointer가 xPointer보다 앞에 있는 경우, yPointer를 xPointer뒤로 옮김
                    str += xPointer;
                    c = b;
                    d = c + number;
                    count = 1;
                    if (d > input.length()) {
                        str += input.substring(c);
                    }
                }
            }
        }
        System.out.println(str);
        return str.length();
    }


    private String archive(String input, int unitLength, String archived) {
        //종료조건
        if (input.length() < unitLength)
            return archived + input;


        String archivePattern = input.substring(0, unitLength);
        int repeatCount = 0;
        while (input.startsWith(archivePattern) && input.length() >= unitLength) {
            repeatCount++;
            input = input.replaceFirst(archivePattern, "");
        }
        String repeatCountString = (repeatCount == 1) ? "" : String.valueOf(repeatCount);
        archived = archived + repeatCountString + archivePattern;
        return archive(input, unitLength, archived);
    }

    public String archive(String input, int unitLength) {
        return archive(input, unitLength, "");
    }


    public static void main(String... args) {
        String input = "abcabcdede";

        Kakao2020Q1 kakao2020Q1 = new Kakao2020Q1();

        int minimumLength = kakao2020Q1.showCompressedLength(input, 2);

//        for(int i = 2; i<input.length(); i++){
//            int compressedLength = solution.showCompressedLength(input, i);
//            if(minimumLength >  compressedLength){
//                minimumLength = compressedLength;
//            }
//        }
//        System.out.println(minimumLength);
    }
}
