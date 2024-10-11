package ru.courses.humans;

public class Route {
    public City destination;
    public int price;

    public Route(City destination, int price) {
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %d рублей", destination.name, price);
    }
}
