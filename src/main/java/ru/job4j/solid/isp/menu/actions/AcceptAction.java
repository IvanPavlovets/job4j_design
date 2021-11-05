package ru.job4j.solid.isp.menu.actions;

import ru.job4j.solid.isp.menu.behavior.Action;

/**
 * Класс действия пользователя по выбору блюда.
 */
public class AcceptAction implements Action {

    @Override
    public String someAction() {
        String str = "Вs заказали -";
        return str;
    }
}
