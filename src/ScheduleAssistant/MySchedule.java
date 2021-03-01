package ScheduleAssistant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class MySchedule /*implements Comparable<MySchedule>*/ {
    private String whatToDo;
    private LocalDateTime startTime;
    private LocalDateTime deadLine;

    public MySchedule() {

    }

    public MySchedule(String whatToDo, LocalDateTime startTime, LocalDateTime deadLine) {
        this.whatToDo = whatToDo;
        this.startTime = startTime;
        this.deadLine = deadLine;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySchedule that = (MySchedule) o;
        return Objects.equals(whatToDo, that.whatToDo) && Objects.equals(startTime, that.startTime) && Objects.equals(deadLine, that.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whatToDo, startTime, deadLine);
    }

    @Override
    public String toString() {
        return "MySchedule{" +
                "whatToDo='" + whatToDo + '\'' +
                ", startTime=" + startTime +
                ", deadLine=" + deadLine +
                '}';
    }

//    @Override
//    public int compareTo(MySchedule myOtherSchedule) {
//        return this.deadLine.compareTo(myOtherSchedule.getDeadLine());
//    }     //이거 블락하면 위의 implements부분도 같이 블락.
}
