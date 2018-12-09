package ru.sbt.mipt.oop.alarm;

public class DisabledAlarmState implements AlarmState {
    private Alarm alarm;

    public DisabledAlarmState(Alarm alarm) {
        this.alarm = alarm;
        this.alarm.setPassword("0000");
        System.out.println("Alarm is disabled");
    }


    private void changeState(AlarmState state) {
        alarm.changeState(state);
    }

    @Override
    public void activate(String password) {
        alarm.changeState(new ActivatedState(alarm, password));
        System.out.println("Alarm was activated");
    }

    @Override
    public void deactivate(String password) {
        System.out.println(" Alarm is already disabled");
    }

    @Override
    public void setToAlarm() {
        changeState(new AlertAlarmState(alarm));
    }
}
