package ru.job4j.solid.isp.menu;

import ru.job4j.solid.isp.menu.abstraction.Menu;

import ru.job4j.solid.isp.menu.actions.AcceptAction;
import ru.job4j.solid.isp.menu.behavior.Action;

public class MenuPrinter {

    private Menu<String> root;

    public void init() {
        Action action = new AcceptAction();
        root = new Menu<>(1, "ВСЕ МЕНЮ", action);
        root.add(1, "ВСЕ МЕНЮ", "PANCAKE HOUSE MENU", action);
        root.add(2, "PANCAKE HOUSE MENU", "Оладьи с яичнецой и тостами", action);
        root.add(3, "PANCAKE HOUSE MENU", "Оладьи с яичнецой и колбасой", action);
        root.add(4, "PANCAKE HOUSE MENU", "Оладьи со свежей черникой и черничным сиропом", action);
        root.add(5, "PANCAKE HOUSE MENU", "Вафли с черникой или клубникой", action);
        System.out.println(root.ordered());
    }

    /**
     * метод диалога с пользователем.
     * Необходимо вести строку выбраного блюда.
     *
     * @param key String
     */
    public void dialog(String key) {
        String arg1 = root.getAction(key).someAction();
        String arg2 = root.getData(key);
        System.out.println(String.format("%s %s", arg1, arg2));
    }

}
