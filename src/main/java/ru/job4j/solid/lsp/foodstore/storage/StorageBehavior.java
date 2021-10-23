package ru.job4j.solid.lsp.foodstore.storage;

import ru.job4j.solid.lsp.foodstore.food.Food;

public interface StorageBehavior {
    /**
     * добавить продукт в хранилище.
     * @param food
     */
    void add(Food food);

    /**
     * проверка срока годности продукта,
     * в зависимости от оценки каждый продукт
     * попадет в свое хранилище.
     * @param food
     * @return boolean
     */
    boolean accept(Food food);
    void remove();
}
