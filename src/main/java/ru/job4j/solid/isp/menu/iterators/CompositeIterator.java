package ru.job4j.solid.isp.menu.iterators;

import ru.job4j.solid.isp.menu.abstraction.MenuComponent;
import ru.job4j.solid.isp.menu.abstraction.MenuComposite;

import java.util.*;

/**
 * Внешний итератор сохраняет текущую позицию перебора
 * в комбинационой рекурсивной структуре, поэтому для
 * отслеживания текущей позиции вверх-вниз по комбинационой
 * иерархии используються Stack.
 */
public class CompositeIterator implements Iterator {

    /**
     * коллекция для хранения итераторов элементов MenuComposite
      */
    Deque stack = new LinkedList();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    /**
     * если стек не пуст читаем из стека верхний итератор
     * и проверяем есть ли в стеке следующий элемнт
     * @return
     */
    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    /**
     * Проверяет существует ли следующий элемнент
     * если относиться к классу MenuComponent (комбинация)
     * то вызываем итератор его коллекции
     * @return
     */
    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof MenuComposite) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
