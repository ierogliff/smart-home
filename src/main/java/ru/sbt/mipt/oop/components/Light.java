package ru.sbt.mipt.oop.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.LeafComponents;

public class Light implements LeafComponents {
    final String TURNED_ON = " was turned on.";
    final String TURNED_OFF = " was turned off.";
    private final String id;
    private boolean isOn;

    @JsonCreator
    public Light(@JsonProperty("isOn") boolean isOn, @JsonProperty("id") String id) {
        this.id = id;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }

    private void setOn(boolean on) {
        isOn = on;
    }

    public void changeState(String componentID, boolean state) {
        if (componentID.equals(this.id)) {
            this.setOn(state);
            System.out.println("Light " + this.id + (state ? TURNED_ON : TURNED_OFF));
        }
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }


}
