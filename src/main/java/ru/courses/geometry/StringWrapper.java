package ru.courses.geometry;

public class StringWrapper implements Measurable {
    private String str;

    public StringWrapper(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public double getLength() {
        return str.length();
    }
}