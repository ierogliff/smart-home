package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.components.Room;

public class HallLightsOnCommand implements UndoableCommand {
    private final SmartHome smartHome;


    public HallLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;

    }

    @Override
    public void execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(object1 -> {
                        if (object1 instanceof Light) {
                            Light light = (Light) object1;
                            light.changeState(light.getId(), true);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void undo() {
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(object1 -> {
                        if (object1 instanceof Light) {
                            Light light = (Light) object1;
                            light.changeState(light.getId(), false);
                        }
                    });
                }
            }
        });
    }
}
