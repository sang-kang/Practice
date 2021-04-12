package dev.sangyoon.exercise.ex5;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Kakao2021Q1 {
    //1단계
    public String makeSmallLetter(String new_id) {
        char[] newIdAsCharArray = new_id.toCharArray();
        for (int i = 0; i < newIdAsCharArray.length; i++) {
            if (newIdAsCharArray[i] >= 65 && newIdAsCharArray[i] <= 90) {
                //System.out.println(newIdAsCharArray[i]);
                newIdAsCharArray[i] = (char) (newIdAsCharArray[i] + 32);
                //System.out.println(newIdAsCharArray[i]);
            }
        }
        //System.out.println(newIdAsCharArray);
        String str = Stream.of(newIdAsCharArray).map(e -> new String(e)).collect(Collectors.joining());

        return str;
    }

    //2단계
    public String deleteUnauthorizedCharacter(String new_id) {
        List<Character> newIdAsCharList = new_id.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
        //System.out.println(newIdAsCharList);

        //Set<Character> charSet= new HashSet<>();


        List<Character> newList = new ArrayList<>();
        for (int i = 0; i < newIdAsCharList.size(); i++) {
            //얘들은 제거 안하는 애들.
            //사실 여기 newIdAsCharList.get(i) == 45 || newIdAsCharList.get(i) == 95 || newIdAsCharList.get(i) == 46 이 부분은 if안에 넣으면 너무 길어지니 이렇게 말고, 이거를 set이나 string에 넣어서 set에 있는지 없는지 체크하는 방법으로 하는게 좋다.
            if ((newIdAsCharList.get(i) >= 97 && newIdAsCharList.get(i) <= 122) || (newIdAsCharList.get(i) >= 48 && newIdAsCharList.get(i) <= 57)
                || newIdAsCharList.get(i) == 45 || newIdAsCharList.get(i) == 95 || newIdAsCharList.get(i) == 46) {
                //return newIdAsCharList.toString();
                newList.add(newIdAsCharList.get(i));
            }
        }
        String str = newList.stream().map(e -> e.toString()).collect(Collectors.joining());
        return str;
    }

    //3단계
    public String checkIfFullStopUsedContinuously(String new_id) {
        List<Character> newIdAsCharList = new_id.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
//비효율적이다.
//        for (int i = 0; i < newIdAsCharList.size(); i++) {
//            for (int j = 0; j < newIdAsCharList.size(); j++) {
//                //연속된 값이 .라면
//                if (newIdAsCharList.get(j) == 46 && newIdAsCharList.get(j + 1) == 46) {
//                    newIdAsCharList.remove(j);
//                }
//            }
//        }
//        System.out.println(newIdAsCharList);
//        return newIdAsCharList.toString();
//        System.out.println(newIdAsCharList);
//        for (int i = 0; i < newIdAsCharList.size() - 1; i++) {
//            for (int j = i + 1; j < newIdAsCharList.size(); j++) {
//                if (newIdAsCharList.get(i) == 46 && newIdAsCharList.get(j) == 46) {
//                    newIdAsCharList.remove(j);
//                    System.out.println(newIdAsCharList);
//                }
//            }
//        }
        List<Character> newList = new ArrayList<>();
        boolean isValueDot = false;
        for (int i = 0; i < newIdAsCharList.size(); i++) {
            //일단 첫 시작은 무조건 넣어줄 것.
            if (i == 0) {
                newList.add(newIdAsCharList.get(i));
                if (newIdAsCharList.get(i) == 46) {
                    isValueDot = true;
                }
            }
            //너무 비효율적 아래 코드 볼것
            //각 조건들이 결국 2개로 구분할 수 있다는걸 파악못했다.
            if (isValueDot && newIdAsCharList.get(i) == 46) {
                //넣지말것
            } else if (isValueDot && !(newIdAsCharList.get(i) == 46)) {
                newList.add(newIdAsCharList.get(i));
                isValueDot = false;
            } else if (!(isValueDot) && newIdAsCharList.get(i) == 46) {
                newList.add(newIdAsCharList.get(i));
                isValueDot = true;
            } else if (!(isValueDot) && !(newIdAsCharList.get(i) == 46)) {
                newList.add(newIdAsCharList.get(i));
                isValueDot = false;
            }
        }
        String str = newList.stream().map(e -> e.toString()).collect(Collectors.joining());
        return str;
    }

    //아래 두개는 문제 3에 대해 형이 준 코드
    private String removeContinuousDots(String input) {
        String ret = "";
        boolean isContinuousDot = false;
        for (char currentCharacter : input.toCharArray()) {
            if (isContinuousDot) {
                if (currentCharacter == '.') {
                    continue;
                }
            }
            isContinuousDot = (currentCharacter == '.');        //currentCharacter == '.' 라면 True반환하는거
            ret += currentCharacter;
        }
        return ret;
    }

    private String removeContinuousDots2(String input) {
        //input이 아무것도 없으면 그냥 input return왜?
        if (input.length() < 1) {
            return input;
        }

        char[] charArray = input.toCharArray();
        String ret = "" + charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            if (!(charArray[i] == '.' && charArray[i - 1] == '.')) {    //~(A and B) = -A or -B
                ret += charArray[i];
            }
        }
        return ret;
    }


    //4단계
    public String checkIfFullStropFirstOrAtLast(String new_id) {
        List<Character> newIdAsCharList = new_id.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
        //          "."
        if (newIdAsCharList.get(0) == '.') {
            newIdAsCharList.remove(0);
        }
        if (newIdAsCharList.size() != 0 && newIdAsCharList.get(newIdAsCharList.size() - 1) == '.') {
            newIdAsCharList.remove(newIdAsCharList.size() - 1);
        }

        String str = newIdAsCharList.stream().map(e -> e.toString()).collect(Collectors.joining());
        return str;
    }

    //5단계
    public String checkIfIdIsEmpty(String new_id) {
        if (new_id.isEmpty() || new_id == null) {
            new_id = "a";
        }
        return new_id;
    }

    //6단계. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    public String sliceFromSixteenth(String new_id) {
        List<Character> newIdAsCharList = new_id.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

        if (newIdAsCharList.size() > 15) {                      //인풋이 길다면 이 방식(끝에서부터 자르는방식)은 별로일수도. 인풋이 길다면 앞에서부터 15개까지 잘라서 새로운 리스트에 카피하는게 낫다.
            while (!(newIdAsCharList.size() <= 15)) {
                int i = 15;
                newIdAsCharList.remove(i);
            }
            while (newIdAsCharList.get(newIdAsCharList.size() - 1) == '.') {
                newIdAsCharList.remove(newIdAsCharList.size() - 1);
            }
        }
        String str = newIdAsCharList.stream().map(e -> e.toString()).collect(Collectors.joining());
        return str;
    }

    //7단계: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    public String checkIfLessThanTwoCharacter(String new_id) {
        List<Character> newIdAsCharList = new_id.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
        if (newIdAsCharList.size() <= 2) {
            while (!(newIdAsCharList.size() == 3)) {
                newIdAsCharList.add(newIdAsCharList.get(newIdAsCharList.size() - 1));
            }
        }

        String str = newIdAsCharList.stream().map(e -> e.toString()).collect(Collectors.joining());
        return str;
    }

    public static void main(String... args) {
        String newId = "abcdefghijklmn.p"	;

        Kakao2021Q1 kakao2021Q1 = new Kakao2021Q1();

        String answer = kakao2021Q1.makeSmallLetter(newId);
        System.out.println("1번 조건 통과후: " + answer);

        answer = kakao2021Q1.deleteUnauthorizedCharacter(answer);
        System.out.println("2번 조건 통과후: " + answer);

        answer = kakao2021Q1.removeContinuousDots(answer);
        System.out.println("3번 조건 통과후: " + answer);

        answer = kakao2021Q1.checkIfFullStropFirstOrAtLast(answer);
        System.out.println("4번 조건 통과후: " + answer);

        answer = kakao2021Q1.checkIfIdIsEmpty(answer);
        System.out.println("5번 조건 통과후: " + answer);

        answer = kakao2021Q1.sliceFromSixteenth(answer);
        System.out.println("6번 조건 통과후: " + answer);

        answer = kakao2021Q1.checkIfLessThanTwoCharacter(answer);
        System.out.println("7번 조건 통과후: " + answer);
//

        //String answer = "";

        //아이디 규칙
        //아이디 규칙에 맞지 않는 아이디 입력하면, 입력된 아이디와 유사하면서 규칙에 맞는 아이디 추천
        //아이디길이: 3~15
        //사용가능문자: 알파벳 소문자 숫자 - _ . 만 사용가능.
        //단 .은 처음과 끝에 사용불가, 연속으로 사용불가

        //1. 대문자를 소문자로
        //2. 사용가능문자 제외 모든문자 제거
        //3. .가 연속해서 나오면 하나로 바꿈
        //4. .가 처음이나 끝에 위치하면 제거
        //5. 빈 문자열이면 a 대입
        //6. 아이디길이가 16자 이상이면 16번째부터 싹 다 지움. 만약 제거 후 .가 끝에 위치한다면 해당 마침표 제거. 즉 14자 됨
        //7. 2자 이하면 마지막 문자를 3될때까지 반복해서 끝에


        //return answer;
    }
}


//
//    String answer = "";
////1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.

// 이건 정규표현식 이용한 것. 나는 지금은 이렇게 할수없다
//        answer = new_id.toLowerCase();
//                //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//                answer = answer.replaceAll("[^a-z0-9-_.]", "");
//                //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//                answer = answer.replaceAll("(\\.){2,}", ".");
//                //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//                answer = answer.replaceAll("^(\\.)|(\\.)$", "");
////5단계 new_id가 빈 문자
