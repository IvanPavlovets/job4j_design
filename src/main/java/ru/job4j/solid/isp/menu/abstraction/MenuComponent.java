package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.behavior.Action;
import ru.job4j.solid.isp.menu.behavior.Menu;
import ru.job4j.solid.isp.menu.behavior.MyIterator;
import ru.job4j.solid.isp.menu.behavior.Printable;

import java.util.Iterator;


public abstract class MenuComponent implements Menu, Printable, MyIterator {

    protected int key;

    /**
     * Методы для узлов дерева - экземпляры MenuComposite
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public String getChildDescription(int key) {
        throw new UnsupportedOperationException();
    }

    public Action getChildAction(int key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Методы для листьев - экземпляры MenuItem
     */
    public int getKey() {
        return key;
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    /**
     * Геттер поля интерфейса Action, включеного как композииция.
     */
    public Action getAction() {
        throw new UnsupportedOperationException();
    }

    /**
     * методы интерфейсов Printable, MyIterator
     */
    public Iterator<MenuComponent> createIterator() {
        throw new UnsupportedOperationException();
    }

    public void printMenu() {
        throw new UnsupportedOperationException();
    }
}