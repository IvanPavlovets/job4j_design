package ru.job4j.solid.isp.wrong;

public interface Dog {
    void barks();
    void hunt();
    void walk();
    void sleep();

    /**
     * 2)
     * Нарушение принципа isp:
     * Не все собаки могут охотиться,
     * но у них все ровно будет
     * присутсвовать заглушка метода
     */
}
