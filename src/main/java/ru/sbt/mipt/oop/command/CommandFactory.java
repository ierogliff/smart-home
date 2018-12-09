package ru.sbt.mipt.oop.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.remotecontrol.Controller;

@Component
public class CommandFactory {


    private final SmartHome smartHome;
    private final CommandHistory history;

    @Autowired
    public CommandFactory(SmartHome smartHome, CommandHistory history) {
        this.smartHome = smartHome;
        this.history = history;
    }

    public Command getCommand(CommandType type) {
        switch (type) {
            case ALL_LIGHTS_OFF:
                return new AllLightsOffCommand(smartHome);
            case ALL_LIGHTS_ON:
                return new AllLightsOnCommand(smartHome);
            case HALL_DOOR_CLOSE:
                return new HallDoorCloseCommand(smartHome);
            case HALL_LIGHTS_ON:
                return new HallLightsOnCommand(smartHome);
            case ALARM_DEACTIVATE:
                return new AwareAlarmCommand(smartHome);
            case ALARM_ACTIVATE:
                return new ActivateAlarmCommand(smartHome);
            default:
                return null;

        }
    }

    public Command getUndoCommandForController(Controller controller) {

        return new UndoCommand(controller, history);
    }

    public Command getAlarmActivate(String password) {

        return new ActivateAlarmCommand(smartHome, password);

    }

}
