import com.oracle.webservices.internal.api.message.PropertySet;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Question1 {
    //예외케이스에 대한 질문을 안했따.
    public static void main(String... args) {
        try {
//            File file = new File("C:\\works\\question.txt");
            FileReader fileReader = new FileReader("C:\\works\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";


            FileWriter fw = new FileWriter("C:\\works\\output.txt", true);

            int skippedLine = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (skippedLine == 0) {
                    skippedLine++;
                    continue;
                }
                String[] array = line.split(" ");
                Set<String> numbersInQuestionSet = new HashSet<String>();
                Boolean doesTheSameNumberExist = false;
                for (int i = 0; i < array.length; i++) {
                    numbersInQuestionSet.add(array[i]);
                }

                if (array.length != numbersInQuestionSet.size()) {
                    doesTheSameNumberExist = true;
                }
                fw.write(doesTheSameNumberExist.toString());
                fw.write("\r\n");

                System.out.println(doesTheSameNumberExist);
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
