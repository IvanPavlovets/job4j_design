package ru.job4j.solid.ocp.example2;

public class Dog {
    void voice() {
        System.out.println("Woof woof");
    }
    /* Все классы животных можно было обьеденить одним интерефейсом с одним шаблоным методом,
     при добавлении нового животного, например при наследовании, придеться вносить изменеия в класс
     */
}