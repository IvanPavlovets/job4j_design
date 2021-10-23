package ru.job4j.solid.lsp.foodstore.food;

import java.time.LocalDateTime;

public class Peach extends Food {

    public Peach(LocalDateTime expiryDate, LocalDateTime createDate, double price) {
        super(expiryDate, createDate, price);
        setName("Peach");
    }
}
