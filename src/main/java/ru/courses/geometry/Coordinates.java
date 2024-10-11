package ru.courses.geometry;

public class Coordinates extends Property {
    private int[] coordinates;

    public Coordinates(int... coordinates) {
        if (coordinates.length > 3) throw new IllegalArgumentException("Не обрабатываем точки у которых координаты больше 3х измерений");
        if (coordinates.length == 0) throw new IllegalArgumentException("Укажите хотя бы одно измерение");
        this.coordinates = coordinates;
    }
    //возвращсаем мас
    public int[] getCoordinates() {
        int[] res = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            res[i] = coordinates[i];
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("в координате {");
        for (int i = 0; i < coordinates.length; i++) {
            sb.append(coordinates[i]);
            if (i < coordinates.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
