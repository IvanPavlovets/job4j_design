package ru.job4j.solid.srp.reports;

import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс доступа к бд
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
