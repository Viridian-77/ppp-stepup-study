package ru.courses.animals;

public class Sparrow extends Bird {
    {
        voice = "чырык";
    }

    @Override
    public void sing() {
        System.out.println(voice);
    }
}
