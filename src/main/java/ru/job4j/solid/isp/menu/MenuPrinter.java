package ru.job4j.solid.isp.menu;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;
import ru.job4j.solid.isp.menu.abstraction.MenuComposite;
import ru.job4j.solid.isp.menu.abstraction.MenuItem;
import ru.job4j.solid.isp.menu.actions.AcceptAction;
import ru.job4j.solid.isp.menu.behavior.Action;
import ru.job4j.solid.isp.menu.behavior.Printable;

import java.util.Iterator;

public class MenuPrinter implements Printable {

    private MenuComponent allMenus;

    public MenuPrinter() {
        this.allMenus = new MenuComposite(1, "ВСЕ МЕНЮ", "все группированые меню");
        this.init();
    }

    /**
     * создаем листы и узлы и добавляем все в виде древовидной структуры в allMenus
     */
    private void init() {
        Action action = new AcceptAction();
        MenuComponent pancakeHouseMenu =
                new MenuComposite(2, "PANCAKE HOUSE MENU", "Завтрак");
        MenuComponent dinerMenu =
                new MenuComposite(3, "DINER MENU", "Обед");
        MenuComponent cafeMenu =
                new MenuComposite(4, "CAFE MENU", "Полдник");
        MenuComponent desertMenu = new MenuComposite(5, "DESERT MENU", "десерт");

        pancakeHouseMenu.add(new MenuItem(6, "Завтрак K&B", "Оладьи с яичнецой и тостами",
                true, 2.99, action));
        pancakeHouseMenu.add(new MenuItem(7, "Основной завтрак", "Оладьи с яичнецой и колбасой",
                false, 2.99, action));
        pancakeHouseMenu.add(new MenuItem(8, "Оладьи с черникой", "Оладьи со свежей черникой и черничным сиропом",
                true, 3.49, action));
        pancakeHouseMenu.add(new MenuItem(9, "Вафли", "Вафли с черникой или клубникой",
                true, 3.59, action));

        dinerMenu.add(new MenuItem(10, "Вегетарианский сендвич с беконом", "Соевый бекон с салатом и помидорами на хлебе",
                true, 2.99, action));
        dinerMenu.add(new MenuItem(11, "Сендвич с беконом", "Бекон с салатом и помидорами на хлебе",
                false, 2.99, action));
        dinerMenu.add(new MenuItem(12, "Суп дня", "Тарелка супа",
                false, 3.29, action));
        dinerMenu.add(new MenuItem(13, "Хот-дог", "Хот-дог с кислой капустой, луком, приправой и сыром",
                false, 3.05, action));
        dinerMenu.add(new MenuItem(14, "Паста", "Спагетти маринара с кусочком хлеба из опары",
                true, 3.89, action));

        cafeMenu.add(new MenuItem(15, "Вегетарианский бургер и картошка фри", "Вегетарианский бургер на булочки хлеба, листья салата, помидоры и картошка",
                true, 3.99, action));
        cafeMenu.add(new MenuItem(16, "Супчик дня", "Кружка супа и салат",
                false, 3.69, action));
        cafeMenu.add(new MenuItem(17, "Burrito", "Большой буррито с фасолью пинто, соус сальса и гуакамоле",
                true, 4.29, action));

        desertMenu.add(new MenuItem(18, "Яблочный пирог", "Яблочный пирог с хрустящим тестом",
                true, 1.59, action));
        desertMenu.add(new MenuItem(19, "Мороженое", "Пломбир посыпаный шоколадной крошкой",
                true, 1.59, action));

        dinerMenu.add(desertMenu);

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

    }

    @Override
    public void printMenu() {
        this.allMenus.printMenu();
    }

    public void printVegetarian() {
        Iterator iterator = allMenus.createIterator();
        System.out.println(String.format("%s%s%s%s", "\n", "VEGETARIAN MENU", "\n", "----"));
        while (iterator.hasNext()) {
            MenuComponent menuComponent =
                    (MenuComponent) iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.printMenu();
                }
            } catch (UnsupportedOperationException e) {
            }
        }
    }

    /**
     * метод диалога с пользователем.
     * Необходимо вести id/ключ выбраного блюда.
     * @param key int
     */
    public void dialog(int key) {
        String arg1 = this.allMenus.getChildAction(key).someAction();
        String arg2 = this.allMenus.getChildDescription(key);
        System.out.println(String.format("%s %s", arg1, arg2));
    }

}
