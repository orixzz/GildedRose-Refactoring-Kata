package com.gildedrose.itemstrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.enhance;

public class AgedBrieStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
        enhance(item);
        if (item.sellIn < 0) enhance(item);
    }
}
