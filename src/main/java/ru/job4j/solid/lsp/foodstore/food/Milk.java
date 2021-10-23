package ru.job4j.solid.lsp.foodstore.food;

import java.time.LocalDateTime;

public class Milk extends Food {

    public Milk(LocalDateTime expiryDate, LocalDateTime createDate, double price) {
        super(expiryDate, createDate, price);
        setName("Milk");
    }
}
