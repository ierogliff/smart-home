package ru.sbt.mipt.oop.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbt.mipt.oop.utils.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeLoader implements SmartHomeLoader {
    private String path;


    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public SmartHome load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = new String(Files.readAllBytes(Paths.get(path)));
        return mapper.readValue(json, SmartHome.class);
    }


}
