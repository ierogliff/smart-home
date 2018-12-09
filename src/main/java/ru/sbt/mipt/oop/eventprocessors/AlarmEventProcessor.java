package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;
import ru.sbt.mipt.oop.utils.SmartHome;

public class AlarmEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public AlarmEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (!isAlarmEvent(event)) {
            return;
        }
        if (event.getType() == SensorEventType.ALARM_ACTIVATE) {
            smartHome.activateAlarm(event.getObjectId());
        } else {
            smartHome.deactivateAlarm(event.getObjectId());
        }
    }

    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType().equals(SensorEventType.ALARM_ACTIVATE)
                || event.getType().equals(SensorEventType.ALARM_DEACTIVATE);
    }
}
