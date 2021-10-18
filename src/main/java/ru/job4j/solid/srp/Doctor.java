package ru.job4j.solid.srp;

import java.util.List;

public interface Doctor {
    String giveReceipt();
    String defineTreatment();
    void collectComplaints(List<Complaint> complaints);
    /*
    1. В данном интерфейсе больше чем одна цель.
     В методах генерируються обьекты, однако там
     не присутсвует сложной логики, поэтому нарущения
     связывания и зависимостей в методах нет.
     */

}
