package ru.job4j.solid.srp.reports;

import com.google.gson.GsonBuilder;
import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportJSONTest {
    @Test
    public void whenReportJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Петр", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report jsonRep = new ReportJSON(store);
        StringBuilder expect = new StringBuilder();
        var gson = new GsonBuilder().create();
        expect.append("[")
                .append(gson.toJson(worker1))
                .append(",")
                .append(gson.toJson(worker2))
                .append("]");
        assertThat(jsonRep.generate(em -> true), is(expect.toString()));
    }
}
