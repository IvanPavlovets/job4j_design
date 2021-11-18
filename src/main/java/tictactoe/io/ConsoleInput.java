package tictactoe.io;

import tictactoe.field.Coord;

import java.util.Scanner;

public class ConsoleInput implements Input {
    /**
     * Класс Scanner принимает поток ввода (System.in) с консоли,
     * с помощью метода получения полной строки nextLine.
     */
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Coord playerTurn(String question) {
        /**
         * здесь пишеться логика по приему строки из консоли от пользователя
         * и преобразования в коррдинаты, поставлеой фигуры пользователем.
         */
        return new Coord();
    }
}
