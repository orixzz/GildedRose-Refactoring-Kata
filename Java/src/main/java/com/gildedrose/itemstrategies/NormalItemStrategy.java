package com.gildedrose.itemstrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.degrade;

public class NormalItemStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
        degrade(item);
        if (item.sellIn < 0) degrade(item);
    }
}
