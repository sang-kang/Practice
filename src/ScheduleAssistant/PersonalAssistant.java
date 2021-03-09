package ScheduleAssistant;

import java.time.LocalDateTime;
import java.util.*;

public abstract class PersonalAssistant {

    List<MySchedule> mySchedulesLists = new ArrayList<MySchedule>();

    public void addSchedule(MySchedule newSchedule) {
        mySchedulesLists.add(newSchedule);
    }

    public void completeSchedule(String whatToDo) {
        for (MySchedule mySchedule : mySchedulesLists) {
            if (mySchedule instanceof MyScheduleWithStatus && ((MyScheduleWithStatus) mySchedule).getWhatToDo().equals(whatToDo)) {
                ((MyScheduleWithStatus) mySchedule).setStatus(Status.COMPLETED);
            }
        }
        System.out.println(mySchedulesLists);

//        int i = mySchedulesLists.indexOf(scheduleToComplete);
//        ((MyScheduleWithStatus) mySchedulesLists.get(i)).setStatus(Status.COMPLETED);
    }

    //상태에 따른 조회(오버로딩)
    public void tellSchedulesAccordingToStatus() {          //네이밍의 문제.
        for (MySchedule mySchedule : mySchedulesLists) {
            if (mySchedule instanceof MyScheduleWithStatus) {
                System.out.println("what to do: " + mySchedule.getWhatToDo() + "\t" + "status: " + ((MyScheduleWithStatus) mySchedule).getStatus());
            }
        }
    }

    public void tellSchedulesAccordingToStatus(Status status) {
        for (MySchedule mySchedule : mySchedulesLists) {
            if (mySchedule instanceof MyScheduleWithStatus && ((MyScheduleWithStatus) mySchedule).getStatus().equals(status)) {
                System.out.println("what to do: " + mySchedule.getWhatToDo() + "\t" + "status: " + ((MyScheduleWithStatus) mySchedule).getStatus());
            }
        }
    }

    public abstract List<MySchedule> sortByCharacteristics(List<MySchedule> mySchedulesLists);

    public void tellWhatShouldDoInOrder(List<MySchedule> orderedScheduleLists) {


        for (int i = 0; i < orderedScheduleLists.size(); i++) {
            System.out.printf("%s ", orderedScheduleLists.get(i).getWhatToDo());    //toString returnType이 String이기 때문에 %s 사용가능
        }
        System.out.println();
    }

    public static void main(String... args) {
        PersonalAssistant personalAssistant = new AssistantByDeadline();
        //PersonalAssistant personalAssistant = new AssistantByStartTime();

        List<MySchedule> mySchedulesLists = personalAssistant.mySchedulesLists;

        LocalDateTime date1 = LocalDateTime.of(2021, 03, 01, 12, 13, 01);
        LocalDateTime date2 = LocalDateTime.of(2021, 03, 01, 12, 14, 01);
        LocalDateTime date3 = LocalDateTime.of(2021, 03, 01, 12, 15, 01);

        LocalDateTime date4 = LocalDateTime.of(2021, 10, 01, 12, 30, 03);
        LocalDateTime date5 = LocalDateTime.of(2021, 03, 04, 12, 11, 10);
        LocalDateTime date6 = LocalDateTime.of(2021, 10, 01, 12, 10, 04);

        System.out.println("스케줄 추가");
        personalAssistant.addSchedule(new MyScheduleWithStatus("clean", date1, date4));
        personalAssistant.addSchedule(new MyScheduleWithStatus("study", date2, date5));
        personalAssistant.addSchedule(new MyScheduleWithStatus("work", date3, date6));
        System.out.println();

        System.out.println("시작시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByCharacteristics(mySchedulesLists));
        System.out.println("마감시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByCharacteristics(mySchedulesLists));
        System.out.println();

        System.out.println("status를 completed로 만들기");
        personalAssistant.completeSchedule("clean");      //이게 문맥에 더 맞다.
        System.out.println();

//        if (personalAssistant instanceof AssistantByDeadline) {
//            System.out.println("Overdue 체크");
//            ((AssistantByDeadline) personalAssistant).makeScheduleOverdue();
//
//        }

        ;
//        LocalDateTime currentTime = LocalDateTime.now();
//        int clean = new MyScheduleWithStatus("clean", date1, date5).deadLine.compareTo(currentTime);
//        System.out.println("clean" + clean);


        System.out.println("상태에 따른 조회(전체일정 조회, 상태에따른 일정 조회)");
        personalAssistant.tellSchedulesAccordingToStatus();
        personalAssistant.tellSchedulesAccordingToStatus(Status.OPEN);
        System.out.println();
    }
}

