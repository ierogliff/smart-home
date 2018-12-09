package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;

public class AllLightsOffCommand implements UndoableCommand {

    private final SmartHome smartHome;

    public AllLightsOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.allLightsOff();
    }

    @Override
    public void undo() {
        smartHome.allLightsOn();
    }

}
