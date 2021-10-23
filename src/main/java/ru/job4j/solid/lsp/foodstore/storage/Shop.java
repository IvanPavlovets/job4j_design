package ru.job4j.solid.lsp.foodstore.storage;

import ru.job4j.solid.lsp.foodstore.Percent;
import ru.job4j.solid.lsp.foodstore.food.Food;

public class Shop extends Storage {
    /**
     * Реализация оценки по сроку годности для магазина.
     * 1. Если срок годности от 25% до 75% направить в Shop.
     * 2. Если срок годности больше 75% то выставить скидку
     * на продукт и отправить в Shop.
     * @param food
     * @return
     */
    @Override
    public boolean accept(Food food) {
        boolean rst = false;
        int percent = Percent.calcPercent(food.getCreateDate(), food.getExpiryDate());
        if (percent >= 25 && percent < 100) {
            if (percent > 75) {
                food.setDiscount(true);
                food.setPrice(food.getPrice() * 0.7);
            }
            rst = true;
        }
        return rst;
    }
}
