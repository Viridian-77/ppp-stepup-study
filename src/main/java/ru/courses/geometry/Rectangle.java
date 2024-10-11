package ru.courses.geometry;

public class Rectangle extends Shape {
    public boolean isSquare;
    public Rectangle(Point point, double a, double b) {
        super(point, a, b);
        if (a == b) isSquare = true;
    }

    public Rectangle(Point point, double a) {
        this(point, a, a);
        isSquare = true;
    }

    @Override
    public double getArea() {
        return a * b;
    }
}
