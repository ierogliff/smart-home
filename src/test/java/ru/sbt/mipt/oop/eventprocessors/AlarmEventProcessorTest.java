package ru.sbt.mipt.oop.eventprocessors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)

class AlarmEventProcessorTest {


    @Mock
    private SensorEvent alarmEvent;

    @Mock
    private  SensorEvent otherEvent;

    @Mock
    private SmartHome homeMock;
    @InjectMocks
    private  AlarmEventProcessor processor;

    @Test
    void executeActionOnSmartHomeWithDoorOpenEventTest() {
        Mockito.when(alarmEvent.getObjectId()).thenReturn("0000");
        Mockito.when(alarmEvent.getType()).thenReturn(SensorEventType.ALARM_ACTIVATE);
        processor.onEvent(alarmEvent);
        Mockito.verify(homeMock).activateAlarm("0000");

    }
    @Test
    void executeActionOnSmartHomeWithDoorClosedEventTest() {
        Mockito.when(alarmEvent.getObjectId()).thenReturn("0000");
        Mockito.when(alarmEvent.getType()).thenReturn(SensorEventType.ALARM_DEACTIVATE);
        processor.onEvent(alarmEvent);
        Mockito.verify(homeMock).deactivateAlarm("0000");
    }

    @Test
    void executeActionOnSmartHomeWithOtherEventTest() {
        Mockito.when(otherEvent.getType()).thenReturn(SensorEventType.LIGHT_ON);
        processor.onEvent(otherEvent);
        Mockito.verifyNoMoreInteractions(homeMock);

    }
}
