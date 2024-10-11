package ru.courses.animals;

public class Cuckoo extends Bird {
    {
        voice = "ку-ку";
    }
    @Override
    public void sing() {
        int count = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
