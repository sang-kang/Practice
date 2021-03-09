package ScheduleAssistant;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import static org.junit.jupiter.api.Assertions.*;

class PersonalAssistantTest {

    @Test
    void addSchedule() {
        List<MySchedule> mySchedulesLists = new ArrayList<MySchedule>();

        LocalDateTime time = LocalDateTime.of(2021,03,02,01,02,03);
        LocalDateTime time2 = LocalDateTime.of(2021,04,02,01,02,03);

        MySchedule schedule = new MySchedule("잠자기", time, time2);

        assertEquals(0, mySchedulesLists.size());
    }
}