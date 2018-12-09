package ru.sbt.mipt.oop.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.composite.Actionable;
import ru.sbt.mipt.oop.components.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class JacksonFileLoaderTest {

    @Test
    void deserializeTest() {
        SmartHome home = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            home = mapper.readValue(new File("smart-home-1.js"), SmartHome.class);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Assertions.assertNotNull(home);
        Assertions.assertEquals(4, home.getComponents().size());
        Assertions.assertTrue(((ArrayList<Actionable>) home.getComponents()).get(0) instanceof Room);

    }
}
