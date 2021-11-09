package ru.job4j.solid.isp.menu.behavior;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;

import java.util.function.Function;

public interface Menu {
    /**
     * Комбинационные методы для добавления, удаления, получения MenuComponent
     */
    void add(MenuComponent menuComponent);
    void remove(MenuComponent menuComponent);
    String getChildDescription(int key);
    Action getChildAction(int key);
}
