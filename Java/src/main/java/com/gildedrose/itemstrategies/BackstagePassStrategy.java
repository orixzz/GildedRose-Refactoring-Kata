package com.gildedrose.itemstrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.enhance;

public class BackstagePassStrategy implements ItemStrategy{
    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            enhance(item);
            if (item.sellIn <= 10) {
                enhance(item);
            }
            if (item.sellIn <= 5) {
                enhance(item);
            }
        }
    }
}
