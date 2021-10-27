package ru.job4j.solid.lsp.parking.storage;

import ru.job4j.solid.lsp.parking.cars.Transport;

public class CarParking extends AbstractParking {

    public CarParking(int carPlaces, int truckPlaces) {
        super(carPlaces, truckPlaces);
    }

    @Override
    public boolean park(Transport car) {
        return false;
    }

    @Override
    public boolean remove(Transport car) {
        return false;
    }
}
