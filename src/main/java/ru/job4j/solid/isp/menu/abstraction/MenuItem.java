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
        System.out.print("  " + getName());
        if (isVegetarian()) { // признак вегетарианского блюда
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
