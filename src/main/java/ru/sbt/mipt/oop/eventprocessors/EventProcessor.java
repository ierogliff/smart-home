package ru.sbt.mipt.oop.eventprocessors;

import ru.sbt.mipt.oop.eventsgenerator.SensorEvent;

public interface EventProcessor {

    void onEvent(SensorEvent event);
}
