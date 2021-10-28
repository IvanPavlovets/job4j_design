package ru.job4j.solid.isp.wrong;

public interface House {
    void setLadder();
    void setElevator();
    void setApartment();

    /**
     * 1)
     * Нарушение принципа isp может быть таким -
     * дома могут не иметь лифта и им придеться
     * оставлять у себя нереализованый метод
     * setElevator()
     */
}
