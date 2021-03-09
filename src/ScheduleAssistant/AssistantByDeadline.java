package ScheduleAssistant;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AssistantByDeadline extends PersonalAssistant {

    @Override
    public List<MySchedule> sortByCharacteristics(List<MySchedule> mySchedulesLists) {
        mySchedulesLists.sort(Comparator.comparing(MySchedule::getDeadLine));
        return mySchedulesLists;
    }

//    public void makeScheduleOverdue() {
//        //현재시각 구하기
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        //1. 정렬된 list가져온다.
//        List<MySchedule> sortedScheduleListsByDeadLine = sortByCharacteristics(mySchedulesLists);
//
//        MySchedule key = new MyScheduleWithStatus(null, null, currentTime);
//        int index = Collections.binarySearch(sortedScheduleListsByDeadLine, key, Comparator.comparing(MySchedule::getDeadLine));
//        index = (index * -1) - 1;
//
//        for (int num = index - 1; num >= 0; num--) {
//            if (sortedScheduleListsByDeadLine.get(num) instanceof MyScheduleWithStatus && ((MyScheduleWithStatus) sortedScheduleListsByDeadLine.get(num)).getStatus() == Status.OPEN) {
//                ((MyScheduleWithStatus) sortedScheduleListsByDeadLine.get(num)).setStatus(Status.OVERDUE);
//            }
//        }
//        System.out.println(sortedScheduleListsByDeadLine);
//    }

}
