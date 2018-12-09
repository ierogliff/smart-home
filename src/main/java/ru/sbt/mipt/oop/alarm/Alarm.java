package ru.sbt.mipt.oop.alarm;

public class Alarm {

    private AlarmState state = new DisabledAlarmState(this);
    private String password = "0000";

    public Alarm() {
    }

    public Alarm(String password) {
        this.password = password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void changeState(AlarmState state) {
        this.state = state;
    }

    public AlarmState getState() {
        return state;
    }

    public void activate(String password) {
        state.activate(password);
    }

    public void deactivate(String password) {
        state.deactivate(password);
    }

    public boolean checkPasswordConcept(String password) {
        return this.password.equals(password);
    }

    public void setToAlarm() {
        state.setToAlarm();
    }
}
