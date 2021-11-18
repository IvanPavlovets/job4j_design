package tictactoe.io;

import tictactoe.field.Coord;

/**
 * Класс выполняет проверку ввода данных пользователем.
 * По анлогии с trackingsustem.
 * Класс ValidateInput комбинируеться с ConsoleInput по шаблону Декоратор,
 * аналогично системе io Java.
 */
public class ValidateInput implements Input {

    @Override
    public Coord playerTurn(String question) {
        Coord coord = new Coord();
        /**
         * здесь выполняеться логика проверки адекатности хода игрока.
         * Что бы не походил на не занятую клетку и т.д.
         */
        return coord;
    }
}
