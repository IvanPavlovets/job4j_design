package ru.job4j.solid.ocp.example1;

public class TaxGenerator {
    private int ratio;

    public Tax generateTax() {
        return new Tax(1 * ratio, 2 * ratio);
    }
    /*
    Класс не расширияем и не гибок, например если нужно будет создать другой налог,
    также наследюеться поле ratio, которое так же связывает.
     */
}
