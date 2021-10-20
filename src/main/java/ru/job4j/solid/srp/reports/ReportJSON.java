package ru.job4j.solid.srp.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private static final Gson JSON = new GsonBuilder().create();

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return JSON.toJson(store.findBy(filter));
    }
}
