package ru.job4j.solid.lsp.foodstore.food;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Food {
    String name;
    LocalDateTime expiryDate;
    LocalDateTime createDate;
    double price;
    boolean discount;

    public Food(LocalDateTime createDate, LocalDateTime expiryDate, double price) {
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate);
    }
}
