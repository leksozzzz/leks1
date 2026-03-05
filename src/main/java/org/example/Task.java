package org.example;

public class Task {
    private String name;
    private boolean isDone;


    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String toString() {
        return name;
    }
}
