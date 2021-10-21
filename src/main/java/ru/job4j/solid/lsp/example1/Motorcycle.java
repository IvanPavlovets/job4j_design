package ru.job4j.solid.lsp.example1;

public class Motorcycle {
    public void forward(int whels) {
        if (whels > 3) {
            System.out.println("Если у вас 4 "
                    + "или больше ведуших колес"
                    + " то это автомобиль");
        }
        System.out.println("Motorcycle is going");
    }
}

/*
 В классе Quadracycle усилено предусловие. Это нарушение контракта.
 Предусловие - условия, которые проверяют корректность аргументов
 конструктора или метода.
 */
class Quadracycle extends Motorcycle {
    @Override
    public void forward(int whels) {
        if (whels < 4) {
            System.out.println("Если у вас меньше 4 "
                    + "ведуших колес то это мотоцикл");
        }
        System.out.println("Quadracycle is going");
    }
}


