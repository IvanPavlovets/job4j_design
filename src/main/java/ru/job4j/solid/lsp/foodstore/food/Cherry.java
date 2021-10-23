package ru.job4j.solid.lsp.foodstore.food;

import java.time.LocalDateTime;

public class Cherry extends Food {

    public Cherry(LocalDateTime expiryDate, LocalDateTime createDate, double price) {
        super(expiryDate, createDate, price);
        setName("Cherry");
    }
}
