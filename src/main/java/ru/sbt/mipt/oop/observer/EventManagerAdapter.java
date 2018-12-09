package ru.sbt.mipt.oop.observer;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.eventprocessors.EventProcessor;

public class EventManagerAdapter implements EventManager {
    private SensorEventsManager manager;

    public EventManagerAdapter(SensorEventsManager manager) {
        this.manager = manager;
    }

    public EventManagerAdapter() {
        this.manager = new SensorEventsManager();
    }

    @Override
    public void runEventLoop() {
        manager.start();
    }

    @Override
    public void addEventProcessor(EventProcessor processor) {
        manager.registerEventHandler(new HandlerProcessorAdapter(processor));
    }
}
