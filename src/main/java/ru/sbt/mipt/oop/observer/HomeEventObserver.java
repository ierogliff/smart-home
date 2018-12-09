package ru.sbt.mipt.oop.observer;

import ru.sbt.mipt.oop.eventsgenerator.EventSource;
import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;
import ru.sbt.mipt.oop.eventprocessors.EventProcessor;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventObserver implements EventManager {
    private Collection<EventProcessor> eventProcessors = null;
    private EventSource eventSource;


    public HomeEventObserver(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    private static void publish(SensorEvent event, Collection<EventProcessor> eventProcessors) {
        for (EventProcessor p : eventProcessors) {
            p.onEvent(event);
        }
    }

    public void runEventLoop() {
        SensorEvent event = eventSource.getNextSensorEvent();
        System.out.println("event" + event.toString());
        while (event != null) {
            System.out.println("Got event: " + event);
            publish(event, eventProcessors);
            event = eventSource.getNextSensorEvent();
        }
    }

    public void addEventProcessor(EventProcessor processor) {
        if (eventProcessors == null) eventProcessors = new ArrayList<>();
        eventProcessors.add(processor);
    }

    public void addAllEventProcessors(Collection<EventProcessor> processors) {
        if (eventProcessors == null) eventProcessors = new ArrayList<>();
        eventProcessors.addAll(processors);
    }

}
