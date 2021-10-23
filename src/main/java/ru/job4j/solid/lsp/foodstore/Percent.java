package ru.job4j.solid.lsp.foodstore;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * рассчитывает срок годности продукта в процентах, в виде int.
 */
public class Percent {
    public static int calcPercent(LocalDateTime createDate, LocalDateTime expiryDate) {
        LocalDateTime now = LocalDateTime.now();
        if (createDate.isBefore(expiryDate)) {
            float storedDays = Duration.between(createDate, expiryDate).toDays();
            float remainingDays = Duration.between(createDate, now).toDays();
            int percent = (int) (remainingDays / storedDays * 100);
            return percent;
        } else {
            throw new IllegalArgumentException("EXP date can't be earlier than PRO date!");
        }
    }
}
