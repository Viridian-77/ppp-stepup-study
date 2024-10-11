package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;

public class PointExtended {
    private List<Property> properties;

    public PointExtended(List<Property> properties) {
        this.properties = new ArrayList<Property>(properties);
    }

    public PointExtended() {
        this(new ArrayList<>());
    }

    public List<Property> getProperties() {
        return new ArrayList<Property>(properties);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Точка");
        for (int i = 0; i < properties.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(" ").append(properties.get(i));
        }
        return sb.toString();
    }
}
