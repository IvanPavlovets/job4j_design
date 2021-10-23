package ru.job4j.solid.lsp.foodstore.storage;

import ru.job4j.solid.lsp.foodstore.Percent;
import ru.job4j.solid.lsp.foodstore.food.Food;

public class Warehouse extends Storage {
    /**
     * Реализация оценки по сроку годности для склада.
     * Если срок годности израсходован меньше чем на 25%
     * направить в Warehouse.
     * @param food
     * @return
     */
    @Override
    public boolean accept(Food food) {
        boolean rst = false;
        int percent = Percent.calcPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent < 25) {
            rst = true;
        }
        return rst;
    }
}
