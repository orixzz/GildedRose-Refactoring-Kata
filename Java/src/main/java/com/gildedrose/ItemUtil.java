package com.gildedrose;

import static com.gildedrose.GildedRose.SULFURAS;

public class ItemUtil {

    protected static boolean isQualityMoreThanZero(int quality) {
        return quality > 0;
    }

    protected static boolean isQualityLessThanFifty(int quality) {
        return quality < 50;
    }

    protected static void enhance(Item item) {
        if (isQualityLessThanFifty(item.quality)) {
            item.quality++;
        }
    }

    protected static void degrade(Item item) {
        if (isQualityMoreThanZero(item.quality)) {
            if (!item.name.equals(SULFURAS)) {
                item.quality--;
            }
        }
    }
}
