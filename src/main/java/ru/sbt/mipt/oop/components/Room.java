package ru.sbt.mipt.oop.components;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;
import ru.sbt.mipt.oop.composite.CompositeComponents;

import java.util.ArrayList;
import java.util.Collection;

public class Room implements CompositeComponents {
    private Collection<Actionable> components;

    private String name;

    public Room() {
        this.components = new ArrayList<>();
    }

    public Room(Collection<Actionable> components, String name) {
        this.components = components;
        this.name = name;
    }

    @JsonCreator
    public Room(@JsonProperty("lights") Collection<Light> lights,
                @JsonProperty("doors") Collection<Door> doors, @JsonProperty("name") String name) {
        this.name = name;
        components = new ArrayList<>();
        components.addAll(lights);
        components.addAll(doors);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Actionable> getComponents() {
        return components;
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
        if (components != null) components.forEach((c) -> c.executeAction(action));
    }
}
