package ru.job4j.solid.isp.menu.io;

import ru.job4j.solid.isp.menu.behavior.Input;

import java.util.Scanner;

/**
 * Класс для работы с пользователем, реализует интерфейс Input.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * метод печатает вопрос а потом получает данные
     * из консоли введеные пользователем.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
