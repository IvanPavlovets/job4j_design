package ru.job4j.solid.dip.example1;

public class BadPizzaStore {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("Сырная".equals(type)) {
            pizza = new CheesePizza();
        } else if ("Рыбная".equals(type)) {
            pizza = new FishPizza();
        } else if ("Греческая".equals(type)) {
            pizza = new GreekPizza();
        }
        return pizza;
    }
}
/**
 * Пример нарушения принципа DIP из сери книг HeadFirs.
 * Здесь класс BadPizzaStore зависит от субкласов,
 * из за создания их экземпляров.
 * Любые изменения в субкласах пиц затронут и BadPizzaStore.
 * Правильным решением может быть - выделение асбстракции класса Pizza и
 * инкапсуляции создания всех экземпляров в фабрику по созданию обьектов.
 */
