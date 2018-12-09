package ru.sbt.mipt.oop.observer;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.eventsgenerator.EventSource;
import ru.sbt.mipt.oop.eventprocessors.EventProcessor;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;


@ExtendWith(MockitoExtension.class)
class HomeEventObserverTest {
    @Mock
    private EventSource eventSource;

    private SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
    @Mock
    private EventProcessor processor;

    @InjectMocks
    private HomeEventObserver observer;


    @Test
    void observerLoopTest() {
        Mockito.when(eventSource.getNextSensorEvent()).thenReturn(event).thenReturn(null);
        observer.addEventProcessor(processor);
        observer.runEventLoop();
        Mockito.verify(eventSource, Mockito.times(2)).getNextSensorEvent();
        Mockito.verify(processor).onEvent(event);

    }
}
