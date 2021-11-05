package ru.job4j.solid.isp.menu.behavior;

/**
 * Интерфейс системы ввода/вывода трекинговой системы,
 * описывает методы для работы с пользователем.
 */
public interface Input {
    /**
     * Метод возвращает ключ для действия системы.
     * @param question
     * @return String
     */
    String ask(String question);
}
