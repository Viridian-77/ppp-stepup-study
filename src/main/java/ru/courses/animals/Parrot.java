package ru.courses.animals;

public class Parrot extends Bird {
    public Parrot(String text) {
        this.voice = text;
    }

    @Override
    public void sing() {
        int symbolsToSing = (int) (Math.random() * voice.length() + 1);
        System.out.println(voice.substring(0, symbolsToSing));
    }
}
