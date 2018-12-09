package ru.sbt.mipt.oop.alarm;

public class AlertAlarmState implements AlarmState {

    private Alarm alarm;


    public AlertAlarmState(Alarm alarm) {
        this.alarm = alarm;
        System.out.println("ALARM");
    }


    @Override
    public void activate(String password) {

        System.out.println("ALARM! Someone try to change password!");

    }

    @Override
    public void deactivate(String password) {

        if (alarm.checkPasswordConcept(password)) {
            alarm.changeState(new DisabledAlarmState(alarm));
            System.out.println("Alarm is disabled");
        } else {
            System.out.println("ALARM! Wrong password!");
        }
    }

    @Override
    public void setToAlarm() {

    }
}
