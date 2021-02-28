package Baseball;

import java.util.Set;

public class SmartReplier extends Replier {

    @Override
    public Set<Integer> getWhatOutedNumbersAre() {
        Player player = Player.getInstance();
        Boolean shouldPrint = false;
        return player.implementCheckResult(answerNumbers, shouldPrint);
    }
}
