package ru.job4j.solid.srp.example3;

import java.util.Date;
import java.util.Map;

public interface ShoppingBasket {
    Map<String, Product> purchase();
    Map<Date, Order> getOrders();
    /* нарушения принципов SRP:
    1. Больше чем одна цель в сущности.
    2. В методе getOrders() формируються новые обьеты,
    генерируется время заказа и сам заказ, данный функционал можно
    упаковать в отдельный интерфейс
    */
}
