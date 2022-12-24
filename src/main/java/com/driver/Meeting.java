package com.driver;

import java.time.LocalTime;

public class Meeting {
    private LocalTime endTime;
private LocalTime startTime;
    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime=startTime;
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}
