package ru.sbt.mipt.oop.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.command.ActivateAlarmCommand;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class ActivateAlarmCommandTest {

    @Mock
    private SmartHome home;
    @Mock
    private Alarm alarm;
    private ru.sbt.mipt.oop.command.ActivateAlarmCommand command;

    @Test
    void executeTest() {
        Mockito.when(home.getAlarm()).thenReturn(alarm);
        command = new ru.sbt.mipt.oop.command.ActivateAlarmCommand(home);
        command.execute();
        Mockito.verify(alarm).activate(Mockito.anyString());
    }


}
