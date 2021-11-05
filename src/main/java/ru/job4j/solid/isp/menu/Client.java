package ru.job4j.solid.isp.menu;


import ru.job4j.solid.isp.menu.io.ConsoleInput;

/**
 * 1) Шаблон проектирования компоновщик:
 * Позволяет создовать древовидные структуры узлами которых являються как
 * комбинации, так и отдельные обьекты.
 * 2) Нарушение принципа одной обязоности ради "прозрачности" для клиента:
 * В абстрактный класс MenuComponent включено поведение
 * как дочерними узлами MenuComposite так и листьями MenuItem
 * это компромисное решение ради "прозрачности" архитектуры для клиента.
 */
public class Client {
    public static void main(String[] args) {
        MenuPrinter printer = new MenuPrinter();
        printer.printMenu();

        int key = Integer.valueOf(new ConsoleInput().ask("Выберите ключ заказа: "));
        printer.dialog(key);
    }
}
