package com.gildedrose;

import static com.gildedrose.ItemUtil.degrade;
import static com.gildedrose.ItemUtil.enhance;

class GildedRose {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);

            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
                updateNormalItemQuality(item);
            } else if(item.name.equals(AGED_BRIE)) {
                updateAgedBrieQuality(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateBackstagePassQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    public void updateNormalItemQuality(Item item) {
        degrade(item);
        if (item.sellIn < 0) degrade(item);
    }

    public void updateAgedBrieQuality(Item item) {
        enhance(item);
        if (item.sellIn < 0) enhance(item);
    }

    public void updateBackstagePassQuality(Item item) {
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
