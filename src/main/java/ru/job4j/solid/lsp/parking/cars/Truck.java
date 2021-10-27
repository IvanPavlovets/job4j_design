package ru.job4j.solid.lsp.parking.cars;

public class Truck extends Transport {

    public Truck(String name, int size) {
        this.name = name;
        setSize(size);
    }

    @Override
    public void setSize(int size) {
        if (size > 1) {
            this.size = size;
        }
        new IllegalArgumentException("The size of the truck must be > 1!");
    }
}
