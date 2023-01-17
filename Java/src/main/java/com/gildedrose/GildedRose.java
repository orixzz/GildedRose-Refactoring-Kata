package com.gildedrose;

import com.gildedrose.itemstrategies.AgedBrieStrategy;
import com.gildedrose.itemstrategies.BackstagePassStrategy;
import com.gildedrose.itemstrategies.ItemStrategy;
import com.gildedrose.itemstrategies.NormalItemStrategy;
import com.gildedrose.itemstrategies.SulfurasStrategy;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String DEFAULT = "default";

    Item[] items;
    Map<String, ItemStrategy> itemStrategies;
    ItemStrategy defaultStrategy;


    public GildedRose(Item[] items) {
        this.items = items;

        this.defaultStrategy = new NormalItemStrategy();
        this.itemStrategies = new HashMap<>();
        this.itemStrategies.put(DEFAULT, new NormalItemStrategy());
        this.itemStrategies.put(SULFURAS, item -> new SulfurasStrategy());
        this.itemStrategies.put(AGED_BRIE, new AgedBrieStrategy());
        this.itemStrategies.put(BACKSTAGE_PASSES, new BackstagePassStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemStrategy strategy =itemStrategies.getOrDefault(item.name, defaultStrategy);
            strategy.updateQuality(item);
        }
    }
}
