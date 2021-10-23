package ru.job4j.solid.lsp.foodstore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.solid.lsp.foodstore.food.*;
import ru.job4j.solid.lsp.foodstore.storage.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ControllQualityTest {
    private ControllQuality controlQuality;
    Storage warehouse;
    Storage shop;
    Storage trash;

    /**
     * Инициализирует экземпляры хранилищь
     * и фруктов перед выполнением тестов.
     * Apricot - направиться на склад.
     * Milk - направиться в магазин.
     * Peach - направиться в мусор.
     * Cherry - получит скидку и направиться в магазин.
     */
    @Before
    public void init() {
        Food milk = new Milk(LocalDateTime.now().minusDays(3),
                LocalDateTime.now().plusDays(7), 83);
        Food peach = new Peach(LocalDateTime.now().minusDays(40),
                LocalDateTime.now(), 350);
        Food apricot = new Apricot(LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(25), 450);
        Food cherry = new Cherry(LocalDateTime.now().minusDays(16),
                LocalDateTime.now().plusDays(4), 400);
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        List<Storage> storageList = List.of(warehouse, shop, trash);
        ControllQuality controlQuality = new ControllQuality(storageList);
        List<Food> foodList = List.of(milk, peach, apricot, cherry);
        controlQuality.distribute(foodList);
    }

    @Test
    public void whenAddToWarehouseThenGetApricot() {
        assertEquals("Apricot", warehouse.getFoods().get(0).getName());
    }

    @Test
    public void whenAddToShop() {
        assertEquals("Milk", shop.getFoods().get(0).getName());
    }

    /**
     * В тесте проверяеться наличие скидки у 2 продукта из shop.
     */
    @Test
    public void whenAddCherryToShopWithDiscount() {
        Food cherryFromShop = shop.getFoods().stream().filter(
                f -> f.getName().equals("Cherry"))
                .collect(Collectors.toList())
                .get(0);
        assertEquals(true, cherryFromShop.getDiscount());
    }

    @Test
    public void whenPeachAddToTrash() {
        assertEquals("Peach", trash.getFoods().get(0).getName());
    }
}
