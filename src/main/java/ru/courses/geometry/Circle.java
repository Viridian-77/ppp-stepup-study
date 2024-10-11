package ru.courses.geometry;

public class Circle extends Shape {
    public Circle(Point point, double a) {
        super(point, a, a);
    }

    @Override
    public double getArea() {
        return PI * a * b;
    }
}
