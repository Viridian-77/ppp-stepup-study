package ru.courses.geometry;

public class Square {
    private Point topLeftCorner;
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        topLeftCorner = new Point(x, y);
        setSideLengthPrivate(sideLength);
    }

    public Point getTopLeftCorner() {
        return new Point(topLeftCorner.getX(), topLeftCorner.getY());
    }

    public void setTopLeftCorner(Point topLeftCorner) {
        this.topLeftCorner = new Point(topLeftCorner.getX(), topLeftCorner.getY());
    }

    public void setTopLeftCorner(int x, int y) {
        topLeftCorner = new Point(x, y);
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        setSideLengthPrivate(sideLength);
    }

    private void setSideLengthPrivate(int sideLength) {
        if (sideLength <= 0) throw new IllegalArgumentException(" Длина стороны обязана быть всегда положительной");
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return String.format("Квадрат в точке %s со стороной %d%n", topLeftCorner, sideLength);
    }
}
