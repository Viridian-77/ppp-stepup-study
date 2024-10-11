package ru.courses.geometry;

public class Color extends Property {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s цвета", name);
    }
}
