package ru.sbt.mipt.oop.alarm;

public class ActivatedState implements AlarmState {

    Alarm alarm;

    public ActivatedState(Alarm alarm, String password) {
        this.alarm = alarm;
        this.alarm.setPassword(password);
        System.out.println("Alarm is activated");
    }


    private void changeState(AlarmState state) {
        alarm.changeState(state);
    }

    @Override
    public void activate(String password) {
        System.out.println("Alarm is active");
        changeState(new AlertAlarmState(alarm));
    }

    @Override
    public void deactivate(String password) {
        if (alarm.checkPasswordConcept(password)) {
            System.out.println("Alarm is deactivated");
            changeState(new DisabledAlarmState(alarm));
        } else {
            System.out.println("Wrong password");
            changeState(new AlertAlarmState(alarm));
        }
    }

    @Override
    public void setToAlarm() {
        System.out.println("Invasion detected");
        changeState(new AlertAlarmState(alarm));
    }

}
