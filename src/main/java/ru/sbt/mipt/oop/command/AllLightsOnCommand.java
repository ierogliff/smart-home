package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;

public class AllLightsOnCommand implements UndoableCommand {
    private final SmartHome smartHome;

    public AllLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.allLightsOn();
    }

    @Override
    public void undo() {
        smartHome.allLightsOff();
    }

}
