package ru.job4j.solid.isp.menu.iterators;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;
import ru.job4j.solid.isp.menu.abstraction.MenuComposite;

import java.util.Iterator;

public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComposite next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
