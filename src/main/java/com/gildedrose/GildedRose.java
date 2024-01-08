package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) continue;

            if (item.name.equals("Aged Brie")) {
                adjustQuality(item, 1);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                int adjustment;

                if (item.sellIn <= 5)
                    adjustment = 3;
                else if (item.sellIn <= 10)
                    adjustment = 2;
                else
                    adjustment = 1;

                adjustQuality(item, adjustment);
            } else {
                adjustQuality(item, -1);
            }

            item.sellIn--;

            if (item.sellIn < 0)
                if (!item.name.equals("Aged Brie"))
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        adjustQuality(item, -1);
                    } else {
                        item.quality = 0;
                    }
                else
                    adjustQuality(item, 1);
        }
    }

    private void adjustQuality(Item item, int adjustment) {
        item.quality = clamp(item.quality + adjustment, 0, 50);
    }

    private int clamp(int value, int min, int max) {
        return Math.min(max, Math.max(min, value));
    }
}
