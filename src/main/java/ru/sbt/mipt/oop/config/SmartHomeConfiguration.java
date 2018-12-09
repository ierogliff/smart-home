package ru.sbt.mipt.oop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.observer.EventManager;
import ru.sbt.mipt.oop.observer.EventManagerAdapter;
import ru.sbt.mipt.oop.eventprocessors.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@ComponentScan("ru.sbt.mipt.oop")
public class SmartHomeConfiguration {


    private static Collection<EventProcessor> configureEventProcessors(SmartHome smartHome) {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new SendSMSEventProcessor(new AlarmDeactivetedEventProcessor(new LightEventProcessor(smartHome),
                smartHome), smartHome));
        eventProcessors.add(new SendSMSEventProcessor(new AlarmDeactivetedEventProcessor(new DoorEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new SendSMSEventProcessor(new AlarmDeactivetedEventProcessor(new HallEventProcessor(smartHome), smartHome),
                smartHome));
        eventProcessors.add(new AlarmEventProcessor(smartHome));
        return eventProcessors;
    }

    @Bean
    public SmartHomeLoader smartHomeLoader() {
        FileSmartHomeLoader loader = new FileSmartHomeLoader();
        loader.setPath("smart-home-1.js");
        return loader;
    }

    @Bean
    public SmartHome smartHome(SmartHomeLoader smartHomeLoader) {
        SmartHome smartHome = null;
        try {
            smartHome = smartHomeLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return smartHome;
    }

    @Bean
    public EventManager eventManager(SmartHome smartHome) {
        EventManager manager = new EventManagerAdapter();
        configureManager(smartHome, manager);
        return manager;
    }

    private void configureManager(SmartHome smartHome, EventManager manager) {
        Collection<EventProcessor> processors = configureEventProcessors(smartHome);
        for (EventProcessor p : processors) {
            manager.addEventProcessor(p);
        }
    }
}
