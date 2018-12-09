package ru.sbt.mipt.oop.loaders;

import ru.sbt.mipt.oop.utils.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {

    SmartHome load() throws IOException;
}
