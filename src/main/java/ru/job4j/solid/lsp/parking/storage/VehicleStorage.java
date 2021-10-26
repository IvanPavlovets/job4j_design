package ru.job4j.solid.lsp.parking.storage;

import ru.job4j.solid.lsp.parking.cars.Transport;

/**
 * Интерфейс хранилища транспортных средств,
 * фактически имитация коллекции или хранилища из задания tracker.
 */
public interface VehicleStorage {
    /**
     * Добавить транспортное средство на парковку.
     * @param car
     * @return
     */
    Transport park(Transport car);

    /**
     * Убрать транспортное средство с парковки.
     * @param car
     * @return
     */
    boolean remove(Transport car);

}
