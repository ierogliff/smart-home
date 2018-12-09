package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.components.Door;
import ru.sbt.mipt.oop.components.Room;

public class HallDoorCloseCommand implements UndoableCommand {

    private final SmartHome smartHome;


    public HallDoorCloseCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(object1 -> {
                        if (object1 instanceof Door) {
                            Door door = (Door) object1;
                            door.changeState(door.getId(), false);
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
                        if (object1 instanceof Door) {
                            Door door = (Door) object1;
                            door.changeState(door.getId(), true);
                        }
                    });
                }
            }
        });
    }

}
