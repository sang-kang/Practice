package ScheduleAssistant;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class MySchedule  {
    private String whatToDo;
    private LocalDateTime startTime;
    private LocalDateTime deadLine;
    private Status status;


    public MySchedule() {

    }

    public MySchedule(String whatToDo, LocalDateTime startTime, LocalDateTime deadLine) {
        this.whatToDo = whatToDo;
        this.startTime = startTime;
        this.deadLine = deadLine;
        this.status = Status.OPEN;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(whatToDo, startTime, deadLine, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySchedule that = (MySchedule) o;
        return Objects.equals(whatToDo, that.whatToDo) && Objects.equals(startTime, that.startTime) && Objects.equals(deadLine, that.deadLine) && status == that.status;
    }

    @Override
    public String toString() {
        return "MySchedule{" +
                "whatToDo='" + whatToDo + '\'' +
                ", startTime=" + startTime +
                ", deadLine=" + deadLine +
                ", status=" + status +
                '}';
    }

}
