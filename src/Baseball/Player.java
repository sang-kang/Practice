package Baseball;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Player {
    private int[] questionNumbers;
    private int strikeCount = 0;

    //Instance
    private static Player player = new Player();

    //private construct
    private Player() {
        int first = (int) (Math.random() * 10) % 10;    //우리가 필요한건 0~9까지의 값. 10으로 나눈 나머지는 0~9사이이기에 %10한 것.
        int second = (int) (Math.random() * 10) % 10;
        int third = (int) (Math.random() * 10) % 10;
        this.questionNumbers = new int[]{first, second, third};
        System.out.printf("문제제시: %d %d %d \n", first, second, third);
    }

    public static Player getInstance() {
        return player;
    }

    public int[] setter() {
        return questionNumbers;
    }

    //replier와의 비교
    private Set<Integer> checkResult(int[] answerNumbers, Boolean shouldPrint) {
        //int strikeCount = 0;
        int ballCount = 0;
        int outCount = 0;

        Set outedAnswerNumbers = new HashSet<Integer>();

        //싱글톤으로 만들었기에 이 값은 계속 고정. 나중에 필기위해 남겨둔 문구

        for (int i = 0; i < questionNumbers.length; i++) {
            for (int j = 0; j < answerNumbers.length; j++) {
                if (i == j && questionNumbers[i] == answerNumbers[j]) {
                    strikeCount++;
                    outedAnswerNumbers.add(answerNumbers[j]);
                } else if (questionNumbers[i] == answerNumbers[j]) {
                    ballCount++;
                    outedAnswerNumbers.add(answerNumbers[j]);
                }
            }
        }
        if (strikeCount == 0 && ballCount == 0) {
            outCount++;
        }
        if (shouldPrint) {
            System.out.printf("%d Strikes! %d Balls! %d Outs! \n", strikeCount, ballCount, outCount);
        }

        return outedAnswerNumbers;
    }

    public Set<Integer> implementCheckResult(int[] answerNumbers, Boolean shouldPrint) {
        return checkResult(answerNumbers, shouldPrint);
    }


    public static void main(String... args) {
//        //QuestionNumbers
        Player player = Player.getInstance();

        //AnswerNumbers
        Replier smartReplier = new SmartReplier();
//      Replier dumbReplier = new DumbReplier();


        Boolean shouldPrint = true;
        System.out.println(player.strikeCount);
        while (player.strikeCount < 3) {
            int[] answerNumbers = smartReplier.createAnswer();
//            int[] answerNumbers = dumbReplier.createAnswer();
            player.checkResult(answerNumbers, shouldPrint);
        }

    }
}