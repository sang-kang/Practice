package ScheduleAssistant;

import java.time.LocalDateTime;
import java.util.*;

public class PersonalAssistant {
    private static List<MySchedule> mySchedulesLists = new ArrayList<MySchedule>();

    public void addSchedule(MySchedule newSchedule) {
        mySchedulesLists.add(newSchedule);
    }

    public void completeSchedule(MySchedule scheduleToComplete) {
        for (MySchedule mySchedule : mySchedulesLists) {
            if (mySchedule.equals(scheduleToComplete)) {
                mySchedule.setStatus(Status.COMPLETED);
            }
        }
        System.out.println(mySchedulesLists);
    }

    public static void makeScheduleOverdue() {
        //현재시각 구하기
        LocalDateTime currentTime = LocalDateTime.now();

        //1. 정렬된 list가져온다.
        List<MySchedule> sortedScheduleListsByDeadLine = sortByDeadline(mySchedulesLists);

        MySchedule key = new MySchedule(null, null, currentTime);
        int index = Collections.binarySearch(sortedScheduleListsByDeadLine, key, Comparator.comparing(MySchedule::getDeadLine));
        index = (index * -1) - 1;

        for (int num = index - 1; num >= 0; num--) {
            if (sortedScheduleListsByDeadLine.get(num).getStatus() == Status.OPEN) {
                sortedScheduleListsByDeadLine.get(num).setStatus(Status.OVERDUE);
            }
        }
        System.out.println(sortedScheduleListsByDeadLine);
    }

    //상태에 따른 조회(오버로딩)
    public void tellSchedulesAccordingToStatus() {
        for (MySchedule mySchedule : mySchedulesLists) {
            System.out.println("what to do: " + mySchedule.getWhatToDo() + "\t" + "status: " + mySchedule.getStatus());
        }
    }

    public void tellSchedulesAccordingToStatus(Status status) {
        for (MySchedule mySchedule : mySchedulesLists) {
            if (mySchedule.getStatus().equals(status)) {
//                System.out.println(mySchedule);
                System.out.println("what to do: " + mySchedule.getWhatToDo() + "\t" + "status: " + mySchedule.getStatus());
            }
        }
    }

    public List<MySchedule> sortByStartTime(List<MySchedule> mySchedulesLists) {
        //람다 활용방안1
        mySchedulesLists.sort((mySchedule1, mySchedule2) -> mySchedule1.getStartTime().compareTo(mySchedule2.getStartTime()));
        return mySchedulesLists;
    }

    public static List<MySchedule> sortByDeadline(List<MySchedule> mySchedulesLists) {
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
        //List<MySchedule> mySchedulesLists = personalAssistant.mySchedulesLists;

        LocalDateTime date1 = LocalDateTime.of(2021, 03, 01, 12, 13, 01);
        LocalDateTime date2 = LocalDateTime.of(2021, 03, 01, 12, 14, 01);
        LocalDateTime date3 = LocalDateTime.of(2021, 03, 01, 12, 15, 01);

        LocalDateTime date4 = LocalDateTime.of(2021, 10, 01, 12, 30, 03);
        LocalDateTime date5 = LocalDateTime.of(2021, 03, 04, 12, 11, 10);
        LocalDateTime date6 = LocalDateTime.of(2021, 10, 01, 12, 10, 04);

        System.out.println("스케줄 추가");
        personalAssistant.addSchedule(new MySchedule("clean", date1, date4));
        personalAssistant.addSchedule(new MySchedule("study", date2, date5));
        personalAssistant.addSchedule(new MySchedule("work", date3, date6));
        System.out.println();

        System.out.println("시작시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByStartTime(mySchedulesLists));
        System.out.println("마감시간순으로 정렬");
        personalAssistant.tellWhatShouldDoInOrder(personalAssistant.sortByDeadline(mySchedulesLists));
        System.out.println();

        System.out.println("status를 completed로 만들기");
        personalAssistant.completeSchedule(new MySchedule("clean", date1, date4));
        System.out.println();


        //overdue체크. 이건Thread로 만들것, 의문은 이 부분을 makeScheduleOverdue안으로 옮기는게 낫나?
        System.out.println("Overdue 체크");
        Timer myTimer = new Timer();
        TimerTask makingScheduleOverdue = new TimerTask() {
            @Override
            public void run() {
                System.out.println("타이머 작동중");
                makeScheduleOverdue();                  //overdue적용되기전에 118번째줄이 먼저 실행된다.
            }
        };
        myTimer.scheduleAtFixedRate(makingScheduleOverdue, 0, 5 * (60 * 1000));

        System.out.println("상태에 따른 조회(전체일정 조회, 상태에따른 일정 조회)");
        personalAssistant.tellSchedulesAccordingToStatus();
        personalAssistant.tellSchedulesAccordingToStatus(Status.OPEN);
        System.out.println();


    }
}

