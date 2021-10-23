package ru.job4j.solid.lsp.foodstore.food;

import java.time.LocalDateTime;

public class Apricot extends Food {

    public Apricot(LocalDateTime expiryDate, LocalDateTime createDate, double price) {
        super(expiryDate, createDate, price);
        setName("Apricot");
    }
}
