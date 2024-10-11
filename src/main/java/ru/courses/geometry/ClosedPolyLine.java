package ru.courses.geometry;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(Point[] points) {
        super(points);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }
    //мой метод получения длины в ru.courses.geometry.PolyLine использует getLines, его придётся переопределить
    @Override
    public Line[] getLines() {
        Line[] oldLines = super.getLines();
        Line[] lines = new Line[super.getLines().length + 1];
        for (int i = 0; i < oldLines.length; i++) {
            lines[i] = oldLines[i];
        }
        lines[lines.length - 1] = new Line(points[points.length - 1], points[0]);
        return lines;
    }
}
