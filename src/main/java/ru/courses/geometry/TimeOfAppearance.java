package ru.courses.geometry;

public class TimeOfAppearance extends Property {
    private String time;

    public TimeOfAppearance(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("в %s", time);
    }
}
