package sample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DateAndTime {
    public void GetDate() {
        LocalDate myDate = LocalDate.now();
        System.out.println("My Date =" + myDate);
    }
    public LocalTime GetTime() {
        LocalTime myTime = LocalTime.now();
        System.out.println("My Time = " + myTime);
        return myTime;
    }

    private final Date createdDate = new java.util.Date();

    public int StartTime() {
        java.util.Date now = new java.util.Date();
        return (int)((now.getTime() - this.createdDate.getTime()) / 1000);
    }

    public int EndTime(int now) {
        //java.util.Date now = new java.util.Date();
        return (int)((now - this.createdDate.getTime()) / 1000);
    }
}