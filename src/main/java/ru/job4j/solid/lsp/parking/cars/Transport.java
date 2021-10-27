package ru.job4j.solid.lsp.parking.cars;

/**
 * Абстрактный класс Транспортного средства, имитирует элемент
 * который будет добавляться в реализацию VehicleStorage.
 * Поля name и size - необходимы для индефиации элементов хранилища.
 * В зависимости от значения size, транспортное средсво может быть
 * легковой маиной - Car или грузовиком Truck.
 */
public abstract class Transport {
    /**
     * Поле name необходимо для индефикации транспорта в хранилище.
     */
    protected String name;

    /**
     * Легковой считается машина у которой размер равен 1,
     * а грузовой у которой размер > 1.
     */
    protected int size;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
