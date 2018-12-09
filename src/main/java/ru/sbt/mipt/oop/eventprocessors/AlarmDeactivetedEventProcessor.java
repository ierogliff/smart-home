package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.AlertAlarmState;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.utils.SmartHome;

public class AlarmDeactivetedEventProcessor implements EventProcessor {

    private final EventProcessor processor;
    private final SmartHome smartHome;

    public AlarmDeactivetedEventProcessor(EventProcessor processor, SmartHome smartHome) {
        this.processor = processor;
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (smartHome.getAlarm().getState() instanceof ActivatedState) {
            smartHome.getAlarm().setToAlarm();
            return;
        }
        if (smartHome.getAlarm().getState() instanceof AlertAlarmState) {
            return;
        }
        processor.onEvent(event);
    }
}
