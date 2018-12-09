package ru.sbt.mipt.oop.eventprocessors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.alarm.*;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class AlarmDeactivetedEventProcessorTest {
    //@Mock
    private SensorEvent alarmEvent;

    @Mock
    private Alarm alarm;
    @Mock
    private SmartHome homeMock;
    @Mock
    private EventProcessor processor;
    @InjectMocks
    AlarmDeactivetedEventProcessor decorator;

    @Test
    void onEventWithActivatedStateTest() {
        AlarmState state = new ActivatedState(alarm, "0000");
        Mockito.when(alarm.getState()).thenReturn(state);
        Mockito.when(homeMock.getAlarm()).thenReturn(alarm);
        decorator.onEvent(alarmEvent);
        Mockito.verify(alarm).setToAlarm();
        Mockito.verifyNoMoreInteractions(processor);
    }

    @Test
    void onEventWithAlarmStateTest() {
        AlarmState state = new AlertAlarmState(alarm);
        Mockito.when(alarm.getState()).thenReturn(state);
        Mockito.when(homeMock.getAlarm()).thenReturn(alarm);
        decorator.onEvent(alarmEvent);
        Mockito.verifyNoMoreInteractions(processor);
    }
    @Test
    void onEventWithDisabledStateTest() {
        AlarmState state = new DisabledAlarmState(alarm);
        Mockito.when(alarm.getState()).thenReturn(state);
        Mockito.when(homeMock.getAlarm()).thenReturn(alarm);
        decorator.onEvent(alarmEvent);
        Mockito.verify(processor).onEvent(alarmEvent);
    }

}
