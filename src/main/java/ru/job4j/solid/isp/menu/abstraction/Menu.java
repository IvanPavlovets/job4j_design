package ru.job4j.solid.isp.menu.abstraction;

import ru.job4j.solid.isp.menu.behavior.Action;
import ru.job4j.solid.isp.menu.behavior.Tree;

import java.util.*;

public class Menu<T> implements Tree<T> {
    private Node<T> parent = null;

    public Menu(int number, T data, Action action) {
        this.parent = new Node<T>(number, data, action);
    }

    /**
     * Добавление Node в children.
     * Каждому новому Node нужно добавить parentData родителя.
     * @param number
     * @param parentData
     * @param data
     * @param action
     * @return
     */
    @Override
    public boolean add(int number, T parentData, T data, Action action) {
        Optional<Node<T>> parentNode = findBy(parentData);
        Optional<Node<T>> childrenNode = findBy(data);
        if (parentNode.isEmpty() || childrenNode.isPresent()) {
            return false;
        }
        parentNode.get().children.add(new Node<T>(number, data, action));
        return true;
    }

    @Override
    public String toString() {
        return "Menu{"
                + "parent=" + parent
                + '}';
    }

    /**
     * Алгоритм обхода в ширину.
     * Ищет Node<T> по внутренему парметру data.
     * @param value
     * @return
     */
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(this.parent);
        while (!queue.isEmpty()) {
            Node<T> el = queue.poll();
            if (Objects.equals(el.data, value)) {
                rsl = Optional.of(el);
                break;
            }
            queue.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public T getData(T key) {
        Optional<Node<T>> node = findBy(key);
        return node.map(tNode -> tNode.data).orElse(null);
    }

    @Override
    public Action getAction(T key) {
        Optional<Node<T>> node = findBy(key);
        return node.map(kNode -> kNode.action).orElse(null);
    }

    @Override
    public String unOrdered() {
        return unOrdered(parent, 0, new StringBuilder()).toString();
    }

    private StringBuilder unOrdered(Node<T> node, int level, StringBuilder out) {
        String prefix = "-".repeat(level);
        out.append(String.format("%s%s%n", (prefix + " ").stripLeading(), node.action.someAction()));
        node.children.forEach(c -> unOrdered(c, level + 1, out));
        return out;
    }

    @Override
    public String ordered() {
        return ordered(parent, 0, "", new StringBuilder()).toString();
    }

    private StringBuilder ordered(Node<T> node, int number, String prefix, StringBuilder out) {
        String prx = String.format("%s%s", prefix, number == 0 ? "" : number + ".");
        out.append(String.format("%s%s%n", (prx + " ").stripLeading(), node.data));
        int subNumber = node.getNumber();
        for (Node<T> c : node.children) {
            ordered(c, subNumber, prx, out);
            subNumber = c.getNumber();
        }
        return out;
    }

    class Node<T> {
        private int number;
        private T data = null;
        private Action action = null;
        private List<Node<T>> children = new ArrayList<>();

        public Node(int number, T data) {
            this.number = number;
            this.data = data;
        }

        public Node(int number, T data, Action action) {
            this.number = number;
            this.data = data;
            this.action = action;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "number=" + number
                    + ", data=" + data
                    + ", children=" + children
                    + '}';
        }
    }


}
