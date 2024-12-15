package edu.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student("Petya");
        student.addGrade(5);
        System.out.println(student);
    }
}

class Student {
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.grades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.grades, other.grades);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", marks=" + grades + '}';
    }
}


class Tests {
    //Использовал ValueSource для тренировки
    @ParameterizedTest(name = "Корректные оценки добавляются")
    @ValueSource(ints = {2, 3, 4, 5})
    public void testCorrectGrades(int x) {
        Student s = new Student("Petya");
        s.addGrade(x);
        Assertions.assertEquals(x, s.getGrades().get(0));
    }

    @ParameterizedTest(name = "Некорректные оценки не добавляются")
    @MethodSource("edu.innotech.Generators#negativeGradeGenerator")
    public void testIncorrectGrades(int x) {
        Student s = new Student("Petya");
        Assertions.assertThrows(IllegalArgumentException.class, () -> s.addGrade(x));
    }

    @ParameterizedTest(name = "Инкапсуляция оценок")
    @MethodSource("edu.innotech.Generators#negativeGradeGenerator")
    public void testEncapsulation(int x) {
        Student s = new Student("Petya");
        s.getGrades().add(x);
        Assertions.assertIterableEquals(new ArrayList<Integer>(), s.getGrades());
    }

    @Test
    @DisplayName("Установка имени в конструкторе")
    public void testNameInConstructor() {
        String name = "Petya";
        Student s = new Student(name);
        Assertions.assertEquals(name, s.getName());
    }

    @Test
    @DisplayName("Установка имени в сеттере")
    public void testSetName() {
        String name1 = "Petya";
        String name2 = "Vasya";
        Student s = new Student(name1);
        s.setName(name2);
        Assertions.assertEquals(name2, s.getName());
    }

    @Test
    @DisplayName("Приведение к строке")
    public void testToString() {
        String result = "Student{name=Petya, marks=[2, 3, 4, 5]}";
        Student s = new Student("Petya");
        Generators.positiveGradeGenerator()
                .forEach(s::addGrade);
        Assertions.assertEquals(result, s.toString());
    }

    @Test
    @DisplayName("Сравнение студентов с одинаковыми параметрами")
    public void testEquals() {
        Student s1 = new Student(new String("Petya"));
        Student s2 = new Student(new String("Petya"));
        Generators.positiveGradeGenerator()
                .forEach(i -> {
                    s1.addGrade(i);
                    s2.addGrade(i);
                });
        Assertions.assertEquals(s1, s2);
    }

    @Test
    @DisplayName("Сравнение хешкодов студентов с одинаковыми параметрами")
    public void testEqualsHashCode() {
        Student s1 = new Student(new String("Petya"));
        Student s2 = new Student(new String("Petya"));
        Generators.positiveGradeGenerator()
                .forEach(i -> {
                    s1.addGrade(i);
                    s2.addGrade(i);
                });
        Assertions.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    @DisplayName("Сравнение студентов с разными именами")
    public void testNotEqualsDifferentNames() {
        Student s1 = new Student("Petya");
        Student s2 = new Student("Vasya");
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    @DisplayName("Сравнение студента с самим собой")
    public void testEqualsWithSelf() {
        Student s1 = new Student("Petya");
        Generators.positiveGradeGenerator()
                .forEach(s1::addGrade);
        Student s2 = s1;
        Assertions.assertEquals(s1, s2);
    }

    @Test
    @DisplayName("Сравнение студента с null")
    public void testNotEqualsNull() {
        Student s1 = new Student("Petya");
        Student s2 = null;
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    @DisplayName("Сравнение студента с объектом другого класса")
    public void testNotEqualsOtherClass() {
        Student s1 = new Student("Petya");
        Object o = "Petya";
        Assertions.assertNotEquals(s1, o);
    }
}

class Generators {
    public static Stream<Integer> negativeGradeGenerator() {
        return Stream.of(-1, 1, 6, Integer.MAX_VALUE);
    }

    public static Stream<Integer> positiveGradeGenerator() {
        return Stream.of(2, 3, 4, 5);
    }
}