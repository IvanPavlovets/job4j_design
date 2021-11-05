package ru.job4j.solid.isp.menu.behavior;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;

import java.util.Iterator;

public interface MyIterator {
    Iterator<MenuComponent> createIterator();
}
