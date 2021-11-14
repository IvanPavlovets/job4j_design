package ru.job4j.solid.isp.menu.behavior;

public interface Tree<T> extends Printable {
    boolean add(int key, T parentData, T data, Action action);
    String getData(T key);
    Action getAction(T key);

}
