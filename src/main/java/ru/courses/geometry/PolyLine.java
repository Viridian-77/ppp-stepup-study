package ru.courses.geometry;

public class PolyLine implements Measurable {
    Point[] points;

    public PolyLine(Point[] points) {
        this.points = points;
    }

    public PolyLine() {};

    public Line[] getLines() {
        if (points == null || points.length == 1) return new Line[0];
        Line[] lines = new Line[points.length - 1];
        for (int i = 0; i < points.length - 1; i++) {
            //поверка на null:
            if (points[i]==null || points[i+1] == null) continue;
            lines[i] = new Line(points[i], points[i+1]);
        }
        return lines;
    }

    public double getLength() {
        double res = 0;
        Line[] lines = this.getLines();
        for (Line line : lines) {
            res += line.getLength();
        }
        return res;
    }

    public String toString() {
        String res = "Линия [";
        if (points != null && points.length > 0) {
            for (int i = 0; i < points.length - 1; i++) {
                if (points[i] != null) {
                    res += points[i].toString() + ",";
                } else {
                    res += "null,";
                }
            }
            if (points[points.length - 1] != null) {
                res += points[points.length - 1].toString();
            } else {
                res += "null";
            }
        }
        res += "]";
        return res;
    }
}
