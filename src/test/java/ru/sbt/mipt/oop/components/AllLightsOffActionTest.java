package ru.sbt.mipt.oop.components;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.composite.Action;

@ExtendWith(MockitoExtension.class)
class AllLightsOffActionTest {


    @Mock
    private Light lightMock;
    @Mock
    private SmartHome smartHome; //= new SmartHome();


    @Test
    void executeActionTest() {
        Mockito.doCallRealMethod().when(smartHome).allLightsOff();
        smartHome.allLightsOff();
        Mockito.verify(smartHome).executeAction(Mockito.any());
    }

    @Test
    void executeActionOnLightTest() {

        SmartHome smartHome = new SmartHome();
        Mockito.doCallRealMethod().when(lightMock).executeAction(Mockito.any(Action.class));
        smartHome.addChild(lightMock);
        smartHome.allLightsOff();
        Mockito.verify(lightMock).executeAction(Mockito.any());
    }

}
