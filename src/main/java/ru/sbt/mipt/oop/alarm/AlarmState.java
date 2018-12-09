package ru.sbt.mipt.oop.alarm;

public interface AlarmState {


    void activate(String password);

    void deactivate(String password);

    void setToAlarm();


}
