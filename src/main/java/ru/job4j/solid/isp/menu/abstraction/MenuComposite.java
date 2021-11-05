package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.iterators.CompositeIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MenuComposite extends MenuComponent {

    /**
     * хранение обьектов типа MenuComponent
     */
    private List<MenuComponent> menuComponents;
    private String name;
    private String description;
    private Iterator<MenuComponent> iterator = null;

    public MenuComposite(int key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.menuComponents = new LinkedList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Добавление в узел (MenuComposite) других обьектов -
     * узлов (MenuComposite) или листьев (MenuItem).
     *
     * @param menuComponent
     */
    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    /**
     * Удаление в узле (MenuComposite) других обьектов -
     * узлов (MenuComposite) или листьев (MenuItem).
     *
     * @param menuComponent
     */
    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    /**
     * Используем итератор коллекции для перебора ее содержимого
     * у каждого вызваного элемента вызываем printMenu
     * если встретиться экземпляр MenuComposite то рекурсия
     */
    @Override
    public void printMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%s%s%s%s%s", "\n", getKey(), ". ", getName(), ", ", getDescription()));
        builder.append("\n---------------------");
        System.out.println(builder);
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.printMenu();
        }
    }

    public MenuComponent getChild(int key) {
        MenuComponent component = null;
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent.getChild(key) != null) {
                component = menuComponent.getChild(key);
            }
        }
        return component;
    }

    /**
     * Передаем итератор текущей комбинации
     */
    @Override
    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuComposite that = (MenuComposite) o;
        return Objects.equals(description, that.description);
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
