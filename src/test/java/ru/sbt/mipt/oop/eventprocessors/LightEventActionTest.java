package ru.sbt.mipt.oop.eventprocessors;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventsgenerator.SensorEventType;
import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class LightEventActionTest {

    @Mock
    private Light lightMock;

    @Mock
    private SensorEvent eventMock;

    private SmartHome smartHome = new SmartHome();

    private  LightEventProcessor processor =  new LightEventProcessor(smartHome);


    @Test
    void executeActionOnLightTest() {
        Mockito.when(eventMock.getType()).thenReturn(SensorEventType.LIGHT_ON);
        smartHome.addChild(lightMock);
        processor.onEvent(eventMock);
        Mockito.verify(lightMock).executeAction(Mockito.any() );
    }

    @Test
    void changeStateOnDoorTest() {

        Mockito.when(eventMock.getType()).thenReturn(SensorEventType.LIGHT_OFF);
        Mockito.doCallRealMethod().when(lightMock).executeAction(Mockito.any(Action.class));
        Mockito.when(eventMock.getObjectId()).thenReturn("1");
        smartHome.addChild(lightMock);
        processor.onEvent(eventMock);
        Mockito.verify(lightMock).changeState("1", false );
    }
}
