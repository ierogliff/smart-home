package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;

public class AwareAlarmCommand implements Command {

    private final SmartHome smartHome;


    public AwareAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().setToAlarm();
    }
}
