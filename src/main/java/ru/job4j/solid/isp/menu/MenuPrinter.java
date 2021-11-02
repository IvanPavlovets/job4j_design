package ru.job4j.solid.isp.menu;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;
import ru.job4j.solid.isp.menu.abstraction.MenuComposite;
import ru.job4j.solid.isp.menu.abstraction.MenuItem;
import ru.job4j.solid.isp.menu.behavior.Printable;

import java.util.Iterator;

public class MenuPrinter implements Printable {

    private MenuComponent allMenus;

    public MenuPrinter() {
        this.allMenus = new MenuComposite("ВСЕ МЕНЮ", "все группированые меню");
        this.init();
    }

    /**
     * создаем листы и узлы и добавляем все в виде древовидной структуры в allMenus
     */
    private void init() {
        MenuComponent pancakeHouseMenu =
                new MenuComposite("PANCAKE HOUSE MENU", "Завтрак");
        MenuComponent dinerMenu =
                new MenuComposite("DINER MENU", "Обед");
        MenuComponent cafeMenu =
                new MenuComposite("CAFE MENU", "Полдник");
        MenuComponent desertMenu = new MenuComposite("DESERT MENU", "десерт");

        pancakeHouseMenu.add(new MenuItem("Завтрак K&B", "Оладьи с яичнецой и тостами",
                true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Основной завтрак", "Оладьи с яичнецой и колбасой",
                false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Оладьи с черникой", "Оладьи со свежей черникой и черничным сиропом",
                true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Вафли", "Вафли с черникой или клубникой",
                true, 3.59));

        dinerMenu.add(new MenuItem("Вегетарианский сендвич с беконом", "Соевый бекон с салатом и помидорами на хлебе",
                true, 2.99));
        dinerMenu.add(new MenuItem("Сендвич с беконом", "Бекон с салатом и помидорами на хлебе",
                false, 2.99));
        dinerMenu.add(new MenuItem("Суп дня", "Тарелка супа",
                false, 3.29));
        dinerMenu.add(new MenuItem("Хот-дог", "Хот-дог с кислой капустой, луком, приправой и сыром",
                false, 3.05));
        dinerMenu.add(new MenuItem("Паста", "Спагетти маринара с кусочком хлеба из опары",
                true, 3.89));

        cafeMenu.add(new MenuItem("Вегетарианский бургер и картошка фри", "Вегетарианский бургер на булочки хлеба, листья салата, помидоры и картошка",
                true, 3.99));
        cafeMenu.add(new MenuItem("Супчик дня", "Кружка супа и салат",
                false, 3.69));
        cafeMenu.add(new MenuItem("Burrito", "Большой буррито с фасолью пинто, соус сальса и гуакамоле",
                true, 4.29));

        desertMenu.add(new MenuItem("Яблочный пирог", "Яблочный пирог с хрустящим тестом",
                true, 1.59));
        desertMenu.add(new MenuItem("Мороженое", "Пломбир посыпаный шоколадной крошкой",
                true, 1.59));


        dinerMenu.add(desertMenu);

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

    }

    @Override
    public void printMenu() {
        allMenus.printMenu();
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

}
