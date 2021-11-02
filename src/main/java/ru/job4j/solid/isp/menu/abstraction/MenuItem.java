package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.iterators.NullIterator;

import java.util.Iterator;

/**
 * Класс описывающий структуру листа (leaf) в дереве.
 * Лист конечный элемент в дереве (нет подменю).
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Выводит полное описание элемента меню(MenuItem)
     */
    @Override
    public void printMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s", "  ", getName()));
        if (isVegetarian()) {
            builder.append("(v)");
        }
        builder.append(String.format("%s %s", ", ", getPrice()));
        builder.append(String.format("%s %s", "  -- ", getDescription()));
        System.out.println(builder);
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
