package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.iterators.CompositeIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MenuComposite extends MenuComponent {

    /**
     * хранение обьектов типа MenuComponent
      */
    private List<MenuComponent> menuComponents;
    String name;
    String description;
    Iterator iterator = null;

    public MenuComposite(String name, String description) {
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
     * @param menuComponent
     */
    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    /**
     * Удаление в узле (MenuComposite) других обьектов -
     * узлов (MenuComposite) или листьев (MenuItem).
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
        builder.append(String.format("%s%s%s%s", "\n", getName(), ", ", getDescription()));
        builder.append("\n---------------------");
        System.out.println(builder);
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.printMenu();
        }
    }

    /**
     * Передаем итератор текущей комбинации
     * @return
     */
    @Override
    public Iterator createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
