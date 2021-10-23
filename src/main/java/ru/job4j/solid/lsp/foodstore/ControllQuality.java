package ru.job4j.solid.lsp.foodstore;

import ru.job4j.solid.lsp.foodstore.food.Food;
import ru.job4j.solid.lsp.foodstore.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    /**
     * Распределение продукта в хранилище
     * с учетом оценки в методе accept().
     * @param food
     */
    public void distribute(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
                break;
            }
        }
    }

    /**
     * Распределние продуктов по хранилищам
     * @param foods
     */
    public void distribute(List<Food> foods) {
        for (Food food : foods) {
            distribute(food);
        }
    }

    /**
     * Перераспределяет продукты заново.
     * Из каждого хранилища все продукты
     * чкладываються в foods. Затем каждое
     * хранилище освобождаеться, в конце
     * распределеине происходит заново с
     * использованием foods.
     */
    public void redistribute() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            foods.addAll(storage.getFoods());
            storage.remove();
        }
        distribute(foods);
    }
}
