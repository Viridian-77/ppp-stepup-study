package ru.courses.humans;

import java.util.ArrayList;
import java.util.List;

public final class Student {
    private List grades=new ArrayList<>();
    String name;
    Rule rule;

    public Student(String name, Rule rule) {
        this.name = name;
        this.rule = rule;
    }
    public void addGrade(int grade){
        if(rule.check(grade)) {
            grades.add(grade);
        } else {
            System.out.printf("Оценка %d не может быть добавлена данному студенту%n", grade);
        }
    }

    public String toString() {
        return "ru.courses.humans.Student{" + " grades=" + grades + ", name=" + name + '}';
    }
}