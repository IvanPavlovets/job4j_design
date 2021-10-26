package ru.job4j.solid.lsp.parking.storage;

import ru.job4j.solid.lsp.parking.cars.Transport;

/**
 * Абстрактный класс парковки для грузовых и легковых машин.
 * Количество парковочных мест для каждого типа машин задается на этапе создания парковки.
 * Реализация хранения во внутренем массиве (бизнесс логика) будет представлена в классе
 * Парковки на следующем этапе.
 */
public abstract class AbstractParking implements VehicleStorage {

    private int carPlaces;
    private int truckPlaces;
    private Transport[] cars;
    private int carIndex = 0;
    private int truckIndex = 0;

    public AbstractParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        this.cars = new Transport[carPlaces + truckPlaces];
    }
}
