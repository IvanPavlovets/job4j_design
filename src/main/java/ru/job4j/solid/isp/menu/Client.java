package ru.job4j.solid.isp.menu;

import ru.job4j.solid.isp.menu.io.ConsoleInput;

/**
 * Структура меню пострена по типу дерева,
 * с добавлением методов распечатки.
 *
 */
public class Client {
    public static void main(String[] args) {
        MenuPrinter printer = new MenuPrinter();
        printer.init();

        String key = new ConsoleInput().ask("Выберите ключ заказа: ");
        printer.dialog(key);


    }
}
