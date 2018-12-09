package ru.sbt.mipt.oop.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.command.HallLightsOnCommand;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class HallLightsOnCommandTest {

    @Mock
    private SmartHome smartHome;
    //@InjectMocks
    private HallLightsOnCommand command;
    @Test
    void executeTest() {
        command = new HallLightsOnCommand(smartHome);
        command.execute();
        Mockito.verify(smartHome).executeAction(Mockito.any());
    }

    @Test
    void undoTest() {
        command = new HallLightsOnCommand(smartHome);
        command.undo();
        Mockito.verify(smartHome).executeAction(Mockito.any());
    }



}
