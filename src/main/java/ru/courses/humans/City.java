package ru.courses.humans;

import java.util.ArrayList;

public class City {
    public String name;
    public ArrayList<Route> routes;

    public City(String name, ArrayList<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public City(String name) {
        this(name, new ArrayList<>());
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void addRoute(City city, int price) {
        routes.add(new Route(city, price));
    }

    public City travelBy(int n) {
        City city = this;
        for (int i = 1; n > 0; n--, i++) {
            if (city.routes.isEmpty()) return null;
            city = city.routes.get(0).destination;
        }
        return city;
    }

    @Override
    public String toString() {
        return "ru.courses.humans.City{" +
                "name='" + name + '\'' +
                ", routes=" + routes +
                '}';
    }
}
