package ru.sbt.mipt.oop.observer;

import ru.sbt.mipt.oop.eventprocessors.EventProcessor;

public interface EventManager {
    void runEventLoop();

    void addEventProcessor(EventProcessor processor);

}
