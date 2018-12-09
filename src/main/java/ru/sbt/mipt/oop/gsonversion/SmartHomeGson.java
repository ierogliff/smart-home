package ru.sbt.mipt.oop.gsonversion;

import java.util.Collection;

class SmartHomeGson {

    private Collection<Room> rooms;

    public SmartHomeGson() {
    }

    public SmartHomeGson(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }


}
