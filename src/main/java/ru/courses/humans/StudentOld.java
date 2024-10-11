package ru.courses.humans;

import java.util.ArrayList;

public class StudentOld {
    private String name;
    private ArrayList<Integer> grades;

    public StudentOld(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
    }

    public StudentOld(String name) {
        this(name, new ArrayList<Integer>());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return new ArrayList<Integer>(grades);
    }
    //добавляем оценки по одной
    public void addGrade(int x) {
        addGradePrivate(x);
    }
    //добавляем список оценок
    public void addGrades(ArrayList<Integer> grades) {
        for (Integer grade : grades) {
            addGradePrivate(grade);
        }
    }

    private void addGradePrivate(int x) {
        if (x<2 || x>5) throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
        grades.add(x);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, grades);
    }
}
