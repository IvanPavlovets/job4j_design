package ru.job4j.solid.lsp.foodstore.storage;

import ru.job4j.solid.lsp.foodstore.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage implements StorageBehavior {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public void remove() {
        foods.clear();
    }

    public List<Food> getFoods() {
        return foods;
    }
}


