package ru.sbt.mipt.oop.utils;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;
import ru.sbt.mipt.oop.composite.CompositeComponents;
import ru.sbt.mipt.oop.components.*;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements CompositeComponents {

    private Collection<Actionable> components;

    private Alarm alarm;

    public SmartHome() {
        components = new ArrayList<>();
        alarm = new Alarm();
    }

    @JsonCreator
    public SmartHome(@JsonProperty("rooms") Collection<Room> rooms) {
        components = new ArrayList<>();
        components.addAll(rooms);
        this.alarm = new Alarm();
    }


    public Collection<Actionable> getComponents() {
        return components;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void activateAlarm(String password) {
        this.alarm.activate(password);
    }

    public void deactivateAlarm(String password) {
        this.alarm.deactivate(password);
    }


    @Override
    public void addChild(Actionable component) {
        if (components == null) components = new ArrayList<>();
        components.add(component);
    }

    @Override
    public void remove(Actionable component) {
        components.remove(component);
    }

    @Override
    public Collection<Actionable> getChildren() {
        return components;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        if (components != null) components.forEach(c -> c.executeAction(action));
    }


    public void allLightsOff() {
        this.executeAction(object1 -> {
            if (object1 instanceof Light) {
                Light light = (Light) object1;
                light.changeState(light.getId(), false);
            }
        });
    }

    public void allLightsOn() {
        this.executeAction(object1 -> {
            if (object1 instanceof Light) {
                Light light = (Light) object1;
                light.changeState(light.getId(), true);
            }
        });
    }
}
