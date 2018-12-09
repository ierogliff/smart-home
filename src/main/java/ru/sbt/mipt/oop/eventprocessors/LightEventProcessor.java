package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.components.Light;

import static ru.sbt.mipt.oop.eventsgenerator.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.eventsgenerator.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private boolean isLightEvent(SensorEvent event) {
        if (event == null) return false;
        return event.getType().equals(LIGHT_ON) || event.getType().equals(LIGHT_OFF);
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (!isLightEvent(event)) {
            return;
        }
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                boolean state = event.getType() == LIGHT_ON;
                light.changeState(event.getObjectId(), state);
            }
        });
    }


}
