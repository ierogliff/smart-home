package ru.sbt.mipt.oop.composite;

import java.util.Collection;

public interface CompositeComponents extends Actionable {
    void addChild(Actionable component);

    void remove(Actionable component);

    Collection<Actionable> getChildren();
}
