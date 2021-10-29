package ru.job4j.solid.lsp.parking;

import org.junit.Test;
import ru.job4j.solid.lsp.parking.cars.Car;
import ru.job4j.solid.lsp.parking.cars.Truck;
import ru.job4j.solid.lsp.parking.storage.CarParking;

import static org.junit.Assert.assertEquals;

public class CarParkingTest {

    /**
     * Проверяем добавление автомобиля на парковку.
     */
    @Test
    public void whenAddCarToParking() {
        CarParking parking = new CarParking(12, 6);
        Car car = new Car("Toyota corolla");
        assertEquals(true, parking.park(car));
    }

    /**
     * Проверяем добавление грузовика на парковку.
     */
    @Test
    public void whenAddTruckToParking() {
        CarParking parking = new CarParking(12, 6);
        Truck truck = new Truck("KAMAZ", 3);
        assertEquals(true, parking.park(truck));
    }

    /**
     * Проверяем удаление автомобиля с парковки.
     * Смотрим что во внутренем массиве нет обьектов Car.
     */
    @Test
    public void whenRemoveCarFromParking() {
        CarParking parking = new CarParking(12, 6);
        Car car = new Car("Toyota corolla");
        parking.park(car);
        parking.remove(car.getName());
        assertEquals(null, parking.getCars()[0]);
    }

    /**
     * Проверяем удаление грузовика с парковки.
     * Смотрим что во внутренем массиве нет обьектов Truck.
     */
    @Test
    public void whenRemoveTrackFromParking() {
        CarParking parking = new CarParking(12, 6);
        Truck truck = new Truck("KAMAZ", 3);
        parking.park(truck);
        parking.remove(truck.getName());
        assertEquals(null, parking.getCars()[0]);
    }

    /**
     * Проверяем наличие проверки при задании неверного размера грузовика.
     */
    @Test (expected = IllegalArgumentException.class)
    public void whenWriteWrongArg() {
        Truck truck = new Truck("KAMAZ", 1);
    }

    /**
     * Проверяем добавление грузовика на места легковых автомобилей.
     */
    @Test
    public void whenAddTruckToCarParking() {
        CarParking parking = new CarParking(12, 0);
        Car car = new Car("Toyota corolla");
        Truck truck = new Truck("KAMAZ", 4);
        parking.park(car);
        assertEquals(true, parking.park(truck));
    }

    /**
     * Проверяем переполнение парковки.
     */
    @Test
    public void whenNoParkingPlace() {
        CarParking parking = new CarParking(3, 0);
        Car car = new Car("Toyota corolla");
        Truck truck = new Truck("KAMAZ", 2);
        parking.park(car);
        parking.park(truck);
        assertEquals(false, parking.park(car));
    }

}
