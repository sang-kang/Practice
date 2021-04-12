package dev.sangyoon.exercise.ex0;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateValues {
    //예외케이스에 대한 질문을 안했따.
    //만약 input.txt첫째줄에 0이 있었따면 나의 코드는 어떻게 작동될까.
    public static void main(String... args) {
        try {
//            File file = new File("C:\\works\\question.txt");
            FileReader fileReader = new FileReader("C:\\works\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            //반복문의 실행될때마다 해당값을 append시켜야 하기 때문에 append: true 설정 붙여줌
            FileWriter fw = new FileWriter("C:\\works\\output.txt", true);

            //불러온 txt파일에서 첫번째줄은 질문. 이 부분은 제거
            int skippedLine = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (skippedLine == 0) {
                    skippedLine++;
                    continue;
                }
                //set에는 중복된 값 들어가지 않으므로(중복된 값 있다면 그 값은 자동적으로 지우고 set에 추가됨), array에 중복된값 없다면 array.length == numbersInQuestionSet.size() 일 것
                String[] array = line.split(" ");
                Set<String> numbersInQuestionSet = new HashSet<String>();
                Boolean doesTheSameNumberExist = false;
                for (int i = 0; i < array.length; i++) {
                    numbersInQuestionSet.add(array[i]);
                }

                if (array.length != numbersInQuestionSet.size()) {
                    doesTheSameNumberExist = true;
                }
                //FileWrither쓰려면 String으로 바꿔줘야함.
                fw.write(doesTheSameNumberExist.toString());
                fw.write("\r\n");

                //System.out.println(doesTheSameNumberExist);
            }
            fw.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

