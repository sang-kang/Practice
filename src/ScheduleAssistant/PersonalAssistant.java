package ScheduleAssistant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PersonalAssistant {
    List<MySchedule> mySchedulesLists = new ArrayList<MySchedule>();

    public List<MySchedule> sortByStartTime(List<MySchedule> mySchedulesLists) {
//        Collections.sort(mySchedulesLists);
//        return mySchedulesLists;

        mySchedulesLists.sort(new Comparator<MySchedule>() {
            @Override
            public int compare(MySchedule mySchedule1, MySchedule mySchedule2) {
                return mySchedule1.getStartTime().compareTo(mySchedule2.getStartTime());
            }
        });
        return mySchedulesLists;
    }

    public List<MySchedule> sortByDeadline(List<MySchedule> mySchedulesLists) {
//        Collections.sort(mySchedulesLists);   //이렇게 할경우 정렬기준을 startTime, deadLine 둘 중 하나로만 잡아야 하기에 사양불가.
//        return mySchedulesLists;

        mySchedulesLists.sort(new Comparator<MySchedule>() {
            @Override
            public int compare(MySchedule mySchedule1, MySchedule mySchedule2) {
                return mySchedule1.getDeadLine().compareTo(mySchedule2.getDeadLine());
            }
        });
        return mySchedulesLists;
    }

    public void tellWhatShouldDoInOrder(List<MySchedule> orderedScheduleLists) {
        for (int i = 0; i < orderedScheduleLists.size(); i++) {
            System.out.printf("%s ", orderedScheduleLists.get(i).getWhatToDo());    //toString returnType이 String이기 때문에 %s 사용가능
        }
        System.out.println();
    }

    public static void main(String... args) {
        PersonalAssistant personalAssistant = new PersonalAssistant();
        List<MySchedule> mySchedulesLists = personalAssistant.mySchedulesLists;
        LocalDateTime date1 = LocalDateTime.of(2021, 03, 01, 12, 13, 01);
        LocalDateTime date2 = LocalDateTime.of(2021, 03, 01, 12, 14, 01);
        LocalDateTime date3 = LocalDateTime.of(2021, 03, 01, 12, 15, 01);

        LocalDateTime date4 = LocalDateTime.of(2021, 10, 01, 12, 30, 03);
        LocalDateTime date5 = LocalDateTime.of(2021, 10, 01, 12, 20, 10);
        LocalDateTime date6 = LocalDateTime.of(2021, 10, 01,12, 10, 04);

        mySchedulesLists.add(new MySchedule("clean", date1, date4));
        mySchedulesLists.add(new MySchedule("study", date2, date5));
        mySchedulesLists.add(new MySchedule("work", date3, date6));

        System.out.println("시작시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByStartTime(mySchedulesLists));
        System.out.println("마감시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByDeadline(mySchedulesLists));
    }
}
