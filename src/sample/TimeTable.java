package sample;

import javafx.beans.property.SimpleStringProperty;

public class TimeTable{

//    private String day = null;
//    private String clockIn;
//    private String clockOut;
//    private Stopwatch stopwatch;
//    private SwitchButton switchButton;
//    private int time;
//
//    public TimeTable(String day) {
//        this.day = day;
//    }
//
//    public TimeTable() {
//
//    }
//
//    public TimeTable(String sunday, String test) {
//    }
//
//    public String getDay() {
//        return day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }
//
//    public String getClockIn() {
//        return clockIn;
//    }
//
//    public void setClockIn(String clockIn) {
//        this.clockIn = clockIn;
//    }
    public final SimpleStringProperty firstName;
    public final SimpleStringProperty lastName;

    TimeTable(String fName, String lName) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }



}