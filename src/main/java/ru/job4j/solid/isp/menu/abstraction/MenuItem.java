package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.behavior.Action;
import ru.job4j.solid.isp.menu.iterators.NullIterator;

import javax.sql.rowset.Predicate;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Класс описывающий структуру листа (leaf) в дереве.
 * Лист конечный элемент в дереве (нет подменю).
 */
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;
    private Action action;

    public MenuItem(int key, String name, String description, boolean vegetarian, double price, Action action) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
        this.action = action;
    }

    @Override
    public int getKey() {
        return key;
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
        builder.append(String.format("%s %s", " ", getKey()));
        builder.append(String.format("%s %s", ".", getName()));
        if (isVegetarian()) {
            builder.append("(v)");
        }
        builder.append(String.format("%s %s", ", ", getPrice()));
        builder.append(String.format("%s %s", "  -- ", getDescription()));
        System.out.println(builder);
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getChildDescription(int key) {
        String rstDesc = null;
        if (key == this.getKey()) {
            rstDesc = this.getDescription();
        }
        return rstDesc;
    }

    @Override
    public Action getChildAction(int key) {
        Action rstAction = null;
        if (key == this.getKey()) {
            rstAction = this.getAction();
        }
        return rstAction;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(description, menuItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return name;
    }
}
