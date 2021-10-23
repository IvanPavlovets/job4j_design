package ru.job4j.solid.lsp.foodstore.storage;

import ru.job4j.solid.lsp.foodstore.Percent;
import ru.job4j.solid.lsp.foodstore.food.Food;

public class Trash extends Storage {
    /**
     * Реализация оценки по сроку годности для утилизации.
     * Если срок годности вышел (>= 100).
     * Отправить продукт в мусорку.
     * @param food
     * @return
     */
    @Override
    public boolean accept(Food food) {
        boolean rst = false;
        int percent = Percent.calcPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent >= 100) {
            rst = true;
        }
        return rst;
    }
}
