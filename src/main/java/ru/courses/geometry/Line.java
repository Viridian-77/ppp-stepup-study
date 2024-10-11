package ru.courses.geometry;

public class Line implements Measurable {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        start = new Point(xStart, yStart);
        end = new Point(xEnd, yEnd);
    }
    //добавил проверку на null:
    public double getLength() {
        if (start == null || end == null) return 0;
        return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow((end.getY() - start.getY()), 2));
    }
    //добавил проверку на null:
    public String toString() {
        String start = this.start == null ? "null" : this.start.toString();
        String end = this.end == null ? "null" : this.end.toString();
        return String.format("Линия от %s до %s", start, end);
    }
}
