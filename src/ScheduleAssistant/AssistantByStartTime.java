package ScheduleAssistant;

import java.util.List;

public class AssistantByStartTime extends PersonalAssistant {

    @Override
    public List<MySchedule> sortByCharacteristics(List<MySchedule> mySchedulesLists) {
        //람다 활용방안1
        mySchedulesLists.sort((mySchedule1, mySchedule2) -> mySchedule1.getStartTime().compareTo(mySchedule2.getStartTime()));
        return mySchedulesLists;
    }
}
