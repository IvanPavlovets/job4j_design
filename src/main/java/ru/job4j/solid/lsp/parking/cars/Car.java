package ru.job4j.solid.lsp.parking.cars;

public class Car extends Transport {

    public Car(String name) {
        this.name = name;
        setSize(1);
    }
}
