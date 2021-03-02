package ScheduleAssistant;

import java.time.LocalDateTime;
import java.util.*;

public class PersonalAssistant {
    List<MySchedule> mySchedulesLists = new ArrayList<MySchedule>();

    public void addSchedule(MySchedule newSchedule) {
        mySchedulesLists.add(newSchedule);
    }

    public List<MySchedule> sortByStartTime(List<MySchedule> mySchedulesLists) {
        //람다 활용방안1
        mySchedulesLists.sort((mySchedule1, mySchedule2) -> mySchedule1.getStartTime().compareTo(mySchedule2.getStartTime()));
        return mySchedulesLists;
    }

    public List<MySchedule> sortByDeadline(List<MySchedule> mySchedulesLists) {
        //람다 활용방안2
        mySchedulesLists.sort(Comparator.comparing(MySchedule::getDeadLine));
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
        LocalDateTime date6 = LocalDateTime.of(2021, 10, 01, 12, 10, 04);

        //비서에게 말해서 스케쥴 추가.
        personalAssistant.addSchedule(new MySchedule("clean", date1, date4));
        personalAssistant.addSchedule(new MySchedule("study", date2, date5));
        personalAssistant.addSchedule(new MySchedule("work", date3, date6));

        System.out.println("시작시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByStartTime(mySchedulesLists));
        System.out.println("마감시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByDeadline(mySchedulesLists));
    }
}
