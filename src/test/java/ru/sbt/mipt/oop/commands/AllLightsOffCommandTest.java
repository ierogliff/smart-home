package ru.sbt.mipt.oop.commands;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.command.AllLightsOffCommand;

import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class AllLightsOffCommandTest {

    @Mock
    private SmartHome smartHome;
    @InjectMocks
    private AllLightsOffCommand command;

    @Test
    void executeTest() {
        command.execute();
        Mockito.verify(smartHome).allLightsOff();
    }

    @Test
    void undoTest() {
        command.undo();
        Mockito.verify(smartHome).allLightsOn();
    }
}
