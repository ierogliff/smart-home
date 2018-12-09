package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.components.Room;

public class HallEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (!event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            return;
        }
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    smartHome.allLightsOff();
                }
            }
        });
    }
}
