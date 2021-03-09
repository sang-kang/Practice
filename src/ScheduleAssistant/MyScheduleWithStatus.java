package ScheduleAssistant;

import java.time.LocalDateTime;

public class MyScheduleWithStatus extends MySchedule {
    protected Status status;

    public MyScheduleWithStatus(){

    }

    public MyScheduleWithStatus(String whatToDo, LocalDateTime startTime, LocalDateTime deadLine) {
        this.whatToDo = whatToDo;
        this.startTime = startTime;
        this.deadLine = deadLine;
        this.status = Status.OPEN;
    }

    public Status getStatus() {
//        AssistantByDeadline assistant = new AssistantByDeadline();
//        assistant.makeScheduleOverdue();
        LocalDateTime currentTime = LocalDateTime.now();
        if(this.deadLine.compareTo(currentTime) < 0){
            this.status = Status.OVERDUE;
        }
        return status;
    }

    @Override
    public String toString() {
        return "MyScheduleWithStatus{" +
                "whatToDo='" + whatToDo + '\'' +
                ", startTime=" + startTime +
                ", deadLine=" + deadLine +
                ", status=" + getStatus() +
                '}';
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
