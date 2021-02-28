package Baseball;

import java.util.Set;

public abstract class Replier {
    int[] answerNumbers = {-1, -1, -1};

    public int[] createAnswer() {       //아웃판정된 숫자는 제외
        //answerNumbers = new int[3];

        int i = 0;
        while (i < 3) {
            int randomNum = (int) (Math.random() * 10) % 10;

            try {
                if (!getWhatOutedNumbersAre().contains(randomNum)) {
                    answerNumbers[i] = randomNum;
                    i++;
                }
            } catch (NullPointerException e) {
                //System.out.println("NullPointException \n");
                answerNumbers[i] = randomNum;
                i++;
            }
        }
        return answerNumbers;
    }

    public abstract Set<Integer> getWhatOutedNumbersAre();
}
