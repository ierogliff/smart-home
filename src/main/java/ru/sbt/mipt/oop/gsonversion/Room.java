package ru.sbt.mipt.oop.gsonversion;


import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

import java.util.Collection;

class Room implements Actionable {

    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room() {
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        //this.components = new ArrayList<>();
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public void setLights(Collection<Light> lights) {
        this.lights = lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public void setDoors(Collection<Door> doors) {
        this.doors = doors;
    }

    @Override
    public void executeAction(Action action) {

    }
}
