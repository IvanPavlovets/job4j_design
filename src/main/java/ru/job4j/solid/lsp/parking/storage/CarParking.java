package ru.job4j.solid.lsp.parking.storage;

import ru.job4j.solid.lsp.parking.cars.Transport;

public class CarParking extends AbstractParking {

    public CarParking(int carPlaces, int truckPlaces) {
        super(carPlaces, truckPlaces);
    }

    /**
     * Метод добавления автомобиля на парковку.
     * Условие для легковых машин:
     * ((car.getSize() == 1) && (carPlaces > 0))
     * @param car
     * @return
     */
    @Override
    public boolean park(Transport car) {
        boolean result = false;
        if (((car.getSize() == 1) && (carPlaces > 0)) || conditionCar(car)) {
            addToCarPlaces(car);
            result = true;
        } else if (conditionTruck(car)) {
            addToTruckPlaces(car);
            result = true;
        }
        return result;
    }

    /**
     * Условие добавления на стоянку для грузовых автмобилей:
     * 1) если машина грузовик car.getSize() > 1.
     * 2) если есть место на грузовой стоянке truckPlaces > 0.
     *
     * @param car
     * @return
     */
    private boolean conditionTruck(Transport car) {
        return (car.getSize() > 1) && (truckPlaces > 0);
    }

    /**
     * Условие добавления грузовиков на стоянку для легковых машин:
     * 1) есть места на стоянке для легковых машин carPlaces > 0.
     * 2) если занята стаянка для грузовых машин truckPlaces == 0.
     * 3) если грузовик, со своим размером, сможет поместиться на легковой стоянке
     * (carPlaces - car.getSize()) >= 0.
     *
     * @param car
     * @return boolean
     */
    private boolean conditionCar(Transport car) {
        return (carPlaces > 0)
                && (truckPlaces == 0)
                && ((carPlaces - car.getSize()) >= 0);
    }

    private void addToCarPlaces(Transport car) {
        this.cars[index++] = car;
        this.carPlaces -= car.getSize();
        car.setCarPlaces(true);
    }

    private void addToTruckPlaces(Transport truck) {
        this.cars[index++] = truck;
        this.truckPlaces--;
    }

    /**
     * Метод удаления транспорта с парковки.
     * 1) В первом цикле происходит заполнение массива buffer
     * автомобилями из cars.
     * 2) В условии происходит поиск ячейки по name и смещение
     * всех значений справа от удаляемого элемента на одну ячейку
     * с помощью System.arrayCopy().
     * 3) Во втором цикле происходит копирование значений массива buffer
     * обратно в cars за вычетом удаленных ячеек, остальные пустые
     * элементы cars заполняються null.
     * 4) index заявок position декрементируеться на еденицу.
     * 5) в методе increment() - увеличиваеться количесво мест
     * занимаемых автомобилем.
     *
     * @param name String
     * @return boolean
     */
    @Override
    public boolean remove(String name) {
        boolean result = false;
        Transport[] buffer = new Transport[cars.length];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = cars[i];
            if (buffer[i].getName().equals(name)) {
                increment(buffer[i]);
                System.arraycopy(cars, i + 1, buffer, i, index - i);
                result = true;
                break;
            }
        }
        this.index--;
        for (int i = 0; i < this.cars.length; i++) {
            if (i < this.index) {
                this.cars[i] = buffer[i];
            } else {
                this.cars[i] = null;
            }
        }

        return result;
    }

    /**
     * Увеличивает количество мест на стоянке занимаемых
     * автомобилем, в зависимости от того на какой
     * стоянки он находился, переменная isCarPlaces
     * указывает на какой стоянки находиться автомобиль.
     * @param car
     */
    private void increment(Transport car) {
        if (car.isCarPlaces()) {
            carPlaces += car.getSize();
        } else {
            truckPlaces++;
        }
    }
}
