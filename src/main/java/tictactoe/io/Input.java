package tictactoe.io;

import tictactoe.field.Coord;

/**
 * Методы для работы с пользователем, получения его хода.
 */
public interface Input {
    /**
     * Получаем ход от игрока.
     * Возвращает кординату по x и y на игровом поле.
     * @param question
     * @return Coord
     */
    Coord playerTurn(String question);
}
