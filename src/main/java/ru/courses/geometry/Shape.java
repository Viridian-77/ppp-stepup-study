package ru.courses.geometry;

public abstract class Shape {
    public static final double PI = 3.14;
    public Point point;
    public double a, b;

    public Shape(Point point, double a, double b) {
        this.point = point;
        this.a = a;
        this.b = b;
    }

    public abstract double getArea();
}