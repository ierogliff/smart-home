package ru.sbt.mipt.oop.loaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.utils.SmartHome;
import ru.sbt.mipt.oop.composite.Actionable;
import ru.sbt.mipt.oop.components.Room;

import java.io.IOException;
import java.util.ArrayList;

public class FileSmartHomeGsonLoaderTest {

    private FileSmartHomeLoader loader = new FileSmartHomeLoader();
    {loader.setPath("smart-home-1.js");}

    @Test
    void loadTest() {
        SmartHome home = null;
        try {
            home = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(home);
        Assertions.assertEquals(4, home.getComponents().size());
        Assertions.assertTrue(((ArrayList<Actionable>) home.getComponents()).get(0) instanceof Room);


    }
}
