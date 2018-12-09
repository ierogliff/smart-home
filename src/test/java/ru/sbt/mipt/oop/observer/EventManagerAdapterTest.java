package ru.sbt.mipt.oop.observer;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.eventprocessors.EventProcessor;

@ExtendWith(MockitoExtension.class)
class EventManagerAdapterTest {

    @Mock
    private EventProcessor processor;
    @Mock
    private SensorEventsManager manager;
    @InjectMocks
    private EventManagerAdapter adapter;

    @Test
    void addHomeEventProcessorTest() {
        adapter.addEventProcessor(processor);
        Mockito.verify(manager).registerEventHandler(Mockito.any(HandlerProcessorAdapter.class));
    }

    @Test
    void runEventLoopTest() {
        adapter.runEventLoop();
        Mockito.verify(manager).start();
    }

}
