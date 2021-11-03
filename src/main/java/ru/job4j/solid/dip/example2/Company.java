package ru.job4j.solid.dip.example2;

import java.util.List;
import java.util.Map;

public class Company {

    private Map<String, List<Employee>> allEmployees;

    public Company(Departament depart) {
        this.allEmployees.put(
                depart.name, depart.departEmployees);
    }

    class Departament {
        String name;
        List<Employee> departEmployees;

        public Departament(List<Employee> departEmployees) {
            this.departEmployees = departEmployees;
        }
    }

    class Employee {
    }

    /**
     * 1. Поля класса хранения зависит от реализации.
     * 2. Сам класс Company зависит от класса Departament
     */
}


