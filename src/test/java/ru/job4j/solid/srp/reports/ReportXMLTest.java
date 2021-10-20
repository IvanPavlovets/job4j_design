package ru.job4j.solid.srp.reports;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportXMLTest {

    @Test
    public void whenReportXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Петр", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report xmlRep = new ReportXML(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(dateFormat.format(worker1.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(dateFormat.format(worker1.getHired().getTime())).append("</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100.0</salary>\n")
                .append("    </employee>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(dateFormat.format(worker1.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(dateFormat.format(worker1.getHired().getTime())).append("</hired>\n")
                .append("        <name>Петр</name>\n")
                .append("        <salary>200.0</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(xmlRep.generate(em -> true), is(expect.toString()));
    }
}
