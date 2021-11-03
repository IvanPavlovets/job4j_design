package ru.job4j.solid.dip.example3;

import java.util.List;

public class Service {

    public List<String> doSmth(FileTxt fileTxt) {
        /**
         * some logic
         */
        return List.of();
    }

    class FileTxt {
    }

    /**
     * Нарушение принципа DIP при возвращении значения метода.
     */

}
