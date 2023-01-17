package com.gildedrose.itemstrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.degrade;

public class ConjuredItemStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
        degrade(item);
        degrade(item);

        if (item.sellIn < 0) {
            degrade(item);
            degrade(item);
        }
    }
}
