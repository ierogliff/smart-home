package ru.sbt.mipt.oop.gsonversion;

class Door {
    private final String id;
    private boolean isOpen;


    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    private void setOpen(boolean open) {
        isOpen = open;
    }
}

