package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) continue;

            int adjustment = 0;

            if (item.name.equals("Aged Brie")) {
                adjustment = item.sellIn <= 0 ? 2 : 1;
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn <= 0)
                    adjustment = -item.quality;
                else if (item.sellIn <= 5)
                    adjustment = 3;
                else if (item.sellIn <= 10)
                    adjustment = 2;
                else
                    adjustment = 1;
            } else {
                adjustment = item.sellIn <= 0 ? -2 : -1;
            }

            item.quality = clamp(item.quality + adjustment, 0, 50);
            item.sellIn--;
        }
    }

    private int clamp(int value, int min, int max) {
        return Math.min(max, Math.max(min, value));
    }
}
