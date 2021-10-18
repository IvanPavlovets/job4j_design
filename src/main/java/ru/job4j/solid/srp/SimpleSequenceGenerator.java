package ru.job4j.solid.srp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleSequenceGenerator implements SequenceGenerator {
    /**
     * Генерация числа происходит в другой сущбности.
     */
    private final NumberGenerator<Integer> numberGenerator;

    public SimpleSequenceGenerator(NumberGenerator<Integer> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    /**
     * Генерирует последовательность.
     * Генерация последовательности отделена от генерации числа.
     * @param size
     * @return
     */
    @Override
    public List generate(int size) {
        return IntStream.range(0, size)
                .map(i -> numberGenerator.generate()).boxed()
                .collect(Collectors.toList());
    }
}
