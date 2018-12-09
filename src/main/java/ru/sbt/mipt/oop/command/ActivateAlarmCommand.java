package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;

public class ActivateAlarmCommand implements Command {

    private final SmartHome smartHome;
    private final String password;


    public ActivateAlarmCommand(SmartHome smartHome, String password) {
        this.smartHome = smartHome;
        this.password = password;
    }

    public ActivateAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
        password = "12345"; // default password
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(password);
    }
}
