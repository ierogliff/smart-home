package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;
import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.components.Door;

import static ru.sbt.mipt.oop.eventsgenerator.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.eventsgenerator.SensorEventType.DOOR_OPEN;


public class DoorEventProcessor implements EventProcessor {


    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (!isDoorEvent(event)) {
            return;
        }

        smartHome.executeAction(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                boolean state = event.getType() == DOOR_OPEN;
                door.changeState(event.getObjectId(), state);
            }
        });
    }


    private boolean isDoorEvent(SensorEvent event) {
        if (event == null) {
            return false;
        }
        SensorEventType t = event.getType();
        return t.equals(DOOR_OPEN) || t.equals(DOOR_CLOSED);
    }

    private class DoorAction implements Action {

        @Override
        public void execute(Object object) {

        }
    }

}


