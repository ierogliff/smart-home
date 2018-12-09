package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.AlertAlarmState;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.utils.SmartHome;

public class SendSMSEventProcessor implements EventProcessor {

    private final EventProcessor processor;
    private final SmartHome smartHome;

    public SendSMSEventProcessor(EventProcessor processor, SmartHome smartHome) {
        this.processor = processor;
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(SensorEvent event) {
        if (smartHome.getAlarm().getState() instanceof ActivatedState) {
            System.out.println("Invasion! " + event.toString());
            return;
        }
        if (smartHome.getAlarm().getState() instanceof AlertAlarmState) {
            System.out.println("Someone in the home! " + event.toString());
            return;
        }
        processor.onEvent(event);
    }
}
