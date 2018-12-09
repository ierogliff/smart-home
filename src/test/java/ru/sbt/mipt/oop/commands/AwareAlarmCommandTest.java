package ru.sbt.mipt.oop.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.command.AwareAlarmCommand;
import ru.sbt.mipt.oop.utils.SmartHome;

@ExtendWith(MockitoExtension.class)
class AwareAlarmCommandTest {

    @Mock
    private SmartHome home;
    @Mock
    private Alarm alarm;
    private ru.sbt.mipt.oop.command.AwareAlarmCommand command;

    @Test
    void executeTest() {
        Mockito.when(home.getAlarm()).thenReturn(alarm);
        command = new ru.sbt.mipt.oop.command.AwareAlarmCommand(home);
        command.execute();
        Mockito.verify(alarm).setToAlarm();
    }

}
