package ru.job4j.solid.isp.menu.behavior;

public interface Tree<T> extends Printable {
    boolean add(int number, T parentData, T data, Action action);
    T getData(T key);
    Action getAction(T key);

}
