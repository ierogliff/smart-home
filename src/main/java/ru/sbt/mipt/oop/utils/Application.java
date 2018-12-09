package ru.sbt.mipt.oop.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.command.CommandFactory;
import ru.sbt.mipt.oop.command.CommandType;
import ru.sbt.mipt.oop.config.SmartHomeConfiguration;
import ru.sbt.mipt.oop.observer.EventManager;
import ru.sbt.mipt.oop.remotecontrol.Controller;
import ru.sbt.mipt.oop.remotecontrol.RemoteControlFactory;
import ru.sbt.mipt.oop.remotecontrol.RemoteControlRegistry;

public class Application {

    public static void main(String[] args)  {

        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        CommandFactory factory = context.getBean(CommandFactory.class);
        RemoteControlFactory rcFactory = context.getBean(RemoteControlFactory.class);
        Controller controller = rcFactory.newController();

        // Настройка пульта 1
        controller.setCommandOnButton("D", factory.getCommand(CommandType.HALL_DOOR_CLOSE));
        controller.setCommandOnButton("4", factory.getUndoCommandForController(controller));

        System.out.println("Execute HALL_DOOR_CLOSE");
        controller.onButtonPressed("D");
        System.out.println("Execute Undo");
        controller.onButtonPressed("4");

        RemoteControlRegistry registry = context.getBean(RemoteControlRegistry.class);
        registry.registerRemoteControl(controller);
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventLoop();
    }

}
