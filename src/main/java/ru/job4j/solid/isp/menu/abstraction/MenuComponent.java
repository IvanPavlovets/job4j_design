package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.behavior.Menu;
import ru.job4j.solid.isp.menu.behavior.MyIterator;
import ru.job4j.solid.isp.menu.behavior.Printable;

import java.util.Iterator;

public abstract class MenuComponent implements Menu, Printable, MyIterator {

    /**
     * Методы для узлов дерева - экземпляры MenuComposite
     */
    @Override
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * Методы для листьев - экземпляры MenuItem
     */
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

}
